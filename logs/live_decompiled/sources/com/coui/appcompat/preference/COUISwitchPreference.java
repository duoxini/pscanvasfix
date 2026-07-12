package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.SwitchPreference;
import androidx.preference.l;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.coui.appcompat.reddot.COUIHintRedDot;

/* loaded from: classes.dex */
public class COUISwitchPreference extends SwitchPreference implements com.coui.appcompat.preference.b, COUIRecyclerView.b {

    /* renamed from: A, reason: collision with root package name */
    private boolean f8711A;

    /* renamed from: B, reason: collision with root package name */
    private int f8712B;

    /* renamed from: C, reason: collision with root package name */
    private TextView f8713C;

    /* renamed from: D, reason: collision with root package name */
    private View f8714D;

    /* renamed from: m, reason: collision with root package name */
    private final b f8715m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8716n;

    /* renamed from: o, reason: collision with root package name */
    private COUISwitch f8717o;

    /* renamed from: p, reason: collision with root package name */
    private int f8718p;

    /* renamed from: q, reason: collision with root package name */
    private int f8719q;

    /* renamed from: r, reason: collision with root package name */
    private int f8720r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f8721s;

    /* renamed from: t, reason: collision with root package name */
    private int f8722t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8723u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f8724v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f8725w;

    /* renamed from: x, reason: collision with root package name */
    private int f8726x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f8727y;

    /* renamed from: z, reason: collision with root package name */
    private int f8728z;

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (COUISwitchPreference.this.i() == z3) {
                return;
            }
            if (COUISwitchPreference.this.u(Boolean.valueOf(z3))) {
                COUISwitchPreference.this.j(z3);
            } else {
                compoundButton.setChecked(!z3);
            }
        }
    }

    public COUISwitchPreference(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(Object obj) {
        if (getOnPreferenceChangeListener() == null) {
            return true;
        }
        return getOnPreferenceChangeListener().a(this, obj);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8714D instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.f8720r;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8713C;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8720r;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8725w;
    }

    @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.f8714D = lVar.itemView;
        View b3 = lVar.b(W1.d.f2685m);
        if (b3 != null) {
            b3.setSoundEffectsEnabled(false);
            b3.setHapticFeedbackEnabled(false);
        }
        View b4 = lVar.b(R.id.switch_widget);
        View b5 = lVar.b(W1.d.f2659A);
        if (b4 instanceof COUISwitch) {
            COUISwitch cOUISwitch = (COUISwitch) b4;
            cOUISwitch.setOnCheckedChangeListener(this.f8715m);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.f8717o = cOUISwitch;
            int i3 = this.f8712B;
            if (i3 != -1) {
                cOUISwitch.setBarCheckedColor(i3);
            }
        }
        super.onBindViewHolder(lVar);
        if (this.f8716n) {
            j.e(getContext(), lVar);
        }
        j.d(lVar, getContext(), this.f8728z, this.f8727y, this.f8726x, this.f8711A);
        View b6 = lVar.b(W1.d.f2696x);
        View findViewById = lVar.itemView.findViewById(R.id.icon);
        if (b6 != null) {
            if (findViewById != null) {
                b6.setVisibility(findViewById.getVisibility());
            } else {
                b6.setVisibility(8);
            }
        }
        TextView textView = (TextView) lVar.b(R.id.title);
        this.f8713C = textView;
        textView.setText(this.f8724v);
        if (b5 != null) {
            if (this.f8723u) {
                COUIHintRedDot cOUIHintRedDot = (COUIHintRedDot) b5;
                cOUIHintRedDot.p();
                b5.setVisibility(0);
                cOUIHintRedDot.setPointMode(1);
            } else {
                b5.setVisibility(8);
            }
            b5.invalidate();
        }
        j.a(lVar, this.f8721s, this.f8722t);
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected void onClick() {
        w(true);
        v(true);
        super.onClick();
    }

    public void setIsEnableClickSpan(boolean z3) {
        this.f8716n = z3;
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f8724v = getTitle();
    }

    public void v(boolean z3) {
        COUISwitch cOUISwitch = this.f8717o;
        if (cOUISwitch != null) {
            cOUISwitch.setTactileFeedbackEnabled(z3);
        }
    }

    public void w(boolean z3) {
        COUISwitch cOUISwitch = this.f8717o;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(z3);
        }
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f6041m);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8715m = new b();
        this.f8722t = 0;
        this.f8711A = false;
        this.f8712B = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, i4);
        this.f8716n = obtainStyledAttributes.getBoolean(W1.h.f2794g0, false);
        this.f8721s = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.f8722t = obtainStyledAttributes.getInt(W1.h.f2786c0, 0);
        this.f8725w = obtainStyledAttributes.getBoolean(W1.h.f2826w0, true);
        this.f8726x = obtainStyledAttributes.getInt(W1.h.f2796h0, 1);
        this.f8727y = obtainStyledAttributes.getBoolean(W1.h.f2820t0, false);
        this.f8728z = obtainStyledAttributes.getDimensionPixelSize(W1.h.f2828x0, 14);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, W1.h.f2772U0, i3, i4);
        this.f8723u = obtainStyledAttributes2.getBoolean(W1.h.f2774V0, false);
        obtainStyledAttributes2.recycle();
        this.f8720r = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
        this.f8724v = getTitle();
        this.f8718p = context.getResources().getDimensionPixelOffset(Z1.b.f3108a);
        this.f8719q = context.getResources().getDimensionPixelOffset(Z1.b.f3113f);
    }
}
