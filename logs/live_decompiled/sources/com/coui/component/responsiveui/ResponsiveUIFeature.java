package com.coui.component.responsiveui;

import D2.g;
import D2.k;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.InterfaceC0267c;
import androidx.lifecycle.o;
import androidx.lifecycle.t;
import com.coui.component.responsiveui.ResponsiveUIFeature;
import com.coui.component.responsiveui.status.FoldingState;
import com.coui.component.responsiveui.status.FoldingStateUtil;
import com.coui.component.responsiveui.status.WindowFeature;
import com.coui.component.responsiveui.status.WindowFeatureUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final class ResponsiveUIFeature implements IResponsiveUIFeature {
    public static final Companion Companion = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f9316c;

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap f9317d;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f9318a;

    /* renamed from: b, reason: collision with root package name */
    private t f9319b;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final FoldingState getFoldingState(Context context) {
            k.e(context, "context");
            return FoldingStateUtil.getFoldingState(context);
        }

        public final IResponsiveUIFeature getOrCreate(ComponentActivity componentActivity) {
            k.e(componentActivity, "activity");
            int hashCode = componentActivity.hashCode();
            IResponsiveUIFeature iResponsiveUIFeature = (IResponsiveUIFeature) ResponsiveUIFeature.f9317d.get(Integer.valueOf(hashCode));
            if (iResponsiveUIFeature != null) {
                return iResponsiveUIFeature;
            }
            ResponsiveUIFeature responsiveUIFeature = new ResponsiveUIFeature(componentActivity, null);
            ResponsiveUIFeature.f9317d.put(Integer.valueOf(hashCode), responsiveUIFeature);
            return responsiveUIFeature;
        }

        public final boolean isSupportWindowFeature() {
            return WindowFeatureUtil.isSupportWindowFeature();
        }

        private Companion() {
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9316c = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("ResponsiveUIFeature", 3);
        f9317d = new ConcurrentHashMap();
    }

    public /* synthetic */ ResponsiveUIFeature(ComponentActivity componentActivity, g gVar) {
        this(componentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ResponsiveUIFeature responsiveUIFeature, WindowFeature windowFeature) {
        k.e(responsiveUIFeature, "this$0");
        k.e(windowFeature, "windowFeature");
        responsiveUIFeature.c(responsiveUIFeature.f9319b, windowFeature);
    }

    private final void c(t tVar, Object obj) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            tVar.j(obj);
        } else {
            tVar.h(obj);
        }
    }

    public static final FoldingState getFoldingState(Context context) {
        return Companion.getFoldingState(context);
    }

    public static final IResponsiveUIFeature getOrCreate(ComponentActivity componentActivity) {
        return Companion.getOrCreate(componentActivity);
    }

    public static final boolean isSupportWindowFeature() {
        return Companion.isSupportWindowFeature();
    }

    @Override // com.coui.component.responsiveui.IResponsiveUIFeature
    public t getWindowFeatureLiveData() {
        return this.f9319b;
    }

    private ResponsiveUIFeature(ComponentActivity componentActivity) {
        this.f9318a = new WeakReference(componentActivity);
        this.f9319b = new t();
        if (WindowFeatureUtil.isSupportWindowFeature()) {
            WindowFeatureUtil.INSTANCE.trackWindowFeature(componentActivity, new Consumer() { // from class: B0.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ResponsiveUIFeature.b(ResponsiveUIFeature.this, (WindowFeature) obj);
                }
            });
        } else if (f9316c) {
            Log.w("ResponsiveUIFeature", "[init.isSupportWindowFeature] false");
        }
        componentActivity.getLifecycle().a(new InterfaceC0267c() { // from class: com.coui.component.responsiveui.ResponsiveUIFeature.2
            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public /* bridge */ /* synthetic */ void onCreate(o oVar) {
                super.onCreate(oVar);
            }

            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public void onDestroy(o oVar) {
                k.e(oVar, "owner");
                super.onDestroy(oVar);
                Activity activity = (Activity) ResponsiveUIFeature.this.f9318a.get();
                if (activity != null) {
                    ResponsiveUIFeature.f9317d.remove(Integer.valueOf(activity.hashCode()));
                }
            }

            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public /* bridge */ /* synthetic */ void onPause(o oVar) {
                super.onPause(oVar);
            }

            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public /* bridge */ /* synthetic */ void onResume(o oVar) {
                super.onResume(oVar);
            }

            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public /* bridge */ /* synthetic */ void onStart(o oVar) {
                super.onStart(oVar);
            }

            @Override // androidx.lifecycle.InterfaceC0267c, androidx.lifecycle.InterfaceC0269e
            public /* bridge */ /* synthetic */ void onStop(o oVar) {
                super.onStop(oVar);
            }
        });
    }
}
