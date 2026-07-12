package G2;

import D2.k;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public final class a extends F2.a {
    @Override // F2.a
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k.d(current, "current(...)");
        return current;
    }
}
