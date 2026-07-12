package q2;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0547q extends AbstractC0546p {
    public static int q(Iterable iterable, int i3) {
        D2.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i3;
    }
}
