package J;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f1097a = new v();

    private v() {
    }

    public static final String a(String str) {
        D2.k.e(str, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
