package U2;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f2493a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static final int f2494b = 65536;

    /* renamed from: c, reason: collision with root package name */
    private static final m f2495c = new m(new byte[0], 0, 0, false, false);

    /* renamed from: d, reason: collision with root package name */
    private static final int f2496d;

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReference[] f2497e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f2496d = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i3 = 0; i3 < highestOneBit; i3++) {
            atomicReferenceArr[i3] = new AtomicReference();
        }
        f2497e = atomicReferenceArr;
    }

    private n() {
    }

    private final AtomicReference a() {
        return f2497e[(int) (Thread.currentThread().getId() & (f2496d - 1))];
    }

    public static final void b(m mVar) {
        D2.k.e(mVar, "segment");
        if (mVar.f2491f != null || mVar.f2492g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (mVar.f2489d) {
            return;
        }
        AtomicReference a3 = f2493a.a();
        m mVar2 = f2495c;
        m mVar3 = (m) a3.getAndSet(mVar2);
        if (mVar3 == mVar2) {
            return;
        }
        int i3 = mVar3 != null ? mVar3.f2488c : 0;
        if (i3 >= f2494b) {
            a3.set(mVar3);
            return;
        }
        mVar.f2491f = mVar3;
        mVar.f2487b = 0;
        mVar.f2488c = i3 + 8192;
        a3.set(mVar);
    }

    public static final m c() {
        AtomicReference a3 = f2493a.a();
        m mVar = f2495c;
        m mVar2 = (m) a3.getAndSet(mVar);
        if (mVar2 == mVar) {
            return new m();
        }
        if (mVar2 == null) {
            a3.set(null);
            return new m();
        }
        a3.set(mVar2.f2491f);
        mVar2.f2491f = null;
        mVar2.f2488c = 0;
        return mVar2;
    }
}
