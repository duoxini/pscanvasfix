package com.color.pscanvasfix.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.color.pscanvasfix.R
import com.color.pscanvasfix.diagnostic.CompatibilityReadiness
import com.color.pscanvasfix.diagnostic.ModuleRuntimeState

@Composable
fun PsCanvasManagerScreen(
    state: ManagerUiState,
    onAdjustableWindowSizeChange: (Boolean) -> Unit,
    onCopyDiagnostics: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 18.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.ps_canvas_icon_foreground_art),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                )
                Column {
                    Text(
                        text = "PsCanvas Classic",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "经典分屏画布增强",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            Spacer(Modifier.height(20.dp))
            ModuleStatusCard(state)

            Spacer(Modifier.height(24.dp))
            Text(
                text = "增强功能",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(Modifier.height(8.dp))

            FeatureToggleRow(
                title = "调整分屏窗口大小",
                state = state.adjustableWindowSize,
                onCheckedChange = onAdjustableWindowSizeChange,
            )

            Spacer(Modifier.height(20.dp))
            FilledTonalButton(
                onClick = onCopyDiagnostics,
                enabled = state.diagnosticsAvailable,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 48.dp),
            ) {
                Text("复制基础信息")
            }

            Spacer(Modifier.height(16.dp))
            Text(
                text = "设置将在重新打开分屏画布后生效",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun ModuleStatusCard(state: ManagerUiState) {
    val presentation = runtimePresentation(state.runtimeState)
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(presentation.color(), CircleShape),
                )
                Column {
                    Text(
                        text = "模块状态",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Text(
                        text = presentation.label,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }

            Text(
                text = state.runtimeDetail ?: presentation.detail,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            StatusLine(
                label = "系统组件",
                value = "com.oplus.pscanvas",
            )
            StatusLine(
                label = "组件版本",
                value = targetVersionLabel(state.targetVersionName, state.targetVersionCode),
            )
            StatusLine(
                label = "版本日期",
                value = state.targetVersionDate ?: "未识别",
            )
            StatusLine(
                label = "验证状态",
                value = readinessLabel(state.compatibilityReadiness),
            )
            if (state.verifiedVersionDates.isNotEmpty()) {
                Text(
                    text = "已验证版本：${state.verifiedVersionDates.joinToString("、")}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Text(
                text = state.compatibilityDetail,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun StatusLine(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun FeatureToggleRow(
    title: String,
    state: FeatureToggleUiState,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 76.dp)
            .toggleable(
                value = state.checked,
                enabled = state.switchEnabled,
                role = Role.Switch,
                onValueChange = onCheckedChange,
            )
            .padding(vertical = 10.dp)
            .alpha(if (state.switchEnabled) 1f else 0.64f),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = state.summary,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        Switch(
            checked = state.checked,
            onCheckedChange = null,
            enabled = state.switchEnabled,
        )
    }
}

private data class RuntimePresentation(
    val label: String,
    val detail: String,
    val color: @Composable () -> Color,
)

private fun runtimePresentation(state: ModuleRuntimeState): RuntimePresentation = when (state) {
    ModuleRuntimeState.SERVICE_UNAVAILABLE -> RuntimePresentation(
        label = "LSPosed 服务未连接",
        detail = "请确认已在 LSPosed 中启用模块",
        color = { MaterialTheme.colorScheme.error },
    )
    ModuleRuntimeState.TARGET_WAITING_RESTART -> RuntimePresentation(
        label = "等待多窗口启动",
        detail = "设置会在下次打开系统多窗口时加载",
        color = { MaterialTheme.colorScheme.tertiary },
    )
    ModuleRuntimeState.ACTIVE -> RuntimePresentation(
        label = "运行正常",
        detail = "模块已在系统多窗口中生效",
        color = { MaterialTheme.colorScheme.primary },
    )
    ModuleRuntimeState.STALE -> RuntimePresentation(
        label = "需要重新打开多窗口",
        detail = "当前信息来自旧进程，重新打开后即可刷新",
        color = { MaterialTheme.colorScheme.outline },
    )
}

private fun targetVersionLabel(versionName: String?, versionCode: Long?): String = when {
    versionName != null && versionCode != null -> "$versionName ($versionCode)"
    versionName != null -> versionName
    versionCode != null -> versionCode.toString()
    else -> "未读取"
}

private fun readinessLabel(readiness: CompatibilityReadiness): String = when (readiness) {
    CompatibilityReadiness.READY -> "已验证"
    CompatibilityReadiness.PARTIAL -> "部分验证"
    CompatibilityReadiness.UNAVAILABLE -> "未识别"
    CompatibilityReadiness.UNVERIFIED -> "未验证"
}
