package com.google.android.material.transformation;

import I0.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: b, reason: collision with root package name */
    private final d f10030b;

    /* renamed from: c, reason: collision with root package name */
    private final d f10031c;

    public FabTransformationScrimBehavior() {
        this.f10030b = new d(75L, 150L);
        this.f10031c = new d(0L, 150L);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10030b = new d(75L, 150L);
        this.f10031c = new d(0L, 150L);
    }
}
