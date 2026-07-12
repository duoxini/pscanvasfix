package M0;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: e, reason: collision with root package name */
    private final Dialog f1332e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1333f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1334g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1335h;

    public a(Dialog dialog, Rect rect) {
        this.f1332e = dialog;
        this.f1333f = rect.left;
        this.f1334g = rect.top;
        this.f1335h = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = this.f1333f + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new RectF(left, this.f1334g + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        view.performClick();
        return this.f1332e.onTouchEvent(obtain);
    }
}
