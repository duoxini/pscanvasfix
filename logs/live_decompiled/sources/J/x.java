package J;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class x implements N.j, N.i {

    /* renamed from: m, reason: collision with root package name */
    public static final a f1106m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static final TreeMap f1107n = new TreeMap();

    /* renamed from: e, reason: collision with root package name */
    private final int f1108e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f1109f;

    /* renamed from: g, reason: collision with root package name */
    public final long[] f1110g;

    /* renamed from: h, reason: collision with root package name */
    public final double[] f1111h;

    /* renamed from: i, reason: collision with root package name */
    public final String[] f1112i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[][] f1113j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f1114k;

    /* renamed from: l, reason: collision with root package name */
    private int f1115l;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final x a(String str, int i3) {
            D2.k.e(str, "query");
            TreeMap treeMap = x.f1107n;
            synchronized (treeMap) {
                Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i3));
                if (ceilingEntry == null) {
                    p2.q qVar = p2.q.f12810a;
                    x xVar = new x(i3, null);
                    xVar.i(str, i3);
                    return xVar;
                }
                treeMap.remove(ceilingEntry.getKey());
                x xVar2 = (x) ceilingEntry.getValue();
                xVar2.i(str, i3);
                D2.k.d(xVar2, "sqliteQuery");
                return xVar2;
            }
        }

        public final void b() {
            TreeMap treeMap = x.f1107n;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            D2.k.d(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i3 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i3;
            }
        }

        private a() {
        }
    }

    public /* synthetic */ x(int i3, D2.g gVar) {
        this(i3);
    }

    public static final x c(String str, int i3) {
        return f1106m.a(str, i3);
    }

    @Override // N.i
    public void H(int i3, byte[] bArr) {
        D2.k.e(bArr, "value");
        this.f1114k[i3] = 5;
        this.f1113j[i3] = bArr;
    }

    @Override // N.i
    public void I(int i3) {
        this.f1114k[i3] = 1;
    }

    @Override // N.i
    public void J(int i3, double d3) {
        this.f1114k[i3] = 3;
        this.f1111h[i3] = d3;
    }

    @Override // N.j
    public String a() {
        String str = this.f1109f;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // N.j
    public void b(N.i iVar) {
        D2.k.e(iVar, "statement");
        int g3 = g();
        if (1 > g3) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i4 = this.f1114k[i3];
            if (i4 == 1) {
                iVar.I(i3);
            } else if (i4 == 2) {
                iVar.y(i3, this.f1110g[i3]);
            } else if (i4 == 3) {
                iVar.J(i3, this.f1111h[i3]);
            } else if (i4 == 4) {
                String str = this.f1112i[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                iVar.x(i3, str);
            } else if (i4 == 5) {
                byte[] bArr = this.f1113j[i3];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                iVar.H(i3, bArr);
            }
            if (i3 == g3) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int g() {
        return this.f1115l;
    }

    public final void i(String str, int i3) {
        D2.k.e(str, "query");
        this.f1109f = str;
        this.f1115l = i3;
    }

    public final void j() {
        TreeMap treeMap = f1107n;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f1108e), this);
            f1106m.b();
            p2.q qVar = p2.q.f12810a;
        }
    }

    @Override // N.i
    public void x(int i3, String str) {
        D2.k.e(str, "value");
        this.f1114k[i3] = 4;
        this.f1112i[i3] = str;
    }

    @Override // N.i
    public void y(int i3, long j3) {
        this.f1114k[i3] = 2;
        this.f1110g[i3] = j3;
    }

    private x(int i3) {
        this.f1108e = i3;
        int i4 = i3 + 1;
        this.f1114k = new int[i4];
        this.f1110g = new long[i4];
        this.f1111h = new double[i4];
        this.f1112i = new String[i4];
        this.f1113j = new byte[i4][];
    }
}
