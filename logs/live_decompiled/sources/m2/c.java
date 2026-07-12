package M2;

import D2.k;
import L2.K;
import L2.O;
import L2.i0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import t2.g;

/* loaded from: classes.dex */
public final class c extends d implements K {
    private volatile c _immediate;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f1594g;

    /* renamed from: h, reason: collision with root package name */
    private final String f1595h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f1596i;

    /* renamed from: j, reason: collision with root package name */
    private final c f1597j;

    private c(Handler handler, String str, boolean z3) {
        super(null);
        this.f1594g = handler;
        this.f1595h = str;
        this.f1596i = z3;
        this._immediate = z3 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.f1597j = cVar;
    }

    private final void h0(g gVar, Runnable runnable) {
        i0.a(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        O.b().c0(gVar, runnable);
    }

    @Override // L2.A
    public void c0(g gVar, Runnable runnable) {
        if (this.f1594g.post(runnable)) {
            return;
        }
        h0(gVar, runnable);
    }

    @Override // L2.A
    public boolean d0(g gVar) {
        return (this.f1596i && k.a(Looper.myLooper(), this.f1594g.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f1594g == this.f1594g;
    }

    public int hashCode() {
        return System.identityHashCode(this.f1594g);
    }

    @Override // L2.o0
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public c f0() {
        return this.f1597j;
    }

    @Override // L2.A
    public String toString() {
        String g02 = g0();
        if (g02 != null) {
            return g02;
        }
        String str = this.f1595h;
        if (str == null) {
            str = this.f1594g.toString();
        }
        if (!this.f1596i) {
            return str;
        }
        return str + ".immediate";
    }

    public /* synthetic */ c(Handler handler, String str, int i3, D2.g gVar) {
        this(handler, (i3 & 2) != 0 ? null : str);
    }

    public c(Handler handler, String str) {
        this(handler, str, false);
    }
}
