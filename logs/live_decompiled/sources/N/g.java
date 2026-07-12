package N;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public interface g extends Closeable {
    k C(String str);

    void D();

    Cursor F(j jVar);

    Cursor U(String str);

    boolean W();

    String d();

    void e();

    void f();

    boolean isOpen();

    Cursor m(j jVar, CancellationSignal cancellationSignal);

    List n();

    boolean s();

    void w(String str);

    void z();
}
