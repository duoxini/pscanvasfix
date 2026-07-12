package com.coui.appcompat.poplist;

import android.graphics.Rect;
import android.util.Log;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
class v extends y0.e {

    /* renamed from: n, reason: collision with root package name */
    private static final boolean f8377n;

    /* renamed from: a, reason: collision with root package name */
    Rect f8378a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    Rect f8379b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    Rect f8380c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    Rect f8381d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    Rect f8382e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    Rect f8383f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    Rect f8384g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    Rect f8385h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    Rect f8386i = new Rect();

    /* renamed from: j, reason: collision with root package name */
    int f8387j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f8388k = 0;

    /* renamed from: l, reason: collision with root package name */
    boolean f8389l = false;

    /* renamed from: m, reason: collision with root package name */
    boolean f8390m = false;

    static {
        f8377n = AbstractC0371a.f11873b || AbstractC0371a.e("PopupMenuDomain", 3);
    }

    v() {
    }

    void a() {
        Log.d("PopupMenuDomain", "mWindow = " + this.f8378a + " mAnchor = " + this.f8379b + " mAnchorOutsets = " + this.f8385h + " mWindowBarriers = " + this.f8386i + " mMainMenu = " + this.f8380c + " mMainMenuRelocated = " + this.f8381d + " mSubMenu = " + this.f8382e + " mSubMenuAnchor = " + this.f8384g + " mGlobalOffsetX = " + this.f8387j + " mGlobalOffsetY = " + this.f8388k);
    }

    void b(Rect rect) {
        Rect rect2 = this.f8379b;
        int i3 = rect2.left;
        Rect rect3 = this.f8385h;
        rect.set(i3 - rect3.left, rect2.top - rect3.top, rect2.right + rect3.right, rect2.bottom + rect3.bottom);
    }

    void c(Rect rect) {
        Rect rect2 = this.f8378a;
        int i3 = rect2.left;
        Rect rect3 = this.f8386i;
        rect.set(i3 + rect3.left, rect2.top + rect3.top, rect2.right - rect3.right, rect2.bottom - rect3.bottom);
        if (f8377n) {
            Log.d("PopupMenuDomain", "PopupMenuDomain getAvailableRect mWindow.left " + this.f8378a.left + " mWindowBarriers.left " + this.f8386i.left + " mWindow.top " + this.f8378a.top + " mWindowBarriers.top " + this.f8386i.top + " mWindow.right " + this.f8378a.right + " mWindowBarriers.right " + this.f8386i.right + " mWindow.bottom " + this.f8378a.bottom + " mWindowBarriers.bottom " + this.f8386i.bottom);
        }
    }

    int d() {
        Rect rect = this.f8378a;
        int i3 = rect.bottom;
        Rect rect2 = this.f8386i;
        return (i3 - rect2.bottom) - (rect.top + rect2.top);
    }

    int e() {
        return this.f8390m ? this.f8380c.centerX() : Math.min(Math.max(this.f8379b.centerX(), this.f8380c.left), this.f8380c.right);
    }

    int f() {
        return this.f8390m ? this.f8380c.centerY() : this.f8380c.centerY() > this.f8379b.centerY() ? this.f8380c.top : this.f8380c.bottom;
    }

    int g() {
        Rect rect = this.f8382e;
        if (rect.left > this.f8380c.left) {
            return 0;
        }
        return rect.width();
    }

    int h() {
        return this.f8384g.centerY() - this.f8382e.top;
    }

    void i() {
        this.f8378a.setEmpty();
        this.f8379b.setEmpty();
        this.f8380c.setEmpty();
        this.f8382e.setEmpty();
        this.f8383f.setEmpty();
        this.f8385h.setEmpty();
        this.f8386i.setEmpty();
        this.f8381d.setEmpty();
        this.f8384g.setEmpty();
    }
}
