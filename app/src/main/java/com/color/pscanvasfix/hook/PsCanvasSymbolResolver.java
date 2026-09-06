package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexField;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Source;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Status;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Structural symbol resolver.
 *
 * <p>Scans the target APK's DEX once (pure JDK, no Xposed) and scores every
 * in-scope obfuscated class by its method/field *signatures*. The {@code x1.* /
 * X1.* / B1.* / u1.* / com.oplus.pscanvas.canvasmode.canvas.*} scope keeps the
 * scan cheap and avoids touching unrelated system classes.</p>
 *
 * <p>Resolution is authoritative and unambiguous for {@code SSTO_FLEXIBLE}
 * (its {@code (ScaleGestureDetector,int)} + {@code (Context,ContainerView,
 * DraggableCanvasViewGroup)} signatures are stable across generations). The three
 * remaining role groups have no signature as distinctive, so they are resolved
 * primarily through the cross-generation known-symbol table and validated by
 * presence + a minimal structural check; structural scoring still runs as a
 * fallback when no known-symbol name survives.</p>
 *
 * <p>The resolver is stateless; a single-slot cache keyed by the APK path is
 * provided separately so the runtime install() scan happens once per process.</p>
 */
public final class PsCanvasSymbolResolver {

    private static final String[] SCAN_PREFIXES = {
            "x1.", "X1.", "B1.", "u1.",
            "com.oplus.pscanvas.canvasmode.canvas."
    };

    // SStoFlexible scoring (from the agreed compatibility design).
    private static final int SSTO_CTOR = 40;
    private static final int SSTO_SCALE = 25;
    private static final int SSTO_LAUNCH_BOUNDS = 20;
    private static final int SSTO_INTENT_LIST = 10;
    private static final int SSTO_CONTAINER_FIELD = 10;
    private static final int SSTO_BUNDLE_FIELD = 5;
    private static final int SSTO_THRESHOLD = 40;
    private static final int MARGIN = 8;

    // Best-effort thresholds for the (weak) structural fallback of the other roles.
    private static final int ANIM_THRESHOLD = 30;
    private static final int DRAG_THRESHOLD = 30;
    private static final int CONTROLLER_THRESHOLD = 25;

    private PsCanvasSymbolResolver() {
    }

    // ------------------------------------------------------------------
    // Public entry points
    // ------------------------------------------------------------------

    /** Persistent single-slot cache for the runtime install() path. */
    private static volatile CacheEntry cache;
    private static volatile int dexClassCount;

    /** Number of classes found by the most recent cached scan (diagnostics). */
    public static int dexClassCount() {
        return dexClassCount;
    }

    /** Scan + score the given APK and cache the result by its path. */
    public static PsCanvasSymbols resolveCached(File apk) {
        if (apk == null) {
            return resolve(Collections.emptyList());
        }
        CacheEntry current = cache;
        if (current != null && current.apkPath.equals(apk.getAbsolutePath())) {
            dexClassCount = current.dexClassCount;
            return current.symbols;
        }
        List<DexClass> scanned = DexClassScanner.scanApk(apk);
        PsCanvasSymbols symbols = resolve(scanned);
        dexClassCount = scanned.size();
        cache = new CacheEntry(apk.getAbsolutePath(), symbols, scanned.size());
        return symbols;
    }

    /** Pure scan + score; used by the offline unit test and by resolveCached. */
    public static PsCanvasSymbols resolve(List<DexClass> dexClasses) {
        Map<String, DexClass> candidates = new LinkedHashMap<>();
        for (DexClass cls : dexClasses) {
            if (inScope(cls.name)) {
                candidates.put(cls.name, cls);
            }
        }

        PsCanvasSymbols result = new PsCanvasSymbols();
        List<String> claimed = new ArrayList<>();

        resolveSstoFlexible(result, candidates, claimed);
        resolveThreeSplitAnim(result, candidates, claimed);
        resolveThreeSplitDrag(result, candidates, claimed);
        resolveCanvasController(result, candidates, claimed);
        return result;
    }

    // ------------------------------------------------------------------
    // SSTO_FLEXIBLE (structural, authoritative)
    // ------------------------------------------------------------------

