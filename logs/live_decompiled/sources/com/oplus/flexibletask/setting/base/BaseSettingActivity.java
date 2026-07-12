package com.oplus.flexibletask.setting.base;

import M1.c;
import android.graphics.Insets;
import android.os.Bundle;
import android.util.Slog;
import android.view.View;
import android.view.WindowInsets;
import androidx.appcompat.app.AppCompatActivity;
import com.oplus.flexibletask.setting.utils.StatusBarUtils;
import d0.AbstractC0335a;
import t1.d;
import t1.k;

/* loaded from: classes.dex */
public abstract class BaseSettingActivity extends AppCompatActivity {
    private static final String TAG = "BaseSettingActivity";

    private void initNavBarHeightPadding() {
        final int dimensionPixelSize = getResources().getDimensionPixelSize(d.f13382k);
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.oplus.flexibletask.setting.base.a
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets lambda$initNavBarHeightPadding$0;
                lambda$initNavBarHeightPadding$0 = BaseSettingActivity.this.lambda$initNavBarHeightPadding$0(dimensionPixelSize, view, windowInsets);
                return lambda$initNavBarHeightPadding$0;
            }
        });
    }

    private void initialStyle() {
        try {
            com.coui.appcompat.theme.a.h().a(this);
            getWindow().getDecorView().setBackgroundColor(AbstractC0335a.a(this, c.f1357b));
            setTheme(k.f13677a);
            StatusBarUtils.setStatusBarTransparentAndBlackFont(this);
            StatusBarUtils.setDarkStatusIcon(this);
            getWindow().setNavigationBarColor(AbstractC0335a.a(this, c.f1357b));
        } catch (Exception e3) {
            Slog.e(TAG, "initialStyle:", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$initNavBarHeightPadding$0(int i3, View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.navigationBars());
        if (insets == null) {
            Slog.d(TAG, "navigationBar inset is null.");
        } else {
            if (insets.bottom > i3) {
                getWindow().getDecorView().setPadding(0, view.getPaddingTop(), 0, insets.bottom);
            } else {
                getWindow().getDecorView().setPadding(0, view.getPaddingTop(), 0, 0);
            }
            Slog.d(TAG, "initNavBarHeightPadding limit:" + i3 + " paddingTop:" + view.getPaddingTop() + " navbarBottom:" + insets.bottom);
        }
        return windowInsets;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initialStyle();
        initNavBarHeightPadding();
    }
}
