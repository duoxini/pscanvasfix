package z1;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import x0.C0629c;

/* loaded from: classes.dex */
public abstract class h extends AbstractC0650c {

    /* renamed from: i, reason: collision with root package name */
    protected int f14690i;

    /* renamed from: j, reason: collision with root package name */
    protected int f14691j;

    /* renamed from: k, reason: collision with root package name */
    protected String f14692k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f14693l;

    /* renamed from: m, reason: collision with root package name */
    private Context f14694m;

    /* renamed from: n, reason: collision with root package name */
    private C0629c f14695n;

    /* renamed from: o, reason: collision with root package name */
    private C0653f f14696o;

    /* renamed from: p, reason: collision with root package name */
    private float f14697p;

    /* renamed from: q, reason: collision with root package name */
    private float f14698q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f14699r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f14700s;

    /* renamed from: t, reason: collision with root package name */
    private PopupWindow.OnDismissListener f14701t;

    /* renamed from: u, reason: collision with root package name */
    private a f14702u;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            AbstractC0652e.a("TipsManager: onGlobalLayout");
            h.this.q();
        }
    }

    public h(Context context) {
        super(context);
        this.f14691j = -1;
        this.f14693l = true;
        this.f14701t = new PopupWindow.OnDismissListener() { // from class: z1.g
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                h.this.o();
            }
        };
        this.f14694m = context;
        C0629c c0629c = new C0629c(context);
        this.f14695n = c0629c;
        c0629c.setOnDismissListener(this.f14701t);
        this.f14699r = j.a().d();
        this.f14700s = j.a().c();
        this.f14702u = new a();
    }

    private void l() {
        AbstractC0652e.a("TipsContainerView removeView");
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d != null && ((C0653f) interfaceC0651d).getTipsView() != null && ((C0653f) this.f14676e).getTipsView().isAttachedToWindow()) {
            ((C0653f) this.f14676e).getTipsView().removeAllViews();
        }
        if (this.f14677f == 2) {
            f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f14695n.T(this.f14692k);
        if (((C0653f) this.f14676e).getTipsView() != null) {
            this.f14695n.Y(((C0653f) this.f14676e).getTipsView(), this.f14690i, this.f14693l);
            AbstractC0652e.a("showTipsImpl");
        }
        int i3 = this.f14691j;
        if (i3 != 0) {
            if (i3 != 10) {
                ((C0653f) this.f14676e).getDragAnimationViewRight().setVisibility(4);
                return;
            }
            ((C0653f) this.f14676e).getDragAnimationViewRight().setVisibility(0);
            ((C0653f) this.f14676e).getDragAnimationViewRight().v();
            AbstractC0652e.a("playAnimation, flag: " + this.f14691j);
        }
    }

    protected void j() {
        if (!d()) {
            AbstractC0652e.a("Failed to showTipsContainerView(): initTargetView failed");
        } else {
            AbstractC0652e.a("TipsContainerView addView");
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // z1.AbstractC0650c
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0653f c() {
        AbstractC0652e.a("TipsContainerView createView start");
        C0653f c0653f = new C0653f(this.f14694m);
        this.f14696o = c0653f;
        c0653f.setHook(this);
        return this.f14696o;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void o() {
        try {
            InterfaceC0651d interfaceC0651d = this.f14676e;
            if (interfaceC0651d != null) {
                ((C0653f) interfaceC0651d).getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f14702u);
                AbstractC0652e.a("hideTips final dismiss");
                this.f14695n.dismiss();
                l();
            }
        } catch (Exception e3) {
            AbstractC0652e.c("hideTips error, e = " + e3);
            l();
        }
    }

    public boolean n() {
        C0629c c0629c = this.f14695n;
        if (c0629c != null) {
            return c0629c.isShowing();
        }
        return false;
    }

    @Override // z1.AbstractC0650c, z1.i
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d == null || ((C0653f) interfaceC0651d).getView() == null) {
            return;
        }
        ((C0653f) this.f14676e).getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f14702u);
    }

    @Override // z1.AbstractC0650c, z1.i
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC0652e.a("TipsManager: onDetachedFromWindow");
        this.f14691j = -1;
    }

    public void p(float f3, float f4) {
        this.f14697p = f3;
        this.f14698q = f4;
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d != null) {
            ((C0653f) interfaceC0651d).getTipsView().setX(this.f14697p);
            ((C0653f) this.f14676e).getTipsView().setY(this.f14698q);
        }
    }
}