    private static void resolveSstoFlexible(PsCanvasSymbols out,
                                            Map<String, DexClass> candidates,
                                            List<String> claimed) {
        RoleSymbol symbol = out.role(Role.SSTO_FLEXIBLE);
        DexClass best = null;
        int bestScore = 0;
        String bestScale = null;
        String bestIntent = null;
        String bestLaunch = null;
        String bestMask = null;

        for (DexClass cls : candidates.values()) {
            if (claimed.contains(cls.name)) {
                continue;
            }
            Score score = scoreSstoFlexible(cls);
            if (best == null || score.total > bestScore) {
                best = cls;
                bestScore = score.total;
                bestScale = score.scale;
                bestIntent = score.intent;
                bestLaunch = score.launch;
                bestMask = score.mask;
            }
            if (score.total > 0) {
                symbol.addCandidate(cls.name, score.total, score.hints);
            }
        }

        if (best != null && bestScore >= SSTO_THRESHOLD && bestScale != null) {
            symbol.className = best.name;
            symbol.score = bestScore;
            symbol.scaleMethod = bestScale;
            symbol.intentListMethod = bestIntent;
            symbol.launchBoundsMethod = bestLaunch;
            symbol.maskAnimMethod = bestMask;
            symbol.status = Status.READY;
            symbol.source = Source.STRUCTURAL;
            claimed.add(best.name);
            return;
        }

        // Structural was weak -> try the known-symbol fallback, validated by presence.
        if (tryKnownSstoFlexible(symbol, candidates, claimed)) {
            return;
        }

        if (best != null) {
            symbol.className = best.name;
            symbol.score = bestScore;
            symbol.status = Status.AMBIGUOUS;
            symbol.source = Source.STRUCTURAL;
        } else {
            symbol.status = Status.SKIPPED;
            symbol.source = Source.NONE;
        }
    }

    private static Score scoreSstoFlexible(DexClass cls) {
        int total = 0;
        String scale = null;
        String intent = null;
        String launch = null;
        String mask = null;
        List<String> hints = new ArrayList<>();
        for (DexMethod method : cls.methods) {
            if (MethodMatcher.isSstoFlexibleConstructor(method)) {
                total += SSTO_CTOR;
                hints.add("ctor:" + MethodMatcher.label(method));
            } else if (MethodMatcher.isScaleGestureDetectorInt(method)) {
                total += SSTO_SCALE;
                scale = method.name;
                hints.add("scale:" + MethodMatcher.label(method));
            } else if (MethodMatcher.isLaunchBounds(method)) {
                total += SSTO_LAUNCH_BOUNDS;
                launch = method.name;
                hints.add("launch:" + MethodMatcher.label(method));
            } else if (MethodMatcher.isIntentList(method)) {
                total += SSTO_INTENT_LIST;
                intent = method.name;
                hints.add("intent:" + MethodMatcher.label(method));
            } else if (MethodMatcher.isMaskAnimation(method)) {
                // Not scored (see the agreed scoring), but capture the name so the
                // mask-animation hook can be wired structurally too.
                mask = method.name;
                hints.add("mask:" + MethodMatcher.label(method));
            }
        }
        for (DexField field : cls.fields) {
            if (MethodMatcher.isContainerViewField(field)) {
                total += SSTO_CONTAINER_FIELD;
                hints.add("field:ContainerView");
            } else if (MethodMatcher.isBundleField(field)) {
                total += SSTO_BUNDLE_FIELD;
                hints.add("field:Bundle");
            }
        }
        return new Score(total, scale, intent, launch, mask, hints);
    }

    // ------------------------------------------------------------------
    // THREE_SPLIT_ANIM / DRAG / CANVAS_CONTROLLER
    // ------------------------------------------------------------------

    private static void resolveThreeSplitAnim(PsCanvasSymbols out,
                                              Map<String, DexClass> candidates,
                                              List<String> claimed) {
        RoleSymbol symbol = out.role(Role.THREE_SPLIT_ANIM);
        if (tryKnownSymbol(symbol, Role.THREE_SPLIT_ANIM, candidates, claimed,
                cls -> hasValidSignature(cls, MethodMatcher::hasBooleanMethod))) {
            return;
        }
        resolveStructuralProxy(symbol, candidates, claimed, ANIM_THRESHOLD,
                PsCanvasSymbolResolver::animScore);
    }

    private static void resolveThreeSplitDrag(PsCanvasSymbols out,
                                              Map<String, DexClass> candidates,
                                              List<String> claimed) {
        RoleSymbol symbol = out.role(Role.THREE_SPLIT_DRAG);
        if (tryKnownSymbol(symbol, Role.THREE_SPLIT_DRAG, candidates, claimed,
                cls -> hasValidSignature(cls, MethodMatcher::hasMotionEventMethod)
                        && hasValidSignature(cls, MethodMatcher::hasEmbeddedDecorParam))) {
            return;
        }
        resolveStructuralProxy(symbol, candidates, claimed, DRAG_THRESHOLD,
                PsCanvasSymbolResolver::dragScore);
    }

    private static void resolveCanvasController(PsCanvasSymbols out,
                                                Map<String, DexClass> candidates,
                                                List<String> claimed) {
        RoleSymbol symbol = out.role(Role.CANVAS_CONTROLLER);
        if (tryKnownSymbol(symbol, Role.CANVAS_CONTROLLER, candidates, claimed,
                cls -> hasValidSignature(cls, MethodMatcher::hasBooleanMethod))) {
            return;
        }
        resolveStructuralProxy(symbol, candidates, claimed, CONTROLLER_THRESHOLD,
                PsCanvasSymbolResolver::controllerScore);
    }

