package c1;

import android.graphics.Path;
import h1.C0380i;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class l implements m, j {

    /* renamed from: d, reason: collision with root package name */
    private final String f7372d;

    /* renamed from: f, reason: collision with root package name */
    private final C0380i f7374f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7369a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f7370b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f7371c = new Path();

    /* renamed from: e, reason: collision with root package name */
    private final List f7373e = new ArrayList();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7375a;

        static {
            int[] iArr = new int[C0380i.a.values().length];
            f7375a = iArr;
            try {
                iArr[C0380i.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7375a[C0380i.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7375a[C0380i.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7375a[C0380i.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7375a[C0380i.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(C0380i c0380i) {
        this.f7372d = c0380i.c();
        this.f7374f = c0380i;
    }

    private void b() {
        for (int i3 = 0; i3 < this.f7373e.size(); i3++) {
            this.f7371c.addPath(((m) this.f7373e.get(i3)).d());
        }
    }

    private void e(Path.Op op) {
        this.f7370b.reset();
        this.f7369a.reset();
        for (int size = this.f7373e.size() - 1; size >= 1; size--) {
            m mVar = (m) this.f7373e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List m3 = dVar.m();
                for (int size2 = m3.size() - 1; size2 >= 0; size2--) {
                    Path d3 = ((m) m3.get(size2)).d();
                    d3.transform(dVar.n());
                    this.f7370b.addPath(d3);
                }
            } else {
                this.f7370b.addPath(mVar.d());
            }
        }
        m mVar2 = (m) this.f7373e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List m4 = dVar2.m();
            for (int i3 = 0; i3 < m4.size(); i3++) {
                Path d4 = ((m) m4.get(i3)).d();
                d4.transform(dVar2.n());
                this.f7369a.addPath(d4);
            }
        } else {
            this.f7369a.set(mVar2.d());
        }
        this.f7371c.op(this.f7369a, this.f7370b, op);
    }

    @Override // c1.m
    public Path d() {
        this.f7371c.reset();
        if (this.f7374f.d()) {
            return this.f7371c;
        }
        int i3 = a.f7375a[this.f7374f.b().ordinal()];
        if (i3 == 1) {
            b();
        } else if (i3 == 2) {
            e(Path.Op.UNION);
        } else if (i3 == 3) {
            e(Path.Op.REVERSE_DIFFERENCE);
        } else if (i3 == 4) {
            e(Path.Op.INTERSECT);
        } else if (i3 == 5) {
            e(Path.Op.XOR);
        }
        return this.f7371c;
    }

    @Override // c1.c
    public void f(List list, List list2) {
        for (int i3 = 0; i3 < this.f7373e.size(); i3++) {
            ((m) this.f7373e.get(i3)).f(list, list2);
        }
    }

    @Override // c1.j
    public void g(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar instanceof m) {
                this.f7373e.add((m) cVar);
                listIterator.remove();
            }
        }
    }
}
