package q;

import androidx.preference.Preference;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import n.C0473c;
import n.C0474d;
import p.C0494a;
import q.d;
import r.l;
import r.n;
import r.p;

/* loaded from: classes.dex */
public class e {

    /* renamed from: K0, reason: collision with root package name */
    public static float f12857K0 = 0.5f;

    /* renamed from: A0, reason: collision with root package name */
    int f12859A0;

    /* renamed from: B0, reason: collision with root package name */
    boolean f12861B0;

    /* renamed from: C0, reason: collision with root package name */
    boolean f12863C0;

    /* renamed from: D0, reason: collision with root package name */
    public float[] f12865D0;

    /* renamed from: E0, reason: collision with root package name */
    protected e[] f12867E0;

    /* renamed from: F0, reason: collision with root package name */
    protected e[] f12869F0;

    /* renamed from: G0, reason: collision with root package name */
    e f12871G0;

    /* renamed from: H0, reason: collision with root package name */
    e f12873H0;

    /* renamed from: I0, reason: collision with root package name */
    public int f12875I0;

    /* renamed from: J0, reason: collision with root package name */
    public int f12877J0;

    /* renamed from: K, reason: collision with root package name */
    private boolean f12878K;

    /* renamed from: V, reason: collision with root package name */
    public d f12889V;

    /* renamed from: W, reason: collision with root package name */
    public d[] f12890W;

    /* renamed from: X, reason: collision with root package name */
    protected ArrayList f12891X;

    /* renamed from: Y, reason: collision with root package name */
    private boolean[] f12892Y;

    /* renamed from: Z, reason: collision with root package name */
    public b[] f12893Z;

    /* renamed from: a0, reason: collision with root package name */
    public e f12895a0;

    /* renamed from: b0, reason: collision with root package name */
    int f12897b0;

    /* renamed from: c, reason: collision with root package name */
    public r.c f12898c;

    /* renamed from: c0, reason: collision with root package name */
    int f12899c0;

    /* renamed from: d, reason: collision with root package name */
    public r.c f12900d;

    /* renamed from: d0, reason: collision with root package name */
    public float f12901d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f12903e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f12905f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f12907g0;

    /* renamed from: h0, reason: collision with root package name */
    int f12909h0;

    /* renamed from: i0, reason: collision with root package name */
    int f12911i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f12913j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f12915k0;

    /* renamed from: l0, reason: collision with root package name */
    int f12917l0;

    /* renamed from: m0, reason: collision with root package name */
    protected int f12919m0;

    /* renamed from: n0, reason: collision with root package name */
    protected int f12921n0;

    /* renamed from: o, reason: collision with root package name */
    public String f12922o;

    /* renamed from: o0, reason: collision with root package name */
    float f12923o0;

    /* renamed from: p0, reason: collision with root package name */
    float f12925p0;

    /* renamed from: q0, reason: collision with root package name */
    private Object f12927q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f12929r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f12931s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f12933t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f12935u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f12937v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f12939w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f12941x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f12943y0;

    /* renamed from: z0, reason: collision with root package name */
    int f12945z0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12894a = false;

    /* renamed from: b, reason: collision with root package name */
    public p[] f12896b = new p[2];

    /* renamed from: e, reason: collision with root package name */
    public l f12902e = null;

    /* renamed from: f, reason: collision with root package name */
    public n f12904f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f12906g = {true, true};

    /* renamed from: h, reason: collision with root package name */
    boolean f12908h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12910i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12912j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12914k = true;

    /* renamed from: l, reason: collision with root package name */
    private int f12916l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f12918m = -1;

    /* renamed from: n, reason: collision with root package name */
    public C0494a f12920n = new C0494a(this);

    /* renamed from: p, reason: collision with root package name */
    private boolean f12924p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12926q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12928r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12930s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f12932t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f12934u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f12936v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f12938w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f12940x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int[] f12942y = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public int f12944z = 0;

    /* renamed from: A, reason: collision with root package name */
    public int f12858A = 0;

    /* renamed from: B, reason: collision with root package name */
    public float f12860B = 1.0f;

    /* renamed from: C, reason: collision with root package name */
    public int f12862C = 0;

    /* renamed from: D, reason: collision with root package name */
    public int f12864D = 0;

    /* renamed from: E, reason: collision with root package name */
    public float f12866E = 1.0f;

    /* renamed from: F, reason: collision with root package name */
    int f12868F = -1;

    /* renamed from: G, reason: collision with root package name */
    float f12870G = 1.0f;

