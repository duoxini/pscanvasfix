package com.color.pscanvasfix.module

import android.content.pm.PackageManager
import com.color.pscanvasfix.BuildConfig
import com.color.pscanvasfix.config.ModulePreferences
import com.color.pscanvasfix.core.CapabilitySet
import com.color.pscanvasfix.core.FeatureManager
import com.color.pscanvasfix.diagnostic.CapabilityDiagnostic
import com.color.pscanvasfix.diagnostic.CompatibilityReadiness
import com.color.pscanvasfix.diagnostic.DiagnosticCapabilityState
import com.color.pscanvasfix.diagnostic.DiagnosticFeatureState
import com.color.pscanvasfix.diagnostic.DiagnosticsFormatter
import com.color.pscanvasfix.diagnostic.DiagnosticsSnapshot
import com.color.pscanvasfix.diagnostic.FeatureDiagnostic
import com.color.pscanvasfix.diagnostic.ModuleRuntimeState
import com.color.pscanvasfix.ui.FeatureAvailability
import com.color.pscanvasfix.ui.FeatureToggleUiState
import com.color.pscanvasfix.ui.ManagerUiCoordinator
import com.color.pscanvasfix.ui.ManagerUiState
import io.github.libxposed.service.XposedService
import java.io.Closeable
import java.util.concurrent.CopyOnWriteArrayList

