package com.coui.appcompat.panel;

import U1.f;
import U1.g;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.toolbar.COUIToolbar;
import d0.AbstractC0335a;
import java.io.Serializable;

/* loaded from: classes.dex */
public class COUIPanelFragment extends Fragment implements Serializable {
    private static final long ENTER_MASK_ALPHA_ANIM_DURATION = 350;
    private static final long EXIT_MASK_ALPHA_ANIM_DURATION = 300;
    private static final long MASK_ALPHA = 255;
    private static final String SAVE_IS_IN_TINY_SCREEN_PANEL_KEY = "SAVE_IS_IN_TINY_SCREEN_PANEL_KEY";
    private static final String SAVE_IS_SHOW_IN_FIRST_PANEL_KEY = "SAVE_IS_SHOW_IN_FIRST_PANEL_KEY";
    private View mContentView;
    private DialogInterface.OnKeyListener mDialogOnKeyListener;
    private COUIPanelDragListener mDragPanelListener;
    private View mDragView;
    protected boolean mIsInTinyScreen;
    private Boolean mIsShowOnFirstPanel = Boolean.FALSE;
    private COUIBottomSheetDialog.OnBackInvokedLocalListener mOnBackInvokedLocalListener;
    private View.OnTouchListener mOutSideViewOnTouchListener;
    private COUIPanelBarView mPanelBarView;
    private PanelFragmentAnimationListener mPanelFragmentAnimationListener;
    private COUIPanelContentLayout mPanelView;
    private View mTitleView;
    private FrameLayout mTitleViewLayout;
    private COUIToolbar mToolbar;
    private static final Interpolator ENTER_MASK_ALPHA_ANIM_INTERPOLATOR = new PathInterpolator(0.3f, 0.26f, 0.4f, 1.0f);
    private static final Interpolator EXIT_MASK_ALPHA_ANIM_INTERPOLATOR = new PathInterpolator(0.3f, 0.15f, 0.3f, 1.0f);

    interface PanelFragmentAnimationListener {
        void onAnimationEnd();
    }

    private void ensurePanelView() {
        if (this.mPanelView == null) {
            this.mPanelView = (COUIPanelContentLayout) getLayoutInflater().inflate(this.mIsInTinyScreen ? g.f2427f : g.f2426e, (ViewGroup) null);
        }
    }

    private void setBottomButtonBar(String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        ensurePanelView();
        this.mPanelView.setUpBottomBar(true, str, onClickListener, str2, onClickListener2, str3, onClickListener3);
    }

