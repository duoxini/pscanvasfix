package com.color.pscanvasfix.feature.resize;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.hook.PsCanvasSymbols;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.PackageLoadContext;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/** Persists two-task ratio and updates two/three-task deterministic shortcuts. */
public final class SavedSplitLayoutFeature {
    public static final String EXTRA_SAVED_LAYOUT =
            "com.color.pscanvasfix.extra.SAVED_SPLIT_LAYOUT";

    public static final String HOOK_SAVE_CONTEXT = "saved_layout.save_context";
    public static final String HOOK_BUILD_PAYLOAD = "saved_layout.build_payload";
    public static final String HOOK_EXISTING_REENABLE = "saved_layout.existing_reenable";
    public static final String HOOK_SHORTCUT_ID = "saved_layout.shortcut_id";
    public static final String HOOK_SHORTCUT_EXTRAS = "saved_layout.shortcut_extras";
    public static final String HOOK_UPDATE_OR_PIN = "saved_layout.update_or_pin";
    public static final String HOOK_ACTIVITY_RESET = "saved_layout.activity_reset";
    public static final String HOOK_ACTIVITY_NEW_INTENT = "saved_layout.activity_new_intent";
    public static final String HOOK_RESTORE_RATIO = "saved_layout.restore_ratio";

    private static final String SPLIT_RATIO = "androidx.flexible.SplitRatio";
    private static final String LAYOUT_ORIENTATION = "androidx.flexible.layoutOrientation";
    private static final String INTENT_LIST = "androidx.flexible.intentList";
    private static final String USER_ID_LIST = "androidx.flexible.userIdList";
    private static final String WRITE_PATH_EXTRA = "saved_layout.write_path";
    private static final String WRITE_SHORTCUT_ID_EXTRA = "saved_layout.write_shortcut_id";
    private static final String WRITE_CONTEXT_EXTRA = "saved_layout.write_context";
    private static final String LAUNCHER_SAVED_TOAST_RESOURCE = "shortcut_has_been_saved";
    private static final int RATIO_SCALE = 10_000;
    private static final ThreadLocal<SaveState> SAVE_STATE = new ThreadLocal<>();
    private static final ThreadLocal<String> RESTORE_SHORTCUT_ID = new ThreadLocal<>();
    private static volatile String activeShortcutId;

    private SavedSplitLayoutFeature() {
    }

    public static void declareHooks(HookRegistry registry) {
        registry.declare(HOOK_SAVE_CONTEXT,
                "shortcut manager save(List,int,int,ContainerView); before/after");
        registry.declare(HOOK_BUILD_PAYLOAD,
                "shortcut manager build(String[],int[],...); before");
        registry.declare(HOOK_EXISTING_REENABLE,
                "shortcut manager exists(List); after; allow deterministic update");
        registry.declare(HOOK_SHORTCUT_ID,
                "ShortcutInfo.Builder(Context,String); before; retain launched shortcut id");
        registry.declare(HOOK_SHORTCUT_EXTRAS,
                "ShortcutInfo.Builder.setExtras(PersistableBundle); before");
        registry.declare(HOOK_UPDATE_OR_PIN,
                "ShortcutManager.requestPinShortcut; before; update matching pinned id");
        registry.declare(HOOK_ACTIVITY_RESET,
                "ContainerActivity.onCreate(Bundle); before; clear stale source on new launch");
        registry.declare(HOOK_ACTIVITY_NEW_INTENT,
                "ContainerActivity.onNewIntent(Intent); before; clear previous shortcut source");
        registry.declare(HOOK_RESTORE_RATIO,
                "ContainerActivity restore(Bundle); before");
    }

