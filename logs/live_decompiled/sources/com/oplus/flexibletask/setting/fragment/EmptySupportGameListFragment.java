package com.oplus.flexibletask.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.oplus.anim.EffectiveAnimationView;
import e0.AbstractC0342a;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class EmptySupportGameListFragment extends com.coui.appcompat.preference.h {
    public static final String TAG = "SettingFragment_" + EmptySupportGameListFragment.class.getSimpleName();
    private EffectiveAnimationView mAnimationView;
    private TextView mHint;

    @Override // androidx.lifecycle.InterfaceC0271g
    public /* bridge */ /* synthetic */ H.a getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.coui.appcompat.theme.a.h().a(requireActivity());
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(t1.h.f13481n, viewGroup, false);
        this.mHint = (TextView) inflate.findViewById(t1.f.f13430J);
        this.mAnimationView = (EffectiveAnimationView) inflate.findViewById(t1.f.f13429I);
        return inflate;
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        EffectiveAnimationView effectiveAnimationView = this.mAnimationView;
        if (effectiveAnimationView == null) {
            AbstractC0652e.d(TAG, "Animation view init fail.");
            return;
        }
        effectiveAnimationView.clearAnimation();
        this.mAnimationView.setVisibility(0);
        if (AbstractC0342a.a(getContext())) {
            this.mAnimationView.setAnimation(t1.i.f13558g1);
        } else {
            this.mAnimationView.setAnimation(t1.i.f13561h1);
        }
        this.mAnimationView.v();
    }
}
