package J2;

import D2.k;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends e {

    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f1155a;

        public a(Iterator it) {
            this.f1155a = it;
        }

        @Override // J2.b
        public Iterator iterator() {
            return this.f1155a;
        }
    }

    public static b a(Iterator it) {
        k.e(it, "<this>");
        return b(new a(it));
    }

    public static final b b(b bVar) {
        k.e(bVar, "<this>");
        return bVar instanceof J2.a ? bVar : new J2.a(bVar);
    }
}
