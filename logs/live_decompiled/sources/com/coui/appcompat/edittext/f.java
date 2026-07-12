package com.coui.appcompat.edittext;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class f {
    public static boolean a(CharSequence charSequence) {
        return c("^([1-9]{1})(\\d{14}|\\d{15}|\\d{16}|\\d{17}|\\d{18})$", charSequence);
    }

    public static boolean b(CharSequence charSequence) {
        return c("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|(147))\\d{8}$", charSequence);
    }

    public static boolean c(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }
}
