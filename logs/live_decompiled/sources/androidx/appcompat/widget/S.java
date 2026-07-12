package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class S extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f4019c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f4020d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f4021a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f4022b;

    private S(Context context) {
        super(context);
        if (!a0.c()) {
            this.f4021a = new U(this, context.getResources());
            this.f4022b = null;
            return;
        }
        a0 a0Var = new a0(this, context.getResources());
        this.f4021a = a0Var;
        Resources.Theme newTheme = a0Var.newTheme();
        this.f4022b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof S) || (context.getResources() instanceof U) || (context.getResources() instanceof a0)) {
            return false;
        }
        return a0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f4019c) {
            try {
                ArrayList arrayList = f4020d;
                if (arrayList == null) {
                    f4020d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f4020d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f4020d.remove(size);
                        }
                    }
                    for (int size2 = f4020d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f4020d.get(size2);
                        S s3 = weakReference2 != null ? (S) weakReference2.get() : null;
                        if (s3 != null && s3.getBaseContext() == context) {
                            return s3;
                        }
                    }
                }
                S s4 = new S(context);
                f4020d.add(new WeakReference(s4));
                return s4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f4021a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f4021a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f4022b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        Resources.Theme theme = this.f4022b;
        if (theme == null) {
            super.setTheme(i3);
        } else {
            theme.applyStyle(i3, true);
        }
    }
}
