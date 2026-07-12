package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.poplist.A;

/* loaded from: classes.dex */
public class COUICheckBoxWithDividerPreference extends CheckBoxPreference implements com.coui.appcompat.preference.b, COUIRecyclerView.b {

    /* renamed from: k, reason: collision with root package name */
    private boolean f8485k;

    /* renamed from: l, reason: collision with root package name */
    private int f8486l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f8487m;

    /* renamed from: n, reason: collision with root package name */
    private int f8488n;

    /* renamed from: o, reason: collision with root package name */
    private LinearLayout f8489o;

    /* renamed from: p, reason: collision with root package name */
    private LinearLayout f8490p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f8491q;

    /* renamed from: r, reason: collision with root package name */
    private View f8492r;

    /* renamed from: s, reason: collision with root package name */
    private A.c f8493s;

    /* renamed from: t, reason: collision with root package name */
    private A f8494t;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUICheckBoxWithDividerPreference.r(COUICheckBoxWithDividerPreference.this);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUICheckBoxWithDividerPreference.super.onClick();
        }
    }

    class c implements A.c {
        c() {
        }

        @Override // com.coui.appcompat.poplist.A.c
        public void a(View view, int i3, int i4) {
            COUICheckBoxWithDividerPreference.this.f8493s.a(view, i3, i4);
            if (COUICheckBoxWithDividerPreference.this.f8489o != null) {
                COUICheckBoxWithDividerPreference.r(COUICheckBoxWithDividerPreference.this);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUICheckBoxWithDividerPreference.r(COUICheckBoxWithDividerPreference.this);
        }
    }

    public interface e {
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2594d);
    }

    static /* synthetic */ e r(COUICheckBoxWithDividerPreference cOUICheckBoxWithDividerPreference) {
        cOUICheckBoxWithDividerPreference.getClass();
        return null;
    }

    private void v() {
        if (this.f8489o == null || this.f8493s == null) {
            return;
        }
        removePreciseClickListener();
        A a3 = new A(this.f8489o, new c());
        this.f8494t = a3;
        a3.d();
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8492r instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.f8486l;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8491q;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8486l;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8485k;
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        LinearLayout linearLayout = (LinearLayout) lVar.itemView.findViewById(W1.d.f2660B);
        this.f8489o = linearLayout;
        View view = lVar.itemView;
        if ((view instanceof COUICardListSelectedItemLayout) && linearLayout != null) {
            ((COUICardListSelectedItemLayout) view).setMainLayoutToSetExtraPadding(linearLayout);
        }
        this.f8492r = lVar.itemView;
        View b3 = lVar.b(R.id.checkbox);
        View b4 = lVar.b(R.id.icon);
        View b5 = lVar.b(W1.d.f2696x);
        if (b5 != null) {
            if (b4 != null) {
                b5.setVisibility(b4.getVisibility());
            } else {
                b5.setVisibility(8);
            }
        }
        if (b3 != null && (b3 instanceof COUICheckBox)) {
            ((COUICheckBox) b3).setState(i() ? 2 : 0);
        }
        this.f8491q = (TextView) lVar.b(R.id.title);
        v();
        LinearLayout linearLayout2 = this.f8489o;
        if (linearLayout2 != null) {
            if (this.f8493s == null) {
                linearLayout2.setOnClickListener(new a());
            }
            this.f8489o.setClickable(isSelectable());
        }
        LinearLayout linearLayout3 = (LinearLayout) lVar.itemView.findViewById(W1.d.f2678f);
        this.f8490p = linearLayout3;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new b());
            this.f8490p.setClickable(isSelectable());
        }
        j.a(lVar, this.f8487m, this.f8488n);
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
    }

    public void removePreciseClickListener() {
        A a3 = this.f8494t;
        if (a3 != null) {
            a3.e();
            this.f8494t = null;
        }
        LinearLayout linearLayout = this.f8489o;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new d());
        }
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2719e);
    }

    public COUICheckBoxWithDividerPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8488n = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2805m, i3, i4);
        this.f8487m = obtainStyledAttributes.getText(W1.h.f2807n);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, i4);
        this.f8485k = obtainStyledAttributes2.getBoolean(W1.h.f2826w0, true);
        this.f8488n = obtainStyledAttributes.getInt(W1.h.f2786c0, 0);
        obtainStyledAttributes2.recycle();
        this.f8486l = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
    }
}
