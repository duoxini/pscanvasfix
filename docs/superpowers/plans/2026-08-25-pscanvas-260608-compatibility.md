# PsCanvasFix 260608 兼容适配实施计划

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** 仅在已验证的 260608 PsCanvas APK 上安装已确认的 Hook，并在未知 APK 上安全退出。

**Architecture:** 以 APK SHA-256 选择不可变兼容档案；`PsCanvasHooks` 先识别档案，再安装该档案声明的独立 Hook 组。260608 只迁移 DEX 签名已确认的角色和方法，未确认的短名 Hook 不安装。

**Tech Stack:** Java 17、Android SDK 35、Xposed API 82、JUnit 4、PowerShell/ADB。

**Spec:** `docs/superpowers/specs/2026-08-25-pscanvas-260608-compatibility-design.md`

## Global Constraints

- 仅支持 `com.oplus.pscanvas` 的 SHA-256 `1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3`。
- 未命中档案时不得安装任何高风险 Hook，保持厂商原生行为。
- 不扩展四应用以上分屏，不修改厂商 APK，不重写既有 502 业务兼容类。
- 260608 的短名方法必须以 DEX 签名为证据；不以同名方法推断语义。
- 不暂存或提交 `logs/pscanvas_latest.log` 与 `docs/v1.1-multi-split-roadmap.md`。

---

### Task 1: APK 档案与 SHA-256 选择器

**Files:**
- Create: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasCompatibilityProfile.java`
- Create: `app/src/main/java/com/color/pscanvasfix/hook/ApkFingerprint.java`
- Create: `app/src/test/java/com/color/pscanvasfix/hook/PsCanvasCompatibilityProfileTest.java`
- Modify: `app/build.gradle`

**Interfaces:**
- Produces: `PsCanvasCompatibilityProfile.find(String sha256): PsCanvasCompatibilityProfile`，未知 SHA 返回 `null`。
- Produces: `ApkFingerprint.sha256(String apkPath): String`，失败返回 `null`。

- [ ] **Step 1: 写出失败的档案选择测试**

```java
@Test public void recognizes260608Only() {
    assertEquals("260608", PsCanvasCompatibilityProfile.find(KNOWN_SHA).id());
    assertNull(PsCanvasCompatibilityProfile.find("deadbeef"));
}
```

- [ ] **Step 2: 运行测试确认失败**

Run: `gradlew.bat :app:testDebugUnitTest --tests "com.color.pscanvasfix.hook.PsCanvasCompatibilityProfileTest"`

Expected: 编译失败，因为档案类尚不存在。

- [ ] **Step 3: 实现最小档案与 SHA-256 计算**

档案固定包含 `x1.x`、`x1.D`、`x1.E`、`com.oplus.pscanvas.canvasmode.canvas.s0`；已确认方法为 `t0(ScaleGestureDetector,int)`、`H(List,int[])`、`I()`、`Z(Transaction,SurfaceControl,SurfaceControl,SurfaceControl,SurfaceControl,EmbeddedViewDecor,int,FlexibleTaskView)`。`ApkFingerprint` 以 32 KiB 缓冲流式计算小写十六进制 SHA-256。

- [ ] **Step 4: 运行单元测试确认通过**

Run: `gradlew.bat :app:testDebugUnitTest --tests "com.color.pscanvasfix.hook.PsCanvasCompatibilityProfileTest"`

Expected: PASS。

### Task 2: 在 Hook 入口实行安全档案门禁

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java`
- Test: `app/src/test/java/com/color/pscanvasfix/hook/PsCanvasCompatibilityProfileTest.java`

**Interfaces:**
- Consumes: `ApkFingerprint.sha256(lpparam.appInfo.sourceDir)` 与 `PsCanvasCompatibilityProfile.find(sha256)`。
- Produces: 日志 `profile=260608` 或 `unsupported profile`，未知档案时提前返回。

- [ ] **Step 1: 扩充失败测试，覆盖已确认方法映射**

