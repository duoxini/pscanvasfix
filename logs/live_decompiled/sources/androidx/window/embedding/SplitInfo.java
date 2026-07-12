package androidx.window.embedding;

import D2.k;
import android.app.Activity;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class SplitInfo {

    /* renamed from: a, reason: collision with root package name */
    private final ActivityStack f7105a;

    /* renamed from: b, reason: collision with root package name */
    private final ActivityStack f7106b;

    /* renamed from: c, reason: collision with root package name */
    private final SplitAttributes f7107c;

    /* renamed from: d, reason: collision with root package name */
    private final IBinder f7108d;

    public SplitInfo(ActivityStack activityStack, ActivityStack activityStack2, SplitAttributes splitAttributes, IBinder iBinder) {
        k.e(activityStack, "primaryActivityStack");
        k.e(activityStack2, "secondaryActivityStack");
        k.e(splitAttributes, "splitAttributes");
        k.e(iBinder, "token");
        this.f7105a = activityStack;
        this.f7106b = activityStack2;
        this.f7107c = splitAttributes;
        this.f7108d = iBinder;
    }

    public final boolean a(Activity activity) {
        k.e(activity, "activity");
        return this.f7105a.a(activity) || this.f7106b.a(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        return k.a(this.f7105a, splitInfo.f7105a) && k.a(this.f7106b, splitInfo.f7106b) && k.a(this.f7107c, splitInfo.f7107c) && k.a(this.f7108d, splitInfo.f7108d);
    }

    public int hashCode() {
        return (((((this.f7105a.hashCode() * 31) + this.f7106b.hashCode()) * 31) + this.f7107c.hashCode()) * 31) + this.f7108d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplitInfo:{");
        sb.append("primaryActivityStack=" + this.f7105a + ", ");
        sb.append("secondaryActivityStack=" + this.f7106b + ", ");
        sb.append("splitAttributes=" + this.f7107c + ", ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("token=");
        sb2.append(this.f7108d);
        sb.append(sb2.toString());
        sb.append("}");
        String sb3 = sb.toString();
        k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
