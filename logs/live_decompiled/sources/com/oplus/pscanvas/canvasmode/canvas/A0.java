package com.oplus.pscanvas.canvasmode.canvas;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.oplus.animation.DynamicAnimation;
import com.oplus.animation.FloatValueHolder;
import com.oplus.animation.SpringAnimation;
import com.oplus.animation.SpringForce;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.DraggableCanvasViewGroup;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import u1.C0600c;
import u1.C0601d;

/* loaded from: classes.dex */
public class A0 {

    /* renamed from: K, reason: collision with root package name */
    private static final String f10169K = "A0";

    /* renamed from: A, reason: collision with root package name */
    private int f10170A;

    /* renamed from: B, reason: collision with root package name */
    private int f10171B;

    /* renamed from: C, reason: collision with root package name */
    private int f10172C;

    /* renamed from: D, reason: collision with root package name */
    private int f10173D;

    /* renamed from: E, reason: collision with root package name */
    private int f10174E;

    /* renamed from: F, reason: collision with root package name */
    private int f10175F;

    /* renamed from: G, reason: collision with root package name */
    private RelativeLayout.LayoutParams f10176G;

    /* renamed from: H, reason: collision with root package name */
    private WindowManager.LayoutParams f10177H;

    /* renamed from: J, reason: collision with root package name */
    private boolean f10179J;

    /* renamed from: a, reason: collision with root package name */
    private ContainerView f10180a;

    /* renamed from: b, reason: collision with root package name */
    private DraggableCanvasViewGroup f10181b;

    /* renamed from: h, reason: collision with root package name */
    private float f10187h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10188i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f10189j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f10190k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f10191l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f10192m;

    /* renamed from: p, reason: collision with root package name */
    private SpringAnimation f10195p;

    /* renamed from: r, reason: collision with root package name */
    private ContainerActivity f10197r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f10198s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f10199t;

    /* renamed from: u, reason: collision with root package name */
    private Toast f10200u;

    /* renamed from: v, reason: collision with root package name */
    private Handler f10201v;

    /* renamed from: w, reason: collision with root package name */
    private WindowManager f10202w;

    /* renamed from: x, reason: collision with root package name */
    private Context f10203x;

    /* renamed from: y, reason: collision with root package name */
    private ViewGroup f10204y;

    /* renamed from: z, reason: collision with root package name */
    private int f10205z;

    /* renamed from: c, reason: collision with root package name */
    private final float f10182c = 0.5f;

    /* renamed from: d, reason: collision with root package name */
    private final float f10183d = 1.2f;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10184e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10185f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10186g = false;

    /* renamed from: n, reason: collision with root package name */
    private Rect f10193n = new Rect();

    /* renamed from: o, reason: collision with root package name */
    private Rect f10194o = new Rect();

    /* renamed from: q, reason: collision with root package name */
    private boolean f10196q = false;

    /* renamed from: I, reason: collision with root package name */
    boolean f10178I = false;

    class a implements DynamicAnimation.OnAnimationEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10206a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f10207b;

