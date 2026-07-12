package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.y;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import f.AbstractC0348a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h extends RecyclerView.h implements Preference.c, PreferenceGroup.c {

    /* renamed from: a, reason: collision with root package name */
    private PreferenceGroup f5990a;

    /* renamed from: b, reason: collision with root package name */
    private List f5991b;

    /* renamed from: c, reason: collision with root package name */
    private List f5992c;

    /* renamed from: d, reason: collision with root package name */
    private List f5993d;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f5995f = new a();

    /* renamed from: e, reason: collision with root package name */
    private Handler f5994e = new Handler();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.m();
        }
    }

    class b implements Preference.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreferenceGroup f5997a;

        b(PreferenceGroup preferenceGroup) {
            this.f5997a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.e
        public boolean a(Preference preference) {
            this.f5997a.t(Preference.DEFAULT_ORDER);
            h.this.b(preference);
            this.f5997a.m();
            return true;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        int f5999a;

        /* renamed from: b, reason: collision with root package name */
        int f6000b;

        /* renamed from: c, reason: collision with root package name */
        String f6001c;

        c(Preference preference) {
            this.f6001c = preference.getClass().getName();
            this.f5999a = preference.getLayoutResource();
            this.f6000b = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f5999a == cVar.f5999a && this.f6000b == cVar.f6000b && TextUtils.equals(this.f6001c, cVar.f6001c);
        }

        public int hashCode() {
            return ((((527 + this.f5999a) * 31) + this.f6000b) * 31) + this.f6001c.hashCode();
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this.f5990a = preferenceGroup;
        this.f5990a.setOnPreferenceChangeInternalListener(this);
        this.f5991b = new ArrayList();
        this.f5992c = new ArrayList();
        this.f5993d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f5990a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).w());
        } else {
            setHasStableIds(true);
        }
        m();
    }

    private androidx.preference.b f(PreferenceGroup preferenceGroup, List list) {
        androidx.preference.b bVar = new androidx.preference.b(preferenceGroup.getContext(), list, preferenceGroup.getId());
        bVar.setOnPreferenceClickListener(new b(preferenceGroup));
        return bVar;
    }

    private List g(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int o3 = preferenceGroup.o();
        int i3 = 0;
        for (int i4 = 0; i4 < o3; i4++) {
            Preference n3 = preferenceGroup.n(i4);
            if (n3.isVisible()) {
                if (!j(preferenceGroup) || i3 < preferenceGroup.l()) {
                    arrayList.add(n3);
                } else {
                    arrayList2.add(n3);
                }
                if (n3 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) n3;
                    if (!preferenceGroup2.p()) {
                        continue;
                    } else {
                        if (j(preferenceGroup) && j(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : g(preferenceGroup2)) {
                            if (!j(preferenceGroup) || i3 < preferenceGroup.l()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i3++;
                        }
                    }
                } else {
                    i3++;
                }
            }
        }
        if (j(preferenceGroup) && i3 > preferenceGroup.l()) {
            arrayList.add(f(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void h(List list, PreferenceGroup preferenceGroup) {
        preferenceGroup.v();
        int o3 = preferenceGroup.o();
        for (int i3 = 0; i3 < o3; i3++) {
            Preference n3 = preferenceGroup.n(i3);
            list.add(n3);
            c cVar = new c(n3);
            if (!this.f5993d.contains(cVar)) {
                this.f5993d.add(cVar);
            }
            if (n3 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) n3;
                if (preferenceGroup2.p()) {
                    h(list, preferenceGroup2);
                }
            }
            n3.setOnPreferenceChangeInternalListener(this);
        }
    }

    private boolean j(PreferenceGroup preferenceGroup) {
        return preferenceGroup.l() != Integer.MAX_VALUE;
    }

    @Override // androidx.preference.Preference.c
    public void a(Preference preference) {
        b(preference);
    }

    @Override // androidx.preference.Preference.c
    public void b(Preference preference) {
        this.f5994e.removeCallbacks(this.f5995f);
        this.f5994e.post(this.f5995f);
    }

    @Override // androidx.preference.Preference.c
    public void c(Preference preference) {
        int indexOf = this.f5992c.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int d(String str) {
        int size = this.f5992c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(str, ((Preference) this.f5992c.get(i3)).getKey())) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int e(Preference preference) {
        int size = this.f5992c.size();
        for (int i3 = 0; i3 < size; i3++) {
            Preference preference2 = (Preference) this.f5992c.get(i3);
            if (preference2 != null && preference2.equals(preference)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.f5992c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i3) {
        if (hasStableIds()) {
            return i(i3).getId();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i3) {
        c cVar = new c(i(i3));
        int indexOf = this.f5993d.indexOf(cVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f5993d.size();
        this.f5993d.add(cVar);
        return size;
    }

    public Preference i(int i3) {
        if (i3 < 0 || i3 >= getItemCount()) {
            return null;
        }
        return (Preference) this.f5992c.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l lVar, int i3) {
        i(i3).onBindViewHolder(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(ViewGroup viewGroup, int i3) {
        c cVar = (c) this.f5993d.get(i3);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, s.f6191p);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.f6194q);
        if (drawable == null) {
            drawable = AbstractC0348a.b(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(cVar.f5999a, viewGroup, false);
        if (inflate.getBackground() == null) {
            y.n0(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i4 = cVar.f6000b;
            if (i4 != 0) {
                from.inflate(i4, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(inflate);
    }

    void m() {
        Iterator it = this.f5991b.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).setOnPreferenceChangeInternalListener(null);
        }
        ArrayList arrayList = new ArrayList(this.f5991b.size());
        this.f5991b = arrayList;
        h(arrayList, this.f5990a);
        this.f5992c = g(this.f5990a);
        j preferenceManager = this.f5990a.getPreferenceManager();
        if (preferenceManager != null) {
            preferenceManager.i();
        }
        notifyDataSetChanged();
        Iterator it2 = this.f5991b.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).clearWasDetached();
        }
    }
}
