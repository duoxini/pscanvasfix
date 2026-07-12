package androidx.core.util;

/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: c, reason: collision with root package name */
    private final Object f5016c;

    public g(int i3) {
        super(i3);
        this.f5016c = new Object();
    }

    @Override // androidx.core.util.f, androidx.core.util.e
    public boolean a(Object obj) {
        boolean a3;
        synchronized (this.f5016c) {
            a3 = super.a(obj);
        }
        return a3;
    }

    @Override // androidx.core.util.f, androidx.core.util.e
    public Object b() {
        Object b3;
        synchronized (this.f5016c) {
            b3 = super.b();
        }
        return b3;
    }
}
