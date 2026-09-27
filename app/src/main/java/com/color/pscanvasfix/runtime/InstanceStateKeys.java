package com.color.pscanvasfix.runtime;

/** Central registry for module-private per-instance state keys. */
public final class InstanceStateKeys {
    public static final InstanceStateStore.Key<Boolean> NEW_THREE_SPLIT_LEFT_ANCHOR =
            InstanceStateStore.Key.of(
                    "pscanvasfix_new_three_split_left_anchor", Boolean.class);

    public static final InstanceStateStore.Key<Boolean> DIRECT_NEW_THREE_SPLIT_ENTRY =
            InstanceStateStore.Key.of(
                    "pscanvasfix_direct_new_three_split_entry", Boolean.class);

    private InstanceStateKeys() {
    }
}
