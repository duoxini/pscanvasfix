package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import e.AbstractC0339a;

/* renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0246u extends SeekBar {

    /* renamed from: e, reason: collision with root package name */
    private final C0247v f4292e;

    public C0246u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11080I);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f4292e.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f4292e.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4292e.g(canvas);
    }

    public C0246u(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Q.a(this, getContext());
        C0247v c0247v = new C0247v(this);
        this.f4292e = c0247v;
        c0247v.c(attributeSet, i3);
    }
}
