package androidx.transition;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class k {
    public static k a(ViewGroup viewGroup) {
        androidx.appcompat.app.p.a(viewGroup.getTag(i.f6721b));
        return null;
    }

    static void b(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(i.f6721b, kVar);
    }
}
