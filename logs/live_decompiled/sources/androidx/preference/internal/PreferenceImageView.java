package androidx.preference.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.s;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PreferenceImageView extends ImageView {

    /* renamed from: e, reason: collision with root package name */
    private int f6008e;

    /* renamed from: f, reason: collision with root package name */
    private int f6009f;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f6009f;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f6008e;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i3);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i3 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i4);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i4 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i3) {
        this.f6009f = i3;
        super.setMaxHeight(i3);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i3) {
        this.f6008e = i3;
        super.setMaxWidth(i3);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f6008e = Preference.DEFAULT_ORDER;
        this.f6009f = Preference.DEFAULT_ORDER;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6196q1, i3, 0);
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(s.f6202s1, Preference.DEFAULT_ORDER));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(s.f6199r1, Preference.DEFAULT_ORDER));
        obtainStyledAttributes.recycle();
    }
}
