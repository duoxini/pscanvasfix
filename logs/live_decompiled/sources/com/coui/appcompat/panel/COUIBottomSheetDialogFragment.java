package com.coui.appcompat.panel;

import U1.f;
import U1.g;
import U1.h;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.l;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class COUIBottomSheetDialogFragment extends com.google.android.material.bottomsheet.b {
    private static final float PHYSICS_UNSET = Float.MIN_VALUE;
    private static final String SAVE_CAN_PULL_UP_KEY = "SAVE_CAN_PULL_UP_KEY_DRAGGABLE_KEY";
    private static final String SAVE_DRAGGABLE_KEY = "SAVE_DRAGGABLE_KEY";
    private static final String SAVE_FIRST_SHOW_COLLAPSED_KEY = "SAVE_FIRST_SHOW_COLLAPSED_KEY";
    private static final String SAVE_FRAME_RATE_KEY = "SAVE_FRAME_RATE_KEY";
    private static final String SAVE_HAS_SET_PEEK_HEIGHT_KEY = "SAVE_HAS_SET_PEEK_HEIGHT_KEY";
    private static final String SAVE_HAS_SET_SKIP_COLLAPSED_KEY = "SAVE_HAS_SET_SKIP_COLLAPSED_KEY";
    private static final String SAVE_IS_HANDLE_PANEL_KEY = "SAVE_IS_HANDLE_PANEL_KEY";
    private static final String SAVE_IS_IN_TINY_SCREEN_PANEL_KEY = "SAVE_IS_IN_TINY_SCREEN_PANEL_KEY";
    private static final String SAVE_PANEL_EDGE_TO_EDGE = "SAVE_PANEL_EDGE_TO_EDGE";
    private static final String SAVE_PANEL_HEIGHT_KEY = "SAVE_PANEL_HEIGHT_KEY";
    private static final String SAVE_PANEL_WIDTH_KEY = "SAVE_PANEL_WIDTH_KEY";
    private static final String SAVE_PEEK_HEIGHT_KEY = "SAVE_PEEK_HEIGHT_KEY";
    private static final String SAVE_REGISTER_CONFIGURATION_KEY = "SAVE_REGISTER_CONFIGURATION_KEY";
    private static final String SAVE_SHOW_IN_MAX_HEIGHT_KEY = "SAVE_SHOW_IN_MAX_HEIGHT_KEY";
    private static final String SAVE_SKIP_COLLAPSED_KEY = "SAVE_SKIP_COLLAPSED_KEY";
    private static final String SAVE_SUPPORT_EXIT_BLOCKING_ANIMATION = "SAVE_SUPPORT_EXIT_BLOCKING_ANIMATION";
    private static final String TAG = "COUIBottomSheetDialogFragment";
    private static final int UNSET_WIDTH = -1;

    @Deprecated
    private long mAlphaAnimDuration;
    private View mAnchorView;
    private BottomSheetBehavior<FrameLayout> mBehavior;
    private COUIBottomSheetDialog mBottomSheetDialog;
    private COUIBottomSheetDialog.BottomSheetDialogAnimatorListener mBottomSheetDialogAnimatorListener;
    private boolean mCanPullUp;
    private boolean mCouiPanelEdgeToEdgeEnable;
    private COUIPanelFragment mCurrentPanelFragment;
    private int mCurrentPanelHeight;
    private View mDialogFragmentView;
    private boolean mDisableSubExpand;

    @Deprecated
    private int mFinalNavColorAfterDismiss;
    private boolean mFirstShowCollapsed;
    private boolean mFrameRate;
    private boolean mGlobalDrag;
    private boolean mHasSetPeekHeight;
    private boolean mHasSetSkipCollapsed;
    private int mHideDragViewHeight;
    private InputMethodManager mInputMethodManager;
    private boolean mIsDraggable;

    @Deprecated
    private boolean mIsExecuteNavColorAnimAfterDismiss;
    private boolean mIsFullScreenInTinyScreen;
    private boolean mIsGestureNavigation;
    private boolean mIsHandlePanel;
    private boolean mIsInTinyScreen;
    private boolean mIsSavedInstanceState;
    private boolean mIsShowInMaxHeight;
    private OnDismissListener mOnDismissListener;
    private View mOutSideView;
    private ViewGroup mPanelContainer;
    private int mPanelHeight;
    private int mPanelWidth;
    private int mPeekHeight;
    private float mPhysicsDampingRatio;
    private float mPhysicsFrequency;
    private int mPreferWidth;
    private boolean mRegisterConfigurationChangeCallBack;
    private boolean mShouldRegisterWindowInsetsListener;
    private boolean mSkipCollapsed;
    private boolean mSupportExitBlockingAnimation;

    public interface OnDismissListener {
        void onDismiss();
    }

    public COUIBottomSheetDialogFragment() {
        this.mAlphaAnimDuration = 100L;
        this.mIsSavedInstanceState = false;
        this.mPeekHeight = 0;
        this.mSkipCollapsed = true;
        this.mFirstShowCollapsed = false;
        this.mIsDraggable = true;
        this.mCanPullUp = true;
        this.mIsShowInMaxHeight = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mPhysicsFrequency = PHYSICS_UNSET;
        this.mPhysicsDampingRatio = PHYSICS_UNSET;
        this.mAnchorView = null;
        this.mBottomSheetDialogAnimatorListener = null;
        this.mDisableSubExpand = false;
        this.mShouldRegisterWindowInsetsListener = true;
        this.mPreferWidth = -1;
        this.mHasSetPeekHeight = false;
        this.mHasSetSkipCollapsed = false;
        this.mIsHandlePanel = false;
        this.mHideDragViewHeight = 0;
        this.mFrameRate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFragmentHeight(Fragment fragment) {
        if (fragment == null || fragment.getView() == null) {
            return 0;
        }
        return fragment.getView().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        this.mInputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void initBottomSheetDialogSize() {
        int i3 = this.mPanelWidth;
        if (i3 != 0) {
            this.mBottomSheetDialog.setWidth(i3);
        }
        int i4 = this.mPanelHeight;
        if (i4 != 0) {
            this.mBottomSheetDialog.setHeight(i4);
            setCurrentPanelHeight(this.mPanelHeight);
        }
    }

    private void initFragment() {
        if (this.mCurrentPanelFragment != null) {
            if (!this.mIsSavedInstanceState) {
                getChildFragmentManager().m().p(f.f2412j, this.mCurrentPanelFragment).j();
            }
            COUIPanelFragment cOUIPanelFragment = this.mCurrentPanelFragment;
            Boolean bool = Boolean.TRUE;
            cOUIPanelFragment.setShowOnFirstPanel(bool);
            this.mCurrentPanelFragment.onAdd(bool);
            setUpViewHeight(this.mPanelContainer, this.mIsShowInMaxHeight);
        }
        this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (COUIBottomSheetDialogFragment.this.mCurrentPanelFragment == null) {
                    return;
                }
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment.mOutSideView = cOUIBottomSheetDialogFragment.mBottomSheetDialog.findViewById(f.f2420r);
                if (COUIBottomSheetDialogFragment.this.mOutSideView != null) {
                    COUIBottomSheetDialogFragment.this.mOutSideView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.1.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent != null && motionEvent.getAction() == 1) {
                                COUIBottomSheetDialogFragment.this.mBottomSheetDialog.dismiss();
                            }
                            return true;
                        }
                    });
                }
                COUIBottomSheetDialogFragment.this.mIsSavedInstanceState = false;
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2 = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment2.setPanelListener(cOUIBottomSheetDialogFragment2.mCurrentPanelFragment);
                COUIBottomSheetDialogFragment.this.mBottomSheetDialog.setDragableLinearLayout(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getDraggableLinearLayout(), false);
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onShow(Boolean.TRUE);
            }
        });
    }

    private void preShowPanel(final COUIPanelFragment cOUIPanelFragment) {
        if (!getChildFragmentManager().r0().contains(cOUIPanelFragment) && !cOUIPanelFragment.isAdded()) {
            getChildFragmentManager().m().s(M1.a.f1338c, M1.a.f1339d, M1.a.f1336a, M1.a.f1337b).n(this.mCurrentPanelFragment).b(f.f2412j, cOUIPanelFragment).h();
            cOUIPanelFragment.onAdd(Boolean.FALSE);
        }
        getChildFragmentManager().m().s(M1.a.f1338c, M1.a.f1339d, M1.a.f1336a, M1.a.f1337b).n(this.mCurrentPanelFragment).u(cOUIPanelFragment).g(null).h();
        if (this.mBottomSheetDialog.getAdjustResizeHelper() != null) {
            this.mBottomSheetDialog.getAdjustResizeHelper().recoveryScrollingParentViewPaddingBottom(this.mCurrentPanelFragment.getDraggableLinearLayout());
        }
        this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.4
            @Override // java.lang.Runnable
            public void run() {
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onHide(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getShowOnFirstPanel());
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment = cOUIPanelFragment;
                COUIBottomSheetDialogFragment.this.mBottomSheetDialog.setDragableLinearLayout(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getDraggableLinearLayout(), true);
                COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onShow(Boolean.FALSE);
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment.setPanelListener(cOUIBottomSheetDialogFragment.mCurrentPanelFragment);
            }
        });
    }

    private void setDialogOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnKeyListener(onKeyListener);
        }
    }

    private void setOnBackInvokedLocalListener(COUIBottomSheetDialog.OnBackInvokedLocalListener onBackInvokedLocalListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnBackInvokedLocalListener(onBackInvokedLocalListener);
        }
    }

    private void setOnTouchOutSideViewListener(View.OnTouchListener onTouchListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOutSideViewTouchListener(onTouchListener);
        }
    }

    private void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog == null || !(cOUIBottomSheetDialog.getBehavior() instanceof COUIBottomSheetBehavior)) {
            return;
        }
        ((COUIBottomSheetBehavior) this.mBottomSheetDialog.getBehavior()).setPanelDragListener(cOUIPanelDragListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelListener(COUIPanelFragment cOUIPanelFragment) {
        if (cOUIPanelFragment != null) {
            setPanelDragListener(cOUIPanelFragment.getDragPanelListener());
            setOnTouchOutSideViewListener(cOUIPanelFragment.getOutSideViewOnTouchListener());
            setDialogOnKeyListener(cOUIPanelFragment.getDialogOnKeyListener());
            setOnBackInvokedLocalListener(cOUIPanelFragment.getOnBackInvokedLocalListener());
        }
    }

    private void setUpViewHeight(View view, boolean z3) {
        if (view != null) {
            int i3 = (z3 || this.mPanelHeight != 0) ? -1 : -2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    public void backToFirstPanel() {
        if (this.mCurrentPanelFragment != null) {
            setCancelable(false);
            hideKeyboard(this.mDialogFragmentView);
            final int indexOf = getChildFragmentManager().r0().indexOf(this.mCurrentPanelFragment);
            final COUIPanelFragment cOUIPanelFragment = this.mCurrentPanelFragment;
            if (indexOf > 0) {
                getChildFragmentManager().m().r(M1.a.f1336a, M1.a.f1337b).u((COUIPanelFragment) getChildFragmentManager().r0().get(indexOf - 1)).n(this.mCurrentPanelFragment).j();
            }
            if (this.mBottomSheetDialog.getAdjustResizeHelper() != null) {
                this.mBottomSheetDialog.getAdjustResizeHelper().recoveryScrollingParentViewPaddingBottom(this.mCurrentPanelFragment.getDraggableLinearLayout());
            }
            this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (indexOf > 0) {
                        COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onHide(Boolean.FALSE);
                        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                        cOUIBottomSheetDialogFragment.mCurrentPanelFragment = (COUIPanelFragment) cOUIBottomSheetDialogFragment.getChildFragmentManager().r0().get(indexOf - 1);
                        COUIBottomSheetDialogFragment.this.mBottomSheetDialog.setDragableLinearLayout(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getDraggableLinearLayout(), true);
                        COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.onShow(COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.getShowOnFirstPanel());
                        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2 = COUIBottomSheetDialogFragment.this;
                        cOUIBottomSheetDialogFragment2.setPanelListener(cOUIBottomSheetDialogFragment2.mCurrentPanelFragment);
                        COUIBottomSheetDialogFragment.this.mCurrentPanelFragment.setPanelFragmentAnimationListener(new COUIPanelFragment.PanelFragmentAnimationListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.2.1
                            @Override // com.coui.appcompat.panel.COUIPanelFragment.PanelFragmentAnimationListener
                            public void onAnimationEnd() {
                                if (cOUIPanelFragment.isAdded()) {
                                    cOUIPanelFragment.onAbandon(Boolean.FALSE);
                                    COUIBottomSheetDialogFragment.this.getChildFragmentManager().m().o(cOUIPanelFragment).i();
                                }
                            }
                        });
                    }
                }
            });
            this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    COUIBottomSheetDialogFragment.this.setCancelable(true);
                }
            });
        }
    }

    public void delPreferWidth() {
        this.mPreferWidth = -1;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.delPreferWidth();
        }
        Log.d(TAG, "delPreferWidth");
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.fragment.app.d
    public void dismiss() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss();
            if (this.mPreferWidth != -1) {
                this.mBottomSheetDialog.delPreferWidth();
                return;
            }
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e3) {
            Log.e(TAG, e3.getMessage(), e3);
        }
    }

    public void doFeedbackAnimation() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.doFeedbackAnimation();
        }
    }

    @Deprecated
    public long getAlphaAnimDuration() {
        return this.mAlphaAnimDuration;
    }

    public COUIBottomSheetDialog getBottomSheetDialog() {
        return this.mBottomSheetDialog;
    }

    public int getCurrentPanelHeight() {
        return this.mCurrentPanelHeight;
    }

    @Override // androidx.lifecycle.InterfaceC0271g
    public /* bridge */ /* synthetic */ H.a getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    public boolean getIsHandlePanel() {
        return this.mIsHandlePanel;
    }

    public int getPeekHeight() {
        return this.mPeekHeight;
    }

    public boolean isFirstShowCollapsed() {
        return this.mFirstShowCollapsed;
    }

    public boolean isSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mBottomSheetDialog == null || this.mCurrentPanelHeight == 0 || getContext() == null) {
            return;
        }
        this.mBottomSheetDialog.setHeight(Math.min(this.mCurrentPanelHeight, COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), configuration)));
        this.mBottomSheetDialog.updateLayoutWhileConfigChange(configuration);
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.k, androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.mIsSavedInstanceState = true;
            this.mIsInTinyScreen = bundle.getBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, false);
            this.mIsDraggable = bundle.getBoolean(SAVE_DRAGGABLE_KEY, true);
            this.mPeekHeight = bundle.getInt(SAVE_PEEK_HEIGHT_KEY, 0);
            this.mSkipCollapsed = bundle.getBoolean(SAVE_SKIP_COLLAPSED_KEY, true);
            this.mFirstShowCollapsed = bundle.getBoolean(SAVE_FIRST_SHOW_COLLAPSED_KEY, false);
            this.mCanPullUp = bundle.getBoolean(SAVE_CAN_PULL_UP_KEY, true);
            this.mIsShowInMaxHeight = bundle.getBoolean(SAVE_SHOW_IN_MAX_HEIGHT_KEY, false);
            this.mRegisterConfigurationChangeCallBack = bundle.getBoolean(SAVE_REGISTER_CONFIGURATION_KEY, true);
            this.mIsHandlePanel = bundle.getBoolean(SAVE_IS_HANDLE_PANEL_KEY, false);
            this.mHasSetPeekHeight = bundle.getBoolean(SAVE_HAS_SET_PEEK_HEIGHT_KEY, false);
            this.mHasSetSkipCollapsed = bundle.getBoolean(SAVE_HAS_SET_SKIP_COLLAPSED_KEY, false);
            this.mFrameRate = bundle.getBoolean(SAVE_FRAME_RATE_KEY, true);
            this.mCouiPanelEdgeToEdgeEnable = bundle.getBoolean(SAVE_PANEL_EDGE_TO_EDGE, false);
            this.mSupportExitBlockingAnimation = bundle.getBoolean(SAVE_SUPPORT_EXIT_BLOCKING_ANIMATION, false);
        }
        boolean isGestureNavigation = COUINavigationBarUtil.isGestureNavigation(requireContext());
        this.mIsGestureNavigation = isGestureNavigation;
        if (this.mIsHandlePanel) {
            if (!this.mHasSetPeekHeight) {
                if (isGestureNavigation) {
                    this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(U1.d.f2388p);
                } else {
                    this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(U1.d.f2387o);
                }
            }
            if (!this.mHasSetSkipCollapsed) {
                this.mSkipCollapsed = false;
            }
        }
        if (getActivity() != null) {
            COUIBottomSheetDialog cOUIBottomSheetDialog = new COUIBottomSheetDialog(getActivity(), h.f2430c, this.mPhysicsFrequency, this.mPhysicsDampingRatio);
            this.mBottomSheetDialog = cOUIBottomSheetDialog;
            View view = this.mAnchorView;
            if (view != null) {
                cOUIBottomSheetDialog.setAnchorView(view);
            }
            this.mBottomSheetDialog.setIsInTinyScreen(this.mIsInTinyScreen, this.mIsFullScreenInTinyScreen);
            this.mBottomSheetDialog.setDisableSubExpand(this.mDisableSubExpand);
            this.mBottomSheetDialog.setBottomSheetDialogAnimatorListener(this.mBottomSheetDialogAnimatorListener);
        }
        this.mBottomSheetDialog.setShouldRegisterWindowInsetsListener(this.mShouldRegisterWindowInsetsListener);
        this.mBottomSheetDialog.setShowInDialogFragment(true);
        this.mBottomSheetDialog.setPeekHeight(this.mPeekHeight);
        this.mBottomSheetDialog.setIsHandlePanel(this.mIsHandlePanel);
        this.mBottomSheetDialog.setSkipCollapsed(this.mSkipCollapsed);
        this.mBottomSheetDialog.setFirstShowCollapsed(this.mFirstShowCollapsed);
        this.mBottomSheetDialog.setCanPullUp(this.mCanPullUp);
        this.mBottomSheetDialog.setIsShowInMaxHeight(this.mIsShowInMaxHeight);
        this.mBottomSheetDialog.setFrameRate(this.mFrameRate);
        this.mBottomSheetDialog.setCouiPanelEdgeToEdgeEnable(this.mCouiPanelEdgeToEdgeEnable);
        this.mBottomSheetDialog.setSupportExitBlockingAnimation(this.mSupportExitBlockingAnimation);
        this.mBottomSheetDialog.setRegisterConfigurationChangeCallBack(this.mRegisterConfigurationChangeCallBack);
        this.mBottomSheetDialog.setHideDragViewHeight(this.mHideDragViewHeight);
        int i3 = this.mPreferWidth;
        if (i3 != -1) {
            this.mBottomSheetDialog.setPreferWidth(i3);
        }
        initBottomSheetDialogSize();
        BottomSheetBehavior<FrameLayout> behavior = this.mBottomSheetDialog.getBehavior();
        this.mBehavior = behavior;
        behavior.setDraggable(this.mIsDraggable);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) bottomSheetBehavior).setGlobalDrag(this.mGlobalDrag);
        }
        return this.mBottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mIsShowInMaxHeight) {
            this.mDialogFragmentView = View.inflate(getActivity(), g.f2423b, null);
        } else {
            this.mDialogFragmentView = View.inflate(getActivity(), g.f2422a, null);
        }
        return this.mDialogFragmentView;
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        COUIPanelFragment cOUIPanelFragment = this.mCurrentPanelFragment;
        if (cOUIPanelFragment != null) {
            cOUIPanelFragment.onAbandon(cOUIPanelFragment.getShowOnFirstPanel());
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnKeyListener(null);
            this.mBottomSheetDialog.setOnBackInvokedLocalListener(null);
            this.mBottomSheetDialog.setOutSideViewTouchListener(null);
            OnDismissListener onDismissListener = this.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) bottomSheetBehavior).setPanelDragListener(null);
        }
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SAVE_PANEL_HEIGHT_KEY, this.mPanelHeight);
        bundle.putInt(SAVE_PANEL_WIDTH_KEY, this.mPanelWidth);
        bundle.putBoolean(SAVE_DRAGGABLE_KEY, this.mIsDraggable);
        bundle.putInt(SAVE_PEEK_HEIGHT_KEY, this.mPeekHeight);
        bundle.putBoolean(SAVE_SKIP_COLLAPSED_KEY, this.mSkipCollapsed);
        bundle.putBoolean(SAVE_FIRST_SHOW_COLLAPSED_KEY, this.mFirstShowCollapsed);
        bundle.putBoolean(SAVE_CAN_PULL_UP_KEY, this.mCanPullUp);
        bundle.putBoolean(SAVE_SHOW_IN_MAX_HEIGHT_KEY, this.mIsShowInMaxHeight);
        bundle.putBoolean(SAVE_IS_IN_TINY_SCREEN_PANEL_KEY, this.mIsInTinyScreen);
        bundle.putBoolean(SAVE_REGISTER_CONFIGURATION_KEY, this.mRegisterConfigurationChangeCallBack);
        bundle.putBoolean(SAVE_IS_HANDLE_PANEL_KEY, this.mIsHandlePanel);
        bundle.putBoolean(SAVE_HAS_SET_PEEK_HEIGHT_KEY, this.mHasSetPeekHeight);
        bundle.putBoolean(SAVE_HAS_SET_SKIP_COLLAPSED_KEY, this.mHasSetSkipCollapsed);
        bundle.putBoolean(SAVE_FRAME_RATE_KEY, this.mFrameRate);
        bundle.putBoolean(SAVE_PANEL_EDGE_TO_EDGE, this.mCouiPanelEdgeToEdgeEnable);
        bundle.putBoolean(SAVE_SUPPORT_EXIT_BLOCKING_ANIMATION, this.mSupportExitBlockingAnimation);
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.f() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.5
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
                public void onSlide(View view, float f3) {
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
                public void onStateChanged(View view, int i3) {
                    if (i3 == 5) {
                        COUIBottomSheetDialogFragment.this.dismissAllowingStateLoss();
                    }
                    if (i3 == 2 && ((COUIBottomSheetBehavior) COUIBottomSheetDialogFragment.this.mBehavior).isCanHideKeyboard()) {
                        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                        cOUIBottomSheetDialogFragment.hideKeyboard(cOUIBottomSheetDialogFragment.mDialogFragmentView);
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            this.mInputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        }
        ViewGroup viewGroup = (ViewGroup) this.mDialogFragmentView.findViewById(f.f2412j);
        this.mPanelContainer = viewGroup;
        if (viewGroup == null) {
            return;
        }
        if (bundle != null) {
            this.mIsSavedInstanceState = true;
            this.mPanelHeight = bundle.getInt(SAVE_PANEL_HEIGHT_KEY, 0);
            this.mPanelWidth = bundle.getInt(SAVE_PANEL_WIDTH_KEY, 0);
            initBottomSheetDialogSize();
        }
        initFragment();
    }

    public void replacePanelFragment(COUIPanelFragment cOUIPanelFragment) {
        if (cOUIPanelFragment == null || this.mPanelContainer == null) {
            return;
        }
        if (this.mBottomSheetDialog.getAdjustResizeHelper() != null) {
            this.mBottomSheetDialog.getAdjustResizeHelper().setIgnoreHideKeyboardAnim(true);
        }
        hideKeyboard(this.mDialogFragmentView);
        preShowPanel(cOUIPanelFragment);
    }

    @Deprecated
    public void setAlphaAnimDuration(long j3) {
        this.mAlphaAnimDuration = j3;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog == null || view == null) {
            return;
        }
        cOUIBottomSheetDialog.setAnchorView(view);
    }

    public void setBottomSheetDialogAnimatorListener(COUIBottomSheetDialog.BottomSheetDialogAnimatorListener bottomSheetDialogAnimatorListener) {
        this.mBottomSheetDialogAnimatorListener = bottomSheetDialogAnimatorListener;
    }

    public void setCanPullUp(boolean z3) {
        this.mCanPullUp = z3;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setCanPullUp(z3);
        }
    }

    public void setCouiPanelEdgeToEdgeEnable(boolean z3) {
        this.mCouiPanelEdgeToEdgeEnable = z3;
    }

    void setCurrentPanelHeight(int i3) {
        this.mCurrentPanelHeight = i3;
    }

    public void setDisableSubExpand(boolean z3) {
        this.mDisableSubExpand = z3;
    }

    public void setDraggable(boolean z3) {
        if (this.mIsDraggable != z3) {
            this.mIsDraggable = z3;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.mBehavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setDraggable(z3);
            }
        }
    }

    @Deprecated
    public void setExecuteNavColorAnimAfterDismiss(boolean z3) {
        this.mIsExecuteNavColorAnimAfterDismiss = z3;
        if (getDialog() instanceof COUIBottomSheetDialog) {
            ((COUIBottomSheetDialog) getDialog()).setExecuteNavColorAnimAfterDismiss(z3);
        }
    }

    @Deprecated
    public void setFinalNavColorAfterDismiss(int i3) {
        this.mFinalNavColorAfterDismiss = i3;
        if (getDialog() instanceof COUIBottomSheetDialog) {
            ((COUIBottomSheetDialog) getDialog()).setFinalNavColorAfterDismiss(i3);
        }
    }

    public void setFirstShowCollapsed(boolean z3) {
        this.mFirstShowCollapsed = z3;
    }

    public void setFrameRate(boolean z3) {
        this.mFrameRate = z3;
    }

    public void setGlobalDrag(boolean z3) {
        this.mGlobalDrag = z3;
    }

    public void setHeight(int i3) {
        this.mPanelHeight = i3;
        if (this.mBottomSheetDialog != null) {
            initBottomSheetDialogSize();
        }
        if (this.mCurrentPanelFragment != null) {
            setUpViewHeight(this.mPanelContainer, this.mIsShowInMaxHeight);
        }
    }

    public void setHideDragViewHeight(int i3) {
        this.mHideDragViewHeight = i3;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setHideDragViewHeight(i3);
        }
    }

    public void setIsHandlePanel(boolean z3) {
        this.mIsHandlePanel = z3;
    }

    public void setIsInTinyScreen(boolean z3, boolean z4) {
        this.mIsInTinyScreen = z3;
        this.mIsFullScreenInTinyScreen = z4;
        if (z3) {
            setIsShowInMaxHeight(true);
        }
    }

    public void setIsShowInMaxHeight(boolean z3) {
        this.mIsShowInMaxHeight = z3;
    }

    public void setMainPanelFragment(COUIPanelFragment cOUIPanelFragment) {
        this.mCurrentPanelFragment = cOUIPanelFragment;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    void setPanelFragment(final COUIPanelFragment cOUIPanelFragment, Boolean bool) {
        this.mCurrentPanelFragment = cOUIPanelFragment;
        this.mBottomSheetDialog.setDragableLinearLayout(cOUIPanelFragment.getDraggableLinearLayout(), true);
        this.mPanelContainer.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialogFragment.6
            @Override // java.lang.Runnable
            public void run() {
                COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = COUIBottomSheetDialogFragment.this;
                cOUIBottomSheetDialogFragment.mCurrentPanelHeight = cOUIBottomSheetDialogFragment.getFragmentHeight(cOUIPanelFragment);
            }
        });
        setUpViewHeight(this.mPanelContainer, this.mIsShowInMaxHeight);
    }

    public void setPeekHeight(int i3) {
        this.mPeekHeight = i3;
        this.mHasSetPeekHeight = true;
    }

    public void setPreferWidth(int i3) {
        this.mPreferWidth = i3;
        Log.d(TAG, "setPreferWidth =：" + this.mPreferWidth);
    }

    public void setShouldRegisterWindowInsetsListener(boolean z3) {
        this.mShouldRegisterWindowInsetsListener = z3;
    }

    public void setSkipCollapsed(boolean z3) {
        this.mSkipCollapsed = z3;
        this.mHasSetSkipCollapsed = true;
    }

    public void setSupportExitBlockingAnimation(boolean z3) {
        if (this.mSupportExitBlockingAnimation != z3) {
            this.mSupportExitBlockingAnimation = z3;
            COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
            if (cOUIBottomSheetDialog != null) {
                cOUIBottomSheetDialog.setSupportExitBlockingAnimation(z3);
            }
        }
    }

    public void setWidth(int i3) {
        this.mPanelWidth = i3;
        if (this.mBottomSheetDialog != null) {
            initBottomSheetDialogSize();
        }
    }

    @Override // androidx.fragment.app.d
    public void show(l lVar, String str) {
        show(lVar, str, null);
    }

    public boolean updateFollowHandPanelLocation() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog == null) {
            return false;
        }
        return cOUIBottomSheetDialog.updateFollowHandPanelLocation();
    }

    public void show(l lVar, String str, View view) {
        COUIBottomSheetDialog cOUIBottomSheetDialog;
        if (isAdded()) {
            return;
        }
        int i3 = this.mPreferWidth;
        if (i3 != -1 && (cOUIBottomSheetDialog = this.mBottomSheetDialog) != null) {
            cOUIBottomSheetDialog.setPreferWidth(i3);
        }
        if (this.mCurrentPanelFragment == null) {
            this.mCurrentPanelFragment = new COUIPanelFragment();
        }
        this.mCurrentPanelFragment.setIsInTinyScreen(this.mIsInTinyScreen);
        this.mAnchorView = view;
        super.show(lVar, str);
    }

    public void dismiss(boolean z3) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.mBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss(z3);
            if (this.mPreferWidth != -1) {
                this.mBottomSheetDialog.delPreferWidth();
                return;
            }
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e3) {
            Log.e(TAG, e3.getMessage(), e3);
        }
    }

    public COUIBottomSheetDialogFragment(float f3, float f4) {
        this.mAlphaAnimDuration = 100L;
        this.mIsSavedInstanceState = false;
        this.mPeekHeight = 0;
        this.mSkipCollapsed = true;
        this.mFirstShowCollapsed = false;
        this.mIsDraggable = true;
        this.mCanPullUp = true;
        this.mIsShowInMaxHeight = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mAnchorView = null;
        this.mBottomSheetDialogAnimatorListener = null;
        this.mDisableSubExpand = false;
        this.mShouldRegisterWindowInsetsListener = true;
        this.mPreferWidth = -1;
        this.mHasSetPeekHeight = false;
        this.mHasSetSkipCollapsed = false;
        this.mIsHandlePanel = false;
        this.mHideDragViewHeight = 0;
        this.mFrameRate = true;
        this.mPhysicsFrequency = f3;
        this.mPhysicsDampingRatio = f4;
    }
}
