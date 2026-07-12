package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.l;
import androidx.transition.r;
import java.util.Map;

/* loaded from: classes.dex */
public class TextScale extends l {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(r rVar) {
        View view = rVar.f6750b;
        if (view instanceof TextView) {
            rVar.f6749a.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.l
    public void captureEndValues(r rVar) {
        captureValues(rVar);
    }

    @Override // androidx.transition.l
    public void captureStartValues(r rVar) {
        captureValues(rVar);
    }

    @Override // androidx.transition.l
    public Animator createAnimator(ViewGroup viewGroup, r rVar, r rVar2) {
        if (rVar == null || rVar2 == null || !(rVar.f6750b instanceof TextView)) {
            return null;
        }
        View view = rVar2.f6750b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        Map map = rVar.f6749a;
        Map map2 = rVar2.f6749a;
        float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float floatValue2 = map2.get(PROPNAME_SCALE) != null ? ((Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue3);
                textView.setScaleY(floatValue3);
            }
        });
        return ofFloat;
    }
}
