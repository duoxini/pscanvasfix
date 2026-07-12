package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0228b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f4198a;

    /* renamed from: androidx.appcompat.widget.b$a */
    private static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C0228b(ActionBarContainer actionBarContainer) {
        this.f4198a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f4198a;
        if (actionBarContainer.f3812l) {
            Drawable drawable = actionBarContainer.f3811k;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f3809i;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f4198a;
        Drawable drawable3 = actionBarContainer2.f3810j;
        if (drawable3 == null || !actionBarContainer2.f3813m) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f4198a;
        if (actionBarContainer.f3812l) {
            if (actionBarContainer.f3811k != null) {
                a.a(actionBarContainer.f3809i, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f3809i;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
