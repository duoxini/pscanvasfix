package H;

import D2.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f453a = new LinkedHashMap();

    /* renamed from: H.a$a, reason: collision with other inner class name */
    public static final class C0013a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0013a f454b = new C0013a();

        private C0013a() {
        }

        @Override // H.a
        public Object a(b bVar) {
            k.e(bVar, "key");
            return null;
        }
    }

    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f453a;
    }
}
