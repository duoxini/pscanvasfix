package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
class j implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    private Rect f6722a;

    j() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f3, Rect rect, Rect rect2) {
        int i3 = rect.left + ((int) ((rect2.left - r0) * f3));
        int i4 = rect.top + ((int) ((rect2.top - r1) * f3));
        int i5 = rect.right + ((int) ((rect2.right - r2) * f3));
        int i6 = rect.bottom + ((int) ((rect2.bottom - r6) * f3));
        Rect rect3 = this.f6722a;
        if (rect3 == null) {
            return new Rect(i3, i4, i5, i6);
        }
        rect3.set(i3, i4, i5, i6);
        return this.f6722a;
    }
}