    /* renamed from: H, reason: collision with root package name */
    private int[] f12872H = {Preference.DEFAULT_ORDER, Preference.DEFAULT_ORDER};

    /* renamed from: I, reason: collision with root package name */
    private float f12874I = 0.0f;

    /* renamed from: J, reason: collision with root package name */
    private boolean f12876J = false;

    /* renamed from: L, reason: collision with root package name */
    private boolean f12879L = false;

    /* renamed from: M, reason: collision with root package name */
    private int f12880M = 0;

    /* renamed from: N, reason: collision with root package name */
    private int f12881N = 0;

    /* renamed from: O, reason: collision with root package name */
    public d f12882O = new d(this, d.b.LEFT);

    /* renamed from: P, reason: collision with root package name */
    public d f12883P = new d(this, d.b.TOP);

    /* renamed from: Q, reason: collision with root package name */
    public d f12884Q = new d(this, d.b.RIGHT);

    /* renamed from: R, reason: collision with root package name */
    public d f12885R = new d(this, d.b.BOTTOM);

    /* renamed from: S, reason: collision with root package name */
    public d f12886S = new d(this, d.b.BASELINE);

    /* renamed from: T, reason: collision with root package name */
    d f12887T = new d(this, d.b.CENTER_X);

    /* renamed from: U, reason: collision with root package name */
    d f12888U = new d(this, d.b.CENTER_Y);

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12946a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12947b;

        static {
            int[] iArr = new int[b.values().length];
            f12947b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12947b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12947b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12947b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f12946a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12946a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12946a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12946a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12946a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12946a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12946a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12946a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12946a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.f12889V = dVar;
        this.f12890W = new d[]{this.f12882O, this.f12884Q, this.f12883P, this.f12885R, this.f12886S, dVar};
        this.f12891X = new ArrayList();
        this.f12892Y = new boolean[2];
        b bVar = b.FIXED;
        this.f12893Z = new b[]{bVar, bVar};
        this.f12895a0 = null;
        this.f12897b0 = 0;
        this.f12899c0 = 0;
        this.f12901d0 = 0.0f;
        this.f12903e0 = -1;
        this.f12905f0 = 0;
        this.f12907g0 = 0;
        this.f12909h0 = 0;
        this.f12911i0 = 0;
        this.f12913j0 = 0;
        this.f12915k0 = 0;
        this.f12917l0 = 0;
        float f3 = f12857K0;
        this.f12923o0 = f3;
        this.f12925p0 = f3;
        this.f12929r0 = 0;
        this.f12931s0 = 0;
        this.f12933t0 = false;
        this.f12935u0 = null;
        this.f12937v0 = null;
        this.f12943y0 = false;
        this.f12945z0 = 0;
        this.f12859A0 = 0;
        this.f12865D0 = new float[]{-1.0f, -1.0f};
        this.f12867E0 = new e[]{null, null};
        this.f12869F0 = new e[]{null, null};
        this.f12871G0 = null;
        this.f12873H0 = null;
        this.f12875I0 = -1;
        this.f12877J0 = -1;
        d();
    }

    private void N(StringBuilder sb, String str, int i3, int i4, int i5, int i6, int i7, int i8, float f3, float f4) {
        sb.append(str);
        sb.append(" :  {\n");
        v0(sb, "      size", i3, 0);
        v0(sb, "      min", i4, 0);
        v0(sb, "      max", i5, Preference.DEFAULT_ORDER);
        v0(sb, "      matchMin", i7, 0);
        v0(sb, "      matchDef", i8, 0);
        u0(sb, "      matchPercent", f3, 1.0f);
        sb.append("    },\n");
    }

