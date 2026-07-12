package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import d0.AbstractC0335a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIRecommendedPreference extends Preference {

    /* renamed from: e, reason: collision with root package name */
    private List f8664e;

    /* renamed from: f, reason: collision with root package name */
    private float f8665f;

    /* renamed from: g, reason: collision with root package name */
    private int f8666g;

    /* renamed from: h, reason: collision with root package name */
    private k f8667h;

    /* renamed from: i, reason: collision with root package name */
    private String f8668i;

    public interface a {
        void onRecommendedClick(View view);
    }

    private static class b extends RecyclerView.h {

        /* renamed from: a, reason: collision with root package name */
        private Context f8669a;

        /* renamed from: b, reason: collision with root package name */
        private float f8670b;

        /* renamed from: c, reason: collision with root package name */
        private int f8671c;

        /* renamed from: d, reason: collision with root package name */
        private List f8672d = new ArrayList();

        class a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f8673e;

            a(c cVar) {
                this.f8673e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f8673e.f8676b != null) {
                    this.f8673e.f8676b.onRecommendedClick(view);
                }
            }
        }

        public b(Context context, List list, String str, float f3, int i3) {
            this.f8669a = context;
            this.f8670b = f3;
            this.f8671c = i3;
            h(list, str);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(d dVar, int i3) {
            c cVar = (c) this.f8672d.get(i3);
            dVar.f8677a.setText(cVar.f8675a);
            dVar.f8678b.setRadius(this.f8670b);
            dVar.f8678b.setBackgroundColor(this.f8671c);
            if (i3 <= 0) {
                if (i3 == 0) {
                    dVar.f8678b.setClickable(false);
                    dVar.f8678b.setPositionInGroup(1);
                    return;
                }
                return;
            }
            if (i3 == getItemCount() - 1) {
                dVar.f8678b.setPositionInGroup(3);
                dVar.f8678b.setPaddingRelative(dVar.f8678b.getPaddingStart(), dVar.f8678b.getPaddingTop(), dVar.f8678b.getPaddingEnd(), this.f8669a.getResources().getDimensionPixelOffset(W1.c.f2620K));
            } else if (dVar.f8678b.getPaddingBottom() == this.f8669a.getResources().getDimensionPixelOffset(W1.c.f2620K)) {
                dVar.f8678b.setPaddingRelative(dVar.f8678b.getPaddingStart(), dVar.f8678b.getPaddingTop(), dVar.f8678b.getPaddingEnd(), 0);
                dVar.f8678b.setPositionInGroup(2);
            } else {
                dVar.f8678b.setPositionInGroup(2);
            }
            dVar.f8678b.setOnClickListener(new a(cVar));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return i3 == 0 ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(W1.e.f2712n, viewGroup, false)) : new d(LayoutInflater.from(viewGroup.getContext()).inflate(W1.e.f2711m, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return this.f8672d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemViewType(int i3) {
            return i3 == 0 ? 0 : 1;
        }

        public void h(List list, String str) {
            this.f8672d.clear();
            if (list != null) {
                this.f8672d.addAll(list);
                this.f8672d.add(0, new c(str));
            }
            notifyDataSetChanged();
        }
    }

    private static class d extends RecyclerView.E {

        /* renamed from: a, reason: collision with root package name */
        private TextView f8677a;

        /* renamed from: b, reason: collision with root package name */
        private COUICardListSelectedItemLayout f8678b;

        class a extends View.AccessibilityDelegate {
            a() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName("android.widget.Button");
            }
        }

        public d(View view) {
            super(view);
            this.f8678b = (COUICardListSelectedItemLayout) view;
            TextView textView = (TextView) view.findViewById(W1.d.f2672N);
            this.f8677a = textView;
            textView.setAccessibilityDelegate(new a());
            this.f8678b.setClickable(true);
        }
    }

    public COUIRecommendedPreference(Context context) {
        this(context, null);
    }

    public void i(List list) {
        if (list == null || list.isEmpty()) {
            setVisible(false);
            return;
        }
        setVisible(true);
        this.f8664e = list;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        RecyclerView recyclerView = (RecyclerView) lVar.itemView;
        RecyclerView.h adapter = recyclerView.getAdapter();
        if (adapter == null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new b(getContext(), this.f8664e, this.f8668i, this.f8665f, this.f8666g));
        } else {
            ((b) adapter).h(this.f8664e, this.f8668i);
        }
        recyclerView.setFocusable(false);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f8675a;

        /* renamed from: b, reason: collision with root package name */
        private a f8676b;

        public c(String str) {
            this.f8675a = str;
        }

        public c(String str, a aVar) {
            this.f8675a = str;
            this.f8676b = aVar;
        }
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2601k);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2716b);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        setLayoutResource(W1.e.f2710l);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2750J0, i3, 0);
        this.f8665f = obtainStyledAttributes.getDimension(W1.h.f2754L0, AbstractC0335a.c(getContext(), M1.c.f1343A));
        this.f8666g = obtainStyledAttributes.getColor(W1.h.f2752K0, AbstractC0335a.a(getContext(), M1.c.f1359d));
        this.f8667h = new k(this.f8665f, this.f8666g);
        String string = obtainStyledAttributes.getString(W1.h.f2756M0);
        this.f8668i = string;
        if (string == null) {
            this.f8668i = getContext().getResources().getString(W1.f.f2713a);
        }
        obtainStyledAttributes.recycle();
    }
}
