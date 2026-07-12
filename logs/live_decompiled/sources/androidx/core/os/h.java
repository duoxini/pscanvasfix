package androidx.core.os;

import android.os.LocaleList;

/* loaded from: classes.dex */
final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f4929a;

    h(Object obj) {
        this.f4929a = (LocaleList) obj;
    }

    @Override // androidx.core.os.g
    public Object a() {
        return this.f4929a;
    }

    @Override // androidx.core.os.g
    public String b() {
        return this.f4929a.toLanguageTags();
    }

    public boolean equals(Object obj) {
        return this.f4929a.equals(((g) obj).a());
    }

    public int hashCode() {
        return this.f4929a.hashCode();
    }

    @Override // androidx.core.os.g
    public boolean isEmpty() {
        return this.f4929a.isEmpty();
    }

    public String toString() {
        return this.f4929a.toString();
    }
}