    private void O(StringBuilder sb, String str, d dVar) {
        if (dVar.f12842f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f12842f);
        sb.append("'");
        if (dVar.f12844h != Integer.MIN_VALUE || dVar.f12843g != 0) {
            sb.append(",");
            sb.append(dVar.f12843g);
            if (dVar.f12844h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(dVar.f12844h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d() {
        this.f12891X.add(this.f12882O);
        this.f12891X.add(this.f12883P);
        this.f12891X.add(this.f12884Q);
        this.f12891X.add(this.f12885R);
        this.f12891X.add(this.f12887T);
        this.f12891X.add(this.f12888U);
        this.f12891X.add(this.f12889V);
        this.f12891X.add(this.f12886S);
    }

    private boolean d0(int i3) {
        d dVar;
        d dVar2;
        int i4 = i3 * 2;
        d[] dVarArr = this.f12890W;
        d dVar3 = dVarArr[i4];
        d dVar4 = dVar3.f12842f;
        return (dVar4 == null || dVar4.f12842f == dVar3 || (dVar2 = (dVar = dVarArr[i4 + 1]).f12842f) == null || dVar2.f12842f != dVar) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0481, code lost:
    
        if ((r4 instanceof q.C0512a) != false) goto L266;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0524 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x056f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:316:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0541 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(n.C0474d r38, boolean r39, boolean r40, boolean r41, boolean r42, n.C0479i r43, n.C0479i r44, q.e.b r45, boolean r46, q.d r47, q.d r48, int r49, int r50, int r51, int r52, float r53, boolean r54, boolean r55, boolean r56, boolean r57, boolean r58, int r59, int r60, int r61, int r62, float r63, boolean r64) {
        /*
            Method dump skipped, instructions count: 1450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.i(n.d, boolean, boolean, boolean, boolean, n.i, n.i, q.e$b, boolean, q.d, q.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private void u0(StringBuilder sb, String str, float f3, float f4) {
        if (f3 == f4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f3);
        sb.append(",\n");
    }

    private void v0(StringBuilder sb, String str, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i3);
        sb.append(",\n");
    }

    private void w0(StringBuilder sb, String str, float f3, int i3) {
        if (f3 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f3);
        sb.append(",");
        sb.append(i3);
        sb.append("");
        sb.append("],\n");
    }

    public int A() {
        return this.f12880M;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0086 -> B:31:0x0087). Please report as a decompilation issue!!! */
    public void A0(String str) {
        float f3;
        int i3 = 0;
        if (str == null || str.length() == 0) {
            this.f12901d0 = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i4 = -1;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            i4 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
            r3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(r3);
            if (substring2.length() > 0) {
                f3 = Float.parseFloat(substring2);
            }
            f3 = i3;
        } else {
            String substring3 = str.substring(r3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f3 = i4 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f3 = i3;
        }
        i3 = (f3 > i3 ? 1 : (f3 == i3 ? 0 : -1));
        if (i3 > 0) {
            this.f12901d0 = f3;
            this.f12903e0 = i4;
        }
    }

    public int B() {
        return this.f12881N;
    }

    public void B0(int i3) {
        if (this.f12876J) {
            int i4 = i3 - this.f12917l0;
            int i5 = this.f12899c0 + i4;
            this.f12907g0 = i4;
            this.f12883P.s(i4);
            this.f12885R.s(i5);
            this.f12886S.s(i3);
            this.f12926q = true;
        }
    }

    public int C(int i3) {
        if (i3 == 0) {
            return U();
        }
        if (i3 == 1) {
            return v();
        }
        return 0;
    }

    public void C0(int i3, int i4) {
        if (this.f12924p) {
            return;
        }
        this.f12882O.s(i3);
        this.f12884Q.s(i4);
        this.f12905f0 = i3;
        this.f12897b0 = i4 - i3;
        this.f12924p = true;
    }

    public int D() {
        return this.f12872H[1];
    }

    public void D0(int i3) {
        this.f12882O.s(i3);
        this.f12905f0 = i3;
    }

    public int E() {
        return this.f12872H[0];
    }

    public void E0(int i3) {
        this.f12883P.s(i3);
        this.f12907g0 = i3;
    }

    public int F() {
        return this.f12921n0;
    }

    public void F0(int i3, int i4) {
        if (this.f12926q) {
            return;
        }
        this.f12883P.s(i3);
        this.f12885R.s(i4);
        this.f12907g0 = i3;
        this.f12899c0 = i4 - i3;
        if (this.f12876J) {
            this.f12886S.s(i3 + this.f12917l0);
        }
        this.f12926q = true;
    }

    public int G() {
        return this.f12919m0;
    }

    public void G0(int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        this.f12905f0 = i3;
        this.f12907g0 = i4;
        if (this.f12931s0 == 8) {
            this.f12897b0 = 0;
            this.f12899c0 = 0;
            return;
        }
        b[] bVarArr = this.f12893Z;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i9 < (i8 = this.f12897b0)) {
            i9 = i8;
        }
        if (bVarArr[1] == bVar2 && i10 < (i7 = this.f12899c0)) {
            i10 = i7;
        }
        this.f12897b0 = i9;
        this.f12899c0 = i10;
        int i11 = this.f12921n0;
        if (i10 < i11) {
            this.f12899c0 = i11;
        }
        int i12 = this.f12919m0;
        if (i9 < i12) {
            this.f12897b0 = i12;
        }
        int i13 = this.f12858A;
        if (i13 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.f12897b0 = Math.min(this.f12897b0, i13);
        }
        int i14 = this.f12864D;
        if (i14 > 0 && this.f12893Z[1] == b.MATCH_CONSTRAINT) {
            this.f12899c0 = Math.min(this.f12899c0, i14);
        }
        int i15 = this.f12897b0;
        if (i9 != i15) {
            this.f12916l = i15;
        }
        int i16 = this.f12899c0;
        if (i10 != i16) {
            this.f12918m = i16;
        }
    }

    public e H(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.f12885R).f12842f) != null && dVar2.f12842f == dVar) {
                return dVar2.f12840d;
            }
            return null;
        }
        d dVar3 = this.f12884Q;
        d dVar4 = dVar3.f12842f;
        if (dVar4 == null || dVar4.f12842f != dVar3) {
            return null;
        }
        return dVar4.f12840d;
    }

    public void H0(boolean z3) {
        this.f12876J = z3;
    }

    public e I() {
        return this.f12895a0;
    }

    public void I0(int i3) {
        this.f12899c0 = i3;
        int i4 = this.f12921n0;
        if (i3 < i4) {
            this.f12899c0 = i4;
        }
    }

    public e J(int i3) {
        d dVar;
        d dVar2;
        if (i3 != 0) {
            if (i3 == 1 && (dVar2 = (dVar = this.f12883P).f12842f) != null && dVar2.f12842f == dVar) {
                return dVar2.f12840d;
            }
            return null;
        }
        d dVar3 = this.f12882O;
        d dVar4 = dVar3.f12842f;
        if (dVar4 == null || dVar4.f12842f != dVar3) {
            return null;
        }
        return dVar4.f12840d;
    }

    public void J0(float f3) {
        this.f12923o0 = f3;
    }

    public int K() {
        return V() + this.f12897b0;
    }

    public void K0(int i3) {
        this.f12945z0 = i3;
    }

    public p L(int i3) {
        if (i3 == 0) {
            return this.f12902e;
        }
        if (i3 == 1) {
            return this.f12904f;
        }
        return null;
    }

    public void L0(int i3, int i4) {
        this.f12905f0 = i3;
        int i5 = i4 - i3;
        this.f12897b0 = i5;
        int i6 = this.f12919m0;
        if (i5 < i6) {
            this.f12897b0 = i6;
        }
    }

    public void M(StringBuilder sb) {
        sb.append("  " + this.f12922o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f12897b0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f12899c0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f12905f0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f12907g0);
        sb.append("\n");
        O(sb, "left", this.f12882O);
        O(sb, "top", this.f12883P);
        O(sb, "right", this.f12884Q);
        O(sb, "bottom", this.f12885R);
        O(sb, "baseline", this.f12886S);
        O(sb, "centerX", this.f12887T);
        O(sb, "centerY", this.f12888U);
        N(sb, "    width", this.f12897b0, this.f12919m0, this.f12872H[0], this.f12916l, this.f12944z, this.f12938w, this.f12860B, this.f12865D0[0]);
        N(sb, "    height", this.f12899c0, this.f12921n0, this.f12872H[1], this.f12918m, this.f12862C, this.f12940x, this.f12866E, this.f12865D0[1]);
        w0(sb, "    dimensionRatio", this.f12901d0, this.f12903e0);
        u0(sb, "    horizontalBias", this.f12923o0, f12857K0);
        u0(sb, "    verticalBias", this.f12925p0, f12857K0);
        v0(sb, "    horizontalChainStyle", this.f12945z0, 0);
        v0(sb, "    verticalChainStyle", this.f12859A0, 0);
        sb.append("  }");
    }

    public void M0(b bVar) {
        this.f12893Z[0] = bVar;
    }

    public void N0(int i3, int i4, int i5, float f3) {
        this.f12938w = i3;
        this.f12944z = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.f12858A = i5;
        this.f12860B = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f12938w = 2;
    }

    public void O0(float f3) {
        this.f12865D0[0] = f3;
    }

    public float P() {
        return this.f12925p0;
    }

    protected void P0(int i3, boolean z3) {
        this.f12892Y[i3] = z3;
    }

    public int Q() {
        return this.f12859A0;
    }

    public void Q0(boolean z3) {
        this.f12878K = z3;
    }

    public b R() {
        return this.f12893Z[1];
    }

    public void R0(int i3, int i4) {
        this.f12880M = i3;
        this.f12881N = i4;
        U0(false);
    }

    public int S() {
        int i3 = this.f12882O != null ? this.f12883P.f12843g : 0;
        return this.f12884Q != null ? i3 + this.f12885R.f12843g : i3;
    }

    public void S0(int i3) {
        this.f12872H[1] = i3;
    }

    public int T() {
        return this.f12931s0;
    }

    public void T0(int i3) {
        this.f12872H[0] = i3;
    }

    public int U() {
        if (this.f12931s0 == 8) {
            return 0;
        }
        return this.f12897b0;
    }

    public void U0(boolean z3) {
        this.f12910i = z3;
    }

    public int V() {
        e eVar = this.f12895a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f12905f0 : ((f) eVar).f12959S0 + this.f12905f0;
    }

    public void V0(int i3) {
        if (i3 < 0) {
            this.f12921n0 = 0;
        } else {
            this.f12921n0 = i3;
        }
    }

    public int W() {
        e eVar = this.f12895a0;
        return (eVar == null || !(eVar instanceof f)) ? this.f12907g0 : ((f) eVar).f12960T0 + this.f12907g0;
    }

    public void W0(int i3) {
        if (i3 < 0) {
            this.f12919m0 = 0;
        } else {
            this.f12919m0 = i3;
        }
    }

    public boolean X() {
        return this.f12876J;
    }

    public void X0(int i3, int i4) {
        this.f12905f0 = i3;
        this.f12907g0 = i4;
    }

    public boolean Y(int i3) {
        if (i3 == 0) {
            return (this.f12882O.f12842f != null ? 1 : 0) + (this.f12884Q.f12842f != null ? 1 : 0) < 2;
        }
        return ((this.f12883P.f12842f != null ? 1 : 0) + (this.f12885R.f12842f != null ? 1 : 0)) + (this.f12886S.f12842f != null ? 1 : 0) < 2;
    }

    public void Y0(e eVar) {
        this.f12895a0 = eVar;
    }

    public boolean Z() {
        int size = this.f12891X.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((d) this.f12891X.get(i3)).l()) {
                return true;
            }
        }
        return false;
    }

