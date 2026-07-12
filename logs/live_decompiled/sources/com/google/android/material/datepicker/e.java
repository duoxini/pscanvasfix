package com.google.android.material.datepicker;

import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
abstract class e {
    static String a(long j3) {
        return b(j3, Locale.getDefault());
    }

    static String b(long j3, Locale locale) {
        return r.b(locale).format(new Date(j3));
    }

    static String c(long j3) {
        return DateUtils.formatDateTime(null, j3, 8228);
    }

    static String d(long j3) {
        return e(j3, Locale.getDefault());
    }

    static String e(long j3, Locale locale) {
        return r.k(locale).format(new Date(j3));
    }
}
