package com.color.pscanvasfix.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.color.pscanvasfix.R
import com.color.pscanvasfix.diagnostic.CompatibilityReadiness
import com.color.pscanvasfix.diagnostic.ModuleRuntimeState

private val ContentMaxWidth = 1120.dp
private val WideLayoutBreakpoint = 960.dp
private val PanelShape = RoundedCornerShape(24.dp)
private val InnerPanelShape = RoundedCornerShape(18.dp)
private val PanelGap = 16.dp
private val PanelContentPadding = 20.dp
private val StatusIconContainerSize = 38.dp
private val StatusLineMinHeight = 58.dp
private val ActiveStatusGreen = Color(0xFF36B96D)
private val BuiltInEnhancementsContainer = Color(0xFFF4F5F7)
private val BuiltInEnhancementsInner = Color(0xFFFCFCFD)
private val FooterLineWidth = 56.dp
private val StatusChevronSize = 20.dp
private val StatusCardGradient = listOf(
    Color(0xFFF3F7FF),
    Color(0xFFF6F2FF),
    Color(0xFFEEF4FF),
)

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
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing),
        ) {
            val wideLayout = maxWidth >= WideLayoutBreakpoint
            val pagePadding = if (wideLayout) 28.dp else 16.dp

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .widthIn(max = ContentMaxWidth)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = pagePadding, vertical = 20.dp),
            ) {
                ManagerHeader()
                Spacer(Modifier.height(24.dp))

                if (wideLayout) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        horizontalArrangement = Arrangement.spacedBy(PanelGap),
                        verticalAlignment = Alignment.Top,
                    ) {
                        ModuleStatusCard(
                            state = state,
                            modifier = Modifier
                                .weight(1.08f)
                                .fillMaxHeight(),
                        )
                        Column(
                            modifier = Modifier.weight(0.92f),
                            verticalArrangement = Arrangement.spacedBy(PanelGap),
                        ) {
                            FeatureCard(
                                state = state.adjustableWindowSize,
                                onCheckedChange = onAdjustableWindowSizeChange,
                            )
                            BasicInfoCard(
                                enabled = state.diagnosticsAvailable,
                                onCopy = onCopyDiagnostics,
                            )
                        }
                    }
                } else {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(PanelGap),
                    ) {
                        ModuleStatusCard(state = state)
                        FeatureCard(
                            state = state.adjustableWindowSize,
                            onCheckedChange = onAdjustableWindowSizeChange,
                        )
                        BasicInfoCard(
                            enabled = state.diagnosticsAvailable,
                            onCopy = onCopyDiagnostics,
                        )
                    }
                }

                FooterHint()
            }
        }
    }
}

@Composable
private fun ManagerHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.ps_canvas_icon_foreground_art),
            contentDescription = null,
            modifier = Modifier.size(68.dp),
        )
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                text = "PsCanvas Classic",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "经典分屏画布增强",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun ModuleStatusCard(
    state: ManagerUiState,
    modifier: Modifier = Modifier,
) {
    val presentation = runtimePresentation(state.runtimeState)
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = PanelShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.42f),
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(StatusCardGradient))
                .padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    SectionHeader(
                        icon = ImageVector.vectorResource(R.drawable.ic_manager_status_layers),
                        title = "模块状态",
                        iconContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        iconColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Surface(
                            modifier = Modifier.size(11.dp),
                            shape = CircleShape,
                            color = presentation.color(),
                            content = {},
                        )
                        Text(
                            text = presentation.label,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Text(
                        text = state.runtimeDetail ?: presentation.detail,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 4.dp),
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.64f),
            )

            StatusLine(
                icon = ImageVector.vectorResource(R.drawable.ic_manager_target_component),
                label = "系统组件",
                value = "com.oplus.pscanvas",
            )
            StatusLine(
                icon = ImageVector.vectorResource(R.drawable.ic_manager_target_version),
                label = "组件版本",
                value = targetVersionLabel(state.targetVersionName, state.targetVersionCode),
            )
            StatusLine(
                icon = Icons.Rounded.DateRange,
                label = "版本日期",
                value = state.targetVersionDate ?: "未识别",
            )
            VerificationStatusLine(state.compatibilityReadiness)

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 4.dp),
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.64f),
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
private fun StatusLine(
    icon: ImageVector,
    label: String,
    value: String,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = InnerPanelShape,
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.78f),
    ) {
        Row(
            modifier = Modifier
                .heightIn(min = StatusLineMinHeight)
                .padding(horizontal = 14.dp, vertical = 9.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            StatusIconContainer(
                icon = icon,
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.42f),
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                text = label,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Box(
                modifier = Modifier.weight(1.6f),
                contentAlignment = Alignment.CenterEnd,
            ) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_manager_chevron_right),
                contentDescription = null,
                modifier = Modifier.size(StatusChevronSize),
                tint = MaterialTheme.colorScheme.outline,
            )
        }
    }
}

