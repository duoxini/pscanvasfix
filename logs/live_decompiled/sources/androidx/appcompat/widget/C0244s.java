package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import e.AbstractC0339a;

/* renamed from: androidx.appcompat.widget.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0244s extends RatingBar {

    /* renamed from: e, reason: collision with root package name */
    private final r f4291e;

    public C0244s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11078G);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        Bitmap b3 = this.f4291e.b();
        if (b3 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b3.getWidth() * getNumStars(), i3, 0), getMeasuredHeight());
        }
    }

    public C0244s(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Q.a(this, getContext());
        r rVar = new r(this);
        this.f4291e = rVar;
        rVar.c(attributeSet, i3);
    }
}
