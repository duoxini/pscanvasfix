# PsCanvas 502 Fix (LSPosed Module)

在 ColorOS **700 版本** `com.oplus.pscanvas` 上恢复 **502 版本**的三分屏 panorama 布局与四指捏合转浮窗行为。

> 设备上 `/system_ext/app/OplusFlexibleWindowUI/OplusFlexibleWindowUI.apk` 与 `com.oplus.pscanvas` 是同一个 APK。模块作用域选 `com.oplus.pscanvas`。

**当前版本：v1.0** (`versionCode 1`)

## 效果

| 行为 | 700 原生 | v1.0 修复后 (502 行为) |
|------|----------|----------------------|
| 三分屏布局 | 三列等宽并排 | 水平滚动 panorama，2+1 peek |
| 四指捏合 | 3 指即可触发 | 4 指触发，转独立浮窗 |
| 全景模式单击 | 自动放大窗口 | 无反应（仅四指张开退出） |
| 分隔栏拖拽 | 弹簧物理拖拽 | 禁用（502 无此功能） |

## 502 vs 700 核心差异

| 差异点 | 502 | 700 |
|--------|-----|-----|
| 全景模式开关 | `w1.l.u0()` 含 `temp_panorama_settings` | `B1.l.F0()` 移除临时开关 |
| 三分屏布局 | layout 4 panorama（2+1 peek） | layout 3 `isThreeSplitTogether` 三列等宽 |
| 捏合触发阈值 | `onScale` 需 **>3** (4指+) | 改为 **>=3** (3指+) |
| 捏合结束阈值 | 手指 **<=4** 结束 | 手指 **<3** 结束 |
| Prepare | `S1.p.I()` dummy `[0]` | `x1.r.e0(true)` 真 taskId |
| Bounds remap | `S1.p.x()` 读 live layout | `x1.r.L()` 用 init 缓存 |
| 分屏→浮窗 abort | 无 changeState 门控 | `F1→k0(2)` + `i0()` 闪桌面 |

## Hook 覆盖

### 布局与显示
| 目标 | 作用 |
|------|------|
| `Intent.putExtra("isThreeSplitTogether")` | 阻断三列等宽 bounds |
| `B1.l.n` bundle | 二次拦截 `isThreeSplitTogether` |
| `containerView.e3(i3=3)` | 阻断三分屏 Together 入口 |
| `containerView.f3()` | 阻断三分屏区域更新 |
| `containerView.E2()` | 阻断三分屏分隔栏滚动动画 |
| `containerView.i2()` | 阻断三分屏拖动放大 |
| `B1.l.F0` → `true` | 恢复全景模式开关（宽画布） |
| `EmbeddedViewDecor.getLaunchRect()` | 全景模式强制正常 rect |

### 捏合转浮窗
| 目标 | 作用 |
|------|------|
| `ContainerActivity.F1` | block `changeState=2` |
| `x1.r.k0/f0` | remap changeState 0/2→1 |
| `x1.r.e0(true)` | 替换为 502 dummy `t0([0])` |
| `x1.r.L` | 替换为 502 式 live layout remap |
| `x1.r.S` afterHook | 全景 mask 动画 rect 修正 |
| `x1.r.i0` | transition 期间 block reset |
| `x1.r.c0` | 502-style finish + 延迟 removeTask |
| `x1.r.J/p0/g0/s0/W` + `B1.l.t0` | sync layout / taskId 注入 / launch 验证 |
| `canvas.y` 手势 (T/onScaleBegin/onScale/onScaleEnd) | 4 指阈值恢复 |

### 动画与拖拽阻断
| 目标 | 作用 |
|------|------|
| `x1.x.H0/U0/e0/p0/y0` | 阻断 ThreeSplitAnimManager |
| `x1.y.b/c/d/e` | 阻断 ThreeSplitDragManager |
| `E.u0()` | 阻断三分屏弹簧拖拽 |
| `E.R()` | 阻断弹簧动画初始化 |
| `u1.c.H` | 全景模式阻断 tap-to-enlarge |

### 兼容层
| 类 | 职责 |
|----|------|
| `PinchTransition502Compat` | 502 捏合转浮窗核心（dummy prepare + bounds 重映射） |
| `FlexibleTransitionCompat` | 浮窗过渡管理、缩放回退、画布关闭调度 |
| `SplitPolicyCompat` | 分屏策略、taskId 管理、EmbeddedDecor 处理 |
| `ThreeSplitTouch502Compat` | 三分屏触摸行为恢复、全景检测 |
| `SplitBar502Compat` | 700 独有三分屏路径阻断 |
| `ObfFieldCompat` | 混淆字段名兼容（短名↔jadx 名映射） |
| `AtmCompat` | ActivityTaskManager 兼容 |
| `ConfigCompat` | 窗口配置/边界工具 |
| `PsCanvasLog` | 统一日志输出 |

## 项目结构

```
app/src/main/java/com/color/pscanvasfix/
├── MainHook.java                      # IXposedHookLoadPackage 入口
├── hook/
│   └── PsCanvasHooks.java            # Hook 编排器
└── compat/
    ├── PinchTransition502Compat.java  # 502 捏合核心
    ├── FlexibleTransitionCompat.java  # 浮窗过渡管理
    ├── SplitPolicyCompat.java         # 分屏策略
    ├── ThreeSplitTouch502Compat.java  # 触摸行为
    ├── SplitBar502Compat.java         # 分隔栏阻断
    ├── ObfFieldCompat.java            # 字段名兼容
    ├── AtmCompat.java                 # ATM 兼容
    ├── ConfigCompat.java              # 窗口配置
    └── PsCanvasLog.java               # 日志工具
```

## 安装

```bat
adb install -r app\build\outputs\apk\release\app-release.apk
```

1. LSPosed 中启用 **PsCanvas 502 Fix**
2. 作用域勾选 **com.oplus.pscanvas**
3. 强制停止 `com.oplus.pscanvas` 或重启设备

## 构建

```bat
# Debug
gradlew.bat assembleDebug

# Release
gradlew.bat assembleRelease
```

## 验证

```powershell
# 集成测试（构建 + 安装 + 抓日志）
scripts\test-session.ps1

# 验收检查
scripts\verify-baseline-log.ps1
```

成功加载时日志应包含：

```
PsCanvasFix: install v1.0 hooks for com.oplus.pscanvas
PsCanvasFix: P0: hookBlockThreeSplitTogether e3 installed on ContainerView
PsCanvasFix: blocked e3 three-split-together entry (i3=3)
```

四指捏合转浮窗成功路径：

```
PsCanvasFix: 502 dummy prepare t0([0]) done
PsCanvasFix: positionChangeToSplit onAnimationEnd result:true
PsCanvasFix: 502-style finish ContainerActivity
```
