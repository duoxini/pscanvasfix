package U2;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class f implements p {

    /* renamed from: e, reason: collision with root package name */
    private final InputStream f2469e;

    /* renamed from: f, reason: collision with root package name */
    private final q f2470f;

    public f(InputStream inputStream, q qVar) {
        D2.k.e(inputStream, "input");
        D2.k.e(qVar, "timeout");
        this.f2469e = inputStream;
        this.f2470f = qVar;
    }

    @Override // U2.p, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f2469e.close();
    }

    @Override // U2.p
    public long o(b bVar, long j3) {
        D2.k.e(bVar, "sink");
        if (j3 == 0) {
            return 0L;
        }
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        try {
            this.f2470f.a();
            m i02 = bVar.i0(1);
            int read = this.f2469e.read(i02.f2486a, i02.f2488c, (int) Math.min(j3, 8192 - i02.f2488c));
            if (read != -1) {
                i02.f2488c += read;
                long j4 = read;
                bVar.d0(bVar.e0() + j4);
                return j4;
            }
            if (i02.f2487b != i02.f2488c) {
                return -1L;
            }
            bVar.f2455e = i02.b();
            n.b(i02);
            return -1L;
        } catch (AssertionError e3) {
            if (g.b(e3)) {
                throw new IOException(e3);
            }
            throw e3;
        }
    }

    public String toString() {
        return "source(" + this.f2469e + ')';
    }
}
