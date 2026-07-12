package androidx.loader.app;

import androidx.lifecycle.I;
import androidx.lifecycle.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {
    public static a b(o oVar) {
        return new b(oVar, ((I) oVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
