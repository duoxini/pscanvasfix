package j1;

/* renamed from: j1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC0408f {
    JSON(".json"),
    ZIP(".zip");


    /* renamed from: e, reason: collision with root package name */
    public final String f12154e;

    EnumC0408f(String str) {
        this.f12154e = str;
    }

    public String a() {
        return ".temp" + this.f12154e;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f12154e;
    }
}
