package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: classes.dex */
public abstract class H implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation = new int[2];
    private Runnable mTriggerLongPress;

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = H.this.mSrc.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            H.this.onLongPress();
        }
    }

    public H(View view) {
        this.mSrc = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = tapTimeout;
        this.mLongPressTimeout = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.mTriggerLongPress;
        if (runnable != null) {
            this.mSrc.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.mDisallowIntercept;
        if (runnable2 != null) {
            this.mSrc.removeCallbacks(runnable2);
        }
    }

    private boolean b(MotionEvent motionEvent) {
        F f3;
        View view = this.mSrc;
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing() || (f3 = (F) popup.getListView()) == null || !f3.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        e(view, obtainNoHistory);
        f(f3, obtainNoHistory);
        boolean e3 = f3.e(obtainNoHistory, this.mActivePointerId);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e3 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r1 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.mSrc
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.mActivePointerId
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.mScaledTouchSlop
            boolean r6 = d(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r5 = r0.getParent()
            r5.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.mActivePointerId = r6
            java.lang.Runnable r6 = r5.mDisallowIntercept
            if (r6 != 0) goto L52
            androidx.appcompat.widget.H$a r6 = new androidx.appcompat.widget.H$a
            r6.<init>()
            r5.mDisallowIntercept = r6
        L52:
            java.lang.Runnable r6 = r5.mDisallowIntercept
            int r1 = r5.mTapTimeout
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.mTriggerLongPress
            if (r6 != 0) goto L65
            androidx.appcompat.widget.H$b r6 = new androidx.appcompat.widget.H$b
            r6.<init>()
            r5.mTriggerLongPress = r6
        L65:
            java.lang.Runnable r6 = r5.mTriggerLongPress
            int r5 = r5.mLongPressTimeout
            long r3 = (long) r5
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.H.c(android.view.MotionEvent):boolean");
    }

    private static boolean d(View view, float f3, float f4, float f5) {
        float f6 = -f5;
        return f3 >= f6 && f4 >= f6 && f3 < ((float) (view.getRight() - view.getLeft())) + f5 && f4 < ((float) (view.getBottom() - view.getTop())) + f5;
    }

    private boolean e(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.mTmpLocation);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    private boolean f(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.mTmpLocation);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    public abstract ShowableListMenu getPopup();

    protected abstract boolean onForwardingStarted();

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    void onLongPress() {
        a();
        View view = this.mSrc;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.mForwarding = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z3;
        boolean z4 = this.mForwarding;
        if (z4) {
            z3 = b(motionEvent) || !onForwardingStopped();
        } else {
            z3 = c(motionEvent) && onForwardingStarted();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.mSrc.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.mForwarding = z3;
        return z3 || z4;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable runnable = this.mDisallowIntercept;
        if (runnable != null) {
            this.mSrc.removeCallbacks(runnable);
        }
    }
}
