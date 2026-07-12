package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class r {

    /* renamed from: b, reason: collision with root package name */
    public View f6750b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f6749a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f6751c = new ArrayList();

    public r(View view) {
        this.f6750b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f6750b == rVar.f6750b && this.f6749a.equals(rVar.f6749a);
    }

    public int hashCode() {
        return (this.f6750b.hashCode() * 31) + this.f6749a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f6750b + "\n") + "    values:";
        for (String str2 : this.f6749a.keySet()) {
            str = str + "    " + str2 + ": " + this.f6749a.get(str2) + "\n";
        }
        return str;
    }
}
