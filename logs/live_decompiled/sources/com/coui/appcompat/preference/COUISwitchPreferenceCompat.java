package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.l;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;

/* loaded from: classes.dex */
public class COUISwitchPreferenceCompat extends SwitchPreferenceCompat implements COUIRecyclerView.b {

    /* renamed from: m, reason: collision with root package name */
    private final b f8730m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8731n;

    /* renamed from: o, reason: collision with root package name */
    private COUISwitch f8732o;

    /* renamed from: p, reason: collision with root package name */
    private View f8733p;

    /* renamed from: q, reason: collision with root package name */
    private int f8734q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f8735r;

    /* renamed from: s, reason: collision with root package name */
    private int f8736s;

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (COUISwitchPreferenceCompat.this.i() == z3) {
                return;
            }
            if (COUISwitchPreferenceCompat.this.u(Boolean.valueOf(z3))) {
                COUISwitchPreferenceCompat.this.j(z3);
            } else {
                compoundButton.setChecked(!z3);
            }
        }
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f6040l);
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
        if (!(this.f8733p instanceof COUICardListSelectedItemLayout)) {
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
        return this.f8734q;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8733p;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8734q;
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.f8733p = lVar.itemView;
        View b3 = lVar.b(W1.d.f2685m);
        if (b3 != null) {
            b3.setSoundEffectsEnabled(false);
        }
        View b4 = lVar.b(W1.d.f2666H);
        boolean z3 = b4 instanceof COUISwitch;
        if (z3) {
            COUISwitch cOUISwitch = (COUISwitch) b4;
            cOUISwitch.setOnCheckedChangeListener(null);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.f8732o = cOUISwitch;
        }
        super.onBindViewHolder(lVar);
        if (z3) {
            ((COUISwitch) b4).setOnCheckedChangeListener(this.f8730m);
        }
        if (this.f8731n) {
            j.e(getContext(), lVar);
        }
        j.a(lVar, this.f8735r, this.f8736s);
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        COUISwitch cOUISwitch = this.f8732o;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
        }
        super.onClick();
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUISwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        this.f8730m = new b();
        this.f8736s = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, 0);
        this.f8731n = obtainStyledAttributes.getBoolean(W1.h.f2794g0, false);
        this.f8735r = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.f8736s = obtainStyledAttributes.getInt(W1.h.f2786c0, 0);
        obtainStyledAttributes.recycle();
        this.f8734q = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
    }
}
