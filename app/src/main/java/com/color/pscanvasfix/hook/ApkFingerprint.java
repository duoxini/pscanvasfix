package com.color.pscanvasfix.hook;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;

/** Computes a content identity for the installed target APK. */
public final class ApkFingerprint {
    private ApkFingerprint() {
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
