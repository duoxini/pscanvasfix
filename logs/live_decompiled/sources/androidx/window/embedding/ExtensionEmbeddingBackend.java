package androidx.window.embedding;

import D2.g;
import D2.k;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.window.core.BuildConfig;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.core.PredicateAdapter;
import androidx.window.core.VerificationMode;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.embedding.SplitController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import m.C0452b;
import p2.AbstractC0506f;
import p2.InterfaceC0505e;
import p2.q;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {

    /* renamed from: i, reason: collision with root package name */
    private static volatile ExtensionEmbeddingBackend f7033i;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7035b;

    /* renamed from: c, reason: collision with root package name */
    private EmbeddingInterfaceCompat f7036c;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList f7037d;

    /* renamed from: e, reason: collision with root package name */
    private final EmbeddingCallbackImpl f7038e;

    /* renamed from: f, reason: collision with root package name */
    private final RuleTracker f7039f;

    /* renamed from: g, reason: collision with root package name */
    private final InterfaceC0505e f7040g;

    /* renamed from: h, reason: collision with root package name */
    public static final Companion f7032h = new Companion(null);

    /* renamed from: j, reason: collision with root package name */
    private static final ReentrantLock f7034j = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: private */
    static final class Api31Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api31Impl f7041a = new Api31Impl();

        private Api31Impl() {
        }

        public final SplitController.SplitSupportStatus a(Context context) {
            k.e(context, "context");
            try {
                PackageManager.Property property = context.getPackageManager().getProperty("android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED", context.getPackageName());
                k.d(property, "try {\n                co…OT_DECLARED\n            }");
                if (property.isBoolean()) {
                    return property.getBoolean() ? SplitController.SplitSupportStatus.f7095c : SplitController.SplitSupportStatus.f7096d;
                }
                if (BuildConfig.f6942a.a() == VerificationMode.LOG) {
                    Log.w("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must have a boolean value");
                }
                return SplitController.SplitSupportStatus.f7097e;
            } catch (PackageManager.NameNotFoundException unused) {
                if (BuildConfig.f6942a.a() == VerificationMode.LOG) {
                    Log.w("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must be set and enabled in AndroidManifest.xml to use splits APIs.");
                }
                return SplitController.SplitSupportStatus.f7097e;
            } catch (Exception e3) {
                if (BuildConfig.f6942a.a() == VerificationMode.LOG) {
                    Log.e("EmbeddingBackend", "PackageManager.getProperty is not supported", e3);
                }
                return SplitController.SplitSupportStatus.f7097e;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final EmbeddingInterfaceCompat b(Context context) {
            ClassLoader classLoader;
            EmbeddingCompat embeddingCompat = null;
            try {
                if (c(Integer.valueOf(ExtensionsUtil.f6956a.a()))) {
                    EmbeddingCompat.Companion companion = EmbeddingCompat.f7024e;
                    if (companion.e() && (classLoader = EmbeddingBackend.class.getClassLoader()) != null) {
                        embeddingCompat = new EmbeddingCompat(companion.b(), new EmbeddingAdapter(new PredicateAdapter(classLoader)), new ConsumerAdapter(classLoader), context);
                    }
                }
            } catch (Throwable th) {
                Log.d("EmbeddingBackend", "Failed to load embedding extension: " + th);
            }
            if (embeddingCompat == null) {
                Log.d("EmbeddingBackend", "No supported embedding extension found");
            }
            return embeddingCompat;
        }

        public final EmbeddingBackend a(Context context) {
            k.e(context, "context");
            if (ExtensionEmbeddingBackend.f7033i == null) {
                ReentrantLock reentrantLock = ExtensionEmbeddingBackend.f7034j;
                reentrantLock.lock();
                try {
                    if (ExtensionEmbeddingBackend.f7033i == null) {
                        Context applicationContext = context.getApplicationContext();
                        Companion companion = ExtensionEmbeddingBackend.f7032h;
                        k.d(applicationContext, "applicationContext");
                        ExtensionEmbeddingBackend.f7033i = new ExtensionEmbeddingBackend(applicationContext, companion.b(applicationContext));
                    }
                    q qVar = q.f12810a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            ExtensionEmbeddingBackend extensionEmbeddingBackend = ExtensionEmbeddingBackend.f7033i;
            k.b(extensionEmbeddingBackend);
            return extensionEmbeddingBackend;
        }

        public final boolean c(Integer num) {
            return num != null && num.intValue() >= 1;
        }

        private Companion() {
        }
    }

    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {

        /* renamed from: a, reason: collision with root package name */
        private List f7042a;

        public EmbeddingCallbackImpl() {
        }

        @Override // androidx.window.embedding.EmbeddingInterfaceCompat.EmbeddingCallbackInterface
        public void a(List list) {
            k.e(list, "splitInfo");
            this.f7042a = list;
            Iterator it = ExtensionEmbeddingBackend.this.j().iterator();
            while (it.hasNext()) {
                ((SplitListenerWrapper) it.next()).b(list);
            }
        }

        public final List b() {
            return this.f7042a;
        }
    }

    private static final class RuleTracker {

        /* renamed from: a, reason: collision with root package name */
        private final C0452b f7044a = new C0452b();

        /* renamed from: b, reason: collision with root package name */
        private final HashMap f7045b = new HashMap();
    }

    public static final class SplitListenerWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f7046a;

        /* renamed from: b, reason: collision with root package name */
        private final Executor f7047b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.core.util.a f7048c;

        /* renamed from: d, reason: collision with root package name */
        private List f7049d;

        public SplitListenerWrapper(Activity activity, Executor executor, androidx.core.util.a aVar) {
            k.e(activity, "activity");
            k.e(executor, "executor");
            k.e(aVar, "callback");
            this.f7046a = activity;
            this.f7047b = executor;
            this.f7048c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SplitListenerWrapper splitListenerWrapper, List list) {
            k.e(splitListenerWrapper, "this$0");
            k.e(list, "$splitsWithActivity");
            splitListenerWrapper.f7048c.accept(list);
        }

        public final void b(List list) {
            k.e(list, "splitInfoList");
            final ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((SplitInfo) obj).a(this.f7046a)) {
                    arrayList.add(obj);
                }
            }
            if (k.a(arrayList, this.f7049d)) {
                return;
            }
            this.f7049d = arrayList;
            this.f7047b.execute(new Runnable() { // from class: androidx.window.embedding.c
                @Override // java.lang.Runnable
                public final void run() {
                    ExtensionEmbeddingBackend.SplitListenerWrapper.c(ExtensionEmbeddingBackend.SplitListenerWrapper.this, arrayList);
                }
            });
        }

        public final androidx.core.util.a d() {
            return this.f7048c;
        }
    }

    public ExtensionEmbeddingBackend(Context context, EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        k.e(context, "applicationContext");
        this.f7035b = context;
        this.f7036c = embeddingInterfaceCompat;
        EmbeddingCallbackImpl embeddingCallbackImpl = new EmbeddingCallbackImpl();
        this.f7038e = embeddingCallbackImpl;
        this.f7037d = new CopyOnWriteArrayList();
        EmbeddingInterfaceCompat embeddingInterfaceCompat2 = this.f7036c;
        if (embeddingInterfaceCompat2 != null) {
            embeddingInterfaceCompat2.b(embeddingCallbackImpl);
        }
        this.f7039f = new RuleTracker();
        this.f7040g = AbstractC0506f.a(new ExtensionEmbeddingBackend$splitSupportStatus$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        return this.f7036c != null;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public boolean a(Activity activity) {
        k.e(activity, "activity");
        EmbeddingInterfaceCompat embeddingInterfaceCompat = this.f7036c;
        if (embeddingInterfaceCompat != null) {
            return embeddingInterfaceCompat.a(activity);
        }
        return false;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void b(androidx.core.util.a aVar) {
        k.e(aVar, "consumer");
        ReentrantLock reentrantLock = f7034j;
        reentrantLock.lock();
        try {
            Iterator it = this.f7037d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SplitListenerWrapper splitListenerWrapper = (SplitListenerWrapper) it.next();
                if (k.a(splitListenerWrapper.d(), aVar)) {
                    this.f7037d.remove(splitListenerWrapper);
                    break;
                }
            }
            q qVar = q.f12810a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void c(Activity activity, Executor executor, androidx.core.util.a aVar) {
        k.e(activity, "activity");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        ReentrantLock reentrantLock = f7034j;
        reentrantLock.lock();
        try {
            if (this.f7036c == null) {
                Log.v("EmbeddingBackend", "Extension not loaded, skipping callback registration.");
                aVar.accept(AbstractC0544n.j());
                return;
            }
            SplitListenerWrapper splitListenerWrapper = new SplitListenerWrapper(activity, executor, aVar);
            this.f7037d.add(splitListenerWrapper);
            if (this.f7038e.b() != null) {
                List b3 = this.f7038e.b();
                k.b(b3);
                splitListenerWrapper.b(b3);
            } else {
                splitListenerWrapper.b(AbstractC0544n.j());
            }
            q qVar = q.f12810a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final CopyOnWriteArrayList j() {
        return this.f7037d;
    }
}
