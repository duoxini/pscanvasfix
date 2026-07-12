package com.google.android.material.internal;

import R0.a;
import R0.d;
import R0.g;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.text.e;
import androidx.core.util.h;
import androidx.core.view.AbstractC0256e;
import androidx.core.view.y;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import x.AbstractC0626a;

/* loaded from: classes.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private boolean boundsChanged;
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private a collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private a expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private CharSequence text;
    private StaticLayout textLayout;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;
    private static final boolean USE_SCALING_TEXTURE = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private int expandedTextGravity = 16;
    private int collapsedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private float collapsedTextSize = 15.0f;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private int maxLines = 1;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;

    public CollapsingTextHelper(View view) {
        this.view = view;
        TextPaint textPaint = new TextPaint(129);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(view.getContext().getResources().getConfiguration());
    }

    private static int blendARGB(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        return Color.argb(Math.round((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3)), Math.round((Color.red(i3) * f4) + (Color.red(i4) * f3)), Math.round((Color.green(i3) * f4) + (Color.green(i4) * f3)), Math.round((Color.blue(i3) * f4) + (Color.blue(i4) * f3)));
    }

    private void calculateBaseOffsets(boolean z3) {
        StaticLayout staticLayout;
        calculateUsingTextSize(1.0f, z3);
        CharSequence charSequence = this.textToDraw;
        if (charSequence != null && (staticLayout = this.textLayout) != null) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float f3 = 0.0f;
        if (charSequence2 != null) {
            this.collapsedTextWidth = measureTextWidth(this.textPaint, charSequence2);
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int b3 = AbstractC0256e.b(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i3 = b3 & FeedbackActivity.SHOW_NO_NETWORK;
        if (i3 == 48) {
            this.collapsedDrawY = this.collapsedBounds.top;
        } else if (i3 != 80) {
            this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
        }
        int i4 = b3 & 8388615;
        if (i4 == 1) {
            this.collapsedDrawX = this.collapsedBounds.centerX() - (this.collapsedTextWidth / 2.0f);
        } else if (i4 != 5) {
            this.collapsedDrawX = this.collapsedBounds.left;
        } else {
            this.collapsedDrawX = this.collapsedBounds.right - this.collapsedTextWidth;
        }
        calculateUsingTextSize(0.0f, z3);
        float height = this.textLayout != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 == null || this.maxLines <= 1) {
            CharSequence charSequence3 = this.textToDraw;
            if (charSequence3 != null) {
                f3 = measureTextWidth(this.textPaint, charSequence3);
            }
        } else {
            f3 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.textLayout;
        this.expandedLineCount = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int b4 = AbstractC0256e.b(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i5 = b4 & FeedbackActivity.SHOW_NO_NETWORK;
        if (i5 == 48) {
            this.expandedDrawY = this.expandedBounds.top;
        } else if (i5 != 80) {
            this.expandedDrawY = this.expandedBounds.centerY() - (height / 2.0f);
        } else {
            this.expandedDrawY = (this.expandedBounds.bottom - height) + this.textPaint.descent();
        }
        int i6 = b4 & 8388615;
        if (i6 == 1) {
            this.expandedDrawX = this.expandedBounds.centerX() - (f3 / 2.0f);
        } else if (i6 != 5) {
            this.expandedDrawX = this.expandedBounds.left;
        } else {
            this.expandedDrawX = this.expandedBounds.right - f3;
        }
        clearTexture();
        setInterpolatedTextSize(this.expandedFraction);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(float f3) {
        float f4 = this.fadeModeThresholdFraction;
        return f3 <= f4 ? I0.a.b(1.0f, 0.0f, this.fadeModeStartFraction, f4, f3) : I0.a.b(0.0f, 1.0f, f4, 1.0f, f3);
    }

    private float calculateFadeModeThresholdFraction() {
        float f3 = this.fadeModeStartFraction;
        return f3 + ((1.0f - f3) * FADE_MODE_THRESHOLD_FRACTION_RELATIVE);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        return this.isRtlTextDirectionHeuristicsEnabled ? isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl) : isDefaultIsRtl;
    }

    private void calculateOffsets(float f3) {
        float f4;
        interpolateBounds(f3);
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f3, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f3, this.positionInterpolator);
            setInterpolatedTextSize(f3);
            f4 = f3;
        } else if (f3 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(0.0f);
            f4 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
            setInterpolatedTextSize(1.0f);
            f4 = 1.0f;
        }
        TimeInterpolator timeInterpolator = I0.a.f915b;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f3, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f3, timeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f4));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f5 = this.collapsedLetterSpacing;
        float f6 = this.expandedLetterSpacing;
        if (f5 != f6) {
            this.textPaint.setLetterSpacing(lerp(f6, f5, f3, timeInterpolator));
        } else {
            this.textPaint.setLetterSpacing(f5);
        }
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f3, null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, f3, null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, f3, null);
        int blendARGB = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f3);
        this.currentShadowColor = blendARGB;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB);
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f3) * this.textPaint.getAlpha()));
        }
        y.Z(this.view);
    }

    private void calculateUsingTextSize(float f3) {
        calculateUsingTextSize(f3, false);
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private StaticLayout createStaticLayout(int i3, float f3, boolean z3) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f3).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z3).setAlignment(i3 == 1 ? Layout.Alignment.ALIGN_NORMAL : getMultilineTextLayoutAlignment()).setIncludePad(false).setMaxLines(i3).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e3) {
            Log.e(TAG, e3.getCause().getMessage(), e3);
            staticLayout = null;
        }
        return (StaticLayout) h.d(staticLayout);
    }

    private void drawMultilineTransition(Canvas canvas, float f3, float f4) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f3, f4);
        float f5 = alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f5));
        TextPaint textPaint = this.textPaint;
        textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, L0.a.a(this.currentShadowColor, textPaint.getAlpha()));
        this.textLayout.draw(canvas);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f5));
        TextPaint textPaint2 = this.textPaint;
        textPaint2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, L0.a.a(this.currentShadowColor, textPaint2.getAlpha()));
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f6 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, this.textPaint);
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        if (this.fadeModeEnabled) {
            return;
        }
        String trim = this.textToDrawCollapsed.toString().trim();
        if (trim.endsWith(ELLIPSIS_NORMAL)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.textPaint.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f6, (Paint) this.textPaint);
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture != null || this.expandedBounds.isEmpty() || TextUtils.isEmpty(this.textToDraw)) {
            return;
        }
        calculateOffsets(0.0f);
        int width = this.textLayout.getWidth();
        int height = this.textLayout.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.textLayout.draw(new Canvas(this.expandedTitleTexture));
        if (this.texturePaint == null) {
            this.texturePaint = new Paint(3);
        }
    }

    private float getCollapsedTextLeftBound(int i3, int i4) {
        return (i4 == 17 || (i4 & 7) == 1) ? (i3 / 2.0f) - (this.collapsedTextWidth / 2.0f) : ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) ? this.isRtl ? this.collapsedBounds.left : this.collapsedBounds.right - this.collapsedTextWidth : this.isRtl ? this.collapsedBounds.right - this.collapsedTextWidth : this.collapsedBounds.left;
    }

    private float getCollapsedTextRightBound(RectF rectF, int i3, int i4) {
        if (i4 == 17 || (i4 & 7) == 1) {
            return (i3 / 2.0f) + (this.collapsedTextWidth / 2.0f);
        }
        if ((i4 & 8388613) == 8388613 || (i4 & 5) == 5) {
            return this.isRtl ? rectF.left + this.collapsedTextWidth : this.collapsedBounds.right;
        }
        if (this.isRtl) {
            return this.collapsedBounds.right;
        }
        return this.collapsedTextWidth + rectF.left;
    }

    private int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int b3 = AbstractC0256e.b(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        return b3 != 1 ? b3 != 5 ? this.isRtl ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.isRtl ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private void getTextPaintCollapsed(TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
        textPaint.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float f3) {
        if (this.fadeModeEnabled) {
            this.currentBounds.set(f3 < this.fadeModeThresholdFraction ? this.expandedBounds : this.collapsedBounds);
            return;
        }
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f3, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f3, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f3, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f3, this.positionInterpolator);
    }

    private static boolean isClose(float f3, float f4) {
        return Math.abs(f3 - f4) < 1.0E-5f;
    }

    private boolean isDefaultIsRtl() {
        return y.x(this.view) == 1;
    }

    private boolean isTextDirectionHeuristicsIsRtl(CharSequence charSequence, boolean z3) {
        return (z3 ? e.f5002d : e.f5001c).a(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f3, float f4, float f5, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f5 = timeInterpolator.getInterpolation(f5);
        }
        return I0.a.a(f3, f4, f5);
    }

    private float measureTextWidth(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean rectEquals(Rect rect, int i3, int i4, int i5, int i6) {
        return rect.left == i3 && rect.top == i4 && rect.right == i5 && rect.bottom == i6;
    }

    private void setCollapsedTextBlend(float f3) {
        this.collapsedTextBlend = f3;
        y.Z(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        a aVar = this.collapsedFontCallback;
        if (aVar != null) {
            aVar.a();
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface b3 = g.b(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = b3;
        if (b3 == null) {
            b3 = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = b3;
        return true;
    }

    private void setExpandedTextBlend(float f3) {
        this.expandedTextBlend = f3;
        y.Z(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        a aVar = this.expandedFontCallback;
        if (aVar != null) {
            aVar.a();
        }
        if (this.expandedTypefaceDefault == typeface) {
            return false;
        }
        this.expandedTypefaceDefault = typeface;
        Typeface b3 = g.b(this.view.getContext().getResources().getConfiguration(), typeface);
        this.expandedTypefaceBold = b3;
        if (b3 == null) {
            b3 = this.expandedTypefaceDefault;
        }
        this.expandedTypeface = b3;
        return true;
    }

    private void setInterpolatedTextSize(float f3) {
        calculateUsingTextSize(f3);
        boolean z3 = USE_SCALING_TEXTURE && this.scale != 1.0f;
        this.useTexture = z3;
        if (z3) {
            ensureExpandedTexture();
        }
        y.Z(this.view);
    }

    private boolean shouldDrawMultiline() {
        return this.maxLines > 1 && (!this.isRtl || this.fadeModeEnabled) && !this.useTexture;
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.textToDraw == null || !this.drawTitle) {
            return;
        }
        this.textPaint.setTextSize(this.currentTextSize);
        float f3 = this.currentDrawX;
        float f4 = this.currentDrawY;
        boolean z3 = this.useTexture && this.expandedTitleTexture != null;
        float f5 = this.scale;
        if (f5 != 1.0f && !this.fadeModeEnabled) {
            canvas.scale(f5, f5, f3, f4);
        }
        if (z3) {
            canvas.drawBitmap(this.expandedTitleTexture, f3, f4, this.texturePaint);
            canvas.restoreToCount(save);
            return;
        }
        if (!shouldDrawMultiline() || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction)) {
            canvas.translate(f3, f4);
            this.textLayout.draw(canvas);
        } else {
            drawMultilineTransition(canvas, this.currentDrawX - this.textLayout.getLineStart(0), f4);
        }
        canvas.restoreToCount(save);
    }

    public void getCollapsedTextActualBounds(RectF rectF, int i3, int i4) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i3, i4);
        rectF.top = this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i3, i4);
        rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    public CharSequence getText() {
        return this.text;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.collapsedTextColor;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.expandedTextColor) != null && colorStateList.isStateful());
    }

    public void maybeUpdateFontWeightAdjustment(Configuration configuration) {
        Typeface typeface = this.collapsedTypefaceDefault;
        if (typeface != null) {
            this.collapsedTypefaceBold = g.b(configuration, typeface);
        }
        Typeface typeface2 = this.expandedTypefaceDefault;
        if (typeface2 != null) {
            this.expandedTypefaceBold = g.b(configuration, typeface2);
        }
        Typeface typeface3 = this.collapsedTypefaceBold;
        if (typeface3 == null) {
            typeface3 = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = typeface3;
        Typeface typeface4 = this.expandedTypefaceBold;
        if (typeface4 == null) {
            typeface4 = this.expandedTypefaceDefault;
        }
        this.expandedTypeface = typeface4;
        recalculate(true);
    }

    void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int i3, int i4, int i5, int i6) {
        if (rectEquals(this.collapsedBounds, i3, i4, i5, i6)) {
            return;
        }
        this.collapsedBounds.set(i3, i4, i5, i6);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setCollapsedTextAppearance(int i3) {
        d dVar = new d(this.view.getContext(), i3);
        if (dVar.i() != null) {
            this.collapsedTextColor = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.collapsedTextSize = dVar.j();
        }
        ColorStateList colorStateList = dVar.f2030c;
        if (colorStateList != null) {
            this.collapsedShadowColor = colorStateList;
        }
        this.collapsedShadowDx = dVar.f2035h;
        this.collapsedShadowDy = dVar.f2036i;
        this.collapsedShadowRadius = dVar.f2037j;
        this.collapsedLetterSpacing = dVar.f2039l;
        a aVar = this.collapsedFontCallback;
        if (aVar != null) {
            aVar.a();
        }
        this.collapsedFontCallback = new a(new a.InterfaceC0037a() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // R0.a.InterfaceC0037a
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, dVar.e());
        dVar.g(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i3) {
        if (this.collapsedTextGravity != i3) {
            this.collapsedTextGravity = i3;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f3) {
        if (this.collapsedTextSize != f3) {
            this.collapsedTextSize = f3;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i3) {
        this.currentOffsetY = i3;
    }

    public void setExpandedBounds(int i3, int i4, int i5, int i6) {
        if (rectEquals(this.expandedBounds, i3, i4, i5, i6)) {
            return;
        }
        this.expandedBounds.set(i3, i4, i5, i6);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setExpandedLetterSpacing(float f3) {
        if (this.expandedLetterSpacing != f3) {
            this.expandedLetterSpacing = f3;
            recalculate();
        }
    }

    public void setExpandedTextAppearance(int i3) {
        d dVar = new d(this.view.getContext(), i3);
        if (dVar.i() != null) {
            this.expandedTextColor = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.expandedTextSize = dVar.j();
        }
        ColorStateList colorStateList = dVar.f2030c;
        if (colorStateList != null) {
            this.expandedShadowColor = colorStateList;
        }
        this.expandedShadowDx = dVar.f2035h;
        this.expandedShadowDy = dVar.f2036i;
        this.expandedShadowRadius = dVar.f2037j;
        this.expandedLetterSpacing = dVar.f2039l;
        a aVar = this.expandedFontCallback;
        if (aVar != null) {
            aVar.a();
        }
        this.expandedFontCallback = new a(new a.InterfaceC0037a() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // R0.a.InterfaceC0037a
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, dVar.e());
        dVar.g(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i3) {
        if (this.expandedTextGravity != i3) {
            this.expandedTextGravity = i3;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f3) {
        if (this.expandedTextSize != f3) {
            this.expandedTextSize = f3;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f3) {
        float a3 = AbstractC0626a.a(f3, 0.0f, 1.0f);
        if (a3 != this.expandedFraction) {
            this.expandedFraction = a3;
            calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean z3) {
        this.fadeModeEnabled = z3;
    }

    public void setFadeModeStartFraction(float f3) {
        this.fadeModeStartFraction = f3;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    public void setHyphenationFrequency(int i3) {
        this.hyphenationFrequency = i3;
    }

    public void setLineSpacingAdd(float f3) {
        this.lineSpacingAdd = f3;
    }

    public void setLineSpacingMultiplier(float f3) {
        this.lineSpacingMultiplier = f3;
    }

    public void setMaxLines(int i3) {
        if (i3 != this.maxLines) {
            this.maxLines = i3;
            clearTexture();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z3) {
        this.isRtlTextDirectionHeuristicsEnabled = z3;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private void calculateUsingTextSize(float f3, boolean z3) {
        boolean z4;
        float f4;
        float f5;
        boolean z5;
        if (this.text == null) {
            return;
        }
        float width = this.collapsedBounds.width();
        float width2 = this.expandedBounds.width();
        if (isClose(f3, 1.0f)) {
            f4 = this.collapsedTextSize;
            f5 = this.collapsedLetterSpacing;
            this.scale = 1.0f;
            Typeface typeface = this.currentTypeface;
            Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            float f6 = this.expandedTextSize;
            float f7 = this.expandedLetterSpacing;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z4 = true;
            } else {
                z4 = false;
            }
            if (isClose(f3, 0.0f)) {
                this.scale = 1.0f;
            } else {
                this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f3, this.textSizeInterpolator) / this.expandedTextSize;
            }
            float f8 = this.collapsedTextSize / this.expandedTextSize;
            width = (!z3 && width2 * f8 > width) ? Math.min(width / f8, width2) : width2;
            f4 = f6;
            f5 = f7;
            z5 = z4;
        }
        if (width > 0.0f) {
            z5 = ((this.currentTextSize > f4 ? 1 : (this.currentTextSize == f4 ? 0 : -1)) != 0) || ((this.currentLetterSpacing > f5 ? 1 : (this.currentLetterSpacing == f5 ? 0 : -1)) != 0) || this.boundsChanged || z5;
            this.currentTextSize = f4;
            this.currentLetterSpacing = f5;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z5) {
            this.textPaint.setTextSize(this.currentTextSize);
            this.textPaint.setTypeface(this.currentTypeface);
            this.textPaint.setLetterSpacing(this.currentLetterSpacing);
            this.textPaint.setLinearText(this.scale != 1.0f);
            this.isRtl = calculateIsRtl(this.text);
            StaticLayout createStaticLayout = createStaticLayout(shouldDrawMultiline() ? this.maxLines : 1, width, this.isRtl);
            this.textLayout = createStaticLayout;
            this.textToDraw = createStaticLayout.getText();
        }
    }

    public void recalculate(boolean z3) {
        if ((this.view.getHeight() <= 0 || this.view.getWidth() <= 0) && !z3) {
            return;
        }
        calculateBaseOffsets(z3);
        calculateCurrentOffsets();
    }

    public void setCollapsedBounds(Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
