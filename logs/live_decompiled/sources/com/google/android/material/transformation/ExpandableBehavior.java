package com.google.android.material.transformation;

import P0.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.p;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.y;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private int f10025a;

    public ExpandableBehavior() {
        this.f10025a = 0;
    }

    protected a a(CoordinatorLayout coordinatorLayout, View view) {
        List r3 = coordinatorLayout.r(view);
        int size = r3.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) r3.get(i3);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                p.a(view2);
                return null;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        p.a(view2);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (y.O(view)) {
            return false;
        }
        a(coordinatorLayout, view);
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10025a = 0;
    }
}
