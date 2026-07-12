package g1;

import d1.AbstractC0336a;
import java.util.List;

/* loaded from: classes.dex */
public class i implements m {

    /* renamed from: a, reason: collision with root package name */
    private final C0366b f11676a;

    /* renamed from: b, reason: collision with root package name */
    private final C0366b f11677b;

    public i(C0366b c0366b, C0366b c0366b2) {
        this.f11676a = c0366b;
        this.f11677b = c0366b2;
    }

    @Override // g1.m
    public AbstractC0336a a() {
        return new d1.n(this.f11676a.a(), this.f11677b.a());
    }

    @Override // g1.m
    public List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // g1.m
    public boolean c() {
        return this.f11676a.c() && this.f11677b.c();
    }
}