        a(ViewGroup viewGroup, boolean z3) {
            this.f10206a = viewGroup;
            this.f10207b = z3;
        }

        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z3, float f3, float f4) {
            B1.l.u1(this.f10206a, 20109, false);
            ViewGroup viewGroup = this.f10206a;
            viewGroup.setTranslationX(viewGroup.getTranslationX() + (this.f10206a.getPivotX() * (1.0f - this.f10206a.getScaleX())));
            ViewGroup viewGroup2 = this.f10206a;
            viewGroup2.setTranslationY(viewGroup2.getTranslationY() + (this.f10206a.getPivotY() * (1.0f - this.f10206a.getScaleY())));
            this.f10206a.setPivotX(0.0f);
            this.f10206a.setPivotY(0.0f);
            A0.this.f10180a.s2();
            if (!A0.this.f10196q && this.f10207b) {
                if (A0.this.f10200u == null) {
                    A0 a02 = A0.this;
                    a02.f10200u = Toast.makeText(a02.f10197r.getApplicationContext(), t1.j.f13642h0, 0);
                }
                A0.this.f10200u.show();
                A0.this.f10197r.y0().n();
                A0 a03 = A0.this;
                a03.c0(a03.f10203x);
            }
            A0.this.f10196q = false;
            A0.this.f10188i = false;
            A0.this.f10180a.o2();
            FlexibleWindowManager.getInstance().notifyEmbeddedTasksChangeFocus(true, A0.this.f10197r.getTaskId());
        }
    }

    public A0(DraggableCanvasViewGroup draggableCanvasViewGroup, ContainerView containerView, ContainerActivity containerActivity, Handler handler) {
        this.f10181b = draggableCanvasViewGroup;
        this.f10180a = containerView;
        this.f10197r = containerActivity;
        this.f10201v = handler;
        this.f10203x = containerActivity.getApplicationContext();
    }

    private void F() {
        this.f10205z = y(32);
        this.f10170A = y(32);
        this.f10171B = y(16);
        this.f10172C = y(16);
        this.f10173D = DisplayMetrics.DENSITY_DEVICE_STABLE == 520 ? y(40) : y(56);
        if (B1.s.H()) {
            this.f10173D = this.f10172C;
        }
        this.f10175F = this.f10171B + this.f10170A;
    }

    private void G(Context context) {
        if (this.f10204y == null) {
            this.f10204y = (ViewGroup) LayoutInflater.from(context).inflate(t1.h.f13482o, (ViewGroup) null, false);
        }
        if (this.f10198s == null) {
            TextView textView = (TextView) this.f10204y.getChildAt(0);
            this.f10198s = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    A0.this.O(view);
                }
            });
        }
        if (this.f10199t == null) {
            TextView textView2 = (TextView) this.f10197r.findViewById(t1.f.f13466z);
            this.f10199t = textView2;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    A0.this.P(view);
                }
            });
        }
    }

    private void H() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10199t.getLayoutParams();
        this.f10176G = layoutParams;
        layoutParams.topMargin = this.f10171B;
    }

    private void I(Context context) {
        this.f10202w = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(2038);
        this.f10177H = layoutParams;
        layoutParams.setTitle("exitButton");
        WindowManager.LayoutParams layoutParams2 = this.f10177H;
        layoutParams2.flags = 40;
        layoutParams2.format = 1;
        layoutParams2.gravity = 8388659;
        layoutParams2.width = this.f10205z;
        layoutParams2.height = this.f10170A;
        layoutParams2.y = this.f10171B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        if (this.f10178I) {
            return;
        }
        try {
            this.f10202w.addView(this.f10204y, this.f10177H);
            this.f10178I = true;
        } catch (Exception e3) {
            Log.e(f10169K, "addExitButtonInWindowManager error: " + e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        A(true);
        W("button_click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        A(true);
        W("button_click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (this.f10178I) {
            try {
                this.f10202w.removeView(this.f10204y);
                this.f10178I = false;
            } catch (Exception e3) {
                Log.e(f10169K, "removeExitButtonInWindowManager error: " + e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(ViewGroup viewGroup, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, DynamicAnimation dynamicAnimation, float f15, float f16) {
        float f17 = f15 / 1000.0f;
        viewGroup.setPivotX((f3 * f17) + f4);
        viewGroup.setPivotY((f5 * f17) + f6);
        viewGroup.setScaleX((f7 * f17) + f8);
        viewGroup.setScaleY((f9 * f17) + f10);
        viewGroup.setTranslationX((f11 * f17) + f12);
        viewGroup.setTranslationY((f13 * f17) + f14);
    }

    private void T() {
        if (!this.f10178I) {
            this.f10204y = null;
            this.f10198s = null;
        }
        TextView textView = this.f10199t;
        if (textView == null || textView.getVisibility() == 0) {
            return;
        }
        this.f10199t = null;
    }

    private void X(int i3) {
        this.f10180a.setControlBarVisibility(i3);
    }

    private void Y(int i3) {
        this.f10180a.setSplitBarVisibility(i3);
    }

    private void Z(Context context) {
        if (context == null || this.f10176G == null) {
            return;
        }
        boolean z3 = context.getResources().getConfiguration().orientation == 1;
        this.f10176G.leftMargin = z3 ? this.f10172C : this.f10173D;
    }

    private void a0(Context context) {
        if (context == null || this.f10177H == null) {
            return;
        }
        boolean z3 = context.getResources().getConfiguration().orientation == 1;
        this.f10177H.x = z3 ? this.f10172C : this.f10173D;
    }

    private void e0(final ViewGroup viewGroup, float f3, float f4, float f5, boolean z3) {
        final float translationX = viewGroup.getTranslationX();
        final float translationY = viewGroup.getTranslationY();
        final float scaleX = viewGroup.getScaleX();
        final float scaleY = viewGroup.getScaleY();
        final float pivotX = viewGroup.getPivotX();
        final float pivotY = viewGroup.getPivotY();
        final float translationX2 = f3 - viewGroup.getTranslationX();
        final float translationY2 = f4 - viewGroup.getTranslationY();
        final float f6 = f5 - scaleX;
        final float f7 = f5 - scaleY;
        final float f8 = 0.0f - pivotX;
        final float f9 = 0.0f - pivotY;
        this.f10188i = true;
        final SpringAnimation startVelocity = new SpringAnimation(new FloatValueHolder()).setStartValue(0.0f).setStartVelocity(1000.0f);
        startVelocity.setSpring(new SpringForce(1000.0f).setStiffness(120.0f).setDampingRatio(0.8f));
        startVelocity.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.y0
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
                A0.R(viewGroup, f8, pivotX, f9, pivotY, f6, scaleX, f7, scaleY, translationX2, translationX, translationY2, translationY, dynamicAnimation, f10, f11);
            }
        });
        this.f10195p = startVelocity;
        startVelocity.addEndListener(new a(viewGroup, z3));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.z0
            @Override // java.lang.Runnable
            public final void run() {
                startVelocity.start();
            }
        });
    }

    private boolean q() {
        this.f10193n.set(this.f10180a.getWindowMetricsBounds());
        this.f10194o.set(this.f10180a.getRectListUnion());
        if (this.f10193n.isEmpty() || this.f10194o.isEmpty()) {
            return false;
        }
        float t3 = t();
        this.f10187h = t3;
        ContainerActivity containerActivity = this.f10197r;
        if (containerActivity != null) {
            containerActivity.p1(t3);
        }
        this.f10192m = u();
        this.f10189j = v();
        this.f10191l = r();
        this.f10190k = s();
        return true;
    }

    private Rect s() {
        Rect rect = new Rect();
        int width = (int) (this.f10181b.getWidth() * this.f10187h);
        int height = (int) (this.f10181b.getHeight() * this.f10187h);
        int[] iArr = this.f10191l;
        int i3 = iArr[0];
        int i4 = width / 2;
        int i5 = iArr[1];
        int i6 = height / 2;
        rect.set(i3 - i4, i5 - i6, i3 + i4, i5 + i6);
        return rect;
    }

    private float t() {
        Rect rect = this.f10193n;
        int width = rect.width() - 16;
        float width2 = (float) (width / this.f10194o.width());
        float height = (float) ((rect.height() - 16) / this.f10194o.height());
        if (width2 < height) {
            this.f10185f = true;
        } else {
            this.f10186g = true;
        }
        return Math.min(width2, height);
    }

    private int[] u() {
        Rect rect = this.f10193n;
        return new int[]{rect.width() / 2, rect.height() / 2};
    }

    private Rect v() {
        Rect rect = new Rect();
        int[] iArr = this.f10192m;
        int i3 = iArr[0];
        float f3 = i3;
        float width = ((int) (this.f10187h * this.f10194o.width())) * 0.5f;
        float f4 = iArr[1];
        float height = ((int) (this.f10187h * this.f10194o.height())) * 0.5f;
        rect.set((int) (f3 - width), (int) (f4 - height), (int) (f3 + width), (int) (f4 + height));
        return rect;
    }

    private int y(int i3) {
        return Math.round(i3 * (DisplayMetrics.DENSITY_DEVICE_STABLE / 160));
    }

    public void A(boolean z3) {
        this.f10184e = false;
        if (b0()) {
            X(0);
        }
        Y(0);
        D();
        if (z3) {
            this.f10180a.E1();
            ContainerActivity containerActivity = this.f10197r;
            if (containerActivity != null && containerActivity.y0() != null) {
                this.f10197r.y0().o(205);
            }
        }
        ContainerActivity containerActivity2 = this.f10197r;
        if (containerActivity2 != null) {
            containerActivity2.o1(this.f10184e);
        }
        T();
    }

    public Rect B() {
        List<Rect> childrenPositionOnScreen = this.f10180a.getChildrenPositionOnScreen();
        Rect rect = new Rect();
        Iterator<Rect> it = childrenPositionOnScreen.iterator();
        while (it.hasNext()) {
            rect.union(it.next());
        }
        return rect;
    }

    public float[] C(float f3, float f4, float f5, float f6) {
        Rect B3 = B();
        Rect containerGroupRect = this.f10180a.getContainerGroupRect();
        float f7 = M() ? 1.2f : 0.5f;
        float exactCenterX = containerGroupRect.exactCenterX();
        float exactCenterY = containerGroupRect.exactCenterY();
        int i3 = B3.left;
        float f8 = 1.0f - f7;
        int i4 = ((int) ((exactCenterX - i3) * f8)) + i3;
        int i5 = B3.top;
        int i6 = ((int) ((exactCenterY - i5) * f8)) + i5;
        Rect rect = new Rect(i4, i6, (int) (i4 + (B3.width() * f7)), (int) (i6 + (B3.height() * f7)));
        return new float[]{(rect.left - B3.left) + f5, (rect.top - B3.top) + f6, f7 * Math.min(f3, f4)};
    }

    public void D() {
        U();
        V();
    }

    public void E(Context context) {
        G(this.f10203x);
        F();
        I(context);
        H();
        a0(context);
        Z(context);
        this.f10179J = true;
    }

    public boolean J() {
        return this.f10178I;
    }

    public boolean K(Context context) {
        int i3;
        int i4;
        if (context.getResources().getConfiguration().orientation == 1) {
            i3 = this.f10205z;
            i4 = this.f10172C;
        } else {
            i3 = this.f10205z;
            i4 = this.f10173D;
        }
        this.f10174E = i3 + i4;
        Rect rect = new Rect(0, 0, this.f10174E, this.f10175F);
        Log.d(f10169K, "exitButtonRect = " + rect + " mTargetUnionRect = " + this.f10189j);
        if (this.f10189j == null && !q()) {
            return false;
        }
        Rect rect2 = this.f10189j;
        return rect.contains(rect2.left, rect2.top);
    }

    public boolean L() {
        return this.f10188i;
    }

    public boolean M() {
        return this.f10184e;
    }

    public void S(Configuration configuration) {
        Context createConfigurationContext = this.f10203x.createConfigurationContext(configuration);
        Z(createConfigurationContext);
        a0(createConfigurationContext);
        if (this.f10184e) {
            D();
            c0(createConfigurationContext);
        }
    }

    public void U() {
        TextView textView = this.f10199t;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.f10199t.setVisibility(8);
    }

    public void V() {
        if (this.f10201v == null) {
            return;
        }
        Log.d(f10169K, "removeExitButtonInWindowManager, exitButtonAddedInWindowManager: " + this.f10178I);
        this.f10201v.postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.x0
            @Override // java.lang.Runnable
            public final void run() {
                A0.this.Q();
            }
        }, 0L);
    }

    public void W(String str) {
        List l3 = this.f10180a.getAdapter().l();
        int size = l3.size();
        B1.h.a(this.f10203x).b(str, B1.s.g(l3), size);
    }

    public boolean b0() {
        C0600c adapter = this.f10180a.getAdapter();
        if (adapter.getCount() != 2) {
            return true;
        }
        C0601d item = adapter.getItem(0);
        C0601d item2 = adapter.getItem(1);
        return item == null || item2 == null || item.v() != item2.v() || !Objects.equals(item.k(), item2.k()) || !B1.l.f214n.contains(item.k()) || B1.s.w(this.f10203x);
    }

    public void c0(Context context) {
        G(this.f10203x);
        if (K(context)) {
            U();
            o();
        } else {
            V();
            n();
        }
    }

    public void d0(boolean z3) {
        if (q()) {
            FlexibleWindowManager.getInstance().notifyEmbeddedTasksChangeFocus(false, this.f10197r.getTaskId());
            ViewGroup viewGroup = (ViewGroup) this.f10180a.getParent();
            Rect rect = this.f10190k;
            e0(viewGroup, rect.left, rect.top, this.f10187h, z3);
        }
    }

    public void f0(Context context) {
        Z(context);
        a0(context);
        if (this.f10184e) {
            D();
            c0(context);
        }
    }

    public void n() {
        TextView textView = this.f10199t;
        if (textView == null || textView.getVisibility() == 0) {
            return;
        }
        this.f10199t.setLayoutParams(this.f10176G);
        this.f10199t.setVisibility(0);
    }

    public void o() {
        if (this.f10201v == null) {
            return;
        }
        Log.d(f10169K, "addExitButtonInWindowManager, exitButtonAddedInWindowManager: " + this.f10178I);
        this.f10201v.postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.w0
            @Override // java.lang.Runnable
            public final void run() {
                A0.this.N();
            }
        }, 0L);
    }

    public void p() {
        if (q()) {
            ViewGroup viewGroup = (ViewGroup) this.f10180a.getParent();
            viewGroup.setTranslationX(this.f10190k.left);
            viewGroup.setTranslationY(this.f10190k.top);
            viewGroup.setScaleX(this.f10187h);
            viewGroup.setScaleY(this.f10187h);
            this.f10180a.s2();
        }
    }

    public int[] r() {
        int width = (this.f10181b.getWidth() / 2) - this.f10194o.centerX();
        int height = (this.f10181b.getHeight() / 2) - this.f10194o.centerY();
        float f3 = this.f10187h;
        return new int[]{this.f10189j.centerX() + ((int) (width * f3)), this.f10189j.centerY() + ((int) (height * f3))};
    }

    public void w() {
        this.f10196q = true;
        this.f10195p.cancel();
    }

    public void x() {
        Toast toast = this.f10200u;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void z(boolean z3) {
        if (!this.f10179J) {
            E(this.f10197r);
        }
        boolean z4 = !this.f10184e;
        this.f10184e = true;
        if (z3) {
            d0(z4);
        }
        X(4);
        Y(4);
        ContainerActivity containerActivity = this.f10197r;
        if (containerActivity != null) {
            containerActivity.o1(this.f10184e);
        }
        ContainerView containerView = this.f10180a;
        if (containerView != null) {
            E e3 = containerView.f10732G;
            if (e3 != null) {
                e3.P();
            }
            this.f10180a.J0();
        }
        B1.h.a(this.f10203x).h();
    }
}
