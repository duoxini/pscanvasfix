package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f4821a = (IconCompat) aVar.v(remoteActionCompat.f4821a, 1);
        remoteActionCompat.f4822b = aVar.l(remoteActionCompat.f4822b, 2);
        remoteActionCompat.f4823c = aVar.l(remoteActionCompat.f4823c, 3);
        remoteActionCompat.f4824d = (PendingIntent) aVar.r(remoteActionCompat.f4824d, 4);
        remoteActionCompat.f4825e = aVar.h(remoteActionCompat.f4825e, 5);
        remoteActionCompat.f4826f = aVar.h(remoteActionCompat.f4826f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f4821a, 1);
        aVar.D(remoteActionCompat.f4822b, 2);
        aVar.D(remoteActionCompat.f4823c, 3);
        aVar.H(remoteActionCompat.f4824d, 4);
        aVar.z(remoteActionCompat.f4825e, 5);
        aVar.z(remoteActionCompat.f4826f, 6);
    }
}
