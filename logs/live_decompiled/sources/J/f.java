package J;

import J.u;
import N.h;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f977a;

    /* renamed from: b, reason: collision with root package name */
    public final String f978b;

    /* renamed from: c, reason: collision with root package name */
    public final h.c f979c;

    /* renamed from: d, reason: collision with root package name */
    public final u.d f980d;

    /* renamed from: e, reason: collision with root package name */
    public final List f981e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f982f;

    /* renamed from: g, reason: collision with root package name */
    public final u.c f983g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f984h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f985i;

    /* renamed from: j, reason: collision with root package name */
    public final Intent f986j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f987k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f988l;

    /* renamed from: m, reason: collision with root package name */
    private final Set f989m;

    /* renamed from: n, reason: collision with root package name */
    public final String f990n;

    /* renamed from: o, reason: collision with root package name */
    public final File f991o;

    /* renamed from: p, reason: collision with root package name */
    public final Callable f992p;

    /* renamed from: q, reason: collision with root package name */
    public final List f993q;

    /* renamed from: r, reason: collision with root package name */
    public final List f994r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f995s;

    public f(Context context, String str, h.c cVar, u.d dVar, List list, boolean z3, u.c cVar2, Executor executor, Executor executor2, Intent intent, boolean z4, boolean z5, Set set, String str2, File file, Callable callable, u.e eVar, List list2, List list3) {
        D2.k.e(context, "context");
        D2.k.e(cVar, "sqliteOpenHelperFactory");
        D2.k.e(dVar, "migrationContainer");
        D2.k.e(cVar2, "journalMode");
        D2.k.e(executor, "queryExecutor");
        D2.k.e(executor2, "transactionExecutor");
        D2.k.e(list2, "typeConverters");
        D2.k.e(list3, "autoMigrationSpecs");
        this.f977a = context;
        this.f978b = str;
        this.f979c = cVar;
        this.f980d = dVar;
        this.f981e = list;
        this.f982f = z3;
        this.f983g = cVar2;
        this.f984h = executor;
        this.f985i = executor2;
        this.f986j = intent;
        this.f987k = z4;
        this.f988l = z5;
        this.f989m = set;
        this.f990n = str2;
        this.f991o = file;
        this.f992p = callable;
        this.f993q = list2;
        this.f994r = list3;
        this.f995s = intent != null;
    }

    public boolean a(int i3, int i4) {
        if ((i3 > i4 && this.f988l) || !this.f987k) {
            return false;
        }
        Set set = this.f989m;
        return set == null || !set.contains(Integer.valueOf(i3));
    }
}
