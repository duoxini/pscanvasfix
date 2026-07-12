package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m.C0451a;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final C0451a f6762a;

    /* renamed from: b, reason: collision with root package name */
    protected final C0451a f6763b;

    /* renamed from: c, reason: collision with root package name */
    protected final C0451a f6764c;

    public a(C0451a c0451a, C0451a c0451a2, C0451a c0451a3) {
        this.f6762a = c0451a;
        this.f6763b = c0451a2;
        this.f6764c = c0451a3;
    }

    private void N(T.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e3);
        }
    }

    private Class c(Class cls) {
        Class cls2 = (Class) this.f6764c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f6764c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = (Method) this.f6762a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f6762a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) {
        Method method = (Method) this.f6763b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c3 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c3.getDeclaredMethod("write", cls, a.class);
        this.f6763b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i3) {
        w(i3);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i3) {
        w(i3);
        C(charSequence);
    }

    protected abstract void E(int i3);

    public void F(int i3, int i4) {
        w(i4);
        E(i3);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i3) {
        w(i3);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i3) {
        w(i3);
        I(str);
    }

    protected void K(T.a aVar, a aVar2) {
        try {
            e(aVar.getClass()).invoke(null, aVar, aVar2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (!(e6.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
            }
            throw ((RuntimeException) e6.getCause());
        }
    }

    protected void L(T.a aVar) {
        if (aVar == null) {
            I(null);
            return;
        }
        N(aVar);
        a b3 = b();
        K(aVar, b3);
        b3.a();
    }

    public void M(T.a aVar, int i3) {
        w(i3);
        L(aVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z3, int i3) {
        return !m(i3) ? z3 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i3) {
        return !m(i3) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i3) {
        return !m(i3) ? charSequence : k();
    }

    protected abstract boolean m(int i3);

    protected T.a n(String str, a aVar) {
        try {
            return (T.a) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    protected abstract int o();

    public int p(int i3, int i4) {
        return !m(i4) ? i3 : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i3) {
        return !m(i3) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i3) {
        return !m(i3) ? str : s();
    }

    protected T.a u() {
        String s3 = s();
        if (s3 == null) {
            return null;
        }
        return n(s3, b());
    }

    public T.a v(T.a aVar, int i3) {
        return !m(i3) ? aVar : u();
    }

    protected abstract void w(int i3);

    public void x(boolean z3, boolean z4) {
    }

    protected abstract void y(boolean z3);

    public void z(boolean z3, int i3) {
        w(i3);
        y(z3);
    }
}
