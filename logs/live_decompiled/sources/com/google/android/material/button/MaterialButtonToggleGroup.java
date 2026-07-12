package com.google.android.material.button;

import H0.i;
import U0.k;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.AbstractC0259h;
import androidx.core.view.C0252a;
import androidx.core.view.accessibility.d;
import androidx.core.view.y;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    private static final String f9467o = "MaterialButtonToggleGroup";

    /* renamed from: p, reason: collision with root package name */
    private static final int f9468p = i.f653r;

    /* renamed from: e, reason: collision with root package name */
    private final List f9469e;

    /* renamed from: f, reason: collision with root package name */
    private final e f9470f;

    /* renamed from: g, reason: collision with root package name */
    private final LinkedHashSet f9471g;

    /* renamed from: h, reason: collision with root package name */
    private final Comparator f9472h;

    /* renamed from: i, reason: collision with root package name */
    private Integer[] f9473i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9474j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9475k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9476l;

    /* renamed from: m, reason: collision with root package name */
    private final int f9477m;

    /* renamed from: n, reason: collision with root package name */
    private Set f9478n;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends C0252a {
        b() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.T(d.c.a(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {

        /* renamed from: e, reason: collision with root package name */
        private static final U0.c f9481e = new U0.a(0.0f);

        /* renamed from: a, reason: collision with root package name */
        U0.c f9482a;

        /* renamed from: b, reason: collision with root package name */
        U0.c f9483b;

        /* renamed from: c, reason: collision with root package name */
        U0.c f9484c;

        /* renamed from: d, reason: collision with root package name */
        U0.c f9485d;

        c(U0.c cVar, U0.c cVar2, U0.c cVar3, U0.c cVar4) {
            this.f9482a = cVar;
            this.f9483b = cVar3;
            this.f9484c = cVar4;
            this.f9485d = cVar2;
        }

        public static c a(c cVar) {
            U0.c cVar2 = f9481e;
            return new c(cVar2, cVar.f9485d, cVar2, cVar.f9484c);
        }

        public static c b(c cVar, View view) {
            return ViewUtils.isLayoutRtl(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            U0.c cVar2 = cVar.f9482a;
            U0.c cVar3 = cVar.f9485d;
            U0.c cVar4 = f9481e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            U0.c cVar2 = f9481e;
            return new c(cVar2, cVar2, cVar.f9483b, cVar.f9484c);
        }

        public static c e(c cVar, View view) {
            return ViewUtils.isLayoutRtl(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            U0.c cVar2 = cVar.f9482a;
            U0.c cVar3 = f9481e;
            return new c(cVar2, cVar3, cVar.f9483b, cVar3);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z3);
    }

    private class e implements MaterialButton.a {
        private e() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z3) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f490v);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i3 = firstVisibleChildIndex + 1; i3 < getChildCount(); i3++) {
            MaterialButton h3 = h(i3);
            int min = Math.min(h3.getStrokeWidth(), h(i3 - 1).getStrokeWidth());
            LinearLayout.LayoutParams d3 = d(h3);
            if (getOrientation() == 0) {
                AbstractC0259h.c(d3, 0);
                AbstractC0259h.d(d3, -min);
                d3.topMargin = 0;
            } else {
                d3.bottomMargin = 0;
                d3.topMargin = -min;
                AbstractC0259h.d(d3, 0);
            }
            h3.setLayoutParams(d3);
        }
        n(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(int i3, boolean z3) {
        if (i3 == -1) {
            Log.e(f9467o, "Button ID is not valid: " + i3);
            return;
        }
        HashSet hashSet = new HashSet(this.f9478n);
        if (z3 && !hashSet.contains(Integer.valueOf(i3))) {
            if (this.f9475k && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i3));
        } else {
            if (z3 || !hashSet.contains(Integer.valueOf(i3))) {
                return;
            }
            if (!this.f9476l || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i3));
            }
        }
        q(hashSet);
    }

    private void g(int i3, boolean z3) {
        Iterator it = this.f9471g.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this, i3, z3);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (k(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof MaterialButton) && k(i4)) {
                i3++;
            }
        }
        return i3;
    }

    private MaterialButton h(int i3) {
        return (MaterialButton) getChildAt(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == view) {
                return i3;
            }
            if ((getChildAt(i4) instanceof MaterialButton) && k(i4)) {
                i3++;
            }
        }
        return -1;
    }

    private c j(int i3, int i4, int i5) {
        c cVar = (c) this.f9469e.get(i3);
        if (i4 == i5) {
            return cVar;
        }
        boolean z3 = getOrientation() == 0;
        if (i3 == i4) {
            return z3 ? c.e(cVar, this) : c.f(cVar);
        }
        if (i3 == i5) {
            return z3 ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    private boolean k(int i3) {
        return getChildAt(i3).getVisibility() != 8;
    }

    private void n(int i3) {
        if (getChildCount() == 0 || i3 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i3).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            AbstractC0259h.c(layoutParams, 0);
            AbstractC0259h.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(int i3, boolean z3) {
        View findViewById = findViewById(i3);
        if (findViewById instanceof MaterialButton) {
            this.f9474j = true;
            ((MaterialButton) findViewById).setChecked(z3);
            this.f9474j = false;
        }
    }

    private static void p(k.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.E(cVar.f9482a).u(cVar.f9485d).J(cVar.f9483b).z(cVar.f9484c);
        }
    }

    private void q(Set set) {
        Set set2 = this.f9478n;
        this.f9478n = new HashSet(set);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = h(i3).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.f9472h);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put(h(i3), Integer.valueOf(i3));
        }
        this.f9473i = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(y.i());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f9470f);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f9467o, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f9469e.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        y.j0(materialButton, new b());
    }

    public void b(d dVar) {
        this.f9471g.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    public int getCheckedButtonId() {
        if (!this.f9475k || this.f9478n.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f9478n.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = h(i3).getId();
            if (this.f9478n.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        Integer[] numArr = this.f9473i;
        if (numArr != null && i4 < numArr.length) {
            return numArr[i4].intValue();
        }
        Log.w(f9467o, "Child order wasn't updated");
        return i4;
    }

    public boolean l() {
        return this.f9475k;
    }

    void m(MaterialButton materialButton, boolean z3) {
        if (this.f9474j) {
            return;
        }
        e(materialButton.getId(), z3);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f9477m;
        if (i3 != -1) {
            q(Collections.singleton(Integer.valueOf(i3)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.d.r0(accessibilityNodeInfo).S(d.b.b(1, getVisibleButtonCount(), false, l() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        s();
        c();
        super.onMeasure(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f9469e.remove(indexOfChild);
        }
        s();
        c();
    }

    void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton h3 = h(i3);
            if (h3.getVisibility() != 8) {
                k.b v3 = h3.getShapeAppearanceModel().v();
                p(v3, j(i3, firstVisibleChildIndex, lastVisibleChildIndex));
                h3.setShapeAppearanceModel(v3.m());
            }
        }
    }

    public void setSelectionRequired(boolean z3) {
        this.f9476l = z3;
    }

    public void setSingleSelection(boolean z3) {
        if (this.f9475k != z3) {
            this.f9475k = z3;
            f();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonToggleGroup(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f9468p
            android.content.Context r7 = V0.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f9469e = r7
            com.google.android.material.button.MaterialButtonToggleGroup$e r7 = new com.google.android.material.button.MaterialButtonToggleGroup$e
            r0 = 0
            r7.<init>(r6, r0)
            r6.f9470f = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f9471g = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f9472h = r7
            r7 = 0
            r6.f9474j = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.f9478n = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = H0.j.f3
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = H0.j.i3
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = H0.j.g3
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f9477m = r9
            int r9 = H0.j.h3
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f9476l = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.y.u0(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
