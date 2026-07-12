package z1;

import B1.s;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.oplus.anim.EffectiveAnimationView;

/* renamed from: z1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0653f extends FrameLayout implements InterfaceC0651d {

    /* renamed from: e, reason: collision with root package name */
    private Context f14684e;

    /* renamed from: f, reason: collision with root package name */
    private WindowManager.LayoutParams f14685f;

    /* renamed from: g, reason: collision with root package name */
    private i f14686g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f14687h;

    /* renamed from: i, reason: collision with root package name */
    private EffectiveAnimationView f14688i;

    public C0653f(Context context) {
        super(context);
        this.f14684e = context;
        c(context);
        b();
    }

    @Override // z1.InterfaceC0651d
    public void a(AnimatorListenerAdapter animatorListenerAdapter) {
    }

    public void b() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(2318);
        this.f14685f = layoutParams;
        layoutParams.flags |= 16777496;
        layoutParams.setFitInsetsTypes(0);
        WindowManager.LayoutParams layoutParams2 = this.f14685f;
        layoutParams2.format = 1;
        layoutParams2.setTitle("ZoomTipsContainer");
    }

    public void c(Context context) {
        View.inflate(context, t1.h.f13485r, this);
        this.f14687h = (FrameLayout) findViewById(t1.f.f13438R);
        this.f14688i = (EffectiveAnimationView) findViewById(t1.f.f13446f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14687h.getLayoutParams());
        layoutParams.gravity = s.C() ? 8388613 : 8388611;
        this.f14687h.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f14688i.getLayoutParams());
        layoutParams2.gravity = s.C() ? 8388613 : 8388611;
        this.f14688i.setLayoutParams(layoutParams2);
        this.f14688i.setAnimation(t1.i.f13538a);
        if (!j.a().d() || j.a().c()) {
            this.f14688i.setRotation(135.0f);
        } else {
            this.f14688i.setRotation(225.0f);
        }
    }

    public EffectiveAnimationView getDragAnimationViewRight() {
        return this.f14688i;
    }

    public FrameLayout getTipsView() {
        return this.f14687h;
    }

    @Override // z1.InterfaceC0651d
    public View getView() {
        return this;
    }

    @Override // z1.InterfaceC0651d
    public WindowManager.LayoutParams getWindowParams() {
        return this.f14685f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i iVar = this.f14686g;
        if (iVar != null) {
            iVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f14686g;
        if (iVar != null) {
            iVar.onDetachedFromWindow();
            this.f14686g = null;
        }
    }

    public void setHook(i iVar) {
        this.f14686g = iVar;
    }
}
