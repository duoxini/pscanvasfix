package com.coui.appcompat.stepper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.C0255d;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private View f9246a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f9247b;

    /* renamed from: c, reason: collision with root package name */
    private C0255d f9248c;

    /* renamed from: f, reason: collision with root package name */
    private View.OnTouchListener f9251f;

    /* renamed from: e, reason: collision with root package name */
    private Handler f9250e = new HandlerC0115b(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector.OnGestureListener f9249d = new a();

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            b.this.f9250e.sendEmptyMessage(2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b.this.f9250e.sendEmptyMessage(1);
            return true;
        }
    }

    /* renamed from: com.coui.appcompat.stepper.b$b, reason: collision with other inner class name */
    private class HandlerC0115b extends Handler {
        public HandlerC0115b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                b.this.f9247b.run();
            } else if (i3 == 2 && b.this.f9246a.isEnabled()) {
                b.this.f9247b.run();
                sendEmptyMessageDelayed(2, 100L);
            }
        }
    }

    public b(View view, Runnable runnable) {
        this.f9246a = view;
        this.f9247b = runnable;
        this.f9248c = new C0255d(this.f9246a.getContext(), this.f9249d);
        e();
    }

    private void e() {
        this.f9246a.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.stepper.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f3;
                f3 = b.this.f(view, motionEvent);
                return f3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean f(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f9251f;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        this.f9248c.a(motionEvent);
        if (motionEvent.getActionMasked() == 3 || motionEvent.getActionMasked() == 1) {
            this.f9250e.removeMessages(2);
        }
        return true;
    }

    public void g() {
        this.f9250e.removeCallbacksAndMessages(null);
        this.f9250e = null;
        View view = this.f9246a;
        if (view != null) {
            view.setOnTouchListener(null);
            this.f9246a.removeCallbacks(this.f9247b);
            this.f9246a = null;
        }
        this.f9247b = null;
        this.f9251f = null;
    }

    public void h(View.OnTouchListener onTouchListener) {
        this.f9251f = onTouchListener;
    }
}
