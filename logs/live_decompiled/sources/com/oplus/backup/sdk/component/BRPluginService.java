package com.oplus.backup.sdk.component;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.oplus.backup.sdk.common.host.BREngineConfig;
import com.oplus.backup.sdk.common.load.BRPluginLoader;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.backup.sdk.common.utils.ReflectUtils;
import com.oplus.backup.sdk.common.utils.StaticHandler;
import com.oplus.backup.sdk.host.BRPluginServiceInfo;
import com.oplus.backup.sdk.host.BRPluginSource;
import java.lang.Thread;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class BRPluginService extends Service {
    public static final boolean DEBUG_SYNC_THREAD = true;
    public static final String TAG = "BRPluginService";
    private Handler mAsyncHandler;
    private HandlerThread mAsyncThread;
    private BREngineConfig mBREngineConfig;
    private Object mBRPlugin;
    private BRPluginHandlerImpl mBRPluginHandler;
    private IBinder mBinder;
    private ClassLoader mClassLoader;
    private Handler mHandler;
    private InvocationBRPluginHandlerImpl mInvocationBRPluginHandler;
    private BRPluginLoader mLoader;
    private Messenger mMessenger;
    private Class<?> mPluginClass;
    private Messenger mSendMessenger;
    private Handler mSyncHandler;
    private HandlerThread mSyncThread;

    private class BRPluginHandlerImpl implements BRPluginHandler {
        public BRPluginHandlerImpl() {
        }

        @Override // com.oplus.backup.sdk.component.BRPluginHandler
        public void error(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle(Constants.MessagerConstants.ARGS_KEY, bundle);
            BRPluginService.this.sendMsg(4, bundle2, true);
        }

        @Override // com.oplus.backup.sdk.component.BRPluginHandler
        public void sendMsg(Intent intent, boolean z3) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.MessagerConstants.ARGS_KEY, intent);
            BRPluginService.this.sendMsg(2, bundle, z3);
        }

        @Override // com.oplus.backup.sdk.component.BRPluginHandler
        public void updateProgress(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle(Constants.MessagerConstants.ARGS_KEY, bundle);
            BRPluginService.this.sendMsg(3, bundle2, true);
        }
    }

    private class InvocationBRPluginHandlerImpl implements InvocationHandler {
        private InvocationBRPluginHandlerImpl() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if ("updateProgress".equals(method.getName())) {
                BRPluginService.this.mBRPluginHandler.updateProgress((Bundle) objArr[0]);
                return null;
            }
            if ("error".equals(method.getName())) {
                BRPluginService.this.mBRPluginHandler.error((Bundle) objArr[0]);
                return null;
            }
            if (!"sendMsg".equals(method.getName())) {
                return null;
            }
            BRPluginService.this.mBRPluginHandler.sendMsg((Intent) objArr[0], ((Boolean) objArr[1]).booleanValue());
            return null;
        }
    }

    private static class MessengerHandler extends StaticHandler<BRPluginService> {
        private Handler mAsyncHandler;
        private Handler mSyncHandler;

        public MessengerHandler(BRPluginService bRPluginService, Looper looper, Handler handler, Handler handler2) {
            super(bRPluginService, looper);
            this.mAsyncHandler = handler;
            this.mSyncHandler = handler2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.oplus.backup.sdk.common.utils.StaticHandler
        public void handleMessage(Message message, BRPluginService bRPluginService) {
            BRLog.d(BRPluginService.TAG, "MessagerHandler handleMessage " + message.what + ", msg.arg1:" + message.arg1);
            int i3 = message.arg1;
            if (i3 == 0) {
                this.mAsyncHandler.sendMessage(Message.obtain(message));
            } else {
                if (i3 != 1) {
                    return;
                }
                this.mSyncHandler.sendMessage(Message.obtain(message));
            }
        }
    }

    private static class WorkHandler extends StaticHandler<BRPluginService> {
        public WorkHandler(BRPluginService bRPluginService, Looper looper) {
            super(bRPluginService, looper);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.oplus.backup.sdk.common.utils.StaticHandler
        public void handleMessage(Message message, BRPluginService bRPluginService) {
            Bundle bundle;
            String str;
            Messenger messenger = message.replyTo;
            if (messenger == null) {
                BRLog.w(BRPluginService.TAG, "handleMessage, messenger is null, return");
                return;
            }
            bRPluginService.mSendMessenger = messenger;
            Object obj = message.obj;
            if (obj != null) {
                Bundle bundle2 = (Bundle) obj;
                bundle = bundle2.getBundle(Constants.MessagerConstants.ARGS_KEY);
                str = bundle2.getString(Constants.MessagerConstants.METHOD_KEY);
            } else {
                bundle = null;
                str = null;
            }
            Bundle bundle3 = new Bundle();
            BRLog.d(BRPluginService.TAG, "WorkHandler handleMessage " + message.what + ", msg.arg1:" + message.arg1 + ", " + bundle + ", method:" + str);
            Object obj2 = bRPluginService.mBRPlugin;
            Class cls = bRPluginService.mPluginClass;
            int i3 = message.what;
            if (i3 == 0) {
                Bundle bundle4 = bundle.getBundle(Constants.MessagerConstants.CONFIG_KEY);
                if (bundle4 != null) {
                    bRPluginService.mBREngineConfig = new BREngineConfig(bundle4);
                    BRLog.setLogLevel(bRPluginService.mBREngineConfig.getLogLevel());
                }
                bundle3.putBundle(Constants.MessagerConstants.RETURN_KEY, bRPluginService.load(bundle));
            } else if (i3 != 1) {
                if (i3 != 2) {
                    switch (i3) {
                        case 6:
                            BRLog.d(BRPluginService.TAG, "" + new BREngineConfig(bundle.getBundle(Constants.MessagerConstants.CONFIG_KEY)));
                            if (obj2 != null) {
                                bundle3.putBundle(Constants.MessagerConstants.RETURN_KEY, (Bundle) bRPluginService.invoke(obj2, cls, "onPrepare", bundle));
                                break;
                            }
                            break;
                        case 7:
                            if (obj2 != null) {
                                bRPluginService.invoke(obj2, cls, "onBackup", bundle);
                                break;
                            }
                            break;
                        case 8:
                            if (obj2 != null) {
                                bRPluginService.invoke(obj2, cls, "onRestore", bundle);
                                break;
                            }
                            break;
                        case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                            if (obj2 != null) {
                                bRPluginService.invoke(obj2, cls, "onPause", bundle);
                                break;
                            }
                            break;
                        case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                            if (obj2 != null) {
                                bRPluginService.invoke(obj2, cls, "onContinue", bundle);
                                break;
                            }
                            break;
                        case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                            HandlerThread handlerThread = bRPluginService.mSyncThread;
                            if (handlerThread != null) {
                                BRLog.i(BRPluginService.TAG, "before onCancel, Thread state = " + handlerThread.getState());
                            }
                            if (obj2 != null) {
                                bRPluginService.invoke(obj2, cls, "onCancel", bundle);
                            }
                            HandlerThread handlerThread2 = bRPluginService.mSyncThread;
                            if (handlerThread2 != null) {
                                Thread.State state = handlerThread2.getState();
                                BRLog.i(BRPluginService.TAG, "after onCancel, Thread state = " + state);
                                if (Thread.State.BLOCKED == state || Thread.State.WAITING == state) {
                                    BRLog.w(BRPluginService.TAG, "getStackTrace:\n" + BRPluginService.getStackMsg(handlerThread2.getStackTrace()));
                                    break;
                                }
                            }
                            break;
                        case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                            if (obj2 != null) {
                                bundle3.putBundle(Constants.MessagerConstants.RETURN_KEY, (Bundle) bRPluginService.invoke(obj2, cls, "onDestroy", bundle));
                                break;
                            }
                            break;
                        case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                            if (obj2 != null) {
                                bundle3.putBundle(Constants.MessagerConstants.RETURN_KEY, (Bundle) bRPluginService.invoke(obj2, cls, "onPreview", bundle));
                                break;
                            }
                            break;
                    }
                } else {
                    bRPluginService.receive(bundle, message.arg1 == 0);
                }
            } else if (obj2 != null) {
                bundle3.putBundle(Constants.MessagerConstants.RETURN_KEY, (Bundle) bRPluginService.invoke(obj2, cls, str, bundle));
            }
            if (message.arg1 == 1) {
                bRPluginService.returnMsg(messenger, message.what, bundle3, false);
            }
        }
    }

    private Class<?> findClass(BRPluginConfig bRPluginConfig, int i3) {
        BRPluginLoader bRPluginLoader = new BRPluginLoader();
        this.mLoader = bRPluginLoader;
        ClassLoader load = bRPluginLoader.load(this, bRPluginConfig);
        this.mClassLoader = load;
        if (i3 == 0) {
            return this.mLoader.findClass(bRPluginConfig, load, 0);
        }
        if (i3 == 1) {
            return this.mLoader.findClass(bRPluginConfig, load, 1);
        }
        return null;
    }

    private BRPluginConfig getLocalPluginConfig() {
        ServiceInfo serviceInfo;
        BRPluginConfig[] localBRPlugins = BRPluginSource.getLocalBRPlugins(getApplicationContext(), BRPluginSource.LOCAL_PLUGINS_DIR);
        try {
            serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            BRLog.e(TAG, "imposible! no this service? " + this + ", " + this.getClass());
            serviceInfo = null;
        }
        if (serviceInfo != null) {
            BRPluginServiceInfo bRPluginServiceInfo = new BRPluginServiceInfo();
            bRPluginServiceInfo.setClass(serviceInfo.packageName, serviceInfo.name);
            bRPluginServiceInfo.setMetaData(serviceInfo.metaData);
            if (localBRPlugins != null && localBRPlugins.length > 0) {
                for (BRPluginConfig bRPluginConfig : localBRPlugins) {
                    if (bRPluginServiceInfo.getUniqueID().equals(bRPluginConfig.getUniqueID())) {
                        return bRPluginConfig;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStackMsg(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        if (stackTraceElementArr != null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                sb.append(stackTraceElement.toString() + "\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object invoke(Object obj, Class<?> cls, String str, Bundle bundle) {
        if (obj == null || cls == null) {
            return null;
        }
        return ReflectUtils.invoke(obj, cls, str, new Class[]{Bundle.class}, new Object[]{bundle});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle load(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.backup.sdk.component.BRPluginService.load(android.os.Bundle):android.os.Bundle");
    }

    private void onReveiveMsg(Object obj, Class<?> cls, Intent intent, boolean z3) {
        if (obj == null || cls == null) {
            return;
        }
        ReflectUtils.invoke(obj, cls, "onReveiveMsg", new Class[]{Intent.class, Boolean.TYPE}, new Object[]{intent, Boolean.valueOf(z3)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receive(Bundle bundle, boolean z3) {
        onReveiveMsg(this.mBRPlugin, this.mPluginClass, (Intent) bundle.get(Constants.MessagerConstants.INTENT_KEY), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnMsg(Messenger messenger, int i3, Bundle bundle, boolean z3) {
        try {
            messenger.send(Message.obtain(null, i3, !z3 ? 1 : 0, 0, bundle));
        } catch (RemoteException e3) {
            BRLog.e(TAG, "returnMsg, e =" + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(int i3, Bundle bundle, boolean z3) {
        Message obtain = Message.obtain(null, i3, !z3 ? 1 : 0, 0, bundle);
        Messenger messenger = this.mSendMessenger;
        if (messenger == null) {
            BRLog.e(TAG, "mSendMessenger == null");
            return;
        }
        try {
            messenger.send(obtain);
        } catch (RemoteException e3) {
            BRLog.e(TAG, "sendMsg, e =" + e3.getMessage());
        }
    }

    protected BRPluginLoader getBRPluginLoader() {
        return this.mLoader;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mBinder == null) {
            BRLog.i(TAG, "onBind ");
            this.mBinder = this.mMessenger.getBinder();
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BRLog.d(TAG, "onCreate ");
        HandlerThread handlerThread = new HandlerThread("br_plugin_messager_thread");
        this.mSyncThread = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("br_plugin_async_thread");
        this.mAsyncThread = handlerThread2;
        handlerThread2.start();
        this.mAsyncHandler = new WorkHandler(this, this.mAsyncThread.getLooper());
        this.mSyncHandler = new WorkHandler(this, this.mSyncThread.getLooper());
        this.mHandler = new MessengerHandler(this, getMainLooper(), this.mAsyncHandler, this.mSyncHandler);
        this.mMessenger = new Messenger(this.mHandler);
        this.mBRPluginHandler = new BRPluginHandlerImpl();
        this.mInvocationBRPluginHandler = new InvocationBRPluginHandlerImpl();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BRLog.i(TAG, "onDestroy");
        HandlerThread handlerThread = this.mSyncThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        HandlerThread handlerThread2 = this.mAsyncThread;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
        }
    }

    public BRPluginConfig onLoad(BRPluginConfig[] bRPluginConfigArr, int i3) {
        if (bRPluginConfigArr != null && bRPluginConfigArr.length > 0) {
            for (BRPluginConfig bRPluginConfig : bRPluginConfigArr) {
                if (bRPluginConfig != null) {
                    return bRPluginConfig;
                }
            }
        }
        return null;
    }
}