    public static boolean install(PackageLoadContext loadContext,
                                  HookRuntime runtime,
                                  HookRegistry registry,
                                  ReflectionAccess reflection,
                                  PsCanvasSymbols.RoleSymbol symbols,
                                  boolean enabled) {
        if (!enabled || symbols == null || !symbols.available()) {
            String detail = enabled ? "saved-layout capability unavailable"
                    : "adjustable_window_size disabled";
            markAllSkipped(registry, detail);
            return false;
        }

        HookRuntime.Group group = runtime.beginGroup("saved_split_layout_atomic");
        try {
            Class<?> containerView = reflection.findClass(
                    "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView",
                    loadContext.classLoader);

            runtime.findAndHookMethod(HOOK_SAVE_CONTEXT,
                    symbols.className, loadContext.classLoader,
                    symbols.savedLayoutSaveMethod,
                    List.class, Integer.TYPE, Integer.TYPE, containerView,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            SAVE_STATE.remove();
                            List<?> tasks = asList(call.args[0]);
                            if (tasks == null || (tasks.size() != 2 && tasks.size() != 3)) {
                                return;
                            }
                            int layoutOrientation = (Integer) call.args[2];
                            if (tasks.size() == 3) {
                                // Three-task resizing is a discrete OEM layout transition. The
                                // shortcut builder already serializes its orientation, focus and
                                // use-max arrays; this marker lets us replace the existing pinned
                                // shortcut so those refreshed OEM extras are actually retained.
                                SAVE_STATE.set(new SaveState(3, layoutOrientation,
                                        new int[]{RATIO_SCALE / 3, (RATIO_SCALE * 2) / 3}));
                                return;
                            }
                            Object ratioValue = reflection.callMethod(
                                    call.args[3], "getSplitRatio");
                            if (!(ratioValue instanceof Number)) {
                                return;
                            }
                            float ratio = ((Number) ratioValue).floatValue();
                            if (!isValidTwoTaskRatio(ratio)) {
                                return;
                            }
                            SAVE_STATE.set(new SaveState(2, layoutOrientation,
                                    new int[]{Math.round(ratio * RATIO_SCALE)}));
                        }

                        @Override
                        protected void afterHookedMethod(HookCall call) {
                            SAVE_STATE.remove();
                        }
                    });

