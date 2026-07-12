package com.coui.appcompat.preference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import e0.AbstractC0342a;

/* loaded from: classes.dex */
public class h extends androidx.preference.g {
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private boolean mEnableInternalDivider = true;
    private i mPreferenceItemDecoration;

    public i getItemDecoration() {
        return this.mPreferenceItemDecoration;
    }

    @Override // androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
    }

    @Override // androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) layoutInflater.inflate(W1.e.f2709k, viewGroup, false);
        cOUIRecyclerView.setEnablePointerDownAction(false);
        cOUIRecyclerView.setLayoutManager(onCreateLayoutManager());
        AbstractC0342a.b(cOUIRecyclerView, false);
        return cOUIRecyclerView;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        setDivider(null);
        setDividerHeight(0);
        return onCreateView;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onDestroyView() {
        i iVar = this.mPreferenceItemDecoration;
        if (iVar != null) {
            iVar.r();
        }
        super.onDestroyView();
    }

    @Override // androidx.preference.g, androidx.preference.j.a
    public void onDisplayPreferenceDialog(Preference preference) {
        androidx.fragment.app.d s3;
        if (getFragmentManager().h0(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof COUIActivityDialogPreference) {
            s3 = a.y(preference.getKey());
        } else if (preference instanceof COUIEditTextPreference) {
            s3 = e.s(preference.getKey());
        } else if (preference instanceof COUIMultiSelectListPreference) {
            s3 = g.t(preference.getKey());
        } else {
            if (!(preference instanceof ListPreference)) {
                super.onDisplayPreferenceDialog(preference);
                return;
            }
            s3 = f.s(preference.getKey());
        }
        s3.setTargetFragment(this, 0);
        s3.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListView() == null || this.mPreferenceItemDecoration == null || !this.mEnableInternalDivider) {
            return;
        }
        getListView().removeItemDecoration(this.mPreferenceItemDecoration);
        if (this.mPreferenceItemDecoration.q() == null) {
            this.mPreferenceItemDecoration = new i(getContext(), getPreferenceScreen());
        }
        getListView().addItemDecoration(this.mPreferenceItemDecoration);
    }

    public void setEnableCOUIPreferenceDivider(boolean z3) {
        this.mEnableInternalDivider = z3;
        if (!z3) {
            if (getListView() != null) {
                getListView().removeItemDecoration(this.mPreferenceItemDecoration);
            }
        } else {
            if (getListView() == null || this.mPreferenceItemDecoration == null) {
                return;
            }
            getListView().removeItemDecoration(this.mPreferenceItemDecoration);
            if (this.mPreferenceItemDecoration.q() == null) {
                this.mPreferenceItemDecoration = new i(getContext(), getPreferenceScreen());
            }
            getListView().addItemDecoration(this.mPreferenceItemDecoration);
        }
    }

    @Override // androidx.preference.g
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (preferenceScreen == getPreferenceScreen()) {
            return;
        }
        super.setPreferenceScreen(preferenceScreen);
        if (this.mPreferenceItemDecoration != null && getListView() != null) {
            getListView().removeItemDecoration(this.mPreferenceItemDecoration);
        }
        this.mPreferenceItemDecoration = new i(getContext(), preferenceScreen);
        if (getListView() == null || !this.mEnableInternalDivider) {
            return;
        }
        getListView().addItemDecoration(this.mPreferenceItemDecoration);
    }
}
