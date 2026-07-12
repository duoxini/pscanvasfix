package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class COUICustomLinearLayoutForPreference extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private View f8499e;

    /* renamed from: f, reason: collision with root package name */
    private View f8500f;

    /* renamed from: g, reason: collision with root package name */
    private View f8501g;

    /* renamed from: h, reason: collision with root package name */
    private String f8502h;

    /* renamed from: i, reason: collision with root package name */
    private int f8503i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8504j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8505k;

    /* renamed from: l, reason: collision with root package name */
    private int f8506l;

    /* renamed from: m, reason: collision with root package name */
    private int f8507m;

    /* renamed from: n, reason: collision with root package name */
    private int f8508n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8509o;

    /* renamed from: p, reason: collision with root package name */
    private int f8510p;

    public COUICustomLinearLayoutForPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i3, int i4) {
        int i5;
        int g3;
        int e3;
        int min;
        int min2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight(), View.MeasureSpec.getMode(i3));
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i4) - getPaddingTop()) - getPaddingBottom(), View.MeasureSpec.getMode(i4));
        if (this.f8499e.getVisibility() != 8) {
            measureChildWithMargins(this.f8499e, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            i5 = Math.max(this.f8499e.getMeasuredHeight(), 0);
        } else {
            measureChild(this.f8499e, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
            i5 = 0;
        }
        if (this.f8500f.getVisibility() != 8) {
            measureChildWithMargins(this.f8500f, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            i5 = Math.max(this.f8500f.getMeasuredHeight(), i5);
        } else {
            measureChild(this.f8500f, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        }
        if (this.f8501g.getVisibility() != 8) {
            measureChildWithMargins(this.f8501g, makeMeasureSpec, 0, makeMeasureSpec2, 0);
            i5 = Math.max(this.f8501g.getMeasuredHeight(), i5);
        } else {
            measureChild(this.f8501g, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        }
        int paddingLeft = getPaddingLeft();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i6 = measuredWidth - paddingLeft;
        if (g(this.f8499e) + g(this.f8500f) + g(this.f8501g) > i6) {
            if (this.f8505k) {
                g3 = g(this.f8501g);
                e3 = e(this.f8501g);
            } else {
                g3 = g(this.f8499e);
                e3 = e(this.f8499e);
            }
            int i7 = g3 - e3;
            int i8 = this.f8503i;
            if (i7 >= i8) {
                i7 = i8;
            }
            if (this.f8505k) {
                min2 = Math.min(g(this.f8499e), (i6 - (i7 + e(this.f8501g))) - g(this.f8500f));
                min = measuredWidth - Math.max(measuredWidth - g(this.f8501g), (paddingLeft + min2) + g(this.f8500f));
            } else {
                min = Math.min(g(this.f8501g), (i6 - (i7 + e(this.f8499e))) - g(this.f8500f));
                min2 = Math.min(g(this.f8499e), (i6 - min) - g(this.f8500f));
            }
            int g4 = g(this.f8500f);
            if (this.f8499e.getVisibility() != 8) {
                View view = this.f8499e;
                j(view, min2 - e(view));
                i5 = Math.max(this.f8499e.getMeasuredHeight(), i5);
            }
            if (this.f8500f.getVisibility() != 8) {
                View view2 = this.f8500f;
                j(view2, g4 - e(view2));
                i5 = Math.max(this.f8500f.getMeasuredHeight(), i5);
            }
            if (this.f8501g.getVisibility() != 8) {
                View view3 = this.f8501g;
                j(view3, min - e(view3));
                i5 = Math.max(this.f8501g.getMeasuredHeight(), i5);
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.makeMeasureSpec(i5 + getPaddingTop() + getPaddingBottom(), View.MeasureSpec.getMode(i4)));
        }
    }

    private int b(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        }
        return 0;
    }

    private int c(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
        }
        return 0;
    }

    private int d(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
        }
        return 0;
    }

    private int e(View view) {
        if (view.getVisibility() != 8) {
            return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
        }
        return 0;
    }

    private int f(View view) {
        if (view.getVisibility() != 8) {
            return view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        }
        return 0;
    }

    private int g(View view) {
        if (view.getVisibility() != 8) {
            return view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
        }
        return 0;
    }

    private void h(Context context, AttributeSet attributeSet, int i3) {
        setOrientation(0);
        this.f8506l = getContext().getResources().getDimensionPixelSize(W1.c.f2630U);
        this.f8507m = getContext().getResources().getDimensionPixelSize(W1.c.f2629T);
        this.f8508n = getContext().getResources().getDimensionPixelSize(W1.c.f2632W);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2813q, i3, 0);
        this.f8510p = obtainStyledAttributes.getDimensionPixelOffset(W1.h.f2821u, 0);
        this.f8504j = obtainStyledAttributes.getBoolean(W1.h.f2817s, this.f8504j);
        this.f8505k = obtainStyledAttributes.getBoolean(W1.h.f2815r, this.f8505k);
        this.f8509o = obtainStyledAttributes.getBoolean(W1.h.f2819t, this.f8509o);
        obtainStyledAttributes.recycle();
        this.f8503i = context.getResources().getDimensionPixelSize(W1.c.f2633a);
    }

    private boolean i() {
        return getLayoutDirection() == 1;
    }

    private void j(View view, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean k() {
        /*
            r5 = this;
            android.view.View r0 = r5.f8500f
            r1 = 1
            if (r0 == 0) goto L41
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L41
            android.view.View r0 = r5.f8500f
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            android.view.View r2 = r5.f8501g
            if (r2 == 0) goto L30
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L1e
            goto L30
        L1e:
            int r2 = r0.getMarginEnd()
            int r3 = r5.f8507m
            if (r2 == r3) goto L41
            r0.setMarginEnd(r3)
            android.view.View r2 = r5.f8500f
            r2.setLayoutParams(r0)
        L2e:
            r0 = r1
            goto L42
        L30:
            int r2 = r0.getMarginEnd()
            int r3 = r5.f8506l
            if (r2 == r3) goto L41
            r0.setMarginEnd(r3)
            android.view.View r2 = r5.f8500f
            r2.setLayoutParams(r0)
            goto L2e
        L41:
            r0 = 0
        L42:
            boolean r2 = r5.f8509o
            if (r2 == 0) goto L97
            android.view.View r2 = r5.f8499e
            if (r2 == 0) goto L97
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L97
            android.view.View r2 = r5.f8500f
            if (r2 == 0) goto L5a
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L65
        L5a:
            android.view.View r2 = r5.f8501g
            if (r2 == 0) goto L7e
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L65
            goto L7e
        L65:
            android.view.View r2 = r5.f8499e
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r3 = r2.getMarginEnd()
            int r4 = r5.f8508n
            if (r3 == r4) goto L97
            r2.setMarginEnd(r4)
            android.view.View r5 = r5.f8499e
            r5.setLayoutParams(r2)
            goto L98
        L7e:
            android.view.View r2 = r5.f8499e
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
            int r3 = r2.getMarginEnd()
            int r4 = r5.f8510p
            if (r3 == r4) goto L97
            r2.setMarginEnd(r4)
            android.view.View r5 = r5.f8499e
            r5.setLayoutParams(r2)
            goto L98
        L97:
            r1 = r0
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.COUICustomLinearLayoutForPreference.k():boolean");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int g3;
        int i7;
        int paddingLeft = getPaddingLeft();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - paddingTop;
        int f3 = ((measuredHeight - f(this.f8499e)) / 2) + paddingTop;
        int f4 = ((measuredHeight - f(this.f8501g)) / 2) + paddingTop;
        int f5 = paddingTop + ((measuredHeight - f(this.f8500f)) / 2);
        if (i()) {
            int g4 = measuredWidth - g(this.f8499e);
            g3 = this.f8504j ? g(this.f8501g) + paddingLeft : g4 - g(this.f8500f);
            i7 = paddingLeft;
            paddingLeft = g4;
        } else {
            i7 = measuredWidth - g(this.f8501g);
            g3 = this.f8504j ? i7 - g(this.f8500f) : g(this.f8499e) + paddingLeft;
        }
        View view = this.f8499e;
        view.layout(c(view) + paddingLeft, d(this.f8499e) + f3, ((paddingLeft + c(this.f8499e)) + g(this.f8499e)) - e(this.f8499e), ((f3 + d(this.f8499e)) + f(this.f8499e)) - b(this.f8499e));
        View view2 = this.f8501g;
        view2.layout(c(view2) + i7, d(this.f8501g) + f4, ((i7 + c(this.f8501g)) + g(this.f8501g)) - e(this.f8501g), ((f4 + d(this.f8501g)) + f(this.f8501g)) - b(this.f8501g));
        View view3 = this.f8500f;
        view3.layout(c(view3) + g3, d(this.f8500f) + f5, ((g3 + c(this.f8500f)) + g(this.f8500f)) - e(this.f8500f), ((f5 + d(this.f8500f)) + f(this.f8500f)) - b(this.f8500f));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        this.f8499e = getChildAt(0);
        this.f8500f = getChildAt(1);
        this.f8501g = getChildAt(2);
        if (k()) {
            super.onMeasure(i3, i4);
        }
        a(i3, i4);
    }

    public COUICustomLinearLayoutForPreference(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8502h = "COUICustomLinearLayout";
        this.f8504j = true;
        this.f8505k = true;
        this.f8509o = true;
        h(context, attributeSet, i3);
    }
}
