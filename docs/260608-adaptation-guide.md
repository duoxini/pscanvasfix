# PsCanvas 260608 适配复盘与后续适配指南

本文记录 `com.oplus.pscanvas` 260608 版本恢复 502 三分屏逻辑的最终结论。后续系统更新后，先按本文定位，不要从手势阈值或界面截图重新猜测。

## 1. 已验证基线

| 项目 | 值 |
| --- | --- |
| 目标包名 | `com.oplus.pscanvas` |
| 系统 APK | `/system_ext/app/OplusFlexibleWindowUI/OplusFlexibleWindowUI.apk` |
| 适配档案 | `260608` |
| versionCode / versionName | `20` / `2.0.0` |
| APK SHA-256 | `1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3` |
| 参考行为 | 502 版本 |
| 被替换行为 | 700 版本逻辑 |

不能只用 `versionName 2.0.0` 判断兼容性。厂商更新后版本名可能不变，而混淆类名和方法名已经变化。模块必须以完整 APK SHA-256 命中兼容档案后才安装 Hook；未命中时输出 `unsupported profile` 并保留系统原生行为。

## 2. 最终验收行为

### 三分屏正常状态

- 第一次打开已保存的三分屏即进入 502 式横向宽画布。
- 每个窗口保持相同的竖向比例，前两个窗口完整显示，第三个窗口在屏幕右侧露出一部分。
- 不出现上下黑边，也不允许第一个窗口单独出现左右黑边。

### 三分屏全景状态

- 四指或五指向内捏合：进入全景模式，三个窗口全部完整显示在屏幕内。
- 在全景模式单击任意窗口：保持全景，不放大、不退出。
- 四指或五指向外张开：退出全景，回到正常三分屏。
- 左上角退出按钮：仍可退出全景。
- 手势不得再落入 700 的“三个浮窗”转换路径。

### 二分屏

二分屏继续使用系统原生计算与交互。本次实机测试覆盖了二分屏和三分屏，日志中未见崩溃、ANR 或 Hook 安装失败。

## 3. 502、700 与 260608 的关键差异

260608 不是简单把 700 的类名换掉。700 在三应用布局中新增了 `isThreeSplitTogether`，同时改变了缩放手势的目标状态；260608 又对相关类进行了重新混淆。

| 环节 | 502 逻辑 | 700 / 260608 原生逻辑 | 本模块处理 |
| --- | --- | --- | --- |
| 三任务批量边界 | 不携带 `isThreeSplitTogether` | `B1.l.o0(...)` 为三任务请求加入该标记 | 在 `B1.l.n(List,int,Bundle)` 调用前移除标记，并同步返回的真实任务边界 |
| 单任务边界 | 不携带该标记 | `B1.l.n0(...)` 给首个任务 Intent 加入该标记 | 在 `B1.l.o(Intent,int,int)` 调用前移除 Intent 标记 |
| 外层画布边界 | 三个等宽竖列组成横向宽画布 | 三列按 700 Together 规则排布 | 改写 `B1.l.M1(List,int,float)` 的三项结果 |
| 捏合方向 | 捏合进入全景 | 可能被解释成三个浮窗 | 直接调用全景管理器 `z(true)` 并截断原逻辑 |
| 张开方向 | 张开退出全景 | 状态和旧逻辑混用 | 仅在全景激活时调用 `A(true)` |
| 全景单击 | 保持全景 | `CanvasGestureManager.T(...)` 调用 `A(true)` 退出 | 只阻断来自该单击调用链的 `A(true)` |
| 三分屏触摸管理器 | 502 全景交互 | 700 的拖动、动画与 Together 逻辑 | 按 260608 类映射阻断不兼容路径 |

注意：上表中的 `o0`、`n0` 是反编译后看到的上层路径，实际需要 Hook 的底层方法分别是 `B1.l.n(...)` 和 `B1.l.o(...)`。后续版本必须重新确认签名，不能只按短方法名照搬。

## 4. 布局问题的真正根因

三分屏画面有两套边界，必须同时正确：

