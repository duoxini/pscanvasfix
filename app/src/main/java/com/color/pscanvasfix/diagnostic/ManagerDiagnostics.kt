package com.color.pscanvasfix.diagnostic

/**
 * Runtime state reported by the modern module service.
 *
 * [ACTIVE] is reserved for a fresh report from the current target-process session. A previously
 * active report becomes [STALE] after that session is lost. [TARGET_WAITING_RESTART] means the
 * service is reachable but no current target session has loaded the latest configuration.
 */
enum class ModuleRuntimeState {
    SERVICE_UNAVAILABLE,
    TARGET_WAITING_RESTART,
    ACTIVE,
    STALE,
}

/** Verification state for the installed target build; this does not gate feature installation. */
enum class CompatibilityReadiness {
    READY,
    PARTIAL,
    UNAVAILABLE,
    UNVERIFIED,
}

enum class DiagnosticCapabilityState {
    AVAILABLE,
    MISSING,
    AMBIGUOUS,
    UNVERIFIED,
}

enum class DiagnosticFeatureState {
    ENABLED,
    DISABLED_BY_USER,
    DISABLED_CAPABILITY_MISSING,
    DISABLED_AMBIGUOUS,
    UNVERIFIED,
}

data class CapabilityDiagnostic(
    val id: String,
    val state: DiagnosticCapabilityState,
    val detail: String = "",
)

data class FeatureDiagnostic(
    val key: String,
    val preferenceEnabled: Boolean,
    val effectiveEnabled: Boolean,
    val state: DiagnosticFeatureState,
)

/**
 * Immutable input for a shareable diagnostics report.
 *
 * A timestamp is intentionally absent so identical runtime snapshots always produce identical
 * text. The caller may add capture metadata outside this formatter when a dated evidence record is
 * needed.
 */
data class DiagnosticsSnapshot(
    val modulePackage: String = "com.color.pscanvasfix",
    val moduleVersionName: String? = null,
    val runtimeState: ModuleRuntimeState,
    val targetPackage: String = "com.oplus.pscanvas",
    val targetVersionName: String? = null,
    val targetVersionCode: Long? = null,
    val targetVersionDate: String? = null,
    val compatibilityReadiness: CompatibilityReadiness,
    val capabilities: List<CapabilityDiagnostic> = emptyList(),
    val features: List<FeatureDiagnostic> = emptyList(),
)
