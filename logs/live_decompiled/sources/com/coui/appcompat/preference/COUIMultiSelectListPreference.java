package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class COUIMultiSelectListPreference extends MultiSelectListPreference implements b, COUIRecyclerView.b {

    /* renamed from: A, reason: collision with root package name */
    private EnumC0643a f8624A;

    /* renamed from: n, reason: collision with root package name */
    Context f8625n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence f8626o;

    /* renamed from: p, reason: collision with root package name */
    Drawable f8627p;

    /* renamed from: q, reason: collision with root package name */
    private int f8628q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f8629r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence[] f8630s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8631t;

    /* renamed from: u, reason: collision with root package name */
    private Point f8632u;

    /* renamed from: v, reason: collision with root package name */
    private View f8633v;

    /* renamed from: w, reason: collision with root package name */
    private View f8634w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f8635x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f8636y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f8637z;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0) {
                return false;
            }
            COUIMultiSelectListPreference.this.f8632u.set((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
    }

    public COUIMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8632u = new Point();
        this.f8636y = true;
        this.f8637z = false;
        this.f8625n = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, 0, W1.g.f2729o);
        this.f8631t = obtainStyledAttributes.getBoolean(W1.h.f2826w0, true);
        this.f8629r = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.f8627p = obtainStyledAttributes.getDrawable(W1.h.f2812p0);
        this.f8626o = obtainStyledAttributes.getText(W1.h.f2814q0);
        this.f8636y = obtainStyledAttributes.getBoolean(W1.h.f2798i0, true);
        this.f8637z = obtainStyledAttributes.getBoolean(W1.h.f2792f0, false);
        this.f8624A = EnumC0643a.b(obtainStyledAttributes.getInt(W1.h.f2788d0, y0.j.f14497a.a()));
        obtainStyledAttributes.recycle();
        this.f8628q = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8634w instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    public CharSequence getAssignment() {
        return this.f8629r;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.f8628q;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8635x;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8628q;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8631t;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        this.f8634w = lVar.itemView;
        j.b(lVar, this.f8627p, this.f8626o, getAssignment());
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
        this.f8635x = (TextView) lVar.b(R.id.title);
        View view = lVar.itemView;
        this.f8633v = view;
        view.setOnTouchListener(new a());
    }

    public EnumC0643a t() {
        return this.f8624A;
    }

    public Point u() {
        return this.f8632u;
    }

    public View v() {
        return this.f8633v;
    }

    CharSequence[] w() {
        return this.f8630s;
    }

    public boolean x() {
        return this.f8637z;
    }

    public boolean y() {
        return this.f8636y;
    }
}
