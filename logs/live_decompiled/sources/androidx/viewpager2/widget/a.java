package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f6817b;

    /* renamed from: a, reason: collision with root package name */
    private LinearLayoutManager f6818a;

    /* renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    class C0097a implements Comparator {
        C0097a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f6817b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f6818a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i3;
        int bottom;
        int i4;
        int J3 = this.f6818a.J();
        if (J3 == 0) {
            return true;
        }
        boolean z3 = this.f6818a.q2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, J3, 2);
        for (int i5 = 0; i5 < J3; i5++) {
            View I3 = this.f6818a.I(i5);
            if (I3 == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = I3.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f6817b;
            int[] iArr2 = iArr[i5];
            if (z3) {
                top = I3.getLeft();
                i3 = marginLayoutParams.leftMargin;
            } else {
                top = I3.getTop();
                i3 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i3;
            int[] iArr3 = iArr[i5];
            if (z3) {
                bottom = I3.getRight();
                i4 = marginLayoutParams.rightMargin;
            } else {
                bottom = I3.getBottom();
                i4 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i4;
        }
        Arrays.sort(iArr, new C0097a());
        for (int i6 = 1; i6 < J3; i6++) {
            if (iArr[i6 - 1][1] != iArr[i6][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i7 = iArr4[1];
        int i8 = iArr4[0];
        return i8 <= 0 && iArr[J3 - 1][1] >= i7 - i8;
    }

    private boolean b() {
        int J3 = this.f6818a.J();
        for (int i3 = 0; i3 < J3; i3++) {
            if (c(this.f6818a.I(i3))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (c(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean d() {
        return (!a() || this.f6818a.J() <= 1) && b();
    }
}