@Composable
private fun VerificationStatusLine(readiness: CompatibilityReadiness) {
    val chipColors = verificationChipColors(readiness)
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = InnerPanelShape,
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.78f),
    ) {
        Row(
            modifier = Modifier
                .heightIn(min = StatusLineMinHeight)
                .padding(horizontal = 14.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            VerificationIconContainer(readiness)
            Text(
                text = "验证状态",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Box(
                modifier = Modifier.weight(1.6f),
                contentAlignment = Alignment.CenterEnd,
            ) {
                Surface(
                    shape = CircleShape,
                    color = chipColors.container,
                    contentColor = chipColors.content,
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        if (readiness == CompatibilityReadiness.READY) {
                            Surface(
                                modifier = Modifier.size(22.dp),
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary,
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = null,
                                    modifier = Modifier.padding(4.dp),
                                )
                            }
                        }
                        Text(
                            text = readinessLabel(readiness),
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun VerificationIconContainer(readiness: CompatibilityReadiness) {
    val verified = readiness == CompatibilityReadiness.READY
    val chipColors = verificationChipColors(readiness)
    Surface(
        modifier = Modifier.size(StatusIconContainerSize),
        shape = RoundedCornerShape(12.dp),
        color = if (verified) {
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.52f)
        } else {
            chipColors.container.copy(alpha = 0.62f)
        },
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (verified) {
                Icon(
                    painter = painterResource(R.drawable.ic_manager_verification_ready),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified,
                )
            } else {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_manager_verification),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = chipColors.content,
                )
            }
        }
    }
}

@Composable
private fun StatusIconContainer(
    icon: ImageVector,
    containerColor: Color,
    contentColor: Color,
) {
    Surface(
        modifier = Modifier.size(StatusIconContainerSize),
        shape = RoundedCornerShape(12.dp),
        color = containerColor,
        contentColor = contentColor,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(9.dp),
        )
    }
}

@Composable
private fun FeatureCard(
    state: FeatureToggleUiState,
    onCheckedChange: (Boolean) -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = PanelShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.42f),
        ),
    ) {
        Column(modifier = Modifier.padding(PanelContentPadding)) {
            SectionHeader(
                icon = ImageVector.vectorResource(R.drawable.ic_manager_feature_tune),
                title = "增强功能",
                iconContainerColor = MaterialTheme.colorScheme.primaryContainer,
                iconColor = MaterialTheme.colorScheme.primary,
            )
            Spacer(Modifier.height(16.dp))
            Surface(
                shape = InnerPanelShape,
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.42f),
            ) {
                FeatureToggleRow(
                    title = "调整分屏窗口大小",
                    state = state,
                    onCheckedChange = onCheckedChange,
                )
            }
            Spacer(Modifier.height(16.dp))
            BuiltInEnhancements()
        }
    }
}

@Composable
private fun BuiltInEnhancements() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = InnerPanelShape,
        color = BuiltInEnhancementsContainer,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp),
        ) {
            Text(
                text = "默认增强",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "兼容目标上自动启用，无需单独设置",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                color = BuiltInEnhancementsInner,
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    BuiltInEnhancementLine("经典三分屏宽画布与边界修复")
                    BuiltInEnhancementLine("二、三分屏捏合进入全景")
                    BuiltInEnhancementLine("全景外扩退出与单击保护")
                }
            }
        }
    }
}

@Composable
private fun BuiltInEnhancementLine(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Icon(
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Composable
private fun FeatureToggleRow(
    title: String,
    state: FeatureToggleUiState,
    onCheckedChange: (Boolean) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 88.dp)
            .toggleable(
                value = state.checked,
                enabled = state.switchEnabled,
                role = Role.Switch,
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onValueChange = onCheckedChange,
            )
            .padding(horizontal = 18.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .alpha(if (state.switchEnabled) 1f else 0.64f),
            verticalArrangement = Arrangement.spacedBy(3.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = state.summary,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        PsCanvasExpressiveSwitch(
            checked = state.checked,
            onCheckedChange = null,
            enabled = state.switchEnabled,
            interactionSource = interactionSource,
            modifier = Modifier.clearAndSetSemantics { },
        )
    }
}

@Composable
private fun BasicInfoCard(
    enabled: Boolean,
    onCopy: () -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = PanelShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.42f),
        ),
    ) {
        Column(modifier = Modifier.padding(PanelContentPadding)) {
            SectionHeader(
                icon = ImageVector.vectorResource(R.drawable.ic_manager_basic_info),
                title = "基础信息",
                iconContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                iconColor = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "复制模块与系统组件信息，便于排查兼容问题",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Spacer(Modifier.height(14.dp))
            Button(
                onClick = onCopy,
                enabled = enabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                shape = InnerPanelShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_manager_copy),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    text = "复制基础信息",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}

@Composable
private fun SectionHeader(
    icon: ImageVector,
    title: String,
    iconContainerColor: Color,
    iconColor: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Surface(
            shape = CircleShape,
            color = iconContainerColor.copy(alpha = 0.72f),
            contentColor = iconColor,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(10.dp).size(24.dp),
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun FooterHint() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HorizontalDivider(
            modifier = Modifier.width(FooterLineWidth),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.size(12.dp))
        Icon(
            imageVector = Icons.Rounded.Info,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = MaterialTheme.colorScheme.outline,
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = "模块启用后，打开分屏即可生效",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(Modifier.size(12.dp))
        HorizontalDivider(
            modifier = Modifier.width(FooterLineWidth),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
    }
}

private data class RuntimePresentation(
    val label: String,
    val detail: String,
    val color: @Composable () -> Color,
)

private data class VerificationChipColors(
    val container: Color,
    val content: Color,
)

@Composable
private fun verificationChipColors(readiness: CompatibilityReadiness): VerificationChipColors =
    when (readiness) {
        CompatibilityReadiness.READY -> VerificationChipColors(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer,
        )
        CompatibilityReadiness.PARTIAL -> VerificationChipColors(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer,
        )
        CompatibilityReadiness.UNAVAILABLE -> VerificationChipColors(
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer,
        )
        CompatibilityReadiness.UNVERIFIED -> VerificationChipColors(
            MaterialTheme.colorScheme.surfaceContainerHighest,
            MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }

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
        color = { ActiveStatusGreen },
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
