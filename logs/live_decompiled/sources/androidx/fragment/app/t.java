package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0272h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    private final h f5554a;

    /* renamed from: b, reason: collision with root package name */
    private final ClassLoader f5555b;

    /* renamed from: d, reason: collision with root package name */
    int f5557d;

    /* renamed from: e, reason: collision with root package name */
    int f5558e;

    /* renamed from: f, reason: collision with root package name */
    int f5559f;

    /* renamed from: g, reason: collision with root package name */
    int f5560g;

    /* renamed from: h, reason: collision with root package name */
    int f5561h;

    /* renamed from: i, reason: collision with root package name */
    boolean f5562i;

    /* renamed from: k, reason: collision with root package name */
    String f5564k;

    /* renamed from: l, reason: collision with root package name */
    int f5565l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f5566m;

    /* renamed from: n, reason: collision with root package name */
    int f5567n;

    /* renamed from: o, reason: collision with root package name */
    CharSequence f5568o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList f5569p;

    /* renamed from: q, reason: collision with root package name */
    ArrayList f5570q;

    /* renamed from: s, reason: collision with root package name */
    ArrayList f5572s;

    /* renamed from: c, reason: collision with root package name */
    ArrayList f5556c = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    boolean f5563j = true;

    /* renamed from: r, reason: collision with root package name */
    boolean f5571r = false;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f5573a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f5574b;

        /* renamed from: c, reason: collision with root package name */
        int f5575c;

        /* renamed from: d, reason: collision with root package name */
        int f5576d;

        /* renamed from: e, reason: collision with root package name */
        int f5577e;

        /* renamed from: f, reason: collision with root package name */
        int f5578f;

        /* renamed from: g, reason: collision with root package name */
        AbstractC0272h.c f5579g;

        /* renamed from: h, reason: collision with root package name */
        AbstractC0272h.c f5580h;

        a() {
        }

        a(int i3, Fragment fragment) {
            this.f5573a = i3;
            this.f5574b = fragment;
            AbstractC0272h.c cVar = AbstractC0272h.c.RESUMED;
            this.f5579g = cVar;
            this.f5580h = cVar;
        }
    }

    t(h hVar, ClassLoader classLoader) {
        this.f5554a = hVar;
        this.f5555b = classLoader;
    }

    public t b(int i3, Fragment fragment) {
        m(i3, fragment, null, 1);
        return this;
    }

    public t c(int i3, Fragment fragment, String str) {
        m(i3, fragment, str, 1);
        return this;
    }

    t d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public t e(Fragment fragment, String str) {
        m(0, fragment, str, 1);
        return this;
    }

    void f(a aVar) {
        this.f5556c.add(aVar);
        aVar.f5575c = this.f5557d;
        aVar.f5576d = this.f5558e;
        aVar.f5577e = this.f5559f;
        aVar.f5578f = this.f5560g;
    }

    public t g(String str) {
        if (!this.f5563j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f5562i = true;
        this.f5564k = str;
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public t l() {
        if (this.f5562i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f5563j = false;
        return this;
    }

    void m(int i3, Fragment fragment, String str, int i4) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i5 = fragment.mFragmentId;
            if (i5 != 0 && i5 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i3);
            }
            fragment.mFragmentId = i3;
            fragment.mContainerId = i3;
        }
        f(new a(i4, fragment));
    }

    public t n(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public t o(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public t p(int i3, Fragment fragment) {
        return q(i3, fragment, null);
    }

    public t q(int i3, Fragment fragment, String str) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m(i3, fragment, str, 2);
        return this;
    }

    public t r(int i3, int i4) {
        return s(i3, i4, 0, 0);
    }

    public t s(int i3, int i4, int i5, int i6) {
        this.f5557d = i3;
        this.f5558e = i4;
        this.f5559f = i5;
        this.f5560g = i6;
        return this;
    }

    public t t(boolean z3) {
        this.f5571r = z3;
        return this;
    }

    public t u(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
