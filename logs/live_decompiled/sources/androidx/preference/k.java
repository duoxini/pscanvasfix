package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.C0252a;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class k extends androidx.recyclerview.widget.m {

    /* renamed from: e, reason: collision with root package name */
    final RecyclerView f6022e;

    /* renamed from: f, reason: collision with root package name */
    final C0252a f6023f;

    /* renamed from: g, reason: collision with root package name */
    final C0252a f6024g;

    class a extends C0252a {
        a() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            Preference i3;
            k.this.f6023f.onInitializeAccessibilityNodeInfo(view, dVar);
            int childAdapterPosition = k.this.f6022e.getChildAdapterPosition(view);
            RecyclerView.h adapter = k.this.f6022e.getAdapter();
            if ((adapter instanceof h) && (i3 = ((h) adapter).i(childAdapterPosition)) != null) {
                i3.onInitializeAccessibilityNodeInfo(dVar);
            }
        }

        @Override // androidx.core.view.C0252a
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return k.this.f6023f.performAccessibilityAction(view, i3, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f6023f = super.getItemDelegate();
        this.f6024g = new a();
        this.f6022e = recyclerView;
    }

    @Override // androidx.recyclerview.widget.m
    public C0252a getItemDelegate() {
        return this.f6024g;
    }
}
