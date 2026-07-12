package com.oplus.pscanvas.canvasmode.canvas;

import android.app.OplusActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import com.oplus.zoomwindow.IOplusZoomWindowObserver;
import com.oplus.zoomwindow.OplusZoomWindowInfo;
import com.oplus.zoomwindow.OplusZoomWindowManager;
import java.util.List;
import u1.C0601d;

/* loaded from: classes.dex */
public class J {

    /* renamed from: a, reason: collision with root package name */
    private Context f10473a;

    /* renamed from: b, reason: collision with root package name */
    private ContainerView f10474b;

    /* renamed from: c, reason: collision with root package name */
    private I f10475c;

    /* renamed from: d, reason: collision with root package name */
    private OplusActivityManager f10476d = new OplusActivityManager();

    /* renamed from: e, reason: collision with root package name */
    private int f10477e;

    class a extends IOplusZoomWindowObserver.Stub {
        a() {
        }

        public void onInputMethodChanged(boolean z3) {
        }

        public void onZoomWindowDied(String str) {
        }

        public void onZoomWindowHide(OplusZoomWindowInfo oplusZoomWindowInfo) {
        }

        public void onZoomWindowShow(OplusZoomWindowInfo oplusZoomWindowInfo) {
            Handler g02 = J.this.f10475c.g0();
            if (g02 == null || !J.this.f10475c.o0() || J.this.f10475c.n0() || !g02.hasMessages(2)) {
                return;
            }
            g02.removeMessages(2);
            Log.d("CanvasSwitchToZoomManager", "onZoomWindowShow start hide animation");
            Message obtainMessage = g02.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = J.this.f10477e;
            g02.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    public J(Context context, ContainerView containerView, EmbeddedViewDecor embeddedViewDecor) {
        this.f10473a = context;
        this.f10474b = containerView;
        if (context != null && containerView != null && embeddedViewDecor != null) {
            this.f10475c = new I(context, containerView, embeddedViewDecor);
        }
        OplusZoomWindowManager.getInstance().registerZoomWindowObserver(new a());
    }

    private int e(int i3) {
        int h3 = this.f10474b.getAdapter().h();
        if (i3 <= 0) {
            return h3;
        }
        List l3 = this.f10474b.getAdapter().l();
        for (int i4 = 0; i4 < l3.size(); i4++) {
            if (((C0601d) l3.get(i4)).s() == i3) {
                return i4;
            }
        }
        return h3;
    }

    public boolean c(int i3) {
        C0601d item = this.f10474b.getAdapter().getItem(i3);
        if (item == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.activity.ShowUnSupportToast", false);
        return B1.l.k(item, bundle);
    }

    public void d(String str) {
        I i3 = this.f10475c;
        if (i3 != null) {
            i3.c0(str);
        }
    }

    public void f() {
        I i3 = this.f10475c;
        if (i3 != null) {
            i3.w0();
        }
    }

    public void g(boolean z3, int i3) {
        I i4;
        ContainerView containerView = this.f10474b;
        if (containerView == null || containerView.getAdapter() == null || (i4 = this.f10475c) == null) {
            Log.d("CanvasSwitchToZoomManager", "switchToZoomForSplit fail");
            return;
        }
        i4.v0(z3);
        int e3 = e(i3);
        this.f10477e = this.f10474b.getAdapter().getCount();
        Handler g02 = this.f10475c.g0();
        if (g02 != null) {
            Message obtainMessage = g02.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = e3;
            obtainMessage.arg2 = this.f10477e;
            g02.sendMessage(obtainMessage);
            Message obtainMessage2 = g02.obtainMessage();
            obtainMessage2.what = 3;
            g02.sendMessageDelayed(obtainMessage2, 2500L);
        }
    }
}
