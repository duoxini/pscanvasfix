package com.coui.appcompat.searchview;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.CollapsibleActionView;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.y;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIToolbar;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import g2.AbstractC0368a;
import h0.AbstractC0371a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import r0.C0559a;
import r0.C0560b;
import r0.C0561c;
import r0.C0562d;
import u0.AbstractC0597a;
import v0.AbstractC0608a;

/* loaded from: classes.dex */
public class COUISearchBar extends ViewGroup implements CollapsibleActionView {

    /* renamed from: J0, reason: collision with root package name */
    private static final Interpolator f9089J0 = new Y.e();

    /* renamed from: K0, reason: collision with root package name */
    private static final Interpolator f9090K0 = new Y.e();

    /* renamed from: L0, reason: collision with root package name */
    private static final Interpolator f9091L0 = new Y.e();

    /* renamed from: M0, reason: collision with root package name */
    private static final ArgbEvaluator f9092M0 = new ArgbEvaluator();

    /* renamed from: N0, reason: collision with root package name */
    private static final String[] f9093N0 = {"TYPE_INSTANT_SEARCH", "TYPE_NON_INSTANT_SEARCH"};

    /* renamed from: A, reason: collision with root package name */
    private ValueAnimator f9094A;

    /* renamed from: A0, reason: collision with root package name */
    private int f9095A0;

    /* renamed from: B, reason: collision with root package name */
    private ValueAnimator f9096B;

    /* renamed from: B0, reason: collision with root package name */
    private Interpolator f9097B0;

    /* renamed from: C, reason: collision with root package name */
    private AnimatorSet f9098C;

    /* renamed from: C0, reason: collision with root package name */
    private volatile AtomicInteger f9099C0;

    /* renamed from: D, reason: collision with root package name */
    private ValueAnimator f9100D;

    /* renamed from: D0, reason: collision with root package name */
    private int f9101D0;

    /* renamed from: E, reason: collision with root package name */
    private ValueAnimator f9102E;

    /* renamed from: E0, reason: collision with root package name */
    private int f9103E0;

    /* renamed from: F, reason: collision with root package name */
    private ValueAnimator f9104F;

    /* renamed from: F0, reason: collision with root package name */
    private String f9105F0;

    /* renamed from: G, reason: collision with root package name */
    private ValueAnimator f9106G;

    /* renamed from: G0, reason: collision with root package name */
    private String f9107G0;

    /* renamed from: H, reason: collision with root package name */
    private ValueAnimator f9108H;

    /* renamed from: H0, reason: collision with root package name */
    private int f9109H0;

    /* renamed from: I, reason: collision with root package name */
    private ValueAnimator f9110I;

    /* renamed from: I0, reason: collision with root package name */
    private boolean f9111I0;

    /* renamed from: J, reason: collision with root package name */
    private List f9112J;

    /* renamed from: K, reason: collision with root package name */
    private float f9113K;

    /* renamed from: L, reason: collision with root package name */
    private int f9114L;

    /* renamed from: M, reason: collision with root package name */
    private int f9115M;

    /* renamed from: N, reason: collision with root package name */
    private int f9116N;

    /* renamed from: O, reason: collision with root package name */
    private int f9117O;

    /* renamed from: P, reason: collision with root package name */
    private int f9118P;

    /* renamed from: Q, reason: collision with root package name */
    private MenuItem f9119Q;

    /* renamed from: R, reason: collision with root package name */
    private COUIToolbar f9120R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f9121S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f9122T;

    /* renamed from: U, reason: collision with root package name */
    private int[] f9123U;

    /* renamed from: V, reason: collision with root package name */
    private int[] f9124V;

    /* renamed from: W, reason: collision with root package name */
    private int[] f9125W;

    /* renamed from: a0, reason: collision with root package name */
    private int[] f9126a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f9127b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f9128c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f9129d0;

    /* renamed from: e, reason: collision with root package name */
    private final o f9130e;

    /* renamed from: e0, reason: collision with root package name */
    private int f9131e0;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f9132f;

    /* renamed from: f0, reason: collision with root package name */
    private int f9133f0;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f9134g;

    /* renamed from: g0, reason: collision with root package name */
    private int f9135g0;

    /* renamed from: h, reason: collision with root package name */
    private View f9136h;

    /* renamed from: h0, reason: collision with root package name */
    private int f9137h0;

    /* renamed from: i, reason: collision with root package name */
    private C0561c f9138i;

    /* renamed from: i0, reason: collision with root package name */
    private int f9139i0;

    /* renamed from: j, reason: collision with root package name */
    private C0559a f9140j;

    /* renamed from: j0, reason: collision with root package name */
    private int f9141j0;

    /* renamed from: k, reason: collision with root package name */
    private C0562d f9142k;

    /* renamed from: k0, reason: collision with root package name */
    private int f9143k0;

    /* renamed from: l, reason: collision with root package name */
    private EditText f9144l;

    /* renamed from: l0, reason: collision with root package name */
    private int f9145l0;

    /* renamed from: m, reason: collision with root package name */
    private COUIHintAnimationLayout f9146m;

    /* renamed from: m0, reason: collision with root package name */
    private int f9147m0;

    /* renamed from: n, reason: collision with root package name */
    private TextView f9148n;

    /* renamed from: n0, reason: collision with root package name */
    private int f9149n0;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f9150o;

    /* renamed from: o0, reason: collision with root package name */
    private int f9151o0;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f9152p;

    /* renamed from: p0, reason: collision with root package name */
    private int f9153p0;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f9154q;

    /* renamed from: q0, reason: collision with root package name */
    private int f9155q0;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f9156r;

    /* renamed from: r0, reason: collision with root package name */
    private int f9157r0;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f9158s;

    /* renamed from: s0, reason: collision with root package name */
    private int f9159s0;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f9160t;

    /* renamed from: t0, reason: collision with root package name */
    private int f9161t0;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f9162u;

    /* renamed from: u0, reason: collision with root package name */
    private float f9163u0;

    /* renamed from: v, reason: collision with root package name */
    private AnimatorSet f9164v;

    /* renamed from: v0, reason: collision with root package name */
    private float f9165v0;

    /* renamed from: w, reason: collision with root package name */
    private ValueAnimator f9166w;

    /* renamed from: w0, reason: collision with root package name */
    private b f9167w0;

    /* renamed from: x, reason: collision with root package name */
    private ValueAnimator f9168x;

    /* renamed from: x0, reason: collision with root package name */
    private AttributeSet f9169x0;

    /* renamed from: y, reason: collision with root package name */
    private ValueAnimator f9170y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f9171y0;

