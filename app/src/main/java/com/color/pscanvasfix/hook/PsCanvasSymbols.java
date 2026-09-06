package com.color.pscanvasfix.hook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Holds the per-process result of one structural scan: for each {@link Role} the
 * resolved class name, the capability status/score/source, and the candidate
 * list that produced it. Purely a data holder — no Xposed / Android dependency,
 * so the exact same object is produced by the JVM unit test and at runtime.
 */
public final class PsCanvasSymbols {

    /** Resolution outcome per role. */
    public enum Status {
        READY,     // unambiguous structural hit (score >= threshold and margin)
        AMBIGUOUS, // a candidate exists but cannot be trusted (below threshold / margin)
        FALLBACK,  // resolved through a known-symbol fallback hint (validated by presence)
        SKIPPED    // nothing usable; the capability must be disabled
    }

    /** Where a resolution came from. */
    public enum Source {
        STRUCTURAL,
        KNOWN_SYMBOL,
        NONE
    }

    /** The four role groups the install path currently cares about. */
    public enum Role {
        SSTO_FLEXIBLE,
        THREE_SPLIT_ANIM,
        THREE_SPLIT_DRAG,
        CANVAS_CONTROLLER
    }

    /** One scored candidate for a role (used for AMBIGUOUS logging). */
    public static final class Candidate {
        public final String className;
        public final int score;
        public final List<String> hints;

        Candidate(String className, int score, List<String> hints) {
            this.className = className;
            this.score = score;
            this.hints = Collections.unmodifiableList(new ArrayList<>(hints));
        }
    }

    /** Per-role resolution. */
    public static final class RoleSymbol {
        public final Role role;
        public String className;
        public Status status = Status.SKIPPED;
        public Source source = Source.NONE;
        public int score;
        public final List<Candidate> candidates = new ArrayList<>();

        // Resolved method *names* found by signature for SStoFlexible (nullable).
        // install() uses these as the method name and the fixed signatures for args.
        public String scaleMethod;
        public String intentListMethod;
        public String launchBoundsMethod;
        public String maskAnimMethod;

        RoleSymbol(Role role) {
            this.role = role;
        }

        public boolean available() {
            return className != null
                    && (status == Status.READY || status == Status.FALLBACK);
        }

        void addCandidate(String className, int score, List<String> hints) {
            candidates.add(new Candidate(className, score, hints));
        }
    }

    private final List<RoleSymbol> symbols;

    public PsCanvasSymbols() {
        List<RoleSymbol> list = new ArrayList<>();
        for (Role role : Role.values()) {
            list.add(new RoleSymbol(role));
        }
        this.symbols = Collections.unmodifiableList(list);
    }

    public RoleSymbol role(Role role) {
        for (RoleSymbol symbol : symbols) {
            if (symbol.role == role) {
                return symbol;
            }
        }
        throw new IllegalArgumentException("unknown role " + role);
    }

    public List<RoleSymbol> all() {
        return symbols;
    }

    /** @return a stable, ordered list of capability keys currently usable. */
    public List<String> enabledCapabilities() {
        List<String> out = new ArrayList<>();
        if (role(Role.SSTO_FLEXIBLE).available()) {
            out.add("sstoFlexible");
        }
        if (role(Role.THREE_SPLIT_ANIM).available()) {
            out.add("threeSplitAnim");
        }
        if (role(Role.THREE_SPLIT_DRAG).available()) {
            out.add("threeSplitDrag");
        }
        if (role(Role.CANVAS_CONTROLLER).available()) {
            out.add("canvasController");
        }
        return out;
    }
}
