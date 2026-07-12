package n;

import java.util.Arrays;
import java.util.HashSet;

/* renamed from: n.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0479i implements Comparable {

    /* renamed from: v, reason: collision with root package name */
    private static int f12520v = 1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12521e;

    /* renamed from: f, reason: collision with root package name */
    private String f12522f;

    /* renamed from: j, reason: collision with root package name */
    public float f12526j;

    /* renamed from: n, reason: collision with root package name */
    a f12530n;

    /* renamed from: g, reason: collision with root package name */
    public int f12523g = -1;

    /* renamed from: h, reason: collision with root package name */
    int f12524h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f12525i = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12527k = false;

    /* renamed from: l, reason: collision with root package name */
    float[] f12528l = new float[9];

    /* renamed from: m, reason: collision with root package name */
    float[] f12529m = new float[9];

    /* renamed from: o, reason: collision with root package name */
    C0472b[] f12531o = new C0472b[16];

    /* renamed from: p, reason: collision with root package name */
    int f12532p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f12533q = 0;

    /* renamed from: r, reason: collision with root package name */
    boolean f12534r = false;

    /* renamed from: s, reason: collision with root package name */
    int f12535s = -1;

    /* renamed from: t, reason: collision with root package name */
    float f12536t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    HashSet f12537u = null;

    /* renamed from: n.i$a */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public C0479i(a aVar, String str) {
        this.f12530n = aVar;
    }

    static void c() {
        f12520v++;
    }

    public final void a(C0472b c0472b) {
        int i3 = 0;
        while (true) {
            int i4 = this.f12532p;
            if (i3 >= i4) {
                C0472b[] c0472bArr = this.f12531o;
                if (i4 >= c0472bArr.length) {
                    this.f12531o = (C0472b[]) Arrays.copyOf(c0472bArr, c0472bArr.length * 2);
                }
                C0472b[] c0472bArr2 = this.f12531o;
                int i5 = this.f12532p;
                c0472bArr2[i5] = c0472b;
                this.f12532p = i5 + 1;
                return;
            }
            if (this.f12531o[i3] == c0472b) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0479i c0479i) {
        return this.f12523g - c0479i.f12523g;
    }

    public final void d(C0472b c0472b) {
        int i3 = this.f12532p;
        int i4 = 0;
        while (i4 < i3) {
            if (this.f12531o[i4] == c0472b) {
                while (i4 < i3 - 1) {
                    C0472b[] c0472bArr = this.f12531o;
                    int i5 = i4 + 1;
                    c0472bArr[i4] = c0472bArr[i5];
                    i4 = i5;
                }
                this.f12532p--;
                return;
            }
            i4++;
        }
    }

    public void e() {
        this.f12522f = null;
        this.f12530n = a.UNKNOWN;
        this.f12525i = 0;
        this.f12523g = -1;
        this.f12524h = -1;
        this.f12526j = 0.0f;
        this.f12527k = false;
        this.f12534r = false;
        this.f12535s = -1;
        this.f12536t = 0.0f;
        int i3 = this.f12532p;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f12531o[i4] = null;
        }
        this.f12532p = 0;
        this.f12533q = 0;
        this.f12521e = false;
        Arrays.fill(this.f12529m, 0.0f);
    }

    public void f(C0474d c0474d, float f3) {
        this.f12526j = f3;
        this.f12527k = true;
        this.f12534r = false;
        this.f12535s = -1;
        this.f12536t = 0.0f;
        int i3 = this.f12532p;
        this.f12524h = -1;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f12531o[i4].A(c0474d, this, false);
        }
        this.f12532p = 0;
    }

    public void g(a aVar, String str) {
        this.f12530n = aVar;
    }

    public final void h(C0474d c0474d, C0472b c0472b) {
        int i3 = this.f12532p;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f12531o[i4].B(c0474d, c0472b, false);
        }
        this.f12532p = 0;
    }

    public String toString() {
        if (this.f12522f != null) {
            return "" + this.f12522f;
        }
        return "" + this.f12523g;
    }
}
