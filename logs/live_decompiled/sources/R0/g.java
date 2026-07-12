package R0;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import x.AbstractC0626a;

/* loaded from: classes.dex */
public abstract class g {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        int i3 = configuration.fontWeightAdjustment;
        if (i3 == Integer.MAX_VALUE || i3 == 0) {
            return null;
        }
        return Typeface.create(typeface, AbstractC0626a.b(typeface.getWeight() + configuration.fontWeightAdjustment, 1, OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT), typeface.isItalic());
    }
}
