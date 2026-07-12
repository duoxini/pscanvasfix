package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.l;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.checkbox.COUICheckBox;

/* loaded from: classes.dex */
public final class COUICheckBoxPreference extends CheckBoxPreference implements COUIRecyclerView.b {

    /* renamed from: k, reason: collision with root package name */
    private COUICheckBox f8476k;

    /* renamed from: l, reason: collision with root package name */
    private Context f8477l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f8478m;

    /* renamed from: n, reason: collision with root package name */
    private View f8479n;

    /* renamed from: o, reason: collision with root package name */
    private int f8480o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f8481p;

    /* renamed from: q, reason: collision with root package name */
    private int f8482q;

    public static final class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            D2.k.e(view, "host");
            D2.k.e(accessibilityNodeInfo, "info");
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            String string = COUICheckBoxPreference.this.getContext().getResources().getString(M1.k.f1495e);
            D2.k.d(string, "context.resources.getStr…oui_accessibility_switch)");
            String string2 = COUICheckBoxPreference.this.getContext().getResources().getString(M1.k.f1494d);
            D2.k.d(string2, "context.resources.getStr…accessibility_select_all)");
            COUICheckBox cOUICheckBox = COUICheckBoxPreference.this.f8476k;
            if (cOUICheckBox != null && cOUICheckBox.getState() == 1) {
                string = string2;
            }
            accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, string));
        }
    }

    public COUICheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2593c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        view.performHapticFeedback(302);
        return false;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f8479n instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.f8480o;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f8478m;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.f8480o;
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        View view;
        super.onBindViewHolder(lVar);
        View view2 = lVar != null ? lVar.itemView : null;
        this.f8479n = view2;
        if (view2 != null) {
            view2.setAccessibilityDelegate(new a());
        }
        View b3 = lVar != null ? lVar.b(R.id.title) : null;
        this.f8478m = b3 instanceof TextView ? (TextView) b3 : null;
        View b4 = lVar != null ? lVar.b(R.id.checkbox) : null;
        COUICheckBox cOUICheckBox = b4 instanceof COUICheckBox ? (COUICheckBox) b4 : null;
        this.f8476k = cOUICheckBox;
        if (cOUICheckBox != null) {
            cOUICheckBox.setState(this.f5951e ? 2 : 0);
        }
        if (lVar != null && (view = lVar.itemView) != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean t3;
                    t3 = COUICheckBoxPreference.t(view3, motionEvent);
                    return t3;
                }
            });
        }
        View b5 = lVar != null ? lVar.b(R.id.icon) : null;
        View b6 = lVar != null ? lVar.b(W1.d.f2696x) : null;
        if (b6 != null) {
            if (b5 != null) {
                b6.setVisibility(b5.getVisibility());
            } else {
                b6.setVisibility(8);
            }
        }
        j.a(lVar, this.f8481p, this.f8482q);
        D2.k.b(lVar);
        com.coui.appcompat.cardlist.a.d(lVar.itemView, com.coui.appcompat.cardlist.a.b(this));
    }

    public COUICheckBoxPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2718d);
    }

    public COUICheckBoxPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8477l = context;
        this.f8480o = getContext().getResources().getDimensionPixelSize(W1.c.f2610A);
        D2.k.b(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, i4);
        D2.k.d(obtainStyledAttributes, "context!!.obtainStyledAt…tr, defStyleRes\n        )");
        this.f8482q = obtainStyledAttributes.getInt(W1.h.f2786c0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, W1.h.f2805m, i3, i4);
        D2.k.d(obtainStyledAttributes2, "context.obtainStyledAttr…    defStyleRes\n        )");
        this.f8481p = obtainStyledAttributes2.getText(W1.h.f2807n);
        obtainStyledAttributes2.recycle();
    }
}
