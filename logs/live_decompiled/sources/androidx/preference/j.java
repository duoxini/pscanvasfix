package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Context f6010a;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f6012c;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences.Editor f6013d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6014e;

    /* renamed from: f, reason: collision with root package name */
    private String f6015f;

    /* renamed from: g, reason: collision with root package name */
    private int f6016g;

    /* renamed from: i, reason: collision with root package name */
    private PreferenceScreen f6018i;

    /* renamed from: j, reason: collision with root package name */
    private c f6019j;

    /* renamed from: k, reason: collision with root package name */
    private a f6020k;

    /* renamed from: l, reason: collision with root package name */
    private b f6021l;

    /* renamed from: b, reason: collision with root package name */
    private long f6011b = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f6017h = 0;

    public interface a {
        void onDisplayPreferenceDialog(Preference preference);
    }

    public interface b {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    public interface c {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public static abstract class d {
    }

    public j(Context context) {
        this.f6010a = context;
        s(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    private static int c() {
        return 0;
    }

    private static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void n(boolean z3) {
        SharedPreferences.Editor editor;
        if (!z3 && (editor = this.f6013d) != null) {
            editor.apply();
        }
        this.f6014e = z3;
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f6018i;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.k(charSequence);
    }

    SharedPreferences.Editor e() {
        if (!this.f6014e) {
            return l().edit();
        }
        if (this.f6013d == null) {
            this.f6013d = l().edit();
        }
        return this.f6013d;
    }

    long f() {
        long j3;
        synchronized (this) {
            j3 = this.f6011b;
            this.f6011b = 1 + j3;
        }
        return j3;
    }

    public b g() {
        return this.f6021l;
    }

    public c h() {
        return this.f6019j;
    }

    public d i() {
        return null;
    }

    public e j() {
        return null;
    }

    public PreferenceScreen k() {
        return this.f6018i;
    }

    public SharedPreferences l() {
        j();
        if (this.f6012c == null) {
            this.f6012c = (this.f6017h != 1 ? this.f6010a : androidx.core.content.a.b(this.f6010a)).getSharedPreferences(this.f6015f, this.f6016g);
        }
        return this.f6012c;
    }

    public PreferenceScreen m(Context context, int i3, PreferenceScreen preferenceScreen) {
        n(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new i(context, this).d(i3, preferenceScreen);
        preferenceScreen2.onAttachedToHierarchy(this);
        n(false);
        return preferenceScreen2;
    }

    public void o(a aVar) {
        this.f6020k = aVar;
    }

    public void p(b bVar) {
        this.f6021l = bVar;
    }

    public void q(c cVar) {
        this.f6019j = cVar;
    }

    public boolean r(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f6018i;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.onDetached();
        }
        this.f6018i = preferenceScreen;
        return true;
    }

    public void s(String str) {
        this.f6015f = str;
        this.f6012c = null;
    }

    boolean t() {
        return !this.f6014e;
    }

    public void u(Preference preference) {
        a aVar = this.f6020k;
        if (aVar != null) {
            aVar.onDisplayPreferenceDialog(preference);
        }
    }
}
