package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class COUILinearLayoutManager extends LinearLayoutManager {
    public COUILinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D2(int i3, int i4) {
        super.D2(i3, i4 - this.f6355b.getPaddingTop());
    }
}
