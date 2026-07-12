package w1;

import B1.l;
import B1.s;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.pscanvas.canvasmode.canvas.database.CanvasTaskDatabase;
import com.oplus.pscanvas.canvasmode.canvas.r0;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import u1.C0601d;

/* renamed from: w1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0622f {

    /* renamed from: d, reason: collision with root package name */
    private static C0622f f13876d;

    /* renamed from: b, reason: collision with root package name */
    private Context f13878b;

    /* renamed from: a, reason: collision with root package name */
    private Executor f13877a = Executors.newFixedThreadPool(1);

    /* renamed from: c, reason: collision with root package name */
    private boolean f13879c = false;

    private C0622f(Context context) {
        this.f13878b = context;
    }

    private void A(int i3, List list, int i4, C0623g c0623g) {
        Intent intent;
        Intent intent2;
        if (i4 == 1) {
            intent = new Intent(Intent.parseUri(c0623g.l(), 0));
        } else if (i4 == 2) {
            intent = new Intent(Intent.parseUri(c0623g.m(), 0));
        } else {
            if (i4 != 3) {
                intent2 = null;
                if (intent2 != null || i3 >= list.size()) {
                }
                ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) list.get(i3);
                Intent intent3 = runningTaskInfo.baseIntent;
                if (intent3 == null || intent3.getComponent() == null || !runningTaskInfo.baseIntent.getComponent().equals(intent2.getComponent())) {
                    if (i4 == 1) {
                        c0623g.G(-1);
                        return;
                    } else if (i4 == 2) {
                        c0623g.H(-1);
                        return;
                    } else {
                        if (i4 != 3) {
                            return;
                        }
                        c0623g.I(-1);
                        return;
                    }
                }
                return;
            }
            intent = new Intent(Intent.parseUri(c0623g.n(), 0));
        }
        intent2 = intent;
        if (intent2 != null) {
        }
    }

    private Rect E(String str) {
        String[] split;
        Rect rect = new Rect();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length == 4) {
            rect.left = Integer.parseInt(split[0]);
            rect.top = Integer.parseInt(split[1]);
            rect.right = Integer.parseInt(split[2]);
            rect.bottom = Integer.parseInt(split[3]);
        }
        return rect;
    }

    private void f(String str, int i3) {
        List c3;
        if (TextUtils.isEmpty(str) || (c3 = CanvasTaskDatabase.C(this.f13878b).B().c()) == null || c3.size() == 0) {
            return;
        }
        Iterator it = c3.iterator();
        while (it.hasNext()) {
            i((C0623g) it.next(), str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void p() {
        InterfaceC0624h B3 = CanvasTaskDatabase.C(this.f13878b).B();
        List<C0623g> c3 = B3.c();
        if (c3.size() == 0) {
            this.f13879c = false;
            return;
        }
        try {
            List recentTasks = ActivityTaskManager.getInstance().getRecentTasks(48, 0, -3);
            if (recentTasks == null || recentTasks.size() == 0) {
                this.f13879c = false;
                return;
            }
            int[] iArr = new int[48];
            for (int i3 = 0; i3 < recentTasks.size(); i3++) {
                iArr[i3] = ((ActivityManager.RecentTaskInfo) recentTasks.get(i3)).taskId;
            }
            ArrayList arrayList = new ArrayList();
            for (final C0623g c0623g : c3) {
                if (!Arrays.stream(iArr).anyMatch(new IntPredicate() { // from class: w1.d
                    @Override // java.util.function.IntPredicate
                    public final boolean test(int i4) {
                        boolean q3;
                        q3 = C0622f.q(C0623g.this, i4);
                        return q3;
                    }
                })) {
                    B3.d(c0623g);
                    arrayList.add(c0623g);
                }
            }
            if (arrayList.size() > 0) {
                c3.removeAll(arrayList);
            }
            List tasks = ActivityTaskManager.getInstance().getTasks(48);
            if (tasks == null || tasks.size() == 0) {
                this.f13879c = false;
                return;
            }
            for (int i4 = 0; i4 < tasks.size(); i4++) {
                iArr[i4] = ((ActivityManager.RunningTaskInfo) tasks.get(i4)).taskId;
            }
            for (C0623g c0623g2 : c3) {
                int j3 = j(c0623g2.d(), iArr);
                if (j3 < 0) {
                    c0623g2.G(-1);
                } else {
                    try {
                        A(j3, tasks, 1, c0623g2);
                    } catch (Exception e3) {
                        Log.w("CanvasTaskDataManager", "clearNonExistentCanvasTask resetInvalidTaskId1 " + e3);
                    }
                }
                int j4 = j(c0623g2.e(), iArr);
                if (j4 < 0) {
                    c0623g2.H(-1);
                } else {
                    try {
                        A(j4, tasks, 2, c0623g2);
                    } catch (Exception e4) {
                        Log.w("CanvasTaskDataManager", "clearNonExistentCanvasTask resetInvalidTaskId2 " + e4);
                    }
                }
                if (c0623g2.f() > 0) {
                    int j5 = j(c0623g2.f(), iArr);
                    if (j5 < 0) {
                        c0623g2.G(-1);
                    } else {
                        try {
                            A(j5, tasks, 3, c0623g2);
                        } catch (Exception e5) {
                            Log.w("CanvasTaskDataManager", "clearNonExistentCanvasTask resetInvalidTaskId3 " + e5);
                        }
                    }
                }
                B3.b(c0623g2);
            }
            this.f13879c = false;
        } catch (Exception e6) {
            Log.e("CanvasTaskDataManager", "clearNonExistentCanvasTask error " + e6.getMessage());
            this.f13879c = false;
        }
    }

    private int h(int i3, String str, String str2, int i4, C0623g c0623g, List list) {
        if (str != null && str2 != null) {
            if (!list.contains(1) && str.equals(c0623g.s()) && str2.equals(c0623g.h()) && i4 == c0623g.A()) {
                return 1;
            }
            if (!list.contains(2) && str.equals(c0623g.t()) && str2.equals(c0623g.i()) && i4 == c0623g.B()) {
                return 2;
            }
            if (!list.contains(3) && str.equals(c0623g.u()) && str2.equals(c0623g.j()) && i4 == c0623g.C()) {
                return 3;
            }
            if (i3 > 0) {
                if (!list.contains(1) && i3 == c0623g.d()) {
                    return 1;
                }
                if (!list.contains(2) && i3 == c0623g.e()) {
                    return 2;
                }
                if (!list.contains(3) && i3 == c0623g.f()) {
                    return 3;
                }
            }
        }
        return -1;
    }

    private boolean i(C0623g c0623g, String str, int i3) {
        InterfaceC0624h B3 = CanvasTaskDatabase.C(this.f13878b).B();
        boolean z3 = true;
        if (str.equals(c0623g.s()) && i3 == c0623g.A()) {
            c0623g.V(null);
            c0623g.K(null);
            c0623g.G(-1);
            c0623g.U(0);
        } else if (str.equals(c0623g.t()) && i3 == c0623g.B()) {
            c0623g.W(null);
            c0623g.L(null);
            c0623g.H(-1);
            c0623g.U(0);
        } else if (str.equals(c0623g.u()) && i3 == c0623g.C()) {
            c0623g.X(null);
            c0623g.M(null);
            c0623g.I(-1);
            c0623g.U(0);
        } else {
            z3 = false;
        }
        if (z3) {
            B3.d(c0623g);
            w(this.f13878b, c0623g, false);
        }
        return z3;
    }

    private int j(int i3, int[] iArr) {
        int i4 = -1;
        if (i3 <= 0) {
            return -1;
        }
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (i3 == iArr[i5]) {
                i4 = i5;
            }
        }
        return i4;
    }

    public static synchronized C0622f k(Context context) {
        C0622f c0622f;
        synchronized (C0622f.class) {
            try {
                if (f13876d == null) {
                    f13876d = new C0622f(context.getApplicationContext());
                }
                c0622f = f13876d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0622f;
    }

    private List l(List list, C0623g c0623g) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0623g c0623g2 = (C0623g) it.next();
            arrayList2.clear();
            int h3 = h(c0623g.d(), c0623g.s(), c0623g.h(), c0623g.A(), c0623g2, arrayList2);
            if (h3 != -1) {
                arrayList2.add(Integer.valueOf(h3));
                int h4 = h(c0623g.e(), c0623g.t(), c0623g.i(), c0623g.B(), c0623g2, arrayList2);
                if (h4 != -1) {
                    arrayList2.add(Integer.valueOf(h4));
                    if (h(c0623g.f(), c0623g.u(), c0623g.j(), c0623g.C(), c0623g2, arrayList2) != -1) {
                        arrayList.add(c0623g2);
                    }
                }
            }
        }
        return arrayList;
    }

    private List m(List list, C0623g c0623g) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0623g c0623g2 = (C0623g) it.next();
            if (c0623g2.u() == null) {
                arrayList2.clear();
                int h3 = h(c0623g.d(), c0623g.s(), c0623g.h(), c0623g.A(), c0623g2, arrayList2);
                if (h3 != -1) {
                    arrayList2.add(Integer.valueOf(h3));
                    if (h(c0623g.e(), c0623g.t(), c0623g.i(), c0623g.B(), c0623g2, arrayList2) != -1) {
                        arrayList.add(c0623g2);
                    }
                }
            }
        }
        return arrayList;
    }

    private String o(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.toUri(0);
        } catch (Exception unused) {
            Log.w("CanvasTaskDataManager", "intentToUri error " + intent);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean q(C0623g c0623g, int i3) {
        return i3 == c0623g.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(int i3, r0 r0Var, boolean z3, boolean z4) {
        InterfaceC0624h B3 = CanvasTaskDatabase.C(this.f13878b).B();
        C0623g t3 = t(i3, r0Var);
        if (t3 == null) {
            return;
        }
        t3.R(z3);
        if (!z4) {
            z(t3, r0Var);
        }
        B3.b(t3);
        y(this.f13878b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(String str, int i3) {
        try {
            f(str, i3);
        } catch (Exception e3) {
            Log.e("clearDatabaseByPackageName", " error:" + e3);
        }
    }

    private C0623g t(int i3, r0 r0Var) {
        C0623g c0623g = new C0623g();
        c0623g.Z(i3);
        int k3 = r0Var.k();
        if (k3 < 2) {
            return null;
        }
        List m3 = r0Var.m();
        for (int i4 = 0; i4 < k3; i4++) {
            C0601d s3 = s.H() ? r0Var.s(i4) : r0Var.l(i4);
            if (s3 == null || s3.f() == null || s3.f().getComponent() == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("data save ");
                sb.append(s3 != null ? s3.f() : "task data null");
                Log.w("CanvasTaskDataManager", sb.toString());
                return null;
            }
            if (i4 == 0) {
                c0623g.V(s3.f().getComponent().getPackageName());
                c0623g.K(s3.f().getComponent().getClassName());
                c0623g.d0(s3.v());
                c0623g.G(s3.s());
                c0623g.a0(s3.u());
                c0623g.O(o(s3.f()));
                if (m3.size() == k3) {
                    c0623g.D(v((Rect) m3.get(i4)));
                }
            } else if (i4 == 1) {
                c0623g.W(s3.f().getComponent().getPackageName());
                c0623g.L(s3.f().getComponent().getClassName());
                c0623g.e0(s3.v());
                c0623g.H(s3.s());
                c0623g.b0(s3.u());
                c0623g.P(o(s3.f()));
                if (m3.size() == k3) {
                    c0623g.E(v((Rect) m3.get(i4)));
                }
            } else if (i4 == 2) {
                c0623g.X(s3.f().getComponent().getPackageName());
                c0623g.M(s3.f().getComponent().getClassName());
                c0623g.f0(s3.v());
                c0623g.I(s3.s());
                c0623g.c0(s3.u());
                c0623g.Q(o(s3.f()));
                if (m3.size() == k3) {
                    c0623g.F(v((Rect) m3.get(i4)));
                }
            }
        }
        c0623g.J(r0Var.j());
        if (s.r(this.f13878b)) {
            c0623g.N(r0Var.n());
        } else {
            c0623g.N(r0Var.r(r0Var.o()));
        }
        c0623g.U(r0Var.q());
        c0623g.T(r0Var.x());
        c0623g.Y(r0Var.t());
        c0623g.S(r0Var.p());
        return c0623g;
    }

    private void u(C0601d c0601d, int i3, C0623g c0623g) {
        ComponentName componentName;
        if (i3 > 2 || i3 < 0) {
            Log.e("CanvasTaskDataManager", "index invalid");
        }
        Intent intent = new Intent();
        Rect rect = new Rect();
        int i4 = 1;
        if (i3 == 0) {
            componentName = new ComponentName(c0623g.s(), c0623g.h());
            try {
                if (!TextUtils.isEmpty(c0623g.l())) {
                    intent = new Intent(Intent.parseUri(c0623g.l(), 0));
                }
            } catch (Exception unused) {
            }
            c0601d.r0(c0623g.A());
            c0601d.k0(c0623g.d());
            intent.putExtra("androidx.activity.LaunchEmbeddedTaskId", c0623g.d());
            c0601d.o0(c0623g.x());
            rect.set(E(c0623g.a()));
        } else if (i3 == 1) {
            componentName = new ComponentName(c0623g.t(), c0623g.i());
            try {
                if (!TextUtils.isEmpty(c0623g.m())) {
                    intent = new Intent(Intent.parseUri(c0623g.m(), 0));
                }
            } catch (Exception unused2) {
            }
            c0601d.r0(c0623g.B());
            c0601d.k0(c0623g.e());
            intent.putExtra("androidx.activity.LaunchEmbeddedTaskId", c0623g.e());
            c0601d.o0(c0623g.y());
            rect.set(E(c0623g.b()));
        } else if (i3 == 2) {
            componentName = new ComponentName(c0623g.u(), c0623g.j());
            try {
                if (!TextUtils.isEmpty(c0623g.n())) {
                    intent = new Intent(Intent.parseUri(c0623g.n(), 0));
                }
            } catch (Exception unused3) {
            }
            c0601d.r0(c0623g.C());
            c0601d.k0(c0623g.f());
            intent.putExtra("androidx.activity.LaunchEmbeddedTaskId", c0623g.f());
            c0601d.o0(c0623g.z());
            rect.set(E(c0623g.c()));
        } else {
            componentName = null;
        }
        if (rect.isEmpty() || !s.r(this.f13878b)) {
            i4 = -2;
        } else if (rect.height() <= rect.width()) {
            i4 = 0;
        }
        c0601d.X(i4);
        intent.setComponent(componentName);
        c0601d.O(intent);
    }

    private String v(Rect rect) {
        if (rect == null) {
            return "0,0,0,0";
        }
        return rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
    }

    private void w(Context context, C0623g c0623g, boolean z3) {
        boolean x3;
        Log.d("CanvasTaskDataManager", "saveCanvasTask removeCanvasTask taskId:" + c0623g);
        if (z3) {
            try {
                x3 = x(c0623g);
            } catch (RemoteException e3) {
                Log.e("CanvasTaskDataManager", "remove task error ", e3);
                return;
            }
        } else {
            x3 = false;
        }
        if (!x3) {
            if (c0623g.d() > 0) {
                FlexibleWindowManager.getInstance().removeEmbeddedContainerTask(c0623g.d(), c0623g.w());
            }
            if (c0623g.e() > 0) {
                FlexibleWindowManager.getInstance().removeEmbeddedContainerTask(c0623g.e(), c0623g.w());
            }
            if (c0623g.f() > 0) {
                FlexibleWindowManager.getInstance().removeEmbeddedContainerTask(c0623g.f(), c0623g.w());
            }
        }
        ActivityTaskManager.getService().removeTask(c0623g.w());
    }

    private boolean x(C0623g c0623g) {
        try {
            ArrayList arrayList = new ArrayList();
            if (c0623g.d() > 0) {
                arrayList.add(Integer.valueOf(c0623g.d()));
            }
            if (c0623g.e() > 0) {
                arrayList.add(Integer.valueOf(c0623g.e()));
            }
            if (c0623g.f() > 0) {
                arrayList.add(Integer.valueOf(c0623g.f()));
            }
            if (arrayList.size() == 0) {
                return false;
            }
            int[] array = arrayList.stream().mapToInt(new ToIntFunction() { // from class: w1.e
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    return ((Integer) obj).intValue();
                }
            }).toArray();
            Method declaredMethod = FlexibleWindowManager.getInstance().getClass().getDeclaredMethod("clearEmbeddedContainerTask", int[].class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(FlexibleWindowManager.getInstance(), array, Integer.valueOf(c0623g.w()));
            return true;
        } catch (Exception e3) {
            Log.w("CanvasTaskDataManager", "removeEmbeddedList exception:" + e3);
            return false;
        }
    }

    private void y(Context context) {
        List c3 = CanvasTaskDatabase.C(context).B().c();
        Log.d("CanvasTaskDataManager", "saveCanvasTask list:" + c3);
        if (c3.size() > 48) {
            p();
        }
    }

    private void z(C0623g c0623g, r0 r0Var) {
        InterfaceC0624h B3 = CanvasTaskDatabase.C(this.f13878b).B();
        if (c0623g == null) {
            return;
        }
        int k3 = r0Var.k();
        ArrayList<C0623g> arrayList = new ArrayList();
        List c3 = B3.c();
        List m3 = k3 == 2 ? m(c3, c0623g) : l(c3, c0623g);
        if (m3.size() > 0) {
            arrayList.addAll(m3);
        }
        Log.d("CanvasTaskDataManager", "removeSameCanvasTask embeddedCanvasList: " + arrayList + " new:" + c0623g);
        if (arrayList.size() > 0) {
            for (C0623g c0623g2 : arrayList) {
                if (c0623g2.w() != c0623g.w() && c0623g2.g() == c0623g.g()) {
                    B3.d(c0623g2);
                    w(this.f13878b, c0623g2, true);
                }
            }
        }
    }

    public boolean B(int i3, r0 r0Var, ContainerView containerView, Bundle bundle, Context context) {
        C0623g a3 = CanvasTaskDatabase.C(this.f13878b).B().a(i3);
        if (a3 == null || a3.t() == null || a3.s() == null) {
            Log.d("CanvasTaskDataManager", "" + a3);
            return false;
        }
        int i4 = a3.u() != null ? 3 : 2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < i4; i5++) {
            C0601d c0601d = new C0601d();
            u(c0601d, i5, a3);
            arrayList2.add(c0601d);
            Intent f3 = c0601d.f();
            f3.putExtra("androidx.flexible.userId", c0601d.v());
            arrayList.add(f3);
        }
        List o02 = l.o0(this.f13878b, arrayList, a3.r());
        if (o02 == null) {
            return false;
        }
        for (int i6 = 0; i6 < o02.size(); i6++) {
            ((C0601d) o02.get(i6)).k0(((C0601d) arrayList2.get(i6)).s());
            ((C0601d) o02.get(i6)).r0(((C0601d) arrayList2.get(i6)).v());
            ((C0601d) o02.get(i6)).o0(((C0601d) arrayList2.get(i6)).u());
            ((C0601d) o02.get(i6)).M(l.X(this.f13878b, ((C0601d) arrayList2.get(i6)).f(), ((C0601d) arrayList2.get(i6)).v()));
        }
        Log.d("CanvasTaskDataManager", "taskDataList restore " + o02);
        if (o02.size() < 2) {
            return false;
        }
        r0Var.e(o02, bundle != null ? bundle.getFloat("SPLIT_RATIO", 0.0f) : 0.0f, a3.r());
        r0Var.F(a3.k());
        r0Var.I(a3.r());
        r0Var.N(a3.q());
        r0Var.K(a3.v());
        r0Var.H(a3.p());
        if (a3.o() && !s.w(this.f13878b)) {
            l.O1(context).E0().z(false);
        }
        if (s.r(this.f13878b)) {
            r0Var.i();
        } else {
            containerView.c3(true, a3.r());
            r0Var.G(r0Var.s(a3.k()));
        }
        return true;
    }

    public void C(int i3, r0 r0Var, boolean z3) {
        D(i3, r0Var, z3, false);
    }

    public void D(final int i3, final r0 r0Var, final boolean z3, final boolean z4) {
        if (r0Var == null) {
            return;
        }
        this.f13877a.execute(new Runnable() { // from class: w1.a
            @Override // java.lang.Runnable
            public final void run() {
                C0622f.this.r(i3, r0Var, z3, z4);
            }
        });
    }

    public void F(final String str, final int i3) {
        this.f13877a.execute(new Runnable() { // from class: w1.b
            @Override // java.lang.Runnable
            public final void run() {
                C0622f.this.s(str, i3);
            }
        });
    }

    public void e() {
        if (this.f13879c) {
            return;
        }
        this.f13879c = true;
        this.f13877a.execute(new Runnable() { // from class: w1.c
            @Override // java.lang.Runnable
            public final void run() {
                C0622f.this.p();
            }
        });
    }

    public boolean n(int i3) {
        return CanvasTaskDatabase.C(this.f13878b).B().a(i3) != null;
    }
}
