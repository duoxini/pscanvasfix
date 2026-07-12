package com.oplus.pscanvas.canvasmode.canvas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemProperties;
import android.util.Log;
import com.oplus.pscanvas.canvasmode.canvas.C0309c;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.ArrayList;
import java.util.List;
import u1.C0601d;

/* renamed from: com.oplus.pscanvas.canvasmode.canvas.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0309c {

    /* renamed from: d, reason: collision with root package name */
    private static final String f10512d = "c";

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f10513e = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: a, reason: collision with root package name */
    private final Context f10514a;

    /* renamed from: b, reason: collision with root package name */
    private ContainerView f10515b;

    /* renamed from: c, reason: collision with root package name */
    String f10516c;

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$a */
    class a implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ContainerView f10517e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ C0601d f10518f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f10519g;

        a(ContainerView containerView, C0601d c0601d, boolean z3) {
            this.f10517e = containerView;
            this.f10518f = c0601d;
            this.f10519g = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(ContainerView containerView, C0601d c0601d, boolean z3) {
            Log.d(C0309c.f10512d, "startEnlargeOrSmallerAnimation#onMaskShow");
            containerView.getAdapter().D();
            containerView.b2();
            c0601d.o0(z3);
            containerView.V2(c0601d, 0);
            containerView.getContainerController().G(c0601d);
            containerView.getAdapter().N(containerView.getAdapter().l());
        }

        @Override // C2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Handler mainThreadHandler = C0309c.this.f10514a.getMainThreadHandler();
            final ContainerView containerView = this.f10517e;
            final C0601d c0601d = this.f10518f;
            final boolean z3 = this.f10519g;
            mainThreadHandler.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.b
                @Override // java.lang.Runnable
                public final void run() {
                    C0309c.a.c(ContainerView.this, c0601d, z3);
                }
            });
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$b */
    class b implements C2.a {
        b(C0309c c0309c) {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$c, reason: collision with other inner class name */
    class C0128c implements C2.a {
        C0128c() {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Log.d(C0309c.f10512d, "startEnlargeOrSmallerAnimation#enlargeOrSmallerMaskHide");
            if (C0309c.this.f10515b != null && C0309c.this.f10515b.f10732G != null) {
                C0309c.this.f10515b.f10732G.H0();
            }
            if (C0309c.this.f10515b != null) {
                C0309c.this.f10515b.f10755S = false;
            }
            if (C0309c.this.f10515b != null && C0309c.this.f10515b.getFlexibleUiManager() != null) {
                C0309c.this.f10515b.getFlexibleUiManager().O();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.flexible.animatingEnlargeSmallAnimation", false);
            B1.l.f(bundle);
            C0309c c0309c = C0309c.this;
            if (c0309c.f10516c != null) {
                B1.h a3 = B1.h.a(c0309c.f10514a);
                C0309c c0309c2 = C0309c.this;
                a3.d(c0309c2.f10516c, c0309c2.f10515b);
                C0309c.this.f10516c = null;
            }
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$d */
    class d implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10522e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f10523f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10524g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f10525h;

        d(int i3, Intent intent, int i4, int i5) {
            this.f10522e = i3;
            this.f10523f = intent;
            this.f10524g = i4;
            this.f10525h = i5;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            B1.l.O1(C0309c.this.f10514a).Z1(this.f10522e, this.f10523f, this.f10524g, this.f10525h);
            B1.l.O1(C0309c.this.f10514a).v0().q0(this.f10525h).setHasBeenReplaced(true);
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$e */
    class e implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ContainerView f10527e;

        e(C0309c c0309c, ContainerView containerView) {
            this.f10527e = containerView;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            this.f10527e.b2();
            this.f10527e.f10732G.D0(8);
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$f */
    class f implements C2.a {
        f(C0309c c0309c) {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$g */
    class g implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10528e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f10529f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10530g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f10531h;

        g(int i3, Intent intent, int i4, int i5) {
            this.f10528e = i3;
            this.f10529f = intent;
            this.f10530g = i4;
            this.f10531h = i5;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            B1.l.O1(C0309c.this.f10514a).Z1(this.f10528e, this.f10529f, this.f10530g, this.f10531h);
            return p2.q.f12810a;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.c$h */
    class h implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ContainerView f10533e;

        h(ContainerView containerView) {
            this.f10533e = containerView;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Log.d(C0309c.f10512d, "replaceMaskHide");
            ContainerView containerView = this.f10533e;
            if (containerView != null) {
                E e3 = containerView.f10732G;
                if (e3 != null) {
                    e3.H0();
                }
                this.f10533e.f10755S = false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.flexible.animatingReplaceAnimation", false);
            B1.l.f(bundle);
            C0309c c0309c = C0309c.this;
            if (c0309c.f10516c != null) {
                B1.h.a(c0309c.f10514a).d(C0309c.this.f10516c, this.f10533e);
                C0309c.this.f10516c = null;
            }
            return p2.q.f12810a;
        }
    }

    public C0309c(Context context) {
        this.f10514a = context;
    }

    private C2.a d() {
        return new b(this);
    }

    private C2.a e() {
        return new C0128c();
    }

    private C2.a f(C0601d c0601d, boolean z3, ContainerView containerView) {
        return new a(containerView, c0601d, z3);
    }

    private C2.a g(ContainerView containerView) {
        return new h(containerView);
    }

    private C2.a h() {
        return new f(this);
    }

    private C2.a i(int i3, Intent intent, int i4, int i5) {
        return new d(i3, intent, i4, i5);
    }

    private C2.a j(int i3, Intent intent, int i4, int i5) {
        return new g(i3, intent, i4, i5);
    }

    private C2.a k(ContainerView containerView) {
        return new e(this, containerView);
    }

    private C0601d o(C0601d c0601d, boolean z3, boolean z4) {
        c0601d.q0(false);
        if (z4) {
            c0601d.o0(z3);
            c0601d.T(true);
        }
        return c0601d;
    }

    public void l(String str) {
        this.f10516c = str;
    }

    public void m(ContainerView containerView, C0601d c0601d, boolean z3) {
        E e3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<Rect> childrenPositionOnScreen = containerView.getChildrenPositionOnScreen();
        ArrayList arrayList3 = new ArrayList();
        int k3 = containerView.getContainerController().k();
        if (childrenPositionOnScreen.size() != k3) {
            Log.e(f10512d, "startEnlargeOrSmallerAnimation error!!ContainerAdapter count does not match the size of EmbeddedViewDecor");
            return;
        }
        Bundle bundle = new Bundle();
        boolean z4 = true;
        bundle.putBoolean("androidx.flexible.animatingEnlargeSmallAnimation", true);
        B1.l.f(bundle);
        int n3 = containerView.getContainerController().n();
        ArrayList arrayList4 = new ArrayList();
        int i3 = 0;
        while (i3 < k3) {
            C0601d l3 = containerView.getContainerController().l(i3);
            arrayList3.add(o(l3, z3, n3 == i3 ? z4 : false));
            arrayList4.add(containerView.p0(containerView.D0(i3)));
            arrayList.add(new y1.u(childrenPositionOnScreen.get(i3), l3.f(), l3.e(), (Bitmap) arrayList4.get(i3)));
            i3++;
            childrenPositionOnScreen = childrenPositionOnScreen;
            z4 = true;
        }
        List<Rect> list = childrenPositionOnScreen;
        containerView.f3(arrayList3);
        List d12 = B1.l.d1(this.f10514a, arrayList3, n3, containerView.getContainerController().q(), false);
        Log.d(f10512d, "startEnlargeOrSmallerAnimation#focusIndex: " + n3 + ", isEnlarge: " + z3 + ", canvasTargetPosition: " + d12);
        int i4 = 0;
        while (i4 < k3) {
            C0601d c0601d2 = (C0601d) arrayList3.get(i4);
            arrayList2.add(new y1.u((Rect) d12.get(i4), c0601d2.f(), c0601d2.e(), (Bitmap) arrayList4.get(i4)));
            i4++;
            arrayList3 = arrayList3;
        }
        String str = f10512d;
        Log.d(str, "startEnlargeOrSmallerAnimation#oldRects: " + arrayList + ", targetRects: " + arrayList2 + ",focusTaskData:" + c0601d);
        this.f10515b = containerView;
        containerView.f10755S = true;
        containerView.f10732G.D0(4);
        this.f10515b.getCanvasMaskManager().i0(404);
        this.f10515b.getCanvasMaskManager().g0(-1);
        if (c0601d != null) {
            boolean B3 = c0601d.B();
            boolean z5 = B1.d.f168d;
            Log.d(str, "startEnlargeOrSmallerAnimation isNeedProportionalScale:" + B3 + ",isLiteOs:" + z5);
            if (!B3 && !z5) {
                containerView.getCanvasMaskManager().d0(c0601d.s());
            }
        }
        containerView.getCanvasMaskManager().n0(arrayList, arrayList2, containerView.A1(0, list, d12), -1, n3, f(c0601d, z3, containerView), d(), e());
        ContainerView containerView2 = this.f10515b;
        if (containerView2 != null && containerView2.getFlexibleUiManager() != null) {
            this.f10515b.getFlexibleUiManager().o(203);
        }
        ContainerView containerView3 = this.f10515b;
        if (containerView3 == null || (e3 = containerView3.f10732G) == null) {
            return;
        }
        e3.Q();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r23, android.content.Intent r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.C0309c.n(com.oplus.pscanvas.canvasmode.canvas.view.ContainerView, android.content.Intent, int, int, int):void");
    }
}
