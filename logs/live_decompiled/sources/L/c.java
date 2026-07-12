package L;

import D2.k;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes.dex */
public abstract class c {
    public static final void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) {
        k.e(readableByteChannel, "input");
        k.e(fileChannel, "output");
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
