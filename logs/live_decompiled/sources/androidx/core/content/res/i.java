package androidx.core.content.res;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: classes.dex */
public abstract class i {
    public static int a(Context context, int i3, int i4) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId != 0 ? i3 : i4;
    }

    public static boolean b(TypedArray typedArray, int i3, int i4, boolean z3) {
        return typedArray.getBoolean(i3, typedArray.getBoolean(i4, z3));
    }

    public static Drawable c(TypedArray typedArray, int i3, int i4) {
        Drawable drawable = typedArray.getDrawable(i3);
        return drawable == null ? typedArray.getDrawable(i4) : drawable;
    }

    public static int d(TypedArray typedArray, int i3, int i4, int i5) {
        return typedArray.getInt(i3, typedArray.getInt(i4, i5));
    }

    public static int e(TypedArray typedArray, int i3, int i4, int i5) {
        return typedArray.getResourceId(i3, typedArray.getResourceId(i4, i5));
    }

    public static String f(TypedArray typedArray, int i3, int i4) {
        String string = typedArray.getString(i3);
        return string == null ? typedArray.getString(i4) : string;
    }

    public static CharSequence g(TypedArray typedArray, int i3, int i4) {
        CharSequence text = typedArray.getText(i3);
        return text == null ? typedArray.getText(i4) : text;
    }

    public static CharSequence[] h(TypedArray typedArray, int i3, int i4) {
        CharSequence[] textArray = typedArray.getTextArray(i3);
        return textArray == null ? typedArray.getTextArray(i4) : textArray;
    }
}
