package com.color.pscanvasfix.hook;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;

/**
 * Content identity for the installed target APK.
 *
 * <p>After the compatibility refactor the SHA-256 is <strong>diagnostics only</strong>:
 * it is logged (and available for bug reports) but never gates hook installation.
 * {@link ApkInfo} carries the few fields the capability report wants to print;
 * {@code versionName}/{@code versionCode} are intentionally not parsed here because
 * every analysed build reports {@code 2.0.0 / 20} and therefore cannot distinguish
 * a build — the DEX structure is what identifies it.</p>
 */
public final class ApkFingerprint {
    private ApkFingerprint() {
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

        public String brief() {
            return "sha256=" + sha256 + " size=" + sizeBytes + " path=" + apkPath;
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
