package N2;

import L2.InterfaceC0178j;
import Q2.D;
import Q2.G;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final i f1645a = new i(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f1646b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f1647c;

    /* renamed from: d, reason: collision with root package name */
    public static final D f1648d;

    /* renamed from: e, reason: collision with root package name */
    private static final D f1649e;

    /* renamed from: f, reason: collision with root package name */
    private static final D f1650f;

    /* renamed from: g, reason: collision with root package name */
    private static final D f1651g;

    /* renamed from: h, reason: collision with root package name */
    private static final D f1652h;

    /* renamed from: i, reason: collision with root package name */
    private static final D f1653i;

    /* renamed from: j, reason: collision with root package name */
    private static final D f1654j;

    /* renamed from: k, reason: collision with root package name */
    private static final D f1655k;

    /* renamed from: l, reason: collision with root package name */
    private static final D f1656l;

    /* renamed from: m, reason: collision with root package name */
    private static final D f1657m;

    /* renamed from: n, reason: collision with root package name */
    private static final D f1658n;

    /* renamed from: o, reason: collision with root package name */
    private static final D f1659o;

    /* renamed from: p, reason: collision with root package name */
    private static final D f1660p;

    /* renamed from: q, reason: collision with root package name */
    private static final D f1661q;

    /* renamed from: r, reason: collision with root package name */
    private static final D f1662r;

    /* renamed from: s, reason: collision with root package name */
    private static final D f1663s;

    /* synthetic */ class a extends D2.j implements C2.p {

        /* renamed from: n, reason: collision with root package name */
        public static final a f1664n = new a();

        a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final i i(long j3, i iVar) {
            return c.x(j3, iVar);
        }

        @Override // C2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return i(((Number) obj).longValue(), (i) obj2);
        }
    }

    static {
        int e3;
        int e4;
        e3 = G.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f1646b = e3;
        e4 = G.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f1647c = e4;
        f1648d = new D("BUFFERED");
        f1649e = new D("SHOULD_BUFFER");
        f1650f = new D("S_RESUMING_BY_RCV");
        f1651g = new D("RESUMING_BY_EB");
        f1652h = new D("POISONED");
        f1653i = new D("DONE_RCV");
        f1654j = new D("INTERRUPTED_SEND");
        f1655k = new D("INTERRUPTED_RCV");
        f1656l = new D("CHANNEL_CLOSED");
        f1657m = new D("SUSPEND");
        f1658n = new D("SUSPEND_NO_WAITER");
        f1659o = new D("FAILED");
        f1660p = new D("NO_RECEIVE_RESULT");
        f1661q = new D("CLOSE_HANDLER_CLOSED");
        f1662r = new D("CLOSE_HANDLER_INVOKED");
        f1663s = new D("NO_CLOSE_CAUSE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i3) {
        if (i3 == 0) {
            return 0L;
        }
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(InterfaceC0178j interfaceC0178j, Object obj, C2.l lVar) {
        Object k3 = interfaceC0178j.k(obj, null, lVar);
        if (k3 == null) {
            return false;
        }
        interfaceC0178j.s(k3);
        return true;
    }

    static /* synthetic */ boolean C(InterfaceC0178j interfaceC0178j, Object obj, C2.l lVar, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            lVar = null;
        }
        return B(interfaceC0178j, obj, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j3, boolean z3) {
        return (z3 ? 4611686018427387904L : 0L) + j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j3, int i3) {
        return (i3 << 60) + j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i x(long j3, i iVar) {
        return new i(j3, iVar, iVar.u(), 0);
    }

    public static final I2.e y() {
        return a.f1664n;
    }

    public static final D z() {
        return f1656l;
    }
}
