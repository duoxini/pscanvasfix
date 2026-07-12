package u2;

import w2.InterfaceC0625a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: u2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0602a {

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0602a f13836e = new EnumC0602a("COROUTINE_SUSPENDED", 0);

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0602a f13837f = new EnumC0602a("UNDECIDED", 1);

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC0602a f13838g = new EnumC0602a("RESUMED", 2);

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ EnumC0602a[] f13839h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0625a f13840i;

    static {
        EnumC0602a[] a3 = a();
        f13839h = a3;
        f13840i = w2.b.a(a3);
    }

    private EnumC0602a(String str, int i3) {
    }

    private static final /* synthetic */ EnumC0602a[] a() {
        return new EnumC0602a[]{f13836e, f13837f, f13838g};
    }

    public static EnumC0602a valueOf(String str) {
        return (EnumC0602a) Enum.valueOf(EnumC0602a.class, str);
    }

    public static EnumC0602a[] values() {
        return (EnumC0602a[]) f13839h.clone();
    }
}
