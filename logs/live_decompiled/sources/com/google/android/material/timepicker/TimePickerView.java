package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.y;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: e, reason: collision with root package name */
    private final Chip f10002e;

    /* renamed from: f, reason: collision with root package name */
    private final Chip f10003f;

    /* renamed from: g, reason: collision with root package name */
    private final ClockHandView f10004g;

    /* renamed from: h, reason: collision with root package name */
    private final ClockFaceView f10005h;

    /* renamed from: i, reason: collision with root package name */
    private final MaterialButtonToggleGroup f10006i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f10007j;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.k(TimePickerView.this);
        }
    }

    class b implements MaterialButtonToggleGroup.d {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z3) {
            TimePickerView.l(TimePickerView.this);
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.p(TimePickerView.this);
            return false;
        }
    }

    class d implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GestureDetector f10011e;

        d(GestureDetector gestureDetector) {
            this.f10011e = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f10011e.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface e {
    }

    interface f {
    }

    interface g {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ g k(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ f l(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ e p(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    private void q() {
        this.f10002e.setTag(H0.e.f556F, 12);
        this.f10003f.setTag(H0.e.f556F, 10);
        this.f10002e.setOnClickListener(this.f10007j);
        this.f10003f.setOnClickListener(this.f10007j);
        this.f10002e.setAccessibilityClassName("android.view.View");
        this.f10003f.setAccessibilityClassName("android.view.View");
    }

    private void r() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.f10002e.setOnTouchListener(dVar);
        this.f10003f.setOnTouchListener(dVar);
    }

    private void s() {
        if (this.f10006i.getVisibility() == 0) {
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            dVar.g(this);
            dVar.e(H0.e.f576i, y.x(this) == 0 ? 2 : 1);
            dVar.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            s();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10007j = new a();
        LayoutInflater.from(context).inflate(H0.g.f610o, this);
        this.f10005h = (ClockFaceView) findViewById(H0.e.f577j);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(H0.e.f579l);
        this.f10006i = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new b());
        this.f10002e = (Chip) findViewById(H0.e.f582o);
        this.f10003f = (Chip) findViewById(H0.e.f580m);
        this.f10004g = (ClockHandView) findViewById(H0.e.f578k);
        r();
        q();
    }
}
