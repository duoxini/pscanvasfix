package com.coui.appcompat.searchview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;

/* loaded from: classes.dex */
public class COUISearchViewAnimate$SearchFunctionalButton extends AppCompatButton {

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f9188h;

    public interface a {
    }

    public COUISearchViewAnimate$SearchFunctionalButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setPerformClickCallback(a aVar) {
    }

    public void setPerformClicked(boolean z3) {
        this.f9188h = z3;
    }

    public COUISearchViewAnimate$SearchFunctionalButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9188h = false;
        setMaxLines(1);
        setMaxWidth(context.getResources().getDimensionPixelOffset(g2.c.f11736T));
        setEllipsize(TextUtils.TruncateAt.END);
    }
}
