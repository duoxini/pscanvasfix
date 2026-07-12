package r0;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import h0.AbstractC0371a;

/* renamed from: r0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0561c extends LayerDrawable implements InterfaceC0565g {

    /* renamed from: e, reason: collision with root package name */
    private boolean f13176e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13177f;

    /* renamed from: g, reason: collision with root package name */
    private j0.b f13178g;

    public C0561c(Drawable[] drawableArr) {
        super(drawableArr);
        this.f13176e = true;
        this.f13177f = false;
    }

    public void a() {
        this.f13177f = false;
        j0.b bVar = this.f13178g;
        if (bVar != null) {
            bVar.k(null);
        }
    }

    public void b(View view) {
        c(view, 0);
    }

    public void c(View view, int i3) {
        this.f13177f = true;
        j0.b bVar = this.f13178g;
        if (bVar == null) {
            this.f13178g = new j0.b(view, i3);
        } else {
            bVar.k(view);
            this.f13178g.l(i3);
        }
    }

    public void d(boolean z3) {
        for (int i3 = 0; i3 < getNumberOfLayers(); i3++) {
            Object drawable = getDrawable(i3);
            if (drawable instanceof InterfaceC0564f) {
                if (z3) {
                    ((InterfaceC0564f) drawable).g();
                } else {
                    ((InterfaceC0564f) drawable).b();
                }
            }
        }
    }

    public void e(boolean z3) {
        for (int i3 = 0; i3 < getNumberOfLayers(); i3++) {
            Object drawable = getDrawable(i3);
            if (drawable instanceof InterfaceC0564f) {
                if (z3) {
                    ((InterfaceC0564f) drawable).h();
                } else {
                    ((InterfaceC0564f) drawable).c();
                }
            }
        }
    }

    public void f(int i3, boolean z3, boolean z4, boolean z5) {
        for (int i4 = 0; i4 < getNumberOfLayers(); i4++) {
            Object drawable = getDrawable(i4);
            if (drawable instanceof InterfaceC0564f) {
                ((InterfaceC0564f) drawable).a(i3, z3, z4, z5);
            }
        }
    }

    public void g(boolean z3) {
        j0.b bVar;
        for (int i3 = 0; i3 < getNumberOfLayers(); i3++) {
            Object drawable = getDrawable(i3);
            if (drawable instanceof InterfaceC0564f) {
                if (z3) {
                    ((InterfaceC0564f) drawable).f();
                } else {
                    ((InterfaceC0564f) drawable).e();
                }
            }
        }
        if (this.f13176e && this.f13177f && (bVar = this.f13178g) != null) {
            bVar.e(z3);
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public void h(Drawable drawable) {
        if (drawable == this) {
            AbstractC0371a.c("StateEffectDrawable", "Set view background failed! Should not set LayerDrawable itself as its child recusively!");
        } else {
            setDrawableByLayerId(getId(0), drawable);
        }
    }

    @Override // r0.InterfaceC0565g
    public void i(boolean z3) {
        for (int i3 = 0; i3 < getNumberOfLayers(); i3++) {
            Object drawable = getDrawable(i3);
            if (drawable instanceof InterfaceC0565g) {
                ((InterfaceC0565g) drawable).i(z3);
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // r0.InterfaceC0565g
    public void j() {
        for (int i3 = 0; i3 < getNumberOfLayers(); i3++) {
            Object drawable = getDrawable(i3);
            if (drawable instanceof InterfaceC0565g) {
                ((InterfaceC0565g) drawable).j();
            }
        }
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z3;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z3 = false;
                break;
            }
            if (iArr[i3] == 16842910) {
                z3 = true;
                break;
            }
            i3++;
        }
        if (z3 != this.f13176e) {
            this.f13176e = z3;
            if (!z3) {
                j0.b bVar = this.f13178g;
                if (bVar != null) {
                    bVar.e(false);
                }
                j();
            }
        }
        return super.onStateChange(iArr);
    }
}
