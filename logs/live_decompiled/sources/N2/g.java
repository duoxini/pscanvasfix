package N2;

import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class g {
    public static final d a(int i3, a aVar, C2.l lVar) {
        d bVar;
        if (i3 == -2) {
            bVar = aVar == a.SUSPEND ? new b(d.f1665c.a(), lVar) : new n(1, aVar, lVar);
        } else {
            if (i3 == -1) {
                if (aVar == a.SUSPEND) {
                    return new n(1, a.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
            if (i3 != 0) {
                return i3 != Integer.MAX_VALUE ? aVar == a.SUSPEND ? new b(i3, lVar) : new n(i3, aVar, lVar) : new b(Preference.DEFAULT_ORDER, lVar);
            }
            bVar = aVar == a.SUSPEND ? new b(0, lVar) : new n(1, aVar, lVar);
        }
        return bVar;
    }

    public static /* synthetic */ d b(int i3, a aVar, C2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        if ((i4 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i4 & 4) != 0) {
            lVar = null;
        }
        return a(i3, aVar, lVar);
    }
}
