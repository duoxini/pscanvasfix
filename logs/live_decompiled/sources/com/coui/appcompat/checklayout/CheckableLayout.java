package com.coui.appcompat.checklayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class CheckableLayout extends RelativeLayout implements Checkable {

    /* renamed from: e, reason: collision with root package name */
    private Checkable f7637e;

    public CheckableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setCheckbleView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                KeyEvent.Callback childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ViewGroup) {
                    setCheckbleView((ViewGroup) childAt);
                } else if (childAt instanceof Checkable) {
                    this.f7637e = (Checkable) childAt;
                    return;
                }
            }
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        Checkable checkable = this.f7637e;
        return checkable != null && checkable.isChecked();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setCheckbleView(this);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        Checkable checkable = this.f7637e;
        if (checkable != null) {
            checkable.setChecked(z3);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Checkable checkable = this.f7637e;
        if (checkable != null) {
            checkable.toggle();
        }
    }
}
