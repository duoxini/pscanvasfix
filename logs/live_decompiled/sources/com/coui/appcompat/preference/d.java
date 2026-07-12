package com.coui.appcompat.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public abstract class d extends LinearLayout implements Checkable {
    public d(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof Checkable) {
                return ((Checkable) childAt).isChecked();
            }
        }
        return false;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(z3);
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            KeyEvent.Callback childAt = getChildAt(i3);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).toggle();
            }
        }
    }
}
