package M2;

import L2.o0;
import Q2.r;
import android.os.Looper;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements r {
    @Override // Q2.r
    public int a() {
        return 1073741823;
    }

    @Override // Q2.r
    public String b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // Q2.r
    public o0 c(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(e.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
