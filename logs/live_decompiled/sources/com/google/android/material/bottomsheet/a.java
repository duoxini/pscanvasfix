package com.google.android.material.bottomsheet;

import H0.i;
import U0.g;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0252a;
import androidx.core.view.J;
import androidx.core.view.t;
import androidx.core.view.y;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class a extends j {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.f bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.f edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    /* renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    class C0118a implements t {
        C0118a() {
        }

        @Override // androidx.core.view.t
        public J onApplyWindowInsets(View view, J j3) {
            if (a.this.edgeToEdgeCallback != null) {
                a.this.behavior.removeBottomSheetCallback(a.this.edgeToEdgeCallback);
            }
            if (j3 != null) {
                a aVar = a.this;
                aVar.edgeToEdgeCallback = new f(aVar.bottomSheet, j3, null);
                a.this.behavior.addBottomSheetCallback(a.this.edgeToEdgeCallback);
            }
            return j3;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.cancelable && aVar.isShowing() && a.this.shouldWindowCloseOnTouchOutside()) {
                a.this.cancel();
            }
        }
    }

    class c extends C0252a {
        c() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (!a.this.cancelable) {
                dVar.V(false);
            } else {
                dVar.a(1048576);
                dVar.V(true);
            }
        }

        @Override // androidx.core.view.C0252a
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (i3 == 1048576) {
                a aVar = a.this;
                if (aVar.cancelable) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i3, bundle);
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.f {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f3) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i3) {
            if (i3 == 5) {
                a.this.cancel();
            }
        }
    }

    private static class f extends BottomSheetBehavior.f {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f9446a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f9447b;

        /* renamed from: c, reason: collision with root package name */
        private final J f9448c;

        /* synthetic */ f(View view, J j3, C0118a c0118a) {
            this(view, j3);
        }

        private void a(View view) {
            if (view.getTop() < this.f9448c.k()) {
                a.setLightStatusBar(view, this.f9446a);
                view.setPadding(view.getPaddingLeft(), this.f9448c.k() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.setLightStatusBar(view, this.f9447b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        void onLayout(View view) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f3) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i3) {
            a(view);
        }

        private f(View view, J j3) {
            this.f9448c = j3;
            boolean z3 = (view.getSystemUiVisibility() & 8192) != 0;
            this.f9447b = z3;
            g materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            ColorStateList w3 = materialShapeDrawable != null ? materialShapeDrawable.w() : y.p(view);
            if (w3 != null) {
                this.f9446a = L0.a.f(w3.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f9446a = L0.a.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f9446a = z3;
            }
        }
    }

    public a(Context context, int i3) {
        super(context, d(context, i3));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new e();
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{H0.a.f487s}).getBoolean(0, false);
    }

    private static int d(Context context, int i3) {
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(H0.a.f471c, typedValue, true) ? typedValue.resourceId : i.f638c;
    }

    private FrameLayout e() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), H0.g.f596a, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(H0.e.f571d);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(H0.e.f572e);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private View f(int i3, View view, ViewGroup.LayoutParams layoutParams) {
        e();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(H0.e.f571d);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            y.x0(this.bottomSheet, new C0118a());
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(H0.e.f566P).setOnClickListener(new b());
        y.j0(this.bottomSheet, new c());
        this.bottomSheet.setOnTouchListener(new d());
        return this.container;
    }

    public static void setLightStatusBar(View view, boolean z3) {
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z3 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        if (!this.dismissWithAnimation || behavior.getState() == 5) {
            super.cancel();
        } else {
            behavior.setState(5);
        }
    }

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            e();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z3 = this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z3);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z3);
            }
            if (z3) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // androidx.appcompat.app.j, androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.activity.f, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.behavior.setState(4);
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z3) {
        super.setCancelable(z3);
        if (this.cancelable != z3) {
            this.cancelable = z3;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z3);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z3) {
        super.setCanceledOnTouchOutside(z3);
        if (z3 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z3;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(f(i3, null, null));
    }

    public void setDismissWithAnimation(boolean z3) {
        this.dismissWithAnimation = z3;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(f(0, view, null));
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(f(0, view, layoutParams));
    }
}
