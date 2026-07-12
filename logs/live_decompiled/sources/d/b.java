package D;

import android.text.Editable;
import androidx.emoji2.text.n;

/* loaded from: classes.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f269a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f270b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f271c;

    private b() {
        try {
            f271c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f270b == null) {
            synchronized (f269a) {
                try {
                    if (f270b == null) {
                        f270b = new b();
                    }
                } finally {
                }
            }
        }
        return f270b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f271c;
        return cls != null ? n.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
