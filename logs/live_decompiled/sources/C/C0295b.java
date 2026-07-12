package c;

import D2.g;
import D2.k;
import H2.d;
import android.content.Context;
import android.content.Intent;
import c.AbstractC0294a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import p2.C0510j;
import p2.n;
import q2.AbstractC0521D;
import q2.AbstractC0538h;
import q2.AbstractC0544n;

/* renamed from: c.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0295b extends AbstractC0294a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7280a = new a(null);

    /* renamed from: c.b$a */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] strArr) {
            k.e(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            k.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }

        private a() {
        }
    }

    @Override // c.AbstractC0294a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        return f7280a.a(strArr);
    }

    @Override // c.AbstractC0294a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC0294a.C0098a b(Context context, String[] strArr) {
        k.e(context, "context");
        k.e(strArr, "input");
        if (strArr.length == 0) {
            return new AbstractC0294a.C0098a(AbstractC0521D.g());
        }
        for (String str : strArr) {
            if (androidx.core.content.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.b(AbstractC0521D.d(strArr.length), 16));
        for (String str2 : strArr) {
            C0510j a3 = n.a(str2, Boolean.TRUE);
            linkedHashMap.put(a3.c(), a3.d());
        }
        return new AbstractC0294a.C0098a(linkedHashMap);
    }

    @Override // c.AbstractC0294a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i3, Intent intent) {
        if (i3 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return AbstractC0521D.g();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i4 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i4 == 0));
            }
            return AbstractC0521D.k(AbstractC0544n.F(AbstractC0538h.s(stringArrayExtra), arrayList));
        }
        return AbstractC0521D.g();
    }
}
