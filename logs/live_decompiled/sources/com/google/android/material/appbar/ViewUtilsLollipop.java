package com.google.android.material.appbar;

import H0.f;
import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.ThemeEnforcement;

/* loaded from: classes.dex */
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {R.attr.stateListAnimator};

    ViewUtilsLollipop() {
    }

    static void setBoundsViewOutlineProvider(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void setDefaultAppBarLayoutStateListAnimator(View view, float f3) {
        int integer = view.getResources().getInteger(f.f594a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j3 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, H0.a.f463D, -H0.a.f464E}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j3));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f3).setDuration(j3));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    static void setStateListAnimatorFromAttrs(View view, AttributeSet attributeSet, int i3, int i4) {
        Context context = view.getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i3, i4, new int[0]);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
