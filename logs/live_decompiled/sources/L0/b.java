package l0;

import M1.f;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;

/* loaded from: classes.dex */
public class b extends RippleDrawable {

    /* renamed from: e, reason: collision with root package name */
    private static final int f12294e = Color.parseColor("#00000000");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r4, int r5, boolean r6) {
        /*
            r3 = this;
            int r0 = b()
            int r0 = d0.AbstractC0335a.a(r4, r0)
            int r1 = l0.b.f12294e
            android.content.res.ColorStateList r0 = s0.AbstractC0573a.a(r0, r1)
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r2.<init>(r1)
            l0.a r1 = new l0.a
            r1.<init>(r5)
            r3.<init>(r0, r2, r1)
            if (r6 == 0) goto L20
            r3.a(r4)
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.b.<init>(android.content.Context, int, boolean):void");
    }

    private void a(Context context) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f1447h0);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(f.f1449i0);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
    }

    private static int b() {
        return Build.VERSION.SDK_INT >= 34 ? M1.c.f1373r : M1.c.f1376u;
    }
}
