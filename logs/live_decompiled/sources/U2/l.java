package U2;

import androidx.preference.Preference;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: e, reason: collision with root package name */
    public final p f2481e;

    /* renamed from: f, reason: collision with root package name */
    public final b f2482f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2483g;

    public l(p pVar) {
        D2.k.e(pVar, "source");
        this.f2481e = pVar;
        this.f2482f = new b();
    }

    @Override // U2.d
    public boolean A(long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (this.f2483g) {
            throw new IllegalStateException("closed");
        }
        while (this.f2482f.e0() < j3) {
            if (this.f2481e.o(this.f2482f, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // U2.d
    public d E() {
        return g.a(new k(this));
    }

    @Override // U2.d
    public long L(e eVar) {
        D2.k.e(eVar, "targetBytes");
        return b(eVar, 0L);
    }

    @Override // U2.d
    public b Q() {
        return this.f2482f;
    }

    @Override // U2.d
    public InputStream Y() {
        return new a();
    }

    @Override // U2.d
    public byte Z() {
        c(1L);
        return this.f2482f.Z();
    }

    public long a(e eVar, long j3) {
        D2.k.e(eVar, "bytes");
        if (this.f2483g) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long l3 = this.f2482f.l(eVar, j3);
            if (l3 != -1) {
                return l3;
            }
            long e02 = this.f2482f.e0();
            if (this.f2481e.o(this.f2482f, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, (e02 - eVar.o()) + 1);
        }
    }

    public long b(e eVar, long j3) {
        D2.k.e(eVar, "targetBytes");
        if (this.f2483g) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long p3 = this.f2482f.p(eVar, j3);
            if (p3 != -1) {
                return p3;
            }
            long e02 = this.f2482f.e0();
            if (this.f2481e.o(this.f2482f, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, e02);
        }
    }

    public void c(long j3) {
        if (!A(j3)) {
            throw new EOFException();
        }
    }

    @Override // U2.p, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.f2483g) {
            return;
        }
        this.f2483g = true;
        this.f2481e.close();
        this.f2482f.a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f2483g;
    }

    @Override // U2.p
    public long o(b bVar, long j3) {
        D2.k.e(bVar, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (this.f2483g) {
            throw new IllegalStateException("closed");
        }
        if (this.f2482f.e0() == 0 && this.f2481e.o(this.f2482f, 8192L) == -1) {
            return -1L;
        }
        return this.f2482f.o(bVar, Math.min(j3, this.f2482f.e0()));
    }

    @Override // U2.d
    public b r() {
        return this.f2482f;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        D2.k.e(byteBuffer, "sink");
        if (this.f2482f.e0() == 0 && this.f2481e.o(this.f2482f, 8192L) == -1) {
            return -1;
        }
        return this.f2482f.read(byteBuffer);
    }

    @Override // U2.d
    public int t(j jVar) {
        D2.k.e(jVar, "options");
        if (this.f2483g) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            int b3 = V2.a.b(this.f2482f, jVar, true);
            if (b3 != -2) {
                if (b3 != -1) {
                    this.f2482f.f0(jVar.d()[b3].o());
                    return b3;
                }
            } else if (this.f2481e.o(this.f2482f, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    public String toString() {
        return "buffer(" + this.f2481e + ')';
    }

    @Override // U2.d
    public long v(e eVar) {
        D2.k.e(eVar, "bytes");
        return a(eVar, 0L);
    }

    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            l lVar = l.this;
            if (lVar.f2483g) {
                throw new IOException("closed");
            }
            return (int) Math.min(lVar.f2482f.e0(), Preference.DEFAULT_ORDER);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            l.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            l lVar = l.this;
            if (lVar.f2483g) {
                throw new IOException("closed");
            }
            if (lVar.f2482f.e0() == 0) {
                l lVar2 = l.this;
                if (lVar2.f2481e.o(lVar2.f2482f, 8192L) == -1) {
                    return -1;
                }
            }
            return l.this.f2482f.Z() & 255;
        }

        public String toString() {
            return l.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            D2.k.e(bArr, "data");
            if (!l.this.f2483g) {
                U2.a.b(bArr.length, i3, i4);
                if (l.this.f2482f.e0() == 0) {
                    l lVar = l.this;
                    if (lVar.f2481e.o(lVar.f2482f, 8192L) == -1) {
                        return -1;
                    }
                }
                return l.this.f2482f.q(bArr, i3, i4);
            }
            throw new IOException("closed");
        }
    }
}
