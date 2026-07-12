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
import androidx.preference.ListPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import y0.EnumC0643a;

/* loaded from: classes.dex */
public class COUIListPreference extends ListPreference implements b, COUIRecyclerView.b {

    /* renamed from: A, reason: collision with root package name */
    private boolean f8539A;

    /* renamed from: B, reason: collision with root package name */
    private EnumC0643a f8540B;

    /* renamed from: p, reason: collision with root package name */
    CharSequence f8541p;

    /* renamed from: q, reason: collision with root package name */
    Drawable f8542q;

    /* renamed from: r, reason: collision with root package name */
    CharSequence[] f8543r;

    /* renamed from: s, reason: collision with root package name */
    private int f8544s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f8545t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8546u;

    /* renamed from: v, reason: collision with root package name */
    private Point f8547v;

    /* renamed from: w, reason: collision with root package name */
    private View f8548w;

    /* renamed from: x, reason: collision with root package name */
    private View f8549x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f8550y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f8551z;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0) {
                return false;
            }
            COUIListPreference.this.f8547v.set((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
    }

    public COUIListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2729o);
    }

    public boolean A() {
        return this.f8539A;
    }

    public boolean B() {
        return this.f8551z;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8549x instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    public CharSequence getAssignment() {
        return this.f8545t;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.f8544s;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8550y;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8544s;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.f8546u;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        this.f8549x = lVar.itemView;
        j.b(lVar, this.f8542q, this.f8541p, getAssignment());
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
        this.f8550y = (TextView) lVar.b(R.id.title);
        View view = lVar.itemView;
        this.f8548w = view;
        view.setOnTouchListener(new a());
    }

    public EnumC0643a w() {
        return this.f8540B;
    }

    public Point x() {
        return this.f8547v;
    }

    public View y() {
        return this.f8548w;
    }

    public CharSequence[] z() {
        return this.f8543r;
    }

    public COUIListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet);
        this.f8547v = new Point();
        this.f8551z = true;
        this.f8539A = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, i4);
        this.f8546u = obtainStyledAttributes.getBoolean(W1.h.f2826w0, true);
        this.f8545t = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.f8542q = obtainStyledAttributes.getDrawable(W1.h.f2812p0);
        this.f8541p = obtainStyledAttributes.getText(W1.h.f2814q0);
        this.f8551z = obtainStyledAttributes.getBoolean(W1.h.f2798i0, true);
        this.f8539A = obtainStyledAttributes.getBoolean(W1.h.f2792f0, false);
        this.f8540B = EnumC0643a.b(obtainStyledAttributes.getInt(W1.h.f2788d0, y0.j.f14497a.a()));
        obtainStyledAttributes.recycle();
        this.f8544s = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
    }

    public COUIListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
