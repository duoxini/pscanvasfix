package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class j<S> extends o {

    /* renamed from: f, reason: collision with root package name */
    private int f9706f;

    /* renamed from: g, reason: collision with root package name */
    private com.google.android.material.datepicker.a f9707g;

    class a extends n {
        a() {
        }
    }

    static j i(d dVar, int i3, com.google.android.material.datepicker.a aVar) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        jVar.setArguments(bundle);
        return jVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9706f = bundle.getInt("THEME_RES_ID_KEY");
        androidx.appcompat.app.p.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f9707g = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f9706f));
        new a();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f9706f);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f9707g);
    }
}
