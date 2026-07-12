package androidx.window.core;

import D2.k;

/* loaded from: classes.dex */
public final class ActivityComponentInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f6935a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6936b;

    public ActivityComponentInfo(String str, String str2) {
        k.e(str, "packageName");
        k.e(str2, "className");
        this.f6935a = str;
        this.f6936b = str2;
    }

    public final String a() {
        return this.f6936b;
    }

    public final String b() {
        return this.f6935a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(ActivityComponentInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type androidx.window.core.ActivityComponentInfo");
        ActivityComponentInfo activityComponentInfo = (ActivityComponentInfo) obj;
        return k.a(this.f6935a, activityComponentInfo.f6935a) && k.a(this.f6936b, activityComponentInfo.f6936b);
    }

    public int hashCode() {
        return (this.f6935a.hashCode() * 31) + this.f6936b.hashCode();
    }

    public String toString() {
        return "ClassInfo { packageName: " + this.f6935a + ", className: " + this.f6936b + " }";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ActivityComponentInfo(android.content.ComponentName r3) {
        /*
            r2 = this;
            java.lang.String r0 = "componentName"
            D2.k.e(r3, r0)
            java.lang.String r0 = r3.getPackageName()
            java.lang.String r1 = "componentName.packageName"
            D2.k.d(r0, r1)
            java.lang.String r3 = r3.getClassName()
            java.lang.String r1 = "componentName.className"
            D2.k.d(r3, r1)
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.core.ActivityComponentInfo.<init>(android.content.ComponentName):void");
    }
}
