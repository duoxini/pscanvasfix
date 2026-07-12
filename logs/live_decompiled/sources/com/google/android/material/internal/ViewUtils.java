package com.google.android.material.internal;

import H0.j;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.J;
import androidx.core.view.t;
import androidx.core.view.y;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        J onApplyWindowInsets(View view, J j3, RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static void addOnGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void doOnApplyWindowInsets(View view, AttributeSet attributeSet, int i3, int i4) {
        doOnApplyWindowInsets(view, attributeSet, i3, i4, null);
    }

    public static float dpToPx(Context context, int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static Integer getBackgroundColor(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    public static ViewGroup getContentView(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ViewOverlayImpl getContentViewOverlay(View view) {
        return getOverlay(getContentView(view));
    }

    public static ViewOverlayImpl getOverlay(View view) {
        if (view == null) {
            return null;
        }
        return new ViewOverlayApi18(view);
    }

    public static float getParentAbsoluteElevation(View view) {
        float f3 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f3 += y.t((View) parent);
        }
        return f3;
    }

    public static boolean isLayoutRtl(View view) {
        return y.x(view) == 1;
    }

    public static PorterDuff.Mode parseTintMode(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                return PorterDuff.Mode.SCREEN;
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void removeOnGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            removeOnGlobalLayoutListener(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void requestApplyInsetsWhenAttached(View view) {
        if (y.N(view)) {
            y.f0(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    y.f0(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static void requestFocusAndShowKeyboard(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static void doOnApplyWindowInsets(View view, AttributeSet attributeSet, int i3, int i4, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, j.f830r2, i3, i4);
        final boolean z3 = obtainStyledAttributes.getBoolean(j.f834s2, false);
        final boolean z4 = obtainStyledAttributes.getBoolean(j.f838t2, false);
        final boolean z5 = obtainStyledAttributes.getBoolean(j.f842u2, false);
        obtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public J onApplyWindowInsets(View view2, J j3, RelativePadding relativePadding) {
                if (z3) {
                    relativePadding.bottom += j3.h();
                }
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(view2);
                if (z4) {
                    if (isLayoutRtl) {
                        relativePadding.end += j3.i();
                    } else {
                        relativePadding.start += j3.i();
                    }
                }
                if (z5) {
                    if (isLayoutRtl) {
                        relativePadding.start += j3.j();
                    } else {
                        relativePadding.end += j3.j();
                    }
                }
                relativePadding.applyToView(view2);
                OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view2, j3, relativePadding) : j3;
            }
        });
    }

    public static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i3, int i4, int i5, int i6) {
            this.start = i3;
            this.top = i4;
            this.end = i5;
            this.bottom = i6;
        }

        public void applyToView(View view) {
            y.y0(view, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }

    public static void doOnApplyWindowInsets(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(y.C(view), view.getPaddingTop(), y.B(view), view.getPaddingBottom());
        y.x0(view, new t() { // from class: com.google.android.material.internal.ViewUtils.3
            @Override // androidx.core.view.t
            public J onApplyWindowInsets(View view2, J j3) {
                return OnApplyWindowInsetsListener.this.onApplyWindowInsets(view2, j3, new RelativePadding(relativePadding));
            }
        });
        requestApplyInsetsWhenAttached(view);
    }
}
