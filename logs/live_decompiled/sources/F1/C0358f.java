package f1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: f1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0358f {

    /* renamed from: c, reason: collision with root package name */
    public static final C0358f f11583c = new C0358f("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    private final List f11584a;

    /* renamed from: b, reason: collision with root package name */
    private g f11585b;

    public C0358f(String... strArr) {
        this.f11584a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.f11584a.get(r1.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public C0358f a(String str) {
        C0358f c0358f = new C0358f(this);
        c0358f.f11584a.add(str);
        return c0358f;
    }

    public boolean c(String str, int i3) {
        if (i3 >= this.f11584a.size()) {
            return false;
        }
        boolean z3 = i3 == this.f11584a.size() - 1;
        String str2 = (String) this.f11584a.get(i3);
        if (!str2.equals("**")) {
            return (z3 || (i3 == this.f11584a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z3 && ((String) this.f11584a.get(i3 + 1)).equals(str)) {
            return i3 == this.f11584a.size() + (-2) || (i3 == this.f11584a.size() + (-3) && b());
        }
        if (z3) {
            return true;
        }
        int i4 = i3 + 1;
        if (i4 < this.f11584a.size() - 1) {
            return false;
        }
        return ((String) this.f11584a.get(i4)).equals(str);
    }

    public g d() {
        return this.f11585b;
    }

    public int e(String str, int i3) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.f11584a.get(i3)).equals("**")) {
            return (i3 != this.f11584a.size() - 1 && ((String) this.f11584a.get(i3 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0358f c0358f = (C0358f) obj;
        if (!this.f11584a.equals(c0358f.f11584a)) {
            return false;
        }
        g gVar = this.f11585b;
        return gVar != null ? gVar.equals(c0358f.f11585b) : c0358f.f11585b == null;
    }

    public boolean g(String str, int i3) {
        if (f(str)) {
            return true;
        }
        if (i3 >= this.f11584a.size()) {
            return false;
        }
        return ((String) this.f11584a.get(i3)).equals(str) || ((String) this.f11584a.get(i3)).equals("**") || ((String) this.f11584a.get(i3)).equals("*");
    }

    public boolean h(String str, int i3) {
        return "__container".equals(str) || i3 < this.f11584a.size() - 1 || ((String) this.f11584a.get(i3)).equals("**");
    }

    public int hashCode() {
        int hashCode = this.f11584a.hashCode() * 31;
        g gVar = this.f11585b;
        return hashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public C0358f i(g gVar) {
        C0358f c0358f = new C0358f(this);
        c0358f.f11585b = gVar;
        return c0358f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f11584a);
        sb.append(",resolved=");
        sb.append(this.f11585b != null);
        sb.append('}');
        return sb.toString();
    }

    private C0358f(C0358f c0358f) {
        this.f11584a = new ArrayList(c0358f.f11584a);
        this.f11585b = c0358f.f11585b;
    }
}
