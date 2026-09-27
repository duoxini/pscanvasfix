package com.color.pscanvasfix.module

import android.content.pm.PackageManager
import com.color.pscanvasfix.BuildConfig
import com.color.pscanvasfix.config.ModulePreferences
import com.color.pscanvasfix.core.CapabilitySet
import com.color.pscanvasfix.core.FeatureManager
import com.color.pscanvasfix.diagnostic.CompatibilityReadiness
import com.color.pscanvasfix.diagnostic.DiagnosticsFormatter
import com.color.pscanvasfix.diagnostic.DiagnosticsSnapshot
import com.color.pscanvasfix.diagnostic.ModuleRuntimeState
import com.color.pscanvasfix.hook.ApkFingerprint
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

    @Suppress("DEPRECATION")
    private val targetIdentity: TargetIdentity? by lazy(LazyThreadSafetyMode.PUBLICATION) {
        readTargetIdentity()
    }

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
        val target = targetIdentity
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
        val verifiedVersionDates = ApkFingerprint.verifiedVersionDates()

        val readiness = when {
            target == null -> CompatibilityReadiness.UNAVAILABLE
            target.versionDate in verifiedVersionDates -> CompatibilityReadiness.READY
            else -> CompatibilityReadiness.UNVERIFIED
        }
        return ManagerUiState(
            runtimeState = runtime.state,
            runtimeDetail = runtime.detail,
            targetVersionName = target?.versionName,
            targetVersionCode = target?.versionCode,
            targetVersionDate = target?.versionDate,
            verifiedVersionDates = verifiedVersionDates,
            compatibilityReadiness = readiness,
            compatibilityDetail = when (readiness) {
                CompatibilityReadiness.READY -> "当前版本已验证，功能仍按组件结构自动适配"
                CompatibilityReadiness.UNAVAILABLE -> "未找到系统多窗口组件"
                else -> "未列入验证记录，功能仍会自动检测"
            },
            adjustableWindowSize = featureState(
                preferenceEnabled = snapshot.adjustableWindowSizeEnabled(),
                status = manager.status(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE),
                capability = capabilities.adjustableWindowSize(),
                availableSummary = "支持二、三分屏调整，并记住已保存的窗口布局",
                unavailableSummary = "当前版本暂不支持窗口布局记忆",
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
                    "系统多窗口尚未运行，设置会在下次打开时生效",
                )
                target.loadedVersionCode == BuildConfig.VERSION_CODE.toLong() -> RuntimeResult(
                    ModuleRuntimeState.ACTIVE,
                    "模块已在系统多窗口中生效",
                )
                else -> RuntimeResult(
                    ModuleRuntimeState.STALE,
                    "系统多窗口仍在使用旧版模块，请重新打开",
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
    private fun readTargetIdentity(): TargetIdentity? = runCatching {
        val info = application.packageManager.getPackageInfo(
            TARGET_PACKAGE,
            PackageManager.GET_META_DATA,
        )
        val manifestVersionDate = info.applicationInfo?.metaData
            ?.getInt(VERSION_DATE_META_DATA, -1)
            ?.takeIf { it > 0 }
            ?.toString()
        TargetIdentity(
            info.versionName,
            info.longVersionCode,
            manifestVersionDate ?: ApkFingerprint.collect(info.applicationInfo?.sourceDir)
                .versionDate(),
        )
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
        return DiagnosticsSnapshot(
            moduleVersionName = BuildConfig.VERSION_NAME,
            runtimeState = ui.runtimeState,
            targetVersionName = ui.targetVersionName,
            targetVersionCode = ui.targetVersionCode,
            targetVersionDate = ui.targetVersionDate,
            compatibilityReadiness = ui.compatibilityReadiness,
        )
    }

    private data class RuntimeResult(
        val state: ModuleRuntimeState,
        val detail: String,
    )

    private data class TargetIdentity(
        val versionName: String?,
        val versionCode: Long,
        val versionDate: String?,
    )

    private companion object {
        const val TARGET_PACKAGE = "com.oplus.pscanvas"
        const val VERSION_DATE_META_DATA = "versionDate"
    }
}
