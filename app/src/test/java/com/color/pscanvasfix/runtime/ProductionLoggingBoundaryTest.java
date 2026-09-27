package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Keeps framework-specific logging calls inside their owned sink backends. */
public final class ProductionLoggingBoundaryTest {
    private static final String MODERN_XPOSED_SINK =
            "com/color/pscanvasfix/runtime/ModernXposedLogSink.java";
    private static final String ANDROID_LOG_SINK =
            "com/color/pscanvasfix/runtime/AndroidLogSink.java";
    private static final Pattern MODERN_XPOSED_LOG =
            Pattern.compile("attached\\.log\\s*\\(");
    private static final Pattern LEGACY_XPOSED_API =
            Pattern.compile("de\\.robv\\.android\\.xposed|XposedBridge\\.log\\s*\\(");
    private static final Pattern ANDROID_LOG = Pattern.compile(
            "(?:android\\.util\\.)?\\bLog\\.(?:v|d|i|w|e|wtf)\\s*\\(");

    @Test
    public void directProductionLoggingIsOwnedBySinkBackends() throws IOException {
        Path sourceRoot = productionSourceRoot();
        List<String> offenders = new ArrayList<>();
        int modernSinkCalls = 0;
        int androidSinkCalls = 0;
        int legacyApiCalls = 0;

        try (Stream<Path> paths = Files.walk(sourceRoot)) {
            Iterable<Path> javaFiles = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))::iterator;
            for (Path javaFile : javaFiles) {
                String relative = sourceRoot.relativize(javaFile)
                        .toString().replace('\\', '/');
                String source = new String(
                        Files.readAllBytes(javaFile), StandardCharsets.UTF_8);
                int modernXposedCalls = occurrences(MODERN_XPOSED_LOG, source);
                int legacyCalls = occurrences(LEGACY_XPOSED_API, source);
                int androidCalls = occurrences(ANDROID_LOG, source);

                if (modernXposedCalls > 0) {
                    if (MODERN_XPOSED_SINK.equals(relative)) {
                        modernSinkCalls += modernXposedCalls;
                    } else {
                        offenders.add(relative + " has " + modernXposedCalls
                                + " direct modern Xposed log call(s)");
                    }
                }
                legacyApiCalls += legacyCalls;
                if (androidCalls > 0) {
                    if (ANDROID_LOG_SINK.equals(relative)) {
                        androidSinkCalls += androidCalls;
                    } else {
                        offenders.add(relative + " has " + androidCalls
                                + " direct android.util.Log call(s)");
                    }
                }
            }
        }

        assertTrue("Direct logging escaped owned sinks: " + offenders,
                offenders.isEmpty());
        assertEquals(2, modernSinkCalls);
        assertEquals(0, legacyApiCalls);
        assertEquals(4, androidSinkCalls);
    }

    private static Path productionSourceRoot() {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path sourceRoot = root.resolve("app/src/main/java");
        if (!Files.isDirectory(sourceRoot)) {
            sourceRoot = root.resolve("src/main/java");
        }
        assertTrue("Production Java source root missing: " + sourceRoot,
                Files.isDirectory(sourceRoot));
        return sourceRoot;
    }

    private static int occurrences(Pattern pattern, String source) {
        int count = 0;
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
