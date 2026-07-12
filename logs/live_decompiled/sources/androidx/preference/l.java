package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class l extends RecyclerView.E {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f6026a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6027b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6028c;

    l(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.f6026a = sparseArray;
        sparseArray.put(R.id.title, view.findViewById(R.id.title));
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i3 = o.f6043a;
        sparseArray.put(i3, view.findViewById(i3));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public View b(int i3) {
        View view = (View) this.f6026a.get(i3);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i3);
        if (findViewById != null) {
            this.f6026a.put(i3, findViewById);
        }
        return findViewById;
    }

    public boolean c() {
        return this.f6027b;
    }

    public boolean d() {
        return this.f6028c;
    }

    public void e(boolean z3) {
        this.f6027b = z3;
    }

    public void f(boolean z3) {
        this.f6028c = z3;
    }
}
