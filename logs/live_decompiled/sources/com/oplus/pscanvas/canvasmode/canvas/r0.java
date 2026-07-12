package com.oplus.pscanvas.canvasmode.canvas;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.SystemProperties;
import android.util.Log;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u1.C0600c;
import u1.C0601d;

/* loaded from: classes.dex */
public class r0 {

    /* renamed from: f, reason: collision with root package name */
    private static final String f10608f = "r0";

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f10609g = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: a, reason: collision with root package name */
    private ContainerView f10610a;

    /* renamed from: b, reason: collision with root package name */
    private C0600c f10611b;

    /* renamed from: c, reason: collision with root package name */
    private b f10612c;

    /* renamed from: d, reason: collision with root package name */
    private FlexibleWindowManager f10613d;

    /* renamed from: e, reason: collision with root package name */
    private ContainerActivity f10614e;

    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f10615a;

        a(Context context) {
            this.f10615a = context;
        }

        @Override // com.oplus.pscanvas.canvasmode.canvas.r0.b
        public void a(List list) {
            Log.d(r0.f10608f, "onEnterThreeSplitTogether");
            r0.this.f10610a.e3(this.f10615a, list, 3);
        }

        @Override // com.oplus.pscanvas.canvasmode.canvas.r0.b
        public void b(List list) {
            Log.d(r0.f10608f, "onExitThreeSplitTogether");
            r0.this.f10610a.e3(this.f10615a, list, 0);
        }
    }

    public interface b {
        void a(List list);

        void b(List list);
    }

    private boolean y() {
        C0601d c0601d;
        boolean z3;
        if (this.f10610a.getAdapter().t() != 1 || k() != 2) {
            return false;
        }
        Iterator it = this.f10610a.getAdapter().l().iterator();
        while (it.hasNext() && (c0601d = (C0601d) it.next()) != null) {
            if ("com.oplus.wpslauncher".equals(c0601d.k())) {
                if (this.f10610a.getAdapter().z()) {
                    g();
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!c0601d.u()) {
                    return z3;
                }
                c0601d.o0(false);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i3) {
        if (i3 <= 1) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isInSplitScreenMode", false);
            bundle.putInt("pocketSplitScreenType", -1);
            bundle.putIntegerArrayList("taskIdList", null);
            try {
                ContainerActivity containerActivity = this.f10614e;
                if (containerActivity != null) {
                    this.f10613d.notifyFlexibleSplitScreenStateChanged("splitScreenModeChange", bundle, containerActivity.u0());
                    return;
                }
                return;
            } catch (Error | Exception e3) {
                Log.e(f10608f, "notifyFlexibleSplitScreenStateChanged error: " + e3);
                return;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("isInSplitScreenMode", true);
        bundle2.putInt("pocketSplitScreenType", i3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i4 = 0; i4 < i3; i4++) {
            C0600c c0600c = this.f10611b;
            if (c0600c != null && c0600c.getItem(i4) != null) {
                arrayList.add(Integer.valueOf(this.f10611b.getItem(i4).s()));
            }
        }
        bundle2.putIntegerArrayList("taskIdList", arrayList);
        try {
            ContainerActivity containerActivity2 = this.f10614e;
            if (containerActivity2 != null) {
                this.f10613d.notifyFlexibleSplitScreenStateChanged("splitScreenModeChange", bundle2, containerActivity2.u0());
            }
        } catch (Error | Exception e4) {
            Log.e(f10608f, "notifyFlexibleSplitScreenStateChanged error: " + e4);
        }
    }

    public void A(final int i3) {
        if (this.f10613d == null) {
            this.f10613d = FlexibleWindowManager.getInstance();
        }
        Log.d(f10608f, "current flexible task size:" + i3);
        C0305a.a().c(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.q0
            @Override // java.lang.Runnable
            public final void run() {
                r0.this.z(i3);
            }
        });
    }

    public void B(C0601d c0601d) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null || c0601d == null) {
            Log.e(f10608f, "container remove params is invalid");
            return;
        }
        c0600c.remove(c0601d);
        this.f10610a.o2();
        J();
        A(this.f10611b.getCount());
    }

    public void C() {
        this.f10611b.F();
    }

    public void D() {
        this.f10611b.G();
    }

    public void E(Context context, ContainerView containerView) {
        if (containerView != null) {
            this.f10610a = containerView;
            this.f10612c = new a(context);
            C0600c c0600c = new C0600c(context, 0, new ArrayList(), this.f10612c);
            this.f10611b = c0600c;
            this.f10614e = (ContainerActivity) context;
            this.f10610a.setAdapter(c0600c);
            this.f10613d = FlexibleWindowManager.getInstance();
        }
    }

    public void F(int i3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else {
            c0600c.H(i3);
        }
    }

    public void G(C0601d c0601d) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else {
            c0600c.J(c0601d);
        }
    }

    public void H(int i3) {
        this.f10611b.L(i3);
    }

    public void I(int i3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else {
            c0600c.M(i3);
        }
    }

    public void J() {
        if (!f10609g.booleanValue() || this.f10610a == null || this.f10611b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int count = this.f10611b.getCount();
        sb.append("mode:" + count);
        for (int i3 = 0; i3 < count; i3++) {
            if (this.f10611b.getItem(i3) != null && this.f10611b.getItem(i3).f() != null && this.f10611b.getItem(i3).f().getComponent() != null) {
                sb.append("|sort:" + this.f10611b.getItem(i3).f().getComponent().getPackageName());
            }
        }
        this.f10610a.setContentDescription(sb.toString());
    }

    public void K(int i3) {
        this.f10611b.O(i3);
    }

    public void L(int i3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else {
            c0600c.P(i3);
        }
    }

    public void M(List list, float f3, int i3) {
        if (y()) {
            Log.d(f10608f, "setSteplessSplitRatio ignore for oplus wps in port.");
            return;
        }
        if (list.size() != 2) {
            return;
        }
        Context context = this.f10610a.getContext();
        boolean z3 = B1.l.C0(context, (C0601d) list.get(0), i3) || B1.l.C0(context, (C0601d) list.get(1), i3);
        if (!z3 && f3 >= ContainerView.f10716U0 && f3 <= ContainerView.f10715T0) {
            this.f10610a.a3(f3);
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((C0601d) list.get(i4)).q0(true);
            }
            f(f3, i3);
            return;
        }
        Log.d(f10608f, "setSteplessSplitRatio isLargeOrSmallDisable: " + z3 + ", splitRatio: " + f3);
    }

    public void N(int i3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else {
            c0600c.Q(i3);
        }
    }

    public void O(boolean z3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else if (c0600c.getCount() > 3 || this.f10611b.getCount() < 2) {
            Log.e(f10608f, "count is invalid");
        } else {
            this.f10611b.T(false, false, z3);
        }
    }

    public void P(C0601d c0601d, int i3, boolean z3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
            return;
        }
        if (i3 >= c0600c.getCount() || i3 < 0) {
            Log.e(f10608f, "updateFlexibleTask update index invalid");
            return;
        }
        this.f10610a.setNeedUpdateFlexibleTaskViewFrameFlag(true);
        this.f10611b.Z(c0601d, i3, z3);
        this.f10610a.o2();
        J();
    }

    public void d(C0601d c0601d) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null || c0601d == null) {
            Log.e(f10608f, "container add params is invalid");
            return;
        }
        if (c0600c.getCount() >= 3) {
            Log.e(f10608f, "count is max");
            return;
        }
        this.f10611b.c(c0601d);
        this.f10611b.D();
        this.f10611b.add(c0601d);
        J();
        this.f10610a.o2();
        A(this.f10611b.getCount());
    }

    public void e(List list, float f3, int i3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null || list == null) {
            Log.e(f10608f, "container add params is invalid");
            return;
        }
        if (c0600c.getCount() >= 3) {
            Log.e(f10608f, "count is max");
            return;
        }
        this.f10611b.b(list);
        this.f10611b.addAll(list);
        M(list, f3, i3);
        J();
        A(this.f10611b.getCount());
    }

    public void f(float f3, int i3) {
        if (y()) {
            Log.d(f10608f, "ignore Stepless UseMax for oplus wps in port.");
            return;
        }
        if (!this.f10610a.getAdapter().z()) {
            Log.d(f10608f, "is not steplessSplit");
            return;
        }
        if (f3 < ContainerView.f10716U0 || f3 > ContainerView.f10715T0) {
            Log.d(f10608f, "is not resizableTwoSplit or is inValid splitRatio: " + f3);
            g();
            return;
        }
        B1.m b3 = B1.n.a().b(this.f10610a.getContext());
        for (int i4 = 0; i4 < k(); i4++) {
            l(i4).j0(b3.b(i4, f3, this.f10610a, i3));
        }
        if (f10609g.booleanValue()) {
            Log.d(f10608f, "adjustSteplessRectBySplitRatio, splitRatio: " + f3 + ", layoutOrientation: " + i3 + ", taskDataRect0: " + l(0).n() + ", taskDataRect1: " + l(1).n() + Debug.getCallers(6));
        }
    }

    public void g() {
        int k3 = k();
        for (int i3 = 0; i3 < k3; i3++) {
            l(i3).q0(false);
        }
        if (f10609g.booleanValue()) {
            Log.d(f10608f, "clearSteplessProperity " + Debug.getCallers(6));
        }
    }

    public void h(C0601d c0601d) {
        if (this.f10610a == null || c0601d == null || !c0601d.H() || !B1.l.C0(this.f10610a.getContext(), c0601d, this.f10611b.t())) {
            return;
        }
        c0601d.q0(false);
        for (int i3 = 0; i3 < k(); i3++) {
            C0601d l3 = l(i3);
            if (l3 != null && l3.H() && l3.s() != c0601d.s()) {
                l3.q0(false);
            }
        }
    }

    public void i() {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
        } else {
            c0600c.e();
        }
    }

    public int j() {
        ContainerView containerView = this.f10610a;
        if (containerView != null) {
            return containerView.getContext().getUserId();
        }
        return 0;
    }

    public int k() {
        C0600c c0600c = this.f10611b;
        if (c0600c != null) {
            return c0600c.getCount();
        }
        Log.e(f10608f, "ContainerAdapter is null");
        return 0;
    }

    public C0601d l(int i3) {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
            return null;
        }
        if (i3 < c0600c.getCount() && i3 >= 0) {
            return this.f10611b.getItem(i3);
        }
        Log.e(f10608f, "getFlexibleTaskData update index invalid");
        return null;
    }

    public List m() {
        ArrayList arrayList = new ArrayList();
        ContainerView containerView = this.f10610a;
        if (containerView != null) {
            arrayList.addAll(containerView.getRectList());
        }
        return arrayList;
    }

    public int n() {
        C0600c c0600c = this.f10611b;
        if (c0600c != null) {
            return c0600c.h();
        }
        Log.e(f10608f, "ContainerAdapter is null");
        return -1;
    }

    public C0601d o() {
        C0600c c0600c = this.f10611b;
        if (c0600c == null) {
            Log.e(f10608f, "ContainerAdapter is null");
            return null;
        }
        int h3 = c0600c.h();
        if (h3 < this.f10611b.getCount() && h3 >= 0) {
            return this.f10611b.getItem(h3);
        }
        Log.e(f10608f, "get TaskData with index: " + h3 + " invalid");
        return null;
    }

    public int p() {
        return this.f10611b.m();
    }

    public int q() {
        C0600c c0600c = this.f10611b;
        if (c0600c != null) {
            return c0600c.n();
        }
        Log.e(f10608f, "ContainerAdapter is null");
        return -1;
    }

    public int r(C0601d c0601d) {
        return this.f10611b.p(c0601d);
    }

    public C0601d s(int i3) {
        return this.f10611b.o(i3);
    }

    public int t() {
        return this.f10611b.s();
    }

    public int u(C0601d c0601d) {
        C0600c c0600c = this.f10611b;
        if (c0600c != null) {
            return c0600c.getPosition(c0601d);
        }
        Log.e(f10608f, "ContainerAdapter is null");
        return -1;
    }

    public int v(int i3) {
        if (this.f10611b == null) {
            Log.e(f10608f, "ContainerAdapter is null");
            return -1;
        }
        for (int i4 = 0; i4 < this.f10611b.getCount(); i4++) {
            if (this.f10611b.getItem(i4).s() == i3) {
                return i4;
            }
        }
        return -1;
    }

    public int w() {
        return this.f10611b.t();
    }

    public int x() {
        C0600c c0600c = this.f10611b;
        if (c0600c != null) {
            return c0600c.u();
        }
        Log.e(f10608f, "ContainerAdapter is null");
        return -1;
    }
}
