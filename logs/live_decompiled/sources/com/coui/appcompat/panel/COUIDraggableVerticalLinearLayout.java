package com.coui.appcompat.panel;

import U1.h;
import U1.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import f.AbstractC0348a;

/* loaded from: classes.dex */
public class COUIDraggableVerticalLinearLayout extends LinearLayout {
    private ImageView mAnimDragView;
    private Drawable mDragViewDrawable;
    private int mDragViewDrawableTintColor;
    private float mElevation;
    private boolean mHasShadowNinePatchDrawable;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mStyle;

    public COUIDraggableVerticalLinearLayout(Context context) {
        this(context, null);
    }

    private void initDragView(AttributeSet attributeSet, int i3, int i4) {
        setOrientation(1);
        this.mAnimDragView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(U1.d.f2394v), (int) getResources().getDimension(U1.d.f2391s));
        layoutParams.gravity = 1;
        this.mAnimDragView.setLayoutParams(layoutParams);
        AbstractC0342a.b(this.mAnimDragView, false);
        setDragViewByTypeArray(getContext().obtainStyledAttributes(attributeSet, i.f2442l, i3, i4));
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i3;
            }
        } else {
            this.mStyle = i3;
        }
        recordPaddingAndElevation();
        addView(this.mAnimDragView);
    }

    private void recordPaddingAndElevation() {
        this.mElevation = getElevation();
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingBottom = getPaddingBottom();
    }

    private void setDragViewByTypeArray(TypedArray typedArray) {
        if (typedArray != null) {
            this.mHasShadowNinePatchDrawable = typedArray.getBoolean(i.f2445o, false);
            int resourceId = typedArray.getResourceId(i.f2443m, U1.e.f2401c);
            int color = typedArray.getColor(i.f2444n, AbstractC0335a.a(getContext(), M1.c.f1361f));
            typedArray.recycle();
            Drawable b3 = AbstractC0348a.b(getContext(), resourceId);
            if (b3 != null) {
                b3.setTint(color);
                this.mAnimDragView.setImageDrawable(b3);
            }
            if (this.mHasShadowNinePatchDrawable) {
                setBackground(getContext().getDrawable(U1.e.f2400b));
            } else {
                setBackground(getContext().getDrawable(U1.e.f2399a));
            }
        }
    }

    public ImageView getDragView() {
        return this.mAnimDragView;
    }

    @Deprecated
    public boolean isHasShadowNinePatchDrawable() {
        return this.mHasShadowNinePatchDrawable;
    }

    public void refresh() {
        TypedArray typedArray = null;
        if (this.mStyle != 0) {
            String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
            if (TextUtils.equals(resourceTypeName, "attr")) {
                typedArray = getContext().getTheme().obtainStyledAttributes(null, i.f2442l, this.mStyle, 0);
            } else if (TextUtils.equals(resourceTypeName, "style")) {
                typedArray = getContext().getTheme().obtainStyledAttributes(null, i.f2442l, 0, this.mStyle);
            }
        }
        setDragViewByTypeArray(typedArray);
        setBackground(getContext().getResources().getDrawable(U1.e.f2400b));
    }

    public void setDragViewDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDragViewDrawable = drawable;
            this.mAnimDragView.setImageDrawable(drawable);
        }
    }

    public void setDragViewDrawableTintColor(int i3) {
        Drawable drawable = this.mDragViewDrawable;
        if (drawable == null || this.mDragViewDrawableTintColor == i3) {
            return;
        }
        this.mDragViewDrawableTintColor = i3;
        drawable.setTint(i3);
        this.mAnimDragView.setImageDrawable(this.mDragViewDrawable);
    }

    @Deprecated
    public void setHasShadowNinePatchDrawable(boolean z3) {
        this.mHasShadowNinePatchDrawable = z3;
        if (z3) {
            setBackground(getContext().getDrawable(U1.e.f2400b));
            setElevation(0.0f);
        } else {
            setBackground(getContext().getDrawable(U1.e.f2399a));
            setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
            setElevation(this.mElevation);
        }
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        super.setOrientation(1);
    }

    public COUIDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, U1.a.f2364b);
    }

    public COUIDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, AbstractC0335a.j(context) ? h.f2429b : h.f2428a);
    }

    public COUIDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mHasShadowNinePatchDrawable = false;
        this.mElevation = 0.0f;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        initDragView(attributeSet, i3, i4);
    }
}
