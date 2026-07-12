package h1;

import a1.C0221a;
import android.graphics.Paint;
import c1.t;
import g1.C0365a;
import g1.C0366b;
import i1.AbstractC0395b;
import java.util.List;

/* renamed from: h1.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0389r implements InterfaceC0374c {

    /* renamed from: a, reason: collision with root package name */
    private final String f11976a;

    /* renamed from: b, reason: collision with root package name */
    private final C0366b f11977b;

    /* renamed from: c, reason: collision with root package name */
    private final List f11978c;

    /* renamed from: d, reason: collision with root package name */
    private final C0365a f11979d;

    /* renamed from: e, reason: collision with root package name */
    private final g1.d f11980e;

    /* renamed from: f, reason: collision with root package name */
    private final C0366b f11981f;

    /* renamed from: g, reason: collision with root package name */
    private final b f11982g;

    /* renamed from: h, reason: collision with root package name */
    private final c f11983h;

    /* renamed from: i, reason: collision with root package name */
    private final float f11984i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f11985j;

    /* renamed from: h1.r$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11986a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f11987b;

        static {
            int[] iArr = new int[c.values().length];
            f11987b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11987b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11987b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            f11986a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11986a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11986a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: h1.r$b */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i3 = a.f11986a[ordinal()];
            return i3 != 1 ? i3 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* renamed from: h1.r$c */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i3 = a.f11987b[ordinal()];
            if (i3 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i3 == 2) {
                return Paint.Join.MITER;
            }
            if (i3 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public C0389r(String str, C0366b c0366b, List list, C0365a c0365a, g1.d dVar, C0366b c0366b2, b bVar, c cVar, float f3, boolean z3) {
        this.f11976a = str;
        this.f11977b = c0366b;
        this.f11978c = list;
        this.f11979d = c0365a;
        this.f11980e = dVar;
        this.f11981f = c0366b2;
        this.f11982g = bVar;
        this.f11983h = cVar;
        this.f11984i = f3;
        this.f11985j = z3;
    }

    @Override // h1.InterfaceC0374c
    public c1.c a(com.oplus.anim.n nVar, C0221a c0221a, AbstractC0395b abstractC0395b) {
        return new t(nVar, abstractC0395b, this);
    }

    public b b() {
        return this.f11982g;
    }

    public C0365a c() {
        return this.f11979d;
    }

    public C0366b d() {
        return this.f11977b;
    }

    public c e() {
        return this.f11983h;
    }

    public List f() {
        return this.f11978c;
    }

    public float g() {
        return this.f11984i;
    }

    public String h() {
        return this.f11976a;
    }

    public g1.d i() {
        return this.f11980e;
    }

    public C0366b j() {
        return this.f11981f;
    }

    public boolean k() {
        return this.f11985j;
    }
}
