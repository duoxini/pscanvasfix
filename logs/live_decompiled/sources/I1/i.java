package i1;

import a1.C0221a;
import a1.InterfaceC0223c;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.oplus.anim.n;
import d1.AbstractC0336a;
import d1.o;
import d1.q;
import f1.C0354b;
import f1.C0356d;
import f1.C0357e;
import g1.C0365a;
import g1.C0366b;
import g1.k;
import h1.C0387p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m.C0454d;
import m1.AbstractC0465h;
import n1.C0483b;

/* loaded from: classes.dex */
public class i extends AbstractC0395b {

    /* renamed from: D, reason: collision with root package name */
    private final StringBuilder f12099D;

    /* renamed from: E, reason: collision with root package name */
    private final RectF f12100E;

    /* renamed from: F, reason: collision with root package name */
    private final Matrix f12101F;

    /* renamed from: G, reason: collision with root package name */
    private final Paint f12102G;

    /* renamed from: H, reason: collision with root package name */
    private final Paint f12103H;

    /* renamed from: I, reason: collision with root package name */
    private final Map f12104I;

    /* renamed from: J, reason: collision with root package name */
    private final C0454d f12105J;

    /* renamed from: K, reason: collision with root package name */
    private final List f12106K;

    /* renamed from: L, reason: collision with root package name */
    private final o f12107L;

    /* renamed from: M, reason: collision with root package name */
    private final n f12108M;

    /* renamed from: N, reason: collision with root package name */
    private final C0221a f12109N;

    /* renamed from: O, reason: collision with root package name */
    private AbstractC0336a f12110O;

    /* renamed from: P, reason: collision with root package name */
    private AbstractC0336a f12111P;

    /* renamed from: Q, reason: collision with root package name */
    private AbstractC0336a f12112Q;

    /* renamed from: R, reason: collision with root package name */
    private AbstractC0336a f12113R;

    /* renamed from: S, reason: collision with root package name */
    private AbstractC0336a f12114S;

    /* renamed from: T, reason: collision with root package name */
    private AbstractC0336a f12115T;

    /* renamed from: U, reason: collision with root package name */
    private AbstractC0336a f12116U;

    /* renamed from: V, reason: collision with root package name */
    private AbstractC0336a f12117V;

    /* renamed from: W, reason: collision with root package name */
    private AbstractC0336a f12118W;

    /* renamed from: X, reason: collision with root package name */
    private AbstractC0336a f12119X;

