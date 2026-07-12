package L2;

/* loaded from: classes.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Q2.D f1291a = new Q2.D("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final Q2.D f1292b = new Q2.D("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    private static final Q2.D f1293c = new Q2.D("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    private static final Q2.D f1294d = new Q2.D("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    private static final Q2.D f1295e = new Q2.D("SEALED");

    /* renamed from: f, reason: collision with root package name */
    private static final Q f1296f = new Q(false);

    /* renamed from: g, reason: collision with root package name */
    private static final Q f1297g = new Q(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC0167a0 ? new C0169b0((InterfaceC0167a0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC0167a0 interfaceC0167a0;
        C0169b0 c0169b0 = obj instanceof C0169b0 ? (C0169b0) obj : null;
        return (c0169b0 == null || (interfaceC0167a0 = c0169b0.f1262a) == null) ? obj : interfaceC0167a0;
    }
}
