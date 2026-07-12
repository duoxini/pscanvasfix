package v0;

import M1.f;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.C0252a;
import androidx.core.view.accessibility.d;
import androidx.core.view.y;
import e0.AbstractC0342a;
import r0.C0560b;

/* renamed from: v0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0608a {

    /* renamed from: v0.a$a, reason: collision with other inner class name */
    class C0152a extends C0252a {
        C0152a() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.Q("android.widget.Button");
        }
    }

    public static void a(View view, boolean z3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
        view.setLayoutParams(layoutParams);
        if (!z3) {
            int dimensionPixelOffset = view.getContext().getResources().getDimensionPixelOffset(f.f1449i0);
            int dimensionPixelOffset2 = view.getContext().getResources().getDimensionPixelOffset(f.f1447h0);
            view.setPadding(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset);
        }
        C0560b c0560b = new C0560b(view.getContext());
        c0560b.w();
        view.setBackground(c0560b);
        AbstractC0342a.b(view, false);
        if (y.j(view) == null) {
            y.j0(view, new C0152a());
        }
    }

    public static void b(TextView textView) {
        a(textView, false);
    }
}
