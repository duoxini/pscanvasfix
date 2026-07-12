package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.PreferenceCategory;
import androidx.preference.l;
import androidx.preference.s;
import d0.AbstractC0335a;
import r0.C0560b;
import v0.AbstractC0608a;

/* loaded from: classes.dex */
public class COUIPreferenceCategory extends PreferenceCategory {

    /* renamed from: A, reason: collision with root package name */
    private int f8642A;

    /* renamed from: B, reason: collision with root package name */
    private int f8643B;

    /* renamed from: C, reason: collision with root package name */
    private ArrayMap f8644C;

    /* renamed from: D, reason: collision with root package name */
    private C0560b f8645D;

    /* renamed from: E, reason: collision with root package name */
    private TextView f8646E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f8647F;

    /* renamed from: G, reason: collision with root package name */
    private String f8648G;

    /* renamed from: H, reason: collision with root package name */
    private String f8649H;

    /* renamed from: m, reason: collision with root package name */
    private Context f8650m;

    /* renamed from: n, reason: collision with root package name */
    private int f8651n;

    /* renamed from: o, reason: collision with root package name */
    private View f8652o;

    /* renamed from: p, reason: collision with root package name */
    private View.OnClickListener f8653p;

    /* renamed from: q, reason: collision with root package name */
    private View.OnClickListener f8654q;

    /* renamed from: r, reason: collision with root package name */
    private View.OnClickListener f8655r;

    /* renamed from: s, reason: collision with root package name */
    private String f8656s;

    /* renamed from: t, reason: collision with root package name */
    private int f8657t;

    /* renamed from: u, reason: collision with root package name */
    private int f8658u;

    /* renamed from: v, reason: collision with root package name */
    private String f8659v;

    /* renamed from: w, reason: collision with root package name */
    private int f8660w;

    /* renamed from: x, reason: collision with root package name */
    private int f8661x;

    /* renamed from: y, reason: collision with root package name */
    private int f8662y;

    /* renamed from: z, reason: collision with root package name */
    private int f8663z;

