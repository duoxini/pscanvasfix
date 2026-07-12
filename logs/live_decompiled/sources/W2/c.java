package w2;

import D2.k;
import java.io.Serializable;
import q2.AbstractC0532b;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
final class c extends AbstractC0532b implements InterfaceC0625a, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final Enum[] f13913f;

    public c(Enum[] enumArr) {
        k.e(enumArr, "entries");
        this.f13913f = enumArr;
    }

    @Override // q2.AbstractC0531a
    public int a() {
        return this.f13913f.length;
    }

    public boolean b(Enum r22) {
        k.e(r22, "element");
        return ((Enum) AbstractC0538h.w(this.f13913f, r22.ordinal())) == r22;
    }

    @Override // q2.AbstractC0532b, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Enum get(int i3) {
        AbstractC0532b.f13035e.a(i3, this.f13913f.length);
        return this.f13913f[i3];
    }

    @Override // q2.AbstractC0531a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return b((Enum) obj);
        }
        return false;
    }

    public int d(Enum r22) {
        k.e(r22, "element");
        int ordinal = r22.ordinal();
        if (((Enum) AbstractC0538h.w(this.f13913f, ordinal)) == r22) {
            return ordinal;
        }
        return -1;
    }

    public int e(Enum r22) {
        k.e(r22, "element");
        return indexOf(r22);
    }

    @Override // q2.AbstractC0532b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return d((Enum) obj);
        }
        return -1;
    }

    @Override // q2.AbstractC0532b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return e((Enum) obj);
        }
        return -1;
    }
}
