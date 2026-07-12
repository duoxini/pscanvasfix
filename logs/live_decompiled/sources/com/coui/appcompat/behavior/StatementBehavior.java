package com.coui.appcompat.behavior;

import W1.c;
import W1.d;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class StatementBehavior extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    public int f7466a;

    /* renamed from: b, reason: collision with root package name */
    private View f7467b;

    /* renamed from: c, reason: collision with root package name */
    private View f7468c;

    /* renamed from: d, reason: collision with root package name */
    private View f7469d;

    /* renamed from: e, reason: collision with root package name */
    private int f7470e;

    /* renamed from: f, reason: collision with root package name */
    private int f7471f;

    /* renamed from: g, reason: collision with root package name */
    private int f7472g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f7473h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup.LayoutParams f7474i;

    /* renamed from: j, reason: collision with root package name */
    private int f7475j;

    /* renamed from: k, reason: collision with root package name */
    private int f7476k;

    /* renamed from: l, reason: collision with root package name */
    private int f7477l;

    /* renamed from: m, reason: collision with root package name */
    private int f7478m;

    /* renamed from: n, reason: collision with root package name */
    private int f7479n;

    /* renamed from: o, reason: collision with root package name */
    private int f7480o;

    /* renamed from: p, reason: collision with root package name */
    private int f7481p;

    /* renamed from: q, reason: collision with root package name */
    private float f7482q;

    /* renamed from: r, reason: collision with root package name */
    private float f7483r;

    /* renamed from: s, reason: collision with root package name */
    private Resources f7484s;

    class a implements View.OnScrollChangeListener {
        a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i3, int i4, int i5, int i6) {
            StatementBehavior.this.b();
        }
    }

    public StatementBehavior() {
        this.f7473h = new int[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f7469d = null;
        View view = this.f7468c;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i3).getVisibility() == 0) {
                        this.f7469d = viewGroup.getChildAt(i3);
                        break;
                    }
                    i3++;
                }
            }
        }
        if (this.f7469d == null) {
            this.f7469d = this.f7468c;
        }
        this.f7469d.getLocationOnScreen(this.f7473h);
        int i4 = this.f7473h[1];
        this.f7470e = i4;
        this.f7471f = 0;
        if (i4 < this.f7477l) {
            this.f7471f = this.f7478m;
        } else {
            int i5 = this.f7476k;
            if (i4 > i5) {
                this.f7471f = 0;
            } else {
                this.f7471f = i5 - i4;
            }
        }
        this.f7472g = this.f7471f;
        if (this.f7482q <= 1.0f) {
            float abs = Math.abs(r0) / this.f7478m;
            this.f7482q = abs;
            this.f7467b.setAlpha(abs);
        }
        int i6 = this.f7470e;
        if (i6 < this.f7479n) {
            this.f7471f = this.f7481p;
        } else {
            int i7 = this.f7480o;
            if (i6 > i7) {
                this.f7471f = 0;
            } else {
                this.f7471f = i7 - i6;
            }
        }
        this.f7472g = this.f7471f;
        float abs2 = Math.abs(r0) / this.f7481p;
        this.f7483r = abs2;
        ViewGroup.LayoutParams layoutParams = this.f7474i;
        layoutParams.width = (int) (this.f7466a - (this.f7475j * (1.0f - abs2)));
        this.f7467b.setLayoutParams(layoutParams);
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.f7484s = resources;
        this.f7475j = resources.getDimensionPixelOffset(c.f2616G) * 2;
        this.f7478m = this.f7484s.getDimensionPixelOffset(c.f2619J);
        this.f7481p = this.f7484s.getDimensionPixelOffset(c.f2617H);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        if (this.f7476k <= 0) {
            view.getLocationOnScreen(this.f7473h);
            this.f7476k = this.f7473h[1];
            this.f7468c = view3;
            View findViewById = view.findViewById(d.f2692t);
            this.f7467b = findViewById;
            this.f7466a = findViewById.getWidth();
            this.f7474i = this.f7467b.getLayoutParams();
            int i5 = this.f7476k;
            this.f7477l = i5 - this.f7478m;
            int dimensionPixelOffset = i5 - this.f7484s.getDimensionPixelOffset(c.f2618I);
            this.f7480o = dimensionPixelOffset;
            this.f7479n = dimensionPixelOffset - this.f7481p;
        }
        view3.setOnScrollChangeListener(new a());
        return false;
    }

    public StatementBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7473h = new int[2];
        init(context);
    }
}
