package v;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: v.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0606a extends IInterface {

    /* renamed from: v.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0150a extends Binder implements InterfaceC0606a {

        /* renamed from: v.a$a$a, reason: collision with other inner class name */
        private static class C0151a implements InterfaceC0606a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f13847a;

            C0151a(IBinder iBinder) {
                this.f13847a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13847a;
            }
        }

        public static InterfaceC0606a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0606a)) ? new C0151a(iBinder) : (InterfaceC0606a) queryLocalInterface;
        }
    }
}
