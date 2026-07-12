package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f4909a = aVar.p(iconCompat.f4909a, 1);
        iconCompat.f4911c = aVar.j(iconCompat.f4911c, 2);
        iconCompat.f4912d = aVar.r(iconCompat.f4912d, 3);
        iconCompat.f4913e = aVar.p(iconCompat.f4913e, 4);
        iconCompat.f4914f = aVar.p(iconCompat.f4914f, 5);
        iconCompat.f4915g = (ColorStateList) aVar.r(iconCompat.f4915g, 6);
        iconCompat.f4917i = aVar.t(iconCompat.f4917i, 7);
        iconCompat.f4918j = aVar.t(iconCompat.f4918j, 8);
        iconCompat.d();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.e(aVar.f());
        int i3 = iconCompat.f4909a;
        if (-1 != i3) {
            aVar.F(i3, 1);
        }
        byte[] bArr = iconCompat.f4911c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f4912d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i4 = iconCompat.f4913e;
        if (i4 != 0) {
            aVar.F(i4, 4);
        }
        int i5 = iconCompat.f4914f;
        if (i5 != 0) {
            aVar.F(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.f4915g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f4917i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f4918j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
