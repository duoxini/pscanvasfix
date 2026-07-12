package D2;

import C2.v;
import C2.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p2.C0510j;
import q2.AbstractC0521D;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class e implements I2.b, d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f323b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Map f324c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap f325d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap f326e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap f327f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map f328g;

    /* renamed from: a, reason: collision with root package name */
    private final Class f329a;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(Class cls) {
            String str;
            k.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) e.f327f.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) e.f327f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
        
            if (r1 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(java.lang.Class r6) {
            /*
                r5 = this;
                java.lang.String r5 = "jClass"
                D2.k.e(r6, r5)
                boolean r5 = r6.isAnonymousClass()
                r0 = 0
                if (r5 == 0) goto Le
                goto Lb3
            Le:
                boolean r5 = r6.isLocalClass()
                if (r5 == 0) goto L6a
                java.lang.String r5 = r6.getSimpleName()
                java.lang.reflect.Method r1 = r6.getEnclosingMethod()
                r2 = 2
                r3 = 36
                if (r1 == 0) goto L41
                D2.k.b(r5)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r1 = r1.getName()
                r4.append(r1)
                r4.append(r3)
                java.lang.String r1 = r4.toString()
                java.lang.String r1 = K2.e.Y(r5, r1, r0, r2, r0)
                if (r1 != 0) goto L3e
                goto L41
            L3e:
                r0 = r1
                goto Lb3
            L41:
                java.lang.reflect.Constructor r6 = r6.getEnclosingConstructor()
                if (r6 == 0) goto L62
                D2.k.b(r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r6 = r6.getName()
                r1.append(r6)
                r1.append(r3)
                java.lang.String r6 = r1.toString()
                java.lang.String r0 = K2.e.Y(r5, r6, r0, r2, r0)
                goto Lb3
            L62:
                D2.k.b(r5)
                java.lang.String r0 = K2.e.X(r5, r3, r0, r2, r0)
                goto Lb3
            L6a:
                boolean r5 = r6.isArray()
                if (r5 == 0) goto L9e
                java.lang.Class r5 = r6.getComponentType()
                boolean r6 = r5.isPrimitive()
                java.lang.String r1 = "Array"
                if (r6 == 0) goto L9b
                java.util.Map r6 = D2.e.g()
                java.lang.String r5 = r5.getName()
                java.lang.Object r5 = r6.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L9b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                r6.append(r1)
                java.lang.String r0 = r6.toString()
            L9b:
                if (r0 != 0) goto Lb3
                goto L3e
            L9e:
                java.util.Map r5 = D2.e.g()
                java.lang.String r0 = r6.getName()
                java.lang.Object r5 = r5.get(r0)
                r0 = r5
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto Lb3
                java.lang.String r0 = r6.getSimpleName()
            Lb3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: D2.e.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(Object obj, Class cls) {
            k.e(cls, "jClass");
            Map map = e.f324c;
            k.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return u.c(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = B2.a.b(B2.a.c(cls));
            }
            return cls.isInstance(obj);
        }

        private a() {
        }
    }

    static {
        List l3 = AbstractC0544n.l(C2.a.class, C2.l.class, C2.p.class, C2.q.class, C2.r.class, C2.s.class, C2.t.class, C2.u.class, v.class, w.class, C2.b.class, C2.c.class, C2.d.class, C2.e.class, C2.f.class, C2.g.class, C2.h.class, C2.i.class, C2.j.class, C2.k.class, C2.m.class, C2.n.class, C2.o.class);
        ArrayList arrayList = new ArrayList(AbstractC0544n.q(l3, 10));
        int i3 = 0;
        for (Object obj : l3) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                AbstractC0544n.p();
            }
            arrayList.add(p2.n.a((Class) obj, Integer.valueOf(i3)));
            i3 = i4;
        }
        f324c = AbstractC0521D.k(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f325d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f326e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k.d(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.b(str);
            sb.append(K2.e.a0(str, '.', null, 2, null));
            sb.append("CompanionObject");
            C0510j a3 = p2.n.a(sb.toString(), str + ".Companion");
            hashMap3.put(a3.c(), a3.d());
        }
        for (Map.Entry entry : f324c.entrySet()) {
            hashMap3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f327f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC0521D.d(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), K2.e.a0((String) entry2.getValue(), '.', null, 2, null));
        }
        f328g = linkedHashMap;
    }

    public e(Class cls) {
        k.e(cls, "jClass");
        this.f329a = cls;
    }

    @Override // I2.b
    public String a() {
        return f323b.a(c());
    }

    @Override // I2.b
    public String b() {
        return f323b.b(c());
    }

    @Override // D2.d
    public Class c() {
        return this.f329a;
    }

    @Override // I2.b
    public boolean d(Object obj) {
        return f323b.c(obj, c());
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(B2.a.b(this), B2.a.b((I2.b) obj));
    }

    public int hashCode() {
        return B2.a.b(this).hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
