package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import q.C0512a;

/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: n, reason: collision with root package name */
    private int f4352n;

    /* renamed from: o, reason: collision with root package name */
    private int f4353o;

    /* renamed from: p, reason: collision with root package name */
    private C0512a f4354p;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void n(q.e eVar, int i3, boolean z3) {
        this.f4353o = i3;
        if (z3) {
            int i4 = this.f4352n;
            if (i4 == 5) {
                this.f4353o = 1;
            } else if (i4 == 6) {
                this.f4353o = 0;
            }
        } else {
            int i5 = this.f4352n;
            if (i5 == 5) {
                this.f4353o = 0;
            } else if (i5 == 6) {
                this.f4353o = 1;
            }
        }
        if (eVar instanceof C0512a) {
            ((C0512a) eVar).w1(this.f4353o);
        }
    }

    @Override // androidx.constraintlayout.widget.b
    protected void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f4354p = new C0512a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.f4698n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == g.f4726u1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == g.f4722t1) {
                    this.f4354p.v1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == g.f4730v1) {
                    this.f4354p.x1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4387h = this.f4354p;
        m();
    }

    public boolean getAllowsGoneWidget() {
        return this.f4354p.q1();
    }

    public int getMargin() {
        return this.f4354p.s1();
    }

    public int getType() {
        return this.f4352n;
    }

    @Override // androidx.constraintlayout.widget.b
    public void h(q.e eVar, boolean z3) {
        n(eVar, this.f4352n, z3);
    }

    public void setAllowsGoneWidget(boolean z3) {
        this.f4354p.v1(z3);
    }

    public void setDpMargin(int i3) {
        this.f4354p.x1((int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i3) {
        this.f4354p.x1(i3);
    }

    public void setType(int i3) {
        this.f4352n = i3;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
