package o1;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.appcompat.app.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o1.b;

/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0492a {

    /* renamed from: a, reason: collision with root package name */
    protected static final List f12718a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final List f12719b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final List f12720c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private static final Uri f12721d = Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider").buildUpon().appendPath("app_feature").build();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12722e = false;

    /* renamed from: f, reason: collision with root package name */
    static b.EnumC0141b f12723f;

    /* renamed from: g, reason: collision with root package name */
    static b.EnumC0141b f12724g;

    /* renamed from: h, reason: collision with root package name */
    static b.EnumC0141b f12725h;

    /* renamed from: o1.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0140a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12726a;

        static {
            int[] iArr = new int[b.c.values().length];
            f12726a = iArr;
            try {
                iArr[b.c.STATIC_COMPONENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12726a[b.c.DYNAMIC_SIMSLOT_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12726a[b.c.DYNAMIC_SIMSLOT_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: o1.a$b */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final C0492a f12727a = new C0492a();
    }

    static {
        b.EnumC0141b enumC0141b = b.EnumC0141b.CACHE_AND_DB;
        f12723f = enumC0141b;
        f12724g = enumC0141b;
        f12725h = enumC0141b;
    }

    C0492a() {
    }

    static b.EnumC0141b a(b.c cVar) {
        int i3 = C0140a.f12726a[cVar.ordinal()];
        if (i3 == 1) {
            return f12723f;
        }
        if (i3 == 2) {
            return f12724g;
        }
        if (i3 == 3) {
            return f12725h;
        }
        throw new IllegalArgumentException("getListFromSlot simSlot is not support");
    }

    private Cursor c(List list, String str) {
        MatrixCursor f3 = f();
        synchronized (C0492a.class) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    p.a(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f3.getCount() != 0) {
            return f3;
        }
        f3.close();
        return null;
    }

    public static C0492a d() {
        return b.f12727a;
    }

    private List e(b.c cVar) {
        int i3 = C0140a.f12726a[cVar.ordinal()];
        if (i3 == 1) {
            return f12718a;
        }
        if (i3 == 2) {
            return f12719b;
        }
        if (i3 == 3) {
            return f12720c;
        }
        throw new IllegalArgumentException("getListFromSlot simSlot is not support");
    }

    private MatrixCursor f() {
        return new MatrixCursor(new String[]{"_id", "featurename", "parameters", "lists"});
    }

    private boolean g(List list) {
        return list != null && list.size() == 0;
    }

    public Cursor b(b.c cVar, String str) {
        if (g(f12718a)) {
            return null;
        }
        return c(e(cVar), str);
    }
}
