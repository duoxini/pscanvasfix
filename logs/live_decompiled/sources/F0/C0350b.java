package f0;

import P1.f;
import P1.g;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.dialog.widget.COUIAlertDialogMaxLinearLayout;
import com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.statement.COUIMaxHeightScrollView;
import d0.AbstractC0335a;
import e.AbstractC0339a;
import g0.AbstractC0363a;
import g0.C0364b;
import h0.AbstractC0371a;
import n0.AbstractC0481a;
import y0.EnumC0643a;
import y0.j;

/* renamed from: f0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0350b extends c.a {

    /* renamed from: V, reason: collision with root package name */
    private static final int f11484V = AbstractC0339a.f11096k;

    /* renamed from: W, reason: collision with root package name */
    private static final int f11485W = f.f1832a;

    /* renamed from: X, reason: collision with root package name */
    private static final int f11486X = f.f1834c;

    /* renamed from: A, reason: collision with root package name */
    private boolean f11487A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f11488B;

    /* renamed from: C, reason: collision with root package name */
    private int f11489C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f11490D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f11491E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f11492F;

    /* renamed from: G, reason: collision with root package name */
    private Configuration f11493G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f11494H;

    /* renamed from: I, reason: collision with root package name */
    private int f11495I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f11496J;

    /* renamed from: K, reason: collision with root package name */
    private Drawable f11497K;

    /* renamed from: L, reason: collision with root package name */
    private String f11498L;

    /* renamed from: M, reason: collision with root package name */
    private CharSequence f11499M;

    /* renamed from: N, reason: collision with root package name */
    private int f11500N;

    /* renamed from: O, reason: collision with root package name */
    private int f11501O;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f11502Q;

    /* renamed from: R, reason: collision with root package name */
    private y0.c f11503R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f11504S;

    /* renamed from: T, reason: collision with root package name */
    private int f11505T;

    /* renamed from: U, reason: collision with root package name */
    private ComponentCallbacks f11506U;

    /* renamed from: a, reason: collision with root package name */
    private androidx.appcompat.app.c f11507a;

    /* renamed from: b, reason: collision with root package name */
    private int f11508b;

    /* renamed from: c, reason: collision with root package name */
    private int f11509c;

    /* renamed from: d, reason: collision with root package name */
    private int f11510d;

    /* renamed from: e, reason: collision with root package name */
    private int f11511e;

    /* renamed from: f, reason: collision with root package name */
    private int f11512f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11513g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence[] f11514h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence[] f11515i;

    /* renamed from: j, reason: collision with root package name */
    private DialogInterface.OnClickListener f11516j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11517k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11518l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11519m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11520n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11521o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11522p;

    /* renamed from: q, reason: collision with root package name */
    private View f11523q;

    /* renamed from: r, reason: collision with root package name */
    private int f11524r;

    /* renamed from: s, reason: collision with root package name */
    private AbstractC0363a f11525s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11526t;

    /* renamed from: u, reason: collision with root package name */
    private View f11527u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f11528v;

    /* renamed from: w, reason: collision with root package name */
    private Point f11529w;

    /* renamed from: x, reason: collision with root package name */
    private Point f11530x;

    /* renamed from: y, reason: collision with root package name */
    private int f11531y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f11532z;

    /* renamed from: f0.b$a */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            C0350b.this.E();
            try {
                C0350b.this.D(view);
            } catch (Exception e3) {
                Log.e("COUIAlertDialogBuilder", "operateBlur error message:" + e3.getMessage());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            C0350b.this.F();
            C0350b.this.f11503R.k();
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: f0.b$b, reason: collision with other inner class name */
    class C0130b implements COUIMaxHeightNestedScrollView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f11534a;

        C0130b(ViewGroup viewGroup) {
            this.f11534a = viewGroup;
        }

        @Override // com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView.b
        public void a() {
            this.f11534a.setPadding(0, C0350b.this.getContext().getResources().getDimensionPixelOffset(P1.b.f1777b), 0, C0350b.this.getContext().getResources().getDimensionPixelOffset(P1.b.f1776a));
        }
    }

    /* renamed from: f0.b$c */
    class c implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ COUIMaxHeightScrollView f11536e;

        c(COUIMaxHeightScrollView cOUIMaxHeightScrollView) {
            this.f11536e = cOUIMaxHeightScrollView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f11536e.getHeight() < this.f11536e.getMaxHeight();
        }
    }

    /* renamed from: f0.b$d */
    class d implements ComponentCallbacks {
        d() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            if (C0350b.this.f11490D) {
                C0350b.this.f11493G = configuration;
                C0350b.this.a0(configuration);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    /* renamed from: f0.b$e */
    static class e implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        private final Dialog f11539e;

        /* renamed from: f, reason: collision with root package name */
        private final int f11540f;

        public e(Dialog dialog) {
            this.f11539e = dialog;
            this.f11540f = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.findViewById(P1.d.f1820q) == null) {
                AbstractC0371a.c("COUIAlertDialogBuilder", "parentPanel is null; Need to check whether the application has a layout that covers the coui's");
                return this.f11539e.onTouchEvent(motionEvent);
            }
            if (new RectF(r0.getLeft() + r0.getPaddingLeft(), r0.getTop() + r0.getPaddingTop(), r0.getRight() - r0.getPaddingRight(), r0.getBottom() - r0.getPaddingBottom()).contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (motionEvent.getAction() == 1) {
                obtain.setAction(4);
            }
            view.performClick();
            boolean onTouchEvent = this.f11539e.onTouchEvent(obtain);
            obtain.recycle();
            return onTouchEvent;
        }
    }

    public C0350b(Context context) {
        this(context, f.f1836e);
    }

    private boolean A(Configuration configuration) {
        return B(configuration) && this.f11492F;
    }

    private boolean B(Configuration configuration) {
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (this.f11494H) {
            i3 = j.p(getContext(), j.n(getContext()));
            i4 = j.p(getContext(), j.k(getContext()));
        }
        return COUIResponsiveUtils.isLargePadWindow(getContext(), i3, i4);
    }

    private boolean C(Configuration configuration) {
        if (this.f11532z) {
            return true;
        }
        return !COUIResponsiveUtils.isSmallScreenDp(configuration.screenWidthDp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(View view) {
        if (!view.isHardwareAccelerated()) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "Hardware accelerate is disabled! Set background blur failed.");
            return;
        }
        if (this.f11503R.x()) {
            View findViewById = this.f11507a.getWindow().findViewById(P1.d.f1823t);
            View findViewById2 = this.f11507a.getWindow().findViewById(P1.d.f1820q);
            this.f11503R.u(findViewById);
            this.f11503R.s(view);
            if (findViewById2 instanceof COUIAlertDialogMaxLinearLayout) {
                ((COUIAlertDialogMaxLinearLayout) findViewById2).setBlurBackgroundWindow(this.f11503R.x());
            } else {
                AbstractC0371a.c("COUIAlertDialogBuilder", "operateBlur: parentPanel is not COUIAlertDialogMaxLinearLayout");
            }
            int i3 = M1.c.f1351I;
            if (this.f11520n) {
                i3 = M1.c.f1345C;
            }
            if (AbstractC0481a.e()) {
                this.f11503R.t(AbstractC0335a.e(getContext(), i3));
            }
            int i4 = M1.c.f1350H;
            if (this.f11520n) {
                i4 = M1.c.f1344B;
            }
            float c3 = AbstractC0335a.c(getContext(), i4);
            if (this.f11488B) {
                this.f11503R.p(c3, c3, 0.0f, 0.0f);
            } else {
                this.f11503R.o(c3);
            }
            this.f11503R.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        getContext().registerComponentCallbacks(this.f11506U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.f11506U != null) {
            getContext().unregisterComponentCallbacks(this.f11506U);
        }
    }

    private void I() {
        if (this.f11496J) {
            if (this.f11497K != null) {
                View findViewById = this.f11507a.findViewById(P1.d.f1813j);
                if (findViewById instanceof COUIRoundImageView) {
                    COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) findViewById;
                    if (cOUIRoundImageView != null) {
                        cOUIRoundImageView.setImageDrawable(this.f11497K);
                        cOUIRoundImageView.setVisibility(0);
                    }
                } else {
                    AbstractC0371a.c("COUIAlertDialogBuilder", "customImageview is error; Need to check whether the application has a layout that covers the coui's");
                }
            }
            if (this.f11498L != null) {
                View findViewById2 = this.f11507a.findViewById(P1.d.f1816m);
                if (findViewById2 instanceof TextView) {
                    TextView textView = (TextView) findViewById2;
                    if (textView != null) {
                        textView.setText(this.f11498L);
                        textView.setVisibility(0);
                    }
                } else {
                    AbstractC0371a.c("COUIAlertDialogBuilder", "customTitle is error; Need to check whether the application has a layout that covers the coui's");
                }
            }
            if (this.f11499M != null) {
                View findViewById3 = this.f11507a.findViewById(P1.d.f1814k);
                if (!(findViewById3 instanceof TextView)) {
                    AbstractC0371a.c("COUIAlertDialogBuilder", "customMessage is error; Need to check whether the application has a layout that covers the coui's");
                    return;
                }
                TextView textView2 = (TextView) findViewById3;
                if (textView2 != null) {
                    textView2.setText(this.f11499M);
                    textView2.setVisibility(0);
                }
            }
        }
    }

    private void X(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams.height = 0;
            ((LinearLayout.LayoutParams) layoutParams).weight = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    private void Z(Configuration configuration) {
        if (A(configuration)) {
            this.f11491E = true;
            this.f11507a.getWindow().setGravity(17);
            this.f11507a.getWindow().setWindowAnimations(f11486X);
        } else {
            this.f11491E = false;
            this.f11507a.getWindow().setGravity(this.f11508b);
            this.f11507a.getWindow().setWindowAnimations(this.f11509c);
        }
    }

    private void j(androidx.appcompat.app.c cVar) {
        View findViewById = cVar.findViewById(P1.d.f1805b);
        if (!(findViewById instanceof COUIMaxHeightScrollView)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "alert_title_scroll_view is error; Need to check whether the application has a layout that covers the coui's");
        } else {
            COUIMaxHeightScrollView cOUIMaxHeightScrollView = (COUIMaxHeightScrollView) findViewById;
            cOUIMaxHeightScrollView.setOnTouchListener(new c(cOUIMaxHeightScrollView));
        }
    }

    private void l() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, g.f1839b, f11484V, f11485W);
        this.f11508b = obtainStyledAttributes.getInt(g.f1840c, 17);
        this.f11509c = obtainStyledAttributes.getResourceId(g.f1850m, f11486X);
        this.f11510d = obtainStyledAttributes.getDimensionPixelOffset(g.f1842e, 0);
        this.f11511e = obtainStyledAttributes.getDimensionPixelOffset(g.f1841d, 0);
        this.f11512f = obtainStyledAttributes.getResourceId(g.f1843f, 0);
        this.f11513g = obtainStyledAttributes.getBoolean(g.f1848k, false);
        this.f11488B = obtainStyledAttributes.getBoolean(g.f1849l, false);
        this.f11520n = obtainStyledAttributes.getBoolean(g.f1844g, false);
        this.f11521o = obtainStyledAttributes.getBoolean(g.f1845h, false);
        this.f11492F = obtainStyledAttributes.getBoolean(g.f1847j, false);
        this.f11496J = obtainStyledAttributes.getBoolean(g.f1846i, false);
        obtainStyledAttributes.recycle();
    }

    private void m(Context context) {
        y0.c cVar = new y0.c(context);
        this.f11503R = cVar;
        cVar.r(j.a(AbstractC0335a.h(getContext(), M1.e.f1396l)));
        this.f11503R.q(j.a(AbstractC0335a.h(getContext(), M1.e.f1395k)));
        this.f11503R.m(j.a(AbstractC0335a.h(getContext(), M1.e.f1394j)));
        this.f11503R.l(j.a(AbstractC0335a.h(getContext(), M1.e.f1393i)));
    }

    private void n() {
        this.f11507a.getWindow().getDecorView().addOnAttachStateChangeListener(new a());
    }

    private void o(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    private void p(Window window) {
        if (this.f11511e <= 0) {
            return;
        }
        View findViewById = window.findViewById(P1.d.f1820q);
        if (findViewById instanceof COUIAlertDialogMaxLinearLayout) {
            ((COUIAlertDialogMaxLinearLayout) findViewById).setMaxHeight(this.f11511e);
        } else {
            AbstractC0371a.c("COUIAlertDialogBuilder", "parentPanel is error; Need to check whether the application has a layout that covers the coui's");
        }
    }

    private void q(Window window) {
        if (this.f11510d <= 0) {
            return;
        }
        View findViewById = window.findViewById(P1.d.f1820q);
        if (findViewById instanceof COUIAlertDialogMaxLinearLayout) {
            ((COUIAlertDialogMaxLinearLayout) findViewById).setMaxWidth(this.f11510d);
        } else {
            AbstractC0371a.c("COUIAlertDialogBuilder", "parentPanel is error; Need to check whether the application has a layout that covers the coui's");
        }
    }

    private void r() {
        int i3;
        if (this.f11522p || (i3 = this.f11512f) == 0) {
            return;
        }
        setView(i3);
    }

    private void s(Window window) {
        if (this.f11522p) {
            View findViewById = window.findViewById(P1.d.f1815l);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = window.findViewById(P1.d.f1812i);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            if (this.f11520n || this.f11518l) {
                return;
            }
            findViewById2.setPaddingRelative(findViewById2.getPaddingStart(), !this.f11517k ? getContext().getResources().getDimensionPixelOffset(P1.b.f1780e) : !this.f11521o ? getContext().getResources().getDimensionPixelOffset(P1.b.f1791p) : 0, findViewById2.getPaddingEnd(), this.f11521o ? getContext().getResources().getDimensionPixelOffset(P1.b.f1790o) : 0);
        }
    }

    private void t(Window window) {
        View findViewById = window.findViewById(P1.d.f1818o);
        if (!(findViewById instanceof ViewGroup)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "listPanel is error; Need to check whether the application has a layout that covers the coui's");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        androidx.appcompat.app.c cVar = this.f11507a;
        ListView f3 = cVar != null ? cVar.f() : null;
        if (f3 != null) {
            f3.setScrollIndicators(0);
        }
        boolean z3 = (viewGroup == null || f3 == null) ? false : true;
        if (z3) {
            if (f3.getParent() != null && (f3.getParent() instanceof ViewGroup)) {
                ((ViewGroup) f3.getParent()).removeView(f3);
            }
            viewGroup.addView(f3, new ViewGroup.LayoutParams(-1, -1));
        }
        ViewGroup viewGroup2 = (ViewGroup) window.findViewById(P1.d.f1824u);
        if (viewGroup2 != null) {
            viewGroup2.setScrollIndicators(0);
            if (this.f11513g && z3) {
                X(viewGroup2, 1);
                X(viewGroup, 1);
            }
            if (!(viewGroup2 instanceof COUIMaxHeightNestedScrollView)) {
                AbstractC0371a.c("COUIAlertDialogBuilder", "scrollView isn't instanceof COUIMaxHeightNestedScrollView; Need to check whether the application has a layout that covers the coui's");
                return;
            }
            boolean c3 = AbstractC0349a.c(getContext());
            if (this.f11519m && !c3) {
                ((COUIMaxHeightNestedScrollView) viewGroup2).setMaxHeight(getContext().getResources().getDimensionPixelOffset(P1.b.f1779d));
            }
            if (window.getAttributes().gravity == 80 && this.f11518l) {
                if (this.f11520n || this.f11488B) {
                    ((COUIMaxHeightNestedScrollView) viewGroup2).setConfigChangeListener(new C0130b(viewGroup2));
                }
            }
        }
    }

    private void u() {
        androidx.appcompat.app.c cVar = this.f11507a;
        if (cVar == null) {
            return;
        }
        View findViewById = cVar.findViewById(P1.d.f1824u);
        View findViewById2 = this.f11507a.getWindow().findViewById(P1.d.f1820q);
        if (!(findViewById2 instanceof COUIAlertDialogMaxLinearLayout)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "parentPanel is error; Need to check whether the application has a layout that covers the coui's");
            return;
        }
        COUIAlertDialogMaxLinearLayout cOUIAlertDialogMaxLinearLayout = (COUIAlertDialogMaxLinearLayout) findViewById2;
        cOUIAlertDialogMaxLinearLayout.setHasLoading(this.f11520n);
        cOUIAlertDialogMaxLinearLayout.setIsTiny(this.f11488B);
        cOUIAlertDialogMaxLinearLayout.setSupportDynamicMarginTop(this.f11504S);
        if (this.f11527u != null) {
            this.f11505T = 0;
        }
        cOUIAlertDialogMaxLinearLayout.setCustomDialogPaddingBottom(this.f11505T);
        if (this.f11488B || this.f11520n || !this.f11518l || findViewById == null) {
            return;
        }
        if (this.f11517k && this.f11521o) {
            findViewById.setPadding(findViewById.getPaddingLeft(), 0, findViewById.getPaddingRight(), getContext().getResources().getDimensionPixelOffset(P1.b.f1795t));
        }
        cOUIAlertDialogMaxLinearLayout.setHasMessageMerge(this.f11502Q);
        if (this.f11488B || this.f11521o) {
            return;
        }
        cOUIAlertDialogMaxLinearLayout.setNeedSetPaddingLayoutId(P1.d.f1824u);
    }

    private void v(Window window) {
        View findViewById = window.findViewById(P1.d.f1807d);
        CharSequence[] charSequenceArr = this.f11514h;
        boolean z3 = this.f11517k || this.f11518l || this.f11522p || this.f11519m || (charSequenceArr != null && charSequenceArr.length > 0);
        if (this.f11488B) {
            if (findViewById == null || z3) {
                return;
            }
            findViewById.setPadding(findViewById.getPaddingLeft(), getContext().getResources().getDimensionPixelOffset(P1.b.f1775X), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
            return;
        }
        if (!(findViewById instanceof COUIButtonBarLayout)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "buttonPanel is error; Need to check whether the application has a layout that covers the coui's");
            return;
        }
        COUIButtonBarLayout cOUIButtonBarLayout = (COUIButtonBarLayout) findViewById;
        cOUIButtonBarLayout.setRecommendButtonId(this.f11495I);
        cOUIButtonBarLayout.setDynamicLayout(this.f11487A);
        cOUIButtonBarLayout.setShowDividerWhenHasItems(this.f11514h != null);
    }

    private void w(Window window) {
        if (this.f11488B || this.f11520n) {
            return;
        }
        View findViewById = window.findViewById(P1.d.f1827x);
        if (findViewById == null || !(findViewById instanceof LinearLayout)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "title_template is error; Need to check whether the application has a layout that covers the coui's");
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(P1.b.f1774W);
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(P1.b.f1773V);
        findViewById.setLayoutParams(layoutParams);
        x(window, window.findViewById(P1.d.f1805b));
        o(window.findViewById(P1.d.f1804a));
    }

    private void x(Window window, View view) {
        if (view == null || !(view instanceof COUIMaxHeightScrollView)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "alert_title_scroll_view is error; Need to check whether the application has a layout that covers the coui's");
            return;
        }
        COUIMaxHeightScrollView cOUIMaxHeightScrollView = (COUIMaxHeightScrollView) view;
        cOUIMaxHeightScrollView.setMinHeight((window.getContext().getResources().getDimensionPixelOffset(P1.b.f1783h) - getContext().getResources().getDimensionPixelOffset(P1.b.f1774W)) - getContext().getResources().getDimensionPixelOffset(P1.b.f1773V));
        cOUIMaxHeightScrollView.setFillViewport(true);
        View findViewById = window.findViewById(P1.d.f1820q);
        if (!(findViewById instanceof COUIAlertDialogMaxLinearLayout)) {
            AbstractC0371a.c("COUIAlertDialogBuilder", "parentPanelView is error; Need to check whether the application has a layout that covers the coui's");
            return;
        }
        COUIAlertDialogMaxLinearLayout cOUIAlertDialogMaxLinearLayout = (COUIAlertDialogMaxLinearLayout) findViewById;
        if (!this.f11518l) {
            cOUIAlertDialogMaxLinearLayout.setNeedMinHeight(window.getContext().getResources().getDimensionPixelOffset(P1.b.f1781f));
        }
        cOUIAlertDialogMaxLinearLayout.setNeedReMeasureLayoutId(cOUIMaxHeightScrollView.getId());
    }

    private void y(Window window) {
        if (z()) {
            AbstractC0352d.c(window, this.f11527u, this.f11529w, this.f11530x);
            window.getDecorView().setVisibility(4);
        } else {
            Configuration configuration = this.f11493G;
            if (configuration == null) {
                configuration = window.getContext().getResources().getConfiguration();
            }
            Z(configuration);
        }
        window.getDecorView().setOnTouchListener(new e(this.f11507a));
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i3 = this.f11524r;
        if (i3 > 0) {
            attributes.type = i3;
        }
        attributes.width = z() ? -2 : -1;
        window.setAttributes(attributes);
    }

    private boolean z() {
        return (this.f11527u == null && this.f11529w == null) ? false : true;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C0350b setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.f11519m = listAdapter != null;
        super.setAdapter(listAdapter, onClickListener);
        return this;
    }

    public C0350b H(boolean z3, EnumC0643a enumC0643a) {
        this.f11503R.v(z3, enumC0643a);
        return this;
    }

    public void J(boolean z3) {
        this.f11526t = z3;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public C0350b setItems(int i3, DialogInterface.OnClickListener onClickListener) {
        this.f11514h = getContext().getResources().getTextArray(i3);
        this.f11516j = onClickListener;
        super.setItems(i3, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public C0350b setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.f11514h = charSequenceArr;
        this.f11516j = onClickListener;
        super.setItems(charSequenceArr, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public C0350b setMessage(int i3) {
        this.f11518l = !TextUtils.isEmpty(getContext().getString(i3));
        super.setMessage(i3);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public C0350b setMessage(CharSequence charSequence) {
        this.f11518l = !TextUtils.isEmpty(charSequence);
        super.setMessage(charSequence);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public C0350b setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        super.setNegativeButton(i3, onClickListener);
        J(true);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C0350b setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setNegativeButton(charSequence, onClickListener);
        J(true);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public C0350b setNeutralButton(int i3, DialogInterface.OnClickListener onClickListener) {
        super.setNeutralButton(i3, onClickListener);
        J(true);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public C0350b setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setNeutralButton(charSequence, onClickListener);
        J(true);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public C0350b setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        super.setPositiveButton(i3, onClickListener);
        J(true);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public C0350b setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.setPositiveButton(charSequence, onClickListener);
        J(true);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public C0350b setSingleChoiceItems(ListAdapter listAdapter, int i3, DialogInterface.OnClickListener onClickListener) {
        this.f11519m = listAdapter != null;
        super.setSingleChoiceItems(listAdapter, i3, onClickListener);
        return this;
    }

    public C0350b V(int i3) {
        this.f11517k = !TextUtils.isEmpty(getContext().getString(i3));
        super.setTitle(i3);
        return this;
    }

    @Override // androidx.appcompat.app.c.a
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public C0350b setTitle(CharSequence charSequence) {
        this.f11517k = !TextUtils.isEmpty(charSequence);
        super.setTitle(charSequence);
        return this;
    }

    public C0350b Y(int i3) {
        this.f11524r = i3;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0032, code lost:
    
        if (r1 == r4.f11507a.getContext().getResources().getConfiguration().screenHeightDp) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a0(android.content.res.Configuration r5) {
        /*
            r4 = this;
            androidx.appcompat.app.c r0 = r4.f11507a
            if (r0 == 0) goto Ld4
            int r1 = r4.f11500N
            int r2 = r5.screenWidthDp
            java.lang.String r3 = "COUIAlertDialogBuilder"
            if (r1 == r2) goto L1c
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenWidthDp
            if (r2 == r0) goto L34
        L1c:
            int r0 = r4.f11501O
            int r1 = r5.screenHeightDp
            if (r0 == r1) goto L86
            androidx.appcompat.app.c r0 = r4.f11507a
            android.content.Context r0 = r0.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenHeightDp
            if (r1 != r0) goto L86
        L34:
            boolean r0 = r4.f11517k
            if (r0 == 0) goto L5d
            androidx.appcompat.app.c r0 = r4.f11507a
            int r1 = P1.d.f1805b
            android.view.View r0 = r0.findViewById(r1)
            boolean r1 = r0 instanceof com.coui.appcompat.statement.COUIMaxHeightScrollView
            if (r1 == 0) goto L58
            com.coui.appcompat.statement.COUIMaxHeightScrollView r0 = (com.coui.appcompat.statement.COUIMaxHeightScrollView) r0
            android.content.Context r1 = r4.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = P1.b.f1782g
            int r1 = r1.getDimensionPixelSize(r2)
            r0.setMaxHeight(r1)
            goto L5d
        L58:
            java.lang.String r0 = "alert_title_scroll_view is error; Need to check whether the application has a layout that covers the coui's"
            h0.AbstractC0371a.c(r3, r0)
        L5d:
            boolean r0 = r4.f11518l
            if (r0 == 0) goto L86
            androidx.appcompat.app.c r0 = r4.f11507a
            int r1 = P1.d.f1824u
            android.view.View r0 = r0.findViewById(r1)
            boolean r1 = r0 instanceof com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView
            if (r1 == 0) goto L81
            com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView r0 = (com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView) r0
            android.content.Context r1 = r4.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = P1.b.f1778c
            int r1 = r1.getDimensionPixelSize(r2)
            r0.setMaxHeight(r1)
            goto L86
        L81:
            java.lang.String r0 = "scrollView is error; Need to check whether the application has a layout that covers the coui's"
            h0.AbstractC0371a.c(r3, r0)
        L86:
            int r0 = r5.screenWidthDp
            r4.f11500N = r0
            int r0 = r5.screenHeightDp
            r4.f11501O = r0
            boolean r0 = r4.z()
            if (r0 != 0) goto La0
            boolean r0 = r4.f11491E
            boolean r1 = r4.A(r5)
            if (r0 == r1) goto La0
            r4.Z(r5)
            goto Ld4
        La0:
            boolean r5 = r4.z()
            if (r5 == 0) goto Ld4
            r5 = 0
            r4.f11529w = r5
            r4.f11527u = r5
            android.view.View r5 = r4.f11523q
            if (r5 == 0) goto Lcc
            androidx.appcompat.app.c r5 = r4.f11507a
            android.view.Window r5 = r5.getWindow()
            int r0 = P1.d.f1812i
            android.view.View r5 = r5.findViewById(r0)
            boolean r0 = r5 instanceof android.widget.FrameLayout
            if (r0 == 0) goto Lc7
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            android.view.View r0 = r4.f11523q
            r5.removeView(r0)
            goto Lcc
        Lc7:
            java.lang.String r5 = "custom is error; Need to check whether the application has a layout that covers the coui's"
            h0.AbstractC0371a.c(r3, r5)
        Lcc:
            androidx.appcompat.app.c r5 = r4.f11507a
            r5.dismiss()
            r4.show()
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.C0350b.a0(android.content.res.Configuration):void");
    }

    public void b0() {
        androidx.appcompat.app.c cVar = this.f11507a;
        if (cVar == null) {
            return;
        }
        w(cVar.getWindow());
        u();
        s(this.f11507a.getWindow());
        t(this.f11507a.getWindow());
        q(this.f11507a.getWindow());
        p(this.f11507a.getWindow());
        v(this.f11507a.getWindow());
        I();
        n();
    }

    @Override // androidx.appcompat.app.c.a
    public androidx.appcompat.app.c create() {
        r();
        k();
        androidx.appcompat.app.c create = super.create();
        this.f11507a = create;
        y(create.getWindow());
        return this.f11507a;
    }

    public androidx.appcompat.app.c g(View view, int i3, int i4) {
        return i(view, i3, i4, 0, 0);
    }

    public androidx.appcompat.app.c h(View view, Point point) {
        return g(view, point.x, point.y);
    }

    public androidx.appcompat.app.c i(View view, int i3, int i4, int i5, int i6) {
        if (C(getContext().getResources().getConfiguration())) {
            this.f11527u = view;
            if (i3 != 0 || i4 != 0) {
                Point point = new Point();
                this.f11529w = point;
                point.set(i3, i4);
            }
            if (i5 != 0 || i6 != 0) {
                Point point2 = new Point();
                this.f11530x = point2;
                point2.set(i5, i6);
            }
        }
        return create();
    }

    protected void k() {
        CharSequence[] charSequenceArr;
        AbstractC0363a abstractC0363a = this.f11525s;
        if (abstractC0363a != null) {
            abstractC0363a.m((this.f11517k || this.f11518l) ? false : true);
            this.f11525s.l((this.f11522p || this.f11526t) ? false : true);
        }
        if (this.f11519m || (charSequenceArr = this.f11514h) == null || charSequenceArr.length <= 0) {
            return;
        }
        setAdapter(new C0364b(getContext(), (this.f11517k || this.f11518l) ? false : true, (this.f11522p || this.f11526t) ? false : true, this.f11514h, this.f11515i, this.f11528v), this.f11516j);
    }

    @Override // androidx.appcompat.app.c.a
    public c.a setView(int i3) {
        this.f11522p = true;
        return super.setView(i3);
    }

    @Override // androidx.appcompat.app.c.a
    public androidx.appcompat.app.c show() {
        androidx.appcompat.app.c show = super.show();
        j(show);
        b0();
        return show;
    }

    public C0350b(Context context, int i3) {
        super(new ContextThemeWrapper(context, i3));
        this.f11517k = false;
        this.f11518l = false;
        this.f11519m = false;
        this.f11520n = false;
        this.f11521o = false;
        this.f11522p = false;
        this.f11524r = 0;
        this.f11525s = null;
        this.f11526t = false;
        this.f11527u = null;
        this.f11529w = null;
        this.f11530x = null;
        this.f11531y = -1;
        this.f11487A = true;
        this.f11488B = false;
        this.f11490D = true;
        this.f11492F = false;
        this.f11494H = false;
        this.f11495I = -1;
        this.f11496J = false;
        this.f11502Q = false;
        this.f11504S = false;
        this.f11506U = new d();
        this.f11489C = i3;
        l();
        m(context);
    }

    @Override // androidx.appcompat.app.c.a
    public c.a setView(View view) {
        this.f11522p = true;
        this.f11523q = view;
        return super.setView(view);
    }
}
