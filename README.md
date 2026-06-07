# PsCanvas 502 Fix (LSPosed Module)

在 **700 版本** `com.oplus.pscanvas` (v2.0.0) 上恢复 **502 版本**的分屏 / 五指捏合行为。

## 反编译对比结论

| 差异点 | 502 | 700 |
|--------|-----|-----|
| 全景模式开关 | `w1.l.u0()` 含 `temp_panorama_settings` | `B1.l.F0()` 移除临时开关 |
| 捏合触发手指数 | `onScale` 需 **>3** (4指+) | 改为 **>=3** (3指+) |
| 捏合结束阈值 | 手指 **<=4** 才结束 | 手指 **<3** 就结束 |
| 分屏→浮窗 | `s1.p` 简单状态机 | `x1.r` 新增 `mChangeToState` 双向逻辑 |
| 三分屏 | 支持三列全景 | 有 `startScrollSplitBarInThreeSplit` 但全景默认关闭 |

502.jpg = 三列全景分屏；700.jpg = 两列普通分屏。

## 模块 Hook 点

1. **`B1.l.F0`** → 强制返回 `true` 开启全景模式
2. **`C0332y.f10934L`** → 构造函数强制 `true` 启用分屏捏合转浮窗
3. **`C0332y$c.onScale/onScaleEnd/T`** → 恢复 502 的 4指+ / <=4指 阈值
4. **`x1.r` (SStoFlexible)** → 分屏捏合转浮窗兼容层（继承自原 PsCanvasFix）
5. **`B1.s.h/j`** → WindowConfiguration 兼容

## 安装

```bat
adb install -r app\build\outputs\apk\debug\app-debug.apk
```

1. LSPosed 中启用 **PsCanvas 502 Fix**
2. 作用域勾选 **com.oplus.pscanvas**
3. 重启设备或强制停止分屏相关进程

## 调试日志

```bat
debug_logs.bat
```

或：

```bat
adb logcat -v time PsCanvasFix:D SStoFlexible:D CanvasGestureManager:D FlexibleWindowUtil:D
```

成功加载时应看到：

```
PsCanvasFix: hooking com.oplus.pscanvas build=12.0.0-700 (502 restore)
PsCanvasFix: forced f10934L=true (502 split-to-flexible)
```

## 构建

```bat
gradlew.bat assembleDebug
```

APK: `app/build/outputs/apk/debug/app-debug.apk`
