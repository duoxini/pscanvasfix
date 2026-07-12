package com.oplus.flexibletask.setting.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.indicator.COUIPageIndicator;
import com.coui.appcompat.preference.COUIPreference;
import com.oplus.flexibletask.setting.guide.BaseGuidePagerAdapter;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import java.util.List;
import t1.j;

/* loaded from: classes.dex */
public class GuidePreference extends COUIPreference {
    private static final String TAG = "GuidePreference";
    private SettingPagerAdapter mAdapter;
    private COUIPageIndicator mCOUIPageIndicator;
    private Context mContext;
    private COUICardListSelectedItemLayout mCouiCardListSelectedItemLayout;
    private ViewPager2 mViewPager;
    private final View.OnLayoutChangeListener mViewPagerLayoutListener;

    public GuidePreference(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mViewPagerLayoutListener = new View.OnLayoutChangeListener() { // from class: com.oplus.flexibletask.setting.guide.GuidePreference.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                GuidePreference.this.mViewPager.removeOnLayoutChangeListener(this);
                SettingPagerAdapter settingPagerAdapter = GuidePreference.this.mAdapter;
                GuidePreference guidePreference = GuidePreference.this;
                settingPagerAdapter.setItemHeight(guidePreference.measureItemHeight(guidePreference.mViewPager.getContext(), i6 - i4, GuidePreference.this.mAdapter));
                GuidePreference.this.mViewPager.setAdapter(GuidePreference.this.mAdapter);
            }
        };
    }

    private void initHeader(l lVar) {
        this.mViewPager = (ViewPager2) lVar.itemView.findViewById(t1.f.f13440T);
        this.mCOUIPageIndicator = (COUIPageIndicator) lVar.itemView.findViewById(t1.f.f13462v);
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) lVar.itemView.findViewById(t1.f.f13432L);
        this.mCouiCardListSelectedItemLayout = cOUICardListSelectedItemLayout;
        if (cOUICardListSelectedItemLayout != null) {
            cOUICardListSelectedItemLayout.setBackgroundAnimationEnabled(false);
        }
        this.mViewPager.addOnLayoutChangeListener(this.mViewPagerLayoutListener);
        this.mViewPager.g(new ViewPager2.i() { // from class: com.oplus.flexibletask.setting.guide.GuidePreference.2
            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageScrolled(int i3, float f3, int i4) {
                GuidePreference.this.mCOUIPageIndicator.p(i3, f3, i4);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageSelected(int i3) {
                GuidePreference.this.mCOUIPageIndicator.q(i3);
            }
        });
        SettingPagerAdapter settingPagerAdapter = new SettingPagerAdapter(lVar.itemView.getContext());
        this.mAdapter = settingPagerAdapter;
        this.mCOUIPageIndicator.setDotsCount(settingPagerAdapter.getItemCount());
        this.mCOUIPageIndicator.setOnDotClickListener(new COUIPageIndicator.b() { // from class: com.oplus.flexibletask.setting.guide.f
            @Override // com.coui.appcompat.indicator.COUIPageIndicator.b
            public final void a(int i3) {
                GuidePreference.this.lambda$initHeader$0(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHeader$0(int i3) {
        this.mViewPager.setCurrentItem(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int measureItemHeight(Context context, int i3, SettingPagerAdapter settingPagerAdapter) {
        List<BaseGuidePagerAdapter.Item> availableItems = settingPagerAdapter.getAvailableItems();
        BaseGuideContentView onCreateGuideContentView = settingPagerAdapter.onCreateGuideContentView(context);
        int i4 = 0;
        for (int i5 = 0; i5 < availableItems.size(); i5++) {
            BaseGuidePagerAdapter.Item item = availableItems.get(i5);
            onCreateGuideContentView.setTitleText(item.mTextTitle);
            if (item == BaseGuidePagerAdapter.sScaleOpenFreeform && FlexibleSettingHelper.isExportVersion(context)) {
                onCreateGuideContentView.setSummaryText(j.f13606F, context.getString(j.f13619S));
            } else {
                onCreateGuideContentView.setSummaryText(item.mSummary);
            }
            onCreateGuideContentView.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            i4 = Math.max(onCreateGuideContentView.getMeasuredHeight(), i4);
        }
        return i4;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        this.mContext = lVar.itemView.getContext();
        initHeader(lVar);
        super.onBindViewHolder(lVar);
        View view = lVar.itemView;
        if (view instanceof COUICardListSelectedItemLayout) {
            view.setPadding(0, 0, 0, 0);
        }
    }

    public GuidePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewPagerLayoutListener = new View.OnLayoutChangeListener() { // from class: com.oplus.flexibletask.setting.guide.GuidePreference.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                GuidePreference.this.mViewPager.removeOnLayoutChangeListener(this);
                SettingPagerAdapter settingPagerAdapter = GuidePreference.this.mAdapter;
                GuidePreference guidePreference = GuidePreference.this;
                settingPagerAdapter.setItemHeight(guidePreference.measureItemHeight(guidePreference.mViewPager.getContext(), i6 - i4, GuidePreference.this.mAdapter));
                GuidePreference.this.mViewPager.setAdapter(GuidePreference.this.mAdapter);
            }
        };
    }

    public GuidePreference(Context context) {
        super(context);
        this.mViewPagerLayoutListener = new View.OnLayoutChangeListener() { // from class: com.oplus.flexibletask.setting.guide.GuidePreference.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                GuidePreference.this.mViewPager.removeOnLayoutChangeListener(this);
                SettingPagerAdapter settingPagerAdapter = GuidePreference.this.mAdapter;
                GuidePreference guidePreference = GuidePreference.this;
                settingPagerAdapter.setItemHeight(guidePreference.measureItemHeight(guidePreference.mViewPager.getContext(), i6 - i4, GuidePreference.this.mAdapter));
                GuidePreference.this.mViewPager.setAdapter(GuidePreference.this.mAdapter);
            }
        };
    }
}
