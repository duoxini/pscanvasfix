package androidx.lifecycle;

import H.a;
import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class F {

    /* renamed from: a, reason: collision with root package name */
    private final H f5706a;

    /* renamed from: b, reason: collision with root package name */
    private final b f5707b;

    /* renamed from: c, reason: collision with root package name */
    private final H.a f5708c;

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5714a = a.f5715a;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ a f5715a = new a();

            private a() {
            }
        }

        default E a(Class cls) {
            D2.k.e(cls, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default E b(Class cls, H.a aVar) {
            D2.k.e(cls, "modelClass");
            D2.k.e(aVar, "extras");
            return a(cls);
        }
    }

    public static class c implements b {

        /* renamed from: c, reason: collision with root package name */
        private static c f5717c;

        /* renamed from: b, reason: collision with root package name */
        public static final a f5716b = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final a.b f5718d = a.C0085a.f5719a;

        public static final class a {

            /* renamed from: androidx.lifecycle.F$c$a$a, reason: collision with other inner class name */
            private static final class C0085a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public static final C0085a f5719a = new C0085a();

                private C0085a() {
                }
            }

            public /* synthetic */ a(D2.g gVar) {
                this();
            }

            public final c a() {
                if (c.f5717c == null) {
                    c.f5717c = new c();
                }
                c cVar = c.f5717c;
                D2.k.b(cVar);
                return cVar;
            }

            private a() {
            }
        }

        @Override // androidx.lifecycle.F.b
        public E a(Class cls) {
            D2.k.e(cls, "modelClass");
            try {
                Object newInstance = cls.newInstance();
                D2.k.d(newInstance, "{\n                modelC…wInstance()\n            }");
                return (E) newInstance;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    public static class d {
        public abstract void c(E e3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public F(H h3, b bVar) {
        this(h3, bVar, null, 4, null);
        D2.k.e(h3, "store");
        D2.k.e(bVar, "factory");
    }

    public E a(Class cls) {
        D2.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public E b(String str, Class cls) {
        E a3;
        D2.k.e(str, "key");
        D2.k.e(cls, "modelClass");
        E b3 = this.f5706a.b(str);
        if (!cls.isInstance(b3)) {
            H.d dVar = new H.d(this.f5708c);
            dVar.c(c.f5718d, str);
            try {
                a3 = this.f5707b.b(cls, dVar);
            } catch (AbstractMethodError unused) {
                a3 = this.f5707b.a(cls);
            }
            this.f5706a.d(str, a3);
            return a3;
        }
        Object obj = this.f5707b;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            D2.k.d(b3, "viewModel");
            dVar2.c(b3);
        }
        if (b3 != null) {
            return b3;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }

    public static class a extends c {

        /* renamed from: g, reason: collision with root package name */
        private static a f5710g;

        /* renamed from: e, reason: collision with root package name */
        private final Application f5712e;

        /* renamed from: f, reason: collision with root package name */
        public static final C0083a f5709f = new C0083a(null);

        /* renamed from: h, reason: collision with root package name */
        public static final a.b f5711h = C0083a.C0084a.f5713a;

        /* renamed from: androidx.lifecycle.F$a$a, reason: collision with other inner class name */
        public static final class C0083a {

            /* renamed from: androidx.lifecycle.F$a$a$a, reason: collision with other inner class name */
            private static final class C0084a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public static final C0084a f5713a = new C0084a();

                private C0084a() {
                }
            }

            public /* synthetic */ C0083a(D2.g gVar) {
                this();
            }

            public final a a(Application application) {
                D2.k.e(application, "application");
                if (a.f5710g == null) {
                    a.f5710g = new a(application);
                }
                a aVar = a.f5710g;
                D2.k.b(aVar);
                return aVar;
            }

            private C0083a() {
            }
        }

        private a(Application application, int i3) {
            this.f5712e = application;
        }

        private final E g(Class cls, Application application) {
            if (!AbstractC0265a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                E e3 = (E) cls.getConstructor(Application.class).newInstance(application);
                D2.k.d(e3, "{\n                try {\n…          }\n            }");
                return e3;
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            }
        }

        @Override // androidx.lifecycle.F.c, androidx.lifecycle.F.b
        public E a(Class cls) {
            D2.k.e(cls, "modelClass");
            Application application = this.f5712e;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.F.b
        public E b(Class cls, H.a aVar) {
            D2.k.e(cls, "modelClass");
            D2.k.e(aVar, "extras");
            if (this.f5712e != null) {
                return a(cls);
            }
            Application application = (Application) aVar.a(f5711h);
            if (application != null) {
                return g(cls, application);
            }
            if (AbstractC0265a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            D2.k.e(application, "application");
        }
    }

    public F(H h3, b bVar, H.a aVar) {
        D2.k.e(h3, "store");
        D2.k.e(bVar, "factory");
        D2.k.e(aVar, "defaultCreationExtras");
        this.f5706a = h3;
        this.f5707b = bVar;
        this.f5708c = aVar;
    }

    public /* synthetic */ F(H h3, b bVar, H.a aVar, int i3, D2.g gVar) {
        this(h3, bVar, (i3 & 4) != 0 ? a.C0013a.f454b : aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public F(androidx.lifecycle.I r3, androidx.lifecycle.F.b r4) {
        /*
            r2 = this;
            java.lang.String r0 = "owner"
            D2.k.e(r3, r0)
            java.lang.String r0 = "factory"
            D2.k.e(r4, r0)
            androidx.lifecycle.H r0 = r3.getViewModelStore()
            java.lang.String r1 = "owner.viewModelStore"
            D2.k.d(r0, r1)
            H.a r3 = androidx.lifecycle.G.a(r3)
            r2.<init>(r0, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.F.<init>(androidx.lifecycle.I, androidx.lifecycle.F$b):void");
    }
}
