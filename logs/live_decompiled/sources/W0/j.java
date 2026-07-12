package W0;

/* loaded from: classes.dex */
public abstract class j {

    class a extends j {
        a() {
        }

        @Override // W0.j
        public Object b(Z0.a aVar) {
            if (aVar.k0() != Z0.b.NULL) {
                return j.this.b(aVar);
            }
            aVar.g0();
            return null;
        }

        @Override // W0.j
        public void c(Z0.c cVar, Object obj) {
            if (obj == null) {
                cVar.G();
            } else {
                j.this.c(cVar, obj);
            }
        }
    }

    public final j a() {
        return new a();
    }

    public abstract Object b(Z0.a aVar);

    public abstract void c(Z0.c cVar, Object obj);
}
