package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.J;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f5347e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f5348f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f5349g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5350h;

    public FragmentContainerView(Context context) {
        super(context);
        this.f5350h = true;
    }

    private void a(View view) {
        ArrayList arrayList = this.f5348f;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f5347e == null) {
            this.f5347e = new ArrayList();
        }
        this.f5347e.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (l.y0(view) != null) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        if (l.y0(view) != null) {
            return super.addViewInLayout(view, i3, layoutParams, z3);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        J v3 = J.v(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f5349g;
        J v4 = onApplyWindowInsetsListener != null ? J.v(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : androidx.core.view.y.V(this, v3);
        if (!v4.o()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                androidx.core.view.y.f(getChildAt(i3), v4);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f5350h && this.f5347e != null) {
            for (int i3 = 0; i3 < this.f5347e.size(); i3++) {
                super.drawChild(canvas, (View) this.f5347e.get(i3), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        ArrayList arrayList;
        if (!this.f5350h || (arrayList = this.f5347e) == null || arrayList.size() <= 0 || !this.f5347e.contains(view)) {
            return super.drawChild(canvas, view, j3);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList arrayList = this.f5348f;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f5347e;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f5350h = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z3) {
        if (z3) {
            a(view);
        }
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        a(getChildAt(i3));
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViews(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViewsInLayout(i3, i4);
    }

    void setDrawDisappearingViewsLast(boolean z3) {
        this.f5350h = z3;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f5349g = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f5348f == null) {
                this.f5348f = new ArrayList();
            }
            this.f5348f.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        this.f5350h = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E.c.f356h);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(E.c.f357i);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, l lVar) {
        super(context, attributeSet);
        String str;
        this.f5350h = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E.c.f356h);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(E.c.f357i) : classAttribute;
        String string = obtainStyledAttributes.getString(E.c.f358j);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment g02 = lVar.g0(id);
        if (classAttribute != null && g02 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a3 = lVar.p0().a(context.getClassLoader(), classAttribute);
            a3.onInflate(context, attributeSet, (Bundle) null);
            lVar.m().t(true).d(this, a3, string).k();
        }
        lVar.T0(this);
    }
}
