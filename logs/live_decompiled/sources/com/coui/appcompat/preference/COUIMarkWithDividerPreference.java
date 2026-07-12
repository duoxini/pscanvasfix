package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.l;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.poplist.A;

/* loaded from: classes.dex */
public class COUIMarkWithDividerPreference extends COUIMarkPreference {

    /* renamed from: A, reason: collision with root package name */
    private A f8594A;

    /* renamed from: x, reason: collision with root package name */
    private LinearLayout f8595x;

    /* renamed from: y, reason: collision with root package name */
    private LinearLayout f8596y;

    /* renamed from: z, reason: collision with root package name */
    private A.c f8597z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUIMarkWithDividerPreference.r(COUIMarkWithDividerPreference.this);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUIMarkWithDividerPreference.super.onClick();
        }
    }

    class c implements A.c {
        c() {
        }

        @Override // com.coui.appcompat.poplist.A.c
        public void a(View view, int i3, int i4) {
            COUIMarkWithDividerPreference.this.f8597z.a(view, i3, i4);
            if (COUIMarkWithDividerPreference.this.f8595x != null) {
                COUIMarkWithDividerPreference.r(COUIMarkWithDividerPreference.this);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUIMarkWithDividerPreference.r(COUIMarkWithDividerPreference.this);
        }
    }

    public interface e {
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    static /* synthetic */ e r(COUIMarkWithDividerPreference cOUIMarkWithDividerPreference) {
        cOUIMarkWithDividerPreference.getClass();
        return null;
    }

    private void v() {
        if (this.f8595x == null || this.f8597z == null) {
            return;
        }
        removePreciseClickListener();
        A a3 = new A(this.f8595x, new c());
        this.f8594A = a3;
        a3.d();
    }

    @Override // com.coui.appcompat.preference.COUIMarkPreference, androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        LinearLayout linearLayout = (LinearLayout) lVar.itemView.findViewById(W1.d.f2660B);
        this.f8595x = linearLayout;
        View view = lVar.itemView;
        if ((view instanceof COUICardListSelectedItemLayout) && linearLayout != null) {
            ((COUICardListSelectedItemLayout) view).setMainLayoutToSetExtraPadding(linearLayout);
        }
        super.onBindViewHolder(lVar);
        v();
        LinearLayout linearLayout2 = this.f8595x;
        if (linearLayout2 != null) {
            if (this.f8597z == null) {
                linearLayout2.setOnClickListener(new a());
            }
            this.f8595x.setClickable(isSelectable());
        }
        LinearLayout linearLayout3 = (LinearLayout) lVar.itemView.findViewById(W1.d.f2662D);
        this.f8596y = linearLayout3;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new b());
            this.f8596y.setClickable(isSelectable());
        }
    }

    public void removePreciseClickListener() {
        A a3 = this.f8594A;
        if (a3 != null) {
            a3.e();
            this.f8594A = null;
        }
        LinearLayout linearLayout = this.f8595x;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new d());
        }
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2724j);
    }

    public COUIMarkWithDividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2600j);
    }
}
