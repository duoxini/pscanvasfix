package com.oplus.settingslib.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class RecoveryService extends Service {
    public static final String ACTION_SETTINGS_RECOVERY_SERVICE = "oplus.intent.action.settings.RECOVERY_SERVICE";
    private static final int MSG_FROM_CLIENT_TO_SERVER_RECOVERY = 1;
    private static final int MSG_FROM_SERVER_TO_CLIENT_FAIL = 3;
    private static final int MSG_FROM_SERVER_TO_CLIENT_SUCCEED = 2;
    public static final String PERMISSION_RECOVERY_SETTINGS = "oplus.permission.settings.RECOVERY_SETTINGS";
    public static final String TAG = "RecoveryService";
    private a mRecoveryTask;
    private Messenger mServerMessenger;

    class a extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        private Context f10996a;

        /* renamed from: b, reason: collision with root package name */
        private Messenger f10997b;

        public a(Context context) {
            this.f10996a = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Messenger... messengerArr) {
            this.f10997b = messengerArr[0];
            return Boolean.valueOf(RecoveryService.this.doRecoveryOperation(this.f10996a));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                this.f10997b.send(Message.obtain((Handler) null, bool.booleanValue() ? 2 : 3));
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
        }
    }

    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private a f10999a;

        public b(a aVar) {
            this.f10999a = aVar;
        }

        private void a(Message message) {
            a aVar = this.f10999a;
            if (aVar != null) {
                try {
                    aVar.execute(message.replyTo);
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a(message);
            }
        }
    }

    public abstract boolean doRecoveryOperation(Context context);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.mRecoveryTask = new a(this);
        Messenger messenger = new Messenger(new b(this.mRecoveryTask));
        this.mServerMessenger = messenger;
        return messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.mRecoveryTask;
        if (aVar != null) {
            aVar.cancel(true);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        a aVar = this.mRecoveryTask;
        if (aVar != null) {
            aVar.cancel(true);
        }
        return super.onUnbind(intent);
    }
}
