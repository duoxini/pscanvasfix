package androidx.transition;

import android.view.ViewGroup;

/* loaded from: classes.dex */
abstract class v {
    static u a(ViewGroup viewGroup) {
        return new t(viewGroup);
    }

    static void b(ViewGroup viewGroup, boolean z3) {
        viewGroup.suppressLayout(z3);
    }
}
