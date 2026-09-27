package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

public final class HookRegistryTest {
    @Test
    public void snapshotKeepsDeclarationOrderAndIsImmutable() {
        HookRegistry registry = new HookRegistry();
        registry.declare("layout.bounds", "layout hook");
        registry.declare("panorama.entry", "panorama hook");

        List<HookRegistry.Entry> snapshot = registry.snapshot();

        assertEquals(2, snapshot.size());
        assertEquals("layout.bounds", snapshot.get(0).id());
        assertEquals("panorama.entry", snapshot.get(1).id());
        assertEquals(HookRegistry.Status.PLANNED, snapshot.get(0).status());
        registry.markInstalled("layout.bounds", "ready");
        assertEquals(HookRegistry.Status.PLANNED, snapshot.get(0).status());
        assertEquals(HookRegistry.Status.INSTALLED,
                registry.snapshot().get(0).status());
        assertThrows(UnsupportedOperationException.class,
                () -> snapshot.add(snapshot.get(0)));
    }

    @Test
    public void recordsTerminalStatusDetailAndThrowable() {
        HookRegistry registry = new HookRegistry();
        registry.declare("installed", "planned installed");
        registry.declare("skipped", "planned skipped");
        registry.declare("failed", "planned failed");
        IllegalStateException failure = new IllegalStateException("boom");

        registry.markInstalled("installed", "ready");
        registry.markSkipped("skipped", "missing role");
        registry.markFailed("failed", "framework rejected hook", failure);

        List<HookRegistry.Entry> snapshot = registry.snapshot();
        assertEntry(snapshot.get(0), HookRegistry.Status.INSTALLED, "ready", null);
        assertEntry(snapshot.get(1), HookRegistry.Status.SKIPPED, "missing role", null);
        assertEntry(snapshot.get(2), HookRegistry.Status.FAILED,
                "framework rejected hook", failure);
    }

    @Test
    public void rejectsDuplicateId() {
        HookRegistry registry = new HookRegistry();
        registry.declare("panorama.entry", "first");

        assertThrows(IllegalArgumentException.class,
                () -> registry.declare("panorama.entry", "duplicate"));
    }

    @Test
    public void rejectsUnknownIdTransition() {
        HookRegistry registry = new HookRegistry();

        assertThrows(IllegalArgumentException.class,
                () -> registry.markInstalled("unknown", "ready"));
        assertThrows(IllegalArgumentException.class,
                () -> registry.markSkipped("unknown", "missing"));
        assertThrows(IllegalArgumentException.class,
                () -> registry.markFailed("unknown", "failed", new RuntimeException()));
    }

    @Test
    public void rejectsTerminalStateRewrite() {
        HookRegistry registry = new HookRegistry();
        registry.declare("layout.bounds", "planned");
        registry.markInstalled("layout.bounds", "ready");

        assertThrows(IllegalStateException.class,
                () -> registry.markSkipped("layout.bounds", "late skip"));
        assertThrows(IllegalStateException.class,
                () -> registry.markFailed(
                        "layout.bounds", "late failure", new RuntimeException()));
        assertThrows(IllegalStateException.class,
                () -> registry.markInstalled("layout.bounds", "duplicate install"));
    }

    @Test
    public void recordsExplicitAtomicGroupRollbackAfterTerminalOutcome() {
        HookRegistry registry = new HookRegistry();
        registry.declare("touch.anim", "planned");
        registry.declare("touch.drag", "planned");
        registry.markInstalled("touch.anim", "installed before group commit");
        registry.markSkipped("touch.drag", "role detail disappeared");
        IllegalStateException failure = new IllegalStateException("group rollback");

        registry.markRolledBack("touch.anim", "composite rollback", failure);
        registry.markRolledBack("touch.drag", "composite rollback", failure);

        assertEntry(registry.snapshot().get(0), HookRegistry.Status.FAILED,
                "composite rollback", failure);
        assertEntry(registry.snapshot().get(1), HookRegistry.Status.FAILED,
                "composite rollback", failure);
    }

    @Test
    public void rejectsNullBlankOrPaddedIds() {
        HookRegistry registry = new HookRegistry();

        assertThrows(NullPointerException.class, () -> registry.declare(null, "null"));
        assertThrows(IllegalArgumentException.class, () -> registry.declare("", "empty"));
        assertThrows(IllegalArgumentException.class, () -> registry.declare("  ", "blank"));
        assertThrows(IllegalArgumentException.class,
                () -> registry.declare(" hook.id", "leading whitespace"));
        assertThrows(IllegalArgumentException.class,
                () -> registry.declare("hook.id ", "trailing whitespace"));
    }

    private static void assertEntry(HookRegistry.Entry entry, HookRegistry.Status status,
                                    String detail, Throwable throwable) {
        assertEquals(status, entry.status());
        assertEquals(detail, entry.detail());
        if (throwable == null) {
            assertNull(entry.throwable());
        } else {
            assertSame(throwable, entry.throwable());
        }
    }
}
