package K2;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class q extends p {
    public static final String c0(String str, int i3) {
        D2.k.e(str, "<this>");
        if (i3 >= 0) {
            String substring = str.substring(H2.d.c(i3, str.length()));
            D2.k.d(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i3 + " is less than zero.").toString());
    }

    public static char d0(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(e.z(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }
}
