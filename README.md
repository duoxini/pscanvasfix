# PsCanvas 502 Fix (LSPosed Module)

在 **700 版本** `com.oplus.pscanvas` / `OplusFlexibleWindowUI.apk` (v2.0.0) 上恢复 **502 版本**的 panorama 分屏与四指捏合转浮窗行为。

> 设备上 `/system_ext/app/OplusFlexibleWindowUI/OplusFlexibleWindowUI.apk` 与 `com.oplus.pscanvas` **是同一个 APK**（哈希一致）。模块作用域仍选 `com.oplus.pscanvas`。

当前模块版本：**v41**（`versionCode 41`）。详细 502 vs 700 对照见 [`docs/502-700-diff-baseline.md`](docs/502-700-diff-baseline.md)。

## 反编译对比结论

| 差异点 | 502 | 700 |
|--------|-----|-----|
| 全景模式开关 | `w1.l.u0()` 含 `temp_panorama_settings` | `B1.l.F0()` 移除临时开关 |
| 三分屏布局 | layout 4 panorama（2+1 peek） | layout 3 + `isThreeSplitTogether` 三列 |
| 捏合触发手指数 | `onScale` 需 **>3** (4指+) | 改为 **>=3** (3指+) |
| 捏合结束阈值 | 手指 **<=4** 才结束 | 手指 **<3** 就结束 |
| Prepare | `S1.p.I()` dummy `[0]` | `x1.r.e0(true)` 真 taskId ×2 |
| Bounds remap | `S1.p.x()` 读 live layout | `x1.r.L()` 用 init 缓存 `f14114H` |
| 分屏→浮窗 abort | 无 changeState 门控 | `F1→k0(2)` + `i0()` 闪桌面 |
| removeTask | `ContainerActivity.w1()` | 700 改为 `C1()` |

## 模块 Hook 点（v41）

### Section A — Panorama 分屏显示

| 目标 | 作用 |
|------|------|
| `Intent.putExtra("isThreeSplitTogether")` | 阻断三列 Together bounds |
| `r0.O(false)` | 强制非 panorama 标志走 layout 4 |
| `u1.c.n/t`, `A/M/T/f`, `B1.e.c` | 三分屏 layout 3→4 |
| `B1.l.F0` → `true` | 恢复全景模式开关 |
| `B1.l.n` bundle | 二次拦截 `isThreeSplitTogether` |

### Section B — 四指 pinch 转浮窗（502 S1.p 核心）

| 目标 | 作用 |
|------|------|
| `ContainerActivity.F1` | block `changeState=2` |
| `x1.r.k0/f0` | remap changeState 0/2→1 |
| `x1.r.e0(true)` | 替换为 502 dummy `t0([0])` |
| `x1.r.L` | 替换为 `PinchTransition502Compat.apply502LayoutRemap` |
| `x1.r.S` afterHook | layout 4 peek mask anim rect 修正 |
| `x1.r.i0` | transition 期间 block reset |
| `x1.r.c0` | 502-style finish + delayed removeTask |
| `x1.r.J/p0/g0/s0` + `B1.l.t0` | sync layout、taskId 注入、launch 验证 |
| `canvas.y` 手势 | 4指+ 阈值恢复 |
| `x1.x.H0` (ThreeSplitAnimManager) | transition 期间 block `resetAll` |

兼容层：`PinchTransition502Compat`、`FlexibleTransitionCompat`、`SplitPolicyCompat`、`ObfFieldCompat`。

## 安装

```bat
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

1. LSPosed 中启用 **PsCanvas 502 Fix**
2. 作用域勾选 **com.oplus.pscanvas**
3. 重启设备或强制停止分屏相关进程

## 调试日志

**集成测试会话（构建 + 安装 + 抓日志）：**

```powershell
scripts\test-session.ps1
```

**验收 grep（对 `logs\pscanvas_latest.log`）：**

```powershell
scripts\verify-baseline-log.ps1
```

**后台自动抓取** — 日志保存到 `logs\pscanvas_时间戳.log`：

```bat
capture_logs_background.bat   rem 后台启动
capture_logs_stop.bat         rem 停止抓取
```

**前台抓取并实时显示：**

```bat
capture_logs.bat
```

或：

```bat
adb logcat -v time PsCanvasFix:D SStoFlexible:D CanvasGestureManager:D FlexibleWindowUtil:D ThreeSplitAnimManager:D
```

成功加载时应看到：

```
PsCanvasFix: install v41 hooks for com.oplus.pscanvas
PsCanvasFix: hookPanoramaMaskAnimRectFix installed on x1.r.S
PsCanvasFix: hookThreeSplitAnimResetGuard installed on x1.x.H0
```

三分屏 4 指 pinch 成功路径示例：

```
PsCanvasFix: 502 dummy prepare t0([0]) done
PsCanvasFix: 502 layout remap layout=4 size=3
PsCanvasFix: fixPanoramaMaskAnimRect task=... -> ...
SStoFlexible: positionChangeToSplit onAnimationEnd result:true
PsCanvasFix: 502-style finish ContainerActivity
```

## 构建

```bat
gradlew.bat assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`
