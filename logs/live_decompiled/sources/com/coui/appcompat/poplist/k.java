package com.coui.appcompat.poplist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import com.coui.appcompat.poplist.E;
import d0.AbstractC0335a;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class k extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Context f8278a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8279b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f8280c;

    /* renamed from: d, reason: collision with root package name */
    protected E f8281d;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), AbstractC0335a.c(k.this.getContentView().getContext(), M1.c.f1343A));
        }
    }

    public k(Context context) {
        this(context, null);
    }

    private void f(Context context) {
        this.f8278a = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{V1.a.f2529a});
        g(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        setClippingEnabled(false);
        setElevation(0.0f);
        setExitTransition(null);
        setEnterTransition(null);
        setAnimationStyle(V1.h.f2571a);
    }

    protected void a(int i3, E.a aVar) {
        this.f8281d.a(i3, aVar);
    }

    protected int b(View view, E.a aVar) {
        if (this.f8281d.i()) {
            return this.f8281d.c(view, aVar);
        }
        return 0;
    }

    protected int c(E.a aVar) {
        if (this.f8281d.i()) {
            return this.f8281d.d(aVar);
        }
        return 0;
    }

    protected void d() {
        if (!this.f8279b || getContentView() == null) {
            return;
        }
        setBackgroundDrawable(null);
        if (y0.i.a()) {
            y0.i.c(getContentView(), 3);
        } else {
            setElevation(this.f8278a.getResources().getDimensionPixelSize(M1.f.f1439d0));
            getContentView().setOutlineSpotShadowColor(androidx.core.content.a.c(this.f8278a, V1.b.f2533d));
        }
    }

    protected void e() {
        if (!this.f8280c || getContentView() == null) {
            return;
        }
        getContentView().setOutlineProvider(new a());
        getContentView().setClipToOutline(true);
    }

    protected void g(Context context, TypedArray typedArray) {
        typedArray.getDrawable(0);
        setBackgroundDrawable(context.getResources().getDrawable(V1.d.f2555a));
    }

    public void h(boolean z3) {
        if (z3) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    public void i(boolean z3) {
        this.f8279b = z3;
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        super.setContentView(view);
        e();
        d();
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11076E);
    }

    public k(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, V1.h.f2572b);
    }

    public k(View view, int i3, int i4) {
        this(view, i3, i4, false);
    }

    public k(View view, int i3, int i4, boolean z3) {
        super(view, i3, i4, z3);
        this.f8279b = false;
        this.f8280c = true;
        this.f8281d = new E();
        f(view.getContext());
    }

    public k(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8279b = false;
        this.f8280c = true;
        this.f8281d = new E();
        f(context);
    }
}
