package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.poplist.A;
import com.coui.appcompat.reddot.COUIHintRedDot;

/* loaded from: classes.dex */
public class COUIPreference extends Preference implements b, COUIRecyclerView.b {
    public static final int CIRCLE = 0;
    static final int DEFAULT_RADIUS = 14;
    static final int DEFAULT_SCALE = 3;
    public static final int FORCE_CLICK = 1;
    public static final int FORCE_UNCLICK = 2;
    static final int MAX_RADIUS = 36;
    static final int MIN_RADIUS = 14;
    public static final int NORMAL = 0;
    static final int NO_ICON_HEIGHT = 0;
    public static final int ROUND = 1;
    public static final int SUMMARY_LINE_DEFAULT = 0;
    public static final int SUMMARY_LINE_ONE = 1;
    public static final int SUMMARY_LINE_TWO = 2;
    private static final String TAG = "COUIPreference-";
    static final int ratio = 6;
    private COUIHintRedDot assignRedDot;
    private COUIRoundImageView assignmentIcon;
    private COUIHintRedDot endRedDot;
    private View iconRedDot;
    private Drawable mAssignIconRes;
    private int mAssignRedDotMode;
    private CharSequence mAssignment;
    private int mAssignmentColor;
    private int mClickStyle;
    private Context mContext;
    private boolean mCouiSetDefaultColor;
    private int mCouiSummaryLineLimit;
    private int mDividerDefaultHorizontalPadding;
    private int mEndRedDotMode;
    private int mEndRedDotNum;
    private boolean mHasBorder;
    private int mIconRedDotMode;
    private int mIconStyle;
    private boolean mIsBackgroundAnimationEnabled;
    private boolean mIsCustom;
    private boolean mIsEnableClickSpan;
    private boolean mIsSelected;
    private boolean mIsSupportCardUse;
    private View mItemView;
    Drawable mJumpRes;
    private A mPreciseHelper;
    protected A.c mPreciseListener;
    private int mRadius;
    private boolean mShowDivider;
    CharSequence mStatusText1;
    private ColorStateList mSummaryTextColor;
    private TextView mSummaryView;
    private ColorStateList mTitleTextColor;
    private TextView mTitleView;

    class a implements A.c {
        a() {
        }

        @Override // com.coui.appcompat.poplist.A.c
        public void a(View view, int i3, int i4) {
            COUIPreference.this.mPreciseListener.a(view, i3, i4);
        }
    }

