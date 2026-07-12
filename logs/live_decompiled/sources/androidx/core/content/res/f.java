package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.f;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4875a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f4876b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f4877c = new Object();

    static class a {
        static Drawable a(Resources resources, int i3, Resources.Theme theme) {
            return resources.getDrawable(i3, theme);
        }

        static Drawable b(Resources resources, int i3, int i4, Resources.Theme theme) {
            return resources.getDrawableForDensity(i3, i4, theme);
        }
    }

    static class b {
        static int a(Resources resources, int i3, Resources.Theme theme) {
            return resources.getColor(i3, theme);
        }

        static ColorStateList b(Resources resources, int i3, Resources.Theme theme) {
            return resources.getColorStateList(i3, theme);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final ColorStateList f4878a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f4879b;

        /* renamed from: c, reason: collision with root package name */
        final int f4880c;

        c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f4878a = colorStateList;
            this.f4879b = configuration;
            this.f4880c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        final Resources f4881a;

        /* renamed from: b, reason: collision with root package name */
        final Resources.Theme f4882b;

        d(Resources resources, Resources.Theme theme) {
            this.f4881a = resources;
            this.f4882b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4881a.equals(dVar.f4881a) && androidx.core.util.c.a(this.f4882b, dVar.f4882b);
        }

        public int hashCode() {
            return androidx.core.util.c.b(this.f4881a, this.f4882b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i3, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.h
                @Override // java.lang.Runnable
                public final void run() {
                    f.e.this.f(i3);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.g
                @Override // java.lang.Runnable
                public final void run() {
                    f.e.this.g(typeface);
                }
            });
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i3);

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    /* renamed from: androidx.core.content.res.f$f, reason: collision with other inner class name */
    public static final class C0064f {

        /* renamed from: androidx.core.content.res.f$f$a */
        static class a {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            a.a(theme);
        }
    }

    private static void a(d dVar, int i3, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f4877c) {
            try {
                WeakHashMap weakHashMap = f4876b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i3, new c(colorStateList, dVar.f4881a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2.f4880c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.ColorStateList b(androidx.core.content.res.f.d r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.f.f4877c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = androidx.core.content.res.f.f4876b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.f$c r2 = (androidx.core.content.res.f.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f4879b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f4881a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f4882b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f4880c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f4880c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f4878a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.b(androidx.core.content.res.f$d, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i3, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources resources, int i3, Resources.Theme theme) {
        return b.a(resources, i3, theme);
    }

    public static ColorStateList e(Resources resources, int i3, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList b3 = b(dVar, i3);
        if (b3 != null) {
            return b3;
        }
        ColorStateList l3 = l(resources, i3, theme);
        if (l3 == null) {
            return b.b(resources, i3, theme);
        }
        a(dVar, i3, l3, theme);
        return l3;
    }

    public static Drawable f(Resources resources, int i3, Resources.Theme theme) {
        return a.a(resources, i3, theme);
    }

    public static Drawable g(Resources resources, int i3, int i4, Resources.Theme theme) {
        return a.b(resources, i3, i4, theme);
    }

    public static Typeface h(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i3, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context context, int i3, TypedValue typedValue, int i4, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i3, typedValue, i4, eVar, null, true, false);
    }

    public static void j(Context context, int i3, e eVar, Handler handler) {
        androidx.core.util.h.d(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            n(context, i3, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    private static TypedValue k() {
        ThreadLocal threadLocal = f4875a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList l(Resources resources, int i3, Resources.Theme theme) {
        if (m(resources, i3)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i3), theme);
        } catch (Exception e3) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e3);
            return null;
        }
    }

    private static boolean m(Resources resources, int i3) {
        TypedValue k3 = k();
        resources.getValue(i3, k3, true);
        int i4 = k3.type;
        return i4 >= 28 && i4 <= 31;
    }

    private static Typeface n(Context context, int i3, TypedValue typedValue, int i4, e eVar, Handler handler, boolean z3, boolean z4) {
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        Typeface o3 = o(context, resources, typedValue, i3, i4, eVar, handler, z3, z4);
        if (o3 != null || eVar != null || z4) {
            return o3;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i3) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface o(android.content.Context r16, android.content.res.Resources r17, android.util.TypedValue r18, int r19, int r20, androidx.core.content.res.f.e r21, android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.f$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
