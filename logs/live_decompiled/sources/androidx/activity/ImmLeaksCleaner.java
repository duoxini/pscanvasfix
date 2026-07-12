package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.o;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.l {

    /* renamed from: f, reason: collision with root package name */
    private static int f3363f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f3364g;

    /* renamed from: h, reason: collision with root package name */
    private static Field f3365h;

    /* renamed from: i, reason: collision with root package name */
    private static Field f3366i;

    /* renamed from: e, reason: collision with root package name */
    private Activity f3367e;

    private static void b() {
        try {
            f3363f = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f3365h = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f3366i = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f3364g = declaredField3;
            declaredField3.setAccessible(true);
            f3363f = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        if (bVar != AbstractC0272h.b.ON_DESTROY) {
            return;
        }
        if (f3363f == 0) {
            b();
        }
        if (f3363f == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f3367e.getSystemService("input_method");
            try {
                Object obj = f3364g.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f3365h.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f3366i.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
