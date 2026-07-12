package d1;

import h1.C0379h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final List f11032a;

    /* renamed from: b, reason: collision with root package name */
    private final List f11033b;

    /* renamed from: c, reason: collision with root package name */
    private final List f11034c;

    public h(List list) {
        this.f11034c = list;
        this.f11032a = new ArrayList(list.size());
        this.f11033b = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f11032a.add(((C0379h) list.get(i3)).b().a());
            this.f11033b.add(((C0379h) list.get(i3)).c().a());
        }
    }

    public List a() {
        return this.f11032a;
    }

    public List b() {
        return this.f11034c;
    }

    public List c() {
        return this.f11033b;
    }
}
