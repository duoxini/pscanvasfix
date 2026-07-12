package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f3721f;

    /* renamed from: a, reason: collision with root package name */
    private int f3722a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f3723b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f3724c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f3725d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f3726e;

    static class a {
        static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d(Context context, int i3) {
        super(context);
        this.f3722a = i3;
    }

    private Resources b() {
        if (this.f3726e == null) {
            Configuration configuration = this.f3725d;
            if (configuration == null || d(configuration)) {
                this.f3726e = super.getResources();
            } else {
                this.f3726e = a.a(this, this.f3725d).getResources();
            }
        }
        return this.f3726e;
    }

    private void c() {
        boolean z3 = this.f3723b == null;
        if (z3) {
            this.f3723b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f3723b.setTo(theme);
            }
        }
        e(this.f3723b, this.f3722a, z3);
    }

    private static boolean d(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f3721f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f3721f = configuration2;
        }
        return configuration.equals(f3721f);
    }

    public void a(Configuration configuration) {
        if (this.f3726e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f3725d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f3725d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    protected void e(Resources.Theme theme, int i3, boolean z3) {
        theme.applyStyle(i3, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f3724c == null) {
            this.f3724c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f3724c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f3723b;
        if (theme != null) {
            return theme;
        }
        if (this.f3722a == 0) {
            this.f3722a = e.i.f11253d;
        }
        c();
        return this.f3723b;
    }

    public int getThemeResId() {
        return this.f3722a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        if (this.f3722a != i3) {
            this.f3722a = i3;
            c();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f3723b = theme;
    }
}
