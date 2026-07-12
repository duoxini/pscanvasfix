package b;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0289a {

    /* renamed from: a, reason: collision with root package name */
    private final Set f7270a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f7271b;

    public void a(InterfaceC0290b interfaceC0290b) {
        if (this.f7271b != null) {
            interfaceC0290b.a(this.f7271b);
        }
        this.f7270a.add(interfaceC0290b);
    }

    public void b() {
        this.f7271b = null;
    }

    public void c(Context context) {
        this.f7271b = context;
        Iterator it = this.f7270a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0290b) it.next()).a(context);
        }
    }

    public Context d() {
        return this.f7271b;
    }

    public void e(InterfaceC0290b interfaceC0290b) {
        this.f7270a.remove(interfaceC0290b);
    }
}
