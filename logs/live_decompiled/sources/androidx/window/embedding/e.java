package androidx.window.embedding;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
