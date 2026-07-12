package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class COUIPanelPreferenceLinearLayoutManager extends LinearLayoutManager {
    public COUIPanelPreferenceLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.B b3) {
        return super.u(b3) + this.f6355b.getScrollY();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.B b3) {
        return super.v(b3) + this.f6355b.getScrollY();
    }

    public COUIPanelPreferenceLinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }
}
