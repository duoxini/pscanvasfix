package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
abstract class r {

    /* renamed from: a, reason: collision with root package name */
    static AtomicReference f9733a = new AtomicReference();

    static long a(long j3) {
        Calendar i3 = i();
        i3.setTimeInMillis(j3);
        return d(i3).getTimeInMillis();
    }

    static DateFormat b(Locale locale) {
        return c("MMMEd", locale);
    }

    private static DateFormat c(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(h());
        return instanceForSkeleton;
    }

    static Calendar d(Calendar calendar) {
        Calendar j3 = j(calendar);
        Calendar i3 = i();
        i3.set(j3.get(1), j3.get(2), j3.get(5));
        return i3;
    }

    static q e() {
        q qVar = (q) f9733a.get();
        return qVar == null ? q.c() : qVar;
    }

    private static TimeZone f() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar g() {
        Calendar a3 = e().a();
        a3.set(11, 0);
        a3.set(12, 0);
        a3.set(13, 0);
        a3.set(14, 0);
        a3.setTimeZone(f());
        return a3;
    }

    private static android.icu.util.TimeZone h() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar i() {
        return j(null);
    }

    static Calendar j(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(f());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    static DateFormat k(Locale locale) {
        return c("yMMMEd", locale);
    }
}
