package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.k;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class b extends k {
    private boolean waitingForDismissAllowingStateLoss;

    /* renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    private class C0119b extends BottomSheetBehavior.f {
        private C0119b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onSlide(View view, float f3) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void onStateChanged(View view, int i3) {
            if (i3 == 5) {
                b.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void j(BottomSheetBehavior bottomSheetBehavior, boolean z3) {
        this.waitingForDismissAllowingStateLoss = z3;
        if (bottomSheetBehavior.getState() == 5) {
            i();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new C0119b());
        bottomSheetBehavior.setState(5);
    }

    private boolean k(boolean z3) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        if (!behavior.isHideable() || !aVar.getDismissWithAnimation()) {
            return false;
        }
        j(behavior, z3);
        return true;
    }

    @Override // androidx.fragment.app.d
    public void dismiss() {
        if (k(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.d
    public void dismissAllowingStateLoss() {
        if (k(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.k, androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(getContext(), getTheme());
    }
}
