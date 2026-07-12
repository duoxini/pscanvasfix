package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: androidx.core.view.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0255d {

    /* renamed from: a, reason: collision with root package name */
    private final a f5112a;

    /* renamed from: androidx.core.view.d$a */
    interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* renamed from: androidx.core.view.d$b */
    static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final GestureDetector f5113a;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f5113a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.C0255d.a
        public boolean a(MotionEvent motionEvent) {
            return this.f5113a.onTouchEvent(motionEvent);
        }
    }

    public C0255d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f5112a.a(motionEvent);
    }

    public C0255d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f5112a = new b(context, onGestureListener, handler);
    }
}
