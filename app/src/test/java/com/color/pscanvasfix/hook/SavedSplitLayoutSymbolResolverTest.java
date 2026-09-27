package com.color.pscanvasfix.hook;

import com.color.pscanvasfix.hook.DexClassScanner.DexClass;
import com.color.pscanvasfix.hook.DexClassScanner.DexMethod;
import com.color.pscanvasfix.hook.PsCanvasSymbols.Role;
import com.color.pscanvasfix.hook.PsCanvasSymbols.RoleSymbol;

import org.junit.Assume;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Offline contract for pinned split-layout save/update/restore symbols. */
public final class SavedSplitLayoutSymbolResolverTest {
    private static final String CONTAINER_ACTIVITY =
            "com.oplus.pscanvas.canvasmode.canvas.ContainerActivity";

    @Test
    public void resolvesNewGenerationFixturesAndFailsClosedOnOldGeneration() {
        String directory = System.getProperty("pscanvas.apk.dir", "").trim();
        Assume.assumeTrue("set -Dpscanvas.apk.dir=<fixture directory>",
                !directory.isEmpty());

        String[][] expected = {
                {"251215", "", ""},
                {"260403", "C1.a", "T1"},
                {"260512", "C1.a", "W1"},
                {"260608", "C1.a", "W1"},
        };
        for (String[] row : expected) {
            File apk = new File(directory, "多窗口(" + row[0] + ").apk");
            assertTrue("missing exact fixture " + apk, apk.isFile());
            RoleSymbol symbol = PsCanvasSymbolResolver.resolve(
                    DexClassScanner.scanApk(apk)).role(Role.SAVED_SPLIT_LAYOUT);
            if (row[1].isEmpty()) {
                assertFalse("old save chain has no live ContainerView", symbol.available());
                continue;
            }
            assertTrue("saved layout role for " + row[0], symbol.available());
            assertEquals(row[1], symbol.className);
            assertEquals("a", symbol.savedLayoutSaveMethod);
            assertEquals("b", symbol.savedLayoutBuildMethod);
            assertEquals("k", symbol.savedLayoutExistsMethod);
            assertEquals(CONTAINER_ACTIVITY, symbol.savedLayoutRestoreClass);
            assertEquals(row[2], symbol.savedLayoutRestoreMethod);
            assertEquals("onCreate", symbol.savedLayoutActivityCreateMethod);
            assertEquals("onNewIntent", symbol.savedLayoutActivityNewIntentMethod);
        }
    }

    @Test
    public void ambiguousManagerCandidatesFailClosed() {
        List<DexClass> classes = new ArrayList<>();
        classes.add(manager("fixture.ManagerOne"));
        classes.add(manager("fixture.ManagerTwo"));
        classes.add(container("W1"));

        RoleSymbol symbol = PsCanvasSymbolResolver.resolve(classes)
                .role(Role.SAVED_SPLIT_LAYOUT);

        assertFalse(symbol.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, symbol.status);
    }

    @Test
    public void unknownRestoreNameFailsClosed() {
        RoleSymbol symbol = PsCanvasSymbolResolver.resolve(Arrays.asList(
                manager("fixture.Manager"), container("X1")))
                .role(Role.SAVED_SPLIT_LAYOUT);

        assertFalse(symbol.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, symbol.status);
    }

    @Test
    public void missingActivityCreateFailsClosed() {
        DexClass container = container("W1");
        container.methods.removeIf(MethodMatcher::isActivityOnCreate);

        RoleSymbol symbol = PsCanvasSymbolResolver.resolve(Arrays.asList(
                manager("fixture.Manager"), container))
                .role(Role.SAVED_SPLIT_LAYOUT);

        assertFalse(symbol.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, symbol.status);
    }

    @Test
    public void duplicateActivityCreateFailsClosed() {
        DexClass container = container("W1");
        container.methods.add(method("onCreate", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_BUNDLE));

        RoleSymbol symbol = PsCanvasSymbolResolver.resolve(Arrays.asList(
                manager("fixture.Manager"), container))
                .role(Role.SAVED_SPLIT_LAYOUT);

        assertFalse(symbol.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, symbol.status);
    }

    @Test
    public void missingActivityNewIntentFailsClosed() {
        DexClass container = container("W1");
        container.methods.removeIf(MethodMatcher::isActivityOnNewIntent);

        RoleSymbol symbol = PsCanvasSymbolResolver.resolve(Arrays.asList(
                manager("fixture.Manager"), container))
                .role(Role.SAVED_SPLIT_LAYOUT);

        assertFalse(symbol.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, symbol.status);
    }

    @Test
    public void duplicateActivityNewIntentFailsClosed() {
        DexClass container = container("W1");
        container.methods.add(method("onNewIntent", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_INTENT));

        RoleSymbol symbol = PsCanvasSymbolResolver.resolve(Arrays.asList(
                manager("fixture.Manager"), container))
                .role(Role.SAVED_SPLIT_LAYOUT);

        assertFalse(symbol.available());
        assertEquals(PsCanvasSymbols.Status.AMBIGUOUS, symbol.status);
    }

    private static DexClass manager(String name) {
        DexClass cls = new DexClass(name);
        cls.methods.add(method("<init>", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_CONTEXT));
        cls.methods.add(method("a", MethodMatcher.DESC_BOOLEAN,
                MethodMatcher.DESC_LIST, MethodMatcher.DESC_INT, MethodMatcher.DESC_INT,
                MethodMatcher.DESC_CONTAINER_VIEW));
        cls.methods.add(method("b", MethodMatcher.DESC_BOOLEAN,
                MethodMatcher.DESC_STRING_ARRAY, MethodMatcher.DESC_INT_ARRAY,
                MethodMatcher.DESC_INT, MethodMatcher.DESC_INT,
                MethodMatcher.DESC_BOOLEAN_ARRAY, MethodMatcher.DESC_BOOLEAN_ARRAY,
                MethodMatcher.DESC_LIST));
        cls.methods.add(method("k", MethodMatcher.DESC_BOOLEAN,
                MethodMatcher.DESC_LIST));
        return cls;
    }

    private static DexClass container(String restoreName) {
        DexClass cls = new DexClass(CONTAINER_ACTIVITY);
        cls.methods.add(method(restoreName, MethodMatcher.DESC_BOOLEAN,
                MethodMatcher.DESC_BUNDLE));
        cls.methods.add(method("onCreate", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_BUNDLE));
        cls.methods.add(method("onNewIntent", MethodMatcher.DESC_VOID,
                MethodMatcher.DESC_INTENT));
        return cls;
    }

    private static DexMethod method(String name, String returnDescriptor,
                                    String... parameters) {
        return new DexMethod(name, returnDescriptor, Arrays.asList(parameters));
    }
}
