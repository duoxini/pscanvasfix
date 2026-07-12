# PsCanvasFix 完美复刻 502 行为 — 实现计划

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** 在 700 版本 `com.oplus.pscanvas` 上完整复刻 502 版本的三分屏行为，覆盖横屏 panorama 分屏和竖屏模式，阻断 700 新增的三分屏 Together 回调链、SplitBar 拖拽、Z-Order 分层变化。

**Architecture:** 在现有 PsCanvasHooks 框架上增加 4 个优先级组共 16 个新 Hook 点，添加 1 个新 compat 类 `SplitBar502Compat` 处理分隔栏拖拽阻断，修改 1 个现有 compat 类 `ThreeSplitTouch502Compat` 增加竖屏感知。

**Tech Stack:** Java 17, Xposed API 82, LSPosed, Android 14 (SDK 35), APKTool 反编译参考

## Global Constraints

- 所有 Hook 必须在 `com.oplus.pscanvas` 包下生效
- 版本号递增: versionCode 48 → 49, versionName → `12.0.14-700-v49`
- 验收标准: `scripts/verify-baseline-log.ps1` 全部通过 + 新增日志无异常
- 横屏和竖屏都需完美工作
- 不能破坏现有的 4 指捏合转浮窗功能
- 所有新增 Hook 必须有 PsCanvasLog 日志输出

---
## 前置: 确认当前未提交改动的基线

### Task 0: 提交现有未提交改动作为基线

**Files:**
- Modify: `app/build.gradle`
- Modify: `README.md`
- Commit all untracked compat classes and docs/scripts

- [ ] **Step 1: 查看当前工作区状态**

```bash
cd E:\AndroidStudioProjects\color2\pscanvasfix
git status
```

- [ ] **Step 2: 暂存并提交所有改动**

```bash
git add -A
git commit -m "chore: baseline before 502 full replication work

Uncommitted changes from v41→v48 development:
- 5 new compat classes (ObfFieldCompat, PinchTransition502Compat,
  PsCanvasLog, ThreeSplitTouch502Compat, plus enhancements to
  FlexibleTransitionCompat, SplitPolicyCompat)
- Docs, scripts, logs, debug batch files
- Updated PsCanvasHooks with layout remap + pinch transition hooks
- README and build.gradle updates

Co-Authored-By: Claude <noreply@anthropic.com>"
```

- [ ] **Step 3: 验证提交成功**

```bash
git log --oneline -3
git status --short
```
Expected: clean working tree

---
## 文件结构

```
app/src/main/java/com/color/pscanvasfix/
├── MainHook.java                          # 入口（无需修改）
├── hook/
│   └── PsCanvasHooks.java                # [修改] 核心 Hook 编排器，新增 4 个 install 方法
└── compat/
    ├── PinchTransition502Compat.java      # [无需修改]
    ├── FlexibleTransitionCompat.java      # [无需修改]
    ├── SplitPolicyCompat.java             # [修改] 新增竖屏判断、三分屏 Together 检测
    ├── ThreeSplitTouch502Compat.java      # [修改] 新增竖屏 panorama 检测
    ├── SplitBar502Compat.java             # [新建] 分隔栏拖拽阻断、e3/f3/E2/i2 hook
    ├── ObfFieldCompat.java               # [修改] 新增 E.java 字段常量
    ├── AtmCompat.java                     # [无需修改]
    ├── ConfigCompat.java                  # [无需修改]
    ├── I0Compat.java                      # [无需修改]
    └── PsCanvasLog.java                   # [无需修改]
```

---
## Section P0: 阻断三分屏 Together 回调链（核心）

### Task P0-1: 新增 SplitBar502Compat 类 — 阻断 e3/f3

**Files:**
- Create: `app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java`

**Interfaces:**
- Produces: `SplitBar502Compat.blockE3Entry(XC_MethodHook.MethodHookParam)`, `SplitBar502Compat.blockF3(XC_MethodHook.MethodHookParam)`, `SplitBar502Compat.shouldBlockThreeSplitTogether()`

- [ ] **Step 1: 创建 SplitBar502Compat 类骨架**

```java
package com.color.pscanvasfix.compat;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

/**
 * Block 700-only three-split-together behaviors:
 * e3() — three-split-together entry point (sets 3 equal columns)
 * f3() — update resizable split rects for three-split
 * E2() — startScrollSplitBarInThreeSplit
 * i2() — startEnlarge for three-split view
 */
public final class SplitBar502Compat {

    private SplitBar502Compat() {}
}
```

