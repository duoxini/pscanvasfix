package androidx.room;

import J.j;
import J.k;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import p2.q;

/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: e, reason: collision with root package name */
    private int f6632e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f6633f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final RemoteCallbackList f6634g = new b();

    /* renamed from: h, reason: collision with root package name */
    private final k.a f6635h = new a();

    public static final class a extends k.a {
        a() {
        }

        @Override // J.k
        public void c(j jVar, int i3) {
            D2.k.e(jVar, "callback");
            RemoteCallbackList a3 = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (a3) {
                multiInstanceInvalidationService.a().unregister(jVar);
            }
        }

        @Override // J.k
        public void d(int i3, String[] strArr) {
            D2.k.e(strArr, "tables");
            RemoteCallbackList a3 = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (a3) {
                String str = (String) multiInstanceInvalidationService.b().get(Integer.valueOf(i3));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
                for (int i4 = 0; i4 < beginBroadcast; i4++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i4);
                        D2.k.c(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int intValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.b().get(num);
                        if (i3 != intValue && D2.k.a(str, str2)) {
                            try {
                                ((j) multiInstanceInvalidationService.a().getBroadcastItem(i4)).f(strArr);
                            } catch (RemoteException e3) {
                                Log.w("ROOM", "Error invoking a remote callback", e3);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.a().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.a().finishBroadcast();
                q qVar = q.f12810a;
            }
        }

        @Override // J.k
        public int e(j jVar, String str) {
            D2.k.e(jVar, "callback");
            int i3 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList a3 = MultiInstanceInvalidationService.this.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (a3) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() + 1);
                    int c3 = multiInstanceInvalidationService.c();
                    if (multiInstanceInvalidationService.a().register(jVar, Integer.valueOf(c3))) {
                        multiInstanceInvalidationService.b().put(Integer.valueOf(c3), str);
                        i3 = c3;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() - 1);
                        multiInstanceInvalidationService.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i3;
        }
    }

    public static final class b extends RemoteCallbackList {
        b() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(j jVar, Object obj) {
            D2.k.e(jVar, "callback");
            D2.k.e(obj, "cookie");
            MultiInstanceInvalidationService.this.b().remove((Integer) obj);
        }
    }

    public final RemoteCallbackList a() {
        return this.f6634g;
    }

    public final Map b() {
        return this.f6633f;
    }

    public final int c() {
        return this.f6632e;
    }

    public final void d(int i3) {
        this.f6632e = i3;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        D2.k.e(intent, Constants.MessagerConstants.INTENT_KEY);
        return this.f6635h;
    }
}
