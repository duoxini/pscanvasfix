package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0243q extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f4286b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4287a;

    public C0243q(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        a(context, attributeSet, i3, i4);
    }

    private void a(Context context, AttributeSet attributeSet, int i3, int i4) {
        V w3 = V.w(context, attributeSet, e.j.f11352Y1, i3, i4);
        if (w3.s(e.j.f11359a2)) {
            b(w3.a(e.j.f11359a2, false));
        }
        setBackgroundDrawable(w3.g(e.j.f11355Z1));
        w3.x();
    }

    private void b(boolean z3) {
        if (f4286b) {
            this.f4287a = z3;
        } else {
            androidx.core.widget.h.a(this, z3);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4) {
        if (f4286b && this.f4287a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i3, int i4, int i5, int i6) {
        if (f4286b && this.f4287a) {
            i4 -= view.getHeight();
        }
        super.update(view, i3, i4, i5, i6);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i4, int i5) {
        if (f4286b && this.f4287a) {
            i4 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i4, i5);
    }
}
