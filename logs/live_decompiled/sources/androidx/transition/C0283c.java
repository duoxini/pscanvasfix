package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* renamed from: androidx.transition.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0283c extends l {

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f6665h = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: i, reason: collision with root package name */
    private static final Property f6666i = new b(PointF.class, "boundsOrigin");

    /* renamed from: j, reason: collision with root package name */
    private static final Property f6667j = new C0095c(PointF.class, "topLeft");

    /* renamed from: k, reason: collision with root package name */
    private static final Property f6668k = new d(PointF.class, "bottomRight");

    /* renamed from: l, reason: collision with root package name */
    private static final Property f6669l = new e(PointF.class, "bottomRight");

    /* renamed from: m, reason: collision with root package name */
    private static final Property f6670m = new f(PointF.class, "topLeft");

    /* renamed from: n, reason: collision with root package name */
    private static final Property f6671n = new g(PointF.class, "position");

    /* renamed from: o, reason: collision with root package name */
    private static androidx.transition.j f6672o = new androidx.transition.j();

    /* renamed from: e, reason: collision with root package name */
    private int[] f6673e = new int[2];

    /* renamed from: f, reason: collision with root package name */
    private boolean f6674f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6675g = false;

    /* renamed from: androidx.transition.c$a */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6676a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f6677b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6678c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f6679d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f3) {
            this.f6676a = viewGroup;
            this.f6677b = bitmapDrawable;
            this.f6678c = view;
            this.f6679d = f3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.b(this.f6676a).remove(this.f6677b);
            y.g(this.f6678c, this.f6679d);
        }
    }

    /* renamed from: androidx.transition.c$b */
    static class b extends Property {

        /* renamed from: a, reason: collision with root package name */
        private Rect f6681a;

        b(Class cls, String str) {
            super(cls, str);
            this.f6681a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f6681a);
            Rect rect = this.f6681a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f6681a);
            this.f6681a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f6681a);
        }
    }

    /* renamed from: androidx.transition.c$c, reason: collision with other inner class name */
    static class C0095c extends Property {
        C0095c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* renamed from: androidx.transition.c$d */
    static class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* renamed from: androidx.transition.c$e */
    static class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            y.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: androidx.transition.c$f */
    static class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            y.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: androidx.transition.c$g */
    static class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            y.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* renamed from: androidx.transition.c$h */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f6682a;
        private k mViewBounds;

        h(k kVar) {
            this.f6682a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* renamed from: androidx.transition.c$i */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6684a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6685b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f6686c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f6687d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f6688e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f6689f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6690g;

        i(View view, Rect rect, int i3, int i4, int i5, int i6) {
            this.f6685b = view;
            this.f6686c = rect;
            this.f6687d = i3;
            this.f6688e = i4;
            this.f6689f = i5;
            this.f6690g = i6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6684a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f6684a) {
                return;
            }
            androidx.core.view.y.q0(this.f6685b, this.f6686c);
            y.f(this.f6685b, this.f6687d, this.f6688e, this.f6689f, this.f6690g);
        }
    }

    /* renamed from: androidx.transition.c$j */
    class j extends m {

        /* renamed from: a, reason: collision with root package name */
        boolean f6692a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6693b;

        j(ViewGroup viewGroup) {
            this.f6693b = viewGroup;
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void a(l lVar) {
            v.b(this.f6693b, false);
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void b(l lVar) {
            v.b(this.f6693b, true);
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void d(l lVar) {
            v.b(this.f6693b, false);
            this.f6692a = true;
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            if (!this.f6692a) {
                v.b(this.f6693b, false);
            }
            lVar.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.c$k */
    private static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f6695a;

        /* renamed from: b, reason: collision with root package name */
        private int f6696b;

        /* renamed from: c, reason: collision with root package name */
        private int f6697c;

        /* renamed from: d, reason: collision with root package name */
        private int f6698d;

        /* renamed from: e, reason: collision with root package name */
        private View f6699e;

        /* renamed from: f, reason: collision with root package name */
        private int f6700f;

        /* renamed from: g, reason: collision with root package name */
        private int f6701g;

        k(View view) {
            this.f6699e = view;
        }

        private void b() {
            y.f(this.f6699e, this.f6695a, this.f6696b, this.f6697c, this.f6698d);
            this.f6700f = 0;
            this.f6701g = 0;
        }

        void a(PointF pointF) {
            this.f6697c = Math.round(pointF.x);
            this.f6698d = Math.round(pointF.y);
            int i3 = this.f6701g + 1;
            this.f6701g = i3;
            if (this.f6700f == i3) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f6695a = Math.round(pointF.x);
            this.f6696b = Math.round(pointF.y);
            int i3 = this.f6700f + 1;
            this.f6700f = i3;
            if (i3 == this.f6701g) {
                b();
            }
        }
    }

    private void captureValues(r rVar) {
        View view = rVar.f6750b;
        if (!androidx.core.view.y.O(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        rVar.f6749a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        rVar.f6749a.put("android:changeBounds:parent", rVar.f6750b.getParent());
        if (this.f6675g) {
            rVar.f6750b.getLocationInWindow(this.f6673e);
            rVar.f6749a.put("android:changeBounds:windowX", Integer.valueOf(this.f6673e[0]));
            rVar.f6749a.put("android:changeBounds:windowY", Integer.valueOf(this.f6673e[1]));
        }
        if (this.f6674f) {
            rVar.f6749a.put("android:changeBounds:clip", androidx.core.view.y.r(view));
        }
    }

    private boolean r(View view, View view2) {
        if (!this.f6675g) {
            return true;
        }
        r matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f6750b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.l
    public void captureEndValues(r rVar) {
        captureValues(rVar);
    }

    @Override // androidx.transition.l
    public void captureStartValues(r rVar) {
        captureValues(rVar);
    }

    @Override // androidx.transition.l
    public Animator createAnimator(ViewGroup viewGroup, r rVar, r rVar2) {
        int i3;
        View view;
        int i4;
        ObjectAnimator objectAnimator;
        Animator c3;
        if (rVar == null || rVar2 == null) {
            return null;
        }
        Map map = rVar.f6749a;
        Map map2 = rVar2.f6749a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = rVar2.f6750b;
        if (!r(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) rVar.f6749a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) rVar.f6749a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) rVar2.f6749a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) rVar2.f6749a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f6673e);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c4 = y.c(view2);
            y.g(view2, 0.0f);
            y.b(viewGroup).add(bitmapDrawable);
            AbstractC0287g pathMotion = getPathMotion();
            int[] iArr = this.f6673e;
            int i5 = iArr[0];
            int i6 = iArr[1];
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, AbstractC0288h.a(f6666i, pathMotion.a(intValue - i5, intValue2 - i6, intValue3 - i5, intValue4 - i6)));
            ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c4));
            return ofPropertyValuesHolder;
        }
        Rect rect = (Rect) rVar.f6749a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) rVar2.f6749a.get("android:changeBounds:bounds");
        int i7 = rect.left;
        int i8 = rect2.left;
        int i9 = rect.top;
        int i10 = rect2.top;
        int i11 = rect.right;
        int i12 = rect2.right;
        int i13 = rect.bottom;
        int i14 = rect2.bottom;
        int i15 = i11 - i7;
        int i16 = i13 - i9;
        int i17 = i12 - i8;
        int i18 = i14 - i10;
        Rect rect3 = (Rect) rVar.f6749a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) rVar2.f6749a.get("android:changeBounds:clip");
        if ((i15 == 0 || i16 == 0) && (i17 == 0 || i18 == 0)) {
            i3 = 0;
        } else {
            i3 = (i7 == i8 && i9 == i10) ? 0 : 1;
            if (i11 != i12 || i13 != i14) {
                i3++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i3++;
        }
        if (i3 <= 0) {
            return null;
        }
        if (this.f6674f) {
            view = view2;
            y.f(view, i7, i9, Math.max(i15, i17) + i7, Math.max(i16, i18) + i9);
            ObjectAnimator a3 = (i7 == i8 && i9 == i10) ? null : AbstractC0286f.a(view, f6671n, getPathMotion().a(i7, i9, i8, i10));
            if (rect3 == null) {
                i4 = 0;
                rect3 = new Rect(0, 0, i15, i16);
            } else {
                i4 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i4, i4, i17, i18) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                androidx.core.view.y.q0(view, rect3);
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", f6672o, rect3, rect5);
                ofObject.addListener(new i(view, rect4, i8, i10, i12, i14));
                objectAnimator = ofObject;
            }
            c3 = q.c(a3, objectAnimator);
        } else {
            view = view2;
            y.f(view, i7, i9, i11, i13);
            if (i3 != 2) {
                c3 = (i7 == i8 && i9 == i10) ? AbstractC0286f.a(view, f6669l, getPathMotion().a(i11, i13, i12, i14)) : AbstractC0286f.a(view, f6670m, getPathMotion().a(i7, i9, i8, i10));
            } else if (i15 == i17 && i16 == i18) {
                c3 = AbstractC0286f.a(view, f6671n, getPathMotion().a(i7, i9, i8, i10));
            } else {
                k kVar = new k(view);
                ObjectAnimator a4 = AbstractC0286f.a(kVar, f6667j, getPathMotion().a(i7, i9, i8, i10));
                ObjectAnimator a5 = AbstractC0286f.a(kVar, f6668k, getPathMotion().a(i11, i13, i12, i14));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(a4, a5);
                animatorSet.addListener(new h(kVar));
                c3 = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            v.b(viewGroup4, true);
            addListener(new j(viewGroup4));
        }
        return c3;
    }

    @Override // androidx.transition.l
    public String[] getTransitionProperties() {
        return f6665h;
    }
}
