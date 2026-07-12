package androidx.activity;

import android.view.View;

/* loaded from: classes.dex */
public abstract class m {
    public static final void a(View view, k kVar) {
        D2.k.e(view, "<this>");
        D2.k.e(kVar, "onBackPressedDispatcherOwner");
        view.setTag(l.f3390a, kVar);
    }
}
