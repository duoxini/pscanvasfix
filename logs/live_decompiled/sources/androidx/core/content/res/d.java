package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class d {

    static class a {
        static int a(TypedArray typedArray, int i3) {
            return typedArray.getType(i3);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final C0063d[] f4864a;

        public c(C0063d[] c0063dArr) {
            this.f4864a = c0063dArr;
        }

        public C0063d[] a() {
            return this.f4864a;
        }
    }

    /* renamed from: androidx.core.content.res.d$d, reason: collision with other inner class name */
    public static final class C0063d {

        /* renamed from: a, reason: collision with root package name */
        private final String f4865a;

        /* renamed from: b, reason: collision with root package name */
        private final int f4866b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f4867c;

        /* renamed from: d, reason: collision with root package name */
        private final String f4868d;

        /* renamed from: e, reason: collision with root package name */
        private final int f4869e;

        /* renamed from: f, reason: collision with root package name */
        private final int f4870f;

        public C0063d(String str, int i3, boolean z3, String str2, int i4, int i5) {
            this.f4865a = str;
            this.f4866b = i3;
            this.f4867c = z3;
            this.f4868d = str2;
            this.f4869e = i4;
            this.f4870f = i5;
        }

        public int a() {
            return this.f4870f;
        }

        public int b() {
            return this.f4869e;
        }

        public String c() {
            return this.f4868d;
        }

        public int d() {
            return this.f4866b;
        }

        public boolean e() {
            return this.f4867c;
        }
    }

    public static final class e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.core.provider.e f4871a;

        /* renamed from: b, reason: collision with root package name */
        private final int f4872b;

        /* renamed from: c, reason: collision with root package name */
        private final int f4873c;

        /* renamed from: d, reason: collision with root package name */
        private final String f4874d;

        public e(androidx.core.provider.e eVar, int i3, int i4, String str) {
            this.f4871a = eVar;
            this.f4873c = i3;
            this.f4872b = i4;
            this.f4874d = str;
        }

        public int a() {
            return this.f4873c;
        }

        public androidx.core.provider.e b() {
            return this.f4871a;
        }

        public String c() {
            return this.f4874d;
        }

        public int d() {
            return this.f4872b;
        }
    }

    private static int a(TypedArray typedArray, int i3) {
        return a.a(typedArray, i3);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i3) {
        if (i3 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i3);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i4 = 0; i4 < obtainTypedArray.length(); i4++) {
                    int resourceId = obtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i3)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), u.c.f13746h);
        String string = obtainAttributes.getString(u.c.f13747i);
        String string2 = obtainAttributes.getString(u.c.f13751m);
        String string3 = obtainAttributes.getString(u.c.f13752n);
        int resourceId = obtainAttributes.getResourceId(u.c.f13748j, 0);
        int integer = obtainAttributes.getInteger(u.c.f13749k, 1);
        int integer2 = obtainAttributes.getInteger(u.c.f13750l, OplusSearchHighlightUtils.WAIT_TIME_DEFAULT);
        String string4 = obtainAttributes.getString(u.c.f13753o);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((C0063d[]) arrayList.toArray(new C0063d[0]));
    }

    private static C0063d f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), u.c.f13754p);
        int i3 = obtainAttributes.getInt(obtainAttributes.hasValue(u.c.f13763y) ? u.c.f13763y : u.c.f13756r, 400);
        boolean z3 = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(u.c.f13761w) ? u.c.f13761w : u.c.f13757s, 0);
        int i4 = obtainAttributes.hasValue(u.c.f13764z) ? u.c.f13764z : u.c.f13758t;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(u.c.f13762x) ? u.c.f13762x : u.c.f13759u);
        int i5 = obtainAttributes.getInt(i4, 0);
        int i6 = obtainAttributes.hasValue(u.c.f13760v) ? u.c.f13760v : u.c.f13755q;
        int resourceId = obtainAttributes.getResourceId(i6, 0);
        String string2 = obtainAttributes.getString(i6);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0063d(string2, i3, z3, string, i5, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i3 = 1;
        while (i3 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i3++;
            } else if (next == 3) {
                i3--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
