package G1;

import H1.r;
import K1.d;
import K1.f;
import K1.g;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f447a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap f448b;

    /* renamed from: c, reason: collision with root package name */
    private String f449c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f450d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f451e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f452f = "";

    public c(Context context) {
        Objects.requireNonNull(context, "TrackEvent: context is null");
        this.f447a = context;
        this.f448b = new ArrayMap();
        h(context);
    }

    private void h(Context context) {
        this.f448b.put("dataType", Integer.valueOf(f()));
        this.f448b.put("ssoid", K1.a.a(context));
        this.f448b.put("statSId", r.e().c(context));
        String c3 = d.c(context);
        if (TextUtils.isEmpty(c3)) {
            f.f("TrackEvent", new g() { // from class: G1.b
                @Override // K1.g
                public final Object get() {
                    String i3;
                    i3 = c.i();
                    return i3;
                }
            });
        } else {
            j(c3);
        }
        E1.c e3 = E1.c.e(c3);
        if (e3 == null) {
            this.f448b.put("appVersion", d.f(context));
            this.f448b.put("appPackage", d.e(context));
            this.f448b.put("appName", d.d(context));
        } else {
            this.f448b.put("headerFlag", Integer.valueOf(e3.f().c()));
            this.f448b.put("appVersion", e3.f().e());
            this.f448b.put("appPackage", e3.f().d());
            this.f448b.put("appName", e3.f().a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String i() {
        return "appId is empty";
    }

    void b(String str, int i3) {
        this.f448b.put(str, Integer.valueOf(i3));
    }

    protected void c(String str, String str2) {
        this.f448b.put(str, str2);
    }

    public String d() {
        return this.f449c;
    }

    public Context e() {
        return this.f447a;
    }

    public abstract int f();

    public Map g() {
        return new ArrayMap(this.f448b);
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f449c = str;
        c("appIdStr", str);
        if (TextUtils.isDigitsOnly(this.f449c)) {
            b("appId", Integer.parseInt(this.f449c));
        }
    }
}
