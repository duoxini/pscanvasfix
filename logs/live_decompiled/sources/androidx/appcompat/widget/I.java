package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.preference.Preference;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class I implements ShowableListMenu {

    /* renamed from: A, reason: collision with root package name */
    final i f3927A;

    /* renamed from: B, reason: collision with root package name */
    private final h f3928B;

    /* renamed from: C, reason: collision with root package name */
    private final g f3929C;

    /* renamed from: D, reason: collision with root package name */
    private final e f3930D;

    /* renamed from: E, reason: collision with root package name */
    private Runnable f3931E;

    /* renamed from: F, reason: collision with root package name */
    final Handler f3932F;

    /* renamed from: G, reason: collision with root package name */
    private final Rect f3933G;

    /* renamed from: H, reason: collision with root package name */
    private Rect f3934H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f3935I;

    /* renamed from: J, reason: collision with root package name */
    PopupWindow f3936J;

    /* renamed from: e, reason: collision with root package name */
    private Context f3937e;

    /* renamed from: f, reason: collision with root package name */
    private ListAdapter f3938f;

    /* renamed from: g, reason: collision with root package name */
    F f3939g;

    /* renamed from: h, reason: collision with root package name */
    private int f3940h;

    /* renamed from: i, reason: collision with root package name */
    private int f3941i;

    /* renamed from: j, reason: collision with root package name */
    private int f3942j;

    /* renamed from: k, reason: collision with root package name */
    private int f3943k;

    /* renamed from: l, reason: collision with root package name */
    private int f3944l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3945m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3946n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f3947o;

    /* renamed from: p, reason: collision with root package name */
    private int f3948p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3949q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3950r;

    /* renamed from: s, reason: collision with root package name */
    int f3951s;

    /* renamed from: t, reason: collision with root package name */
    private View f3952t;

    /* renamed from: u, reason: collision with root package name */
    private int f3953u;

    /* renamed from: v, reason: collision with root package name */
    private DataSetObserver f3954v;

    /* renamed from: w, reason: collision with root package name */
    private View f3955w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f3956x;

    /* renamed from: y, reason: collision with root package name */
    private AdapterView.OnItemClickListener f3957y;

    /* renamed from: z, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f3958z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View o3 = I.this.o();
            if (o3 == null || o3.getWindowToken() == null) {
                return;
            }
            I.this.show();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            F f3;
            if (i3 == -1 || (f3 = I.this.f3939g) == null) {
                return;
            }
            f3.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i3, boolean z3) {
            return popupWindow.getMaxAvailableHeight(view, i3, z3);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z3) {
            popupWindow.setIsClippedToScreen(z3);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I.this.m();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (I.this.isShowing()) {
                I.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            I.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 != 1 || I.this.v() || I.this.f3936J.getContentView() == null) {
                return;
            }
            I i4 = I.this;
            i4.f3932F.removeCallbacks(i4.f3927A);
            I.this.f3927A.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = I.this.f3936J) != null && popupWindow.isShowing() && x3 >= 0 && x3 < I.this.f3936J.getWidth() && y3 >= 0 && y3 < I.this.f3936J.getHeight()) {
                I i3 = I.this;
                i3.f3932F.postDelayed(i3.f3927A, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            I i4 = I.this;
            i4.f3932F.removeCallbacks(i4.f3927A);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F f3 = I.this.f3939g;
            if (f3 == null || !androidx.core.view.y.N(f3) || I.this.f3939g.getCount() <= I.this.f3939g.getChildCount()) {
                return;
            }
            int childCount = I.this.f3939g.getChildCount();
            I i3 = I.this;
            if (childCount <= i3.f3951s) {
                i3.f3936J.setInputMethodMode(2);
                I.this.show();
            }
        }
    }

    public I(Context context) {
        this(context, null, AbstractC0339a.f11073B);
    }

    private void I(boolean z3) {
        d.b(this.f3936J, z3);
    }

    private int l() {
        int i3;
        int i4;
        int makeMeasureSpec;
        int i5;
        if (this.f3939g == null) {
            Context context = this.f3937e;
            this.f3931E = new a();
            F n3 = n(context, !this.f3935I);
            this.f3939g = n3;
            Drawable drawable = this.f3956x;
            if (drawable != null) {
                n3.setSelector(drawable);
            }
            this.f3939g.setAdapter(this.f3938f);
            this.f3939g.setOnItemClickListener(this.f3957y);
            this.f3939g.setFocusable(true);
            this.f3939g.setFocusableInTouchMode(true);
            this.f3939g.setOnItemSelectedListener(new b());
            this.f3939g.setOnScrollListener(this.f3929C);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f3958z;
            if (onItemSelectedListener != null) {
                this.f3939g.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f3939g;
            View view2 = this.f3952t;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i6 = this.f3953u;
                if (i6 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i6 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f3953u);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i7 = this.f3941i;
                if (i7 >= 0) {
                    i5 = Integer.MIN_VALUE;
                } else {
                    i7 = 0;
                    i5 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i7, i5), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i3 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i3 = 0;
            }
            this.f3936J.setContentView(view);
        } else {
            View view3 = this.f3952t;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i3 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f3936J.getBackground();
        if (background != null) {
            background.getPadding(this.f3933G);
            Rect rect = this.f3933G;
            int i8 = rect.top;
            i4 = rect.bottom + i8;
            if (!this.f3945m) {
                this.f3943k = -i8;
            }
        } else {
            this.f3933G.setEmpty();
            i4 = 0;
        }
        int p3 = p(o(), this.f3943k, this.f3936J.getInputMethodMode() == 2);
        if (this.f3949q || this.f3940h == -1) {
            return p3 + i4;
        }
        int i9 = this.f3941i;
        if (i9 == -2) {
            int i10 = this.f3937e.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f3933G;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i9 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        } else {
            int i11 = this.f3937e.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f3933G;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - (rect3.left + rect3.right), 1073741824);
        }
        int d3 = this.f3939g.d(makeMeasureSpec, 0, -1, p3 - i3, -1);
        if (d3 > 0) {
            i3 += i4 + this.f3939g.getPaddingTop() + this.f3939g.getPaddingBottom();
        }
        return d3 + i3;
    }

    private int p(View view, int i3, boolean z3) {
        return c.a(this.f3936J, view, i3, z3);
    }

    private void x() {
        View view = this.f3952t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f3952t);
            }
        }
    }

    public void A(int i3) {
        Drawable background = this.f3936J.getBackground();
        if (background == null) {
            L(i3);
            return;
        }
        background.getPadding(this.f3933G);
        Rect rect = this.f3933G;
        this.f3941i = rect.left + rect.right + i3;
    }

    public void B(int i3) {
        this.f3948p = i3;
    }

    public void C(Rect rect) {
        this.f3934H = rect != null ? new Rect(rect) : null;
    }

    public void D(int i3) {
        this.f3936J.setInputMethodMode(i3);
    }

    public void E(boolean z3) {
        this.f3935I = z3;
        this.f3936J.setFocusable(z3);
    }

    public void F(PopupWindow.OnDismissListener onDismissListener) {
        this.f3936J.setOnDismissListener(onDismissListener);
    }

    public void G(AdapterView.OnItemClickListener onItemClickListener) {
        this.f3957y = onItemClickListener;
    }

    public void H(boolean z3) {
        this.f3947o = true;
        this.f3946n = z3;
    }

    public void J(int i3) {
        this.f3953u = i3;
    }

    public void K(int i3) {
        F f3 = this.f3939g;
        if (!isShowing() || f3 == null) {
            return;
        }
        f3.setListSelectionHidden(false);
        f3.setSelection(i3);
        if (f3.getChoiceMode() != 0) {
            f3.setItemChecked(i3, true);
        }
    }

    public void L(int i3) {
        this.f3941i = i3;
    }

    public void a(int i3) {
        this.f3942j = i3;
    }

    public int b() {
        return this.f3942j;
    }

    public int d() {
        if (this.f3945m) {
            return this.f3943k;
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.f3936J.dismiss();
        x();
        this.f3936J.setContentView(null);
        this.f3939g = null;
        this.f3932F.removeCallbacks(this.f3927A);
    }

    public Drawable e() {
        return this.f3936J.getBackground();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f3939g;
    }

    public void h(Drawable drawable) {
        this.f3936J.setBackgroundDrawable(drawable);
    }

    public void i(int i3) {
        this.f3943k = i3;
        this.f3945m = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.f3936J.isShowing();
    }

    public void j(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f3954v;
        if (dataSetObserver == null) {
            this.f3954v = new f();
        } else {
            ListAdapter listAdapter2 = this.f3938f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3938f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f3954v);
        }
        F f3 = this.f3939g;
        if (f3 != null) {
            f3.setAdapter(this.f3938f);
        }
    }

    public void m() {
        F f3 = this.f3939g;
        if (f3 != null) {
            f3.setListSelectionHidden(true);
            f3.requestLayout();
        }
    }

    F n(Context context, boolean z3) {
        return new F(context, z3);
    }

    public View o() {
        return this.f3955w;
    }

    public Object q() {
        if (isShowing()) {
            return this.f3939g.getSelectedItem();
        }
        return null;
    }

    public long r() {
        if (isShowing()) {
            return this.f3939g.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int s() {
        if (isShowing()) {
            return this.f3939g.getSelectedItemPosition();
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int l3 = l();
        boolean v3 = v();
        androidx.core.widget.h.b(this.f3936J, this.f3944l);
        if (this.f3936J.isShowing()) {
            if (androidx.core.view.y.N(o())) {
                int i3 = this.f3941i;
                if (i3 == -1) {
                    i3 = -1;
                } else if (i3 == -2) {
                    i3 = o().getWidth();
                }
                int i4 = this.f3940h;
                if (i4 == -1) {
                    if (!v3) {
                        l3 = -1;
                    }
                    if (v3) {
                        this.f3936J.setWidth(this.f3941i == -1 ? -1 : 0);
                        this.f3936J.setHeight(0);
                    } else {
                        this.f3936J.setWidth(this.f3941i == -1 ? -1 : 0);
                        this.f3936J.setHeight(-1);
                    }
                } else if (i4 != -2) {
                    l3 = i4;
                }
                this.f3936J.setOutsideTouchable((this.f3950r || this.f3949q) ? false : true);
                this.f3936J.update(o(), this.f3942j, this.f3943k, i3 < 0 ? -1 : i3, l3 < 0 ? -1 : l3);
                return;
            }
            return;
        }
        int i5 = this.f3941i;
        if (i5 == -1) {
            i5 = -1;
        } else if (i5 == -2) {
            i5 = o().getWidth();
        }
        int i6 = this.f3940h;
        if (i6 == -1) {
            l3 = -1;
        } else if (i6 != -2) {
            l3 = i6;
        }
        this.f3936J.setWidth(i5);
        this.f3936J.setHeight(l3);
        I(true);
        this.f3936J.setOutsideTouchable((this.f3950r || this.f3949q) ? false : true);
        this.f3936J.setTouchInterceptor(this.f3928B);
        if (this.f3947o) {
            androidx.core.widget.h.a(this.f3936J, this.f3946n);
        }
        d.a(this.f3936J, this.f3934H);
        androidx.core.widget.h.c(this.f3936J, o(), this.f3942j, this.f3943k, this.f3948p);
        this.f3939g.setSelection(-1);
        if (!this.f3935I || this.f3939g.isInTouchMode()) {
            m();
        }
        if (this.f3935I) {
            return;
        }
        this.f3932F.post(this.f3930D);
    }

    public View t() {
        if (isShowing()) {
            return this.f3939g.getSelectedView();
        }
        return null;
    }

    public int u() {
        return this.f3941i;
    }

    public boolean v() {
        return this.f3936J.getInputMethodMode() == 2;
    }

    public boolean w() {
        return this.f3935I;
    }

    public void y(View view) {
        this.f3955w = view;
    }

    public void z(int i3) {
        this.f3936J.setAnimationStyle(i3);
    }

    public I(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public I(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f3940h = -2;
        this.f3941i = -2;
        this.f3944l = 1002;
        this.f3948p = 0;
        this.f3949q = false;
        this.f3950r = false;
        this.f3951s = Preference.DEFAULT_ORDER;
        this.f3953u = 0;
        this.f3927A = new i();
        this.f3928B = new h();
        this.f3929C = new g();
        this.f3930D = new e();
        this.f3933G = new Rect();
        this.f3937e = context;
        this.f3932F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f11402l1, i3, i4);
        this.f3942j = obtainStyledAttributes.getDimensionPixelOffset(e.j.f11406m1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(e.j.f11410n1, 0);
        this.f3943k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f3945m = true;
        }
        obtainStyledAttributes.recycle();
        C0243q c0243q = new C0243q(context, attributeSet, i3, i4);
        this.f3936J = c0243q;
        c0243q.setInputMethodMode(1);
    }
}
