package J;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final u f1001a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f1002b;

    public m(u uVar) {
        D2.k.e(uVar, "database");
        this.f1001a = uVar;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        D2.k.d(newSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.f1002b = newSetFromMap;
    }
}
