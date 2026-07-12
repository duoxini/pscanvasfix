package com.coui.appcompat.tintimageview;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.V;
import w0.C0615a;

/* loaded from: classes.dex */
public class COUITintImageView extends AppCompatImageView {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f9289i = {R.attr.background, R.attr.src};

    /* renamed from: h, reason: collision with root package name */
    private final C0615a f9290h;

    public COUITintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        setImageDrawable(this.f9290h.b(i3));
    }

    public COUITintImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        V w3 = V.w(getContext(), attributeSet, f9289i, i3, 0);
        if (w3.t() > 0) {
            if (w3.s(0)) {
                setBackgroundDrawable(w3.g(0));
            }
            if (w3.s(1)) {
                setImageDrawable(w3.g(1));
            }
        }
        w3.x();
        this.f9290h = C0615a.a(context);
    }
}
