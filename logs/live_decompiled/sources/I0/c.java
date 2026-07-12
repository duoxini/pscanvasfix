package I0;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import m.g;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final g f919a = new g();

    /* renamed from: b, reason: collision with root package name */
    private final g f920b = new g();

    private static void a(c cVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            cVar.e(objectAnimator.getPropertyName(), objectAnimator.getValues());
            cVar.f(objectAnimator.getPropertyName(), d.a(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static c b(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static c c(Context context, int i3) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i3);
            if (loadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return d(arrayList);
        } catch (Exception e3) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i3), e3);
            return null;
        }
    }

    private static c d(List list) {
        c cVar = new c();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(cVar, (Animator) list.get(i3));
        }
        return cVar;
    }

    public void e(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f920b.put(str, propertyValuesHolderArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f919a.equals(((c) obj).f919a);
        }
        return false;
    }

    public void f(String str, d dVar) {
        this.f919a.put(str, dVar);
    }

    public int hashCode() {
        return this.f919a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f919a + "}\n";
    }
}
