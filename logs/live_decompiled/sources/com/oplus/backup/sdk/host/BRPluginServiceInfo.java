package com.oplus.backup.sdk.host;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.BRLog;

/* loaded from: classes.dex */
public class BRPluginServiceInfo {
    private static final String GROUP_ID = "groupID";
    private static final String ICON_RES_ID = "backup_icon_resId";
    private static final String IS_CMCC_USE = "isCmccUse";
    private static final String IS_OVERSEA_USE = "isOverseaUse";
    private static final String IS_THIRD_SUPPORT = "isThirdSupport";
    private static final String NAME_RES_ID = "backup_name_resId";
    private static final String ORIGINAL_ID = "originalID";
    public static final String PARAMS = "params";
    private static final String PARENT_ID = "parentID";
    private static final String PRIORITY = "priority";
    private static final String SINGLE_THREAD = "singleThread";
    private static final String TAG = "BRPluginServiceInfo";
    private static final String THREAD_ID = "threadID";
    private static final String UI_GROUP = "uiGroup";
    private static final String UNIQUE_ID = "uniqueID";
    private static final String VERSION = "version";
    private String mClassName;
    private Intent mIntent;
    private boolean mIsCmccUse;
    private boolean mIsOverseaUse;
    private boolean mIsSingleThread;
    private boolean mIsThirdSupport;
    private Bundle mMetaData;
    private String mOriginalID;
    private String mPackageName;
    private Bundle mParams;
    private String mParentID;
    private int mPriority;
    private int mThreadID = -1;
    private int mUIGroup = -1;
    private String mUniqueID;
    private int mVersion;

    private String getString(String str, Bundle bundle) {
        String str2;
        try {
            str2 = String.valueOf(bundle.getInt(str));
        } catch (Exception unused) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        try {
            return bundle.getString(str);
        } catch (Exception unused2) {
            return str2;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof BRPluginServiceInfo) && hashCode() == ((BRPluginServiceInfo) obj).hashCode();
    }

    public String getClassName() {
        return this.mClassName;
    }

    public Drawable getIcon(Context context) {
        int i3;
        String str = this.mPackageName;
        Drawable drawable = null;
        if (str == null) {
            return null;
        }
        try {
            Context createPackageContext = context.createPackageContext(str, 3);
            Bundle bundle = this.mMetaData;
            if (bundle != null) {
                i3 = createPackageContext.getResources().getIdentifier(bundle.getString(ICON_RES_ID), "drawable", this.mPackageName);
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                drawable = createPackageContext.getDrawable(i3);
            }
        } catch (PackageManager.NameNotFoundException e3) {
            BRLog.e(TAG, "getIcon, e =" + e3.getMessage());
        } catch (Resources.NotFoundException unused) {
            BRLog.w(TAG, "getIcon failed:" + this.mUniqueID);
        }
        if (drawable != null) {
            return drawable;
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.mPackageName, 0);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        Drawable loadIcon = applicationInfo.loadIcon(packageManager);
        BRLog.d(TAG, "getApplicationLabel icon:" + loadIcon);
        return loadIcon;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public Bundle getMetaData() {
        return this.mMetaData;
    }

    public String getName(Context context) {
        String str = null;
        if (this.mPackageName == null) {
            return null;
        }
        try {
            Bundle bundle = this.mMetaData;
            if (bundle != null) {
                str = bundle.getString(NAME_RES_ID);
                BRLog.d(TAG, "getBRPluginServiceInfos nameValue:");
            }
        } catch (Resources.NotFoundException unused) {
            BRLog.w(TAG, "getBRPluginServiceInfos name failed:" + this.mUniqueID);
        }
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.mPackageName, 0);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        String str2 = (String) packageManager.getApplicationLabel(applicationInfo);
        BRLog.d(TAG, "getApplicationLabel name:");
        return str2;
    }

    public String getOriginalID() {
        return this.mOriginalID;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public String getParentID() {
        return this.mParentID;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getThreadID() {
        return this.mThreadID;
    }

    public int getUIGroup() {
        return this.mUIGroup;
    }

    public String getUniqueID() {
        return this.mUniqueID;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        String str = this.mUniqueID;
        if (str != null) {
            return str.hashCode();
        }
        return -1;
    }

    public boolean isCmccUse() {
        return this.mIsCmccUse;
    }

    public boolean isOverseaUse() {
        return this.mIsOverseaUse;
    }

    public boolean isParent() {
        return TextUtils.isEmpty(this.mParentID) || "0".equals(this.mParentID);
    }

    public boolean isSingleThread() {
        return this.mIsSingleThread;
    }

    public boolean isThirdSupport() {
        return this.mIsThirdSupport;
    }

    public void setClass(String str, String str2) {
        this.mPackageName = str;
        this.mClassName = str2;
        Intent intent = new Intent();
        this.mIntent = intent;
        intent.setClassName(str, str2);
    }

    public void setCmccUse(boolean z3) {
        this.mIsCmccUse = z3;
    }

    public void setMetaData(Bundle bundle) {
        this.mMetaData = bundle;
        if (bundle != null) {
            this.mUniqueID = getString("uniqueID", bundle);
            this.mThreadID = bundle.getInt(THREAD_ID, -1);
            this.mOriginalID = getString(ORIGINAL_ID, bundle);
            this.mIsSingleThread = bundle.getBoolean(SINGLE_THREAD, false);
            this.mIsThirdSupport = bundle.getBoolean(IS_THIRD_SUPPORT, false);
            this.mIsCmccUse = bundle.getBoolean(IS_CMCC_USE, false);
            this.mIsOverseaUse = bundle.getBoolean(IS_OVERSEA_USE, false);
            this.mUIGroup = bundle.getInt(UI_GROUP, -1);
            this.mPriority = bundle.getInt(PRIORITY, -1);
            this.mVersion = bundle.getInt("version", 0);
            this.mParentID = getString(PARENT_ID, bundle);
            if (isParent()) {
                this.mParentID = getString(GROUP_ID, bundle);
            }
        }
    }

    public void setOriginalID(String str) {
        this.mOriginalID = str;
    }

    public void setOverseaUse(boolean z3) {
        this.mIsOverseaUse = z3;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    public void setParentID(String str) {
        this.mParentID = str;
    }

    public void setPriority(int i3) {
        this.mPriority = i3;
    }

    public void setSingleThread(boolean z3) {
        this.mIsSingleThread = z3;
    }

    public void setThirdSupport(boolean z3) {
        this.mIsThirdSupport = z3;
    }

    public void setThreadID(int i3) {
        this.mThreadID = i3;
    }

    public void setUIGroup(int i3) {
        this.mUIGroup = i3;
    }

    public void setVersion(int i3) {
        this.mVersion = i3;
    }

    public String toString() {
        return "[BRPluginServiceInfo:" + getUniqueID() + ", " + getOriginalID() + ", " + getThreadID() + ", " + getVersion() + ", " + getParentID() + "]";
    }
}
