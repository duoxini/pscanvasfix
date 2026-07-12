package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.couiswitch.COUISwitch;

/* loaded from: classes.dex */
public class COUISwitchLoadingPreference extends SwitchPreferenceCompat implements com.coui.appcompat.preference.b, COUIRecyclerView.b {

    /* renamed from: m, reason: collision with root package name */
    View f8700m;

    /* renamed from: n, reason: collision with root package name */
    private int f8701n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f8702o;

    /* renamed from: p, reason: collision with root package name */
    private View f8703p;

    /* renamed from: q, reason: collision with root package name */
    private COUISwitch f8704q;

    /* renamed from: r, reason: collision with root package name */
    private final b f8705r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8706s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8707t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f8708u;

    /* renamed from: v, reason: collision with root package name */
    private int f8709v;

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (COUISwitchLoadingPreference.this.u(Boolean.valueOf(z3))) {
                COUISwitchLoadingPreference.this.j(z3);
            } else {
                compoundButton.setChecked(!z3);
            }
        }
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2606p);
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
        if (!(this.f8703p instanceof COUICardListSelectedItemLayout)) {
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
        return this.f8701n;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8702o;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8701n;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8707t;
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.f8703p = lVar.itemView;
        View b3 = lVar.b(W1.d.f2685m);
        if (b3 != null) {
            b3.setSoundEffectsEnabled(false);
            b3.setHapticFeedbackEnabled(false);
        }
        View b4 = lVar.b(W1.d.f2666H);
        this.f8700m = b4;
        if (b4 instanceof COUISwitch) {
            COUISwitch cOUISwitch = (COUISwitch) b4;
            cOUISwitch.setOnCheckedChangeListener(null);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.f8704q = cOUISwitch;
        }
        super.onBindViewHolder(lVar);
        View view = this.f8700m;
        if (view instanceof COUISwitch) {
            COUISwitch cOUISwitch2 = (COUISwitch) view;
            cOUISwitch2.setLoadingStyle(true);
            cOUISwitch2.setOnLoadingStateChangedListener(null);
            cOUISwitch2.setOnCheckedChangeListener(this.f8705r);
        }
        if (this.f8706s) {
            j.e(getContext(), lVar);
        }
        this.f8702o = (TextView) lVar.b(R.id.title);
        View findViewById = lVar.itemView.findViewById(R.id.icon);
        View b5 = lVar.b(W1.d.f2696x);
        if (b5 != null) {
            if (findViewById != null) {
                b5.setVisibility(findViewById.getVisibility());
            } else {
                b5.setVisibility(8);
            }
        }
        j.a(lVar, this.f8708u, this.f8709v);
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        COUISwitch cOUISwitch = this.f8704q;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
            this.f8704q.setTactileFeedbackEnabled(true);
            this.f8704q.Y();
        }
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2730p);
    }

    public COUISwitchLoadingPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8705r = new b();
        this.f8709v = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, 0);
        this.f8706s = obtainStyledAttributes.getBoolean(W1.h.f2794g0, false);
        this.f8707t = obtainStyledAttributes.getBoolean(W1.h.f2826w0, true);
        this.f8708u = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.f8709v = obtainStyledAttributes.getInt(W1.h.f2786c0, 0);
        obtainStyledAttributes.recycle();
        this.f8701n = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
    }
}
