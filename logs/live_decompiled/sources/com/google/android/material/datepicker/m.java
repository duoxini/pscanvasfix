package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.y;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.h;

/* loaded from: classes.dex */
class m extends RecyclerView.h {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.material.datepicker.a f9721a;

    /* renamed from: b, reason: collision with root package name */
    private final h.l f9722b;

    /* renamed from: c, reason: collision with root package name */
    private final int f9723c;

    class a implements AdapterView.OnItemClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f9724e;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f9724e = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            if (this.f9724e.getAdapter().l(i3)) {
                m.this.f9722b.a(this.f9724e.getAdapter().getItem(i3).longValue());
            }
        }
    }

    public static class b extends RecyclerView.E {

        /* renamed from: a, reason: collision with root package name */
        final TextView f9726a;

        /* renamed from: b, reason: collision with root package name */
        final MaterialCalendarGridView f9727b;

        b(LinearLayout linearLayout, boolean z3) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(H0.e.f588u);
            this.f9726a = textView;
            y.k0(textView, true);
            this.f9727b = (MaterialCalendarGridView) linearLayout.findViewById(H0.e.f584q);
            if (z3) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    m(Context context, d dVar, com.google.android.material.datepicker.a aVar, h.l lVar) {
        k k3 = aVar.k();
        k h3 = aVar.h();
        k j3 = aVar.j();
        if (k3.compareTo(j3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (j3.compareTo(h3) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f9723c = (l.f9716i * h.t(context)) + (i.r(context) ? h.t(context) : 0);
        this.f9721a = aVar;
        this.f9722b = lVar;
        setHasStableIds(true);
    }

    k g(int i3) {
        return this.f9721a.k().l(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.f9721a.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i3) {
        return this.f9721a.k().l(i3).k();
    }

    CharSequence h(int i3) {
        return g(i3).j();
    }

    int i(k kVar) {
        return this.f9721a.k().m(kVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        k l3 = this.f9721a.k().l(i3);
        bVar.f9726a.setText(l3.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f9727b.findViewById(H0.e.f584q);
        if (materialCalendarGridView.getAdapter() == null || !l3.equals(materialCalendarGridView.getAdapter().f9717e)) {
            l lVar = new l(l3, null, this.f9721a);
            materialCalendarGridView.setNumColumns(l3.f9712h);
            materialCalendarGridView.setAdapter((ListAdapter) lVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().k(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(H0.g.f615t, viewGroup, false);
        if (!i.r(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.q(-1, this.f9723c));
        return new b(linearLayout, true);
    }
}
