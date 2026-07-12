package K0;

import H0.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.c;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
public class a extends AppCompatCheckBox {

    /* renamed from: l, reason: collision with root package name */
    private static final int f1162l = i.f650o;

    /* renamed from: m, reason: collision with root package name */
    private static final int[][] f1163m = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f1164i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1165j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1166k;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f473e);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f1164i == null) {
            int[][] iArr = f1163m;
            int[] iArr2 = new int[iArr.length];
            int d3 = L0.a.d(this, H0.a.f477i);
            int d4 = L0.a.d(this, H0.a.f482n);
            int d5 = L0.a.d(this, H0.a.f479k);
            iArr2[0] = L0.a.h(d4, d3, 1.0f);
            iArr2[1] = L0.a.h(d4, d5, 0.54f);
            iArr2[2] = L0.a.h(d4, d5, 0.38f);
            iArr2[3] = L0.a.h(d4, d5, 0.38f);
            this.f1164i = new ColorStateList(iArr, iArr2);
        }
        return this.f1164i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1165j && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable a3;
        if (!this.f1166k || !TextUtils.isEmpty(getText()) || (a3 = c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - a3.getIntrinsicWidth()) / 2) * (ViewUtils.isLayoutRtl(this) ? -1 : 1);
        int save = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a3.getBounds();
            androidx.core.graphics.drawable.a.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void setCenterIfNoTextEnabled(boolean z3) {
        this.f1166k = z3;
    }

    public void setUseMaterialThemeColors(boolean z3) {
        this.f1165j = z3;
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
            int r4 = K0.a.f1162l
            android.content.Context r8 = V0.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = H0.j.E3
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = H0.j.F3
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L2a
            int r10 = H0.j.F3
            android.content.res.ColorStateList r8 = R0.c.a(r8, r9, r10)
            androidx.core.widget.c.c(r7, r8)
        L2a:
            int r8 = H0.j.H3
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f1165j = r8
            int r8 = H0.j.G3
            r10 = 1
            boolean r8 = r9.getBoolean(r8, r10)
            r7.f1166k = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K0.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
