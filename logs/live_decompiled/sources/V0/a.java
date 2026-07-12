package V0;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.d;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2527a = {R.attr.theme, H0.a.f467H};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2528b = {H0.a.f493y};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2527a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2528b, i3, i4);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i3, int i4) {
        int b3 = b(context, attributeSet, i3, i4);
        boolean z3 = (context instanceof d) && ((d) context).getThemeResId() == b3;
        if (b3 == 0 || z3) {
            return context;
        }
        d dVar = new d(context, b3);
        int a3 = a(context, attributeSet);
        if (a3 != 0) {
            dVar.getTheme().applyStyle(a3, true);
        }
        return dVar;
    }
}
