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
import androidx.preference.EditTextPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class COUIEditTextPreference extends EditTextPreference implements b, COUIRecyclerView.b {

    /* renamed from: l, reason: collision with root package name */
    private int f8515l;

    /* renamed from: m, reason: collision with root package name */
    private Context f8516m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f8517n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f8518o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f8519p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8520q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8521r;

    /* renamed from: s, reason: collision with root package name */
    private Point f8522s;

    /* renamed from: t, reason: collision with root package name */
    private View f8523t;

    /* renamed from: u, reason: collision with root package name */
    private View f8524u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f8525v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f8526w;

    /* renamed from: x, reason: collision with root package name */
    private EnumC0643a f8527x;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0) {
                return false;
            }
            COUIEditTextPreference.this.f8522s.set((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
    }

    public COUIEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8522s = new Point();
        this.f8526w = false;
        this.f8516m = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, 0, W1.g.f2729o);
        this.f8519p = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.f8518o = obtainStyledAttributes.getDrawable(W1.h.f2812p0);
        this.f8517n = obtainStyledAttributes.getText(W1.h.f2814q0);
        this.f8521r = obtainStyledAttributes.getBoolean(W1.h.f2826w0, true);
        this.f8526w = obtainStyledAttributes.getBoolean(W1.h.f2792f0, false);
        this.f8527x = EnumC0643a.b(obtainStyledAttributes.getInt(W1.h.f2788d0, y0.j.f14497a.a()));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, W1.h.f2776W0, 0, 0);
        this.f8520q = obtainStyledAttributes2.getBoolean(W1.h.f2778X0, false);
        obtainStyledAttributes2.recycle();
        this.f8515l = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8524u instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    public CharSequence getAssignment() {
        return this.f8519p;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.f8515l;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8525v;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8515l;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8521r;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        this.f8524u = lVar.itemView;
        j.b(lVar, this.f8518o, this.f8517n, getAssignment());
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
        this.f8525v = (TextView) lVar.b(R.id.title);
        View view = lVar.itemView;
        this.f8523t = view;
        view.setOnTouchListener(new a());
    }

    public EnumC0643a s() {
        return this.f8527x;
    }

    public boolean t() {
        return this.f8526w;
    }

    public boolean u() {
        return this.f8520q;
    }
}
