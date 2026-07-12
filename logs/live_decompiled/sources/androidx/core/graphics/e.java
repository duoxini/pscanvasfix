package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.d;
import androidx.core.provider.g;
import java.io.IOException;

/* loaded from: classes.dex */
public class e extends f {
    private Font d(FontFamily fontFamily, int i3) {
        FontStyle fontStyle = new FontStyle((i3 & 1) != 0 ? 700 : 400, (i3 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int e3 = e(fontStyle, font.getStyle());
        for (int i4 = 1; i4 < fontFamily.getSize(); i4++) {
            Font font2 = fontFamily.getFont(i4);
            int e4 = e(fontStyle, font2.getStyle());
            if (e4 < e3) {
                font = font2;
                e3 = e4;
            }
        }
        return font;
    }

    private static int e(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // androidx.core.graphics.f
    public Typeface a(Context context, d.c cVar, Resources resources, int i3) {
        try {
            FontFamily.Builder builder = null;
            for (d.C0063d c0063d : cVar.a()) {
                try {
                    Font build = new Font.Builder(resources, c0063d.a()).setWeight(c0063d.d()).setSlant(c0063d.e() ? 1 : 0).setTtcIndex(c0063d.b()).setFontVariationSettings(c0063d.c()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(d(build2, i3).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.f
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i3) {
        int i4;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            while (i4 < length) {
                g.b bVar = bVarArr[i4];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    i4 = openFileDescriptor == null ? i4 + 1 : 0;
                } else {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(bVar.e()).setSlant(bVar.f() ? 1 : 0).setTtcIndex(bVar.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(d(build2, i3).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.f
    public Typeface c(Context context, Resources resources, int i3, String str, int i4) {
        try {
            Font build = new Font.Builder(resources, i3).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
