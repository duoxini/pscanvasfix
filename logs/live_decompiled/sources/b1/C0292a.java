package b1;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import m1.AbstractC0464g;

/* renamed from: b1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0292a extends Paint {
    public C0292a() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i3) {
        super.setAlpha(AbstractC0464g.c(i3, 0, 255));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public C0292a(int i3) {
        super(i3);
    }

    public C0292a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public C0292a(int i3, PorterDuff.Mode mode) {
        super(i3);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
