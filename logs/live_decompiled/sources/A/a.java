package A;

import A.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.C0252a;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.e;
import androidx.core.view.accessibility.f;
import androidx.core.view.y;
import androidx.preference.Preference;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import java.util.ArrayList;
import java.util.List;
import m.h;

/* loaded from: classes.dex */
public abstract class a extends C0252a {

    /* renamed from: o, reason: collision with root package name */
    private static final Rect f0o = new Rect(Preference.DEFAULT_ORDER, Preference.DEFAULT_ORDER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: p, reason: collision with root package name */
    private static final b.a f1p = new C0000a();

    /* renamed from: q, reason: collision with root package name */
    private static final b.InterfaceC0001b f2q = new b();

    /* renamed from: i, reason: collision with root package name */
    private final AccessibilityManager f7i;

    /* renamed from: j, reason: collision with root package name */
    private final View f8j;

    /* renamed from: k, reason: collision with root package name */
    private c f9k;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f3e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final Rect f4f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private final Rect f5g = new Rect();

    /* renamed from: h, reason: collision with root package name */
    private final int[] f6h = new int[2];

    /* renamed from: l, reason: collision with root package name */
    int f10l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    int f11m = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    private int f12n = Integer.MIN_VALUE;

    /* renamed from: A.a$a, reason: collision with other inner class name */
    class C0000a implements b.a {
        C0000a() {
        }

        @Override // A.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d dVar, Rect rect) {
            dVar.i(rect);
        }
    }

    class b implements b.InterfaceC0001b {
        b() {
        }

        @Override // A.b.InterfaceC0001b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d b(h hVar, int i3) {
            return (d) hVar.k(i3);
        }

