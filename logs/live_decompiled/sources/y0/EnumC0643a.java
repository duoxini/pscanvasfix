package y0;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC0643a {
    HIGN_END(1),
    MID_END(2),
    LOW_END(3),
    ULTRA_LOW_END(4);


    /* renamed from: e, reason: collision with root package name */
    private final int f14459e;

    EnumC0643a(int i3) {
        this.f14459e = i3;
    }

    public static EnumC0643a b(int i3) {
        for (EnumC0643a enumC0643a : values()) {
            if (enumC0643a.a() == i3) {
                return enumC0643a;
            }
        }
        throw new IllegalArgumentException("AnimLevel Invalid int value");
    }

    public int a() {
        return this.f14459e;
    }
}