    class a extends Paint {
        a(int i3) {
            super(i3);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i3) {
            super(i3);
            setStyle(Paint.Style.STROKE);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12122a;

        static {
            int[] iArr = new int[C0354b.a.values().length];
            f12122a = iArr;
            try {
                iArr[C0354b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12122a[C0354b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12122a[C0354b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    i(n nVar, e eVar) {
        super(nVar, eVar);
        C0366b c0366b;
        C0366b c0366b2;
        C0365a c0365a;
        C0365a c0365a2;
        this.f12099D = new StringBuilder(2);
        this.f12100E = new RectF();
        this.f12101F = new Matrix();
        this.f12102G = new a(1);
        this.f12103H = new b(1);
        this.f12104I = new HashMap();
        this.f12105J = new C0454d();
        this.f12106K = new ArrayList();
        this.f12108M = nVar;
        this.f12109N = eVar.b();
        o a3 = eVar.s().a();
        this.f12107L = a3;
        a3.a(this);
        k(a3);
        k t3 = eVar.t();
        if (t3 != null && (c0365a2 = t3.f11678a) != null) {
            AbstractC0336a a4 = c0365a2.a();
            this.f12110O = a4;
            a4.a(this);
            k(this.f12110O);
        }
        if (t3 != null && (c0365a = t3.f11679b) != null) {
            AbstractC0336a a5 = c0365a.a();
            this.f12112Q = a5;
            a5.a(this);
            k(this.f12112Q);
        }
        if (t3 != null && (c0366b2 = t3.f11680c) != null) {
            AbstractC0336a a6 = c0366b2.a();
            this.f12114S = a6;
            a6.a(this);
            k(this.f12114S);
        }
        if (t3 == null || (c0366b = t3.f11681d) == null) {
            return;
        }
        AbstractC0336a a7 = c0366b.a();
        this.f12116U = a7;
        a7.a(this);
        k(this.f12116U);
    }

    private String Q(String str, int i3) {
        int codePointAt = str.codePointAt(i3);
        int charCount = Character.charCount(codePointAt) + i3;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!e0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j3 = codePointAt;
        if (this.f12105J.c(j3)) {
            return (String) this.f12105J.e(j3);
        }
        this.f12099D.setLength(0);
        while (i3 < charCount) {
            int codePointAt3 = str.codePointAt(i3);
            this.f12099D.appendCodePoint(codePointAt3);
            i3 += Character.charCount(codePointAt3);
        }
        String sb = this.f12099D.toString();
        this.f12105J.i(j3, sb);
        return sb;
    }

    private void R(C0354b c0354b, Matrix matrix) {
        AbstractC0336a abstractC0336a = this.f12111P;
        if (abstractC0336a != null) {
            this.f12102G.setColor(((Integer) abstractC0336a.h()).intValue());
        } else {
            AbstractC0336a abstractC0336a2 = this.f12110O;
            if (abstractC0336a2 != null) {
                this.f12102G.setColor(((Integer) abstractC0336a2.h()).intValue());
            } else {
                this.f12102G.setColor(c0354b.f11560h);
            }
        }
        AbstractC0336a abstractC0336a3 = this.f12113R;
        if (abstractC0336a3 != null) {
            this.f12103H.setColor(((Integer) abstractC0336a3.h()).intValue());
        } else {
            AbstractC0336a abstractC0336a4 = this.f12112Q;
            if (abstractC0336a4 != null) {
                this.f12103H.setColor(((Integer) abstractC0336a4.h()).intValue());
            } else {
                this.f12103H.setColor(c0354b.f11561i);
            }
        }
        int intValue = ((this.f12034x.h() == null ? 100 : ((Integer) this.f12034x.h().h()).intValue()) * 255) / 100;
        this.f12102G.setAlpha(intValue);
        this.f12103H.setAlpha(intValue);
        AbstractC0336a abstractC0336a5 = this.f12115T;
        if (abstractC0336a5 != null) {
            this.f12103H.setStrokeWidth(((Float) abstractC0336a5.h()).floatValue());
            return;
        }
        AbstractC0336a abstractC0336a6 = this.f12114S;
        if (abstractC0336a6 != null) {
            this.f12103H.setStrokeWidth(((Float) abstractC0336a6.h()).floatValue());
        } else {
            this.f12103H.setStrokeWidth(c0354b.f11562j * AbstractC0465h.e());
        }
    }

    private void S(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void T(C0357e c0357e, float f3, C0354b c0354b, Canvas canvas) {
        List b02 = b0(c0357e);
        for (int i3 = 0; i3 < b02.size(); i3++) {
            Path d3 = ((c1.d) b02.get(i3)).d();
            d3.computeBounds(this.f12100E, false);
            this.f12101F.reset();
            this.f12101F.preTranslate(0.0f, (-c0354b.f11559g) * AbstractC0465h.e());
            this.f12101F.preScale(f3, f3);
            d3.transform(this.f12101F);
            if (c0354b.f11563k) {
                W(d3, this.f12102G, canvas);
                W(d3, this.f12103H, canvas);
            } else {
                W(d3, this.f12103H, canvas);
                W(d3, this.f12102G, canvas);
            }
        }
    }

    private void U(String str, C0354b c0354b, Canvas canvas) {
        if (c0354b.f11563k) {
            S(str, this.f12102G, canvas);
            S(str, this.f12103H, canvas);
        } else {
            S(str, this.f12103H, canvas);
            S(str, this.f12102G, canvas);
        }
    }

    private void V(String str, C0354b c0354b, Canvas canvas, float f3) {
        int i3 = 0;
        while (i3 < str.length()) {
            String Q3 = Q(str, i3);
            i3 += Q3.length();
            U(Q3, c0354b, canvas);
            canvas.translate(this.f12102G.measureText(Q3) + f3, 0.0f);
        }
    }

    private void W(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void X(String str, C0354b c0354b, C0356d c0356d, Canvas canvas, float f3, float f4, float f5) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            C0357e c0357e = (C0357e) this.f12109N.c().e(C0357e.c(str.charAt(i3), c0356d.a(), c0356d.c()));
            if (c0357e != null) {
                T(c0357e, f4, c0354b, canvas);
                canvas.translate((((float) c0357e.b()) * f4 * AbstractC0465h.e()) + f5, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Y(f1.C0354b r19, f1.C0356d r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.d0(r9)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r1 = r8.f11553a
            com.oplus.anim.n r2 = r7.f12108M
            r2.W()
            android.graphics.Paint r2 = r7.f12102G
            r2.setTypeface(r0)
            d1.a r0 = r7.f12118W
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L2c
        L2a:
            float r0 = r8.f11555c
        L2c:
            android.graphics.Paint r2 = r7.f12102G
            float r3 = m1.AbstractC0465h.e()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.f12103H
            android.graphics.Paint r3 = r7.f12102G
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.f12103H
            android.graphics.Paint r3 = r7.f12102G
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.f11557e
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            d1.a r3 = r7.f12117V
            if (r3 == 0) goto L62
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L60:
            float r2 = r2 + r3
            goto L71
        L62:
            d1.a r3 = r7.f12116U
            if (r3 == 0) goto L71
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L60
        L71:
            float r3 = m1.AbstractC0465h.e()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.c0(r1)
            int r13 = r12.size()
            r14 = 0
            r0 = -1
            r15 = r0
            r6 = r14
        L87:
            if (r6 >= r13) goto Ld3
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.f11565m
            if (r0 != 0) goto L97
            r0 = 0
        L95:
            r2 = r0
            goto L9a
        L97:
            float r0 = r0.x
            goto L95
        L9a:
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.g0(r1, r2, r3, r4, r5, r6)
            r1 = r14
        Lab:
            int r2 = r0.size()
            if (r1 >= r2) goto Ld0
            java.lang.Object r2 = r0.get(r1)
            i1.i$d r2 = (i1.i.d) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = i1.i.d.a(r2)
            r7.f0(r10, r8, r15, r3)
            java.lang.String r2 = i1.i.d.b(r2)
            r7.V(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto Lab
        Ld0:
            int r6 = r17 + 1
            goto L87
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.i.Y(f1.b, f1.d, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Z(f1.C0354b r21, android.graphics.Matrix r22, f1.C0356d r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            d1.a r0 = r8.f12118W
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.f11555c
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = m1.AbstractC0465h.h(r22)
            java.lang.String r0 = r9.f11553a
            java.util.List r12 = r8.c0(r0)
            int r13 = r12.size()
            int r0 = r9.f11557e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            d1.a r1 = r8.f12117V
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
        L3c:
            r14 = r0
            goto L4d
        L3e:
            d1.a r1 = r8.f12116U
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4d:
            r15 = 0
            r0 = -1
            r7 = r0
            r6 = r15
        L51:
            if (r6 >= r13) goto Lb2
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.f11565m
            if (r0 != 0) goto L61
            r0 = 0
        L5f:
            r2 = r0
            goto L64
        L61:
            float r0 = r0.x
            goto L5f
        L64:
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.g0(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L75:
            int r0 = r6.size()
            if (r5 >= r0) goto Laf
            java.lang.Object r0 = r6.get(r5)
            i1.i$d r0 = (i1.i.d) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = i1.i.d.a(r0)
            r4 = r24
            r8.f0(r4, r9, r7, r1)
            java.lang.String r1 = i1.i.d.b(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.X(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L75
        Laf:
            int r6 = r17 + 1
            goto L51
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.i.Z(f1.b, android.graphics.Matrix, f1.d, android.graphics.Canvas):void");
    }

    private d a0(int i3) {
        for (int size = this.f12106K.size(); size < i3; size++) {
            this.f12106K.add(new d(null));
        }
        return (d) this.f12106K.get(i3 - 1);
    }

    private List b0(C0357e c0357e) {
        if (this.f12104I.containsKey(c0357e)) {
            return (List) this.f12104I.get(c0357e);
        }
        List a3 = c0357e.a();
        int size = a3.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new c1.d(this.f12108M, this, (C0387p) a3.get(i3), this.f12109N));
        }
        this.f12104I.put(c0357e, arrayList);
        return arrayList;
    }

    private List c0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface d0(C0356d c0356d) {
        Typeface typeface;
        AbstractC0336a abstractC0336a = this.f12119X;
        if (abstractC0336a != null && (typeface = (Typeface) abstractC0336a.h()) != null) {
            return typeface;
        }
        Typeface X3 = this.f12108M.X(c0356d);
        return X3 != null ? X3 : c0356d.d();
    }

    private boolean e0(int i3) {
        return Character.getType(i3) == 16 || Character.getType(i3) == 27 || Character.getType(i3) == 6 || Character.getType(i3) == 28 || Character.getType(i3) == 8 || Character.getType(i3) == 19;
    }

    private void f0(Canvas canvas, C0354b c0354b, int i3, float f3) {
        PointF pointF = c0354b.f11564l;
        PointF pointF2 = c0354b.f11565m;
        float e3 = AbstractC0465h.e();
        float f4 = (i3 * c0354b.f11558f * e3) + (pointF == null ? 0.0f : (c0354b.f11558f * e3) + pointF.y);
        float f5 = pointF == null ? 0.0f : pointF.x;
        float f6 = pointF2 != null ? pointF2.x : 0.0f;
        int i4 = c.f12122a[c0354b.f11556d.ordinal()];
        if (i4 == 1) {
            canvas.translate(f5, f4);
        } else if (i4 == 2) {
            canvas.translate((f5 + f6) - f3, f4);
        } else {
            if (i4 != 3) {
                return;
            }
            canvas.translate((f5 + (f6 / 2.0f)) - (f3 / 2.0f), f4);
        }
    }

    private List g0(String str, float f3, C0356d c0356d, float f4, float f5, boolean z3) {
        float measureText;
        int i3 = 0;
        int i4 = 0;
        boolean z4 = false;
        int i5 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (z3) {
                C0357e c0357e = (C0357e) this.f12109N.c().e(C0357e.c(charAt, c0356d.a(), c0356d.c()));
                if (c0357e != null) {
                    measureText = ((float) c0357e.b()) * f4 * AbstractC0465h.e();
                }
            } else {
                measureText = this.f12102G.measureText(str.substring(i6, i6 + 1));
            }
            float f9 = measureText + f5;
            if (charAt == ' ') {
                z4 = true;
                f8 = f9;
            } else if (z4) {
                z4 = false;
                i5 = i6;
                f7 = f9;
            } else {
                f7 += f9;
            }
            f6 += f9;
            if (f3 > 0.0f && f6 >= f3 && charAt != ' ') {
                i3++;
                d a02 = a0(i3);
                if (i5 == i4) {
                    a02.c(str.substring(i4, i6).trim(), (f6 - f9) - ((r9.length() - r7.length()) * f8));
                    i4 = i6;
                    i5 = i4;
                    f6 = f9;
                    f7 = f6;
                } else {
                    a02.c(str.substring(i4, i5 - 1).trim(), ((f6 - f7) - ((r7.length() - r13.length()) * f8)) - f8);
                    f6 = f7;
                    i4 = i5;
                }
            }
        }
        if (f6 > 0.0f) {
            i3++;
            a0(i3).c(str.substring(i4), f6);
        }
        return this.f12106K.subList(0, i3);
    }

    @Override // i1.AbstractC0395b, c1.e
    public void a(RectF rectF, Matrix matrix, boolean z3) {
        super.a(rectF, matrix, z3);
        rectF.set(0.0f, 0.0f, this.f12109N.b().width(), this.f12109N.b().height());
    }

    @Override // i1.AbstractC0395b, f1.g
    public void h(Object obj, C0483b c0483b) {
        super.h(obj, c0483b);
        if (obj == InterfaceC0223c.f3193a) {
            AbstractC0336a abstractC0336a = this.f12111P;
            if (abstractC0336a != null) {
                I(abstractC0336a);
            }
            if (c0483b == null) {
                this.f12111P = null;
                return;
            }
            q qVar = new q(c0483b);
            this.f12111P = qVar;
            qVar.a(this);
            k(this.f12111P);
            return;
        }
        if (obj == InterfaceC0223c.f3194b) {
            AbstractC0336a abstractC0336a2 = this.f12113R;
            if (abstractC0336a2 != null) {
                I(abstractC0336a2);
            }
            if (c0483b == null) {
                this.f12113R = null;
                return;
            }
            q qVar2 = new q(c0483b);
            this.f12113R = qVar2;
            qVar2.a(this);
            k(this.f12113R);
            return;
        }
        if (obj == InterfaceC0223c.f3211s) {
            AbstractC0336a abstractC0336a3 = this.f12115T;
            if (abstractC0336a3 != null) {
                I(abstractC0336a3);
            }
            if (c0483b == null) {
                this.f12115T = null;
                return;
            }
            q qVar3 = new q(c0483b);
            this.f12115T = qVar3;
            qVar3.a(this);
            k(this.f12115T);
            return;
        }
        if (obj == InterfaceC0223c.f3212t) {
            AbstractC0336a abstractC0336a4 = this.f12117V;
            if (abstractC0336a4 != null) {
                I(abstractC0336a4);
            }
            if (c0483b == null) {
                this.f12117V = null;
                return;
            }
            q qVar4 = new q(c0483b);
            this.f12117V = qVar4;
            qVar4.a(this);
            k(this.f12117V);
            return;
        }
        if (obj == InterfaceC0223c.f3183F) {
            AbstractC0336a abstractC0336a5 = this.f12118W;
            if (abstractC0336a5 != null) {
                I(abstractC0336a5);
            }
            if (c0483b == null) {
                this.f12118W = null;
                return;
            }
            q qVar5 = new q(c0483b);
            this.f12118W = qVar5;
            qVar5.a(this);
            k(this.f12118W);
            return;
        }
        if (obj != InterfaceC0223c.f3190M) {
            if (obj == InterfaceC0223c.f3192O) {
                this.f12107L.q(c0483b);
                return;
            }
            return;
        }
        AbstractC0336a abstractC0336a6 = this.f12119X;
        if (abstractC0336a6 != null) {
            I(abstractC0336a6);
        }
        if (c0483b == null) {
            this.f12119X = null;
            return;
        }
        q qVar6 = new q(c0483b);
        this.f12119X = qVar6;
        qVar6.a(this);
        k(this.f12119X);
    }

    @Override // i1.AbstractC0395b
    void v(Canvas canvas, Matrix matrix, int i3) {
        C0354b c0354b = (C0354b) this.f12107L.h();
        C0356d c0356d = (C0356d) this.f12109N.g().get(c0354b.f11554b);
        if (c0356d == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        R(c0354b, matrix);
        if (this.f12108M.a1()) {
            Z(c0354b, matrix, c0356d, canvas);
        } else {
            Y(c0354b, c0356d, canvas);
        }
        canvas.restore();
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f12123a;

        /* renamed from: b, reason: collision with root package name */
        private float f12124b;

        private d() {
            this.f12123a = "";
            this.f12124b = 0.0f;
        }

        void c(String str, float f3) {
            this.f12123a = str;
            this.f12124b = f3;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