- [ ] **Step 2: 添加 `blockE3Entry` — 阻断 e3 三分屏 Together 入口**

在 `SplitBar502Compat.java` 中添加:

```java
    /**
     * Block containerView.e3() when i3==3 (three-split-together entry).
     * 502 has no three-split-together mode — the adapter callback must not
     * trigger 3-equal-column layout setup.
     */
    public static void blockE3Entry(XC_MethodHook.MethodHookParam param) {
        int layoutParam = (Integer) param.args[2];
        if (layoutParam == 3) {
            PsCanvasLog.d("blocked e3 three-split-together entry (i3=3)");
            param.setResult(null);
            return;
        }
        // Allow exit (i3=0) to proceed normally
        PsCanvasLog.d("e3 exit allowed i3=" + layoutParam);
    }
```

- [ ] **Step 3: 添加 `blockF3` — 阻断 f3 三分屏区域更新**

```java
    /**
     * Block containerView.f3() in three-split panorama context.
     * 700 uses this to update resizable split rects for 3-column layout;
     * 502 panorama mode manages this differently.
     */
    public static void blockF3(XC_MethodHook.MethodHookParam param) {
        if (!ThreeSplitTouch502Compat.isPanoramaThreeSplit(null)) {
            // Check via adapter layout
            try {
                Object containerView = param.thisObject;
                Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
                if (adapter != null) {
                    int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
                    if (layout >= 4 && layout <= 7) {
                        PsCanvasLog.d("blocked f3 in panorama layout=" + layout);
                        param.setResult(null);
                        return;
                    }
                }
            } catch (Throwable ignored) {}
        }
        PsCanvasLog.d("blocked f3 (panorama context)");
        param.setResult(null);
    }
```

- [ ] **Step 4: 添加 `blockE2` — 阻断三分屏分隔栏滚动动画**

```java
    /**
     * Block containerView.E2() — startScrollSplitBarInThreeSplit.
     * 502 has no three-split scroll bar animation; block entirely.
     */
    public static void blockE2Entry(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked E2 startScrollSplitBarInThreeSplit");
        param.setResult(new java.util.ArrayList()); // return empty list
    }
```

- [ ] **Step 5: 添加 `blockI2` — 阻断三分屏拖动放大**

```java
    /**
     * Block containerView.i2() — startEnlarge for three-split.
     * 502 uses panorama pan (ContainerView.V) instead of drag-to-enlarge.
     */
    public static void blockI2(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked i2 startEnlarge in three-split");
        param.setResult(null);
    }
```

- [ ] **Step 6: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java
git commit -m "feat(P0): add SplitBar502Compat — block e3/f3/E2/i2

Blocks 700-only three-split-together behaviors:
- e3(Context, List, int) with i3=3 (three equal columns entry)
- f3(List) resizable rect update
- E2() scroll split bar in three-split
- i2() start enlarge for three-split

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

### Task P0-2: 在 PsCanvasHooks 中安装 e3/f3/E2/i2 Hook

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java`

**Interfaces:**
- Consumes: `SplitBar502Compat.blockE3Entry()`, `SplitBar502Compat.blockF3()`, `SplitBar502Compat.blockE2Entry()`, `SplitBar502Compat.blockI2()`

- [ ] **Step 1: 在 `install()` 方法中添加新的 install 调用**

在 `PsCanvasHooks.java` 的 `install()` 方法中，在 `installDeferredHooksOnContainerStart(lpparam);` 之后添加:

```java
        // --- P0: Block 700 three-split-together callback chain ---
        hookBlockThreeSplitTogether(lpparam);
