package androidx.lifecycle;

import M.c;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import q2.AbstractC0521D;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: f, reason: collision with root package name */
    public static final a f5835f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Class[] f5836g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    private final Map f5837a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f5838b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f5839c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f5840d;

    /* renamed from: e, reason: collision with root package name */
    private final c.InterfaceC0026c f5841e;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final y a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new y();
                }
                HashMap hashMap = new HashMap();
                for (String str : bundle2.keySet()) {
                    D2.k.d(str, "key");
                    hashMap.put(str, bundle2.get(str));
                }
                return new y(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = parcelableArrayList.get(i3);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i3));
            }
            return new y(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : y.f5836g) {
                D2.k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private a() {
        }
    }

    public y(Map map) {
        D2.k.e(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f5837a = linkedHashMap;
        this.f5838b = new LinkedHashMap();
        this.f5839c = new LinkedHashMap();
        this.f5840d = new LinkedHashMap();
        this.f5841e = new c.InterfaceC0026c() { // from class: androidx.lifecycle.x
            @Override // M.c.InterfaceC0026c
            public final Bundle a() {
                Bundle e3;
                e3 = y.e(y.this);
                return e3;
            }
        };
        linkedHashMap.putAll(map);
    }

    public static final y c(Bundle bundle, Bundle bundle2) {
        return f5835f.a(bundle, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle e(y yVar) {
        D2.k.e(yVar, "this$0");
        for (Map.Entry entry : AbstractC0521D.m(yVar.f5838b).entrySet()) {
            yVar.f((String) entry.getKey(), ((c.InterfaceC0026c) entry.getValue()).a());
        }
        Set<String> keySet = yVar.f5837a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(yVar.f5837a.get(str));
        }
        return androidx.core.os.d.a(p2.n.a("keys", arrayList), p2.n.a("values", arrayList2));
    }

    public final c.InterfaceC0026c d() {
        return this.f5841e;
    }

    public final void f(String str, Object obj) {
        D2.k.e(str, "key");
        if (!f5835f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            D2.k.b(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.f5839c.get(str);
        t tVar = obj2 instanceof t ? (t) obj2 : null;
        if (tVar != null) {
            tVar.j(obj);
        } else {
            this.f5837a.put(str, obj);
        }
        androidx.appcompat.app.p.a(this.f5840d.get(str));
    }

    public y() {
        this.f5837a = new LinkedHashMap();
        this.f5838b = new LinkedHashMap();
        this.f5839c = new LinkedHashMap();
        this.f5840d = new LinkedHashMap();
        this.f5841e = new c.InterfaceC0026c() { // from class: androidx.lifecycle.x
            @Override // M.c.InterfaceC0026c
            public final Bundle a() {
                Bundle e3;
                e3 = y.e(y.this);
                return e3;
            }
        };
    }
}
