package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class y extends Writer {

    /* renamed from: e, reason: collision with root package name */
    private final String f5656e;

    /* renamed from: f, reason: collision with root package name */
    private StringBuilder f5657f = new StringBuilder(128);

    y(String str) {
        this.f5656e = str;
    }

    private void a() {
        if (this.f5657f.length() > 0) {
            Log.d(this.f5656e, this.f5657f.toString());
            StringBuilder sb = this.f5657f;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                a();
            } else {
                this.f5657f.append(c3);
            }
        }
    }
}
