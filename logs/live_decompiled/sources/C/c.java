package C;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected int f249a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f250b;

    /* renamed from: c, reason: collision with root package name */
    private int f251c;

    /* renamed from: d, reason: collision with root package name */
    private int f252d;

    /* renamed from: e, reason: collision with root package name */
    d f253e = d.a();

    protected int a(int i3) {
        return i3 + this.f250b.getInt(i3);
    }

    protected int b(int i3) {
        if (i3 < this.f252d) {
            return this.f250b.getShort(this.f251c + i3);
        }
        return 0;
    }

    protected void c(int i3, ByteBuffer byteBuffer) {
        this.f250b = byteBuffer;
        if (byteBuffer == null) {
            this.f249a = 0;
            this.f251c = 0;
            this.f252d = 0;
        } else {
            this.f249a = i3;
            int i4 = i3 - byteBuffer.getInt(i3);
            this.f251c = i4;
            this.f252d = this.f250b.getShort(i4);
        }
    }

    protected int d(int i3) {
        int i4 = i3 + this.f249a;
        return i4 + this.f250b.getInt(i4) + 4;
    }

    protected int e(int i3) {
        int i4 = i3 + this.f249a;
        return this.f250b.getInt(i4 + this.f250b.getInt(i4));
    }
}
