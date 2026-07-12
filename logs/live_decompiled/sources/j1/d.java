package J1;

import android.content.Context;
import android.util.ArrayMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Map f1133a;

    /* renamed from: b, reason: collision with root package name */
    private int f1134b;

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f1135a;

        /* renamed from: b, reason: collision with root package name */
        private final String f1136b;

        /* renamed from: c, reason: collision with root package name */
        private final String f1137c;

        /* renamed from: d, reason: collision with root package name */
        private int f1138d;

        public b(String str, String str2, String str3) {
            this.f1135a = str;
            this.f1136b = str2;
            this.f1137c = str3;
        }

        public int e() {
            int i3 = this.f1138d;
            this.f1138d = i3 + 1;
            return i3;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final d f1139a = new d();
    }

    public static d e() {
        return c.f1139a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f() {
        return "context is empty.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Context context, G1.a aVar) {
        j(context, aVar.d(), aVar.n(), aVar.l());
    }

    private void j(final Context context, String str, String str2, String str3) {
        String str4 = str + str2 + str3;
        b bVar = (b) this.f1133a.get(str4);
        if (bVar == null) {
            b bVar2 = new b(str, str2, str3);
            bVar2.e();
            this.f1133a.put(str4, bVar2);
        } else {
            bVar.e();
        }
        int i3 = this.f1134b + 1;
        this.f1134b = i3;
        if (i3 >= 100) {
            h(context);
        } else {
            if (i3 != 1 || h.c().d(1)) {
                return;
            }
            h.c().g(1, new Runnable() { // from class: J1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.h(context);
                }
            }, 300000L);
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void h(Context context) {
        for (b bVar : this.f1133a.values()) {
            G1.a aVar = new G1.a(context, "21000", "001", "chatty_event");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("app_id", String.valueOf(bVar.f1135a));
            arrayMap.put("log_tag", bVar.f1136b);
            arrayMap.put("event_id", bVar.f1137c);
            arrayMap.put("times", String.valueOf(bVar.f1138d));
            aVar.p(arrayMap);
            F1.e.c(context, aVar);
        }
        this.f1134b = 0;
        this.f1133a.clear();
        h.c().h(1);
    }

    public void i(final G1.a aVar) {
        final Context applicationContext = aVar.e().getApplicationContext();
        if (applicationContext == null) {
            K1.f.b("ChattyEventTracker", new K1.g() { // from class: J1.a
                @Override // K1.g
                public final Object get() {
                    String f3;
                    f3 = d.f();
                    return f3;
                }
            });
        } else {
            h.b(new Runnable() { // from class: J1.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.g(applicationContext, aVar);
                }
            });
        }
    }

    private d() {
        this.f1133a = new ArrayMap();
    }
}
