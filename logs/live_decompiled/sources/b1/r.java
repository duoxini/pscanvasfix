package B1;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemProperties;
import android.util.Log;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.List;
import u1.C0600c;
import y1.u;

/* loaded from: classes.dex */
public class r implements m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f242a = "r";

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f243b = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0257, code lost:
    
        if (r6 <= 0.0f) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0259, code lost:
    
        r11 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x025b, code lost:
    
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0271, code lost:
    
        if ((r6 - r10[r10.length - 1]) <= 0.0f) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0338  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Rect i(int r17, android.graphics.Rect r18, float r19, float r20, java.lang.String r21, java.lang.String r22, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r23) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.r.i(int, android.graphics.Rect, float, float, java.lang.String, java.lang.String, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):android.graphics.Rect");
    }

    private void j(int i3, List list, String str, String str2, float f3, float f4, ContainerView containerView) {
        if (i3 != containerView.getLastDragMode()) {
            containerView.getCanvasMaskListView().D(150L);
        }
        u uVar = (u) list.get(0);
        u uVar2 = (u) list.get(1);
        containerView.setLastFirstText(str);
        containerView.setLastSecondText(str2);
        uVar.o(str);
        uVar2.o(str2);
        if (i3 != 61) {
            if (i3 == 62) {
                uVar2.m(1.0f);
                uVar.m(1.0f);
                uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                return;
            }
            if (i3 == 67) {
                uVar.m(1.0f);
                uVar2.m(1.0f);
                uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                return;
            }
            if (i3 != 68) {
                switch (i3) {
                    case 31:
                        break;
                    case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS /* 32 */:
                        uVar2.m(1.0f);
                        uVar.m(1.0f);
                        uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                        break;
                    case 33:
                    case 34:
                        uVar.m(1.0f);
                        uVar2.m(1.0f);
                        uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                        break;
                    case 35:
                    case 36:
                        uVar2.m(1.0f);
                        uVar.m(1.0f);
                        uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                        break;
                    case 37:
                        uVar.m(1.0f);
                        uVar2.m(1.0f);
                        uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                        break;
                    case 38:
                        break;
                    default:
                        uVar.m(1.0f);
                        uVar2.m(1.0f);
                        break;
                }
            }
            uVar.m(1.0f);
            uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
            containerView.X2(uVar2, uVar, i3, 1);
            return;
        }
        uVar2.m(1.0f);
        uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
        containerView.X2(uVar, uVar2, i3, 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01c9, code lost:
    
        if (r4 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d7, code lost:
    
        if (B1.s.u(r12, r1, r31.getNavigationBarHeight()) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01df, code lost:
    
        if (r5 == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01ed, code lost:
    
        if (B1.s.u(r14, r1, r31.getNavigationBarHeight()) == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010e, code lost:
    
        if (r2 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0114, code lost:
    
        if (r3 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011a, code lost:
    
        if (r3 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
    
        if (r2 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0136, code lost:
    
        if (r4 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0143, code lost:
    
        if (B1.s.u(r12, r1, r31.getNavigationBarHeight()) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x014a, code lost:
    
        if (r5 != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0157, code lost:
    
        if (B1.s.u(r14, r1, r31.getNavigationBarHeight()) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015d, code lost:
    
        if (r2 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0164, code lost:
    
        if (r5 != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0171, code lost:
    
        if (B1.s.u(r14, r1, r31.getNavigationBarHeight()) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0177, code lost:
    
        if (r2 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x017f, code lost:
    
        if (r5 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018c, code lost:
    
        if (B1.s.u(r14, r1, r31.getNavigationBarHeight()) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0194, code lost:
    
        if (r4 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a1, code lost:
    
        if (B1.s.u(r12, r1, r31.getNavigationBarHeight()) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a7, code lost:
    
        if (r3 == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ae, code lost:
    
        if (r4 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01bc, code lost:
    
        if (B1.s.u(r12, r1, r31.getNavigationBarHeight()) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01c2, code lost:
    
        if (r3 == false) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0129  */
    @Override // B1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.List r19, float r20, float r21, float r22, float r23, java.lang.String r24, java.lang.String r25, boolean r26, boolean r27, boolean r28, boolean r29, android.graphics.Rect r30, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r31) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.r.a(java.util.List, float, float, float, float, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, android.graphics.Rect, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):void");
    }

    @Override // B1.m
    public Rect b(int i3, float f3, ContainerView containerView, int i4) {
        Context context = containerView.getContext();
        Rect rect = new Rect();
        int j3 = s.j(context);
        int h3 = s.h(context);
        int G02 = l.O1(context).G0();
        int f4 = l.z0(context) ? 0 : s.f(context);
        int l02 = l.l0(context);
        if (s.J(context)) {
            if (i3 == 0) {
                rect.left = 0;
                rect.top = G02;
                rect.right = j3;
                rect.bottom = (int) (((((h3 - f4) - G02) * f3) - (l02 / 2)) + G02);
            } else if (i3 == 1) {
                rect.left = 0;
                rect.top = (int) (((r0 - G02) * f3) + (l02 / 2) + G02);
                rect.right = j3;
                rect.bottom = h3 - f4;
            }
        } else if (i3 == 0) {
            rect.left = 0;
            rect.top = 0;
            rect.right = (int) ((j3 * f3) - (l02 / 2));
            rect.bottom = h3 - f4;
        } else if (i3 == 1) {
            rect.left = (int) ((j3 * f3) + (l02 / 2));
            rect.top = 0;
            rect.right = j3;
            rect.bottom = h3 - f4;
        }
        return rect;
    }

    @Override // B1.m
    public int c(C0600c c0600c, int i3, int i4, boolean z3) {
        if (c0600c.getCount() == 2) {
            return i4 == 1 ? 1 : 2;
        }
        if (c0600c.getCount() != 3) {
            return i3;
        }
        if (z3) {
            if (i4 == 2 && c0600c.m() >= 3) {
                if (f243b.booleanValue()) {
                    Log.d(f242a, "return saved land space layout: " + c0600c.m());
                }
                return c0600c.m();
            }
            if (i4 == 1 && c0600c.s() >= 3) {
                if (f243b.booleanValue()) {
                    Log.d(f242a, "return saved portrait layout: " + c0600c.s());
                }
                return c0600c.s();
            }
        }
        int[] d3 = c0600c.d();
        int i5 = d3[0];
        int i6 = d3[1];
        boolean I3 = z3 ? c0600c.o(0).I() : c0600c.getItem(0).I();
        if (i4 == 2) {
            if (i5 == 3) {
                i3 = 3;
            } else if ((i5 == 0 || i5 == 2) && i3 != 4 && i3 != 5) {
                i3 = (i5 != 2 || I3) ? 5 : 4;
            } else if (i5 == 1 && i3 != 6 && i3 != 7) {
                i3 = I3 ? 6 : 7;
            }
            if (c0600c.m() != 0 || !c0600c.y()) {
                return i3;
            }
            c0600c.L(i3);
            if (!f243b.booleanValue()) {
                return i3;
            }
            Log.d(f242a, "setLandSpaceLayout to " + i3);
            return i3;
        }
        if (i4 != 1) {
            return i3;
        }
        if (i6 == 3) {
            i3 = 3;
        } else if ((i6 == 0 || i6 == 2) && i3 != 6 && i3 != 7) {
            i3 = (i6 == 2 && I3) ? 6 : 7;
        } else if (i6 == 1 && i3 != 4 && i3 != 5) {
            i3 = !I3 ? 4 : 5;
        }
        if (c0600c.s() != 0 || !c0600c.y()) {
            return i3;
        }
        c0600c.O(i3);
        if (!f243b.booleanValue()) {
            return i3;
        }
        Log.d(f242a, "setPortraitLayout to " + i3);
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0171  */
    @Override // B1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(java.util.List r23, int r24, int r25, float r26, float r27, int r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r34) {
        /*
            Method dump skipped, instructions count: 2332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.r.g(java.util.List, int, int, float, float, int, boolean, boolean, boolean, boolean, boolean, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):void");
    }

    @Override // B1.m
    public void h(Rect rect, ContainerView containerView) {
        float[] fArr;
        if (containerView.k1()) {
            float B02 = containerView.B0(containerView.getContext());
            float x02 = ContainerView.x0(containerView.getContext());
            float y02 = ContainerView.y0(containerView.getContext());
            int G02 = containerView.m1() ? l.O1(containerView.getContext()).G0() : 0;
            int max = Math.max(containerView.getWindowMetricsBounds().height(), containerView.getWindowMetricsBounds().width()) - G02;
            int i3 = 4;
            if (l.N0(containerView) || containerView.f10732G.f10323Q) {
                float f3 = max;
                float f4 = G02;
                double d3 = max;
                double d4 = G02;
                fArr = new float[]{(0.050000012f * f3) + f4, (0.17500001f * f3) + f4, (float) (((1.0f - B02) * 0.5d * d3) + d4), (float) ((d3 * 0.5d) + d4), (float) ((d3 * (B02 + 1.0f) * 0.5d) + d4), (0.825f * f3) + f4, (f3 * 0.95f) + f4};
                i3 = 7;
            } else {
                float f5 = max;
                float f6 = G02;
                double d5 = max;
                double d6 = G02;
                double d7 = y02;
                fArr = new float[]{(0.050000012f * f5) + f6, (float) (((1.0f - x02) * 0.5d * d5) + d6), (float) (((0.5d - d7) * d5) + d6), (float) ((d5 * 0.5d) + d6), (float) (((d7 + 0.5d) * d5) + d6), (float) ((d5 * (x02 + 1.0f) * 0.5d) + d6), (f5 * 0.95f) + f6};
            }
            containerView.setDragModes(fArr);
            containerView.setDragModeType(i3);
        }
    }
}