    public COUIPreference(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.mItemView == null || this.mPreciseListener == null) {
            return;
        }
        removePreciseClickListener();
        A a3 = new A(this.mItemView, new a());
        this.mPreciseHelper = a3;
        a3.d();
    }

    public void changeEndRedDotNumberWithAnim(int i3) {
        if (this.endRedDot != null) {
            this.mEndRedDotNum = i3;
            this.endRedDot.l(i3);
            if (i3 > 0) {
                this.endRedDot.setPointNumber(i3);
            }
        }
    }

    public void dismissAssignRedDot() {
        if (this.assignRedDot == null || this.assignRedDot.getVisibility() != 0) {
            return;
        }
        this.assignRedDot.n(false);
        notifyChanged();
    }

    public void dismissEndRedDot() {
        if (this.endRedDot == null || this.endRedDot.getVisibility() != 0) {
            return;
        }
        this.endRedDot.n(false);
        notifyChanged();
    }

    public void dismissIconRedDot() {
        View view = this.iconRedDot;
        if ((view instanceof COUIHintRedDot) && view.getVisibility() == 0) {
            ((COUIHintRedDot) this.iconRedDot).n(false);
            notifyChanged();
        }
    }

    public boolean drawDivider() {
        if (!this.mShowDivider || !(this.mItemView instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int b3 = com.coui.appcompat.cardlist.a.b(this);
        return b3 == 1 || b3 == 2;
    }

    public int getAssignRedDotMode() {
        return this.mAssignRedDotMode;
    }

    public CharSequence getAssignment() {
        return this.mAssignment;
    }

    public int getBorderRectRadius(int i3) {
        return (i3 == 1 || i3 == 2 || i3 != 3) ? 14 : 16;
    }

    public int getClickStyle() {
        return this.mClickStyle;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return null;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerEndInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.mTitleView;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public int getDividerStartInset() {
        return this.mDividerDefaultHorizontalPadding;
    }

    public int getEndRedDotMode() {
        return this.mEndRedDotMode;
    }

    public int getEndRedDotNum() {
        return this.mEndRedDotNum;
    }

    public int getIconRedDotMode() {
        return this.mIconRedDotMode;
    }

    public int getIconStyle() {
        return this.mIconStyle;
    }

    public boolean getIsSelected() {
        return this.mIsSelected;
    }

    public CharSequence getStatusText1() {
        return this.mStatusText1;
    }

    public boolean isShowDivider() {
        return this.mShowDivider;
    }

    @Override // com.coui.appcompat.preference.b
    public boolean isSupportCardUse() {
        return this.mIsSupportCardUse;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.preference.l r11) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.preference.COUIPreference.onBindViewHolder(androidx.preference.l):void");
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        removePreciseClickListener();
        super.onDetached();
    }

    public void removePreciseClickListener() {
        A a3 = this.mPreciseHelper;
        if (a3 != null) {
            a3.e();
            this.mPreciseHelper = null;
        }
    }

    public void setAssignIconRes(Drawable drawable) {
        if (this.mAssignIconRes != drawable) {
            this.mAssignIconRes = drawable;
            notifyChanged();
        }
    }

    public void setAssignRedDotMode(int i3) {
        if (this.mAssignRedDotMode != i3) {
            this.mAssignRedDotMode = i3;
            notifyChanged();
        }
    }

    public void setAssignment(CharSequence charSequence) {
        if (TextUtils.equals(this.mAssignment, charSequence)) {
            return;
        }
        this.mAssignment = charSequence;
        notifyChanged();
    }

    public void setAssignmentColor(int i3) {
        if (this.mAssignmentColor != i3) {
            this.mAssignmentColor = i3;
            notifyChanged();
        }
    }

    public void setBackgroundAnimationEnabled(boolean z3) {
        if (this.mIsBackgroundAnimationEnabled != z3) {
            this.mIsBackgroundAnimationEnabled = z3;
            notifyChanged();
        }
    }

    public void setBorderRectRadius(int i3) {
        if (this.mRadius != i3) {
            this.mRadius = i3;
            notifyChanged();
        }
    }

    public void setClickStyle(int i3) {
        this.mClickStyle = i3;
    }

    public void setCouiSummaryLine(int i3) {
        if (this.mCouiSummaryLineLimit != i3) {
            this.mCouiSummaryLineLimit = i3;
            notifyChanged();
        }
    }

    public void setEndRedDotMode(int i3) {
        if (this.mEndRedDotMode != i3) {
            this.mEndRedDotMode = i3;
            notifyChanged();
        }
    }

    public void setEndRedDotNum(int i3) {
        if (this.mEndRedDotNum != i3) {
            this.mEndRedDotNum = i3;
            notifyChanged();
        }
    }

    public void setIconRedDotMode(int i3) {
        if (this.mIconRedDotMode != i3) {
            this.mIconRedDotMode = i3;
            notifyChanged();
        }
    }

    public void setIconStyle(int i3) {
        if (i3 == 0 || i3 == 1) {
            this.mIconStyle = i3;
            notifyChanged();
        }
    }

    public void setIsCustomIconRadius(boolean z3) {
        this.mIsCustom = z3;
    }

    public void setIsEnableClickSpan(boolean z3) {
        this.mIsEnableClickSpan = z3;
    }

    public void setIsSupportCardUse(boolean z3) {
        this.mIsSupportCardUse = z3;
    }

    public void setJump(Drawable drawable) {
        if (this.mJumpRes != drawable) {
            this.mJumpRes = drawable;
            notifyChanged();
        }
    }

    public void setOnPreciseClickListener(A.c cVar) {
        this.mPreciseListener = cVar;
        i();
    }

    public void setSelected(boolean z3) {
        if (this.mIsSelected != z3) {
            this.mIsSelected = z3;
            notifyChanged();
        }
    }

    public void setSelectedState(boolean z3) {
        this.mIsSelected = z3;
    }

    public void setShowDivider(boolean z3) {
        if (this.mShowDivider != z3) {
            this.mShowDivider = z3;
            notifyChanged();
        }
    }

    public void setStatusText1(CharSequence charSequence) {
        if ((charSequence != null || this.mStatusText1 == null) && (charSequence == null || charSequence.equals(this.mStatusText1))) {
            return;
        }
        this.mStatusText1 = charSequence;
        notifyChanged();
    }

    public void setSummaryTextColor(ColorStateList colorStateList) {
        this.mSummaryTextColor = colorStateList;
        notifyChanged();
    }

    public void setTitleColor(ColorStateList colorStateList) {
        if (this.mTitleTextColor != colorStateList) {
            this.mTitleTextColor = colorStateList;
            notifyChanged();
        }
    }

    public void showAssignRedDot() {
        if (this.assignRedDot != null) {
            this.assignRedDot.n(true);
            notifyChanged();
        }
    }

    public void showEndRedDot() {
        if (this.endRedDot != null) {
            this.endRedDot.n(true);
            notifyChanged();
        }
    }

    public void showIconRedDot() {
        View view = this.iconRedDot;
        if (view instanceof COUIHintRedDot) {
            ((COUIHintRedDot) view).n(true);
            notifyChanged();
        }
    }

    public COUIPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f6037i);
    }

    public COUIPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUIPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mShowDivider = true;
        this.mClickStyle = 0;
        this.mIsSelected = false;
        this.mIsBackgroundAnimationEnabled = true;
        this.mIsCustom = false;
        this.mTitleTextColor = null;
        this.mSummaryTextColor = null;
        this.mCouiSetDefaultColor = false;
        this.mCouiSummaryLineLimit = 0;
        this.mContext = context;
        this.mDividerDefaultHorizontalPadding = context.getResources().getDimensionPixelSize(W1.c.f2610A);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, i3, i4);
        this.mShowDivider = obtainStyledAttributes.getBoolean(W1.h.f2804l0, this.mShowDivider);
        this.mIsEnableClickSpan = obtainStyledAttributes.getBoolean(W1.h.f2794g0, false);
        this.mJumpRes = obtainStyledAttributes.getDrawable(W1.h.f2812p0);
        this.mAssignIconRes = obtainStyledAttributes.getDrawable(W1.h.f2810o0);
        this.mStatusText1 = obtainStyledAttributes.getText(W1.h.f2814q0);
        this.mClickStyle = obtainStyledAttributes.getInt(W1.h.f2790e0, 0);
        this.mAssignment = obtainStyledAttributes.getText(W1.h.f2784b0);
        this.mAssignmentColor = obtainStyledAttributes.getInt(W1.h.f2786c0, 0);
        this.mIconStyle = obtainStyledAttributes.getInt(W1.h.f2796h0, 1);
        this.mHasBorder = obtainStyledAttributes.getBoolean(W1.h.f2820t0, false);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(W1.h.f2828x0, 14);
        this.mIconRedDotMode = obtainStyledAttributes.getInt(W1.h.f2822u0, 0);
        this.mEndRedDotMode = obtainStyledAttributes.getInt(W1.h.f2816r0, 0);
        this.mAssignRedDotMode = obtainStyledAttributes.getInt(W1.h.f2782a0, 0);
        this.mEndRedDotNum = obtainStyledAttributes.getInt(W1.h.f2818s0, 0);
        this.mIsBackgroundAnimationEnabled = obtainStyledAttributes.getBoolean(W1.h.f2824v0, true);
        this.mIsSupportCardUse = obtainStyledAttributes.getBoolean(W1.h.f2826w0, true);
        boolean z3 = obtainStyledAttributes.getBoolean(W1.h.f2802k0, false);
        this.mCouiSetDefaultColor = z3;
        if (z3) {
            this.mTitleTextColor = obtainStyledAttributes.getColorStateList(W1.h.f2830y0);
            this.mSummaryTextColor = obtainStyledAttributes.getColorStateList(W1.h.f2806m0);
        }
        this.mIsCustom = obtainStyledAttributes.getBoolean(W1.h.f2800j0, false);
        this.mCouiSummaryLineLimit = obtainStyledAttributes.getInt(W1.h.f2808n0, 0);
        obtainStyledAttributes.recycle();
    }

    public void setJump(int i3) {
        setJump(this.mContext.getResources().getDrawable(i3));
    }
}