1. 系统为真实任务分配的 LaunchBounds。
2. PsCanvas 外层画布用于摆放任务卡片的 Rect。

在 3392×2400 的测试设备上，502 目标列尺寸为 1600×2400，列间距约 26 像素。通用计算为：

```text
列宽 = round(列高 × 2 / 3)
列间距 = round(10dp × density)
```

`B1.l.M1(...)` 最终返回三列：

```text
[0, 0, 1600, 2400]
[1626, 0, 3226, 2400]
[3252, 0, 4852, 2400]
```

不同失败画面可以直接反推遗漏项：

| 现象 | 原因 |
| --- | --- |
| 三个等宽窗口一次全部显示 | 700 的 Together 路径仍在生效 |
| 外层列已变宽，但窗口左右有黑边 | 只改了 `M1`，真实任务仍按约 1113 像素宽创建 |
| 窗口上下有黑边 | 真实任务按更宽边界创建，但外层列只有 1600 像素宽，比例不一致 |
| 只有第一个窗口左右有黑边 | 批量 Bundle 标记已移除，但单任务 Intent 标记仍在 |

最终修复必须同时完成四件事：

1. Hook `B1.l.n(List,int,Bundle)`，三任务且 layout 为 3 时移除 Bundle 中的 `isThreeSplitTogether`。
2. 在该方法返回后，把三个任务的 `androidx.flexible.LaunchBounds` 与 `androidx.flexible.LaunchHorizontalBounds` 同步为 `高度 × 2/3` 的列宽。
3. Hook `B1.l.o(Intent,int,int)`，移除单任务 Intent 中的 `isThreeSplitTogether`。
4. Hook `B1.l.M1(List,int,float)`，同步生成相同比例的外层三列 Rect。

不能通过把 layout 3 硬改成其他 layout 值来复刻 502。502 可以继续保持 layout 3；区别在请求标记、真实任务边界和外层画布边界。

## 5. 全景手势与单击的最终调用链

260608 的已验证入口为 `x1.x.t0(ScaleGestureDetector,int)`。处理前必须确认：

- 当前画布确实有三个应用；
- 指针数不少于 4；
- 全景管理器可从 `ContainerView.getPanoramaModeManager()` 获取。

方向语义如下：

```text
scaleFactor < 1：向内捏合；未激活时调用 B0.z(true) 进入全景
scaleFactor > 1：向外张开；已激活时调用 B0.A(true) 退出全景
B0.M()：读取全景激活状态
```

`z(true)` 是进入，`A(true)` 是退出。早期把 `A(true)` 当作入口，会回到正常分屏或触发三个浮窗，看起来像“手势无效”。处理四指、五指缩放后必须截断 700 原逻辑，防止它继续把同一次手势解释为浮窗转换。

全景单击退出来自 `CanvasGestureManager.T(MotionEvent)`：该方法在全景激活时调用 `B0.A(true)`。最终实现只在调用栈来自 `canvas.y.T` 或 `canvas.C0332y.T` 时阻断 `A(true)`；方向张开退出通过 ThreadLocal 放行，左上角按钮不经过该调用栈，因此也能正常退出。

## 6. 260608 已确认的混淆映射

| 职责 | 旧参考映射 | 260608 映射 |
| --- | --- | --- |
| SStoFlexible | `x1.r` | `x1.x` |
| ThreeSplitAnim | `x1.x` | `x1.D` |
| ThreeSplitDrag | `x1.y` | `x1.E` |
| CanvasController | `com.oplus.pscanvas.canvasmode.canvas.r0` | `com.oplus.pscanvas.canvasmode.canvas.s0` |
| 三分屏分隔栏五参数处理器 | `E.u0(...)` | `E.v0(...)` |

260608 的 SStoFlexible 已验证方法：

| 用途 | 方法 |
| --- | --- |
| 缩放处理 | `t0(ScaleGestureDetector,int)` |
| Intent 列表 | `I()` |
| 启动边界 | `H(List,int[])` |
| 遮罩动画 | `Z(...)` |

这些映射保存在 `PsCanvasCompatibilityProfile` 中并由单元测试锁定。新版本必须新建档案，不要直接修改 260608 档案来兼容多个 APK。

