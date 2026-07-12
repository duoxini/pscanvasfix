package c1;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import m1.AbstractC0465h;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List f7304a = new ArrayList();

    void a(u uVar) {
        this.f7304a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f7304a.size() - 1; size >= 0; size--) {
            AbstractC0465h.b(path, (u) this.f7304a.get(size));
        }
    }
}
