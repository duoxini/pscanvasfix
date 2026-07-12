package com.oplus.flexibletask.setting.guide;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.SpannableString;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c0.C0297a;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t1.i;
import t1.j;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public abstract class BaseGuidePagerAdapter extends RecyclerView.h {
    private static final String ASSETS_PATH = "images/";
    private static Boolean DEBUG = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));
    private static final String DIGITAL_ASSISTANCE_FROM_GOOGLE_SETTINGS_GESTURE_KEY = "circle_to_search_gesture_wake_assistance_key";
    private static final String DIGITAL_ASSISTANCE_FROM_GOOGLE_SETTINGS_VIRTUAL_KEY = "circle_to_search_wake_assistance_key";
    private static final int LONG_ANIM_REPEAT_TIME = 3;
    private static final String NAVIGATION_BAR_SETTINGS_ACTIVITY_NAME = "com.oplus.settings.OplusSettingsActivity$NavigationBarSettingsActivity";
    private static final String SETTINGS_PACKAGE_NAME = "com.android.settings";
    private static final int SHORT_ANIM_REPEAT_TIME = 1;
    private static final String TAG = "BaseGuidePagerAdapter";
    protected static Item sButtonOperation;
    protected static Item sControllerMove;
    protected static Item sDownFull;
    protected static Item sDragToShare;
    protected static Item sHandleMove;
    protected static Item sMultiFinger;
    protected static Item sMultiFingerOpenFreeform;
    protected static Item sOpenZoomFromNotification;
    protected static Item sOpenZoomFromSide;
    protected static Item sOperateMiniZoom;
    protected static Item sScaleOpenFreeform;
    protected static Item sSidewardsFloat;
    protected static Item sUpClose;
    protected static Item sUpOpenFreeform;
    protected static Item sZoomScale;
    protected static Item sZoomTransferSplite;
    private final SparseArray<BaseGuideContentView> mViews = new SparseArray<>();
    private boolean mEnablePlayAnim = true;
    private int mCurrentPage = 0;

    protected static final class Item {
        final int mAnimId;
        final int mAnimIdInDark;
        final String mAssetsPath;
        final String mAssetsPathInDark;
        final int mAutoRepeatLimit;
        final int mSummary;
        final int mTextTitle;

        private Item(int i3, int i4, int i5, String str, int i6, String str2, int i7) {
            this.mSummary = i3;
            this.mTextTitle = i4;
            this.mAnimId = i5;
            this.mAssetsPath = str;
            this.mAnimIdInDark = i6;
            this.mAssetsPathInDark = str2;
            this.mAutoRepeatLimit = i7;
        }
    }

    public BaseGuidePagerAdapter(Context context) {
        if (FlexibleSettingHelper.getInstance().isPadScreen()) {
            int i3 = 3;
            sUpOpenFreeform = new Item(j.f13618R, j.f13617Q, i.f13540a1, ASSETS_PATH, i.f13543b1, ASSETS_PATH, i3);
            int i4 = 3;
            sOpenZoomFromSide = new Item(j.f13602B, j.f13601A, i.f13539a0, ASSETS_PATH, i.f13542b0, ASSETS_PATH, i4);
            sZoomScale = new Item(j.f13608H, j.f13607G, i.f13582q0, ASSETS_PATH, i.f13584r0, ASSETS_PATH, i3);
            sOperateMiniZoom = new Item(j.f13667u, j.f13665t, i.f13510M, ASSETS_PATH, i.f13512N, ASSETS_PATH, i4);
            sSidewardsFloat = new Item(j.f13610J, j.f13609I, i.f13491C0, ASSETS_PATH, i.f13493D0, ASSETS_PATH, i3);
            sDragToShare = new Item(j.f13664s0, j.f13662r0, i.f13594w0, ASSETS_PATH, i.f13596x0, ASSETS_PATH, i4);
            sZoomTransferSplite = new Item(j.f13612L, j.f13672w0, i.f13515O0, ASSETS_PATH, i.f13517P0, ASSETS_PATH, i3);
            sMultiFinger = new Item(j.f13673x, j.f13670v0, i.f13526U, ASSETS_PATH, i.f13528V, ASSETS_PATH, i4);
            sOpenZoomFromNotification = new Item(j.f13676z, j.f13675y, i.f13557g0, ASSETS_PATH, i.f13560h0, ASSETS_PATH, i3);
            sUpClose = new Item(j.f13616P, j.f13615O, i.f13527U0, ASSETS_PATH, i.f13529V0, ASSETS_PATH, i4);
            sDownFull = new Item(j.f13657p, j.f13655o, i.f13562i, ASSETS_PATH, i.f13565j, ASSETS_PATH, i3);
            sControllerMove = new Item(j.f13661r, j.f13659q, i.f13589u, ASSETS_PATH, i.f13591v, ASSETS_PATH, i4);
            sHandleMove = new Item(j.f13661r, j.f13659q, i.f13498G, ASSETS_PATH, i.f13500H, ASSETS_PATH, i3);
            sButtonOperation = new Item(j.f13614N, j.f13613M, i.f13503I0, ASSETS_PATH, i.f13505J0, ASSETS_PATH, i4);
            sScaleOpenFreeform = new Item(j.f13605E, j.f13604D, i.f13578o0, ASSETS_PATH, i.f13580p0, ASSETS_PATH, i3);
            sMultiFingerOpenFreeform = new Item(j.f13671w, j.f13669v, i.f13522S, ASSETS_PATH, i.f13524T, ASSETS_PATH, i4);
            return;
        }
        if (!FlexibleSettingHelper.getInstance().isFoldScreen() || FlexibleSettingHelper.getInstance().isFlip()) {
            int i5 = 3;
            sUpOpenFreeform = new Item(j.f13618R, j.f13617Q, i.f13531W0, ASSETS_PATH, i.f13533X0, ASSETS_PATH, i5);
            int i6 = 3;
            sOpenZoomFromSide = new Item(j.f13602B, j.f13601A, i.f13530W, ASSETS_PATH, i.f13532X, ASSETS_PATH, i6);
            sZoomScale = new Item(j.f13608H, j.f13607G, i.f13563i0, ASSETS_PATH, i.f13566j0, ASSETS_PATH, i5);
            sOperateMiniZoom = new Item(j.f13667u, j.f13665t, i.f13502I, ASSETS_PATH, i.f13504J, ASSETS_PATH, i6);
            sSidewardsFloat = new Item(j.f13610J, j.f13609I, i.f13598y0, ASSETS_PATH, i.f13600z0, ASSETS_PATH, i5);
            sDragToShare = new Item(j.f13664s0, j.f13662r0, i.f13586s0, ASSETS_PATH, i.f13588t0, ASSETS_PATH, i6);
            sZoomTransferSplite = new Item(j.f13612L, j.f13672w0, i.f13507K0, ASSETS_PATH, i.f13509L0, ASSETS_PATH, i5);
            sOpenZoomFromNotification = new Item(j.f13676z, j.f13675y, i.f13545c0, ASSETS_PATH, i.f13548d0, ASSETS_PATH, i6);
            sUpClose = new Item(j.f13616P, j.f13615O, i.f13519Q0, ASSETS_PATH, i.f13521R0, ASSETS_PATH, i5);
            sDownFull = new Item(j.f13657p, j.f13655o, i.f13550e, ASSETS_PATH, i.f13553f, ASSETS_PATH, i6);
            sControllerMove = new Item(j.f13661r, j.f13659q, i.f13581q, ASSETS_PATH, i.f13583r, ASSETS_PATH, i5);
            sHandleMove = new Item(j.f13661r, j.f13659q, i.f13490C, ASSETS_PATH, i.f13492D, ASSETS_PATH, i6);
            sButtonOperation = new Item(j.f13614N, j.f13613M, i.f13495E0, ASSETS_PATH, i.f13497F0, ASSETS_PATH, i5);
            return;
        }
        int i7 = 3;
        sUpOpenFreeform = new Item(j.f13618R, j.f13617Q, i.f13535Y0, ASSETS_PATH, i.f13537Z0, ASSETS_PATH, i7);
        int i8 = 3;
        sOpenZoomFromSide = new Item(j.f13602B, j.f13601A, i.f13534Y, ASSETS_PATH, i.f13536Z, ASSETS_PATH, i8);
        sZoomScale = new Item(j.f13608H, j.f13607G, i.f13569k0, ASSETS_PATH, i.f13572l0, ASSETS_PATH, i7);
        sOperateMiniZoom = new Item(j.f13667u, j.f13665t, i.f13506K, ASSETS_PATH, i.f13508L, ASSETS_PATH, i8);
        sSidewardsFloat = new Item(j.f13610J, j.f13609I, i.f13487A0, ASSETS_PATH, i.f13489B0, ASSETS_PATH, i7);
        sDragToShare = new Item(j.f13664s0, j.f13662r0, i.f13590u0, ASSETS_PATH, i.f13592v0, ASSETS_PATH, i8);
        sZoomTransferSplite = new Item(j.f13612L, j.f13672w0, i.f13511M0, ASSETS_PATH, i.f13513N0, ASSETS_PATH, i7);
        sMultiFinger = new Item(j.f13673x, j.f13670v0, i.f13514O, ASSETS_PATH, i.f13516P, ASSETS_PATH, i8);
        sOpenZoomFromNotification = new Item(j.f13676z, j.f13675y, i.f13551e0, ASSETS_PATH, i.f13554f0, ASSETS_PATH, i7);
        sUpClose = new Item(j.f13616P, j.f13615O, i.f13523S0, ASSETS_PATH, i.f13525T0, ASSETS_PATH, i8);
        sDownFull = new Item(j.f13657p, j.f13655o, i.f13556g, ASSETS_PATH, i.f13559h, ASSETS_PATH, i7);
        sControllerMove = new Item(j.f13661r, j.f13659q, i.f13585s, ASSETS_PATH, i.f13587t, ASSETS_PATH, i8);
        sHandleMove = new Item(j.f13661r, j.f13659q, i.f13494E, ASSETS_PATH, i.f13496F, ASSETS_PATH, i7);
        sButtonOperation = new Item(j.f13614N, j.f13613M, i.f13499G0, ASSETS_PATH, i.f13501H0, ASSETS_PATH, i8);
        sScaleOpenFreeform = new Item(j.f13605E, j.f13604D, i.f13574m0, ASSETS_PATH, i.f13576n0, ASSETS_PATH, i7);
        sMultiFingerOpenFreeform = new Item(j.f13671w, j.f13669v, i.f13518Q, ASSETS_PATH, i.f13520R, ASSETS_PATH, i8);
    }

    private BaseGuideContentView getCurrentPageView() {
        return this.mViews.get(this.mCurrentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onBindViewHolder$0(Context context) {
        try {
            ComponentName componentName = new ComponentName(SETTINGS_PACKAGE_NAME, NAVIGATION_BAR_SETTINGS_ACTIVITY_NAME);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            Bundle bundle = new Bundle();
            if (Settings.Secure.getIntForUser(context.getContentResolver(), "navigation_mode", -1, ActivityManager.getCurrentUser()) == 2) {
                bundle.putString(OplusSearchHighlightUtils.ARGS_KEY, DIGITAL_ASSISTANCE_FROM_GOOGLE_SETTINGS_GESTURE_KEY);
            } else {
                bundle.putString(OplusSearchHighlightUtils.ARGS_KEY, DIGITAL_ASSISTANCE_FROM_GOOGLE_SETTINGS_VIRTUAL_KEY);
            }
            intent.putExtra(":settings:show_fragment_args", bundle);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                AbstractC0652e.j(TAG, "NavigationBarSettingsActivity not available");
            } else {
                AbstractC0652e.b(TAG, "Launching NavigationBarSettingsActivity directly");
                context.startActivity(intent);
            }
        } catch (Exception e3) {
            AbstractC0652e.e(TAG, "Failed to launch NavigationBarSettingsActivity", e3);
        }
    }

    protected abstract List<Item> getAvailableItems();

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return getAvailableItems().size();
    }

    public int[] getSummaryTextIds() {
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it = getAvailableItems().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().mSummary));
        }
        return arrayList.stream().mapToInt(new c()).toArray();
    }

    public int[] getTitleTextIds() {
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it = getAvailableItems().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().mTextTitle));
        }
        return arrayList.stream().mapToInt(new c()).toArray();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.E e3, int i3) {
        BaseGuideContentView baseGuideContentView = (BaseGuideContentView) e3.itemView;
        if (baseGuideContentView == null) {
            AbstractC0652e.j(TAG, "onBindViewHolder: guide is null");
            return;
        }
        if (baseGuideContentView.getContext() != null) {
            r2 = (baseGuideContentView.getContext().getResources().getConfiguration().uiMode & 32) != 0;
            if (DEBUG.booleanValue()) {
                AbstractC0652e.b(TAG, "onBindViewHolder: darkMode is " + r2);
            }
        }
        baseGuideContentView.setTitleText(getAvailableItems().get(i3).mTextTitle);
        Item item = getAvailableItems().get(i3);
        if (item == sScaleOpenFreeform && FlexibleSettingHelper.isExportVersion(baseGuideContentView.getContext())) {
            final Context context = baseGuideContentView.getContext();
            String string = context.getString(j.f13619S);
            String string2 = context.getString(j.f13606F, string);
            int indexOf = string2.indexOf(string);
            if (indexOf >= 0) {
                SpannableString spannableString = new SpannableString(string2);
                C0297a c0297a = new C0297a(context);
                c0297a.a(new C0297a.InterfaceC0099a() { // from class: com.oplus.flexibletask.setting.guide.d
                    @Override // c0.C0297a.InterfaceC0099a
                    public final void a() {
                        BaseGuidePagerAdapter.lambda$onBindViewHolder$0(context);
                    }
                });
                spannableString.setSpan(c0297a, indexOf, string.length() + indexOf, 33);
                baseGuideContentView.setSummaryText(spannableString);
            } else {
                baseGuideContentView.setSummaryText(j.f13606F, string);
            }
        } else {
            baseGuideContentView.setSummaryText(item.mSummary);
        }
        if (r2) {
            baseGuideContentView.setAnimResource(getAvailableItems().get(i3).mAnimIdInDark, getAvailableItems().get(i3).mAssetsPathInDark);
        } else {
            baseGuideContentView.setAnimResource(getAvailableItems().get(i3).mAnimId, getAvailableItems().get(i3).mAssetsPath);
        }
        baseGuideContentView.setPosition(i3);
        this.mViews.put(i3, baseGuideContentView);
    }

    protected abstract BaseGuideContentView onCreateGuideContentView(Context context);

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.E onCreateViewHolder(ViewGroup viewGroup, int i3) {
        BaseGuideContentView onCreateGuideContentView = onCreateGuideContentView(viewGroup.getContext());
        onCreateGuideContentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new RecyclerView.E(this, onCreateGuideContentView) { // from class: com.oplus.flexibletask.setting.guide.BaseGuidePagerAdapter.1
        };
    }

    public void onPageSelected(int i3) {
        this.mCurrentPage = i3;
        if (this.mEnablePlayAnim) {
            for (int i4 = 0; i4 < getItemCount(); i4++) {
                BaseGuideContentView baseGuideContentView = this.mViews.get(i4);
                if (baseGuideContentView != null) {
                    if (i3 == baseGuideContentView.getPosition()) {
                        baseGuideContentView.play();
                    } else {
                        baseGuideContentView.stop();
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewAttachedToWindow(RecyclerView.E e3) {
        super.onViewAttachedToWindow(e3);
        BaseGuideContentView baseGuideContentView = (BaseGuideContentView) e3.itemView;
        if (this.mEnablePlayAnim) {
            baseGuideContentView.play();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewDetachedFromWindow(RecyclerView.E e3) {
        super.onViewDetachedFromWindow(e3);
        ((BaseGuideContentView) e3.itemView).stop();
    }

    public void setEnablePlayAnim(boolean z3) {
        if (this.mEnablePlayAnim == z3) {
            return;
        }
        this.mEnablePlayAnim = z3;
        BaseGuideContentView currentPageView = getCurrentPageView();
        if (currentPageView == null) {
            return;
        }
        if (this.mEnablePlayAnim) {
            currentPageView.play();
        } else {
            currentPageView.stop();
        }
    }
}
