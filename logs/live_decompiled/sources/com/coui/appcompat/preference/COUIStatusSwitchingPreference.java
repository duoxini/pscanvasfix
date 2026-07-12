package com.coui.appcompat.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.preference.l;
import com.coui.appcompat.textview.COUITextView;
import com.oplus.anim.EffectiveAnimationView;

/* loaded from: classes.dex */
public class COUIStatusSwitchingPreference extends COUIPreference {

    /* renamed from: e, reason: collision with root package name */
    private EffectiveAnimationView f8684e;

    /* renamed from: f, reason: collision with root package name */
    private COUITextView f8685f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f8686g;

    /* renamed from: h, reason: collision with root package name */
    private int f8687h;

    /* renamed from: i, reason: collision with root package name */
    private int f8688i;

    /* renamed from: j, reason: collision with root package name */
    private int f8689j;

    /* renamed from: k, reason: collision with root package name */
    private int f8690k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f8691l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f8692m;

    public COUIStatusSwitchingPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2604n);
    }

    private void j() {
        EffectiveAnimationView effectiveAnimationView = this.f8684e;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.setVisibility(0);
            this.f8685f.setVisibility(8);
            this.f8686g.setVisibility(8);
            n();
            m();
        }
    }

    private void k() {
        if (this.f8686g == null || this.f8692m == null) {
            return;
        }
        o();
        this.f8684e.setVisibility(8);
        this.f8685f.setVisibility(8);
        this.f8686g.setVisibility(0);
        this.f8686g.setImageDrawable(this.f8692m);
    }

    private void l() {
        if (this.f8685f != null) {
            o();
            this.f8684e.setVisibility(8);
            this.f8685f.setVisibility(0);
            this.f8686g.setVisibility(8);
            this.f8685f.setText(this.f8691l);
        }
    }

    private void m() {
        o();
        this.f8684e.setAnimation(this.f8690k);
        this.f8684e.t(true);
        this.f8684e.v();
    }

    private void n() {
        ViewGroup.LayoutParams layoutParams = this.f8684e.getLayoutParams();
        layoutParams.width = this.f8688i;
        layoutParams.height = this.f8689j;
        this.f8684e.setLayoutParams(layoutParams);
    }

    private void o() {
        EffectiveAnimationView effectiveAnimationView = this.f8684e;
        if (effectiveAnimationView == null || !effectiveAnimationView.p()) {
            return;
        }
        this.f8684e.i();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        this.f8684e = (EffectiveAnimationView) lVar.b(W1.d.f2680h);
        this.f8685f = (COUITextView) lVar.b(W1.d.f2691s);
        this.f8686g = (ImageView) lVar.b(W1.d.f2683k);
        int i3 = this.f8687h;
        if (i3 == 1) {
            j();
        } else if (i3 == 2) {
            l();
        } else {
            if (i3 != 3) {
                return;
            }
            k();
        }
    }

    public COUIStatusSwitchingPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, i3);
    }

    public COUIStatusSwitchingPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        this.f8687h = 0;
        this.f8688i = -2;
        this.f8689j = -2;
    }
}
