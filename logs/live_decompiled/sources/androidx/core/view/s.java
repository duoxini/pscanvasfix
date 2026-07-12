package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private int f5127a;

    /* renamed from: b, reason: collision with root package name */
    private int f5128b;

    public s(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f5128b | this.f5127a;
    }

    public void b(View view, View view2, int i3) {
        c(view, view2, i3, 0);
    }

    public void c(View view, View view2, int i3, int i4) {
        if (i4 == 1) {
            this.f5128b = i3;
        } else {
            this.f5127a = i3;
        }
    }

    public void d(View view, int i3) {
        if (i3 == 1) {
            this.f5128b = 0;
        } else {
            this.f5127a = 0;
        }
    }
}
