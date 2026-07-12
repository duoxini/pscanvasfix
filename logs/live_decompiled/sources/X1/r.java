package x1;

import Z.b;
import android.app.OplusActivityTaskManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import android.view.SurfaceControl;
import android.view.SurfaceSession;
import android.view.WindowManager;
import com.google.android.collect.Sets;
import com.oplus.app.OplusAppInfo;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.multiapp.OplusMultiAppManager;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.DraggableCanvasViewGroup;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import u1.C0601d;

/* loaded from: classes.dex */
public class r {

    /* renamed from: V, reason: collision with root package name */
    public static final int f14094V = SystemProperties.getInt("persist.sys.finger.blurradius", 60);

    /* renamed from: W, reason: collision with root package name */
    private static final float f14095W = B1.s.c(0.0f);

    /* renamed from: X, reason: collision with root package name */
    private static float f14096X = 0.00390625f;

    /* renamed from: Y, reason: collision with root package name */
    private static float f14097Y = 0.1f;

    /* renamed from: Z, reason: collision with root package name */
    private static float f14098Z = 0.2f;

    /* renamed from: a0, reason: collision with root package name */
    private static float f14099a0 = 0.15f;

    /* renamed from: b0, reason: collision with root package name */
    private static float f14100b0 = 0.36f;

    /* renamed from: c0, reason: collision with root package name */
    private static float f14101c0 = 0.5f;

    /* renamed from: d0, reason: collision with root package name */
    private static float f14102d0 = 1.1f;

    /* renamed from: e0, reason: collision with root package name */
    private static float f14103e0 = 0.99f;

    /* renamed from: f0, reason: collision with root package name */
    private static float f14104f0 = 0.4f;

    /* renamed from: g0, reason: collision with root package name */
    private static float f14105g0 = 0.95f;

    /* renamed from: h0, reason: collision with root package name */
    private static final Set f14106h0 = Sets.newArraySet(new String[]{"com.oplus.ocar"});

    /* renamed from: A, reason: collision with root package name */
    private float f14107A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f14108B;

    /* renamed from: D, reason: collision with root package name */
    private boolean f14110D;

    /* renamed from: F, reason: collision with root package name */
    private Z.c f14112F;

    /* renamed from: H, reason: collision with root package name */
    private int f14114H;

    /* renamed from: I, reason: collision with root package name */
    private List f14115I;

    /* renamed from: L, reason: collision with root package name */
    private volatile Bundle f14118L;

    /* renamed from: Q, reason: collision with root package name */
    private List f14123Q;

    /* renamed from: R, reason: collision with root package name */
    private int f14124R;

    /* renamed from: S, reason: collision with root package name */
    private Runnable f14125S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f14126T;

    /* renamed from: U, reason: collision with root package name */
    private int f14127U;

    /* renamed from: a, reason: collision with root package name */
    private Context f14128a;

    /* renamed from: b, reason: collision with root package name */
    private ContainerView f14129b;

    /* renamed from: e, reason: collision with root package name */
    SurfaceControl f14132e;

    /* renamed from: f, reason: collision with root package name */
    DraggableCanvasViewGroup f14133f;

    /* renamed from: g, reason: collision with root package name */
    private float f14134g;

    /* renamed from: h, reason: collision with root package name */
    private float f14135h;

    /* renamed from: i, reason: collision with root package name */
    float f14136i;

    /* renamed from: j, reason: collision with root package name */
    float f14137j;

    /* renamed from: k, reason: collision with root package name */
    private int f14138k;

    /* renamed from: l, reason: collision with root package name */
    private int f14139l;

    /* renamed from: m, reason: collision with root package name */
    private int f14140m;

    /* renamed from: n, reason: collision with root package name */
    Z.c f14141n;

    /* renamed from: o, reason: collision with root package name */
    Z.c f14142o;

    /* renamed from: s, reason: collision with root package name */
    private Handler f14146s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f14147t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f14148u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f14149v;

    /* renamed from: w, reason: collision with root package name */
    private int f14150w;

    /* renamed from: x, reason: collision with root package name */
    private int f14151x;

    /* renamed from: y, reason: collision with root package name */
    private volatile int f14152y;

    /* renamed from: z, reason: collision with root package name */
    private StringBuilder f14153z;

    /* renamed from: c, reason: collision with root package name */
    private float f14130c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f14131d = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    private final SurfaceSession f14143p = new SurfaceSession();

    /* renamed from: q, reason: collision with root package name */
    private final SurfaceControl.Transaction f14144q = new SurfaceControl.Transaction();

    /* renamed from: r, reason: collision with root package name */
    private final CopyOnWriteArrayList f14145r = new CopyOnWriteArrayList();

    /* renamed from: C, reason: collision with root package name */
    private boolean f14109C = true;

    /* renamed from: E, reason: collision with root package name */
    private List f14111E = new ArrayList();

    /* renamed from: G, reason: collision with root package name */
    private int f14113G = 0;

    /* renamed from: J, reason: collision with root package name */
    private volatile boolean f14116J = false;

    /* renamed from: K, reason: collision with root package name */
    private volatile boolean f14117K = false;

    /* renamed from: M, reason: collision with root package name */
    private final Object f14119M = new Object();

    /* renamed from: N, reason: collision with root package name */
    private final Object f14120N = new Object();

    /* renamed from: O, reason: collision with root package name */
    private boolean f14121O = false;

    /* renamed from: P, reason: collision with root package name */
    private Rect f14122P = new Rect();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        EmbeddedViewDecor f14154a;

        /* renamed from: b, reason: collision with root package name */
        SurfaceControl f14155b;

        /* renamed from: c, reason: collision with root package name */
        SurfaceControl f14156c;

        /* renamed from: d, reason: collision with root package name */
        SurfaceControl f14157d;

        /* renamed from: e, reason: collision with root package name */
        Rect f14158e;

        /* renamed from: f, reason: collision with root package name */
        int f14159f;

        /* renamed from: g, reason: collision with root package name */
        Rect f14160g;

        /* renamed from: h, reason: collision with root package name */
        float f14161h;

        /* renamed from: i, reason: collision with root package name */
        int f14162i;

        /* renamed from: j, reason: collision with root package name */
        boolean f14163j;

