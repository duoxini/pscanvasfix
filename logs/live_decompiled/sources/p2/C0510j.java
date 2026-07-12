package p2;

import java.io.Serializable;

/* renamed from: p2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0510j implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    private final Object f12801e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f12802f;

    public C0510j(Object obj, Object obj2) {
        this.f12801e = obj;
        this.f12802f = obj2;
    }

    public final Object a() {
        return this.f12801e;
    }

    public final Object b() {
        return this.f12802f;
    }

    public final Object c() {
        return this.f12801e;
    }

    public final Object d() {
        return this.f12802f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0510j)) {
            return false;
        }
        C0510j c0510j = (C0510j) obj;
        return D2.k.a(this.f12801e, c0510j.f12801e) && D2.k.a(this.f12802f, c0510j.f12802f);
    }

    public int hashCode() {
        Object obj = this.f12801e;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f12802f;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f12801e + ", " + this.f12802f + ')';
    }
}
