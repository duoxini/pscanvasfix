package a1;

import java.util.Arrays;

/* renamed from: a1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0224d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3219a;

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f3220b;

    public C0224d(Object obj) {
        this.f3219a = obj;
        this.f3220b = null;
    }

    public Throwable a() {
        return this.f3220b;
    }

    public Object b() {
        return this.f3219a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0224d)) {
            return false;
        }
        C0224d c0224d = (C0224d) obj;
        if (b() != null && b().equals(c0224d.b())) {
            return true;
        }
        if (a() == null || c0224d.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public C0224d(Throwable th) {
        this.f3220b = th;
        this.f3219a = null;
    }
}
