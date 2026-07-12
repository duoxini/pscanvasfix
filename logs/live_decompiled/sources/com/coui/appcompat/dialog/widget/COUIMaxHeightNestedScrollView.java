package com.coui.appcompat.dialog.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import c2.AbstractC0299a;

/* loaded from: classes.dex */
public class COUIMaxHeightNestedScrollView extends com.coui.appcompat.scrollview.a {

    /* renamed from: D0, reason: collision with root package name */
    private int f7749D0;

    /* renamed from: E0, reason: collision with root package name */
    private int f7750E0;

    /* renamed from: F0, reason: collision with root package name */
    private b f7751F0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIMaxHeightNestedScrollView.this.requestLayout();
        }
    }

    public interface b {
        void a();
    }

    public COUIMaxHeightNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b bVar = this.f7751F0;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.coui.appcompat.scrollview.a, androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (canScrollVertically(-1) || canScrollVertically(1)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int measuredHeight = getMeasuredHeight();
        int i5 = this.f7750E0;
        if (i5 > 0) {
            measuredHeight = Math.max(measuredHeight, i5);
        }
        int i6 = this.f7749D0;
        if (i6 > 0) {
            measuredHeight = Math.min(i6, measuredHeight);
        }
        if (measuredHeight != getMeasuredHeight()) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(Math.min(this.f7749D0, measuredHeight), 1073741824));
        }
    }

    public void setConfigChangeListener(b bVar) {
        this.f7751F0 = bVar;
    }

    public void setMaxHeight(int i3) {
        this.f7749D0 = i3;
        if (isInLayout()) {
            post(new a());
        } else {
            requestLayout();
        }
    }

    public void setMinHeight(int i3) {
        this.f7750E0 = i3;
        requestLayout();
    }

    public COUIMaxHeightNestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0299a.f7437b);
        this.f7749D0 = obtainStyledAttributes.getDimensionPixelOffset(AbstractC0299a.f7438c, 0);
        this.f7750E0 = obtainStyledAttributes.getDimensionPixelOffset(AbstractC0299a.f7439d, 0);
        obtainStyledAttributes.recycle();
    }
}
