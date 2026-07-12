package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
abstract class o extends Fragment {

    /* renamed from: e, reason: collision with root package name */
    protected final LinkedHashSet f9728e = new LinkedHashSet();

    o() {
    }

    boolean g(n nVar) {
        return this.f9728e.add(nVar);
    }

    void h() {
        this.f9728e.clear();
    }
}
