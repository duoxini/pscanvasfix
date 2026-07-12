package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.l;
import com.coui.appcompat.progressbar.COUICompProgressIndicator;

/* loaded from: classes.dex */
public class COUILoadingPreferenceCategory extends COUIPreferenceCategory {

    /* renamed from: I, reason: collision with root package name */
    private b f8566I;

    /* renamed from: J, reason: collision with root package name */
    private int f8567J;

    /* renamed from: K, reason: collision with root package name */
    private int f8568K;

    /* renamed from: L, reason: collision with root package name */
    private COUICompProgressIndicator f8569L;

    /* renamed from: M, reason: collision with root package name */
    private TextView f8570M;

    /* renamed from: N, reason: collision with root package name */
    private String f8571N;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8572a;

        static {
            int[] iArr = new int[b.values().length];
            f8572a = iArr;
            try {
                iArr[b.BEFORE_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8572a[b.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8572a[b.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8572a[b.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8572a[b.AFTER_LOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        LOADING,
        PAUSE,
        INVISIBLE,
        AFTER_LOADING,
        BEFORE_LOADING
    }

    public COUILoadingPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8566I = b.LOADING;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2749J, 0, 0);
        this.f8567J = obtainStyledAttributes.getResourceId(W1.h.f2751K, 0);
        this.f8568K = obtainStyledAttributes.getResourceId(W1.h.f2753L, 0);
        this.f8571N = obtainStyledAttributes.getString(W1.h.f2755M);
        obtainStyledAttributes.recycle();
        if (this.f8568K != 0) {
            this.f8566I = b.BEFORE_LOADING;
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory
    protected boolean A() {
        return true;
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory, androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        int i3 = a.f8572a[this.f8566I.ordinal()];
        if (i3 == 1) {
            B(this.f8568K);
            super.onBindViewHolder(lVar);
            return;
        }
        if (i3 == 2) {
            B(W1.e.f2703e);
            super.onBindViewHolder(lVar);
            this.f8569L = (COUICompProgressIndicator) x().findViewById(W1.d.f2677e);
            this.f8570M = (TextView) x().findViewById(W1.d.f2670L);
            this.f8569L.setVisibility(0);
            if (this.f8569L.getAnimationView() != null) {
                this.f8569L.getAnimationView().v();
            }
            if (TextUtils.isEmpty(this.f8571N)) {
                this.f8570M.setVisibility(8);
                return;
            } else {
                this.f8570M.setText(this.f8571N);
                this.f8570M.setVisibility(0);
                return;
            }
        }
        if (i3 == 3) {
            COUICompProgressIndicator cOUICompProgressIndicator = this.f8569L;
            if (cOUICompProgressIndicator != null) {
                cOUICompProgressIndicator.setVisibility(0);
                this.f8569L.getAnimationView().u();
                return;
            }
            return;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return;
            }
            B(this.f8567J);
            super.onBindViewHolder(lVar);
            return;
        }
        COUICompProgressIndicator cOUICompProgressIndicator2 = this.f8569L;
        if (cOUICompProgressIndicator2 != null) {
            cOUICompProgressIndicator2.setVisibility(8);
        }
    }
}
