package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ToolbarUtils {
    private static final Comparator<View> VIEW_TOP_COMPARATOR = new Comparator<View>() { // from class: com.google.android.material.internal.ToolbarUtils.1
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    };

    private ToolbarUtils() {
    }

    public static ActionMenuItemView getActionMenuItemView(Toolbar toolbar, int i3) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null) {
            return null;
        }
        for (int i4 = 0; i4 < actionMenuView.getChildCount(); i4++) {
            View childAt = actionMenuView.getChildAt(i4);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i3) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    public static ActionMenuView getActionMenuView(Toolbar toolbar) {
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private static ImageView getImageView(Toolbar toolbar, Drawable drawable) {
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ImageView) {
                ImageView imageView = (ImageView) childAt;
                if (drawable != null && imageView.getDrawable().getConstantState().equals(drawable.getConstantState())) {
                    return imageView;
                }
            }
        }
        return null;
    }

    public static ImageView getLogoImageView(Toolbar toolbar) {
        return getImageView(toolbar, toolbar.getLogo());
    }

    public static ImageButton getNavigationIconButton(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static View getSecondaryActionMenuItemView(Toolbar toolbar) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null || actionMenuView.getChildCount() <= 1) {
            return null;
        }
        return actionMenuView.getChildAt(0);
    }

    public static TextView getSubtitleTextView(Toolbar toolbar) {
        List<TextView> textViewsWithText = getTextViewsWithText(toolbar, toolbar.getSubtitle());
        if (textViewsWithText.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(textViewsWithText, VIEW_TOP_COMPARATOR);
    }

    private static List<TextView> getTextViewsWithText(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static TextView getTitleTextView(Toolbar toolbar) {
        List<TextView> textViewsWithText = getTextViewsWithText(toolbar, toolbar.getTitle());
        if (textViewsWithText.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(textViewsWithText, VIEW_TOP_COMPARATOR);
    }
}
