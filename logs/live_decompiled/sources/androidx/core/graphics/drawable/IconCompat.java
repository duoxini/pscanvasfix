package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f4908k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    Object f4910b;

    /* renamed from: j, reason: collision with root package name */
    public String f4918j;

    /* renamed from: a, reason: collision with root package name */
    public int f4909a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f4911c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f4912d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f4913e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f4914f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f4915g = null;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f4916h = f4908k;

    /* renamed from: i, reason: collision with root package name */
    public String f4917i = null;

    static class a {
        static int a(Object obj) {
            return c.a(obj);
        }

        static String b(Object obj) {
            return c.b(obj);
        }

        static Uri c(Object obj) {
            return c.d(obj);
        }

        static Drawable d(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon e(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.f4909a) {
                case -1:
                    return (Icon) iconCompat.f4910b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f4910b);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.b(), iconCompat.f4913e);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.f4910b, iconCompat.f4913e, iconCompat.f4914f);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.f4910b);
                    break;
                case 5:
                    createWithBitmap = b.b((Bitmap) iconCompat.f4910b);
                    break;
                case 6:
                    createWithBitmap = d.a(iconCompat.c());
                    break;
            }
            ColorStateList colorStateList = iconCompat.f4915g;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f4916h;
            if (mode != IconCompat.f4908k) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    private static String f(int i3) {
        switch (i3) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int a() {
        int i3 = this.f4909a;
        if (i3 == -1) {
            return a.a(this.f4910b);
        }
        if (i3 == 2) {
            return this.f4913e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String b() {
        int i3 = this.f4909a;
        if (i3 == -1) {
            return a.b(this.f4910b);
        }
        if (i3 == 2) {
            String str = this.f4918j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f4910b).split(":", -1)[0] : this.f4918j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public Uri c() {
        int i3 = this.f4909a;
        if (i3 == -1) {
            return a.c(this.f4910b);
        }
        if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.f4910b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public void d() {
        this.f4916h = PorterDuff.Mode.valueOf(this.f4917i);
        switch (this.f4909a) {
            case -1:
                Parcelable parcelable = this.f4912d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f4910b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f4912d;
                if (parcelable2 != null) {
                    this.f4910b = parcelable2;
                    return;
                }
                byte[] bArr = this.f4911c;
                this.f4910b = bArr;
                this.f4909a = 3;
                this.f4913e = 0;
                this.f4914f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f4911c, Charset.forName("UTF-16"));
                this.f4910b = str;
                if (this.f4909a == 2 && this.f4918j == null) {
                    this.f4918j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f4910b = this.f4911c;
                return;
        }
    }

    public void e(boolean z3) {
        this.f4917i = this.f4916h.name();
        switch (this.f4909a) {
            case -1:
                if (z3) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f4912d = (Parcelable) this.f4910b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z3) {
                    this.f4912d = (Parcelable) this.f4910b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f4910b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f4911c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f4911c = ((String) this.f4910b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f4911c = (byte[]) this.f4910b;
                return;
            case 4:
            case 6:
                this.f4911c = this.f4910b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public String toString() {
        if (this.f4909a == -1) {
            return String.valueOf(this.f4910b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(f(this.f4909a));
        switch (this.f4909a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f4910b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f4910b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f4918j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f4913e);
                if (this.f4914f != 0) {
                    sb.append(" off=");
                    sb.append(this.f4914f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f4910b);
                break;
        }
        if (this.f4915g != null) {
            sb.append(" tint=");
            sb.append(this.f4915g);
        }
        if (this.f4916h != f4908k) {
            sb.append(" mode=");
            sb.append(this.f4916h);
        }
        sb.append(")");
        return sb.toString();
    }
}