## 7. 本次走过的弯路

- 只看界面外层 Rect，没有检查 system_server 实际创建的任务边界，导致黑边反复变化。
- 只清理批量 Bundle，遗漏首个任务的单 Intent 路径，结果仅第一个窗口仍有左右黑边。
- 只 Hook 上层包装方法，没有确认首次打开已保存三分屏实际经过 `M1`。
- 误以为 502 必须把 layout 3 改成 layout 4；实机证明布局编号不是目标行为本身。
- 混淆类名沿用旧版，导致 Hook 表面安装但没有命中 260608 的真实处理类。
- 把 `A(true)` 当作全景入口；它实际是退出。
- 依赖 700 原生缩放收尾，导致捏合又回到三个浮窗。
- 只拦截通用窗口点击，没有找到 `CanvasGestureManager.T -> B0.A(true)` 的直接退出链。
- 测试保存的三分屏时没有先区分“首次恢复状态”和“从三个浮窗再次放大”的路径，导致对根因判断混乱。

## 8. 下次适配的最短流程

### 第一步：固定目标 APK

```powershell
adb -s <设备地址> shell pm path com.oplus.pscanvas
adb -s <设备地址> pull /system_ext/app/OplusFlexibleWindowUI/OplusFlexibleWindowUI.apk
Get-FileHash .\OplusFlexibleWindowUI.apk -Algorithm SHA256
adb -s <设备地址> shell dumpsys package com.oplus.pscanvas
```

记录 APK 路径、versionCode、versionName 和完整 SHA-256。先添加新的兼容档案；不要放宽为版本名前缀匹配。

### 第二步：反编译后只追六条链

1. `isThreeSplitTogether` 的 Bundle 写入和 Intent 写入位置。
2. 三任务边界请求及其返回 Bundle。
3. 三列画布 Rect 的计算方法，对应本版 `B1.l.M1(...)`。
4. SStoFlexible 的 `onScale` 入口及参数。
5. 全景管理器的进入、退出、状态读取方法，对应本版 `z/A/M`。
6. 全景状态下单击窗口调用退出方法的调用链。

然后确认 ThreeSplitAnim、ThreeSplitDrag、CanvasController 和分隔栏处理器的新混淆名。不要先移植整套旧 Hook；先让“边界、方向手势、单击”三条主链闭环。

### 第三步：自动验证

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:assembleDebug
```

至少为新档案补充 SHA、类名和方法名测试；布局宽度计算保留纯 Java 单元测试。

### 第四步：实机验收矩阵

1. 直接打开已保存的三分屏：前两列完整、第三列露出、无任何黑边。
2. 四指和五指向内捏合：三个窗口完整进入全景，不出现三个浮窗。
3. 全景单击三个窗口：均不退出、不放大。
4. 四指和五指向外张开：回到正常三分屏。
5. 左上角按钮：可以退出全景。
6. 关闭后重新打开已保存的三分屏：首次布局仍正确。
7. 二分屏新增、切换、缩放和退出：保持原生逻辑。
8. 日志中无 `hook failed`、崩溃或 ANR。

测试时同时检查 user 0 与多开用户（常见为 user 999）的 `com.oplus.pscanvas` 进程。无线 ADB 端口可能变化，不要把测试端口写入模块或适配档案。

## 9. 代码入口

| 文件 | 作用 |
| --- | --- |
| `hook/ApkFingerprint.java` | 计算目标 APK SHA-256 |
| `hook/PsCanvasCompatibilityProfile.java` | 保存每个已验证 APK 的混淆映射 |
| `hook/PsCanvasHooks.java` | 安装边界、手势、单击和触摸 Hook |
| `compat/PanoramaModeCompat.java` | 502 列宽与三应用全景判断 |
| `compat/SplitBar502Compat.java` | 阻断 700 三分屏拖动路径 |
| `scripts/verify-baseline-log.ps1` | 检查目标版本 Hook 安装日志 |

后续适配完成后，必须同步更新：兼容档案、档案单元测试、README 的适配版本，以及本文的新增差异结论。
