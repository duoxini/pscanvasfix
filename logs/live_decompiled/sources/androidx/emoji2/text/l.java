package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
abstract class l {

    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f5287a;

        a(ByteBuffer byteBuffer) {
            this.f5287a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.l.c
        public long a() {
            return l.c(this.f5287a.getInt());
        }

        @Override // androidx.emoji2.text.l.c
        public void b(int i3) {
            ByteBuffer byteBuffer = this.f5287a;
            byteBuffer.position(byteBuffer.position() + i3);
        }

        @Override // androidx.emoji2.text.l.c
        public int c() {
            return l.d(this.f5287a.getShort());
        }

        @Override // androidx.emoji2.text.l.c
        public int d() {
            return this.f5287a.getInt();
        }

        @Override // androidx.emoji2.text.l.c
        public long getPosition() {
            return this.f5287a.position();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f5288a;

        /* renamed from: b, reason: collision with root package name */
        private final long f5289b;

        b(long j3, long j4) {
            this.f5288a = j3;
            this.f5289b = j4;
        }

        long a() {
            return this.f5288a;
        }
    }

    private interface c {
        long a();

        void b(int i3);

        int c();

        int d();

        long getPosition();
    }

    private static b a(c cVar) {
        long j3;
        cVar.b(4);
        int c3 = cVar.c();
        if (c3 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i3 = 0;
        while (true) {
            if (i3 >= c3) {
                j3 = -1;
                break;
            }
            int d3 = cVar.d();
            cVar.b(4);
            j3 = cVar.a();
            cVar.b(4);
            if (1835365473 == d3) {
                break;
            }
            i3++;
        }
        if (j3 != -1) {
            cVar.b((int) (j3 - cVar.getPosition()));
            cVar.b(12);
            long a3 = cVar.a();
            for (int i4 = 0; i4 < a3; i4++) {
                int d4 = cVar.d();
                long a4 = cVar.a();
                long a5 = cVar.a();
                if (1164798569 == d4 || 1701669481 == d4) {
                    return new b(a4 + j3, a5);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static C.b b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return C.b.h(duplicate);
    }

    static long c(int i3) {
        return i3 & 4294967295L;
    }

    static int d(short s3) {
        return s3 & 65535;
    }
}
