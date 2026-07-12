package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.d;
import androidx.core.provider.g;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f4919a = new ConcurrentHashMap();

    f() {
    }

    public abstract Typeface a(Context context, d.c cVar, Resources resources, int i3);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i3);

    public abstract Typeface c(Context context, Resources resources, int i3, String str, int i4);
}
