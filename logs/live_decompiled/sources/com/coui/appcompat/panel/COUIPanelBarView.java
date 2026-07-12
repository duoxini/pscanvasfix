package com.coui.appcompat.panel;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.res.f;

/* loaded from: classes.dex */
public class COUIPanelBarView extends View {
    private static final long ANIMATOR_DURATION = 167;
    private static final int ANIMATOR_RESPONSE_THRESHOLD = 5;
    private int continuousMove;
    private int directTo;
    private int mBarColor;
    private int mBarHeight;
    private int mBarMarginTop;
    private int mBarWidth;
    private int mCurrentPosition;
    private boolean mIsBeingDragged;
    private boolean mIsFixed;
    private float mMaxOffset;
    private float mOffset;
    private Paint mPaint;
    private Path mPath;
    private int mSpecialThreshold;
    private float mTopLeftPointX;
    private float mTopLeftPointY;
    private float mTopMiddlePointX;
    private float mTopMiddlePointY;
    private float mTopRightPointX;
    private float mTopRightPointY;
    private ObjectAnimator translationAnimator;

    public COUIPanelBarView(Context context) {
        super(context);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }

    private void drawBar(Canvas canvas) {
        setPoint();
        this.mPath.reset();
        this.mPath.moveTo(this.mTopLeftPointX, this.mTopLeftPointY);
        this.mPath.lineTo(this.mTopMiddlePointX, this.mTopMiddlePointY);
        this.mPath.lineTo(this.mTopRightPointX, this.mTopRightPointY);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init(Context context) {
        this.mBarWidth = getContext().getResources().getDimensionPixelOffset(U1.d.f2383k);
        this.mBarHeight = getContext().getResources().getDimensionPixelOffset(U1.d.f2381i);
        this.mBarMarginTop = getContext().getResources().getDimensionPixelOffset(U1.d.f2382j);
        this.mMaxOffset = getContext().getResources().getDimensionPixelOffset(U1.d.f2390r);
        this.mSpecialThreshold = getContext().getResources().getDimensionPixelOffset(U1.d.f2370B);
        this.mBarColor = f.d(context.getResources(), U1.c.f2367a, null);
        this.mPaint = new Paint();
        this.mPath = new Path();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeWidth(this.mBarHeight);
        this.mPaint.setColor(this.mBarColor);
    }

    private void playResetAnimator() {
        if (this.mIsFixed) {
            return;
        }
        ObjectAnimator objectAnimator = this.translationAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.translationAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "barOffset", this.mOffset, 0.0f);
        this.translationAnimator = ofFloat;
        ofFloat.setDuration((long) ((Math.abs(this.mOffset) / (this.mMaxOffset * 2.0f)) * 167.0f));
        this.translationAnimator.setInterpolator(new Y.b());
        this.translationAnimator.start();
        this.directTo = 0;
    }

    private void playTowardsDownAnimator() {
        if (this.mIsFixed) {
            return;
        }
        ObjectAnimator objectAnimator = this.translationAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.translationAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "barOffset", this.mOffset, this.mMaxOffset);
        this.translationAnimator = ofFloat;
        ofFloat.setDuration((long) ((Math.abs(this.mMaxOffset - this.mOffset) / (this.mMaxOffset * 2.0f)) * 167.0f));
        this.translationAnimator.setInterpolator(new Y.b());
        this.translationAnimator.start();
        this.directTo = 1;
    }

    private void playTowardsUpAnimator() {
        if (this.mIsFixed) {
            return;
        }
        ObjectAnimator objectAnimator = this.translationAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.translationAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "barOffset", this.mOffset, -this.mMaxOffset);
        this.translationAnimator = ofFloat;
        ofFloat.setDuration((long) ((Math.abs(this.mMaxOffset + this.mOffset) / (this.mMaxOffset * 2.0f)) * 167.0f));
        this.translationAnimator.setInterpolator(new LinearInterpolator());
        this.translationAnimator.start();
        this.directTo = -1;
    }

    private void setBarOffset(float f3) {
        this.mOffset = f3;
        invalidate();
    }

    private void setPoint() {
        float f3 = this.mOffset / 2.0f;
        int i3 = this.mBarHeight;
        this.mTopLeftPointX = i3 / 2.0f;
        float f4 = (i3 / 2.0f) - f3;
        this.mTopLeftPointY = f4;
        int i4 = this.mBarWidth;
        this.mTopMiddlePointX = (i4 / 2.0f) + (i3 / 2.0f);
        this.mTopMiddlePointY = (i3 / 2.0f) + f3;
        this.mTopRightPointX = i4 + (i3 / 2.0f);
        this.mTopRightPointY = f4;
    }

    private void startAnimator() {
        if (this.mIsBeingDragged) {
            int i3 = this.continuousMove;
            if (i3 > 0 && this.mOffset <= 0.0f && this.directTo != 1) {
                playTowardsDownAnimator();
            } else {
                if (i3 >= 0 || this.mOffset < 0.0f || this.directTo == -1 || this.mCurrentPosition < this.mSpecialThreshold) {
                    return;
                }
                playTowardsUpAnimator();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, this.mBarMarginTop);
        drawBar(canvas);
    }

    public void releaseDrag() {
        playResetAnimator();
    }

    public void setBarColor(int i3) {
        this.mBarColor = i3;
        this.mPaint.setColor(i3);
        invalidate();
    }

    public void setIsBeingDragged(boolean z3) {
        if (this.mIsBeingDragged != z3) {
            this.mIsBeingDragged = z3;
            if (z3) {
                return;
            }
            releaseDrag();
        }
    }

    public void setIsFixed(boolean z3) {
        this.mIsFixed = z3;
    }

    public void setPanelOffset(int i3) {
        if (this.mIsFixed) {
            return;
        }
        int i4 = this.continuousMove;
        if (i4 * i3 > 0) {
            this.continuousMove = i4 + i3;
        } else {
            this.continuousMove = i3;
        }
        this.mCurrentPosition += i3;
        if (Math.abs(this.continuousMove) > 5 || (this.continuousMove > 0 && this.mCurrentPosition < this.mSpecialThreshold)) {
            startAnimator();
        }
    }

    public COUIPanelBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }

    public COUIPanelBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }

    public COUIPanelBarView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }
}
