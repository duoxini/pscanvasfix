package com.oplus.flexibletask.setting.guide;

import B1.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemProperties;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.textview.COUITextView;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.flexibletask.setting.guide.BaseGuideContentView;
import com.oplus.util.OplusChangeTextUtil;
import java.util.Objects;
import t1.g;
import t1.h;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public abstract class BaseGuideContentView extends ConstraintLayout {
    private static final int ANIM_PADDING_DP = 48;
    private static Boolean DEBUG = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));
    private static final String TAG = "BaseGuideContentView";
    private EffectiveAnimationView mAnim;
    private String mAnimAssetsPath;
    private final long mAnimRepeatDelay;
    private int mAnimResID;
    private volatile boolean mIsAttached;
    private volatile boolean mIsPlaying;
    private int mPosition;
    private TextView mSummaryText;
    private COUITextView mTitleText;

    /* renamed from: com.oplus.flexibletask.setting.guide.BaseGuideContentView$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            AbstractC0652e.h(BaseGuideContentView.TAG, "postDelayed playAnimation");
            if (BaseGuideContentView.this.mIsAttached && BaseGuideContentView.this.mIsPlaying) {
                BaseGuideContentView.this.mAnim.v();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (BaseGuideContentView.this.mIsAttached && BaseGuideContentView.this.mIsPlaying) {
                BaseGuideContentView.this.postDelayed(new Runnable() { // from class: com.oplus.flexibletask.setting.guide.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseGuideContentView.AnonymousClass1.this.lambda$onAnimationEnd$0();
                    }
                }, BaseGuideContentView.this.mAnimRepeatDelay);
            }
        }
    }

    public BaseGuideContentView(Context context) {
        this(context, null);
    }

    private void setClassificationTextSize(TextView textView, Context context) {
        textView.setTextSize(0, OplusChangeTextUtil.getSuitableFontSize(textView.getTextSize(), textView.getResources().getConfiguration().fontScale, 2));
    }

    private void updateAnimViewPadding(int i3) {
        if (this.mAnim == null || i3 <= 0 || getContext() == null) {
            return;
        }
        int b3 = s.b(48.0f, getContext().getResources());
        ViewGroup.LayoutParams layoutParams = this.mAnim.getLayoutParams();
        if (layoutParams != null) {
            if ((i3 - layoutParams.width) / 2 <= b3) {
                EffectiveAnimationView effectiveAnimationView = this.mAnim;
                effectiveAnimationView.setPadding(b3, effectiveAnimationView.getPaddingTop(), b3, this.mAnim.getPaddingBottom());
            } else {
                EffectiveAnimationView effectiveAnimationView2 = this.mAnim;
                effectiveAnimationView2.setPadding(0, effectiveAnimationView2.getPaddingTop(), 0, this.mAnim.getPaddingBottom());
            }
        }
    }

    protected boolean delayBeforeStartPlay() {
        return false;
    }

    protected final int getAnimRepeatDelayConfig() {
        return g.f13467a;
    }

    public int getPosition() {
        return this.mPosition;
    }

    protected final int getWidgetLayout(Context context) {
        return context.toString().contains("SettingActivity") ? h.f13483p : h.f13484q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        play();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        stop();
        this.mIsAttached = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        updateAnimViewPadding(i3);
    }

    public void play() {
        if (this.mAnim == null || this.mAnimResID == 0 || TextUtils.isEmpty(this.mAnimAssetsPath) || !this.mIsAttached || this.mIsPlaying) {
            return;
        }
        this.mAnim.w();
        this.mAnim.g(new AnonymousClass1());
        if (delayBeforeStartPlay()) {
            if (DEBUG.booleanValue()) {
                AbstractC0652e.h(TAG, "delay Before Start playAnimation");
            }
            final EffectiveAnimationView effectiveAnimationView = this.mAnim;
            Objects.requireNonNull(effectiveAnimationView);
            postDelayed(new Runnable() { // from class: com.oplus.flexibletask.setting.guide.a
                @Override // java.lang.Runnable
                public final void run() {
                    EffectiveAnimationView.this.v();
                }
            }, this.mAnimRepeatDelay);
        } else {
            this.mAnim.v();
        }
        this.mIsPlaying = true;
    }

    public void setAnimResource(int i3, String str) {
        this.mAnimResID = i3;
        this.mAnimAssetsPath = str;
        if (this.mAnim == null || i3 == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        this.mAnim.setAnimation(this.mAnimResID);
        this.mAnim.setImageAssetsFolder(this.mAnimAssetsPath);
    }

    public void setPosition(int i3) {
        this.mPosition = i3;
    }

    public void setSummaryText(int i3) {
        TextView textView = this.mSummaryText;
        if (textView != null) {
            textView.setText(i3);
        }
    }

    public void setTitleText(int i3) {
        COUITextView cOUITextView = this.mTitleText;
        if (cOUITextView != null) {
            cOUITextView.setText(i3);
        }
    }

    public void stop() {
        if (this.mAnim == null || this.mAnimResID == 0 || TextUtils.isEmpty(this.mAnimAssetsPath) || !this.mIsPlaying) {
            return;
        }
        this.mIsPlaying = false;
        this.mAnim.w();
        this.mAnim.i();
        this.mAnim.setProgress(0.0f);
    }

    public BaseGuideContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseGuideContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View inflate = LayoutInflater.from(context).inflate(getWidgetLayout(context), this);
        if (inflate != null) {
            this.mAnim = (EffectiveAnimationView) inflate.findViewById(t1.f.f13445e);
            this.mTitleText = (COUITextView) inflate.findViewById(t1.f.f13444d);
            this.mSummaryText = (TextView) inflate.findViewById(t1.f.f13443c);
        }
        EffectiveAnimationView effectiveAnimationView = this.mAnim;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.setForceDarkAllowed(false);
        }
        setClassificationTextSize(this.mTitleText, context);
        this.mAnimResID = 0;
        this.mAnimAssetsPath = null;
        this.mIsAttached = false;
        this.mIsPlaying = false;
        this.mAnimRepeatDelay = context.getResources().getInteger(getAnimRepeatDelayConfig());
        this.mPosition = 0;
    }

    public void setSummaryText(int i3, Object... objArr) {
        TextView textView = this.mSummaryText;
        if (textView != null) {
            textView.setText(getContext().getString(i3, objArr));
        }
    }

    public void setSummaryText(Spannable spannable) {
        TextView textView = this.mSummaryText;
        if (textView != null) {
            textView.setText(spannable);
            this.mSummaryText.setMovementMethod(LinkMovementMethod.getInstance());
            this.mSummaryText.setLinksClickable(true);
        }
    }
}
