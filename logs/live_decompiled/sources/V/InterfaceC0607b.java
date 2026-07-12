package v;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import v.InterfaceC0606a;

/* renamed from: v.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0607b extends IInterface {

    /* renamed from: v.b$a */
    public static abstract class a extends Binder implements InterfaceC0607b {
        public a() {
            attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            h(InterfaceC0606a.AbstractBinderC0150a.j(parcel.readStrongBinder()));
            return true;
        }
    }

    void h(InterfaceC0606a interfaceC0606a);
}
