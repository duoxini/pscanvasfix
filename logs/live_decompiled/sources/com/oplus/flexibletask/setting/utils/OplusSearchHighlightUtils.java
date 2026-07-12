package com.oplus.flexibletask.setting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.h;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.preference.ListSelectedItemLayout;
import e0.AbstractC0342a;

/* loaded from: classes.dex */
public class OplusSearchHighlightUtils {
    public static final String ARGS_KEY = ":settings:fragment_args_key";
    private static final int DELAY_TIME = 150;
    public static final int HIGHT_LIGHT_COLOR_PREFERENCE_DARK = -13487566;
    public static final int HIGHT_LIGHT_COLOR_PREFERENCE_DEFAULT = -1776412;
    public static final int HIGH_LIGHT_TIME_DEFAULT = 1000;
    private static final int LAST_TIME = 500;
    private static final int START_TIME = 100;
    private static final int STOP_TIME = 250;
    public static final int WAIT_TIME_DEFAULT = 500;

    private static void calculateHighlight(final RecyclerView recyclerView, final String str, final int i3, final boolean z3, final int i4) {
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.oplus.flexibletask.setting.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    OplusSearchHighlightUtils.lambda$calculateHighlight$0(RecyclerView.this, str, i4, i3, z3);
                }
            });
        }
    }

    private static void calculatehighlight(PreferenceScreen preferenceScreen, RecyclerView recyclerView, String str, int i3, int i4) {
        Preference k3 = preferenceScreen.k(str);
        if (k3 != null) {
            calculateHighlight(recyclerView, str, i3, k3 instanceof PreferenceCategory, i4);
        }
    }

    @SuppressLint({"RestrictedApi"})
    private static int canUseRecyclerViewForHighlighting(RecyclerView recyclerView, String str) {
        RecyclerView.h adapter = recyclerView.getAdapter();
        if (adapter == null || !(adapter instanceof h)) {
            return -1;
        }
        return ((h) adapter).d(str);
    }

    private static AnimationDrawable getAnimationDrawable(int i3, Drawable drawable) {
        double d3;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        int i4 = 0;
        while (true) {
            d3 = 0.0d;
            if (i4 >= 6) {
                break;
            }
            ColorDrawable colorDrawable = new ColorDrawable(i3);
            colorDrawable.setAlpha((int) (((i4 + 0.0d) * 255.0d) / 6));
            if (drawable != null) {
                animationDrawable.addFrame(new LayerDrawable(new Drawable[]{drawable, colorDrawable}), 16);
            } else {
                animationDrawable.addFrame(colorDrawable, 16);
            }
            i4++;
        }
        animationDrawable.addFrame(new ColorDrawable(i3), STOP_TIME);
        int i5 = 0;
        while (i5 < 31) {
            double d4 = (((31 - i5) - d3) * 255.0d) / 31;
            ColorDrawable colorDrawable2 = new ColorDrawable(i3);
            colorDrawable2.setAlpha((int) d4);
            if (drawable != null) {
                animationDrawable.addFrame(new LayerDrawable(new Drawable[]{drawable, colorDrawable2}), 16);
            } else {
                animationDrawable.addFrame(colorDrawable2, 16);
                if (i5 == 30) {
                    animationDrawable.addFrame(new ColorDrawable(0), 300);
                }
            }
            i5++;
            d3 = 0.0d;
        }
        if (drawable != null) {
            animationDrawable.addFrame(drawable, DELAY_TIME);
        }
        animationDrawable.setOneShot(true);
        return animationDrawable;
    }

    public static void highlightPreference(PreferenceScreen preferenceScreen, RecyclerView recyclerView, Bundle bundle, Context context) {
        highlightPreference(preferenceScreen, recyclerView, bundle, 0, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$calculateHighlight$0(RecyclerView recyclerView, String str, int i3, int i4, boolean z3) {
        int canUseRecyclerViewForHighlighting = canUseRecyclerViewForHighlighting(recyclerView, str);
        if (canUseRecyclerViewForHighlighting > 1) {
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            if (i3 == 0) {
                layoutManager.A1(canUseRecyclerViewForHighlighting);
            } else if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).D2(canUseRecyclerViewForHighlighting, i3);
            }
        }
        if (canUseRecyclerViewForHighlighting >= 0) {
            showHighlight(recyclerView, canUseRecyclerViewForHighlighting, i4, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showHighlight$1(RecyclerView recyclerView, int i3, int i4) {
        final View childAt;
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        int c22 = layoutManager instanceof LinearLayoutManager ? i3 - ((LinearLayoutManager) layoutManager).c2() : -1;
        if (c22 < 0 || c22 >= recyclerView.getChildCount() || (childAt = recyclerView.getChildAt(c22)) == null) {
            return;
        }
        if (childAt instanceof ListSelectedItemLayout) {
            ((ListSelectedItemLayout) childAt).d();
            childAt.postDelayed(new Runnable() { // from class: com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    ((ListSelectedItemLayout) childAt).f();
                }
            }, 1000L);
            return;
        }
        final Drawable background = childAt.getBackground();
        AnimationDrawable animationDrawable = getAnimationDrawable(i4, background);
        childAt.setBackground(animationDrawable);
        animationDrawable.start();
        childAt.postDelayed(new Runnable() { // from class: com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils.2
            @Override // java.lang.Runnable
            public void run() {
                childAt.setBackground(background);
            }
        }, 1000L);
    }

    private static void showHighlight(final RecyclerView recyclerView, final int i3, final int i4, boolean z3) {
        if (z3) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.oplus.flexibletask.setting.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                OplusSearchHighlightUtils.lambda$showHighlight$1(RecyclerView.this, i3, i4);
            }
        }, 500L);
    }

    public static void highlightPreference(PreferenceScreen preferenceScreen, RecyclerView recyclerView, Bundle bundle, int i3, Context context) {
        if (preferenceScreen == null || recyclerView == null || bundle == null) {
            return;
        }
        String string = bundle.getString(ARGS_KEY);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        calculatehighlight(preferenceScreen, recyclerView, string, AbstractC0342a.a(context) ? HIGHT_LIGHT_COLOR_PREFERENCE_DARK : HIGHT_LIGHT_COLOR_PREFERENCE_DEFAULT, i3);
    }
}
