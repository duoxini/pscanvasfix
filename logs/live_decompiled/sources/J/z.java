package J;

import N.h;
import java.io.File;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class z implements h.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f1124a;

    /* renamed from: b, reason: collision with root package name */
    private final File f1125b;

    /* renamed from: c, reason: collision with root package name */
    private final Callable f1126c;

    /* renamed from: d, reason: collision with root package name */
    private final h.c f1127d;

    public z(String str, File file, Callable callable, h.c cVar) {
        D2.k.e(cVar, "mDelegate");
        this.f1124a = str;
        this.f1125b = file;
        this.f1126c = callable;
        this.f1127d = cVar;
    }

    @Override // N.h.c
    public N.h a(h.b bVar) {
        D2.k.e(bVar, "configuration");
        return new y(bVar.f1610a, this.f1124a, this.f1125b, this.f1126c, bVar.f1612c.f1608a, this.f1127d.a(bVar));
    }
}
