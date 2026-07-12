package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.l;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.poplist.A;

/* loaded from: classes.dex */
public class COUISwitchWithDividerPreference extends COUISwitchPreference {

    /* renamed from: E, reason: collision with root package name */
    private LinearLayout f8738E;

    /* renamed from: F, reason: collision with root package name */
    private LinearLayout f8739F;

    /* renamed from: G, reason: collision with root package name */
    private A.c f8740G;

    /* renamed from: H, reason: collision with root package name */
    private A f8741H;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUISwitchWithDividerPreference.x(COUISwitchWithDividerPreference.this);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUISwitchWithDividerPreference.super.onClick();
        }
    }

    class c implements A.c {
        c() {
        }

        @Override // com.coui.appcompat.poplist.A.c
        public void a(View view, int i3, int i4) {
            COUISwitchWithDividerPreference.this.f8740G.a(view, i3, i4);
            if (COUISwitchWithDividerPreference.this.f8738E != null) {
                COUISwitchWithDividerPreference.x(COUISwitchWithDividerPreference.this);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUISwitchWithDividerPreference.x(COUISwitchWithDividerPreference.this);
        }
    }

    public interface e {
    }

    public COUISwitchWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2607q);
    }

    private void B() {
        if (this.f8738E == null || this.f8740G == null) {
            return;
        }
        removePreciseClickListener();
        A a3 = new A(this.f8738E, new c());
        this.f8741H = a3;
        a3.d();
    }

    static /* synthetic */ e x(COUISwitchWithDividerPreference cOUISwitchWithDividerPreference) {
        cOUISwitchWithDividerPreference.getClass();
        return null;
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        LinearLayout linearLayout = (LinearLayout) lVar.itemView.findViewById(W1.d.f2660B);
        this.f8738E = linearLayout;
        View view = lVar.itemView;
        if ((view instanceof COUICardListSelectedItemLayout) && linearLayout != null) {
            ((COUICardListSelectedItemLayout) view).setMainLayoutToSetExtraPadding(linearLayout);
        }
        super.onBindViewHolder(lVar);
        B();
        LinearLayout linearLayout2 = this.f8738E;
        if (linearLayout2 != null) {
            if (this.f8740G == null) {
                linearLayout2.setOnClickListener(new a());
            }
            this.f8738E.setClickable(isSelectable());
        }
        LinearLayout linearLayout3 = (LinearLayout) lVar.itemView.findViewById(W1.d.f2667I);
        this.f8739F = linearLayout3;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new b());
            this.f8739F.setClickable(isSelectable());
        }
    }

    public void removePreciseClickListener() {
        A a3 = this.f8741H;
        if (a3 != null) {
            a3.e();
            this.f8741H = null;
        }
        LinearLayout linearLayout = this.f8738E;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new d());
        }
    }

    public COUISwitchWithDividerPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2728n);
    }

    public COUISwitchWithDividerPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }
}
