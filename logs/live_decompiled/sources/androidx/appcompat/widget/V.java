package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.f;
import f.AbstractC0348a;

/* loaded from: classes.dex */
public class V {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4154a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f4155b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f4156c;

    private V(Context context, TypedArray typedArray) {
        this.f4154a = context;
        this.f4155b = typedArray;
    }

    public static V u(Context context, int i3, int[] iArr) {
        return new V(context, context.obtainStyledAttributes(i3, iArr));
    }

    public static V v(Context context, AttributeSet attributeSet, int[] iArr) {
        return new V(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static V w(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4) {
        return new V(context, context.obtainStyledAttributes(attributeSet, iArr, i3, i4));
    }

    public boolean a(int i3, boolean z3) {
        return this.f4155b.getBoolean(i3, z3);
    }

    public int b(int i3, int i4) {
        return this.f4155b.getColor(i3, i4);
    }

    public ColorStateList c(int i3) {
        int resourceId;
        ColorStateList a3;
        return (!this.f4155b.hasValue(i3) || (resourceId = this.f4155b.getResourceId(i3, 0)) == 0 || (a3 = AbstractC0348a.a(this.f4154a, resourceId)) == null) ? this.f4155b.getColorStateList(i3) : a3;
    }

    public float d(int i3, float f3) {
        return this.f4155b.getDimension(i3, f3);
    }

    public int e(int i3, int i4) {
        return this.f4155b.getDimensionPixelOffset(i3, i4);
    }

    public int f(int i3, int i4) {
        return this.f4155b.getDimensionPixelSize(i3, i4);
    }

    public Drawable g(int i3) {
        int resourceId;
        return (!this.f4155b.hasValue(i3) || (resourceId = this.f4155b.getResourceId(i3, 0)) == 0) ? this.f4155b.getDrawable(i3) : AbstractC0348a.b(this.f4154a, resourceId);
    }

    public Drawable h(int i3) {
        int resourceId;
        if (!this.f4155b.hasValue(i3) || (resourceId = this.f4155b.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return C0235i.b().d(this.f4154a, resourceId, true);
    }

    public float i(int i3, float f3) {
        return this.f4155b.getFloat(i3, f3);
    }

    public Typeface j(int i3, int i4, f.e eVar) {
        int resourceId = this.f4155b.getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f4156c == null) {
            this.f4156c = new TypedValue();
        }
        return androidx.core.content.res.f.i(this.f4154a, resourceId, this.f4156c, i4, eVar);
    }

    public int k(int i3, int i4) {
        return this.f4155b.getInt(i3, i4);
    }

    public int l(int i3, int i4) {
        return this.f4155b.getInteger(i3, i4);
    }

    public int m(int i3, int i4) {
        return this.f4155b.getLayoutDimension(i3, i4);
    }

    public int n(int i3, int i4) {
        return this.f4155b.getResourceId(i3, i4);
    }

    public String o(int i3) {
        return this.f4155b.getString(i3);
    }

    public CharSequence p(int i3) {
        return this.f4155b.getText(i3);
    }

    public CharSequence[] q(int i3) {
        return this.f4155b.getTextArray(i3);
    }

    public TypedArray r() {
        return this.f4155b;
    }

    public boolean s(int i3) {
        return this.f4155b.hasValue(i3);
    }

    public int t() {
        return this.f4155b.length();
    }

    public void x() {
        this.f4155b.recycle();
    }
}
