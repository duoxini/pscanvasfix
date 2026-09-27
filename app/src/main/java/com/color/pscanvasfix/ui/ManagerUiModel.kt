package com.color.pscanvasfix.ui

import com.color.pscanvasfix.diagnostic.CompatibilityReadiness
import com.color.pscanvasfix.diagnostic.ModuleRuntimeState
import java.io.Closeable

enum class FeatureAvailability {
    AVAILABLE,
    UNAVAILABLE,
    UNVERIFIED,
}

data class FeatureToggleUiState(
    val preferenceEnabled: Boolean = false,
    val effectiveEnabled: Boolean = false,
    val availability: FeatureAvailability = FeatureAvailability.UNVERIFIED,
    val preferenceWritable: Boolean = false,
    val availableSummary: String,
    val unavailableSummary: String,
) {
    init {
        require(!effectiveEnabled || preferenceEnabled) {
            "An effective feature must also be enabled in preferences"
        }
        require(!effectiveEnabled || availability == FeatureAvailability.AVAILABLE) {
            "An effective feature must have an available capability"
        }
    }

    val switchEnabled: Boolean
        get() = preferenceWritable && availability == FeatureAvailability.AVAILABLE

    val checked: Boolean
        get() = effectiveEnabled

    val summary: String
        get() = if (availability == FeatureAvailability.AVAILABLE) {
            availableSummary
        } else {
            unavailableSummary
        }
}

data class ManagerUiState(
    val runtimeState: ModuleRuntimeState,
    val runtimeDetail: String? = null,
    val targetVersionName: String? = null,
    val targetVersionCode: Long? = null,
    val compatibilityReadiness: CompatibilityReadiness = CompatibilityReadiness.UNVERIFIED,
    val compatibilityDetail: String = "能力尚未验证",
    val adjustableWindowSize: FeatureToggleUiState = FeatureToggleUiState(
        availableSummary = "拖动分割条调整相邻窗口",
        unavailableSummary = "缺少相邻窗口 Resize 能力",
    ),
    val fourTaskCanvas: FeatureToggleUiState = FeatureToggleUiState(
        availableSummary = "四任务产品方向已归档",
        unavailableSummary = "四任务产品实现已停止",
    ),
    val diagnosticsAvailable: Boolean = true,
    val compatibilityReportAvailable: Boolean = false,
)

/**
 * Host boundary for wiring Remote Preferences and the libxposed service into the Compose page.
 * UI code never reads local or remote preferences directly.
 */
interface ManagerUiCoordinator {
    fun currentState(): ManagerUiState

    fun observe(observer: (ManagerUiState) -> Unit): Closeable

    fun setAdjustableWindowSize(enabled: Boolean)

    fun setFourTaskCanvas(enabled: Boolean)

    fun diagnosticsText(): String

    fun openCompatibilityReport()
}

/** Implement this on the Application when the service-backed coordinator is ready. */
interface ManagerUiCoordinatorOwner {
    val managerUiCoordinator: ManagerUiCoordinator
}
