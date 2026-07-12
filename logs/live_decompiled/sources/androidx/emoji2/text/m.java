package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final C.b f5290a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f5291b;

    /* renamed from: c, reason: collision with root package name */
    private final a f5292c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    private final Typeface f5293d;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray f5294a;

        /* renamed from: b, reason: collision with root package name */
        private g f5295b;

        private a() {
            this(1);
        }

        a a(int i3) {
            SparseArray sparseArray = this.f5294a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i3);
        }

        final g b() {
            return this.f5295b;
        }

        void c(g gVar, int i3, int i4) {
            a a3 = a(gVar.b(i3));
            if (a3 == null) {
                a3 = new a();
                this.f5294a.put(gVar.b(i3), a3);
            }
            if (i4 > i3) {
                a3.c(gVar, i3 + 1, i4);
            } else {
                a3.f5295b = gVar;
            }
        }

        a(int i3) {
            this.f5294a = new SparseArray(i3);
        }
    }

    private m(Typeface typeface, C.b bVar) {
        this.f5293d = typeface;
        this.f5290a = bVar;
        this.f5291b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(C.b bVar) {
        int k3 = bVar.k();
        for (int i3 = 0; i3 < k3; i3++) {
            g gVar = new g(this, i3);
            Character.toChars(gVar.f(), this.f5291b, i3 * 2);
            h(gVar);
        }
    }

    public static m b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            androidx.core.os.i.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            androidx.core.os.i.b();
        }
    }

    public char[] c() {
        return this.f5291b;
    }

    public C.b d() {
        return this.f5290a;
    }

    int e() {
        return this.f5290a.l();
    }

    a f() {
        return this.f5292c;
    }

    Typeface g() {
        return this.f5293d;
    }

    void h(g gVar) {
        androidx.core.util.h.e(gVar, "emoji metadata cannot be null");
        androidx.core.util.h.a(gVar.c() > 0, "invalid metadata codepoint length");
        this.f5292c.c(gVar, 0, gVar.c() - 1);
    }
}
