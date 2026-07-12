package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* loaded from: classes.dex */
class s extends RecyclerView.h {

    /* renamed from: a, reason: collision with root package name */
    private final h f9734a;

    public static class a extends RecyclerView.E {

        /* renamed from: a, reason: collision with root package name */
        final TextView f9735a;

        a(TextView textView) {
            super(textView);
            this.f9735a = textView;
        }
    }

    s(h hVar) {
        this.f9734a = hVar;
    }

    int f(int i3) {
        return i3 - this.f9734a.p().k().f9711g;
    }

    int g(int i3) {
        return this.f9734a.p().k().f9711g + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.f9734a.p().l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        int g3 = g(i3);
        String string = aVar.f9735a.getContext().getString(H0.h.f630k);
        aVar.f9735a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(g3)));
        aVar.f9735a.setContentDescription(String.format(string, Integer.valueOf(g3)));
        c q3 = this.f9734a.q();
        if (r.g().get(1) == g3) {
            b bVar = q3.f9634f;
        } else {
            b bVar2 = q3.f9632d;
        }
        this.f9734a.s();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(H0.g.f617v, viewGroup, false));
    }
}
