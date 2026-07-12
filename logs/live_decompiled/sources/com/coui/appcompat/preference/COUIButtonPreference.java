package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.button.COUIButton;

/* loaded from: classes.dex */
public class COUIButtonPreference extends COUIPreference {

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f8470e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f8471f;

    /* renamed from: g, reason: collision with root package name */
    private int f8472g;

    /* renamed from: h, reason: collision with root package name */
    private int f8473h;

    /* renamed from: i, reason: collision with root package name */
    private int f8474i;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            COUIButtonPreference.j(COUIButtonPreference.this);
        }
    }

    public interface b {
    }

    public COUIButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2592b);
    }

    static /* synthetic */ b j(COUIButtonPreference cOUIButtonPreference) {
        cOUIButtonPreference.getClass();
        return null;
    }

    public CharSequence k() {
        return this.f8471f;
    }

    public int l() {
        return this.f8473h;
    }

    public int m() {
        return this.f8472g;
    }

    public int n() {
        return this.f8474i;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUIButton cOUIButton = (COUIButton) lVar.b(W1.d.f2681i);
        if (cOUIButton != null) {
            cOUIButton.setText(k());
            cOUIButton.setTextSize(n());
            if (m() != 0) {
                cOUIButton.setTextColor(m());
            }
            if (l() != 0) {
                cOUIButton.setDrawableColor(l());
            }
            cOUIButton.setOnClickListener(this.f8470e);
        }
    }

    public COUIButtonPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2717c);
    }

    public COUIButtonPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8470e = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2787d, i3, i4);
        this.f8471f = obtainStyledAttributes.getText(W1.h.f2791f);
        this.f8474i = obtainStyledAttributes.getInt(W1.h.f2795h, 14);
        this.f8472g = obtainStyledAttributes.getColor(W1.h.f2793g, 0);
        this.f8473h = obtainStyledAttributes.getColor(W1.h.f2789e, 0);
        obtainStyledAttributes.recycle();
    }
}
