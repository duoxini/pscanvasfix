package v2;

import t2.InterfaceC0593d;

/* renamed from: v2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0612c implements InterfaceC0593d {

    /* renamed from: e, reason: collision with root package name */
    public static final C0612c f13850e = new C0612c();

    private C0612c() {
    }

    @Override // t2.InterfaceC0593d
    public t2.g getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // t2.InterfaceC0593d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
