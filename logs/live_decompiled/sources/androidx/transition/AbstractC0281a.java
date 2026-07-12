package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: androidx.transition.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0281a {
    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    static void b(Animator animator) {
        animator.pause();
    }

    static void c(Animator animator) {
        animator.resume();
    }
}
