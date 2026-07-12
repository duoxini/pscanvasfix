package m1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: m1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0458a extends ValueAnimator {

    /* renamed from: e, reason: collision with root package name */
    private final Set f12403e = new CopyOnWriteArraySet();

    /* renamed from: f, reason: collision with root package name */
    private final Set f12404f = new CopyOnWriteArraySet();

    /* renamed from: g, reason: collision with root package name */
    private final Set f12405g = new CopyOnWriteArraySet();

    void a() {
        Iterator it = this.f12404f.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f12404f.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f12405g.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f12403e.add(animatorUpdateListener);
    }

    void b(boolean z3) {
        Iterator it = this.f12404f.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationEnd(this, z3);
        }
    }

    void c() {
        Iterator it = this.f12405g.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorPauseListener) it.next()).onAnimationPause(this);
        }
    }

    void d() {
        Iterator it = this.f12404f.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
        }
    }

    void e() {
        Iterator it = this.f12405g.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorPauseListener) it.next()).onAnimationResume(this);
        }
    }

    void f(boolean z3) {
        Iterator it = this.f12404f.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationStart(this, z3);
        }
    }

    void g() {
        Iterator it = this.f12403e.iterator();
        while (it.hasNext()) {
            ((ValueAnimator.AnimatorUpdateListener) it.next()).onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("EffectiveAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f12404f.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f12403e.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f12404f.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f12405g.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f12403e.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j3) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j3) {
        throw new UnsupportedOperationException("EffectiveAnimator does not support setDuration.");
    }
}
