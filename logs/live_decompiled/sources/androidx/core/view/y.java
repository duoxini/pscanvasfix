package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.C0252a;
import androidx.core.view.J;
import androidx.core.view.accessibility.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f5132a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static WeakHashMap f5133b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5134c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f5135d = {u.b.f13712b, u.b.f13713c, u.b.f13724n, u.b.f13735y, u.b.f13697B, u.b.f13698C, u.b.f13699D, u.b.f13700E, u.b.f13701F, u.b.f13702G, u.b.f13714d, u.b.f13715e, u.b.f13716f, u.b.f13717g, u.b.f13718h, u.b.f13719i, u.b.f13720j, u.b.f13721k, u.b.f13722l, u.b.f13723m, u.b.f13725o, u.b.f13726p, u.b.f13727q, u.b.f13728r, u.b.f13729s, u.b.f13730t, u.b.f13731u, u.b.f13732v, u.b.f13733w, u.b.f13734x, u.b.f13736z, u.b.f13696A};

    /* renamed from: e, reason: collision with root package name */
    private static final u f5136e = new u() { // from class: androidx.core.view.x
    };

    /* renamed from: f, reason: collision with root package name */
    private static final e f5137f = new e();

    class a extends f {
        a(int i3, Class cls, int i4) {
            super(i3, cls, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(p.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            p.i(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f {
        b(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return p.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            p.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f {
        c(int i3, Class cls, int i4, int i5) {
            super(i3, cls, i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return r.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            r.b(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f {
        d(int i3, Class cls, int i4) {
            super(i3, cls, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(p.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            p.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.y.f
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        private final WeakHashMap f5138e = new WeakHashMap();

        e() {
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void d(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        void a(View view) {
            this.f5138e.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                b(view);
            }
        }

        void c(View view) {
            this.f5138e.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        private final int f5139a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f5140b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5141c;

        /* renamed from: d, reason: collision with root package name */
        private final int f5142d;

        f(int i3, Class cls, int i4) {
            this(i3, cls, 0, i4);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f5141c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object d(View view);

        abstract void e(View view, Object obj);

        Object f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            Object tag = view.getTag(this.f5139a);
            if (this.f5140b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void g(View view, Object obj) {
            if (c()) {
                e(view, obj);
            } else if (b() && h(f(view), obj)) {
                y.h(view);
                view.setTag(this.f5139a, obj);
                y.S(view, this.f5142d);
            }
        }

        abstract boolean h(Object obj, Object obj2);

        f(int i3, Class cls, int i4, int i5) {
            this.f5139a = i3;
            this.f5140b = cls;
            this.f5142d = i4;
            this.f5141c = i5;
        }
    }

    static class g {
        static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class h {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i3, Bundle bundle) {
            return view.performAccessibilityAction(i3, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i3, int i4, int i5, int i6) {
            view.postInvalidateOnAnimation(i3, i4, i5, i6);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j3) {
            view.postOnAnimationDelayed(runnable, j3);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z3) {
            view.setHasTransientState(z3);
        }

        static void s(View view, int i3) {
            view.setImportantForAccessibility(i3);
        }
    }

    static class i {
        static int a() {
            return View.generateViewId();
        }

        static Display b(View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i3) {
            view.setLabelFor(i3);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i3) {
            view.setLayoutDirection(i3);
        }

        static void k(View view, int i3, int i4, int i5, int i6) {
            view.setPaddingRelative(i3, i4, i5, i6);
        }
    }

    static class j {
        static Rect a(View view) {
            return view.getClipBounds();
        }

        static boolean b(View view) {
            return view.isInLayout();
        }

        static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static class k {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(View view) {
            return view.isLaidOut();
        }

        static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i3) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
        }

        static void f(View view, int i3) {
            view.setAccessibilityLiveRegion(i3);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i3) {
            accessibilityEvent.setContentChangeTypes(i3);
        }
    }

    static class l {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class m {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            J f5143a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f5144b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ t f5145c;

            a(View view, t tVar) {
                this.f5144b = view;
                this.f5145c = tVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                J w3 = J.w(windowInsets, view);
                this.f5143a = w3;
                return this.f5145c.onApplyWindowInsets(view, w3).u();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(u.b.f13710O);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static J b(View view, J j3, Rect rect) {
            WindowInsets u3 = j3.u();
            if (u3 != null) {
                return J.w(view.computeSystemWindowInsets(u3, rect), view);
            }
            rect.setEmpty();
            return j3;
        }

        static boolean c(View view, float f3, float f4, boolean z3) {
            return view.dispatchNestedFling(f3, f4, z3);
        }

        static boolean d(View view, float f3, float f4) {
            return view.dispatchNestedPreFling(f3, f4);
        }

        static boolean e(View view, int i3, int i4, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i3, i4, iArr, iArr2);
        }

        static boolean f(View view, int i3, int i4, int i5, int i6, int[] iArr) {
            return view.dispatchNestedScroll(i3, i4, i5, i6, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static J j(View view) {
            return J.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f3) {
            view.setElevation(f3);
        }

        static void t(View view, boolean z3) {
            view.setNestedScrollingEnabled(z3);
        }

        static void u(View view, t tVar) {
            if (tVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(u.b.f13710O));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, tVar));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f3) {
            view.setTranslationZ(f3);
        }

        static void x(View view, float f3) {
            view.setZ(f3);
        }

        static boolean y(View view, int i3) {
            return view.startNestedScroll(i3);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class n {
        public static J a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            J v3 = J.v(rootWindowInsets);
            v3.t(v3);
            v3.d(view.getRootView());
            return v3;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i3) {
            view.setScrollIndicators(i3);
        }

        static void d(View view, int i3, int i4) {
            view.setScrollIndicators(i3, i4);
        }
    }

    static class o {
        static void a(View view, Collection<View> collection, int i3) {
            view.addKeyboardNavigationClusters(collection, i3);
        }

        static int b(View view) {
            return view.getImportantForAutofill();
        }

        static int c(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean d(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean e(View view) {
            return view.isFocusedByDefault();
        }

        static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        static boolean g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View h(View view, View view2, int i3) {
            return view.keyboardNavigationClusterSearch(view2, i3);
        }

        static boolean i(View view) {
            return view.restoreDefaultFocus();
        }

        static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(View view, boolean z3) {
            view.setFocusedByDefault(z3);
        }

        static void l(View view, int i3) {
            view.setImportantForAutofill(i3);
        }

        static void m(View view, boolean z3) {
            view.setKeyboardNavigationCluster(z3);
        }

        static void n(View view, int i3) {
            view.setNextClusterForwardId(i3);
        }

        static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class p {
        static void a(View view, final s sVar) {
            m.g gVar = (m.g) view.getTag(u.b.f13709N);
            if (gVar == null) {
                gVar = new m.g();
                view.setTag(u.b.f13709N, gVar);
            }
            Objects.requireNonNull(sVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(sVar) { // from class: androidx.core.view.z
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            gVar.put(sVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, s sVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            m.g gVar = (m.g) view.getTag(u.b.f13709N);
            if (gVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(sVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i3) {
            return (T) view.requireViewById(i3);
        }

        static void g(View view, boolean z3) {
            view.setAccessibilityHeading(z3);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z3) {
            view.setScreenReaderFocusable(z3);
        }
    }

    private static class q {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i3, i4);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class r {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public interface s {
    }

    public static int A(View view) {
        return h.e(view);
    }

    public static void A0(View view, CharSequence charSequence) {
        F0().g(view, charSequence);
    }

    public static int B(View view) {
        return i.e(view);
    }

    public static void B0(View view, String str) {
        m.v(view, str);
    }

    public static int C(View view) {
        return i.f(view);
    }

    public static void C0(View view, float f3) {
        m.w(view, f3);
    }

    public static J D(View view) {
        return n.a(view);
    }

    private static void D0(View view) {
        if (v(view) == 0) {
            u0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (v((View) parent) == 4) {
                u0(view, 2);
                return;
            }
        }
    }

    public static CharSequence E(View view) {
        return (CharSequence) F0().f(view);
    }

    public static void E0(View view, float f3) {
        m.x(view, f3);
    }

    public static String F(View view) {
        return m.k(view);
    }

    private static f F0() {
        return new c(u.b.f13708M, CharSequence.class, 64, 30);
    }

    public static float G(View view) {
        return m.l(view);
    }

    public static void G0(View view) {
        m.z(view);
    }

    public static int H(View view) {
        return h.g(view);
    }

    public static float I(View view) {
        return m.m(view);
    }

    public static boolean J(View view) {
        return g.a(view);
    }

    public static boolean K(View view) {
        return h.h(view);
    }

    public static boolean L(View view) {
        return h.i(view);
    }

    public static boolean M(View view) {
        Boolean bool = (Boolean) a().f(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean N(View view) {
        return k.b(view);
    }

    public static boolean O(View view) {
        return k.c(view);
    }

    public static boolean P(View view) {
        return m.p(view);
    }

    public static boolean Q(View view) {
        return i.g(view);
    }

    public static boolean R(View view) {
        Boolean bool = (Boolean) i0().f(view);
        return bool != null && bool.booleanValue();
    }

    static void S(View view, int i3) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z3 = m(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (l(view) != 0 || z3) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z3 ? 32 : 2048);
                k.g(obtain, i3);
                if (z3) {
                    obtain.getText().add(m(view));
                    D0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i3 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                k.g(obtain2, i3);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(m(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i3);
                } catch (AbstractMethodError e3) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e3);
                }
            }
        }
    }

    public static void T(View view, int i3) {
        view.offsetLeftAndRight(i3);
    }

    public static void U(View view, int i3) {
        view.offsetTopAndBottom(i3);
    }

    public static J V(View view, J j3) {
        WindowInsets u3 = j3.u();
        if (u3 != null) {
            WindowInsets b3 = l.b(view, u3);
            if (!b3.equals(u3)) {
                return J.w(b3, view);
            }
        }
        return j3;
    }

    public static void W(View view, androidx.core.view.accessibility.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.q0());
    }

    private static f X() {
        return new b(u.b.f13706K, CharSequence.class, 8, 28);
    }

    public static boolean Y(View view, int i3, Bundle bundle) {
        return h.j(view, i3, bundle);
    }

    public static void Z(View view) {
        h.k(view);
    }

    private static f a() {
        return new d(u.b.f13705J, Boolean.class, 28);
    }

    public static void a0(View view, Runnable runnable) {
        h.m(view, runnable);
    }

    public static int b(View view, CharSequence charSequence, androidx.core.view.accessibility.g gVar) {
        int o3 = o(view, charSequence);
        if (o3 != -1) {
            c(view, new d.a(o3, charSequence, gVar));
        }
        return o3;
    }

    public static void b0(View view, Runnable runnable, long j3) {
        h.n(view, runnable, j3);
    }

    private static void c(View view, d.a aVar) {
        h(view);
        d0(aVar.b(), view);
        n(view).add(aVar);
        S(view, 0);
    }

    public static void c0(View view, int i3) {
        d0(i3, view);
        S(view, 0);
    }

    public static E d(View view) {
        if (f5133b == null) {
            f5133b = new WeakHashMap();
        }
        E e3 = (E) f5133b.get(view);
        if (e3 != null) {
            return e3;
        }
        E e4 = new E(view);
        f5133b.put(view, e4);
        return e4;
    }

    private static void d0(int i3, View view) {
        List n3 = n(view);
        for (int i4 = 0; i4 < n3.size(); i4++) {
            if (((d.a) n3.get(i4)).b() == i3) {
                n3.remove(i4);
                return;
            }
        }
    }

    public static J e(View view, J j3, Rect rect) {
        return m.b(view, j3, rect);
    }

    public static void e0(View view, d.a aVar, CharSequence charSequence, androidx.core.view.accessibility.g gVar) {
        if (gVar == null && charSequence == null) {
            c0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, gVar));
        }
    }

    public static J f(View view, J j3) {
        WindowInsets u3 = j3.u();
        if (u3 != null) {
            WindowInsets a3 = l.a(view, u3);
            if (!a3.equals(u3)) {
                return J.w(a3, view);
            }
        }
        return j3;
    }

    public static void f0(View view) {
        l.c(view);
    }

    static boolean g(View view, KeyEvent keyEvent) {
        return false;
    }

    public static int g0(int i3, int i4, int i5) {
        return View.resolveSizeAndState(i3, i4, i5);
    }

    static void h(View view) {
        C0252a j3 = j(view);
        if (j3 == null) {
            j3 = new C0252a();
        }
        j0(view, j3);
    }

    public static void h0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3, int i4) {
        q.c(view, context, iArr, attributeSet, typedArray, i3, i4);
    }

    public static int i() {
        return i.a();
    }

    private static f i0() {
        return new a(u.b.f13707L, Boolean.class, 28);
    }

    public static C0252a j(View view) {
        View.AccessibilityDelegate k3 = k(view);
        if (k3 == null) {
            return null;
        }
        return k3 instanceof C0252a.C0070a ? ((C0252a.C0070a) k3).f5053a : new C0252a(k3);
    }

    public static void j0(View view, C0252a c0252a) {
        if (c0252a == null && (k(view) instanceof C0252a.C0070a)) {
            c0252a = new C0252a();
        }
        view.setAccessibilityDelegate(c0252a == null ? null : c0252a.getBridge());
    }

    private static View.AccessibilityDelegate k(View view) {
        return q.a(view);
    }

    public static void k0(View view, boolean z3) {
        a().g(view, Boolean.valueOf(z3));
    }

    public static int l(View view) {
        return k.a(view);
    }

    public static void l0(View view, int i3) {
        k.f(view, i3);
    }

    public static CharSequence m(View view) {
        return (CharSequence) X().f(view);
    }

    public static void m0(View view, CharSequence charSequence) {
        X().g(view, charSequence);
        if (charSequence != null) {
            f5137f.a(view);
        } else {
            f5137f.c(view);
        }
    }

    private static List n(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(u.b.f13703H);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(u.b.f13703H, arrayList2);
        return arrayList2;
    }

    public static void n0(View view, Drawable drawable) {
        h.q(view, drawable);
    }

    private static int o(View view, CharSequence charSequence) {
        List n3 = n(view);
        for (int i3 = 0; i3 < n3.size(); i3++) {
            if (TextUtils.equals(charSequence, ((d.a) n3.get(i3)).c())) {
                return ((d.a) n3.get(i3)).b();
            }
        }
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int[] iArr = f5135d;
            if (i5 >= iArr.length || i4 != -1) {
                break;
            }
            int i6 = iArr[i5];
            boolean z3 = true;
            for (int i7 = 0; i7 < n3.size(); i7++) {
                z3 &= ((d.a) n3.get(i7)).b() != i6;
            }
            if (z3) {
                i4 = i6;
            }
            i5++;
        }
        return i4;
    }

    public static void o0(View view, ColorStateList colorStateList) {
        m.q(view, colorStateList);
    }

    public static ColorStateList p(View view) {
        return m.g(view);
    }

    public static void p0(View view, PorterDuff.Mode mode) {
        m.r(view, mode);
    }

    public static PorterDuff.Mode q(View view) {
        return m.h(view);
    }

    public static void q0(View view, Rect rect) {
        j.c(view, rect);
    }

    public static Rect r(View view) {
        return j.a(view);
    }

    public static void r0(View view, float f3) {
        m.s(view, f3);
    }

    public static Display s(View view) {
        return i.b(view);
    }

    public static void s0(View view, boolean z3) {
        view.setFitsSystemWindows(z3);
    }

    public static float t(View view) {
        return m.i(view);
    }

    public static void t0(View view, boolean z3) {
        h.r(view, z3);
    }

    public static boolean u(View view) {
        return h.b(view);
    }

    public static void u0(View view, int i3) {
        h.s(view, i3);
    }

    public static int v(View view) {
        return h.c(view);
    }

    public static void v0(View view, int i3) {
        o.l(view, i3);
    }

    public static int w(View view) {
        return o.b(view);
    }

    public static void w0(View view, boolean z3) {
        m.t(view, z3);
    }

    public static int x(View view) {
        return i.d(view);
    }

    public static void x0(View view, t tVar) {
        m.u(view, tVar);
    }

    public static int y(View view) {
        return view.getMeasuredState();
    }

    public static void y0(View view, int i3, int i4, int i5, int i6) {
        i.k(view, i3, i4, i5, i6);
    }

    public static int z(View view) {
        return h.d(view);
    }

    public static void z0(View view, int i3, int i4) {
        n.d(view, i3, i4);
    }
}
