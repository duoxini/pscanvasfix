package u1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import y1.t;
import y1.u;

/* renamed from: u1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0599b extends ArrayAdapter {
    public C0599b(Context context, int i3, List list) {
        super(context, i3, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public u getItem(int i3) {
        return (u) super.getItem(i3);
    }

    public void b(u uVar, int i3) {
        if (getPosition(uVar) == -1 && i3 >= 0 && i3 < getCount()) {
            getItem(i3).p(uVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        return view == null ? new t(getContext()) : view;
    }
}
