package E1;

import J1.f;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f382a = Pattern.compile("^[a-zA-Z0-9\\_\\-]{1,64}$");

    /* renamed from: b, reason: collision with root package name */
    private static final F1.f f383b = new F1.f();

    /* renamed from: c, reason: collision with root package name */
    private static final J1.f f384c = new f.b(120, 120000).c();

    public static void e(Context context) {
        f(context, null);
    }

    public static void f(Context context, a aVar) {
        g(context, K1.d.c(context), aVar);
    }

    public static void g(Context context, String str, a aVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            H1.a.a().b((Application) applicationContext);
        }
        if (TextUtils.isEmpty(str)) {
            K1.f.f("OplusTrack", new K1.g() { // from class: E1.d
                @Override // K1.g
                public final Object get() {
                    String h3;
                    h3 = i.h();
                    return h3;
                }
            });
        }
        K1.d.i(context, str);
        c.d(str, context, aVar);
        if (aVar != null) {
            K1.f.d(aVar.b() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h() {
        return "AppCode is empty.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(G1.a aVar) {
        F1.e.c(aVar.e(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(G1.a aVar) {
        F1.b.d(aVar.e(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String k(G1.a aVar, int i3) {
        return "onCommon logTag is " + aVar.n() + ",eventID:" + aVar.l() + ",flagSendTo:" + i3;
    }

    public static boolean l(final G1.a aVar, final int i3) {
        if (!f384c.d(aVar.d() + "_" + aVar.n() + "_" + aVar.l())) {
            J1.d.e().i(aVar);
            return false;
        }
        try {
            K1.f.e("OplusTrack", new K1.g() { // from class: E1.e
                @Override // K1.g
                public final Object get() {
                    String k3;
                    k3 = i.k(G1.a.this, i3);
                    return k3;
                }
            });
            if ((i3 & 1) == 1) {
                J1.h.b(new Runnable() { // from class: E1.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.i(G1.a.this);
                    }
                });
            }
            if ((i3 & 2) == 2) {
                J1.h.b(new Runnable() { // from class: E1.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.j(G1.a.this);
                    }
                });
            }
            return true;
        } catch (Exception e3) {
            K1.f.b("OplusTrack", new h(e3));
            return false;
        }
    }

    public static boolean m(Context context, String str, String str2, Map map) {
        G1.a aVar = new G1.a(context);
        aVar.q(str);
        aVar.o(str2);
        aVar.p(map);
        return l(aVar, 1);
    }
}