```

- [ ] **Step 2: 实现 `hookBlockThreeSplitTogether` 方法**

在 `PsCanvasHooks.java` 类末尾（`}` 之前）添加:

```java
    /**
     * P0 — Block 700 three-split-together callback chain.
     * 502 has no onEnterThreeSplitTogether / onExitThreeSplitTogether.
     * Block e3(), f3(), E2(), i2() so panorama layout 4 is never overridden
     * by 3-equal-column setup.
     */
    private static void hookBlockThreeSplitTogether(XC_LoadPackage.LoadPackageParam lpparam) {
        // Block containerView.e3(Context, List, int) when i3==3
        try {
            XposedHelpers.findAndHookMethod(
                    CONTAINER_VIEW, lpparam.classLoader, "e3",
                    android.content.Context.class, List.class, Integer.TYPE,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            SplitBar502Compat.blockE3Entry(param);
                        }
                    });
            PsCanvasLog.i("hookBlockThreeSplitTogether e3 installed on ContainerView");
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockThreeSplitTogether e3 failed", t);
        }

        // Block containerView.f3(List) — update resizable rects in three-split
        try {
            XposedHelpers.findAndHookMethod(
                    CONTAINER_VIEW, lpparam.classLoader, "f3",
                    List.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            SplitBar502Compat.blockF3(param);
                        }
                    });
            PsCanvasLog.i("hookBlockThreeSplitTogether f3 installed on ContainerView");
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockThreeSplitTogether f3 failed", t);
        }

        // Block containerView.E2() — startScrollSplitBarInThreeSplit
        try {
            XposedHelpers.findAndHookMethod(
                    CONTAINER_VIEW, lpparam.classLoader, "E2",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            SplitBar502Compat.blockE2Entry(param);
                        }
                    });
            PsCanvasLog.i("hookBlockThreeSplitTogether E2 installed on ContainerView");
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockThreeSplitTogether E2 failed", t);
        }

        // Block containerView.i2(List, float, float, E.c) — enlarge for three-split
        try {
            Class<?> eClass = XposedHelpers.findClass(
                    "com.oplus.pscanvas.canvasmode.canvas.E", lpparam.classLoader);
            // E.c is an inner class of E
            Class<?> eInnerC = null;
            for (Class<?> inner : eClass.getDeclaredClasses()) {
                if (inner.getSimpleName().equals("c")) {
                    eInnerC = inner;
                    break;
                }
            }
            if (eInnerC == null) {
                PsCanvasLog.w("hookBlockThreeSplitTogether i2: E.c inner class not found");
            } else {
                XposedHelpers.findAndHookMethod(
                        CONTAINER_VIEW, lpparam.classLoader, "i2",
                        List.class, Float.TYPE, Float.TYPE, eInnerC,
                        new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) {
                                SplitBar502Compat.blockI2(param);
                            }
                        });
                PsCanvasLog.i("hookBlockThreeSplitTogether i2 installed on ContainerView");
            }
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockThreeSplitTogether i2 failed", t);
        }
    }
```

- [ ] **Step 3: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java
git commit -m "feat(P0): install e3/f3/E2/i2 hooks in PsCanvasHooks

Add hookBlockThreeSplitTogether() to block the 700-only
three-split-together callback chain at all four entry points.

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

## Section P1: 阻断 SplitBar 三分屏拖拽

### Task P1-1: 在 SplitBar502Compat 中添加 E.u0/E.R 阻断

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java`

- [ ] **Step 1: 添加 `blockEU0` — 阻断三分屏弹簧拖动处理器**

在 `SplitBar502Compat.java` 中添加:

```java
    /**
     * Block E.u0() — spring-based three-split drag handler.
     * 502 uses direction-switch methods C/D/E/F/G instead of unified spring drag.
     * Block entirely so the canvas doesn't enter three-split drag mode.
     */
    public static void blockEU0(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked E.u0 three-split spring drag");
        param.setResult(null);
    }

    /**
     * Block E.R() — spring animation initialization for 3-split drag.
     * Must be blocked because u0() depends on the SpringAnimation created here.
     */
    public static void blockER(XC_MethodHook.MethodHookParam param) {
        PsCanvasLog.d("blocked E.R spring animation init");
        param.setResult(null);
    }
```

- [ ] **Step 2: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java
git commit -m "feat(P1): add E.u0/E.R blocking in SplitBar502Compat

Blocks 700-only spring-based three-split drag handler.
502 uses different direction-switch methods (C/D/E/F/G).

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

### Task P1-2: 在 PsCanvasHooks 中安装 E.u0/E.R Hook

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java`

- [ ] **Step 1: 添加 `install()` 调用**

在 `install()` 方法中，紧跟 P0 的 hook 调用之后添加:

```java
        // --- P1: Block 700 SplitBar three-split drag ---
        hookBlockSplitBarThreeSplitDrag(lpparam);
