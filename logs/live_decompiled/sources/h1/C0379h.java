package h1;

/* renamed from: h1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0379h {

    /* renamed from: a, reason: collision with root package name */
    private final a f11915a;

    /* renamed from: b, reason: collision with root package name */
    private final g1.h f11916b;

    /* renamed from: c, reason: collision with root package name */
    private final g1.d f11917c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f11918d;

    /* renamed from: h1.h$a */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public C0379h(a aVar, g1.h hVar, g1.d dVar, boolean z3) {
        this.f11915a = aVar;
        this.f11916b = hVar;
        this.f11917c = dVar;
        this.f11918d = z3;
    }

    public a a() {
        return this.f11915a;
    }

    public g1.h b() {
        return this.f11916b;
    }

    public g1.d c() {
        return this.f11917c;
    }

    public boolean d() {
        return this.f11918d;
    }
}
