package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.ApkFingerprint.ApkInfo;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Candidate;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Source;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Structured, header-only capability report.
 *
 * <p>Renders a single plain-text block (APK identity -> per-role
 * score/status/source -> per-capability ENABLED / DISABLED / SKIPPED) that can be
 * pasted straight into adb logcat (or a unit-test assertion). Because it is pure
 * JDK, the same renderer is used offline by the JVM test and at runtime by the
 * Xposed install path.</p>
 */
public final class CapabilityReport {
    private CapabilityReport() {
    }

    public static String render(ApkInfo apkInfo, int dexClassCount, PsCanvasSymbols symbols) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("PsCanvasFix capability report").append('\n');
        if (apkInfo != null) {
            sb.append("  apk: ").append(apkInfo.apkPath).append('\n');
            sb.append("  sha256=").append(apkInfo.sha256).append(" size=")
                    .append(apkInfo.sizeBytes).append('\n');
        }
        sb.append("  dexClasses=").append(dexClassCount).append('\n');
        sb.append("  roles:").append('\n');
        for (RoleSymbol symbol : symbols.all()) {
            appendRole(sb, symbol);
        }
        sb.append("  capabilities:").append('\n');
        appendCapability(sb, "sstoFlexible",
                symbols.role(Role.SSTO_FLEXIBLE).available());
        appendCapability(sb, "threeSplitAnim",
                symbols.role(Role.THREE_SPLIT_ANIM).available());
        appendCapability(sb, "threeSplitDrag",
                symbols.role(Role.THREE_SPLIT_DRAG).available());
        appendCapability(sb, "canvasController",
                symbols.role(Role.CANVAS_CONTROLLER).available());
        return sb.toString();
    }

    private static void appendRole(StringBuilder sb, RoleSymbol symbol) {
        sb.append("    ").append(symbol.role).append(" status=").append(symbol.status)
                .append(" source=").append(symbol.source);
        if (symbol.source == Source.KNOWN_SYMBOL || symbol.status == Status.FALLBACK) {
            sb.append(" fallback=true");
        }
        sb.append(" score=").append(symbol.score);
        if (symbol.className != null) {
            sb.append(" class=").append(symbol.className);
        }
        sb.append('\n');
        if (symbol.scaleMethod != null) {
            sb.append("      scale=").append(symbol.scaleMethod).append('\n');
        }
        if (symbol.intentListMethod != null) {
            sb.append("      intentList=").append(symbol.intentListMethod).append('\n');
        }
        if (symbol.launchBoundsMethod != null) {
            sb.append("      launchBounds=").append(symbol.launchBoundsMethod).append('\n');
        }
        if (symbol.maskAnimMethod != null) {
            sb.append("      maskAnim=").append(symbol.maskAnimMethod).append('\n');
        }
        for (Candidate candidate : symbol.candidates) {
            sb.append("      candidate ").append(candidate.className)
                    .append(" score=").append(candidate.score)
                    .append(" hints=").append(candidate.hints).append('\n');
        }
    }

    private static void appendCapability(StringBuilder sb, String name, boolean enabled) {
        sb.append("    ").append(name).append("=")
                .append(enabled ? "ENABLED" : "DISABLED/SKIPPED").append('\n');
    }

    /** Convenience: top-level {@code ENABLED} capabilities from a resolved set. */
    public static List<String> enabled(PsCanvasSymbols symbols) {
        return new ArrayList<>(symbols.enabledCapabilities());
    }
}