    public COUIPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8660w = 1;
        this.f8642A = 0;
        this.f8643B = 0;
        this.f8646E = null;
        this.f8647F = false;
        this.f8650m = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2832z0, 0, 0);
        this.f8656s = obtainStyledAttributes.getString(W1.h.f2742F0);
        this.f8657t = obtainStyledAttributes.getResourceId(W1.h.f2732A0, 0);
        this.f8658u = obtainStyledAttributes.getResourceId(W1.h.f2736C0, 0);
        this.f8659v = obtainStyledAttributes.getString(W1.h.f2740E0);
        this.f8660w = obtainStyledAttributes.getInteger(W1.h.f2744G0, this.f8660w);
        this.f8642A = obtainStyledAttributes.getInteger(W1.h.f2746H0, this.f8642A);
        this.f8643B = obtainStyledAttributes.getInteger(W1.h.f2748I0, this.f8643B);
        this.f8648G = obtainStyledAttributes.getString(W1.h.f2738D0);
        this.f8649H = obtainStyledAttributes.getString(W1.h.f2734B0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.f6201s0, 0, 0);
        this.f8651n = androidx.core.content.res.i.e(obtainStyledAttributes2, s.f6147c1, s.f6066C0, 0);
        obtainStyledAttributes2.recycle();
        this.f8663z = context.getResources().getDimensionPixelSize(W1.c.f2623N);
        this.f8661x = context.getResources().getDimensionPixelSize(W1.c.f2624O);
        this.f8662y = context.getResources().getDimensionPixelSize(W1.c.f2621L);
        ArrayMap arrayMap = new ArrayMap();
        this.f8644C = arrayMap;
        arrayMap.put(Integer.valueOf(W1.e.f2702d), 0);
        this.f8644C.put(Integer.valueOf(W1.e.f2703e), 0);
        this.f8644C.put(Integer.valueOf(W1.e.f2704f), Integer.valueOf(context.getResources().getDimensionPixelSize(W1.c.f2651s)));
        this.f8644C.put(Integer.valueOf(W1.e.f2705g), Integer.valueOf(context.getResources().getDimensionPixelSize(W1.c.f2658z)));
        this.f8644C.put(Integer.valueOf(W1.e.f2706h), 0);
        w();
    }

    private void w() {
        if (this.f8645D == null) {
            C0560b c0560b = new C0560b(getContext());
            this.f8645D = c0560b;
            c0560b.v(getContext().getResources().getDimensionPixelSize(W1.c.f2615F));
        }
    }

    private void y(l lVar) {
        TextView textView;
        TextView textView2;
        int i3;
        int i4;
        View b3 = lVar.b(R.id.widget_frame);
        if (this.f8651n != 0) {
            if (!(b3 instanceof LinearLayout)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) b3;
            if (linearLayout != null && linearLayout.getChildCount() > 0) {
                linearLayout.removeAllViews();
            }
            View inflate = LayoutInflater.from(this.f8650m).inflate(this.f8651n, (ViewGroup) linearLayout, false);
            this.f8652o = inflate;
            if (inflate == null) {
                Log.e("COUIPreferenceCategory", "inflate mWidgetLayoutRes failed");
                return;
            }
            this.f8647F = false;
            if (inflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8652o.getLayoutParams();
                if (this.f8660w == 0) {
                    if (marginLayoutParams.getMarginEnd() != ((Integer) this.f8644C.get(Integer.valueOf(this.f8651n))).intValue()) {
                        marginLayoutParams.setMarginEnd(((Integer) this.f8644C.get(Integer.valueOf(this.f8651n))).intValue());
                        this.f8652o.setLayoutParams(marginLayoutParams);
                    }
                } else if (marginLayoutParams.getMarginEnd() != ((Integer) this.f8644C.get(Integer.valueOf(this.f8651n))).intValue() + this.f8662y) {
                    marginLayoutParams.setMarginEnd(((Integer) this.f8644C.get(Integer.valueOf(this.f8651n))).intValue() + this.f8662y);
                    this.f8652o.setLayoutParams(marginLayoutParams);
                }
            }
            if (!(this.f8652o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f8652o.getLayoutParams();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginLayoutParams2.width, marginLayoutParams2.height);
            layoutParams.gravity = 16;
            layoutParams.setMarginStart(marginLayoutParams2.getMarginStart());
            layoutParams.topMargin = marginLayoutParams2.topMargin;
            layoutParams.setMarginEnd(marginLayoutParams2.getMarginEnd());
            layoutParams.bottomMargin = marginLayoutParams2.bottomMargin;
            linearLayout.addView(this.f8652o, layoutParams);
            linearLayout.setVisibility(0);
            if (this.f8653p != null) {
                if (this.f8651n == W1.e.f2704f) {
                    w();
                    linearLayout.getChildAt(0).setBackground(this.f8645D);
                } else {
                    AbstractC0608a.a(this.f8652o, false);
                }
                this.f8652o.setOnClickListener(this.f8653p);
            } else {
                View.OnClickListener onClickListener = this.f8654q;
                if (onClickListener != null) {
                    lVar.itemView.setOnClickListener(onClickListener);
                    l0.c.b(lVar.itemView, 0, false);
                }
            }
            int i5 = this.f8651n;
            if (i5 == W1.e.f2706h) {
                textView2 = (TextView) linearLayout.findViewById(W1.d.f2669K);
                if (textView2 != null && !TextUtils.isEmpty(this.f8656s)) {
                    textView2.setText(this.f8656s);
                    textView2.setVisibility(0);
                }
                if (this.f8653p == null || A()) {
                    textView2.setTextColor(AbstractC0335a.b(getContext(), M1.c.f1377v, 0));
                } else {
                    textView2.setTextColor(AbstractC0335a.b(getContext(), M1.c.f1375t, 0));
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(W1.d.f2694v);
                if (imageView != null && (i4 = this.f8657t) != 0) {
                    imageView.setImageResource(i4);
                    imageView.setVisibility(0);
                }
            } else if (i5 == W1.e.f2705g) {
                textView2 = (TextView) linearLayout.findViewById(W1.d.f2668J);
                if (textView2 != null && !TextUtils.isEmpty(this.f8656s)) {
                    textView2.setText(this.f8656s);
                    textView2.setVisibility(0);
                    AbstractC0608a.b(textView2);
                }
            } else {
                if (i5 == W1.e.f2704f) {
                    ImageView imageView2 = (ImageView) linearLayout.findViewById(W1.d.f2664F);
                    if (imageView2 != null && (i3 = this.f8657t) != 0) {
                        imageView2.setImageResource(i3);
                        imageView2.setVisibility(0);
                        if (!TextUtils.isEmpty(this.f8649H)) {
                            imageView2.setContentDescription(this.f8649H);
                        }
                    }
                } else if (i5 == W1.e.f2703e) {
                    textView2 = (TextView) this.f8652o.findViewById(W1.d.f2670L);
                }
                textView2 = null;
            }
            if (textView2 != null) {
                if (this.f8642A == 0) {
                    textView2.setTextSize(2, 12.0f);
                } else {
                    textView2.setTextSize(2, 14.0f);
                    linearLayout.getChildAt(0).setMinimumHeight(getContext().getResources().getDimensionPixelSize(W1.c.f2614E));
                }
            }
        } else if (b3 != null) {
            b3.setVisibility(8);
        }
        if (this.f8647F && (textView = this.f8646E) != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f8646E.getLayoutParams();
            marginLayoutParams3.setMarginEnd(marginLayoutParams3.getMarginStart());
            this.f8646E.setLayoutParams(marginLayoutParams3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z(androidx.preference.l r10) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.COUIPreferenceCategory.z(androidx.preference.l):void");
    }

    protected boolean A() {
        return false;
    }

    protected void B(int i3) {
        this.f8651n = i3;
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        z(lVar);
        y(lVar);
    }

    protected View x() {
        return this.f8652o;
    }
}
