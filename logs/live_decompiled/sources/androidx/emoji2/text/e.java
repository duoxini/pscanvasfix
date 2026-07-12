package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m.C0452b;

/* loaded from: classes.dex */
public class e {

    /* renamed from: n, reason: collision with root package name */
    private static final Object f5218n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private static final Object f5219o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private static volatile e f5220p;

    /* renamed from: b, reason: collision with root package name */
    private final Set f5222b;

    /* renamed from: e, reason: collision with root package name */
    private final b f5225e;

    /* renamed from: f, reason: collision with root package name */
    final g f5226f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f5227g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f5228h;

    /* renamed from: i, reason: collision with root package name */
    final int[] f5229i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f5230j;

    /* renamed from: k, reason: collision with root package name */
    private final int f5231k;

    /* renamed from: l, reason: collision with root package name */
    private final int f5232l;

    /* renamed from: m, reason: collision with root package name */
    private final d f5233m;

    /* renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f5221a = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private volatile int f5223c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f5224d = new Handler(Looper.getMainLooper());

    private static final class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.h f5234b;

        /* renamed from: c, reason: collision with root package name */
        private volatile m f5235c;

        /* renamed from: androidx.emoji2.text.e$a$a, reason: collision with other inner class name */
        class C0077a extends h {
            C0077a() {
            }

            @Override // androidx.emoji2.text.e.h
            public void a(Throwable th) {
                a.this.f5237a.m(th);
            }

            @Override // androidx.emoji2.text.e.h
            public void b(m mVar) {
                a.this.d(mVar);
            }
        }

        a(e eVar) {
            super(eVar);
        }

        @Override // androidx.emoji2.text.e.b
        void a() {
            try {
                this.f5237a.f5226f.a(new C0077a());
            } catch (Throwable th) {
                this.f5237a.m(th);
            }
        }

        @Override // androidx.emoji2.text.e.b
        CharSequence b(CharSequence charSequence, int i3, int i4, int i5, boolean z3) {
            return this.f5234b.h(charSequence, i3, i4, i5, z3);
        }