    public Button getCenterButton() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mPanelView;
        if (cOUIPanelContentLayout != null) {
            return (Button) cOUIPanelContentLayout.findViewById(R.id.button3);
        }
        return null;
    }

    protected int getContentResId() {
        return f.f2413k;
    }

    public View getContentView() {
        return this.mContentView;
    }

    @Override // androidx.lifecycle.InterfaceC0271g
    public /* bridge */ /* synthetic */ H.a getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    public DialogInterface.OnKeyListener getDialogOnKeyListener() {
        return this.mDialogOnKeyListener;
    }

    public COUIPanelDragListener getDragPanelListener() {
        return this.mDragPanelListener;
    }

    protected View getDragView() {
        return this.mDragView;
    }

    public int getDragViewHeight() {
        View view = this.mDragView;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public COUIPanelContentLayout getDraggableLinearLayout() {
        return this.mPanelView;
    }

    public Button getLeftButton() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mPanelView;
        if (cOUIPanelContentLayout != null) {
            return (Button) cOUIPanelContentLayout.findViewById(R.id.button2);
        }
        return null;
    }

    public COUIBottomSheetDialog.OnBackInvokedLocalListener getOnBackInvokedLocalListener() {
        return this.mOnBackInvokedLocalListener;
    }

    public View.OnTouchListener getOutSideViewOnTouchListener() {
        return this.mOutSideViewOnTouchListener;
    }

    public COUIPanelBarView getPanelBarView() {
        return this.mPanelBarView;
    }

    public Button getRightButton() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mPanelView;
        if (cOUIPanelContentLayout != null) {
            return (Button) cOUIPanelContentLayout.findViewById(R.id.button1);
        }
        return null;
    }

    protected Boolean getShowOnFirstPanel() {
        return this.mIsShowOnFirstPanel;
    }

    public View getTitleView() {
        return this.mTitleView;
    }

    public COUIToolbar getToolbar() {
        return this.mToolbar;
    }

    public int getToolbarHeight() {
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null) {
            return cOUIToolbar.getHeight();
        }
        return 0;
    }

    public void hideDragView() {
        ViewGroup.LayoutParams layoutParams = getDragView().getLayoutParams();
        layoutParams.height = getDragView().getContext().getResources().getDimensionPixelSize(U1.d.f2392t);
        getDragView().setVisibility(4);
        getDragView().setLayoutParams(layoutParams);
    }

    public void initView(View view) {
    }

    public void onAbandon(Boolean bool) {
        setPanelDragListener(null);
        setDialogOnKeyListener(null);
        setOnBackInvokedLocalListener(null);
        setOutSideViewOnTouchListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.mIsShowOnFirstPanel = Boolean.valueOf(bundle.getBoolean(SAVE_IS_SHOW_IN_FIRST_PANEL_KEY, false));
            if (getParentFragment() instanceof COUIBottomSheetDialogFragment) {
                ((COUIBottomSheetDialogFragment) getParentFragment()).setPanelFragment(this, this.mIsShowOnFirstPanel);
            }
        }
        initView(this.mPanelView);
    }

    public void onAdd(Boolean bool) {
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i3, boolean z3, int i4) {
        final ValueAnimator valueAnimator;
        Animation animation;
        final Drawable drawable = getContext().getDrawable(U1.e.f2399a);
        drawable.setTint(AbstractC0335a.h(getContext(), M1.e.f1390f));
        drawable.setAlpha(0);
        if (i4 == M1.a.f1339d) {
            valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimator.setDuration(EXIT_MASK_ALPHA_ANIM_DURATION);
            valueAnimator.setInterpolator(EXIT_MASK_ALPHA_ANIM_INTERPOLATOR);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelFragment.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    drawable.setAlpha((int) (((Float) valueAnimator2.getAnimatedValue()).floatValue() * 255.0f));
                }
            });
            animation = AnimationUtils.loadAnimation(getContext(), i4);
        } else {
            valueAnimator = null;
            animation = null;
        }
        if (i4 == M1.a.f1336a) {
            valueAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimator.setDuration(ENTER_MASK_ALPHA_ANIM_DURATION);
            valueAnimator.setInterpolator(ENTER_MASK_ALPHA_ANIM_INTERPOLATOR);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelFragment.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    drawable.setAlpha((int) (((Float) valueAnimator2.getAnimatedValue()).floatValue() * 255.0f));
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelFragment.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (COUIPanelFragment.this.mPanelFragmentAnimationListener != null) {
                        COUIPanelFragment.this.mPanelFragmentAnimationListener.onAnimationEnd();
                    }
                }
            });
            animation = AnimationUtils.loadAnimation(getContext(), i4);
        }
        if (valueAnimator == null || animation == null) {
            return super.onCreateAnimation(i3, z3, i4);
        }
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.coui.appcompat.panel.COUIPanelFragment.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                COUIPanelFragment.this.mPanelView.setForeground(null);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                COUIPanelFragment.this.mPanelView.setForeground(drawable);
                valueAnimator.start();
            }
        });
        return animation;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            this.mIsInTinyScreen = bundle.getBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, false);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) getLayoutInflater().inflate(this.mIsInTinyScreen ? g.f2427f : g.f2426e, (ViewGroup) null);
        this.mPanelView = cOUIPanelContentLayout;
        cOUIPanelContentLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mDragView = this.mPanelView.getDragView();
        this.mPanelBarView = this.mPanelView.getPanelBarView();
        View inflate = layoutInflater.inflate(g.f2425d, viewGroup, false);
        this.mToolbar = (COUIToolbar) inflate.findViewById(f.f2404b);
        this.mTitleViewLayout = (FrameLayout) inflate.findViewById(f.f2418p);
        this.mContentView = inflate.findViewById(getContentResId());
        this.mPanelView.addContentView(inflate);
        return this.mPanelView;
    }

    public void onHide(Boolean bool) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(SAVE_IS_SHOW_IN_FIRST_PANEL_KEY, this.mIsShowOnFirstPanel.booleanValue());
        bundle.putBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, this.mIsInTinyScreen);
    }

    public void onShow(Boolean bool) {
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void setDialogOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mDialogOnKeyListener = onKeyListener;
    }

    public void setIsInTinyScreen(boolean z3) {
        this.mIsInTinyScreen = z3;
    }

    public void setOnBackInvokedLocalListener(COUIBottomSheetDialog.OnBackInvokedLocalListener onBackInvokedLocalListener) {
        this.mOnBackInvokedLocalListener = onBackInvokedLocalListener;
    }

    public void setOutSideViewOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOutSideViewOnTouchListener = onTouchListener;
    }

    public void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        this.mDragPanelListener = cOUIPanelDragListener;
    }

    public void setPanelFragmentAnimationListener(PanelFragmentAnimationListener panelFragmentAnimationListener) {
        this.mPanelFragmentAnimationListener = panelFragmentAnimationListener;
    }

    protected void setShowOnFirstPanel(Boolean bool) {
        this.mIsShowOnFirstPanel = bool;
    }

    public void setTitleView(int i3) {
        if (i3 > 0) {
            setTitleView(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this.mTitleViewLayout, false));
        }
    }

    public void setToolbar(COUIToolbar cOUIToolbar) {
        if (cOUIToolbar == null || this.mToolbar == null) {
            return;
        }
        this.mTitleViewLayout.setVisibility(8);
        this.mToolbar.setVisibility(0);
        this.mToolbar = cOUIToolbar;
    }

    public void showDragView() {
        ViewGroup.LayoutParams layoutParams = getDragView().getLayoutParams();
        layoutParams.height = getDragView().getContext().getResources().getDimensionPixelSize(U1.d.f2391s);
        getDragView().setVisibility(0);
        getDragView().setLayoutParams(layoutParams);
    }

    public void setTitleView(View view) {
        this.mTitleView = view;
        if (this.mTitleViewLayout == null || view == null || view.getVisibility() == 8) {
            return;
        }
        this.mToolbar.setVisibility(8);
        this.mTitleViewLayout.setVisibility(0);
        this.mTitleView = view;
        this.mTitleViewLayout.addView(view);
    }
}
