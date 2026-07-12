package T2;

import Q2.D;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final D f2210a = new D("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    private static final D f2211b = new D("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z3) {
        return new b(z3);
    }

    public static /* synthetic */ a b(boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z3 = false;
        }
        return a(z3);
    }
}
