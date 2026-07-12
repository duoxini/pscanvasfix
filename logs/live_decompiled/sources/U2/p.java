package U2;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface p extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close();

    long o(b bVar, long j3);
}
