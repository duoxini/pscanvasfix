package com.oplus.flexibletask.setting;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.oplusdevicepolicy.OplusDevicepolicyManager;
import android.provider.SearchIndexableResource;
import android.provider.SearchIndexablesContract;
import android.provider.SearchIndexablesProvider;
import com.oplus.backup.sdk.common.utils.Constants;
import t1.e;
import t1.j;
import t1.l;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class IndexSearchProvider extends SearchIndexablesProvider {
    private static final String PACKAGE_NAME = "com.oplus.pscanvas";
    private static SearchIndexableResource[] INDEXABLE_RES_DATA = {new SearchIndexableResource(1, l.f13680a, (String) null, e.f13413s)};
    private static int[][] INDEXABLE_SCREEN_TITLE = {new int[]{j.f13658p0, j.f13660q0}};
    public static final String MAIN_ACTION = "oplus.intent.action.ZOOM_SETTINGS_ACTIVITY";
    private static String[] INDEXABLE_TARGET_ACTION = {MAIN_ACTION};
    private static String[] INDEXABLE_TARGET_CLASS = {SettingActivity.class.getName()};

    private static String getArrayScreenTitle(Context context, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(context.getString(iArr[i3]));
            if (i3 != length - 1) {
                sb.append(Constants.DataMigration.SPLIT_TAG);
            }
        }
        return sb.toString();
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor queryNonIndexableKeys(String[] strArr) {
        return null;
    }

    public Cursor queryRawData(String[] strArr) {
        return new MatrixCursor(SearchIndexablesContract.INDEXABLES_RAW_COLUMNS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cursor queryXmlResources(String[] strArr) {
        MatrixCursor matrixCursor = new MatrixCursor(SearchIndexablesContract.INDEXABLES_XML_RES_COLUMNS);
        if (OplusDevicepolicyManager.getInstance().getBoolean("persist.sys.custom.zoom_window_disable", 1, false)) {
            AbstractC0652e.b("IndexSearchProvider", "disable zoom window by custom");
            return matrixCursor;
        }
        Context context = getContext();
        int length = INDEXABLE_RES_DATA.length;
        for (int i3 = 0; i3 < length; i3++) {
            Object[] objArr = new Object[SearchIndexablesContract.INDEXABLES_XML_RES_COLUMNS.length];
            objArr[0] = Integer.valueOf(INDEXABLE_RES_DATA[i3].rank);
            objArr[1] = Integer.valueOf(INDEXABLE_RES_DATA[i3].xmlResId);
            objArr[2] = getArrayScreenTitle(context, INDEXABLE_SCREEN_TITLE[i3]);
            objArr[3] = Integer.valueOf(INDEXABLE_RES_DATA[i3].iconResId);
            objArr[4] = INDEXABLE_TARGET_ACTION[i3];
            objArr[5] = PACKAGE_NAME;
            objArr[6] = INDEXABLE_TARGET_CLASS[i3];
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }
}
