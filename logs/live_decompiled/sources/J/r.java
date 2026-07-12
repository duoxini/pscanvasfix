package J;

import J.j;
import J.k;
import J.o;
import J.r;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String f1035a;

    /* renamed from: b, reason: collision with root package name */
    private final o f1036b;

    /* renamed from: c, reason: collision with root package name */
    private final Executor f1037c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f1038d;

    /* renamed from: e, reason: collision with root package name */
    private int f1039e;

    /* renamed from: f, reason: collision with root package name */
    public o.c f1040f;

    /* renamed from: g, reason: collision with root package name */
    private k f1041g;

    /* renamed from: h, reason: collision with root package name */
    private final j f1042h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f1043i;

    /* renamed from: j, reason: collision with root package name */
    private final ServiceConnection f1044j;

    /* renamed from: k, reason: collision with root package name */
    private final Runnable f1045k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f1046l;

    public static final class a extends o.c {
        a(String[] strArr) {
            super(strArr);
        }

        @Override // J.o.c
        public boolean b() {
            return true;
        }

        @Override // J.o.c
        public void c(Set set) {
            D2.k.e(set, "tables");
            if (r.this.j().get()) {
                return;
            }
            try {
                k h3 = r.this.h();
                if (h3 != null) {
                    int c3 = r.this.c();
                    Object[] array = set.toArray(new String[0]);
                    D2.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    h3.d(c3, (String[]) array);
                }
            } catch (RemoteException e3) {
                Log.w("ROOM", "Cannot broadcast invalidation", e3);
            }
        }
    }

    public static final class b extends j.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(r rVar, String[] strArr) {
            D2.k.e(rVar, "this$0");
            D2.k.e(strArr, "$tables");
            rVar.e().j((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @Override // J.j
        public void f(final String[] strArr) {
            D2.k.e(strArr, "tables");
            Executor d3 = r.this.d();
            final r rVar = r.this;
            d3.execute(new Runnable() { // from class: J.s
                @Override // java.lang.Runnable
                public final void run() {
                    r.b.l(r.this, strArr);
                }
            });
        }
    }

    public static final class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            D2.k.e(componentName, "name");
            D2.k.e(iBinder, "service");
            r.this.m(k.a.j(iBinder));
            r.this.d().execute(r.this.i());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            D2.k.e(componentName, "name");
            r.this.d().execute(r.this.g());
            r.this.m(null);
        }
    }

    public r(Context context, String str, Intent intent, o oVar, Executor executor) {
        D2.k.e(context, "context");
        D2.k.e(str, "name");
        D2.k.e(intent, "serviceIntent");
        D2.k.e(oVar, "invalidationTracker");
        D2.k.e(executor, "executor");
        this.f1035a = str;
        this.f1036b = oVar;
        this.f1037c = executor;
        Context applicationContext = context.getApplicationContext();
        this.f1038d = applicationContext;
        this.f1042h = new b();
        this.f1043i = new AtomicBoolean(false);
        c cVar = new c();
        this.f1044j = cVar;
        this.f1045k = new Runnable() { // from class: J.p
            @Override // java.lang.Runnable
            public final void run() {
                r.n(r.this);
            }
        };
        this.f1046l = new Runnable() { // from class: J.q
            @Override // java.lang.Runnable
            public final void run() {
                r.k(r.this);
            }
        };
        Object[] array = oVar.h().keySet().toArray(new String[0]);
        D2.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        l(new a((String[]) array));
        applicationContext.bindService(intent, cVar, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(r rVar) {
        D2.k.e(rVar, "this$0");
        rVar.f1036b.m(rVar.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(r rVar) {
        D2.k.e(rVar, "this$0");
        try {
            k kVar = rVar.f1041g;
            if (kVar != null) {
                rVar.f1039e = kVar.e(rVar.f1042h, rVar.f1035a);
                rVar.f1036b.b(rVar.f());
            }
        } catch (RemoteException e3) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e3);
        }
    }

    public final int c() {
        return this.f1039e;
    }

    public final Executor d() {
        return this.f1037c;
    }

    public final o e() {
        return this.f1036b;
    }

    public final o.c f() {
        o.c cVar = this.f1040f;
        if (cVar != null) {
            return cVar;
        }
        D2.k.n("observer");
        return null;
    }

    public final Runnable g() {
        return this.f1046l;
    }

    public final k h() {
        return this.f1041g;
    }

    public final Runnable i() {
        return this.f1045k;
    }

    public final AtomicBoolean j() {
        return this.f1043i;
    }

    public final void l(o.c cVar) {
        D2.k.e(cVar, "<set-?>");
        this.f1040f = cVar;
    }

    public final void m(k kVar) {
        this.f1041g = kVar;
    }
}