    /** Known-symbol fallback for SSTO_FLEXIBLE: also captures the resolved method names. */
    private static boolean tryKnownSstoFlexible(RoleSymbol symbol,
                                                Map<String, DexClass> candidates,
                                                List<String> claimed) {
        for (String name : PsCanvasCompatibilityProfile.knownClassNames(Role.SSTO_FLEXIBLE)) {
            if (claimed.contains(name)) {
                continue;
            }
            DexClass cls = candidates.get(name);
            if (cls == null) {
                continue;
            }
            Score score = scoreSstoFlexible(cls);
            if (score.scale == null) {
                continue;
            }
            symbol.className = name;
            symbol.score = score.total;
            symbol.scaleMethod = score.scale;
            symbol.intentListMethod = score.intent;
            symbol.launchBoundsMethod = score.launch;
            symbol.maskAnimMethod = score.mask;
            symbol.status = Status.FALLBACK;
            symbol.source = Source.KNOWN_SYMBOL;
            claimed.add(name);
            return true;
        }
        return false;
    }

    /** Try the cross-generation known-symbol table for this role, validating presence. */
    private static boolean tryKnownSymbol(RoleSymbol symbol, Role role,
                                          Map<String, DexClass> candidates,
                                          List<String> claimed,
                                          java.util.function.Predicate<DexClass> validator) {
        List<String> names = PsCanvasCompatibilityProfile.knownClassNames(role);
        for (String name : names) {
            if (claimed.contains(name)) {
                continue;
            }
            DexClass cls = candidates.get(name);
            if (cls == null) {
                continue;
            }
            if (validator.test(cls)) {
                symbol.className = name;
                symbol.status = Status.FALLBACK;
                symbol.source = Source.KNOWN_SYMBOL;
                claimed.add(name);
                return true;
            }
        }
        return false;
    }

    private static boolean hasValidSignature(DexClass cls,
                                             java.util.function.Predicate<DexMethod> validator) {
        for (DexMethod method : cls.methods) {
            if (validator.test(method)) {
                return true;
            }
        }
        return false;
    }

    private interface ScoreFn {
        int apply(DexClass cls);
    }

    private static void resolveStructuralProxy(RoleSymbol symbol,
                                               Map<String, DexClass> candidates,
                                               List<String> claimed,
                                               int threshold,
                                               ScoreFn scoreFn) {
        DexClass best = null;
        int bestScore = 0;
        for (DexClass cls : candidates.values()) {
            if (claimed.contains(cls.name)) {
                continue;
            }
            int score = scoreFn.apply(cls);
            if (score > 0) {
                symbol.addCandidate(cls.name, score, Collections.singletonList("structural"));
            }
            if (best == null || score > bestScore) {
                best = cls;
                bestScore = score;
            }
        }
        if (best != null && bestScore >= threshold) {
            symbol.className = best.name;
            symbol.score = bestScore;
            symbol.status = Status.READY;
            symbol.source = Source.STRUCTURAL;
            claimed.add(best.name);
        } else if (best != null) {
            symbol.className = best.name;
            symbol.score = bestScore;
            symbol.status = Status.AMBIGUOUS;
            symbol.source = Source.STRUCTURAL;
        } else {
            symbol.status = Status.SKIPPED;
            symbol.source = Source.NONE;
        }
    }

    private static int animScore(DexClass cls) {
        int booleans = 0;
        int ints = 0;
        int noArg = 0;
        for (DexMethod method : cls.methods) {
            if (MethodMatcher.hasBooleanMethod(method)) {
                booleans++;
            } else if (MethodMatcher.hasTwoIntMethod(method)) {
                ints++;
            } else if (method.paramDescriptors.isEmpty()) {
                noArg++;
            }
        }
        return booleans * 20 + ints * 20 + Math.min(noArg, 2) * 5;
    }

    private static int dragScore(DexClass cls) {
        int motion = 0;
        int decor = 0;
        for (DexMethod method : cls.methods) {
            if (MethodMatcher.hasMotionEventMethod(method)) {
                motion++;
            }
            if (MethodMatcher.hasEmbeddedDecorParam(method)) {
                decor++;
            }
        }
        return motion * 15 + decor * 15;
    }

    private static int controllerScore(DexClass cls) {
        int booleans = 0;
        for (DexMethod method : cls.methods) {
            if (MethodMatcher.hasBooleanMethod(method)) {
                booleans++;
            }
        }
        return booleans * 25;
    }

    private static boolean inScope(String className) {
        for (String prefix : SCAN_PREFIXES) {
            if (className.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    private static final class Score {
        final int total;
        final String scale;
        final String intent;
        final String launch;
        final String mask;
        final List<String> hints;

        Score(int total, String scale, String intent, String launch,
              String mask, List<String> hints) {
            this.total = total;
            this.scale = scale;
            this.intent = intent;
            this.launch = launch;
            this.mask = mask;
            this.hints = hints;
        }
    }

    private static final class CacheEntry {
        final String apkPath;
        final PsCanvasSymbols symbols;
        final int dexClassCount;

        CacheEntry(String apkPath, PsCanvasSymbols symbols, int dexClassCount) {
            this.apkPath = apkPath;
            this.symbols = symbols;
            this.dexClassCount = dexClassCount;
        }
    }
}
