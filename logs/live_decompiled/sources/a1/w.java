package a1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import m.C0452b;
import m1.C0463f;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3265a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set f3266b = new C0452b();

    /* renamed from: c, reason: collision with root package name */
    private final Map f3267c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Comparator f3268d = new a();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.core.util.d dVar, androidx.core.util.d dVar2) {
            float floatValue = ((Float) dVar.f5013b).floatValue();
            float floatValue2 = ((Float) dVar2.f5013b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    public void a(String str, float f3) {
        if (this.f3265a) {
            C0463f c0463f = (C0463f) this.f3267c.get(str);
            if (c0463f == null) {
                c0463f = new C0463f();
                this.f3267c.put(str, c0463f);
            }
            c0463f.a(f3);
            if (str.equals("__container")) {
                Iterator it = this.f3266b.iterator();
                if (it.hasNext()) {
                    androidx.appcompat.app.p.a(it.next());
                    throw null;
                }
            }
        }
    }

    void b(boolean z3) {
        this.f3265a = z3;
    }
}
