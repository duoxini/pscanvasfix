package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {

    /* renamed from: e, reason: collision with root package name */
    private final C0231e f3879e;

    /* renamed from: f, reason: collision with root package name */
    private final C0241o f3880f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3881g;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            c0231e.b();
        }
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            c0241o.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            return c0241o.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            return c0241o.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f3880f.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            c0241o.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0241o c0241o = this.f3880f;
        if (c0241o != null && drawable != null && !this.f3881g) {
            c0241o.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0241o c0241o2 = this.f3880f;
        if (c0241o2 != null) {
            c0241o2.c();
            if (this.f3881g) {
                return;
            }
            this.f3880f.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i3) {
        super.setImageLevel(i3);
        this.f3881g = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            c0241o.i(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            c0241o.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f3879e;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            c0241o.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0241o c0241o = this.f3880f;
        if (c0241o != null) {
            c0241o.k(mode);
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        this.f3881g = false;
        Q.a(this, getContext());
        C0231e c0231e = new C0231e(this);
        this.f3879e = c0231e;
        c0231e.e(attributeSet, i3);
        C0241o c0241o = new C0241o(this);
        this.f3880f = c0241o;
        c0241o.g(attributeSet, i3);
    }
}
