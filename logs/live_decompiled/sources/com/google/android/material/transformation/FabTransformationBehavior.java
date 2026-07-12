package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: b, reason: collision with root package name */
    private final Rect f10026b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f10027c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f10028d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f10029e;

    public FabTransformationBehavior() {
        this.f10026b = new Rect();
        this.f10027c = new RectF();
        this.f10028d = new RectF();
        this.f10029e = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        if (fVar.f4784h == 0) {
            fVar.f4784h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10026b = new Rect();
        this.f10027c = new RectF();
        this.f10028d = new RectF();
        this.f10029e = new int[2];
    }
}
