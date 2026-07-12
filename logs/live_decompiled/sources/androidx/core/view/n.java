package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class n {
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean b(MotionEvent motionEvent, int i3) {
        return (motionEvent.getSource() & i3) == i3;
    }
}
