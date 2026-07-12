package I0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    public static void a(AnimatorSet animatorSet, List list) {
        int size = list.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Animator animator = (Animator) list.get(i3);
            j3 = Math.max(j3, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j3);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
