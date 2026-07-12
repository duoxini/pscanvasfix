package x1;

import android.graphics.Rect;

/* renamed from: x1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0633c {

    /* renamed from: a, reason: collision with root package name */
    private int f14052a;

    /* renamed from: b, reason: collision with root package name */
    private int f14053b;

    /* renamed from: d, reason: collision with root package name */
    private float f14055d;

    /* renamed from: f, reason: collision with root package name */
    private float f14057f;

    /* renamed from: h, reason: collision with root package name */
    private float f14059h;

    /* renamed from: j, reason: collision with root package name */
    private float f14061j;

    /* renamed from: c, reason: collision with root package name */
    private Rect f14054c = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private Rect f14056e = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private Rect f14058g = new Rect();

    /* renamed from: i, reason: collision with root package name */
    private Rect f14060i = new Rect();

    public C0633c(int i3, int i4) {
        c(i3, i4);
    }

    private void a(int i3, int i4) {
        this.f14052a = Math.min(i3, i4);
        this.f14053b = Math.max(i3, i4);
        Rect rect = this.f14054c;
        int i5 = this.f14052a;
        rect.set(0, 0, (int) (i5 / 1.6666666f), i5);
        this.f14055d = 0.85f;
        Rect rect2 = this.f14056e;
        int i6 = this.f14052a;
        rect2.set(0, 0, i6, (int) (i6 / 1.6666666f));
        this.f14057f = 0.85f;
        Rect rect3 = this.f14058g;
        int i7 = this.f14052a;
        rect3.set(0, 0, (int) (i7 / 1.6666666f), i7);
        this.f14059h = 0.85f;
        Rect rect4 = this.f14060i;
        int i8 = this.f14052a;
        rect4.set(0, 0, i8, (int) (i8 / 1.6666666f));
        this.f14061j = 0.85f;
    }

    private void b(int i3, int i4) {
        this.f14052a = Math.min(i3, i4);
        this.f14053b = Math.max(i3, i4);
        Rect rect = this.f14054c;
        int i5 = this.f14052a;
        rect.set(0, 0, (int) (i5 / 1.6666666f), i5);
        this.f14055d = 0.708f;
        Rect rect2 = this.f14056e;
        int i6 = this.f14052a;
        rect2.set(0, 0, i6, (int) (i6 / 1.6666666f));
        this.f14057f = 0.708f;
        Rect rect3 = this.f14058g;
        int i7 = this.f14052a;
        rect3.set(0, 0, (int) (i7 / 1.6666666f), i7);
        this.f14059h = 0.708f;
        Rect rect4 = this.f14060i;
        int i8 = this.f14052a;
        rect4.set(0, 0, i8, (int) (i8 / 1.6666666f));
        this.f14061j = 0.708f;
    }

    private void c(int i3, int i4) {
        if (B1.s.H()) {
            b(i3, i4);
        } else {
            a(i3, i4);
        }
    }
}
