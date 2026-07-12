package com.oplus.flexibletask.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import t1.l;

/* loaded from: classes.dex */
public class OperationFragment extends com.coui.appcompat.preference.h {
    private static final String TAG = "OperationFragment";
    private Context mContext;
    private boolean mPreferenceHighlighted;

    private void initPreference() {
        E1.i.e(this.mContext);
    }

    @Override // androidx.lifecycle.InterfaceC0271g
    public /* bridge */ /* synthetic */ H.a getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        this.mContext = getContext();
        addPreferencesFromResource(l.f13681b);
        initPreference();
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) super.onCreateRecyclerView(layoutInflater, viewGroup, bundle);
        cOUIRecyclerView.setDispatchEventWhileScrolling(true);
        return cOUIRecyclerView;
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mPreferenceHighlighted || getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        OplusSearchHighlightUtils.highlightPreference(getPreferenceScreen(), getListView(), getActivity().getIntent().getExtras(), this.mContext);
        this.mPreferenceHighlighted = true;
    }

    @Override // com.coui.appcompat.preference.h, androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
