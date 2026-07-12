package com.oplus.backup.sdk.host.listener;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ProgressHelper {
    public static final String BR_RESULT = "br_result";
    public static final int BR_RESULT_CANCEL = 3;
    public static final int BR_RESULT_FAILED = 2;
    public static final int BR_RESULT_SUCCESS = 1;
    public static final String COMPLETED_COUNT = "completed_count";
    public static final String COMPLETED_FILE_PATHS = "completed_paths";
    public static final String ERROR_MESSAGE = "error_message";
    public static final int ERROR_SERVICE_CONNECTION_FAIL = 1;
    public static final String ERROR_TYPE = "error_type";
    public static final String FILE_TYPE = "file_type";
    public static final int INVALID_COUNT = Integer.MIN_VALUE;
    public static final String MAX_COUNT = "max_count";
    public static final String PREVIEW_DATA_SIZE = "preview_data_size";
    public static final String PREVIEW_LIST = "preview_list";
    public static final String PREVIEW_LIST_ITEM_CACHE_SIZE = "preview_list_item_cache_size";
    public static final String PREVIEW_LIST_ITEM_COUNT = "preview_list_item_count";
    public static final String PREVIEW_LIST_ITEM_DATA_SIZE = "preview_list_item_data_size";
    public static final String PREVIEW_LIST_ITEM_DEFAULT_SELECTED = "preview_list_item_default_selected";
    public static final String PREVIEW_LIST_ITEM_ICON = "preview_list_item_icon";
    public static final String PREVIEW_LIST_ITEM_PACKAGE = "preview_list_item_package";
    public static final String PREVIEW_LIST_ITEM_SUB_TITLE = "preview_list_item_sub_title";
    public static final String PREVIEW_LIST_ITEM_TITLE = "preview_list_item_title";
    public static final String PREVIEW_LIST_SHOW_PLUGIN_ITEM = "preview_list_show_plugin_item";
    public static final String PREVIEW_SELECTED_LIST = "preview_selected_list";

    public static Bundle buildErrorBundle(int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(ERROR_TYPE, i3);
        bundle.putString(ERROR_MESSAGE, str);
        return bundle;
    }

    public static int getBRResult(Bundle bundle, int i3) {
        return bundle != null ? bundle.getInt(BR_RESULT, i3) : i3;
    }

    public static int getErrorType(Bundle bundle) {
        if (bundle != null) {
            return bundle.getInt(ERROR_TYPE);
        }
        return 0;
    }

    public static int getMaxCount(Bundle bundle) {
        return getMaxCount(bundle, 0);
    }

    public static String getPreviewListItemTitle(Bundle bundle) {
        if (bundle != null) {
            return bundle.getString(PREVIEW_LIST_ITEM_TITLE);
        }
        return null;
    }

    public static List<Bundle> getPreviewSelectedList(Bundle bundle) {
        if (bundle != null) {
            return bundle.getParcelableArrayList(PREVIEW_SELECTED_LIST);
        }
        return null;
    }

    public static void putBRResult(Bundle bundle, int i3) {
        if (bundle != null) {
            bundle.putInt(BR_RESULT, i3);
        }
    }

    public static void putCompletedCount(Bundle bundle, int i3) {
        if (bundle != null) {
            bundle.putInt(COMPLETED_COUNT, i3);
        }
    }

    public static void putFileType(Bundle bundle, String str) {
        if (bundle != null) {
            bundle.putString(FILE_TYPE, str);
        }
    }

    public static void putMaxCount(Bundle bundle, int i3) {
        if (bundle != null) {
            bundle.putInt(MAX_COUNT, i3);
        }
    }

    public static void putPreviewArrayList(Bundle bundle, ArrayList<Bundle> arrayList) {
        if (bundle != null) {
            bundle.putParcelableArrayList(PREVIEW_LIST, arrayList);
        }
    }

    public static void putPreviewDataSize(Bundle bundle, long j3) {
        if (bundle != null) {
            bundle.putLong(PREVIEW_DATA_SIZE, j3);
        }
    }

    public static void putPreviewListItemIcon(Bundle bundle, int i3) {
        if (bundle != null) {
            bundle.putInt(PREVIEW_LIST_ITEM_ICON, i3);
        }
    }

    public static void putPreviewListItemPackage(Bundle bundle, String str) {
        if (bundle != null) {
            bundle.putString(PREVIEW_LIST_ITEM_PACKAGE, str);
        }
    }

    public static void putPreviewListItemSubCacheSize(Bundle bundle, long j3) {
        if (bundle != null) {
            bundle.putLong(PREVIEW_LIST_ITEM_CACHE_SIZE, j3);
        }
    }

    public static void putPreviewListItemSubDataSize(Bundle bundle, long j3) {
        if (bundle != null) {
            bundle.putLong(PREVIEW_LIST_ITEM_DATA_SIZE, j3);
        }
    }

    public static void putPreviewListItemSubTitle(Bundle bundle, String str) {
        if (bundle != null) {
            bundle.putString(PREVIEW_LIST_ITEM_SUB_TITLE, str);
        }
    }

    public static void putPreviewListItemTitle(Bundle bundle, String str) {
        if (bundle != null) {
            bundle.putString(PREVIEW_LIST_ITEM_TITLE, str);
        }
    }

    public static int getMaxCount(Bundle bundle, int i3) {
        return bundle != null ? bundle.getInt(MAX_COUNT, i3) : i3;
    }
}
