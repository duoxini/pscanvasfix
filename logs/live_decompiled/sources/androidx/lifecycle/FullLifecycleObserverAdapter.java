package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements l {

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC0269e f5720e;

    /* renamed from: f, reason: collision with root package name */
    private final l f5721f;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5722a;

        static {
            int[] iArr = new int[AbstractC0272h.b.values().length];
            f5722a = iArr;
            try {
                iArr[AbstractC0272h.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5722a[AbstractC0272h.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5722a[AbstractC0272h.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5722a[AbstractC0272h.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5722a[AbstractC0272h.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5722a[AbstractC0272h.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5722a[AbstractC0272h.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(InterfaceC0269e interfaceC0269e, l lVar) {
        this.f5720e = interfaceC0269e;
        this.f5721f = lVar;
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        switch (a.f5722a[bVar.ordinal()]) {
            case 1:
                this.f5720e.onCreate(oVar);
                break;
            case 2:
                this.f5720e.onStart(oVar);
                break;
            case 3:
                this.f5720e.onResume(oVar);
                break;
            case 4:
                this.f5720e.onPause(oVar);
                break;
            case 5:
                this.f5720e.onStop(oVar);
                break;
            case 6:
                this.f5720e.onDestroy(oVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        l lVar = this.f5721f;
        if (lVar != null) {
            lVar.a(oVar, bVar);
        }
    }
}