/** Live manager model backed only by the modern libxposed service and Remote Preferences. */
class ServiceBackedManagerCoordinator(
    private val application: PsCanvasApplication,
) : ManagerUiCoordinator {
    private val observers = CopyOnWriteArrayList<(ManagerUiState) -> Unit>()

    @Volatile
    private var state = buildState(application.currentService())

    init {
        application.addServiceListener { service ->
            state = buildState(service)
            observers.forEach { observer -> observer(state) }
        }
    }

    override fun currentState(): ManagerUiState {
        state = buildState(application.currentService())
        return state
    }

    override fun observe(observer: (ManagerUiState) -> Unit): Closeable {
        observers.add(observer)
        observer(state)
        return Closeable { observers.remove(observer) }
    }

    override fun setAdjustableWindowSize(enabled: Boolean) {
        writePreference(ModulePreferences.KEY_ADJUSTABLE_WINDOW_SIZE, enabled)
    }

    override fun setFourTaskCanvas(enabled: Boolean) {
        writePreference(ModulePreferences.KEY_FOUR_TASK_CANVAS, enabled)
    }

    override fun diagnosticsText(): String = diagnosticsSnapshot(state).let(
        DiagnosticsFormatter::format,
    )

    override fun openCompatibilityReport() = Unit

    private fun writePreference(key: String, enabled: Boolean) {
        val service = application.currentService() ?: return
        runCatching {
            service.getRemotePreferences(ModulePreferences.PREFERENCES_NAME)
                .edit()
                .putBoolean(key, enabled)
                .commit()
        }
        state = buildState(service)
        observers.forEach { observer -> observer(state) }
    }

    private fun buildState(service: XposedService?): ManagerUiState {
        val target = readTargetVersion()
        val preferences = runCatching {
            service?.getRemotePreferences(ModulePreferences.PREFERENCES_NAME)
        }.getOrNull()
        val snapshot = ModulePreferences.readSnapshot(preferences)
        val capabilities = CapabilitySet.of(
            CapabilitySet.State.READY,
            CapabilitySet.State.UNVERIFIED,
        )
        val manager = FeatureManager(snapshot, capabilities)
        val runtime = runtimeState(service)

        return ManagerUiState(
            runtimeState = runtime.state,
            runtimeDetail = runtime.detail,
            targetVersionName = target?.first,
            targetVersionCode = target?.second,
            compatibilityReadiness = CompatibilityReadiness.READY,
            compatibilityDetail = "二/三分屏 Resize、保存记忆与重复保存已验证",
            adjustableWindowSize = featureState(
                preferenceEnabled = snapshot.adjustableWindowSizeEnabled(),
                status = manager.status(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE),
                capability = capabilities.adjustableWindowSize(),
                availableSummary = "二/三分屏尺寸调整、记忆与重复保存",
                unavailableSummary = "当前目标缺少保存恢复结构能力",
                writable = preferences != null,
            ),
            fourTaskCanvas = featureState(
                preferenceEnabled = snapshot.fourTaskCanvasEnabled(),
                status = manager.status(FeatureManager.Feature.FOUR_TASK_CANVAS),
                capability = capabilities.fourTaskCanvas(),
                availableSummary = "四任务产品方向已归档",
                unavailableSummary = "四任务产品实现已停止",
                writable = preferences != null,
            ),
            compatibilityReportAvailable = false,
        )
    }

    private fun runtimeState(service: XposedService?): RuntimeResult {
        if (service == null) {
            return RuntimeResult(
                ModuleRuntimeState.SERVICE_UNAVAILABLE,
                "尚未连接到 LSPosed 模块服务",
            )
        }
        return runCatching {
            if (TARGET_PACKAGE !in service.scope) {
                return@runCatching RuntimeResult(
                    ModuleRuntimeState.TARGET_WAITING_RESTART,
                    "请在 LSPosed 中启用模块并勾选目标组件",
                )
            }
            val target = service.runningTargets.firstOrNull {
                it.processName == TARGET_PACKAGE
            }
            when {
                target == null -> RuntimeResult(
                    ModuleRuntimeState.TARGET_WAITING_RESTART,
                    "目标组件未运行，设置将在下次启动时读取",
                )
                target.loadedVersionCode == BuildConfig.VERSION_CODE.toLong() -> RuntimeResult(
                    ModuleRuntimeState.ACTIVE,
                    "当前目标进程已加载此版本模块",
                )
                else -> RuntimeResult(
                    ModuleRuntimeState.STALE,
                    "目标进程仍加载旧版模块，请重启目标组件",
                )
            }
        }.getOrElse {
            RuntimeResult(
                ModuleRuntimeState.SERVICE_UNAVAILABLE,
                "模块服务状态读取失败",
            )
        }
    }

    @Suppress("DEPRECATION")
    private fun readTargetVersion(): Pair<String?, Long>? = runCatching {
        val info = application.packageManager.getPackageInfo(TARGET_PACKAGE, 0)
        info.versionName to info.longVersionCode
    }.recoverCatching { throwable ->
        if (throwable is PackageManager.NameNotFoundException) null else throw throwable
    }.getOrNull()

    private fun featureState(
        preferenceEnabled: Boolean,
        status: FeatureManager.Status,
        capability: CapabilitySet.State,
        availableSummary: String,
        unavailableSummary: String,
        writable: Boolean,
    ): FeatureToggleUiState = FeatureToggleUiState(
        preferenceEnabled = preferenceEnabled,
        effectiveEnabled = status == FeatureManager.Status.ENABLED,
        availability = when (capability) {
            CapabilitySet.State.READY -> FeatureAvailability.AVAILABLE
            CapabilitySet.State.MISSING -> FeatureAvailability.UNAVAILABLE
            CapabilitySet.State.AMBIGUOUS,
            CapabilitySet.State.UNVERIFIED,
            -> FeatureAvailability.UNVERIFIED
        },
        preferenceWritable = writable,
        availableSummary = availableSummary,
        unavailableSummary = unavailableSummary,
    )

    private fun diagnosticsSnapshot(ui: ManagerUiState): DiagnosticsSnapshot {
        val snapshot = ModulePreferences.readSnapshot(
            runCatching {
                application.currentService()?.getRemotePreferences(
                    ModulePreferences.PREFERENCES_NAME,
                )
            }.getOrNull(),
        )
        return DiagnosticsSnapshot(
            moduleVersionName = BuildConfig.VERSION_NAME,
            runtimeState = ui.runtimeState,
            targetVersionName = ui.targetVersionName,
            targetVersionCode = ui.targetVersionCode,
            compatibilityReadiness = ui.compatibilityReadiness,
            capabilities = listOf(
                CapabilityDiagnostic(
                    "adjustable_window_size",
                    DiagnosticCapabilityState.AVAILABLE,
                    "Two-task saved-layout contract resolved across supported new fixtures",
                ),
                CapabilityDiagnostic(
                    "four_task_canvas",
                    DiagnosticCapabilityState.UNVERIFIED,
                    "Append and WM commit not verified",
                ),
            ),
            features = listOf(
                featureDiagnostic(
                    ModulePreferences.KEY_ADJUSTABLE_WINDOW_SIZE,
                    snapshot.adjustableWindowSizeEnabled(),
                    capabilityReady = true,
                ),
                featureDiagnostic(
                    ModulePreferences.KEY_FOUR_TASK_CANVAS,
                    snapshot.fourTaskCanvasEnabled(),
                    capabilityReady = false,
                ),
            ),
        )
    }

    private fun featureDiagnostic(
        key: String,
        preferenceEnabled: Boolean,
        capabilityReady: Boolean,
    ) = FeatureDiagnostic(
        key = key,
        preferenceEnabled = preferenceEnabled,
        effectiveEnabled = preferenceEnabled && capabilityReady,
        state = if (!preferenceEnabled) {
            DiagnosticFeatureState.DISABLED_BY_USER
        } else if (capabilityReady) {
            DiagnosticFeatureState.ENABLED
        } else {
            DiagnosticFeatureState.UNVERIFIED
        },
    )

    private data class RuntimeResult(
        val state: ModuleRuntimeState,
        val detail: String,
    )

    private companion object {
        const val TARGET_PACKAGE = "com.oplus.pscanvas"
    }
}
