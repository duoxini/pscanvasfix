# PsCanvas Classic

PsCanvas Classic 是面向 ColorOS 平板多窗口组件 `com.oplus.pscanvas` 的 LSPosed 模块，
用于恢复经典三分屏宽画布、修正任务边界与黑框问题，并保留经过验证的全景交互。

## 主要功能

- 三任务经典横向宽画布：两个完整窗口加下一窗口预览；
- 画布槽位、TaskData LaunchBounds 与实际窗口边界同步；
- 三任务多指捏合进入全景、外扩退出和单击保护；
- 通过 DEX 结构和 Capability 识别兼容目标，不以版本号或 APK 哈希作为安装门槛；
- Material 3 模块状态与诊断页面。

二分屏捏合全景正在开发和实机验证中；正式发布版本在验证完成前继续保留系统原生二分屏
行为。

## 已获授权用户的使用方式

1. 在兼容的 LSPosed 环境中安装模块；
2. 启用模块并将作用域设置为 `com.oplus.pscanvas`；
3. 重启目标组件后生效。

已发布版本：[v1.4](https://github.com/duoxini/pscanvasfix/releases/tag/v1.4)

## 许可证与使用限制

本项目公开源代码仅供查阅、安全审计和学习研究，**不采用开放源代码许可，也不因源码
公开而授予使用权**。

未经书面授权，仅允许在线查看源码，以及使用 GitHub 原生 Fork 功能在 GitHub Fork
网络内创建、保留公开且未修改的 Fork，并原样同步上游内容。该有限许可不允许修改、
编译、构建、运行、发布、在 GitHub Fork 网络之外再分发、集成到其他项目或创作衍生
作品；原生 Fork 本身也不授予上述权利。

完整条款见 [LICENSE](LICENSE)。发布页若对特定二进制文件提供单独授权，以该发布页的
明确文字为准。
