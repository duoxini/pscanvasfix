package com.coui.appcompat.button;

import M1.m;
import N1.b;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class COUILoadingButton extends COUIButton {

    /* renamed from: a0, reason: collision with root package name */
    private int f7537a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f7538b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f7539c0;

    /* renamed from: d0, reason: collision with root package name */
    private final String f7540d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Rect f7541e0;

    /* renamed from: f0, reason: collision with root package name */
    private final float f7542f0;

    /* renamed from: g0, reason: collision with root package name */
    private final float f7543g0;

    /* renamed from: h0, reason: collision with root package name */
    private final float f7544h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f7545i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f7546j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f7547k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f7548l0;

    /* renamed from: m0, reason: collision with root package name */
    private AnimatorSet f7549m0;

    public interface a {
    }

    public COUILoadingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11099n);
    }

    private boolean A() {
        return getLayoutDirection() == 1;
    }

    private void y(Canvas canvas, float f3, float f4, float f5, float f6, TextPaint textPaint, int i3) {
        textPaint.setAlpha(i3);
        int save = canvas.save();
        canvas.clipRect(f3, 0.0f, f4, getHeight());
        canvas.drawText(this.f7540d0, f5, f6, textPaint);
        canvas.restoreToCount(save);
    }

    private void z(Canvas canvas, TextPaint textPaint) {
        int i3;
        int i4;
        int i5 = this.f7547k0;
        if (A()) {
            i3 = this.f7548l0;
            i4 = this.f7546j0;
        } else {
            i3 = this.f7546j0;
            i4 = this.f7548l0;
        }
        float measuredHeight = getMeasuredHeight() / 2.0f;
        float measuredWidth = ((getMeasuredWidth() - this.f7544h0) / 2.0f) + this.f7542f0;
        textPaint.setAlpha(i3);
        canvas.drawCircle(measuredWidth, measuredHeight, this.f7542f0, textPaint);
        float f3 = measuredWidth + (this.f7542f0 * 2.0f) + this.f7543g0;
        textPaint.setAlpha(i5);
        canvas.drawCircle(f3, measuredHeight, this.f7542f0, textPaint);
        float f4 = f3 + (this.f7542f0 * 2.0f) + this.f7543g0;
        textPaint.setAlpha(i4);
        canvas.drawCircle(f4, measuredHeight, this.f7542f0, textPaint);
    }

    public int getButtonState() {
        return this.f7537a0;
    }

    public String getLoadingText() {
        return this.f7539c0;
    }

    public boolean getShowLoadingText() {
        return this.f7545i0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        AnimatorSet animatorSet;
        super.onAttachedToWindow();
        if (this.f7537a0 != 1 || (animatorSet = this.f7549m0) == null || animatorSet.isRunning()) {
            return;
        }
        this.f7549m0.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f7537a0 == 1) {
            this.f7549m0.cancel();
        }
    }

    @Override // com.coui.appcompat.button.COUIButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float measuredWidth;
        float f3;
        int i4;
        int i5;
        super.onDraw(canvas);
        if (this.f7537a0 != 1 || getPaint() == null) {
            return;
        }
        TextPaint paint = getPaint();
        int alpha = paint.getAlpha();
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f7545i0) {
            float measureText = paint.measureText(this.f7539c0);
            float measureText2 = paint.measureText(this.f7540d0);
            if (measureText + measureText2 > (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) {
                z(canvas, paint);
                i3 = save;
            } else {
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float measuredHeight = (((getMeasuredHeight() + (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - fontMetrics.bottom) - ((getPaddingBottom() - getPaddingTop()) / 2);
                int i6 = this.f7547k0;
                if (A()) {
                    measuredWidth = (((getMeasuredWidth() - measureText) - measureText2) / 2.0f) + measureText2;
                    i4 = this.f7548l0;
                    i5 = this.f7546j0;
                    f3 = ((getMeasuredWidth() - measureText) - measureText2) / 2.0f;
                } else {
                    measuredWidth = ((getMeasuredWidth() - measureText) - measureText2) / 2.0f;
                    f3 = measureText + measuredWidth;
                    i4 = this.f7546j0;
                    i5 = this.f7548l0;
                }
                canvas.drawText(this.f7539c0, measuredWidth - ((getPaddingEnd() - getPaddingStart()) / 2), measuredHeight, paint);
                paint.getTextBounds(this.f7540d0, 0, 1, this.f7541e0);
                float f4 = f3;
                i3 = save;
                y(canvas, f3, this.f7541e0.right + f3, f4, measuredHeight, paint, i4);
                paint.getTextBounds(this.f7540d0, 0, 2, this.f7541e0);
                y(canvas, r0.right + f3, this.f7541e0.right + f3, f4, measuredHeight, paint, i6);
                y(canvas, this.f7541e0.right + f3, f3 + measureText2, f4, measuredHeight, paint, i5);
            }
        } else {
            i3 = save;
            z(canvas, paint);
        }
        paint.setAlpha(alpha);
        canvas.restoreToCount(i3);
    }

    public void setLoadingText(String str) {
        if (str == null || !this.f7545i0) {
            return;
        }
        this.f7539c0 = str;
    }

    public void setOnLoadingStateChangeListener(a aVar) {
    }

    public void setOriginalText(String str) {
        this.f7538b0 = str;
    }

    public void setShowLoadingText(boolean z3) {
        this.f7545i0 = z3;
    }

    public COUILoadingButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f7537a0 = 0;
        this.f7539c0 = "";
        this.f7541e0 = new Rect();
        this.f7546j0 = 51;
        this.f7547k0 = 51;
        this.f7548l0 = 51;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1542a, i3, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(m.f1564l, false);
        this.f7545i0 = z3;
        if (z3) {
            String string = obtainStyledAttributes.getString(m.f1566m);
            this.f7539c0 = string;
            if (string == null) {
                this.f7539c0 = "";
            }
        }
        obtainStyledAttributes.recycle();
        this.f7538b0 = getText().toString();
        this.f7540d0 = context.getString(b.f1624a);
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(N1.a.f1622c);
        this.f7542f0 = dimensionPixelOffset;
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(N1.a.f1623d);
        this.f7543g0 = dimensionPixelOffset2;
        this.f7544h0 = (dimensionPixelOffset * 6.0f) + (dimensionPixelOffset2 * 2.0f);
    }
}
