package com.oplus.pscanvas.canvasmode.canvas.mask;

import B1.l;
import Y.d;
import Y.e;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.ArrayList;
import java.util.List;
import u1.C0599b;
import y1.h;
import y1.t;

/* loaded from: classes.dex */
public class CanvasMaskListView extends ListView {

    /* renamed from: r, reason: collision with root package name */
    private static final String f10578r = "CanvasMaskListView";

    /* renamed from: e, reason: collision with root package name */
    private C0599b f10579e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f10580f;

    /* renamed from: g, reason: collision with root package name */
    private int f10581g;

    /* renamed from: h, reason: collision with root package name */
    private int f10582h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10583i;

    /* renamed from: j, reason: collision with root package name */
    private int f10584j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10585k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10586l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f10587m;

    /* renamed from: n, reason: collision with root package name */
    private long f10588n;

    /* renamed from: o, reason: collision with root package name */
    private float f10589o;

    /* renamed from: p, reason: collision with root package name */
    private AnimatorSet f10590p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f10591q;

    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f10592a;

        a(t tVar) {
            this.f10592a = tVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d(CanvasMaskListView.f10578r, "hideMaskView: alphaAnimator onAnimationCancel");
            CanvasMaskListView.this.f10591q = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10592a.setVisibility(8);
            Log.d(CanvasMaskListView.f10578r, "hideMaskView: alphaAnimator onAnimationEnd");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d(CanvasMaskListView.f10578r, "hideMaskView: alphaAnimator onAnimationStart");
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f10594a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10595b;

        b(t tVar, int i3) {
            this.f10594a = tVar;
            this.f10595b = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (l.O1(((ListView) CanvasMaskListView.this).mContext).v0().R0()) {
                return;
            }
            l.O1(((ListView) CanvasMaskListView.this).mContext).v0().M0(this.f10595b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f10594a.setVisibility(0);
        }
    }

    public CanvasMaskListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (this.f10579e.getCount() < 1) {
            return;
        }
        if (this.f10579e.getCount() == 1) {
            Rect h3 = this.f10579e.getItem(0).h();
            Rect rect = this.f10580f;
            Rect rect2 = new Rect(rect.left, rect.top, h3.width() + this.f10580f.left, h3.height() + this.f10580f.top);
            t o3 = o(0);
            if (o3 != null) {
                o3.j(this.f10579e.getItem(0), this.f10581g, this.f10583i);
                o3.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
                return;
            }
            View view = this.f10579e.getView(0, o(0), this);
            if (view.getLayoutParams() == null) {
                addViewInLayout(view, 0, new AbsListView.LayoutParams(this.f10579e.getItem(0).h().width(), this.f10579e.getItem(0).h().height()));
                if (view instanceof t) {
                    ((t) view).setIsSystemAnimating(this.f10583i);
                    return;
                }
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < this.f10579e.getCount(); i3++) {
            Rect h4 = this.f10579e.getItem(i3).h();
            t o4 = o(i3);
            if (o4 != null) {
                float f3 = this.f10579e.getCount() == 2 ? this.f10581g : this.f10582h;
                if (this.f10586l) {
                    f3 *= this.f10589o;
                }
                o4.j(this.f10579e.getItem(i3), f3, this.f10583i);
                o4.layout(h4.left, h4.top, h4.right, h4.bottom);
            } else {
                View view2 = this.f10579e.getView(i3, o(i3), this);
                if (view2.getLayoutParams() == null) {
                    addViewInLayout(view2, i3, new AbsListView.LayoutParams(this.f10579e.getItem(i3).h().width(), this.f10579e.getItem(i3).h().height()));
                    if (view2 instanceof t) {
                        ((t) view2).setIsSystemAnimating(this.f10583i);
                    }
                }
            }
        }
    }

    private void C() {
        List<t> childEmbeddedViewList = getChildEmbeddedViewList();
        for (int i3 = 0; i3 < childEmbeddedViewList.size(); i3++) {
            childEmbeddedViewList.get(i3).g();
            removeViewInLayout(childEmbeddedViewList.get(i3));
        }
    }

    private List<t> getChildEmbeddedViewList() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof t) {
                arrayList.add((t) childAt);
            }
        }
        return arrayList;
    }

    public boolean D(long j3) {
        return F(j3, null, -1);
    }

    public boolean E(long j3, int i3) {
        return F(j3, null, i3);
    }

    public boolean F(long j3, final Animator.AnimatorListener animatorListener, int i3) {
        final AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f10579e.getCount(); i4++) {
            if (i3 == -1 || i4 == i3) {
                t o3 = o(i4);
                if (o3 == null) {
                    ContainerView v02 = l.O1(((ListView) this).mContext).v0();
                    if (v02 != null) {
                        v02.setIsReparentAnim(false);
                    }
                    return false;
                }
                if (o3.getVisibility() != 0) {
                    if (j3 == 0) {
                        o3.setAlpha(1.0f);
                        o3.setVisibility(0);
                        l.O1(((ListView) this).mContext).v0().M0(i4);
                        l.O1(((ListView) this).mContext).v0().f10732G.v0(true);
                    } else {
                        ObjectAnimator customAlphaAnim = o3.getCustomAlphaAnim();
                        if (customAlphaAnim != null) {
                            customAlphaAnim.cancel();
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o3, "alpha", 1.0f);
                        o3.setCustomAlphaAnim(ofFloat);
                        ofFloat.addListener(new b(o3, i4));
                        arrayList.add(ofFloat);
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            if (animatorListener != null) {
                ((ListView) this).mContext.getMainThreadHandler().post(new Runnable() { // from class: y1.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        animatorListener.onAnimationStart(animatorSet);
                    }
                });
                ((ListView) this).mContext.getMainThreadHandler().postDelayed(new Runnable() { // from class: y1.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        animatorListener.onAnimationEnd(animatorSet);
                    }
                }, j3);
            }
            return true;
        }
        animatorSet.playTogether(arrayList);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        animatorSet.setDuration(j3);
        animatorSet.setInterpolator(new d());
        animatorSet.start();
        return false;
    }

    public void k() {
        ObjectAnimator customAlphaAnim;
        for (int i3 = 0; i3 < this.f10579e.getCount(); i3++) {
            t o3 = o(i3);
            if (o3 != null && (customAlphaAnim = o3.getCustomAlphaAnim()) != null && (customAlphaAnim.isStarted() || customAlphaAnim.isRunning())) {
                customAlphaAnim.cancel();
            }
        }
        Log.d(f10578r, "cancelAllMaskAlphaAnim");
    }

    public void l() {
        AnimatorSet animatorSet = this.f10590p;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.f10590p.cancel();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        if (this.f10579e == null) {
            return;
        }
        if (getChildEmbeddedViewList().size() != this.f10579e.getCount()) {
            C();
        }
        for (int i3 = 0; i3 < this.f10579e.getCount(); i3++) {
            View view = this.f10579e.getView(i3, o(i3), this);
            if (view.getLayoutParams() == null) {
                addViewInLayout(view, i3, new AbsListView.LayoutParams(this.f10579e.getItem(i3).h().width(), this.f10579e.getItem(i3).h().height()));
                if (view instanceof t) {
                    ((t) view).setIsSystemAnimating(this.f10583i);
                }
            }
        }
    }

    public void m() {
        setVisibility(8);
        this.f10579e.clear();
        C();
    }

    public void n(long j3) {
        if (j3 == this.f10588n) {
            m();
        }
    }

    public t o(int i3) {
        int i4 = -1;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if ((childAt instanceof t) && (i4 = i4 + 1) == i3) {
                return (t) childAt;
            }
        }
        return null;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f10580f.set(i3, i4, i5, i6 - (this.f10585k ? 0 : this.f10584j));
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i4));
        if (this.f10587m) {
            this.f10587m = false;
            ?? r02 = this;
            while (r02.getParent() != null && (r02.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) r02.getParent();
                viewGroup.setClipChildren(false);
                r02 = viewGroup;
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean p(long j3, long j4, boolean z3, Animator.AnimatorListener animatorListener, int i3) {
        return q(j3, j4, z3, animatorListener, i3, 300L);
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public boolean q(long j3, long j4, boolean z3, final Animator.AnimatorListener animatorListener, int i3, long j5) {
        boolean z4;
        int i4;
        final AnimatorSet animatorSet = new AnimatorSet();
        this.f10590p = animatorSet;
        ArrayList arrayList = new ArrayList();
        ?? r11 = 0;
        this.f10591q = false;
        int i5 = 0;
        while (i5 < this.f10579e.getCount()) {
            if (i3 == -1 || i3 != i5) {
                t o3 = o(i5);
                if (o3 == null) {
                    Log.d(f10578r, "hideMaskView maskView is null");
                    if (animatorListener != null) {
                        ((ListView) this).mContext.getMainThreadHandler().post(new Runnable() { // from class: y1.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                animatorListener.onAnimationStart(animatorSet);
                            }
                        });
                        ((ListView) this).mContext.getMainThreadHandler().postDelayed(new Runnable() { // from class: y1.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                animatorListener.onAnimationEnd(animatorSet);
                            }
                        }, j3);
                    }
                    return r11;
                }
                if (j3 == 0) {
                    o3.setAlpha(0.0f);
                    o3.setVisibility(8);
                } else {
                    ImageView iconView = o3.getIconView();
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[r11] = 0.0f;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(iconView, (Property<ImageView, Float>) property, fArr);
                    int i6 = i5;
                    ofFloat.setDuration(j4);
                    ofFloat.setInterpolator(new Y.b());
                    z4 = false;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(o3, (Property<t, Float>) property, 0.0f);
                    ofFloat2.setDuration(j3);
                    ofFloat2.setInterpolator(new e());
                    ofFloat2.addListener(new a(o3));
                    if (!z3 || i3 == -1) {
                        i4 = i6;
                    } else {
                        i4 = i6;
                        if (i4 != i3) {
                            ofFloat.setStartDelay(500L);
                            ofFloat2.setStartDelay(500L);
                        }
                    }
                    arrayList.add(ofFloat2);
                    arrayList.add(ofFloat);
                    i5 = i4 + 1;
                    r11 = z4;
                }
            }
            z4 = r11;
            i4 = i5;
            i5 = i4 + 1;
            r11 = z4;
        }
        if (arrayList.size() == 0) {
            if (animatorListener != null) {
                ((ListView) this).mContext.getMainThreadHandler().post(new Runnable() { // from class: y1.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        animatorListener.onAnimationStart(animatorSet);
                    }
                });
                ((ListView) this).mContext.getMainThreadHandler().postDelayed(new Runnable() { // from class: y1.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        animatorListener.onAnimationEnd(animatorSet);
                    }
                }, j3);
            }
            return true;
        }
        animatorSet.playTogether(arrayList);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        Log.d(f10578r, "hideMaskView isDelayStart:" + z3 + " delayTime:" + j5);
        if (z3) {
            animatorSet.setStartDelay(j5);
        }
        ((ListView) this).mContext.getMainThreadHandler().post(new h(animatorSet));
        return true;
    }

    public boolean r(long j3, boolean z3) {
        return p(j3, j3, z3, null, -1);
    }

    public long s(List list) {
        setVisibility(0);
        this.f10579e.clear();
        this.f10579e.addAll(list);
        this.f10579e.notifyDataSetChanged();
        long currentTimeMillis = System.currentTimeMillis();
        this.f10588n = currentTimeMillis;
        return currentTimeMillis;
    }

    public void setAdapter(C0599b c0599b) {
        this.f10579e = c0599b;
        super.setAdapter((ListAdapter) c0599b);
        this.f10579e.notifyDataSetChanged();
    }

    public void setCanceldHideAnimator(boolean z3) {
        this.f10591q = z3;
    }

    public void setIsGestureNavMode(boolean z3) {
        if (this.f10585k != z3) {
            this.f10585k = z3;
            requestLayout();
        }
    }

    public void setIsPanoramaMode(boolean z3) {
        if (this.f10586l != z3) {
            this.f10586l = z3;
        }
    }

    public void setIsSystemAnimating(boolean z3) {
        this.f10583i = z3;
    }

    public void setNavigationBarHeight(int i3) {
        if (i3 != this.f10584j) {
            this.f10584j = i3;
            requestLayout();
        }
    }

    public void setPanoramaScaleRatio(float f3) {
        this.f10589o = f3;
    }

    public boolean t() {
        return this.f10591q;
    }

    public boolean u(int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (o(0) == null) {
                return false;
            }
        }
        return true;
    }

    public CanvasMaskListView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f10579e;
    }

    public CanvasMaskListView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f10580f = new Rect();
        this.f10586l = false;
        this.f10587m = true;
        this.f10589o = 1.0f;
        this.f10591q = false;
        this.f10581g = (int) context.getResources().getDimension(t1.d.f13391t);
        this.f10582h = (int) context.getResources().getDimension(t1.d.f13389r);
    }
}