        @Override // androidx.emoji2.text.e.b
        void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f5235c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f5237a.f5227g);
        }

        void d(m mVar) {
            if (mVar == null) {
                this.f5237a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f5235c = mVar;
            m mVar2 = this.f5235c;
            i iVar = new i();
            d dVar = this.f5237a.f5233m;
            e eVar = this.f5237a;
            this.f5234b = new androidx.emoji2.text.h(mVar2, iVar, dVar, eVar.f5228h, eVar.f5229i);
            this.f5237a.n();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final e f5237a;

        b(e eVar) {
            this.f5237a = eVar;
        }

        abstract void a();

        abstract CharSequence b(CharSequence charSequence, int i3, int i4, int i5, boolean z3);

        abstract void c(EditorInfo editorInfo);
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final g f5238a;

        /* renamed from: b, reason: collision with root package name */
        boolean f5239b;

        /* renamed from: c, reason: collision with root package name */
        boolean f5240c;

        /* renamed from: d, reason: collision with root package name */
        int[] f5241d;

        /* renamed from: e, reason: collision with root package name */
        Set f5242e;

        /* renamed from: f, reason: collision with root package name */
        boolean f5243f;

        /* renamed from: g, reason: collision with root package name */
        int f5244g = -16711936;

        /* renamed from: h, reason: collision with root package name */
        int f5245h = 0;

        /* renamed from: i, reason: collision with root package name */
        d f5246i = new androidx.emoji2.text.d();

        protected c(g gVar) {
            androidx.core.util.h.e(gVar, "metadataLoader cannot be null.");
            this.f5238a = gVar;
        }

        protected final g a() {
            return this.f5238a;
        }

        public c b(int i3) {
            this.f5245h = i3;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence charSequence, int i3, int i4, int i5);
    }

    /* renamed from: androidx.emoji2.text.e$e, reason: collision with other inner class name */
    public static abstract class AbstractC0078e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    private static class f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final List f5247e;

        /* renamed from: f, reason: collision with root package name */
        private final Throwable f5248f;

        /* renamed from: g, reason: collision with root package name */
        private final int f5249g;

        f(AbstractC0078e abstractC0078e, int i3) {
            this(Arrays.asList((AbstractC0078e) androidx.core.util.h.e(abstractC0078e, "initCallback cannot be null")), i3, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f5247e.size();
            int i3 = 0;
            if (this.f5249g != 1) {
                while (i3 < size) {
                    ((AbstractC0078e) this.f5247e.get(i3)).a(this.f5248f);
                    i3++;
                }
            } else {
                while (i3 < size) {
                    ((AbstractC0078e) this.f5247e.get(i3)).b();
                    i3++;
                }
            }
        }

        f(Collection collection, int i3) {
            this(collection, i3, null);
        }

        f(Collection collection, int i3, Throwable th) {
            androidx.core.util.h.e(collection, "initCallbacks cannot be null");
            this.f5247e = new ArrayList(collection);
            this.f5249g = i3;
            this.f5248f = th;
        }
    }

    public interface g {
        void a(h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(m mVar);
    }

    static class i {
        i() {
        }

        androidx.emoji2.text.i a(androidx.emoji2.text.g gVar) {
            return new o(gVar);
        }
    }

    private e(c cVar) {
        this.f5227g = cVar.f5239b;
        this.f5228h = cVar.f5240c;
        this.f5229i = cVar.f5241d;
        this.f5230j = cVar.f5243f;
        this.f5231k = cVar.f5244g;
        this.f5226f = cVar.f5238a;
        this.f5232l = cVar.f5245h;
        this.f5233m = cVar.f5246i;
        C0452b c0452b = new C0452b();
        this.f5222b = c0452b;
        Set set = cVar.f5242e;
        if (set != null && !set.isEmpty()) {
            c0452b.addAll(cVar.f5242e);
        }
        this.f5225e = new a(this);
        l();
    }

    public static e b() {
        e eVar;
        synchronized (f5218n) {
            eVar = f5220p;
            androidx.core.util.h.f(eVar != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z3) {
        return androidx.emoji2.text.h.c(inputConnection, editable, i3, i4, z3);
    }

    public static boolean f(Editable editable, int i3, KeyEvent keyEvent) {
        return androidx.emoji2.text.h.d(editable, i3, keyEvent);
    }

    public static e g(c cVar) {
        e eVar = f5220p;
        if (eVar == null) {
            synchronized (f5218n) {
                try {
                    eVar = f5220p;
                    if (eVar == null) {
                        eVar = new e(cVar);
                        f5220p = eVar;
                    }
                } finally {
                }
            }
        }
        return eVar;
    }

    public static boolean h() {
        return f5220p != null;
    }

    private boolean j() {
        return d() == 1;
    }

    private void l() {
        this.f5221a.writeLock().lock();
        try {
            if (this.f5232l == 0) {
                this.f5223c = 0;
            }
            this.f5221a.writeLock().unlock();
            if (d() == 0) {
                this.f5225e.a();
            }
        } catch (Throwable th) {
            this.f5221a.writeLock().unlock();
            throw th;
        }
    }

    public int c() {
        return this.f5231k;
    }

    public int d() {
        this.f5221a.readLock().lock();
        try {
            return this.f5223c;
        } finally {
            this.f5221a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f5230j;
    }

    public void k() {
        androidx.core.util.h.f(this.f5232l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f5221a.writeLock().lock();
        try {
            if (this.f5223c == 0) {
                return;
            }
            this.f5223c = 0;
            this.f5221a.writeLock().unlock();
            this.f5225e.a();
        } finally {
            this.f5221a.writeLock().unlock();
        }
    }

    void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f5221a.writeLock().lock();
        try {
            this.f5223c = 2;
            arrayList.addAll(this.f5222b);
            this.f5222b.clear();
            this.f5221a.writeLock().unlock();
            this.f5224d.post(new f(arrayList, this.f5223c, th));
        } catch (Throwable th2) {
            this.f5221a.writeLock().unlock();
            throw th2;
        }
    }

    void n() {
        ArrayList arrayList = new ArrayList();
        this.f5221a.writeLock().lock();
        try {
            this.f5223c = 1;
            arrayList.addAll(this.f5222b);
            this.f5222b.clear();
            this.f5221a.writeLock().unlock();
            this.f5224d.post(new f(arrayList, this.f5223c));
        } catch (Throwable th) {
            this.f5221a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i3, int i4) {
        return q(charSequence, i3, i4, Preference.DEFAULT_ORDER);
    }

    public CharSequence q(CharSequence charSequence, int i3, int i4, int i5) {
        return r(charSequence, i3, i4, i5, 0);
    }

    public CharSequence r(CharSequence charSequence, int i3, int i4, int i5, int i6) {
        boolean z3;
        androidx.core.util.h.f(j(), "Not initialized yet");
        androidx.core.util.h.c(i3, "start cannot be negative");
        androidx.core.util.h.c(i4, "end cannot be negative");
        androidx.core.util.h.c(i5, "maxEmojiCount cannot be negative");
        androidx.core.util.h.a(i3 <= i4, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.h.a(i3 <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.h.a(i4 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i3 == i4) {
            return charSequence;
        }
        if (i6 != 1) {
            z3 = i6 != 2 ? this.f5227g : false;
        } else {
            z3 = true;
        }
        return this.f5225e.b(charSequence, i3, i4, i5, z3);
    }

    public void s(AbstractC0078e abstractC0078e) {
        androidx.core.util.h.e(abstractC0078e, "initCallback cannot be null");
        this.f5221a.writeLock().lock();
        try {
            if (this.f5223c != 1 && this.f5223c != 2) {
                this.f5222b.add(abstractC0078e);
                this.f5221a.writeLock().unlock();
            }
            this.f5224d.post(new f(abstractC0078e, this.f5223c));
            this.f5221a.writeLock().unlock();
        } catch (Throwable th) {
            this.f5221a.writeLock().unlock();
            throw th;
        }
    }

    public void t(AbstractC0078e abstractC0078e) {
        androidx.core.util.h.e(abstractC0078e, "initCallback cannot be null");
        this.f5221a.writeLock().lock();
        try {
            this.f5222b.remove(abstractC0078e);
        } finally {
            this.f5221a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (!j() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f5225e.c(editorInfo);
    }
}