            runtime.findAndHookMethod(HOOK_BUILD_PAYLOAD,
                    symbols.className, loadContext.classLoader,
                    symbols.savedLayoutBuildMethod,
                    String[].class, int[].class, Integer.TYPE, Integer.TYPE,
                    boolean[].class, boolean[].class, List.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            SaveState state = SAVE_STATE.get();
                            if (state == null) {
                                return;
                            }
                            String fingerprint = fingerprint(
                                    (String[]) call.args[0], (int[]) call.args[1]);
                            if (fingerprint == null) {
                                SAVE_STATE.remove();
                                return;
                            }
                            state.payload = SavedSplitLayoutCodec.encode(
                                    new SavedSplitLayoutCodec.Layout(
                                            state.taskCount, state.layoutOrientation,
                                            state.dividerRatios, fingerprint));
                            String candidateId = shortcutId(
                                    (String[]) call.args[0], (int[]) call.args[1]);
                            if (sameShortcutMembers(candidateId, activeShortcutId)) {
                                state.targetShortcutId = activeShortcutId;
                            }
                        }
                    });

            runtime.findAndHookMethod(HOOK_EXISTING_REENABLE,
                    symbols.className, loadContext.classLoader,
                    symbols.savedLayoutExistsMethod, List.class,
                    new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall call) {
                            List<?> tasks = asList(call.args[0]);
                            if (tasks != null && (tasks.size() == 2 || tasks.size() == 3)
                                    && Boolean.TRUE.equals(call.getResult())) {
                                call.setResult(false);
                            }
                        }
                    });

            runtime.findAndHookConstructor(HOOK_SHORTCUT_ID,
                    ShortcutInfo.Builder.class, Context.class, String.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            SaveState state = SAVE_STATE.get();
                            if (state != null) {
                                if (call.args[0] instanceof Context) {
                                    state.context = (Context) call.args[0];
                                }
                                if (state.targetShortcutId != null) {
                                    call.args[1] = state.targetShortcutId;
                                }
                            }
                        }
                    });

            runtime.findAndHookMethod(HOOK_SHORTCUT_EXTRAS,
                    ShortcutInfo.Builder.class, "setExtras", PersistableBundle.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            SaveState state = SAVE_STATE.get();
                            if (state == null || state.payload == null
                                    || !(call.args[0] instanceof PersistableBundle)) {
                                return;
                            }
                            ((PersistableBundle) call.args[0]).putString(
                                    EXTRA_SAVED_LAYOUT, state.payload);
                        }
                    });

            runtime.findAndHookMethod(HOOK_UPDATE_OR_PIN,
                    ShortcutManager.class, "requestPinShortcut",
                    ShortcutInfo.class, IntentSender.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            SaveState state = SAVE_STATE.get();
                            if (state == null || state.payload == null
                                    || !(call.thisObject instanceof ShortcutManager)
                                    || !(call.args[0] instanceof ShortcutInfo)) {
                                return;
                            }
                            ShortcutManager manager = (ShortcutManager) call.thisObject;
                            ShortcutInfo candidate = (ShortcutInfo) call.args[0];
                            call.setObjectExtra(WRITE_PATH_EXTRA, ShortcutWritePath.PIN);
                            call.setObjectExtra(WRITE_SHORTCUT_ID_EXTRA, candidate.getId());
                            call.setObjectExtra(WRITE_CONTEXT_EXTRA, state.context);
                            for (ShortcutInfo pinned : manager.getPinnedShortcuts()) {
                                if (candidate.getId().equals(pinned.getId())) {
                                    boolean updated = manager.updateShortcuts(
                                            Collections.singletonList(candidate));
                                    call.setObjectExtra(
                                            WRITE_PATH_EXTRA, ShortcutWritePath.UPDATE);
                                    call.setResult(forcedRequestPinResult(
                                            ShortcutWritePath.UPDATE, updated));
                                    if (updated) {
                                        PsCanvasLog.i("[SavedLayout] updated pinned shortcut id="
                                                + candidate.getId());
                                    }
                                    return;
                                }
                            }
                        }

                        @Override
                        protected void afterHookedMethod(HookCall call) {
                            Object writePath = call.getObjectExtra(WRITE_PATH_EXTRA);
                            Object shortcutId = call.getObjectExtra(WRITE_SHORTCUT_ID_EXTRA);
                            Object context = call.getObjectExtra(WRITE_CONTEXT_EXTRA);
                            if (writePath instanceof ShortcutWritePath
                                    && shortcutId instanceof String
                                    && shouldRecordShortcutId(
                                    (ShortcutWritePath) writePath, call.getResult())) {
                                activeShortcutId = (String) shortcutId;
                                if (writePath == ShortcutWritePath.PIN) {
                                    PsCanvasLog.i("[SavedLayout] pinned shortcut accepted id="
                                            + shortcutId);
                                }
                            }
                            if (writePath instanceof ShortcutWritePath
                                    && context instanceof Context
                                    && shouldShowSavedToast(
                                    (ShortcutWritePath) writePath, call.getResult())) {
                                showLauncherSavedToast((Context) context);
                            }
                        }
                    });

            runtime.findAndHookMethod(HOOK_ACTIVITY_RESET,
                    symbols.savedLayoutRestoreClass, loadContext.classLoader,
                    symbols.savedLayoutActivityCreateMethod, Bundle.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            if (shouldResetShortcutState(ActivityLifecycleEvent.ON_CREATE,
                                    call.args[0])) {
                                clearShortcutLaunchState();
                            }
                        }
                    });

            runtime.findAndHookMethod(HOOK_ACTIVITY_NEW_INTENT,
                    symbols.savedLayoutRestoreClass, loadContext.classLoader,
                    symbols.savedLayoutActivityNewIntentMethod, Intent.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            if (shouldResetShortcutState(ActivityLifecycleEvent.ON_NEW_INTENT,
                                    null)) {
                                clearShortcutLaunchState();
                            }
                        }
                    });

            runtime.findAndHookMethod(HOOK_RESTORE_RATIO,
                    symbols.savedLayoutRestoreClass, loadContext.classLoader,
                    symbols.savedLayoutRestoreMethod, Bundle.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall call) {
                            if (!(call.args[0] instanceof Bundle)) {
                                return;
                            }
                            activeShortcutId = null;
                            RESTORE_SHORTCUT_ID.remove();
                            String shortcutId = deriveShortcutId((Bundle) call.args[0]);
                            if (shortcutId != null) {
                                RESTORE_SHORTCUT_ID.set(shortcutId);
                            }
                            restoreTwoTaskRatio((Bundle) call.args[0]);
                        }

                        @Override
                        protected void afterHookedMethod(HookCall call) {
                            String shortcutId = RESTORE_SHORTCUT_ID.get();
                            activeShortcutId = Boolean.TRUE.equals(call.getResult())
                                    ? shortcutId : null;
                            RESTORE_SHORTCUT_ID.remove();
                        }
                    });

            if (!runtime.commitGroup(group)) {
                markAllRolledBack(registry, "atomic registration rejected", null);
                return false;
            }
            markAllInstalled(registry, symbols);
            return true;
        } catch (Throwable throwable) {
            if (!group.isClosed()) {
                runtime.rollbackGroup(group);
            }
            markAllRolledBack(registry, "atomic registration failed", throwable);
            PsCanvasLog.e("[SavedLayout] hook group failed", throwable);
            return false;
        }
    }

    static boolean isValidTwoTaskRatio(float ratio) {
        return Float.isFinite(ratio) && ratio > 0.0f && ratio < 1.0f;
    }

    static String fingerprint(String[] packages, int[] userIds) {
        if (packages == null || userIds == null || packages.length == 0
                || packages.length != userIds.length) {
            return null;
        }
        StringBuilder value = new StringBuilder();
        for (int index = 0; index < packages.length; index++) {
            String packageName = packages[index];
            if (packageName == null || packageName.isEmpty()) {
                return null;
            }
            if (index > 0) {
                value.append('|');
            }
            value.append(packageName).append(':').append(userIds[index]);
        }
        return value.toString();
    }

    static String shortcutId(String[] packages, int[] userIds) {
        if (packages == null || userIds == null || packages.length == 0
                || packages.length != userIds.length) {
            return null;
        }
        StringBuilder value = new StringBuilder();
        for (int index = 0; index < packages.length; index++) {
            String packageName = packages[index];
            if (packageName == null || packageName.isEmpty()) {
                return null;
            }
            if (index > 0) {
                value.append('|');
            }
            value.append(packageName);
            if (userIds[index] != 0) {
                value.append(':').append(userIds[index]);
            }
        }
        return value.toString();
    }

    static boolean sameShortcutMembers(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        String[] firstMembers = first.split("\\|", -1);
        String[] secondMembers = second.split("\\|", -1);
        if (firstMembers.length != secondMembers.length) {
            return false;
        }
        Set<String> firstSet = new HashSet<>();
        Set<String> secondSet = new HashSet<>();
        Collections.addAll(firstSet, firstMembers);
        Collections.addAll(secondSet, secondMembers);
        return firstSet.size() == firstMembers.length && firstSet.equals(secondSet);
    }

    static boolean shouldResetShortcutState(ActivityLifecycleEvent event,
                                            Object savedInstanceState) {
        return event == ActivityLifecycleEvent.ON_NEW_INTENT
                || (event == ActivityLifecycleEvent.ON_CREATE && savedInstanceState == null);
    }

    static boolean shouldRecordShortcutId(ShortcutWritePath path, Object result) {
        return path != null && Boolean.TRUE.equals(result);
    }

    static boolean shouldShowSavedToast(ShortcutWritePath path, Object result) {
        // requestPinShortcut already asks the launcher to display this confirmation. Only the
        // module's in-place update bypasses that launcher flow and needs to replay its Toast.
        return path == ShortcutWritePath.UPDATE && Boolean.TRUE.equals(result);
    }

    static Boolean forcedRequestPinResult(ShortcutWritePath path, boolean updateResult) {
        return path == ShortcutWritePath.UPDATE ? updateResult : null;
    }

    private static void showLauncherSavedToast(Context context) {
        try {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN)
                    .addCategory(Intent.CATEGORY_HOME);
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo home = packageManager.resolveActivity(
                    homeIntent, PackageManager.MATCH_DEFAULT_ONLY);
            if (home == null || home.activityInfo == null) {
                PsCanvasLog.w("[SavedLayout] launcher saved Toast unavailable: no HOME activity");
                return;
            }
            String launcherPackage = home.activityInfo.packageName;
            Context launcherContext = context.createPackageContext(launcherPackage, 0);
            int messageId = launcherContext.getResources().getIdentifier(
                    LAUNCHER_SAVED_TOAST_RESOURCE, "string", launcherPackage);
            if (messageId == 0) {
                PsCanvasLog.w("[SavedLayout] launcher saved Toast resource unavailable package="
                        + launcherPackage);
                return;
            }
            Toast.makeText(context.getApplicationContext(),
                    launcherContext.getText(messageId), Toast.LENGTH_SHORT).show();
            PsCanvasLog.i("[SavedLayout] replayed launcher saved Toast package="
                    + launcherPackage);
        } catch (Throwable throwable) {
            PsCanvasLog.e("[SavedLayout] launcher saved Toast failed", throwable);
        }
    }

    private static void clearShortcutLaunchState() {
        activeShortcutId = null;
        SAVE_STATE.remove();
        RESTORE_SHORTCUT_ID.remove();
    }

    private static String deriveShortcutId(Bundle bundle) {
        int[] userIds = bundle.getIntArray(USER_ID_LIST);
        List<Intent> intents = bundle.getParcelableArrayList(INTENT_LIST, Intent.class);
        if (intents == null || userIds == null || intents.size() < 2
                || intents.size() > 3 || userIds.length < intents.size()) {
            return null;
        }
        String[] packages = new String[intents.size()];
        int[] exactUsers = new int[intents.size()];
        for (int index = 0; index < intents.size(); index++) {
            Intent intent = intents.get(index);
            if (intent == null) {
                return null;
            }
            packages[index] = intent.getComponent() == null
                    ? intent.getPackage() : intent.getComponent().getPackageName();
            exactUsers[index] = userIds[index];
        }
        return shortcutId(packages, exactUsers);
    }

    private static void restoreTwoTaskRatio(Bundle bundle) {
        String encoded = bundle.getString(EXTRA_SAVED_LAYOUT);
        Optional<SavedSplitLayoutCodec.Layout> decoded =
                SavedSplitLayoutCodec.decode(encoded);
        if (!decoded.isPresent()) {
            return;
        }
        SavedSplitLayoutCodec.Layout layout = decoded.get();
        if (layout.taskCount() != 2
                || layout.layoutOrientation() != bundle.getInt(LAYOUT_ORIENTATION, 0)) {
            return;
        }
        int[] userIds = bundle.getIntArray(USER_ID_LIST);
        List<Intent> intents = bundle.getParcelableArrayList(INTENT_LIST, Intent.class);
        if (intents == null || userIds == null || intents.size() != 2
                || userIds.length < intents.size()) {
            return;
        }
        String[] packages = new String[intents.size()];
        for (int index = 0; index < intents.size(); index++) {
            Intent intent = intents.get(index);
            if (intent == null) {
                return;
            }
            packages[index] = intent.getComponent() == null
                    ? intent.getPackage() : intent.getComponent().getPackageName();
        }
        int[] exactUsers = new int[intents.size()];
        System.arraycopy(userIds, 0, exactUsers, 0, exactUsers.length);
        if (!layout.slotOrderFingerprint().equals(fingerprint(packages, exactUsers))) {
            return;
        }
        int[] ratios = layout.dividerRatios();
        if (ratios.length != 1) {
            return;
        }
        bundle.putFloat(SPLIT_RATIO, ratios[0] / (float) RATIO_SCALE);
        PsCanvasLog.i("[SavedLayout] restored two-task ratio=" + ratios[0]);
    }

    @SuppressWarnings("unchecked")
    private static List<?> asList(Object value) {
        return value instanceof List<?> ? (List<?>) value : null;
    }

    private static void markAllInstalled(HookRegistry registry,
                                         PsCanvasSymbols.RoleSymbol symbols) {
        registry.markInstalled(HOOK_SAVE_CONTEXT, symbols.className + "."
                + symbols.savedLayoutSaveMethod);
        registry.markInstalled(HOOK_BUILD_PAYLOAD, symbols.className + "."
                + symbols.savedLayoutBuildMethod);
        registry.markInstalled(HOOK_EXISTING_REENABLE, symbols.className + "."
                + symbols.savedLayoutExistsMethod);
        registry.markInstalled(HOOK_SHORTCUT_ID, "ShortcutInfo.Builder(Context,String)");
        registry.markInstalled(HOOK_SHORTCUT_EXTRAS, "ShortcutInfo.Builder.setExtras");
        registry.markInstalled(HOOK_UPDATE_OR_PIN, "ShortcutManager.requestPinShortcut");
        registry.markInstalled(HOOK_ACTIVITY_RESET, symbols.savedLayoutRestoreClass
                + "." + symbols.savedLayoutActivityCreateMethod);
        registry.markInstalled(HOOK_ACTIVITY_NEW_INTENT, symbols.savedLayoutRestoreClass
                + "." + symbols.savedLayoutActivityNewIntentMethod);
        registry.markInstalled(HOOK_RESTORE_RATIO, symbols.savedLayoutRestoreClass + "."
                + symbols.savedLayoutRestoreMethod);
    }

    private static void markAllSkipped(HookRegistry registry, String detail) {
        registry.markSkipped(HOOK_SAVE_CONTEXT, detail);
        registry.markSkipped(HOOK_BUILD_PAYLOAD, detail);
        registry.markSkipped(HOOK_EXISTING_REENABLE, detail);
        registry.markSkipped(HOOK_SHORTCUT_ID, detail);
        registry.markSkipped(HOOK_SHORTCUT_EXTRAS, detail);
        registry.markSkipped(HOOK_UPDATE_OR_PIN, detail);
        registry.markSkipped(HOOK_ACTIVITY_RESET, detail);
        registry.markSkipped(HOOK_ACTIVITY_NEW_INTENT, detail);
        registry.markSkipped(HOOK_RESTORE_RATIO, detail);
    }

    private static void markAllRolledBack(HookRegistry registry, String detail,
                                          Throwable throwable) {
        registry.markRolledBack(HOOK_SAVE_CONTEXT, detail, throwable);
        registry.markRolledBack(HOOK_BUILD_PAYLOAD, detail, throwable);
        registry.markRolledBack(HOOK_EXISTING_REENABLE, detail, throwable);
        registry.markRolledBack(HOOK_SHORTCUT_ID, detail, throwable);
        registry.markRolledBack(HOOK_SHORTCUT_EXTRAS, detail, throwable);
        registry.markRolledBack(HOOK_UPDATE_OR_PIN, detail, throwable);
        registry.markRolledBack(HOOK_ACTIVITY_RESET, detail, throwable);
        registry.markRolledBack(HOOK_ACTIVITY_NEW_INTENT, detail, throwable);
        registry.markRolledBack(HOOK_RESTORE_RATIO, detail, throwable);
    }

    private static final class SaveState {
        final int taskCount;
        final int layoutOrientation;
        final int[] dividerRatios;
        String payload;
        String targetShortcutId;
        Context context;

        SaveState(int taskCount, int layoutOrientation, int[] dividerRatios) {
            this.taskCount = taskCount;
            this.layoutOrientation = layoutOrientation;
            this.dividerRatios = dividerRatios.clone();
        }
    }

    enum ActivityLifecycleEvent {
        ON_CREATE,
        ON_NEW_INTENT
    }

    enum ShortcutWritePath {
        UPDATE,
        PIN
    }
}
