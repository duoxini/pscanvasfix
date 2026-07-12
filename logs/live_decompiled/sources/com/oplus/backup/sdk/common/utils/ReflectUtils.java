package com.oplus.backup.sdk.common.utils;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Object invoke(Object obj, Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            BRLog.e(TAG, "invoke, e =" + e3.getMessage());
            return null;
        } catch (IllegalArgumentException e4) {
            BRLog.e(TAG, "invoke, e =" + e4.getMessage());
            return null;
        } catch (NoSuchMethodException e5) {
            BRLog.e(TAG, "invoke, e =" + e5.getMessage());
            return null;
        } catch (InvocationTargetException e6) {
            BRLog.e(TAG, "invoke, e =" + e6.getMessage());
            return null;
        } catch (Exception e7) {
            BRLog.e(TAG, "invoke, e =" + e7.getMessage());
            return null;
        }
    }
}
