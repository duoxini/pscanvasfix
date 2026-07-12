package c;

import D2.g;
import D2.k;
import android.content.Context;
import android.content.Intent;

/* renamed from: c.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0296c extends AbstractC0294a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7281a = new a(null);

    /* renamed from: c.c$a */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    @Override // c.AbstractC0294a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "input");
        return intent;
    }

    @Override // c.AbstractC0294a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public androidx.activity.result.a c(int i3, Intent intent) {
        return new androidx.activity.result.a(i3, intent);
    }
}
