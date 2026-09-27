package com.color.pscanvasfix.diagnostic

/** Stable, line-oriented diagnostics intended for clipboard and bug-report use. */
object DiagnosticsFormatter {
    private const val SCHEMA_VERSION = 1

    @JvmStatic
    fun format(snapshot: DiagnosticsSnapshot): String = buildString {
        appendLine("PsCanvas Classic diagnostics")
        appendLine("schema=$SCHEMA_VERSION")
        appendLine("module.package=${snapshot.modulePackage.asValue()}")
        appendLine("module.version=${snapshot.moduleVersionName.asValue()}")
        appendLine("runtime.state=${snapshot.runtimeState.name}")
        appendLine("target.package=${snapshot.targetPackage.asValue()}")
        appendLine("target.version=${snapshot.targetVersionName.asValue()}")
        appendLine("target.versionCode=${snapshot.targetVersionCode?.toString().asValue()}")
        appendLine("compatibility=${snapshot.compatibilityReadiness.name}")

        snapshot.features
            .sortedBy { it.key }
            .forEach { feature ->
                val key = feature.key.asKey()
                appendLine("feature.$key.preference=${feature.preferenceEnabled}")
                appendLine("feature.$key.effective=${feature.effectiveEnabled}")
                appendLine("feature.$key.state=${feature.state.name}")
            }

        snapshot.capabilities
            .sortedBy { it.id }
            .forEach { capability ->
                val key = capability.id.asKey()
                append("capability.$key=${capability.state.name}")
                if (capability.detail.isNotBlank()) {
                    append('|')
                    append(capability.detail.asValue())
                }
                appendLine()
            }
    }.trimEnd()

    private fun String?.asValue(): String = when {
        this == null -> "unknown"
        isEmpty() -> "unknown"
        else -> replace("\\", "\\\\")
            .replace("\r", "\\r")
            .replace("\n", "\\n")
    }

    private fun String.asKey(): String {
        val normalized = lowercase().map { character ->
            if (character.isLetterOrDigit() || character == '_' || character == '-') {
                character
            } else {
                '_'
            }
        }.joinToString(separator = "")
        return normalized.ifEmpty { "unknown" }
    }
}