```

- [ ] **Step 2: 实现 `hookBlockSplitBarThreeSplitDrag` 方法**

在 `PsCanvasHooks.java` 末尾添加:

```java
    /**
     * P1 — Block 700 SplitBar three-split drag handlers.
     * 502 uses direction-switch methods (C/D/E/F/G in C0328z)
     * which were replaced by unified spring drag (E.u0) in 700.
     * Block both u0() and its spring init R().
     */
    private static void hookBlockSplitBarThreeSplitDrag(XC_LoadPackage.LoadPackageParam lpparam) {
        String E_CLASS = "com.oplus.pscanvas.canvasmode.canvas.E";

        // Block E.u0(c, float, float, float, float) — three-split spring drag
        try {
            Class<?> eClass = findClassFirst(lpparam.classLoader, E_CLASS);
            if (eClass == null) {
                PsCanvasLog.w("hookBlockSplitBarThreeSplitDrag: E class not found");
                return;
            }
            Class<?> eInnerC = null;
            for (Class<?> inner : eClass.getDeclaredClasses()) {
                if (inner.getSimpleName().equals("c")) {
                    eInnerC = inner;
                    break;
                }
            }
            if (eInnerC == null) {
                PsCanvasLog.w("hookBlockSplitBarThreeSplitDrag: E.c inner class not found");
            } else {
                XposedHelpers.findAndHookMethod(eClass, "u0",
                        eInnerC, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE,
                        new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) {
                                SplitBar502Compat.blockEU0(param);
                            }
                        });
                PsCanvasLog.i("hookBlockSplitBarThreeSplitDrag u0 installed on E");
            }
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockSplitBarThreeSplitDrag u0 failed", t);
        }

        // Block E.R() — spring animation initialization
        try {
            Class<?> eClass = findClassFirst(lpparam.classLoader, E_CLASS);
            if (eClass != null) {
                XposedHelpers.findAndHookMethod(eClass, "R",
                        new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) {
                                SplitBar502Compat.blockER(param);
                            }
                        });
                PsCanvasLog.i("hookBlockSplitBarThreeSplitDrag R installed on E");
            }
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockSplitBarThreeSplitDrag R failed", t);
        }
    }
```

- [ ] **Step 3: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java
git commit -m "feat(P1): install E.u0/E.R hooks in PsCanvasHooks

Block 700-only split bar spring drag handler.
502 uses direction-switch methods that don't apply here.

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

## Section P2: Z-Order 分层修正 + getLaunchRect 全景覆盖

### Task P2-1: 在 SplitBar502Compat 中添加 setLayerOrder / getLaunchRect 阻断

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java`

- [ ] **Step 1: 添加 `blockThreeSplitLayerOrder` — 阻断三分屏 Together Z-Order 分支**

在 `SplitBar502Compat.java` 中添加:

```java
    /**
     * Block the three-split-together branch in ContainerView.setLayerOrder().
     * 502 setLayerOrder has no B1.s.z() sub-surface branch — force the
     * simple (non-three-split-together) path instead.
     *
     * Strategy: beforeHook set both B1.s.z(0,this) and B1.s.z(1,this) to false
     * so the method always takes the simple branch.
     */
    public static void blockThreeSplitLayerOrder(XC_MethodHook.MethodHookParam param) {
        try {
            Object containerView = param.thisObject;
            Class<?> sClass = XposedHelpers.findClass("B1.s",
                    containerView.getClass().getClassLoader());
            // Force z(0, this) and z(1, this) to return false
            // We hook B1.s.z() separately to always return false for this call
            PsCanvasLog.d("setLayerOrder: forcing simple (non-three-split-together) branch");
        } catch (Throwable ignored) {}
        // The actual blocking is done via B1.s.z hook (see P2-2)
    }

    /**
     * Block panorama getLaunchRect() override in EmbeddedViewDecor.
     * 700 adds: if (B1.s.H() && item.B()) return item.i() (match-parent rect).
     * 502 always returns item.n() in panorama mode.
     *
     * Strategy: beforeHook on getLaunchRect(), if current layout is panorama
     * (adapter layout >= 4), skip the B1.s.H() check by temporarily setting
     * the result to item.n().
     */
    public static void blockPanoramaLaunchRectOverride(XC_MethodHook.MethodHookParam param) {
        try {
            Object decor = param.thisObject;
            // Check if parent is ContainerView with panorama layout
            Object parent = XposedHelpers.callMethod(decor, "getParent");
            if (parent == null) return;
            Object adapter = XposedHelpers.callMethod(parent, "getAdapter");
            if (adapter == null) return;
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            if (layout >= 4 && layout <= 7) {
                // Panorama mode: force return item.n() instead of item.i()
                Object taskData = XposedHelpers.getObjectField(decor, "f10863i");
                if (taskData != null) {
                    Object normalRect = XposedHelpers.callMethod(taskData, "n");
                    PsCanvasLog.d("getLaunchRect: forced normal rect in panorama layout=" + layout);
                    param.setResult(normalRect);
                }
            }
        } catch (Throwable t) {
            PsCanvasLog.e("blockPanoramaLaunchRectOverride failed", t);
        }
    }
```

