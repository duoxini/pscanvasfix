package androidx.lifecycle;

import H.a;

/* loaded from: classes.dex */
public abstract class G {
    public static final H.a a(I i3) {
        D2.k.e(i3, "owner");
        if (!(i3 instanceof InterfaceC0271g)) {
            return a.C0013a.f454b;
        }
        H.a defaultViewModelCreationExtras = ((InterfaceC0271g) i3).getDefaultViewModelCreationExtras();
        D2.k.d(defaultViewModelCreationExtras, "{\n        owner.defaultV…ModelCreationExtras\n    }");
        return defaultViewModelCreationExtras;
    }
}
