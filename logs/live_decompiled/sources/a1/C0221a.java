package a1;

import android.graphics.Rect;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.C0454d;
import m1.AbstractC0462e;
import m1.AbstractC0464g;

/* renamed from: a1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0221a {

    /* renamed from: c, reason: collision with root package name */
    private Map f3165c;

    /* renamed from: d, reason: collision with root package name */
    private Map f3166d;

    /* renamed from: e, reason: collision with root package name */
    private Map f3167e;

    /* renamed from: f, reason: collision with root package name */
    private List f3168f;

    /* renamed from: g, reason: collision with root package name */
    private m.h f3169g;

    /* renamed from: h, reason: collision with root package name */
    private C0454d f3170h;

    /* renamed from: i, reason: collision with root package name */
    private List f3171i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f3172j;

    /* renamed from: k, reason: collision with root package name */
    private float f3173k;

    /* renamed from: l, reason: collision with root package name */
    private float f3174l;

    /* renamed from: m, reason: collision with root package name */
    private float f3175m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3176n;

    /* renamed from: a, reason: collision with root package name */
    private final w f3163a = new w();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f3164b = new HashSet();

    /* renamed from: o, reason: collision with root package name */
    private int f3177o = 0;

    public void a(String str) {
        AbstractC0462e.c(str);
        this.f3164b.add(str);
    }

    public Rect b() {
        return this.f3172j;
    }

    public m.h c() {
        return this.f3169g;
    }

    public float d() {
        return (long) ((e() / this.f3175m) * 1000.0f);
    }

    public float e() {
        return this.f3174l - this.f3173k;
    }

    public float f() {
        return this.f3174l;
    }

    public Map g() {
        return this.f3167e;
    }

    public float h(float f3) {
        return AbstractC0464g.i(this.f3173k, this.f3174l, f3);
    }

    public float i() {
        return this.f3175m;
    }

    public Map j() {
        return this.f3166d;
    }

    public List k() {
        return this.f3171i;
    }

    public f1.h l(String str) {
        int size = this.f3168f.size();
        for (int i3 = 0; i3 < size; i3++) {
            f1.h hVar = (f1.h) this.f3168f.get(i3);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f3177o;
    }

    public w n() {
        return this.f3163a;
    }

    public List o(String str) {
        return (List) this.f3165c.get(str);
    }

    public float p() {
        return this.f3173k;
    }

    public boolean q() {
        return this.f3176n;
    }

    public void r(int i3) {
        this.f3177o += i3;
    }

    public void s(Rect rect, float f3, float f4, float f5, List list, C0454d c0454d, Map map, Map map2, m.h hVar, Map map3, List list2) {
        this.f3172j = rect;
        this.f3173k = f3;
        this.f3174l = f4;
        this.f3175m = f5;
        this.f3171i = list;
        this.f3170h = c0454d;
        this.f3165c = map;
        this.f3166d = map2;
        this.f3169g = hVar;
        this.f3167e = map3;
        this.f3168f = list2;
    }

    public i1.e t(long j3) {
        return (i1.e) this.f3170h.e(j3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EffectiveAnimationComposition:\n");
        Iterator it = this.f3171i.iterator();
        while (it.hasNext()) {
            sb.append(((i1.e) it.next()).y("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z3) {
        this.f3176n = z3;
    }

    public void v(boolean z3) {
        this.f3163a.b(z3);
    }
}
