package g1;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
abstract class n implements m {

    /* renamed from: a, reason: collision with root package name */
    final List f11691a;

    n(List list) {
        this.f11691a = list;
    }

    @Override // g1.m
    public List b() {
        return this.f11691a;
    }

    @Override // g1.m
    public boolean c() {
        if (this.f11691a.isEmpty()) {
            return true;
        }
        return this.f11691a.size() == 1 && ((n1.c) this.f11691a.get(0)).i();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f11691a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f11691a.toArray()));
        }
        return sb.toString();
    }
}
