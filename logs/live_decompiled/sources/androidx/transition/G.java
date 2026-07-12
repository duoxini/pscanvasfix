package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class G implements H {

    /* renamed from: a, reason: collision with root package name */
    private final WindowId f6664a;

    G(View view) {
        this.f6664a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof G) && ((G) obj).f6664a.equals(this.f6664a);
    }

    public int hashCode() {
        return this.f6664a.hashCode();
    }
}
