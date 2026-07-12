package androidx.window.layout;

import D2.k;
import java.util.List;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class WindowLayoutInfo {

    /* renamed from: a, reason: collision with root package name */
    private final List f7191a;

    public WindowLayoutInfo(List list) {
        k.e(list, "displayFeatures");
        this.f7191a = list;
    }

    public final List a() {
        return this.f7191a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !k.a(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return k.a(this.f7191a, ((WindowLayoutInfo) obj).f7191a);
    }

    public int hashCode() {
        return this.f7191a.hashCode();
    }

    public String toString() {
        return AbstractC0544n.v(this.f7191a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
