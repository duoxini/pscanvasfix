package com.color.pscanvasfix.hook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class ApkFingerprintTest {

    @Test
    public void identifies251215As502Baseline() {
        ApkFingerprint.ApkInfo info = ApkFingerprint.collect(null);
        assertEquals("unknown", info.generation());
    }

    @Test
    public void mapsKnownGenerationsBySha() {
        assertEquals("251215 (502 baseline)",
                ApkFingerprint.generationOf(
                        "dee059ce93b7831610f3fd03247e652f215f42ec2057eed077d8a54c60ea0e8d"));
        assertEquals("260403 (target)",
                ApkFingerprint.generationOf(
                        "f8a0db044db291c42a7a5cdebcade06bc2daa7cb7a1e7f32438679106d0cc10e"));
        assertEquals("260512 (target)",
                ApkFingerprint.generationOf(
                        "f06b0a0011f21b90cbed3bd68e5c803f1b728a7fcd72c8102b0477f10b2f9d2e"));
        assertEquals("260608 (target)",
                ApkFingerprint.generationOf(
                        "1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3"));
        assertEquals("unknown", ApkFingerprint.generationOf("deadbeef"));
    }
}
