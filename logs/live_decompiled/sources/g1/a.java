package G1;

import K1.e;
import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: g, reason: collision with root package name */
    protected String f443g;

    /* renamed from: h, reason: collision with root package name */
    private String f444h;

    /* renamed from: i, reason: collision with root package name */
    private String f445i;

    /* renamed from: j, reason: collision with root package name */
    private int f446j;

    public a(Context context) {
        super(context);
        this.f443g = "";
        this.f444h = "";
        this.f445i = "";
        this.f446j = 0;
    }

    @Override // G1.c
    public int f() {
        return 1006;
    }

    public int k() {
        return this.f446j;
    }

    public String l() {
        return this.f445i;
    }

    public String m() {
        return this.f443g;
    }

    public String n() {
        return this.f444h;
    }

    public void o(String str) {
        this.f445i = str;
        c("eventID", str);
    }

    public void p(Map map) {
        String jSONObject = e.a(map).toString();
        this.f443g = jSONObject;
        c("logMap", jSONObject);
    }

    public void q(String str) {
        this.f444h = str;
        c("logTag", str);
    }

    public String toString() {
        return " type is :" + f() + ", tag is :" + n() + ", eventID is :" + l() + ", map is :" + m();
    }

    public a(Context context, String str, String str2, String str3) {
        super(context);
        this.f443g = "";
        this.f446j = 0;
        this.f444h = str2;
        this.f445i = str3;
        j(str);
        c("logTag", this.f444h);
        c("eventID", this.f445i);
    }
}
