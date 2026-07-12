package Q0;

import H0.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.c;

/* loaded from: classes.dex */
public class a extends AppCompatRadioButton {

    /* renamed from: k, reason: collision with root package name */
    private static final int f1887k = i.f651p;

    /* renamed from: l, reason: collision with root package name */
    private static final int[][] f1888l = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f1889i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1890j;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f460A);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f1889i == null) {
            int d3 = L0.a.d(this, H0.a.f477i);
            int d4 = L0.a.d(this, H0.a.f479k);
            int d5 = L0.a.d(this, H0.a.f482n);
            int[][] iArr = f1888l;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = L0.a.h(d5, d3, 1.0f);
            iArr2[1] = L0.a.h(d5, d4, 0.54f);
            iArr2[2] = L0.a.h(d5, d4, 0.38f);
            iArr2[3] = L0.a.h(d5, d4, 0.38f);
            this.f1889i = new ColorStateList(iArr, iArr2);
        }
        return this.f1889i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1890j && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z3) {
        this.f1890j = z3;
        if (z3) {
            c.c(this, getMaterialThemeColorsTintList());
        } else {
            c.c(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = Q0.a.f1887k
            android.content.Context r8 = V0.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = H0.j.J3
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = H0.j.K3
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L2a
            int r10 = H0.j.K3
            android.content.res.ColorStateList r8 = R0.c.a(r8, r9, r10)
            androidx.core.widget.c.c(r7, r8)
        L2a:
            int r8 = H0.j.L3
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f1890j = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Q0.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