    public void Z0(float f3) {
        this.f12925p0 = f3;
    }

    public boolean a0() {
        return (this.f12916l == -1 && this.f12918m == -1) ? false : true;
    }

    public void a1(int i3) {
        this.f12859A0 = i3;
    }

    public boolean b0(int i3, int i4) {
        d dVar;
        d dVar2;
        if (i3 == 0) {
            d dVar3 = this.f12882O.f12842f;
            return dVar3 != null && dVar3.m() && (dVar2 = this.f12884Q.f12842f) != null && dVar2.m() && (this.f12884Q.f12842f.d() - this.f12884Q.e()) - (this.f12882O.f12842f.d() + this.f12882O.e()) >= i4;
        }
        d dVar4 = this.f12883P.f12842f;
        return dVar4 != null && dVar4.m() && (dVar = this.f12885R.f12842f) != null && dVar.m() && (this.f12885R.f12842f.d() - this.f12885R.e()) - (this.f12883P.f12842f.d() + this.f12883P.e()) >= i4;
        return false;
    }

    public void b1(int i3, int i4) {
        this.f12907g0 = i3;
        int i5 = i4 - i3;
        this.f12899c0 = i5;
        int i6 = this.f12921n0;
        if (i5 < i6) {
            this.f12899c0 = i6;
        }
    }

