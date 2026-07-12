package B1;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class q {

    /* renamed from: e, reason: collision with root package name */
    private static q f233e;

    /* renamed from: c, reason: collision with root package name */
    private Context f236c;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap f234a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private int f235b = 13;

    /* renamed from: d, reason: collision with root package name */
    private final Object f237d = new Object();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        protected String f238a;

        /* renamed from: b, reason: collision with root package name */
        private String f239b;

        a(String str, String str2) {
            this.f238a = str;
            String[] split = str2.split("/");
            this.f239b = split[0];
            if (split.length > 1) {
                if (!split[1].startsWith(".")) {
                    this.f239b = split[1];
                    return;
                }
                this.f239b = split[0] + split[1];
            }
        }

        static String b(String str, String str2) {
            return str + "/" + str2;
        }

        String a() {
            return b(this.f238a, this.f239b);
        }

        public String toString() {
            return a();
        }
    }

    private static class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private String f240c;

        b(String str, String str2, String str3) {
            super(str, str2);
            this.f240c = str3;
        }

        String c() {
            return this.f240c;
        }

        @Override // B1.q.a
        public String toString() {
            return super.toString() + " type:" + this.f240c;
        }
    }

    private static class c extends a {

        /* renamed from: c, reason: collision with root package name */
        private final boolean f241c;

        c(String str, String str2, String str3) {
            super(str, str2);
            this.f241c = "disable".equals(str3);
        }

        @Override // B1.q.a
        public String toString() {
            return "VerticalSplitItem{Tag=" + a() + ", disable=" + this.f241c + '}';
        }
    }

    private q(Context context) {
        this.f236c = context;
        C0305a.a().b(new Runnable() { // from class: B1.p
            @Override // java.lang.Runnable
            public final void run() {
                q.this.k();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        if (r3 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        if (r3 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List b(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto Lc
            return r0
        Lc:
            java.lang.String r1 = ""
            java.lang.String r2 = "false"
            r3 = 0
            if (r6 == 0) goto L20
            android.content.Context r4 = r4.f236c     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r6 = 0
            java.io.InputStream r4 = com.oplus.settings.OplusSettings.readConfig(r4, r5, r6)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
        L1a:
            r3 = r4
            goto L26
        L1c:
            r4 = move-exception
            goto L80
        L1e:
            r4 = move-exception
            goto L6f
        L20:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L1a
        L26:
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r5 = r5.name()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r4.setInput(r3, r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            int r5 = r4.getEventType()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
        L37:
            r6 = 1
            if (r5 == r6) goto L69
            r6 = 2
            if (r5 != r6) goto L64
            java.lang.String r5 = r4.getName()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r6 = "version"
            boolean r6 = r6.equals(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r6 == 0) goto L59
            r4.next()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r6 = r4.getText()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1 = r6
        L59:
            java.lang.String r6 = "disableMultiWindow"
            boolean r5 = r6.equals(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r5 == 0) goto L64
            java.lang.String r5 = "true"
            r2 = r5
        L64:
            int r5 = r4.next()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L37
        L69:
            if (r3 == 0) goto L79
        L6b:
            r3.close()     // Catch: java.lang.Exception -> L79
            goto L79
        L6f:
            java.lang.String r5 = "PocketStudioAppReader"
            java.lang.String r6 = "getConfigVersion error"
            android.util.Log.e(r5, r6, r4)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L79
            goto L6b
        L79:
            r0.add(r1)
            r0.add(r2)
            return r0
        L80:
            if (r3 == 0) goto L85
            r3.close()     // Catch: java.lang.Exception -> L85
        L85:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.q.b(java.lang.String, boolean):java.util.List");
    }

    public static q d(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f233e == null) {
                    f233e = new q(context);
                }
                qVar = f233e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
    
        if (java.lang.Boolean.parseBoolean((java.lang.String) r2.get(1)) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k() {
        /*
            r10 = this;
            java.lang.String r0 = "config/sys_wms_split_app.xml"
            r1 = 1
            java.util.List r2 = r10.b(r0, r1)
            java.lang.String r3 = "/system_ext/oplus/sys_wms_split_app_ps.xml"
            r4 = 0
            java.util.List r5 = r10.b(r3, r4)
            java.lang.Object r6 = r2.get(r4)     // Catch: java.lang.Exception -> L33
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L33
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Exception -> L33
            java.lang.Object r8 = r5.get(r4)     // Catch: java.lang.Exception -> L33
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L33
            long r8 = java.lang.Long.parseLong(r8)     // Catch: java.lang.Exception -> L33
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L33
            java.lang.Object r6 = r2.get(r1)     // Catch: java.lang.Exception -> L33
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L33
            boolean r6 = java.lang.Boolean.parseBoolean(r6)     // Catch: java.lang.Exception -> L33
            if (r6 == 0) goto L33
            goto L34
        L33:
            r1 = r4
        L34:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "rusVersion "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = " defaultVersion "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r2 = r6.toString()
            java.lang.String r5 = "PocketStudioAppReader"
            android.util.Log.d(r5, r2)
            java.lang.String r2 = "parse configStream error"
            if (r1 == 0) goto L77
            android.content.Context r1 = r10.f236c     // Catch: java.lang.Exception -> L65
            java.io.InputStream r0 = com.oplus.settings.OplusSettings.readConfig(r1, r0, r4)     // Catch: java.lang.Exception -> L65
            r10.m(r0)     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L92
            r0.close()     // Catch: java.lang.Exception -> L65
            goto L92
        L65:
            r10 = move-exception
            goto L73
        L67:
            r10 = move-exception
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.lang.Throwable -> L6e
            goto L72
        L6e:
            r0 = move-exception
            r10.addSuppressed(r0)     // Catch: java.lang.Exception -> L65
        L72:
            throw r10     // Catch: java.lang.Exception -> L65
        L73:
            android.util.Log.e(r5, r2, r10)
            goto L92
        L77:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L83
            r0.<init>(r3)     // Catch: java.lang.Exception -> L83
            r10.m(r0)     // Catch: java.lang.Throwable -> L85
            r0.close()     // Catch: java.lang.Exception -> L83
            goto L92
        L83:
            r10 = move-exception
            goto L8f
        L85:
            r10 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L8a
            goto L8e
        L8a:
            r0 = move-exception
            r10.addSuppressed(r0)     // Catch: java.lang.Exception -> L83
        L8e:
            throw r10     // Catch: java.lang.Exception -> L83
        L8f:
            android.util.Log.e(r5, r2, r10)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.q.k():void");
    }

    private ArrayMap l(XmlPullParser xmlPullParser, String str) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            int depth = xmlPullParser.getDepth();
            while (XmlUtils.nextElementWithin(xmlPullParser, depth)) {
                if ("package".equals(xmlPullParser.getName())) {
                    String readStringAttribute = XmlUtils.readStringAttribute(xmlPullParser, "name");
                    if (!TextUtils.isEmpty(readStringAttribute)) {
                        String readStringAttribute2 = XmlUtils.readStringAttribute(xmlPullParser, "type");
                        if (!TextUtils.isEmpty(readStringAttribute2)) {
                            b bVar = new b(str, readStringAttribute, readStringAttribute2);
                            arrayMap.put(bVar.a(), bVar);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            Log.e("PocketStudioAppReader", " parseForceRelaunchDeviceConfig error:" + e3);
        }
        return arrayMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0019 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m(java.io.InputStream r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L3
            return
        L3:
            org.xmlpull.v1.XmlPullParser r0 = android.util.Xml.newPullParser()     // Catch: java.lang.Exception -> L38
            r1 = 0
            r0.setInput(r9, r1)     // Catch: java.lang.Exception -> L38
            java.lang.String r9 = "settings"
            com.android.internal.util.XmlUtils.beginDocument(r0, r9)     // Catch: java.lang.Exception -> L38
            android.util.ArrayMap r9 = new android.util.ArrayMap     // Catch: java.lang.Exception -> L38
            r9.<init>()     // Catch: java.lang.Exception -> L38
            int r2 = r0.getDepth()     // Catch: java.lang.Exception -> L38
        L19:
            boolean r3 = com.android.internal.util.XmlUtils.nextElementWithin(r0, r2)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto Laa
            java.lang.String r3 = r0.getName()     // Catch: java.lang.Exception -> L38
            int r4 = r3.hashCode()     // Catch: java.lang.Exception -> L38
            r5 = 2
            r6 = 1
            r7 = 3
            switch(r4) {
                case -2062842158: goto L4f;
                case -1195953535: goto L45;
                case -843969177: goto L3b;
                case 1023617400: goto L2e;
                default: goto L2d;
            }     // Catch: java.lang.Exception -> L38
        L2d:
            goto L59
        L2e:
            java.lang.String r4 = "psHoraeLevel"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto L59
            r3 = r7
            goto L5a
        L38:
            r8 = move-exception
            goto Lbc
        L3b:
            java.lang.String r4 = "vSplitPs"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto L59
            r3 = r6
            goto L5a
        L45:
            java.lang.String r4 = "disableMultiWindow"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto L59
            r3 = 0
            goto L5a
        L4f:
            java.lang.String r4 = "psFixedSize"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L38
            if (r3 == 0) goto L59
            r3 = r5
            goto L5a
        L59:
            r3 = -1
        L5a:
            if (r3 == 0) goto L93
            if (r3 == r6) goto L7c
            if (r3 == r5) goto L6e
            if (r3 == r7) goto L63
            goto L9e
        L63:
            java.lang.String r3 = "attr"
            int r4 = r8.f235b     // Catch: java.lang.Exception -> L38
            int r3 = com.android.internal.util.XmlUtils.readIntAttribute(r0, r3, r4)     // Catch: java.lang.Exception -> L38
            r8.f235b = r3     // Catch: java.lang.Exception -> L38
            goto L9e
        L6e:
            java.lang.String r3 = "attr"
            java.lang.String r3 = com.android.internal.util.XmlUtils.readStringAttribute(r0, r3)     // Catch: java.lang.Exception -> L38
            B1.q$a r4 = new B1.q$a     // Catch: java.lang.Exception -> L38
            java.lang.String r5 = "psFixedSize"
            r4.<init>(r5, r3)     // Catch: java.lang.Exception -> L38
            goto L9f
        L7c:
            java.lang.String r3 = "attr"
            java.lang.String r3 = com.android.internal.util.XmlUtils.readStringAttribute(r0, r3)     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = "status"
            java.lang.String r4 = com.android.internal.util.XmlUtils.readStringAttribute(r0, r4)     // Catch: java.lang.Exception -> L38
            B1.q$c r5 = new B1.q$c     // Catch: java.lang.Exception -> L38
            java.lang.String r6 = r0.getName()     // Catch: java.lang.Exception -> L38
            r5.<init>(r6, r3, r4)     // Catch: java.lang.Exception -> L38
            r4 = r5
            goto L9f
        L93:
            java.lang.String r3 = r0.getName()     // Catch: java.lang.Exception -> L38
            android.util.ArrayMap r3 = r8.l(r0, r3)     // Catch: java.lang.Exception -> L38
            r9.putAll(r3)     // Catch: java.lang.Exception -> L38
        L9e:
            r4 = r1
        L9f:
            if (r4 == 0) goto L19
            java.lang.String r3 = r4.a()     // Catch: java.lang.Exception -> L38
            r9.put(r3, r4)     // Catch: java.lang.Exception -> L38
            goto L19
        Laa:
            java.lang.Object r0 = r8.f237d     // Catch: java.lang.Exception -> L38
            monitor-enter(r0)     // Catch: java.lang.Exception -> L38
            android.util.ArrayMap r1 = r8.f234a     // Catch: java.lang.Throwable -> Lb9
            r1.clear()     // Catch: java.lang.Throwable -> Lb9
            android.util.ArrayMap r8 = r8.f234a     // Catch: java.lang.Throwable -> Lb9
            r8.putAll(r9)     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            goto Lc3
        Lb9:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            throw r8     // Catch: java.lang.Exception -> L38
        Lbc:
            java.lang.String r9 = "PocketStudioAppReader"
            java.lang.String r0 = "readConfigsFromXML error"
            android.util.Log.e(r9, r0, r8)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.q.m(java.io.InputStream):void");
    }

    public int c() {
        return this.f235b;
    }

    public int e(boolean z3, boolean z4, String str) {
        String[] split;
        if (str == null || (split = str.split(":")) == null || split.length != 3) {
            return -1;
        }
        String str2 = z3 ? split[2] : z4 ? split[1] : split[0];
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception unused) {
            return -1;
        }
    }

    public boolean f(ComponentName componentName) {
        if (componentName == null) {
            return false;
        }
        String className = componentName.getClassName();
        synchronized (this.f237d) {
            try {
                c cVar = (c) this.f234a.get(a.b("vSplitPs", className));
                if (cVar == null) {
                    return false;
                }
                return cVar.f241c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean g(String str) {
        boolean containsKey;
        if (str == null) {
            return false;
        }
        synchronized (this.f237d) {
            containsKey = this.f234a.containsKey(a.b("vSplitPs", str));
        }
        return containsKey;
    }

    public boolean h(String str) {
        boolean containsKey;
        if (str == null) {
            return false;
        }
        synchronized (this.f237d) {
            containsKey = this.f234a.containsKey(a.b("psFixedSize", str));
        }
        return containsKey;
    }

    public boolean i() {
        return s.r(this.f236c);
    }

    public boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.f237d) {
            try {
                a aVar = (a) this.f234a.get(a.b("disableMultiWindow", str));
                if (!(aVar instanceof b)) {
                    return false;
                }
                int e3 = e(s.H(), i(), ((b) aVar).c());
                return e3 == 2 || e3 == 3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
