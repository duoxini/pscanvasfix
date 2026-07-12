package e1;

import a1.t;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import f1.C0356d;
import f1.i;
import java.util.HashMap;
import java.util.Map;
import m1.AbstractC0462e;

/* renamed from: e1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0343a {

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f11463d;

    /* renamed from: a, reason: collision with root package name */
    private final i f11460a = new i();

    /* renamed from: b, reason: collision with root package name */
    private final Map f11461b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f11462c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private String f11464e = ".ttf";

    public C0343a(Drawable.Callback callback, t tVar) {
        if (callback instanceof View) {
            this.f11463d = ((View) callback).getContext().getAssets();
        } else {
            AbstractC0462e.c("EffectiveAnimationDrawable must be inside of a view for images to work.");
            this.f11463d = null;
        }
    }

    private Typeface a(C0356d c0356d) {
        String a3 = c0356d.a();
        Typeface typeface = (Typeface) this.f11462c.get(a3);
        if (typeface != null) {
            return typeface;
        }
        c0356d.c();
        c0356d.b();
        if (c0356d.d() != null) {
            return c0356d.d();
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f11463d, "fonts/" + a3 + this.f11464e);
        this.f11462c.put(a3, createFromAsset);
        return createFromAsset;
    }

    private Typeface e(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i3 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i3 ? typeface : Typeface.create(typeface, i3);
    }

    public Typeface b(C0356d c0356d) {
        this.f11460a.b(c0356d.a(), c0356d.c());
        Typeface typeface = (Typeface) this.f11461b.get(this.f11460a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e3 = e(a(c0356d), c0356d.c());
        this.f11461b.put(this.f11460a, e3);
        return e3;
    }

    public void c(String str) {
        this.f11464e = str;
    }

    public void d(t tVar) {
    }
}
