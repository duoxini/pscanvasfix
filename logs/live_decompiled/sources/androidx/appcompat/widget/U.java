package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class U extends M {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f4153b;

    public U(Context context, Resources resources) {
        super(resources);
        this.f4153b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) {
        Drawable a3 = a(i3);
        Context context = (Context) this.f4153b.get();
        if (a3 != null && context != null) {
            L.g().w(context, i3, a3);
        }
        return a3;
    }
}
