package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class p extends LinearLayoutManager {

    class a extends androidx.recyclerview.widget.i {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.i
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    p(Context context, int i3, boolean z3) {
        super(context, i3, z3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void L1(RecyclerView recyclerView, RecyclerView.B b3, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i3);
        M1(aVar);
    }
}
