package C;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class b extends c {
    public static b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new b());
    }

    public static b i(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public b f(int i3, ByteBuffer byteBuffer) {
        g(i3, byteBuffer);
        return this;
    }

    public void g(int i3, ByteBuffer byteBuffer) {
        c(i3, byteBuffer);
    }

    public a j(a aVar, int i3) {
        int b3 = b(6);
        if (b3 != 0) {
            return aVar.f(a(d(b3) + (i3 * 4)), this.f250b);
        }
        return null;
    }

    public int k() {
        int b3 = b(6);
        if (b3 != 0) {
            return e(b3);
        }
        return 0;
    }

    public int l() {
        int b3 = b(4);
        if (b3 != 0) {
            return this.f250b.getInt(b3 + this.f249a);
        }
        return 0;
    }
}
