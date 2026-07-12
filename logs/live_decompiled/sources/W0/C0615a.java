package w0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import m.C0455e;

/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0615a {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f13860c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final PorterDuff.Mode f13861d = PorterDuff.Mode.SRC_IN;

    /* renamed from: e, reason: collision with root package name */
    private static final WeakHashMap f13862e = new WeakHashMap();

    /* renamed from: f, reason: collision with root package name */
    private static final C0153a f13863f = new C0153a(6);

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f13864a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray f13865b;

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    private static class C0153a extends C0455e {
        public C0153a(int i3) {
            super(i3);
        }
    }

    private C0615a(Context context) {
        this.f13864a = new WeakReference(context);
    }

    public static C0615a a(Context context) {
        WeakHashMap weakHashMap = f13862e;
        C0615a c0615a = (C0615a) weakHashMap.get(context);
        if (c0615a != null) {
            return c0615a;
        }
        C0615a c0615a2 = new C0615a(context);
        weakHashMap.put(context, c0615a2);
        return c0615a2;
    }

    public Drawable b(int i3) {
        return c(i3, false);
    }

    public Drawable c(int i3, boolean z3) {
        Context context = (Context) this.f13864a.get();
        if (context == null) {
            return null;
        }
        Drawable e3 = androidx.core.content.a.e(context, i3);
        if (e3 != null) {
            e3 = e3.mutate();
            ColorStateList d3 = d(i3);
            if (d3 != null) {
                Drawable l3 = androidx.core.graphics.drawable.a.l(e3);
                androidx.core.graphics.drawable.a.i(l3, d3);
                PorterDuff.Mode e4 = e(i3);
                if (e4 == null) {
                    return l3;
                }
                androidx.core.graphics.drawable.a.j(l3, e4);
                return l3;
            }
            if (!f(i3, e3) && z3) {
                return null;
            }
        }
        return e3;
    }

    public final ColorStateList d(int i3) {
        if (((Context) this.f13864a.get()) == null) {
            return null;
        }
        SparseArray sparseArray = this.f13865b;
        ColorStateList colorStateList = sparseArray != null ? (ColorStateList) sparseArray.get(i3) : null;
        if (colorStateList != null) {
            if (this.f13865b == null) {
                this.f13865b = new SparseArray();
            }
            this.f13865b.append(i3, colorStateList);
        }
        return colorStateList;
    }

    final PorterDuff.Mode e(int i3) {
        return null;
    }

    public final boolean f(int i3, Drawable drawable) {
        return false;
    }
}
