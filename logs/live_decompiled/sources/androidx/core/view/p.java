package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private ViewParent f5122a;

    /* renamed from: b, reason: collision with root package name */
    private ViewParent f5123b;

    /* renamed from: c, reason: collision with root package name */
    private final View f5124c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5125d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f5126e;

    public p(View view) {
        this.f5124c = view;
    }

    private boolean h(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        ViewParent i8;
        int i9;
        int i10;
        int[] iArr3;
        if (!m() || (i8 = i(i7)) == null) {
            return false;
        }
        if (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f5124c.getLocationInWindow(iArr);
            i9 = iArr[0];
            i10 = iArr[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr2 == null) {
            int[] j3 = j();
            j3[0] = 0;
            j3[1] = 0;
            iArr3 = j3;
        } else {
            iArr3 = iArr2;
        }
        C.d(i8, this.f5124c, i3, i4, i5, i6, i7, iArr3);
        if (iArr != null) {
            this.f5124c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i9;
            iArr[1] = iArr[1] - i10;
        }
        return true;
    }

    private ViewParent i(int i3) {
        if (i3 == 0) {
            return this.f5122a;
        }
        if (i3 != 1) {
            return null;
        }
        return this.f5123b;
    }

    private int[] j() {
        if (this.f5126e == null) {
            this.f5126e = new int[2];
        }
        return this.f5126e;
    }

    private void o(int i3, ViewParent viewParent) {
        if (i3 == 0) {
            this.f5122a = viewParent;
        } else {
            if (i3 != 1) {
                return;
            }
            this.f5123b = viewParent;
        }
    }

    public boolean a(float f3, float f4, boolean z3) {
        ViewParent i3;
        if (!m() || (i3 = i(0)) == null) {
            return false;
        }
        return C.a(i3, this.f5124c, f3, f4, z3);
    }

    public boolean b(float f3, float f4) {
        ViewParent i3;
        if (!m() || (i3 = i(0)) == null) {
            return false;
        }
        return C.b(i3, this.f5124c, f3, f4);
    }

    public boolean c(int i3, int i4, int[] iArr, int[] iArr2) {
        return d(i3, i4, iArr, iArr2, 0);
    }

    public boolean d(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        ViewParent i6;
        int i7;
        int i8;
        if (!m() || (i6 = i(i5)) == null) {
            return false;
        }
        if (i3 == 0 && i4 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f5124c.getLocationInWindow(iArr2);
            i7 = iArr2[0];
            i8 = iArr2[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        C.c(i6, this.f5124c, i3, i4, iArr, i5);
        if (iArr2 != null) {
            this.f5124c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i8;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        h(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    public boolean f(int i3, int i4, int i5, int i6, int[] iArr) {
        return h(i3, i4, i5, i6, iArr, 0, null);
    }

    public boolean g(int i3, int i4, int i5, int i6, int[] iArr, int i7) {
        return h(i3, i4, i5, i6, iArr, i7, null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i3) {
        return i(i3) != null;
    }

    public boolean m() {
        return this.f5125d;
    }

    public void n(boolean z3) {
        if (this.f5125d) {
            y.G0(this.f5124c);
        }
        this.f5125d = z3;
    }

    public boolean p(int i3) {
        return q(i3, 0);
    }

    public boolean q(int i3, int i4) {
        if (l(i4)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f5124c;
        for (ViewParent parent = this.f5124c.getParent(); parent != null; parent = parent.getParent()) {
            if (C.f(parent, view, this.f5124c, i3, i4)) {
                o(i4, parent);
                C.e(parent, view, this.f5124c, i3, i4);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i3) {
        ViewParent i4 = i(i3);
        if (i4 != null) {
            C.g(i4, this.f5124c, i3);
            o(i3, null);
        }
    }
}
