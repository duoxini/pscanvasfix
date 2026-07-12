package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.Preference;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n.AbstractC0475e;
import q.d;
import q.e;
import q.j;
import r.C0558b;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static h sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<androidx.constraintlayout.widget.b> mConstraintHelpers;
    protected androidx.constraintlayout.widget.c mConstraintLayoutSpec;
    private d mConstraintSet;
    private int mConstraintSetId;
    private e mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected q.f mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    c mMeasurer;
    private AbstractC0475e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<q.e> mTempMapIdToWidget;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4355a;

        static {
            int[] iArr = new int[e.b.values().length];
            f4355a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4355a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4355a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4355a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class c implements C0558b.InterfaceC0145b {

        /* renamed from: a, reason: collision with root package name */
        ConstraintLayout f4357a;

        /* renamed from: b, reason: collision with root package name */
        int f4358b;

        /* renamed from: c, reason: collision with root package name */
        int f4359c;

        /* renamed from: d, reason: collision with root package name */
        int f4360d;

        /* renamed from: e, reason: collision with root package name */
        int f4361e;

        /* renamed from: f, reason: collision with root package name */
        int f4362f;

        /* renamed from: g, reason: collision with root package name */
        int f4363g;

        public c(ConstraintLayout constraintLayout) {
            this.f4357a = constraintLayout;
        }

        private boolean d(int i3, int i4, int i5) {
            if (i3 == i4) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i5 == size;
            }
            return false;
        }

        @Override // r.C0558b.InterfaceC0145b
        public final void a(q.e eVar, C0558b.a aVar) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            int baseline;
            int max;
            int i3;
            int i4;
            int i5;
            if (eVar == null) {
                return;
            }
            if (eVar.T() == 8 && !eVar.h0()) {
                aVar.f13062e = 0;
                aVar.f13063f = 0;
                aVar.f13064g = 0;
                return;
            }
            if (eVar.I() == null) {
                return;
            }
            e.b bVar = aVar.f13058a;
            e.b bVar2 = aVar.f13059b;
            int i6 = aVar.f13060c;
            int i7 = aVar.f13061d;
            int i8 = this.f4358b + this.f4359c;
            int i9 = this.f4360d;
            View view = (View) eVar.q();
            int[] iArr = a.f4355a;
            int i10 = iArr[bVar.ordinal()];
            if (i10 == 1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else if (i10 == 2) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4362f, i9, -2);
            } else if (i10 == 3) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4362f, i9 + eVar.z(), -1);
            } else if (i10 != 4) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4362f, i9, -2);
                boolean z3 = eVar.f12938w == 1;
                int i11 = aVar.f13067j;
                if (i11 == C0558b.a.f13056l || i11 == C0558b.a.f13057m) {
                    boolean z4 = view.getMeasuredHeight() == eVar.v();
                    if (aVar.f13067j == C0558b.a.f13057m || !z3 || ((z3 && z4) || eVar.l0())) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.U(), 1073741824);
                    }
                }
            }
            int i12 = iArr[bVar2.ordinal()];
            if (i12 == 1) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else if (i12 == 2) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4363g, i8, -2);
            } else if (i12 == 3) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4363g, i8 + eVar.S(), -1);
            } else if (i12 != 4) {
                makeMeasureSpec2 = 0;
            } else {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4363g, i8, -2);
                boolean z5 = eVar.f12940x == 1;
                int i13 = aVar.f13067j;
                if (i13 == C0558b.a.f13056l || i13 == C0558b.a.f13057m) {
                    boolean z6 = view.getMeasuredWidth() == eVar.U();
                    if (aVar.f13067j == C0558b.a.f13057m || !z5 || ((z5 && z6) || eVar.m0())) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.v(), 1073741824);
                    }
                }
            }
            q.f fVar = (q.f) eVar.I();
            if (fVar != null && j.b(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == eVar.U() && view.getMeasuredWidth() < fVar.U() && view.getMeasuredHeight() == eVar.v() && view.getMeasuredHeight() < fVar.v() && view.getBaseline() == eVar.n() && !eVar.k0() && d(eVar.A(), makeMeasureSpec, eVar.U()) && d(eVar.B(), makeMeasureSpec2, eVar.v())) {
                aVar.f13062e = eVar.U();
                aVar.f13063f = eVar.v();
                aVar.f13064g = eVar.n();
                return;
            }
            e.b bVar3 = e.b.MATCH_CONSTRAINT;
            boolean z7 = bVar == bVar3;
            boolean z8 = bVar2 == bVar3;
            e.b bVar4 = e.b.MATCH_PARENT;
            boolean z9 = bVar2 == bVar4 || bVar2 == e.b.FIXED;
            boolean z10 = bVar == bVar4 || bVar == e.b.FIXED;
            boolean z11 = z7 && eVar.f12901d0 > 0.0f;
            boolean z12 = z8 && eVar.f12901d0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i14 = aVar.f13067j;
            if (i14 != C0558b.a.f13056l && i14 != C0558b.a.f13057m && z7 && eVar.f12938w == 0 && z8 && eVar.f12940x == 0) {
                i5 = -1;
                i4 = 0;
                baseline = 0;
                max = 0;
            } else {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                eVar.R0(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i15 = eVar.f12944z;
                max = i15 > 0 ? Math.max(i15, measuredWidth) : measuredWidth;
                int i16 = eVar.f12858A;
                if (i16 > 0) {
                    max = Math.min(i16, max);
                }
                int i17 = eVar.f12862C;
                if (i17 > 0) {
                    i4 = Math.max(i17, measuredHeight);
                    i3 = makeMeasureSpec;
                } else {
                    i3 = makeMeasureSpec;
                    i4 = measuredHeight;
                }
                int i18 = eVar.f12864D;
                if (i18 > 0) {
                    i4 = Math.min(i18, i4);
                }
                if (!j.b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z11 && z9) {
                        max = (int) ((i4 * eVar.f12901d0) + 0.5f);
                    } else if (z12 && z10) {
                        i4 = (int) ((max / eVar.f12901d0) + 0.5f);
                    }
                }
                if (measuredWidth != max || measuredHeight != i4) {
                    int makeMeasureSpec3 = measuredWidth != max ? View.MeasureSpec.makeMeasureSpec(max, 1073741824) : i3;
                    if (measuredHeight != i4) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    }
                    view.measure(makeMeasureSpec3, makeMeasureSpec2);
                    eVar.R0(makeMeasureSpec3, makeMeasureSpec2);
                    max = view.getMeasuredWidth();
                    i4 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i5 = -1;
            }
            boolean z13 = baseline != i5;
            aVar.f13066i = (max == aVar.f13060c && i4 == aVar.f13061d) ? false : true;
            if (bVar5.needsBaseline) {
                z13 = true;
            }
            if (z13 && baseline != -1 && eVar.n() != baseline) {
                aVar.f13066i = true;
            }
            aVar.f13062e = max;
            aVar.f13063f = i4;
            aVar.f13065h = z13;
            aVar.f13064g = baseline;
        }

        @Override // r.C0558b.InterfaceC0145b
        public final void b() {
            int childCount = this.f4357a.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.f4357a.getChildAt(i3);
            }
            int size = this.f4357a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    ((androidx.constraintlayout.widget.b) this.f4357a.mConstraintHelpers.get(i4)).j(this.f4357a);
                }
            }
        }

        public void c(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f4358b = i5;
            this.f4359c = i6;
            this.f4360d = i7;
            this.f4361e = i8;
            this.f4362f = i3;
            this.f4363g = i4;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new q.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Preference.DEFAULT_ORDER;
        this.mMaxHeight = Preference.DEFAULT_ORDER;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        c(attributeSet, 0, 0);
    }

    private final q.e b(int i3) {
        if (i3 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i3);
        if (view == null && (view = findViewById(i3)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).widget;
    }

    private void c(AttributeSet attributeSet, int i3, int i4) {
        this.mLayoutWidget.y0(this);
        this.mLayoutWidget.R1(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.f4698n1, i3, i4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == g.f4714r1) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == g.f4718s1) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == g.f4706p1) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == g.f4710q1) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == g.f4565F2) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == g.f4544A1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == g.f4734w1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.mConstraintSet = dVar;
                        dVar.l(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.S1(this.mOptimizationLevel);
    }

    private void d() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void e() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            q.e viewWidget = getViewWidget(getChildAt(i3));
            if (viewWidget != null) {
                viewWidget.r0();
            }
        }
        if (isInEditMode) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    b(childAt.getId()).z0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).getId();
            }
        }
        d dVar = this.mConstraintSet;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.mLayoutWidget.q1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).l(this);
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            getChildAt(i7);
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            this.mTempMapIdToWidget.put(childAt2.getId(), getViewWidget(childAt2));
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt3 = getChildAt(i9);
            q.e viewWidget2 = getViewWidget(childAt3);
            if (viewWidget2 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt3, viewWidget2, bVar, this.mTempMapIdToWidget);
            }
        }
    }

    private void f(q.e eVar, b bVar, SparseArray sparseArray, int i3, d.b bVar2) {
        View view = this.mChildrenByIds.get(i3);
        q.e eVar2 = (q.e) sparseArray.get(i3);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.needsBaseline = true;
        d.b bVar3 = d.b.BASELINE;
        if (bVar2 == bVar3) {
            b bVar4 = (b) view.getLayoutParams();
            bVar4.needsBaseline = true;
            bVar4.widget.H0(true);
        }
        eVar.m(bVar3).a(eVar2.m(bVar2), bVar.baselineMargin, bVar.goneBaselineMargin, true);
        eVar.H0(true);
        eVar.m(d.b.TOP).p();
        eVar.m(d.b.BOTTOM).p();
    }

    private boolean g() {
        int childCount = getChildCount();
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (getChildAt(i3).isLayoutRequested()) {
                z3 = true;
                break;
            }
            i3++;
        }
        if (z3) {
            e();
        }
        return z3;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return max2 > 0 ? max2 : max;
    }

    public static h getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new h();
        }
        return sSharedValues;
    }

    protected void applyConstraintsFromLayoutParams(boolean z3, View view, q.e eVar, b bVar, SparseArray<q.e> sparseArray) {
        q.e eVar2;
        q.e eVar3;
        q.e eVar4;
        q.e eVar5;
        int i3;
        bVar.validate();
        bVar.helped = false;
        eVar.f1(view.getVisibility());
        if (bVar.isInPlaceholder) {
            eVar.Q0(true);
            eVar.f1(8);
        }
        eVar.y0(view);
        if (view instanceof androidx.constraintlayout.widget.b) {
            ((androidx.constraintlayout.widget.b) view).h(eVar, this.mLayoutWidget.L1());
        }
        if (bVar.isGuideline) {
            q.g gVar = (q.g) eVar;
            int i4 = bVar.resolvedGuideBegin;
            int i5 = bVar.resolvedGuideEnd;
            float f3 = bVar.resolvedGuidePercent;
            if (f3 != -1.0f) {
                gVar.v1(f3);
                return;
            } else if (i4 != -1) {
                gVar.t1(i4);
                return;
            } else {
                if (i5 != -1) {
                    gVar.u1(i5);
                    return;
                }
                return;
            }
        }
        int i6 = bVar.resolvedLeftToLeft;
        int i7 = bVar.resolvedLeftToRight;
        int i8 = bVar.resolvedRightToLeft;
        int i9 = bVar.resolvedRightToRight;
        int i10 = bVar.resolveGoneLeftMargin;
        int i11 = bVar.resolveGoneRightMargin;
        float f4 = bVar.resolvedHorizontalBias;
        int i12 = bVar.circleConstraint;
        if (i12 != -1) {
            q.e eVar6 = sparseArray.get(i12);
            if (eVar6 != null) {
                eVar.j(eVar6, bVar.circleAngle, bVar.circleRadius);
            }
        } else {
            if (i6 != -1) {
                q.e eVar7 = sparseArray.get(i6);
                if (eVar7 != null) {
                    d.b bVar2 = d.b.LEFT;
                    eVar.c0(bVar2, eVar7, bVar2, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i10);
                }
            } else if (i7 != -1 && (eVar2 = sparseArray.get(i7)) != null) {
                eVar.c0(d.b.LEFT, eVar2, d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i10);
            }
            if (i8 != -1) {
                q.e eVar8 = sparseArray.get(i8);
                if (eVar8 != null) {
                    eVar.c0(d.b.RIGHT, eVar8, d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i11);
                }
            } else if (i9 != -1 && (eVar3 = sparseArray.get(i9)) != null) {
                d.b bVar3 = d.b.RIGHT;
                eVar.c0(bVar3, eVar3, bVar3, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i11);
            }
            int i13 = bVar.topToTop;
            if (i13 != -1) {
                q.e eVar9 = sparseArray.get(i13);
                if (eVar9 != null) {
                    d.b bVar4 = d.b.TOP;
                    eVar.c0(bVar4, eVar9, bVar4, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.goneTopMargin);
                }
            } else {
                int i14 = bVar.topToBottom;
                if (i14 != -1 && (eVar4 = sparseArray.get(i14)) != null) {
                    eVar.c0(d.b.TOP, eVar4, d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.goneTopMargin);
                }
            }
            int i15 = bVar.bottomToTop;
            if (i15 != -1) {
                q.e eVar10 = sparseArray.get(i15);
                if (eVar10 != null) {
                    eVar.c0(d.b.BOTTOM, eVar10, d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.goneBottomMargin);
                }
            } else {
                int i16 = bVar.bottomToBottom;
                if (i16 != -1 && (eVar5 = sparseArray.get(i16)) != null) {
                    d.b bVar5 = d.b.BOTTOM;
                    eVar.c0(bVar5, eVar5, bVar5, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.goneBottomMargin);
                }
            }
            int i17 = bVar.baselineToBaseline;
            if (i17 != -1) {
                f(eVar, bVar, sparseArray, i17, d.b.BASELINE);
            } else {
                int i18 = bVar.baselineToTop;
                if (i18 != -1) {
                    f(eVar, bVar, sparseArray, i18, d.b.TOP);
                } else {
                    int i19 = bVar.baselineToBottom;
                    if (i19 != -1) {
                        f(eVar, bVar, sparseArray, i19, d.b.BOTTOM);
                    }
                }
            }
            if (f4 >= 0.0f) {
                eVar.J0(f4);
            }
            float f5 = bVar.verticalBias;
            if (f5 >= 0.0f) {
                eVar.Z0(f5);
            }
        }
        if (z3 && ((i3 = bVar.editorAbsoluteX) != -1 || bVar.editorAbsoluteY != -1)) {
            eVar.X0(i3, bVar.editorAbsoluteY);
        }
        if (bVar.horizontalDimensionFixed) {
            eVar.M0(e.b.FIXED);
            eVar.g1(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.M0(e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            if (bVar.constrainedWidth) {
                eVar.M0(e.b.MATCH_CONSTRAINT);
            } else {
                eVar.M0(e.b.MATCH_PARENT);
            }
            eVar.m(d.b.LEFT).f12843g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            eVar.m(d.b.RIGHT).f12843g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            eVar.M0(e.b.MATCH_CONSTRAINT);
            eVar.g1(0);
        }
        if (bVar.verticalDimensionFixed) {
            eVar.c1(e.b.FIXED);
            eVar.I0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.c1(e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            if (bVar.constrainedHeight) {
                eVar.c1(e.b.MATCH_CONSTRAINT);
            } else {
                eVar.c1(e.b.MATCH_PARENT);
            }
            eVar.m(d.b.TOP).f12843g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            eVar.m(d.b.BOTTOM).f12843g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            eVar.c1(e.b.MATCH_CONSTRAINT);
            eVar.I0(0);
        }
        eVar.A0(bVar.dimensionRatio);
        eVar.O0(bVar.horizontalWeight);
        eVar.e1(bVar.verticalWeight);
        eVar.K0(bVar.horizontalChainStyle);
        eVar.a1(bVar.verticalChainStyle);
        eVar.h1(bVar.wrapBehaviorInParent);
        eVar.N0(bVar.matchConstraintDefaultWidth, bVar.matchConstraintMinWidth, bVar.matchConstraintMaxWidth, bVar.matchConstraintPercentWidth);
        eVar.d1(bVar.matchConstraintDefaultHeight, bVar.matchConstraintMinHeight, bVar.matchConstraintMaxHeight, bVar.matchConstraintPercentHeight);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.mConstraintHelpers.get(i3).k(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i5 = (int) ((parseInt / 1080.0f) * width);
                        int i6 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f3 = i5;
                        float f4 = i6;
                        float f5 = i5 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f3, f4, f5, f4, paint);
                        float parseInt4 = i6 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f5, f4, f5, parseInt4, paint);
                        canvas.drawLine(f5, parseInt4, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f3, f4, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f3, f4, f5, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f5, f4, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(AbstractC0475e abstractC0475e) {
        this.mLayoutWidget.E1(abstractC0475e);
    }

    @Override // android.view.View
    public void forceLayout() {
        d();
        super.forceLayout();
    }

    public Object getDesignInformation(int i3, Object obj) {
        if (i3 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.G1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.f12922o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.f12922o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.f12922o = "parent";
            }
        }
        if (this.mLayoutWidget.r() == null) {
            q.f fVar = this.mLayoutWidget;
            fVar.z0(fVar.f12922o);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.r());
        }
        Iterator it = this.mLayoutWidget.n1().iterator();
        while (it.hasNext()) {
            q.e eVar = (q.e) it.next();
            View view = (View) eVar.q();
            if (view != null) {
                if (eVar.f12922o == null && (id = view.getId()) != -1) {
                    eVar.f12922o = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar.r() == null) {
                    eVar.z0(eVar.f12922o);
                    Log.v(TAG, " setDebugName " + eVar.r());
                }
            }
        }
        this.mLayoutWidget.M(sb);
        return sb.toString();
    }

    public View getViewById(int i3) {
        return this.mChildrenByIds.get(i3);
    }

    public final q.e getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).widget;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).widget;
        }
        return null;
    }

    protected boolean isRtl() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i3) {
        if (i3 == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.c(getContext(), this, i3);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            b bVar = (b) childAt.getLayoutParams();
            q.e eVar = bVar.widget;
            if ((childAt.getVisibility() != 8 || bVar.isGuideline || bVar.isHelper || bVar.isVirtualGroup || isInEditMode) && !bVar.isInPlaceholder) {
                int V3 = eVar.V();
                int W3 = eVar.W();
                childAt.layout(V3, W3, eVar.U() + V3, eVar.v() + W3);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.mConstraintHelpers.get(i8).i(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.mOnMeasureWidthMeasureSpec == i3) {
            int i5 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                }
                if (getChildAt(i6).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i6++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i3;
        this.mOnMeasureHeightMeasureSpec = i4;
        this.mLayoutWidget.U1(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (g()) {
                this.mLayoutWidget.W1();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i3, i4);
        resolveMeasuredDimension(i3, i4, this.mLayoutWidget.U(), this.mLayoutWidget.v(), this.mLayoutWidget.M1(), this.mLayoutWidget.K1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        q.e viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof q.g)) {
            b bVar = (b) view.getLayoutParams();
            q.g gVar = new q.g();
            bVar.widget = gVar;
            bVar.isGuideline = true;
            gVar.w1(bVar.orientation);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.m();
            ((b) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(bVar2)) {
                this.mConstraintHelpers.add(bVar2);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.p1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i3) {
        this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.c(getContext(), this, i3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        d();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int i3, int i4, int i5, int i6, boolean z3, boolean z4) {
        c cVar = this.mMeasurer;
        int i7 = cVar.f4361e;
        int resolveSizeAndState = View.resolveSizeAndState(i5 + cVar.f4360d, i3, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i6 + i7, i4, 0) & 16777215;
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, resolveSizeAndState2);
        if (z3) {
            min |= 16777216;
        }
        if (z4) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    protected void resolveSystem(q.f fVar, int i3, int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i6 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i4, i5, max, max2, paddingWidth, i6);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            max4 = Math.max(0, getPaddingLeft());
        } else if (!isRtl()) {
            max4 = max3;
        }
        int i7 = size - paddingWidth;
        int i8 = size2 - i6;
        setSelfDimensionBehaviour(fVar, mode, i7, mode2, i8);
        fVar.N1(i3, mode, i7, mode2, i8, this.mLastMeasureWidth, this.mLastMeasureHeight, max4, max);
    }

    public void setConstraintSet(d dVar) {
        this.mConstraintSet = dVar;
    }

    public void setDesignInformation(int i3, Object obj, Object obj2) {
        if (i3 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(str, num);
        }
    }

    @Override // android.view.View
    public void setId(int i3) {
        this.mChildrenByIds.remove(getId());
        super.setId(i3);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(e eVar) {
        androidx.constraintlayout.widget.c cVar = this.mConstraintLayoutSpec;
        if (cVar != null) {
            cVar.c(eVar);
        }
    }

    public void setOptimizationLevel(int i3) {
        this.mOptimizationLevel = i3;
        this.mLayoutWidget.S1(i3);
    }

    protected void setSelfDimensionBehaviour(q.f fVar, int i3, int i4, int i5, int i6) {
        e.b bVar;
        c cVar = this.mMeasurer;
        int i7 = cVar.f4361e;
        int i8 = cVar.f4360d;
        e.b bVar2 = e.b.FIXED;
        int childCount = getChildCount();
        if (i3 == Integer.MIN_VALUE) {
            bVar = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.mMinWidth);
            }
        } else if (i3 == 0) {
            bVar = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.mMinWidth);
            }
            i4 = 0;
        } else if (i3 != 1073741824) {
            bVar = bVar2;
            i4 = 0;
        } else {
            i4 = Math.min(this.mMaxWidth - i8, i4);
            bVar = bVar2;
        }
        if (i5 == Integer.MIN_VALUE) {
            bVar2 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.mMinHeight);
            }
        } else if (i5 != 0) {
            if (i5 == 1073741824) {
                i6 = Math.min(this.mMaxHeight - i7, i6);
            }
            i6 = 0;
        } else {
            bVar2 = e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i6 = Math.max(0, this.mMinHeight);
            }
            i6 = 0;
        }
        if (i4 != fVar.U() || i6 != fVar.v()) {
            fVar.J1();
        }
        fVar.i1(0);
        fVar.j1(0);
        fVar.T0(this.mMaxWidth - i8);
        fVar.S0(this.mMaxHeight - i7);
        fVar.W0(0);
        fVar.V0(0);
        fVar.M0(bVar);
        fVar.g1(i4);
        fVar.c1(bVar2);
        fVar.I0(i6);
        fVar.W0(this.mMinWidth - i8);
        fVar.V0(this.mMinHeight - i7);
    }

    public void setState(int i3, int i4, int i5) {
        androidx.constraintlayout.widget.c cVar = this.mConstraintLayoutSpec;
        if (cVar != null) {
            cVar.d(i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new q.f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Preference.DEFAULT_ORDER;
        this.mMaxHeight = Preference.DEFAULT_ORDER;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        c(attributeSet, i3, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;
        boolean heightSet;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        q.e widget;
        boolean widthSet;
        public int wrapBehaviorInParent;

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f4356a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f4356a = sparseIntArray;
                sparseIntArray.append(g.f4711q2, 64);
                sparseIntArray.append(g.f4620T1, 65);
                sparseIntArray.append(g.f4655c2, 8);
                sparseIntArray.append(g.f4659d2, 9);
                sparseIntArray.append(g.f4667f2, 10);
                sparseIntArray.append(g.f4671g2, 11);
                sparseIntArray.append(g.f4695m2, 12);
                sparseIntArray.append(g.f4691l2, 13);
                sparseIntArray.append(g.f4580J1, 14);
                sparseIntArray.append(g.f4576I1, 15);
                sparseIntArray.append(g.f4560E1, 16);
                sparseIntArray.append(g.f4568G1, 52);
                sparseIntArray.append(g.f4564F1, 53);
                sparseIntArray.append(g.f4584K1, 2);
                sparseIntArray.append(g.f4592M1, 3);
                sparseIntArray.append(g.f4588L1, 4);
                sparseIntArray.append(g.f4731v2, 49);
                sparseIntArray.append(g.f4735w2, 50);
                sparseIntArray.append(g.f4608Q1, 5);
                sparseIntArray.append(g.f4612R1, 6);
                sparseIntArray.append(g.f4616S1, 7);
                sparseIntArray.append(g.f4746z1, 67);
                sparseIntArray.append(g.f4702o1, 1);
                sparseIntArray.append(g.f4675h2, 17);
                sparseIntArray.append(g.f4679i2, 18);
                sparseIntArray.append(g.f4604P1, 19);
                sparseIntArray.append(g.f4600O1, 20);
                sparseIntArray.append(g.f4545A2, 21);
                sparseIntArray.append(g.f4557D2, 22);
                sparseIntArray.append(g.f4549B2, 23);
                sparseIntArray.append(g.f4743y2, 24);
                sparseIntArray.append(g.f4553C2, 25);
                sparseIntArray.append(g.f4747z2, 26);
                sparseIntArray.append(g.f4739x2, 55);
                sparseIntArray.append(g.f4561E2, 54);
                sparseIntArray.append(g.f4640Y1, 29);
                sparseIntArray.append(g.f4699n2, 30);
                sparseIntArray.append(g.f4596N1, 44);
                sparseIntArray.append(g.f4647a2, 45);
                sparseIntArray.append(g.f4707p2, 46);
                sparseIntArray.append(g.f4643Z1, 47);
                sparseIntArray.append(g.f4703o2, 48);
                sparseIntArray.append(g.f4552C1, 27);
                sparseIntArray.append(g.f4548B1, 28);
                sparseIntArray.append(g.f4715r2, 31);
                sparseIntArray.append(g.f4624U1, 32);
                sparseIntArray.append(g.f4723t2, 33);
                sparseIntArray.append(g.f4719s2, 34);
                sparseIntArray.append(g.f4727u2, 35);
                sparseIntArray.append(g.f4632W1, 36);
                sparseIntArray.append(g.f4628V1, 37);
                sparseIntArray.append(g.f4636X1, 38);
                sparseIntArray.append(g.f4651b2, 39);
                sparseIntArray.append(g.f4687k2, 40);
                sparseIntArray.append(g.f4663e2, 41);
                sparseIntArray.append(g.f4572H1, 42);
                sparseIntArray.append(g.f4556D1, 43);
                sparseIntArray.append(g.f4683j2, 51);
                sparseIntArray.append(g.f4569G2, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new q.e();
            this.helped = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f4698n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = a.f4356a.get(index);
                switch (i4) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId == -1) {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f3 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f3;
                        if (f3 < 0.0f) {
                            this.circleAngle = (360.0f - f3) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 == -1) {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 == -1) {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 == -1) {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 == -1) {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 == -1) {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 == -1) {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 == -1) {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case COUIViewDragHelper.EDGE_ALL /* 15 */:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 == -1) {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 == -1) {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 == -1) {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 == -1) {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 == -1) {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 == -1) {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i5;
                        if (i5 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS /* 32 */:
                        int i6 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i6;
                        if (i6 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                d.q(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.baselineToTop);
                                this.baselineToTop = resourceId15;
                                if (resourceId15 == -1) {
                                    this.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.baselineToBottom);
                                this.baselineToBottom = resourceId16;
                                if (resourceId16 == -1) {
                                    this.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                break;
                            case 55:
                                this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                break;
                            default:
                                switch (i4) {
                                    case 64:
                                        d.o(this, obtainStyledAttributes, index, 0);
                                        this.widthSet = true;
                                        break;
                                    case 65:
                                        d.o(this, obtainStyledAttributes, index, 1);
                                        this.heightSet = true;
                                        break;
                                    case 66:
                                        this.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, this.wrapBehaviorInParent);
                                        break;
                                    case 67:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public q.e getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            q.e eVar = this.widget;
            if (eVar != null) {
                eVar.r0();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public void setWidgetDebugName(String str) {
            this.widget.z0(str);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int i3 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i3 == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i4 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i4 == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.horizontalDimensionFixed = false;
                if (i3 == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i4 == 0 || i4 == -1) {
                this.verticalDimensionFixed = false;
                if (i4 == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent == -1.0f && this.guideBegin == -1 && this.guideEnd == -1) {
                return;
            }
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (!(this.widget instanceof q.g)) {
                this.widget = new q.g();
            }
            ((q.g) this.widget).w1(this.orientation);
        }

        public b(int i3, int i4) {
            super(i3, i4);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new q.e();
            this.helped = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new q.e();
            this.helped = false;
        }
    }
}
