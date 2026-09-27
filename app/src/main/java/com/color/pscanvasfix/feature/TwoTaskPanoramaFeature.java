package com.color.pscanvasfix.feature;

import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.runtime.ReflectionAccess;

/** Adds directional panorama gestures only when the canvas contains exactly two tasks. */
public final class TwoTaskPanoramaFeature {
    enum Decision {
        NOT_HANDLED,
        ENTER,
        EXIT,
        CONSUME_NOOP
    }

    private TwoTaskPanoramaFeature() {
    }

    static Decision decide(boolean capabilityAvailable, boolean managerAvailable,
                           int taskCount, int pointerCount, float scaleFactor,
                           boolean active) {
        if (!capabilityAvailable || !managerAvailable || taskCount != 2
                || pointerCount < 4 || !Float.isFinite(scaleFactor)
                || scaleFactor <= 0.0f) {
            return Decision.NOT_HANDLED;
        }
        if (scaleFactor < 1.0f && !active) {
            return Decision.ENTER;
        }
        if (scaleFactor > 1.0f && active) {
            return Decision.EXIT;
        }
        return Decision.CONSUME_NOOP;
    }

    /**
     * Dispatches a scale frame through the OEM panorama manager.
     *
     * @return {@code true} only when the exact-two-task frame belongs to this feature;
     *         {@code false} preserves the existing OEM/module fallback path
     */
    public static boolean handleDirectionalScale(Object containerView, float scaleFactor,
                                                 int pointerCount,
                                                 boolean capabilityAvailable,
                                                 ReflectionAccess reflectionAccess,
                                                 String managerGetter,
                                                 String activeMethod,
                                                 String enterMethod,
                                                 String exitMethod) {
        if (!hasRuntimeCapability(capabilityAvailable, containerView, reflectionAccess,
                managerGetter, activeMethod, enterMethod, exitMethod)) {
            return false;
        }
        try {
            Object adapter = reflectionAccess.callMethod(containerView, "getAdapter");
            if (adapter == null) {
                return false;
            }
            Object countValue = reflectionAccess.callMethod(adapter, "getCount");
            if (!(countValue instanceof Number)) {
                return false;
            }
            int taskCount = ((Number) countValue).intValue();
            if (taskCount != 2 || pointerCount < 4 || !Float.isFinite(scaleFactor)
                    || scaleFactor <= 0.0f) {
                return false;
            }

            Object manager = reflectionAccess.callMethod(containerView, managerGetter);
            if (manager == null) {
                return false;
            }
            Boolean activeValue = readActive(manager, reflectionAccess, activeMethod);
            if (activeValue == null) {
                return false;
            }
            boolean active = activeValue.booleanValue();
            Decision decision = decide(true, true, taskCount, pointerCount, scaleFactor, active);
            switch (decision) {
                case ENTER:
                    reflectionAccess.callMethod(manager, enterMethod, true);
                    logActionResultBestEffort("enter", manager, reflectionAccess,
                            activeMethod, pointerCount, scaleFactor, false);
                    return true;
                case EXIT:
                    PanoramaFeature.exitDirectionally(manager, reflectionAccess, exitMethod);
                    logActionResultBestEffort("exit", manager, reflectionAccess,
                            activeMethod, pointerCount, scaleFactor, true);
                    return true;
                case CONSUME_NOOP:
                    return true;
                case NOT_HANDLED:
                    return false;
                default:
                    throw new AssertionError("Unhandled decision: " + decision);
            }
        } catch (Throwable throwable) {
            logErrorBestEffort("[TwoTaskPanorama] gesture dispatch failed", throwable);
            return false;
        }
    }

    private static boolean hasRuntimeCapability(boolean capabilityAvailable,
                                                Object containerView,
                                                ReflectionAccess reflectionAccess,
                                                String managerGetter,
                                                String activeMethod,
                                                String enterMethod,
                                                String exitMethod) {
        return capabilityAvailable && containerView != null && reflectionAccess != null
                && hasText(managerGetter) && hasText(activeMethod)
                && hasText(enterMethod) && hasText(exitMethod);
    }

    private static Boolean readActive(Object manager, ReflectionAccess reflectionAccess,
                                      String activeMethod) {
        Object value = reflectionAccess.callMethod(manager, activeMethod);
        return value instanceof Boolean ? (Boolean) value : null;
    }

    private static void logActionResultBestEffort(String action, Object manager,
                                                  ReflectionAccess reflectionAccess,
                                                  String activeMethod, int pointerCount,
                                                  float scaleFactor, boolean activeBefore) {
        try {
            Boolean activeAfter = readActive(manager, reflectionAccess, activeMethod);
            PsCanvasLog.i("[TwoTaskPanorama] " + action + " count=2 pointers="
                    + pointerCount + " scale=" + scaleFactor
                    + " activeBefore=" + activeBefore + " activeAfter=" + activeAfter);
        } catch (Throwable throwable) {
            logErrorBestEffort("[TwoTaskPanorama] " + action
                    + " completed; post-action state unavailable", throwable);
        }
    }

    private static void logErrorBestEffort(String message, Throwable throwable) {
        try {
            PsCanvasLog.e(message, throwable);
        } catch (Throwable ignored) {
            // Logging must not change gesture dispatch or fallback semantics.
        }
    }

    private static boolean hasText(String value) {
        return value != null && !value.isEmpty();
    }
}
