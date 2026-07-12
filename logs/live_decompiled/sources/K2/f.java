package K2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f {
    public static void a(Appendable appendable, Object obj, C2.l lVar) {
        D2.k.e(appendable, "<this>");
        if (lVar != null) {
            appendable.append((CharSequence) lVar.f(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }
}
