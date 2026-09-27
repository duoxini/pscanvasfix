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
        appendCapability(sb, "twoTaskPanorama",
                symbols.role(Role.PANORAMA_MANAGER).available());
        appendCapability(sb, "savedSplitLayout",
                symbols.role(Role.SAVED_SPLIT_LAYOUT).available());
        appendCapability(sb, "threeTaskResize",
                symbols.role(Role.THREE_TASK_RESIZE).available());
        appendCapability(sb, "p4TraceChain",
                symbols.role(Role.P4_TRACE_CHAIN).available());
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
        if (symbol.panoramaActiveMethod != null) {
            sb.append("      panoramaActive=").append(symbol.panoramaActiveMethod).append('\n');
        }
        if (symbol.panoramaEnterMethod != null) {
            sb.append("      panoramaEnter=").append(symbol.panoramaEnterMethod).append('\n');
        }
        if (symbol.panoramaExitMethod != null) {
            sb.append("      panoramaExit=").append(symbol.panoramaExitMethod).append('\n');
        }
        if (symbol.twoTaskPredicateMethod != null) {
            sb.append("      twoTaskPredicate=")
                    .append(symbol.twoTaskPredicateMethod).append('\n');
        }
        appendValue(sb, "savedLayout.build", symbol.savedLayoutBuildMethod);
        appendValue(sb, "savedLayout.save", symbol.savedLayoutSaveMethod);
        appendValue(sb, "savedLayout.exists", symbol.savedLayoutExistsMethod);
        appendValue(sb, "savedLayout.restoreClass", symbol.savedLayoutRestoreClass);
        appendValue(sb, "savedLayout.restore", symbol.savedLayoutRestoreMethod);
        appendValue(sb, "savedLayout.onCreate", symbol.savedLayoutActivityCreateMethod);
        appendValue(sb, "savedLayout.onNewIntent",
                symbol.savedLayoutActivityNewIntentMethod);
        appendValue(sb, "threeTaskResize.springClass",
                symbol.threeTaskResizeSpringClass);
        appendValue(sb, "threeTaskResize.rectUpdate",
                symbol.threeTaskResizeRectUpdateMethod);
        appendValue(sb, "threeTaskResize.scrollStart",
                symbol.threeTaskResizeScrollStartMethod);
        appendValue(sb, "threeTaskResize.enlarge",
                symbol.threeTaskResizeEnlargeMethod);
        appendValue(sb, "threeTaskResize.predicate",
                symbol.threeTaskResizePredicateMethod);
        appendValue(sb, "threeTaskResize.springDrag",
                symbol.threeTaskResizeSpringDragMethod);
        appendValue(sb, "threeTaskResize.springInit",
                symbol.threeTaskResizeSpringInitMethod);
        appendP4Value(sb, "taskData", symbol.p4TaskDataDescriptor);
        appendP4Value(sb, "adapterClass", symbol.p4AdapterClass);
        appendP4Value(sb, "embeddedViewDecorClass", symbol.p4EmbeddedViewDecorClass);
        appendP4Value(sb, "taskCreatedCallbackClass", symbol.p4TaskCreatedCallbackClass);
        appendP4Value(sb, "flexibleTaskViewClass", symbol.p4FlexibleTaskViewClass);
        appendP4Value(sb, "controllerAppend", symbol.p4ControllerAppendMethod);
        appendP4Value(sb, "controllerRemove", symbol.p4ControllerRemoveMethod);
        appendP4Value(sb, "controllerFocus", symbol.p4ControllerFocusMethod);
        appendP4Value(sb, "controllerTaskCount", symbol.p4ControllerTaskCountMethod);
        appendP4Value(sb, "controllerContainerField", symbol.p4ControllerContainerField);
        appendP4Value(sb, "controllerAdapterField", symbol.p4ControllerAdapterField);
        appendP4Value(sb, "containerAdapterGetter", symbol.p4ContainerAdapterGetter);
        appendP4Value(sb, "containerControllerGetter", symbol.p4ContainerControllerGetter);
        appendP4Value(sb, "containerChildrenGetter", symbol.p4ContainerChildrenGetter);
        appendP4Value(sb, "adapterAdd", symbol.p4AdapterAddMethod);
        appendP4Value(sb, "adapterCount", symbol.p4AdapterCountMethod);
        appendP4Value(sb, "embeddedBind", symbol.p4EmbeddedBindMethod);
        appendP4Value(sb, "embeddedAttached", symbol.p4EmbeddedAttachedMethod);
        appendP4Value(sb, "taskCreated", symbol.p4TaskCreatedMethod);
        appendP4Value(sb, "flexibleResize", symbol.p4FlexibleResizeMethod);
        for (Candidate candidate : symbol.candidates) {
            sb.append("      candidate ").append(candidate.className)
                    .append(" score=").append(candidate.score)
                    .append(" hints=").append(candidate.hints).append('\n');
        }
    }

    private static void appendP4Value(StringBuilder sb, String name, String value) {
        if (value != null) {
            sb.append("      p4.").append(name).append('=').append(value).append('\n');
        }
    }

    private static void appendValue(StringBuilder sb, String name, String value) {
        if (value != null) {
            sb.append("      ").append(name).append('=').append(value).append('\n');
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
