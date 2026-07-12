# 502 vs 700 — diff baseline (v41)

## Class map

| Role | 502 | 700 device | live dex |
|------|-----|------------|----------|
| SStoFlexible | S1.p | X1.r | x1.r |
| Gesture | C0325w | C0332y | canvas.y |
| FlexibleUtil | W1.l | B1.l | B1.l |
| Adapter | p1.C0532c | U1.C0600c | u1.c |
| ThreeSplitAnim | — | X1.x | x1.x |

---

## Section A — 分屏显示（502 panorama，已实现）

目标：三分屏 canvas 显示为 502 式 **layout 4 panorama**（2+1 peek + 横滑）。

| Hook | 文件 | 作用 |
|------|------|------|
| `hookTwoColumnPanoramaRestoreCore` | PsCanvasHooks | block `isThreeSplitTogether`；`r0.O(false)` |
| `hookTwoColumnPanoramaRestoreDeferred` | PsCanvasHooks | adapter `A/M/T/f`；`B1.e.c` layout 3→4 |
| `hookAdapterLayoutMethods` | PsCanvasHooks | `u1.c.n/t` 三分屏时 3→4 |
| `hook502BehaviorRestoreCore/Deferred` | PsCanvasHooks | `B1.l.F0`→true；手势 4指+ 阈值 |
| `hookSplitToFlexibleTransition` B1.l.n | PsCanvasHooks | block `isThreeSplitTogether` bundle |

与 [`502-700-split-screen-diff.md`](502-700-split-screen-diff.md) 关系：

| 700 分屏差异 | 模块覆盖 |
|--------------|----------|
| ThreeSplitTogether / ContainerView.e3 | **已覆盖**（Intent + B1.l.n） |
| 700 三分屏 SplitBar 拖拽 E.u0 | **未覆盖**（502 无此路径） |
| C0309c 动画前 f3() | **未覆盖**（当前非阻塞） |

验收：三分屏后 canvas 为 panorama 2+1，**不**因 pinch hook 变回三列 layout 3。

---

## Section B — 捏合转浮窗（502 已移植，v41）

### Method map (pinch only)

| Step | 502 S1.p | 700 x1.r | v41 fix |
|------|----------|----------|---------|
| Init | v() | J() | J afterHook sync live layout |
| Scale | O() | f0() | block changeState 0/2 |
| Scale end | P() → N()→**I() dummy** | g0() → **e0(true) real** | e0(true) → dummy t0([0]) |
| Bounds remap | **x() live adapter.n()** | L() + cached f14114H | **replace L() with 502 x()** |
| Mask anim rect | — | x1.r.S createMaskLeash | **afterHook fixPanoramaMaskAnimRect** |
| Animate | p() | p0() | 700 native (unchanged) |
| Launch | T()→o0 once | s0()→t0 | taskId inject on **real** launch only |
| Finish | D() | c0() | 502-style finish + C1 removeTask |
| Abort | Q() | i0() | block i0 during transition |
| Anim reset | — | x1.x.H0 resetAll | block during `inTransition()` |

### Pinch log 验收表

**应有：**

```
install v41 ...
hookPanoramaMaskAnimRectFix installed on x1.r.S
hookThreeSplitAnimResetGuard installed on x1.x.H0
502 dummy prepare t0([0]) done
502 layout remap layout=4 size=3
fixPanoramaMaskAnimRect task=... (layout 4 peek 槽)
positionChangeToSplit onAnimationEnd result:true
502-style finish ContainerActivity
```

**不应有：**

```
ensureCanvasLayout3ForTransition
refreshFlexibleLaunchBounds / recalcFlexibleLaunchBounds
M1 clamped layoutOrientation 4 -> 3
hookPanoramaMaskAnimRectFix failed
notifyPrepare:true [0,0,0] → toggle returned false（真 prepare 失败）
resetAll（transition 中途，且未被 block）
```

**说明**：`createMaskLeash ... 3396 height:4837` 日志仍可能打印（来自 FlexibleTaskView 尺寸），应以 `fixPanoramaMaskAnimRect` 是否执行及视觉同步为准。

自动化验收：`scripts/verify-baseline-log.ps1`（对 `logs/pscanvas_latest.log` grep）。

### 用户可见验收

1. Panorama 分屏显示不变
2. 四指 pinch 不闪桌面，canvas 上三 app 同步缩小
3. 完成后三独立浮窗，canvas 退出

---

## Section C — S1.p vs X1.r 逐方法对照（2026-06-21 补充）

源文件：

- 502：[`502/decompiled/sources/S1/p.java`](../../502/decompiled/sources/S1/p.java)
- 700：[`700/decompiled/sources/X1/r.java`](../../700/decompiled/sources/X1/r.java)

### C.1 公共 API 映射

