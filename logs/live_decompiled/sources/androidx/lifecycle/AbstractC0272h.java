package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0272h {

    /* renamed from: a, reason: collision with root package name */
    AtomicReference f5800a = new AtomicReference();

    /* renamed from: androidx.lifecycle.h$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5801a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5802b;

        static {
            int[] iArr = new int[b.values().length];
            f5802b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5802b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5802b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5802b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5802b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5802b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5802b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            f5801a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5801a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5801a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5801a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5801a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: androidx.lifecycle.h$b */
    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static b a(c cVar) {
            int i3 = a.f5801a[cVar.ordinal()];
            if (i3 == 1) {
                return ON_DESTROY;
            }
            if (i3 == 2) {
                return ON_STOP;
            }
            if (i3 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static b c(c cVar) {
            int i3 = a.f5801a[cVar.ordinal()];
            if (i3 == 1) {
                return ON_START;
            }
            if (i3 == 2) {
                return ON_RESUME;
            }
            if (i3 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public static b d(c cVar) {
            int i3 = a.f5801a[cVar.ordinal()];
            if (i3 == 1) {
                return ON_CREATE;
            }
            if (i3 == 2) {
                return ON_START;
            }
            if (i3 != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public c b() {
            switch (a.f5802b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* renamed from: androidx.lifecycle.h$c */
    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(c cVar) {
            return compareTo(cVar) >= 0;
        }
    }

    public abstract void a(n nVar);

    public abstract c b();

    public abstract void c(n nVar);
}
