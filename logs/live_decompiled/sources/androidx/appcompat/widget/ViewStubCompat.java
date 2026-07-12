package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: e, reason: collision with root package name */
    private int f4157e;

    /* renamed from: f, reason: collision with root package name */
    private int f4158f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference f4159g;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f4160h;

    public interface a {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f4157e == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.f4160h;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.f4157e, viewGroup, false);
        int i3 = this.f4158f;
        if (i3 != -1) {
            inflate.setId(i3);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.f4159g = new WeakReference(inflate);
        return inflate;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f4158f;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f4160h;
    }

    public int getLayoutResource() {
        return this.f4157e;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i3) {
        this.f4158f = i3;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f4160h = layoutInflater;
    }

    public void setLayoutResource(int i3) {
        this.f4157e = i3;
    }

    public void setOnInflateListener(a aVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        WeakReference weakReference = this.f4159g;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 == 0 || i3 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4157e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.P3, i3, 0);
        this.f4158f = obtainStyledAttributes.getResourceId(e.j.S3, -1);
        this.f4157e = obtainStyledAttributes.getResourceId(e.j.R3, 0);
        setId(obtainStyledAttributes.getResourceId(e.j.Q3, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
