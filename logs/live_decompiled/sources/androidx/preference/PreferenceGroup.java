package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: e, reason: collision with root package name */
    final m.g f5915e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f5916f;

    /* renamed from: g, reason: collision with root package name */
    private List f5917g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5918h;

    /* renamed from: i, reason: collision with root package name */
    private int f5919i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5920j;

    /* renamed from: k, reason: collision with root package name */
    private int f5921k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f5922l;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f5915e.clear();
            }
        }
    }

    public interface b {
    }

    public interface c {
        int d(String str);

        int e(Preference preference);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5915e = new m.g();
        this.f5916f = new Handler();
        this.f5918h = true;
        this.f5919i = 0;
        this.f5920j = false;
        this.f5921k = Preference.DEFAULT_ORDER;
        this.f5922l = new a();
        this.f5917g = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6187n1, i3, i4);
        int i5 = s.f6193p1;
        this.f5918h = androidx.core.content.res.i.b(obtainStyledAttributes, i5, i5, true);
        if (obtainStyledAttributes.hasValue(s.f6190o1)) {
            int i6 = s.f6190o1;
            t(androidx.core.content.res.i.d(obtainStyledAttributes, i6, i6, Preference.DEFAULT_ORDER));
        }
        obtainStyledAttributes.recycle();
    }

    private boolean s(Preference preference) {
        boolean remove;
        synchronized (this) {
            try {
                preference.onPrepareForRemoval();
                if (preference.getParent() == this) {
                    preference.assignParent(null);
                }
                remove = this.f5917g.remove(preference);
                if (remove) {
                    String key = preference.getKey();
                    if (key != null) {
                        this.f5915e.put(key, Long.valueOf(preference.getId()));
                        this.f5916f.removeCallbacks(this.f5922l);
                        this.f5916f.post(this.f5922l);
                    }
                    if (this.f5920j) {
                        preference.onDetached();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return remove;
    }

    @Override // androidx.preference.Preference
    protected void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int o3 = o();
        for (int i3 = 0; i3 < o3; i3++) {
            n(i3).dispatchRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int o3 = o();
        for (int i3 = 0; i3 < o3; i3++) {
            n(i3).dispatchSaveInstanceState(bundle);
        }
    }

    public void i(Preference preference) {
        j(preference);
    }

    public boolean j(Preference preference) {
        long f3;
        if (this.f5917g.contains(preference)) {
            return true;
        }
        if (preference.getKey() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.getParent() != null) {
                preferenceGroup = preferenceGroup.getParent();
            }
            String key = preference.getKey();
            if (preferenceGroup.k(key) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + key + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.f5918h) {
                int i3 = this.f5919i;
                this.f5919i = i3 + 1;
                preference.setOrder(i3);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).u(this.f5918h);
            }
        }
        int binarySearch = Collections.binarySearch(this.f5917g, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * (-1)) - 1;
        }
        if (!q(preference)) {
            return false;
        }
        synchronized (this) {
            this.f5917g.add(binarySearch, preference);
        }
        j preferenceManager = getPreferenceManager();
        String key2 = preference.getKey();
        if (key2 == null || !this.f5915e.containsKey(key2)) {
            f3 = preferenceManager.f();
        } else {
            f3 = ((Long) this.f5915e.get(key2)).longValue();
            this.f5915e.remove(key2);
        }
        preference.onAttachedToHierarchy(preferenceManager, f3);
        preference.assignParent(this);
        if (this.f5920j) {
            preference.onAttached();
        }
        notifyHierarchyChanged();
        return true;
    }

    public Preference k(CharSequence charSequence) {
        Preference k3;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        }
        int o3 = o();
        for (int i3 = 0; i3 < o3; i3++) {
            Preference n3 = n(i3);
            if (TextUtils.equals(n3.getKey(), charSequence)) {
                return n3;
            }
            if ((n3 instanceof PreferenceGroup) && (k3 = ((PreferenceGroup) n3).k(charSequence)) != null) {
                return k3;
            }
        }
        return null;
    }

    public int l() {
        return this.f5921k;
    }

    public b m() {
        return null;
    }

    public Preference n(int i3) {
        return (Preference) this.f5917g.get(i3);
    }

    @Override // androidx.preference.Preference
    public void notifyDependencyChange(boolean z3) {
        super.notifyDependencyChange(z3);
        int o3 = o();
        for (int i3 = 0; i3 < o3; i3++) {
            n(i3).onParentChanged(this, z3);
        }
    }

    public int o() {
        return this.f5917g.size();
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        this.f5920j = true;
        int o3 = o();
        for (int i3 = 0; i3 < o3; i3++) {
            n(i3).onAttached();
        }
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        this.f5920j = false;
        int o3 = o();
        for (int i3 = 0; i3 < o3; i3++) {
            n(i3).onDetached();
        }
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(d.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        this.f5921k = dVar.f5924e;
        super.onRestoreInstanceState(dVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        return new d(super.onSaveInstanceState(), this.f5921k);
    }

    protected boolean p() {
        return true;
    }

    protected boolean q(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    public void r() {
        synchronized (this) {
            try {
                List list = this.f5917g;
                for (int size = list.size() - 1; size >= 0; size--) {
                    s((Preference) list.get(0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyHierarchyChanged();
    }

    public void t(int i3) {
        if (i3 != Integer.MAX_VALUE && !hasKey()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f5921k = i3;
    }

    public void u(boolean z3) {
        this.f5918h = z3;
    }

    void v() {
        synchronized (this) {
            Collections.sort(this.f5917g);
        }
    }

    static class d extends Preference.b {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f5924e;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        d(Parcel parcel) {
            super(parcel);
            this.f5924e = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f5924e);
        }

        d(Parcelable parcelable, int i3) {
            super(parcelable);
            this.f5924e = i3;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
