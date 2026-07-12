package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class w implements x {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f6757a;

    w(View view) {
        this.f6757a = view.getOverlay();
    }

    @Override // androidx.transition.x
    public void add(Drawable drawable) {
        this.f6757a.add(drawable);
    }

    @Override // androidx.transition.x
    public void remove(Drawable drawable) {
        this.f6757a.remove(drawable);
    }
}
