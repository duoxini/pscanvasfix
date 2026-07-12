# 502 vs 700 — Canvas 控制栏「新建窗口」调用链（700 独有）

502 无 `startNewWindow`、`canvas_control_bar_menu_new_window` 字符串及对应菜单项。以下基于 700 反编译源码。

## 类角色

| 类 | 文件 | 角色 |
|----|------|------|
| `C0327t` | `com/oplus/pscanvas/canvasmode/canvas/C0327t.java` | **CanvasControlBarManager** — 每个 EmbeddedViewDecor 的控制栏 + 弹出菜单 |
| `EmbeddedViewDecor` | `view/EmbeddedViewDecor.java` | 持有 `f10862h` → `C0327t` 实例 |
| `ContainerView` | `view/ContainerView.java` | 分屏容器；focus 切换时更新 control bar |
| `B1.l` | `B1/l.java` | FlexibleWindowUtil；`K1` 启动浮窗 |
| `t1.j.f13635e` | 字符串资源 | `canvas_control_bar_menu_new_window`（新建窗口） |
| `t1.e.f13412r` | drawable | `canvas_control_bar_icon_plus_not_focus` 菜单图标 |

## 初始化链

```
EmbeddedViewDecor 创建/布局
  └─ C0327t.J0(FlexibleTaskView, EmbeddedViewDecor, layoutRect, launchRect, C0601d)
       ├─ inflate canvas_control_bar (t1.h.f13474g)
       ├─ f10657e = ImageButton（控制栏手柄）
       │    └─ setOnClickListener → X0() → w1()  // 点击打开菜单
       ├─ f10666l = FlexibleTaskView
       ├─ f10669o = C0601d（当前 task 数据）
       └─ f10652b0 = true（已初始化）
```

`ContainerView.setControlBarVisibility` / focus 变化时调用各 decor 的 `getCanvasControlBarManager().J0(...)` 更新位置与图标。

## 菜单构建链（含「新建窗口」条件）

```
用户点击控制栏 ImageButton
  └─ X0()
       └─ w1()  // showControlBarMenu
            ├─ M0()  // 创建 COUIPopupListWindow f10670p
            └─ N0()  // initPopupList — 按设备类型分支
                 ├─ B1.s.H() → e0()   // 折叠屏
                 ├─ B1.s.w() → d0()   // Pad
                 └─ else     → c0()   // 手机

c0() / d0() / e0() 共同逻辑：
  ├─ 全屏、关闭、替换、转浮窗等固定项
  └─ b0()  // 「新建窗口」项 — 条件出现
       ├─ 非 Pad (B1.s.w) 且 taskData 有效
       ├─ B1.l.O0(packageName)  // 查询 isSupportMultiInstance
       ├─ B1.l.f217q.get(pkg) == true
       └─ 若支持 → 添加菜单项：
            s.a().C(t1.e.f13412r)  // plus 图标
                 .I(getString(t1.j.f13635e))  // "新建窗口"
                 .F(true).z(1).x()
```

**关键 gate**：`OplusActivityTaskManager.isSupportMultiInstance(packageName)` 为 true 时才显示「新建窗口」。缓存于 `B1.l.f217q`（LRU 24）。

## 菜单点击 → startNewWindow

```
COUIPopupListWindow.OnItemClickListener (inner class c)
  └─ 匹配 sVar.t() == getString(t1.j.f13635e)
       ├─ f10670p.dismiss()
       └─ C1()  // startNewWindow
            ├─ 校验 f10669o (C0601d) 非 null，taskId > 0
            ├─ Intent cloneFilter = taskData.f().cloneFilter()
            ├─ cloneFilter.setClassName(component)
            ├─ flags: 268435456 | 134217728
            ├─ putExtra("multi_instance_source", 2)
            ├─ Bundle:
            │    extra_window_mode = 100
            │    android:activity.mZoomLaunchFlags = 14
            └─ B1.l.K1(intent, bundle, userId, callerPkg)
                 └─ OplusZoomWindowManager.startZoomWindow(...)
```

## 与 ContainerActivity.C1() 的区分

700 中存在**两个不同**的 `C1()`：

| 位置 | 含义 |
|------|------|
| `C0327t.C1()` | **startNewWindow** — 从控制栏菜单启动同应用新浮窗实例 |
| `ContainerActivity.C1()` | 其他生命周期/布局逻辑（与菜单无关） |
| `ContainerView.C1(int, List, List)` | 动画参数传递（ pinch 过渡用） |

控制栏路径只涉及 **`C0327t.C1()`**。

## 菜单项完整列表（手机 c0 分支）

| 字符串 ID | 文案 key | 点击行为 |
|-----------|----------|----------|
| f13633d | menu_full | `H2()` 全屏 |
| f13639g | to_third_split | 三分屏（仅 2-app） |
| f13637f | switch_to_zoom | `D1()` → 转浮窗 |
| f13631c | menu_close | `S1()` 关闭 |
| **f13635e** | **new_window** | **`C1()` 新建窗口**（b0 条件） |
| f13625Y | replace | `v1()` 替换应用 |

Pad `d0()`、折叠 `e0()` 顺序略有不同，但 `b0()` 插入条件相同。

## 502 对比结论

- 502 反编译中 **无** `f13635e` / `canvas_control_bar_menu_new_window` / `startNewWindow` / `multi_instance_source` / `B1.l.K1` 调用链。
- 502 控制栏等价类为 `n0`/`C0325w` 等（混淆名不同），菜单仅含全屏、关闭、转浮窗、替换等，**无多实例新建窗口**。

## 相关资源（仅 700）

- `res/drawable/canvas_control_bar_icon_plus_not_focus.xml`
- `res/drawable/canvas_control_bar_icon_plus_not_focus_light.xml`
- `res/drawable/new_window_button_bg.xml`
- `res/values/strings.xml` → `canvas_control_bar_menu_new_window`