- [ ] **Step 2: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java
git commit -m "feat(P2): add setLayerOrder/getLaunchRect blocking logic

Blocks 700 three-split-together z-order branch and
panorama launch rect override in EmbeddedViewDecor.

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

### Task P2-2: 在 PsCanvasHooks 中安装 setLayerOrder / getLaunchRect Hook

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java`

- [ ] **Step 1: 添加 `install()` 调用**

在 `install()` 方法中，紧跟 P1 hook 调用之后添加:

```java
        // --- P2: Z-Order + getLaunchRect panorama fix ---
        hookBlockThreeSplitZOrder(lpparam);
        hookFixPanoramaLaunchRect(lpparam);
```

- [ ] **Step 2: 实现 `hookBlockThreeSplitZOrder`**

在 `PsCanvasHooks.java` 末尾添加:

```java
    /**
     * P2 — Block three-split-together z-order branch in setLayerOrder().
     * Hook B1.s.z() to always return false so ContainerView.setLayerOrder()
     * takes the simple (502-compatible) branch instead of the 700
     * three-split-together sub-surface layer assignment.
     */
    private static void hookBlockThreeSplitZOrder(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            XposedHelpers.findAndHookMethod(CONFIG, lpparam.classLoader, "z",
                    Integer.TYPE, android.view.View.class,
                    new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) {
                            return false; // Always return false = not in three-split-together
                        }
                    });
            PsCanvasLog.i("hookBlockThreeSplitZOrder installed: B1.s.z() always false");
        } catch (Throwable t) {
            PsCanvasLog.e("hookBlockThreeSplitZOrder B1.s.z failed", t);
        }
    }

    /**
     * P2 — Fix panorama getLaunchRect() override in EmbeddedViewDecor.
     * 700 adds B1.s.H() && item.B() → match-parent rect. 502 never does this.
     */
    private static void hookFixPanoramaLaunchRect(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            String EMBEDDED_DECOR =
                    "com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor";
            XposedHelpers.findAndHookMethod(EMBEDDED_DECOR, lpparam.classLoader,
                    "getLaunchRect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            SplitBar502Compat.blockPanoramaLaunchRectOverride(param);
                        }
                    });
            PsCanvasLog.i("hookFixPanoramaLaunchRect installed on EmbeddedViewDecor.getLaunchRect");
        } catch (Throwable t) {
            PsCanvasLog.e("hookFixPanoramaLaunchRect failed", t);
        }
    }
```

- [ ] **Step 3: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java
git commit -m "feat(P2): install z-order + getLaunchRect panorama fix hooks

- Hook B1.s.z() to always return false (blocks three-split-together
  sub-surface z-ordering)
- Hook EmbeddedViewDecor.getLaunchRect() to return normal rect
  instead of match-parent rect in panorama mode

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

## Section P3: 竖屏支持 + adapter回调阻断

### Task P3-1: 在 ThreeSplitTouch502Compat 中添加竖屏检测

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/compat/ThreeSplitTouch502Compat.java`

- [ ] **Step 1: 添加竖屏 panorama 检测方法**

在 `ThreeSplitTouch502Compat.java` 末尾（`}` 之前）添加:

