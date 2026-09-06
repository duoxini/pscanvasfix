# AGENTS.md — PsCanvasFix 项目规则

面向所有 AI 助手/自动化会话的项目指令。详细结论与长文沉淀在本地 `docs/`（gitignore，不入库）。

## 1. 项目概况

- Xposed/LSPosed 模块：包名 `com.color.pscanvasfix`，目标应用 `com.oplus.pscanvas`
  （ColorOS 平板金标版多窗口组件；所有版本 versionName/versionCode 均为 2.0.0/20，
  只能用 SHA-256 / DEX 结构识别代际）。
- 目的：把金标版（700 新逻辑）的三分屏/全景行为适配回 251215（502 原版逻辑）——
  无黑框、内容铺满、全景捏合进入/单击不退出/外扩退出、二分屏保持 OEM 行为。

## 2. 工程红线（不可违反）

1. 不重写 UI / 不换 Gradle（不重构 build.gradle 结构）/ 不重构未验证的 502 状态机。
2. 不改动画参数 / 不改 Panorama 行为（既定目标行为之外的部分）。
3. 不猜测未知方法语义；一切改动必须基于反编译源码或真机日志证据。
4. 不新增 SHA/版本号 gate：版本识别（ApkFingerprint）仅诊断用途，不得 gate 能力安装。
5. 二分屏保持 OEM 原生行为。
6. 三分屏黑框不变量：画布槽位比例 = TaskData LaunchBounds = WM 实际任务比例；
   三层不一致必然 letterbox。先检查三层矩形一致性，不先动 View 背景 / Surface / 延迟刷新。

## 3. 版本适配规则

- **251215 = 502 原版基准**（两套逻辑中的原版逻辑）：仅作版本对照放在
  `archive\file`，**不安装、不测试**；所有需适配版本的适配目标 = 对齐其行为。
- **260403 / 260512 / 260608 及以后新版本 = 需适配版本**。
- 适配流程：
  1. 新版本 APK 放入 `archive\file`，命名 `多窗口(<代际>).apk`；
  2. SHA-256 追加到 `ApkFingerprint.createGenerationTable()`（仅诊断）；
  3. 确认设备当前版本：`adb shell pm path com.oplus.pscanvas` → pull base.apk 比对 SHA；
  4. **排除 251215（不装）与本机版本**，其余需适配版本按代际顺序
     `adb install -r -t` 覆盖安装，由用户手动测试（对照 251215 原版行为）；
  5. 发现问题 → 用 `logcat -s PsCanvasFix` 定位能力组 → 修复 → 重测该版本；
  6. 测试结束装回本机版本。

## 4. 发布与文档规范（用户 2026-09-06 明确）

1. **README 极简**：只保留 来源 / 目的 / 适配范围 / 使用 / 最新版本；
   不写适配记录、适配规则等长文。
2. **对外（README / Release）一律只用版本号**（如 `v1.4`），
   **禁止出现内部代际号**（260608、251215 等）。
3. **Release notes 极简**：版本号标题 + 一句修复简述。
4. **发布前必须让用户确认**：先改好 README 与 Release 内容并展示，确认后再发布。

## 5. 调试约定

- 模块日志：`logcat -s PsCanvasFix`；系统侧相关 tag：
  `FlexibleWindowUtil` / `CanvasCalculateLayoutRect` / `TabletCanvasTaskLayoutPolicy`。
- 本地文档：`docs/竖屏三分屏未填充窗口问题结论_20260906.md`、
  `docs/三分屏黑框问题结论_20260825.md`、
  `docs/版本适配规则与代际测试记录_20260906.md`。
