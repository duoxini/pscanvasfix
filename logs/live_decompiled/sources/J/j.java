package J;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface j extends IInterface {

    public static abstract class a extends Binder implements j {

        /* renamed from: J.j$a$a, reason: collision with other inner class name */
        private static class C0019a implements j {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f996a;

            C0019a(IBinder iBinder) {
                this.f996a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f996a;
            }

            @Override // J.j
            public void f(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    this.f996a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static j j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j)) ? new C0019a(iBinder) : (j) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            f(parcel.createStringArray());
            return true;
        }
    }

    void f(String[] strArr);
}