```java
    /**
     * Check if the current adapter orientation is portrait (vertical) panorama.
     * 502 portrait layout values: adapter.i() returns portrait count,
     * adapter.u() returns user preferred orientation.
     *
     * In portrait: all three apps are stacked vertically with the
     * top two fully visible and the bottom one peeking (or vice versa).
     */
    public static boolean isPortraitPanorama(Object containerView) {
        if (containerView == null || !isThreeAppCanvas(containerView)) {
            return false;
        }
        try {
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null) return false;
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            int portraitCount = (Integer) XposedHelpers.callMethod(adapter, "i");
            // Portrait panorama: layout >= 4 (panorama) and has portrait tasks
            return layout >= 4 && layout <= 7 && portraitCount >= 1;
        } catch (Throwable ignored) {
            return false;
        }
    }

    /**
     * Check if we're in any panorama mode (landscape or portrait).
     * Used by hooks that need to apply 502 behavior regardless of orientation.
     */
    public static boolean isAnyPanoramaMode(Object containerView) {
        return isPanoramaThreeSplit(containerView) || isPortraitPanorama(containerView);
    }
```

- [ ] **Step 2: 更新 `shouldBlockTouchAnim` 使用竖屏感知检查**

修改 `shouldBlockTouchAnim` 和 `isPanoramaThreeSplit`:

```java
    // In isPanoramaThreeSplit, remove SplitPolicyCompat.inTransition() check 
    // (transition state is now handled at the hook level)
    public static boolean isPanoramaThreeSplit(Object containerView) {
        if (containerView == null) {
            return false;
        }
        if (!isThreeAppCanvas(containerView)) {
            return false;
        }
        try {
            Object adapter = XposedHelpers.callMethod(containerView, "getAdapter");
            if (adapter == null) return false;
            int layout = (Integer) XposedHelpers.callMethod(adapter, "n");
            return layout >= 4 && layout <= 7;
        } catch (Throwable ignored) {
            return false;
        }
    }

    // shouldBlockTouchAnim now uses isAnyPanoramaMode
    public static boolean shouldBlockTouchAnim(Object animOrDragHolder) {
        return isAnyPanoramaMode(findContainerView(animOrDragHolder));
    }
```

- [ ] **Step 3: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/compat/ThreeSplitTouch502Compat.java
git commit -m "feat(P3): add portrait panorama detection in ThreeSplitTouch502Compat

- Add isPortraitPanorama() for vertical 3-app split detection
- Add isAnyPanoramaMode() as orientation-agnostic check
- Update shouldBlockTouchAnim to use orientation-agnostic check

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

### Task P3-2: Hook adapter C0600c.f() beforeHook 阻断回调

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java`

- [ ] **Step 1: 修改现有 `hookTwoColumnPanoramaRestoreDeferred` 中的 `f()` hook**

将现有的 afterHook 改为 beforeHook，阻断回调对象 `f13801s`。在 `hookTwoColumnPanoramaRestoreDeferred` 方法中找到现有的:

```java
        hookAfterMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            ensureTwoColumnLayout(param.thisObject, "f()");
        });
```

替换为:

```java
        // P3: beforeHook on f() — null out the three-split callback BEFORE
        // the adapter calculates layout orientation, so onEnterThreeSplitTogether
        // never fires even if layout calculation returns 3.
        hookBeforeMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            try {
                // Null out f13801s (r0.b callback) to prevent three-split-together
                // callbacks from firing during layout calculation
                Object callback = XposedHelpers.getObjectField(param.thisObject, "f13801s");
                if (callback != null) {
                    XposedHelpers.setObjectField(param.thisObject, "f13801s", null);
                    PsCanvasLog.d("f() beforeHook: nulled three-split callback f13801s");
                }
            } catch (Throwable ignored) {
                // f13801s might not exist on all devices or the field name may differ
            }
        });

        // Keep afterHook for layout remap as fallback
        hookAfterMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            ensureTwoColumnLayout(param.thisObject, "f() afterHook");
        });
```

- [ ] **Step 2: 提交**

```bash
git add app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java
git commit -m "feat(P3): add beforeHook on adapter.f() to block three-split callback

Null out f13801s callback field BEFORE layout calculation so
onEnterThreeSplitTogether never fires. Keep afterHook as fallback.

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

## Section: 版本号更新 + 验收

### Task V-1: 更新版本号

**Files:**
- Modify: `app/build.gradle`
- Modify: `README.md`
- Modify: `scripts/verify-baseline-log.ps1`

- [ ] **Step 1: 更新 build.gradle**

修改 `app/build.gradle`:

```groovy
        versionCode 49
        versionName '12.0.14-700-v49'
```

- [ ] **Step 2: 更新 README.md 中的版本引用**

