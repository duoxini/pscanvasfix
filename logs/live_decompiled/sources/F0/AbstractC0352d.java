package f0;

import P1.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.core.view.y;
import com.coui.appcompat.dialog.widget.COUIAlertDialogMaxLinearLayout;
import f0.AbstractC0352d;
import y0.g;
import y0.i;
import y0.j;

/* renamed from: f0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0352d {

    /* renamed from: f0.d$a */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f11542a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Point f11543b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f11544c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Point f11545d;

        /* renamed from: f0.d$a$a, reason: collision with other inner class name */
        class ViewOnLayoutChangeListenerC0131a implements View.OnLayoutChangeListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f11546a;

            ViewOnLayoutChangeListenerC0131a(View view) {
                this.f11546a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                a aVar = a.this;
                AbstractC0352d.k(aVar.f11542a, aVar.f11544c, aVar.f11543b, aVar.f11545d);
                this.f11546a.removeOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: f0.c
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view2, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                        AbstractC0352d.a.ViewOnLayoutChangeListenerC0131a.this.onLayoutChange(view2, i11, i12, i13, i14, i15, i16, i17, i18);
                    }
                });
                a.this.f11542a.getDecorView().setVisibility(0);
            }
        }

        a(Window window, Point point, View view, Point point2) {
            this.f11542a = window;
            this.f11543b = point;
            this.f11544c = view;
            this.f11545d = point2;
        }

        @Override // f0.AbstractC0352d.c
        public void a() {
            View findViewById = this.f11542a.findViewById(P1.d.f1820q);
            if (findViewById == null) {
                return;
            }
            Point point = this.f11543b;
            if (point == null) {
                g.l(this.f11544c);
            } else {
                g.m(this.f11544c, point.x, point.y);
            }
            AbstractC0352d.j(this.f11542a, true);
            findViewById.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0131a(findViewById));
        }
    }

    /* renamed from: f0.d$b */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Window f11548e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f11549f;

        b(Window window, c cVar) {
            this.f11548e = window;
            this.f11549f = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f11548e.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f11549f.a();
        }
    }

    /* renamed from: f0.d$c */
    private interface c {
        void a();
    }

    public static void c(Window window, View view, Point point, Point point2) {
        i(window, -2);
        window.clearFlags(2);
        window.setGravity(51);
        window.setWindowAnimations(f.f1833b);
        h(window, new a(window, point, view, point2));
    }

    private static int d(Context context, float f3) {
        return Math.round(TypedValue.applyDimension(1, f3, context.getResources().getDisplayMetrics()));
    }

    private static int e(Window window, int i3, int i4) {
        Resources resources = window.getDecorView().getResources();
        return (resources == null || i3 == 0) ? i4 : resources.getDimensionPixelOffset(i3);
    }

    private static Drawable f(Window window, int i3) {
        Context context = window.getDecorView().getContext();
        if (context == null || i3 == 0) {
            return null;
        }
        return context.getDrawable(i3);
    }

    private static void g(Window window, int i3, int i4) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = i3;
        attributes.y = i4;
        window.setAttributes(attributes);
    }

    private static void h(Window window, c cVar) {
        if (cVar == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new b(window, cVar));
    }

    private static void i(Window window, int i3) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i3;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Window window, boolean z3) {
        View findViewById = window.findViewById(P1.d.f1820q);
        if (findViewById instanceof COUIAlertDialogMaxLinearLayout) {
            if (z3) {
                int e3 = e(window, M1.f.f1443f0, 0);
                LinearLayout linearLayout = new LinearLayout(window.getContext());
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(j.d(window.getContext(), window.getContext().getResources().getConfiguration().screenWidthDp), g.h().height()));
                if (g.k(window.getContext()) && g.i()[0] > 0) {
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.gravity = 8388659;
                    layoutParams.x = g.i()[0];
                    layoutParams.y = g.i()[1];
                    window.setAttributes(layoutParams);
                }
                j.q(linearLayout, false);
                linearLayout.setClipToOutline(false);
                linearLayout.setClipChildren(false);
                findViewById.setClipToOutline(false);
                ((COUIAlertDialogMaxLinearLayout) findViewById).setClipChildren(false);
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                viewGroup.removeView(findViewById);
                viewGroup.addView(linearLayout);
                linearLayout.addView(findViewById);
                i.d(findViewById, 3, e3, androidx.core.content.a.c(window.getContext(), P1.a.f1751a));
            } else {
                ((COUIAlertDialogMaxLinearLayout) findViewById).setMaxWidth(e(window, P1.b.f1772U, 0));
            }
            findViewById.setBackground(f(window, P1.c.f1803b));
            findViewById.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Window window, View view, Point point, Point point2) {
        Point a3;
        if (view == null && point != null) {
            g(window, point.x, point.y);
            return;
        }
        int e3 = e(window, P1.b.f1792q, 0);
        View findViewById = window.findViewById(P1.d.f1820q);
        if (point == null) {
            a3 = g.a(view.getContext(), findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight() + e3, false);
            if (a3.y < g.g()) {
                a3.y += d(view.getContext(), 8.0f);
            }
        } else {
            a3 = g.a(view.getContext(), findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight() + e3, false);
        }
        int i3 = a3.y - g.h().top;
        a3.y = i3;
        if (point2 != null) {
            a3.x += point2.x;
            a3.y = i3 + point2.y;
        }
        if (findViewById instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = a3.y + e3;
            Rect rect = new Rect();
            if (g.i()[0] == 0) {
                view.getWindowVisibleDisplayFrame(rect);
            }
            if (y.x(view) == 1) {
                layoutParams.setMarginStart(((g.h().width() - a3.x) - findViewById.getMeasuredWidth()) + rect.left);
            } else {
                layoutParams.setMarginStart(a3.x - rect.left);
            }
            findViewById.setLayoutParams(layoutParams);
        }
    }
}
