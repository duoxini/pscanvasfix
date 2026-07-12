package com.coui.appcompat.behavior;

import W1.b;
import W1.c;
import W1.d;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.c implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private View f7444a;

    /* renamed from: b, reason: collision with root package name */
    private View f7445b;

    /* renamed from: c, reason: collision with root package name */
    private View f7446c;

    /* renamed from: d, reason: collision with root package name */
    private int f7447d;

    /* renamed from: e, reason: collision with root package name */
    private int f7448e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f7449f;

    /* renamed from: g, reason: collision with root package name */
    private int f7450g;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup.LayoutParams f7451h;

    /* renamed from: i, reason: collision with root package name */
    private int f7452i;

    /* renamed from: j, reason: collision with root package name */
    private int f7453j;

    /* renamed from: k, reason: collision with root package name */
    private int f7454k;

    /* renamed from: l, reason: collision with root package name */
    private int f7455l;

    /* renamed from: m, reason: collision with root package name */
    private int f7456m;

    /* renamed from: n, reason: collision with root package name */
    private int f7457n;

    /* renamed from: o, reason: collision with root package name */
    private int f7458o;

    /* renamed from: p, reason: collision with root package name */
    private int f7459p;

    /* renamed from: q, reason: collision with root package name */
    private float f7460q;

    /* renamed from: r, reason: collision with root package name */
    private float f7461r;

    /* renamed from: s, reason: collision with root package name */
    private Resources f7462s;

    /* renamed from: t, reason: collision with root package name */
    public int f7463t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7464u;

    class a implements View.OnScrollChangeListener {
        a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i3, int i4, int i5, int i6) {
            SecondToolbarBehavior.this.onListScroll();
        }
    }

    public SecondToolbarBehavior() {
        this.f7449f = new int[2];
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.f7462s = resources;
        this.f7452i = resources.getDimensionPixelOffset(c.f2616G);
        this.f7455l = this.f7462s.getDimensionPixelOffset(c.f2619J);
        this.f7458o = this.f7462s.getDimensionPixelOffset(c.f2617H);
        this.f7459p = this.f7462s.getDimensionPixelOffset(c.f2618I);
        this.f7464u = this.f7462s.getBoolean(b.f2608a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.f7446c = null;
        View view = this.f7445b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i3).getVisibility() == 0) {
                        this.f7446c = viewGroup.getChildAt(i3);
                        break;
                    }
                    i3++;
                }
            }
        }
        if (this.f7446c == null) {
            this.f7446c = this.f7445b;
        }
        this.f7446c.getLocationOnScreen(this.f7449f);
        int i4 = this.f7449f[1];
        int[] iArr = new int[2];
        this.f7445b.getRootView().getLocationOnScreen(iArr);
        int i5 = iArr[1];
        if (i5 != 0) {
            i4 -= i5;
        }
        this.f7447d = 0;
        if (i4 < this.f7454k) {
            this.f7447d = this.f7455l;
        } else {
            int i6 = this.f7453j;
            if (i4 > i6) {
                this.f7447d = 0;
            } else {
                this.f7447d = i6 - i4;
            }
        }
        this.f7448e = this.f7447d;
        if (this.f7460q <= 1.0f) {
            float abs = Math.abs(r1) / this.f7455l;
            this.f7460q = abs;
            this.f7444a.setAlpha(abs);
        }
        if (i4 < this.f7456m) {
            this.f7447d = this.f7458o;
        } else {
            int i7 = this.f7457n;
            if (i4 > i7) {
                this.f7447d = 0;
            } else {
                this.f7447d = i7 - i4;
            }
        }
        this.f7448e = this.f7447d;
        float abs2 = Math.abs(r0) / this.f7458o;
        this.f7461r = abs2;
        ViewGroup.LayoutParams layoutParams = this.f7451h;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int i8 = (int) (this.f7452i * (1.0f - abs2));
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i8;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i8;
        }
        this.f7444a.setLayoutParams(layoutParams);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        onListScroll();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
        boolean z3 = (i3 & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        if (!this.f7464u && z3) {
            if (this.f7453j <= 0) {
                this.f7445b = view2;
                this.f7444a = appBarLayout.findViewById(d.f2692t);
            }
            int measuredHeight = appBarLayout.getMeasuredHeight();
            this.f7453j = measuredHeight;
            this.f7454k = measuredHeight - this.f7455l;
            int i5 = measuredHeight - this.f7459p;
            this.f7457n = i5;
            this.f7456m = i5 - this.f7458o;
            this.f7463t = this.f7444a.getWidth();
            this.f7451h = this.f7444a.getLayoutParams();
            this.f7450g = appBarLayout.getMeasuredWidth();
            view2.setOnScrollChangeListener(new a());
        }
        return false;
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7449f = new int[2];
        init(context);
    }
}