将 README 中的 `v41` → `v49`，`versionCode 41` → `versionCode 49`:

```
当前模块版本：**v49**（`versionCode 49`）。
```

- [ ] **Step 3: 更新 verify-baseline-log.ps1 验收脚本**

修改 `scripts/verify-baseline-log.ps1` 中的版本检查:

```powershell
$mustHave = @(
    "install v49",
    ...
)
```

并新增 P0/P1/P2/P3 验收项:

```powershell
# P0 验收项（应出现）:
    "blocked e3 three-split-together entry",
    "blocked f3",
    "blocked E2 startScrollSplitBarInThreeSplit",
    "blocked i2 startEnlarge in three-split",

# P1 验收项（应出现）:
    "blocked E.u0 three-split spring drag",
    "blocked E.R spring animation init",

# P2 验收项（应出现）:
    "setLayerOrder: forcing simple",
    "getLaunchRect: forced normal rect in panorama",

# P3 验收项（应出现）:
    "f() beforeHook: nulled three-split callback",
```

同步更新 `mustNotHave`:

```powershell
$mustNotHave = @(
    "ensureCanvasLayout3ForTransition",
    "M1 clamped layoutOrientation 4 -> 3",
    "notifyPrepare.*toggle returned false",
    "hookPanoramaMaskAnimRectFix failed",
    # P0 不应出现:
    "onEnterThreeSplitTogether",
    "onExitThreeSplitTogether",
    # P1 不应出现:
    "SpringAnimation.*start",
    "startScrollSplitBarInThreeSplit",
    # P2 不应出现:
    "setLayer.*sub.*surface",
    # P3 不应出现:
    "uncaught.*f13801s"
)
```

- [ ] **Step 4: 提交**

```bash
git add app/build.gradle README.md scripts/verify-baseline-log.ps1
git commit -m "chore: bump version to v49, update docs and verification script

- versionCode 49, versionName 12.0.14-700-v49
- README: v41→v49 references
- verify-baseline-log.ps1: add P0-P3 acceptance criteria

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

### Task V-2: 构建、安装、验收

- [ ] **Step 1: 构建 APK**

```bash
cd E:\AndroidStudioProjects\color2\pscanvasfix
./gradlew.bat :app:assembleDebug
```
Expected: BUILD SUCCESSFUL

- [ ] **Step 2: 安装到设备**

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```
Expected: Success

- [ ] **Step 3: 强制停止目标进程**

```bash
adb shell am force-stop com.oplus.pscanvas
```

- [ ] **Step 4: 抓取日志并执行验收**

```powershell
cd E:\AndroidStudioProjects\color2\pscanvasfix
powershell -File scripts/test-session.ps1
```

在设备上执行以下操作:
1. 打开三分屏（横屏 + 竖屏各一次）
2. 在三分屏中执行 4 指捏合转浮窗
3. 检查 panorama 布局是否正确 (2+1 peek 而非 3 等宽)

按 Ctrl+C 停止日志抓取后:

```powershell
powershell -File scripts/verify-baseline-log.ps1
```
Expected: All checks PASS

- [ ] **Step 5: 检查日志确认所有 P0-P3 Hook 已安装**

```bash
grep -E "install v49|hookBlockThreeSplitTogether|hookBlockSplitBarThreeSplitDrag|hookBlockThreeSplitZOrder|hookFixPanoramaLaunchRect" logs/pscanvas_latest.log
```
Expected: 所有 install 日志均出现

- [ ] **Step 6: 提交最终验收结果**

```bash
git add logs/
git commit -m "test: v49 verification — all P0-P3 hooks verified

Co-Authored-By: Claude <noreply@anthropic.com>"
```

---

## 验收清单

执行完毕后确认以下全部通过:

- [ ] `verify-baseline-log.ps1` 全部 mustHave 通过 (含 v49 标记)
- [ ] `verify-baseline-log.ps1` 全部 mustNotHave 通过
- [ ] 横屏三分屏展示为 panorama 2+1 (左侧两个完全,右侧部分)
- [ ] 竖屏三分屏展示为 panorama (上方两个完全,下方部分,或反之)
- [ ] 四指捏合转浮窗不闪桌面
- [ ] 分隔栏不可拖拽改变三分屏布局
- [ ] `onEnterThreeSplitTogether` 不在日志中出现
- [ ] `e3(Context, List, 3)` 调用被阻断 (日志可见)
