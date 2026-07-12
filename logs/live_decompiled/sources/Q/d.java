package q;

import com.oplus.backup.sdk.common.utils.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import n.C0473c;
import n.C0479i;
import r.o;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private int f12838b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12839c;

    /* renamed from: d, reason: collision with root package name */
    public final e f12840d;

    /* renamed from: e, reason: collision with root package name */
    public final b f12841e;

    /* renamed from: f, reason: collision with root package name */
    public d f12842f;

    /* renamed from: i, reason: collision with root package name */
    C0479i f12845i;

    /* renamed from: a, reason: collision with root package name */
    private HashSet f12837a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f12843g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f12844h = Integer.MIN_VALUE;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12846a;

        static {
            int[] iArr = new int[b.values().length];
            f12846a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12846a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12846a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12846a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12846a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12846a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12846a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12846a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12846a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f12840d = eVar;
        this.f12841e = bVar;
    }

    public boolean a(d dVar, int i3, int i4, boolean z3) {
        if (dVar == null) {
            p();
            return true;
        }
        if (!z3 && !o(dVar)) {
            return false;
        }
        this.f12842f = dVar;
        if (dVar.f12837a == null) {
            dVar.f12837a = new HashSet();
        }
        HashSet hashSet = this.f12842f.f12837a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f12843g = i3;
        this.f12844h = i4;
        return true;
    }

    public void b(int i3, ArrayList arrayList, o oVar) {
        HashSet hashSet = this.f12837a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                r.i.a(((d) it.next()).f12840d, i3, arrayList, oVar);
            }
        }
    }

    public HashSet c() {
        return this.f12837a;
    }

    public int d() {
        if (this.f12839c) {
            return this.f12838b;
        }
        return 0;
    }

    public int e() {
        d dVar;
        if (this.f12840d.T() == 8) {
            return 0;
        }
        return (this.f12844h == Integer.MIN_VALUE || (dVar = this.f12842f) == null || dVar.f12840d.T() != 8) ? this.f12843g : this.f12844h;
    }

    public final d f() {
        switch (a.f12846a[this.f12841e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                return null;
            case 2:
                return this.f12840d.f12884Q;
            case 3:
                return this.f12840d.f12882O;
            case 4:
                return this.f12840d.f12885R;
            case 5:
                return this.f12840d.f12883P;
            default:
                throw new AssertionError(this.f12841e.name());
        }
    }

    public e g() {
        return this.f12840d;
    }

    public C0479i h() {
        return this.f12845i;
    }

    public d i() {
        return this.f12842f;
    }

    public b j() {
        return this.f12841e;
    }

    public boolean k() {
        HashSet hashSet = this.f12837a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        HashSet hashSet = this.f12837a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean m() {
        return this.f12839c;
    }

    public boolean n() {
        return this.f12842f != null;
    }

    public boolean o(d dVar) {
        if (dVar == null) {
            return false;
        }
        b j3 = dVar.j();
        b bVar = this.f12841e;
        if (j3 == bVar) {
            return bVar != b.BASELINE || (dVar.g().X() && g().X());
        }
        switch (a.f12846a[bVar.ordinal()]) {
            case 1:
                return (j3 == b.BASELINE || j3 == b.CENTER_X || j3 == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z3 = j3 == b.LEFT || j3 == b.RIGHT;
                if (dVar.g() instanceof g) {
                    return z3 || j3 == b.CENTER_X;
                }
                return z3;
            case 4:
            case 5:
                boolean z4 = j3 == b.TOP || j3 == b.BOTTOM;
                if (dVar.g() instanceof g) {
                    return z4 || j3 == b.CENTER_Y;
                }
                return z4;
            case 6:
                return (j3 == b.LEFT || j3 == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                return false;
            default:
                throw new AssertionError(this.f12841e.name());
        }
    }

    public void p() {
        HashSet hashSet;
        d dVar = this.f12842f;
        if (dVar != null && (hashSet = dVar.f12837a) != null) {
            hashSet.remove(this);
            if (this.f12842f.f12837a.size() == 0) {
                this.f12842f.f12837a = null;
            }
        }
        this.f12837a = null;
        this.f12842f = null;
        this.f12843g = 0;
        this.f12844h = Integer.MIN_VALUE;
        this.f12839c = false;
        this.f12838b = 0;
    }

    public void q() {
        this.f12839c = false;
        this.f12838b = 0;
    }

    public void r(C0473c c0473c) {
        C0479i c0479i = this.f12845i;
        if (c0479i == null) {
            this.f12845i = new C0479i(C0479i.a.UNRESTRICTED, null);
        } else {
            c0479i.e();
        }
    }

    public void s(int i3) {
        this.f12838b = i3;
        this.f12839c = true;
    }

    public String toString() {
        return this.f12840d.r() + ":" + this.f12841e.toString();
    }
}
