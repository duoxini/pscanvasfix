package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C;
import androidx.appcompat.widget.C0235i;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.V;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.b0;
import androidx.core.content.res.f;
import androidx.core.view.AbstractC0257f;
import androidx.core.view.AbstractC0258g;
import androidx.core.view.E;
import androidx.core.view.G;
import androidx.core.view.J;
import androidx.core.view.y;
import androidx.lifecycle.AbstractC0272h;
import e.AbstractC0339a;
import e.AbstractC0341c;
import f.AbstractC0348a;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class g extends androidx.appcompat.app.f implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: n0, reason: collision with root package name */
    private static final m.g f3540n0 = new m.g();

    /* renamed from: o0, reason: collision with root package name */
    private static final boolean f3541o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    private static final int[] f3542p0 = {R.attr.windowBackground};

    /* renamed from: q0, reason: collision with root package name */
    private static final boolean f3543q0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: r0, reason: collision with root package name */
    private static final boolean f3544r0 = true;

    /* renamed from: A, reason: collision with root package name */
    PopupWindow f3545A;

    /* renamed from: B, reason: collision with root package name */
    Runnable f3546B;

    /* renamed from: C, reason: collision with root package name */
    E f3547C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f3548D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f3549E;

    /* renamed from: F, reason: collision with root package name */
    ViewGroup f3550F;

    /* renamed from: G, reason: collision with root package name */
    private TextView f3551G;

    /* renamed from: H, reason: collision with root package name */
    private View f3552H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f3553I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f3554J;

    /* renamed from: K, reason: collision with root package name */
    boolean f3555K;

    /* renamed from: L, reason: collision with root package name */
    boolean f3556L;

    /* renamed from: M, reason: collision with root package name */
    boolean f3557M;

    /* renamed from: N, reason: collision with root package name */
    boolean f3558N;

    /* renamed from: O, reason: collision with root package name */
    boolean f3559O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f3560P;

    /* renamed from: Q, reason: collision with root package name */
    private u[] f3561Q;

    /* renamed from: R, reason: collision with root package name */
    private u f3562R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f3563S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f3564T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f3565U;

    /* renamed from: V, reason: collision with root package name */
    boolean f3566V;

    /* renamed from: W, reason: collision with root package name */
    private Configuration f3567W;

    /* renamed from: X, reason: collision with root package name */
    private int f3568X;

    /* renamed from: Y, reason: collision with root package name */
    private int f3569Y;

    /* renamed from: Z, reason: collision with root package name */
    private int f3570Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f3571a0;

    /* renamed from: b0, reason: collision with root package name */
    private q f3572b0;

    /* renamed from: c0, reason: collision with root package name */
    private q f3573c0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f3574d0;

    /* renamed from: e0, reason: collision with root package name */
    int f3575e0;

    /* renamed from: f0, reason: collision with root package name */
    private final Runnable f3576f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f3577g0;

    /* renamed from: h0, reason: collision with root package name */
    private Rect f3578h0;

    /* renamed from: i0, reason: collision with root package name */
    private Rect f3579i0;

    /* renamed from: j0, reason: collision with root package name */
    private androidx.appcompat.app.l f3580j0;

    /* renamed from: k0, reason: collision with root package name */
    private androidx.appcompat.app.o f3581k0;

    /* renamed from: l0, reason: collision with root package name */
    private OnBackInvokedDispatcher f3582l0;

    /* renamed from: m0, reason: collision with root package name */
    private OnBackInvokedCallback f3583m0;

    /* renamed from: n, reason: collision with root package name */
    final Object f3584n;

    /* renamed from: o, reason: collision with root package name */
    final Context f3585o;

    /* renamed from: p, reason: collision with root package name */
    Window f3586p;

    /* renamed from: q, reason: collision with root package name */
    private o f3587q;

    /* renamed from: r, reason: collision with root package name */
    final androidx.appcompat.app.d f3588r;

    /* renamed from: s, reason: collision with root package name */
    androidx.appcompat.app.a f3589s;

    /* renamed from: t, reason: collision with root package name */
    MenuInflater f3590t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f3591u;

    /* renamed from: v, reason: collision with root package name */
    private C f3592v;

    /* renamed from: w, reason: collision with root package name */
    private h f3593w;

    /* renamed from: x, reason: collision with root package name */
    private v f3594x;

    /* renamed from: y, reason: collision with root package name */
    androidx.appcompat.view.b f3595y;

    /* renamed from: z, reason: collision with root package name */
    ActionBarContextView f3596z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if ((gVar.f3575e0 & 1) != 0) {
                gVar.f0(0);
            }
            g gVar2 = g.this;
            if ((gVar2.f3575e0 & 4096) != 0) {
                gVar2.f0(108);
            }
            g gVar3 = g.this;
            gVar3.f3574d0 = false;
            gVar3.f3575e0 = 0;
        }
    }

    class b implements androidx.core.view.t {
        b() {
        }

        @Override // androidx.core.view.t
        public J onApplyWindowInsets(View view, J j3) {
            int k3 = j3.k();
            int b12 = g.this.b1(j3, null);
            if (k3 != b12) {
                j3 = j3.q(j3.i(), b12, j3.j(), j3.h());
            }
            return y.V(view, j3);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            g.this.d0();
        }
    }

    class d implements Runnable {

        class a extends G {
            a() {
            }

            @Override // androidx.core.view.F
            public void a(View view) {
                g.this.f3596z.setAlpha(1.0f);
                g.this.f3547C.h(null);
                g.this.f3547C = null;
            }

            @Override // androidx.core.view.G, androidx.core.view.F
            public void b(View view) {
                g.this.f3596z.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.f3545A.showAtLocation(gVar.f3596z, 55, 0, 0);
            g.this.g0();
            if (!g.this.R0()) {
                g.this.f3596z.setAlpha(1.0f);
                g.this.f3596z.setVisibility(0);
            } else {
                g.this.f3596z.setAlpha(0.0f);
                g gVar2 = g.this;
                gVar2.f3547C = y.d(gVar2.f3596z).b(1.0f);
                g.this.f3547C.h(new a());
            }
        }
    }

    class e extends G {
        e() {
        }

        @Override // androidx.core.view.F
        public void a(View view) {
            g.this.f3596z.setAlpha(1.0f);
            g.this.f3547C.h(null);
            g.this.f3547C = null;
        }

        @Override // androidx.core.view.G, androidx.core.view.F
        public void b(View view) {
            g.this.f3596z.setVisibility(0);
            if (g.this.f3596z.getParent() instanceof View) {
                y.f0((View) g.this.f3596z.getParent());
            }
        }
    }

    private class f implements androidx.appcompat.app.b {
        f() {
        }
    }

    /* renamed from: androidx.appcompat.app.g$g, reason: collision with other inner class name */
    interface InterfaceC0055g {
        boolean a(int i3);

        View onCreatePanelView(int i3);
    }

    private final class h implements MenuPresenter.Callback {
        h() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
            g.this.W(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback s02 = g.this.s0();
            if (s02 == null) {
                return true;
            }
            s02.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    class i implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f3605a;

        class a extends G {
            a() {
            }

            @Override // androidx.core.view.F
            public void a(View view) {
                g.this.f3596z.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.f3545A;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.f3596z.getParent() instanceof View) {
                    y.f0((View) g.this.f3596z.getParent());
                }
                g.this.f3596z.k();
                g.this.f3547C.h(null);
                g gVar2 = g.this;
                gVar2.f3547C = null;
                y.f0(gVar2.f3550F);
            }
        }

        public i(b.a aVar) {
            this.f3605a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            y.f0(g.this.f3550F);
            return this.f3605a.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f3605a.b(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f3605a.c(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public void d(androidx.appcompat.view.b bVar) {
            this.f3605a.d(bVar);
            g gVar = g.this;
            if (gVar.f3545A != null) {
                gVar.f3586p.getDecorView().removeCallbacks(g.this.f3546B);
            }
            g gVar2 = g.this;
            if (gVar2.f3596z != null) {
                gVar2.g0();
                g gVar3 = g.this;
                gVar3.f3547C = y.d(gVar3.f3596z).b(0.0f);
                g.this.f3547C.h(new a());
            }
            g gVar4 = g.this;
            androidx.appcompat.app.d dVar = gVar4.f3588r;
            if (dVar != null) {
                dVar.onSupportActionModeFinished(gVar4.f3595y);
            }
            g gVar5 = g.this;
            gVar5.f3595y = null;
            y.f0(gVar5.f3550F);
            g.this.Z0();
        }
    }

    static class j {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i3 = configuration.densityDpi;
            int i4 = configuration2.densityDpi;
            if (i3 != i4) {
                configuration3.densityDpi = i4;
            }
        }

        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    static class k {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class l {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static androidx.core.os.f b(Configuration configuration) {
            return androidx.core.os.f.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.f fVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(fVar.e()));
        }

        static void d(Configuration configuration, androidx.core.os.f fVar) {
            configuration.setLocales(LocaleList.forLanguageTags(fVar.e()));
        }
    }

    static class m {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i3 = configuration.colorMode & 3;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 3)) {
                configuration3.colorMode |= i4 & 3;
            }
            int i5 = configuration.colorMode & 12;
            int i6 = configuration2.colorMode;
            if (i5 != (i6 & 12)) {
                configuration3.colorMode |= i6 & 12;
            }
        }
    }

    static class n {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final g gVar) {
            Objects.requireNonNull(gVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.h
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    g.this.A0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    class o extends androidx.appcompat.view.i {

        /* renamed from: f, reason: collision with root package name */
        private InterfaceC0055g f3608f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3609g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3610h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f3611i;

        o(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f3610h = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f3610h = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f3609g = true;
                callback.onContentChanged();
            } finally {
                this.f3609g = false;
            }
        }

        public void d(Window.Callback callback, int i3, Menu menu) {
            try {
                this.f3611i = true;
                callback.onPanelClosed(i3, menu);
            } finally {
                this.f3611i = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f3610h ? a().dispatchKeyEvent(keyEvent) : g.this.e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.D0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(InterfaceC0055g interfaceC0055g) {
            this.f3608f = interfaceC0055g;
        }

        final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(g.this.f3585o, callback);
            androidx.appcompat.view.b M3 = g.this.M(aVar);
            if (M3 != null) {
                return aVar.e(M3);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f3609g) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i3, Menu menu) {
            if (i3 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i3, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i3) {
            View onCreatePanelView;
            InterfaceC0055g interfaceC0055g = this.f3608f;
            return (interfaceC0055g == null || (onCreatePanelView = interfaceC0055g.onCreatePanelView(i3)) == null) ? super.onCreatePanelView(i3) : onCreatePanelView;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i3, Menu menu) {
            super.onMenuOpened(i3, menu);
            g.this.G0(i3);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i3, Menu menu) {
            if (this.f3611i) {
                a().onPanelClosed(i3, menu);
            } else {
                super.onPanelClosed(i3, menu);
                g.this.H0(i3);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i3, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i3 == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            InterfaceC0055g interfaceC0055g = this.f3608f;
            boolean z3 = interfaceC0055g != null && interfaceC0055g.a(i3);
            if (!z3) {
                z3 = super.onPreparePanel(i3, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z3;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i3) {
            MenuBuilder menuBuilder;
            u q02 = g.this.q0(0, true);
            if (q02 == null || (menuBuilder = q02.f3630j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i3);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i3);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
            return (g.this.y0() && i3 == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i3);
        }
    }

    private class p extends q {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f3613c;

        p(Context context) {
            super();
            this.f3613c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.g.q
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.g.q
        public int c() {
            return k.a(this.f3613c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.g.q
        public void d() {
            g.this.Q();
        }
    }

    abstract class q {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f3615a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                q.this.d();
            }
        }

        q() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f3615a;
            if (broadcastReceiver != null) {
                try {
                    g.this.f3585o.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f3615a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b3 = b();
            if (b3 == null || b3.countActions() == 0) {
                return;
            }
            if (this.f3615a == null) {
                this.f3615a = new a();
            }
            g.this.f3585o.registerReceiver(this.f3615a, b3);
        }
    }

    private class r extends q {

        /* renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.s f3618c;

        r(androidx.appcompat.app.s sVar) {
            super();
            this.f3618c = sVar;
        }

        @Override // androidx.appcompat.app.g.q
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.g.q
        public int c() {
            return this.f3618c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.g.q
        public void d() {
            g.this.Q();
        }
    }

    private static class s {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class t extends ContentFrameLayout {
        public t(Context context) {
            super(context);
        }

        private boolean b(int i3, int i4) {
            return i3 < -5 || i4 < -5 || i3 > getWidth() + 5 || i4 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            g.this.Y(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i3) {
            setBackgroundDrawable(AbstractC0348a.b(getContext(), i3));
        }
    }

    protected static final class u {

        /* renamed from: a, reason: collision with root package name */
        int f3621a;

        /* renamed from: b, reason: collision with root package name */
        int f3622b;

        /* renamed from: c, reason: collision with root package name */
        int f3623c;

        /* renamed from: d, reason: collision with root package name */
        int f3624d;

        /* renamed from: e, reason: collision with root package name */
        int f3625e;

        /* renamed from: f, reason: collision with root package name */
        int f3626f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f3627g;

        /* renamed from: h, reason: collision with root package name */
        View f3628h;

        /* renamed from: i, reason: collision with root package name */
        View f3629i;

        /* renamed from: j, reason: collision with root package name */
        MenuBuilder f3630j;

        /* renamed from: k, reason: collision with root package name */
        ListMenuPresenter f3631k;

        /* renamed from: l, reason: collision with root package name */
        Context f3632l;

        /* renamed from: m, reason: collision with root package name */
        boolean f3633m;

        /* renamed from: n, reason: collision with root package name */
        boolean f3634n;

        /* renamed from: o, reason: collision with root package name */
        boolean f3635o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f3636p;

        /* renamed from: q, reason: collision with root package name */
        boolean f3637q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f3638r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f3639s;

        u(int i3) {
            this.f3621a = i3;
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.f3630j == null) {
                return null;
            }
            if (this.f3631k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f3632l, e.g.f11225j);
                this.f3631k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.f3630j.addMenuPresenter(this.f3631k);
            }
            return this.f3631k.getMenuView(this.f3627g);
        }

        public boolean b() {
            if (this.f3628h == null) {
                return false;
            }
            return this.f3629i != null || this.f3631k.getAdapter().getCount() > 0;
        }

        void c(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f3630j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.f3631k);
            }
            this.f3630j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.f3631k) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(AbstractC0339a.f11086a, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            }
            newTheme.resolveAttribute(AbstractC0339a.f11074C, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                newTheme.applyStyle(i4, true);
            } else {
                newTheme.applyStyle(e.i.f11251b, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f3632l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(e.j.f11453y0);
            this.f3622b = obtainStyledAttributes.getResourceId(e.j.f11259B0, 0);
            this.f3626f = obtainStyledAttributes.getResourceId(e.j.f11255A0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private final class v implements MenuPresenter.Callback {
        v() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z4 = rootMenu != menuBuilder;
            g gVar = g.this;
            if (z4) {
                menuBuilder = rootMenu;
            }
            u j02 = gVar.j0(menuBuilder);
            if (j02 != null) {
                if (!z4) {
                    g.this.Z(j02, z3);
                } else {
                    g.this.V(j02.f3621a, j02, rootMenu);
                    g.this.Z(j02, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback s02;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            g gVar = g.this;
            if (!gVar.f3555K || (s02 = gVar.s0()) == null || g.this.f3566V) {
                return true;
            }
            s02.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    g(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    private boolean C0(int i3, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        u q02 = q0(i3, true);
        if (q02.f3635o) {
            return false;
        }
        return M0(q02, keyEvent);
    }

    private boolean F0(int i3, KeyEvent keyEvent) {
        boolean z3;
        C c3;
        if (this.f3595y != null) {
            return false;
        }
        boolean z4 = true;
        u q02 = q0(i3, true);
        if (i3 != 0 || (c3 = this.f3592v) == null || !c3.g() || ViewConfiguration.get(this.f3585o).hasPermanentMenuKey()) {
            boolean z5 = q02.f3635o;
            if (z5 || q02.f3634n) {
                Z(q02, true);
                z4 = z5;
            } else {
                if (q02.f3633m) {
                    if (q02.f3638r) {
                        q02.f3633m = false;
                        z3 = M0(q02, keyEvent);
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        J0(q02, keyEvent);
                    }
                }
                z4 = false;
            }
        } else if (this.f3592v.c()) {
            z4 = this.f3592v.d();
        } else {
            if (!this.f3566V && M0(q02, keyEvent)) {
                z4 = this.f3592v.e();
            }
            z4 = false;
        }
        if (z4) {
            AudioManager audioManager = (AudioManager) this.f3585o.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void J0(androidx.appcompat.app.g.u r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.J0(androidx.appcompat.app.g$u, android.view.KeyEvent):void");
    }

    private boolean L0(u uVar, int i3, KeyEvent keyEvent, int i4) {
        MenuBuilder menuBuilder;
        boolean z3 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((uVar.f3633m || M0(uVar, keyEvent)) && (menuBuilder = uVar.f3630j) != null) {
            z3 = menuBuilder.performShortcut(i3, keyEvent, i4);
        }
        if (z3 && (i4 & 1) == 0 && this.f3592v == null) {
            Z(uVar, true);
        }
        return z3;
    }

    private boolean M0(u uVar, KeyEvent keyEvent) {
        C c3;
        C c4;
        C c5;
        if (this.f3566V) {
            return false;
        }
        if (uVar.f3633m) {
            return true;
        }
        u uVar2 = this.f3562R;
        if (uVar2 != null && uVar2 != uVar) {
            Z(uVar2, false);
        }
        Window.Callback s02 = s0();
        if (s02 != null) {
            uVar.f3629i = s02.onCreatePanelView(uVar.f3621a);
        }
        int i3 = uVar.f3621a;
        boolean z3 = i3 == 0 || i3 == 108;
        if (z3 && (c5 = this.f3592v) != null) {
            c5.f();
        }
        if (uVar.f3629i == null && (!z3 || !(K0() instanceof androidx.appcompat.app.q))) {
            MenuBuilder menuBuilder = uVar.f3630j;
            if (menuBuilder == null || uVar.f3638r) {
                if (menuBuilder == null && (!w0(uVar) || uVar.f3630j == null)) {
                    return false;
                }
                if (z3 && this.f3592v != null) {
                    if (this.f3593w == null) {
                        this.f3593w = new h();
                    }
                    this.f3592v.a(uVar.f3630j, this.f3593w);
                }
                uVar.f3630j.stopDispatchingItemsChanged();
                if (!s02.onCreatePanelMenu(uVar.f3621a, uVar.f3630j)) {
                    uVar.c(null);
                    if (z3 && (c3 = this.f3592v) != null) {
                        c3.a(null, this.f3593w);
                    }
                    return false;
                }
                uVar.f3638r = false;
            }
            uVar.f3630j.stopDispatchingItemsChanged();
            Bundle bundle = uVar.f3639s;
            if (bundle != null) {
                uVar.f3630j.restoreActionViewStates(bundle);
                uVar.f3639s = null;
            }
            if (!s02.onPreparePanel(0, uVar.f3629i, uVar.f3630j)) {
                if (z3 && (c4 = this.f3592v) != null) {
                    c4.a(null, this.f3593w);
                }
                uVar.f3630j.startDispatchingItemsChanged();
                return false;
            }
            boolean z4 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            uVar.f3636p = z4;
            uVar.f3630j.setQwertyMode(z4);
            uVar.f3630j.startDispatchingItemsChanged();
        }
        uVar.f3633m = true;
        uVar.f3634n = false;
        this.f3562R = uVar;
        return true;
    }

    private void N0(boolean z3) {
        C c3 = this.f3592v;
        if (c3 == null || !c3.g() || (ViewConfiguration.get(this.f3585o).hasPermanentMenuKey() && !this.f3592v.b())) {
            u q02 = q0(0, true);
            q02.f3637q = true;
            Z(q02, false);
            J0(q02, null);
            return;
        }
        Window.Callback s02 = s0();
        if (this.f3592v.c() && z3) {
            this.f3592v.d();
            if (this.f3566V) {
                return;
            }
            s02.onPanelClosed(108, q0(0, true).f3630j);
            return;
        }
        if (s02 == null || this.f3566V) {
            return;
        }
        if (this.f3574d0 && (this.f3575e0 & 1) != 0) {
            this.f3586p.getDecorView().removeCallbacks(this.f3576f0);
            this.f3576f0.run();
        }
        u q03 = q0(0, true);
        MenuBuilder menuBuilder = q03.f3630j;
        if (menuBuilder == null || q03.f3638r || !s02.onPreparePanel(0, q03.f3629i, menuBuilder)) {
            return;
        }
        s02.onMenuOpened(108, q03.f3630j);
        this.f3592v.e();
    }

    private boolean O(boolean z3) {
        return P(z3, true);
    }

    private int O0(int i3) {
        if (i3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i3 != 9) {
            return i3;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean P(boolean z3, boolean z4) {
        if (this.f3566V) {
            return false;
        }
        int U3 = U();
        boolean Y02 = Y0(z0(this.f3585o, U3), null, z3);
        if (U3 == 0) {
            o0(this.f3585o).e();
        } else {
            q qVar = this.f3572b0;
            if (qVar != null) {
                qVar.a();
            }
        }
        if (U3 == 3) {
            n0(this.f3585o).e();
        } else {
            q qVar2 = this.f3573c0;
            if (qVar2 != null) {
                qVar2.a();
            }
        }
        return Y02;
    }

    private void R() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f3550F.findViewById(R.id.content);
        View decorView = this.f3586p.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f3585o.obtainStyledAttributes(e.j.f11453y0);
        obtainStyledAttributes.getValue(e.j.f11295K0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(e.j.f11299L0, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(e.j.f11287I0)) {
            obtainStyledAttributes.getValue(e.j.f11287I0, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(e.j.f11291J0)) {
            obtainStyledAttributes.getValue(e.j.f11291J0, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(e.j.f11279G0)) {
            obtainStyledAttributes.getValue(e.j.f11279G0, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(e.j.f11283H0)) {
            obtainStyledAttributes.getValue(e.j.f11283H0, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void S(Window window) {
        if (this.f3586p != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof o) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        o oVar = new o(callback);
        this.f3587q = oVar;
        window.setCallback(oVar);
        V v3 = V.v(this.f3585o, null, f3542p0);
        Drawable h3 = v3.h(0);
        if (h3 != null) {
            window.setBackgroundDrawable(h3);
        }
        v3.x();
        this.f3586p = window;
        if (this.f3582l0 == null) {
            I(null);
        }
    }

    private boolean S0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f3586p.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || y.N((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int U() {
        int i3 = this.f3568X;
        return i3 != -100 ? i3 : androidx.appcompat.app.f.k();
    }

    private void V0() {
        if (this.f3549E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity W0() {
        for (Context context = this.f3585o; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void X() {
        q qVar = this.f3572b0;
        if (qVar != null) {
            qVar.a();
        }
        q qVar2 = this.f3573c0;
        if (qVar2 != null) {
            qVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X0(Configuration configuration) {
        Activity activity = (Activity) this.f3584n;
        if (activity instanceof androidx.lifecycle.o) {
            if (((androidx.lifecycle.o) activity).getLifecycle().b().a(AbstractC0272h.c.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.f3565U || this.f3566V) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean Y0(int r9, androidx.core.os.f r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f3585o
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.a0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f3585o
            int r1 = r8.m0(r1)
            android.content.res.Configuration r2 = r8.f3567W
            if (r2 != 0) goto L1f
            android.content.Context r2 = r8.f3585o
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.f r2 = r8.p0(r2)
            r5 = 0
            if (r10 != 0) goto L30
            r0 = r5
            goto L34
        L30:
            androidx.core.os.f r0 = r8.p0(r0)
        L34:
            r6 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.175E-43)
            goto L3b
        L3a:
            r3 = r6
        L3b:
            if (r0 == 0) goto L45
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L6f
            if (r11 == 0) goto L6f
            boolean r11 = r8.f3564T
            if (r11 == 0) goto L6f
            boolean r11 = androidx.appcompat.app.g.f3543q0
            if (r11 != 0) goto L58
            boolean r11 = r8.f3565U
            if (r11 == 0) goto L6f
        L58:
            java.lang.Object r11 = r8.f3584n
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L6f
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L6f
            java.lang.Object r11 = r8.f3584n
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.a.m(r11)
            r11 = r7
            goto L70
        L6f:
            r11 = r6
        L70:
            if (r11 != 0) goto L7d
            if (r3 == 0) goto L7d
            r11 = r3 & r1
            if (r11 != r3) goto L79
            r6 = r7
        L79:
            r8.a1(r4, r0, r6, r5)
            goto L7e
        L7d:
            r7 = r11
        L7e:
            if (r7 == 0) goto L9a
            java.lang.Object r11 = r8.f3584n
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L9a
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L8f
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L8f:
            r9 = r3 & 4
            if (r9 == 0) goto L9a
            java.lang.Object r9 = r8.f3584n
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L9a:
            if (r7 == 0) goto Laf
            if (r0 == 0) goto Laf
            android.content.Context r9 = r8.f3585o
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.f r9 = r8.p0(r9)
            r8.Q0(r9)
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.Y0(int, androidx.core.os.f, boolean):boolean");
    }

    private Configuration a0(Context context, int i3, androidx.core.os.f fVar, Configuration configuration, boolean z3) {
        int i4 = i3 != 1 ? i3 != 2 ? z3 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        if (fVar != null) {
            P0(configuration2, fVar);
        }
        return configuration2;
    }

    private void a1(int i3, androidx.core.os.f fVar, boolean z3, Configuration configuration) {
        Resources resources = this.f3585o.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i3 | (resources.getConfiguration().uiMode & (-49));
        if (fVar != null) {
            P0(configuration2, fVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i4 = this.f3569Y;
        if (i4 != 0) {
            this.f3585o.setTheme(i4);
            this.f3585o.getTheme().applyStyle(this.f3569Y, true);
        }
        if (z3 && (this.f3584n instanceof Activity)) {
            X0(configuration2);
        }
    }

    private ViewGroup b0() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f3585o.obtainStyledAttributes(e.j.f11453y0);
        if (!obtainStyledAttributes.hasValue(e.j.f11267D0)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(e.j.f11303M0, false)) {
            E(1);
        } else if (obtainStyledAttributes.getBoolean(e.j.f11267D0, false)) {
            E(108);
        }
        if (obtainStyledAttributes.getBoolean(e.j.f11271E0, false)) {
            E(109);
        }
        if (obtainStyledAttributes.getBoolean(e.j.f11275F0, false)) {
            E(10);
        }
        this.f3558N = obtainStyledAttributes.getBoolean(e.j.f11457z0, false);
        obtainStyledAttributes.recycle();
        i0();
        this.f3586p.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f3585o);
        if (this.f3559O) {
            viewGroup = this.f3557M ? (ViewGroup) from.inflate(e.g.f11230o, (ViewGroup) null) : (ViewGroup) from.inflate(e.g.f11229n, (ViewGroup) null);
        } else if (this.f3558N) {
            viewGroup = (ViewGroup) from.inflate(e.g.f11221f, (ViewGroup) null);
            this.f3556L = false;
            this.f3555K = false;
        } else if (this.f3555K) {
            TypedValue typedValue = new TypedValue();
            this.f3585o.getTheme().resolveAttribute(AbstractC0339a.f11089d, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f3585o, typedValue.resourceId) : this.f3585o).inflate(e.g.f11231p, (ViewGroup) null);
            C c3 = (C) viewGroup.findViewById(e.f.f11205p);
            this.f3592v = c3;
            c3.setWindowCallback(s0());
            if (this.f3556L) {
                this.f3592v.k(109);
            }
            if (this.f3553I) {
                this.f3592v.k(2);
            }
            if (this.f3554J) {
                this.f3592v.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f3555K + ", windowActionBarOverlay: " + this.f3556L + ", android:windowIsFloating: " + this.f3558N + ", windowActionModeOverlay: " + this.f3557M + ", windowNoTitle: " + this.f3559O + " }");
        }
        y.x0(viewGroup, new b());
        if (this.f3592v == null) {
            this.f3551G = (TextView) viewGroup.findViewById(e.f.f11186L);
        }
        b0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(e.f.f11191b);
        ViewGroup viewGroup2 = (ViewGroup) this.f3586p.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f3586p.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void c1(View view) {
        view.setBackgroundColor((y.H(view) & 8192) != 0 ? androidx.core.content.a.c(this.f3585o, AbstractC0341c.f11114b) : androidx.core.content.a.c(this.f3585o, AbstractC0341c.f11113a));
    }

    private void h0() {
        if (this.f3549E) {
            return;
        }
        this.f3550F = b0();
        CharSequence r02 = r0();
        if (!TextUtils.isEmpty(r02)) {
            C c3 = this.f3592v;
            if (c3 != null) {
                c3.setWindowTitle(r02);
            } else if (K0() != null) {
                K0().u(r02);
            } else {
                TextView textView = this.f3551G;
                if (textView != null) {
                    textView.setText(r02);
                }
            }
        }
        R();
        I0(this.f3550F);
        this.f3549E = true;
        u q02 = q0(0, false);
        if (this.f3566V) {
            return;
        }
        if (q02 == null || q02.f3630j == null) {
            x0(108);
        }
    }

    private void i0() {
        if (this.f3586p == null) {
            Object obj = this.f3584n;
            if (obj instanceof Activity) {
                S(((Activity) obj).getWindow());
            }
        }
        if (this.f3586p == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration k0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f3 = configuration.fontScale;
            float f4 = configuration2.fontScale;
            if (f3 != f4) {
                configuration3.fontScale = f4;
            }
            int i3 = configuration.mcc;
            int i4 = configuration2.mcc;
            if (i3 != i4) {
                configuration3.mcc = i4;
            }
            int i5 = configuration.mnc;
            int i6 = configuration2.mnc;
            if (i5 != i6) {
                configuration3.mnc = i6;
            }
            l.a(configuration, configuration2, configuration3);
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            m.a(configuration, configuration2, configuration3);
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            j.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int m0(Context context) {
        if (!this.f3571a0 && (this.f3584n instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f3584n.getClass()), 269221888);
                if (activityInfo != null) {
                    this.f3570Z = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e3);
                this.f3570Z = 0;
            }
        }
        this.f3571a0 = true;
        return this.f3570Z;
    }

    private q n0(Context context) {
        if (this.f3573c0 == null) {
            this.f3573c0 = new p(context);
        }
        return this.f3573c0;
    }

    private q o0(Context context) {
        if (this.f3572b0 == null) {
            this.f3572b0 = new r(androidx.appcompat.app.s.a(context));
        }
        return this.f3572b0;
    }

    private void t0() {
        h0();
        if (this.f3555K && this.f3589s == null) {
            Object obj = this.f3584n;
            if (obj instanceof Activity) {
                this.f3589s = new androidx.appcompat.app.t((Activity) this.f3584n, this.f3556L);
            } else if (obj instanceof Dialog) {
                this.f3589s = new androidx.appcompat.app.t((Dialog) this.f3584n);
            }
            androidx.appcompat.app.a aVar = this.f3589s;
            if (aVar != null) {
                aVar.r(this.f3577g0);
            }
        }
    }

    private boolean u0(u uVar) {
        View view = uVar.f3629i;
        if (view != null) {
            uVar.f3628h = view;
            return true;
        }
        if (uVar.f3630j == null) {
            return false;
        }
        if (this.f3594x == null) {
            this.f3594x = new v();
        }
        View view2 = (View) uVar.a(this.f3594x);
        uVar.f3628h = view2;
        return view2 != null;
    }

    private boolean v0(u uVar) {
        uVar.d(l0());
        uVar.f3627g = new t(uVar.f3632l);
        uVar.f3623c = 81;
        return true;
    }

    private boolean w0(u uVar) {
        Resources.Theme theme;
        Context context = this.f3585o;
        int i3 = uVar.f3621a;
        if ((i3 == 0 || i3 == 108) && this.f3592v != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(AbstractC0339a.f11089d, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(AbstractC0339a.f11090e, typedValue, true);
            } else {
                theme2.resolveAttribute(AbstractC0339a.f11090e, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        uVar.c(menuBuilder);
        return true;
    }

    private void x0(int i3) {
        this.f3575e0 = (1 << i3) | this.f3575e0;
        if (this.f3574d0) {
            return;
        }
        y.a0(this.f3586p.getDecorView(), this.f3576f0);
        this.f3574d0 = true;
    }

    @Override // androidx.appcompat.app.f
    public void A() {
        P(true, false);
    }

    boolean A0() {
        boolean z3 = this.f3563S;
        this.f3563S = false;
        u q02 = q0(0, false);
        if (q02 != null && q02.f3635o) {
            if (!z3) {
                Z(q02, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f3595y;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        androidx.appcompat.app.a p3 = p();
        return p3 != null && p3.h();
    }

    @Override // androidx.appcompat.app.f
    public void B() {
        androidx.appcompat.app.a p3 = p();
        if (p3 != null) {
            p3.t(false);
        }
    }

    boolean B0(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.f3563S = (keyEvent.getFlags() & 128) != 0;
        } else if (i3 == 82) {
            C0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean D0(int i3, KeyEvent keyEvent) {
        androidx.appcompat.app.a p3 = p();
        if (p3 != null && p3.o(i3, keyEvent)) {
            return true;
        }
        u uVar = this.f3562R;
        if (uVar != null && L0(uVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            u uVar2 = this.f3562R;
            if (uVar2 != null) {
                uVar2.f3634n = true;
            }
            return true;
        }
        if (this.f3562R == null) {
            u q02 = q0(0, true);
            M0(q02, keyEvent);
            boolean L02 = L0(q02, keyEvent.getKeyCode(), keyEvent, 1);
            q02.f3633m = false;
            if (L02) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public boolean E(int i3) {
        int O02 = O0(i3);
        if (this.f3559O && O02 == 108) {
            return false;
        }
        if (this.f3555K && O02 == 1) {
            this.f3555K = false;
        }
        if (O02 == 1) {
            V0();
            this.f3559O = true;
            return true;
        }
        if (O02 == 2) {
            V0();
            this.f3553I = true;
            return true;
        }
        if (O02 == 5) {
            V0();
            this.f3554J = true;
            return true;
        }
        if (O02 == 10) {
            V0();
            this.f3557M = true;
            return true;
        }
        if (O02 == 108) {
            V0();
            this.f3555K = true;
            return true;
        }
        if (O02 != 109) {
            return this.f3586p.requestFeature(O02);
        }
        V0();
        this.f3556L = true;
        return true;
    }

    boolean E0(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            if (i3 == 82) {
                F0(0, keyEvent);
                return true;
            }
        } else if (A0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void F(int i3) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.f3550F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3585o).inflate(i3, viewGroup);
        this.f3587q.c(this.f3586p.getCallback());
    }

    @Override // androidx.appcompat.app.f
    public void G(View view) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.f3550F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3587q.c(this.f3586p.getCallback());
    }

    void G0(int i3) {
        androidx.appcompat.app.a p3;
        if (i3 != 108 || (p3 = p()) == null) {
            return;
        }
        p3.i(true);
    }

    @Override // androidx.appcompat.app.f
    public void H(View view, ViewGroup.LayoutParams layoutParams) {
        h0();
        ViewGroup viewGroup = (ViewGroup) this.f3550F.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3587q.c(this.f3586p.getCallback());
    }

    void H0(int i3) {
        if (i3 == 108) {
            androidx.appcompat.app.a p3 = p();
            if (p3 != null) {
                p3.i(false);
                return;
            }
            return;
        }
        if (i3 == 0) {
            u q02 = q0(i3, true);
            if (q02.f3635o) {
                Z(q02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public void I(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.I(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f3582l0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f3583m0) != null) {
            n.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f3583m0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f3584n;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f3582l0 = n.a((Activity) this.f3584n);
                Z0();
            }
        }
        this.f3582l0 = onBackInvokedDispatcher;
        Z0();
    }

    void I0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.f
    public void J(Toolbar toolbar) {
        if (this.f3584n instanceof Activity) {
            androidx.appcompat.app.a p3 = p();
            if (p3 instanceof androidx.appcompat.app.t) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f3590t = null;
            if (p3 != null) {
                p3.n();
            }
            this.f3589s = null;
            if (toolbar != null) {
                androidx.appcompat.app.q qVar = new androidx.appcompat.app.q(toolbar, r0(), this.f3587q);
                this.f3589s = qVar;
                this.f3587q.e(qVar.f3656c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f3587q.e(null);
            }
            r();
        }
    }

    @Override // androidx.appcompat.app.f
    public void K(int i3) {
        this.f3569Y = i3;
    }

    final androidx.appcompat.app.a K0() {
        return this.f3589s;
    }

    @Override // androidx.appcompat.app.f
    public final void L(CharSequence charSequence) {
        this.f3591u = charSequence;
        C c3 = this.f3592v;
        if (c3 != null) {
            c3.setWindowTitle(charSequence);
            return;
        }
        if (K0() != null) {
            K0().u(charSequence);
            return;
        }
        TextView textView = this.f3551G;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.view.b M(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f3595y;
        if (bVar != null) {
            bVar.a();
        }
        i iVar = new i(aVar);
        androidx.appcompat.app.a p3 = p();
        if (p3 != null) {
            androidx.appcompat.view.b v3 = p3.v(iVar);
            this.f3595y = v3;
            if (v3 != null && (dVar = this.f3588r) != null) {
                dVar.onSupportActionModeStarted(v3);
            }
        }
        if (this.f3595y == null) {
            this.f3595y = U0(iVar);
        }
        Z0();
        return this.f3595y;
    }

    void P0(Configuration configuration, androidx.core.os.f fVar) {
        l.d(configuration, fVar);
    }

    public boolean Q() {
        return O(true);
    }

    void Q0(androidx.core.os.f fVar) {
        l.c(fVar);
    }

    final boolean R0() {
        ViewGroup viewGroup;
        return this.f3549E && (viewGroup = this.f3550F) != null && y.O(viewGroup);
    }

    androidx.core.os.f T(Context context) {
        return null;
    }

    boolean T0() {
        if (this.f3582l0 == null) {
            return false;
        }
        u q02 = q0(0, false);
        return (q02 != null && q02.f3635o) || this.f3595y != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.appcompat.view.b U0(androidx.appcompat.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.U0(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    void V(int i3, u uVar, Menu menu) {
        if (menu == null) {
            if (uVar == null && i3 >= 0) {
                u[] uVarArr = this.f3561Q;
                if (i3 < uVarArr.length) {
                    uVar = uVarArr[i3];
                }
            }
            if (uVar != null) {
                menu = uVar.f3630j;
            }
        }
        if ((uVar == null || uVar.f3635o) && !this.f3566V) {
            this.f3587q.d(this.f3586p.getCallback(), i3, menu);
        }
    }

    void W(MenuBuilder menuBuilder) {
        if (this.f3560P) {
            return;
        }
        this.f3560P = true;
        this.f3592v.l();
        Window.Callback s02 = s0();
        if (s02 != null && !this.f3566V) {
            s02.onPanelClosed(108, menuBuilder);
        }
        this.f3560P = false;
    }

    void Y(int i3) {
        Z(q0(i3, true), true);
    }

    void Z(u uVar, boolean z3) {
        ViewGroup viewGroup;
        C c3;
        if (z3 && uVar.f3621a == 0 && (c3 = this.f3592v) != null && c3.c()) {
            W(uVar.f3630j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f3585o.getSystemService("window");
        if (windowManager != null && uVar.f3635o && (viewGroup = uVar.f3627g) != null) {
            windowManager.removeView(viewGroup);
            if (z3) {
                V(uVar.f3621a, uVar, null);
            }
        }
        uVar.f3633m = false;
        uVar.f3634n = false;
        uVar.f3635o = false;
        uVar.f3628h = null;
        uVar.f3637q = true;
        if (this.f3562R == uVar) {
            this.f3562R = null;
        }
        if (uVar.f3621a == 0) {
            Z0();
        }
    }

    void Z0() {
        OnBackInvokedCallback onBackInvokedCallback;
        boolean T02 = T0();
        if (T02 && this.f3583m0 == null) {
            this.f3583m0 = n.b(this.f3582l0, this);
        } else {
            if (T02 || (onBackInvokedCallback = this.f3583m0) == null) {
                return;
            }
            n.c(this.f3582l0, onBackInvokedCallback);
        }
    }

    final int b1(J j3, Rect rect) {
        boolean z3;
        boolean z4;
        int k3 = j3 != null ? j3.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f3596z;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z3 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3596z.getLayoutParams();
            if (this.f3596z.isShown()) {
                if (this.f3578h0 == null) {
                    this.f3578h0 = new Rect();
                    this.f3579i0 = new Rect();
                }
                Rect rect2 = this.f3578h0;
                Rect rect3 = this.f3579i0;
                if (j3 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(j3.i(), j3.k(), j3.j(), j3.h());
                }
                b0.a(this.f3550F, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                J D3 = y.D(this.f3550F);
                int i6 = D3 == null ? 0 : D3.i();
                int j4 = D3 == null ? 0 : D3.j();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z4 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z4 = true;
                }
                if (i3 <= 0 || this.f3552H != null) {
                    View view = this.f3552H;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i7 = marginLayoutParams2.height;
                        int i8 = marginLayoutParams.topMargin;
                        if (i7 != i8 || marginLayoutParams2.leftMargin != i6 || marginLayoutParams2.rightMargin != j4) {
                            marginLayoutParams2.height = i8;
                            marginLayoutParams2.leftMargin = i6;
                            marginLayoutParams2.rightMargin = j4;
                            this.f3552H.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f3585o);
                    this.f3552H = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i6;
                    layoutParams.rightMargin = j4;
                    this.f3550F.addView(this.f3552H, -1, layoutParams);
                }
                View view3 = this.f3552H;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    c1(this.f3552H);
                }
                if (!this.f3557M && r5) {
                    k3 = 0;
                }
                z3 = r5;
                r5 = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = false;
            } else {
                z3 = false;
                r5 = false;
            }
            if (r5) {
                this.f3596z.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f3552H;
        if (view4 != null) {
            view4.setVisibility(z3 ? 0 : 8);
        }
        return k3;
    }

    @Override // androidx.appcompat.app.f
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        h0();
        ((ViewGroup) this.f3550F.findViewById(R.id.content)).addView(view, layoutParams);
        this.f3587q.c(this.f3586p.getCallback());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View c0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z3;
        if (this.f3580j0 == null) {
            String string = this.f3585o.obtainStyledAttributes(e.j.f11453y0).getString(e.j.f11263C0);
            if (string == null) {
                this.f3580j0 = new androidx.appcompat.app.l();
            } else {
                try {
                    this.f3580j0 = (androidx.appcompat.app.l) this.f3585o.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f3580j0 = new androidx.appcompat.app.l();
                }
            }
        }
        boolean z4 = f3541o0;
        boolean z5 = false;
        if (z4) {
            if (this.f3581k0 == null) {
                this.f3581k0 = new androidx.appcompat.app.o();
            }
            if (this.f3581k0.a(attributeSet)) {
                z3 = true;
                return this.f3580j0.createView(view, str, context, attributeSet, z3, z4, true, a0.c());
            }
            if (!(attributeSet instanceof XmlPullParser)) {
                z5 = S0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z5 = true;
            }
        }
        z3 = z5;
        return this.f3580j0.createView(view, str, context, attributeSet, z3, z4, true, a0.c());
    }

    void d0() {
        MenuBuilder menuBuilder;
        C c3 = this.f3592v;
        if (c3 != null) {
            c3.l();
        }
        if (this.f3545A != null) {
            this.f3586p.getDecorView().removeCallbacks(this.f3546B);
            if (this.f3545A.isShowing()) {
                try {
                    this.f3545A.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f3545A = null;
        }
        g0();
        u q02 = q0(0, false);
        if (q02 == null || (menuBuilder = q02.f3630j) == null) {
            return;
        }
        menuBuilder.close();
    }

    @Override // androidx.appcompat.app.f
    public Context e(Context context) {
        this.f3564T = true;
        int z02 = z0(context, U());
        if (androidx.appcompat.app.f.s(context)) {
            androidx.appcompat.app.f.N(context);
        }
        androidx.core.os.f T3 = T(context);
        if (f3544r0 && (context instanceof ContextThemeWrapper)) {
            try {
                s.a((ContextThemeWrapper) context, a0(context, z02, T3, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(a0(context, z02, T3, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f3543q0) {
            return super.e(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = j.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration a02 = a0(context, z02, T3, !configuration2.equals(configuration3) ? k0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, e.i.f11252c);
        dVar.a(a02);
        try {
            if (context.getTheme() != null) {
                f.C0064f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.e(dVar);
    }

    boolean e0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f3584n;
        if (((obj instanceof AbstractC0257f.a) || (obj instanceof androidx.appcompat.app.j)) && (decorView = this.f3586p.getDecorView()) != null && AbstractC0257f.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f3587q.b(this.f3586p.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? B0(keyCode, keyEvent) : E0(keyCode, keyEvent);
    }

    void f0(int i3) {
        u q02;
        u q03 = q0(i3, true);
        if (q03.f3630j != null) {
            Bundle bundle = new Bundle();
            q03.f3630j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                q03.f3639s = bundle;
            }
            q03.f3630j.stopDispatchingItemsChanged();
            q03.f3630j.clear();
        }
        q03.f3638r = true;
        q03.f3637q = true;
        if ((i3 != 108 && i3 != 0) || this.f3592v == null || (q02 = q0(0, false)) == null) {
            return;
        }
        q02.f3633m = false;
        M0(q02, null);
    }

    void g0() {
        E e3 = this.f3547C;
        if (e3 != null) {
            e3.c();
        }
    }

    @Override // androidx.appcompat.app.f
    public View h(int i3) {
        h0();
        return this.f3586p.findViewById(i3);
    }

    @Override // androidx.appcompat.app.f
    public Context j() {
        return this.f3585o;
    }

    u j0(Menu menu) {
        u[] uVarArr = this.f3561Q;
        int length = uVarArr != null ? uVarArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            u uVar = uVarArr[i3];
            if (uVar != null && uVar.f3630j == menu) {
                return uVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b l() {
        return new f();
    }

    final Context l0() {
        androidx.appcompat.app.a p3 = p();
        Context k3 = p3 != null ? p3.k() : null;
        return k3 == null ? this.f3585o : k3;
    }

    @Override // androidx.appcompat.app.f
    public int m() {
        return this.f3568X;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater o() {
        if (this.f3590t == null) {
            t0();
            androidx.appcompat.app.a aVar = this.f3589s;
            this.f3590t = new androidx.appcompat.view.g(aVar != null ? aVar.k() : this.f3585o);
        }
        return this.f3590t;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return c0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        u j02;
        Window.Callback s02 = s0();
        if (s02 == null || this.f3566V || (j02 = j0(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return s02.onMenuItemSelected(j02.f3621a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        N0(true);
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a p() {
        t0();
        return this.f3589s;
    }

    androidx.core.os.f p0(Configuration configuration) {
        return l.b(configuration);
    }

    @Override // androidx.appcompat.app.f
    public void q() {
        LayoutInflater from = LayoutInflater.from(this.f3585o);
        if (from.getFactory() == null) {
            AbstractC0258g.a(from, this);
        } else {
            if (from.getFactory2() instanceof g) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    protected u q0(int i3, boolean z3) {
        u[] uVarArr = this.f3561Q;
        if (uVarArr == null || uVarArr.length <= i3) {
            u[] uVarArr2 = new u[i3 + 1];
            if (uVarArr != null) {
                System.arraycopy(uVarArr, 0, uVarArr2, 0, uVarArr.length);
            }
            this.f3561Q = uVarArr2;
            uVarArr = uVarArr2;
        }
        u uVar = uVarArr[i3];
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(i3);
        uVarArr[i3] = uVar2;
        return uVar2;
    }

    @Override // androidx.appcompat.app.f
    public void r() {
        if (K0() == null || p().l()) {
            return;
        }
        x0(0);
    }

    final CharSequence r0() {
        Object obj = this.f3584n;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f3591u;
    }

    final Window.Callback s0() {
        return this.f3586p.getCallback();
    }

    @Override // androidx.appcompat.app.f
    public void u(Configuration configuration) {
        androidx.appcompat.app.a p3;
        if (this.f3555K && this.f3549E && (p3 = p()) != null) {
            p3.m(configuration);
        }
        C0235i.b().g(this.f3585o);
        this.f3567W = new Configuration(this.f3585o.getResources().getConfiguration());
        P(false, false);
    }

    @Override // androidx.appcompat.app.f
    public void v(Bundle bundle) {
        String str;
        this.f3564T = true;
        O(false);
        i0();
        Object obj = this.f3584n;
        if (obj instanceof Activity) {
            try {
                str = androidx.core.app.e.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                androidx.appcompat.app.a K02 = K0();
                if (K02 == null) {
                    this.f3577g0 = true;
                } else {
                    K02.r(true);
                }
            }
            androidx.appcompat.app.f.b(this);
        }
        this.f3567W = new Configuration(this.f3585o.getResources().getConfiguration());
        this.f3565U = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    @Override // androidx.appcompat.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3584n
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.f.C(r3)
        L9:
            boolean r0 = r3.f3574d0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f3586p
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f3576f0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f3566V = r0
            int r0 = r3.f3568X
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f3584n
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            m.g r0 = androidx.appcompat.app.g.f3540n0
            java.lang.Object r1 = r3.f3584n
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f3568X
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            m.g r0 = androidx.appcompat.app.g.f3540n0
            java.lang.Object r1 = r3.f3584n
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f3589s
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.X()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.g.w():void");
    }

    @Override // androidx.appcompat.app.f
    public void x(Bundle bundle) {
        h0();
    }

    @Override // androidx.appcompat.app.f
    public void y() {
        androidx.appcompat.app.a p3 = p();
        if (p3 != null) {
            p3.t(true);
        }
    }

    public boolean y0() {
        return this.f3548D;
    }

    @Override // androidx.appcompat.app.f
    public void z(Bundle bundle) {
    }

    int z0(Context context, int i3) {
        if (i3 == -100) {
            return -1;
        }
        if (i3 != -1) {
            if (i3 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return o0(context).c();
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    return n0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i3;
    }

    g(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private g(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        AppCompatActivity W02;
        this.f3547C = null;
        this.f3548D = true;
        this.f3568X = -100;
        this.f3576f0 = new a();
        this.f3585o = context;
        this.f3588r = dVar;
        this.f3584n = obj;
        if (this.f3568X == -100 && (obj instanceof Dialog) && (W02 = W0()) != null) {
            this.f3568X = W02.getDelegate().m();
        }
        if (this.f3568X == -100) {
            m.g gVar = f3540n0;
            Integer num = (Integer) gVar.get(obj.getClass().getName());
            if (num != null) {
                this.f3568X = num.intValue();
                gVar.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            S(window);
        }
        C0235i.h();
    }
}
