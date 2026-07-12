package com.oplus.flexibletask.setting;

import M1.g;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Space;
import androidx.fragment.app.Fragment;
import com.coui.appcompat.grid.COUIPercentWidthFrameLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.flexibletask.setting.base.BaseSettingActivity;
import com.oplus.flexibletask.setting.bean.GameListInfo;
import com.oplus.flexibletask.setting.fragment.EmptySupportGameListFragment;
import com.oplus.flexibletask.setting.fragment.SupportGameListFragment;
import com.oplus.flexibletask.setting.utils.FlexibleSettingHelper;
import com.oplus.flexibletask.setting.utils.StatusBarUtils;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import java.util.ArrayList;
import java.util.List;
import t1.f;
import t1.h;
import t1.j;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SupportGameListActivity extends BaseSettingActivity {
    private static final int FLEXIBLE_WINDOW_CONFIG_TYPE = 1;
    public static final String TAG = "SupportGameListActivity";
    private Handler mHandler;
    private List<String> mResult = new ArrayList();

    public static Drawable changeDrawableSize(Context context, Drawable drawable, int i3) {
        int i4;
        int i5;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return drawable;
        }
        if (drawable instanceof ColorDrawable) {
            i4 = i3;
            i5 = i4;
        } else {
            i4 = intrinsicWidth;
            i5 = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i4, i5);
        drawable.draw(canvas);
        Matrix matrix = new Matrix();
        float f3 = i3;
        matrix.postScale(f3 / intrinsicWidth, f3 / intrinsicHeight);
        return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(createBitmap, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GameListInfo> getGameListInfo() {
        PackageManager packageManager = getPackageManager();
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : this.mResult) {
                if (isAppInstalled(this, str)) {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                    arrayList.add(new GameListInfo(packageManager.getApplicationLabel(applicationInfo).toString(), str, changeDrawableSize(this, packageManager.getApplicationIcon(applicationInfo), (int) getResources().getDimension(t1.d.f13381j))));
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGameList() {
        FlexibleWindowManager flexibleWindowManager = FlexibleWindowManager.getInstance();
        if (flexibleWindowManager != null) {
            this.mResult = flexibleWindowManager.getFlexibleWindowConfigList(1);
            AbstractC0652e.b(TAG, "initGameList success");
        }
    }

    private void initView() {
        com.coui.appcompat.theme.a.h().a(this);
        if ((!FlexibleSettingHelper.getInstance().isFoldScreen() || FlexibleSettingHelper.getInstance().isFlip()) && !FlexibleSettingHelper.getInstance().isPadScreen()) {
            setRequestedOrientation(1);
        }
        Space space = (Space) findViewById(f.f13435O);
        if (space != null) {
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int statusBarHeightForRotation = rotation == 0 ? StatusBarUtils.getStatusBarHeightForRotation(this, rotation) : StatusBarUtils.getStatusBarHeightValue(this);
            AbstractC0652e.b(TAG, "statusBarHeight is " + statusBarHeightForRotation);
            space.setMinimumHeight(statusBarHeightForRotation);
        }
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(f.f13439S);
        if (cOUIToolbar != null) {
            cOUIToolbar.setTitle(getString(j.f13611K));
            cOUIToolbar.setNavigationIcon(g.f1467a);
            setSupportActionBar(cOUIToolbar);
            getSupportActionBar().s(true);
            cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.flexibletask.setting.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SupportGameListActivity.this.lambda$initView$0(view);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceFragment(List<GameListInfo> list) {
        Fragment emptySupportGameListFragment;
        if (list == null || list.isEmpty()) {
            AbstractC0652e.j(TAG, "switching to EmptySupportGameListFragment, because no installed game support this function.");
            emptySupportGameListFragment = new EmptySupportGameListFragment();
        } else {
            emptySupportGameListFragment = new SupportGameListFragment(this, list);
        }
        try {
            getSupportFragmentManager().m().q(f.f13421A, emptySupportGameListFragment, TAG).h();
        } catch (Exception e3) {
            AbstractC0652e.e(TAG, "replaceFragment, gamelist:" + list, e3);
        }
    }

    public boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            AbstractC0652e.c("not found correct app name, error:" + e3);
            return false;
        }
    }

    @Override // com.oplus.flexibletask.setting.base.BaseSettingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.f13468a);
        initView();
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.oplus.flexibletask.setting.d
            @Override // java.lang.Runnable
            public final void run() {
                SupportGameListActivity.this.initGameList();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.post(new Runnable() { // from class: com.oplus.flexibletask.setting.SupportGameListActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SupportGameListActivity supportGameListActivity = SupportGameListActivity.this;
                supportGameListActivity.replaceFragment(supportGameListActivity.getGameListInfo());
            }
        });
    }
}
