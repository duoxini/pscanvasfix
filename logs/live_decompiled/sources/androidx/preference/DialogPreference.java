package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f5853e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f5854f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f5855g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f5856h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f5857i;

    /* renamed from: j, reason: collision with root package name */
    private int f5858j;

    public interface a {
        Preference findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6068D, i3, i4);
        String f3 = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6098N, s.f6071E);
        this.f5853e = f3;
        if (f3 == null) {
            this.f5853e = getTitle();
        }
        this.f5854f = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6095M, s.f6074F);
        this.f5855g = androidx.core.content.res.i.c(obtainStyledAttributes, s.f6089K, s.f6077G);
        this.f5856h = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6104P, s.f6080H);
        this.f5857i = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6101O, s.f6083I);
        this.f5858j = androidx.core.content.res.i.e(obtainStyledAttributes, s.f6092L, s.f6086J, 0);
        obtainStyledAttributes.recycle();
    }

    public Drawable i() {
        return this.f5855g;
    }

    public int j() {
        return this.f5858j;
    }

    public CharSequence k() {
        return this.f5854f;
    }

    public CharSequence l() {
        return this.f5853e;
    }

    public CharSequence m() {
        return this.f5857i;
    }

    public CharSequence n() {
        return this.f5856h;
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        getPreferenceManager().u(this);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6030b, R.attr.dialogPreferenceStyle));
    }
}
