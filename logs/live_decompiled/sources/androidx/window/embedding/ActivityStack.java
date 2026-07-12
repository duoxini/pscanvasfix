package androidx.window.embedding;

import D2.k;
import android.app.Activity;
import java.util.List;

/* loaded from: classes.dex */
public final class ActivityStack {

    /* renamed from: a, reason: collision with root package name */
    private final List f6997a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6998b;

    public ActivityStack(List list, boolean z3) {
        k.e(list, "activitiesInProcess");
        this.f6997a = list;
        this.f6998b = z3;
    }

    public final boolean a(Activity activity) {
        k.e(activity, "activity");
        return this.f6997a.contains(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityStack)) {
            return false;
        }
        ActivityStack activityStack = (ActivityStack) obj;
        return k.a(this.f6997a, activityStack.f6997a) && this.f6998b == activityStack.f6998b;
    }

    public int hashCode() {
        return (this.f6997a.hashCode() * 31) + Boolean.hashCode(this.f6998b);
    }

    public String toString() {
        return "ActivityStack{activitiesInProcess=" + this.f6997a + ", isEmpty=" + this.f6998b + '}';
    }
}
