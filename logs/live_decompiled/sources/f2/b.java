package F2;

import D2.k;
import java.util.Random;

/* loaded from: classes.dex */
public final class b extends F2.a {

    /* renamed from: g, reason: collision with root package name */
    private final a f429g = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // F2.a
    public Random c() {
        Object obj = this.f429g.get();
        k.d(obj, "get(...)");
        return (Random) obj;
    }
}
