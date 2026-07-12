package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class t implements u {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f6756a;

    t(ViewGroup viewGroup) {
        this.f6756a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.x
    public void add(Drawable drawable) {
        this.f6756a.add(drawable);
    }

    @Override // androidx.transition.x
    public void remove(Drawable drawable) {
        this.f6756a.remove(drawable);
    }

    @Override // androidx.transition.u
    public void add(View view) {
        this.f6756a.add(view);
    }

    @Override // androidx.transition.u
    public void remove(View view) {
        this.f6756a.remove(view);
    }
}
