package com.color.pscanvasfix;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Source contract for the behavior-named feature boundary introduced in Gate M3. */
public final class PsCanvasFeatureBoundaryContractTest {
    private static final List<String> REQUIRED_FEATURE_CLASSES = Arrays.asList(
            "ClassicLayoutFeature",
            "PanoramaFeature",
            "TwoTaskPanoramaFeature",
            "PinchGestureFeature",
            "SplitBarFeature",
            "ClassicCanvasController"
    );

    private static final String[] STABLE_HOOK_IDS = {
            "pinch.lifecycle.init.trace",
            "pinch.lifecycle.scale_end.trace",
            "pinch.lifecycle.animation_start.trace",
            "panorama.launch_while_active.block",
            "pinch.scale.panorama_dispatch",
            "transition.intent_list.patch_ids",
            "transition.launch_bounds.fix_bundle",
            "transition.mask_rect.fix",
            "touch_anim.reset_all.block",
            "touch_anim.scale_down_start.block",
            "touch_anim.need_anim_check.block",
            "touch_anim.control_bar_long_press.block",
            "touch_anim.initial_drag.guard",
            "touch_drag.pointer_down.block",
            "touch_drag.pointer_move.block",
            "touch_drag.pointer_up.block",
            "touch_drag.initialize.block",
            "controller.disable_three_together_flag",
            "panorama.exit.direction_guard",
            "bounds.single.restore_502",
            "bounds.multi.restore_502",
            "layout.three.equal_width_canvas",
            "entry.direct_three.on_create",
            "entry.two_to_three.anchor_mark",
            "entry.two_to_three.anchor_redirect",
            "splitbar.resizable_rect_update.block",
            "splitbar.three_split_scroll_start.block",
            "splitbar.three_split_enlarge.block",
            "splitbar.spring_drag_handler.block",
            "splitbar.spring_animation_init.block"
    };

    private static final Pattern GENERATION_NAMED_TYPE = Pattern.compile(
            "\\b(?:class|interface|enum)\\s+[A-Za-z_$][\\w$]*(?:260608|502)[\\w$]*");
    private static final Pattern GENERATION_NAMED_METHOD = Pattern.compile(
            "(?m)^\\s*(?:(?:public|protected|private|static|final|synchronized|native|abstract|default|strictfp)\\s+)*"
                    + "(?:<[^>\\r\\n]+>\\s+)?[A-Za-z_$][\\w$<>\\[\\], ?.@]*\\s+"
                    + "[A-Za-z_$][\\w$]*(?:260608|502)[\\w$]*\\s*\\(");

    @Test
    public void definesAllFiveBehaviorNamedFeatureClasses() throws IOException {
        Path featureRoot = productionRoot().resolve("feature");

        for (String className : REQUIRED_FEATURE_CLASSES) {
            Path sourceFile = featureRoot.resolve(className + ".java");
            assertTrue("Missing Gate M3 feature source: " + sourceFile,
                    Files.isRegularFile(sourceFile));
            String source = read(sourceFile);
            assertTrue("Missing behavior-named type declaration: " + className,
                    Pattern.compile("\\bclass\\s+" + className + "\\b")
                            .matcher(source).find());
        }
    }

    @Test
    public void preservesGlobalHookRegistrationAndOriginTotals() throws IOException {
        String production = aggregateJavaSources(productionRoot());
        String diagnosticTrace = read(productionRoot().resolve("feature")
                .resolve("FourTaskTraceFeature.java"));
        String stableProduction = production.replace(diagnosticTrace, "");

        assertEquals(35, occurrences(stableProduction, "hookRuntime.findAndHookMethod("));
        assertEquals(1, occurrences(stableProduction, "hookRuntime.findAndHookConstructor("));
        assertEquals(16, occurrences(stableProduction, "hookRuntime.invokeOriginalMethod("));
        assertEquals(30, occurrences(stableProduction, "hookRegistry.declare("));

        assertEquals(10, occurrences(diagnosticTrace, "hookRuntime.findAndHookMethod("));
        assertEquals(0, occurrences(diagnosticTrace, "hookRuntime.findAndHookConstructor("));
        assertEquals(0, occurrences(diagnosticTrace, "hookRuntime.invokeOriginalMethod("));
        assertEquals(10, occurrences(diagnosticTrace, "hookRegistry.declare("));
    }

    @Test
    public void keepsAllThirtyStableHookIdsUnique() throws IOException {
        String production = aggregateJavaSources(productionRoot());
        Set<String> uniqueIds = new HashSet<>(Arrays.asList(STABLE_HOOK_IDS));

        assertEquals("The expected hook-id fixture itself must stay duplicate-free",
                30, uniqueIds.size());
        for (String stableId : STABLE_HOOK_IDS) {
            assertEquals("Stable hook ID must have one production declaration: " + stableId,
                    1, occurrences(production, "\"" + stableId + "\""));
        }
    }

    @Test
    public void featurePackageStaysBehindProjectOwnedBoundaries() throws IOException {
        Path featureRoot = productionRoot().resolve("feature");
        String features = aggregateJavaSources(featureRoot);

        assertFalse("Feature sources must not import the libxposed API directly",
                features.contains("import io.github.libxposed.api"));
        assertFalse("Feature type names must describe behavior, not an internal generation",
                GENERATION_NAMED_TYPE.matcher(features).find());
        assertFalse("Feature method names must describe behavior, not an internal generation",
                GENERATION_NAMED_METHOD.matcher(features).find());
        String twoTask = read(featureRoot.resolve("TwoTaskPanoramaFeature.java"));
        assertFalse("Two-task Panorama must stay exact-two, never a broad >= 2 gate",
                twoTask.contains(">= 2"));
    }

    private static Path productionRoot() {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path production = root.resolve("app/src/main/java/com/color/pscanvasfix");
        if (!Files.isDirectory(production)) {
            production = root.resolve("src/main/java/com/color/pscanvasfix");
        }
        return production;
    }

    private static String aggregateJavaSources(Path root) throws IOException {
        if (!Files.isDirectory(root)) {
            return "";
        }
        List<Path> sources;
        try (Stream<Path> paths = Files.walk(root)) {
            sources = paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".java"))
                    .sorted()
                    .collect(Collectors.toList());
        }
        StringBuilder aggregate = new StringBuilder();
        for (Path source : sources) {
            aggregate.append('\n').append(read(source));
        }
        return aggregate.toString();
    }

    private static String read(Path source) throws IOException {
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8)
                .replace("\r\n", "\n");
    }

    private static int occurrences(String text, String token) {
        int count = 0;
        int offset = 0;
        while ((offset = text.indexOf(token, offset)) >= 0) {
            count++;
            offset += token.length();
        }
        return count;
    }
}
