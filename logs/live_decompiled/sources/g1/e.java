package g1;

import d1.AbstractC0336a;
import java.util.List;

/* loaded from: classes.dex */
public class e implements m {

    /* renamed from: a, reason: collision with root package name */
    private final List f11675a;

    public e(List list) {
        this.f11675a = list;
    }

    @Override // g1.m
    public AbstractC0336a a() {
        return ((n1.c) this.f11675a.get(0)).i() ? new d1.k(this.f11675a) : new d1.j(this.f11675a);
    }

    @Override // g1.m
    public List b() {
        return this.f11675a;
    }

    @Override // g1.m
    public boolean c() {
        return this.f11675a.size() == 1 && ((n1.c) this.f11675a.get(0)).i();
    }
}
