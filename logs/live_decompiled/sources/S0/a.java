package S0;

import U0.g;
import U0.k;
import U0.n;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class a extends Drawable implements n {

    /* renamed from: e, reason: collision with root package name */
    private b f2067e;

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f2067e = new b(this.f2067e);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f2067e;
        if (bVar.f2069b) {
            bVar.f2068a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f2067e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2067e.f2068a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2067e.f2068a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f2067e.f2068a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b3 = S0.b.b(iArr);
        b bVar = this.f2067e;
        if (bVar.f2069b == b3) {
            return onStateChange;
        }
        bVar.f2069b = b3;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f2067e.f2068a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2067e.f2068a.setColorFilter(colorFilter);
    }

    @Override // U0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f2067e.f2068a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        this.f2067e.f2068a.setTint(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2067e.f2068a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2067e.f2068a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        g f2068a;

        /* renamed from: b, reason: collision with root package name */
        boolean f2069b;

        public b(g gVar) {
            this.f2068a = gVar;
            this.f2069b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f2068a = (g) bVar.f2068a.getConstantState().newDrawable();
            this.f2069b = bVar.f2069b;
        }
    }

    private a(b bVar) {
        this.f2067e = bVar;
    }
}
