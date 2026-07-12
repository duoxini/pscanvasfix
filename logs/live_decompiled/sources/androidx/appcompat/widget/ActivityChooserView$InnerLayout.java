package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f3871e = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        V v3 = V.v(context, attributeSet, f3871e);
        setBackgroundDrawable(v3.g(0));
        v3.x();
    }
}