```java
@Test public void exposesVerified260608Symbols() {
    PsCanvasCompatibilityProfile p = PsCanvasCompatibilityProfile.find(KNOWN_SHA);
    assertEquals("x1.x", p.sstoFlexibleClass());
    assertEquals("t0", p.scaleMethod());
    assertEquals("x1.D", p.threeSplitAnimClass());
    assertEquals("x1.E", p.threeSplitDragClass());
    assertEquals("com.oplus.pscanvas.canvasmode.canvas.s0", p.canvasControllerClass());
}
```

- [ ] **Step 2: 实现入口门禁和安装摘要**

在 `install` 中计算 `lpparam.appInfo.sourceDir` 的 SHA-256。未知值记录路径、版本名、SHA 及 `unsupported profile` 后返回。已知值保存到 `activeProfile`，记录 `profile=260608` 后才安装。每组通过统一状态记录函数输出 `installed`、`skipped` 或 `failed`，并以摘要结束。

- [ ] **Step 3: 运行单元测试和 Debug 构建**

Run: `gradlew.bat :app:testDebugUnitTest :app:assembleDebug`

Expected: 两个任务均为 `BUILD SUCCESSFUL`。

### Task 3: 迁移 260608 已确认的 Hook 组

**Files:**
- Modify: `app/src/main/java/com/color/pscanvasfix/hook/PsCanvasHooks.java`

**Interfaces:**
- Consumes: `activeProfile` 中已确认的角色和方法。
- Produces: 已确认的 SStoFlexible、ThreeSplitAnim、ThreeSplitDrag、CanvasController Hook；未确认的 SStoFlexible 短名 Hook 明确跳过。

- [ ] **Step 1: 从 DEX 证据定义最小迁移集**

保留 SStoFlexible 的 `t0` 前置 Hook、`I()` 返回后的 taskId 修复、`H(List,int[])` 返回后的 bounds 修复、`Z(...)` 后置的 panorama mask rect 修复；将触摸恢复目标从 `x1.x/x1.y` 改为档案的 `x1.D/x1.E`；将 `O(boolean)` 目标从 `canvas.r0` 改为 `canvas.s0`。

- [ ] **Step 2: 显式跳过未确认的短名 Hook**

`F1()`、`k0`、`J`、`L`、`e0`、`W`、`p0`、`q0`、`g0`、`i0`、`c0`、`s0` 不迁移到 `x1.x`。日志包含每个跳过原因，禁止对它们调用 `findAndHookMethod`。

- [ ] **Step 3: 构建并检查静态安装日志文本**

Run: `gradlew.bat :app:assembleDebug`

Expected: `BUILD SUCCESSFUL`，生成 `app/build/outputs/apk/debug/app-debug.apk`。

### Task 4: 设备安装与日志验证

**Files:**
- Modify: `scripts/verify-baseline-log.ps1`
- Modify: `README.md`

**Interfaces:**
- Consumes: 设备 `192.168.5.14:40005`、Debug APK 与最新日志。
- Produces: 包含档案识别和必需 Hook 组状态的验证结果。

- [ ] **Step 1: 更新验收关键字**

必需日志包含 `profile=260608`、已确认触摸组、SStoFlexible 已确认组、CanvasController 组和摘要；未知档案日志包含 `unsupported profile`。删除对已跳过短名 Hook 的“必须已安装”要求。

- [ ] **Step 2: 安装并捕获加载日志**

Run: `adb -s 192.168.5.14:40005 install -r app/build/outputs/apk/debug/app-debug.apk`，随后强制停止并重新打开 `com.oplus.pscanvas`，抓取 `PsCanvasFix`、`LSPosed`、`Xposed` 日志。

Expected: SHA 命中 260608 档案，所有必需 Hook 组均报告 `installed`。

- [ ] **Step 3: 运行日志验收并手动验证手势**

Run: `powershell -ExecutionPolicy Bypass -File scripts/verify-baseline-log.ps1`

Expected: 自动日志检查通过；设备上手动验证三分屏 panorama 和四指捏合转浮窗。

- [ ] **Step 4: 提交实现**

```powershell
git add app/build.gradle app/src/main/java/com/color/pscanvasfix/hook scripts/verify-baseline-log.ps1 README.md docs/superpowers/plans/2026-08-25-pscanvas-260608-compatibility.md
git commit -m "feat: add 260608 compatibility profile"
```
