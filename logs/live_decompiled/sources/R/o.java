package r;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import n.C0474d;
import q.AbstractC0513b;

/* loaded from: classes.dex */
public class o {

    /* renamed from: g, reason: collision with root package name */
    static int f13117g;

    /* renamed from: b, reason: collision with root package name */
    int f13119b;

    /* renamed from: d, reason: collision with root package name */
    int f13121d;

    /* renamed from: a, reason: collision with root package name */
    ArrayList f13118a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    boolean f13120c = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f13122e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f13123f = -1;

    class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference f13124a;

        /* renamed from: b, reason: collision with root package name */
        int f13125b;

        /* renamed from: c, reason: collision with root package name */
        int f13126c;

        /* renamed from: d, reason: collision with root package name */
        int f13127d;

        /* renamed from: e, reason: collision with root package name */
        int f13128e;

        /* renamed from: f, reason: collision with root package name */
        int f13129f;

        /* renamed from: g, reason: collision with root package name */
        int f13130g;

        public a(q.e eVar, C0474d c0474d, int i3) {
            this.f13124a = new WeakReference(eVar);
            this.f13125b = c0474d.y(eVar.f12882O);
            this.f13126c = c0474d.y(eVar.f12883P);
            this.f13127d = c0474d.y(eVar.f12884Q);
            this.f13128e = c0474d.y(eVar.f12885R);
            this.f13129f = c0474d.y(eVar.f12886S);
            this.f13130g = i3;
        }
    }

    public o(int i3) {
        int i4 = f13117g;
        f13117g = i4 + 1;
        this.f13119b = i4;
        this.f13121d = i3;
    }

    private String e() {
        int i3 = this.f13121d;
        return i3 == 0 ? "Horizontal" : i3 == 1 ? "Vertical" : i3 == 2 ? "Both" : "Unknown";
    }

    private int j(C0474d c0474d, ArrayList arrayList, int i3) {
        int y3;
        int y4;
        q.f fVar = (q.f) ((q.e) arrayList.get(0)).I();
        c0474d.E();
        fVar.g(c0474d, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ((q.e) arrayList.get(i4)).g(c0474d, false);
        }
        if (i3 == 0 && fVar.f12963W0 > 0) {
            AbstractC0513b.b(fVar, c0474d, arrayList, 0);
        }
        if (i3 == 1 && fVar.f12964X0 > 0) {
            AbstractC0513b.b(fVar, c0474d, arrayList, 1);
        }
        try {
            c0474d.A();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.f13122e = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.f13122e.add(new a((q.e) arrayList.get(i5), c0474d, i3));
        }
        if (i3 == 0) {
            y3 = c0474d.y(fVar.f12882O);
            y4 = c0474d.y(fVar.f12884Q);
            c0474d.E();
        } else {
            y3 = c0474d.y(fVar.f12883P);
            y4 = c0474d.y(fVar.f12885R);
            c0474d.E();
        }
        return y4 - y3;
    }

    public boolean a(q.e eVar) {
        if (this.f13118a.contains(eVar)) {
            return false;
        }
        this.f13118a.add(eVar);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f13118a.size();
        if (this.f13123f != -1 && size > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                o oVar = (o) arrayList.get(i3);
                if (this.f13123f == oVar.f13119b) {
                    g(this.f13121d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f13119b;
    }

    public int d() {
        return this.f13121d;
    }

    public int f(C0474d c0474d, int i3) {
        if (this.f13118a.size() == 0) {
            return 0;
        }
        return j(c0474d, this.f13118a, i3);
    }

    public void g(int i3, o oVar) {
        Iterator it = this.f13118a.iterator();
        while (it.hasNext()) {
            q.e eVar = (q.e) it.next();
            oVar.a(eVar);
            if (i3 == 0) {
                eVar.f12875I0 = oVar.c();
            } else {
                eVar.f12877J0 = oVar.c();
            }
        }
        this.f13123f = oVar.f13119b;
    }

    public void h(boolean z3) {
        this.f13120c = z3;
    }

    public void i(int i3) {
        this.f13121d = i3;
    }

    public String toString() {
        String str = e() + " [" + this.f13119b + "] <";
        Iterator it = this.f13118a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((q.e) it.next()).r();
        }
        return str + " >";
    }
}
