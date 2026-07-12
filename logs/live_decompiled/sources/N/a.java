package N;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: g, reason: collision with root package name */
    public static final C0027a f1599g = new C0027a(null);

    /* renamed from: e, reason: collision with root package name */
    private final String f1600e;

    /* renamed from: f, reason: collision with root package name */
    private final Object[] f1601f;

    /* renamed from: N.a$a, reason: collision with other inner class name */
    public static final class C0027a {
        public /* synthetic */ C0027a(D2.g gVar) {
            this();
        }

        private final void a(i iVar, int i3, Object obj) {
            if (obj == null) {
                iVar.I(i3);
                return;
            }
            if (obj instanceof byte[]) {
                iVar.H(i3, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                iVar.J(i3, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                iVar.J(i3, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                iVar.y(i3, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                iVar.y(i3, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                iVar.y(i3, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                iVar.y(i3, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                iVar.x(i3, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                iVar.y(i3, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i3 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(i iVar, Object[] objArr) {
            D2.k.e(iVar, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i3 = 0;
            while (i3 < length) {
                Object obj = objArr[i3];
                i3++;
                a(iVar, i3, obj);
            }
        }

        private C0027a() {
        }
    }

    public a(String str, Object[] objArr) {
        D2.k.e(str, "query");
        this.f1600e = str;
        this.f1601f = objArr;
    }

    @Override // N.j
    public String a() {
        return this.f1600e;
    }

    @Override // N.j
    public void b(i iVar) {
        D2.k.e(iVar, "statement");
        f1599g.b(iVar, this.f1601f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(str, null);
        D2.k.e(str, "query");
    }
}
