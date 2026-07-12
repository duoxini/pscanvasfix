package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import o.C0490a;
import org.xmlpull.v1.XmlPullParserException;
import s.AbstractC0571a;
import s.AbstractC0572b;

/* loaded from: classes.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f4409f = {0, 4, 8};

    /* renamed from: g, reason: collision with root package name */
    private static SparseIntArray f4410g = new SparseIntArray();

    /* renamed from: h, reason: collision with root package name */
    private static SparseIntArray f4411h = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    public String f4412a = "";

    /* renamed from: b, reason: collision with root package name */
    public int f4413b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap f4414c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private boolean f4415d = true;

    /* renamed from: e, reason: collision with root package name */
    private HashMap f4416e = new HashMap();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f4417a;

        /* renamed from: b, reason: collision with root package name */
        String f4418b;

        /* renamed from: c, reason: collision with root package name */
        public final C0060d f4419c = new C0060d();

        /* renamed from: d, reason: collision with root package name */
        public final c f4420d = new c();

        /* renamed from: e, reason: collision with root package name */
        public final b f4421e = new b();

        /* renamed from: f, reason: collision with root package name */
        public final e f4422f = new e();

        /* renamed from: g, reason: collision with root package name */
        public HashMap f4423g = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        C0059a f4424h;

        /* renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        static class C0059a {

            /* renamed from: a, reason: collision with root package name */
            int[] f4425a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            int[] f4426b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            int f4427c = 0;

            /* renamed from: d, reason: collision with root package name */
            int[] f4428d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            float[] f4429e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            int f4430f = 0;

            /* renamed from: g, reason: collision with root package name */
            int[] f4431g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            String[] f4432h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            int f4433i = 0;

            /* renamed from: j, reason: collision with root package name */
            int[] f4434j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            boolean[] f4435k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            int f4436l = 0;

            C0059a() {
            }

            void a(int i3, float f3) {
                int i4 = this.f4430f;
                int[] iArr = this.f4428d;
                if (i4 >= iArr.length) {
                    this.f4428d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f4429e;
                    this.f4429e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f4428d;
                int i5 = this.f4430f;
                iArr2[i5] = i3;
                float[] fArr2 = this.f4429e;
                this.f4430f = i5 + 1;
                fArr2[i5] = f3;
            }

            void b(int i3, int i4) {
                int i5 = this.f4427c;
                int[] iArr = this.f4425a;
                if (i5 >= iArr.length) {
                    this.f4425a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f4426b;
                    this.f4426b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f4425a;
                int i6 = this.f4427c;
                iArr3[i6] = i3;
                int[] iArr4 = this.f4426b;
                this.f4427c = i6 + 1;
                iArr4[i6] = i4;
            }

            void c(int i3, String str) {
                int i4 = this.f4433i;
                int[] iArr = this.f4431g;
                if (i4 >= iArr.length) {
                    this.f4431g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f4432h;
                    this.f4432h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f4431g;
                int i5 = this.f4433i;
                iArr2[i5] = i3;
                String[] strArr2 = this.f4432h;
                this.f4433i = i5 + 1;
                strArr2[i5] = str;
            }

            void d(int i3, boolean z3) {
                int i4 = this.f4436l;
                int[] iArr = this.f4434j;
                if (i4 >= iArr.length) {
                    this.f4434j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f4435k;
                    this.f4435k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f4434j;
                int i5 = this.f4436l;
                iArr2[i5] = i3;
                boolean[] zArr2 = this.f4435k;
                this.f4436l = i5 + 1;
                zArr2[i5] = z3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i3, ConstraintLayout.b bVar) {
            this.f4417a = i3;
            b bVar2 = this.f4421e;
            bVar2.f4482j = bVar.leftToLeft;
            bVar2.f4484k = bVar.leftToRight;
            bVar2.f4486l = bVar.rightToLeft;
            bVar2.f4488m = bVar.rightToRight;
            bVar2.f4490n = bVar.topToTop;
            bVar2.f4492o = bVar.topToBottom;
            bVar2.f4494p = bVar.bottomToTop;
            bVar2.f4496q = bVar.bottomToBottom;
            bVar2.f4498r = bVar.baselineToBaseline;
            bVar2.f4499s = bVar.baselineToTop;
            bVar2.f4500t = bVar.baselineToBottom;
            bVar2.f4501u = bVar.startToEnd;
            bVar2.f4502v = bVar.startToStart;
            bVar2.f4503w = bVar.endToStart;
            bVar2.f4504x = bVar.endToEnd;
            bVar2.f4505y = bVar.horizontalBias;
            bVar2.f4506z = bVar.verticalBias;
            bVar2.f4438A = bVar.dimensionRatio;
            bVar2.f4439B = bVar.circleConstraint;
            bVar2.f4440C = bVar.circleRadius;
            bVar2.f4441D = bVar.circleAngle;
            bVar2.f4442E = bVar.editorAbsoluteX;
            bVar2.f4443F = bVar.editorAbsoluteY;
            bVar2.f4444G = bVar.orientation;
            bVar2.f4478h = bVar.guidePercent;
            bVar2.f4474f = bVar.guideBegin;
            bVar2.f4476g = bVar.guideEnd;
            bVar2.f4470d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f4472e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f4445H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f4446I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f4447J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f4448K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f4451N = bVar.baselineMargin;
            bVar2.f4459V = bVar.verticalWeight;
            bVar2.f4460W = bVar.horizontalWeight;
            bVar2.f4462Y = bVar.verticalChainStyle;
            bVar2.f4461X = bVar.horizontalChainStyle;
            bVar2.f4491n0 = bVar.constrainedWidth;
            bVar2.f4493o0 = bVar.constrainedHeight;
            bVar2.f4463Z = bVar.matchConstraintDefaultWidth;
            bVar2.f4465a0 = bVar.matchConstraintDefaultHeight;
            bVar2.f4467b0 = bVar.matchConstraintMaxWidth;
            bVar2.f4469c0 = bVar.matchConstraintMaxHeight;
            bVar2.f4471d0 = bVar.matchConstraintMinWidth;
            bVar2.f4473e0 = bVar.matchConstraintMinHeight;
            bVar2.f4475f0 = bVar.matchConstraintPercentWidth;
            bVar2.f4477g0 = bVar.matchConstraintPercentHeight;
            bVar2.f4489m0 = bVar.constraintTag;
            bVar2.f4453P = bVar.goneTopMargin;
            bVar2.f4455R = bVar.goneBottomMargin;
            bVar2.f4452O = bVar.goneLeftMargin;
            bVar2.f4454Q = bVar.goneRightMargin;
            bVar2.f4457T = bVar.goneStartMargin;
            bVar2.f4456S = bVar.goneEndMargin;
            bVar2.f4458U = bVar.goneBaselineMargin;
            bVar2.f4497q0 = bVar.wrapBehaviorInParent;
            bVar2.f4449L = bVar.getMarginEnd();
            this.f4421e.f4450M = bVar.getMarginStart();
        }

        public void b(ConstraintLayout.b bVar) {
            b bVar2 = this.f4421e;
            bVar.leftToLeft = bVar2.f4482j;
            bVar.leftToRight = bVar2.f4484k;
            bVar.rightToLeft = bVar2.f4486l;
            bVar.rightToRight = bVar2.f4488m;
            bVar.topToTop = bVar2.f4490n;
            bVar.topToBottom = bVar2.f4492o;
            bVar.bottomToTop = bVar2.f4494p;
            bVar.bottomToBottom = bVar2.f4496q;
            bVar.baselineToBaseline = bVar2.f4498r;
            bVar.baselineToTop = bVar2.f4499s;
            bVar.baselineToBottom = bVar2.f4500t;
            bVar.startToEnd = bVar2.f4501u;
            bVar.startToStart = bVar2.f4502v;
            bVar.endToStart = bVar2.f4503w;
            bVar.endToEnd = bVar2.f4504x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f4445H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f4446I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f4447J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f4448K;
            bVar.goneStartMargin = bVar2.f4457T;
            bVar.goneEndMargin = bVar2.f4456S;
            bVar.goneTopMargin = bVar2.f4453P;
            bVar.goneBottomMargin = bVar2.f4455R;
            bVar.horizontalBias = bVar2.f4505y;
            bVar.verticalBias = bVar2.f4506z;
            bVar.circleConstraint = bVar2.f4439B;
            bVar.circleRadius = bVar2.f4440C;
            bVar.circleAngle = bVar2.f4441D;
            bVar.dimensionRatio = bVar2.f4438A;
            bVar.editorAbsoluteX = bVar2.f4442E;
            bVar.editorAbsoluteY = bVar2.f4443F;
            bVar.verticalWeight = bVar2.f4459V;
            bVar.horizontalWeight = bVar2.f4460W;
            bVar.verticalChainStyle = bVar2.f4462Y;
            bVar.horizontalChainStyle = bVar2.f4461X;
            bVar.constrainedWidth = bVar2.f4491n0;
            bVar.constrainedHeight = bVar2.f4493o0;
            bVar.matchConstraintDefaultWidth = bVar2.f4463Z;
            bVar.matchConstraintDefaultHeight = bVar2.f4465a0;
            bVar.matchConstraintMaxWidth = bVar2.f4467b0;
            bVar.matchConstraintMaxHeight = bVar2.f4469c0;
            bVar.matchConstraintMinWidth = bVar2.f4471d0;
            bVar.matchConstraintMinHeight = bVar2.f4473e0;
            bVar.matchConstraintPercentWidth = bVar2.f4475f0;
            bVar.matchConstraintPercentHeight = bVar2.f4477g0;
            bVar.orientation = bVar2.f4444G;
            bVar.guidePercent = bVar2.f4478h;
            bVar.guideBegin = bVar2.f4474f;
            bVar.guideEnd = bVar2.f4476g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f4470d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f4472e;
            String str = bVar2.f4489m0;
            if (str != null) {
                bVar.constraintTag = str;
            }
            bVar.wrapBehaviorInParent = bVar2.f4497q0;
            bVar.setMarginStart(bVar2.f4450M);
            bVar.setMarginEnd(this.f4421e.f4449L);
            bVar.validate();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f4421e.a(this.f4421e);
            aVar.f4420d.a(this.f4420d);
            aVar.f4419c.a(this.f4419c);
            aVar.f4422f.a(this.f4422f);
            aVar.f4417a = this.f4417a;
            aVar.f4424h = this.f4424h;
            return aVar;
        }
    }

    public static class b {

        /* renamed from: r0, reason: collision with root package name */
        private static SparseIntArray f4437r0;

        /* renamed from: d, reason: collision with root package name */
        public int f4470d;

        /* renamed from: e, reason: collision with root package name */
        public int f4472e;

        /* renamed from: k0, reason: collision with root package name */
        public int[] f4485k0;

        /* renamed from: l0, reason: collision with root package name */
        public String f4487l0;

        /* renamed from: m0, reason: collision with root package name */
        public String f4489m0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f4464a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4466b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4468c = false;

        /* renamed from: f, reason: collision with root package name */
        public int f4474f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f4476g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f4478h = -1.0f;

        /* renamed from: i, reason: collision with root package name */
        public boolean f4480i = true;

        /* renamed from: j, reason: collision with root package name */
        public int f4482j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f4484k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f4486l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f4488m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f4490n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f4492o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f4494p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f4496q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f4498r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f4499s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f4500t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f4501u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f4502v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f4503w = -1;

        /* renamed from: x, reason: collision with root package name */
        public int f4504x = -1;

        /* renamed from: y, reason: collision with root package name */
        public float f4505y = 0.5f;

        /* renamed from: z, reason: collision with root package name */
        public float f4506z = 0.5f;

        /* renamed from: A, reason: collision with root package name */
        public String f4438A = null;

        /* renamed from: B, reason: collision with root package name */
        public int f4439B = -1;

        /* renamed from: C, reason: collision with root package name */
        public int f4440C = 0;

        /* renamed from: D, reason: collision with root package name */
        public float f4441D = 0.0f;

        /* renamed from: E, reason: collision with root package name */
        public int f4442E = -1;

        /* renamed from: F, reason: collision with root package name */
        public int f4443F = -1;

        /* renamed from: G, reason: collision with root package name */
        public int f4444G = -1;

        /* renamed from: H, reason: collision with root package name */
        public int f4445H = 0;

        /* renamed from: I, reason: collision with root package name */
        public int f4446I = 0;

        /* renamed from: J, reason: collision with root package name */
        public int f4447J = 0;

        /* renamed from: K, reason: collision with root package name */
        public int f4448K = 0;

        /* renamed from: L, reason: collision with root package name */
        public int f4449L = 0;

        /* renamed from: M, reason: collision with root package name */
        public int f4450M = 0;

        /* renamed from: N, reason: collision with root package name */
        public int f4451N = 0;

        /* renamed from: O, reason: collision with root package name */
        public int f4452O = Integer.MIN_VALUE;

        /* renamed from: P, reason: collision with root package name */
        public int f4453P = Integer.MIN_VALUE;

        /* renamed from: Q, reason: collision with root package name */
        public int f4454Q = Integer.MIN_VALUE;

        /* renamed from: R, reason: collision with root package name */
        public int f4455R = Integer.MIN_VALUE;

        /* renamed from: S, reason: collision with root package name */
        public int f4456S = Integer.MIN_VALUE;

        /* renamed from: T, reason: collision with root package name */
        public int f4457T = Integer.MIN_VALUE;

        /* renamed from: U, reason: collision with root package name */
        public int f4458U = Integer.MIN_VALUE;

        /* renamed from: V, reason: collision with root package name */
        public float f4459V = -1.0f;

        /* renamed from: W, reason: collision with root package name */
        public float f4460W = -1.0f;

        /* renamed from: X, reason: collision with root package name */
        public int f4461X = 0;

        /* renamed from: Y, reason: collision with root package name */
        public int f4462Y = 0;

        /* renamed from: Z, reason: collision with root package name */
        public int f4463Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f4465a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f4467b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f4469c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f4471d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        public int f4473e0 = 0;

        /* renamed from: f0, reason: collision with root package name */
        public float f4475f0 = 1.0f;

        /* renamed from: g0, reason: collision with root package name */
        public float f4477g0 = 1.0f;

        /* renamed from: h0, reason: collision with root package name */
        public int f4479h0 = -1;

        /* renamed from: i0, reason: collision with root package name */
        public int f4481i0 = 0;

        /* renamed from: j0, reason: collision with root package name */
        public int f4483j0 = -1;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f4491n0 = false;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f4493o0 = false;

        /* renamed from: p0, reason: collision with root package name */
        public boolean f4495p0 = true;

        /* renamed from: q0, reason: collision with root package name */
        public int f4497q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4437r0 = sparseIntArray;
            sparseIntArray.append(g.w5, 24);
            f4437r0.append(g.x5, 25);
            f4437r0.append(g.z5, 28);
            f4437r0.append(g.A5, 29);
            f4437r0.append(g.F5, 35);
            f4437r0.append(g.E5, 34);
            f4437r0.append(g.g5, 4);
            f4437r0.append(g.f5, 3);
            f4437r0.append(g.d5, 1);
            f4437r0.append(g.L5, 6);
            f4437r0.append(g.M5, 7);
            f4437r0.append(g.n5, 17);
            f4437r0.append(g.o5, 18);
            f4437r0.append(g.p5, 19);
            f4437r0.append(g.Z4, 90);
            f4437r0.append(g.L4, 26);
            f4437r0.append(g.B5, 31);
            f4437r0.append(g.C5, 32);
            f4437r0.append(g.m5, 10);
            f4437r0.append(g.l5, 9);
            f4437r0.append(g.P5, 13);
            f4437r0.append(g.S5, 16);
            f4437r0.append(g.Q5, 14);
            f4437r0.append(g.N5, 11);
            f4437r0.append(g.R5, 15);
            f4437r0.append(g.O5, 12);
            f4437r0.append(g.I5, 38);
            f4437r0.append(g.u5, 37);
            f4437r0.append(g.t5, 39);
            f4437r0.append(g.H5, 40);
            f4437r0.append(g.s5, 20);
            f4437r0.append(g.G5, 36);
            f4437r0.append(g.k5, 5);
            f4437r0.append(g.v5, 91);
            f4437r0.append(g.D5, 91);
            f4437r0.append(g.y5, 91);
            f4437r0.append(g.e5, 91);
            f4437r0.append(g.c5, 91);
            f4437r0.append(g.O4, 23);
            f4437r0.append(g.Q4, 27);
            f4437r0.append(g.S4, 30);
            f4437r0.append(g.T4, 8);
            f4437r0.append(g.P4, 33);
            f4437r0.append(g.R4, 2);
            f4437r0.append(g.M4, 22);
            f4437r0.append(g.N4, 21);
            f4437r0.append(g.J5, 41);
            f4437r0.append(g.q5, 42);
            f4437r0.append(g.b5, 41);
            f4437r0.append(g.a5, 42);
            f4437r0.append(g.T5, 76);
            f4437r0.append(g.h5, 61);
            f4437r0.append(g.j5, 62);
            f4437r0.append(g.i5, 63);
            f4437r0.append(g.K5, 69);
            f4437r0.append(g.r5, 70);
            f4437r0.append(g.X4, 71);
            f4437r0.append(g.V4, 72);
            f4437r0.append(g.W4, 73);
            f4437r0.append(g.Y4, 74);
            f4437r0.append(g.U4, 75);
        }

        public void a(b bVar) {
            this.f4464a = bVar.f4464a;
            this.f4470d = bVar.f4470d;
            this.f4466b = bVar.f4466b;
            this.f4472e = bVar.f4472e;
            this.f4474f = bVar.f4474f;
            this.f4476g = bVar.f4476g;
            this.f4478h = bVar.f4478h;
            this.f4480i = bVar.f4480i;
            this.f4482j = bVar.f4482j;
            this.f4484k = bVar.f4484k;
            this.f4486l = bVar.f4486l;
            this.f4488m = bVar.f4488m;
            this.f4490n = bVar.f4490n;
            this.f4492o = bVar.f4492o;
            this.f4494p = bVar.f4494p;
            this.f4496q = bVar.f4496q;
            this.f4498r = bVar.f4498r;
            this.f4499s = bVar.f4499s;
            this.f4500t = bVar.f4500t;
            this.f4501u = bVar.f4501u;
            this.f4502v = bVar.f4502v;
            this.f4503w = bVar.f4503w;
            this.f4504x = bVar.f4504x;
            this.f4505y = bVar.f4505y;
            this.f4506z = bVar.f4506z;
            this.f4438A = bVar.f4438A;
            this.f4439B = bVar.f4439B;
            this.f4440C = bVar.f4440C;
            this.f4441D = bVar.f4441D;
            this.f4442E = bVar.f4442E;
            this.f4443F = bVar.f4443F;
            this.f4444G = bVar.f4444G;
            this.f4445H = bVar.f4445H;
            this.f4446I = bVar.f4446I;
            this.f4447J = bVar.f4447J;
            this.f4448K = bVar.f4448K;
            this.f4449L = bVar.f4449L;
            this.f4450M = bVar.f4450M;
            this.f4451N = bVar.f4451N;
            this.f4452O = bVar.f4452O;
            this.f4453P = bVar.f4453P;
            this.f4454Q = bVar.f4454Q;
            this.f4455R = bVar.f4455R;
            this.f4456S = bVar.f4456S;
            this.f4457T = bVar.f4457T;
            this.f4458U = bVar.f4458U;
            this.f4459V = bVar.f4459V;
            this.f4460W = bVar.f4460W;
            this.f4461X = bVar.f4461X;
            this.f4462Y = bVar.f4462Y;
            this.f4463Z = bVar.f4463Z;
            this.f4465a0 = bVar.f4465a0;
            this.f4467b0 = bVar.f4467b0;
            this.f4469c0 = bVar.f4469c0;
            this.f4471d0 = bVar.f4471d0;
            this.f4473e0 = bVar.f4473e0;
            this.f4475f0 = bVar.f4475f0;
            this.f4477g0 = bVar.f4477g0;
            this.f4479h0 = bVar.f4479h0;
            this.f4481i0 = bVar.f4481i0;
            this.f4483j0 = bVar.f4483j0;
            this.f4489m0 = bVar.f4489m0;
            int[] iArr = bVar.f4485k0;
            if (iArr == null || bVar.f4487l0 != null) {
                this.f4485k0 = null;
            } else {
                this.f4485k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f4487l0 = bVar.f4487l0;
            this.f4491n0 = bVar.f4491n0;
            this.f4493o0 = bVar.f4493o0;
            this.f4495p0 = bVar.f4495p0;
            this.f4497q0 = bVar.f4497q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.K4);
            this.f4466b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = f4437r0.get(index);
                switch (i4) {
                    case 1:
                        this.f4498r = d.n(obtainStyledAttributes, index, this.f4498r);
                        break;
                    case 2:
                        this.f4448K = obtainStyledAttributes.getDimensionPixelSize(index, this.f4448K);
                        break;
                    case 3:
                        this.f4496q = d.n(obtainStyledAttributes, index, this.f4496q);
                        break;
                    case 4:
                        this.f4494p = d.n(obtainStyledAttributes, index, this.f4494p);
                        break;
                    case 5:
                        this.f4438A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f4442E = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4442E);
                        break;
                    case 7:
                        this.f4443F = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4443F);
                        break;
                    case 8:
                        this.f4449L = obtainStyledAttributes.getDimensionPixelSize(index, this.f4449L);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                        this.f4504x = d.n(obtainStyledAttributes, index, this.f4504x);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                        this.f4503w = d.n(obtainStyledAttributes, index, this.f4503w);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                        this.f4455R = obtainStyledAttributes.getDimensionPixelSize(index, this.f4455R);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                        this.f4456S = obtainStyledAttributes.getDimensionPixelSize(index, this.f4456S);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                        this.f4452O = obtainStyledAttributes.getDimensionPixelSize(index, this.f4452O);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                        this.f4454Q = obtainStyledAttributes.getDimensionPixelSize(index, this.f4454Q);
                        break;
                    case COUIViewDragHelper.EDGE_ALL /* 15 */:
                        this.f4457T = obtainStyledAttributes.getDimensionPixelSize(index, this.f4457T);
                        break;
                    case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                        this.f4453P = obtainStyledAttributes.getDimensionPixelSize(index, this.f4453P);
                        break;
                    case 17:
                        this.f4474f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4474f);
                        break;
                    case 18:
                        this.f4476g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4476g);
                        break;
                    case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                        this.f4478h = obtainStyledAttributes.getFloat(index, this.f4478h);
                        break;
                    case 20:
                        this.f4505y = obtainStyledAttributes.getFloat(index, this.f4505y);
                        break;
                    case 21:
                        this.f4472e = obtainStyledAttributes.getLayoutDimension(index, this.f4472e);
                        break;
                    case 22:
                        this.f4470d = obtainStyledAttributes.getLayoutDimension(index, this.f4470d);
                        break;
                    case 23:
                        this.f4445H = obtainStyledAttributes.getDimensionPixelSize(index, this.f4445H);
                        break;
                    case 24:
                        this.f4482j = d.n(obtainStyledAttributes, index, this.f4482j);
                        break;
                    case 25:
                        this.f4484k = d.n(obtainStyledAttributes, index, this.f4484k);
                        break;
                    case 26:
                        this.f4444G = obtainStyledAttributes.getInt(index, this.f4444G);
                        break;
                    case 27:
                        this.f4446I = obtainStyledAttributes.getDimensionPixelSize(index, this.f4446I);
                        break;
                    case 28:
                        this.f4486l = d.n(obtainStyledAttributes, index, this.f4486l);
                        break;
                    case 29:
                        this.f4488m = d.n(obtainStyledAttributes, index, this.f4488m);
                        break;
                    case 30:
                        this.f4450M = obtainStyledAttributes.getDimensionPixelSize(index, this.f4450M);
                        break;
                    case 31:
                        this.f4501u = d.n(obtainStyledAttributes, index, this.f4501u);
                        break;
                    case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS /* 32 */:
                        this.f4502v = d.n(obtainStyledAttributes, index, this.f4502v);
                        break;
                    case 33:
                        this.f4447J = obtainStyledAttributes.getDimensionPixelSize(index, this.f4447J);
                        break;
                    case 34:
                        this.f4492o = d.n(obtainStyledAttributes, index, this.f4492o);
                        break;
                    case 35:
                        this.f4490n = d.n(obtainStyledAttributes, index, this.f4490n);
                        break;
                    case 36:
                        this.f4506z = obtainStyledAttributes.getFloat(index, this.f4506z);
                        break;
                    case 37:
                        this.f4460W = obtainStyledAttributes.getFloat(index, this.f4460W);
                        break;
                    case 38:
                        this.f4459V = obtainStyledAttributes.getFloat(index, this.f4459V);
                        break;
                    case 39:
                        this.f4461X = obtainStyledAttributes.getInt(index, this.f4461X);
                        break;
                    case 40:
                        this.f4462Y = obtainStyledAttributes.getInt(index, this.f4462Y);
                        break;
                    case 41:
                        d.o(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        d.o(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i4) {
                            case 61:
                                this.f4439B = d.n(obtainStyledAttributes, index, this.f4439B);
                                break;
                            case 62:
                                this.f4440C = obtainStyledAttributes.getDimensionPixelSize(index, this.f4440C);
                                break;
                            case 63:
                                this.f4441D = obtainStyledAttributes.getFloat(index, this.f4441D);
                                break;
                            default:
                                switch (i4) {
                                    case 69:
                                        this.f4475f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f4477g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f4479h0 = obtainStyledAttributes.getInt(index, this.f4479h0);
                                        break;
                                    case 73:
                                        this.f4481i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4481i0);
                                        break;
                                    case 74:
                                        this.f4487l0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f4495p0 = obtainStyledAttributes.getBoolean(index, this.f4495p0);
                                        break;
                                    case 76:
                                        this.f4497q0 = obtainStyledAttributes.getInt(index, this.f4497q0);
                                        break;
                                    case 77:
                                        this.f4499s = d.n(obtainStyledAttributes, index, this.f4499s);
                                        break;
                                    case 78:
                                        this.f4500t = d.n(obtainStyledAttributes, index, this.f4500t);
                                        break;
                                    case 79:
                                        this.f4458U = obtainStyledAttributes.getDimensionPixelSize(index, this.f4458U);
                                        break;
                                    case 80:
                                        this.f4451N = obtainStyledAttributes.getDimensionPixelSize(index, this.f4451N);
                                        break;
                                    case 81:
                                        this.f4463Z = obtainStyledAttributes.getInt(index, this.f4463Z);
                                        break;
                                    case 82:
                                        this.f4465a0 = obtainStyledAttributes.getInt(index, this.f4465a0);
                                        break;
                                    case 83:
                                        this.f4469c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4469c0);
                                        break;
                                    case 84:
                                        this.f4467b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4467b0);
                                        break;
                                    case 85:
                                        this.f4473e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4473e0);
                                        break;
                                    case 86:
                                        this.f4471d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4471d0);
                                        break;
                                    case 87:
                                        this.f4491n0 = obtainStyledAttributes.getBoolean(index, this.f4491n0);
                                        break;
                                    case 88:
                                        this.f4493o0 = obtainStyledAttributes.getBoolean(index, this.f4493o0);
                                        break;
                                    case 89:
                                        this.f4489m0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f4480i = obtainStyledAttributes.getBoolean(index, this.f4480i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4437r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f4437r0.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class c {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f4507o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f4508a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f4509b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f4510c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f4511d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f4512e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f4513f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f4514g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f4515h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f4516i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public float f4517j = Float.NaN;

        /* renamed from: k, reason: collision with root package name */
        public int f4518k = -1;

        /* renamed from: l, reason: collision with root package name */
        public String f4519l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f4520m = -3;

        /* renamed from: n, reason: collision with root package name */
        public int f4521n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4507o = sparseIntArray;
            sparseIntArray.append(g.f6, 1);
            f4507o.append(g.h6, 2);
            f4507o.append(g.l6, 3);
            f4507o.append(g.e6, 4);
            f4507o.append(g.d6, 5);
            f4507o.append(g.c6, 6);
            f4507o.append(g.g6, 7);
            f4507o.append(g.k6, 8);
            f4507o.append(g.j6, 9);
            f4507o.append(g.i6, 10);
        }

        public void a(c cVar) {
            this.f4508a = cVar.f4508a;
            this.f4509b = cVar.f4509b;
            this.f4511d = cVar.f4511d;
            this.f4512e = cVar.f4512e;
            this.f4513f = cVar.f4513f;
            this.f4516i = cVar.f4516i;
            this.f4514g = cVar.f4514g;
            this.f4515h = cVar.f4515h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.b6);
            this.f4508a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (f4507o.get(index)) {
                    case 1:
                        this.f4516i = obtainStyledAttributes.getFloat(index, this.f4516i);
                        break;
                    case 2:
                        this.f4512e = obtainStyledAttributes.getInt(index, this.f4512e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f4511d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f4511d = C0490a.f12609c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f4513f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f4509b = d.n(obtainStyledAttributes, index, this.f4509b);
                        break;
                    case 6:
                        this.f4510c = obtainStyledAttributes.getInteger(index, this.f4510c);
                        break;
                    case 7:
                        this.f4514g = obtainStyledAttributes.getFloat(index, this.f4514g);
                        break;
                    case 8:
                        this.f4518k = obtainStyledAttributes.getInteger(index, this.f4518k);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                        this.f4517j = obtainStyledAttributes.getFloat(index, this.f4517j);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                        int i4 = obtainStyledAttributes.peekValue(index).type;
                        if (i4 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f4521n = resourceId;
                            if (resourceId != -1) {
                                this.f4520m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i4 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.f4519l = string;
                            if (string.indexOf("/") > 0) {
                                this.f4521n = obtainStyledAttributes.getResourceId(index, -1);
                                this.f4520m = -2;
                                break;
                            } else {
                                this.f4520m = -1;
                                break;
                            }
                        } else {
                            this.f4520m = obtainStyledAttributes.getInteger(index, this.f4521n);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0060d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4522a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f4523b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f4524c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f4525d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f4526e = Float.NaN;

        public void a(C0060d c0060d) {
            this.f4522a = c0060d.f4522a;
            this.f4523b = c0060d.f4523b;
            this.f4525d = c0060d.f4525d;
            this.f4526e = c0060d.f4526e;
            this.f4524c = c0060d.f4524c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.w6);
            this.f4522a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == g.y6) {
                    this.f4525d = obtainStyledAttributes.getFloat(index, this.f4525d);
                } else if (index == g.x6) {
                    this.f4523b = obtainStyledAttributes.getInt(index, this.f4523b);
                    this.f4523b = d.f4409f[this.f4523b];
                } else if (index == g.A6) {
                    this.f4524c = obtainStyledAttributes.getInt(index, this.f4524c);
                } else if (index == g.z6) {
                    this.f4526e = obtainStyledAttributes.getFloat(index, this.f4526e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f4527o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f4528a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f4529b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f4530c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f4531d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f4532e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f4533f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f4534g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f4535h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f4536i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f4537j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f4538k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f4539l = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        public boolean f4540m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f4541n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4527o = sparseIntArray;
            sparseIntArray.append(g.V6, 1);
            f4527o.append(g.W6, 2);
            f4527o.append(g.X6, 3);
            f4527o.append(g.T6, 4);
            f4527o.append(g.U6, 5);
            f4527o.append(g.P6, 6);
            f4527o.append(g.Q6, 7);
            f4527o.append(g.R6, 8);
            f4527o.append(g.S6, 9);
            f4527o.append(g.Y6, 10);
            f4527o.append(g.Z6, 11);
            f4527o.append(g.a7, 12);
        }

        public void a(e eVar) {
            this.f4528a = eVar.f4528a;
            this.f4529b = eVar.f4529b;
            this.f4530c = eVar.f4530c;
            this.f4531d = eVar.f4531d;
            this.f4532e = eVar.f4532e;
            this.f4533f = eVar.f4533f;
            this.f4534g = eVar.f4534g;
            this.f4535h = eVar.f4535h;
            this.f4536i = eVar.f4536i;
            this.f4537j = eVar.f4537j;
            this.f4538k = eVar.f4538k;
            this.f4539l = eVar.f4539l;
            this.f4540m = eVar.f4540m;
            this.f4541n = eVar.f4541n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.O6);
            this.f4528a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (f4527o.get(index)) {
                    case 1:
                        this.f4529b = obtainStyledAttributes.getFloat(index, this.f4529b);
                        break;
                    case 2:
                        this.f4530c = obtainStyledAttributes.getFloat(index, this.f4530c);
                        break;
                    case 3:
                        this.f4531d = obtainStyledAttributes.getFloat(index, this.f4531d);
                        break;
                    case 4:
                        this.f4532e = obtainStyledAttributes.getFloat(index, this.f4532e);
                        break;
                    case 5:
                        this.f4533f = obtainStyledAttributes.getFloat(index, this.f4533f);
                        break;
                    case 6:
                        this.f4534g = obtainStyledAttributes.getDimension(index, this.f4534g);
                        break;
                    case 7:
                        this.f4535h = obtainStyledAttributes.getDimension(index, this.f4535h);
                        break;
                    case 8:
                        this.f4537j = obtainStyledAttributes.getDimension(index, this.f4537j);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                        this.f4538k = obtainStyledAttributes.getDimension(index, this.f4538k);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                        this.f4539l = obtainStyledAttributes.getDimension(index, this.f4539l);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                        this.f4540m = true;
                        this.f4541n = obtainStyledAttributes.getDimension(index, this.f4541n);
                        break;
                    case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                        this.f4536i = d.n(obtainStyledAttributes, index, this.f4536i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f4410g.append(g.f4543A0, 25);
        f4410g.append(g.f4547B0, 26);
        f4410g.append(g.f4555D0, 29);
        f4410g.append(g.f4559E0, 30);
        f4410g.append(g.f4583K0, 36);
        f4410g.append(g.f4579J0, 35);
        f4410g.append(g.f4673h0, 4);
        f4410g.append(g.f4669g0, 3);
        f4410g.append(g.f4653c0, 1);
        f4410g.append(g.f4661e0, 91);
        f4410g.append(g.f4657d0, 92);
        f4410g.append(g.f4619T0, 6);
        f4410g.append(g.f4623U0, 7);
        f4410g.append(g.f4701o0, 17);
        f4410g.append(g.f4705p0, 18);
        f4410g.append(g.f4709q0, 19);
        f4410g.append(g.f4638Y, 99);
        f4410g.append(g.f4724u, 27);
        f4410g.append(g.f4563F0, 32);
        f4410g.append(g.f4567G0, 33);
        f4410g.append(g.f4697n0, 10);
        f4410g.append(g.f4693m0, 9);
        f4410g.append(g.f4635X0, 13);
        f4410g.append(g.f4646a1, 16);
        f4410g.append(g.f4639Y0, 14);
        f4410g.append(g.f4627V0, 11);
        f4410g.append(g.f4642Z0, 15);
        f4410g.append(g.f4631W0, 12);
        f4410g.append(g.f4595N0, 40);
        f4410g.append(g.f4741y0, 39);
        f4410g.append(g.f4737x0, 41);
        f4410g.append(g.f4591M0, 42);
        f4410g.append(g.f4733w0, 20);
        f4410g.append(g.f4587L0, 37);
        f4410g.append(g.f4689l0, 5);
        f4410g.append(g.f4745z0, 87);
        f4410g.append(g.f4575I0, 87);
        f4410g.append(g.f4551C0, 87);
        f4410g.append(g.f4665f0, 87);
        f4410g.append(g.f4649b0, 87);
        f4410g.append(g.f4744z, 24);
        f4410g.append(g.f4546B, 28);
        f4410g.append(g.f4594N, 31);
        f4410g.append(g.f4598O, 8);
        f4410g.append(g.f4542A, 34);
        f4410g.append(g.f4550C, 2);
        f4410g.append(g.f4736x, 23);
        f4410g.append(g.f4740y, 21);
        f4410g.append(g.f4599O0, 95);
        f4410g.append(g.f4713r0, 96);
        f4410g.append(g.f4732w, 22);
        f4410g.append(g.f4554D, 43);
        f4410g.append(g.f4606Q, 44);
        f4410g.append(g.f4586L, 45);
        f4410g.append(g.f4590M, 46);
        f4410g.append(g.f4582K, 60);
        f4410g.append(g.f4574I, 47);
        f4410g.append(g.f4578J, 48);
        f4410g.append(g.f4558E, 49);
        f4410g.append(g.f4562F, 50);
        f4410g.append(g.f4566G, 51);
        f4410g.append(g.f4570H, 52);
        f4410g.append(g.f4602P, 53);
        f4410g.append(g.f4603P0, 54);
        f4410g.append(g.f4717s0, 55);
        f4410g.append(g.f4607Q0, 56);
        f4410g.append(g.f4721t0, 57);
        f4410g.append(g.f4611R0, 58);
        f4410g.append(g.f4725u0, 59);
        f4410g.append(g.f4677i0, 61);
        f4410g.append(g.f4685k0, 62);
        f4410g.append(g.f4681j0, 63);
        f4410g.append(g.f4610R, 64);
        f4410g.append(g.f4686k1, 65);
        f4410g.append(g.f4634X, 66);
        f4410g.append(g.f4690l1, 67);
        f4410g.append(g.f4658d1, 79);
        f4410g.append(g.f4728v, 38);
        f4410g.append(g.f4654c1, 68);
        f4410g.append(g.f4615S0, 69);
        f4410g.append(g.f4729v0, 70);
        f4410g.append(g.f4650b1, 97);
        f4410g.append(g.f4626V, 71);
        f4410g.append(g.f4618T, 72);
        f4410g.append(g.f4622U, 73);
        f4410g.append(g.f4630W, 74);
        f4410g.append(g.f4614S, 75);
        f4410g.append(g.f4662e1, 76);
        f4410g.append(g.f4571H0, 77);
        f4410g.append(g.f4694m1, 78);
        f4410g.append(g.f4645a0, 80);
        f4410g.append(g.f4641Z, 81);
        f4410g.append(g.f4666f1, 82);
        f4410g.append(g.f4682j1, 83);
        f4410g.append(g.f4678i1, 84);
        f4410g.append(g.f4674h1, 85);
        f4410g.append(g.f4670g1, 86);
        f4411h.append(g.P3, 6);
        f4411h.append(g.P3, 7);
        f4411h.append(g.f4585K2, 27);
        f4411h.append(g.S3, 13);
        f4411h.append(g.V3, 16);
        f4411h.append(g.T3, 14);
        f4411h.append(g.Q3, 11);
        f4411h.append(g.U3, 15);
        f4411h.append(g.R3, 12);
        f4411h.append(g.J3, 40);
        f4411h.append(g.C3, 39);
        f4411h.append(g.B3, 41);
        f4411h.append(g.I3, 42);
        f4411h.append(g.A3, 20);
        f4411h.append(g.H3, 37);
        f4411h.append(g.u3, 5);
        f4411h.append(g.D3, 87);
        f4411h.append(g.G3, 87);
        f4411h.append(g.E3, 87);
        f4411h.append(g.r3, 87);
        f4411h.append(g.q3, 87);
        f4411h.append(g.f4605P2, 24);
        f4411h.append(g.f4613R2, 28);
        f4411h.append(g.d3, 31);
        f4411h.append(g.e3, 8);
        f4411h.append(g.f4609Q2, 34);
        f4411h.append(g.f4617S2, 2);
        f4411h.append(g.f4597N2, 23);
        f4411h.append(g.f4601O2, 21);
        f4411h.append(g.K3, 95);
        f4411h.append(g.v3, 96);
        f4411h.append(g.f4593M2, 22);
        f4411h.append(g.f4621T2, 43);
        f4411h.append(g.g3, 44);
        f4411h.append(g.b3, 45);
        f4411h.append(g.c3, 46);
        f4411h.append(g.a3, 60);
        f4411h.append(g.Y2, 47);
        f4411h.append(g.Z2, 48);
        f4411h.append(g.f4625U2, 49);
        f4411h.append(g.f4629V2, 50);
        f4411h.append(g.f4633W2, 51);
        f4411h.append(g.f4637X2, 52);
        f4411h.append(g.f3, 53);
        f4411h.append(g.L3, 54);
        f4411h.append(g.w3, 55);
        f4411h.append(g.M3, 56);
        f4411h.append(g.x3, 57);
        f4411h.append(g.N3, 58);
        f4411h.append(g.y3, 59);
        f4411h.append(g.t3, 62);
        f4411h.append(g.s3, 63);
        f4411h.append(g.h3, 64);
        f4411h.append(g.g4, 65);
        f4411h.append(g.n3, 66);
        f4411h.append(g.h4, 67);
        f4411h.append(g.Y3, 79);
        f4411h.append(g.f4589L2, 38);
        f4411h.append(g.Z3, 98);
        f4411h.append(g.X3, 68);
        f4411h.append(g.O3, 69);
        f4411h.append(g.z3, 70);
        f4411h.append(g.l3, 71);
        f4411h.append(g.j3, 72);
        f4411h.append(g.k3, 73);
        f4411h.append(g.m3, 74);
        f4411h.append(g.i3, 75);
        f4411h.append(g.a4, 76);
        f4411h.append(g.F3, 77);
        f4411h.append(g.i4, 78);
        f4411h.append(g.p3, 80);
        f4411h.append(g.o3, 81);
        f4411h.append(g.b4, 82);
        f4411h.append(g.f4, 83);
        f4411h.append(g.e4, 84);
        f4411h.append(g.d4, 85);
        f4411h.append(g.c4, 86);
        f4411h.append(g.W3, 97);
    }

    private int[] i(View view, String str) {
        int i3;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i4 = 0;
        int i5 = 0;
        while (i4 < split.length) {
            String trim = split[i4].trim();
            try {
                i3 = f.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 == 0) {
                i3 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i3 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i3 = ((Integer) designInformation).intValue();
            }
            iArr[i5] = i3;
            i4++;
            i5++;
        }
        return i5 != split.length ? Arrays.copyOf(iArr, i5) : iArr;
    }

    private a j(Context context, AttributeSet attributeSet, boolean z3) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z3 ? g.f4581J2 : g.f4720t);
        r(context, aVar, obtainStyledAttributes, z3);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a k(int i3) {
        if (!this.f4416e.containsKey(Integer.valueOf(i3))) {
            this.f4416e.put(Integer.valueOf(i3), new a());
        }
        return (a) this.f4416e.get(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(TypedArray typedArray, int i3, int i4) {
        int resourceId = typedArray.getResourceId(i3, i4);
        return resourceId == -1 ? typedArray.getInt(i3, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void o(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L71
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2a
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L26
            r6 = -3
            if (r5 == r6) goto L20
            if (r5 == r0) goto L22
            r6 = -1
            if (r5 == r6) goto L22
        L20:
            r5 = r2
            goto L2f
        L22:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L2f
        L26:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L2f
        L2a:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L22
        L2f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.b
            if (r6 == 0) goto L41
            androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4
            if (r7 != 0) goto L3c
            r4.width = r2
            r4.constrainedWidth = r5
            goto L70
        L3c:
            r4.height = r2
            r4.constrainedHeight = r5
            goto L70
        L41:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.b
            if (r6 == 0) goto L53
            androidx.constraintlayout.widget.d$b r4 = (androidx.constraintlayout.widget.d.b) r4
            if (r7 != 0) goto L4e
            r4.f4470d = r2
            r4.f4491n0 = r5
            goto L70
        L4e:
            r4.f4472e = r2
            r4.f4493o0 = r5
            goto L70
        L53:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.a.C0059a
            if (r6 == 0) goto L70
            androidx.constraintlayout.widget.d$a$a r4 = (androidx.constraintlayout.widget.d.a.C0059a) r4
            if (r7 != 0) goto L66
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            goto L70
        L66:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L70:
            return
        L71:
            java.lang.String r5 = r5.getString(r6)
            p(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.o(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void p(Object obj, String str, int i3) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if ("ratio".equalsIgnoreCase(trim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i3 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    q(bVar, trim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f4438A = trim2;
                    return;
                } else {
                    if (obj instanceof a.C0059a) {
                        ((a.C0059a) obj).c(5, trim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.horizontalWeight = parseFloat;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.verticalWeight = parseFloat;
                        }
                    } else if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i3 == 0) {
                            bVar3.f4470d = 0;
                            bVar3.f4460W = parseFloat;
                        } else {
                            bVar3.f4472e = 0;
                            bVar3.f4459V = parseFloat;
                        }
                    } else if (obj instanceof a.C0059a) {
                        a.C0059a c0059a = (a.C0059a) obj;
                        if (i3 == 0) {
                            c0059a.b(23, 0);
                            c0059a.a(39, parseFloat);
                        } else {
                            c0059a.b(21, 0);
                            c0059a.a(40, parseFloat);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(trim)) {
                        return;
                    }
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.matchConstraintPercentWidth = max;
                            bVar4.matchConstraintDefaultWidth = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.matchConstraintPercentHeight = max;
                            bVar4.matchConstraintDefaultHeight = 2;
                        }
                    } else if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i3 == 0) {
                            bVar5.f4470d = 0;
                            bVar5.f4475f0 = max;
                            bVar5.f4463Z = 2;
                        } else {
                            bVar5.f4472e = 0;
                            bVar5.f4477g0 = max;
                            bVar5.f4465a0 = 2;
                        }
                    } else if (obj instanceof a.C0059a) {
                        a.C0059a c0059a2 = (a.C0059a) obj;
                        if (i3 == 0) {
                            c0059a2.b(23, 0);
                            c0059a2.b(54, 2);
                        } else {
                            c0059a2.b(21, 0);
                            c0059a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    static void q(ConstraintLayout.b bVar, String str) {
        float f3 = Float.NaN;
        int i3 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i4 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i3 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i3 = 1;
                }
                i4 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i4);
                    if (substring2.length() > 0) {
                        f3 = Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i4, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f3 = i3 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.dimensionRatio = str;
        bVar.dimensionRatioValue = f3;
        bVar.dimensionRatioSide = i3;
    }

    private void r(Context context, a aVar, TypedArray typedArray, boolean z3) {
        if (z3) {
            s(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index != g.f4728v && g.f4594N != index && g.f4598O != index) {
                aVar.f4420d.f4508a = true;
                aVar.f4421e.f4466b = true;
                aVar.f4419c.f4522a = true;
                aVar.f4422f.f4528a = true;
            }
            switch (f4410g.get(index)) {
                case 1:
                    b bVar = aVar.f4421e;
                    bVar.f4498r = n(typedArray, index, bVar.f4498r);
                    break;
                case 2:
                    b bVar2 = aVar.f4421e;
                    bVar2.f4448K = typedArray.getDimensionPixelSize(index, bVar2.f4448K);
                    break;
                case 3:
                    b bVar3 = aVar.f4421e;
                    bVar3.f4496q = n(typedArray, index, bVar3.f4496q);
                    break;
                case 4:
                    b bVar4 = aVar.f4421e;
                    bVar4.f4494p = n(typedArray, index, bVar4.f4494p);
                    break;
                case 5:
                    aVar.f4421e.f4438A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f4421e;
                    bVar5.f4442E = typedArray.getDimensionPixelOffset(index, bVar5.f4442E);
                    break;
                case 7:
                    b bVar6 = aVar.f4421e;
                    bVar6.f4443F = typedArray.getDimensionPixelOffset(index, bVar6.f4443F);
                    break;
                case 8:
                    b bVar7 = aVar.f4421e;
                    bVar7.f4449L = typedArray.getDimensionPixelSize(index, bVar7.f4449L);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    b bVar8 = aVar.f4421e;
                    bVar8.f4504x = n(typedArray, index, bVar8.f4504x);
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    b bVar9 = aVar.f4421e;
                    bVar9.f4503w = n(typedArray, index, bVar9.f4503w);
                    break;
                case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                    b bVar10 = aVar.f4421e;
                    bVar10.f4455R = typedArray.getDimensionPixelSize(index, bVar10.f4455R);
                    break;
                case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                    b bVar11 = aVar.f4421e;
                    bVar11.f4456S = typedArray.getDimensionPixelSize(index, bVar11.f4456S);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                    b bVar12 = aVar.f4421e;
                    bVar12.f4452O = typedArray.getDimensionPixelSize(index, bVar12.f4452O);
                    break;
                case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                    b bVar13 = aVar.f4421e;
                    bVar13.f4454Q = typedArray.getDimensionPixelSize(index, bVar13.f4454Q);
                    break;
                case COUIViewDragHelper.EDGE_ALL /* 15 */:
                    b bVar14 = aVar.f4421e;
                    bVar14.f4457T = typedArray.getDimensionPixelSize(index, bVar14.f4457T);
                    break;
                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                    b bVar15 = aVar.f4421e;
                    bVar15.f4453P = typedArray.getDimensionPixelSize(index, bVar15.f4453P);
                    break;
                case 17:
                    b bVar16 = aVar.f4421e;
                    bVar16.f4474f = typedArray.getDimensionPixelOffset(index, bVar16.f4474f);
                    break;
                case 18:
                    b bVar17 = aVar.f4421e;
                    bVar17.f4476g = typedArray.getDimensionPixelOffset(index, bVar17.f4476g);
                    break;
                case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                    b bVar18 = aVar.f4421e;
                    bVar18.f4478h = typedArray.getFloat(index, bVar18.f4478h);
                    break;
                case 20:
                    b bVar19 = aVar.f4421e;
                    bVar19.f4505y = typedArray.getFloat(index, bVar19.f4505y);
                    break;
                case 21:
                    b bVar20 = aVar.f4421e;
                    bVar20.f4472e = typedArray.getLayoutDimension(index, bVar20.f4472e);
                    break;
                case 22:
                    C0060d c0060d = aVar.f4419c;
                    c0060d.f4523b = typedArray.getInt(index, c0060d.f4523b);
                    C0060d c0060d2 = aVar.f4419c;
                    c0060d2.f4523b = f4409f[c0060d2.f4523b];
                    break;
                case 23:
                    b bVar21 = aVar.f4421e;
                    bVar21.f4470d = typedArray.getLayoutDimension(index, bVar21.f4470d);
                    break;
                case 24:
                    b bVar22 = aVar.f4421e;
                    bVar22.f4445H = typedArray.getDimensionPixelSize(index, bVar22.f4445H);
                    break;
                case 25:
                    b bVar23 = aVar.f4421e;
                    bVar23.f4482j = n(typedArray, index, bVar23.f4482j);
                    break;
                case 26:
                    b bVar24 = aVar.f4421e;
                    bVar24.f4484k = n(typedArray, index, bVar24.f4484k);
                    break;
                case 27:
                    b bVar25 = aVar.f4421e;
                    bVar25.f4444G = typedArray.getInt(index, bVar25.f4444G);
                    break;
                case 28:
                    b bVar26 = aVar.f4421e;
                    bVar26.f4446I = typedArray.getDimensionPixelSize(index, bVar26.f4446I);
                    break;
                case 29:
                    b bVar27 = aVar.f4421e;
                    bVar27.f4486l = n(typedArray, index, bVar27.f4486l);
                    break;
                case 30:
                    b bVar28 = aVar.f4421e;
                    bVar28.f4488m = n(typedArray, index, bVar28.f4488m);
                    break;
                case 31:
                    b bVar29 = aVar.f4421e;
                    bVar29.f4450M = typedArray.getDimensionPixelSize(index, bVar29.f4450M);
                    break;
                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS /* 32 */:
                    b bVar30 = aVar.f4421e;
                    bVar30.f4501u = n(typedArray, index, bVar30.f4501u);
                    break;
                case 33:
                    b bVar31 = aVar.f4421e;
                    bVar31.f4502v = n(typedArray, index, bVar31.f4502v);
                    break;
                case 34:
                    b bVar32 = aVar.f4421e;
                    bVar32.f4447J = typedArray.getDimensionPixelSize(index, bVar32.f4447J);
                    break;
                case 35:
                    b bVar33 = aVar.f4421e;
                    bVar33.f4492o = n(typedArray, index, bVar33.f4492o);
                    break;
                case 36:
                    b bVar34 = aVar.f4421e;
                    bVar34.f4490n = n(typedArray, index, bVar34.f4490n);
                    break;
                case 37:
                    b bVar35 = aVar.f4421e;
                    bVar35.f4506z = typedArray.getFloat(index, bVar35.f4506z);
                    break;
                case 38:
                    aVar.f4417a = typedArray.getResourceId(index, aVar.f4417a);
                    break;
                case 39:
                    b bVar36 = aVar.f4421e;
                    bVar36.f4460W = typedArray.getFloat(index, bVar36.f4460W);
                    break;
                case 40:
                    b bVar37 = aVar.f4421e;
                    bVar37.f4459V = typedArray.getFloat(index, bVar37.f4459V);
                    break;
                case 41:
                    b bVar38 = aVar.f4421e;
                    bVar38.f4461X = typedArray.getInt(index, bVar38.f4461X);
                    break;
                case 42:
                    b bVar39 = aVar.f4421e;
                    bVar39.f4462Y = typedArray.getInt(index, bVar39.f4462Y);
                    break;
                case 43:
                    C0060d c0060d3 = aVar.f4419c;
                    c0060d3.f4525d = typedArray.getFloat(index, c0060d3.f4525d);
                    break;
                case 44:
                    e eVar = aVar.f4422f;
                    eVar.f4540m = true;
                    eVar.f4541n = typedArray.getDimension(index, eVar.f4541n);
                    break;
                case 45:
                    e eVar2 = aVar.f4422f;
                    eVar2.f4530c = typedArray.getFloat(index, eVar2.f4530c);
                    break;
                case 46:
                    e eVar3 = aVar.f4422f;
                    eVar3.f4531d = typedArray.getFloat(index, eVar3.f4531d);
                    break;
                case 47:
                    e eVar4 = aVar.f4422f;
                    eVar4.f4532e = typedArray.getFloat(index, eVar4.f4532e);
                    break;
                case 48:
                    e eVar5 = aVar.f4422f;
                    eVar5.f4533f = typedArray.getFloat(index, eVar5.f4533f);
                    break;
                case 49:
                    e eVar6 = aVar.f4422f;
                    eVar6.f4534g = typedArray.getDimension(index, eVar6.f4534g);
                    break;
                case 50:
                    e eVar7 = aVar.f4422f;
                    eVar7.f4535h = typedArray.getDimension(index, eVar7.f4535h);
                    break;
                case 51:
                    e eVar8 = aVar.f4422f;
                    eVar8.f4537j = typedArray.getDimension(index, eVar8.f4537j);
                    break;
                case 52:
                    e eVar9 = aVar.f4422f;
                    eVar9.f4538k = typedArray.getDimension(index, eVar9.f4538k);
                    break;
                case 53:
                    e eVar10 = aVar.f4422f;
                    eVar10.f4539l = typedArray.getDimension(index, eVar10.f4539l);
                    break;
                case 54:
                    b bVar40 = aVar.f4421e;
                    bVar40.f4463Z = typedArray.getInt(index, bVar40.f4463Z);
                    break;
                case 55:
                    b bVar41 = aVar.f4421e;
                    bVar41.f4465a0 = typedArray.getInt(index, bVar41.f4465a0);
                    break;
                case 56:
                    b bVar42 = aVar.f4421e;
                    bVar42.f4467b0 = typedArray.getDimensionPixelSize(index, bVar42.f4467b0);
                    break;
                case 57:
                    b bVar43 = aVar.f4421e;
                    bVar43.f4469c0 = typedArray.getDimensionPixelSize(index, bVar43.f4469c0);
                    break;
                case 58:
                    b bVar44 = aVar.f4421e;
                    bVar44.f4471d0 = typedArray.getDimensionPixelSize(index, bVar44.f4471d0);
                    break;
                case 59:
                    b bVar45 = aVar.f4421e;
                    bVar45.f4473e0 = typedArray.getDimensionPixelSize(index, bVar45.f4473e0);
                    break;
                case 60:
                    e eVar11 = aVar.f4422f;
                    eVar11.f4529b = typedArray.getFloat(index, eVar11.f4529b);
                    break;
                case 61:
                    b bVar46 = aVar.f4421e;
                    bVar46.f4439B = n(typedArray, index, bVar46.f4439B);
                    break;
                case 62:
                    b bVar47 = aVar.f4421e;
                    bVar47.f4440C = typedArray.getDimensionPixelSize(index, bVar47.f4440C);
                    break;
                case 63:
                    b bVar48 = aVar.f4421e;
                    bVar48.f4441D = typedArray.getFloat(index, bVar48.f4441D);
                    break;
                case 64:
                    c cVar = aVar.f4420d;
                    cVar.f4509b = n(typedArray, index, cVar.f4509b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f4420d.f4511d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f4420d.f4511d = C0490a.f12609c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f4420d.f4513f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f4420d;
                    cVar2.f4516i = typedArray.getFloat(index, cVar2.f4516i);
                    break;
                case 68:
                    C0060d c0060d4 = aVar.f4419c;
                    c0060d4.f4526e = typedArray.getFloat(index, c0060d4.f4526e);
                    break;
                case 69:
                    aVar.f4421e.f4475f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f4421e.f4477g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f4421e;
                    bVar49.f4479h0 = typedArray.getInt(index, bVar49.f4479h0);
                    break;
                case 73:
                    b bVar50 = aVar.f4421e;
                    bVar50.f4481i0 = typedArray.getDimensionPixelSize(index, bVar50.f4481i0);
                    break;
                case 74:
                    aVar.f4421e.f4487l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f4421e;
                    bVar51.f4495p0 = typedArray.getBoolean(index, bVar51.f4495p0);
                    break;
                case 76:
                    c cVar3 = aVar.f4420d;
                    cVar3.f4512e = typedArray.getInt(index, cVar3.f4512e);
                    break;
                case 77:
                    aVar.f4421e.f4489m0 = typedArray.getString(index);
                    break;
                case 78:
                    C0060d c0060d5 = aVar.f4419c;
                    c0060d5.f4524c = typedArray.getInt(index, c0060d5.f4524c);
                    break;
                case 79:
                    c cVar4 = aVar.f4420d;
                    cVar4.f4514g = typedArray.getFloat(index, cVar4.f4514g);
                    break;
                case 80:
                    b bVar52 = aVar.f4421e;
                    bVar52.f4491n0 = typedArray.getBoolean(index, bVar52.f4491n0);
                    break;
                case 81:
                    b bVar53 = aVar.f4421e;
                    bVar53.f4493o0 = typedArray.getBoolean(index, bVar53.f4493o0);
                    break;
                case 82:
                    c cVar5 = aVar.f4420d;
                    cVar5.f4510c = typedArray.getInteger(index, cVar5.f4510c);
                    break;
                case 83:
                    e eVar12 = aVar.f4422f;
                    eVar12.f4536i = n(typedArray, index, eVar12.f4536i);
                    break;
                case 84:
                    c cVar6 = aVar.f4420d;
                    cVar6.f4518k = typedArray.getInteger(index, cVar6.f4518k);
                    break;
                case 85:
                    c cVar7 = aVar.f4420d;
                    cVar7.f4517j = typedArray.getFloat(index, cVar7.f4517j);
                    break;
                case 86:
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        aVar.f4420d.f4521n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f4420d;
                        if (cVar8.f4521n != -1) {
                            cVar8.f4520m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i4 == 3) {
                        aVar.f4420d.f4519l = typedArray.getString(index);
                        if (aVar.f4420d.f4519l.indexOf("/") > 0) {
                            aVar.f4420d.f4521n = typedArray.getResourceId(index, -1);
                            aVar.f4420d.f4520m = -2;
                            break;
                        } else {
                            aVar.f4420d.f4520m = -1;
                            break;
                        }
                    } else {
                        c cVar9 = aVar.f4420d;
                        cVar9.f4520m = typedArray.getInteger(index, cVar9.f4521n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4410g.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f4410g.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f4421e;
                    bVar54.f4499s = n(typedArray, index, bVar54.f4499s);
                    break;
                case 92:
                    b bVar55 = aVar.f4421e;
                    bVar55.f4500t = n(typedArray, index, bVar55.f4500t);
                    break;
                case 93:
                    b bVar56 = aVar.f4421e;
                    bVar56.f4451N = typedArray.getDimensionPixelSize(index, bVar56.f4451N);
                    break;
                case 94:
                    b bVar57 = aVar.f4421e;
                    bVar57.f4458U = typedArray.getDimensionPixelSize(index, bVar57.f4458U);
                    break;
                case 95:
                    o(aVar.f4421e, typedArray, index, 0);
                    break;
                case 96:
                    o(aVar.f4421e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f4421e;
                    bVar58.f4497q0 = typedArray.getInt(index, bVar58.f4497q0);
                    break;
            }
        }
        b bVar59 = aVar.f4421e;
        if (bVar59.f4487l0 != null) {
            bVar59.f4485k0 = null;
        }
    }

    private static void s(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0059a c0059a = new a.C0059a();
        aVar.f4424h = c0059a;
        aVar.f4420d.f4508a = false;
        aVar.f4421e.f4466b = false;
        aVar.f4419c.f4522a = false;
        aVar.f4422f.f4528a = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            switch (f4411h.get(index)) {
                case 2:
                    c0059a.b(2, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4448K));
                    break;
                case 3:
                case 4:
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                case 25:
                case 26:
                case 29:
                case 30:
                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS /* 32 */:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f4410g.get(index));
                    break;
                case 5:
                    c0059a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0059a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f4421e.f4442E));
                    break;
                case 7:
                    c0059a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f4421e.f4443F));
                    break;
                case 8:
                    c0059a.b(8, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4449L));
                    break;
                case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                    c0059a.b(11, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4455R));
                    break;
                case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                    c0059a.b(12, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4456S));
                    break;
                case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                    c0059a.b(13, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4452O));
                    break;
                case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                    c0059a.b(14, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4454Q));
                    break;
                case COUIViewDragHelper.EDGE_ALL /* 15 */:
                    c0059a.b(15, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4457T));
                    break;
                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                    c0059a.b(16, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4453P));
                    break;
                case 17:
                    c0059a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f4421e.f4474f));
                    break;
                case 18:
                    c0059a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f4421e.f4476g));
                    break;
                case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                    c0059a.a(19, typedArray.getFloat(index, aVar.f4421e.f4478h));
                    break;
                case 20:
                    c0059a.a(20, typedArray.getFloat(index, aVar.f4421e.f4505y));
                    break;
                case 21:
                    c0059a.b(21, typedArray.getLayoutDimension(index, aVar.f4421e.f4472e));
                    break;
                case 22:
                    c0059a.b(22, f4409f[typedArray.getInt(index, aVar.f4419c.f4523b)]);
                    break;
                case 23:
                    c0059a.b(23, typedArray.getLayoutDimension(index, aVar.f4421e.f4470d));
                    break;
                case 24:
                    c0059a.b(24, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4445H));
                    break;
                case 27:
                    c0059a.b(27, typedArray.getInt(index, aVar.f4421e.f4444G));
                    break;
                case 28:
                    c0059a.b(28, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4446I));
                    break;
                case 31:
                    c0059a.b(31, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4450M));
                    break;
                case 34:
                    c0059a.b(34, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4447J));
                    break;
                case 37:
                    c0059a.a(37, typedArray.getFloat(index, aVar.f4421e.f4506z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f4417a);
                    aVar.f4417a = resourceId;
                    c0059a.b(38, resourceId);
                    break;
                case 39:
                    c0059a.a(39, typedArray.getFloat(index, aVar.f4421e.f4460W));
                    break;
                case 40:
                    c0059a.a(40, typedArray.getFloat(index, aVar.f4421e.f4459V));
                    break;
                case 41:
                    c0059a.b(41, typedArray.getInt(index, aVar.f4421e.f4461X));
                    break;
                case 42:
                    c0059a.b(42, typedArray.getInt(index, aVar.f4421e.f4462Y));
                    break;
                case 43:
                    c0059a.a(43, typedArray.getFloat(index, aVar.f4419c.f4525d));
                    break;
                case 44:
                    c0059a.d(44, true);
                    c0059a.a(44, typedArray.getDimension(index, aVar.f4422f.f4541n));
                    break;
                case 45:
                    c0059a.a(45, typedArray.getFloat(index, aVar.f4422f.f4530c));
                    break;
                case 46:
                    c0059a.a(46, typedArray.getFloat(index, aVar.f4422f.f4531d));
                    break;
                case 47:
                    c0059a.a(47, typedArray.getFloat(index, aVar.f4422f.f4532e));
                    break;
                case 48:
                    c0059a.a(48, typedArray.getFloat(index, aVar.f4422f.f4533f));
                    break;
                case 49:
                    c0059a.a(49, typedArray.getDimension(index, aVar.f4422f.f4534g));
                    break;
                case 50:
                    c0059a.a(50, typedArray.getDimension(index, aVar.f4422f.f4535h));
                    break;
                case 51:
                    c0059a.a(51, typedArray.getDimension(index, aVar.f4422f.f4537j));
                    break;
                case 52:
                    c0059a.a(52, typedArray.getDimension(index, aVar.f4422f.f4538k));
                    break;
                case 53:
                    c0059a.a(53, typedArray.getDimension(index, aVar.f4422f.f4539l));
                    break;
                case 54:
                    c0059a.b(54, typedArray.getInt(index, aVar.f4421e.f4463Z));
                    break;
                case 55:
                    c0059a.b(55, typedArray.getInt(index, aVar.f4421e.f4465a0));
                    break;
                case 56:
                    c0059a.b(56, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4467b0));
                    break;
                case 57:
                    c0059a.b(57, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4469c0));
                    break;
                case 58:
                    c0059a.b(58, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4471d0));
                    break;
                case 59:
                    c0059a.b(59, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4473e0));
                    break;
                case 60:
                    c0059a.a(60, typedArray.getFloat(index, aVar.f4422f.f4529b));
                    break;
                case 62:
                    c0059a.b(62, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4440C));
                    break;
                case 63:
                    c0059a.a(63, typedArray.getFloat(index, aVar.f4421e.f4441D));
                    break;
                case 64:
                    c0059a.b(64, n(typedArray, index, aVar.f4420d.f4509b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c0059a.c(65, typedArray.getString(index));
                        break;
                    } else {
                        c0059a.c(65, C0490a.f12609c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    c0059a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0059a.a(67, typedArray.getFloat(index, aVar.f4420d.f4516i));
                    break;
                case 68:
                    c0059a.a(68, typedArray.getFloat(index, aVar.f4419c.f4526e));
                    break;
                case 69:
                    c0059a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0059a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0059a.b(72, typedArray.getInt(index, aVar.f4421e.f4479h0));
                    break;
                case 73:
                    c0059a.b(73, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4481i0));
                    break;
                case 74:
                    c0059a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0059a.d(75, typedArray.getBoolean(index, aVar.f4421e.f4495p0));
                    break;
                case 76:
                    c0059a.b(76, typedArray.getInt(index, aVar.f4420d.f4512e));
                    break;
                case 77:
                    c0059a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0059a.b(78, typedArray.getInt(index, aVar.f4419c.f4524c));
                    break;
                case 79:
                    c0059a.a(79, typedArray.getFloat(index, aVar.f4420d.f4514g));
                    break;
                case 80:
                    c0059a.d(80, typedArray.getBoolean(index, aVar.f4421e.f4491n0));
                    break;
                case 81:
                    c0059a.d(81, typedArray.getBoolean(index, aVar.f4421e.f4493o0));
                    break;
                case 82:
                    c0059a.b(82, typedArray.getInteger(index, aVar.f4420d.f4510c));
                    break;
                case 83:
                    c0059a.b(83, n(typedArray, index, aVar.f4422f.f4536i));
                    break;
                case 84:
                    c0059a.b(84, typedArray.getInteger(index, aVar.f4420d.f4518k));
                    break;
                case 85:
                    c0059a.a(85, typedArray.getFloat(index, aVar.f4420d.f4517j));
                    break;
                case 86:
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        aVar.f4420d.f4521n = typedArray.getResourceId(index, -1);
                        c0059a.b(89, aVar.f4420d.f4521n);
                        c cVar = aVar.f4420d;
                        if (cVar.f4521n != -1) {
                            cVar.f4520m = -2;
                            c0059a.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i4 == 3) {
                        aVar.f4420d.f4519l = typedArray.getString(index);
                        c0059a.c(90, aVar.f4420d.f4519l);
                        if (aVar.f4420d.f4519l.indexOf("/") > 0) {
                            aVar.f4420d.f4521n = typedArray.getResourceId(index, -1);
                            c0059a.b(89, aVar.f4420d.f4521n);
                            aVar.f4420d.f4520m = -2;
                            c0059a.b(88, -2);
                            break;
                        } else {
                            aVar.f4420d.f4520m = -1;
                            c0059a.b(88, -1);
                            break;
                        }
                    } else {
                        c cVar2 = aVar.f4420d;
                        cVar2.f4520m = typedArray.getInteger(index, cVar2.f4521n);
                        c0059a.b(88, aVar.f4420d.f4520m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4410g.get(index));
                    break;
                case 93:
                    c0059a.b(93, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4451N));
                    break;
                case 94:
                    c0059a.b(94, typedArray.getDimensionPixelSize(index, aVar.f4421e.f4458U));
                    break;
                case 95:
                    o(c0059a, typedArray, index, 0);
                    break;
                case 96:
                    o(c0059a, typedArray, index, 1);
                    break;
                case 97:
                    c0059a.b(97, typedArray.getInt(index, aVar.f4421e.f4497q0));
                    break;
                case 98:
                    if (AbstractC0572b.f13280e) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f4417a);
                        aVar.f4417a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f4418b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f4418b = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f4417a = typedArray.getResourceId(index, aVar.f4417a);
                        break;
                    }
                case 99:
                    c0059a.d(99, typedArray.getBoolean(index, aVar.f4421e.f4480i));
                    break;
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    void d(ConstraintLayout constraintLayout, boolean z3) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f4416e.keySet());
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!this.f4416e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + AbstractC0571a.a(childAt));
            } else {
                if (this.f4415d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f4416e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.f4416e.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f4421e.f4483j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(aVar.f4421e.f4479h0);
                                barrier.setMargin(aVar.f4421e.f4481i0);
                                barrier.setAllowsGoneWidget(aVar.f4421e.f4495p0);
                                b bVar = aVar.f4421e;
                                int[] iArr = bVar.f4485k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f4487l0;
                                    if (str != null) {
                                        bVar.f4485k0 = i(barrier, str);
                                        barrier.setReferencedIds(aVar.f4421e.f4485k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.validate();
                            aVar.b(bVar2);
                            if (z3) {
                                androidx.constraintlayout.widget.a.c(childAt, aVar.f4423g);
                            }
                            childAt.setLayoutParams(bVar2);
                            C0060d c0060d = aVar.f4419c;
                            if (c0060d.f4524c == 0) {
                                childAt.setVisibility(c0060d.f4523b);
                            }
                            childAt.setAlpha(aVar.f4419c.f4525d);
                            childAt.setRotation(aVar.f4422f.f4529b);
                            childAt.setRotationX(aVar.f4422f.f4530c);
                            childAt.setRotationY(aVar.f4422f.f4531d);
                            childAt.setScaleX(aVar.f4422f.f4532e);
                            childAt.setScaleY(aVar.f4422f.f4533f);
                            e eVar = aVar.f4422f;
                            if (eVar.f4536i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f4422f.f4536i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f4534g)) {
                                    childAt.setPivotX(aVar.f4422f.f4534g);
                                }
                                if (!Float.isNaN(aVar.f4422f.f4535h)) {
                                    childAt.setPivotY(aVar.f4422f.f4535h);
                                }
                            }
                            childAt.setTranslationX(aVar.f4422f.f4537j);
                            childAt.setTranslationY(aVar.f4422f.f4538k);
                            childAt.setTranslationZ(aVar.f4422f.f4539l);
                            e eVar2 = aVar.f4422f;
                            if (eVar2.f4540m) {
                                childAt.setElevation(eVar2.f4541n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.f4416e.get(num);
            if (aVar2 != null) {
                if (aVar2.f4421e.f4483j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f4421e;
                    int[] iArr2 = bVar3.f4485k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f4487l0;
                        if (str2 != null) {
                            bVar3.f4485k0 = i(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f4421e.f4485k0);
                        }
                    }
                    barrier2.setType(aVar2.f4421e.f4479h0);
                    barrier2.setMargin(aVar2.f4421e.f4481i0);
                    ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.m();
                    aVar2.b(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (aVar2.f4421e.f4464a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.b(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof androidx.constraintlayout.widget.b) {
                ((androidx.constraintlayout.widget.b) childAt2).d(constraintLayout);
            }
        }
    }

    public void e(int i3, int i4) {
        a aVar;
        if (!this.f4416e.containsKey(Integer.valueOf(i3)) || (aVar = (a) this.f4416e.get(Integer.valueOf(i3))) == null) {
            return;
        }
        switch (i4) {
            case 1:
                b bVar = aVar.f4421e;
                bVar.f4484k = -1;
                bVar.f4482j = -1;
                bVar.f4445H = -1;
                bVar.f4452O = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = aVar.f4421e;
                bVar2.f4488m = -1;
                bVar2.f4486l = -1;
                bVar2.f4446I = -1;
                bVar2.f4454Q = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = aVar.f4421e;
                bVar3.f4492o = -1;
                bVar3.f4490n = -1;
                bVar3.f4447J = 0;
                bVar3.f4453P = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = aVar.f4421e;
                bVar4.f4494p = -1;
                bVar4.f4496q = -1;
                bVar4.f4448K = 0;
                bVar4.f4455R = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = aVar.f4421e;
                bVar5.f4498r = -1;
                bVar5.f4499s = -1;
                bVar5.f4500t = -1;
                bVar5.f4451N = 0;
                bVar5.f4458U = Integer.MIN_VALUE;
                return;
            case 6:
                b bVar6 = aVar.f4421e;
                bVar6.f4501u = -1;
                bVar6.f4502v = -1;
                bVar6.f4450M = 0;
                bVar6.f4457T = Integer.MIN_VALUE;
                return;
            case 7:
                b bVar7 = aVar.f4421e;
                bVar7.f4503w = -1;
                bVar7.f4504x = -1;
                bVar7.f4449L = 0;
                bVar7.f4456S = Integer.MIN_VALUE;
                return;
            case 8:
                b bVar8 = aVar.f4421e;
                bVar8.f4441D = -1.0f;
                bVar8.f4440C = -1;
                bVar8.f4439B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void f(Context context, int i3) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i3, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f4416e.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f4415d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4416e.containsKey(Integer.valueOf(id))) {
                this.f4416e.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.f4416e.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f4423g = androidx.constraintlayout.widget.a.a(this.f4414c, childAt);
                aVar.d(id, bVar);
                aVar.f4419c.f4523b = childAt.getVisibility();
                aVar.f4419c.f4525d = childAt.getAlpha();
                aVar.f4422f.f4529b = childAt.getRotation();
                aVar.f4422f.f4530c = childAt.getRotationX();
                aVar.f4422f.f4531d = childAt.getRotationY();
                aVar.f4422f.f4532e = childAt.getScaleX();
                aVar.f4422f.f4533f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f4422f;
                    eVar.f4534g = pivotX;
                    eVar.f4535h = pivotY;
                }
                aVar.f4422f.f4537j = childAt.getTranslationX();
                aVar.f4422f.f4538k = childAt.getTranslationY();
                aVar.f4422f.f4539l = childAt.getTranslationZ();
                e eVar2 = aVar.f4422f;
                if (eVar2.f4540m) {
                    eVar2.f4541n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f4421e.f4495p0 = barrier.getAllowsGoneWidget();
                    aVar.f4421e.f4485k0 = barrier.getReferencedIds();
                    aVar.f4421e.f4479h0 = barrier.getType();
                    aVar.f4421e.f4481i0 = barrier.getMargin();
                }
            }
        }
    }

    public void h(int i3, int i4, int i5, float f3) {
        b bVar = k(i3).f4421e;
        bVar.f4439B = i4;
        bVar.f4440C = i5;
        bVar.f4441D = f3;
    }

    public void l(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a j3 = j(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        j3.f4421e.f4464a = true;
                    }
                    this.f4416e.put(Integer.valueOf(j3.f4417a), j3);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cf, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.m(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
