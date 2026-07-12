package G0;

import androidx.appcompat.app.p;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static final C0012a f433a = new C0012a();

    /* renamed from: G0.a$a, reason: collision with other inner class name */
    static final class C0012a implements Comparator {
        C0012a() {
        }

        public int a(X2.a aVar, X2.a aVar2) {
            throw null;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            p.a(obj);
            p.a(obj2);
            return a(null, null);
        }
    }

    static String a(String str, X2.b bVar, List list, String str2, g gVar) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < str.length(); i3++) {
            stringBuffer.append(b.d(str.charAt(i3)));
            if (i3 != str.length() - 1) {
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }
}
