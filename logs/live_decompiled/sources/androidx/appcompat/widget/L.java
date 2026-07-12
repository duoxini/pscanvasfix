package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import h.AbstractC0370b;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import m.C0454d;
import m.C0455e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: i, reason: collision with root package name */
    private static L f3972i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap f3974a;

    /* renamed from: b, reason: collision with root package name */
    private m.g f3975b;

    /* renamed from: c, reason: collision with root package name */
    private m.h f3976c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap f3977d = new WeakHashMap(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f3978e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3979f;

    /* renamed from: g, reason: collision with root package name */
    private c f3980g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f3971h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final a f3973j = new a(6);

    private static class a extends C0455e {
        public a(int i3) {
            super(i3);
        }

        private static int h(int i3, PorterDuff.Mode mode) {
            return ((i3 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i3, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i3, mode)));
        }

        PorterDuffColorFilter j(int i3, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i3, mode)), porterDuffColorFilter);
        }
    }

    private interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(L l3, Context context, int i3);

        boolean b(Context context, int i3, Drawable drawable);

        ColorStateList c(Context context, int i3);

        boolean d(Context context, int i3, Drawable drawable);

        PorterDuff.Mode e(int i3);
    }

    private synchronized boolean a(Context context, long j3, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C0454d c0454d = (C0454d) this.f3977d.get(context);
            if (c0454d == null) {
                c0454d = new C0454d();
                this.f3977d.put(context, c0454d);
            }
            c0454d.i(j3, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(Context context, int i3, ColorStateList colorStateList) {
        if (this.f3974a == null) {
            this.f3974a = new WeakHashMap();
        }
        m.h hVar = (m.h) this.f3974a.get(context);
        if (hVar == null) {
            hVar = new m.h();
            this.f3974a.put(context, hVar);
        }
        hVar.a(i3, colorStateList);
    }

    private void c(Context context) {
        if (this.f3979f) {
            return;
        }
        this.f3979f = true;
        Drawable i3 = i(context, AbstractC0370b.f11871a);
        if (i3 == null || !p(i3)) {
            this.f3979f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable e(Context context, int i3) {
        if (this.f3978e == null) {
            this.f3978e = new TypedValue();
        }
        TypedValue typedValue = this.f3978e;
        context.getResources().getValue(i3, typedValue, true);
        long d3 = d(typedValue);
        Drawable h3 = h(context, d3);
        if (h3 != null) {
            return h3;
        }
        c cVar = this.f3980g;
        Drawable a3 = cVar == null ? null : cVar.a(this, context, i3);
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, d3, a3);
        }
        return a3;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized L g() {
        L l3;
        synchronized (L.class) {
            try {
                if (f3972i == null) {
                    L l4 = new L();
                    f3972i = l4;
                    o(l4);
                }
                l3 = f3972i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return l3;
    }

    private synchronized Drawable h(Context context, long j3) {
        C0454d c0454d = (C0454d) this.f3977d.get(context);
        if (c0454d == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c0454d.e(j3);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c0454d.j(j3);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter k(int i3, PorterDuff.Mode mode) {
        PorterDuffColorFilter i4;
        synchronized (L.class) {
            a aVar = f3973j;
            i4 = aVar.i(i3, mode);
            if (i4 == null) {
                i4 = new PorterDuffColorFilter(i3, mode);
                aVar.j(i3, mode, i4);
            }
        }
        return i4;
    }

    private ColorStateList m(Context context, int i3) {
        m.h hVar;
        WeakHashMap weakHashMap = this.f3974a;
        if (weakHashMap == null || (hVar = (m.h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i3);
    }

    private static void o(L l3) {
    }

    private static boolean p(Drawable drawable) {
        return (drawable instanceof S.b) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable q(Context context, int i3) {
        int next;
        m.g gVar = this.f3975b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        m.h hVar = this.f3976c;
        if (hVar != null) {
            String str = (String) hVar.e(i3);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f3975b.get(str) == null)) {
                return null;
            }
        } else {
            this.f3976c = new m.h();
        }
        if (this.f3978e == null) {
            this.f3978e = new TypedValue();
        }
        TypedValue typedValue = this.f3978e;
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        long d3 = d(typedValue);
        Drawable h3 = h(context, d3);
        if (h3 != null) {
            return h3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i3);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f3976c.a(i3, name);
                b bVar = (b) this.f3975b.get(name);
                if (bVar != null) {
                    h3 = bVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (h3 != null) {
                    h3.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, d3, h3);
                }
            } catch (Exception e3) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e3);
            }
        }
        if (h3 == null) {
            this.f3976c.a(i3, "appcompat_skip_skip");
        }
        return h3;
    }

    private Drawable u(Context context, int i3, boolean z3, Drawable drawable) {
        ColorStateList l3 = l(context, i3);
        if (l3 == null) {
            c cVar = this.f3980g;
            if ((cVar == null || !cVar.d(context, i3, drawable)) && !w(context, i3, drawable) && z3) {
                return null;
            }
            return drawable;
        }
        if (E.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable l4 = androidx.core.graphics.drawable.a.l(drawable);
        androidx.core.graphics.drawable.a.i(l4, l3);
        PorterDuff.Mode n3 = n(i3);
        if (n3 == null) {
            return l4;
        }
        androidx.core.graphics.drawable.a.j(l4, n3);
        return l4;
    }

    static void v(Drawable drawable, T t3, int[] iArr) {
        int[] state = drawable.getState();
        if (E.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z3 = t3.f4143d;
        if (z3 || t3.f4142c) {
            drawable.setColorFilter(f(z3 ? t3.f4140a : null, t3.f4142c ? t3.f4141b : f3971h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public synchronized Drawable i(Context context, int i3) {
        return j(context, i3, false);
    }

    synchronized Drawable j(Context context, int i3, boolean z3) {
        Drawable q3;
        try {
            c(context);
            q3 = q(context, i3);
            if (q3 == null) {
                q3 = e(context, i3);
            }
            if (q3 == null) {
                q3 = androidx.core.content.a.e(context, i3);
            }
            if (q3 != null) {
                q3 = u(context, i3, z3, q3);
            }
            if (q3 != null) {
                E.b(q3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return q3;
    }

    synchronized ColorStateList l(Context context, int i3) {
        ColorStateList m3;
        m3 = m(context, i3);
        if (m3 == null) {
            c cVar = this.f3980g;
            m3 = cVar == null ? null : cVar.c(context, i3);
            if (m3 != null) {
                b(context, i3, m3);
            }
        }
        return m3;
    }

    PorterDuff.Mode n(int i3) {
        c cVar = this.f3980g;
        if (cVar == null) {
            return null;
        }
        return cVar.e(i3);
    }

    public synchronized void r(Context context) {
        C0454d c0454d = (C0454d) this.f3977d.get(context);
        if (c0454d != null) {
            c0454d.a();
        }
    }

    synchronized Drawable s(Context context, a0 a0Var, int i3) {
        try {
            Drawable q3 = q(context, i3);
            if (q3 == null) {
                q3 = a0Var.a(i3);
            }
            if (q3 == null) {
                return null;
            }
            return u(context, i3, false, q3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(c cVar) {
        this.f3980g = cVar;
    }

    boolean w(Context context, int i3, Drawable drawable) {
        c cVar = this.f3980g;
        return cVar != null && cVar.b(context, i3, drawable);
    }
}
