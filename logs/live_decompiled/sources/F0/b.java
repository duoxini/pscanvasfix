package F0;

import androidx.appcompat.app.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    private final h f397c;

    /* renamed from: a, reason: collision with root package name */
    private final Map f395a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set f396b = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f398d = new CopyOnWriteArraySet();

    /* renamed from: e, reason: collision with root package name */
    private boolean f399e = true;

    public b(h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("springLooper is required");
        }
        this.f397c = hVar;
        hVar.a(this);
    }

    void a(String str) {
        e eVar = (e) this.f395a.get(str);
        if (eVar == null) {
            throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
        }
        this.f396b.add(eVar);
        if (d()) {
            this.f399e = false;
            this.f397c.b();
        }
    }

    void b(double d3) {
        for (e eVar : this.f396b) {
            if (eVar.n()) {
                eVar.b(d3 / 1000.0d);
            } else {
                this.f396b.remove(eVar);
            }
        }
    }

    public e c() {
        e eVar = new e(this);
        f(eVar);
        return eVar;
    }

    public boolean d() {
        return this.f399e;
    }

    public void e(double d3) {
        Iterator it = this.f398d.iterator();
        if (it.hasNext()) {
            p.a(it.next());
            throw null;
        }
        b(d3);
        if (this.f396b.isEmpty()) {
            this.f399e = true;
        }
        Iterator it2 = this.f398d.iterator();
        if (it2.hasNext()) {
            p.a(it2.next());
            throw null;
        }
        if (this.f399e) {
            this.f397c.c();
        }
    }

    void f(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("spring is required");
        }
        if (this.f395a.containsKey(eVar.e())) {
            throw new IllegalArgumentException("spring is already registered");
        }
        this.f395a.put(eVar.e(), eVar);
    }
}
