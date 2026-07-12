package com.oplus.flexibletask.setting.guide;

import B1.l;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.flexibletask.setting.guide.BaseGuidePagerAdapter;
import com.oplus.flexibletask.setting.utils.AppFeatureUtil;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SettingPagerAdapter extends BaseGuidePagerAdapter {
    private int mItemHeight;
    private final List<BaseGuidePagerAdapter.Item> mItems;

    public SettingPagerAdapter(Context context) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.mItems = arrayList;
        this.mItemHeight = -2;
        boolean z3 = true;
        if (!context.toString().contains("SettingActivity")) {
            if (context.toString().contains("OperationActivity")) {
                if (FlexibleSettingHelper.getInstance().getSwitchValue(FlexibleSettingHelper.ZOOM_SIMPLE_MODE) != 1) {
                    arrayList.add(BaseGuidePagerAdapter.sButtonOperation);
                    arrayList.add(BaseGuidePagerAdapter.sHandleMove);
                    arrayList.add(BaseGuidePagerAdapter.sZoomScale);
                    arrayList.add(BaseGuidePagerAdapter.sOperateMiniZoom);
                    return;
                }
                arrayList.add(BaseGuidePagerAdapter.sUpClose);
                arrayList.add(BaseGuidePagerAdapter.sDownFull);
                arrayList.add(BaseGuidePagerAdapter.sSidewardsFloat);
                arrayList.add(BaseGuidePagerAdapter.sControllerMove);
                arrayList.add(BaseGuidePagerAdapter.sZoomScale);
                arrayList.add(BaseGuidePagerAdapter.sOperateMiniZoom);
                return;
            }
            return;
        }
        if ((!FlexibleSettingHelper.getInstance().isFoldScreen() || FlexibleSettingHelper.getInstance().isFlip()) && !FlexibleSettingHelper.getInstance().isPadScreen()) {
            z3 = false;
        }
        if (z3 && l.F0(context)) {
            arrayList.add(BaseGuidePagerAdapter.sScaleOpenFreeform);
        }
        if ((!AppFeatureUtil.lightOsAnimationSupport(context) && !AppFeatureUtil.lightWeightOsSupport(context)) || FlexibleSettingHelper.getInstance().isPadScreen()) {
            arrayList.add(BaseGuidePagerAdapter.sUpOpenFreeform);
        }
        arrayList.add(BaseGuidePagerAdapter.sOpenZoomFromSide);
        arrayList.add(BaseGuidePagerAdapter.sOpenZoomFromNotification);
        if (z3) {
            if (l.F0(context)) {
                arrayList.add(BaseGuidePagerAdapter.sMultiFingerOpenFreeform);
            } else {
                arrayList.add(BaseGuidePagerAdapter.sMultiFinger);
            }
        }
        arrayList.add(BaseGuidePagerAdapter.sDragToShare);
        if (FlexibleSettingHelper.getInstance().isFoldFrontScreen()) {
            return;
        }
        arrayList.add(BaseGuidePagerAdapter.sZoomTransferSplite);
    }

    @Override // com.oplus.flexibletask.setting.guide.BaseGuidePagerAdapter
    protected List<BaseGuidePagerAdapter.Item> getAvailableItems() {
        return this.mItems;
    }

    @Override // com.oplus.flexibletask.setting.guide.BaseGuidePagerAdapter, androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.E e3, int i3) {
        super.onBindViewHolder(e3, i3);
        BaseGuideContentView baseGuideContentView = (BaseGuideContentView) e3.itemView;
        if (baseGuideContentView != null) {
            baseGuideContentView.findViewById(t1.f.f13431K).getLayoutParams().height = this.mItemHeight;
        }
    }

    @Override // com.oplus.flexibletask.setting.guide.BaseGuidePagerAdapter
    protected BaseGuideContentView onCreateGuideContentView(Context context) {
        return new SettingsGuideContentView(context);
    }

    public void setItemHeight(int i3) {
        this.mItemHeight = i3;
    }
}
