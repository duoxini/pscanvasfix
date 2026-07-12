package com.oplus.flexibletask.setting;

import M1.g;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Slog;
import android.view.View;
import android.widget.Space;
import com.coui.appcompat.grid.COUIPercentWidthFrameLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.flexibletask.setting.base.BaseSettingActivity;
import com.oplus.flexibletask.setting.fragment.OperationFragment;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import com.oplus.flexibletask.setting.utils.StatusBarUtils;
import t1.f;
import t1.h;
import t1.j;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class OperationActivity extends BaseSettingActivity {
    private static final String TAG = "OperationActivity";
    private boolean mIsFoldFrontScreen;
    private OperationFragment mOperationFragment;

    private void initView() {
        Space space = (Space) findViewById(f.f13435O);
        if (space != null) {
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int statusBarHeightForRotation = rotation == 0 ? StatusBarUtils.getStatusBarHeightForRotation(this, rotation) : StatusBarUtils.getStatusBarHeightValue(this);
            Slog.d(TAG, "statusBarHeight is " + statusBarHeightForRotation);
            space.setMinimumHeight(statusBarHeightForRotation);
        }
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(f.f13439S);
        if (cOUIToolbar != null) {
            cOUIToolbar.setTitle(getString(j.f13603C));
            cOUIToolbar.setNavigationIcon(g.f1467a);
            setSupportActionBar(cOUIToolbar);
            getSupportActionBar().s(true);
            cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.flexibletask.setting.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OperationActivity.this.lambda$initView$0(view);
                }
            });
        }
        View findViewById = findViewById(f.f13421A);
        if ((findViewById instanceof COUIPercentWidthFrameLayout) && FlexibleSettingHelper.getInstance().isPadScreen()) {
            ((COUIPercentWidthFrameLayout) findViewById).setPercentIndentEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mIsFoldFrontScreen != FlexibleSettingHelper.getInstance().isFoldFrontScreen()) {
            this.mIsFoldFrontScreen = FlexibleSettingHelper.getInstance().isFoldFrontScreen();
            AbstractC0652e.b(TAG, "onConfigurationChanged mIsFoldFrontScreen:" + this.mIsFoldFrontScreen);
            this.mOperationFragment = new OperationFragment();
            try {
                getSupportFragmentManager().m().q(f.f13421A, this.mOperationFragment, TAG).h();
            } catch (Exception e3) {
                AbstractC0652e.e(TAG, "replace:", e3);
            }
        }
    }

    @Override // com.oplus.flexibletask.setting.base.BaseSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.coui.appcompat.theme.a.h().a(this);
        if ((!FlexibleSettingHelper.getInstance().isFoldScreen() || FlexibleSettingHelper.getInstance().isFlip()) && !FlexibleSettingHelper.getInstance().isPadScreen()) {
            setRequestedOrientation(1);
        }
        setContentView(h.f13468a);
        initView();
        if (this.mOperationFragment == null) {
            this.mOperationFragment = new OperationFragment();
        }
        this.mIsFoldFrontScreen = FlexibleSettingHelper.getInstance().isFoldFrontScreen();
        try {
            getSupportFragmentManager().m().q(f.f13421A, this.mOperationFragment, TAG).h();
        } catch (Exception e3) {
            AbstractC0652e.e(TAG, "replace:", e3);
        }
        FlexibleSettingHelper.getInstance().deleteSettingBannerTip(getIntent());
    }
}
