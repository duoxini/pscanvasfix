package g;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class c extends Drawable implements Drawable.Callback {

    /* renamed from: e, reason: collision with root package name */
    private Drawable f11639e;

    public c(Drawable drawable) {
        a(drawable);
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f11639e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f11639e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f11639e.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f11639e.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f11639e.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11639e.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11639e.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f11639e.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f11639e.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f11639e.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f11639e.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f11639e.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f11639e.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return androidx.core.graphics.drawable.a.c(this.f11639e);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f11639e.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f11639e.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f11639e.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        return this.f11639e.setLevel(i3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f11639e.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z3) {
        androidx.core.graphics.drawable.a.d(this.f11639e, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        this.f11639e.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f11639e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z3) {
        this.f11639e.setDither(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f11639e.setFilterBitmap(z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f3, float f4) {
        androidx.core.graphics.drawable.a.e(this.f11639e, f3, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i4, int i5, int i6) {
        androidx.core.graphics.drawable.a.f(this.f11639e, i3, i4, i5, i6);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f11639e.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        androidx.core.graphics.drawable.a.h(this.f11639e, i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.i(this.f11639e, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        androidx.core.graphics.drawable.a.j(this.f11639e, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        return super.setVisible(z3, z4) || this.f11639e.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
