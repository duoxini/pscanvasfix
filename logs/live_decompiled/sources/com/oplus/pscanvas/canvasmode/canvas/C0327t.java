package com.oplus.pscanvas.canvasmode.canvas;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityTaskManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemProperties;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.poplist.s;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.app.OPlusAccessControlManager;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import com.oplus.view.inputmethod.OplusInputMethodManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import t1.AbstractC0587a;
import t1.AbstractC0589c;
import u1.C0598a;
import u1.C0601d;
import x1.C0631a;

/* renamed from: com.oplus.pscanvas.canvasmode.canvas.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0327t implements ContainerActivity.h {

    /* renamed from: g0, reason: collision with root package name */
    public static final boolean f10620g0 = SystemProperties.getBoolean("ro.oplus.is_not_support_threesplit", false);

    /* renamed from: h0, reason: collision with root package name */
    private static final String f10621h0 = C0327t.class.getSimpleName();

    /* renamed from: i0, reason: collision with root package name */
    private static Boolean f10622i0 = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: A, reason: collision with root package name */
    private COUIRecyclerView f10623A;

    /* renamed from: B, reason: collision with root package name */
    private COUIRecyclerView f10624B;

    /* renamed from: C, reason: collision with root package name */
    private ViewStub f10625C;

    /* renamed from: D, reason: collision with root package name */
    private EffectiveAnimationView f10626D;

    /* renamed from: E, reason: collision with root package name */
    private View f10627E;

    /* renamed from: G, reason: collision with root package name */
    private int f10629G;

    /* renamed from: H, reason: collision with root package name */
    private int f10630H;

    /* renamed from: I, reason: collision with root package name */
    private int f10631I;

    /* renamed from: J, reason: collision with root package name */
    private int f10632J;

    /* renamed from: K, reason: collision with root package name */
    private int f10633K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f10634L;

    /* renamed from: M, reason: collision with root package name */
    private PopupWindow f10635M;

    /* renamed from: N, reason: collision with root package name */
    private RelativeLayout f10636N;

    /* renamed from: O, reason: collision with root package name */
    private View f10637O;

    /* renamed from: P, reason: collision with root package name */
    private Future f10638P;

    /* renamed from: Q, reason: collision with root package name */
    private Animation f10639Q;

    /* renamed from: R, reason: collision with root package name */
    private EmbeddedViewDecor f10640R;

    /* renamed from: S, reason: collision with root package name */
    private C0631a f10641S;

    /* renamed from: T, reason: collision with root package name */
    private x1.u f10642T;

    /* renamed from: U, reason: collision with root package name */
    private x1.y f10643U;

    /* renamed from: W, reason: collision with root package name */
    private ArrayList f10645W;

    /* renamed from: Y, reason: collision with root package name */
    private GridLayoutManager f10647Y;

    /* renamed from: Z, reason: collision with root package name */
    private J f10648Z;

    /* renamed from: a, reason: collision with root package name */
    private final int f10649a;

    /* renamed from: b, reason: collision with root package name */
    private final int f10651b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10653c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f10655d;

    /* renamed from: e, reason: collision with root package name */
    private ImageButton f10657e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f10659f;

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f10661g;

    /* renamed from: h, reason: collision with root package name */
    private AnimatorSet f10662h;

    /* renamed from: i, reason: collision with root package name */
    private GestureDetector f10663i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f10664j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f10665k;

    /* renamed from: l, reason: collision with root package name */
    private FlexibleTaskView f10666l;

    /* renamed from: m, reason: collision with root package name */
    private EmbeddedViewDecor f10667m;

    /* renamed from: n, reason: collision with root package name */
    private ContainerView f10668n;

    /* renamed from: o, reason: collision with root package name */
    private C0601d f10669o;

    /* renamed from: p, reason: collision with root package name */
    private com.coui.appcompat.poplist.f f10670p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f10671q;

    /* renamed from: r, reason: collision with root package name */
    private C0309c f10672r;

    /* renamed from: w, reason: collision with root package name */
    public com.coui.appcompat.poplist.k f10677w;

    /* renamed from: x, reason: collision with root package name */
    private View f10678x;

    /* renamed from: y, reason: collision with root package name */
    private RelativeLayout f10679y;

    /* renamed from: z, reason: collision with root package name */
    private COUISearchBar f10680z;

    /* renamed from: s, reason: collision with root package name */
    private List f10673s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    private List f10674t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    private List f10675u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    private L1.a f10676v = new L1.a();

    /* renamed from: F, reason: collision with root package name */
    private String f10628F = "";

    /* renamed from: V, reason: collision with root package name */
    private int f10644V = 0;

    /* renamed from: X, reason: collision with root package name */
    private float f10646X = 0.0f;

    /* renamed from: a0, reason: collision with root package name */
    private long f10650a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f10652b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f10654c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f10656d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f10658e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private final TextWatcher f10660f0 = new a();

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$a */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (C0327t.f10622i0.booleanValue()) {
                Log.d(C0327t.f10621h0, "afterTextChanged s : " + ((Object) editable));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            if (C0327t.f10622i0.booleanValue()) {
                Log.d(C0327t.f10621h0, "beforeTextChanged s : " + ((Object) charSequence) + " start : " + i3 + " after : " + i5);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            C0327t.this.r0(charSequence.toString());
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$b */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C0601d f10682e;

        b(C0327t c0327t, C0601d c0601d) {
            this.f10682e = c0601d;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (B1.l.f217q) {
                try {
                    if (!B1.l.f217q.containsKey(this.f10682e.k())) {
                        B1.l.O0(this.f10682e.k());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$c */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            com.coui.appcompat.poplist.s sVar = (com.coui.appcompat.poplist.s) C0327t.this.f10645W.get(i3);
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13623W)) && sVar.z()) {
                C0327t.this.f10670p.dismiss();
                C0327t.this.f10672r.l("menu_enlarge");
                C0327t.this.f10672r.m(C0327t.this.f10668n, C0327t.this.f10669o, true);
                return;
            }
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13624X)) && sVar.z()) {
                C0327t.this.f10670p.dismiss();
                C0327t.this.f10672r.l("menu_narrow");
                C0327t.this.f10672r.m(C0327t.this.f10668n, C0327t.this.f10669o, false);
                return;
            }
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13633d))) {
                C0327t.this.f10670p.dismiss();
                C0327t.this.f10668n.H2();
                B1.h.a(C0327t.this.f10664j.getApplicationContext()).e("menu_full");
                return;
            }
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13625Y))) {
                C0327t.this.f10670p.dismiss();
                C0327t.this.v1();
                return;
            }
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13637f)) && ((com.coui.appcompat.poplist.s) C0327t.this.f10645W.get(i3)).z()) {
                C0327t.this.f10670p.dismiss();
                C0327t c0327t = C0327t.this;
                if (c0327t.F1(c0327t.f10664j).N0()) {
                    Log.w(C0327t.f10621h0, "intercept switchToZoom inSplitScreenToFlexibleTask.");
                    return;
                } else {
                    C0327t.this.D1();
                    return;
                }
            }
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13631c))) {
                C0327t.this.f10670p.dismiss();
                C0327t.this.f10668n.setMenuAction("menu_close");
                C0327t.this.f10668n.S1();
                return;
            }
            if (sVar.t().equals(C0327t.this.f10664j.getResources().getString(t1.j.f13635e))) {
                C0327t.this.f10670p.dismiss();
                C0327t.this.C1();
                return;
            }
            if (sVar.m() == 1) {
                C0327t.this.f10670p.dismiss();
                if (C0327t.this.f10668n.getAdapter().getCount() != 2) {
                    Log.w(C0327t.f10621h0, "onItemClick count error");
                    return;
                }
                Bundle bundle = new Bundle();
                boolean[] zArr = {false, false};
                C0601d item = C0327t.this.f10668n.getAdapter().getItem(0);
                if (item == null) {
                    Log.w(C0327t.f10621h0, "onItemClick taskData index 0 null");
                    return;
                }
                int s3 = item.s();
                zArr[0] = item.u();
                if (item.B()) {
                    zArr[0] = !B1.s.z(0, C0327t.this.f10668n);
                }
                float splitRatio = item.H() ? C0327t.this.f10668n.getSplitRatio() : 0.0f;
                C0601d item2 = C0327t.this.f10668n.getAdapter().getItem(1);
                if (item2 == null) {
                    Log.w(C0327t.f10621h0, "onItemClick taskData index 1 null");
                    return;
                }
                bundle.putInt("androidx.flexible.split_to_mini_second", item2.s());
                zArr[1] = item2.u();
                if (item2.B()) {
                    zArr[1] = !B1.s.z(1, C0327t.this.f10668n);
                }
                int n3 = C0327t.this.f10668n.getContainerController().n();
                int q3 = C0327t.this.f10668n.getContainerController().q();
                bundle.putInt("androidx.flexible.focusIndex", n3);
                bundle.putInt("androidx.flexible.layoutOrientation", q3);
                bundle.putBooleanArray("androidx.flexible.useMaxLayoutArray", zArr);
                bundle.putFloat("androidx.flexible.SplitRatio", splitRatio);
                Log.d(C0327t.f10621h0, "onItemClick third focusIndex:" + n3 + ",orientation:" + q3 + ",useMaxArray:" + Arrays.toString(zArr));
                B1.l.h1(s3, 2101, bundle);
                C0327t.this.f10668n.getAdapter().W();
                C0327t c0327t2 = C0327t.this;
                c0327t2.F1(c0327t2.f10664j).G1(true);
            }
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$d */
    class d implements PopupWindow.OnDismissListener {
        d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            com.coui.appcompat.poplist.k kVar = C0327t.this.f10677w;
            if (kVar != null) {
                kVar.dismiss();
            }
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$e */
    class e implements Runnable {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(List list) {
            if (!C0327t.this.f10634L || C0327t.this.f10623A == null || C0327t.this.f10623A.getAdapter() == null || C0327t.this.f10637O == null || C0327t.this.f10680z == null || C0327t.this.f10638P == null) {
                return;
            }
            if (C0327t.f10622i0.booleanValue()) {
                Log.d(C0327t.f10621h0, "about to start showing the results");
            }
            C0327t.this.f10675u.clear();
            C0327t.this.f10675u.addAll(list);
            C0327t.this.f10623A.getAdapter().notifyDataSetChanged();
            C0327t.this.f10637O.setVisibility(8);
            C0327t.this.f10680z.setClickable(true);
            C0327t.this.f10680z.setFocusable(true);
            C0327t.this.f10680z.getSearchEditText().setFocusableInTouchMode(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x01e5, code lost:
        
            if (r5.contains(B1.l.q0((java.lang.String) r12.first, ((java.lang.Integer) r12.second).intValue())) != false) goto L84;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 678
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.C0327t.e.run():void");
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$f */
    class f extends GridLayoutManager.c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C0598a f10686e;

        f(C0598a c0598a) {
            this.f10686e = c0598a;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i3) {
            int B02;
            if (this.f10686e.getItemViewType(i3) != 2 || (B02 = C0327t.this.B0()) > C0327t.this.f10647Y.Z2()) {
                return 1;
            }
            return B02;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$g */
    class g extends ViewOutlineProvider {
        g() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = view.getWidth();
            int height = view.getHeight();
            C0327t c0327t = C0327t.this;
            outline.setRoundRect(0, 0, width, height, c0327t.p0(24.0f, c0327t.f10664j.getResources()));
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$h */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0327t.this.f10677w.dismiss();
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$i */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0327t.this.f10628F = "";
            C0327t.this.f10680z.getSearchEditText().removeTextChangedListener(C0327t.this.f10660f0);
            C0327t.this.y1();
            C0327t.this.f10680z.f0(0);
            C0327t.this.f10680z.getSearchEditText().addTextChangedListener(C0327t.this.f10660f0);
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$j */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0327t.this.f10680z.f0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.t$k */
    class k extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            x1.s.a(C0327t.this.f10664j, 0, true);
            if (C0327t.this.f10654c0) {
                if (C0327t.f10622i0.booleanValue()) {
                    Log.d(C0327t.f10621h0, "onLongPress");
                }
                C0327t.this.f10658e0 = true;
                C0327t.this.o0();
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            C0601d o3;
            if (B1.s.w(C0327t.this.f10664j) && !B1.s.B()) {
                return false;
            }
            if (B1.s.w(C0327t.this.f10664j) && C0327t.this.f10668n.getAdapter().t() == 2) {
                C0327t c0327t = C0327t.this;
                if (c0327t.F1(c0327t.f10664j).S0()) {
                    OplusInputMethodManager.getInstance().hideCurrentInputMethod();
                }
            }
            com.coui.appcompat.poplist.k kVar = C0327t.this.f10677w;
            if ((kVar == null || !kVar.isShowing() || !C0327t.this.f10634L) && C0327t.this.f10667m != null && ((o3 = C0327t.this.f10668n.getContainerController().o()) == C0327t.this.f10669o || o3 == null)) {
                Handler mainThreadHandler = C0327t.this.f10664j.getMainThreadHandler();
                final C0327t c0327t2 = C0327t.this;
                mainThreadHandler.postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0327t.this.w1();
                    }
                }, 150L);
            }
            return false;
        }

        private k() {
        }
    }

    public C0327t(Context context) {
        this.f10664j = context;
        Resources resources = context.getResources();
        this.f10663i = new GestureDetector(context, new k(), new Handler(context.getMainLooper()));
        this.f10641S = new C0631a(ViewConfiguration.get(context), (WindowManager) context.getSystemService("window"));
        this.f10672r = new C0309c(context);
        this.f10671q = (resources.getConfiguration().uiMode & 32) != 0;
        this.f10649a = resources.getDimensionPixelSize(V1.c.f2538e);
        this.f10651b = resources.getDimensionPixelSize(V1.c.f2545l);
        this.f10653c = resources.getDimensionPixelSize(V1.c.f2544k);
        if (context == null || F1(context) == null) {
            return;
        }
        F1(context).x1(this);
    }

    private int A0() {
        return B1.s.w(this.f10664j) ? 16 : 24;
    }

    private void A1() {
        L0();
        this.f10625C.setVisibility(0);
        this.f10623A.setVisibility(8);
        this.f10624B.setVisibility(8);
        this.f10626D.setVisibility(0);
        this.f10626D.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B0() {
        return B1.s.w(this.f10664j) ? 4 : 5;
    }

    private void B1() {
        this.f10625C.setVisibility(8);
        this.f10623A.setVisibility(8);
        this.f10624B.setVisibility(0);
    }

    private void C0(boolean z3) {
        if (this.f10669o.p() != 1) {
            z1();
            return;
        }
        if ((B1.l.g0(this.f10668n, this.f10669o, this.f10664j) & 2) != 0) {
            z1();
            return;
        }
        if (z3 && !this.f10669o.u()) {
            this.f10672r.m(this.f10668n, this.f10669o, true);
        } else {
            if (z3 || !this.f10669o.u()) {
                return;
            }
            this.f10672r.m(this.f10668n, this.f10669o, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D0(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 9) {
            boolean H12 = this.f10668n.H1(motionEvent);
            if (f10622i0.booleanValue()) {
                Log.d(f10621h0, "handleHoverEvent hover enter, needScale=" + H12);
            }
            if (!H12) {
                this.f10656d0 = true;
                H1(false);
            }
        } else if (action == 10) {
            com.coui.appcompat.poplist.f fVar = this.f10670p;
            boolean z3 = fVar != null && fVar.isShowing();
            if (f10622i0.booleanValue()) {
                Log.d(f10621h0, "handleHoverEvent hover exit, mHandleHoverEnter=" + this.f10656d0 + ", isShowing=" + z3);
            }
            if (this.f10656d0 && !z3) {
                H1(true);
                this.f10656d0 = false;
            }
        }
        return !AccessibilityManager.getInstance(this.f10664j).isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (r0.d1() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
    
        if (r0 != 6) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean E0(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            r6 = 0
            if (r7 != 0) goto Lb
            java.lang.String r5 = com.oplus.pscanvas.canvasmode.canvas.C0327t.f10621h0
            java.lang.String r7 = "not handle down event because event = null"
            android.util.Log.d(r5, r7)
            return r6
        Lb:
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r0 = r5.f10668n
            com.oplus.pscanvas.canvasmode.canvas.E r0 = r0.f10732G
            if (r0 == 0) goto L1f
            boolean r0 = r0.e0()
            if (r0 == 0) goto L1f
            java.lang.String r5 = com.oplus.pscanvas.canvasmode.canvas.C0327t.f10621h0
            java.lang.String r7 = "not handle all events because isNeedWaitScrollTips is running"
            android.util.Log.d(r5, r7)
            return r6
        L1f:
            int r0 = r7.getActionMasked()
            if (r0 != 0) goto L57
            boolean r0 = com.oplus.pscanvas.canvasmode.canvas.C0332y.P(r7)
            if (r0 == 0) goto L33
            java.lang.String r5 = com.oplus.pscanvas.canvasmode.canvas.C0327t.f10621h0
            java.lang.String r7 = "not handle down event because isInjectEvent"
            android.util.Log.d(r5, r7)
            return r6
        L33:
            x1.u r0 = r5.f10642T
            if (r0 == 0) goto L3d
            boolean r0 = r0.F0()
            if (r0 != 0) goto L49
        L3d:
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r0 = r5.f10668n
            boolean r1 = r0.f10755S
            if (r1 != 0) goto L49
            boolean r0 = r0.d1()
            if (r0 == 0) goto L57
        L49:
            long r0 = r7.getDownTime()
            r5.f10650a0 = r0
            java.lang.String r5 = com.oplus.pscanvas.canvasmode.canvas.C0327t.f10621h0
            java.lang.String r7 = "not handle down event because isCurrentAnimationRun or duringTransform"
            android.util.Log.d(r5, r7)
            return r6
        L57:
            long r0 = r7.getDownTime()
            long r2 = r5.f10650a0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L69
            java.lang.String r5 = com.oplus.pscanvas.canvasmode.canvas.C0327t.f10621h0
            java.lang.String r7 = "not handle all events because isCurrentAnimationRun"
            android.util.Log.d(r5, r7)
            return r6
        L69:
            x1.a r0 = r5.f10641S
            r0.k(r7)
            android.view.GestureDetector r0 = r5.f10663i
            r0.onTouchEvent(r7)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto La2
            if (r0 == r1) goto L91
            r2 = 2
            if (r0 == r2) goto L89
            r2 = 3
            if (r0 == r2) goto L91
            r2 = 5
            if (r0 == r2) goto La2
            r2 = 6
            if (r0 == r2) goto L91
            goto Ld3
        L89:
            boolean r6 = r5.f10654c0
            if (r6 == 0) goto Ld3
            r5.m0(r7)
            goto Ld3
        L91:
            boolean r0 = r5.f10654c0
            if (r0 == 0) goto Ld3
            r5.G1(r1)
            r5.n0(r7)
            r2 = -1
            r5.f10650a0 = r2
            r5.f10654c0 = r6
            goto Ld3
        La2:
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r0 = r5.f10668n
            boolean r0 = r0.H1(r7)
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r2 = r5.f10668n
            com.oplus.pscanvas.canvasmode.canvas.r0 r2 = r2.getContainerController()
            u1.d r2 = r2.o()
            u1.d r3 = r5.f10669o
            if (r2 == r3) goto Lc3
            if (r0 != 0) goto Lc3
            com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r3 = r5.f10668n
            com.oplus.pscanvas.canvasmode.canvas.r0 r3 = r3.getContainerController()
            u1.d r4 = r5.f10669o
            r3.G(r4)
        Lc3:
            u1.d r3 = r5.f10669o
            if (r2 == r3) goto Lc9
            if (r0 != 0) goto Ld3
        Lc9:
            r5.f10654c0 = r1
            r5.f10658e0 = r6
            r5.G1(r6)
            r5.l0(r7)
        Ld3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.C0327t.E0(android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContainerActivity F1(Context context) {
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ContainerActivity) context;
    }

    private void G1(final boolean z3) {
        if (this.f10659f == null) {
            return;
        }
        AnimatorSet animatorSet = this.f10662h;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f10662h.cancel();
            if (f10622i0.booleanValue()) {
                Log.d(f10621h0, "updateControlBarBg cancel mControlBarBgAnimatorForHover");
            }
        }
        if (f10622i0.booleanValue()) {
            Log.d(f10621h0, "updateControlBarBg hide=" + z3 + " getAlpha=" + this.f10659f.getAlpha());
        }
        if (z3 && this.f10659f.getAlpha() == 0.0f) {
            this.f10664j.getMainThreadHandler().postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.o
                @Override // java.lang.Runnable
                public final void run() {
                    C0327t.this.g1(z3);
                }
            }, 30L);
            return;
        }
        AnimatorSet animatorSet2 = this.f10661g;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.f10661g.cancel();
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f10661g = animatorSet3;
        I1(z3, animatorSet3);
    }

    private void H0() {
        PopupWindow popupWindow = this.f10635M;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void H1(boolean z3) {
        if (this.f10659f == null) {
            return;
        }
        AnimatorSet animatorSet = this.f10661g;
        if (animatorSet == null || !animatorSet.isRunning()) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f10662h = animatorSet2;
            I1(z3, animatorSet2);
            return;
        }
        if (f10622i0.booleanValue()) {
            Log.d(f10621h0, "updateControlBarBgForHover need return, mLongPressedForHover=" + this.f10658e0);
        }
        if (this.f10658e0) {
            this.f10661g.cancel();
            this.f10658e0 = false;
        }
    }

    private void I1(boolean z3, AnimatorSet animatorSet) {
        ImageView imageView = this.f10659f;
        if (imageView == null) {
            return;
        }
        float f3 = this.f10671q ? 0.2f : 0.1f;
        Property property = View.ALPHA;
        float f4 = z3 ? f3 : 0.0f;
        if (z3) {
            f3 = 0.0f;
        }
        animatorSet.playTogether(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, f4, f3), ObjectAnimator.ofFloat(this.f10659f, (Property<ImageView, Float>) View.SCALE_X, z3 ? 1.0f : 0.625f, z3 ? 0.625f : 1.0f));
        animatorSet.setDuration(217L);
        animatorSet.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
        animatorSet.start();
    }

    private void K0() {
        this.f10631I = o1();
        this.f10629G = B1.s.j(this.f10664j);
        this.f10630H = B1.s.h(this.f10664j);
        int i3 = this.f10664j.getResources().getConfiguration().windowConfiguration.getBounds().bottom - this.f10668n.getWindowMetricsBounds().bottom;
        Rect rect = new Rect();
        Window window = B1.l.O1(this.f10664j).getWindow();
        if (B1.s.w(this.f10664j) && window != null && window.getDecorView().getRootWindowInsets() != null) {
            rect = window.getDecorView().getRootWindowInsets().getInsets(WindowInsets.Type.navigationBars()).toRect();
            if (i3 == 0) {
                i3 = rect.height();
            }
        }
        int G02 = B1.l.O1(this.f10664j).G0();
        f0(i3, G02);
        FrameLayout frameLayout = new FrameLayout(this.f10664j);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10678x = LayoutInflater.from(this.f10664j).inflate(t1.h.f13472e, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f10632J, this.f10633K);
        layoutParams.gravity = 0;
        if (!B1.s.w(this.f10664j)) {
            layoutParams.leftMargin = (this.f10629G - this.f10632J) / 2;
            layoutParams.topMargin = ((((this.f10630H - i3) - G02) - this.f10633K) / 2) + G02;
        } else if (B1.s.i(this.f10664j.getResources().getConfiguration()) == 1) {
            layoutParams.leftMargin = (this.f10629G - this.f10632J) / 2;
            layoutParams.topMargin = G02 + p0(24.0f, this.f10664j.getResources());
        } else {
            layoutParams.leftMargin = (((this.f10629G - Math.abs(rect.width())) - this.f10632J) + rect.width()) / 2;
            layoutParams.topMargin = (this.f10630H - this.f10633K) / 2;
        }
        this.f10678x.setLayoutParams(layoutParams);
        this.f10678x.setSystemUiVisibility(772);
        this.f10678x.setOutlineProvider(new g());
        this.f10678x.setClipToOutline(true);
        this.f10678x.setElevation(p0(12.0f, this.f10664j.getResources()));
        frameLayout.addView(this.f10678x);
        com.coui.appcompat.poplist.k kVar = new com.coui.appcompat.poplist.k(frameLayout, -1, -1);
        this.f10677w = kVar;
        kVar.setBackgroundDrawable(null);
        this.f10677w.setFocusable(true);
        this.f10677w.setAnimationStyle(t1.k.f13679c);
        this.f10677w.setWindowLayoutType(2038);
        this.f10677w.h(true);
        this.f10677w.setSplitTouchEnabled(false);
        this.f10677w.setIsLaidOutInScreen(true);
        this.f10677w.setFocusable(true);
        frameLayout.setOnClickListener(new h());
        this.f10677w.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.q
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                C0327t.this.a1();
            }
        });
        this.f10677w.showAtLocation(this.f10668n, 17, 0, 0);
        final AppBarLayout appBarLayout = (AppBarLayout) this.f10678x.findViewById(t1.f.f13447g);
        if (B1.d.f(this.f10664j)) {
            this.f10678x.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.r
                @Override // java.lang.Runnable
                public final void run() {
                    C0327t.this.b1(appBarLayout);
                }
            });
        }
        COUISearchBar cOUISearchBar = (COUISearchBar) this.f10678x.findViewById(t1.f.f13433M);
        this.f10680z = cOUISearchBar;
        cOUISearchBar.setSearchAnimateType(0);
        this.f10680z.d0(new COUISearchBar.g() { // from class: com.oplus.pscanvas.canvasmode.canvas.s
            @Override // com.coui.appcompat.searchview.COUISearchBar.g
            public final void a(int i4, int i5) {
                C0327t.this.Y0(i4, i5);
            }
        });
        this.f10680z.getSearchEditText().addTextChangedListener(this.f10660f0);
        this.f10680z.getFunctionalButton().setOnClickListener(new i());
        this.f10680z.setOnClickListener(new j());
        this.f10680z.setInputMethodAnimationEnabled(false);
        this.f10625C = (ViewStub) this.f10678x.findViewById(t1.f.f13465y);
        this.f10623A = (COUIRecyclerView) this.f10678x.findViewById(t1.f.f13442b);
        this.f10637O = this.f10678x.findViewById(t1.f.f13441a);
        this.f10639Q = AnimationUtils.loadAnimation(this.f10664j, AbstractC0587a.f13359a);
        this.f10678x.findViewById(t1.f.f13427G).startAnimation(this.f10639Q);
        O0(this.f10623A, this.f10675u, false);
        this.f10634L = true;
        h1();
        x1(rect);
    }

    private void L0() {
        if (this.f10627E == null) {
            View inflate = this.f10625C.inflate();
            this.f10627E = inflate;
            EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) inflate.findViewById(t1.f.f13464x);
            this.f10626D = effectiveAnimationView;
            effectiveAnimationView.setCacheComposition(false);
            if ((this.f10664j.getResources().getConfiguration().uiMode & 32) != 0) {
                this.f10626D.setAnimation(t1.i.f13567j1);
            } else {
                this.f10626D.setAnimation(t1.i.f13570k1);
            }
        }
    }

    private Drawable L1(Drawable drawable, float f3) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0 || f3 <= 0.0f || Float.isInfinite(f3)) {
            Log.e(f10621h0, "invalid parameter, can not zoom the drawable");
            return null;
        }
        Bitmap q02 = q0(drawable, intrinsicWidth, intrinsicHeight);
        Matrix matrix = new Matrix();
        matrix.postScale(f3, f3);
        return new BitmapDrawable(this.f10664j.getResources(), Bitmap.createBitmap(q02, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true));
    }

    private void M0() {
        com.coui.appcompat.poplist.f fVar = new com.coui.appcompat.poplist.f(this.f10664j);
        this.f10670p = fVar;
        fVar.setBackgroundDrawable(null);
        this.f10670p.setWindowLayoutType(2008);
        this.f10670p.h(true);
        this.f10670p.setSplitTouchEnabled(false);
        this.f10670p.setIsLaidOutInScreen(true);
        this.f10670p.setFocusable(true);
        this.f10670p.setInputMethodMode(2);
        this.f10670p.o0(false, false);
        Context context = this.f10664j;
        if (context == null || F1(context) == null) {
            return;
        }
        F1(this.f10664j).t1(this.f10670p, this);
    }

    private void N0() {
        ArrayList arrayList = this.f10645W;
        if (arrayList == null) {
            this.f10645W = new ArrayList();
        } else {
            arrayList.clear();
        }
        Log.d(f10621h0, "initPopupList mTaskData " + this.f10669o);
        int t02 = this.f10668n.t0(this.f10669o);
        boolean U02 = this.f10668n.U0(t02, this.f10669o);
        boolean V02 = this.f10668n.V0(t02);
        if (B1.s.H()) {
            e0(U02, V02);
        } else if (B1.s.w(this.f10664j)) {
            d0(V02);
        } else {
            c0(U02, V02);
        }
    }

    private void O0(RecyclerView recyclerView, final List list, boolean z3) {
        list.clear();
        recyclerView.setItemAnimator(null);
        C0598a c0598a = new C0598a(list, this.f10664j);
        c0598a.i(!z3);
        c0598a.j(new C0598a.e() { // from class: com.oplus.pscanvas.canvasmode.canvas.e
            @Override // u1.C0598a.e
            public final void a(View view, int i3) {
                C0327t.this.c1(list, view, i3);
            }
        });
        float p02 = p0(A0(), this.f10664j.getResources());
        c0598a.h((int) (((this.f10632J - (2.0f * p02)) - (this.f10664j.getResources().getDimension(t1.d.f13373b) * B0())) / (B0() * 2)));
        recyclerView.setAdapter(c0598a);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f10664j, B0(), 1, false);
        this.f10647Y = gridLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
        int i3 = (int) p02;
        marginLayoutParams.setMarginStart(i3);
        marginLayoutParams.setMarginEnd(i3);
        recyclerView.setLayoutParams(marginLayoutParams);
        f fVar = new f(c0598a);
        fVar.j(false);
        fVar.i(false);
        this.f10647Y.h3(fVar);
    }

    private void P0() {
        if (this.f10624B != null) {
            return;
        }
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) this.f10678x.findViewById(t1.f.f13434N);
        this.f10624B = cOUIRecyclerView;
        cOUIRecyclerView.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.g
            @Override // java.lang.Runnable
            public final void run() {
                C0327t.this.d1();
            }
        });
    }

    private boolean S0(String str, String str2) {
        String replace = str2.toLowerCase().replace(" ", "");
        if (replace.contains(str)) {
            return true;
        }
        String e3 = G0.b.e(replace, " ");
        String str3 = "";
        for (String str4 : e3.split(" ")) {
            if (!str4.isEmpty()) {
                str3 = str3 + str4.charAt(0);
            }
        }
        return e3.toUpperCase().replace(" ", "").contains(str.toUpperCase()) || str3.toUpperCase().contains(str.toUpperCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(String str, C0598a.b bVar) {
        if (bVar.e() == 4 && S0(str, bVar.c())) {
            this.f10674t.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U0() {
        Runtime.getRuntime().gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0() {
        PopupWindow popupWindow = this.f10635M;
        if (popupWindow != null && popupWindow.getContentView() != null) {
            this.f10635M.getContentView().setAlpha(0.0f);
            this.f10635M.dismiss();
        }
        com.coui.appcompat.poplist.k kVar = this.f10677w;
        if (kVar != null) {
            kVar.setExitTransition(null);
            this.f10647Y.m1();
            this.f10677w.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0() {
        com.coui.appcompat.poplist.f fVar = this.f10670p;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(View view) {
        ContainerView containerView = this.f10668n;
        if (!containerView.f10755S && !containerView.d1()) {
            w1();
            return;
        }
        Log.d(f10621h0, "setOnClickListener:" + this.f10668n.f10755S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(int i3, int i4) {
        if (i3 == 0 && i4 == 1) {
            this.f10680z.c1(true);
            P0();
            B1();
        } else if (i3 == 1 && i4 == 0) {
            this.f10680z.c1(false);
            this.f10674t.clear();
            COUIRecyclerView cOUIRecyclerView = this.f10624B;
            if (cOUIRecyclerView == null || cOUIRecyclerView.getAdapter() == null) {
                return;
            }
            this.f10624B.getAdapter().notifyDataSetChanged();
            y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        H0();
        n1();
    }

    private com.coui.appcompat.poplist.s a0() {
        if (B1.s.w(this.f10664j) || this.f10668n.getAdapter().getCount() != 2) {
            return null;
        }
        this.f10668n.s2();
        return new s.a().C(t1.e.f13404j).D(1).I(this.f10664j.getResources().getString(t1.j.f13639g)).F(true).x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1() {
        Handler.getMain().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.f
            @Override // java.lang.Runnable
            public final void run() {
                C0327t.this.Z0();
            }
        });
    }

    private com.coui.appcompat.poplist.s b0() {
        C0601d c0601d;
        if (B1.s.w(this.f10664j) || (c0601d = this.f10669o) == null || c0601d.s() <= 0 || this.f10669o.k() == null) {
            return null;
        }
        synchronized (B1.l.f217q) {
            try {
                if (!B1.l.f217q.containsKey(this.f10669o.k())) {
                    B1.l.O0(this.f10669o.k());
                }
                Boolean bool = (Boolean) B1.l.f217q.get(this.f10669o.k());
                if (bool == null || !bool.booleanValue()) {
                    return null;
                }
                return new s.a().C(t1.e.f13412r).I(this.f10664j.getResources().getString(t1.j.f13635e)).F(true).z(1).x();
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(AppBarLayout appBarLayout) {
        B1.d.h(this.f10678x, this.f10664j);
        appBarLayout.setBackground(null);
    }

    private void c0(boolean z3, boolean z4) {
        s.a aVar = new s.a();
        com.coui.appcompat.poplist.s sVar = null;
        if (this.f10669o.D() && !this.f10669o.B()) {
            Rect rect = new Rect(this.f10669o.f13810a);
            boolean z5 = rect.width() <= rect.height();
            if ((!this.f10668n.j1() || z5) && (!this.f10668n.m1() || !z5)) {
                if (this.f10669o.u()) {
                    sVar = aVar.C(this.f10669o.I() ? t1.e.f13409o : t1.e.f13410p).I(this.f10664j.getResources().getString(t1.j.f13624X)).F(!z3).z(0).x();
                } else {
                    sVar = aVar.C(this.f10669o.I() ? t1.e.f13407m : t1.e.f13408n).I(this.f10664j.getResources().getString(t1.j.f13623W)).F(!z3).z(0).x();
                }
            }
        } else if (this.f10668n.k1() && this.f10669o.B()) {
            if (B1.s.A(this.f10669o, this.f10666l, this.f10668n)) {
                sVar = aVar.C(this.f10668n.j1() ? t1.e.f13407m : t1.e.f13408n).I(this.f10664j.getResources().getString(t1.j.f13623W)).F(!z3).z(0).x();
            } else {
                sVar = aVar.C(this.f10668n.j1() ? t1.e.f13409o : t1.e.f13410p).I(this.f10664j.getResources().getString(t1.j.f13624X)).F(!z3).z(0).x();
            }
        }
        if (B1.l.x0(this.f10669o) && sVar != null) {
            sVar.B(false);
        }
        com.coui.appcompat.poplist.s x3 = aVar.C(t1.e.f13395a).I(this.f10664j.getResources().getString(t1.j.f13625Y)).F(true).z(1).x();
        com.coui.appcompat.poplist.s x4 = aVar.C(t1.e.f13411q).I(this.f10664j.getResources().getString(t1.j.f13633d)).F(true).z(0).x();
        com.coui.appcompat.poplist.s a02 = a0();
        com.coui.appcompat.poplist.s x5 = aVar.C(t1.e.f13394B).I(this.f10664j.getResources().getString(t1.j.f13637f)).F(j0() && !z4).z(0).x();
        com.coui.appcompat.poplist.s x6 = aVar.C(t1.e.f13406l).I(this.f10664j.getResources().getString(t1.j.f13631c)).F(true).z(0).x();
        com.coui.appcompat.poplist.s b02 = b0();
        this.f10645W.add(x4);
        if (a02 != null) {
            this.f10645W.add(a02);
        }
        this.f10645W.add(x5);
        if (sVar != null) {
            this.f10645W.add(sVar);
        }
        this.f10645W.add(x6);
        if (b02 != null) {
            this.f10645W.add(b02);
        }
        this.f10645W.add(x3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(List list, View view, int i3) {
        String d3 = ((C0598a.b) list.get(i3)).d();
        int f3 = ((C0598a.b) list.get(i3)).f();
        if (w0().contains(B1.l.q0(d3, f3))) {
            return;
        }
        this.f10668n.f10755S = true;
        Intent Y2 = B1.l.Y(this.f10664j, d3, f3);
        Y2.addFlags(262144);
        Y2.putExtra("androidx.flexible.userId", f3);
        this.f10672r.l("menu_replace");
        this.f10672r.n(this.f10668n, Y2, -1, f3, -1);
        this.f10677w.dismiss();
    }

    private void d0(boolean z3) {
        boolean z4;
        String string;
        int i3;
        com.coui.appcompat.poplist.s x3;
        com.coui.appcompat.poplist.s sVar;
        s.a aVar = new s.a();
        boolean z5 = false;
        if (this.f10669o.p() != 1) {
            int t3 = this.f10668n.getAdapter().t();
            if (this.f10669o.y()) {
                i3 = t3 == 2 ? t1.e.f13407m : t1.e.f13408n;
                string = this.f10664j.getResources().getString(t1.j.f13623W);
            } else {
                if (h0(this.f10669o)) {
                    i3 = t1.e.f13407m;
                    string = this.f10664j.getResources().getString(t1.j.f13623W);
                } else if (i0(this.f10669o)) {
                    i3 = t1.e.f13409o;
                    string = this.f10664j.getResources().getString(t1.j.f13624X);
                } else if (this.f10669o.I()) {
                    i3 = t1.e.f13410p;
                    string = this.f10664j.getResources().getString(t1.j.f13624X);
                } else {
                    z4 = false;
                    int i4 = t3 == 2 ? t1.e.f13409o : t1.e.f13408n;
                    string = t3 == 2 ? this.f10664j.getResources().getString(t1.j.f13624X) : this.f10664j.getResources().getString(t1.j.f13623W);
                    i3 = i4;
                    x3 = aVar.C(i3).I(string).F(z4).x();
                }
                z4 = true;
                x3 = aVar.C(i3).I(string).F(z4).x();
            }
            z4 = false;
            x3 = aVar.C(i3).I(string).F(z4).x();
        } else if (this.f10669o.u()) {
            x3 = aVar.C(this.f10668n.m1() ? t1.e.f13410p : t1.e.f13409o).I(this.f10664j.getResources().getString(t1.j.f13624X)).F(true).x();
        } else {
            x3 = aVar.C(this.f10668n.m1() ? t1.e.f13408n : t1.e.f13407m).I(this.f10664j.getResources().getString(t1.j.f13623W)).F(true).x();
        }
        if (B1.l.x0(this.f10669o) && x3 != null) {
            x3.B(false);
        }
        com.coui.appcompat.poplist.s x4 = aVar.C(t1.e.f13411q).I(this.f10664j.getResources().getString(t1.j.f13633d)).F(true).x();
        boolean z6 = B1.d.f169e;
        if (z6) {
            sVar = null;
        } else {
            if (j0() && !z3) {
                z5 = true;
            }
            sVar = aVar.C(t1.e.f13394B).I(this.f10664j.getResources().getString(t1.j.f13637f)).F(z5).x();
        }
        com.coui.appcompat.poplist.s x5 = aVar.C(t1.e.f13395a).I(this.f10664j.getResources().getString(t1.j.f13625Y)).F(true).x();
        com.coui.appcompat.poplist.s x6 = aVar.C(t1.e.f13406l).I(this.f10664j.getResources().getString(t1.j.f13631c)).F(true).x();
        this.f10645W.add(x4);
        if (!z6) {
            this.f10645W.add(sVar);
        }
        if (x3 != null) {
            x3.D(this.f10664j.getColor(AbstractC0589c.f13362a));
            this.f10645W.add(x3);
        }
        this.f10645W.add(x5);
        this.f10645W.add(x6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1() {
        O0(this.f10624B, this.f10674t, true);
    }

    private void e0(boolean z3, boolean z4) {
        com.coui.appcompat.poplist.s sVar;
        s.a aVar = new s.a();
        if (!this.f10669o.D() || this.f10669o.B()) {
            if (!this.f10668n.k1() || !this.f10669o.B()) {
                sVar = null;
            } else if (B1.s.A(this.f10669o, this.f10666l, this.f10668n)) {
                sVar = aVar.C(this.f10668n.j1() ? t1.e.f13407m : t1.e.f13408n).I(this.f10664j.getResources().getString(t1.j.f13623W)).F(!z3).z(0).x();
            } else {
                sVar = aVar.C(this.f10668n.j1() ? t1.e.f13410p : t1.e.f13409o).I(this.f10664j.getResources().getString(t1.j.f13624X)).F(!z3).z(0).x();
            }
        } else if (this.f10669o.u()) {
            sVar = aVar.C(this.f10669o.I() ? t1.e.f13410p : t1.e.f13409o).I(this.f10664j.getResources().getString(t1.j.f13624X)).F(!z3).z(0).x();
        } else {
            sVar = aVar.C(this.f10669o.I() ? t1.e.f13407m : t1.e.f13408n).I(this.f10664j.getResources().getString(t1.j.f13623W)).F(!z3).z(0).x();
        }
        if (B1.l.x0(this.f10669o) && sVar != null) {
            sVar.B(false);
        }
        com.coui.appcompat.poplist.s x3 = aVar.C(t1.e.f13411q).I(this.f10664j.getResources().getString(t1.j.f13633d)).F(true).z(0).x();
        com.coui.appcompat.poplist.s a02 = f10620g0 ? null : a0();
        com.coui.appcompat.poplist.s x4 = aVar.C(t1.e.f13394B).I(this.f10664j.getResources().getString(t1.j.f13637f)).F(j0() && !z4).z(0).x();
        com.coui.appcompat.poplist.s x5 = aVar.C(t1.e.f13395a).I(this.f10664j.getResources().getString(t1.j.f13625Y)).F(true).z(1).x();
        com.coui.appcompat.poplist.s x6 = aVar.C(t1.e.f13406l).I(this.f10664j.getResources().getString(t1.j.f13631c)).F(true).z(0).x();
        com.coui.appcompat.poplist.s b02 = b0();
        this.f10645W.add(x3);
        if (a02 != null) {
            this.f10645W.add(a02);
        }
        this.f10645W.add(x4);
        if (sVar != null) {
            this.f10645W.add(sVar);
        }
        this.f10645W.add(x6);
        if (b02 != null) {
            this.f10645W.add(b02);
        }
        this.f10645W.add(x5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(int i3, int i4) {
        COUIRecyclerView cOUIRecyclerView;
        if (!this.f10634L || (cOUIRecyclerView = this.f10623A) == null || cOUIRecyclerView.getAdapter() == null || this.f10637O == null || this.f10680z == null || this.f10638P == null) {
            return;
        }
        this.f10623A.getAdapter().notifyItemRangeChanged(i3, i4);
    }

    private void f0(int i3, int i4) {
        if (!B1.s.w(this.f10664j)) {
            Context context = this.f10664j;
            this.f10632J = new ResponsiveUIModel(context, l1(this.f10629G, context), l1(this.f10630H, this.f10664j)).chooseMargin(y0(this.f10631I)).calculateGridWidth(6);
            this.f10633K = Math.min(((this.f10630H - (p0(64.0f, this.f10664j.getResources()) * 2)) - i3) - i4, p0(u0(), this.f10664j.getResources()));
            return;
        }
        int i5 = this.f10629G;
        if (i5 > this.f10630H) {
            this.f10632J = p0(396.0f, this.f10664j.getResources());
            this.f10633K = this.f10630H - p0(32.0f, this.f10664j.getResources());
            return;
        }
        this.f10632J = i5 - p0(32.0f, this.f10664j.getResources());
        int p02 = ((this.f10630H - i3) - i4) - (p0(24.0f, this.f10664j.getResources()) * 2);
        this.f10633K = p02;
        if (p02 > p0(u0(), this.f10664j.getResources())) {
            this.f10633K = p0(u0(), this.f10664j.getResources());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1() {
        if (this.f10624B == null || this.f10674t.isEmpty()) {
            return;
        }
        this.f10624B.getAdapter().notifyDataSetChanged();
    }

    private float g0(Rect rect, int i3) {
        if (i3 < 0 || i3 >= this.f10668n.getAdapter().getCount()) {
            i3 = this.f10668n.getContainerController().u(this.f10669o);
        }
        List a02 = B1.l.a0(this.f10664j, this.f10668n.getRectList(), this.f10668n.getAdapter().n(), this.f10668n.getAdapter().u(), i3);
        if (a02 != null) {
            return 1.0f / ((RectF) a02.get(a02.size() - 1)).right;
        }
        if (rect == null || rect.isEmpty()) {
            return 1.0f;
        }
        return Math.min(this.f10666l.getWidth() / rect.width(), this.f10666l.getHeight() / rect.height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(boolean z3) {
        AnimatorSet animatorSet = this.f10661g;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f10661g.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f10661g = animatorSet2;
        I1(z3, animatorSet2);
    }

    private boolean h0(C0601d c0601d) {
        if (c0601d == null) {
            return false;
        }
        return !c0601d.u() && !c0601d.d().equals(c0601d.i()) && this.f10668n.getAdapter().w() && (this.f10668n.getAdapter().t() == 2 && ActivityInfo.isFixedOrientationLandscape(c0601d.j()));
    }

    private void h1() {
        this.f10638P = C0305a.a().c(new e());
    }

    private boolean i0(C0601d c0601d) {
        if (c0601d == null) {
            return false;
        }
        return c0601d.u() && !c0601d.d().equals(c0601d.i()) && this.f10668n.getAdapter().w() && (this.f10668n.getAdapter().t() == 2 && ActivityInfo.isFixedOrientationLandscape(c0601d.j()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(PackageManager packageManager, int i3, List list) {
        final int i4;
        final int i5;
        int size = list.size();
        int B02 = this.f10673s.size() != 0 ? B0() + 2 : 1;
        int B03 = B0() * 2;
        int i6 = 1;
        for (int i7 = B02; i7 < size; i7++) {
            try {
            } catch (Exception e3) {
                Log.d(f10621h0, "app list window is showing ? -->" + this.f10634L + "\nload icon in background failed," + e3);
            }
            if (!this.f10634L) {
                return;
            }
            ((C0598a.b) list.get(i7)).h(B1.l.O(this.f10664j, B1.l.q0(((C0598a.b) list.get(i7)).d(), ((C0598a.b) list.get(i7)).f())));
            if (((i7 - B02) + 1) / B03 == i6 || i7 == size - 1) {
                if (i7 == size - 1) {
                    i5 = (size - B02) % B03;
                    if (i5 == 0) {
                        i5 = B03;
                    }
                    i4 = (i7 - i5) + 1;
                } else {
                    i4 = (i7 - B03) + 1;
                    i5 = B03;
                }
                F1(this.f10664j).runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0327t.this.e1(i4, i5);
                    }
                });
                i6++;
            }
            if (i7 % 50 == 0 || i7 == size - 1) {
                F1(this.f10664j).runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0327t.this.f1();
                    }
                });
                t0();
            }
        }
        t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List j1() {
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls = Class.forName("com.oplus.splitscreen.OplusSplitScreenManagerInternal");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Method declaredMethod2 = cls.getDeclaredMethod("getRecentUsedAppWithMultiApp", Integer.TYPE, Long.TYPE, Boolean.TYPE, List.class);
            declaredMethod2.setAccessible(true);
            return (List) declaredMethod2.invoke(invoke, Integer.valueOf(z0()), 172800000L, Boolean.TRUE, null);
        } catch (Exception e3) {
            Log.d(f10621h0, "obtainRecentAppList failed," + e3);
            return arrayList;
        }
    }

    private void l0(MotionEvent motionEvent) {
        this.f10644V = motionEvent.getPointerId(0);
        if (this.f10668n.i1()) {
            if (this.f10643U == null) {
                this.f10643U = new x1.y(this.f10664j, this.f10668n);
            }
            this.f10643U.e(this.f10640R);
            this.f10643U.b(this.f10641S, motionEvent);
        }
        if (this.f10668n.k1()) {
            if (this.f10642T == null) {
                this.f10642T = new x1.u(this.f10664j);
            }
            t1();
            this.f10642T.A0(this.f10640R);
            this.f10668n.f10757U = false;
            this.f10642T.J0(this.f10641S);
        }
    }

    private float l1(float f3, Context context) {
        return f3 / context.getResources().getDisplayMetrics().density;
    }

    private void m0(MotionEvent motionEvent) {
        x1.u uVar;
        x1.y yVar;
        if (motionEvent.findPointerIndex(this.f10644V) == -1) {
            Log.e(f10621h0, "Invalid active pointer id on MOVE: " + this.f10644V);
            return;
        }
        if (this.f10668n.i1() && (yVar = this.f10643U) != null) {
            yVar.c(this.f10641S, motionEvent);
        }
        if (!this.f10668n.k1() || (uVar = this.f10642T) == null) {
            return;
        }
        uVar.K0(this.f10641S);
    }

    private void n0(MotionEvent motionEvent) {
        x1.u uVar;
        motionEvent.findPointerIndex(this.f10644V);
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (pointerId != this.f10644V) {
            Log.e("draganim", "Invalid active pointer id on UP: " + pointerId + " mActivePointerId:" + this.f10644V);
            return;
        }
        if (this.f10668n.i1()) {
            this.f10643U.d(this.f10641S);
        }
        if (!this.f10668n.k1() || (uVar = this.f10642T) == null) {
            return;
        }
        this.f10668n.f10757U = true;
        uVar.L0(this.f10641S);
    }

    private void n1() {
        this.f10677w = null;
        this.f10678x = null;
        this.f10679y = null;
        this.f10623A.removeAllViews();
        this.f10623A = null;
        this.f10647Y.m1();
        COUIRecyclerView cOUIRecyclerView = this.f10624B;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.removeAllViews();
        }
        this.f10624B = null;
        this.f10625C = null;
        EffectiveAnimationView effectiveAnimationView = this.f10626D;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.i();
            this.f10626D.clearAnimation();
            this.f10626D = null;
        }
        this.f10627E = null;
        this.f10628F = "";
        this.f10632J = 0;
        this.f10634L = false;
        this.f10635M = null;
        this.f10636N = null;
        this.f10637O = null;
        Future future = this.f10638P;
        if (future != null) {
            future.cancel(true);
            this.f10638P = null;
        }
        Animation animation = this.f10639Q;
        if (animation != null) {
            animation.cancel();
            this.f10639Q = null;
        }
        this.f10673s.clear();
        this.f10674t.clear();
        this.f10675u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        x1.y yVar;
        x1.u uVar;
        if (this.f10668n.k1() && (uVar = this.f10642T) != null) {
            uVar.I0();
        }
        if (!this.f10668n.i1() || (yVar = this.f10643U) == null) {
            return;
        }
        yVar.h();
    }

    private int o1() {
        return p1(B1.s.e(this.f10664j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p0(float f3, Resources resources) {
        return (int) TypedValue.applyDimension(1, f3, resources.getDisplayMetrics());
    }

    private int p1(int i3) {
        if (i3 <= 600) {
            return 1;
        }
        return i3 <= 840 ? 2 : 3;
    }

    private Bitmap q0(Drawable drawable, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        if (drawable == null) {
            Log.e(f10621h0, "drawable = null, drawableToBitmap failed");
            return createBitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i3, i4);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            if (!this.f10674t.isEmpty()) {
                this.f10674t.clear();
                this.f10624B.getAdapter().notifyDataSetChanged();
            }
            B1();
            this.f10628F = "";
            return;
        }
        final String trim = str.toLowerCase().replace(" ", "").trim();
        if (trim.equals(this.f10628F)) {
            return;
        }
        this.f10674t.clear();
        this.f10675u.forEach(new Consumer() { // from class: com.oplus.pscanvas.canvasmode.canvas.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C0327t.this.T0(trim, (C0598a.b) obj);
            }
        });
        this.f10674t.sort(this.f10676v);
        if (this.f10674t.size() == 0) {
            A1();
        } else {
            this.f10624B.getAdapter().notifyDataSetChanged();
            B1();
        }
        this.f10628F = trim;
    }

    private boolean s0(EmbeddedViewDecor embeddedViewDecor) {
        return this.f10668n.getContainerController().q() == 2 && (embeddedViewDecor.getTaskData().B() && !embeddedViewDecor.getTaskData().u());
    }

    private void t0() {
        F1(this.f10664j).runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.j
            @Override // java.lang.Runnable
            public final void run() {
                C0327t.U0();
            }
        });
    }

    private void t1() {
        try {
            if (this.f10669o.s() > 0) {
                ActivityTaskManager.getService().setFocusedTask(this.f10669o.s());
            }
        } catch (Exception unused) {
            Log.e(f10621h0, "set focus task failed");
        }
    }

    private int u0() {
        return B1.s.w(this.f10664j) ? 600 : 800;
    }

    private Drawable v0(int i3, int i4, float f3, StringBuilder sb, int i5, EmbeddedViewDecor embeddedViewDecor, boolean z3) {
        sb.append("lastLight: ");
        sb.append(i5);
        if (s0(embeddedViewDecor)) {
            sb.append(" forceUseLightControlBar");
            i5 = 0;
        }
        Drawable drawable = i5 != 0 ? i5 != 1 ? !this.f10671q ? (i3 != i4 || z3) ? this.f10664j.getResources().getDrawable(t1.e.f13401g) : this.f10664j.getResources().getDrawable(t1.e.f13399e) : (i3 != i4 || z3) ? this.f10664j.getResources().getDrawable(t1.e.f13402h) : this.f10664j.getResources().getDrawable(t1.e.f13400f) : (i3 != i4 || z3) ? this.f10664j.getResources().getDrawable(t1.e.f13401g) : this.f10664j.getResources().getDrawable(t1.e.f13399e) : (i3 != i4 || z3) ? this.f10664j.getResources().getDrawable(t1.e.f13402h) : this.f10664j.getResources().getDrawable(t1.e.f13400f);
        sb.append(", isFocus: ");
        sb.append(i3 == i4);
        sb.append(", curIndex: ");
        sb.append(i4);
        sb.append(", focusIndex: ");
        sb.append(i3);
        sb.append(", isDarkMode: ");
        sb.append(this.f10671q);
        if (Math.abs(f3 - 1.0f) <= 1.0E-6f) {
            return drawable;
        }
        sb.append(", minScale: ");
        sb.append(f3);
        sb.append(", zoomDrawable");
        return L1(drawable, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        com.coui.appcompat.poplist.k kVar = this.f10677w;
        if (kVar == null || !kVar.isShowing()) {
            K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set w0() {
        HashSet hashSet = new HashSet();
        r0 containerController = this.f10668n.getContainerController();
        int k3 = containerController.k();
        for (int i3 = 0; i3 < k3; i3++) {
            C0601d l3 = containerController.l(i3);
            hashSet.add(B1.l.q0(l3.k(), l3.v()));
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        com.coui.appcompat.poplist.f fVar = this.f10670p;
        if (fVar != null && fVar.isShowing()) {
            Log.i(f10621h0, "control bar menu is showing");
            this.f10670p.dismiss();
        }
        Context context = this.f10664j;
        if (context == null || ((ContainerActivity) context).isFinishing()) {
            Log.i(f10621h0, "showControlBarMenu invalid context");
            return;
        }
        OplusInputMethodManager.getInstance().hideCurrentInputMethod();
        if (this.f10668n.getAdapter().h() < 0) {
            Log.w(f10621h0, "showControlBarMenu invalid focusIndex.");
            return;
        }
        M0();
        N0();
        this.f10670p.k0(this.f10645W);
        this.f10670p.p0(new c());
        Rect rect = new Rect();
        this.f10666l.getBoundsOnScreen(rect);
        String str = f10621h0;
        Log.d(str, "flexible task view bounds on screen: " + rect);
        Log.d(str, "mControlBarLayout.getHeight(): " + this.f10655d.getHeight());
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f10670p.getContentView().measure(makeMeasureSpec, makeMeasureSpec);
        Rect rect2 = new Rect(rect.left + (rect.width() / 2), rect.top + p0(12.0f, this.f10664j.getResources()), rect.left + (rect.width() / 2), rect.top + p0(12.0f, this.f10664j.getResources()));
        this.f10670p.u0(((ContainerActivity) this.f10664j).w0(), rect2.left, rect2.top);
        this.f10668n.setCurrentPopWindow(this.f10670p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map x0() {
        return OPlusAccessControlManager.getInstance().getAccessControlAppsInfo("type_hide", OPlusAccessControlManager.USER_CURRENT);
    }

    private void x1(Rect rect) {
        PopupWindow popupWindow = new PopupWindow(this.f10664j);
        this.f10635M = popupWindow;
        popupWindow.setBackgroundDrawable(null);
        this.f10635M.setClippingEnabled(false);
        this.f10635M.setEnterTransition(null);
        this.f10635M.setExitTransition(null);
        this.f10635M.setContentView(LayoutInflater.from(this.f10664j).inflate(t1.h.f13469b, (ViewGroup) null));
        this.f10635M.setOnDismissListener(new d());
        Rect rect2 = this.f10668n.getChildrenPositionOnScreen().get(this.f10668n.getContainerController().n());
        int i3 = (int) (this.f10664j.getResources().getDisplayMetrics().density * 1.0f);
        if (f10622i0.booleanValue()) {
            Log.d(f10621h0, "current focus target=" + rect2 + ", threshold=" + i3);
        }
        int i4 = i3 * 2;
        this.f10635M.setWidth((rect2.right - rect2.left) + i4);
        this.f10635M.setHeight((rect2.bottom - rect2.top) + i4);
        this.f10635M.setAnimationStyle(t1.k.f13678b);
        this.f10635M.getContentView().setSystemUiVisibility(260);
        this.f10635M.showAtLocation(this.f10668n, 0, rect2.left - i3, rect2.top - i3);
    }

    private MarginType y0(int i3) {
        if (i3 == 1 || i3 == 2) {
            return MarginType.MARGIN_SMALL;
        }
        if (i3 != 3) {
            return null;
        }
        return MarginType.MARGIN_LARGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        this.f10625C.setVisibility(8);
        this.f10623A.setVisibility(0);
        this.f10624B.setVisibility(8);
    }

    private int z0() {
        if (B1.s.w(this.f10664j)) {
            return B1.s.x(this.f10664j) ? 4 : 6;
        }
        return 5;
    }

    public void C1() {
        C0601d c0601d = this.f10669o;
        if (c0601d == null) {
            if (f10622i0.booleanValue()) {
                Log.e(f10621h0, "startNewWindow: task data is null");
                return;
            }
            return;
        }
        try {
            int s3 = c0601d.s();
            if (s3 <= 0) {
                if (f10622i0.booleanValue()) {
                    Log.e(f10621h0, "startNewWindow: invalid task id");
                    return;
                }
                return;
            }
            ComponentName component = this.f10669o.f().getComponent();
            Intent cloneFilter = this.f10669o.f().cloneFilter();
            cloneFilter.setClassName(component.getPackageName(), component.getClassName());
            cloneFilter.setFlags(268435456);
            cloneFilter.setFlags(134217728);
            cloneFilter.putExtra("multi_instance_source", 2);
            Bundle bundle = new Bundle();
            bundle.putInt("extra_window_mode", 100);
            bundle.putInt("android:activity.mZoomLaunchFlags", 14);
            B1.l.K1(cloneFilter, bundle, this.f10669o.v(), this.f10664j.getPackageName());
            Log.d(f10621h0, "startNewWindow: launched new window for task: " + s3);
        } catch (Exception e3) {
            Log.e(f10621h0, "startNewWindow failed: " + e3.getMessage(), e3);
        }
    }

    public void D1() {
        if (B1.s.w(this.f10664j)) {
            E1(true);
        } else {
            E1(false);
        }
    }

    public void E1(boolean z3) {
        if (this.f10648Z == null) {
            this.f10648Z = new J(this.f10664j, this.f10668n, this.f10640R);
        }
        this.f10648Z.f();
        this.f10668n.f10755S = true;
        C0601d c0601d = this.f10669o;
        this.f10648Z.g(z3, c0601d == null ? -1 : c0601d.s());
    }

    public void F0() {
        Handler.getMain().postAtFrontOfQueue(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.n
            @Override // java.lang.Runnable
            public final void run() {
                C0327t.this.V0();
            }
        });
    }

    public void G0() {
        if (this.f10659f == null) {
            return;
        }
        if (f10622i0.booleanValue()) {
            Log.d(f10621h0, "hideControlBarBg getAlpha=" + this.f10659f.getAlpha() + " mHandleHoverEnter=" + this.f10656d0);
        }
        if (!this.f10656d0 || this.f10659f.getAlpha() == 0.0f) {
            return;
        }
        I1(true, new AnimatorSet());
        this.f10656d0 = false;
    }

    public void I0() {
        Handler.getMain().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.m
            @Override // java.lang.Runnable
            public final void run() {
                C0327t.this.W0();
            }
        });
    }

    public void J0(FlexibleTaskView flexibleTaskView, EmbeddedViewDecor embeddedViewDecor, Rect rect, Rect rect2, C0601d c0601d) {
        if (!this.f10652b0) {
            if (c0601d.k() != null) {
                C0305a.a().b(new b(this, c0601d));
            }
            this.f10666l = flexibleTaskView;
            this.f10667m = embeddedViewDecor;
            this.f10668n = (ContainerView) embeddedViewDecor.getParent();
            this.f10669o = c0601d;
            Context context = this.f10664j;
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context.createWindowContext(context.getDisplay(), 2038, null)).inflate(t1.h.f13474g, (ViewGroup) null);
            this.f10655d = frameLayout;
            this.f10657e = (ImageButton) frameLayout.findViewById(t1.f.f13450j);
            this.f10659f = (ImageView) this.f10655d.findViewById(t1.f.f13451k);
            this.f10657e.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean E02;
                    E02 = C0327t.this.E0(view, motionEvent);
                    return E02;
                }
            });
            this.f10657e.setOnHoverListener(new View.OnHoverListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.k
                @Override // android.view.View.OnHoverListener
                public final boolean onHover(View view, MotionEvent motionEvent) {
                    boolean D02;
                    D02 = C0327t.this.D0(view, motionEvent);
                    return D02;
                }
            });
            this.f10657e.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C0327t.this.X0(view);
                }
            });
            this.f10652b0 = true;
        }
        this.f10665k = rect;
        Log.d(f10621h0, "current layout rect: " + this.f10665k + ", launchRect: " + rect2 + ", mTaskData: " + this.f10669o);
        this.f10646X = 0.0f;
        q1(flexibleTaskView, rect2, false, false);
    }

    public void J1() {
        C0327t c0327t;
        ContainerView containerView = this.f10668n;
        if (containerView == null || containerView.getContainerController() == null) {
            Log.d(f10621h0, "initialization not complete, can not update control bar alpha");
            return;
        }
        int size = this.f10668n.getChildEmbeddedViewList().size();
        for (int i3 = 0; i3 < size; i3++) {
            int n3 = this.f10668n.getContainerController().n();
            EmbeddedViewDecor q02 = this.f10668n.q0(i3);
            if (q02 != null && (c0327t = q02.f10862h) != null && c0327t.f10657e != null) {
                float g02 = g0(q02.getLaunchRect(), i3);
                StringBuilder sb = new StringBuilder();
                Drawable v02 = v0(n3, i3, g02, sb, q02.f10862h.f10640R.getLightMode(), q02, false);
                if (f10622i0.booleanValue()) {
                    Log.d(f10621h0, "updateFocusStateForControlBar rules: " + sb.toString());
                }
                q02.f10862h.f10657e.setImageDrawable(v02);
            }
        }
    }

    public void K1(C0601d c0601d) {
        this.f10669o = c0601d;
        Log.d(f10621h0, "updateTaskData: " + this.f10669o);
    }

    public boolean Q0() {
        x1.y yVar;
        x1.u uVar = this.f10642T;
        return (uVar != null && uVar.z0()) || ((yVar = this.f10643U) != null && yVar.f());
    }

    public boolean R0() {
        return this.f10652b0;
    }

    @Override // com.oplus.pscanvas.canvasmode.canvas.ContainerActivity.h
    public void a(com.coui.appcompat.poplist.f fVar) {
        com.coui.appcompat.poplist.f fVar2 = this.f10670p;
        if (fVar2 == null || fVar == fVar2 || !fVar2.isShowing()) {
            return;
        }
        this.f10670p.dismiss();
    }

    public boolean j0() {
        if (this.f10648Z == null) {
            this.f10648Z = new J(this.f10664j, this.f10668n, this.f10640R);
        }
        return this.f10648Z.c(this.f10668n.getAdapter().h());
    }

    public void k0(String str) {
        J j3 = this.f10648Z;
        if (j3 != null) {
            j3.d(str);
        }
    }

    public void k1(Bundle bundle) {
        if (this.f10668n.f10755S) {
            Log.d(f10621h0, "onCanvasTaskEvent is in animation");
        }
        int i3 = bundle.getInt("androidx.activity.TaskEvent", -1);
        String str = f10621h0;
        Log.d(str, "valueEvent is " + i3);
        int position = this.f10668n.getAdapter().getPosition(this.f10669o);
        switch (i3) {
            case 1:
                this.f10668n.T1(this.f10669o);
                break;
            case 2:
                Intent intent = (Intent) bundle.getParcelable("androidx.activity.replaceTaskIntent", Intent.class);
                int i4 = bundle.getInt("androidx.activity.replaceTaskId", -1);
                this.f10668n.f10755S = true;
                if (intent == null && i4 == -1) {
                    Log.d(str, "invalid");
                }
                if (intent != null) {
                    intent.addFlags(262144);
                    intent.putExtra("androidx.flexible.userId", this.f10669o.v());
                }
                this.f10672r.n(this.f10668n, intent, i4, this.f10669o.v(), position);
                break;
            case 3:
                this.f10668n.I2(position);
                break;
            case 4:
                E1(true);
                break;
            case 5:
                C0(true);
                break;
            case 6:
                C0(false);
                break;
        }
    }

    public void m1() {
        C0327t c0327t;
        ContainerView containerView = this.f10668n;
        if (containerView == null || containerView.getContainerController() == null) {
            Log.d(f10621h0, "initialization not complete, can not reset control bar alpha");
            return;
        }
        int n3 = this.f10668n.getContainerController().n();
        EmbeddedViewDecor q02 = this.f10668n.q0(n3);
        if (q02 == null || (c0327t = q02.f10862h) == null || c0327t.f10657e == null) {
            return;
        }
        int lightMode = this.f10640R.getLightMode();
        float g02 = g0(q02.getLaunchRect(), n3);
        StringBuilder sb = new StringBuilder();
        Drawable v02 = v0(n3, n3, g02, sb, lightMode, q02, true);
        Log.d(f10621h0, "resetFocusStateForControlBar rules: " + sb.toString());
        q02.f10862h.f10657e.setImageDrawable(v02);
    }

    public void q1(FlexibleTaskView flexibleTaskView, Rect rect, boolean z3, boolean z4) {
        StringBuilder sb;
        float g02 = g0(rect, -1);
        if (Math.abs(g02 - this.f10646X) < 1.0E-6f && !z3) {
            if (f10622i0.booleanValue()) {
                Log.d(f10621h0, "return as scale equals");
                return;
            }
            return;
        }
        this.f10646X = g02;
        Drawable drawable = this.f10664j.getResources().getDrawable(t1.e.f13399e);
        Drawable drawable2 = this.f10664j.getResources().getDrawable(t1.e.f13398d);
        if (f10622i0.booleanValue()) {
            Log.d(f10621h0, "updateLight: " + z3 + " light: " + z4 + " lightMode: " + this.f10640R.getLightMode() + " taskData : " + this.f10669o);
        }
        if (z3 || this.f10640R.getLightMode() != -1) {
            sb = new StringBuilder();
            if (z3) {
                this.f10640R.setLightMode(z4);
            }
            drawable = v0(this.f10668n.getContainerController().n(), this.f10668n.getAdapter().getPosition(this.f10669o), g02, sb, this.f10640R.getLightMode(), this.f10640R, false);
        } else {
            sb = null;
        }
        if (f10622i0.booleanValue()) {
            String str = f10621h0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setControlBar rules: ");
            sb2.append(sb != null ? sb.toString() : null);
            Log.d(str, sb2.toString());
        }
        if (Math.abs(g02 - 1.0f) > 1.0E-6f) {
            Log.d(f10621h0, "zoom in or out the bar with scale: " + g02);
            drawable2 = L1(drawable2, g02);
        }
        this.f10657e.setImageDrawable(drawable);
        this.f10659f.setImageDrawable(drawable2);
        if (this.f10668n.getPanoramaModeManager().M()) {
            r1(4);
        }
        if (z3) {
            return;
        }
        int dimensionPixelSize = (int) (this.f10664j.getResources().getDimensionPixelSize(t1.d.f13374c) * g02);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(2038);
        layoutParams.flags |= 8;
        layoutParams.width = this.f10665k.width();
        layoutParams.height = dimensionPixelSize;
        layoutParams.token = new Binder();
        layoutParams.format = -3;
        layoutParams.setTitle("CanvasControlBar");
        layoutParams.privateFlags |= 536870976;
        int dimensionPixelSize2 = ((int) (this.f10664j.getResources().getDimensionPixelSize(t1.d.f13375d) * g02)) / 2;
        flexibleTaskView.setExtraViewInfo(this.f10655d, layoutParams, new Region((this.f10665k.width() / 2) - dimensionPixelSize2, 0, (this.f10665k.width() / 2) + dimensionPixelSize2, dimensionPixelSize));
    }

    public void r1(int i3) {
        FrameLayout frameLayout = this.f10655d;
        if (frameLayout != null) {
            frameLayout.setVisibility(i3);
            this.f10655d.setEnabled(i3 == 0);
        }
        ImageButton imageButton = this.f10657e;
        if (imageButton != null) {
            imageButton.setEnabled(i3 == 0);
        }
    }

    public void s1(EmbeddedViewDecor embeddedViewDecor) {
        this.f10640R = embeddedViewDecor;
    }

    public void u1(String str) {
        FrameLayout frameLayout = this.f10655d;
        if (frameLayout != null) {
            frameLayout.setContentDescription(str);
        }
    }

    public void z1() {
        String str;
        try {
            str = this.f10664j.getPackageManager().getApplicationInfo(this.f10669o.k(), 128).loadLabel(this.f10664j.getPackageManager()).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(f10621h0, "can't find package exception ");
            str = "";
        }
        Toast.makeText(this.f10664j, TextUtils.isEmpty(str) ? this.f10664j.getResources().getString(t1.j.f13634d0) : String.format(this.f10664j.getResources().getString(t1.j.f13632c0), str), 0).show();
    }
}
