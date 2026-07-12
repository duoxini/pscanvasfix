package com.coui.appcompat.stepper;

import M1.c;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.stepper.COUIStepperView;
import d0.AbstractC0335a;
import e2.AbstractC0345a;
import e2.AbstractC0346b;
import e2.AbstractC0347c;
import e2.f;
import java.util.Observable;
import java.util.Observer;
import r0.C0559a;
import r0.C0561c;
import r0.C0562d;
import t0.d;
import t0.e;

/* loaded from: classes.dex */
public class COUIStepperView extends ConstraintLayout implements Observer {

    /* renamed from: e, reason: collision with root package name */
    private final String f9232e;

    /* renamed from: f, reason: collision with root package name */
    private Context f9233f;

    /* renamed from: g, reason: collision with root package name */
    private d f9234g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f9235h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f9236i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f9237j;

    /* renamed from: k, reason: collision with root package name */
    private e f9238k;

    /* renamed from: l, reason: collision with root package name */
    private int f9239l;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f9240m;

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f9241n;

    /* renamed from: o, reason: collision with root package name */
    private b f9242o;

    /* renamed from: p, reason: collision with root package name */
    private b f9243p;

    /* renamed from: q, reason: collision with root package name */
    private int f9244q;

    public COUIStepperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0345a.f11469a);
    }

    private int getNumForMaxWidth() {
        int i3 = 1;
        float f3 = 0.0f;
        for (int i4 = 0; i4 < 10; i4++) {
            float measureText = this.f9237j.getPaint().measureText(String.valueOf(i4));
            if (measureText > f3) {
                i3 = i4;
                f3 = measureText;
            }
        }
        return i3;
    }

    private void q() {
        r(this.f9236i, this.f9243p);
        r(this.f9235h, this.f9242o);
    }

    private void r(ImageView imageView, b bVar) {
        float dimension = getContext().getResources().getDimension(AbstractC0346b.f11470a);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        RectF rectF = new RectF(0.0f, 0.0f, dimension, dimension);
        shapeDrawable.getPaint().setColor(AbstractC0335a.a(getContext(), c.f1373r));
        int i3 = (int) dimension;
        shapeDrawable.setBounds(0, 0, i3, i3);
        C0559a c0559a = new C0559a(getContext(), 0);
        float f3 = dimension / 2.0f;
        c0559a.D(rectF, f3, f3);
        C0562d c0562d = new C0562d(getContext());
        c0562d.w(rectF, f3, f3);
        final C0561c c0561c = new C0561c(new Drawable[]{shapeDrawable, c0559a, c0562d});
        c0561c.c(imageView, 2);
        imageView.setBackground(c0561c);
        bVar.h(new View.OnTouchListener() { // from class: t0.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean u3;
                u3 = COUIStepperView.u(C0561c.this, view, motionEvent);
                return u3;
            }
        });
    }

    private void t(TypedArray typedArray) {
        try {
            int resourceId = typedArray.getResourceId(f.f11482g, 0);
            int resourceId2 = typedArray.getResourceId(f.f11481f, 0);
            int resourceId3 = typedArray.getResourceId(f.f11480e, 0);
            if (resourceId != 0) {
                this.f9237j.setTextAppearance(resourceId);
            }
            if (resourceId2 != 0) {
                this.f9235h.setImageDrawable(androidx.core.content.a.e(getContext(), resourceId2));
            }
            if (resourceId3 != 0) {
                this.f9236i.setImageDrawable(androidx.core.content.a.e(getContext(), resourceId3));
            }
            q();
        } catch (Resources.NotFoundException e3) {
            Log.e("COUIStepperView", e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean u(C0561c c0561c, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            c0561c.g(true);
        }
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            c0561c.g(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        performHapticFeedback(308, 0);
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        performHapticFeedback(308, 0);
        x();
    }

    public int getCurStep() {
        return this.f9234g.c();
    }

    public int getMaximum() {
        return this.f9234g.a();
    }

    public int getMinimum() {
        return this.f9234g.b();
    }

    public int getUnit() {
        return this.f9239l;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int numForMaxWidth = getNumForMaxWidth();
        String[] split = String.valueOf(getMaximum()).split("");
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < split.length; i5++) {
            sb.append(numForMaxWidth);
        }
        this.f9237j.setWidth(Math.round(this.f9237j.getPaint().measureText(sb.toString())));
        super.onMeasure(i3, i4);
    }

    protected void s(AttributeSet attributeSet, int i3) {
        this.f9244q = e2.e.f11475a;
        LayoutInflater.from(getContext()).inflate(e2.d.f11474a, this);
        this.f9235h = (ImageView) findViewById(AbstractC0347c.f11473c);
        this.f9236i = (ImageView) findViewById(AbstractC0347c.f11472b);
        this.f9237j = (TextView) findViewById(AbstractC0347c.f11471a);
        this.f9242o = new b(this.f9235h, this.f9240m);
        this.f9243p = new b(this.f9236i, this.f9241n);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.f11476a, i3, e2.e.f11475a);
        int i4 = obtainStyledAttributes.getInt(f.f11478c, 9999);
        int i5 = obtainStyledAttributes.getInt(f.f11479d, -999);
        int i6 = obtainStyledAttributes.getInt(f.f11477b, 0);
        this.f9239l = obtainStyledAttributes.getInt(f.f11483h, 1);
        t(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        d dVar = new d();
        this.f9234g = dVar;
        dVar.addObserver(this);
        setMaximum(i4);
        setMinimum(i5);
        setCurStep(i6);
    }

    public void setCurStep(int i3) {
        this.f9234g.f(i3);
    }

    public void setMaximum(int i3) {
        this.f9234g.d(i3);
    }

    public void setMinimum(int i3) {
        this.f9234g.e(i3);
    }

    public void setOnStepChangeListener(e eVar) {
        this.f9238k = eVar;
    }

    public void setUnit(int i3) {
        this.f9239l = i3;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int c3 = ((d) observable).c();
        int intValue = ((Integer) obj).intValue();
        boolean z3 = false;
        this.f9235h.setEnabled(c3 < getMaximum() && isEnabled());
        ImageView imageView = this.f9236i;
        if (c3 > getMinimum() && isEnabled()) {
            z3 = true;
        }
        imageView.setEnabled(z3);
        this.f9237j.setText(String.valueOf(c3));
        e eVar = this.f9238k;
        if (eVar != null) {
            eVar.a(c3, intValue);
        }
    }

    public void x() {
        d dVar = this.f9234g;
        dVar.f(dVar.c() - getUnit());
    }

    public void y() {
        d dVar = this.f9234g;
        dVar.f(dVar.c() + getUnit());
    }

    public void z() {
        this.f9242o.g();
        this.f9243p.g();
        this.f9234g.deleteObservers();
        this.f9238k = null;
    }

    public COUIStepperView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9232e = "COUIStepperView";
        this.f9240m = new Runnable() { // from class: t0.a
            @Override // java.lang.Runnable
            public final void run() {
                COUIStepperView.this.v();
            }
        };
        this.f9241n = new Runnable() { // from class: t0.b
            @Override // java.lang.Runnable
            public final void run() {
                COUIStepperView.this.w();
            }
        };
        this.f9233f = context;
        s(attributeSet, i3);
    }
}