    public void c0(d.b bVar, e eVar, d.b bVar2, int i3, int i4) {
        m(bVar).a(eVar.m(bVar2), i3, i4, true);
    }

    public void c1(b bVar) {
        this.f12893Z[1] = bVar;
    }

    public void d1(int i3, int i4, int i5, float f3) {
        this.f12940x = i3;
        this.f12862C = i4;
        if (i5 == Integer.MAX_VALUE) {
            i5 = 0;
        }
        this.f12864D = i5;
        this.f12866E = f3;
        if (f3 <= 0.0f || f3 >= 1.0f || i3 != 0) {
            return;
        }
        this.f12940x = 2;
    }

    public void e(f fVar, C0474d c0474d, HashSet hashSet, int i3, boolean z3) {
        if (z3) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(fVar, c0474d, this);
            hashSet.remove(this);
            g(c0474d, fVar.P1(64));
        }
        if (i3 == 0) {
            HashSet c3 = this.f12882O.c();
            if (c3 != null) {
                Iterator it = c3.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f12840d.e(fVar, c0474d, hashSet, i3, true);
                }
            }
            HashSet c4 = this.f12884Q.c();
            if (c4 != null) {
                Iterator it2 = c4.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f12840d.e(fVar, c0474d, hashSet, i3, true);
                }
                return;
            }
            return;
        }
        HashSet c5 = this.f12883P.c();
        if (c5 != null) {
            Iterator it3 = c5.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f12840d.e(fVar, c0474d, hashSet, i3, true);
            }
        }
        HashSet c6 = this.f12885R.c();
        if (c6 != null) {
            Iterator it4 = c6.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f12840d.e(fVar, c0474d, hashSet, i3, true);
            }
        }
        HashSet c7 = this.f12886S.c();
        if (c7 != null) {
            Iterator it5 = c7.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f12840d.e(fVar, c0474d, hashSet, i3, true);
            }
        }
    }

    public boolean e0() {
        return this.f12928r;
    }

    public void e1(float f3) {
        this.f12865D0[1] = f3;
    }

    boolean f() {
        return this instanceof g;
    }

    public boolean f0(int i3) {
        return this.f12892Y[i3];
    }

    public void f1(int i3) {
        this.f12931s0 = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(n.C0474d r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.g(n.d, boolean):void");
    }

    public boolean g0() {
        d dVar = this.f12882O;
        d dVar2 = dVar.f12842f;
        if (dVar2 != null && dVar2.f12842f == dVar) {
            return true;
        }
        d dVar3 = this.f12884Q;
        d dVar4 = dVar3.f12842f;
        return dVar4 != null && dVar4.f12842f == dVar3;
    }

    public void g1(int i3) {
        this.f12897b0 = i3;
        int i4 = this.f12919m0;
        if (i3 < i4) {
            this.f12897b0 = i4;
        }
    }

    public boolean h() {
        return this.f12931s0 != 8;
    }

    public boolean h0() {
        return this.f12878K;
    }

    public void h1(int i3) {
        if (i3 < 0 || i3 > 3) {
            return;
        }
        this.f12936v = i3;
    }

    public boolean i0() {
        d dVar = this.f12883P;
        d dVar2 = dVar.f12842f;
        if (dVar2 != null && dVar2.f12842f == dVar) {
            return true;
        }
        d dVar3 = this.f12885R;
        d dVar4 = dVar3.f12842f;
        return dVar4 != null && dVar4.f12842f == dVar3;
    }

    public void i1(int i3) {
        this.f12905f0 = i3;
    }

    public void j(e eVar, float f3, int i3) {
        d.b bVar = d.b.CENTER;
        c0(bVar, eVar, bVar, i3, 0);
        this.f12874I = f3;
    }

    public boolean j0() {
        return this.f12879L;
    }

    public void j1(int i3) {
        this.f12907g0 = i3;
    }

    public void k(C0474d c0474d) {
        c0474d.q(this.f12882O);
        c0474d.q(this.f12883P);
        c0474d.q(this.f12884Q);
        c0474d.q(this.f12885R);
        if (this.f12917l0 > 0) {
            c0474d.q(this.f12886S);
        }
    }

    public boolean k0() {
        return this.f12910i && this.f12931s0 != 8;
    }

    public void k1(boolean z3, boolean z4, boolean z5, boolean z6) {
        if (this.f12868F == -1) {
            if (z5 && !z6) {
                this.f12868F = 0;
            } else if (!z5 && z6) {
                this.f12868F = 1;
                if (this.f12903e0 == -1) {
                    this.f12870G = 1.0f / this.f12870G;
                }
            }
        }
        if (this.f12868F == 0 && (!this.f12883P.n() || !this.f12885R.n())) {
            this.f12868F = 1;
        } else if (this.f12868F == 1 && (!this.f12882O.n() || !this.f12884Q.n())) {
            this.f12868F = 0;
        }
        if (this.f12868F == -1 && (!this.f12883P.n() || !this.f12885R.n() || !this.f12882O.n() || !this.f12884Q.n())) {
            if (this.f12883P.n() && this.f12885R.n()) {
                this.f12868F = 0;
            } else if (this.f12882O.n() && this.f12884Q.n()) {
                this.f12870G = 1.0f / this.f12870G;
                this.f12868F = 1;
            }
        }
        if (this.f12868F == -1) {
            int i3 = this.f12944z;
            if (i3 > 0 && this.f12862C == 0) {
                this.f12868F = 0;
            } else {
                if (i3 != 0 || this.f12862C <= 0) {
                    return;
                }
                this.f12870G = 1.0f / this.f12870G;
                this.f12868F = 1;
            }
        }
    }

    public void l() {
        if (this.f12902e == null) {
            this.f12902e = new l(this);
        }
        if (this.f12904f == null) {
            this.f12904f = new n(this);
        }
    }

    public boolean l0() {
        return this.f12924p || (this.f12882O.m() && this.f12884Q.m());
    }

    public void l1(boolean z3, boolean z4) {
        int i3;
        int i4;
        boolean k3 = z3 & this.f12902e.k();
        boolean k4 = z4 & this.f12904f.k();
        l lVar = this.f12902e;
        int i5 = lVar.f13139h.f13085g;
        n nVar = this.f12904f;
        int i6 = nVar.f13139h.f13085g;
        int i7 = lVar.f13140i.f13085g;
        int i8 = nVar.f13140i.f13085g;
        int i9 = i8 - i6;
        if (i7 - i5 < 0 || i9 < 0 || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE) {
            i7 = 0;
            i5 = 0;
            i8 = 0;
            i6 = 0;
        }
        int i10 = i7 - i5;
        int i11 = i8 - i6;
        if (k3) {
            this.f12905f0 = i5;
        }
        if (k4) {
            this.f12907g0 = i6;
        }
        if (this.f12931s0 == 8) {
            this.f12897b0 = 0;
            this.f12899c0 = 0;
            return;
        }
        if (k3) {
            if (this.f12893Z[0] == b.FIXED && i10 < (i4 = this.f12897b0)) {
                i10 = i4;
            }
            this.f12897b0 = i10;
            int i12 = this.f12919m0;
            if (i10 < i12) {
                this.f12897b0 = i12;
            }
        }
        if (k4) {
            if (this.f12893Z[1] == b.FIXED && i11 < (i3 = this.f12899c0)) {
                i11 = i3;
            }
            this.f12899c0 = i11;
            int i13 = this.f12921n0;
            if (i11 < i13) {
                this.f12899c0 = i13;
            }
        }
    }

    public d m(d.b bVar) {
        switch (a.f12946a[bVar.ordinal()]) {
            case 1:
                return this.f12882O;
            case 2:
                return this.f12883P;
            case 3:
                return this.f12884Q;
            case 4:
                return this.f12885R;
            case 5:
                return this.f12886S;
            case 6:
                return this.f12889V;
            case 7:
                return this.f12887T;
            case 8:
                return this.f12888U;
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean m0() {
        return this.f12926q || (this.f12883P.m() && this.f12885R.m());
    }

    public void m1(C0474d c0474d, boolean z3) {
        n nVar;
        l lVar;
        int y3 = c0474d.y(this.f12882O);
        int y4 = c0474d.y(this.f12883P);
        int y5 = c0474d.y(this.f12884Q);
        int y6 = c0474d.y(this.f12885R);
        if (z3 && (lVar = this.f12902e) != null) {
            r.f fVar = lVar.f13139h;
            if (fVar.f13088j) {
                r.f fVar2 = lVar.f13140i;
                if (fVar2.f13088j) {
                    y3 = fVar.f13085g;
                    y5 = fVar2.f13085g;
                }
            }
        }
        if (z3 && (nVar = this.f12904f) != null) {
            r.f fVar3 = nVar.f13139h;
            if (fVar3.f13088j) {
                r.f fVar4 = nVar.f13140i;
                if (fVar4.f13088j) {
                    y4 = fVar3.f13085g;
                    y6 = fVar4.f13085g;
                }
            }
        }
        int i3 = y6 - y4;
        if (y5 - y3 < 0 || i3 < 0 || y3 == Integer.MIN_VALUE || y3 == Integer.MAX_VALUE || y4 == Integer.MIN_VALUE || y4 == Integer.MAX_VALUE || y5 == Integer.MIN_VALUE || y5 == Integer.MAX_VALUE || y6 == Integer.MIN_VALUE || y6 == Integer.MAX_VALUE) {
            y3 = 0;
            y6 = 0;
            y4 = 0;
            y5 = 0;
        }
        G0(y3, y4, y5, y6);
    }

    public int n() {
        return this.f12917l0;
    }

    public boolean n0() {
        return this.f12930s;
    }

    public float o(int i3) {
        if (i3 == 0) {
            return this.f12923o0;
        }
        if (i3 == 1) {
            return this.f12925p0;
        }
        return -1.0f;
    }

    public void o0() {
        this.f12928r = true;
    }

    public int p() {
        return W() + this.f12899c0;
    }

    public void p0() {
        this.f12930s = true;
    }

    public Object q() {
        return this.f12927q0;
    }

    public boolean q0() {
        b[] bVarArr = this.f12893Z;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public String r() {
        return this.f12935u0;
    }

    public void r0() {
        this.f12882O.p();
        this.f12883P.p();
        this.f12884Q.p();
        this.f12885R.p();
        this.f12886S.p();
        this.f12887T.p();
        this.f12888U.p();
        this.f12889V.p();
        this.f12895a0 = null;
        this.f12874I = 0.0f;
        this.f12897b0 = 0;
        this.f12899c0 = 0;
        this.f12901d0 = 0.0f;
        this.f12903e0 = -1;
        this.f12905f0 = 0;
        this.f12907g0 = 0;
        this.f12913j0 = 0;
        this.f12915k0 = 0;
        this.f12917l0 = 0;
        this.f12919m0 = 0;
        this.f12921n0 = 0;
        float f3 = f12857K0;
        this.f12923o0 = f3;
        this.f12925p0 = f3;
        b[] bVarArr = this.f12893Z;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f12927q0 = null;
        this.f12929r0 = 0;
        this.f12931s0 = 0;
        this.f12937v0 = null;
        this.f12939w0 = false;
        this.f12941x0 = false;
        this.f12945z0 = 0;
        this.f12859A0 = 0;
        this.f12861B0 = false;
        this.f12863C0 = false;
        float[] fArr = this.f12865D0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f12932t = -1;
        this.f12934u = -1;
        int[] iArr = this.f12872H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f12938w = 0;
        this.f12940x = 0;
        this.f12860B = 1.0f;
        this.f12866E = 1.0f;
        this.f12858A = Preference.DEFAULT_ORDER;
        this.f12864D = Preference.DEFAULT_ORDER;
        this.f12944z = 0;
        this.f12862C = 0;
        this.f12908h = false;
        this.f12868F = -1;
        this.f12870G = 1.0f;
        this.f12943y0 = false;
        boolean[] zArr = this.f12906g;
        zArr[0] = true;
        zArr[1] = true;
        this.f12879L = false;
        boolean[] zArr2 = this.f12892Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f12910i = true;
        int[] iArr2 = this.f12942y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f12916l = -1;
        this.f12918m = -1;
    }

    public b s(int i3) {
        if (i3 == 0) {
            return y();
        }
        if (i3 == 1) {
            return R();
        }
        return null;
    }

    public void s0() {
        this.f12924p = false;
        this.f12926q = false;
        this.f12928r = false;
        this.f12930s = false;
        int size = this.f12891X.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((d) this.f12891X.get(i3)).q();
        }
    }

    public float t() {
        return this.f12901d0;
    }

    public void t0(C0473c c0473c) {
        this.f12882O.r(c0473c);
        this.f12883P.r(c0473c);
        this.f12884Q.r(c0473c);
        this.f12885R.r(c0473c);
        this.f12886S.r(c0473c);
        this.f12889V.r(c0473c);
        this.f12887T.r(c0473c);
        this.f12888U.r(c0473c);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f12937v0 != null) {
            str = "type: " + this.f12937v0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f12935u0 != null) {
            str2 = "id: " + this.f12935u0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f12905f0);
        sb.append(", ");
        sb.append(this.f12907g0);
        sb.append(") - (");
        sb.append(this.f12897b0);
        sb.append(" x ");
        sb.append(this.f12899c0);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.f12903e0;
    }

    public int v() {
        if (this.f12931s0 == 8) {
            return 0;
        }
        return this.f12899c0;
    }

    public float w() {
        return this.f12923o0;
    }

    public int x() {
        return this.f12945z0;
    }

    public void x0(int i3) {
        this.f12917l0 = i3;
        this.f12876J = i3 > 0;
    }

    public b y() {
        return this.f12893Z[0];
    }

    public void y0(Object obj) {
        this.f12927q0 = obj;
    }

    public int z() {
        d dVar = this.f12882O;
        int i3 = dVar != null ? dVar.f12843g : 0;
        d dVar2 = this.f12884Q;
        return dVar2 != null ? i3 + dVar2.f12843g : i3;
    }

    public void z0(String str) {
        this.f12935u0 = str;
    }
}
