package com.google.android.material.appbar;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.preference.Preference;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
final class StaticLayoutBuilderCompat {
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;
    private static Object textDirection;
    private int end;
    private boolean isRtl;
    private final TextPaint paint;
    private CharSequence source;
    private final int width;
    private int start = 0;
    private Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
    private int maxLines = Preference.DEFAULT_ORDER;
    private boolean includePad = true;
    private TextUtils.TruncateAt ellipsize = null;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i3;
        this.end = charSequence.length();
    }

    private void createConstructorWithReflection() {
        if (initialized) {
            return;
        }
        try {
            textDirection = this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            constructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
            initialized = true;
        } catch (Exception e3) {
            throw new StaticLayoutBuilderCompatException(e3);
        }
    }

    public static StaticLayoutBuilderCompat obtain(CharSequence charSequence, TextPaint textPaint, int i3) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i3);
    }

    public StaticLayout build() {
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.paint, max, this.ellipsize);
        }
        int min = Math.min(charSequence.length(), this.end);
        this.end = min;
        if (this.isRtl) {
            this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.start, min, this.paint, max);
        obtain.setAlignment(this.alignment);
        obtain.setIncludePad(this.includePad);
        obtain.setTextDirection(this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.ellipsize;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.maxLines);
        return obtain.build();
    }

    public StaticLayoutBuilderCompat setAlignment(Layout.Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    public StaticLayoutBuilderCompat setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat setEnd(int i3) {
        this.end = i3;
        return this;
    }

    public StaticLayoutBuilderCompat setIncludePad(boolean z3) {
        this.includePad = z3;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z3) {
        this.isRtl = z3;
        return this;
    }

    public StaticLayoutBuilderCompat setMaxLines(int i3) {
        this.maxLines = i3;
        return this;
    }

    public StaticLayoutBuilderCompat setStart(int i3) {
        this.start = i3;
        return this;
    }
}
