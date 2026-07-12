package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* loaded from: classes.dex */
public abstract class g {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f4961a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f4962b;

        public a(int i3, b[] bVarArr) {
            this.f4961a = i3;
            this.f4962b = bVarArr;
        }

        static a a(int i3, b[] bVarArr) {
            return new a(i3, bVarArr);
        }

        public b[] b() {
            return this.f4962b;
        }

        public int c() {
            return this.f4961a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f4963a;

        /* renamed from: b, reason: collision with root package name */
        private final int f4964b;

        /* renamed from: c, reason: collision with root package name */
        private final int f4965c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f4966d;

        /* renamed from: e, reason: collision with root package name */
        private final int f4967e;

        public b(Uri uri, int i3, int i4, boolean z3, int i5) {
            this.f4963a = (Uri) androidx.core.util.h.d(uri);
            this.f4964b = i3;
            this.f4965c = i4;
            this.f4966d = z3;
            this.f4967e = i5;
        }

        static b a(Uri uri, int i3, int i4, boolean z3, int i5) {
            return new b(uri, i3, i4, z3, i5);
        }

        public int b() {
            return this.f4967e;
        }

        public int c() {
            return this.f4964b;
        }

        public Uri d() {
            return this.f4963a;
        }

        public int e() {
            return this.f4965c;
        }

        public boolean f() {
            return this.f4966d;
        }
    }

    public static class c {
        public abstract void a(int i3);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.d.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(Context context, e eVar, int i3, boolean z3, int i4, Handler handler, c cVar) {
        androidx.core.provider.a aVar = new androidx.core.provider.a(cVar, handler);
        return z3 ? f.e(context, eVar, aVar, i3, i4) : f.d(context, eVar, i3, null, aVar);
    }
}
