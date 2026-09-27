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

    /** The role groups the install path currently cares about. */
    public enum Role {
        SSTO_FLEXIBLE,
        THREE_SPLIT_ANIM,
        THREE_SPLIT_DRAG,
        CANVAS_CONTROLLER,
        PANORAMA_MANAGER,
        SAVED_SPLIT_LAYOUT,
        THREE_TASK_RESIZE,
        P4_TRACE_CHAIN
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

        // Resolved PanoramaModeManager contract (nullable). The two-task
        // capability is usable only when this complete method set is present on
        // one structurally unique manager class.
        public String panoramaActiveMethod;
        public String panoramaEnterMethod;
        public String panoramaExitMethod;
        public String twoTaskPredicateMethod;

        // Saved split-layout persistence contract. This role is usable only
        // when the shortcut manager save/build/exists chain and the
        // ContainerActivity bundle restore point are all uniquely resolved.
        public String savedLayoutBuildMethod;
        public String savedLayoutSaveMethod;
        public String savedLayoutExistsMethod;
        public String savedLayoutRestoreClass;
        public String savedLayoutRestoreMethod;
        public String savedLayoutActivityCreateMethod;
        public String savedLayoutActivityNewIntentMethod;

        // Complete OEM three-task resize path. All entries must resolve before
        // the classic suppression hooks may expose the newer implementation.
        public String threeTaskResizeSpringClass;
        public String threeTaskResizeSpringStateClass;
        public String threeTaskResizeRectUpdateMethod;
        public String threeTaskResizeScrollStartMethod;
        public String threeTaskResizeEnlargeMethod;
        public String threeTaskResizePredicateMethod;
        public String threeTaskResizeSpringDragMethod;
        public String threeTaskResizeSpringInitMethod;

        // Debug-only P4 feasibility trace chain. This role is deliberately
        // independent from CANVAS_CONTROLLER and is not an enablement gate for
        // any four-window product behavior.
        public String p4TaskDataDescriptor;
        public String p4AdapterClass;
        public String p4EmbeddedViewDecorClass;
        public String p4TaskCreatedCallbackClass;
        public String p4FlexibleTaskViewClass;
        public String p4ControllerAppendMethod;
        public String p4ControllerRemoveMethod;
        public String p4ControllerFocusMethod;
        public String p4ControllerTaskCountMethod;
        public String p4ControllerContainerField;
        public String p4ControllerAdapterField;
        public String p4ContainerAdapterGetter;
        public String p4ContainerControllerGetter;
        public String p4ContainerChildrenGetter;
        public String p4AdapterAddMethod;
        public String p4AdapterRemoveMethod;
        public String p4AdapterCountMethod;
        public String p4AdapterItemMethod;
        public String p4TaskDataTaskIdMethod;
        public String p4TaskDataIntentMethod;
        public String p4EmbeddedBindMethod;
        public String p4EmbeddedAttachedMethod;
        public String p4DecorTaskDataField;
        public String p4TaskCreatedMethod;
        public String p4FlexibleResizeMethod;
        public String p4FlexibleReleaseMethod;
        public String p4FlexibleTaskIdMethod;

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
        if (role(Role.PANORAMA_MANAGER).available()) {
            out.add("twoTaskPanorama");
        }
        if (role(Role.SAVED_SPLIT_LAYOUT).available()) {
            out.add("savedSplitLayout");
        }
        if (role(Role.THREE_TASK_RESIZE).available()) {
            out.add("threeTaskResize");
        }
        if (role(Role.P4_TRACE_CHAIN).available()) {
            out.add("p4TraceChain");
        }
        return out;
    }
}
