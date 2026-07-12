package k1;

import a1.C0221a;
import h1.C0379h;
import m1.AbstractC0462e;

/* loaded from: classes.dex */
abstract class x {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static C0379h a(l1.c cVar, C0221a c0221a) {
        boolean z3;
        boolean z4;
        cVar.c();
        C0379h.a aVar = null;
        g1.h hVar = null;
        g1.d dVar = null;
        boolean z5 = false;
        while (cVar.j()) {
            String u3 = cVar.u();
            u3.hashCode();
            switch (u3.hashCode()) {
                case 111:
                    if (u3.equals("o")) {
                        z3 = false;
                        break;
                    }
                    z3 = -1;
                    break;
                case 3588:
                    if (u3.equals("pt")) {
                        z3 = true;
                        break;
                    }
                    z3 = -1;
                    break;
                case 104433:
                    if (u3.equals("inv")) {
                        z3 = 2;
                        break;
                    }
                    z3 = -1;
                    break;
                case 3357091:
                    if (u3.equals("mode")) {
                        z3 = 3;
                        break;
                    }
                    z3 = -1;
                    break;
                default:
                    z3 = -1;
                    break;
            }
            switch (z3) {
                case false:
                    dVar = AbstractC0433d.h(cVar, c0221a);
                    break;
                case true:
                    hVar = AbstractC0433d.k(cVar, c0221a);
                    break;
                case true:
                    z5 = cVar.l();
                    break;
                case true:
                    String G3 = cVar.G();
                    G3.hashCode();
                    switch (G3.hashCode()) {
                        case 97:
                            if (G3.equals("a")) {
                                z4 = false;
                                break;
                            }
                            z4 = -1;
                            break;
                        case 105:
                            if (G3.equals("i")) {
                                z4 = true;
                                break;
                            }
                            z4 = -1;
                            break;
                        case 110:
                            if (G3.equals("n")) {
                                z4 = 2;
                                break;
                            }
                            z4 = -1;
                            break;
                        case 115:
                            if (G3.equals("s")) {
                                z4 = 3;
                                break;
                            }
                            z4 = -1;
                            break;
                        default:
                            z4 = -1;
                            break;
                    }
                    switch (z4) {
                        case false:
                            aVar = C0379h.a.MASK_MODE_ADD;
                            break;
                        case true:
                            c0221a.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = C0379h.a.MASK_MODE_INTERSECT;
                            break;
                        case true:
                            aVar = C0379h.a.MASK_MODE_NONE;
                            break;
                        case true:
                            aVar = C0379h.a.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            AbstractC0462e.c("Unknown mask mode " + u3 + ". Defaulting to Add.");
                            aVar = C0379h.a.MASK_MODE_ADD;
                            break;
                    }
                default:
                    cVar.c0();
                    break;
            }
        }
        cVar.i();
        return new C0379h(aVar, hVar, dVar, z5);
    }
}
