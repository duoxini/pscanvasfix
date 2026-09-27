package com.color.pscanvasfix.ui;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Keeps archived Four Task research internal while the release page stays concise. */
public final class PsCanvasManagerScreenVisibilityContractTest {

    @Test
    public void showsResizeAndHidesFourTaskProductEntry() throws IOException {
        String screen = source("ui/PsCanvasManagerScreen.kt");
        String model = source("ui/ManagerUiModel.kt");
        String coordinator = source("module/ServiceBackedManagerCoordinator.kt");
        String preferences = source("config/ModulePreferences.java");

        assertTrue(screen.contains("调整分屏窗口大小"));
        assertTrue(screen.contains("已验证版本"));
        assertTrue(screen.contains("验证状态"));
        assertTrue(screen.contains("复制基础信息"));
        assertTrue(screen.contains("BoxWithConstraints"));
        assertTrue(screen.contains("maxWidth >= WideLayoutBreakpoint"));
        assertTrue(screen.contains("widthIn(max = ContentMaxWidth)\n                    .fillMaxWidth()"));
        assertTrue(screen.contains("ModuleStatusCard"));
        assertTrue(screen.contains("FeatureCard"));
        assertTrue(screen.contains("BasicInfoCard"));
        assertTrue(screen.contains("PsCanvasExpressiveSwitch"));
        assertFalse(screen.contains("ManagerBackgroundDecoration"));
        assertTrue(screen.contains("SectionHeader"));
        assertTrue(screen.contains("StatusIconContainer"));
        assertTrue(screen.contains("VerificationIconContainer"));
        assertTrue(screen.contains("MaterialTheme.colorScheme.onPrimary"));
        assertTrue(screen.contains("ic_manager_status_layers"));
        assertTrue(screen.contains("Brush.linearGradient(StatusCardGradient)"));
        assertTrue(screen.contains("modifier = Modifier.weight(1.6f),\n                contentAlignment = Alignment.CenterEnd"));
        assertTrue(screen.contains("R.drawable.ic_manager_chevron_right"));
        assertTrue(screen.contains("ActiveStatusGreen"));
        assertTrue(screen.contains("BuiltInEnhancementsContainer"));
        assertTrue(screen.contains("BuiltInEnhancementsInner"));
        assertTrue(screen.contains(".height(IntrinsicSize.Min)"));
        assertTrue(screen.contains("FooterLineWidth"));
        assertTrue(screen.contains("默认增强"));
        assertTrue(screen.contains("兼容目标上自动启用，无需单独设置"));
        assertTrue(screen.contains("经典三分屏宽画布与边界修复"));
        assertTrue(screen.contains("二、三分屏捏合进入全景"));
        assertTrue(screen.contains("全景外扩退出与单击保护"));
        assertTrue(screen.contains("shape = RoundedCornerShape(14.dp)"));
        assertTrue(screen.contains("模块启用后，打开分屏即可生效"));
        assertTrue(screen.contains("复制模块与系统组件信息，便于排查兼容问题"));
        assertTrue(screen.contains("R.drawable.ic_manager_copy"));
        assertTrue(screen.contains("R.drawable.ic_manager_verification"));
        assertTrue(screen.contains("R.drawable.ic_manager_verification_ready"));
        assertFalse(screen.contains("设置将在重新打开分屏画布后生效"));
        assertFalse(screen.contains("查看完整兼容报告"));
        assertFalse(screen.contains("复制诊断信息"));
        assertFalse(screen.contains("三分屏 Resize 接线中"));
        assertFalse(screen.contains("更多菜单"));
        assertFalse(screen.contains("允许四窗口画布"));
        assertTrue(coordinator.contains("PackageManager.GET_META_DATA"));
        assertTrue(coordinator.contains("VERSION_DATE_META_DATA = \"versionDate\""));
        assertTrue(coordinator.contains("target.versionDate in verifiedVersionDates"));
        assertTrue(
                coordinator.indexOf("private val targetIdentity")
                        < coordinator.indexOf("private var state = buildState"));

        assertTrue(model.contains("val fourTaskCanvas: FeatureToggleUiState"));
        assertTrue(preferences.contains("KEY_FOUR_TASK_CANVAS"));
    }

    private static String source(String relative) throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve("app/src/main/java/com/color/pscanvasfix").resolve(relative);
        if (!Files.isRegularFile(source)) {
            source = root.resolve("src/main/java/com/color/pscanvasfix").resolve(relative);
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8)
                .replace("\r\n", "\n");
    }
}
