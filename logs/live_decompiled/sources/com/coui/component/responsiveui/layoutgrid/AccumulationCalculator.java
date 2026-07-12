package com.coui.component.responsiveui.layoutgrid;

import D2.k;
import E2.a;
import com.coui.component.responsiveui.unit.Dp;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
public final class AccumulationCalculator implements IColumnsWidthCalculator {
    @Override // com.coui.component.responsiveui.layoutgrid.IColumnsWidthCalculator
    public Dp[] calculate(Dp dp, Dp dp2, Dp dp3, int i3) {
        k.e(dp, "layoutGridWidth");
        k.e(dp2, "margin");
        k.e(dp3, "gutter");
        Dp[] dpArr = new Dp[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            dpArr[i5] = new Dp(0.0f);
        }
        float f3 = i3 - 1;
        if ((dp3.getValue() * f3) + (dp2.getValue() * 2.0d) > dp.getValue()) {
            return dpArr;
        }
        double value = ((dp.getValue() - (dp2.getValue() * 2.0d)) - (f3 * dp3.getValue())) / i3;
        int v3 = AbstractC0538h.v(dpArr);
        if (v3 >= 0) {
            double d3 = 0.0d;
            while (true) {
                int i6 = i4 + 1;
                int a3 = a.a((i6 * value) - d3);
                dpArr[i4] = new Dp(a3);
                d3 += a3;
                if (i4 == v3) {
                    break;
                }
                i4 = i6;
            }
        }
        return dpArr;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.IColumnsWidthCalculator
    public int[] calculate(int i3, int i4, int i5, int i6) {
        int[] iArr = new int[i6];
        double d3 = (i6 - 1) * i5;
        double d4 = i4 * 2.0d;
        double d5 = i3;
        if (d3 + d4 > d5) {
            return iArr;
        }
        double d6 = ((d5 - d4) - d3) / i6;
        int u3 = AbstractC0538h.u(iArr);
        if (u3 >= 0) {
            double d7 = 0.0d;
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                int a3 = a.a((i8 * d6) - d7);
                iArr[i7] = a3;
                d7 += a3;
                if (i7 == u3) {
                    break;
                }
                i7 = i8;
            }
        }
        return iArr;
    }
}
