package com.coui.appcompat.preference;

import android.content.Context;
import android.view.View;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class i extends COUIRecyclerView.a {

    /* renamed from: i, reason: collision with root package name */
    private final int[] f8801i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f8802j;

    /* renamed from: k, reason: collision with root package name */
    private PreferenceScreen f8803k;

    public i(Context context, PreferenceScreen preferenceScreen) {
        super(context);
        this.f8801i = new int[2];
        this.f8802j = new int[2];
        this.f8803k = preferenceScreen;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.a
    public int k(RecyclerView recyclerView, int i3) {
        int width;
        int width2;
        if (this.f8803k == null) {
            return super.k(recyclerView, i3);
        }
        RecyclerView.h adapter = recyclerView.getAdapter();
        if (adapter instanceof androidx.preference.h) {
            View childAt = recyclerView.getChildAt(i3);
            Object i4 = ((androidx.preference.h) adapter).i(recyclerView.getChildAdapterPosition(childAt));
            if (i4 != null && (i4 instanceof COUIRecyclerView.b)) {
                boolean z3 = childAt.getLayoutDirection() == 1;
                COUIRecyclerView.b bVar = (COUIRecyclerView.b) i4;
                View dividerEndAlignView = bVar.getDividerEndAlignView();
                if (dividerEndAlignView == null) {
                    return bVar.getDividerEndInset();
                }
                childAt.getLocationInWindow(this.f8801i);
                dividerEndAlignView.getLocationInWindow(this.f8802j);
                if (z3) {
                    width = this.f8802j[0] + dividerEndAlignView.getPaddingEnd();
                    width2 = this.f8801i[0];
                } else {
                    width = this.f8801i[0] + childAt.getWidth();
                    width2 = (this.f8802j[0] + dividerEndAlignView.getWidth()) - dividerEndAlignView.getPaddingEnd();
                }
                return width - width2;
            }
        }
        return super.l(recyclerView, i3);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.a
    public int l(RecyclerView recyclerView, int i3) {
        int paddingStart;
        int i4;
        if (this.f8803k == null) {
            return super.l(recyclerView, i3);
        }
        RecyclerView.h adapter = recyclerView.getAdapter();
        if (adapter instanceof androidx.preference.h) {
            View childAt = recyclerView.getChildAt(i3);
            Object i5 = ((androidx.preference.h) adapter).i(recyclerView.getChildAdapterPosition(childAt));
            if (i5 != null && (i5 instanceof COUIRecyclerView.b)) {
                boolean z3 = childAt.getLayoutDirection() == 1;
                COUIRecyclerView.b bVar = (COUIRecyclerView.b) i5;
                View dividerStartAlignView = bVar.getDividerStartAlignView();
                if (dividerStartAlignView == null) {
                    return bVar.getDividerStartInset();
                }
                childAt.getLocationInWindow(this.f8801i);
                dividerStartAlignView.getLocationInWindow(this.f8802j);
                if (z3) {
                    paddingStart = this.f8801i[0] + childAt.getWidth();
                    i4 = (this.f8802j[0] + dividerStartAlignView.getWidth()) - dividerStartAlignView.getPaddingStart();
                } else {
                    paddingStart = this.f8802j[0] + dividerStartAlignView.getPaddingStart();
                    i4 = this.f8801i[0];
                }
                return paddingStart - i4;
            }
        }
        return super.l(recyclerView, i3);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.a
    public boolean p(RecyclerView recyclerView, int i3) {
        Object i4;
        if (this.f8803k == null) {
            return false;
        }
        RecyclerView.h adapter = recyclerView.getAdapter();
        if ((adapter instanceof androidx.preference.h) && (i4 = ((androidx.preference.h) adapter).i(recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i3)))) != null && (i4 instanceof COUIRecyclerView.b)) {
            return ((COUIRecyclerView.b) i4).drawDivider();
        }
        return false;
    }

    protected PreferenceScreen q() {
        return this.f8803k;
    }

    public void r() {
        this.f8803k = null;
    }
}
