package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    public static class Default implements INotificationSideChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {
        public Stub() {
            attachInterface(this, "android.support.v4.app.INotificationSideChannel");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
            }
            if (i3 == 1598968902) {
                parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                return true;
            }
            if (i3 == 1) {
                g(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) a.b(parcel, Notification.CREATOR));
            } else if (i3 == 2) {
                b(parcel.readString(), parcel.readInt(), parcel.readString());
            } else {
                if (i3 != 3) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                a(parcel.readString());
            }
            return true;
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void a(String str);

    void b(String str, int i3, String str2);

    void g(String str, int i3, String str2, Notification notification);
}
