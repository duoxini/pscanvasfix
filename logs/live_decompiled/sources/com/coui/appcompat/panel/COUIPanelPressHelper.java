package com.coui.appcompat.panel;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public class COUIPanelPressHelper {
    private static final String BG_ALPHA = "bgAlpha";
    private static final PathInterpolator COUI_EASE_INTERPOLATOR = new Y.b();
    private static final int LOAD_BG_DURATION = 200;
    private Float bgAlpha = Float.valueOf(0.0f);
    private ValueAnimator pressAnim;
    private ValueAnimator releaseAnim;

    private void cancelAnim(ValueAnimator valueAnimator) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        valueAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$endAnim$1(View view, ValueAnimator valueAnimator) {
        Float f3 = (Float) valueAnimator.getAnimatedValue(BG_ALPHA);
        this.bgAlpha = f3;
        view.setAlpha(f3.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnim$0(View view, ValueAnimator valueAnimator) {
        Float f3 = (Float) valueAnimator.getAnimatedValue(BG_ALPHA);
        this.bgAlpha = f3;
        view.setAlpha(f3.floatValue());
    }

    public void endAnim(final View view) {
        cancelAnim(this.pressAnim);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(BG_ALPHA, this.bgAlpha.floatValue(), 0.0f));
        this.releaseAnim = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(COUI_EASE_INTERPOLATOR);
        this.releaseAnim.setDuration(200L);
        this.releaseAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIPanelPressHelper.this.lambda$endAnim$1(view, valueAnimator);
            }
        });
        this.releaseAnim.start();
    }

    public void startAnim(final View view) {
        cancelAnim(this.releaseAnim);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(BG_ALPHA, 0.0f, 1.0f));
        this.pressAnim = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(COUI_EASE_INTERPOLATOR);
        this.pressAnim.setDuration(200L);
        this.pressAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIPanelPressHelper.this.lambda$startAnim$0(view, valueAnimator);
            }
        });
        this.pressAnim.start();
    }
}
