package com.coui.appcompat.poplist;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    private View f8102a;

    /* renamed from: b, reason: collision with root package name */
    private c f8103b;

    /* renamed from: c, reason: collision with root package name */
    private float[] f8104c = new float[2];

    /* renamed from: d, reason: collision with root package name */
    private View.OnTouchListener f8105d = new a();

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f8106e = new b();

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                A.this.f8104c[0] = motionEvent.getX();
                A.this.f8104c[1] = motionEvent.getY();
            }
            return false;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (X.a.c(view.getContext()) || (A.this.f8104c[0] == 0.0f && A.this.f8104c[1] == 0.0f)) {
                A.this.f8103b.a(view, view.getWidth() / 2, view.getHeight() / 2);
                return;
            }
            A.this.f8103b.a(view, Math.round(A.this.f8104c[0]), Math.round(A.this.f8104c[1]));
        }
    }

    public interface c {
        void a(View view, int i3, int i4);
    }

    public A(View view, c cVar) {
        this.f8102a = view;
        this.f8103b = cVar;
    }

    View c() {
        return this.f8102a;
    }

    public void d() {
        this.f8102a.setOnTouchListener(this.f8105d);
        this.f8102a.setOnClickListener(this.f8106e);
    }

    public void e() {
        this.f8102a.setOnClickListener(null);
        this.f8102a.setOnTouchListener(null);
    }
}
