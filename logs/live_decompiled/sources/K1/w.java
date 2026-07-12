package k1;

import a1.C0221a;
import android.graphics.Color;
import android.graphics.Rect;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import g1.C0366b;
import h1.C0372a;
import h1.InterfaceC0374c;
import i1.e;
import java.util.ArrayList;
import java.util.Collections;
import l1.c;
import m1.AbstractC0465h;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12282a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12283b = c.a.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f12284c = c.a.a("ty", "nm");

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12285a;

        static {
            int[] iArr = new int[e.b.values().length];
            f12285a = iArr;
            try {
                iArr[e.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12285a[e.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static i1.e a(C0221a c0221a) {
        Rect b3 = c0221a.b();
        return new i1.e(Collections.emptyList(), c0221a, "__container", -1L, e.a.PRE_COMP, -1L, null, Collections.emptyList(), new g1.l(), 0, 0, 0, 0.0f, 0.0f, b3.width(), b3.height(), null, null, Collections.emptyList(), e.b.NONE, null, false, null, null);
    }

    public static i1.e b(l1.c cVar, C0221a c0221a) {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f3;
        e.b bVar = e.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.c();
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        e.b bVar2 = bVar;
        e.a aVar = null;
        String str = null;
        g1.l lVar = null;
        g1.j jVar = null;
        g1.k kVar = null;
        C0366b c0366b = null;
        C0372a c0372a = null;
        C0439j c0439j = null;
        long j3 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        long j4 = -1;
        float f8 = 1.0f;
        String str2 = "UNSET";
        String str3 = null;
        float f9 = 0.0f;
        while (cVar.j()) {
            switch (cVar.a0(f12282a)) {
                case 0:
                    str2 = cVar.G();
                    break;
                case 1:
                    j3 = cVar.q();
                    break;
                case 2:
                    str = cVar.G();
                    break;
                case 3:
                    int q3 = cVar.q();
                    aVar = e.a.UNKNOWN;
                    if (q3 >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = e.a.values()[q3];
                        break;
                    }
                case 4:
                    j4 = cVar.q();
                    break;
                case 5:
                    i3 = (int) (cVar.q() * AbstractC0465h.e());
                    break;
                case 6:
                    i4 = (int) (cVar.q() * AbstractC0465h.e());
                    break;
                case 7:
                    i5 = Color.parseColor(cVar.G());
                    break;
                case 8:
                    lVar = AbstractC0432c.g(cVar, c0221a);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    int q4 = cVar.q();
                    if (q4 < e.b.values().length) {
                        bVar2 = e.b.values()[q4];
                        int i6 = a.f12285a[bVar2.ordinal()];
                        if (i6 == 1) {
                            c0221a.a("Unsupported matte type: Luma");
                        } else if (i6 == 2) {
                            c0221a.a("Unsupported matte type: Luma Inverted");
                        }
                        c0221a.r(1);
                        break;
                    } else {
                        c0221a.a("Unsupported matte type: " + q4);
                        break;
                    }
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    cVar.b();
                    while (cVar.j()) {
                        arrayList3.add(x.a(cVar, c0221a));
                    }
                    c0221a.r(arrayList3.size());
                    cVar.g();
                    break;
                case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                    cVar.b();
                    while (cVar.j()) {
                        InterfaceC0374c a3 = AbstractC0437h.a(cVar, c0221a);
                        if (a3 != null) {
                            arrayList4.add(a3);
                        }
                    }
                    cVar.g();
                    break;
                case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                    cVar.c();
                    while (cVar.j()) {
                        int a02 = cVar.a0(f12283b);
                        if (a02 == 0) {
                            jVar = AbstractC0433d.d(cVar, c0221a);
                        } else if (a02 != 1) {
                            cVar.b0();
                            cVar.c0();
                        } else {
                            cVar.b();
                            if (cVar.j()) {
                                kVar = AbstractC0431b.a(cVar, c0221a);
                            }
                            while (cVar.j()) {
                                cVar.c0();
                            }
                            cVar.g();
                        }
                    }
                    cVar.i();
                    break;
                case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                    cVar.b();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.j()) {
                        cVar.c();
                        while (cVar.j()) {
                            int a03 = cVar.a0(f12284c);
                            if (a03 == 0) {
                                int q5 = cVar.q();
                                if (q5 == 29) {
                                    c0372a = AbstractC0434e.b(cVar, c0221a);
                                } else if (q5 == 25) {
                                    c0439j = new C0440k().b(cVar, c0221a);
                                }
                            } else if (a03 != 1) {
                                cVar.b0();
                                cVar.c0();
                            } else {
                                arrayList5.add(cVar.G());
                            }
                        }
                        cVar.i();
                    }
                    cVar.g();
                    c0221a.a("Effective doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                    f8 = (float) cVar.p();
                    break;
                case COUIViewDragHelper.EDGE_ALL /* 15 */:
                    f4 = (float) cVar.p();
                    break;
                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                    f5 = (float) (cVar.p() * AbstractC0465h.e());
                    break;
                case 17:
                    f6 = (float) (cVar.p() * AbstractC0465h.e());
                    break;
                case 18:
                    f9 = (float) cVar.p();
                    break;
                case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                    f7 = (float) cVar.p();
                    break;
                case 20:
                    c0366b = AbstractC0433d.f(cVar, c0221a, false);
                    break;
                case 21:
                    str3 = cVar.G();
                    break;
                case 22:
                    z3 = cVar.l();
                    break;
                default:
                    cVar.b0();
                    cVar.c0();
                    break;
            }
        }
        cVar.i();
        ArrayList arrayList6 = new ArrayList();
        if (f9 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new n1.c(c0221a, valueOf, valueOf, null, 0.0f, Float.valueOf(f9)));
            f3 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f3 = 0.0f;
        }
        if (f7 <= f3) {
            f7 = c0221a.f();
        }
        arrayList2.add(new n1.c(c0221a, valueOf2, valueOf2, null, f9, Float.valueOf(f7)));
        arrayList2.add(new n1.c(c0221a, valueOf, valueOf, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (AbstractC0465h.n(str2, ".ai") || "ai".equals(str3)) {
            c0221a.a("Convert your Illustrator layers to shape layers.");
        }
        return new i1.e(arrayList4, c0221a, str2, j3, aVar, j4, str, arrayList, lVar, i3, i4, i5, f8, f4, f5, f6, jVar, kVar, arrayList2, bVar2, c0366b, z3, c0372a, c0439j);
    }
}
