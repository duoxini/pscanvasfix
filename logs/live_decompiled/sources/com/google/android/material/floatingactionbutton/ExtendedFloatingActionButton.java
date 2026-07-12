package com.google.android.material.floatingactionbutton;

import H0.i;
import H0.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.p;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.y;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* renamed from: x, reason: collision with root package name */
    private static final int f9738x = i.f652q;

    /* renamed from: y, reason: collision with root package name */
    static final Property f9739y = new a(Float.class, "width");

    /* renamed from: z, reason: collision with root package name */
    static final Property f9740z = new b(Float.class, "height");

    /* renamed from: A, reason: collision with root package name */
    static final Property f9736A = new c(Float.class, "paddingStart");

    /* renamed from: B, reason: collision with root package name */
    static final Property f9737B = new d(Float.class, "paddingEnd");

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            view.getLayoutParams().width = f3.intValue();
            view.requestLayout();
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            view.getLayoutParams().height = f3.intValue();
            view.requestLayout();
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.C(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            y.y0(view, f3.intValue(), view.getPaddingTop(), y.B(view), view.getPaddingBottom());
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(y.B(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            y.y0(view, y.C(view), view.getPaddingTop(), f3.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class e {
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.a j(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.a k(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    static /* synthetic */ void l(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar, e eVar) {
        throw null;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.a m(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    static /* synthetic */ com.google.android.material.floatingactionbutton.a n(ExtendedFloatingActionButton extendedFloatingActionButton) {
        throw null;
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c {

        /* renamed from: a, reason: collision with root package name */
        private Rect f9741a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f9742b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9743c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f9742b = false;
            this.f9743c = true;
        }

        private static boolean c(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).e() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean f(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            throw null;
        }

        private boolean h(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!f(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f9741a == null) {
                this.f9741a = new Rect();
            }
            Rect rect = this.f9741a;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                g(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        private boolean i(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (f(view, extendedFloatingActionButton)) {
                throw null;
            }
            return false;
        }

        protected void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.f9743c) {
                ExtendedFloatingActionButton.m(extendedFloatingActionButton);
            } else {
                ExtendedFloatingActionButton.n(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.l(extendedFloatingActionButton, null, null);
        }

        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean d(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                h(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!c(view)) {
                return false;
            }
            i(view, extendedFloatingActionButton);
            return false;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i3) {
            List r3 = coordinatorLayout.r(extendedFloatingActionButton);
            int size = r3.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) r3.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (c(view) && i(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (h(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i3);
            return true;
        }

        protected void g(ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.f9743c) {
                ExtendedFloatingActionButton.j(extendedFloatingActionButton);
            } else {
                ExtendedFloatingActionButton.k(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.l(extendedFloatingActionButton, null, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            p.a(view);
            return b(coordinatorLayout, null, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.f4784h == 0) {
                fVar.f4784h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            p.a(view);
            return d(coordinatorLayout, null, view2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            p.a(view);
            return e(coordinatorLayout, null, i3);
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f751X1);
            this.f9742b = obtainStyledAttributes.getBoolean(j.f755Y1, false);
            this.f9743c = obtainStyledAttributes.getBoolean(j.f758Z1, true);
            obtainStyledAttributes.recycle();
        }
    }
}
