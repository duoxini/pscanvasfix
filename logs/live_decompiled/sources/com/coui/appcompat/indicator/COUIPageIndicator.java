package com.coui.appcompat.indicator;

import B.e;
import B.f;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.PathInterpolator;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class COUIPageIndicator extends View {

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f7980v;

    /* renamed from: w, reason: collision with root package name */
    private static final PathInterpolator f7981w;

    /* renamed from: x, reason: collision with root package name */
    private static final ArgbEvaluator f7982x;

    /* renamed from: e, reason: collision with root package name */
    private final int f7983e;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f7984f;

    /* renamed from: g, reason: collision with root package name */
    private d f7985g;

    /* renamed from: h, reason: collision with root package name */
    private int f7986h;

    /* renamed from: i, reason: collision with root package name */
    private int f7987i;

    /* renamed from: j, reason: collision with root package name */
    private float f7988j;

    /* renamed from: k, reason: collision with root package name */
    private float f7989k;

    /* renamed from: l, reason: collision with root package name */
    private float f7990l;

    /* renamed from: m, reason: collision with root package name */
    private float f7991m;

    /* renamed from: n, reason: collision with root package name */
    private float f7992n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7993o;

    /* renamed from: p, reason: collision with root package name */
    private long f7994p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f7995q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f7996r;

    /* renamed from: s, reason: collision with root package name */
    private int f7997s;

    /* renamed from: t, reason: collision with root package name */
    private b f7998t;

    /* renamed from: u, reason: collision with root package name */
    private String f7999u;

    public interface b {
        void a(int i3);
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        protected int f8002a;

        /* renamed from: b, reason: collision with root package name */
        protected int f8003b;

        /* renamed from: c, reason: collision with root package name */
        protected float f8004c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        protected float f8005d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        protected float f8006e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        protected float f8007f = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        protected RectF f8008g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

        c(int i3) {
            this.f8003b = i3;
        }

        private void k() {
            RectF rectF = this.f8008g;
            float f3 = this.f8007f;
            float f4 = this.f8005d;
            float f5 = this.f8004c;
            float f6 = this.f8006e;
            rectF.set((f3 + f4) - f5, f6 - f5, f3 + f4 + f5, f6 + f5);
        }

        public void a() {
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "id = " + this.f8003b + " dot = (" + this.f8005d + ", " + this.f8006e + ", " + this.f8004c + ") bounds = " + this.f8008g + " offsetX = " + this.f8007f);
        }

        public RectF b() {
            return this.f8008g;
        }

        public float c() {
            return this.f8005d;
        }

        public float d() {
            return this.f8006e;
        }

        public float e() {
            return this.f8004c;
        }

        public void f(Canvas canvas, Paint paint) {
            paint.setColor(this.f8002a);
            float f3 = this.f8005d;
            float f4 = this.f8004c;
            float f5 = this.f8006e;
            canvas.drawOval(f3 - f4, f5 - f4, f3 + f4, f5 + f4, paint);
        }

        public void g(float f3) {
            this.f8005d = f3;
            k();
        }

        public void h(float f3) {
            this.f8006e = f3;
            k();
        }

        public void i(int i3) {
            this.f8002a = i3;
        }

        public void j(float f3) {
            this.f8007f = f3;
            k();
        }
    }

    private class d {

        /* renamed from: A, reason: collision with root package name */
        private int f8009A;

        /* renamed from: f, reason: collision with root package name */
        private final float[] f8016f;

        /* renamed from: g, reason: collision with root package name */
        private final float[] f8017g;

        /* renamed from: h, reason: collision with root package name */
        private final float[] f8018h;

        /* renamed from: q, reason: collision with root package name */
        private View f8027q;

        /* renamed from: s, reason: collision with root package name */
        private int f8029s;

        /* renamed from: t, reason: collision with root package name */
        private float f8030t;

        /* renamed from: u, reason: collision with root package name */
        private float f8031u;

        /* renamed from: x, reason: collision with root package name */
        private float f8034x;

        /* renamed from: y, reason: collision with root package name */
        private e f8035y;

        /* renamed from: a, reason: collision with root package name */
        private final LinkedList f8011a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        private final int f8012b = 6;

        /* renamed from: c, reason: collision with root package name */
        private final Path f8013c = new Path();

        /* renamed from: d, reason: collision with root package name */
        private final RectF f8014d = new RectF();

        /* renamed from: e, reason: collision with root package name */
        private final float[] f8015e = new float[2];

        /* renamed from: i, reason: collision with root package name */
        private final Path f8019i = new Path();

        /* renamed from: j, reason: collision with root package name */
        private final Path f8020j = new Path();

        /* renamed from: k, reason: collision with root package name */
        private final Path f8021k = new Path();

        /* renamed from: l, reason: collision with root package name */
        private final Path f8022l = new Path();

        /* renamed from: m, reason: collision with root package name */
        private final Path f8023m = new Path();

        /* renamed from: n, reason: collision with root package name */
        private final Matrix f8024n = new Matrix();

        /* renamed from: o, reason: collision with root package name */
        private final Matrix f8025o = new Matrix();

        /* renamed from: p, reason: collision with root package name */
        private final B.c f8026p = new a("currentPosition");

        /* renamed from: r, reason: collision with root package name */
        private int f8028r = 0;

        /* renamed from: v, reason: collision with root package name */
        private float f8032v = 0.0f;

        /* renamed from: w, reason: collision with root package name */
        private float f8033w = 0.0f;

        /* renamed from: z, reason: collision with root package name */
        private boolean f8036z = false;

        class a extends B.c {
            a(String str) {
                super(str);
            }

            @Override // B.c
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public float a(d dVar) {
                return dVar.k();
            }

            @Override // B.c
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(d dVar, float f3) {
                int floor = (int) Math.floor(f3);
                dVar.v(floor, f3 - floor);
            }
        }

        d(View view) {
            this.f8027q = view;
            this.f8016f = new float[]{0.0f, r6, r6, r6 - ((9.0f - r4[2]) / 2.0f)};
            float[] fArr = {3.0f, 5.0f, 7.0f, 9.0f};
            this.f8017g = fArr;
            this.f8018h = new float[]{COUIPageIndicator.this.f7988j / 2.0f, COUIPageIndicator.this.f7989k / 2.0f, COUIPageIndicator.this.f7990l / 2.0f, 0.0f};
            float f3 = 0.0f - ((5.0f - fArr[0]) / 2.0f);
            float f4 = f3 - ((7.0f - fArr[1]) / 2.0f);
            this.f8034x = 0.0f;
            this.f8031u = COUIPageIndicator.this.f7991m * 2.0f;
            q();
        }

        private void f(Canvas canvas) {
            this.f8024n.reset();
            if (COUIPageIndicator.this.isLayoutRtl()) {
                this.f8024n.setTranslate(this.f8015e[0] - this.f8032v, 0.0f);
                Matrix matrix = this.f8024n;
                float[] fArr = this.f8015e;
                float f3 = fArr[0];
                matrix.postRotate(180.0f, f3 + ((fArr[1] - f3) / 2.0f), COUIPageIndicator.this.f7988j / 2.0f);
            } else {
                this.f8024n.setTranslate((-this.f8015e[0]) + this.f8032v, 0.0f);
            }
            canvas.setMatrix(this.f8024n);
            this.f8024n.invert(this.f8025o);
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "draw rect bounds = " + Arrays.toString(this.f8015e) + " horizontalOffset = " + this.f8032v);
        }

        private void g(Canvas canvas) {
            int i3;
            Iterator it = this.f8011a.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                int indexOf = this.f8011a.indexOf(cVar);
                if (this.f8030t == 0.0f || (indexOf != (i3 = this.f8029s) && indexOf - 1 != i3)) {
                    float f3 = cVar.f8005d;
                    float f4 = cVar.f8004c;
                    float f5 = f3 + f4;
                    float[] fArr = this.f8015e;
                    if (f5 >= fArr[0] && f3 - f4 <= fArr[1]) {
                        AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "drawDots: dot index = " + indexOf + " dot radius = " + cVar.f8004c + " dot location = (" + cVar.f8005d + ", " + cVar.f8006e + ") left = " + this.f8015e[0] + " right = " + this.f8015e[1]);
                        if (indexOf == this.f8029s) {
                            cVar.i(COUIPageIndicator.this.f7986h);
                        } else {
                            cVar.i(COUIPageIndicator.this.f7987i);
                        }
                        cVar.f(canvas, COUIPageIndicator.this.f7995q);
                    }
                }
            }
        }

        private void h(Canvas canvas) {
            float j3 = j();
            if (j3 == 1.0f) {
                COUIPageIndicator.this.f7996r.setColor(COUIPageIndicator.this.f7986h);
                canvas.drawPath(this.f8019i, COUIPageIndicator.this.f7996r);
                return;
            }
            if (this.f8030t <= 0.5f) {
                COUIPageIndicator.this.f7996r.setColor(COUIPageIndicator.this.f7986h);
                canvas.drawPath(this.f8020j, COUIPageIndicator.this.f7996r);
                COUIPageIndicator.this.f7996r.setColor(((Integer) COUIPageIndicator.f7982x.evaluate(j3, Integer.valueOf(COUIPageIndicator.this.f7987i), Integer.valueOf(COUIPageIndicator.this.f7986h))).intValue());
            } else {
                COUIPageIndicator.this.f7996r.setColor(((Integer) COUIPageIndicator.f7982x.evaluate(j3, Integer.valueOf(COUIPageIndicator.this.f7987i), Integer.valueOf(COUIPageIndicator.this.f7986h))).intValue());
                canvas.drawPath(this.f8020j, COUIPageIndicator.this.f7996r);
                COUIPageIndicator.this.f7996r.setColor(COUIPageIndicator.this.f7986h);
            }
            canvas.drawPath(this.f8021k, COUIPageIndicator.this.f7996r);
        }

        private float j() {
            float f3 = this.f8030t;
            if (f3 <= 0.05f) {
                return f3 / 0.05f;
            }
            if (f3 >= 0.95f) {
                return (1.0f - f3) / 0.05f;
            }
            return 1.0f;
        }

        private float m(int i3, float f3) {
            if (i3 == 0) {
                return this.f8018h[i3];
            }
            float f4 = this.f8016f[0];
            if (f3 < f4) {
                if (this.f8036z) {
                    float[] fArr = this.f8018h;
                    float f5 = fArr[i3];
                    int i4 = i3 - 1;
                    float f6 = fArr[i4];
                    float interpolation = COUIPageIndicator.f7981w.getInterpolation(f3 - this.f8016f[i3]);
                    float[] fArr2 = this.f8016f;
                    return Math.max(f5, f6 - (((f6 - f5) * 2.0f) * (1.0f - (interpolation / (fArr2[i4] - fArr2[i3])))));
                }
                float[] fArr3 = this.f8018h;
                int i5 = i3 - 1;
                float f7 = fArr3[i5];
                float f8 = fArr3[i3];
                float interpolation2 = (f7 - f8) * 2.0f * COUIPageIndicator.f7981w.getInterpolation(f3 - this.f8016f[i3]);
                float[] fArr4 = this.f8016f;
                return Math.min(f7, f8 + (interpolation2 / (fArr4[i5] - fArr4[i3])));
            }
            if (f3 <= f4 + this.f8017g[0]) {
                return 0.0f;
            }
            if (this.f8036z) {
                float[] fArr5 = this.f8018h;
                int i6 = i3 - 1;
                float f9 = fArr5[i6];
                float f10 = fArr5[i3];
                float interpolation3 = (f9 - f10) * 2.0f * COUIPageIndicator.f7981w.getInterpolation((this.f8016f[i3] + this.f8017g[i3]) - f3);
                float[] fArr6 = this.f8016f;
                float f11 = fArr6[i3];
                float[] fArr7 = this.f8017g;
                return Math.min(f9, f10 + (interpolation3 / (((f11 + fArr7[i3]) - fArr6[i6]) - fArr7[i6])));
            }
            float[] fArr8 = this.f8018h;
            float f12 = fArr8[i3];
            int i7 = i3 - 1;
            float f13 = fArr8[i7];
            float interpolation4 = COUIPageIndicator.f7981w.getInterpolation((this.f8016f[i3] + this.f8017g[i3]) - f3);
            float[] fArr9 = this.f8016f;
            float f14 = fArr9[i3];
            float[] fArr10 = this.f8017g;
            return Math.max(f12, f13 - (((f13 - f12) * 2.0f) * (1.0f - (interpolation4 / (((f14 + fArr10[i3]) - fArr9[i7]) - fArr10[i7])))));
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private float n() {
            /*
                r7 = this;
                float r0 = r7.f8030t
                r1 = 1028443341(0x3d4ccccd, float:0.05)
                int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                r3 = 1073741824(0x40000000, float:2.0)
                r4 = 1055286886(0x3ee66666, float:0.45)
                r5 = 1056964608(0x3f000000, float:0.5)
                if (r2 <= 0) goto L22
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 > 0) goto L22
                android.view.animation.PathInterpolator r0 = com.coui.appcompat.indicator.COUIPageIndicator.a()
                float r2 = r7.f8030t
                float r2 = r2 - r1
                float r2 = r2 / r4
                float r0 = r0.getInterpolation(r2)
            L20:
                float r0 = r0 / r3
                goto L3e
            L22:
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 <= 0) goto L3d
                r2 = 1064514355(0x3f733333, float:0.95)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L3d
                android.view.animation.PathInterpolator r0 = com.coui.appcompat.indicator.COUIPageIndicator.a()
                r2 = 1065353216(0x3f800000, float:1.0)
                float r6 = r7.f8030t
                float r2 = r2 - r6
                float r2 = r2 - r1
                float r2 = r2 / r4
                float r0 = r0.getInterpolation(r2)
                goto L20
            L3d:
                r0 = 0
            L3e:
                com.coui.appcompat.indicator.COUIPageIndicator r1 = com.coui.appcompat.indicator.COUIPageIndicator.this
                float r1 = com.coui.appcompat.indicator.COUIPageIndicator.b(r1)
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 >= 0) goto L4f
                com.coui.appcompat.indicator.COUIPageIndicator r7 = com.coui.appcompat.indicator.COUIPageIndicator.this
                float r0 = com.coui.appcompat.indicator.COUIPageIndicator.b(r7)
                goto L63
            L4f:
                com.coui.appcompat.indicator.COUIPageIndicator r1 = com.coui.appcompat.indicator.COUIPageIndicator.this
                float r1 = com.coui.appcompat.indicator.COUIPageIndicator.b(r1)
                float r1 = r5 - r1
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 <= 0) goto L63
                com.coui.appcompat.indicator.COUIPageIndicator r7 = com.coui.appcompat.indicator.COUIPageIndicator.this
                float r7 = com.coui.appcompat.indicator.COUIPageIndicator.b(r7)
                float r0 = r5 - r7
            L63:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.indicator.COUIPageIndicator.d.n():float");
        }

        private float o(int i3) {
            float f3 = i3 - this.f8034x;
            int i4 = 0;
            while (true) {
                float[] fArr = this.f8016f;
                if (i4 >= fArr.length) {
                    return 0.0f;
                }
                float f4 = fArr[i4];
                if (f3 >= f4 && f3 <= f4 + this.f8017g[i4]) {
                    float m3 = m(i4, f3);
                    AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "index, mMaskOffset = " + i3 + " " + this.f8034x + " level = " + i4 + " dot position = " + f3 + " size = " + m3 + " moving to end = " + this.f8036z);
                    return m3;
                }
                i4++;
            }
        }

        private void q() {
            f fVar = new f();
            fVar.d(1.0f);
            fVar.f(1500.0f);
            e eVar = new e(this, this.f8026p);
            this.f8035y = eVar;
            eVar.t(fVar);
            this.f8035y.i(0.005f);
        }

        private void r(float[] fArr) {
            this.f8025o.mapPoints(fArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0203 A[LOOP:0: B:33:0x01fd->B:35:0x0203, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0148  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void v(int r19, float r20) {
            /*
                Method dump skipped, instructions count: 574
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.indicator.COUIPageIndicator.d.v(int, float):void");
        }

        private void w() {
            if (this.f8029s >= this.f8011a.size() - 1) {
                return;
            }
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "updatePath: mCurrentOffset = " + this.f8030t + " dots size = " + this.f8011a.size());
            c cVar = (c) this.f8011a.get(this.f8029s);
            c cVar2 = (c) this.f8011a.get(this.f8029s + 1);
            float c3 = cVar.c();
            float d3 = cVar.d();
            float e3 = cVar.e();
            float c4 = cVar2.c();
            float d4 = cVar2.d();
            float e4 = cVar2.e();
            float j3 = j();
            float n3 = n();
            float f3 = this.f8030t;
            float f4 = f3 <= 0.5f ? n3 * 2.0f * (this.f8031u + e4 + e3) : 0.0f;
            float f5 = f3 > 0.5f ? n3 * 2.0f * (this.f8031u + e4 + e3) : 0.0f;
            float f6 = c3 + f4;
            float f7 = 0.5f - n3;
            float f8 = f6 + (e3 * f7 * 2.0f);
            float sqrt = (float) (d3 - Math.sqrt(r20 - (((((e3 * 2.0f) * f7) * 2.0f) * e3) * f7)));
            float f9 = c4 - f5;
            float f10 = f9 - ((e4 * f7) * 2.0f);
            float f11 = f5;
            float sqrt2 = (float) (d4 - Math.sqrt((e4 * e4) - (((((e4 * 2.0f) * f7) * 2.0f) * e4) * f7)));
            float f12 = (f8 + f10) / 2.0f;
            float f13 = (((e3 * e3) - (((f12 - c3) - f4) * ((f8 - c3) - f4))) / (sqrt - d3)) + d3;
            float asin = (float) ((Math.asin(f7 * 2.0f) * 180.0d) / 3.141592653589793d);
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "updatePath: mCurrentOffset = " + this.f8030t + " dots size = " + this.f8011a.size() + " startDot = (" + c3 + ", " + d3 + ", " + e3 + ") endDot = (" + c4 + ", " + d4 + ", " + e4 + ") colorFactor = " + j3 + " moveFactor = " + n3 + " mDepartOffset = " + f4 + " mPortOffset = " + f11 + ") control1 = (" + f8 + ", " + sqrt + ") control2 = (" + f12 + ", " + f13 + ") control3 = (" + f10 + ", " + sqrt2 + ") snapAngle = " + asin);
            this.f8019i.reset();
            Path path = this.f8019i;
            float f14 = c3 - e3;
            float f15 = c4 + e4;
            float f16 = COUIPageIndicator.this.f7988j;
            Path.Direction direction = Path.Direction.CW;
            path.addRect(f14, 0.0f, f15, f16, direction);
            this.f8013c.reset();
            this.f8013c.moveTo(f14, 0.0f);
            this.f8013c.lineTo(f15, 0.0f);
            this.f8013c.lineTo(f15, COUIPageIndicator.this.f7988j);
            this.f8013c.lineTo(f14, COUIPageIndicator.this.f7988j);
            this.f8013c.close();
            this.f8022l.reset();
            this.f8022l.moveTo(f14, d3);
            float f17 = d3 - e3;
            float f18 = c3 + e3;
            float f19 = e3 + d3;
            this.f8022l.arcTo(f14, f17, f18, f19, 180.0f, 90.0f, false);
            this.f8022l.lineTo(f6, f17);
            float f20 = f14 + f4;
            float f21 = f18 + f4;
            this.f8022l.arcTo(f20, f17, f21, f19, 270.0f, asin, false);
            this.f8022l.quadTo(f12, f13, f10, sqrt2);
            float f22 = c4 - e4;
            float f23 = f22 - f11;
            float f24 = d4 - e4;
            float f25 = f15 - f11;
            float f26 = d4 + e4;
            this.f8022l.arcTo(f23, f24, f25, f26, 270.0f - asin, asin, false);
            this.f8022l.lineTo(c4, f24);
            this.f8022l.arcTo(f22, f24, f15, f26, 270.0f, 90.0f, false);
            this.f8022l.lineTo(f15, 0.0f);
            this.f8022l.lineTo(f14, 0.0f);
            this.f8022l.close();
            this.f8023m.reset();
            this.f8023m.moveTo(f15, d4);
            this.f8023m.arcTo(f22, f24, f15, f26, 0.0f, 90.0f, false);
            this.f8023m.lineTo(f9, f26);
            this.f8023m.arcTo(f23, f24, f25, f26, 90.0f, asin, false);
            this.f8023m.quadTo(f12, (d4 * 2.0f) - f13, f8, (d3 * 2.0f) - sqrt);
            this.f8023m.arcTo(f20, f17, f21, f19, 90.0f - asin, asin, false);
            this.f8023m.lineTo(c3, f19);
            this.f8023m.arcTo(f14, f17, f18, f19, 90.0f, 90.0f, false);
            this.f8023m.lineTo(f14, COUIPageIndicator.this.f7988j);
            this.f8023m.lineTo(f15, COUIPageIndicator.this.f7988j);
            this.f8023m.close();
            Path path2 = this.f8019i;
            Path path3 = this.f8022l;
            Path.Op op = Path.Op.DIFFERENCE;
            path2.op(path3, op);
            this.f8019i.op(this.f8023m, op);
            this.f8020j.reset();
            this.f8021k.reset();
            this.f8020j.addRect(f14, 0.0f, f12 + 0.5f, COUIPageIndicator.this.f7988j, direction);
            this.f8021k.addRect(f12, 0.0f, f15, COUIPageIndicator.this.f7988j, direction);
            Path path4 = this.f8020j;
            Path path5 = this.f8019i;
            Path.Op op2 = Path.Op.INTERSECT;
            path4.op(path5, op2);
            this.f8021k.op(this.f8019i, op2);
        }

        private void x(boolean z3) {
            if (z3) {
                if (this.f8028r >= 6) {
                    this.f8034x = Math.max(0.0f, this.f8034x - 1.0f);
                } else {
                    this.f8034x = 0.0f;
                }
            }
            if (this.f8028r < 6) {
                this.f8017g[0] = 5.0f;
            } else {
                this.f8017g[0] = 3.0f;
            }
        }

        public void e(int i3) {
            c cVar = new c(i3);
            cVar.i(COUIPageIndicator.this.f7987i);
            cVar.g(COUIPageIndicator.this.f7988j / 2.0f);
            cVar.h(COUIPageIndicator.this.f7988j / 2.0f);
            this.f8011a.add(cVar);
            this.f8028r = this.f8011a.size();
            x(false);
            v(this.f8029s, this.f8030t);
            this.f8027q.requestLayout();
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "addDot: current index = " + this.f8029s + " mCurrentOffset = " + this.f8030t);
            cVar.a();
        }

        public int i(float f3, float f4) {
            float[] fArr = {f3, f4};
            r(fArr);
            Iterator it = this.f8011a.iterator();
            float f5 = -1.0f;
            int i3 = -1;
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.b().contains(fArr[0], fArr[1])) {
                    return this.f8011a.indexOf(cVar);
                }
                float abs = COUIPageIndicator.this.isLayoutRtl() ? Math.abs(fArr[0] - (cVar.b().centerX() - (cVar.b().width() / 2.0f))) : Math.abs(fArr[0] - cVar.b().centerX());
                if (i3 == -1 || abs < f5) {
                    i3 = this.f8011a.indexOf(cVar);
                    f5 = abs;
                }
            }
            return i3;
        }

        public float k() {
            return this.f8029s + this.f8030t;
        }

        public int l() {
            return this.f8028r;
        }

        public RectF p() {
            this.f8014d.set(0.0f, 0.0f, Math.min(6, this.f8028r) * (this.f8031u + COUIPageIndicator.this.f7988j), COUIPageIndicator.this.f7988j);
            return this.f8014d;
        }

        public void s(Canvas canvas) {
            canvas.save();
            f(canvas);
            g(canvas);
            if (this.f8030t != 0.0f) {
                h(canvas);
            }
            canvas.restore();
        }

        public void t() {
            if (this.f8011a.size() == 0) {
                AbstractC0371a.c("COUIPageIndicator", "The mDots has no data");
                return;
            }
            this.f8011a.removeLast();
            int size = this.f8011a.size();
            this.f8028r = size;
            if (this.f8029s + this.f8030t > size - 1) {
                this.f8029s = size - 1;
                this.f8030t = 0.0f;
            }
            x(true);
            v(this.f8029s, this.f8030t);
            this.f8027q.requestLayout();
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "removeDot: current index = " + this.f8029s + " currentOffset = " + this.f8030t + " count = " + this.f8028r);
        }

        public void u(int i3, float f3, boolean z3) {
            AbstractC0371a.b(COUIPageIndicator.f7980v, "COUIPageIndicator", "setCurrentPosition: position: " + i3 + " offset: " + f3 + " animate: " + z3);
            if (!z3) {
                v(i3, f3);
            } else {
                this.f8035y.k(k());
                this.f8035y.p(i3 + f3);
            }
        }
    }

    static {
        f7980v = AbstractC0371a.f11873b || AbstractC0371a.e("COUIPageIndicator", 3);
        f7981w = new Y.b();
        f7982x = new ArgbEvaluator();
    }

    public COUIPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R1.a.f2052a);
    }

    private void n() {
        this.f7985g = new d(this);
    }

    private void o() {
        Paint paint = new Paint(1);
        this.f7995q = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f7996r = paint2;
        paint2.setColor(this.f7986h);
    }

    @Override // android.view.View
    public boolean callOnClick() {
        b bVar;
        if (this.f7993o && (bVar = this.f7998t) != null) {
            d dVar = this.f7985g;
            float[] fArr = this.f7984f;
            bVar.a(dVar.i(fArr[0], fArr[1]));
        }
        invalidate();
        return super.callOnClick();
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        StringBuilder sb = new StringBuilder();
        String string = getResources().getString(R1.c.f2054a);
        if (!TextUtils.isEmpty(this.f7999u)) {
            string = this.f7999u;
        }
        sb.append(string);
        sb.append(", ");
        int i3 = this.f7985g.f8009A + 1;
        sb.append(getResources().getQuantityString(this.f7997s, i3, Integer.valueOf(i3), Integer.valueOf(this.f7985g.f8011a.size()), Integer.valueOf(this.f7985g.f8011a.size())));
        sb.append(", ");
        sb.append(getResources().getString(R1.c.f2055b));
        return sb.toString();
    }

    public int getDotsCount() {
        return this.f7985g.l();
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    public void m() {
        d dVar = this.f7985g;
        dVar.e(dVar.l());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7985g.s(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        RectF p3 = this.f7985g.p();
        setMeasuredDimension((int) Math.ceil(p3.width()), (int) Math.ceil(p3.height()));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setDotsCount(aVar.f8000e);
        float f3 = aVar.f8001f;
        int i3 = (int) f3;
        s(i3, f3 - i3);
        if (f7980v) {
            Log.d("COUIPageIndicator", "onRestoreInstanceState dotsCount = " + aVar.f8000e + " currentPosition = " + aVar.f8001f);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f8000e = this.f7985g.l();
        aVar.f8001f = this.f7985g.k();
        if (f7980v) {
            Log.d("COUIPageIndicator", "onSaveInstanceState dotsCount = " + aVar.f8000e + " currentPosition = " + aVar.f8001f);
        }
        return aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7994p = System.currentTimeMillis();
        } else if (actionMasked == 1 && System.currentTimeMillis() - this.f7994p <= ViewConfiguration.getTapTimeout()) {
            this.f7984f[0] = motionEvent.getX();
            this.f7984f[1] = motionEvent.getY();
            callOnClick();
        }
        return true;
    }

    public void p(int i3, float f3, int i4) {
        s(i3, f3);
    }

    public void q(int i3) {
        this.f7985g.f8009A = i3;
    }

    public void r() {
        this.f7985g.t();
    }

    public void s(int i3, float f3) {
        t(i3, f3, false);
    }

    public void setCurrentPosition(int i3) {
        s(i3, 0.0f);
    }

    @Deprecated
    public void setDotCornerRadius(int i3) {
    }

    @Deprecated
    public void setDotSpacing(int i3) {
    }

    @Deprecated
    public void setDotStrokeWidth(int i3) {
    }

    public void setDotsCount(int i3) {
        int dotsCount = i3 - getDotsCount();
        for (int i4 = 0; i4 < Math.abs(dotsCount); i4++) {
            if (dotsCount > 0) {
                m();
            } else {
                r();
            }
        }
    }

    public void setIndicatorDescriptionID(int i3) {
        try {
            getResources().getQuantityString(this.f7997s, 1, 1, 1, 1);
            this.f7997s = i3;
        } catch (Exception e3) {
            AbstractC0371a.c("COUIPageIndicator", "setIndicatorDescriptionID indicatorDescriptionID error :" + e3.getMessage());
        }
    }

    public void setIsClickable(boolean z3) {
        this.f7993o = z3;
    }

    public void setOnDotClickListener(b bVar) {
        this.f7998t = bVar;
    }

    public void setPageIndicatorDotsColor(int i3) {
        this.f7987i = i3;
        this.f7995q.setColor(i3);
        invalidate();
    }

    public void setStartContentDescription(String str) {
        this.f7999u = str;
    }

    public void setTraceDotColor(int i3) {
        this.f7986h = i3;
        this.f7996r.setColor(i3);
        invalidate();
    }

    public void t(int i3, float f3, boolean z3) {
        this.f7985g.u(i3, f3, z3);
        invalidate();
    }

    public COUIPageIndicator(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, AbstractC0335a.j(context) ? R1.d.f2057b : R1.d.f2056a);
    }

    static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0103a();

        /* renamed from: e, reason: collision with root package name */
        int f8000e;

        /* renamed from: f, reason: collision with root package name */
        float f8001f;

        /* renamed from: com.coui.appcompat.indicator.COUIPageIndicator$a$a, reason: collision with other inner class name */
        class C0103a implements Parcelable.Creator {
            C0103a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel, a.class.getClassLoader());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8000e = 0;
            this.f8001f = 0.0f;
            c(parcel);
        }

        private void c(Parcel parcel) {
            this.f8000e = parcel.readInt();
            this.f8001f = parcel.readFloat();
        }

        public String toString() {
            return "IndicatorSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "mDotsCount = " + this.f8000e + " mCurrentPosition = " + this.f8001f + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f8000e);
            parcel.writeFloat(this.f8001f);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
            this.f8000e = 0;
            this.f8001f = 0.0f;
        }
    }

    public COUIPageIndicator(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f7984f = new float[2];
        this.f7992n = 0.005f;
        this.f7994p = 0L;
        this.f7997s = R1.b.f2053a;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7983e = attributeSet.getStyleAttribute();
        } else {
            this.f7983e = i3;
        }
        AbstractC0342a.b(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R1.e.f2058a, i3, i4);
        this.f7986h = obtainStyledAttributes.getColor(R1.e.f2065h, 0);
        this.f7987i = obtainStyledAttributes.getColor(R1.e.f2060c, 0);
        this.f7988j = obtainStyledAttributes.getDimension(R1.e.f2061d, 0.0f);
        this.f7989k = obtainStyledAttributes.getDimension(R1.e.f2062e, 0.0f);
        this.f7990l = obtainStyledAttributes.getDimension(R1.e.f2063f, 0.0f);
        this.f7991m = obtainStyledAttributes.getDimension(R1.e.f2064g, 0.0f);
        this.f7993o = obtainStyledAttributes.getBoolean(R1.e.f2059b, true);
        obtainStyledAttributes.recycle();
        n();
        o();
        setFocusable(false);
    }
}
