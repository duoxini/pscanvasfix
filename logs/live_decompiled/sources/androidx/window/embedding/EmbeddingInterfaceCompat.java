package androidx.window.embedding;

import android.app.Activity;
import java.util.List;

/* loaded from: classes.dex */
public interface EmbeddingInterfaceCompat {

    public interface EmbeddingCallbackInterface {
        void a(List list);
    }

    boolean a(Activity activity);

    void b(EmbeddingCallbackInterface embeddingCallbackInterface);
}
