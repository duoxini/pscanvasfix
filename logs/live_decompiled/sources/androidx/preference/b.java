package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b extends Preference {

    /* renamed from: e, reason: collision with root package name */
    private long f5959e;

    b(Context context, List list, long j3) {
        super(context);
        i();
        j(list);
        this.f5959e = j3 + 1000000;
    }

    private void i() {
        setLayoutResource(p.f6049a);
        setIcon(n.f6042a);
        setTitle(q.f6054b);
        setOrder(999);
    }

    private void j(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        CharSequence charSequence = null;
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            CharSequence title = preference.getTitle();
            boolean z3 = preference instanceof PreferenceGroup;
            if (z3 && !TextUtils.isEmpty(title)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.getParent())) {
                if (z3) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(title)) {
                charSequence = charSequence == null ? title : getContext().getString(q.f6057e, charSequence, title);
            }
        }
        setSummary(charSequence);
    }

    @Override // androidx.preference.Preference
    long getId() {
        return this.f5959e;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        lVar.e(false);
    }
}
