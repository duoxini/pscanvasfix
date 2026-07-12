package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import v.InterfaceC0606a;
import v.InterfaceC0607b;

/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0607b.a f4845e = new a();

    class a extends InterfaceC0607b.a {
        a() {
        }

        @Override // v.InterfaceC0607b
        public void h(InterfaceC0606a interfaceC0606a) {
            if (interfaceC0606a == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new d(interfaceC0606a));
        }
    }

    protected abstract void a(d dVar);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f4845e;
    }
}
