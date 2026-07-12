package com.oplus.pscanvas.canvasmode.canvas;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.OplusGestureMonitorManager;
import android.provider.Settings;
import android.util.Log;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import com.oplus.pscanvas.canvasmode.canvas.t0;
import com.oplus.wrapper.os.Trace;

/* loaded from: classes.dex */
public class t0 {

    /* renamed from: l, reason: collision with root package name */
    private static final String f10693l = "t0";

    /* renamed from: a, reason: collision with root package name */
    private final Context f10694a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10697d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10698e;

    /* renamed from: f, reason: collision with root package name */
    private c f10699f;

    /* renamed from: i, reason: collision with root package name */
    private Handler f10702i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10703j;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10700g = false;

    /* renamed from: h, reason: collision with root package name */
    private Rect f10701h = new Rect();

    /* renamed from: k, reason: collision with root package name */
    private OplusGestureMonitorManager.OnPointerEventObserver f10704k = new a();

    /* renamed from: c, reason: collision with root package name */
    private OplusGestureMonitorManager f10696c = OplusGestureMonitorManager.getInstance();

    /* renamed from: b, reason: collision with root package name */
    private b f10695b = new b(new Handler());

    class a implements OplusGestureMonitorManager.OnPointerEventObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(MotionEvent motionEvent) {
            t0.this.h(motionEvent);
        }

        public void onInputEvent(InputEvent inputEvent) {
            if (inputEvent instanceof MotionEvent) {
                final MotionEvent motionEvent = (MotionEvent) inputEvent;
                long j3 = Trace.TRACE_TAG_VIEW;
                Trace.traceBegin(j3, "onInputEvent for gestureModule: s" + motionEvent.getActionMasked() + " " + motionEvent.getId());
                t0.this.f10702i.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.s0
                    @Override // java.lang.Runnable
                    public final void run() {
                        t0.a.this.b(motionEvent);
                    }
                });
                Trace.traceEnd(j3);
            }
        }
    }

    private final class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f10706a;

        b(Handler handler) {
            super(handler);
            this.f10706a = Settings.Secure.getUriFor("touch_exploration_enabled");
        }

        private void b() {
            try {
                t0 t0Var = t0.this;
                boolean z3 = true;
                if (Settings.Secure.getInt(t0Var.f10694a.getContentResolver(), "touch_exploration_enabled") != 1) {
                    z3 = false;
                }
                t0Var.f10700g = z3;
            } catch (Settings.SettingNotFoundException e3) {
                e3.printStackTrace();
            }
        }

        public void a() {
            t0.this.f10694a.getContentResolver().registerContentObserver(this.f10706a, false, this);
            b();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3, Uri uri, int i3) {
            if (this.f10706a.equals(uri)) {
                b();
            }
        }
    }

    public interface c {
        void a(MotionEvent motionEvent);
    }

    public t0(Context context) {
        this.f10694a = context;
        this.f10702i = new Handler(context.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(MotionEvent motionEvent) {
        if (this.f10697d || this.f10698e) {
            return;
        }
        if (this.f10700g && !AccessibilityManager.getInstance(this.f10694a).isEnabled()) {
            Log.v(f10693l, "mTouchExplorationEnabled, return");
        } else {
            if (this.f10699f == null) {
                Log.v(f10693l, "mTouchEventListener is null, return");
                return;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.f10699f.a(obtain);
            obtain.recycle();
        }
    }

    public void e() {
        Log.e(f10693l, "dispose");
        this.f10696c.unregisterInputEvent(this.f10704k);
        if (this.f10703j) {
            this.f10694a.getContentResolver().unregisterContentObserver(this.f10695b);
        }
    }

    public void f() {
        if (this.f10696c.registerInputEvent(this.f10704k)) {
            return;
        }
        Log.d(f10693l, "registerInputEvent failed");
    }

    public void g() {
        if (B1.l.O1(this.f10694a).t0() == 5 || B1.l.O1(this.f10694a).t0() == 6) {
            return;
        }
        this.f10695b.a();
        this.f10703j = true;
    }

    public void i() {
        this.f10697d = true;
    }

    public void j() {
        OplusGestureMonitorManager oplusGestureMonitorManager = this.f10696c;
        if (oplusGestureMonitorManager != null) {
            oplusGestureMonitorManager.pilferPointers();
        }
    }

    public void k() {
        this.f10697d = false;
    }

    public void l(boolean z3) {
        this.f10698e = z3;
    }

    public void m(c cVar) {
        this.f10699f = cVar;
    }
}
