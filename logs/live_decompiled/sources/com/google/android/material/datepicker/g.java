package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class g extends BaseAdapter {

    /* renamed from: h, reason: collision with root package name */
    private static final int f9638h = 4;

    /* renamed from: e, reason: collision with root package name */
    private final Calendar f9639e;

    /* renamed from: f, reason: collision with root package name */
    private final int f9640f;

    /* renamed from: g, reason: collision with root package name */
    private final int f9641g;

    public g() {
        Calendar i3 = r.i();
        this.f9639e = i3;
        this.f9640f = i3.getMaximum(7);
        this.f9641g = i3.getFirstDayOfWeek();
    }

    private int b(int i3) {
        int i4 = i3 + this.f9641g;
        int i5 = this.f9640f;
        return i4 > i5 ? i4 - i5 : i4;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i3) {
        if (i3 >= this.f9640f) {
            return null;
        }
        return Integer.valueOf(b(i3));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9640f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(H0.g.f613r, viewGroup, false);
        }
        this.f9639e.set(7, b(i3));
        textView.setText(this.f9639e.getDisplayName(7, f9638h, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(H0.h.f629j), this.f9639e.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
