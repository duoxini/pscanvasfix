package x1;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import u1.C0600c;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private Context f14426a;

    /* renamed from: b, reason: collision with root package name */
    private ContainerView f14427b;

    /* renamed from: c, reason: collision with root package name */
    private C0600c f14428c;

    /* renamed from: d, reason: collision with root package name */
    private EmbeddedViewDecor f14429d;

    /* renamed from: f, reason: collision with root package name */
    private x f14431f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14434i;

    /* renamed from: e, reason: collision with root package name */
    private PointF f14430e = new PointF();

    /* renamed from: g, reason: collision with root package name */
    private final SurfaceControl.Transaction f14432g = new SurfaceControl.Transaction();

    /* renamed from: h, reason: collision with root package name */
    private boolean f14433h = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14435j = false;

    public y(Context context, ContainerView containerView) {
        this.f14426a = context;
        this.f14427b = containerView;
        this.f14428c = containerView.getAdapter();
    }

    private void i(SurfaceControl.Transaction transaction) {
        for (int i3 = 0; i3 < this.f14428c.getCount(); i3++) {
            EmbeddedViewDecor q02 = this.f14427b.q0(i3);
            if (q02 != null && q02.getFlexibleTaskView() != null && q02.getFlexibleTaskView().getSurfaceControl() != null && q02.getFlexibleTaskView().getSurfaceControl().isValid()) {
                EmbeddedViewDecor embeddedViewDecor = this.f14429d;
                if (embeddedViewDecor == null || embeddedViewDecor.getTaskData() == null || q02.getTaskData() == null || this.f14429d.getTaskData().s() != q02.getTaskData().s()) {
                    transaction.setLayer(q02.getFlexibleTaskView().getSurfaceControl(), 1);
                } else {
                    transaction.setLayer(q02.getFlexibleTaskView().getSurfaceControl(), 2);
                }
                transaction.setCornerRadius(q02.getFlexibleTaskView().getSurfaceControl(), this.f14426a.getResources().getDisplayMetrics().density * 12.0f);
            }
        }
        transaction.apply();
    }

    public void a(C0631a c0631a, MotionEvent motionEvent) {
        if (this.f14429d != null) {
            this.f14431f.j0();
            float parentScaleX = this.f14427b.getParentScaleX();
            float parentScaleY = this.f14427b.getParentScaleY();
            float f3 = c0631a.g().x;
            float f4 = c0631a.g().y;
            if (Math.abs(f3 - this.f14430e.x) > 3.0f || Math.abs(f4 - this.f14430e.y) > 3.0f) {
                this.f14431f.e0((int) f3, (int) f4);
                EmbeddedViewDecor embeddedViewDecor = this.f14429d;
                embeddedViewDecor.setTranslationX(embeddedViewDecor.getTranslationX() + ((f3 - this.f14430e.x) / parentScaleX));
                EmbeddedViewDecor embeddedViewDecor2 = this.f14429d;
                embeddedViewDecor2.setTranslationY(embeddedViewDecor2.getTranslationY() + ((f4 - this.f14430e.y) / parentScaleY));
                this.f14430e.set(f3, f4);
                this.f14431f.L0(this.f14430e, c0631a);
            }
        }
    }

    public void b(C0631a c0631a, MotionEvent motionEvent) {
        this.f14431f.O0(c0631a.e(), c0631a.d());
        this.f14431f.v0();
        this.f14430e.set(c0631a.g().x, c0631a.g().y);
    }

    public void c(C0631a c0631a, MotionEvent motionEvent) {
        if (c0631a.j()) {
            if (this.f14433h) {
                a(c0631a, motionEvent);
                return;
            }
            i(this.f14432g);
            if (this.f14431f.y0()) {
                Log.d("ThreeSplitDragManager", "handleThreeSplitMove mHasLongPress=" + this.f14435j);
                this.f14427b.setSplitBarVisibility(4);
                this.f14427b.I0();
                this.f14433h = true;
                if (!this.f14434i) {
                    s.a(this.f14426a, 1, true);
                }
                if (this.f14435j) {
                    return;
                }
                this.f14431f.U0(false);
            }
        }
    }

    public void d(C0631a c0631a) {
        this.f14433h = false;
        if (c0631a.j()) {
            this.f14435j = false;
            this.f14431f.s0(false, c0631a);
            this.f14429d = null;
            return;
        }
        Log.d("ThreeSplitDragManager", "handleThreeSplitUp mHasLongPress=" + this.f14435j);
        if (!this.f14435j) {
            this.f14431f.H0();
        } else {
            this.f14431f.R0(true);
            this.f14435j = false;
        }
    }

    public void e(EmbeddedViewDecor embeddedViewDecor) {
        x xVar = new x(this.f14426a, this.f14428c, this.f14427b);
        this.f14431f = xVar;
        this.f14429d = embeddedViewDecor;
        xVar.N0(embeddedViewDecor);
        this.f14431f.P0(this.f14432g);
        this.f14434i = false;
    }

    public boolean f() {
        x xVar;
        return g() || ((xVar = this.f14431f) != null && xVar.A0());
    }

    public boolean g() {
        return this.f14433h;
    }

    public void h() {
        this.f14434i = true;
        this.f14435j = true;
        this.f14427b.setSplitBarVisibility(4);
        this.f14431f.p0();
    }
}
