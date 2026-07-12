package A0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import f.AbstractC0348a;

/* loaded from: classes.dex */
public abstract class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        ColorStateList a3;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (a3 = AbstractC0348a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i3) : a3;
    }
}
