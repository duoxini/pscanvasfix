package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.view.b;

/* loaded from: classes.dex */
public abstract class a {
    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z3);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    void n() {
    }

    public abstract boolean o(int i3, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z3);

    public abstract void s(boolean z3);

    public abstract void t(boolean z3);

    public abstract void u(CharSequence charSequence);

    public androidx.appcompat.view.b v(b.a aVar) {
        return null;
    }

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0054a extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public C0054a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f11432t);
            this.gravity = obtainStyledAttributes.getInt(e.j.f11436u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0054a(int i3, int i4) {
            super(i3, i4);
            this.gravity = 8388627;
        }

        public C0054a(C0054a c0054a) {
            super((ViewGroup.MarginLayoutParams) c0054a);
            this.gravity = 0;
            this.gravity = c0054a.gravity;
        }

        public C0054a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }
}
