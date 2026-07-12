package c;

import D2.k;
import android.content.Context;
import android.content.Intent;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0294a {

    /* renamed from: c.a$a, reason: collision with other inner class name */
    public static final class C0098a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f7279a;

        public C0098a(Object obj) {
            this.f7279a = obj;
        }

        public final Object a() {
            return this.f7279a;
        }
    }

    public abstract Intent a(Context context, Object obj);

    public C0098a b(Context context, Object obj) {
        k.e(context, "context");
        return null;
    }

    public abstract Object c(int i3, Intent intent);
}
