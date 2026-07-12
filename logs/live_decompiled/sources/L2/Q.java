package L2;

/* loaded from: classes.dex */
final class Q implements InterfaceC0167a0 {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f1249e;

    public Q(boolean z3) {
        this.f1249e = z3;
    }

    @Override // L2.InterfaceC0167a0
    public boolean c() {
        return this.f1249e;
    }

    @Override // L2.InterfaceC0167a0
    public p0 d() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(c() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
