package J1;

import android.os.SystemClock;
import android.util.LruCache;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f1143a;

    /* renamed from: b, reason: collision with root package name */
    private final long f1144b;

    /* renamed from: c, reason: collision with root package name */
    private final LruCache f1145c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f1146a;

        /* renamed from: b, reason: collision with root package name */
        private final long f1147b;

        public b(int i3, long j3) {
            this.f1146a = Math.max(i3, 0);
            this.f1147b = Math.max(j3, 0L);
        }

        public f c() {
            return new f(this);
        }
    }

    private long b(Queue queue, long j3) {
        Long l3 = (Long) queue.peek();
        while (l3 != null && l3.longValue() < j3 - this.f1144b) {
            queue.poll();
            l3 = (Long) queue.peek();
        }
        return queue.size();
    }

    private Queue c(String str) {
        Queue queue = (Queue) this.f1145c.get(str);
        if (queue != null) {
            return queue;
        }
        LinkedList linkedList = new LinkedList();
        this.f1145c.put(str, linkedList);
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String e(String str, long j3) {
        return "Chatty!!! Allow " + this.f1143a + "/" + this.f1144b + "ms, but " + str + " request " + j3 + " in the recent period.";
    }

    public boolean d(final String str) {
        Queue c3 = c(str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c3.add(Long.valueOf(elapsedRealtime));
        final long b3 = b(c3, elapsedRealtime);
        boolean z3 = b3 <= ((long) this.f1143a);
        if (!z3 && b3 % 10 == 1) {
            K1.f.f("FireWall", new K1.g() { // from class: J1.e
                @Override // K1.g
                public final Object get() {
                    String e3;
                    e3 = f.this.e(str, b3);
                    return e3;
                }
            });
        }
        return z3;
    }

    private f(b bVar) {
        this.f1143a = bVar.f1146a;
        this.f1144b = bVar.f1147b;
        this.f1145c = new LruCache(100);
    }
}