        @Override // A.b.InterfaceC0001b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int a(h hVar) {
            return hVar.j();
        }
    }

    private class c extends e {
        c() {
        }

        @Override // androidx.core.view.accessibility.e
        public d b(int i3) {
            return d.H(a.this.y(i3));
        }

        @Override // androidx.core.view.accessibility.e
        public d d(int i3) {
            int i4 = i3 == 2 ? a.this.f10l : a.this.f11m;
            if (i4 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i4);
        }

        @Override // androidx.core.view.accessibility.e
        public boolean f(int i3, int i4, Bundle bundle) {
            return a.this.G(i3, i4, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f8j = view;
        this.f7i = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (y.v(view) == 0) {
            y.u0(view, 1);
        }
    }

    private boolean H(int i3, int i4, Bundle bundle) {
        return i4 != 1 ? i4 != 2 ? i4 != 64 ? i4 != 128 ? A(i3, i4, bundle) : c(i3) : J(i3) : d(i3) : K(i3);
    }

    private boolean I(int i3, Bundle bundle) {
        return y.Y(this.f8j, i3, bundle);
    }

    private boolean J(int i3) {
        int i4;
        if (!this.f7i.isEnabled() || !this.f7i.isTouchExplorationEnabled() || (i4 = this.f10l) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            c(i4);
        }
        this.f10l = i3;
        this.f8j.invalidate();
        L(i3, 32768);
        return true;
    }

    private void M(int i3) {
        int i4 = this.f12n;
        if (i4 == i3) {
            return;
        }
        this.f12n = i3;
        L(i3, 128);
        L(i4, 256);
    }

    private boolean c(int i3) {
        if (this.f10l != i3) {
            return false;
        }
        this.f10l = Integer.MIN_VALUE;
        this.f8j.invalidate();
        L(i3, 65536);
        return true;
    }

    private boolean e() {
        int i3 = this.f11m;
        return i3 != Integer.MIN_VALUE && A(i3, 16, null);
    }

    private AccessibilityEvent f(int i3, int i4) {
        return i3 != -1 ? g(i3, i4) : h(i4);
    }

    private AccessibilityEvent g(int i3, int i4) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i4);
        d y3 = y(i3);
        obtain.getText().add(y3.q());
        obtain.setContentDescription(y3.n());
        obtain.setScrollable(y3.C());
        obtain.setPassword(y3.B());
        obtain.setEnabled(y3.x());
        obtain.setChecked(y3.v());
        C(i3, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(y3.l());
        f.c(obtain, this.f8j, i3);
        obtain.setPackageName(this.f8j.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent h(int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        this.f8j.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private d i(int i3) {
        d F3 = d.F();
        F3.W(true);
        F3.Y(true);
        F3.Q("android.view.View");
        Rect rect = f0o;
        F3.M(rect);
        F3.N(rect);
        F3.g0(this.f8j);
        E(i3, F3);
        if (F3.q() == null && F3.n() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        F3.i(this.f4f);
        if (this.f4f.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int h3 = F3.h();
        if ((h3 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((h3 & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        F3.e0(this.f8j.getContext().getPackageName());
        F3.l0(this.f8j, i3);
        if (this.f10l == i3) {
            F3.L(true);
            F3.a(128);
        } else {
            F3.L(false);
            F3.a(64);
        }
        boolean z3 = this.f11m == i3;
        if (z3) {
            F3.a(2);
        } else if (F3.y()) {
            F3.a(1);
        }
        F3.Z(z3);
        this.f8j.getLocationOnScreen(this.f6h);
        F3.j(this.f3e);
        if (this.f3e.equals(rect)) {
            F3.i(this.f3e);
            if (F3.f5058b != -1) {
                d F4 = d.F();
                for (int i4 = F3.f5058b; i4 != -1; i4 = F4.f5058b) {
                    F4.h0(this.f8j, -1);
                    F4.M(f0o);
                    E(i4, F4);
                    F4.i(this.f4f);
                    Rect rect2 = this.f3e;
                    Rect rect3 = this.f4f;
                    rect2.offset(rect3.left, rect3.top);
                }
                F4.J();
            }
            this.f3e.offset(this.f6h[0] - this.f8j.getScrollX(), this.f6h[1] - this.f8j.getScrollY());
        }
        if (this.f8j.getLocalVisibleRect(this.f5g)) {
            this.f5g.offset(this.f6h[0] - this.f8j.getScrollX(), this.f6h[1] - this.f8j.getScrollY());
            if (this.f3e.intersect(this.f5g)) {
                F3.N(this.f3e);
                if (v(this.f3e)) {
                    F3.p0(true);
                }
            }
        }
        return F3;
    }

    private d j() {
        d G3 = d.G(this.f8j);
        y.W(this.f8j, G3);
        ArrayList arrayList = new ArrayList();
        r(arrayList);
        if (G3.k() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            G3.c(this.f8j, ((Integer) arrayList.get(i3)).intValue());
        }
        return G3;
    }

    private h n() {
        ArrayList arrayList = new ArrayList();
        r(arrayList);
        h hVar = new h();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            hVar.i(((Integer) arrayList.get(i3)).intValue(), i(((Integer) arrayList.get(i3)).intValue()));
        }
        return hVar;
    }

    private void o(int i3, Rect rect) {
        y(i3).i(rect);
    }

    private static Rect s(View view, int i3, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i3 == 17) {
            rect.set(width, 0, width, height);
        } else if (i3 == 33) {
            rect.set(0, height, width, height);
        } else if (i3 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean v(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f8j.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f8j.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int w(int i3) {
        if (i3 == 19) {
            return 33;
        }
        if (i3 != 21) {
            return i3 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean x(int i3, Rect rect) {
        d dVar;
        h n3 = n();
        int i4 = this.f11m;
        d dVar2 = i4 == Integer.MIN_VALUE ? null : (d) n3.e(i4);
        if (i3 == 1 || i3 == 2) {
            dVar = (d) A.b.d(n3, f2q, f1p, dVar2, i3, y.x(this.f8j) == 1, false);
        } else {
            if (i3 != 17 && i3 != 33 && i3 != 66 && i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i5 = this.f11m;
            if (i5 != Integer.MIN_VALUE) {
                o(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                s(this.f8j, i3, rect2);
            }
            dVar = (d) A.b.c(n3, f2q, f1p, dVar2, rect2, i3);
        }
        return K(dVar != null ? n3.h(n3.g(dVar)) : Integer.MIN_VALUE);
    }

    protected abstract boolean A(int i3, int i4, Bundle bundle);

    protected void B(AccessibilityEvent accessibilityEvent) {
    }

    protected void C(int i3, AccessibilityEvent accessibilityEvent) {
    }

    protected void D(d dVar) {
    }

    protected abstract void E(int i3, d dVar);

    protected void F(int i3, boolean z3) {
    }

    boolean G(int i3, int i4, Bundle bundle) {
        return i3 != -1 ? H(i3, i4, bundle) : I(i4, bundle);
    }

    public final boolean K(int i3) {
        int i4;
        if ((!this.f8j.isFocused() && !this.f8j.requestFocus()) || (i4 = this.f11m) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            d(i4);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.f11m = i3;
        F(i3, true);
        L(i3, 8);
        return true;
    }

    public final boolean L(int i3, int i4) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f7i.isEnabled() || (parent = this.f8j.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f8j, f(i3, i4));
    }

    public final boolean d(int i3) {
        if (this.f11m != i3) {
            return false;
        }
        this.f11m = Integer.MIN_VALUE;
        F(i3, false);
        L(i3, 8);
        return true;
    }

    @Override // androidx.core.view.C0252a
    public e getAccessibilityNodeProvider(View view) {
        if (this.f9k == null) {
            this.f9k = new c();
        }
        return this.f9k;
    }

    public final boolean k(MotionEvent motionEvent) {
        if (!this.f7i.isEnabled() || !this.f7i.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int q3 = q(motionEvent.getX(), motionEvent.getY());
            M(q3);
            return q3 != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f12n == Integer.MIN_VALUE) {
            return false;
        }
        M(Integer.MIN_VALUE);
        return true;
    }

    public final boolean l(KeyEvent keyEvent) {
        int i3 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return x(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return x(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int w3 = w(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z3 = false;
                    while (i3 < repeatCount && x(w3, null)) {
                        i3++;
                        z3 = true;
                    }
                    return z3;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        e();
        return true;
    }

    public final int m() {
        return this.f10l;
    }

    @Override // androidx.core.view.C0252a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        B(accessibilityEvent);
    }

    @Override // androidx.core.view.C0252a
    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        D(dVar);
    }

    public final int p() {
        return this.f11m;
    }

    protected abstract int q(float f3, float f4);

    protected abstract void r(List list);

    public final void t() {
        u(-1, 1);
    }

    public final void u(int i3, int i4) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f7i.isEnabled() || (parent = this.f8j.getParent()) == null) {
            return;
        }
        AccessibilityEvent f3 = f(i3, 2048);
        androidx.core.view.accessibility.b.b(f3, i4);
        parent.requestSendAccessibilityEvent(this.f8j, f3);
    }

    d y(int i3) {
        return i3 == -1 ? j() : i(i3);
    }

    public final void z(boolean z3, int i3, Rect rect) {
        int i4 = this.f11m;
        if (i4 != Integer.MIN_VALUE) {
            d(i4);
        }
        if (z3) {
            x(i3, rect);
        }
    }
}
