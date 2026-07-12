package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0234h {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f4251a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f4252b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f4253c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4254d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4255e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4256f;

    C0234h(CompoundButton compoundButton) {
        this.f4251a = compoundButton;
    }

    void a() {
        Drawable a3 = androidx.core.widget.c.a(this.f4251a);
        if (a3 != null) {
            if (this.f4254d || this.f4255e) {
                Drawable mutate = androidx.core.graphics.drawable.a.l(a3).mutate();
                if (this.f4254d) {
                    androidx.core.graphics.drawable.a.i(mutate, this.f4252b);
                }
                if (this.f4255e) {
                    androidx.core.graphics.drawable.a.j(mutate, this.f4253c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f4251a.getDrawableState());
                }
                this.f4251a.setButtonDrawable(mutate);
            }
        }
    }

    int b(int i3) {
        return i3;
    }

    ColorStateList c() {
        return this.f4252b;
    }

    PorterDuff.Mode d() {
        return this.f4253c;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0064 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:9:0x005c, B:11:0x0064, B:12:0x006f, B:14:0x0077, B:21:0x003f, B:23:0x0047, B:25:0x004f), top: B:2:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:9:0x005c, B:11:0x0064, B:12:0x006f, B:14:0x0077, B:21:0x003f, B:23:0x0047, B:25:0x004f), top: B:2:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void e(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.f4251a
            android.content.Context r0 = r0.getContext()
            int[] r1 = e.j.f11335U0
            r2 = 0
            androidx.appcompat.widget.V r0 = androidx.appcompat.widget.V.w(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.f4251a
            android.content.Context r4 = r3.getContext()
            int[] r5 = e.j.f11335U0
            android.content.res.TypedArray r7 = r0.r()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.y.h0(r3, r4, r5, r6, r7, r8, r9)
            int r11 = e.j.f11343W0     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L3f
            int r11 = e.j.f11343W0     // Catch: java.lang.Throwable -> L3d
            int r11 = r0.n(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L3f
            android.widget.CompoundButton r12 = r10.f4251a     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            android.graphics.drawable.Drawable r11 = f.AbstractC0348a.b(r1, r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            goto L5c
        L3d:
            r10 = move-exception
            goto L8c
        L3f:
            int r11 = e.j.f11339V0     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5c
            int r11 = e.j.f11339V0     // Catch: java.lang.Throwable -> L3d
            int r11 = r0.n(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5c
            android.widget.CompoundButton r12 = r10.f4251a     // Catch: java.lang.Throwable -> L3d
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L3d
            android.graphics.drawable.Drawable r11 = f.AbstractC0348a.b(r1, r11)     // Catch: java.lang.Throwable -> L3d
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L3d
        L5c:
            int r11 = e.j.f11347X0     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L6f
            android.widget.CompoundButton r11 = r10.f4251a     // Catch: java.lang.Throwable -> L3d
            int r12 = e.j.f11347X0     // Catch: java.lang.Throwable -> L3d
            android.content.res.ColorStateList r12 = r0.c(r12)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.c.c(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L6f:
            int r11 = e.j.f11351Y0     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L88
            android.widget.CompoundButton r10 = r10.f4251a     // Catch: java.lang.Throwable -> L3d
            int r11 = e.j.f11351Y0     // Catch: java.lang.Throwable -> L3d
            r12 = -1
            int r11 = r0.k(r11, r12)     // Catch: java.lang.Throwable -> L3d
            r12 = 0
            android.graphics.PorterDuff$Mode r11 = androidx.appcompat.widget.E.d(r11, r12)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.c.d(r10, r11)     // Catch: java.lang.Throwable -> L3d
        L88:
            r0.x()
            return
        L8c:
            r0.x()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0234h.e(android.util.AttributeSet, int):void");
    }

    void f() {
        if (this.f4256f) {
            this.f4256f = false;
        } else {
            this.f4256f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.f4252b = colorStateList;
        this.f4254d = true;
        a();
    }

    void h(PorterDuff.Mode mode) {
        this.f4253c = mode;
        this.f4255e = true;
        a();
    }
}
