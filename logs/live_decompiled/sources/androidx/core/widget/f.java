package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public class f extends a {

    /* renamed from: w, reason: collision with root package name */
    private final ListView f5207w;

    public f(ListView listView) {
        super(listView);
        this.f5207w = listView;
    }

    @Override // androidx.core.widget.a
    public boolean a(int i3) {
        return false;
    }

    @Override // androidx.core.widget.a
    public boolean b(int i3) {
        ListView listView = this.f5207w;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i4 = firstVisiblePosition + childCount;
        if (i3 > 0) {
            if (i4 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i3 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.a
    public void j(int i3, int i4) {
        g.a(this.f5207w, i4);
    }
}