        private a() {
        }
    }

    private class b {

        /* renamed from: a, reason: collision with root package name */
        SurfaceControl f14164a;

        /* renamed from: b, reason: collision with root package name */
        SurfaceControl f14165b;

        /* renamed from: c, reason: collision with root package name */
        SurfaceControl f14166c;

        /* renamed from: d, reason: collision with root package name */
        SurfaceControl f14167d;

        /* renamed from: e, reason: collision with root package name */
        FlexibleTaskView f14168e;

        /* renamed from: f, reason: collision with root package name */
        EmbeddedViewDecor f14169f;

        /* renamed from: j, reason: collision with root package name */
        float f14173j;

        /* renamed from: k, reason: collision with root package name */
        float f14174k;

        /* renamed from: l, reason: collision with root package name */
        float f14175l;

        /* renamed from: p, reason: collision with root package name */
        boolean f14179p;

        /* renamed from: g, reason: collision with root package name */
        Rect f14170g = new Rect();

        /* renamed from: h, reason: collision with root package name */
        Rect f14171h = new Rect();

        /* renamed from: i, reason: collision with root package name */
        Rect f14172i = new Rect();

        /* renamed from: m, reason: collision with root package name */
        float f14176m = 1.0f;

        /* renamed from: n, reason: collision with root package name */
        float f14177n = 1.0f;

        /* renamed from: o, reason: collision with root package name */
        float f14178o = 1.0f;

        /* renamed from: q, reason: collision with root package name */
        int f14180q = 0;

        public b(SurfaceControl surfaceControl, SurfaceControl surfaceControl2, SurfaceControl surfaceControl3, SurfaceControl surfaceControl4, EmbeddedViewDecor embeddedViewDecor, Rect rect) {
            this.f14166c = surfaceControl;
            this.f14165b = surfaceControl2;
            this.f14164a = surfaceControl3;
            this.f14167d = surfaceControl4;
            this.f14169f = embeddedViewDecor;
            this.f14168e = embeddedViewDecor.getFlexibleTaskView();
            this.f14170g.set(rect);
            if (r.this.f14126T) {
                this.f14170g.offset(0, (int) (r.this.f14127U / r.this.f14134g));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(SurfaceControl.Transaction transaction, float f3) {
            float f4 = r.this.f14134g * f3;
            float[] x3 = r.this.x(f3);
            float f5 = x3[0];
            float f6 = x3[1];
            Rect rect = this.f14170g;
            float f7 = (int) (f5 + (rect.left * f4));
            float f8 = (int) (f6 + (rect.top * f4));
            transaction.setPosition(this.f14166c, f7, f8).setCrop(this.f14166c, new Rect(0, 0, (int) (((int) ((rect.width() * f4) + f7)) - f7), (int) (((int) ((this.f14170g.height() * f4) + f8)) - f8))).setPosition(this.f14164a, 0.0f, 0.0f).setScale(this.f14164a, r.this.f14134g * f3, r.this.f14135h * f3);
            if (this.f14165b.isValid()) {
                transaction.setPosition(this.f14165b, 0.0f, 0.0f).setScale(this.f14165b, f4, f4);
            }
            B1.l.x1(transaction, this.f14166c, r.this.f14129b.getTwoSplitCornerRadius());
        }

        public void c() {
            this.f14176m = r.f14103e0 * r.this.f14134g;
            float[] x3 = r.this.x(r.f14103e0);
            float f3 = x3[0];
            float f4 = x3[1];
            Rect rect = this.f14171h;
            float f5 = this.f14170g.left;
            float f6 = this.f14176m;
            int i3 = (int) (f3 + (f5 * f6));
            rect.left = i3;
            rect.top = (int) (f4 + (r3.top * f6));
            rect.right = (int) (i3 + (r3.width() * this.f14176m));
            this.f14171h.bottom = (int) (r0.top + (this.f14170g.height() * this.f14176m));
            this.f14177n = (this.f14172i.width() * 1.0f) / this.f14170g.width();
            this.f14178o = (this.f14172i.height() * 1.0f) / this.f14170g.height();
            r.this.f14144q.reparent(this.f14166c, r.this.f14132e);
            if (this.f14179p) {
                r.this.f14144q.setLayer(this.f14166c, 3);
            } else {
                r.this.f14144q.setLayer(this.f14166c, this.f14180q);
            }
            this.f14174k = r.this.f14129b.getTwoSplitCornerRadius();
            r.this.f14144q.setCornerRadius(this.f14166c, this.f14174k);
            FlexibleTaskView flexibleTaskView = this.f14168e;
            if (flexibleTaskView != null && flexibleTaskView.getSurfaceControl() != null) {
                r.this.f14144q.hide(this.f14168e.getSurfaceControl());
            }
            this.f14169f.setVisibility(4);
            SurfaceControl surfaceControl = this.f14165b;
            if (surfaceControl == null || !surfaceControl.isValid()) {
                return;
            }
            r.this.f14144q.setAlpha(this.f14165b, 1.0f);
        }

        public void d(SurfaceControl.Transaction transaction, float f3) {
            float f4 = this.f14177n;
            float f5 = this.f14176m;
            float f6 = ((f4 - f5) * f3) + f5;
            float f7 = ((this.f14178o - f5) * f3) + f5;
            r.this.f14144q.setScale(this.f14164a, f6, f7);
            if (this.f14165b.isValid()) {
                r.this.f14144q.setScale(this.f14165b, f6, f7);
            }
            Rect rect = this.f14172i;
            int i3 = rect.left;
            Rect rect2 = this.f14171h;
            float f8 = ((i3 - r5) * f3) + rect2.left;
            int i4 = rect.top;
            float f9 = ((i4 - r6) * f3) + rect2.top;
            int i5 = rect.right;
            int i6 = rect2.right;
            int i7 = rect.bottom;
            r.this.f14144q.setPosition(this.f14166c, f8, f9).setCrop(this.f14166c, new Rect(0, 0, (int) ((((i5 - i6) * f3) + i6) - f8), (int) ((((i7 - r4) * f3) + rect2.bottom) - f9)));
            B1.l.x1(transaction, this.f14166c, B1.l.p(f3, this.f14175l * this.f14173j, this.f14174k));
            float f10 = this.f14176m;
            float f11 = f10 + ((1.0f - f10) * f3);
            transaction.setScale(this.f14167d, (1.0f / f6) * f11, (1.0f / f7) * f11);
            transaction.setPosition(this.f14167d, (((this.f14170g.width() * f6) - (r.this.f14140m * f11)) / 2.0f) / f6, (((this.f14170g.height() * f7) - (r.this.f14140m * f11)) / 2.0f) / f7);
        }

        public void e() {
            this.f14168e.setScaleX(1.0f);
            this.f14168e.setScaleY(1.0f);
            this.f14168e.setTranslationX(0.0f);
            this.f14168e.setTranslationY(0.0f);
            this.f14169f.setVisibility(0);
            this.f14168e = null;
            this.f14169f = null;
            SurfaceControl surfaceControl = this.f14164a;
            if (surfaceControl != null && surfaceControl.isValid()) {
                r.this.f14144q.remove(this.f14164a);
                this.f14164a = null;
            }
            SurfaceControl surfaceControl2 = this.f14165b;
            if (surfaceControl2 != null && surfaceControl2.isValid()) {
                r.this.f14144q.remove(this.f14165b);
                this.f14165b = null;
            }
            SurfaceControl surfaceControl3 = this.f14167d;
            if (surfaceControl3 != null && surfaceControl3.isValid()) {
                r.this.f14144q.remove(this.f14167d);
                this.f14167d = null;
            }
            SurfaceControl surfaceControl4 = this.f14166c;
            if (surfaceControl4 == null || !surfaceControl4.isValid()) {
                return;
            }
            r.this.f14144q.remove(this.f14166c);
            this.f14166c = null;
        }

        public void f(boolean z3) {
            this.f14179p = z3;
        }
    }

    public r(Context context, ContainerView containerView, DraggableCanvasViewGroup draggableCanvasViewGroup) {
        this.f14128a = context;
        this.f14129b = containerView;
        this.f14133f = draggableCanvasViewGroup;
        this.f14140m = (int) (context.getResources().getDisplayMetrics().density * 64.0f);
    }

    private Bitmap A(Drawable drawable) {
        if (drawable == null) {
            Log.d("SStoFlexible", " drawableToBitmap; Some parameters are null, return!");
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            intrinsicWidth = this.f14140m;
            intrinsicHeight = intrinsicWidth;
        }
        if ((intrinsicWidth > 500 || intrinsicHeight > 500) && (drawable instanceof AdaptiveIconDrawable)) {
            AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
            if (adaptiveIconDrawable.getBackground() != null && adaptiveIconDrawable.getForeground() != null && adaptiveIconDrawable.getForeground().getIntrinsicWidth() <= 500 && adaptiveIconDrawable.getForeground().getIntrinsicWidth() > 0 && adaptiveIconDrawable.getForeground().getIntrinsicWidth() == adaptiveIconDrawable.getBackground().getIntrinsicWidth()) {
                intrinsicWidth = adaptiveIconDrawable.getForeground().getIntrinsicWidth();
                intrinsicHeight = adaptiveIconDrawable.getForeground().getIntrinsicHeight();
            }
        }
        int i3 = intrinsicWidth;
        int i4 = intrinsicHeight;
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i3, i4);
        drawable.draw(canvas);
        Matrix matrix = new Matrix();
        int i5 = this.f14140m;
        matrix.postScale(i5 / i3, i5 / i4);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, i3, i4, matrix, true);
        createBitmap.recycle();
        return createBitmap2;
    }

    private Bundle B(List list, int[] iArr) {
        if (list == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.canvas.to.multi.flexible", true);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < iArr.length; i3++) {
            sb.append(iArr[i3]);
            if (i3 != iArr.length - 1) {
                sb.append(",");
            }
        }
        bundle.putString("task_id_list_string", sb.toString());
        return B1.l.n(list, this.f14114H, bundle);
    }

    private List C() {
        List list = this.f14115I;
        if (list == null) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(E((EmbeddedViewDecor) list.get(G(i3))));
        }
        return arrayList;
    }

    private void D() {
        ArrayList parcelableArrayList;
        Object last;
        ArrayList arrayList = new ArrayList();
        this.f14111E.clear();
        v0(arrayList);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.canvas.to.multi.flexible", true);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Intent intent = (Intent) it.next();
            sb.append(intent.getIntExtra("androidx.activity.LaunchEmbeddedTaskId", 0));
            last = arrayList.getLast();
            if (intent != last) {
                sb.append(",");
            }
        }
        bundle.putString("task_id_list_string", sb.toString());
        synchronized (this.f14119M) {
            try {
                this.f14118L = B1.l.n(arrayList, this.f14114H, bundle);
                parcelableArrayList = this.f14118L != null ? this.f14118L.getParcelableArrayList("androidx.canvas.to.multi.flexible.launch.bounds.list", Bundle.class) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (parcelableArrayList == null) {
            return;
        }
        L(parcelableArrayList);
    }

    private static Intent E(EmbeddedViewDecor embeddedViewDecor) {
        C0601d taskData = embeddedViewDecor.getTaskData();
        Intent f3 = taskData.f();
        f3.putExtra("androidx.activity.LaunchEmbeddedTaskId", taskData.s());
        f3.putExtra("androidx.flexible.userId", taskData.v());
        if (taskData.u() || embeddedViewDecor.getLaunchRect().equals(taskData.i())) {
            f3.putExtra("androidx.canvas.to.multi.flexible.full.ratio", true);
        }
        Rect launchRect = embeddedViewDecor.getLaunchRect();
        if (launchRect.width() > launchRect.height()) {
            f3.putExtra("androidx.canvas.to.multi.flexible.orientation", 0);
        } else if (launchRect.width() < launchRect.height()) {
            f3.putExtra("androidx.canvas.to.multi.flexible.orientation", 1);
        }
        return f3;
    }

    private boolean F() {
        boolean z3;
        synchronized (this.f14119M) {
            z3 = this.f14117K;
        }
        return z3;
    }

    private int G(int i3) {
        int size = this.f14115I.size();
        int i4 = this.f14114H;
        return (i4 == 7 || i4 == 1) ? i3 : (i4 != 3 || ((C0601d) this.f14123Q.get(0)).I()) ? i4 == 6 ? (i3 + 1) % 3 : i4 == 5 ? (i3 == 0 || i3 == 1) ? 1 - i3 : i3 : i4 == 4 ? (i3 == 1 || i3 == 2) ? 3 - i3 : i3 : (size - 1) - i3 : i3;
    }

    private void I(OplusAppInfo oplusAppInfo) {
        if (oplusAppInfo.extension.getInt("launchScenario", 0) == 2) {
            Log.w("SStoFlexible", "hideDissociativeEmbeddedTaskIfNeeded " + oplusAppInfo.taskId);
            try {
                OplusActivityTaskManager.getInstance().moveTaskToBack(oplusAppInfo.taskId, true);
            } catch (RemoteException | IllegalArgumentException e3) {
                Log.e("SStoFlexible", "hideDissociativeEmbeddedTaskIfNeeded " + e3.getMessage());
            }
        }
    }

    private void K(b bVar, Bundle bundle, a aVar) {
        Rect rect = (Rect) bundle.getParcelable("androidx.flexible.VisualBounds", Rect.class);
        int i3 = bundle.getInt("androidx.activity.LaunchCornerRadius");
        Rect rect2 = (Rect) bundle.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
        float f3 = bundle.getFloat("androidx.activity.LaunchScale", 1.0f);
        Slog.d("SStoFlexible", "getFlexibleTaskLaunchInfo:" + bVar.f14169f.getTaskData().k() + " visibleBound:" + rect + " endCornerRadius:" + i3 + " launchBound:" + rect2 + " scale:" + f3);
        aVar.f14161h = f3;
        aVar.f14160g = rect2;
        aVar.f14163j = bVar.f14179p;
        aVar.f14162i = i3;
        bVar.f14172i.set(rect);
        bVar.f14175l = (float) i3;
        bVar.f14173j = f3;
        bVar.f14180q = this.f14111E.indexOf(aVar);
    }

    private void L(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            K((b) this.f14145r.get(G(i3)), (Bundle) arrayList.get(i3), (a) this.f14111E.get(i3));
        }
    }

    private Z.c M(float f3, float f4) {
        o0(3);
        Z.d dVar = new Z.d();
        dVar.g(f14099a0).e(f14095W).f(f4);
        Z.c cVar = new Z.c(new B.d(f3));
        cVar.B(dVar);
        b.r rVar = new b.r() { // from class: x1.e
            @Override // Z.b.r
            public final void onAnimationUpdate(Z.b bVar, float f5, float f6) {
                r.this.U(bVar, f5, f6);
            }
        };
        b.q qVar = new b.q() { // from class: x1.f
            @Override // Z.b.q
            public final void onAnimationEnd(Z.b bVar, boolean z3, float f5, float f6) {
                r.this.V(bVar, z3, f5, f6);
            }
        };
        cVar.o(f3);
        cVar.m(0.00390625f);
        cVar.b(rVar);
        cVar.a(qVar);
        cVar.u(f4);
        cVar.r();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(List list, int[] iArr) {
        try {
            synchronized (this.f14119M) {
                try {
                    if (this.f14118L == null) {
                        this.f14118L = B(list, iArr);
                    }
                } finally {
                }
            }
        } catch (Exception e3) {
            Log.w("SStoFlexible", "calculateFlexibleTaskBoundBackground error. " + e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, SurfaceControl surfaceControl2, SurfaceControl surfaceControl3, SurfaceControl surfaceControl4, EmbeddedViewDecor embeddedViewDecor, int i3, FlexibleTaskView flexibleTaskView) {
        int i4 = this.f14113G;
        if (i4 == 6 || i4 == 0) {
            transaction.remove(surfaceControl).remove(surfaceControl2).remove(surfaceControl3).remove(surfaceControl4).apply();
            Log.d("SStoFlexible", "reset remove mask " + embeddedViewDecor.getTaskData().f());
            return;
        }
        List<Rect> rectList = this.f14129b.getRectList();
        if (rectList != null && this.f14151x == rectList.size()) {
            b bVar = new b(surfaceControl4, surfaceControl3, surfaceControl2, surfaceControl, embeddedViewDecor, rectList.get(i3));
            if (this.f14124R == i3) {
                bVar.f(true);
            }
            this.f14145r.add(bVar);
            Log.d("SStoFlexible", "createMaskLeash task:" + embeddedViewDecor.getTaskData().s() + " width:" + flexibleTaskView.getWidth() + " height:" + flexibleTaskView.getHeight());
        }
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(EmbeddedViewDecor embeddedViewDecor) {
        y(embeddedViewDecor, this.f14115I.indexOf(embeddedViewDecor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(Z.b bVar, float f3, float f4) {
        if (this.f14113G == 6 || !this.f14147t) {
            return;
        }
        float[] x3 = x(f3);
        float f5 = x3[0];
        float f6 = x3[1];
        this.f14133f.setTranslationX(f5);
        this.f14133f.setTranslationY(f6);
        this.f14133f.setScaleX(this.f14134g * f3);
        this.f14133f.setScaleY(this.f14135h * f3);
        this.f14107A = f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Z.b bVar, boolean z3, float f3, float f4) {
        if (this.f14113G != 6 && this.f14147t && this.f14108B) {
            if (this.f14149v || !this.f14110D) {
                i0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(int i3, boolean z3, List list, int[] iArr) {
        Bundle bundle;
        int i4;
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[i3];
        Bundle bundle2 = new Bundle();
        if (z3) {
            bundle2.putBoolean("prepare_switch_to_flexible_window", true);
        }
        bundle2.putInt("androidx.canvas.task.pending.remove", this.f14129b.Q2(this.f14128a).u0());
        synchronized (this.f14119M) {
            try {
                if (!F() && this.f14142o != null) {
                    if (this.f14118L != null) {
                        bundle = this.f14118L;
                    } else {
                        bundle = B(list, iArr);
                        this.f14118L = bundle;
                    }
                    bundle2.putBoolean("prepare_start_flexible_window_ps", true);
                    m0(true);
                } else if (!z3) {
                    return;
                } else {
                    bundle = null;
                }
                int[] iArr2 = new int[i3];
                if (bundle != null) {
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList("androidx.canvas.to.multi.flexible.launch.bounds.list", Bundle.class);
                    if (parcelableArrayList == null || parcelableArrayList.size() != list.size()) {
                        return;
                    }
                    int i5 = this.f14124R;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (i6 < i3) {
                        if (G(i6) == i5) {
                            i4 = i5;
                            i7 = i6;
                        } else {
                            Bundle bundle3 = (Bundle) parcelableArrayList.get(i6);
                            Rect rect = (Rect) bundle3.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
                            i4 = i5;
                            float f3 = bundle3.getFloat("androidx.activity.LaunchScale", 1.0f);
                            iArr2[i8] = iArr[i6];
                            arrayList.add(rect);
                            fArr[i8] = f3;
                            i8++;
                        }
                        i6++;
                        i5 = i4;
                    }
                    if (arrayList.size() < list.size()) {
                        Bundle bundle4 = (Bundle) parcelableArrayList.get(i7);
                        Rect rect2 = (Rect) bundle4.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
                        float f4 = bundle4.getFloat("androidx.activity.LaunchScale", 1.0f);
                        iArr2[i8] = iArr[i7];
                        arrayList.add(rect2);
                        fArr[i8] = f4;
                    }
                } else {
                    for (int i9 = 0; i9 < i3; i9++) {
                        arrayList.add(new Rect());
                    }
                }
                int H3 = H();
                if (H3 == 0 || H3 >= 6) {
                    Log.i("SStoFlexible", "notifySystemSwitchingToFlexibleTask return state:" + H3);
                    return;
                }
                Log.d("SStoFlexible", "notifySystemSwitchingToFlexibleTask taskIdList:" + Arrays.toString(iArr2) + " notifyPrepare:" + z3);
                if (!bundle2.getBoolean("prepare_start_flexible_window_ps", false)) {
                    B1.l.t0(iArr2, arrayList, fArr, bundle2);
                    return;
                }
                synchronized (this.f14120N) {
                    B1.l.t0(iArr2, arrayList, fArr, bundle2);
                    n0(true);
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Z.b bVar, boolean z3, float f3, float f4) {
        if (this.f14113G != 6 && this.f14147t && this.f14108B) {
            Slog.d("SStoFlexible", "startChangeAnimationToFlexibleTask onAnimationEnd mState:" + this.f14113G + ",mInit:" + this.f14147t);
            this.f14125S = new Runnable() { // from class: x1.o
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.Z();
                }
            };
            if (Q()) {
                this.f14146s.postDelayed(this.f14125S, 20L);
            } else {
                this.f14146s.postDelayed(this.f14125S, 2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(float f3, float f4, Z.b bVar, float f5, float f6) {
        if (this.f14113G == 6 || !this.f14147t) {
            return;
        }
        try {
            w0(f5, f3);
        } catch (Exception e3) {
            Slog.d("SStoFlexible", "startChangeAnimationToFlexibleTask update error.", e3);
        }
        this.f14144q.apply();
        if (f5 <= f14105g0 || !this.f14108B) {
            return;
        }
        this.f14142o.x().h(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(float f3, List list, Z.b bVar, float f4, float f5) {
        if (this.f14113G == 6 || !this.f14147t) {
            return;
        }
        if (f4 > 0.9f) {
            this.f14141n.x().h(f3);
        }
        Iterator it = this.f14145r.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            SurfaceControl surfaceControl = bVar2.f14164a;
            if (surfaceControl != null && surfaceControl.isValid()) {
                this.f14144q.setAlpha(bVar2.f14164a, f4);
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((E.c) it2.next()).g().setAlpha(1.0f - f4);
        }
        this.f14144q.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(List list, Z.b bVar, boolean z3, float f3, float f4) {
        Log.d("SStoFlexible", "startFadeInAnimation addEndListener mInit:" + this.f14147t + ",mState:" + this.f14113G + " mScaleEnd:" + this.f14108B);
        if (this.f14113G == 6 || !this.f14147t) {
            return;
        }
        Iterator it = this.f14145r.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            SurfaceControl surfaceControl = bVar2.f14165b;
            if (surfaceControl != null && surfaceControl.isValid()) {
                this.f14144q.remove(bVar2.f14165b);
            }
        }
        this.f14144q.apply();
        this.f14148u = true;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((E.c) it2.next()).g().setVisibility(8);
        }
        l0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0() {
        ContainerActivity Q22 = this.f14129b.Q2(this.f14128a);
        Q22.L1(true);
        B1.h.a(Q22).e("four_finger_to_zoom");
        if (Q22.isFinishing()) {
            return;
        }
        Q22.finish();
    }

    private void d0() {
        if (this.f14145r.size() < this.f14129b.getAdapter().getCount()) {
            return;
        }
        if ((!this.f14110D && this.f14108B && !this.f14112F.h()) || this.f14129b.getAdapter().getCount() != this.f14151x) {
            Slog.d("SStoFlexible", "notifyMaskReady mScaleMoved && mScaleEnd && !mScaleMoveSpringAni");
            i0();
            return;
        }
        if (this.f14141n == null && this.f14110D) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f14145r);
            this.f14145r.clear();
            for (EmbeddedViewDecor embeddedViewDecor : this.f14115I) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.f14169f == embeddedViewDecor) {
                        this.f14145r.add(bVar);
                    }
                }
            }
            q0();
            if (this.f14110D) {
                p0();
            }
        }
    }

    private void e0(final boolean z3) {
        List list = this.f14115I;
        if (list == null) {
            return;
        }
        final int size = list.size();
        final List C3 = C();
        final int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Intent) C3.get(i3)).getIntExtra("androidx.activity.LaunchEmbeddedTaskId", 0);
        }
        C0305a.a().b(new Runnable() { // from class: x1.h
            @Override // java.lang.Runnable
            public final void run() {
                r.this.W(size, z3, C3, iArr);
            }
        });
    }

    private void h0(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    private void i0() {
        o0(6);
        Z.c cVar = this.f14112F;
        if (cVar != null && cVar.h()) {
            this.f14112F.c();
        }
        Z.c cVar2 = this.f14141n;
        if (cVar2 != null && cVar2.h()) {
            this.f14141n.c();
        }
        Z.c cVar3 = this.f14142o;
        if (cVar3 != null && cVar3.h()) {
            this.f14142o.c();
        }
        Iterator it = this.f14145r.iterator();
        while (it.hasNext()) {
            ((b) it.next()).e();
        }
        j0();
        Log.d("SStoFlexible", "resetAll " + Debug.getCallers(6));
        this.f14145r.clear();
        this.f14111E.clear();
        n0(false);
        this.f14144q.apply();
        this.f14129b.setIsToFlexibleAnimating(false);
        l0(false);
        m0(false);
        synchronized (this.f14119M) {
            this.f14118L = null;
        }
        this.f14149v = false;
        this.f14110D = false;
        this.f14141n = null;
        this.f14142o = null;
        o0(0);
        this.f14152y = 0;
        this.f14147t = false;
        this.f14109C = true;
        if (this.f14129b.Q2(this.f14128a).t0() == 3) {
            this.f14129b.invalidate();
            this.f14129b.setSplitBarVisibility(0);
            ContainerView containerView = this.f14129b;
            containerView.R(containerView.getAdapter().h());
        }
    }

    private void j0() {
        this.f14133f.setScaleX(this.f14134g);
        this.f14133f.setScaleY(this.f14135h);
        this.f14133f.setTranslationX(this.f14136i);
        this.f14133f.setTranslationY(this.f14137j);
    }

    private void l0(boolean z3) {
        synchronized (this.f14119M) {
            this.f14116J = z3;
        }
    }

    private void m0(boolean z3) {
        synchronized (this.f14119M) {
            this.f14117K = z3;
        }
    }

    private void o0(int i3) {
        synchronized (this.f14119M) {
            this.f14113G = i3;
        }
    }

    private void q0() {
        Log.d("SStoFlexible", "startFadeInAnimation mInit:" + this.f14147t);
        if (this.f14147t) {
            D();
            o0(2);
            final float k3 = B1.s.k(0.02f);
            final List H3 = this.f14129b.f10732G.H();
            Z.c cVar = new Z.c(new B.d(0.0f));
            this.f14141n = cVar;
            cVar.B(new Z.d().f(1.0f).g(f14097Y).e(f14095W));
            this.f14141n.m(0.00390625f);
            this.f14141n.b(new b.r() { // from class: x1.m
                @Override // Z.b.r
                public final void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                    r.this.a0(k3, H3, bVar, f3, f4);
                }
            });
            this.f14141n.a(new b.q() { // from class: x1.n
                @Override // Z.b.q
                public final void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
                    r.this.b0(H3, bVar, z3, f3, f4);
                }
            });
            this.f14141n.u(1.0f);
            this.f14141n.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void Z() {
        String str = "positionChangeToSplit onAnimationEnd result:";
        int H3 = H();
        String str2 = "SStoFlexible";
        if (H3 == 0 || H3 == 6) {
            Log.i("SStoFlexible", "startFlexibleTaskMaskFadeOut return state:" + H3);
            return;
        }
        o0(5);
        Runnable runnable = this.f14125S;
        if (runnable != null) {
            this.f14146s.removeCallbacks(runnable);
            this.f14125S = null;
        }
        boolean z3 = false;
        try {
            z3 = s0();
            if (z3) {
                Handler handler = this.f14146s;
                Runnable runnable2 = new Runnable() { // from class: x1.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.this.c0();
                    }
                };
                handler.postAtFrontOfQueue(runnable2);
                str = handler;
                str2 = runnable2;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        } finally {
            Slog.d(str2, str + z3);
        }
        if (z3) {
            return;
        }
        j0();
        i0();
    }

    private OplusAppInfo u0(List list) {
        ApplicationInfo applicationInfo;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Integer.valueOf(((EmbeddedViewDecor) it.next()).getTaskData().s()));
        }
        OplusAppInfo oplusAppInfo = null;
        try {
            this.f14150w = 0;
            List<OplusAppInfo> allTopAppInfos = OplusActivityTaskManager.getInstance().getAllTopAppInfos();
            if (allTopAppInfos != null && !allTopAppInfos.isEmpty()) {
                for (OplusAppInfo oplusAppInfo2 : allTopAppInfos) {
                    if (oplusAppInfo2.windowingMode == 1 && !hashSet.contains(Integer.valueOf(oplusAppInfo2.taskId)) && oplusAppInfo2.taskId != B1.l.O1(this.f14128a).u0() && oplusAppInfo2.displayId == 0 && (applicationInfo = oplusAppInfo2.appInfo) != null && !f14106h0.contains(applicationInfo.packageName)) {
                        try {
                            I(oplusAppInfo2);
                            oplusAppInfo = oplusAppInfo2;
                        } catch (Exception e3) {
                            e = e3;
                            oplusAppInfo = oplusAppInfo2;
                            Log.e("SStoFlexible", "getAllTopAppInfos error", e);
                            return oplusAppInfo;
                        }
                    } else if (oplusAppInfo2.windowingMode == 100) {
                        this.f14150w++;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        return oplusAppInfo;
    }

    private void v(b bVar, int i3, ArrayList arrayList) {
        C0601d taskData = bVar.f14169f.getTaskData();
        Intent f3 = taskData.f();
        f3.putExtra("androidx.activity.LaunchEmbeddedTaskId", taskData.s());
        f3.putExtra("androidx.flexible.userId", taskData.v());
        if (taskData.u() || bVar.f14169f.getLaunchRect().equals(taskData.i())) {
            f3.putExtra("androidx.canvas.to.multi.flexible.full.ratio", true);
            Log.d("SStoFlexible", "addFlexibleTaskInfo intent:" + f3 + " useMax");
        }
        Rect launchRect = bVar.f14169f.getLaunchRect();
        if (launchRect.width() > launchRect.height()) {
            f3.putExtra("androidx.canvas.to.multi.flexible.orientation", 0);
        } else if (launchRect.width() < launchRect.height()) {
            f3.putExtra("androidx.canvas.to.multi.flexible.orientation", 1);
        }
        arrayList.add(f3);
        a aVar = new a();
        aVar.f14159f = taskData.s();
        aVar.f14154a = bVar.f14169f;
        aVar.f14155b = bVar.f14166c;
        aVar.f14156c = bVar.f14164a;
        aVar.f14157d = bVar.f14167d;
        aVar.f14158e = new Rect(bVar.f14170g);
        this.f14111E.add(i3, aVar);
    }

    private void v0(ArrayList arrayList) {
        int size = this.f14145r.size();
        for (int i3 = 0; i3 < size; i3++) {
            v((b) this.f14145r.get(G(i3)), i3, arrayList);
        }
    }

    private void w() {
        final List C3 = C();
        int size = C3.size();
        final int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = ((Intent) C3.get(i3)).getIntExtra("androidx.activity.LaunchEmbeddedTaskId", 0);
        }
        if (this.f14130c > 0.98f || this.f14118L != null) {
            return;
        }
        C0305a.a().b(new Runnable() { // from class: x1.l
            @Override // java.lang.Runnable
            public final void run() {
                r.this.R(C3, iArr);
            }
        });
    }

    private void w0(float f3, float f4) {
        if (B1.l.f201a.booleanValue()) {
            Log.d("SStoFlexible", "updateChangeAnimation value:" + f3);
        }
        if (f3 >= f4) {
            float f5 = (f3 - f4) / (1.0f - f4);
            Iterator it = this.f14145r.iterator();
            while (it.hasNext()) {
                ((b) it.next()).d(this.f14144q, f5);
            }
            return;
        }
        float f6 = f14102d0;
        float f7 = f6 - (f3 * (f6 - f14101c0));
        Iterator it2 = this.f14145r.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).b(this.f14144q, f7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] x(float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        int width = this.f14122P.width();
        int height = this.f14122P.height();
        float f8 = this.f14136i;
        if (f8 < 0.0f) {
            f4 = width;
            f5 = this.f14134g;
        } else {
            f4 = this.f14138k;
            f5 = this.f14134g;
        }
        float f9 = f8 + (((f4 * f5) * (1.0f - f3)) / 2.0f);
        float f10 = this.f14137j;
        if (f10 < 0.0f) {
            f6 = height;
            f7 = this.f14134g;
        } else {
            f6 = this.f14139l;
            f7 = this.f14134g;
        }
        return new float[]{f9, f10 + (((f6 * f7) * (1.0f - f3)) / 2.0f)};
    }

    private void y(final EmbeddedViewDecor embeddedViewDecor, final int i3) {
        final SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        final FlexibleTaskView flexibleTaskView = embeddedViewDecor.getFlexibleTaskView();
        int width = flexibleTaskView.getWidth();
        int height = flexibleTaskView.getHeight();
        final SurfaceControl build = new SurfaceControl.Builder(this.f14143p).setContainerLayer().setParent(flexibleTaskView.getSurfaceControl()).setName("wholeSurface_" + embeddedViewDecor.getTaskData().s()).setCallsite("createLeash").setHidden(false).build();
        final SurfaceControl build2 = new SurfaceControl.Builder(this.f14143p).setContainerLayer().setParent(build).setName("snapshot_" + embeddedViewDecor.getTaskData().s()).setCallsite("createLeash").setHidden(false).build();
        final SurfaceControl build3 = new SurfaceControl.Builder(this.f14143p).setParent(build).setBufferSize(width, height).setFormat(2).setName("mask_t" + embeddedViewDecor.getTaskData().s()).setCallsite("createLeash").setHidden(false).build();
        Bitmap E02 = this.f14129b.E0(i3, 0.2f);
        if (E02 == null) {
            transaction.remove(build3).remove(build2).remove(build).apply();
            return;
        }
        z(width, height, E02, build2, transaction);
        Bitmap W3 = B1.l.W(E02, f14094V);
        z(width, height, W3, build3, transaction);
        Bitmap A3 = A(embeddedViewDecor.getTaskData().e());
        SurfaceControl.Builder parent = new SurfaceControl.Builder(this.f14143p).setParent(build);
        int i4 = this.f14140m;
        final SurfaceControl build4 = parent.setBufferSize(i4, i4).setFormat(2).setName("icon_" + embeddedViewDecor.getTaskData().s()).setCallsite("createLeash").setHidden(false).build();
        int i5 = this.f14140m;
        B1.l.z(build4, transaction, A3, i5, i5, -1, 0);
        SurfaceControl.Transaction reparent = transaction.reparent(build4, build3);
        int i6 = this.f14140m;
        reparent.setPosition(build4, (width - i6) / 2, (height - i6) / 2);
        transaction.setAlpha(build3, 0.0f).setAlpha(build2, 0.0f);
        transaction.reparent(build3, build);
        transaction.setLayer(build, 2147483646).setLayer(build2, 0).setLayer(build3, 1);
        transaction.apply();
        h0(E02);
        h0(W3);
        h0(A3);
        this.f14146s.post(new Runnable() { // from class: x1.p
            @Override // java.lang.Runnable
            public final void run() {
                r.this.S(transaction, build4, build3, build2, build, embeddedViewDecor, i3, flexibleTaskView);
            }
        });
    }

    public int H() {
        int i3;
        synchronized (this.f14119M) {
            i3 = this.f14113G;
        }
        return i3;
    }

    public void J() {
        if (this.f14129b.getViewRootImpl() == null || this.f14129b.Q2(this.f14128a).t0() != 3 || this.f14128a.getResources().getConfiguration().windowConfiguration.getBounds().left < 0) {
            Log.i("SStoFlexible", "init failed,getViewRootImpl" + this.f14129b.getViewRootImpl() + ",state:" + this.f14129b.Q2(this.f14128a).t0() + ",left:" + this.f14128a.getResources().getConfiguration().windowConfiguration.getBounds().left);
            return;
        }
        if (this.f14129b.getCanvasMaskManager().I() != 0 || this.f14129b.getCanvasMaskManager().R()) {
            Log.i("SStoFlexible", "canvas is in mask animation");
            return;
        }
        ContainerView containerView = this.f14129b;
        if (containerView.f10755S) {
            Log.i("SStoFlexible", "canvas is during transform");
            return;
        }
        E e3 = containerView.f10732G;
        if (e3 != null && e3.Z()) {
            Log.i("SStoFlexible", "guide dialog is showing");
            return;
        }
        List<EmbeddedViewDecor> childEmbeddedViewList = this.f14129b.getChildEmbeddedViewList();
        this.f14115I = childEmbeddedViewList;
        if (childEmbeddedViewList.isEmpty() || this.f14115I.size() < 2) {
            Log.i("SStoFlexible", "init failed size:" + this.f14115I.size());
            return;
        }
        for (EmbeddedViewDecor embeddedViewDecor : this.f14115I) {
            if (!embeddedViewDecor.getInitialized() || !embeddedViewDecor.O()) {
                Log.i("SStoFlexible", "init failed getInitialized:" + embeddedViewDecor.getInitialized());
                return;
            }
        }
        boolean z3 = false;
        int i3 = 0;
        while (i3 < this.f14115I.size()) {
            int i4 = i3 + 1;
            for (int i5 = i4; i5 < this.f14115I.size(); i5++) {
                if (((EmbeddedViewDecor) this.f14115I.get(i3)).getTaskData().s() == ((EmbeddedViewDecor) this.f14115I.get(i5)).getTaskData().s()) {
                    return;
                }
            }
            i3 = i4;
        }
        this.f14151x = this.f14115I.size();
        OplusAppInfo u02 = u0(this.f14115I);
        if (u02 != null) {
            Slog.w("SStoFlexible", "init has top app " + u02);
            return;
        }
        try {
            Bundle splitScreenStatus = OplusActivityTaskManager.getInstance().getSplitScreenStatus("splitScreenAnimationStateChanged");
            if (splitScreenStatus != null && splitScreenStatus.getBoolean("isFlexibleAnimationState", false)) {
                Log.d("SStoFlexible", "getSplitScreenStatus animation running");
                return;
            }
        } catch (RemoteException unused) {
            Log.e("SStoFlexible", "getSplitScreenStatus failed");
        }
        this.f14123Q = this.f14129b.getAdapter().l();
        this.f14124R = this.f14129b.getAdapter().h();
        List<C0601d> j3 = B1.l.j(this.f14123Q);
        if (!j3.isEmpty()) {
            this.f14149v = true;
            this.f14153z = new StringBuilder();
            for (C0601d c0601d : j3) {
                if (j3.indexOf(c0601d) != 0) {
                    this.f14153z.append(",");
                }
                this.f14153z.append(B1.l.H(this.f14128a.getPackageManager(), null, c0601d.k(), OplusMultiAppManager.getInstance().isMultiAppUserId(c0601d.v()), c0601d.v()));
            }
        }
        this.f14109C = false;
        SurfaceControl updateAndGetBoundsLayer = this.f14129b.getViewRootImpl().updateAndGetBoundsLayer(this.f14144q);
        this.f14132e = updateAndGetBoundsLayer;
        if (updateAndGetBoundsLayer == null || !updateAndGetBoundsLayer.isValid()) {
            return;
        }
        this.f14122P.set(this.f14129b.getRectListUnion());
        this.f14107A = 1.0f;
        this.f14152y = 0;
        this.f14146s = new Handler(Looper.getMainLooper());
        this.f14148u = false;
        this.f14108B = false;
        this.f14130c = 1.0f;
        this.f14131d = 1.0f;
        this.f14134g = this.f14133f.getScaleX();
        this.f14135h = this.f14133f.getScaleY();
        this.f14136i = this.f14133f.getTranslationX();
        this.f14137j = this.f14133f.getTranslationY();
        WindowManager windowManager = (WindowManager) this.f14128a.getSystemService("window");
        this.f14139l = windowManager.getMaximumWindowMetrics().getBounds().height();
        this.f14138k = windowManager.getMaximumWindowMetrics().getBounds().width();
        this.f14129b.setIsToFlexibleAnimating(true);
        if (B1.s.J(this.f14128a) && B1.l.u0()) {
            z3 = true;
        }
        this.f14126T = z3;
        if (z3) {
            this.f14127U = B1.l.O1(this.f14128a).G0();
        }
        if (!this.f14149v) {
            for (final EmbeddedViewDecor embeddedViewDecor2 : this.f14115I) {
                C0305a.a().b(new Runnable() { // from class: x1.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.this.T(embeddedViewDecor2);
                    }
                });
            }
        }
        this.f14114H = this.f14129b.getAdapter().n();
        this.f14112F = M(1.0f, 1.0f);
        o0(1);
        this.f14147t = true;
        Log.d("SStoFlexible", "init end");
    }

    public boolean N() {
        return this.f14109C;
    }

    public boolean O() {
        return (this.f14141n == null && this.f14142o == null) ? false : true;
    }

    public boolean P() {
        return this.f14147t && !this.f14108B;
    }

    public boolean Q() {
        boolean z3;
        synchronized (this.f14120N) {
            z3 = this.f14121O;
        }
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0140, code lost:
    
        if (r8 < r0) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f0(android.view.ScaleGestureDetector r8, int r9) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.r.f0(android.view.ScaleGestureDetector, int):void");
    }

    public void g0() {
        Log.d("SStoFlexible", "onScaleEnd mInitMaskSurface:" + this.f14148u + " mChangeToState:" + this.f14152y + ",mScaleEnd:" + this.f14108B + ",mInit:" + this.f14147t + ",mScaleMoved:" + this.f14110D + ",mNotSupportZoom:" + this.f14149v + " mChangeToFlexibleTaskAnimation:" + this.f14142o + " " + Debug.getCallers(3));
        if (!this.f14147t || this.f14108B) {
            return;
        }
        this.f14108B = true;
        if (this.f14152y == 0 || this.f14152y == 2) {
            i0();
            return;
        }
        if (!this.f14149v && this.f14110D) {
            Z.c cVar = this.f14142o;
            if (cVar != null) {
                cVar.x().g(f14100b0);
                this.f14142o.u(1.0f);
            }
            e0(true);
            return;
        }
        Log.d("SStoFlexible", "onScaleEnd mNotSupportZoom:" + this.f14149v + " mScaleMoved:" + this.f14110D);
        this.f14112F.x().g(f14104f0);
        this.f14112F.u(1.0f);
    }

    public void k0(int i3) {
        Slog.d("SStoFlexible", "setChangeToState:" + i3 + " " + Debug.getCallers(3));
        this.f14152y = i3;
    }

    public void n0(boolean z3) {
        Z.c cVar;
        Runnable runnable;
        synchronized (this.f14120N) {
            try {
                this.f14121O = z3;
                if (z3 && this.f14108B && (cVar = this.f14142o) != null && !cVar.h() && (runnable = this.f14125S) != null) {
                    this.f14146s.postDelayed(runnable, 20L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void p0() {
        if (this.f14142o == null && this.f14147t && this.f14113G != 4) {
            o0(4);
            final float k3 = B1.s.k(0.2f);
            Z.c cVar = this.f14112F;
            if (cVar != null && cVar.h()) {
                this.f14112F.c();
            }
            float f3 = f14102d0;
            float f4 = f3 - f14103e0;
            float f5 = f14101c0;
            final float f6 = f4 / (f3 - f5);
            float f7 = (f3 - this.f14107A) / (f3 - f5);
            Slog.d("SStoFlexible", "startChangeAnimationToFlexibleTask start mAnimationScale:" + this.f14107A + " mScaleEnd:" + this.f14108B + " startScale:" + f7 + " changeScale:" + f6);
            for (int i3 = 0; i3 < this.f14145r.size(); i3++) {
                ((b) this.f14145r.get(i3)).c();
                w0(f7, f6);
            }
            Z.c cVar2 = new Z.c(new B.d(f7));
            this.f14142o = cVar2;
            cVar2.B(new Z.d().f(f7).g(f14098Z).e(f14095W));
            this.f14142o.m(f14096X);
            this.f14142o.b(new b.r() { // from class: x1.i
                @Override // Z.b.r
                public final void onAnimationUpdate(Z.b bVar, float f8, float f9) {
                    r.this.Y(f6, k3, bVar, f8, f9);
                }
            });
            this.f14142o.a(new b.q() { // from class: x1.j
                @Override // Z.b.q
                public final void onAnimationEnd(Z.b bVar, boolean z3, float f8, float f9) {
                    r.this.X(bVar, z3, f8, f9);
                }
            });
            if (this.f14108B) {
                this.f14142o.x().g(f14100b0);
                f7 = 1.0f;
            }
            this.f14142o.u(f7);
            this.f14142o.r();
            synchronized (this.f14119M) {
                try {
                    if (!F()) {
                        e0(false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public boolean s0() {
        int size = this.f14111E.size();
        int[] iArr = new int[size];
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[size];
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>();
        int[] iArr2 = new int[3];
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = (a) this.f14111E.get(i3);
            if (aVar.f14163j) {
                arrayList7.add(aVar);
            } else {
                arrayList6.add(aVar);
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList6.size(); i5++) {
            a aVar2 = (a) arrayList6.get(i5);
            iArr[i4] = aVar2.f14159f;
            arrayList.add(aVar2.f14160g);
            fArr[i4] = aVar2.f14161h;
            arrayList2.add(aVar2.f14155b);
            arrayList3.add(aVar2.f14156c);
            arrayList4.add(aVar2.f14157d);
            arrayList5.add(aVar2.f14158e);
            iArr2[i4] = aVar2.f14162i;
            i4++;
        }
        for (int i6 = 0; i6 < arrayList7.size(); i6++) {
            a aVar3 = (a) arrayList7.get(i6);
            iArr[i4] = aVar3.f14159f;
            arrayList.add(aVar3.f14160g);
            fArr[i4] = aVar3.f14161h;
            arrayList2.add(aVar3.f14155b);
            arrayList3.add(aVar3.f14156c);
            arrayList4.add(aVar3.f14157d);
            arrayList5.add(aVar3.f14158e);
            iArr2[i4] = aVar3.f14162i;
            i4++;
        }
        bundle.putParcelableArrayList("mask_surface_list", arrayList3);
        bundle.putParcelableArrayList("whole_surface_list", arrayList2);
        bundle.putParcelableArrayList("mask_rect_list", arrayList5);
        bundle.putParcelableArrayList("icon_surface_list", arrayList4);
        bundle.putIntArray("corner_radius_array", iArr2);
        bundle.putInt("androidx.canvas.task.pending.remove", this.f14129b.Q2(this.f14128a).u0());
        Log.d("SStoFlexible", "startMultiFlexibleTask " + Arrays.toString(iArr) + Arrays.asList(arrayList) + " " + Arrays.toString(fArr));
        return B1.l.t0(iArr, arrayList, fArr, bundle);
    }

    public void t0() {
        int i3 = this.f14113G;
        if (i3 == 0) {
            return;
        }
        if (i3 >= 4 || F()) {
            if (!this.f14108B) {
                g0();
            }
            Z.c cVar = this.f14142o;
            if (cVar == null || !cVar.h()) {
                return;
            }
            this.f14142o.C();
            return;
        }
        this.f14110D = false;
        Slog.d("SStoFlexible", "stopAnimation");
        for (int i4 = 0; i4 < this.f14145r.size(); i4++) {
            ((b) this.f14145r.get(i4)).f14169f.setVisibility(0);
        }
        i0();
    }

    public void z(int i3, int i4, Bitmap bitmap, SurfaceControl surfaceControl, SurfaceControl.Transaction transaction) {
        int i5 = this.f14128a.getResources().getConfiguration().uiMode;
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i3, i4);
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(i3 / bitmap.getWidth(), i4 / bitmap.getHeight());
            beginRecording.drawBitmap(bitmap, matrix, null);
        } else if ((i5 & 32) != 0) {
            beginRecording.drawColor(Color.parseColor("#333333"));
        } else {
            beginRecording.drawColor(Color.parseColor("#F0F1F2"));
        }
        picture.endRecording();
        HardwareBuffer hardwareBuffer = Bitmap.createBitmap(picture).getHardwareBuffer();
        if (surfaceControl == null || !surfaceControl.isValid()) {
            return;
        }
        transaction.setBuffer(surfaceControl, hardwareBuffer);
        transaction.setColorSpace(surfaceControl, ColorSpace.get(ColorSpace.Named.SRGB));
        transaction.setAlpha(surfaceControl, 0.0f);
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
        }
        transaction.apply();
    }
}
