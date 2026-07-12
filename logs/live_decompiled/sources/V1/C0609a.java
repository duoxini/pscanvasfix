package v1;

import D2.k;
import android.content.Context;
import java.util.ArrayList;
import q2.AbstractC0538h;
import t1.AbstractC0588b;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0609a {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f13848a;

    public C0609a(Context context) {
        k.e(context, "context");
        ArrayList arrayList = new ArrayList();
        this.f13848a = arrayList;
        String[] stringArray = context.getResources().getStringArray(AbstractC0588b.f13361a);
        k.d(stringArray, "getStringArray(...)");
        arrayList.addAll(AbstractC0538h.G(stringArray));
    }

    public final boolean a(String str) {
        k.e(str, "component");
        return this.f13848a.contains(str);
    }
}
