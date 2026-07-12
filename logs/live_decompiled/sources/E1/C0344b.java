package e1;

import a1.r;
import a1.u;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import java.io.IOException;
import java.util.Map;
import m1.AbstractC0462e;
import m1.AbstractC0465h;

/* renamed from: e1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0344b {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f11465d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f11466a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11467b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f11468c;

    public C0344b(Drawable.Callback callback, String str, u uVar, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f11467b = str;
        } else {
            this.f11467b = str + '/';
        }
        this.f11468c = map;
        d(uVar);
        if (callback instanceof View) {
            this.f11466a = ((View) callback).getContext().getApplicationContext();
        } else {
            AbstractC0462e.c("EffectiveAnimationDrawable must be inside of a view for images to work.");
            this.f11466a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f11465d) {
            AbstractC0462e.c("putBitmap key = " + str);
            ((r) this.f11468c.get(str)).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        r rVar = (r) this.f11468c.get(str);
        if (rVar == null) {
            return null;
        }
        Bitmap a3 = rVar.a();
        if (a3 != null) {
            return a3;
        }
        Context context = this.f11466a;
        if (context == null) {
            return null;
        }
        String b3 = rVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b3.startsWith("data:") && b3.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b3.substring(b3.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e3) {
                AbstractC0462e.d("data URL did not have correct base64 format.", e3);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f11467b)) {
                AbstractC0462e.c("Set non folder.");
                return null;
            }
            AbstractC0462e.c("bitmapForId filename = " + b3 + ";imagesFolder = " + this.f11467b);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f11467b + b3), null, options);
                if (decodeStream != null) {
                    return c(str, AbstractC0465h.m(decodeStream, rVar.e(), rVar.c()));
                }
                AbstractC0462e.c("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e4) {
                AbstractC0462e.d("Unable to decode image `" + str + "`.", e4);
                return null;
            }
        } catch (IOException e5) {
            AbstractC0462e.d("Unable to open asset.", e5);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f11466a == null) || this.f11466a.equals(context);
    }

    public void d(u uVar) {
    }
}
