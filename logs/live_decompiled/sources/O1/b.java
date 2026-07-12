package o1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public abstract class b {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12728a;

        static {
            int[] iArr = new int[c.values().length];
            f12728a = iArr;
            try {
                iArr[c.STATIC_COMPONENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12728a[c.DYNAMIC_SIMSLOT_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12728a[c.DYNAMIC_SIMSLOT_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: o1.b$b, reason: collision with other inner class name */
    public enum EnumC0141b {
        CACHE_ONLY,
        CACHE_AND_DB
    }

    public enum c {
        STATIC_COMPONENT,
        DYNAMIC_SIMSLOT_1,
        DYNAMIC_SIMSLOT_2
    }

    private static Cursor a(ContentResolver contentResolver, c cVar, String str) {
        Cursor b3 = C0492a.d().b(cVar, str);
        return (b3 != null || C0492a.a(cVar) == EnumC0141b.CACHE_ONLY) ? b3 : contentResolver.query(e(cVar), null, "featurename=?", new String[]{str}, null);
    }

    public static boolean b(ContentResolver contentResolver, String str, boolean z3) {
        return c(contentResolver, c.STATIC_COMPONENT, str, z3);
    }

    public static boolean c(ContentResolver contentResolver, c cVar, String str, boolean z3) {
        String d3 = d(contentResolver, cVar, str, "boolean");
        if (d3 != null) {
            return Boolean.parseBoolean(d3);
        }
        Log.e("AppFeatureProviderUtils", "getBoolean: getStringForFeature return null");
        return z3;
    }

    private static String d(ContentResolver contentResolver, c cVar, String str, String str2) {
        int indexOf;
        String str3 = null;
        if (contentResolver != null && !TextUtils.isEmpty(str) && str2 != null) {
            Cursor a3 = a(contentResolver, cVar, str);
            if (a3 != null && a3.moveToFirst()) {
                do {
                    String string = a3.getString(a3.getColumnIndexOrThrow("parameters"));
                    if (string != null && !string.isEmpty()) {
                        String[] split = string.split(Constants.DataMigration.SPLIT_TAG);
                        if (split.length > 0) {
                            int length = split.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 < length) {
                                    String str4 = split[i3];
                                    if (str4 != null && !str4.isEmpty() && (indexOf = str4.indexOf(":")) > 0 && str4.substring(0, indexOf).equals(str2)) {
                                        str3 = str4.substring(indexOf + 1);
                                        break;
                                    }
                                    i3++;
                                } else {
                                    break;
                                }
                            }
                            if (str3 != null) {
                                break;
                            }
                        }
                    }
                } while (a3.moveToNext());
            }
            if (a3 != null) {
                a3.close();
            }
        }
        return str3;
    }

    static Uri e(c cVar) {
        Uri parse = Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider");
        int i3 = a.f12728a[cVar.ordinal()];
        if (i3 == 1) {
            return parse.buildUpon().appendPath("app_feature").build();
        }
        if (i3 == 2) {
            return parse.buildUpon().appendPath("app_feature_first").build();
        }
        if (i3 == 3) {
            return parse.buildUpon().appendPath("app_feature_second").build();
        }
        throw new IllegalArgumentException("getUriBySimSlot simSlot is not support");
    }

    public static boolean f(ContentResolver contentResolver, String str) {
        return g(contentResolver, c.STATIC_COMPONENT, str);
    }

    public static boolean g(ContentResolver contentResolver, c cVar, String str) {
        Cursor a3 = a(contentResolver, cVar, str);
        boolean z3 = a3 != null && a3.getCount() > 0;
        if (a3 != null) {
            a3.close();
        }
        return z3;
    }
}
