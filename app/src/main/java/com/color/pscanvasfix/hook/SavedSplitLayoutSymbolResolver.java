package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Source;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Resolves the save/update/restore contract for pinned split-layout shortcuts. */
final class SavedSplitLayoutSymbolResolver {
    private static final String CONTAINER_ACTIVITY =
            "com.oplus.pscanvas.canvasmode.canvas.ContainerActivity";
    private static final List<String> RESTORE_METHOD_HINTS =
            Collections.unmodifiableList(Arrays.asList("K1", "T1", "W1"));

    private SavedSplitLayoutSymbolResolver() {
    }

    static void resolveInto(PsCanvasSymbols out, List<DexClass> dexClasses) {
        RoleSymbol symbol = out.role(Role.SAVED_SPLIT_LAYOUT);
        List<ManagerContract> managers = new ArrayList<>();
        DexClass containerActivity = null;

        for (DexClass cls : dexClasses) {
            if (CONTAINER_ACTIVITY.equals(cls.name)) {
                containerActivity = cls;
            }
            ManagerContract contract = inspectManager(cls);
            if (contract != null) {
                managers.add(contract);
                symbol.addCandidate(cls.name, 100,
                        Arrays.asList("context-ctor", "save-with-container",
                                "shortcut-build", "exists"));
            }
        }

        if (managers.size() != 1 || containerActivity == null) {
            symbol.status = managers.size() > 1
                    ? Status.AMBIGUOUS : Status.SKIPPED;
            symbol.source = managers.isEmpty() ? Source.NONE : Source.STRUCTURAL;
            return;
        }

        ActivityContract activity = inspectActivity(containerActivity);
        if (activity == null) {
            symbol.className = managers.get(0).className;
            symbol.score = 100;
            symbol.status = Status.AMBIGUOUS;
            symbol.source = Source.KNOWN_SYMBOL;
            return;
        }

        ManagerContract manager = managers.get(0);
        symbol.className = manager.className;
        symbol.savedLayoutBuildMethod = manager.buildMethod;
        symbol.savedLayoutSaveMethod = manager.saveMethod;
        symbol.savedLayoutExistsMethod = manager.existsMethod;
        symbol.savedLayoutRestoreClass = containerActivity.name;
        symbol.savedLayoutRestoreMethod = activity.restoreMethod;
        symbol.savedLayoutActivityCreateMethod = activity.createMethod;
        symbol.savedLayoutActivityNewIntentMethod = activity.newIntentMethod;
        symbol.score = 160;
        symbol.status = Status.FALLBACK;
        symbol.source = Source.KNOWN_SYMBOL;
    }

    private static ManagerContract inspectManager(DexClass cls) {
        int constructors = 0;
        List<DexMethod> saves = new ArrayList<>();
        List<DexMethod> builds = new ArrayList<>();
        List<DexMethod> exists = new ArrayList<>();
        for (DexMethod method : cls.methods) {
            if (MethodMatcher.isContextConstructor(method)) {
                constructors++;
            }
            if (MethodMatcher.isSavedLayoutSaveEntry(method)) {
                saves.add(method);
            }
            if (MethodMatcher.isSavedLayoutShortcutBuild(method)) {
                builds.add(method);
            }
            if (MethodMatcher.isSavedLayoutExists(method)) {
                exists.add(method);
            }
        }
        if (constructors != 1 || saves.size() != 1 || builds.size() != 1
                || exists.size() != 1) {
            return null;
        }
        return new ManagerContract(cls.name, saves.get(0).name,
                builds.get(0).name, exists.get(0).name);
    }

    private static DexMethod uniqueHintedRestore(DexClass containerActivity) {
        DexMethod match = null;
        for (DexMethod method : containerActivity.methods) {
            if (!RESTORE_METHOD_HINTS.contains(method.name)
                    || !MethodMatcher.isBundleBoolean(method)) {
                continue;
            }
            if (match != null) {
                return null;
            }
            match = method;
        }
        return match;
    }

    private static ActivityContract inspectActivity(DexClass containerActivity) {
        DexMethod restore = uniqueHintedRestore(containerActivity);
        List<DexMethod> creates = new ArrayList<>();
        List<DexMethod> newIntents = new ArrayList<>();
        for (DexMethod method : containerActivity.methods) {
            if (MethodMatcher.isActivityOnCreate(method)) {
                creates.add(method);
            }
            if (MethodMatcher.isActivityOnNewIntent(method)) {
                newIntents.add(method);
            }
        }
        if (restore == null || creates.size() != 1 || newIntents.size() != 1) {
            return null;
        }
        return new ActivityContract(restore.name, creates.get(0).name,
                newIntents.get(0).name);
    }

    private static final class ManagerContract {
        final String className;
        final String saveMethod;
        final String buildMethod;
        final String existsMethod;

        ManagerContract(String className, String saveMethod,
                        String buildMethod, String existsMethod) {
            this.className = className;
            this.saveMethod = saveMethod;
            this.buildMethod = buildMethod;
            this.existsMethod = existsMethod;
        }
    }

    private static final class ActivityContract {
        final String restoreMethod;
        final String createMethod;
        final String newIntentMethod;

        ActivityContract(String restoreMethod, String createMethod,
                         String newIntentMethod) {
            this.restoreMethod = restoreMethod;
            this.createMethod = createMethod;
            this.newIntentMethod = newIntentMethod;
        }
    }
}
