package E1;

/* loaded from: classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f362f = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f363a;

    /* renamed from: b, reason: collision with root package name */
    private int f364b;

    /* renamed from: c, reason: collision with root package name */
    private String f365c;

    /* renamed from: d, reason: collision with root package name */
    private String f366d;

    /* renamed from: e, reason: collision with root package name */
    private String f367e;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f368a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f369b;

        /* renamed from: c, reason: collision with root package name */
        private String f370c;

        /* renamed from: d, reason: collision with root package name */
        private String f371d;

        /* renamed from: e, reason: collision with root package name */
        private String f372e;

        public a f() {
            return new a(this);
        }

        public b g(String str) {
            this.f372e = str;
            return this;
        }

        public b h(String str) {
            this.f370c = str;
            return this;
        }

        public b i(String str) {
            this.f371d = str;
            return this;
        }
    }

    public String a() {
        return this.f367e;
    }

    public int b() {
        return this.f363a;
    }

    public int c() {
        return this.f364b;
    }

    public String d() {
        return this.f365c;
    }

    public String e() {
        return this.f366d;
    }

    public void f(String str) {
        this.f367e = str;
    }

    public void g(String str) {
        this.f365c = str;
    }

    public void h(String str) {
        this.f366d = str;
    }

    private a() {
        this.f365c = "";
        this.f366d = "";
        this.f367e = "";
    }

    private a(b bVar) {
        this.f365c = "";
        this.f366d = "";
        this.f367e = "";
        this.f363a = bVar.f368a;
        this.f365c = bVar.f370c;
        this.f366d = bVar.f371d;
        this.f367e = bVar.f372e;
        this.f364b = bVar.f369b;
    }
}
