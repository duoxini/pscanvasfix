package com.google.android.material.internal;

import R0.d;
import R0.f;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TextDrawableHelper {
    private d textAppearance;
    private float textWidth;
    private final TextPaint textPaint = new TextPaint(1);
    private final f fontCallback = new f() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        @Override // R0.f
        public void onFontRetrievalFailed(int i3) {
            TextDrawableHelper.this.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        @Override // R0.f
        public void onFontRetrieved(Typeface typeface, boolean z3) {
            if (z3) {
                return;
            }
            TextDrawableHelper.this.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }
    };
    private boolean textWidthDirty = true;
    private WeakReference<TextDrawableDelegate> delegate = new WeakReference<>(null);

    public interface TextDrawableDelegate {
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        setDelegate(textDrawableDelegate);
    }

    private float calculateTextWidth(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public d getTextAppearance() {
        return this.textAppearance;
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public float getTextWidth(String str) {
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        float calculateTextWidth = calculateTextWidth(str);
        this.textWidth = calculateTextWidth;
        this.textWidthDirty = false;
        return calculateTextWidth;
    }

    public boolean isTextWidthDirty() {
        return this.textWidthDirty;
    }

    public void setDelegate(TextDrawableDelegate textDrawableDelegate) {
        this.delegate = new WeakReference<>(textDrawableDelegate);
    }

    public void setTextAppearance(d dVar, Context context) {
        if (this.textAppearance != dVar) {
            this.textAppearance = dVar;
            if (dVar != null) {
                dVar.o(context, this.textPaint, this.fontCallback);
                TextDrawableDelegate textDrawableDelegate = this.delegate.get();
                if (textDrawableDelegate != null) {
                    this.textPaint.drawableState = textDrawableDelegate.getState();
                }
                dVar.n(context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.delegate.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void setTextWidthDirty(boolean z3) {
        this.textWidthDirty = z3;
    }

    public void updateTextPaintDrawState(Context context) {
        this.textAppearance.n(context, this.textPaint, this.fontCallback);
    }
}
