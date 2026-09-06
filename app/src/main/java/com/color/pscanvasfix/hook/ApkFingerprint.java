package com.color.pscanvasfix.hook;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Content identity for the installed target APK.
 *
 * <p>After the compatibility refactor the SHA-256 is <strong>diagnostics only</strong>:
 * it is logged (and available for bug reports) but never gates hook installation.
 * {@link ApkInfo} carries the few fields the capability report wants to print;
 * {@code versionName}/{@code versionCode} are intentionally not parsed here because
 * every analysed build reports {@code 2.0.0 / 20} and therefore cannot distinguish
 * a build — the DEX structure is what identifies it.</p>
 *
 * <p>Generation role table (diagnostics only, never gates):</p>
 * <ul>
 *   <li>{@code 251215} = <strong>502 original baseline</strong>. This build is the
 *       reference: correct two/three-split and panorama behavior, no letterboxing.
 *       The module resolves no adapt-capabilities in it and installs nothing.</li>
 *   <li>{@code 260403 / 260512 / 260608} and any newer build = <strong>target
 *       generations</strong>: they need adaptation, whose goal is to reproduce the
 *       251215 baseline behavior.</li>
 * </ul>
 */
public final class ApkFingerprint {
    private ApkFingerprint() {
    }

    /** Known target-APK generations by SHA-256. New builds are appended here. */
    private static final Map<String, String> KNOWN_GENERATION_BY_SHA = createGenerationTable();

    private static Map<String, String> createGenerationTable() {
        Map<String, String> table = new HashMap<>();
        // 502 original baseline: reference behavior for every newer generation.
        table.put("dee059ce93b7831610f3fd03247e652f215f42ec2057eed077d8a54c60ea0e8d",
                "251215 (502 baseline)");
        // Target generations needing adaptation (ordered by release date).
        table.put("f8a0db044db291c42a7a5cdebcade06bc2daa7cb7a1e7f32438679106d0cc10e",
                "260403 (target)");
        table.put("f06b0a0011f21b90cbed3bd68e5c803f1b728a7fcd72c8102b0477f10b2f9d2e",
                "260512 (target)");
        table.put("1cbf75ee66565ba4eb2e78c360243bc97d7e13379595f94914af5b25c7a77fe3",
                "260608 (target)");
        return Collections.unmodifiableMap(table);
    }

    /** Known generation label + role for a SHA-256 hex string (diagnostics only). */
    public static String generationOf(String sha) {
        if (sha == null) {
            return "unknown";
        }
        String known = KNOWN_GENERATION_BY_SHA.get(sha.toLowerCase(Locale.ROOT));
        return known != null ? known : "unknown";
    }

    /** Diagnostic info for one installed APK. */
    public static final class ApkInfo {
        public final String apkPath;
        public final String sha256;
        public final long sizeBytes;

        public ApkInfo(String apkPath, String sha256, long sizeBytes) {
            this.apkPath = apkPath;
            this.sha256 = sha256;
            this.sizeBytes = sizeBytes;
        }

        /** Known generation label + role, or {@code unknown} when not in the table. */
        public String generation() {
            return generationOf(sha256);
        }

        public String brief() {
            return "generation=" + generation()
                    + " sha256=" + sha256 + " size=" + sizeBytes + " path=" + apkPath;
        }
    }

    /** Build diagnostic info (path + SHA + size) for the given APK. */
    public static ApkInfo collect(String apkPath) {
        if (apkPath == null) {
            return new ApkInfo(null, null, 0);
        }
        File file = new File(apkPath);
        long size = file.isFile() ? file.length() : 0;
        return new ApkInfo(apkPath, sha256(apkPath), size);
    }

    public static String sha256(String apkPath) {
        if (apkPath == null || apkPath.isEmpty()) {
            return null;
        }
        try (FileInputStream input = new FileInputStream(apkPath)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[32 * 1024];
            for (int read; (read = input.read(buffer)) != -1; ) {
                digest.update(buffer, 0, read);
            }
            StringBuilder hex = new StringBuilder(64);
            for (byte value : digest.digest()) {
                hex.append(String.format(Locale.ROOT, "%02x", value & 0xff));
            }
            return hex.toString();
        } catch (Throwable ignored) {
            return null;
        }
    }
}
