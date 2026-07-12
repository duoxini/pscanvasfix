package L2;

import java.io.Closeable;
import t2.AbstractC0591b;
import t2.g;

/* loaded from: classes.dex */
public abstract class Y extends A implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static final a f1258g = new a(null);

    public static final class a extends AbstractC0591b {

        /* renamed from: L2.Y$a$a, reason: collision with other inner class name */
        static final class C0025a extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final C0025a f1259e = new C0025a();

            C0025a() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Y f(g.b bVar) {
                if (bVar instanceof Y) {
                    return (Y) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
            super(A.f1227f, C0025a.f1259e);
        }
    }
}
