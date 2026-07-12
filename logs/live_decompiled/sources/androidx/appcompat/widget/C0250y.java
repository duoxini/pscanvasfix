package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.content.res.f;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0250y {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f4329a;

    /* renamed from: b, reason: collision with root package name */
    private T f4330b;

    /* renamed from: c, reason: collision with root package name */
    private T f4331c;

    /* renamed from: d, reason: collision with root package name */
    private T f4332d;

    /* renamed from: e, reason: collision with root package name */
    private T f4333e;

    /* renamed from: f, reason: collision with root package name */
    private T f4334f;

    /* renamed from: g, reason: collision with root package name */
    private T f4335g;

    /* renamed from: h, reason: collision with root package name */
    private T f4336h;

    /* renamed from: i, reason: collision with root package name */
    private final A f4337i;

    /* renamed from: j, reason: collision with root package name */
    private int f4338j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f4339k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f4340l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4341m;

    /* renamed from: androidx.appcompat.widget.y$a */
    class a extends f.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4342a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4343b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f4344c;

        a(int i3, int i4, WeakReference weakReference) {
            this.f4342a = i3;
            this.f4343b = i4;
            this.f4344c = weakReference;
        }

        @Override // androidx.core.content.res.f.e
        /* renamed from: h */
        public void f(int i3) {
        }

        @Override // androidx.core.content.res.f.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            int i3 = this.f4342a;
            if (i3 != -1) {
                typeface = f.a(typeface, i3, (this.f4343b & 2) != 0);
            }
            C0250y.this.n(this.f4344c, typeface);
        }
    }

    /* renamed from: androidx.appcompat.widget.y$b */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f4346e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Typeface f4347f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f4348g;

        b(TextView textView, Typeface typeface, int i3) {
            this.f4346e = textView;
            this.f4347f = typeface;
            this.f4348g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4346e.setTypeface(this.f4347f, this.f4348g);
        }
    }

    /* renamed from: androidx.appcompat.widget.y$c */
    static class c {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* renamed from: androidx.appcompat.widget.y$d */
    static class d {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* renamed from: androidx.appcompat.widget.y$e */
    static class e {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i3, int i4, int i5, int i6) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
        }

        static void c(TextView textView, int[] iArr, int i3) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* renamed from: androidx.appcompat.widget.y$f */
    static class f {
        static Typeface a(Typeface typeface, int i3, boolean z3) {
            return Typeface.create(typeface, i3, z3);
        }
    }

    C0250y(TextView textView) {
        this.f4329a = textView;
        this.f4337i = new A(textView);
    }

    private void B(int i3, float f3) {
        this.f4337i.t(i3, f3);
    }

    private void C(Context context, V v3) {
        String o3;
        this.f4338j = v3.k(e.j.f11341V2, this.f4338j);
        int k3 = v3.k(e.j.Y2, -1);
        this.f4339k = k3;
        if (k3 != -1) {
            this.f4338j &= 2;
        }
        if (!v3.s(e.j.f11349X2) && !v3.s(e.j.Z2)) {
            if (v3.s(e.j.f11337U2)) {
                this.f4341m = false;
                int k4 = v3.k(e.j.f11337U2, 1);
                if (k4 == 1) {
                    this.f4340l = Typeface.SANS_SERIF;
                    return;
                } else if (k4 == 2) {
                    this.f4340l = Typeface.SERIF;
                    return;
                } else {
                    if (k4 != 3) {
                        return;
                    }
                    this.f4340l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f4340l = null;
        int i3 = v3.s(e.j.Z2) ? e.j.Z2 : e.j.f11349X2;
        int i4 = this.f4339k;
        int i5 = this.f4338j;
        if (!context.isRestricted()) {
            try {
                Typeface j3 = v3.j(i3, this.f4338j, new a(i4, i5, new WeakReference(this.f4329a)));
                if (j3 != null) {
                    if (this.f4339k != -1) {
                        this.f4340l = f.a(Typeface.create(j3, 0), this.f4339k, (this.f4338j & 2) != 0);
                    } else {
                        this.f4340l = j3;
                    }
                }
                this.f4341m = this.f4340l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f4340l != null || (o3 = v3.o(i3)) == null) {
            return;
        }
        if (this.f4339k != -1) {
            this.f4340l = f.a(Typeface.create(o3, 0), this.f4339k, (this.f4338j & 2) != 0);
        } else {
            this.f4340l = Typeface.create(o3, this.f4338j);
        }
    }

    private void a(Drawable drawable, T t3) {
        if (drawable == null || t3 == null) {
            return;
        }
        C0235i.i(drawable, t3, this.f4329a.getDrawableState());
    }

    private static T d(Context context, C0235i c0235i, int i3) {
        ColorStateList f3 = c0235i.f(context, i3);
        if (f3 == null) {
            return null;
        }
        T t3 = new T();
        t3.f4143d = true;
        t3.f4140a = f3;
        return t3;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] a3 = c.a(this.f4329a);
            TextView textView = this.f4329a;
            if (drawable5 == null) {
                drawable5 = a3[0];
            }
            if (drawable2 == null) {
                drawable2 = a3[1];
            }
            if (drawable6 == null) {
                drawable6 = a3[2];
            }
            if (drawable4 == null) {
                drawable4 = a3[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] a4 = c.a(this.f4329a);
        Drawable drawable7 = a4[0];
        if (drawable7 != null || a4[2] != null) {
            TextView textView2 = this.f4329a;
            if (drawable2 == null) {
                drawable2 = a4[1];
            }
            Drawable drawable8 = a4[2];
            if (drawable4 == null) {
                drawable4 = a4[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f4329a.getCompoundDrawables();
        TextView textView3 = this.f4329a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        T t3 = this.f4336h;
        this.f4330b = t3;
        this.f4331c = t3;
        this.f4332d = t3;
        this.f4333e = t3;
        this.f4334f = t3;
        this.f4335g = t3;
    }

    void A(int i3, float f3) {
        if (b0.f4200b || l()) {
            return;
        }
        B(i3, f3);
    }

    void b() {
        if (this.f4330b != null || this.f4331c != null || this.f4332d != null || this.f4333e != null) {
            Drawable[] compoundDrawables = this.f4329a.getCompoundDrawables();
            a(compoundDrawables[0], this.f4330b);
            a(compoundDrawables[1], this.f4331c);
            a(compoundDrawables[2], this.f4332d);
            a(compoundDrawables[3], this.f4333e);
        }
        if (this.f4334f == null && this.f4335g == null) {
            return;
        }
        Drawable[] a3 = c.a(this.f4329a);
        a(a3[0], this.f4334f);
        a(a3[2], this.f4335g);
    }

    void c() {
        this.f4337i.a();
    }

    int e() {
        return this.f4337i.f();
    }

    int f() {
        return this.f4337i.g();
    }

    int g() {
        return this.f4337i.h();
    }

    int[] h() {
        return this.f4337i.i();
    }

    int i() {
        return this.f4337i.j();
    }

    ColorStateList j() {
        T t3 = this.f4336h;
        if (t3 != null) {
            return t3.f4140a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        T t3 = this.f4336h;
        if (t3 != null) {
            return t3.f4141b;
        }
        return null;
    }

    boolean l() {
        return this.f4337i.n();
    }

    void m(AttributeSet attributeSet, int i3) {
        boolean z3;
        boolean z4;
        String str;
        String str2;
        Context context = this.f4329a.getContext();
        C0235i b3 = C0235i.b();
        V w3 = V.w(context, attributeSet, e.j.f11350Y, i3, 0);
        TextView textView = this.f4329a;
        androidx.core.view.y.h0(textView, textView.getContext(), e.j.f11350Y, attributeSet, w3.r(), i3, 0);
        int n3 = w3.n(e.j.f11353Z, -1);
        if (w3.s(e.j.f11365c0)) {
            this.f4330b = d(context, b3, w3.n(e.j.f11365c0, 0));
        }
        if (w3.s(e.j.f11357a0)) {
            this.f4331c = d(context, b3, w3.n(e.j.f11357a0, 0));
        }
        if (w3.s(e.j.f11369d0)) {
            this.f4332d = d(context, b3, w3.n(e.j.f11369d0, 0));
        }
        if (w3.s(e.j.f11361b0)) {
            this.f4333e = d(context, b3, w3.n(e.j.f11361b0, 0));
        }
        if (w3.s(e.j.f11373e0)) {
            this.f4334f = d(context, b3, w3.n(e.j.f11373e0, 0));
        }
        if (w3.s(e.j.f11377f0)) {
            this.f4335g = d(context, b3, w3.n(e.j.f11377f0, 0));
        }
        w3.x();
        boolean z5 = this.f4329a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z6 = true;
        if (n3 != -1) {
            V u3 = V.u(context, n3, e.j.f11329S2);
            if (z5 || !u3.s(e.j.b3)) {
                z3 = false;
                z4 = false;
            } else {
                z3 = u3.a(e.j.b3, false);
                z4 = true;
            }
            C(context, u3);
            str = u3.s(e.j.c3) ? u3.o(e.j.c3) : null;
            str2 = u3.s(e.j.a3) ? u3.o(e.j.a3) : null;
            u3.x();
        } else {
            z3 = false;
            z4 = false;
            str = null;
            str2 = null;
        }
        V w4 = V.w(context, attributeSet, e.j.f11329S2, i3, 0);
        if (z5 || !w4.s(e.j.b3)) {
            z6 = z4;
        } else {
            z3 = w4.a(e.j.b3, false);
        }
        if (w4.s(e.j.c3)) {
            str = w4.o(e.j.c3);
        }
        if (w4.s(e.j.a3)) {
            str2 = w4.o(e.j.a3);
        }
        if (w4.s(e.j.f11333T2) && w4.f(e.j.f11333T2, -1) == 0) {
            this.f4329a.setTextSize(0, 0.0f);
        }
        C(context, w4);
        w4.x();
        if (!z5 && z6) {
            s(z3);
        }
        Typeface typeface = this.f4340l;
        if (typeface != null) {
            if (this.f4339k == -1) {
                this.f4329a.setTypeface(typeface, this.f4338j);
            } else {
                this.f4329a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            e.d(this.f4329a, str2);
        }
        if (str != null) {
            d.b(this.f4329a, d.a(str));
        }
        this.f4337i.o(attributeSet, i3);
        if (b0.f4200b && this.f4337i.j() != 0) {
            int[] i4 = this.f4337i.i();
            if (i4.length > 0) {
                if (e.a(this.f4329a) != -1.0f) {
                    e.b(this.f4329a, this.f4337i.g(), this.f4337i.f(), this.f4337i.h(), 0);
                } else {
                    e.c(this.f4329a, i4, 0);
                }
            }
        }
        V v3 = V.v(context, attributeSet, e.j.f11381g0);
        int n4 = v3.n(e.j.f11413o0, -1);
        Drawable c3 = n4 != -1 ? b3.c(context, n4) : null;
        int n5 = v3.n(e.j.f11433t0, -1);
        Drawable c4 = n5 != -1 ? b3.c(context, n5) : null;
        int n6 = v3.n(e.j.f11417p0, -1);
        Drawable c5 = n6 != -1 ? b3.c(context, n6) : null;
        int n7 = v3.n(e.j.f11405m0, -1);
        Drawable c6 = n7 != -1 ? b3.c(context, n7) : null;
        int n8 = v3.n(e.j.f11421q0, -1);
        Drawable c7 = n8 != -1 ? b3.c(context, n8) : null;
        int n9 = v3.n(e.j.f11409n0, -1);
        y(c3, c4, c5, c6, c7, n9 != -1 ? b3.c(context, n9) : null);
        if (v3.s(e.j.f11425r0)) {
            androidx.core.widget.i.f(this.f4329a, v3.c(e.j.f11425r0));
        }
        if (v3.s(e.j.f11429s0)) {
            androidx.core.widget.i.g(this.f4329a, E.d(v3.k(e.j.f11429s0, -1), null));
        }
        int f3 = v3.f(e.j.f11441v0, -1);
        int f4 = v3.f(e.j.f11445w0, -1);
        int f5 = v3.f(e.j.f11449x0, -1);
        v3.x();
        if (f3 != -1) {
            androidx.core.widget.i.i(this.f4329a, f3);
        }
        if (f4 != -1) {
            androidx.core.widget.i.j(this.f4329a, f4);
        }
        if (f5 != -1) {
            androidx.core.widget.i.k(this.f4329a, f5);
        }
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.f4341m) {
            this.f4340l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (androidx.core.view.y.N(textView)) {
                    textView.post(new b(textView, typeface, this.f4338j));
                } else {
                    textView.setTypeface(typeface, this.f4338j);
                }
            }
        }
    }

    void o(boolean z3, int i3, int i4, int i5, int i6) {
        if (b0.f4200b) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i3) {
        String o3;
        V u3 = V.u(context, i3, e.j.f11329S2);
        if (u3.s(e.j.b3)) {
            s(u3.a(e.j.b3, false));
        }
        if (u3.s(e.j.f11333T2) && u3.f(e.j.f11333T2, -1) == 0) {
            this.f4329a.setTextSize(0, 0.0f);
        }
        C(context, u3);
        if (u3.s(e.j.a3) && (o3 = u3.o(e.j.a3)) != null) {
            e.d(this.f4329a, o3);
        }
        u3.x();
        Typeface typeface = this.f4340l;
        if (typeface != null) {
            this.f4329a.setTypeface(typeface, this.f4338j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
    }

    void s(boolean z3) {
        this.f4329a.setAllCaps(z3);
    }

    void t(int i3, int i4, int i5, int i6) {
        this.f4337i.p(i3, i4, i5, i6);
    }

    void u(int[] iArr, int i3) {
        this.f4337i.q(iArr, i3);
    }

    void v(int i3) {
        this.f4337i.r(i3);
    }

    void w(ColorStateList colorStateList) {
        if (this.f4336h == null) {
            this.f4336h = new T();
        }
        T t3 = this.f4336h;
        t3.f4140a = colorStateList;
        t3.f4143d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f4336h == null) {
            this.f4336h = new T();
        }
        T t3 = this.f4336h;
        t3.f4141b = mode;
        t3.f4142c = mode != null;
        z();
    }
}
