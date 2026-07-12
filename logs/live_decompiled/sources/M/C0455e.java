package m;

import java.util.LinkedHashMap;
import java.util.Locale;

/* renamed from: m.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0455e {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f12348a;

    /* renamed from: b, reason: collision with root package name */
    private int f12349b;

    /* renamed from: c, reason: collision with root package name */
    private int f12350c;

    /* renamed from: d, reason: collision with root package name */
    private int f12351d;

    /* renamed from: e, reason: collision with root package name */
    private int f12352e;

    /* renamed from: f, reason: collision with root package name */
    private int f12353f;

    /* renamed from: g, reason: collision with root package name */
    private int f12354g;

    /* renamed from: h, reason: collision with root package name */
    private int f12355h;

    public C0455e(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f12350c = i3;
        this.f12348a = new LinkedHashMap(0, 0.75f, true);
    }

    private int e(Object obj, Object obj2) {
        int f3 = f(obj, obj2);
        if (f3 >= 0) {
            return f3;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    protected Object a(Object obj) {
        return null;
    }

    protected void b(boolean z3, Object obj, Object obj2, Object obj3) {
    }

    public final Object c(Object obj) {
        Object put;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Object obj2 = this.f12348a.get(obj);
                if (obj2 != null) {
                    this.f12354g++;
                    return obj2;
                }
                this.f12355h++;
                Object a3 = a(obj);
                if (a3 == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f12352e++;
                        put = this.f12348a.put(obj, a3);
                        if (put != null) {
                            this.f12348a.put(obj, put);
                        } else {
                            this.f12349b += e(obj, a3);
                        }
                    } finally {
                    }
                }
                if (put != null) {
                    b(false, obj, a3, put);
                    return put;
                }
                g(this.f12350c);
                return a3;
            } finally {
            }
        }
    }

    public final Object d(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f12351d++;
                this.f12349b += e(obj, obj2);
                put = this.f12348a.put(obj, obj2);
                if (put != null) {
                    this.f12349b -= e(obj, put);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (put != null) {
            b(false, obj, put, obj2);
        }
        g(this.f12350c);
        return put;
    }

    protected int f(Object obj, Object obj2) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f12349b     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L55
            java.util.LinkedHashMap r0 = r4.f12348a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r4.f12349b     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L55
            goto L14
        L12:
            r5 = move-exception
            goto L74
        L14:
            int r0 = r4.f12349b     // Catch: java.lang.Throwable -> L12
            if (r0 <= r5) goto L53
            java.util.LinkedHashMap r0 = r4.f12348a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L53
        L21:
            java.util.LinkedHashMap r0 = r4.f12348a     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap r2 = r4.f12348a     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r4.f12349b     // Catch: java.lang.Throwable -> L12
            int r3 = r4.e(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r3
            r4.f12349b = r2     // Catch: java.lang.Throwable -> L12
            int r2 = r4.f12353f     // Catch: java.lang.Throwable -> L12
            r3 = 1
            int r2 = r2 + r3
            r4.f12353f = r2     // Catch: java.lang.Throwable -> L12
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            r2 = 0
            r4.b(r3, r1, r0, r2)
            goto L0
        L53:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            return
        L55:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r5     // Catch: java.lang.Throwable -> L12
        L74:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m.C0455e.g(int):void");
    }

    public final synchronized String toString() {
        int i3;
        int i4;
        try {
            i3 = this.f12354g;
            i4 = this.f12355h + i3;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f12350c), Integer.valueOf(this.f12354g), Integer.valueOf(this.f12355h), Integer.valueOf(i4 != 0 ? (i3 * 100) / i4 : 0));
    }
}
