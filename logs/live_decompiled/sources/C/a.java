package C;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a extends c {
    public a f(int i3, ByteBuffer byteBuffer) {
        g(i3, byteBuffer);
        return this;
    }

    public void g(int i3, ByteBuffer byteBuffer) {
        c(i3, byteBuffer);
    }

    public int h(int i3) {
        int b3 = b(16);
        if (b3 != 0) {
            return this.f250b.getInt(d(b3) + (i3 * 4));
        }
        return 0;
    }

    public int i() {
        int b3 = b(16);
        if (b3 != 0) {
            return e(b3);
        }
        return 0;
    }

    public boolean j() {
        int b3 = b(6);
        return (b3 == 0 || this.f250b.get(b3 + this.f249a) == 0) ? false : true;
    }

    public short k() {
        int b3 = b(14);
        if (b3 != 0) {
            return this.f250b.getShort(b3 + this.f249a);
        }
        return (short) 0;
    }

    public int l() {
        int b3 = b(4);
        if (b3 != 0) {
            return this.f250b.getInt(b3 + this.f249a);
        }
        return 0;
    }

    public short m() {
        int b3 = b(8);
        if (b3 != 0) {
            return this.f250b.getShort(b3 + this.f249a);
        }
        return (short) 0;
    }

    public short n() {
        int b3 = b(12);
        if (b3 != 0) {
            return this.f250b.getShort(b3 + this.f249a);
        }
        return (short) 0;
    }
}
