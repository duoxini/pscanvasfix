package com.color.pscanvasfix.diagnostic;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class DiagnosticsFormatterTest {
    @Test
    public void format_isStableSortedAndSingleLineSafe() {
        DiagnosticsSnapshot snapshot = new DiagnosticsSnapshot(
                "com.color.pscanvasfix",
                "1.4",
                ModuleRuntimeState.ACTIVE,
                "com.oplus.pscanvas",
                "2.0.0",
                20L,
                CompatibilityReadiness.PARTIAL,
                List.of(
                        new CapabilityDiagnostic(
                                "wm commit",
                                DiagnosticCapabilityState.UNVERIFIED,
                                "line1\nline2"),
                        new CapabilityDiagnostic(
                                "append_task",
                                DiagnosticCapabilityState.AVAILABLE,
                                "")),
                List.of(
                        new FeatureDiagnostic(
                                "four_task_canvas",
                                false,
                                false,
                                DiagnosticFeatureState.UNVERIFIED),
                        new FeatureDiagnostic(
                                "adjustable_window_size",
                                true,
                                false,
                                DiagnosticFeatureState.DISABLED_CAPABILITY_MISSING)));

        String expected = String.join("\n",
                "PsCanvas Classic diagnostics",
                "schema=1",
                "module.package=com.color.pscanvasfix",
                "module.version=1.4",
                "runtime.state=ACTIVE",
                "target.package=com.oplus.pscanvas",
                "target.version=2.0.0",
                "target.versionCode=20",
                "compatibility=PARTIAL",
                "feature.adjustable_window_size.preference=true",
                "feature.adjustable_window_size.effective=false",
                "feature.adjustable_window_size.state=DISABLED_CAPABILITY_MISSING",
                "feature.four_task_canvas.preference=false",
                "feature.four_task_canvas.effective=false",
                "feature.four_task_canvas.state=UNVERIFIED",
                "capability.append_task=AVAILABLE",
                "capability.wm_commit=UNVERIFIED|line1\\nline2");

        assertEquals(expected, DiagnosticsFormatter.format(snapshot));
        assertEquals(expected, DiagnosticsFormatter.format(snapshot));
    }
}
