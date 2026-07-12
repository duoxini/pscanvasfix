package androidx.core.provider;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f4939a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4940b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4941c;

    /* renamed from: d, reason: collision with root package name */
    private final List f4942d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4943e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f4944f;

    public e(String str, String str2, String str3, List list) {
        this.f4939a = (String) androidx.core.util.h.d(str);
        this.f4940b = (String) androidx.core.util.h.d(str2);
        this.f4941c = (String) androidx.core.util.h.d(str3);
        this.f4942d = (List) androidx.core.util.h.d(list);
        this.f4944f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f4942d;
    }

    public int c() {
        return this.f4943e;
    }

    String d() {
        return this.f4944f;
    }

    public String e() {
        return this.f4939a;
    }

    public String f() {
        return this.f4940b;
    }

    public String g() {
        return this.f4941c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f4939a + ", mProviderPackage: " + this.f4940b + ", mQuery: " + this.f4941c + ", mCertificates:");
        for (int i3 = 0; i3 < this.f4942d.size(); i3++) {
            sb.append(" [");
            List list = (List) this.f4942d.get(i3);
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i4), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f4943e);
        return sb.toString();
    }
}
