package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.C0230d;
import androidx.appcompat.widget.I;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;

/* loaded from: classes.dex */
public class h extends C0230d {

    /* renamed from: i, reason: collision with root package name */
    private final I f9940i;

    /* renamed from: j, reason: collision with root package name */
    private final AccessibilityManager f9941j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f9942k;

    /* renamed from: l, reason: collision with root package name */
    private final int f9943l;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            h hVar = h.this;
            h.this.f(i3 < 0 ? hVar.f9940i.q() : hVar.getAdapter().getItem(i3));
            AdapterView.OnItemClickListener onItemClickListener = h.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i3 < 0) {
                    view = h.this.f9940i.t();
                    i3 = h.this.f9940i.s();
                    j3 = h.this.f9940i.r();
                }
                onItemClickListener.onItemClick(h.this.f9940i.getListView(), view, i3, j3);
            }
            h.this.f9940i.dismiss();
        }
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f470b);
    }

    private TextInputLayout d() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int e() {
        ListAdapter adapter = getAdapter();
        TextInputLayout d3 = d();
        int i3 = 0;
        if (adapter == null || d3 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f9940i.s()) + 15);
        View view = null;
        int i4 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = adapter.getView(max, view, d3);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
        }
        Drawable e3 = this.f9940i.e();
        if (e3 != null) {
            e3.getPadding(this.f9942k);
            Rect rect = this.f9942k;
            i4 += rect.left + rect.right;
        }
        return i4 + d3.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout d3 = d();
        return (d3 == null || !d3.O()) ? super.getHint() : d3.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout d3 = d();
        if (d3 != null && d3.O() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), e()), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t3) {
        super.setAdapter(t3);
        this.f9940i.j(getAdapter());
    }

    public void setSimpleItems(int i3) {
        setSimpleItems(getResources().getStringArray(i3));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f9941j;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f9940i.show();
        }
    }

    public h(Context context, AttributeSet attributeSet, int i3) {
        super(V0.a.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.f9942k = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, H0.j.f688H2, i3, H0.i.f639d, new int[0]);
        if (obtainStyledAttributes.hasValue(H0.j.f692I2) && obtainStyledAttributes.getInt(H0.j.f692I2, 0) == 0) {
            setKeyListener(null);
        }
        this.f9943l = obtainStyledAttributes.getResourceId(H0.j.f696J2, H0.g.f611p);
        this.f9941j = (AccessibilityManager) context2.getSystemService("accessibility");
        I i4 = new I(context2);
        this.f9940i = i4;
        i4.E(true);
        i4.y(this);
        i4.D(2);
        i4.j(getAdapter());
        i4.G(new a());
        if (obtainStyledAttributes.hasValue(H0.j.f700K2)) {
            setSimpleItems(obtainStyledAttributes.getResourceId(H0.j.f700K2, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.f9943l, strArr));
    }
}
