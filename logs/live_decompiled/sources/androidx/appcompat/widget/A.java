package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class A {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f3791l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f3792m = new ConcurrentHashMap();

    /* renamed from: n, reason: collision with root package name */
    private static ConcurrentHashMap f3793n = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f3801h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f3802i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f3803j;

    /* renamed from: a, reason: collision with root package name */
    private int f3794a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3795b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f3796c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f3797d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f3798e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f3799f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f3800g = false;

    /* renamed from: k, reason: collision with root package name */
    private final f f3804k = new e();

    private static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i3, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i3, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    private static final class b {
        static boolean a(View view) {
            return view.isInLayout();
        }
    }

    private static final class c {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i3);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i4 == -1) {
                i4 = Preference.DEFAULT_ORDER;
            }
            hyphenationFrequency.setMaxLines(i4);
            try {
                fVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    private static class d extends f {
        d() {
        }
    }

    private static class e extends d {
        e() {
        }

        @Override // androidx.appcompat.widget.A.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.A.f
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class f {
        f() {
        }

        abstract void a(StaticLayout.Builder builder, TextView textView);

        abstract boolean b(TextView textView);
    }

    A(TextView textView) {
        this.f3802i = textView;
        this.f3803j = textView.getContext();
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f3794a = 0;
        this.f3797d = -1.0f;
        this.f3798e = -1.0f;
        this.f3796c = -1.0f;
        this.f3799f = new int[0];
        this.f3795b = false;
    }

    private int e(RectF rectF) {
        int length = this.f3799f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i3 = 1;
        int i4 = length - 1;
        int i5 = 0;
        while (i3 <= i4) {
            int i6 = (i3 + i4) / 2;
            if (x(this.f3799f[i6], rectF)) {
                int i7 = i6 + 1;
                i5 = i3;
                i3 = i7;
            } else {
                i5 = i6 - 1;
                i4 = i5;
            }
        }
        return this.f3799f[i5];
    }

    private static Method k(String str) {
        try {
            Method method = (Method) f3792m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                f3792m.put(str, method);
            }
            return method;
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e3);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e3);
            return obj2;
        }
    }

    private void s(float f3) {
        if (f3 != this.f3802i.getPaint().getTextSize()) {
            this.f3802i.getPaint().setTextSize(f3);
            boolean a3 = b.a(this.f3802i);
            if (this.f3802i.getLayout() != null) {
                this.f3795b = false;
                try {
                    Method k3 = k("nullLayouts");
                    if (k3 != null) {
                        k3.invoke(this.f3802i, null);
                    }
                } catch (Exception e3) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e3);
                }
                if (a3) {
                    this.f3802i.forceLayout();
                } else {
                    this.f3802i.requestLayout();
                }
                this.f3802i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f3794a == 1) {
            if (!this.f3800g || this.f3799f.length == 0) {
                int floor = ((int) Math.floor((this.f3798e - this.f3797d) / this.f3796c)) + 1;
                int[] iArr = new int[floor];
                for (int i3 = 0; i3 < floor; i3++) {
                    iArr[i3] = Math.round(this.f3797d + (i3 * this.f3796c));
                }
                this.f3799f = b(iArr);
            }
            this.f3795b = true;
        } else {
            this.f3795b = false;
        }
        return this.f3795b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = typedArray.getDimensionPixelSize(i3, -1);
            }
            this.f3799f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z3 = this.f3799f.length > 0;
        this.f3800g = z3;
        if (z3) {
            this.f3794a = 1;
            this.f3797d = r0[0];
            this.f3798e = r0[r1 - 1];
            this.f3796c = -1.0f;
        }
        return z3;
    }

    private boolean x(int i3, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f3802i.getText();
        TransformationMethod transformationMethod = this.f3802i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f3802i)) != null) {
            text = transformation;
        }
        int b3 = a.b(this.f3802i);
        l(i3);
        StaticLayout d3 = d(text, (Layout.Alignment) m(this.f3802i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b3);
        return (b3 == -1 || (d3.getLineCount() <= b3 && d3.getLineEnd(d3.getLineCount() - 1) == text.length())) && ((float) d3.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f3802i instanceof C0236j);
    }

    private void z(float f3, float f4, float f5) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f3 + "px) is less or equal to (0px)");
        }
        if (f4 <= f3) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f4 + "px) is less or equal to minimum auto-size text size (" + f3 + "px)");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f5 + "px) is less or equal to (0px)");
        }
        this.f3794a = 1;
        this.f3797d = f3;
        this.f3798e = f4;
        this.f3796c = f5;
        this.f3800g = false;
    }

    void a() {
        if (n()) {
            if (this.f3795b) {
                if (this.f3802i.getMeasuredHeight() <= 0 || this.f3802i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f3804k.b(this.f3802i) ? 1048576 : (this.f3802i.getMeasuredWidth() - this.f3802i.getTotalPaddingLeft()) - this.f3802i.getTotalPaddingRight();
                int height = (this.f3802i.getHeight() - this.f3802i.getCompoundPaddingBottom()) - this.f3802i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f3791l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float e3 = e(rectF);
                        if (e3 != this.f3802i.getTextSize()) {
                            t(0, e3);
                        }
                    } finally {
                    }
                }
            }
            this.f3795b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4) {
        return c.a(charSequence, alignment, i3, i4, this.f3802i, this.f3801h, this.f3804k);
    }

    int f() {
        return Math.round(this.f3798e);
    }

    int g() {
        return Math.round(this.f3797d);
    }

    int h() {
        return Math.round(this.f3796c);
    }

    int[] i() {
        return this.f3799f;
    }

    int j() {
        return this.f3794a;
    }

    void l(int i3) {
        TextPaint textPaint = this.f3801h;
        if (textPaint == null) {
            this.f3801h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f3801h.set(this.f3802i.getPaint());
        this.f3801h.setTextSize(i3);
    }

    boolean n() {
        return y() && this.f3794a != 0;
    }

    void o(AttributeSet attributeSet, int i3) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f3803j.obtainStyledAttributes(attributeSet, e.j.f11381g0, i3, 0);
        TextView textView = this.f3802i;
        androidx.core.view.y.h0(textView, textView.getContext(), e.j.f11381g0, attributeSet, obtainStyledAttributes, i3, 0);
        if (obtainStyledAttributes.hasValue(e.j.f11401l0)) {
            this.f3794a = obtainStyledAttributes.getInt(e.j.f11401l0, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(e.j.f11397k0) ? obtainStyledAttributes.getDimension(e.j.f11397k0, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(e.j.f11389i0) ? obtainStyledAttributes.getDimension(e.j.f11389i0, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(e.j.f11385h0) ? obtainStyledAttributes.getDimension(e.j.f11385h0, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(e.j.f11393j0) && (resourceId = obtainStyledAttributes.getResourceId(e.j.f11393j0, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f3794a = 0;
            return;
        }
        if (this.f3794a == 1) {
            if (!this.f3800g) {
                DisplayMetrics displayMetrics = this.f3803j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    void p(int i3, int i4, int i5, int i6) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f3803j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i6, i3, displayMetrics), TypedValue.applyDimension(i6, i4, displayMetrics), TypedValue.applyDimension(i6, i5, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i3) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i3 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f3803j.getResources().getDisplayMetrics();
                    for (int i4 = 0; i4 < length; i4++) {
                        iArr2[i4] = Math.round(TypedValue.applyDimension(i3, iArr[i4], displayMetrics));
                    }
                }
                this.f3799f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f3800g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i3) {
        if (y()) {
            if (i3 == 0) {
                c();
                return;
            }
            if (i3 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i3);
            }
            DisplayMetrics displayMetrics = this.f3803j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i3, float f3) {
        Context context = this.f3803j;
        s(TypedValue.applyDimension(i3, f3, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
