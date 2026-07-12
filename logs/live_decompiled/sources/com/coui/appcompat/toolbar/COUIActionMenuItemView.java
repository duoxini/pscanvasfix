package com.coui.appcompat.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.Z;
import e0.AbstractC0342a;
import g2.c;
import java.lang.reflect.Field;
import r0.C0560b;
import v0.AbstractC0608a;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class COUIActionMenuItemView extends ActionMenuItemView {
    private static final String TAG = "COUIActionMenuItemView";
    private int mIconMenuMinWidth;
    private boolean mIsText;
    private int mMarginEnd;
    private C0560b mMaskRippleDrawable;
    private int mPaddingHorizontal;
    private int mPaddingVertical;
    private int mTextMenuItemMaxWidth;
    private int mTextPaddingHorizontal;
    private int mTextPaddingVertical;

    public COUIActionMenuItemView(Context context) {
        this(context, null);
    }

    private void configMenuIconBackground() {
        C0560b c0560b = new C0560b(getContext());
        this.mMaskRippleDrawable = c0560b;
        c0560b.v(C0560b.t(getContext(), 0));
        setBackground(this.mMaskRippleDrawable);
        AbstractC0342a.b(this, false);
    }

    private void setReflectField(Class cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e3) {
            Log.e(TAG, "setReflectField error: " + e3.getMessage());
        }
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "android.widget.Button";
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i3) {
        super.initialize(menuItemImpl, i3);
        this.mIsText = menuItemImpl.getIcon() == null;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.mIsText) {
            AbstractC0608a.b(this);
            setMaxWidth(this.mTextMenuItemMaxWidth);
        } else {
            setReflectField(ActionMenuItemView.class, this, "mMinWidth", Integer.valueOf(this.mIconMenuMinWidth));
            configMenuIconBackground();
            int i4 = this.mPaddingHorizontal;
            int i5 = this.mPaddingVertical;
            setPadding(i4, i5, i4, i5);
        }
        boolean z3 = this.mIsText;
        layoutParams.height = z3 ? -2 : -1;
        if (!z3 && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(this.mMarginEnd);
        }
        setLayoutParams(layoutParams);
    }

    public boolean isTextMenuItem() {
        return this.mIsText;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MenuItemImpl itemData = getItemData();
        if (itemData == null || itemData.getIcon() == null) {
            return;
        }
        this.mMarginEnd = getContext().createConfigurationContext(configuration).getResources().getDimensionPixelSize(c.f11752d);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(this.mMarginEnd);
        }
        Z.a(this, null);
    }

    public void refresh() {
        C0560b c0560b = this.mMaskRippleDrawable;
        if (c0560b != null) {
            c0560b.u(getContext());
        }
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        super.setIcon(drawable);
        Z.a(this, null);
    }

    void setItemWithGap(boolean z3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.mIsText && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (z3) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(this.mMarginEnd);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        Z.a(this, null);
    }

    public COUIActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIActionMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPaddingHorizontal = context.getResources().getDimensionPixelSize(c.f11749b0);
        this.mPaddingVertical = context.getResources().getDimensionPixelSize(c.f11751c0);
        this.mTextPaddingHorizontal = context.getResources().getDimensionPixelSize(c.f11779q0);
        this.mTextPaddingVertical = context.getResources().getDimensionPixelSize(c.f11781r0);
        this.mMarginEnd = context.getResources().getDimensionPixelSize(c.f11752d);
        this.mIconMenuMinWidth = context.getResources().getDimensionPixelSize(c.f11750c);
        this.mTextMenuItemMaxWidth = context.getResources().getDimensionPixelSize(c.f11748b);
    }
}
