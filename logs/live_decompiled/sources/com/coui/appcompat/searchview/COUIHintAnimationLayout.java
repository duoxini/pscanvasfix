package com.coui.appcompat.searchview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.internal.TextWatcherAdapter;
import d0.AbstractC0335a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIHintAnimationLayout extends FrameLayout {

    /* renamed from: y, reason: collision with root package name */
    private static final TimeInterpolator f9063y = androidx.core.view.animation.a.a(0.3f, 0.0f, 0.2f, 1.0f);

    /* renamed from: z, reason: collision with root package name */
    private static final Y.b f9064z = new Y.b();

    /* renamed from: e, reason: collision with root package name */
    private List f9065e;

    /* renamed from: f, reason: collision with root package name */
    private int f9066f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f9067g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f9068h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f9069i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f9070j;

    /* renamed from: k, reason: collision with root package name */
    private String f9071k;

    /* renamed from: l, reason: collision with root package name */
    private AnimatorSet f9072l;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f9073m;

    /* renamed from: n, reason: collision with root package name */
    private ObjectAnimator f9074n;

    /* renamed from: o, reason: collision with root package name */
    private ObjectAnimator f9075o;

    /* renamed from: p, reason: collision with root package name */
    private ObjectAnimator f9076p;

    /* renamed from: q, reason: collision with root package name */
    private ObjectAnimator f9077q;

    /* renamed from: r, reason: collision with root package name */
    private EditText f9078r;

    /* renamed from: s, reason: collision with root package name */
    private int f9079s;

    /* renamed from: t, reason: collision with root package name */
    boolean f9080t;

    /* renamed from: u, reason: collision with root package name */
    boolean f9081u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f9082v;

    /* renamed from: w, reason: collision with root package name */
    private int f9083w;

    /* renamed from: x, reason: collision with root package name */
    private int f9084x;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (COUIHintAnimationLayout.this.f9065e.isEmpty()) {
                return;
            }
            COUIHintAnimationLayout cOUIHintAnimationLayout = COUIHintAnimationLayout.this;
            cOUIHintAnimationLayout.f9066f = (cOUIHintAnimationLayout.f9066f + 1) % COUIHintAnimationLayout.this.f9065e.size();
            COUIHintAnimationLayout cOUIHintAnimationLayout2 = COUIHintAnimationLayout.this;
            if (cOUIHintAnimationLayout2.f9080t) {
                cOUIHintAnimationLayout2.r((String) cOUIHintAnimationLayout2.f9065e.get(COUIHintAnimationLayout.this.f9066f));
            }
            COUIHintAnimationLayout.this.postDelayed(this, 3000L);
        }
    }

    class b extends TextWatcherAdapter {
        b() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(COUIHintAnimationLayout.this.f9078r.getText().toString())) {
                if (TextUtils.isEmpty(COUIHintAnimationLayout.this.f9071k)) {
                    return;
                }
                COUIHintAnimationLayout.this.f9070j.setText(COUIHintAnimationLayout.this.f9071k);
                COUIHintAnimationLayout.this.f9070j.setVisibility(0);
                COUIHintAnimationLayout.this.getNextHintTextView().setVisibility(8);
                return;
            }
            COUIHintAnimationLayout cOUIHintAnimationLayout = COUIHintAnimationLayout.this;
            cOUIHintAnimationLayout.removeCallbacks(cOUIHintAnimationLayout.f9067g);
            COUIHintAnimationLayout.this.f9068h.setVisibility(8);
            COUIHintAnimationLayout.this.f9069i.setVisibility(8);
            COUIHintAnimationLayout.this.s();
            COUIHintAnimationLayout.this.f9080t = false;
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            COUIHintAnimationLayout cOUIHintAnimationLayout = COUIHintAnimationLayout.this;
            cOUIHintAnimationLayout.f9070j = cOUIHintAnimationLayout.getNextHintTextView();
            if (COUIHintAnimationLayout.this.f9082v) {
                COUIHintAnimationLayout.this.v();
                COUIHintAnimationLayout.this.f9082v = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            COUIHintAnimationLayout.this.getNextHintTextView().setText(COUIHintAnimationLayout.this.f9071k);
            COUIHintAnimationLayout.this.getNextHintTextView().setVisibility(0);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIHintAnimationLayout.this.f9073m.start();
        }
    }

    public interface e {
    }

    public COUIHintAnimationLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView getNextHintTextView() {
        TextView textView = this.f9070j;
        TextView textView2 = this.f9068h;
        return textView == textView2 ? this.f9069i : textView2;
    }

    private boolean q() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.f9073m;
        return (animatorSet2 != null && animatorSet2.isRunning()) || ((animatorSet = this.f9072l) != null && animatorSet.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        if (this.f9070j == null) {
            return;
        }
        int i3 = this.f9084x + 1;
        this.f9084x = i3;
        int i4 = this.f9083w;
        if (i4 != -1 && i3 > i4) {
            v();
            return;
        }
        this.f9071k = str;
        int measuredHeight = ((getMeasuredHeight() - this.f9070j.getLineHeight()) / 2) + this.f9079s;
        if (this.f9072l == null || this.f9073m == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f9070j, "translationY", 0.0f, -measuredHeight);
            this.f9074n = ofFloat;
            TimeInterpolator timeInterpolator = f9063y;
            ofFloat.setInterpolator(timeInterpolator);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f9070j, "alpha", 1.0f, 0.0f);
            this.f9075o = ofFloat2;
            Y.b bVar = f9064z;
            ofFloat2.setInterpolator(bVar);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f9072l = animatorSet;
            animatorSet.playTogether(this.f9074n, this.f9075o);
            this.f9072l.setDuration(600L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(getNextHintTextView(), "translationY", measuredHeight, 0.0f);
            this.f9076p = ofFloat3;
            ofFloat3.setInterpolator(timeInterpolator);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(getNextHintTextView(), "alpha", 0.0f, 1.0f);
            this.f9077q = ofFloat4;
            ofFloat4.setInterpolator(bVar);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f9073m = animatorSet2;
            animatorSet2.playTogether(this.f9076p, this.f9077q);
            this.f9073m.setDuration(600L);
            this.f9073m.addListener(new c());
        } else {
            this.f9074n.setTarget(this.f9070j);
            this.f9075o.setTarget(this.f9070j);
            this.f9076p.setTarget(getNextHintTextView());
            this.f9077q.setTarget(getNextHintTextView());
        }
        postDelayed(new d(), 150L);
        this.f9072l.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        AnimatorSet animatorSet = this.f9073m;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f9073m.cancel();
        }
        AnimatorSet animatorSet2 = this.f9072l;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            return;
        }
        this.f9072l.cancel();
    }

    private void t() {
        if (this.f9068h == null && this.f9069i == null) {
            this.f9068h = new TextView(new ContextThemeWrapper(getContext(), g2.h.f11815d), null);
            this.f9069i = new TextView(new ContextThemeWrapper(getContext(), g2.h.f11815d), null);
            this.f9068h.setImportantForAccessibility(2);
            this.f9069i.setImportantForAccessibility(2);
            this.f9068h.setTextAppearance(M1.l.f1505e);
            this.f9069i.setTextAppearance(M1.l.f1505e);
            this.f9068h.setTextColor(AbstractC0335a.a(getContext(), M1.c.f1370o));
            this.f9069i.setTextColor(AbstractC0335a.a(getContext(), M1.c.f1370o));
            this.f9068h.setId(g2.e.f11802c);
            this.f9069i.setId(g2.e.f11803d);
            addView(this.f9068h);
            addView(this.f9069i);
        }
    }

    private void u() {
        if (this.f9067g == null) {
            this.f9065e = new ArrayList();
            this.f9067g = new a();
            this.f9078r.addTextChangedListener(new b());
        }
    }

    private void w() {
        this.f9068h.setTranslationY(0.0f);
        this.f9068h.setAlpha(1.0f);
        this.f9069i.setTranslationY(0.0f);
        this.f9069i.setAlpha(1.0f);
    }

    TextView getCurrentHintTextView() {
        return this.f9070j;
    }

    public List<String> getHintStrings() {
        return this.f9065e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        x();
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        v();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (i3 == 0) {
            if (this.f9081u) {
                x();
                this.f9081u = false;
                return;
            }
            return;
        }
        if (this.f9080t) {
            v();
            this.f9081u = true;
        }
    }

    public void setCOUIHintAnimationChangeListener(e eVar) {
    }

    public void setHintsAnimation(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.f9078r == null) {
            if (!(getChildAt(0) instanceof EditText)) {
                Log.e("COUIHintAnimationLayout", "Before calling this method, you must ensure that there is an edittext object in the container:1, you can call setSearchEditText or add an edittext yourself, refer to COUISearchBar2, you can put an edittext object in xml ( Refer to coui_search_view_animated_support_layout)to use the related functions of this animation container");
                return;
            }
            this.f9078r = (EditText) getChildAt(0);
        }
        if (!TextUtils.isEmpty(this.f9078r.getText().toString())) {
            Log.e("COUIHintAnimationLayout", "Setting hints animation content is invalid when the searchEdittext has a value");
            return;
        }
        t();
        u();
        if (!this.f9065e.equals(list)) {
            this.f9065e.clear();
            this.f9065e.addAll(list);
        }
        if (this.f9070j == null) {
            this.f9070j = this.f9068h;
        }
        if (TextUtils.isEmpty(this.f9071k)) {
            this.f9071k = (String) this.f9065e.get(this.f9066f);
        }
        this.f9070j.setText(this.f9071k);
        this.f9070j.setVisibility(0);
        removeCallbacks(this.f9067g);
        this.f9078r.setHint("");
        postDelayed(this.f9067g, 3000L);
        this.f9080t = true;
    }

    public void setRepeatCount(int i3) {
        if (i3 <= 0) {
            Log.e("COUIHintAnimationLayout", "RepeatCount must be greater than zero");
        } else {
            this.f9083w = i3;
        }
    }

    public void setSearchEditText(EditText editText) {
        this.f9078r = editText;
        if (getChildCount() == 0) {
            addView(this.f9078r, new FrameLayout.LayoutParams(-1, -1));
        } else {
            Log.e("COUIHintAnimationLayout", "setSearchEditText() can only be executed once");
        }
    }

    public void v() {
        List list;
        removeCallbacks(this.f9067g);
        if (!this.f9080t || (list = this.f9065e) == null || list.size() == 0) {
            Log.e("COUIHintAnimationLayout", "pauseHintsAnimation return");
            return;
        }
        if (q()) {
            this.f9082v = true;
            return;
        }
        w();
        this.f9080t = false;
        if (TextUtils.isEmpty(this.f9071k)) {
            this.f9068h.setVisibility(8);
            this.f9069i.setVisibility(8);
        } else {
            this.f9070j.setText(this.f9071k);
            this.f9070j.setVisibility(0);
            getNextHintTextView().setVisibility(8);
        }
    }

    public void x() {
        setHintsAnimation(this.f9065e);
    }

    public COUIHintAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9066f = 0;
        this.f9080t = false;
        this.f9081u = false;
        this.f9082v = false;
        this.f9083w = -1;
        this.f9084x = 0;
        this.f9079s = context.getResources().getDimensionPixelSize(g2.c.f11782s);
    }
}
