package com.oplus.flexibletask.setting.fragment;

import B1.s;
import android.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.preference.Preference;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIRecommendedPreference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.flexibletask.setting.OperationActivity;
import com.oplus.flexibletask.setting.SupportGameListActivity;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import com.oplus.framework.flags.Flags;
import f0.C0350b;
import java.util.HashMap;
import t1.j;
import t1.l;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SettingFragment extends com.coui.appcompat.preference.h {
    private static final int ANIM_VIEW_HEIGHT = 240;
    private static final int ANIM_VIEW_HEIGHT_FOLD = 179;
    private static final int ANIM_VIEW_HEIGHT_PAD = 178;
    private static final String CPN_SMART_SIDEBAR = "com.oplus.smartsidebar.settings.EdgePanelSettingsActivity";
    private static final boolean ENABLE_SOFTWARE_CONFIDENTIAL = Flags.coloros1502ConfidentialPagani();
    private static final int FREEFORM_GESTURE_MODE = 1;
    private static final String PKG_SMART_SIDEBAR = "com.coloros.smartsidebar";
    private static final String TAG = "SettingFragment";
    private Context mContext;
    private int mCurrentMode;
    private boolean mIsFoldFrontScreen;
    private boolean mPreferenceHighlighted;
    private CharSequence mModeSwitchTitle = null;
    private Dialog mModeChooseBottomDialog = null;
    private COUIJumpPreference mModePreference = null;
    private COUIJumpPreference mTutorialPreference = null;
    private COUIRecommendedPreference mRecommendedPreference = null;
    private COUISwitchPreference mSharePreference = null;
    private COUISwitchPreference mLightOpenPreference = null;
    private COUISwitchPreference mExchangeApplication = null;
    private COUISwitchPreference mAlphaAdjust = null;
    private ScollViewListener mScrollViewListener = null;

    class ScollViewListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final View mTargetView;

        ScollViewListener(View view) {
            this.mTargetView = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height;
            View view = this.mTargetView;
            if (view == null || !view.isAttachedToWindow() || SettingFragment.this.getActivity() == null || this.mTargetView.getHeight() <= (height = (int) (SettingFragment.this.getActivity().getWindowManager().getCurrentWindowMetrics().getBounds().height() * 0.7d))) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.mTargetView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            layoutParams.height = height;
            this.mTargetView.setLayoutParams(layoutParams);
        }

        void unregister() {
            View view = this.mTargetView;
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    private void adjustParamForAnimView(EffectiveAnimationView effectiveAnimationView, EffectiveAnimationView effectiveAnimationView2, boolean z3) {
        int i3;
        int i4;
        int a3;
        if (FlexibleSettingHelper.getInstance().isPadScreen()) {
            if (z3) {
                i3 = t1.i.f13579p;
                i4 = t1.i.f13488B;
            } else {
                i3 = t1.i.f13577o;
                i4 = t1.i.f13486A;
            }
            a3 = s.a(this.mContext, 178.0f);
        } else if (!FlexibleSettingHelper.getInstance().isFoldScreen() || FlexibleSettingHelper.getInstance().isFlip()) {
            if (z3) {
                i3 = t1.i.f13571l;
                i4 = t1.i.f13595x;
            } else {
                i3 = t1.i.f13568k;
                i4 = t1.i.f13593w;
            }
            a3 = s.a(this.mContext, 240.0f);
        } else {
            if (z3) {
                i3 = t1.i.f13575n;
                i4 = t1.i.f13599z;
            } else {
                i3 = t1.i.f13573m;
                i4 = t1.i.f13597y;
            }
            a3 = s.a(this.mContext, 179.0f);
        }
        effectiveAnimationView.setAnimation(i3);
        effectiveAnimationView2.setAnimation(i4);
        effectiveAnimationView.setRepeatCount(-1);
        effectiveAnimationView2.setRepeatCount(-1);
        ViewGroup.LayoutParams layoutParams = effectiveAnimationView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = effectiveAnimationView2.getLayoutParams();
        layoutParams.height = a3;
        layoutParams2.height = a3;
        effectiveAnimationView.setLayoutParams(layoutParams);
        effectiveAnimationView2.setLayoutParams(layoutParams2);
    }

    private void changeAlphaAdjustBehavior(int i3) {
        Context context = this.mContext;
        if (context == null) {
            AbstractC0652e.j(TAG, "changeAlphaAdjustBehavior fail for context is null");
            return;
        }
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_ALPHA_ADJUST, i3);
        AbstractC0652e.b(TAG, "Change alpha adjust behavior to " + i3);
    }

    private void changeExchangeApplicationBehavior(int i3) {
        Context context = this.mContext;
        if (context == null) {
            AbstractC0652e.j(TAG, "changeExchangeApplicationBehavior fail for context is null");
            return;
        }
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_EXCHANGE_APPLICATION, i3);
        AbstractC0652e.b(TAG, "Change exchange application behavior to " + i3);
    }

    private void changeLightOpenBehavior(int i3) {
        Context context = this.mContext;
        if (context == null) {
            AbstractC0652e.j(TAG, "changeLightOpenBehavior fail for context is null");
            return;
        }
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_GAME_REDIRECT_BEHAVIOR, i3);
        AbstractC0652e.b(TAG, "Change light open behavior to " + i3);
    }

    private void changeShareBehavior(int i3) {
        Context context = this.mContext;
        if (context == null) {
            AbstractC0652e.j(TAG, "changeShareBehavior fail for context is null");
            return;
        }
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_SHARE_BEHAVIOR, i3);
        AbstractC0652e.b(TAG, "Change share behavior to " + i3);
        HashMap hashMap = new HashMap();
        hashMap.put("status", i3 == 1 ? "true" : "false");
        E1.i.m(this.mContext, "001", "simple_share_switch", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSimpleModeBehavior(int i3) {
        Context context = this.mContext;
        if (context == null) {
            AbstractC0652e.j(TAG, "changeSimpleModeBehavior fail for context is null");
            return;
        }
        Settings.System.putInt(context.getContentResolver(), FlexibleSettingHelper.ZOOM_SIMPLE_MODE, i3);
        AbstractC0652e.b(TAG, "Change SimpleMode to " + i3);
    }

    @SuppressLint({"ResourceType"})
    private void createModeChooseBottomDialog(COUIJumpPreference cOUIJumpPreference) {
        Dialog dialog = this.mModeChooseBottomDialog;
        if (dialog == null || !dialog.isShowing()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(t1.h.f13479l, (ViewGroup) null);
            if (inflate != null) {
                EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) inflate.findViewById(t1.f.f13448h);
                EffectiveAnimationView effectiveAnimationView2 = (EffectiveAnimationView) inflate.findViewById(t1.f.f13422B);
                RadioGroup radioGroup = (RadioGroup) inflate.findViewById(t1.f.f13428H);
                RadioButton radioButton = (RadioButton) inflate.findViewById(t1.f.f13449i);
                RadioButton radioButton2 = (RadioButton) inflate.findViewById(t1.f.f13423C);
                boolean z3 = false;
                if (inflate.getContext() != null && (inflate.getContext().getResources().getConfiguration().uiMode & 32) != 0) {
                    z3 = true;
                }
                if (effectiveAnimationView != null && effectiveAnimationView2 != null && radioGroup != null && radioButton != null && radioButton2 != null) {
                    adjustParamForAnimView(effectiveAnimationView, effectiveAnimationView2, z3);
                    radioGroup.check(this.mCurrentMode == 1 ? t1.f.f13423C : t1.f.f13449i);
                    if (this.mCurrentMode == 1) {
                        effectiveAnimationView2.v();
                        this.mModeSwitchTitle = getString(j.f13663s);
                    } else {
                        effectiveAnimationView.v();
                        this.mModeSwitchTitle = getString(j.f13651m);
                    }
                    setAnimationViewListener(radioGroup, effectiveAnimationView, effectiveAnimationView2, radioButton, radioButton2);
                }
                this.mScrollViewListener = new ScollViewListener(inflate);
                inflate.getViewTreeObserver().addOnGlobalLayoutListener(this.mScrollViewListener);
            }
            androidx.appcompat.app.c create = new C0350b(this.mContext, P1.f.f1835d).setTitle(getString(j.f13653n)).setView(inflate).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.ok, setPositiveButtonListener(cOUIJumpPreference)).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.oplus.flexibletask.setting.fragment.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    SettingFragment.this.lambda$createModeChooseBottomDialog$7(dialogInterface);
                }
            }).create();
            this.mModeChooseBottomDialog = create;
            create.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initPreference() {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.flexibletask.setting.fragment.SettingFragment.initPreference():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createModeChooseBottomDialog$7(DialogInterface dialogInterface) {
        unregisterScrollViewListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPreference$0(Preference preference) {
        createModeChooseBottomDialog(this.mModePreference);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPreference$1(Preference preference) {
        startActivity(new Intent(this.mContext, (Class<?>) OperationActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPreference$2(Preference preference, Object obj) {
        changeShareBehavior(((Boolean) obj).booleanValue() ? 1 : 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPreference$3(Preference preference, Object obj) {
        changeExchangeApplicationBehavior(((Boolean) obj).booleanValue() ? 1 : 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPreference$4(Preference preference, Object obj) {
        changeAlphaAdjustBehavior(((Boolean) obj).booleanValue() ? 1 : 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPreference$5() {
        startActivity(new Intent(this.mContext, (Class<?>) SupportGameListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPreference$6(Preference preference, Object obj) {
        changeLightOpenBehavior(((Boolean) obj).booleanValue() ? 1 : 0);
        return true;
    }

    private void setAnimationViewListener(RadioGroup radioGroup, final EffectiveAnimationView effectiveAnimationView, final EffectiveAnimationView effectiveAnimationView2, final RadioButton radioButton, final RadioButton radioButton2) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.oplus.flexibletask.setting.fragment.SettingFragment.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            @SuppressLint({"NonConstantResourceId", "ResourceAsColor"})
            public void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                if (i3 == t1.f.f13449i) {
                    SettingFragment.this.mModeSwitchTitle = radioButton.getText();
                    effectiveAnimationView.v();
                    effectiveAnimationView2.i();
                    effectiveAnimationView2.setProgress(0.0f);
                    return;
                }
                if (i3 == t1.f.f13423C) {
                    SettingFragment.this.mModeSwitchTitle = radioButton2.getText();
                    effectiveAnimationView2.v();
                    effectiveAnimationView.i();
                    effectiveAnimationView.setProgress(0.0f);
                }
            }
        });
        effectiveAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.flexibletask.setting.fragment.SettingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SettingFragment.this.mModeSwitchTitle == null || !SettingFragment.this.mModeSwitchTitle.equals(radioButton.getText())) {
                    SettingFragment.this.mModeSwitchTitle = radioButton.getText();
                    effectiveAnimationView.v();
                    effectiveAnimationView2.i();
                    effectiveAnimationView2.setProgress(0.0f);
                    radioButton.setChecked(true);
                }
            }
        });
        effectiveAnimationView2.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.flexibletask.setting.fragment.SettingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SettingFragment.this.mModeSwitchTitle == null || !SettingFragment.this.mModeSwitchTitle.equals(radioButton2.getText())) {
                    SettingFragment.this.mModeSwitchTitle = radioButton2.getText();
                    effectiveAnimationView2.v();
                    effectiveAnimationView.i();
                    effectiveAnimationView.setProgress(0.0f);
                    radioButton2.setChecked(true);
                }
            }
        });
    }

    private DialogInterface.OnClickListener setPositiveButtonListener(final COUIJumpPreference cOUIJumpPreference) {
        return new DialogInterface.OnClickListener() { // from class: com.oplus.flexibletask.setting.fragment.SettingFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (SettingFragment.this.mModeSwitchTitle == null || cOUIJumpPreference.getAssignment() == null || cOUIJumpPreference.getAssignment().equals(SettingFragment.this.mModeSwitchTitle)) {
                    return;
                }
                cOUIJumpPreference.setAssignment(SettingFragment.this.mModeSwitchTitle);
                SettingFragment settingFragment = SettingFragment.this;
                settingFragment.mCurrentMode = 1 - settingFragment.mCurrentMode;
                SettingFragment settingFragment2 = SettingFragment.this;
                settingFragment2.changeSimpleModeBehavior(settingFragment2.mCurrentMode);
                SettingFragment.this.updatePreference();
                SettingFragment.this.mModeSwitchTitle = null;
            }
        };
    }

    private void unregisterScrollViewListener() {
        ScollViewListener scollViewListener = this.mScrollViewListener;
        if (scollViewListener != null) {
            scollViewListener.unregister();
            this.mScrollViewListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreference() {
        boolean z3 = this.mCurrentMode == 1;
        COUISwitchPreference cOUISwitchPreference = this.mExchangeApplication;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setEnabled(z3);
            this.mExchangeApplication.setSummary(getString(z3 ? j.f13645j : j.f13647k));
        }
        COUISwitchPreference cOUISwitchPreference2 = this.mAlphaAdjust;
        if (cOUISwitchPreference2 != null) {
            cOUISwitchPreference2.setEnabled(z3);
            this.mAlphaAdjust.setSummary(getString(z3 ? j.f13627a : j.f13629b));
        }
    }

    @Override // androidx.lifecycle.InterfaceC0271g
    public /* bridge */ /* synthetic */ H.a getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mIsFoldFrontScreen != FlexibleSettingHelper.getInstance().isFoldFrontScreen()) {
            this.mIsFoldFrontScreen = FlexibleSettingHelper.getInstance().isFoldFrontScreen();
            Dialog dialog = this.mModeChooseBottomDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            AbstractC0652e.b(TAG, "onConfigurationChanged mModeChooseBottomDialog dismiss, mIsFoldFrontScreen:" + this.mIsFoldFrontScreen);
            this.mModeChooseBottomDialog.dismiss();
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        this.mContext = getContext();
        this.mIsFoldFrontScreen = FlexibleSettingHelper.getInstance().isFoldFrontScreen();
        addPreferencesFromResource(l.f13680a);
        initPreference();
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) super.onCreateRecyclerView(layoutInflater, viewGroup, bundle);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t1.d.f13382k);
        cOUIRecyclerView.setDispatchEventWhileScrolling(true);
        cOUIRecyclerView.setPadding(0, 0, 0, dimensionPixelSize);
        return cOUIRecyclerView;
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        unregisterScrollViewListener();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mPreferenceHighlighted && getActivity() != null && getActivity().getIntent() != null) {
            OplusSearchHighlightUtils.highlightPreference(getPreferenceScreen(), getListView(), getActivity().getIntent().getExtras(), this.mContext);
            this.mPreferenceHighlighted = true;
        }
        if (this.mModePreference != null) {
            this.mCurrentMode = Settings.System.getIntForUser(this.mContext.getContentResolver(), FlexibleSettingHelper.ZOOM_SIMPLE_MODE, 1, -2);
            AbstractC0652e.b(TAG, "onResume get simple mode state: " + this.mCurrentMode);
            this.mModePreference.setAssignment(getString(this.mCurrentMode == 1 ? j.f13663s : j.f13651m));
        }
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
