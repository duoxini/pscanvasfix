package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
class q {

    /* renamed from: c, reason: collision with root package name */
    private static final q f9730c = new q(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Long f9731a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeZone f9732b;

    private q(Long l3, TimeZone timeZone) {
        this.f9731a = l3;
        this.f9732b = timeZone;
    }

    static q c() {
        return f9730c;
    }

    Calendar a() {
        return b(this.f9732b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l3 = this.f9731a;
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        return calendar;
    }
}
