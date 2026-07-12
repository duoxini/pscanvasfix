package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;

/* loaded from: classes.dex */
public class COUIMarkPreference extends CheckBoxPreference implements b, COUIRecyclerView.b {

    /* renamed from: k, reason: collision with root package name */
    int f8579k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8580l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8581m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8582n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f8583o;

    /* renamed from: p, reason: collision with root package name */
    private int f8584p;

    /* renamed from: q, reason: collision with root package name */
    private int f8585q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8586r;

    /* renamed from: s, reason: collision with root package name */
    private int f8587s;

    /* renamed from: t, reason: collision with root package name */
    private int f8588t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8589u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f8590v;

    /* renamed from: w, reason: collision with root package name */
    private View f8591w;

    class a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8592a;

        a(View view) {
            this.f8592a = view;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, COUIMarkPreference.this.getContext().getResources().getString(M1.k.f1493c)));
            KeyEvent.Callback callback = this.f8592a;
            if ((callback instanceof Checkable) && ((Checkable) callback).isChecked()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            }
        }
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8579k = 0;
        this.f8580l = true;
        this.f8584p = 0;
        this.f8589u = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2757N, i3, i4);
        this.f8579k = obtainStyledAttributes.getInt(W1.h.f2761P, 0);
        this.f8583o = obtainStyledAttributes.getText(W1.h.f2759O);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, i4);
        this.f8580l = obtainStyledAttributes2.getBoolean(W1.h.f2804l0, this.f8580l);
        this.f8581m = obtainStyledAttributes2.getBoolean(W1.h.f2794g0, false);
        this.f8582n = obtainStyledAttributes2.getBoolean(W1.h.f2826w0, true);
        this.f8585q = obtainStyledAttributes2.getInt(W1.h.f2796h0, 1);
        this.f8586r = obtainStyledAttributes2.getBoolean(W1.h.f2820t0, false);
        this.f8587s = obtainStyledAttributes2.getDimensionPixelSize(W1.h.f2828x0, 14);
        this.f8584p = obtainStyledAttributes2.getInt(W1.h.f2786c0, 0);
        obtainStyledAttributes2.recycle();
        this.f8588t = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
        j(true);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8591w instanceof COUICardListSelectedItemLayout)) {
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
        return this.f8588t;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8590v;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8588t;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8582n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        this.f8591w = lVar.itemView;
        View b3 = lVar.b(W1.d.f2690r);
        this.f8591w.setAccessibilityDelegate(new a(b3));
        if (b3 != 0 && (b3 instanceof Checkable)) {
            if (this.f8579k == 0) {
                b3.setVisibility(0);
                ((Checkable) b3).setChecked(i());
            } else {
                b3.setVisibility(8);
            }
        }
        View b4 = lVar.b(W1.d.f2682j);
        if (b4 != 0 && (b4 instanceof Checkable)) {
            if (this.f8579k == 1) {
                b4.setVisibility(0);
                ((Checkable) b4).setChecked(i());
            } else {
                b4.setVisibility(8);
            }
        }
        j.d(lVar, getContext(), this.f8587s, this.f8586r, this.f8585q, this.f8589u);
        this.f8590v = (TextView) lVar.b(R.id.title);
        View b5 = lVar.b(W1.d.f2696x);
        View b6 = lVar.b(R.id.icon);
        if (b5 != null) {
            if (b6 != null) {
                b5.setVisibility(b6.getVisibility());
            } else {
                b5.setVisibility(8);
            }
        }
        if (this.f8581m) {
            j.e(getContext(), lVar);
        }
        j.a(lVar, this.f8583o, this.f8584p);
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2723i);
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2598h);
    }
}
