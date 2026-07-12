package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
class l extends BaseAdapter {

    /* renamed from: i, reason: collision with root package name */
    static final int f9716i = r.i().getMaximum(4);

    /* renamed from: e, reason: collision with root package name */
    final k f9717e;

    /* renamed from: f, reason: collision with root package name */
    private Collection f9718f;

    /* renamed from: g, reason: collision with root package name */
    c f9719g;

    /* renamed from: h, reason: collision with root package name */
    final a f9720h;

    l(k kVar, d dVar, a aVar) {
        this.f9717e = kVar;
        this.f9720h = aVar;
        this.f9718f = dVar.b();
    }

    private void e(Context context) {
        if (this.f9719g == null) {
            this.f9719g = new c(context);
        }
    }

    private boolean f(long j3) {
        throw null;
    }

    private void i(TextView textView, long j3) {
        b bVar;
        if (textView == null) {
            return;
        }
        if (this.f9720h.g().a(j3)) {
            textView.setEnabled(true);
            bVar = f(j3) ? this.f9719g.f9630b : r.g().getTimeInMillis() == j3 ? this.f9719g.f9631c : this.f9719g.f9629a;
        } else {
            textView.setEnabled(false);
            bVar = this.f9719g.f9635g;
        }
        bVar.b(textView);
    }

    private void j(MaterialCalendarGridView materialCalendarGridView, long j3) {
        if (k.e(j3).equals(this.f9717e)) {
            i((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f9717e.i(j3)) - materialCalendarGridView.getFirstVisiblePosition()), j3);
        }
    }

    int a(int i3) {
        return b() + (i3 - 1);
    }

    int b() {
        return this.f9717e.g();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i3) {
        if (i3 < this.f9717e.g() || i3 > g()) {
            return null;
        }
        return Long.valueOf(this.f9717e.h(h(i3)));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = H0.g.f612q
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.k r8 = r5.f9717e
            int r2 = r8.f9713i
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.k r8 = r5.f9717e
            long r7 = r8.h(r7)
            com.google.android.material.datepicker.k r3 = r5.f9717e
            int r3 = r3.f9711g
            com.google.android.material.datepicker.k r4 = com.google.android.material.datepicker.k.f()
            int r4 = r4.f9711g
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.e.a(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.e.d(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.i(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.l.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    int g() {
        return (this.f9717e.g() + this.f9717e.f9713i) - 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9717e.f9713i + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3 / this.f9717e.f9712h;
    }

    int h(int i3) {
        return (i3 - this.f9717e.g()) + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public void k(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f9718f.iterator();
        while (it.hasNext()) {
            j(materialCalendarGridView, ((Long) it.next()).longValue());
        }
    }

    boolean l(int i3) {
        return i3 >= b() && i3 <= g();
    }
}
