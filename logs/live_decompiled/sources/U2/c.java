package U2;

import java.io.Closeable;
import java.io.Flushable;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface c extends Closeable, Flushable, WritableByteChannel {
    c O(String str);

    c T(int i3);

    c k(String str, int i3, int i4);
}
