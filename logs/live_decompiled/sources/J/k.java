package J;

import J.j;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface k extends IInterface {

    public static abstract class a extends Binder implements k {

        /* renamed from: J.k$a$a, reason: collision with other inner class name */
        private static class C0020a implements k {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f997a;

            C0020a(IBinder iBinder) {
                this.f997a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f997a;
            }

            @Override // J.k
            public void d(int i3, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i3);
                    obtain.writeStringArray(strArr);
                    this.f997a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // J.k
            public int e(j jVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongInterface(jVar);
                    obtain.writeString(str);
                    this.f997a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static k j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new C0020a(iBinder) : (k) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            if (i3 == 1) {
                int e3 = e(j.a.j(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(e3);
            } else if (i3 == 2) {
                c(j.a.j(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i3 != 3) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                d(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }
    }

    void c(j jVar, int i3);

    void d(int i3, String[] strArr);

    int e(j jVar, String str);
}
