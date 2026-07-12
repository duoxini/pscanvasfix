package U2;

import java.util.List;
import java.util.RandomAccess;
import q2.AbstractC0532b;

/* loaded from: classes.dex */
public final class j extends AbstractC0532b implements RandomAccess {

    /* renamed from: h, reason: collision with root package name */
    public static final a f2472h = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private final e[] f2473f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f2474g;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private final void a(long j3, b bVar, int i3, List list, int i4, int i5, List list2) {
            int i6;
            int i7;
            int i8;
            int i9;
            b bVar2;
            int i10 = i3;
            if (i4 >= i5) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i11 = i4; i11 < i5; i11++) {
                if (((e) list.get(i11)).o() < i10) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            e eVar = (e) list.get(i4);
            e eVar2 = (e) list.get(i5 - 1);
            int i12 = -1;
            if (i10 == eVar.o()) {
                int intValue = ((Number) list2.get(i4)).intValue();
                int i13 = i4 + 1;
                e eVar3 = (e) list.get(i13);
                i6 = i13;
                i7 = intValue;
                eVar = eVar3;
            } else {
                i6 = i4;
                i7 = -1;
            }
            if (eVar.c(i10) == eVar2.c(i10)) {
                int min = Math.min(eVar.o(), eVar2.o());
                int i14 = 0;
                for (int i15 = i10; i15 < min && eVar.c(i15) == eVar2.c(i15); i15++) {
                    i14++;
                }
                long c3 = j3 + c(bVar) + 2 + i14 + 1;
                bVar.m0(-i14);
                bVar.m0(i7);
                int i16 = i14 + i10;
                while (i10 < i16) {
                    bVar.m0(eVar.c(i10) & 255);
                    i10++;
                }
                if (i6 + 1 == i5) {
                    if (i16 != ((e) list.get(i6)).o()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    bVar.m0(((Number) list2.get(i6)).intValue());
                    return;
                } else {
                    b bVar3 = new b();
                    bVar.m0(((int) (c(bVar3) + c3)) * (-1));
                    a(c3, bVar3, i16, list, i6, i5, list2);
                    bVar.k0(bVar3);
                    return;
                }
            }
            int i17 = 1;
            for (int i18 = i6 + 1; i18 < i5; i18++) {
                if (((e) list.get(i18 - 1)).c(i10) != ((e) list.get(i18)).c(i10)) {
                    i17++;
                }
            }
            long c4 = j3 + c(bVar) + 2 + (i17 * 2);
            bVar.m0(i17);
            bVar.m0(i7);
            for (int i19 = i6; i19 < i5; i19++) {
                byte c5 = ((e) list.get(i19)).c(i10);
                if (i19 == i6 || c5 != ((e) list.get(i19 - 1)).c(i10)) {
                    bVar.m0(c5 & 255);
                }
            }
            b bVar4 = new b();
            while (i6 < i5) {
                byte c6 = ((e) list.get(i6)).c(i10);
                int i20 = i6 + 1;
                int i21 = i20;
                while (true) {
                    if (i21 >= i5) {
                        i8 = i5;
                        break;
                    } else {
                        if (c6 != ((e) list.get(i21)).c(i10)) {
                            i8 = i21;
                            break;
                        }
                        i21++;
                    }
                }
                if (i20 == i8 && i10 + 1 == ((e) list.get(i6)).o()) {
                    bVar.m0(((Number) list2.get(i6)).intValue());
                    i9 = i8;
                    bVar2 = bVar4;
                } else {
                    bVar.m0(((int) (c4 + c(bVar4))) * i12);
                    i9 = i8;
                    bVar2 = bVar4;
                    a(c4, bVar4, i10 + 1, list, i6, i8, list2);
                }
                bVar4 = bVar2;
                i6 = i9;
                i12 = -1;
            }
            bVar.k0(bVar4);
        }

        static /* synthetic */ void b(a aVar, long j3, b bVar, int i3, List list, int i4, int i5, List list2, int i6, Object obj) {
            aVar.a((i6 & 1) != 0 ? 0L : j3, bVar, (i6 & 4) != 0 ? 0 : i3, list, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? list.size() : i5, list2);
        }

        private final long c(b bVar) {
            return bVar.e0() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final U2.j d(U2.e... r17) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: U2.j.a.d(U2.e[]):U2.j");
        }

        private a() {
        }
    }

    public /* synthetic */ j(e[] eVarArr, int[] iArr, D2.g gVar) {
        this(eVarArr, iArr);
    }

    public static final j h(e... eVarArr) {
        return f2472h.d(eVarArr);
    }

    @Override // q2.AbstractC0531a
    public int a() {
        return this.f2473f.length;
    }

    public /* bridge */ boolean b(e eVar) {
        return super.contains(eVar);
    }

    @Override // q2.AbstractC0532b, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e get(int i3) {
        return this.f2473f[i3];
    }

    @Override // q2.AbstractC0531a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof e) {
            return b((e) obj);
        }
        return false;
    }

    public final e[] d() {
        return this.f2473f;
    }

    public final int[] e() {
        return this.f2474g;
    }

    public /* bridge */ int f(e eVar) {
        return super.indexOf(eVar);
    }

    public /* bridge */ int g(e eVar) {
        return super.lastIndexOf(eVar);
    }

    @Override // q2.AbstractC0532b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof e) {
            return f((e) obj);
        }
        return -1;
    }

    @Override // q2.AbstractC0532b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof e) {
            return g((e) obj);
        }
        return -1;
    }

    private j(e[] eVarArr, int[] iArr) {
        this.f2473f = eVarArr;
        this.f2474g = iArr;
    }
}
