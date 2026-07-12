package z1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import java.util.function.Supplier;

/* renamed from: z1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0650c implements i {

    /* renamed from: b, reason: collision with root package name */
    protected final Context f14673b;

    /* renamed from: c, reason: collision with root package name */
    protected final WindowManager f14674c;

    /* renamed from: d, reason: collision with root package name */
    protected final LayoutInflater f14675d;

    /* renamed from: e, reason: collision with root package name */
    protected InterfaceC0651d f14676e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14679h;

    /* renamed from: a, reason: collision with root package name */
    protected final String f14672a = getClass().getSimpleName();

    /* renamed from: f, reason: collision with root package name */
    protected int f14677f = 0;

    /* renamed from: g, reason: collision with root package name */
    private final Supplier f14678g = new Supplier() { // from class: z1.b
        @Override // java.util.function.Supplier
        public final Object get() {
            return AbstractC0650c.this.c();
        }
    };

    /* renamed from: z1.c$a */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f14680a;

        a(Runnable runnable) {
            this.f14680a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            InterfaceC0651d interfaceC0651d = AbstractC0650c.this.f14676e;
            if (interfaceC0651d != null && interfaceC0651d.getView().isAttachedToWindow()) {
                this.f14680a.run();
                return;
            }
            AbstractC0652e.c("mTarget may not AttachedToWindow : " + AbstractC0650c.this.f14676e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InterfaceC0651d interfaceC0651d = AbstractC0650c.this.f14676e;
            if (interfaceC0651d != null && interfaceC0651d.getView().isAttachedToWindow()) {
                this.f14680a.run();
                return;
            }
            AbstractC0652e.c("mTarget may not AttachedToWindow : " + AbstractC0650c.this.f14676e);
        }
    }

    AbstractC0650c(Context context) {
        this.f14673b = context;
        this.f14674c = (WindowManager) context.getSystemService("window");
        this.f14675d = LayoutInflater.from(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        AbstractC0652e.a("removeView() WM removes view : " + this.f14676e.getView());
        this.f14674c.removeView(this.f14676e.getView());
    }

    public void b() {
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d == null) {
            AbstractC0652e.i("Failed to addView() : mTarget is null !");
            return;
        }
        if (interfaceC0651d.getView().isAttachedToWindow()) {
            AbstractC0652e.c("mTarget already AttachedToWindow : " + this.f14676e);
            return;
        }
        if (this.f14677f != 0) {
            AbstractC0652e.i("Invalid state: " + this.f14677f);
            return;
        }
        AbstractC0652e.f("addView() for : " + this.f14676e + ", state = " + this.f14677f);
        this.f14674c.addView(this.f14676e.getView(), this.f14676e.getWindowParams());
        this.f14677f = 1;
    }

    protected abstract InterfaceC0651d c();

    protected boolean d() {
        if (this.f14676e != null || this.f14677f != 0) {
            AbstractC0652e.c("Failed to initTargetView() - Invalid operation : mTarget = " + this.f14676e + ", mState = " + this.f14677f);
            return false;
        }
        this.f14676e = (InterfaceC0651d) this.f14678g.get();
        AbstractC0652e.f("Init view for " + this.f14672a + ", mTarget = " + this.f14676e);
        return true;
    }

    public void f(boolean z3) {
        AbstractC0652e.a("removeView() anim = " + z3 + ", state = " + this.f14677f);
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d == null) {
            AbstractC0652e.a("removeView() : mTarget is null!");
            return;
        }
        if (!interfaceC0651d.getView().isAttachedToWindow()) {
            AbstractC0652e.c("mTarget may not AttachedToWindow : " + this.f14676e);
            this.f14679h = true;
            return;
        }
        if (this.f14677f != 2) {
            AbstractC0652e.i("Invalid state: " + this.f14677f);
            return;
        }
        this.f14677f = 3;
        Runnable runnable = new Runnable() { // from class: z1.a
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC0650c.this.e();
            }
        };
        if (z3) {
            this.f14676e.a(new a(runnable));
        } else {
            runnable.run();
        }
    }

    public void g() {
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d == null || !interfaceC0651d.getView().isAttachedToWindow()) {
            AbstractC0652e.c("mTarget may not AttachedToWindow : " + this.f14676e);
            return;
        }
        if (this.f14677f == 2) {
            this.f14674c.updateViewLayout(this.f14676e.getView(), this.f14676e.getWindowParams());
            return;
        }
        AbstractC0652e.i("Invalid state: " + this.f14677f);
    }

    @Override // z1.i
    public void onAttachedToWindow() {
        AbstractC0652e.a(this.f14676e + " onAttachedToWindow()");
        this.f14677f = 2;
        if (this.f14679h) {
            if (this.f14676e != null) {
                AbstractC0652e.i("pendingRemoved onAttachedToWindow() - need removeView");
                this.f14674c.removeView(this.f14676e.getView());
            }
            this.f14679h = false;
        }
    }

    @Override // z1.i
    public void onDetachedFromWindow() {
        AbstractC0652e.a(this.f14676e + " onDetachedFromWindow()");
        this.f14677f = 0;
        this.f14676e = null;
        this.f14679h = false;
    }
}
