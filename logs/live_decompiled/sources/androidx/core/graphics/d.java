package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.d;
import androidx.core.content.res.f;
import androidx.core.provider.g;
import m.C0455e;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final f f4905a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final C0455e f4906b = new C0455e(16);

    public static class a extends g.c {

        /* renamed from: a, reason: collision with root package name */
        private f.e f4907a;

        public a(f.e eVar) {
            this.f4907a = eVar;
        }

        @Override // androidx.core.provider.g.c
        public void a(int i3) {
            f.e eVar = this.f4907a;
            if (eVar != null) {
                eVar.f(i3);
            }
        }

        @Override // androidx.core.provider.g.c
        public void b(Typeface typeface) {
            f.e eVar = this.f4907a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i3) {
        if (context != null) {
            return Typeface.create(typeface, i3);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i3) {
        return f4905a.b(context, cancellationSignal, bVarArr, i3);
    }

    public static Typeface c(Context context, d.b bVar, Resources resources, int i3, String str, int i4, int i5, f.e eVar, Handler handler, boolean z3) {
        Typeface a3;
        if (bVar instanceof d.e) {
            d.e eVar2 = (d.e) bVar;
            Typeface g3 = g(eVar2.c());
            if (g3 != null) {
                if (eVar != null) {
                    eVar.d(g3, handler);
                }
                return g3;
            }
            a3 = androidx.core.provider.g.c(context, eVar2.b(), i5, !z3 ? eVar != null : eVar2.a() != 0, z3 ? eVar2.d() : -1, f.e.e(handler), new a(eVar));
        } else {
            a3 = f4905a.a(context, (d.c) bVar, resources, i5);
            if (eVar != null) {
                if (a3 != null) {
                    eVar.d(a3, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (a3 != null) {
            f4906b.d(e(resources, i3, str, i4, i5), a3);
        }
        return a3;
    }

    public static Typeface d(Context context, Resources resources, int i3, String str, int i4, int i5) {
        Typeface c3 = f4905a.c(context, resources, i3, str, i5);
        if (c3 != null) {
            f4906b.d(e(resources, i3, str, i4, i5), c3);
        }
        return c3;
    }

    private static String e(Resources resources, int i3, String str, int i4, int i5) {
        return resources.getResourcePackageName(i3) + '-' + str + '-' + i4 + '-' + i3 + '-' + i5;
    }

    public static Typeface f(Resources resources, int i3, String str, int i4, int i5) {
        return (Typeface) f4906b.c(e(resources, i3, str, i4, i5));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
