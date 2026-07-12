package com.coui.appcompat.edittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class d extends COUIEditText {

    /* renamed from: D0, reason: collision with root package name */
    private int f7946D0;

    public d(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.coui.appcompat.edittext.COUIEditText, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f7946D0 = (getLineHeight() * getMaxLines()) + getPaddingTop() + getPaddingBottom();
            if (getHeight() >= this.f7946D0 && getLineCount() > 1) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
