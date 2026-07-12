package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.l;
import com.coui.appcompat.progressbar.COUIInstallLoadProgress;
import com.coui.appcompat.progressbar.a;
import d0.AbstractC0335a;
import s0.AbstractC0573a;
import u0.AbstractC0597a;

/* loaded from: classes.dex */
public class COUILoadInstallProgressPreference extends COUIPreference {

    /* renamed from: e, reason: collision with root package name */
    private a.e f8553e;

    /* renamed from: f, reason: collision with root package name */
    private COUIInstallLoadProgress f8554f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f8555g;

    /* renamed from: h, reason: collision with root package name */
    private int f8556h;

    /* renamed from: i, reason: collision with root package name */
    private int f8557i;

    /* renamed from: j, reason: collision with root package name */
    private int f8558j;

    /* renamed from: k, reason: collision with root package name */
    private int f8559k;

    /* renamed from: l, reason: collision with root package name */
    private int f8560l;

    /* renamed from: m, reason: collision with root package name */
    private final int f8561m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f8562n;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f8563o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f8564p;

    class a implements a.e {
        a() {
        }

        @Override // com.coui.appcompat.progressbar.a.e
        public void a(com.coui.appcompat.progressbar.a aVar, int i3) {
            COUILoadInstallProgressPreference.j(COUILoadInstallProgressPreference.this);
        }
    }

    public interface b {
    }

    public COUILoadInstallProgressPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2597g);
    }

    static /* synthetic */ b j(COUILoadInstallProgressPreference cOUILoadInstallProgressPreference) {
        cOUILoadInstallProgressPreference.getClass();
        return null;
    }

    private int k() {
        return this.f8557i;
    }

    public CharSequence l() {
        return this.f8555g;
    }

    public int m() {
        return this.f8556h;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUIInstallLoadProgress cOUIInstallLoadProgress = (COUIInstallLoadProgress) lVar.b(W1.d.f2684l);
        this.f8554f = cOUIInstallLoadProgress;
        if (cOUIInstallLoadProgress != null) {
            cOUIInstallLoadProgress.setText(l().toString());
            this.f8554f.setDefaultTextSize(m());
            ColorStateList colorStateList = this.f8562n;
            if (colorStateList != null) {
                this.f8554f.setBtnTextColorStateList(colorStateList);
            }
            ColorStateList colorStateList2 = this.f8563o;
            if (colorStateList2 != null) {
                this.f8554f.setThemeSecondaryColorStateList(colorStateList2);
            }
            ColorStateList colorStateList3 = this.f8564p;
            if (colorStateList3 != null) {
                this.f8554f.setThemeColorStateList(colorStateList3);
            }
            if (k() != 0) {
                this.f8554f.setBtnTextColorBySurpassProgress(k());
            }
            int i3 = this.f8558j;
            if (i3 != 0) {
                this.f8554f.setMax(i3);
            }
            this.f8554f.setProgress(this.f8559k);
            this.f8554f.setState(this.f8560l);
            this.f8554f.setOnStateChangeListener(this.f8553e);
        }
    }

    public COUILoadInstallProgressPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2722h);
    }

    public COUILoadInstallProgressPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8553e = new a();
        this.f8555g = "";
        int h3 = AbstractC0335a.h(getContext(), M1.e.f1387c);
        this.f8561m = h3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2735C, i3, i4);
        this.f8555g = obtainStyledAttributes.getText(W1.h.f2743G);
        this.f8556h = obtainStyledAttributes.getDimensionPixelSize(W1.h.f2747I, context.getResources().getDimensionPixelSize(X1.c.f2875f));
        this.f8556h = (int) AbstractC0597a.e(this.f8556h, context.getResources().getConfiguration().fontScale, 2);
        int color = obtainStyledAttributes.getColor(W1.h.f2745H, 0);
        int color2 = obtainStyledAttributes.getColor(W1.h.f2737D, 0);
        int color3 = obtainStyledAttributes.getColor(W1.h.f2739E, 0);
        this.f8557i = obtainStyledAttributes.getColor(W1.h.f2741F, 0);
        obtainStyledAttributes.recycle();
        if (color != 0) {
            this.f8562n = AbstractC0573a.a(color, h3);
        }
        if (color2 != 0) {
            this.f8563o = AbstractC0573a.a(color2, h3);
        }
        if (color3 != 0) {
            this.f8564p = AbstractC0573a.a(color3, h3);
        }
    }
}
