package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class h {

    /* renamed from: b, reason: collision with root package name */
    int f6588b;

    /* renamed from: c, reason: collision with root package name */
    int f6589c;

    /* renamed from: d, reason: collision with root package name */
    int f6590d;

    /* renamed from: e, reason: collision with root package name */
    int f6591e;

    /* renamed from: h, reason: collision with root package name */
    boolean f6594h;

    /* renamed from: i, reason: collision with root package name */
    boolean f6595i;

    /* renamed from: a, reason: collision with root package name */
    boolean f6587a = true;

    /* renamed from: f, reason: collision with root package name */
    int f6592f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f6593g = 0;

    h() {
    }

    boolean a(RecyclerView.B b3) {
        int i3 = this.f6589c;
        return i3 >= 0 && i3 < b3.b();
    }

    View b(RecyclerView.w wVar) {
        View o3 = wVar.o(this.f6589c);
        this.f6589c += this.f6590d;
        return o3;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f6588b + ", mCurrentPosition=" + this.f6589c + ", mItemDirection=" + this.f6590d + ", mLayoutDirection=" + this.f6591e + ", mStartLine=" + this.f6592f + ", mEndLine=" + this.f6593g + '}';
    }
}
