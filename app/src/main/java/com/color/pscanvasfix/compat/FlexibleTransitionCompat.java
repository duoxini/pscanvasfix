package com.color.pscanvasfix.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class FlexibleTransitionCompat {
    private static final int FALLBACK_POLL_ATTEMPTS = 10;
    private static final int FINISH_DELAY_MS = 500;
    private static final int FLEXIBLE_ANIMATING_IDLE = -1;
    private static final int FLEXIBLE_VERIFY_INTERVAL_MS = 100;
    private static final int FLEXIBLE_VERIFY_TIMEOUT_MS = 1500;
    private static final String TAG = "PsCanvasFix";
    private static final int TRANSITION_POLL_ATTEMPTS = 8;
    private static final int TRANSITION_POLL_INTERVAL_MS = 50;
    private static final int WINDOWING_MODE_COMPACT = 100;
    private static final int WINDOWING_MODE_FREEFORM = 5;
    private static final int WINDOWING_MODE_PINNED = 6;
    private static final int ZOOM_DISMISS_AFTER_LAST_ZOOM_MS = 250;
    private static final int ZOOM_DISMISS_MAX_WAIT_MS = 1200;
    private static final int ZOOM_DISMISS_MIN_DELAY_MS = 300;
    private static final int ZOOM_MASK_CLEAR_DELAY_MS = 100;
    private static final int ZOOM_STAGGER_MS = 16;
    private static final AtomicBoolean lastTransitionSucceeded = new AtomicBoolean(false);
    private static final AtomicBoolean usedZoomFallback = new AtomicBoolean(false);
    private static final AtomicBoolean earlySplitZoomActive = new AtomicBoolean(false);
    private static final AtomicBoolean zoomCanvasDismissScheduled = new AtomicBoolean(false);
    private static volatile int[] lastZoomTaskIds = new int[0];
    private static volatile Object lastSplitPolicy = null;
    private static volatile long pinchEndUptimeMs = 0;
    private static volatile long lastZoomInvokeUptimeMs = 0;

    private static volatile Object activeSplitPolicy = null;

    private FlexibleTransitionCompat() {
    }

    public static void setActiveSplitPolicy(Object splitPolicy) {
        activeSplitPolicy = splitPolicy;
    }

    public static Object getActiveSplitPolicy() {
        return activeSplitPolicy;
    }

    public static boolean isPrepareSwitchCall(Bundle bundle) {
        return bundle != null && bundle.getBoolean("prepare_switch_to_flexible_window", false);
    }

    public static Context resolveContext(Object instance, Object[] args, ClassLoader classLoader) {
        if (instance instanceof Context) {
            return (Context) instance;
        }
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof Context) {
                    return (Context) arg;
                }
            }
        }
        if (instance != null) {
            Object context = findFieldValueByType(instance, Context.class);
            if (context instanceof Context) {
                return (Context) context;
            }
        }
        try {
            Object app = XposedHelpers.callStaticMethod(XposedHelpers.findClass("android.app.ActivityThread", classLoader), "currentApplication", new Object[0]);
            if (app instanceof Context) {
                return (Context) app;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static void sanitizeLaunchBounds(List<?> launchBounds, Context context) {
        if (launchBounds == null || context == null) {
            return;
        }
        Rect maxBounds = ConfigCompat.getMaxBounds(context.getResources().getConfiguration(), context);
        List<Object> mutable = (List<Object>) launchBounds;
        for (int index = 0; index < mutable.size(); index++) {
            Object entry = mutable.get(index);
            if (entry instanceof Rect) {
                Rect source = (Rect) entry;
                if (isValid(source)) {
                    Rect fixed = clampRect(source, maxBounds);
                    if (!fixed.equals(source)) {
                        mutable.set(index, fixed);
                        XposedBridge.log("PsCanvasFix: clamped launch bounds[" + index + "] from " + source + " to " + fixed);
                    }
                }
            }
        }
    }

    public static Bundle fixLaunchBoundsBundle(Bundle bundle, Context context) {
        if (bundle == null || context == null) {
            return bundle;
        }
        ArrayList<?> launchList = readLaunchBoundsList(bundle);
        if (launchList == null || launchList.isEmpty()) {
            XposedBridge.log("PsCanvasFix: launch bounds list missing in calculateFlexibleWindowBounds result");
            return bundle;
        }
        Rect maxBounds = ConfigCompat.getMaxBounds(context.getResources().getConfiguration(), context);
        ArrayList<Bundle> fixedList = new ArrayList<>(launchList.size());
        float referenceScale = 0.0f;
        float referenceExpandRatio = 0.0f;
        int referenceCount = 0;
        Iterator<?> preview = launchList.iterator();
        while (preview.hasNext()) {
            Object item = preview.next();
            if (!(item instanceof Bundle)) {
                continue;
            }
            Bundle launchBundle = (Bundle) item;
            Rect launchBounds = (Rect) launchBundle.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
            Rect visualBounds = (Rect) launchBundle.getParcelable("androidx.flexible.VisualBounds", Rect.class);
            if (!isOversizedLaunchBounds(launchBounds, visualBounds, maxBounds)) {
                referenceScale += launchBundle.getFloat("androidx.activity.LaunchScale", 1.0f);
                if (visualBounds != null && isValid(visualBounds) && launchBounds != null && isValid(launchBounds)
                        && visualBounds.width() > 0) {
                    referenceExpandRatio += (float) launchBounds.width() / visualBounds.width();
                    referenceCount++;
                }
            }
        }
        if (referenceCount > 0) {
            referenceScale /= referenceCount;
            referenceExpandRatio /= referenceCount;
        } else {
            referenceScale = 0.8611111f;
            referenceExpandRatio = 1.16f;
        }
        Iterator<?> it = launchList.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item instanceof Bundle) {
                Bundle launchBundle = new Bundle((Bundle) item);
                Rect launchBounds = (Rect) launchBundle.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
                Rect visualBounds = (Rect) launchBundle.getParcelable("androidx.flexible.VisualBounds", Rect.class);
                if (isOversizedLaunchBounds(launchBounds, visualBounds, maxBounds)) {
                    Rect normalized = deriveLaunchBoundsFromVisual(visualBounds, referenceExpandRatio, maxBounds);
                    if (normalized != null) {
                        launchBounds = normalized;
                        launchBundle.putParcelable("androidx.flexible.LaunchBounds", launchBounds);
                        launchBundle.putFloat("androidx.activity.LaunchScale", referenceScale);
                        XposedBridge.log(TAG + ": normalized oversized launch bounds to " + launchBounds
                                + " scale=" + referenceScale);
                    }
                }
                if (launchBounds != null && isValid(launchBounds)) {
                    launchBundle.putParcelable("androidx.flexible.LaunchBounds",
                            clampRect(launchBounds, maxBounds));
                }
                if (visualBounds != null && isValid(visualBounds)) {
                    launchBundle.putParcelable("androidx.flexible.VisualBounds",
                            clampRect(visualBounds, maxBounds));
                }
                fixedList.add(launchBundle);
            }
        }
        bundle.putParcelableArrayList("androidx.canvas.to.multi.flexible.launch.bounds.list", fixedList);
        return bundle;
    }

    public static void markTransitionSucceeded(boolean succeeded) {
        lastTransitionSucceeded.set(succeeded);
    }

    public static boolean wasLastTransitionSucceeded() {
        return lastTransitionSucceeded.get();
    }

    public static boolean wasZoomFallbackUsed() {
        return usedZoomFallback.get();
    }

    public static boolean isEarlySplitZoomActive() {
        return earlySplitZoomActive.get();
    }

    public static void resetEarlySplitZoom() {
        earlySplitZoomActive.set(false);
        zoomCanvasDismissScheduled.set(false);
        lastTransitionSucceeded.set(false);
        lastSplitPolicy = null;
        pinchEndUptimeMs = 0L;
        lastZoomInvokeUptimeMs = 0L;
    }

    public static void resetSplitToFlexibleMask(Object splitPolicy) {
        if (splitPolicy == null) {
            return;
        }
        try {
            XposedHelpers.callMethod(splitPolicy, "U", new Object[0]);
            XposedBridge.log("PsCanvasFix: reset split-to-flexible blur mask");
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: resetSplitToFlexibleMask failed: " + throwable);
        }
    }

    public static void beginEarlySplitZoom(final Object splitPolicy, final ClassLoader classLoader) {
        if (earlySplitZoomActive.getAndSet(true)) {
            return;
        }
        Context context = SplitPolicyCompat.findContext(splitPolicy);
        if (context == null) {
            context = resolveContext(splitPolicy, null, classLoader);
        }
        if (context == null) {
            earlySplitZoomActive.set(false);
            return;
        }
        SplitPolicyCompat.sanitizeTransitionEntries(splitPolicy, context);
        lastSplitPolicy = splitPolicy;
        lastZoomTaskIds = extractZoomTargetTaskIds(splitPolicy);
        if (lastZoomTaskIds.length == 0) {
            earlySplitZoomActive.set(false);
            XposedBridge.log(TAG + ": early split zoom aborted, no embedded tasks");
            return;
        }
        SplitPolicyCompat.hideCanvasImmediately(splitPolicy);
        SplitPolicyCompat.clearFlexibleAnimating(splitPolicy);
        zoomCanvasDismissScheduled.set(false);
        pinchEndUptimeMs = SystemClock.uptimeMillis();
        lastZoomInvokeUptimeMs = pinchEndUptimeMs;
        lastTransitionSucceeded.set(true);
        usedZoomFallback.set(true);
        final Context appContext = context;
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> scheduleStaggeredZoom(splitPolicy, appContext, classLoader, handler, 0));
        Activity activity = getContainerActivity(splitPolicy, context);
        if (activity != null) {
            scheduleZoomCanvasDismiss(activity, classLoader);
        }
        XposedBridge.log(TAG + ": early split zoom at pinch end, tasks=" + taskIdsToString(lastZoomTaskIds));
    }

    public static Activity getContainerActivity(Object splitPolicy, Context context) {
        if (splitPolicy == null) {
            return null;
        }
        try {
            Object containerView = SplitPolicyCompat.findContainerView(splitPolicy);
            if (containerView == null) {
                return null;
            }
            Context viewContext = containerView instanceof View
                    ? ((View) containerView).getContext()
                    : context;
            if (viewContext == null) {
                return null;
            }
            Object activity = XposedHelpers.callMethod(containerView, "Q2", viewContext);
            if (activity instanceof Activity) {
                return (Activity) activity;
            }
            return null;
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": getContainerActivity failed: " + throwable);
            return null;
        }
    }

    public static boolean runSplitZoomTransition(final Object splitPolicy, Context context, final ClassLoader classLoader) {
        lastTransitionSucceeded.set(false);
        usedZoomFallback.set(false);
        lastZoomTaskIds = new int[0];
        if (earlySplitZoomActive.get()) {
            XposedBridge.log("PsCanvasFix: split zoom already started early, skip T()");
            return true;
        }
        if (context == null) {
            context = resolveContext(splitPolicy, null, classLoader);
        }
        if (context == null) {
            return false;
        }
        final Context zoomContext = context;
        zoomCanvasDismissScheduled.set(false);
        pinchEndUptimeMs = SystemClock.uptimeMillis();
        lastZoomInvokeUptimeMs = pinchEndUptimeMs;
        lastSplitPolicy = splitPolicy;
        lastZoomTaskIds = extractZoomTargetTaskIds(splitPolicy);
        if (lastZoomTaskIds.length == 0) {
            XposedBridge.log(TAG + ": split zoom aborted, no embedded tasks");
            return false;
        }
        SplitPolicyCompat.hideCanvasImmediately(splitPolicy);
        SplitPolicyCompat.clearFlexibleAnimating(splitPolicy);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlexibleTransitionCompat.scheduleStaggeredZoom(splitPolicy, zoomContext, classLoader, handler, 0);
            }
        });
        Activity activity = getContainerActivity(splitPolicy, zoomContext);
        if (activity != null) {
            scheduleZoomCanvasDismiss(activity, classLoader);
        }
        lastTransitionSucceeded.set(true);
        usedZoomFallback.set(true);
        XposedBridge.log("PsCanvasFix: split zoom-only path started for tasks=" + taskIdsToString(lastZoomTaskIds));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scheduleStaggeredZoom(final Object splitPolicy, final Context context, final ClassLoader classLoader, final Handler handler, final int index) {
        List<Object> entries = SplitPolicyCompat.getEmbeddedTransitionEntries(splitPolicy);
        if (index >= entries.size()) {
            return;
        }
        invokeZoomForEntry(entries.get(index), context, classLoader);
        if (index + 1 < entries.size()) {
            handler.postDelayed(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    FlexibleTransitionCompat.scheduleStaggeredZoom(splitPolicy, context, classLoader, handler, index + 1);
                }
            }, 16L);
        }
    }

    private static void invokeZoomForEntry(Object entry, Context context, ClassLoader classLoader) {
        int taskId = SplitPolicyCompat.getTaskId(entry);
        Rect launchBounds = SplitPolicyCompat.getLaunchBounds(entry);
        if (taskId <= 0 || launchBounds == null) {
            return;
        }
        if (hasFlexibleLaunchScenario(classLoader, taskId) || isTaskFlexible(classLoader, taskId)) {
            XposedBridge.log("PsCanvasFix: skip zoom for taskId=" + taskId + " already flexible");
            return;
        }
        Rect maxBounds = ConfigCompat.getMaxBounds(context.getResources().getConfiguration(), context);
        Rect bounds = clampRect(launchBounds, maxBounds);
        float scale = SplitPolicyCompat.getLaunchScale(entry);
        lastZoomInvokeUptimeMs = SystemClock.uptimeMillis();
        try {
            XposedHelpers.callStaticMethod(XposedHelpers.findClass("B1.l", context.getClassLoader()), "g", new Object[]{Integer.valueOf(taskId), bounds, Float.valueOf(scale)});
            XposedBridge.log("PsCanvasFix: zoom taskId=" + taskId + " bounds=" + bounds + " scale=" + scale);
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: zoom failed for taskId=" + taskId + ": " + throwable);
        }
    }

    public static boolean evaluateTransitionResult(Object splitPolicy, boolean toggleReturned, ClassLoader classLoader) {
        lastTransitionSucceeded.set(false);
        if (!toggleReturned) {
            PsCanvasLog.d("toggleMultiFlexibleWindowFromCanvas returned false");
            SplitPolicyCompat.clearTransitionActive();
            return false;
        }
        int[] taskIds = SplitPolicyCompat.extractTaskIds(splitPolicy);
        if (SplitPolicyCompat.isAllZeroTaskIds(taskIds)) {
            taskIds = SplitPolicyCompat.getRememberedEmbeddedTaskIds();
        }
        if (hasValidTaskIds(taskIds)) {
            markTransitionSucceeded(true);
            PsCanvasLog.d("502-style transition success taskIds=" + taskIdsToString(taskIds));
            return true;
        }
        if (waitForFlexibleTasks(classLoader, taskIds, TRANSITION_POLL_ATTEMPTS)) {
            markTransitionSucceeded(true);
            PsCanvasLog.d("flexible tasks detected after toggleMulti");
            return true;
        }
        Context context = SplitPolicyCompat.findContext(splitPolicy);
        if (context == null) {
            context = resolveContext(splitPolicy, null, classLoader);
        }
        PsCanvasLog.d("flexible transition failed, keeping canvas open");
        SplitPolicyCompat.clearTransitionActive();
        return false;
    }

    /** 502 D(): trust WM toggle and finish canvas quickly after animation. */
    public static void scheduleFinish502Style(final Activity activity, final ClassLoader classLoader) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!wasLastTransitionSucceeded()) {
            PsCanvasLog.d("skip 502 finish, transition not verified");
            return;
        }
        if (wasZoomFallbackUsed()) {
            scheduleZoomCanvasDismiss(activity, classLoader);
            return;
        }
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(() ->
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        finish502Container(activity, classLoader);
                    }
                }, 150L));
    }

    private static void finish502Container(Activity activity, ClassLoader classLoader) {
        try {
            safeCall(activity, "L1", true);
            activity.finish();
            SplitPolicyCompat.clearTransitionActive();
            PsCanvasLog.d("502-style finish ContainerActivity");
            final int taskId = (Integer) XposedHelpers.callMethod(activity, "u0");
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (!AtmCompat.removeTask(classLoader, taskId)) {
                    PsCanvasLog.d("502 finish removeTask skipped taskId=" + taskId);
                }
            }, 300L);
        } catch (Throwable throwable) {
            PsCanvasLog.e("502-style finish failed", throwable);
        }
    }

    private static void safeCall(Object target, String methodName, Object... args) {
        try {
            XposedHelpers.callMethod(target, methodName, args);
        } catch (Throwable throwable) {
            PsCanvasLog.e(methodName + "() failed", throwable);
        }
    }

    private static boolean hasValidTaskIds(int[] taskIds) {
        if (taskIds == null) {
            return false;
        }
        int validCount = 0;
        for (int taskId : taskIds) {
            if (taskId > 0) {
                validCount++;
            }
        }
        return validCount >= 2;
    }

    public static void scheduleFinishAfterTransition(final Activity activity, final int[] taskIds, final ClassLoader classLoader) {
        if (activity == null) {
            return;
        }
        if (!wasLastTransitionSucceeded()) {
            XposedBridge.log("PsCanvasFix: skip delayed finish, transition not verified");
        } else if (wasZoomFallbackUsed()) {
            scheduleZoomCanvasDismiss(activity, classLoader);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    FlexibleTransitionCompat.waitForFlexibleTasksThenFinish(activity, taskIds, classLoader, 0);
                }
            }, 500L);
        }
    }

    public static void scheduleZoomCanvasDismiss(final Activity activity, final ClassLoader classLoader) {
        if (activity == null || !zoomCanvasDismissScheduled.compareAndSet(false, true)) {
            return;
        }
        final int[] taskIds = lastZoomTaskIds;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                FlexibleTransitionCompat.waitForZoomDismissReady(activity, classLoader, taskIds, 0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void waitForZoomDismissReady(final Activity activity, final ClassLoader classLoader, final int[] zoomTaskIds, final int elapsedMs) {
        long sincePinch;
        long sinceLastZoom;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (pinchEndUptimeMs > 0) {
            sincePinch = SystemClock.uptimeMillis() - pinchEndUptimeMs;
        } else {
            sincePinch = elapsedMs;
        }
        if (lastZoomInvokeUptimeMs > 0) {
            sinceLastZoom = SystemClock.uptimeMillis() - lastZoomInvokeUptimeMs;
        } else {
            sinceLastZoom = elapsedMs;
        }
        if (sincePinch >= 300 && sinceLastZoom >= 250 && allZoomTargetsFlexible(classLoader, zoomTaskIds) && areZoomTargetsAnimationIdle(classLoader, zoomTaskIds)) {
            dismissCanvasAfterSettle(activity, classLoader, zoomTaskIds);
        } else if (elapsedMs >= ZOOM_DISMISS_MAX_WAIT_MS) {
            XposedBridge.log("PsCanvasFix: zoom dismiss timeout after " + elapsedMs + "ms, flexible=" + countFlexibleTasks(classLoader, zoomTaskIds) + "/" + (zoomTaskIds == null ? 0 : zoomTaskIds.length));
            dismissCanvasAfterSettle(activity, classLoader, zoomTaskIds);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FlexibleTransitionCompat.waitForZoomDismissReady(activity, classLoader, zoomTaskIds, elapsedMs + FlexibleTransitionCompat.TRANSITION_POLL_INTERVAL_MS);
                }
            }, 50L);
        }
    }

    private static void dismissCanvasAfterSettle(Activity activity, ClassLoader classLoader, int[] zoomTaskIds) {
        long sincePinch;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        earlySplitZoomActive.set(false);
        int canvasTaskId = (Integer) XposedHelpers.callMethod(activity, "u0");
        detachEmbeddedTasksFromCanvas(classLoader, zoomTaskIds);
        if (!AtmCompat.removeTask(classLoader, canvasTaskId)) {
            XposedBridge.log("PsCanvasFix: zoom dismiss removeTask failed, taskId=" + canvasTaskId);
            return;
        }
        if (pinchEndUptimeMs > 0) {
            sincePinch = SystemClock.uptimeMillis() - pinchEndUptimeMs;
        } else {
            sincePinch = -1;
        }
        long sinceLastZoom = lastZoomInvokeUptimeMs > 0 ? SystemClock.uptimeMillis() - lastZoomInvokeUptimeMs : -1L;
        scheduleMaskClearAfterRemove(lastSplitPolicy);
        XposedBridge.log("PsCanvasFix: removed canvas task after zoom settle pinch+" + sincePinch + "ms lastZoom+" + sinceLastZoom + "ms");
    }

    private static void detachEmbeddedTasksFromCanvas(ClassLoader classLoader, int[] zoomTaskIds) {
        int[] taskIds;
        if (zoomTaskIds != null && zoomTaskIds.length > 0) {
            taskIds = zoomTaskIds;
        } else {
            taskIds = lastZoomTaskIds;
        }
        for (int taskId : taskIds) {
            if (taskId > 0) {
                try {
                    XposedHelpers.callStaticMethod(XposedHelpers.findClass("B1.l", classLoader), "p1", new Object[]{Integer.valueOf(taskId)});
                    XposedBridge.log("PsCanvasFix: X0 detach embedded taskId=" + taskId);
                } catch (Throwable throwable) {
                    XposedBridge.log("PsCanvasFix: X0 detach failed taskId=" + taskId + ": " + throwable);
                }
            }
        }
    }

    private static void scheduleMaskClearAfterRemove(final Object splitPolicy) {
        if (splitPolicy == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FlexibleTransitionCompat.resetSplitToFlexibleMask(splitPolicy);
            }
        }, 100L);
    }

    private static int[] extractZoomTargetTaskIds(Object splitPolicy) {
        List<Object> entries = SplitPolicyCompat.getEmbeddedTransitionEntries(splitPolicy);
        if (!entries.isEmpty()) {
            int[] taskIds = new int[entries.size()];
            for (int index = 0; index < entries.size(); index++) {
                taskIds[index] = SplitPolicyCompat.getTaskId(entries.get(index));
            }
            return taskIds;
        }
        java.util.Set<Integer> embeddedTaskIds = SplitPolicyCompat.getEmbeddedCanvasTaskIds(splitPolicy);
        if (!embeddedTaskIds.isEmpty()) {
            int[] taskIds = new int[embeddedTaskIds.size()];
            int index = 0;
            for (Integer taskId : embeddedTaskIds) {
                taskIds[index++] = taskId;
            }
            return taskIds;
        }
        return SplitPolicyCompat.extractTaskIds(splitPolicy);
    }

    private static boolean areZoomTargetsAnimationIdle(ClassLoader classLoader, int[] taskIds) {
        if (taskIds == null || taskIds.length == 0) {
            return true;
        }
        for (int taskId : taskIds) {
            if (taskId > 0 && readFlexibleAnimatingType(classLoader, taskId) != FLEXIBLE_ANIMATING_IDLE) {
                return false;
            }
        }
        return true;
    }

    private static int readFlexibleAnimatingType(ClassLoader classLoader, int taskId) {
        List<?> appInfos = null;
        try {
            Object manager = XposedHelpers.callStaticMethod(XposedHelpers.findClass("android.app.OplusActivityTaskManager", classLoader), "getInstance", new Object[0]);
            appInfos = (List) XposedHelpers.callMethod(manager, "getAllTopAppInfos", new Object[0]);
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: readFlexibleAnimatingType failed: " + throwable);
        }
        if (appInfos == null) {
            return FLEXIBLE_ANIMATING_IDLE;
        }
        for (Object appInfo : appInfos) {
            if (XposedHelpers.getIntField(appInfo, "taskId") == taskId) {
                Object extension = XposedHelpers.getObjectField(appInfo, "extension");
                return extension instanceof Bundle ? ((Bundle) extension).getInt("key_flexible_task_animating_type", FLEXIBLE_ANIMATING_IDLE) : FLEXIBLE_ANIMATING_IDLE;
            }
        }
        return FLEXIBLE_ANIMATING_IDLE;
    }

    private static boolean allZoomTargetsFlexible(ClassLoader classLoader, int[] taskIds) {
        if (taskIds == null || taskIds.length == 0) {
            return true;
        }
        int flexibleCount = 0;
        int requiredCount = 0;
        for (int taskId : taskIds) {
            if (taskId > 0) {
                requiredCount++;
                if (isTaskFlexible(classLoader, taskId) || hasFlexibleLaunchScenario(classLoader, taskId)) {
                    flexibleCount++;
                }
            }
        }
        return requiredCount == 0 || flexibleCount >= requiredCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void waitForFlexibleTasksThenFinish(final Activity activity, final int[] taskIds, final ClassLoader classLoader, final int elapsedMs) {
        if (activity.isFinishing()) {
            return;
        }
        if (taskIds != null && taskIds.length > 0 && countFlexibleTasks(classLoader, taskIds) > 0) {
            finishContainer(activity);
        } else if (elapsedMs >= FLEXIBLE_VERIFY_TIMEOUT_MS) {
            XposedBridge.log("PsCanvasFix: flexible tasks not detected after " + elapsedMs + "ms, skip finish to avoid flash to desktop");
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.color.pscanvasfix.compat.FlexibleTransitionCompat$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    FlexibleTransitionCompat.waitForFlexibleTasksThenFinish(activity, taskIds, classLoader, elapsedMs + 100);
                }
            }, 100L);
        }
    }

    public static int[] extractTaskIdsFromSplitPolicy(Object splitPolicy) {
        return SplitPolicyCompat.extractTaskIds(splitPolicy);
    }

    private static boolean waitForFlexibleTasks(ClassLoader classLoader, int[] taskIds, int attempts) {
        for (int attempt = 0; attempt < attempts; attempt++) {
            if (taskIds != null && taskIds.length > 0 && countFlexibleTasks(classLoader, taskIds) > 0) {
                return true;
            }
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }

    private static boolean tryPerTaskZoomFallback(Object splitPolicy, Context context, ClassLoader classLoader) {
        if (splitPolicy == null || context == null) {
            return false;
        }
        scheduleStaggeredZoom(splitPolicy, context, classLoader, new Handler(Looper.getMainLooper()), 0);
        return !SplitPolicyCompat.getEmbeddedTransitionEntries(splitPolicy).isEmpty();
    }

    private static String taskIdsToString(int[] taskIds) {
        if (taskIds == null || taskIds.length == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int index = 0; index < taskIds.length; index++) {
            if (index > 0) {
                builder.append(',');
            }
            builder.append(taskIds[index]);
        }
        return builder.append(']').toString();
    }

    private static int countFlexibleTasks(ClassLoader classLoader, int[] taskIds) {
        int count = 0;
        for (int taskId : taskIds) {
            if (taskId > 0 && (isTaskFlexible(classLoader, taskId) || hasFlexibleLaunchScenario(classLoader, taskId))) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasFlexibleLaunchScenario(ClassLoader classLoader, int taskId) {
        List<?> appInfos = null;
        try {
            Object manager = XposedHelpers.callStaticMethod(XposedHelpers.findClass("android.app.OplusActivityTaskManager", classLoader), "getInstance", new Object[0]);
            appInfos = (List) XposedHelpers.callMethod(manager, "getAllTopAppInfos", new Object[0]);
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: hasFlexibleLaunchScenario failed: " + throwable);
        }
        if (appInfos == null) {
            return false;
        }
        for (Object appInfo : appInfos) {
            if (XposedHelpers.getIntField(appInfo, "taskId") == taskId) {
                Object extension = XposedHelpers.getObjectField(appInfo, "extension");
                if (extension instanceof Bundle) {
                    return ((Bundle) extension).getInt("launchScenario", 0) == 1;
                }
                return false;
            }
        }
        return false;
    }

    private static boolean isTaskFlexible(ClassLoader classLoader, int taskId) {
        for (Object runningTask : AtmCompat.getTasks(classLoader, 20, false)) {
            if (XposedHelpers.getIntField(runningTask, "taskId") == taskId) {
                int windowingMode = readWindowingMode(runningTask);
                return windowingMode == 100 || windowingMode == WINDOWING_MODE_FREEFORM || windowingMode == WINDOWING_MODE_PINNED;
            }
        }
        return false;
    }

    private static int readWindowingMode(Object runningTask) {
        Object windowConfiguration;
        try {
            Object config = XposedHelpers.getObjectField(runningTask, "configuration");
            if ((config instanceof Configuration) && (windowConfiguration = ConfigCompat.getWindowConfigurationObject((Configuration) config)) != null) {
                return ((Integer) XposedHelpers.callMethod(windowConfiguration, "getWindowingMode", new Object[0])).intValue();
            }
        } catch (Throwable throwable) {
            XposedBridge.log("PsCanvasFix: readWindowingMode failed: " + throwable);
        }
        return 0;
    }

    private static void finishContainer(Activity activity) {
        try {
            XposedHelpers.callMethod(activity, "E1", true, 0);
            activity.finish();
            XposedBridge.log(TAG + ": finish ContainerActivity after flexible verify");
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": finish ContainerActivity failed: " + throwable);
        }
    }

    public static Object findFieldValueByType(Object instance, Class<?> type) {
        if (instance == null || type == null) {
            return null;
        }
        for (Class<?> current = instance.getClass(); current != null; current = current.getSuperclass()) {
            for (Field field : current.getDeclaredFields()) {
                if (type.isAssignableFrom(field.getType())) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(instance);
                        if (value != null) {
                            return value;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
        return null;
    }

    public static void injectDisplayBoundsIntoIntents(List<?> intents, Context context) {
        if (intents == null || context == null) {
            return;
        }
        Rect bounds = ConfigCompat.getBounds(context.getResources().getConfiguration(), context);
        for (Object intent : intents) {
            if (intent instanceof Intent) {
                ((Intent) intent).putExtra("ps_config_display_bound", bounds);
            }
        }
    }

    private static boolean isOversizedLaunchBounds(Rect launchBounds, Rect visualBounds, Rect maxBounds) {
        if (launchBounds == null || visualBounds == null || !isValid(launchBounds) || !isValid(visualBounds)) {
            return false;
        }
        if (launchBounds.width() >= maxBounds.width() * 0.85f) {
            return visualBounds.width() < launchBounds.width() * 0.6f;
        }
        return launchBounds.width() * launchBounds.height()
                > visualBounds.width() * visualBounds.height() * 2.5f;
    }

    private static Rect deriveLaunchBoundsFromVisual(Rect visualBounds, float expandRatio, Rect maxBounds) {
        if (visualBounds == null || !isValid(visualBounds)) {
            return null;
        }
        int width = Math.max(1, Math.round(visualBounds.width() * expandRatio));
        int height = Math.max(1, Math.round(visualBounds.height() * expandRatio));
        int centerX = visualBounds.centerX();
        int centerY = visualBounds.centerY();
        Rect derived = new Rect(
                centerX - width / 2,
                centerY - height / 2,
                centerX + width / 2,
                centerY + height / 2);
        return clampRect(derived, maxBounds);
    }

    private static Rect clampRect(Rect source, Rect maxBounds) {
        if (source == null || !isValid(source)) {
            return source == null ? new Rect() : new Rect(source);
        }
        Rect rect = new Rect(source);
        if (rect.right > maxBounds.right) {
            int width = rect.width();
            rect.right = maxBounds.right;
            rect.left = rect.right - width;
        }
        int width2 = rect.left;
        if (width2 < maxBounds.left) {
            int width3 = rect.width();
            rect.left = maxBounds.left;
            rect.right = rect.left + width3;
        }
        int width4 = rect.bottom;
        if (width4 > maxBounds.bottom) {
            int height = rect.height();
            rect.bottom = maxBounds.bottom;
            rect.top = rect.bottom - height;
        }
        if (rect.top < maxBounds.top) {
            int height2 = rect.height();
            rect.top = maxBounds.top;
            rect.bottom = rect.top + height2;
        }
        if (!isValid(rect)) {
            float scale = Math.min(maxBounds.width() / source.width(), maxBounds.height() / source.height());
            int width5 = Math.max(1, Math.round(source.width() * scale));
            int height3 = Math.max(1, Math.round(source.height() * scale));
            int centerX = source.centerX();
            int centerY = source.centerY();
            rect.set(centerX - (width5 / 2), centerY - (height3 / 2), (centerX - (width5 / 2)) + width5, (centerY - (height3 / 2)) + height3);
            rect.intersect(maxBounds);
        }
        return rect;
    }

    private static ArrayList<?> readLaunchBoundsList(Bundle bundle) {
        ArrayList<?> launchList = bundle.getParcelableArrayList("androidx.canvas.to.multi.flexible.launch.bounds.list", Bundle.class);
        if (launchList != null) {
            return launchList;
        }
        return bundle.getParcelableArrayList("androidx.canvas.to.multi.flexible.launch.bounds.list");
    }

    private static boolean isValid(Rect rect) {
        return rect != null && rect.width() > 0 && rect.height() > 0;
    }
}