    /* renamed from: z, reason: collision with root package name */
    private ValueAnimator f9172z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f9173z0;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                COUISearchBar cOUISearchBar = COUISearchBar.this;
                cOUISearchBar.e1(cOUISearchBar.f9154q, true);
                COUISearchBar cOUISearchBar2 = COUISearchBar.this;
                cOUISearchBar2.e1(cOUISearchBar2.f9156r, true);
                COUISearchBar cOUISearchBar3 = COUISearchBar.this;
                cOUISearchBar3.e1(cOUISearchBar3.f9162u, false);
                return;
            }
            COUISearchBar cOUISearchBar4 = COUISearchBar.this;
            cOUISearchBar4.e1(cOUISearchBar4.f9154q, false);
            COUISearchBar cOUISearchBar5 = COUISearchBar.this;
            cOUISearchBar5.e1(cOUISearchBar5.f9156r, false);
            COUISearchBar cOUISearchBar6 = COUISearchBar.this;
            cOUISearchBar6.e1(cOUISearchBar6.f9162u, true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            COUISearchBar.this.n0();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b {

        /* renamed from: a, reason: collision with root package name */
        private int f9175a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f9176b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f9177c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f9178d = 0;

        /* renamed from: e, reason: collision with root package name */
        private volatile AtomicBoolean f9179e = new AtomicBoolean(false);

        class a extends d {
            a() {
                super(null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.q();
                b.this.f9179e.set(false);
                COUISearchBar.y(COUISearchBar.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISearchBar.y(COUISearchBar.this);
            }
        }

        /* renamed from: com.coui.appcompat.searchview.COUISearchBar$b$b, reason: collision with other inner class name */
        class C0114b extends d {
            C0114b() {
                super(null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.r();
                b.this.f9179e.set(false);
                COUISearchBar.y(COUISearchBar.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISearchBar.y(COUISearchBar.this);
                if (COUISearchBar.this.f9109H0 == 0 && COUISearchBar.this.getOuterButtonCount() == 1 && COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.jumpDrawablesToCurrentState();
                }
            }
        }

        b() {
            s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.f9109H0 == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setTranslationX((1.0f - floatValue) * COUISearchBar.this.f9157r0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.f9109H0 == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.f9158s != null) {
                    COUISearchBar.this.f9158s.setAlpha(1.0f - floatValue);
                }
                if (COUISearchBar.this.f9160t != null) {
                    COUISearchBar.this.f9160t.setAlpha(1.0f - floatValue);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.f9109H0 == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.f9158s != null) {
                    COUISearchBar.this.f9158s.setTranslationX((-floatValue) * COUISearchBar.this.f9157r0);
                }
                if (COUISearchBar.this.f9160t != null) {
                    COUISearchBar.this.f9160t.setTranslationX((-floatValue) * COUISearchBar.this.f9157r0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.f9109H0 == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.f9158s != null) {
                    COUISearchBar.this.f9158s.setAlpha(floatValue);
                }
                if (COUISearchBar.this.f9160t != null) {
                    COUISearchBar.this.f9160t.setAlpha(floatValue);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.f9109H0 == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.f9158s != null) {
                    COUISearchBar.this.f9158s.setTranslationX((-floatValue) * COUISearchBar.this.f9157r0);
                }
                if (COUISearchBar.this.f9160t != null) {
                    COUISearchBar.this.f9160t.setTranslationX((-floatValue) * COUISearchBar.this.f9157r0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.f9109H0 == 0) {
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setAlpha(1.0f - floatValue);
                }
            } else if (COUISearchBar.this.f9109H0 == 1) {
                float f3 = 1.0f - floatValue;
                COUISearchBar.this.f9130e.g(f3);
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setAlpha(f3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.f9109H0 == 0 && COUISearchBar.this.getOuterButtonCount() == 1) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setTranslationX(floatValue * COUISearchBar.this.f9157r0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void H(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.f9109H0 == 0) {
                int i3 = (int) (floatValue * (this.f9177c - this.f9178d));
                ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin -= i3 - this.f9175a;
                this.f9175a = i3;
                COUISearchBar.this.requestLayout();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.f9109H0 == 0) {
                COUISearchBar.this.f9165v0 = floatValue;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.f9109H0 == 0) {
                int i3 = (int) (floatValue * (this.f9177c - this.f9178d));
                ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin += i3 - this.f9175a;
                this.f9175a = i3;
                COUISearchBar.this.requestLayout();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.f9109H0 == 0) {
                COUISearchBar.this.f9165v0 = 1.0f - floatValue;
            }
        }

        private void M() {
            this.f9175a = 0;
            if (((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()) != null) {
                this.f9176b = ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin;
            }
            this.f9177c = COUISearchBar.this.getTop();
            if (COUISearchBar.this.o0()) {
                COUISearchBar.this.f9148n.setVisibility(0);
            }
            if ((!COUISearchBar.this.f9173z0 || COUISearchBar.this.f9095A0 == 0) && COUISearchBar.this.f9171y0) {
                COUISearchBar.this.c1(true);
            }
            COUISearchBar.this.f9099C0.set(1);
            COUISearchBar.this.b1(0, 1);
        }

        private void N() {
            this.f9175a = 0;
            COUISearchBar.this.f9144l.setText((CharSequence) null);
            if (COUISearchBar.this.f9171y0) {
                COUISearchBar.this.c1(false);
            }
            if (COUISearchBar.this.f9109H0 == 0) {
                COUISearchBar.this.setOuterButtonVisibility(0);
            }
            COUISearchBar.this.f9099C0.set(0);
            COUISearchBar.this.b1(1, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            this.f9175a = 0;
            if (COUISearchBar.this.f9109H0 == 0) {
                int i3 = this.f9177c - this.f9178d;
                if (((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()) != null) {
                    ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin = this.f9176b - i3;
                }
                COUISearchBar.this.f9165v0 = 1.0f;
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setAlpha(1.0f);
                }
                COUISearchBar.this.setOuterButtonVisibility(8);
            } else if (COUISearchBar.this.f9109H0 == 1) {
                COUISearchBar.this.f9130e.g(1.0f);
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setAlpha(1.0f);
                }
            }
            COUISearchBar.this.requestLayout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            this.f9175a = 0;
            if (COUISearchBar.this.f9109H0 == 0) {
                if (((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()) != null) {
                    ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin = this.f9176b;
                }
                COUISearchBar.this.f9165v0 = 0.0f;
            } else if (COUISearchBar.this.f9109H0 == 1) {
                COUISearchBar.this.f9130e.g(0.0f);
            }
            if (COUISearchBar.this.o0()) {
                COUISearchBar.this.f9148n.setAlpha(0.0f);
                COUISearchBar.this.f9148n.setVisibility(8);
            }
            COUISearchBar.this.requestLayout();
        }

        private void s() {
            v();
            w();
            t();
            u();
            x();
            y();
        }

        private void t() {
            COUISearchBar.this.f9170y = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9170y.setDuration(COUISearchBar.this.f9109H0 == 0 ? 350L : COUISearchBar.this.getOuterButtonCount() == 1 ? 400L : 100L);
            COUISearchBar.this.f9170y.setInterpolator(COUISearchBar.f9091L0);
            COUISearchBar.this.f9170y.setStartDelay(COUISearchBar.this.f9109H0 != 0 ? COUISearchBar.this.getOuterButtonCount() == 1 ? 50L : 0L : 100L);
            COUISearchBar.this.f9170y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.z(valueAnimator);
                }
            });
            COUISearchBar.this.f9172z = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9172z.setDuration(400L);
            COUISearchBar.this.f9172z.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9172z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.A(valueAnimator);
                }
            });
            COUISearchBar.this.f9094A = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9094A.setDuration(200L);
            COUISearchBar.this.f9094A.setInterpolator(COUISearchBar.f9091L0);
            COUISearchBar.this.f9094A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.B(valueAnimator);
                }
            });
            COUISearchBar.this.f9096B = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9096B.setDuration(400L);
            COUISearchBar.this.f9096B.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9096B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.C(valueAnimator);
                }
            });
        }

        private void u() {
            COUISearchBar.this.f9104F = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9104F.setDuration(COUISearchBar.this.f9109H0 == 0 ? 350L : COUISearchBar.this.getOuterButtonCount() == 1 ? 200L : 100L);
            COUISearchBar.this.f9104F.setInterpolator(COUISearchBar.f9091L0);
            COUISearchBar.this.f9104F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.F(valueAnimator);
                }
            });
            COUISearchBar.this.f9106G = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9106G.setDuration(400L);
            COUISearchBar.this.f9106G.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9106G.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.G(valueAnimator);
                }
            });
            COUISearchBar.this.f9108H = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9108H.setDuration(400L);
            COUISearchBar.this.f9108H.setStartDelay(50L);
            COUISearchBar.this.f9108H.setInterpolator(COUISearchBar.f9091L0);
            COUISearchBar.this.f9108H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.D(valueAnimator);
                }
            });
            COUISearchBar.this.f9110I = ValueAnimator.ofFloat(1.0f, 0.0f);
            COUISearchBar.this.f9110I.setDuration(400L);
            COUISearchBar.this.f9110I.setStartDelay(50L);
            COUISearchBar.this.f9110I.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9110I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.E(valueAnimator);
                }
            });
        }

        private void v() {
            COUISearchBar.this.f9166w = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9166w.setDuration(450L);
            COUISearchBar.this.f9166w.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9166w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.H(valueAnimator);
                }
            });
            COUISearchBar.this.f9168x = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9168x.setDuration(450L);
            COUISearchBar.this.f9168x.setInterpolator(COUISearchBar.f9090K0);
            COUISearchBar.this.f9168x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.I(valueAnimator);
                }
            });
        }

        private void w() {
            COUISearchBar.this.f9100D = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9100D.setDuration(450L);
            COUISearchBar.this.f9100D.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9100D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.J(valueAnimator);
                }
            });
            COUISearchBar.this.f9102E = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.f9102E.setDuration(450L);
            COUISearchBar.this.f9102E.setInterpolator(COUISearchBar.f9089J0);
            COUISearchBar.this.f9102E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.b.this.K(valueAnimator);
                }
            });
        }

        private void x() {
            COUISearchBar.this.f9164v = new AnimatorSet();
            COUISearchBar.this.f9164v.addListener(new a());
            COUISearchBar.this.f9164v.playTogether(COUISearchBar.this.f9166w, COUISearchBar.this.f9168x, COUISearchBar.this.f9170y, COUISearchBar.this.f9172z, COUISearchBar.this.f9094A, COUISearchBar.this.f9096B);
        }

        private void y() {
            COUISearchBar.this.f9098C = new AnimatorSet();
            COUISearchBar.this.f9098C.addListener(new C0114b());
            COUISearchBar.this.f9098C.playTogether(COUISearchBar.this.f9100D, COUISearchBar.this.f9102E, COUISearchBar.this.f9104F, COUISearchBar.this.f9106G, COUISearchBar.this.f9108H, COUISearchBar.this.f9110I);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.f9109H0 == 0) {
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setAlpha(floatValue);
                }
            } else if (COUISearchBar.this.f9109H0 == 1) {
                COUISearchBar.this.f9130e.g(floatValue);
                if (COUISearchBar.this.o0()) {
                    COUISearchBar.this.f9148n.setAlpha(floatValue);
                }
            }
        }

        public void L(int i3) {
            if (this.f9179e.get()) {
                AbstractC0371a.g("COUISearchBar", "animating");
                return;
            }
            if (i3 == 1) {
                M();
                q();
            } else if (i3 == 0) {
                N();
                r();
            }
        }
    }

    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        float f9183e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.f9183e);
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f9183e = parcel.readFloat();
        }
    }

    private static class d implements Animator.AnimatorListener {
        private d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
        void a(int i3, int i4);
    }

    public COUISearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0368a.f11692a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(View view) {
        EditText editText = this.f9144l;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view, boolean z3) {
        this.f9138i.d(z3);
    }

    private void C0() {
        int right;
        int width;
        View view = this.f9136h;
        view.layout(0, 0, view.getMeasuredWidth(), this.f9136h.getMeasuredHeight());
        int e02 = e0(0, getMeasuredHeight(), this.f9132f.height());
        int height = this.f9132f.height() + e02;
        if (z0()) {
            width = d1(this.f9152p) ? this.f9152p.getLeft() : getMeasuredWidth() - (getInternalPaddingStart() - this.f9153p0);
            right = width - this.f9132f.width();
        } else {
            right = d1(this.f9152p) ? this.f9152p.getRight() : getInternalPaddingStart() - this.f9153p0;
            width = this.f9132f.width() + right;
        }
        this.f9132f.set(right, e02, width, height);
        h1();
    }

    private void D0() {
        C0();
        M0();
        H0();
        int J02 = J0();
        if (this.f9109H0 == 1) {
            I0(G0(J02));
        }
    }

    private void E0() {
        if (this.f9109H0 == 1) {
            K0();
        }
    }

    private void F0() {
        int i3 = this.f9109H0;
        if (i3 != 0) {
            if (i3 == 1) {
                L0();
            }
        } else {
            I0(z0() ? this.f9132f.left - this.f9147m0 : this.f9132f.right + this.f9147m0);
            if (getOuterButtonCount() == 1) {
                L0();
            }
        }
    }

    private int G0(int i3) {
        int width;
        int i4;
        Rect rect = this.f9132f;
        int e02 = e0(rect.top, rect.height(), this.f9134g.height());
        int height = this.f9134g.height() + e02;
        if (z0()) {
            int width2 = i3 - this.f9134g.width();
            i4 = i3 - this.f9128c0;
            width = i3;
            i3 = width2;
        } else {
            width = this.f9134g.width() + i3;
            i4 = this.f9128c0 + i3;
        }
        int width3 = i4 + this.f9134g.width();
        this.f9134g.set(i3, e02, width, height);
        this.f9130e.h(this.f9134g);
        return width3;
    }

    private void H0() {
        Rect rect = this.f9132f;
        int e02 = e0(rect.top, rect.height(), getSearchEditOrAnimationLayout().getMeasuredHeight());
        if (z0()) {
            int left = d1(this.f9150o) ? this.f9150o.getLeft() : this.f9132f.right;
            getSearchEditOrAnimationLayout().layout(left - getSearchEditOrAnimationLayout().getMeasuredWidth(), e02, left, getSearchEditOrAnimationLayout().getMeasuredHeight() + e02);
        } else {
            int right = d1(this.f9150o) ? this.f9150o.getRight() : this.f9132f.left;
            getSearchEditOrAnimationLayout().layout(right, e02, getSearchEditOrAnimationLayout().getMeasuredWidth() + right, getSearchEditOrAnimationLayout().getMeasuredHeight() + e02);
        }
    }

    private void I0(int i3) {
        if (d1(this.f9148n)) {
            Rect rect = this.f9132f;
            int e02 = e0(rect.top, rect.height(), this.f9148n.getMeasuredHeight());
            if (z0()) {
                TextView textView = this.f9148n;
                textView.layout(i3 - textView.getMeasuredWidth(), e02, i3, this.f9148n.getMeasuredHeight() + e02);
            } else {
                TextView textView2 = this.f9148n;
                textView2.layout(i3, e02, textView2.getMeasuredWidth() + i3, this.f9148n.getMeasuredHeight() + e02);
            }
        }
    }

    private int J0() {
        if (z0()) {
            int left = getSearchEditOrAnimationLayout().getLeft() - this.f9127b0;
            if (d1(this.f9162u)) {
                Rect rect = this.f9132f;
                int e02 = e0(rect.top, rect.height(), this.f9162u.getMeasuredHeight());
                ImageView imageView = this.f9162u;
                imageView.layout(left - imageView.getMeasuredWidth(), e02, left, this.f9162u.getMeasuredHeight() + e02);
                left -= this.f9162u.getMeasuredWidth();
            }
            if (d1(this.f9154q)) {
                Rect rect2 = this.f9132f;
                int e03 = e0(rect2.top, rect2.height(), this.f9154q.getMeasuredHeight());
                ImageView imageView2 = this.f9154q;
                imageView2.layout(left - imageView2.getMeasuredWidth(), e03, left, this.f9154q.getMeasuredHeight() + e03);
                left -= this.f9154q.getMeasuredWidth();
            }
            if (d1(this.f9156r)) {
                Rect rect3 = this.f9132f;
                int e04 = e0(rect3.top, rect3.height(), this.f9156r.getMeasuredHeight());
                ImageView imageView3 = this.f9156r;
                imageView3.layout(left - imageView3.getMeasuredWidth(), e04, left, this.f9156r.getMeasuredHeight() + e04);
                left -= this.f9156r.getMeasuredWidth();
            }
            return left != getSearchEditOrAnimationLayout().getLeft() ? left - this.f9128c0 : left;
        }
        int right = getSearchEditOrAnimationLayout().getRight() + this.f9127b0;
        if (d1(this.f9162u)) {
            Rect rect4 = this.f9132f;
            int e05 = e0(rect4.top, rect4.height(), this.f9162u.getMeasuredHeight());
            ImageView imageView4 = this.f9162u;
            imageView4.layout(right, e05, imageView4.getMeasuredWidth() + right, this.f9162u.getMeasuredHeight() + e05);
            right += this.f9162u.getMeasuredWidth();
        }
        if (d1(this.f9154q)) {
            Rect rect5 = this.f9132f;
            int e06 = e0(rect5.top, rect5.height(), this.f9154q.getMeasuredHeight());
            ImageView imageView5 = this.f9154q;
            imageView5.layout(right, e06, imageView5.getMeasuredWidth() + right, this.f9154q.getMeasuredHeight() + e06);
            right += this.f9154q.getMeasuredWidth();
        }
        if (d1(this.f9156r)) {
            Rect rect6 = this.f9132f;
            int e07 = e0(rect6.top, rect6.height(), this.f9156r.getMeasuredHeight());
            ImageView imageView6 = this.f9156r;
            imageView6.layout(right, e07, imageView6.getMeasuredWidth() + right, this.f9156r.getMeasuredHeight() + e07);
            right += this.f9156r.getMeasuredWidth();
        }
        return right != getSearchEditOrAnimationLayout().getRight() ? right + this.f9128c0 : right;
    }

    private void K0() {
        if (d1(this.f9152p)) {
            int e02 = e0(0, getMeasuredHeight(), this.f9152p.getMeasuredHeight());
            if (z0()) {
                int measuredWidth = getMeasuredWidth() - this.f9124V[this.f9114L];
                ImageView imageView = this.f9152p;
                imageView.layout(measuredWidth - imageView.getMeasuredWidth(), e02, measuredWidth, this.f9152p.getMeasuredHeight() + e02);
            } else {
                int i3 = this.f9124V[this.f9114L];
                ImageView imageView2 = this.f9152p;
                imageView2.layout(i3, e02, imageView2.getMeasuredWidth() + i3, this.f9152p.getMeasuredHeight() + e02);
            }
        }
    }

    private void L0() {
        if (z0()) {
            int i3 = this.f9132f.left - this.f9143k0;
            if (d1(this.f9158s)) {
                int e02 = e0(0, getMeasuredHeight(), this.f9158s.getMeasuredHeight());
                ImageView imageView = this.f9158s;
                imageView.layout(i3 - imageView.getMeasuredWidth(), e02, i3, this.f9158s.getMeasuredHeight() + e02);
                i3 -= this.f9158s.getMeasuredWidth();
            }
            if (d1(this.f9160t)) {
                int e03 = e0(0, getMeasuredHeight(), this.f9160t.getMeasuredHeight());
                ImageView imageView2 = this.f9160t;
                imageView2.layout(i3 - imageView2.getMeasuredWidth(), e03, i3, this.f9160t.getMeasuredHeight() + e03);
                return;
            }
            return;
        }
        int i4 = this.f9132f.right + this.f9143k0;
        if (d1(this.f9158s)) {
            int e04 = e0(0, getMeasuredHeight(), this.f9158s.getMeasuredHeight());
            ImageView imageView3 = this.f9158s;
            imageView3.layout(i4, e04, imageView3.getMeasuredWidth() + i4, this.f9158s.getMeasuredHeight() + e04);
            i4 += this.f9158s.getMeasuredWidth();
        }
        if (d1(this.f9160t)) {
            int e05 = e0(0, getMeasuredHeight(), this.f9160t.getMeasuredHeight());
            ImageView imageView4 = this.f9160t;
            imageView4.layout(i4, e05, imageView4.getMeasuredWidth() + i4, this.f9160t.getMeasuredHeight() + e05);
        }
    }

    private void M0() {
        if (d1(this.f9150o)) {
            Rect rect = this.f9132f;
            int e02 = e0(rect.top, rect.height(), this.f9150o.getMeasuredHeight());
            if (z0()) {
                int i3 = this.f9132f.right - this.f9133f0;
                ImageView imageView = this.f9150o;
                imageView.layout(i3 - imageView.getMeasuredWidth(), e02, i3, this.f9150o.getMeasuredHeight() + e02);
            } else {
                int i4 = this.f9132f.left + this.f9133f0;
                ImageView imageView2 = this.f9150o;
                imageView2.layout(i4, e02, imageView2.getMeasuredWidth() + i4, this.f9150o.getMeasuredHeight() + e02);
            }
        }
    }

    private void N0(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g2.i.f11858n, i3, i4);
        if (obtainStyledAttributes.hasValue(g2.i.f11865u)) {
            this.f9144l.setTextSize(obtainStyledAttributes.getDimension(g2.i.f11865u, this.f9144l.getTextSize()));
        }
        if (obtainStyledAttributes.hasValue(g2.i.f11864t)) {
            this.f9144l.setTextColor(obtainStyledAttributes.getColorStateList(g2.i.f11864t));
        }
        if (obtainStyledAttributes.hasValue(g2.i.f11866v)) {
            this.f9144l.setHintTextColor(obtainStyledAttributes.getColorStateList(g2.i.f11866v));
        }
        if (obtainStyledAttributes.hasValue(g2.i.f11862r) && o0()) {
            this.f9148n.setText(obtainStyledAttributes.getString(g2.i.f11862r));
        }
        if (obtainStyledAttributes.hasValue(g2.i.f11863s) && o0()) {
            this.f9148n.setTextColor(obtainStyledAttributes.getColorStateList(g2.i.f11863s));
        }
        Drawable drawable = obtainStyledAttributes.hasValue(g2.i.f11861q) ? obtainStyledAttributes.getDrawable(g2.i.f11861q) : androidx.core.content.res.f.f(getContext().getResources(), g2.d.f11798a, getContext().getTheme());
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i5 = this.f9101D0;
        if (intrinsicWidth > i5) {
            drawable = i1(drawable, (int) (i5 * getResources().getDisplayMetrics().density), (int) (this.f9103E0 * getResources().getDisplayMetrics().density));
        }
        if (this.f9150o == null) {
            ImageView l02 = l0(drawable, false, false, 0);
            this.f9150o = l02;
            l02.setId(g2.e.f11800a);
            this.f9150o.setImportantForAccessibility(2);
        }
        i0(this.f9150o, drawable, this.f9131e0);
        if (obtainStyledAttributes.hasValue(g2.i.f11867w)) {
            this.f9144l.setHint(obtainStyledAttributes.getString(g2.i.f11867w));
        }
        this.f9161t0 = obtainStyledAttributes.getResourceId(g2.i.f11860p, g2.d.f11799b);
        obtainStyledAttributes.recycle();
    }

    private void O0(Context context, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g2.i.f11858n, i3, i4);
        this.f9111I0 = obtainStyledAttributes.getBoolean(g2.i.f11859o, false);
        obtainStyledAttributes.recycle();
    }

    private int P0(int i3) {
        S0();
        a1(this.f9136h, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        int i4 = this.f9109H0;
        if (i4 == 0) {
            int measuredWidth = (int) (((getMeasuredWidth() - getInternalPaddingStart()) - (!o0() ? getInternalPaddingEnd() : (this.f9148n.getMeasuredWidth() + this.f9147m0) + this.f9123U[this.f9114L])) + ((i3 - r1) * (1.0f - this.f9165v0)));
            Y0(this.f9132f, (this.f9153p0 * 2) + measuredWidth, (int) Float.max(this.f9149n0, this.f9129d0 * this.f9113K));
            return measuredWidth;
        }
        if (i4 != 1) {
            return i3;
        }
        Y0(this.f9132f, i3, (int) Float.max(this.f9149n0, this.f9129d0 * this.f9113K));
        return i3;
    }

    private int Q0(int i3) {
        if (this.f9109H0 != 1) {
            return i3;
        }
        Y0(this.f9134g, this.f9135g0, this.f9137h0);
        return (i3 - this.f9128c0) - this.f9135g0;
    }

    private void R0(int i3) {
        a1(getSearchEditOrAnimationLayout(), View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f9129d0, Integer.MIN_VALUE));
    }

    private void S0() {
        if (d1(this.f9148n)) {
            a1(this.f9148n, View.MeasureSpec.makeMeasureSpec(this.f9145l0, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
        }
    }

    private int T0(int i3) {
        int a12 = d1(this.f9154q) ? i3 - a1(this.f9154q, View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824)) : i3;
        if (d1(this.f9156r)) {
            a12 -= a1(this.f9156r, View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824));
        }
        if (d1(this.f9162u)) {
            a12 -= a1(this.f9162u, View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824));
        }
        return a12 != i3 ? a12 - this.f9128c0 : a12;
    }

    private void U0(int i3) {
        int Z02 = Z0(i3);
        int i4 = this.f9109H0;
        if (i4 == 0) {
            Z02 = T0(Z02);
        } else if (i4 == 1) {
            if (d1(this.f9148n)) {
                Z02 = Q0(Z02 - (this.f9148n.getMeasuredWidth() + this.f9128c0));
            }
            Z02 = T0(Z02);
        }
        R0(Z02 - this.f9127b0);
    }

    private int V0(int i3) {
        if (!d1(this.f9152p) || this.f9109H0 != 1) {
            return i3;
        }
        int a12 = i3 - a1(this.f9152p, View.MeasureSpec.makeMeasureSpec(this.f9141j0, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        return (a12 == i3 || !this.f9122T) ? a12 : (a12 + getInternalPaddingStart()) - this.f9124V[this.f9114L];
    }

    private int W0(int i3) {
        if (this.f9109H0 != 1 && getOuterButtonCount() != 1) {
            return i3;
        }
        int a12 = d1(this.f9158s) ? i3 - a1(this.f9158s, View.MeasureSpec.makeMeasureSpec(this.f9139i0, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824)) : i3;
        if (d1(this.f9160t)) {
            a12 -= a1(this.f9160t, View.MeasureSpec.makeMeasureSpec(this.f9139i0, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
        if (a12 == i3) {
            return a12;
        }
        if (this.f9122T) {
            a12 = (a12 + getInternalPaddingEnd()) - this.f9125W[this.f9114L];
        }
        return a12 - this.f9143k0;
    }

    private int X0() {
        return W0(V0((getMeasuredWidth() - getInternalPaddingStart()) - getInternalPaddingEnd()));
    }

    private void Y0(Rect rect, int i3, int i4) {
        if (rect != null) {
            rect.set(0, 0, i3, i4);
        }
    }

    private int Z0(int i3) {
        if (!d1(this.f9150o)) {
            return i3;
        }
        int a12 = i3 - a1(this.f9150o, View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f9131e0, 1073741824));
        return a12 != i3 ? a12 - this.f9133f0 : a12;
    }

    private int a1(View view, int i3, int i4) {
        view.measure(i3, i4);
        return view.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(int i3, int i4) {
        List<g> list = this.f9112J;
        if (list != null) {
            for (g gVar : list) {
                if (gVar != null) {
                    gVar.a(i3, i4);
                }
            }
        }
    }

    private boolean d1(View view) {
        if (view == null) {
            return false;
        }
        return view instanceof ImageView ? (((ImageView) view).getDrawable() == null || view.getVisibility() == 8) ? false : true : view.getVisibility() != 8;
    }

    private int e0(int i3, int i4, int i5) {
        return i3 + ((i4 - i5) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(View view, boolean z3) {
        if (view != null) {
            view.setVisibility(z3 ? 0 : 8);
        }
    }

    private void f1() {
        s sVar = new s(true, this.f9095A0, this.f9097B0);
        if (this.f9144l.getWindowInsetsController() != null) {
            this.f9144l.getWindowInsetsController().controlWindowInsetsAnimation(WindowInsets.Type.ime(), this.f9095A0, this.f9097B0, null, sVar);
        }
    }

    private float g0(float f3) {
        return Math.max(0.0f, Math.min(1.0f, f3 / 0.3f));
    }

    private void g1(int i3) {
        if (i3 == 1) {
            this.f9144l.setImportantForAccessibility(1);
        } else if (i3 == 0) {
            this.f9144l.setImportantForAccessibility(2);
        }
    }

    private b getAnimatorHelper() {
        if (this.f9167w0 == null) {
            this.f9167w0 = new b();
        }
        return this.f9167w0;
    }

    private int getInternalPaddingEnd() {
        return this.f9122T ? this.f9126a0[this.f9114L] : getPaddingEnd();
    }

    private int getInternalPaddingStart() {
        return this.f9122T ? this.f9126a0[this.f9114L] : getPaddingStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOuterButtonCount() {
        return (d1(this.f9158s) ? 1 : 0) + (d1(this.f9160t) ? 1 : 0);
    }

    private View getSearchEditOrAnimationLayout() {
        COUIHintAnimationLayout cOUIHintAnimationLayout = this.f9146m;
        return cOUIHintAnimationLayout != null ? cOUIHintAnimationLayout : this.f9144l;
    }

    private float h0(float f3) {
        return (f3 / 0.7f) - 0.42857146f;
    }

    private void h1() {
        this.f9130e.d(this.f9132f);
    }

    private void i0(ImageView imageView, Drawable drawable, int i3) {
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            imageView.setClickable(true);
            if (drawable != null) {
                int intrinsicWidth = (i3 - drawable.getIntrinsicWidth()) / 2;
                imageView.setPadding(intrinsicWidth, 0, intrinsicWidth, 0);
            }
        }
    }

    private Drawable i1(Drawable drawable, int i3, int i4) {
        return new BitmapDrawable(Bitmap.createScaledBitmap(k0(drawable), i3, i4, true));
    }

    private void j0() {
        if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
            this.f9114L = 0;
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), getMeasuredWidth(), y0.j.j(getContext()))) {
            this.f9114L = 1;
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), getMeasuredWidth(), y0.j.j(getContext()))) {
            this.f9114L = 2;
        }
    }

    private Bitmap k0(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private ImageView l0(Drawable drawable, boolean z3, boolean z4, int i3) {
        if (drawable == null) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        if (!z4) {
            imageView.setClickable(false);
            imageView.setFocusable(false);
        }
        if (z3 && z4) {
            l0.c.a(imageView, i3);
        }
        addView(imageView);
        return imageView;
    }

    private void m0() {
        if (this.f9152p == null) {
            ImageView imageView = new ImageView(getContext());
            this.f9152p = imageView;
            l0.c.a(imageView, C0560b.t(getContext(), 0));
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(g2.c.f11746a);
            this.f9152p.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            addView(this.f9152p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        Drawable f3;
        if (this.f9162u == null && (f3 = androidx.core.content.res.f.f(getResources(), this.f9161t0, getContext().getTheme())) != null) {
            ImageView l02 = l0(f3, true, true, this.f9131e0 / 2);
            this.f9162u = l02;
            l02.setContentDescription(getResources().getString(g2.g.f11808a));
            i0(this.f9162u, f3, this.f9131e0);
            e1(this.f9162u, false);
            this.f9162u.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchview.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    COUISearchBar.this.A0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o0() {
        return !this.f9111I0;
    }

    private void p0(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f9173z0 = true;
        q0();
        r0();
        O0(context, attributeSet, i3, i4);
        s0();
        this.f9169x0 = attributeSet;
        if (attributeSet != null) {
            this.f9159s0 = attributeSet.getStyleAttribute();
        }
        if (this.f9159s0 == 0) {
            this.f9159s0 = i3;
        }
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f9149n0 = context.getResources().getDimensionPixelSize(g2.c.f11738U);
        this.f9155q0 = context.getResources().getColor(M1.e.f1388d);
        this.f9151o0 = context.getResources().getDimensionPixelOffset(g2.c.f11702C);
        this.f9127b0 = context.getResources().getDimensionPixelOffset(g2.c.f11784t);
        this.f9128c0 = context.getResources().getDimensionPixelOffset(g2.c.f11716J);
        this.f9129d0 = context.getResources().getDimensionPixelOffset(g2.c.f11718K);
        this.f9131e0 = context.getResources().getDimensionPixelOffset(g2.c.f11704D);
        this.f9133f0 = context.getResources().getDimensionPixelOffset(g2.c.f11706E);
        this.f9135g0 = context.getResources().getDimensionPixelOffset(g2.c.f11788v);
        this.f9137h0 = context.getResources().getDimensionPixelOffset(g2.c.f11786u);
        this.f9139i0 = context.getResources().getDimensionPixelOffset(g2.c.f11728P);
        this.f9141j0 = context.getResources().getDimensionPixelOffset(g2.c.f11714I);
        this.f9143k0 = context.getResources().getDimensionPixelOffset(g2.c.f11726O);
        this.f9145l0 = context.getResources().getDimensionPixelOffset(g2.c.f11796z);
        this.f9147m0 = context.getResources().getDimensionPixelOffset(g2.c.f11700B);
        this.f9157r0 = context.getResources().getDimensionPixelOffset(g2.c.f11698A);
        this.f9101D0 = context.getResources().getDimensionPixelSize(g2.c.f11740V);
        this.f9103E0 = context.getResources().getDimensionPixelSize(g2.c.f11740V);
        this.f9123U = new int[]{context.getResources().getDimensionPixelOffset(g2.c.f11790w), context.getResources().getDimensionPixelOffset(g2.c.f11794y), context.getResources().getDimensionPixelOffset(g2.c.f11792x)};
        this.f9124V = new int[]{context.getResources().getDimensionPixelOffset(g2.c.f11708F), context.getResources().getDimensionPixelOffset(g2.c.f11712H), context.getResources().getDimensionPixelOffset(g2.c.f11710G)};
        this.f9125W = new int[]{context.getResources().getDimensionPixelOffset(g2.c.f11720L), context.getResources().getDimensionPixelOffset(g2.c.f11724N), context.getResources().getDimensionPixelOffset(g2.c.f11722M)};
        this.f9126a0 = new int[]{context.getResources().getDimensionPixelOffset(g2.c.f11730Q), context.getResources().getDimensionPixelOffset(g2.c.f11734S), context.getResources().getDimensionPixelOffset(g2.c.f11732R)};
        N0(context, attributeSet, i3, i4);
        this.f9115M = androidx.core.content.res.f.d(getContext().getResources(), g2.b.f11695a, getContext().getTheme());
        this.f9116N = androidx.core.content.res.f.d(getContext().getResources(), g2.b.f11696b, getContext().getTheme());
        this.f9130e.e(AbstractC0335a.a(getContext(), M1.c.f1363h));
        this.f9130e.f(this.f9115M);
        this.f9105F0 = getResources().getString(g2.g.f11809b);
        this.f9107G0 = getResources().getString(g2.g.f11811d);
    }

    private void q0() {
        View view = new View(getContext());
        this.f9136h = view;
        AbstractC0342a.b(view, false);
        C0559a c0559a = new C0559a(getContext(), 0);
        this.f9140j = c0559a;
        c0559a.C(this.f9130e.b());
        C0562d c0562d = new C0562d(getContext());
        this.f9142k = c0562d;
        c0562d.v(this.f9130e.b());
        C0561c c0561c = new C0561c(new Drawable[]{this.f9130e, this.f9140j, this.f9142k});
        this.f9138i = c0561c;
        this.f9136h.setBackground(c0561c);
        addView(this.f9136h, new ViewGroup.LayoutParams(-1, -1));
        setDefaultFocusHighlightEnabled(false);
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.coui.appcompat.searchview.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z3) {
                COUISearchBar.this.B0(view2, z3);
            }
        });
    }

    private void r0() {
        EditText editText = new EditText(new ContextThemeWrapper(getContext(), g2.h.f11814c), null);
        this.f9144l = editText;
        editText.setVerticalScrollBarEnabled(false);
        this.f9144l.setMaxLines(1);
        this.f9144l.setInputType(1);
        this.f9144l.setEllipsize(TextUtils.TruncateAt.END);
        this.f9144l.setImeOptions(3);
        this.f9144l.setId(g2.e.f11806g);
        this.f9144l.setImportantForAccessibility(2);
        this.f9144l.setImportantForAutofill(2);
        this.f9144l.addTextChangedListener(new a());
        addView(this.f9144l);
    }

    private void s0() {
        if (this.f9111I0) {
            AbstractC0371a.d("COUISearchBar", "mHideFunctionalButton is true");
            return;
        }
        TextView textView = new TextView(getContext());
        this.f9148n = textView;
        textView.setMaxLines(1);
        this.f9148n.setEllipsize(TextUtils.TruncateAt.END);
        this.f9148n.setTextAppearance(getContext(), M1.l.f1506f);
        this.f9148n.setText(g2.g.f11810c);
        this.f9148n.setTextColor(androidx.core.content.res.f.d(getResources(), g2.b.f11697c, getContext().getTheme()));
        this.f9148n.setClickable(true);
        this.f9148n.setFocusable(true);
        this.f9148n.setAlpha(0.0f);
        this.f9148n.setVisibility(8);
        this.f9148n.setTextSize(0, AbstractC0597a.e(this.f9148n.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
        AbstractC0608a.b(this.f9148n);
        addView(this.f9148n);
    }

    private void setMenuItem(MenuItem menuItem) {
        this.f9119Q = menuItem;
        if (menuItem == null || menuItem.getActionView() != this) {
            return;
        }
        this.f9119Q.setActionView((View) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOuterButtonVisibility(int i3) {
        if (i3 == 0 || i3 == 4 || i3 == 8) {
            ImageView imageView = this.f9158s;
            if (imageView != null) {
                imageView.setVisibility(i3);
            }
            ImageView imageView2 = this.f9160t;
            if (imageView2 != null) {
                imageView2.setVisibility(i3);
            }
        }
    }

    private void setToolBarAlpha(float f3) {
        COUIToolbar cOUIToolbar = this.f9120R;
        if (cOUIToolbar != null) {
            int childCount = cOUIToolbar.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f9120R.getChildAt(i3);
                if (childAt != this) {
                    childAt.setAlpha(f3);
                }
            }
        }
    }

    private void setToolBarChildVisibility(int i3) {
        COUIToolbar cOUIToolbar = this.f9120R;
        if (cOUIToolbar != null) {
            int childCount = cOUIToolbar.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = this.f9120R.getChildAt(i4);
                if (childAt != this) {
                    childAt.setVisibility(i3);
                }
            }
        }
    }

    private boolean t0() {
        if (getContext() instanceof Activity) {
            return ((Activity) getContext()).isInMultiWindowMode();
        }
        return false;
    }

    private boolean u0(float f3, float f4) {
        return this.f9132f.contains((int) f3, (int) f4);
    }

    private boolean v0(float f3, float f4) {
        return y0(this.f9148n, f3, f4);
    }

    private boolean w0(float f3, float f4) {
        return y0(this.f9154q, f3, f4) || y0(this.f9156r, f3, f4) || y0(this.f9162u, f3, f4);
    }

    private boolean x0(float f3, float f4) {
        return y0(this.f9158s, f3, f4) || y0(this.f9160t, f3, f4) || y0(this.f9152p, f3, f4);
    }

    static /* synthetic */ e y(COUISearchBar cOUISearchBar) {
        cOUISearchBar.getClass();
        return null;
    }

    private boolean y0(View view, float f3, float f4) {
        return view != null && view.getVisibility() != 8 && f3 >= ((float) view.getLeft()) && f3 <= ((float) view.getRight()) && f4 >= ((float) view.getTop()) && f4 <= ((float) view.getBottom());
    }

    private boolean z0() {
        return y.x(this) == 1;
    }

    public void c1(boolean z3) {
        if (this.f9144l != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            AbstractC0371a.a("COUISearchBar", "openSoftInput: " + z3);
            if (!z3) {
                this.f9144l.clearFocus();
                if (inputMethodManager == null || !inputMethodManager.isActive()) {
                    return;
                }
                inputMethodManager.hideSoftInputFromWindow(this.f9144l.getWindowToken(), 0);
                return;
            }
            this.f9144l.requestFocus();
            if (inputMethodManager != null) {
                if (this.f9173z0 && this.f9095A0 != 0 && !t0()) {
                    f1();
                    return;
                }
                WindowInsetsController windowInsetsController = this.f9144l.getWindowInsetsController();
                if (windowInsetsController != null) {
                    windowInsetsController.show(WindowInsets.Type.ime());
                }
            }
        }
    }

    public void d0(g gVar) {
        if (this.f9112J == null) {
            this.f9112J = new ArrayList();
        }
        this.f9112J.add(gVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f3 = this.f9163u0;
        if (f3 >= 1.0f || f3 < 0.75f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(0, this.f9132f.top, getWidth(), this.f9132f.bottom);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (isEnabled() && (motionEvent.getActionMasked() == 9 || motionEvent.getActionMasked() == 7)) {
            this.f9138i.e(u0(motionEvent.getX(), motionEvent.getY()));
        }
        if (motionEvent.getActionMasked() == 10) {
            this.f9138i.e(false);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (u0(motionEvent.getX(), motionEvent.getY()) || this.f9121S) {
                    this.f9121S = false;
                    this.f9138i.g(false);
                }
            } else if (!u0(motionEvent.getX(), motionEvent.getY()) && this.f9121S) {
                this.f9121S = false;
                this.f9138i.g(false);
            }
        } else {
            if (motionEvent.getY() < this.f9132f.top || motionEvent.getY() > this.f9132f.bottom) {
                return false;
            }
            if (u0(motionEvent.getX(), motionEvent.getY()) && !w0(motionEvent.getX(), motionEvent.getY()) && !v0(motionEvent.getX(), motionEvent.getY())) {
                this.f9121S = true;
                this.f9138i.g(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f0(int i3) {
        if (this.f9099C0.get() == i3) {
            AbstractC0371a.a("COUISearchBar", "changeStateImmediately: same state , return. targetState = " + i3);
            return;
        }
        g1(i3);
        if (this.f9099C0.get() == 1) {
            getAnimatorHelper().L(0);
        } else if (this.f9099C0.get() == 0) {
            getAnimatorHelper().L(1);
        }
    }

    public TextView getFunctionalButton() {
        return this.f9148n;
    }

    public COUIHintAnimationLayout getHintAnimationLayout() {
        if (this.f9146m == null) {
            this.f9146m = new COUIHintAnimationLayout(getContext());
            removeView(this.f9144l);
            this.f9146m.setSearchEditText(this.f9144l);
            addView(this.f9146m);
        }
        return this.f9146m;
    }

    public View getInnerPrimaryButton() {
        return this.f9154q;
    }

    public View getInnerSecondaryButton() {
        return this.f9156r;
    }

    public boolean getInputMethodAnimationEnabled() {
        return this.f9171y0;
    }

    public View getNavigationView() {
        return this.f9152p;
    }

    public View getOuterPrimaryButton() {
        return this.f9158s;
    }

    public View getOuterSecondaryButton() {
        return this.f9160t;
    }

    public View getQuickDeleteButton() {
        return this.f9162u;
    }

    public EditText getSearchEditText() {
        return this.f9144l;
    }

    public int getSearchState() {
        return this.f9099C0.get();
    }

    public float getSearchViewAnimateHeightPercent() {
        return this.f9163u0;
    }

    @Override // android.view.CollapsibleActionView
    public void onActionViewCollapsed() {
    }

    @Override // android.view.CollapsibleActionView
    public void onActionViewExpanded() {
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.f9144l.getImportantForAccessibility() == 1) {
            return;
        }
        String str = "";
        if (!TextUtils.isEmpty(this.f9105F0)) {
            str = "" + this.f9105F0;
        }
        COUIHintAnimationLayout cOUIHintAnimationLayout = this.f9146m;
        if (cOUIHintAnimationLayout != null && cOUIHintAnimationLayout.getCurrentHintTextView() != null) {
            str = str + "," + this.f9107G0 + ((Object) this.f9146m.getCurrentHintTextView().getText());
        }
        accessibilityNodeInfo.setContentDescription(str);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (w0(motionEvent.getX(), motionEvent.getY()) || x0(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        if (this.f9099C0.get() == 0) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        E0();
        D0();
        F0();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i4));
        j0();
        U0(P0(X0()));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof c) {
            setSearchViewAnimateHeightPercent(((c) parcelable).f9183e);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f9183e = this.f9163u0;
        return cVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && !u0(motionEvent.getX(), motionEvent.getY())) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            super.onTouchEvent(obtain);
            obtain.recycle();
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        if (o0()) {
            this.f9148n.setEnabled(z3);
        }
        this.f9136h.setEnabled(z3);
        ImageView imageView = this.f9150o;
        if (imageView != null) {
            imageView.setEnabled(z3);
        }
        ImageView imageView2 = this.f9152p;
        if (imageView2 != null) {
            imageView2.setEnabled(z3);
        }
        ImageView imageView3 = this.f9162u;
        if (imageView3 != null) {
            imageView3.setEnabled(z3);
        }
        ImageView imageView4 = this.f9154q;
        if (imageView4 != null) {
            imageView4.setEnabled(z3);
        }
        ImageView imageView5 = this.f9156r;
        if (imageView5 != null) {
            imageView5.setEnabled(z3);
        }
        ImageView imageView6 = this.f9158s;
        if (imageView6 != null) {
            imageView6.setEnabled(z3);
        }
        ImageView imageView7 = this.f9160t;
        if (imageView7 != null) {
            imageView7.setEnabled(z3);
        }
    }

    public void setExtraActivateMarginTop(int i3) {
        getAnimatorHelper().f9178d = i3;
    }

    public void setFunctionalButtonText(String str) {
        if (o0()) {
            this.f9148n.setText(str);
        }
    }

    public void setHideFunctionalButton(boolean z3) {
        if (this.f9111I0 != z3) {
            this.f9111I0 = z3;
            if (z3) {
                this.f9148n.setVisibility(8);
            } else {
                if (this.f9148n == null) {
                    s0();
                }
                this.f9148n.setVisibility(0);
            }
            requestLayout();
        }
    }

    public void setInnerPrimaryButton(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i3 = this.f9101D0;
        if (intrinsicWidth > i3) {
            drawable = i1(drawable, (int) (i3 * getResources().getDisplayMetrics().density), (int) (this.f9103E0 * getResources().getDisplayMetrics().density));
        }
        if (this.f9154q == null) {
            this.f9154q = l0(drawable, true, true, this.f9131e0 / 2);
        }
        ImageView imageView = this.f9154q;
        if (imageView != null) {
            i0(imageView, drawable, this.f9131e0);
        }
    }

    public void setInnerSecondaryButton(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i3 = this.f9101D0;
        if (intrinsicWidth > i3) {
            drawable = i1(drawable, (int) (i3 * getResources().getDisplayMetrics().density), (int) (this.f9103E0 * getResources().getDisplayMetrics().density));
        }
        if (this.f9156r == null) {
            this.f9156r = l0(drawable, true, true, this.f9131e0 / 2);
        }
        ImageView imageView = this.f9156r;
        if (imageView != null) {
            i0(imageView, drawable, this.f9131e0);
        }
    }

    public void setInputMethodAnimationEnabled(boolean z3) {
        this.f9171y0 = z3;
    }

    public void setNavigationViewDrawable(Drawable drawable) {
        m0();
        this.f9152p.setImageDrawable(drawable);
        this.f9152p.setClickable(true);
    }

    public void setOnAnimationListener(e eVar) {
    }

    public void setOnSearchBarBackgroundBoundsChangedListener(f fVar) {
    }

    public void setOuterPrimaryButton(Drawable drawable) {
        if (drawable == null) {
            ImageView imageView = this.f9158s;
            if (imageView != null) {
                removeView(imageView);
                this.f9158s = null;
                return;
            }
            return;
        }
        if (this.f9158s == null) {
            this.f9158s = l0(drawable, true, true, this.f9139i0 / 2);
        }
        ImageView imageView2 = this.f9158s;
        if (imageView2 != null) {
            i0(imageView2, drawable, this.f9139i0);
        }
    }

    public void setOuterSecondaryButton(Drawable drawable) {
        if (drawable == null) {
            ImageView imageView = this.f9160t;
            if (imageView != null) {
                removeView(imageView);
                this.f9160t = null;
                return;
            }
            return;
        }
        if (this.f9160t == null) {
            this.f9160t = l0(drawable, true, true, this.f9139i0 / 2);
        }
        ImageView imageView2 = this.f9160t;
        if (imageView2 != null) {
            i0(imageView2, drawable, this.f9139i0);
        }
    }

    public void setSearchAnimateType(int i3) {
        if (this.f9099C0.get() != 1) {
            this.f9109H0 = i3;
            requestLayout();
            return;
        }
        AbstractC0371a.a("COUISearchBar", "setSearchAnimateType to " + f9093N0[i3] + " is not allowed in STATE_EDIT");
    }

    public void setSearchBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i3 = this.f9115M;
            int defaultColor = colorStateList.getDefaultColor();
            this.f9115M = defaultColor;
            this.f9116N = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, defaultColor);
            if (this.f9130e.a() == i3) {
                this.f9130e.f(this.f9115M);
            }
            invalidate();
        }
    }

    public void setSearchViewAnimateHeightPercent(float f3) {
        this.f9163u0 = f3;
        this.f9113K = h0(f3);
        this.f9153p0 = (int) (getInternalPaddingEnd() * (1.0f - g0(f3)));
        setTranslationY(Math.max(0.0f, ((this.f9151o0 / 2.0f) * (1.0f - f3)) - 1.0f));
        float f4 = (f3 - 0.75f) * 4.0f;
        ImageView imageView = this.f9150o;
        if (imageView != null) {
            imageView.setAlpha(f4);
        }
        ImageView imageView2 = this.f9154q;
        if (imageView2 != null) {
            imageView2.setAlpha(f4);
        }
        ImageView imageView3 = this.f9156r;
        if (imageView3 != null) {
            imageView3.setAlpha(f4);
        }
        ImageView imageView4 = this.f9158s;
        if (imageView4 != null) {
            imageView4.setAlpha(f4);
        }
        ImageView imageView5 = this.f9160t;
        if (imageView5 != null) {
            imageView5.setAlpha(f4);
        }
        this.f9130e.f(((Integer) f9092M0.evaluate(g0(f3), Integer.valueOf(this.f9155q0), Integer.valueOf(this.f9115M))).intValue());
        COUIHintAnimationLayout cOUIHintAnimationLayout = this.f9146m;
        if (cOUIHintAnimationLayout != null) {
            cOUIHintAnimationLayout.setAlpha(f4);
        } else {
            this.f9144l.setAlpha(f4);
        }
        COUIHintAnimationLayout cOUIHintAnimationLayout2 = this.f9146m;
        if (cOUIHintAnimationLayout2 != null) {
            if (f3 < 1.0f) {
                cOUIHintAnimationLayout2.v();
            } else {
                cOUIHintAnimationLayout2.x();
            }
        }
        if (!isInLayout()) {
            requestLayout();
            return;
        }
        j0();
        U0(P0(X0()));
        E0();
        D0();
        F0();
    }

    public void setSearchViewIcon(Drawable drawable) {
        i0(this.f9150o, drawable, this.f9131e0);
    }

    public void setUseResponsivePadding(boolean z3) {
        this.f9122T = z3;
        requestLayout();
    }

    public COUISearchBar(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, AbstractC0335a.j(context) ? g2.h.f11813b : g2.h.f11812a);
    }

    public COUISearchBar(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f9130e = new o();
        this.f9132f = new Rect();
        this.f9134g = new Rect();
        this.f9113K = 1.0f;
        this.f9114L = 0;
        this.f9117O = 0;
        this.f9118P = 48;
        this.f9121S = false;
        this.f9122T = true;
        this.f9157r0 = 0;
        this.f9159s0 = 0;
        this.f9161t0 = -1;
        this.f9163u0 = 1.0f;
        this.f9165v0 = 0.0f;
        this.f9169x0 = null;
        this.f9171y0 = true;
        this.f9095A0 = 0;
        this.f9097B0 = null;
        this.f9099C0 = new AtomicInteger(0);
        this.f9109H0 = 0;
        this.f9111I0 = false;
        p0(context, attributeSet, i3, i4);
    }
}
