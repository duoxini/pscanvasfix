package com.color.pscanvasfix.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Ordered diagnostic inventory of declared hooks and their install outcomes. */
public final class HookRegistry {
    public enum Status {
        PLANNED,
        INSTALLED,
        SKIPPED,
        FAILED
    }

    public static final class Entry {
        private final String id;
        private final Status status;
        private final String detail;
        private final Throwable throwable;

        private Entry(String id, Status status, String detail, Throwable throwable) {
            this.id = id;
            this.status = status;
            this.detail = detail;
            this.throwable = throwable;
        }

        public String id() {
            return id;
        }

        public Status status() {
            return status;
        }

        public String detail() {
            return detail;
        }

        public Throwable throwable() {
            return throwable;
        }
    }

    private final Map<String, Entry> entries = new LinkedHashMap<>();

    public synchronized void declare(String id, String detail) {
        requireStableId(id);
        if (entries.containsKey(id)) {
            throw new IllegalArgumentException("Hook ID already declared: " + id);
        }
        entries.put(id, new Entry(id, Status.PLANNED, detail, null));
    }

    public synchronized void markInstalled(String id, String detail) {
        transition(id, Status.INSTALLED, detail, null);
    }

    public synchronized void markSkipped(String id, String detail) {
        transition(id, Status.SKIPPED, detail, null);
    }

    public synchronized void markFailed(String id, String detail, Throwable throwable) {
        transition(id, Status.FAILED, detail, throwable);
    }

    /** Rewrites a terminal group member after its framework handle was atomically rolled back. */
    public synchronized void markRolledBack(String id, String detail, Throwable throwable) {
        requireStableId(id);
        Entry current = entries.get(id);
        if (current == null) {
            throw new IllegalArgumentException("Unknown Hook ID: " + id);
        }
        entries.put(id, new Entry(id, Status.FAILED, detail, throwable));
    }

    public synchronized List<Entry> snapshot() {
        return Collections.unmodifiableList(new ArrayList<>(entries.values()));
    }

    private void transition(String id, Status status, String detail, Throwable throwable) {
        requireStableId(id);
        Entry current = entries.get(id);
        if (current == null) {
            throw new IllegalArgumentException("Unknown Hook ID: " + id);
        }
        if (current.status != Status.PLANNED) {
            throw new IllegalStateException(
                    "Hook ID already terminal: " + id + " status=" + current.status);
        }
        entries.put(id, new Entry(id, status, detail, throwable));
    }

    private static void requireStableId(String id) {
        Objects.requireNonNull(id, "id");
        String trimmed = id.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Hook ID must not be blank");
        }
        if (!id.equals(trimmed)) {
            throw new IllegalArgumentException(
                    "Hook ID must not have leading or trailing whitespace: " + id);
        }
    }
}
