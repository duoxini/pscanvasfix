package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;

/* loaded from: classes.dex */
public class k extends androidx.fragment.app.d {
    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        return new j(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.d
    public void setupDialog(Dialog dialog, int i3) {
        if (!(dialog instanceof j)) {
            super.setupDialog(dialog, i3);
            return;
        }
        j jVar = (j) dialog;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        jVar.supportRequestWindowFeature(1);
    }
}
