package P2;

/* loaded from: classes.dex */
public interface g extends O2.c {

    public static final class a {
        public static /* synthetic */ O2.c a(g gVar, t2.g gVar2, int i3, N2.a aVar, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i4 & 1) != 0) {
                gVar2 = t2.h.f13692e;
            }
            if ((i4 & 2) != 0) {
                i3 = -3;
            }
            if ((i4 & 4) != 0) {
                aVar = N2.a.SUSPEND;
            }
            return gVar.a(gVar2, i3, aVar);
        }
    }

    O2.c a(t2.g gVar, int i3, N2.a aVar);
}