| 语义 | 502 `S1.p` | 700 `X1.r` | 差异摘要 |
|------|------------|------------|----------|
| 初始化捏合转浮窗 | `v()` | `J()` | 700 增加 duplicate taskId 检查、splitScreen 动画状态检查、guide dialog 阻塞、`f14114H=adapter.n()` 缓存 layout |
| 缩放进行中 | `O(ScaleGestureDetector)` | `f0(ScaleGestureDetector, int)` | 700 增加 `changeState` 路径；f0 反编译失败需看 live dex |
| 缩放结束 | `P()` | `g0()` | 700：`changeState==0/2` 时直接 `i0()` 重置；否则 `e0(true)` 真 prepare |
| 启动转浮窗动画 | `p()` | `p0()` | 700 在 `p0()` 内还会 `e0(false)` 第二次 prepare |
| 最终 launch | `T()` | `s0()` | 逻辑相近；700 bundle 多 `androidx.canvas.task.pending.remove` |
| 取消/重置 | `Q()` | `i0()` | 700 日志 `resetAll`；恢复 split bar visibility |
| 外部 stop | `U()` | `t0()` | 700 在 state>=4 或已 prepare 时也会触发 `g0()` |
| 是否 init 中 | `A()` | `P()` | 字段名不同，语义相同 |
| 是否已 scaleEnd | — | `N()` | 700 新增 `mScaleEnd` 查询 |
| 是否 mask 动画中 | — | `O()` | 700 新增 |
| changeState 写入 | — | `k0(int)` | **502 无**；700 手势层写入 0/2 触发 abort |
| prepare 就绪标记 | — | `n0(boolean)` | 700 WM prepare 回调后置 true，动画结束延迟 launch |

### C.2 Prepare 路径（核心回归点）

**502 `I()` + `N()`**

```java
// 502: static dummy — taskId=[0], bounds=[empty Rect]
bundle.putBoolean("prepare_switch_to_flexible_window", true);
w1.l.o0(new int[]{0}, arrayList, new float[1], bundle);
// 由 P() → N() 在 scaleEnd 时 post 到 C0304a 线程池
```

**700 `e0(boolean)` → `W(...)`**

```java
// 700: 真 taskId 来自 C() → E(EmbeddedViewDecor) Intent extras
iArr[i] = intent.getIntExtra("androidx.activity.LaunchEmbeddedTaskId", 0);
if (z3) bundle.putBoolean("prepare_switch_to_flexible_window", true);
// z3=true: scaleEnd 后 e0(true)
// z3=false: p0() 动画开始时 e0(false) — 第二次 prepare
B1.l.t0(iArr2, arrayList, fArr, bundle2);
n0(true); // prepare_start_flexible_window_ps
```

| 调用时机 | 502 | 700 |
|----------|-----|-----|
| scaleEnd | 1× dummy `[0]` | 1× real taskId |
| p0 动画开始 | 无 | 1× real taskId（若 !F()） |
| 动画结束 launch | `T()` → `o0` | `Z()` → `s0()` → `t0` |

### C.3 Bounds 重映射

**502 `x(ArrayList)`** — 每次 launch 前读取 **live** layout：

```java
int n3 = this.f13650b.getAdapter().n(); // 实时 adapter layout
// layout 4 (panorama): mask[0]↔bundle[0], mask[2]↔bundle[1], mask[1]↔bundle[2]
// layout 6: 循环移位 mapping
// default: reverse index
```

**700 `L(ArrayList)` + `G(int)`** — 使用 init 时缓存的 `f14114H`：

```java
// J() 末尾: this.f14114H = this.f14129b.getAdapter().n();
// L() 通过 G(i) 做 index 变换，不 re-read adapter
// panorama hook 把 layout 3→4 后，f14114H 仍为 init 值 → 映射错位
```

**502 `x(float,float)` 在 700 中不存在同名方法**；700 的 `x(float)` 仅为 scale spring 的 translation 计算，与 bounds remap 无关。

### C.4 动画结束与 Activity 退出

| 步骤 | 502 | 700 |
|------|-----|-----|
| 动画 onEnd | `B()` → `T()` → post `D()` | `X()` → postDelayed `Z()` → `s0()` → post `c0()` |
| 退出 Activity | `D()`: `E1(true); finish()` | `c0()`: `Q2().E1(true); finish()` |
| prepare 失败回滚 | `B()` catch → `R(); Q()` | `Z()` catch → `j0(); i0()` |

### C.5 502 独有 / 700 新增方法

**仅 502**

- `J()` — fade-in 动画 listener（非 init）
- `S()` — mask fade-in 启动
- `E()` — notifyMaskReady（对应 700 `d0()`）

**仅 700**

- `D()` — init 时 pre-calc flexible bundle（`B1.l.n`）
- `R(Runnable)` — 后台 `calculateFlexibleTaskBoundBackground`
- `F()` / `H()` — prepare 状态机 `f14113G`
- `o0(int)` — state 写入（0/1/3/4/5/6）
- `Z()` — 动画结束后统一 launch 入口
- `c0()` — finish ContainerActivity（对应 502 `D()`）
- `l0/m0` — synchronized prepare 标志

### C.6 FlexibleUtil launch 入口

| 502 `W1.l` | 700 `B1.l` |
|------------|------------|
| `o0(int[], List, float[], Bundle)` | `t0(...)` 同名参数 |
| — | `n(List, layoutOrient, Bundle)` bounds 预计算 |
| — | `K1(Intent, Bundle, userId, pkg)` → `OplusZoomWindowManager.startZoomWindow` |

v41 hook 目标：在 700 `e0(true)` 替换为 502 dummy `t0([0])`；`L()` 替换为 502 式 live layout remap；`x1.r.S` afterHook 修正 layout 4 peek mask anim rect；`x1.x.H0` 在 transition 期间 block resetAll。
