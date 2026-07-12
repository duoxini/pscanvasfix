package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.C0451a;
import m.C0454d;

/* loaded from: classes.dex */
public abstract class l implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<r> mEndValuesList;
    private f mEpicenterCallback;
    private C0451a mNameOverrides;
    o mPropagation;
    private ArrayList<r> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final AbstractC0287g STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<C0451a> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private s mStartValues = new s();
    private s mEndValues = new s();
    p mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<g> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private AbstractC0287g mPathMotion = STRAIGHT_PATH_MOTION;

    static class a extends AbstractC0287g {
        a() {
        }

        @Override // androidx.transition.AbstractC0287g
        public Path a(float f3, float f4, float f5, float f6) {
            Path path = new Path();
            path.moveTo(f3, f4);
            path.lineTo(f5, f6);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0451a f6723a;

        b(C0451a c0451a) {
            this.f6723a = c0451a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6723a.remove(animator);
            l.this.mCurrentAnimators.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l.this.mCurrentAnimators.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.end();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        View f6726a;

        /* renamed from: b, reason: collision with root package name */
        String f6727b;

        /* renamed from: c, reason: collision with root package name */
        r f6728c;

        /* renamed from: d, reason: collision with root package name */
        H f6729d;

        /* renamed from: e, reason: collision with root package name */
        l f6730e;

        d(View view, String str, l lVar, H h3, r rVar) {
            this.f6726a = view;
            this.f6727b = str;
            this.f6728c = rVar;
            this.f6729d = h3;
            this.f6730e = lVar;
        }
    }

    private static class e {
        static ArrayList a(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            return arrayList;
        }

        static ArrayList b(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(obj);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class f {
        public abstract Rect a(l lVar);
    }

    public interface g {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);

        void e(l lVar);
    }

    private void a(C0451a c0451a, C0451a c0451a2) {
        for (int i3 = 0; i3 < c0451a.size(); i3++) {
            r rVar = (r) c0451a.m(i3);
            if (isValidTarget(rVar.f6750b)) {
                this.mStartValuesList.add(rVar);
                this.mEndValuesList.add(null);
            }
        }
        for (int i4 = 0; i4 < c0451a2.size(); i4++) {
            r rVar2 = (r) c0451a2.m(i4);
            if (isValidTarget(rVar2.f6750b)) {
                this.mEndValuesList.add(rVar2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void b(s sVar, View view, r rVar) {
        sVar.f6752a.put(view, rVar);
        int id = view.getId();
        if (id >= 0) {
            if (sVar.f6753b.indexOfKey(id) >= 0) {
                sVar.f6753b.put(id, null);
            } else {
                sVar.f6753b.put(id, view);
            }
        }
        String F3 = androidx.core.view.y.F(view);
        if (F3 != null) {
            if (sVar.f6755d.containsKey(F3)) {
                sVar.f6755d.put(F3, null);
            } else {
                sVar.f6755d.put(F3, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (sVar.f6754c.g(itemIdAtPosition) < 0) {
                    androidx.core.view.y.t0(view, true);
                    sVar.f6754c.i(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) sVar.f6754c.e(itemIdAtPosition);
                if (view2 != null) {
                    androidx.core.view.y.t0(view2, false);
                    sVar.f6754c.i(itemIdAtPosition, null);
                }
            }
        }
    }

    private static boolean c(int[] iArr, int i3) {
        int i4 = iArr[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            if (iArr[i5] == i4) {
                return true;
            }
        }
        return false;
    }

    private void d(View view, boolean z3) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.mTargetTypeExcludes.get(i3).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    r rVar = new r(view);
                    if (z3) {
                        captureStartValues(rVar);
                    } else {
                        captureEndValues(rVar);
                    }
                    rVar.f6751c.add(this);
                    capturePropagationValues(rVar);
                    if (z3) {
                        b(this.mStartValues, view, rVar);
                    } else {
                        b(this.mEndValues, view, rVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    if (this.mTargetTypeChildExcludes.get(i4).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                                d(viewGroup.getChildAt(i5), z3);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList e(ArrayList arrayList, int i3, boolean z3) {
        return i3 > 0 ? z3 ? e.a(arrayList, Integer.valueOf(i3)) : e.b(arrayList, Integer.valueOf(i3)) : arrayList;
    }

    private static ArrayList f(ArrayList arrayList, Object obj, boolean z3) {
        return obj != null ? z3 ? e.a(arrayList, obj) : e.b(arrayList, obj) : arrayList;
    }

    private ArrayList g(ArrayList arrayList, Class cls, boolean z3) {
        return cls != null ? z3 ? e.a(arrayList, cls) : e.b(arrayList, cls) : arrayList;
    }

    private ArrayList h(ArrayList arrayList, View view, boolean z3) {
        return view != null ? z3 ? e.a(arrayList, view) : e.b(arrayList, view) : arrayList;
    }

    private static C0451a i() {
        C0451a c0451a = sRunningAnimators.get();
        if (c0451a != null) {
            return c0451a;
        }
        C0451a c0451a2 = new C0451a();
        sRunningAnimators.set(c0451a2);
        return c0451a2;
    }

    private static boolean j(int i3) {
        return i3 >= 1 && i3 <= 4;
    }

    private static boolean k(r rVar, r rVar2, String str) {
        Object obj = rVar.f6749a.get(str);
        Object obj2 = rVar2.f6749a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void l(C0451a c0451a, C0451a c0451a2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) sparseArray.valueAt(i3);
            if (view2 != null && isValidTarget(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i3))) != null && isValidTarget(view)) {
                r rVar = (r) c0451a.get(view2);
                r rVar2 = (r) c0451a2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.mStartValuesList.add(rVar);
                    this.mEndValuesList.add(rVar2);
                    c0451a.remove(view2);
                    c0451a2.remove(view);
                }
            }
        }
    }

    private void m(C0451a c0451a, C0451a c0451a2) {
        r rVar;
        for (int size = c0451a.size() - 1; size >= 0; size--) {
            View view = (View) c0451a.i(size);
            if (view != null && isValidTarget(view) && (rVar = (r) c0451a2.remove(view)) != null && isValidTarget(rVar.f6750b)) {
                this.mStartValuesList.add((r) c0451a.k(size));
                this.mEndValuesList.add(rVar);
            }
        }
    }

    private void n(C0451a c0451a, C0451a c0451a2, C0454d c0454d, C0454d c0454d2) {
        View view;
        int l3 = c0454d.l();
        for (int i3 = 0; i3 < l3; i3++) {
            View view2 = (View) c0454d.m(i3);
            if (view2 != null && isValidTarget(view2) && (view = (View) c0454d2.e(c0454d.h(i3))) != null && isValidTarget(view)) {
                r rVar = (r) c0451a.get(view2);
                r rVar2 = (r) c0451a2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.mStartValuesList.add(rVar);
                    this.mEndValuesList.add(rVar2);
                    c0451a.remove(view2);
                    c0451a2.remove(view);
                }
            }
        }
    }

    private void o(C0451a c0451a, C0451a c0451a2, C0451a c0451a3, C0451a c0451a4) {
        View view;
        int size = c0451a3.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) c0451a3.m(i3);
            if (view2 != null && isValidTarget(view2) && (view = (View) c0451a4.get(c0451a3.i(i3))) != null && isValidTarget(view)) {
                r rVar = (r) c0451a.get(view2);
                r rVar2 = (r) c0451a2.get(view);
                if (rVar != null && rVar2 != null) {
                    this.mStartValuesList.add(rVar);
                    this.mEndValuesList.add(rVar2);
                    c0451a.remove(view2);
                    c0451a2.remove(view);
                }
            }
        }
    }

    private void p(s sVar, s sVar2) {
        C0451a c0451a = new C0451a(sVar.f6752a);
        C0451a c0451a2 = new C0451a(sVar2.f6752a);
        int i3 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i3 >= iArr.length) {
                a(c0451a, c0451a2);
                return;
            }
            int i4 = iArr[i3];
            if (i4 == 1) {
                m(c0451a, c0451a2);
            } else if (i4 == 2) {
                o(c0451a, c0451a2, sVar.f6755d, sVar2.f6755d);
            } else if (i4 == 3) {
                l(c0451a, c0451a2, sVar.f6753b, sVar2.f6753b);
            } else if (i4 == 4) {
                n(c0451a, c0451a2, sVar.f6754c, sVar2.f6754c);
            }
            i3++;
        }
    }

    private void q(Animator animator, C0451a c0451a) {
        if (animator != null) {
            animator.addListener(new b(c0451a));
            animate(animator);
        }
    }

    public l addListener(g gVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(gVar);
        return this;
    }

    public l addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    protected void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((g) arrayList2.get(i3)).d(this);
        }
    }

    public abstract void captureEndValues(r rVar);

    void capturePropagationValues(r rVar) {
    }

    public abstract void captureStartValues(r rVar);

    void captureValues(ViewGroup viewGroup, boolean z3) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        C0451a c0451a;
        clearValues(z3);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i3 = 0; i3 < this.mTargetIds.size(); i3++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i3).intValue());
                if (findViewById != null) {
                    r rVar = new r(findViewById);
                    if (z3) {
                        captureStartValues(rVar);
                    } else {
                        captureEndValues(rVar);
                    }
                    rVar.f6751c.add(this);
                    capturePropagationValues(rVar);
                    if (z3) {
                        b(this.mStartValues, findViewById, rVar);
                    } else {
                        b(this.mEndValues, findViewById, rVar);
                    }
                }
            }
            for (int i4 = 0; i4 < this.mTargets.size(); i4++) {
                View view = this.mTargets.get(i4);
                r rVar2 = new r(view);
                if (z3) {
                    captureStartValues(rVar2);
                } else {
                    captureEndValues(rVar2);
                }
                rVar2.f6751c.add(this);
                capturePropagationValues(rVar2);
                if (z3) {
                    b(this.mStartValues, view, rVar2);
                } else {
                    b(this.mEndValues, view, rVar2);
                }
            }
        } else {
            d(viewGroup, z3);
        }
        if (z3 || (c0451a = this.mNameOverrides) == null) {
            return;
        }
        int size = c0451a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList3.add(this.mStartValues.f6755d.remove((String) this.mNameOverrides.i(i5)));
        }
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) arrayList3.get(i6);
            if (view2 != null) {
                this.mStartValues.f6755d.put((String) this.mNameOverrides.m(i6), view2);
            }
        }
    }

    void clearValues(boolean z3) {
        if (z3) {
            this.mStartValues.f6752a.clear();
            this.mStartValues.f6753b.clear();
            this.mStartValues.f6754c.a();
        } else {
            this.mEndValues.f6752a.clear();
            this.mEndValues.f6753b.clear();
            this.mEndValues.f6754c.a();
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, r rVar, r rVar2) {
        return null;
    }

    protected void createAnimators(ViewGroup viewGroup, s sVar, s sVar2, ArrayList<r> arrayList, ArrayList<r> arrayList2) {
        View view;
        Animator animator;
        r rVar;
        int i3;
        Animator animator2;
        r rVar2;
        C0451a i4 = i();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            r rVar3 = arrayList.get(i5);
            r rVar4 = arrayList2.get(i5);
            if (rVar3 != null && !rVar3.f6751c.contains(this)) {
                rVar3 = null;
            }
            if (rVar4 != null && !rVar4.f6751c.contains(this)) {
                rVar4 = null;
            }
            if ((rVar3 != null || rVar4 != null) && (rVar3 == null || rVar4 == null || isTransitionRequired(rVar3, rVar4))) {
                Animator createAnimator = createAnimator(viewGroup, rVar3, rVar4);
                if (createAnimator != null) {
                    if (rVar4 != null) {
                        View view2 = rVar4.f6750b;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            rVar2 = new r(view2);
                            r rVar5 = (r) sVar2.f6752a.get(view2);
                            if (rVar5 != null) {
                                int i6 = 0;
                                while (i6 < transitionProperties.length) {
                                    Map map = rVar2.f6749a;
                                    Animator animator3 = createAnimator;
                                    String str = transitionProperties[i6];
                                    map.put(str, rVar5.f6749a.get(str));
                                    i6++;
                                    createAnimator = animator3;
                                    transitionProperties = transitionProperties;
                                }
                            }
                            Animator animator4 = createAnimator;
                            int size2 = i4.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) i4.get((Animator) i4.i(i7));
                                if (dVar.f6728c != null && dVar.f6726a == view2 && dVar.f6727b.equals(getName()) && dVar.f6728c.equals(rVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            animator2 = createAnimator;
                            rVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        rVar = rVar2;
                    } else {
                        view = rVar3.f6750b;
                        animator = createAnimator;
                        rVar = null;
                    }
                    if (animator != null) {
                        i3 = size;
                        i4.put(animator, new d(view, getName(), this, y.d(viewGroup), rVar));
                        this.mAnimators.add(animator);
                        i5++;
                        size = i3;
                    }
                    i3 = size;
                    i5++;
                    size = i3;
                }
            }
            i3 = size;
            i5++;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator5 = this.mAnimators.get(sparseIntArray.keyAt(i8));
                animator5.setStartDelay((sparseIntArray.valueAt(i8) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    protected void end() {
        int i3 = this.mNumInstances - 1;
        this.mNumInstances = i3;
        if (i3 == 0) {
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((g) arrayList2.get(i4)).e(this);
                }
            }
            for (int i5 = 0; i5 < this.mStartValues.f6754c.l(); i5++) {
                View view = (View) this.mStartValues.f6754c.m(i5);
                if (view != null) {
                    androidx.core.view.y.t0(view, false);
                }
            }
            for (int i6 = 0; i6 < this.mEndValues.f6754c.l(); i6++) {
                View view2 = (View) this.mEndValues.f6754c.m(i6);
                if (view2 != null) {
                    androidx.core.view.y.t0(view2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public l excludeChildren(View view, boolean z3) {
        this.mTargetChildExcludes = h(this.mTargetChildExcludes, view, z3);
        return this;
    }

    public l excludeTarget(View view, boolean z3) {
        this.mTargetExcludes = h(this.mTargetExcludes, view, z3);
        return this;
    }

    void forceToEnd(ViewGroup viewGroup) {
        C0451a i3 = i();
        int size = i3.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        H d3 = y.d(viewGroup);
        C0451a c0451a = new C0451a(i3);
        i3.clear();
        for (int i4 = size - 1; i4 >= 0; i4--) {
            d dVar = (d) c0451a.m(i4);
            if (dVar.f6726a != null && d3 != null && d3.equals(dVar.f6729d)) {
                ((Animator) c0451a.i(i4)).end();
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        f fVar = this.mEpicenterCallback;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this);
    }

    public f getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    r getMatchedTransitionValues(View view, boolean z3) {
        p pVar = this.mParent;
        if (pVar != null) {
            return pVar.getMatchedTransitionValues(view, z3);
        }
        ArrayList<r> arrayList = z3 ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            }
            r rVar = arrayList.get(i3);
            if (rVar == null) {
                return null;
            }
            if (rVar.f6750b == view) {
                break;
            }
            i3++;
        }
        if (i3 >= 0) {
            return (z3 ? this.mEndValuesList : this.mStartValuesList).get(i3);
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }

    public AbstractC0287g getPathMotion() {
        return this.mPathMotion;
    }

    public o getPropagation() {
        return null;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public r getTransitionValues(View view, boolean z3) {
        p pVar = this.mParent;
        if (pVar != null) {
            return pVar.getTransitionValues(view, z3);
        }
        return (r) (z3 ? this.mStartValues : this.mEndValues).f6752a.get(view);
    }

    public boolean isTransitionRequired(r rVar, r rVar2) {
        if (rVar == null || rVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties == null) {
            Iterator it = rVar.f6749a.keySet().iterator();
            while (it.hasNext()) {
                if (k(rVar, rVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : transitionProperties) {
            if (!k(rVar, rVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.mTargetTypeExcludes.get(i3).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && androidx.core.view.y.F(view) != null && this.mTargetNameExcludes.contains(androidx.core.view.y.F(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(androidx.core.view.y.F(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i4 = 0; i4 < this.mTargetTypes.size(); i4++) {
                if (this.mTargetTypes.get(i4).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        C0451a i3 = i();
        int size = i3.size();
        H d3 = y.d(view);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            d dVar = (d) i3.m(i4);
            if (dVar.f6726a != null && d3.equals(dVar.f6729d)) {
                AbstractC0281a.b((Animator) i3.i(i4));
            }
        }
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ((g) arrayList2.get(i5)).a(this);
            }
        }
        this.mPaused = true;
    }

    void playTransition(ViewGroup viewGroup) {
        d dVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        p(this.mStartValues, this.mEndValues);
        C0451a i3 = i();
        int size = i3.size();
        H d3 = y.d(viewGroup);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            Animator animator = (Animator) i3.i(i4);
            if (animator != null && (dVar = (d) i3.get(animator)) != null && dVar.f6726a != null && d3.equals(dVar.f6729d)) {
                r rVar = dVar.f6728c;
                View view = dVar.f6726a;
                r transitionValues = getTransitionValues(view, true);
                r matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = (r) this.mEndValues.f6752a.get(view);
                }
                if ((transitionValues != null || matchedTransitionValues != null) && dVar.f6730e.isTransitionRequired(rVar, matchedTransitionValues)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        i3.remove(animator);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public l removeListener(g gVar) {
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(gVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public l removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                C0451a i3 = i();
                int size = i3.size();
                H d3 = y.d(view);
                for (int i4 = size - 1; i4 >= 0; i4--) {
                    d dVar = (d) i3.m(i4);
                    if (dVar.f6726a != null && d3.equals(dVar.f6729d)) {
                        AbstractC0281a.c((Animator) i3.i(i4));
                    }
                }
                ArrayList<g> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        ((g) arrayList2.get(i5)).b(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    protected void runAnimators() {
        start();
        C0451a i3 = i();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (i3.containsKey(next)) {
                start();
                q(next, i3);
            }
        }
        this.mAnimators.clear();
        end();
    }

    void setCanRemoveViews(boolean z3) {
        this.mCanRemoveViews = z3;
    }

    public l setDuration(long j3) {
        this.mDuration = j3;
        return this;
    }

    public void setEpicenterCallback(f fVar) {
        this.mEpicenterCallback = fVar;
    }

    public l setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (!j(iArr[i3])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (c(iArr, i3)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(AbstractC0287g abstractC0287g) {
        if (abstractC0287g == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = abstractC0287g;
        }
    }

    public void setPropagation(o oVar) {
    }

    l setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public l setStartDelay(long j3) {
        this.mStartDelay = j3;
        return this;
    }

    protected void start() {
        if (this.mNumInstances == 0) {
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((g) arrayList2.get(i3)).c(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public l addTarget(int i3) {
        if (i3 != 0) {
            this.mTargetIds.add(Integer.valueOf(i3));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public l mo0clone() {
        try {
            l lVar = (l) super.clone();
            lVar.mAnimators = new ArrayList<>();
            lVar.mStartValues = new s();
            lVar.mEndValues = new s();
            lVar.mStartValuesList = null;
            lVar.mEndValuesList = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public l excludeChildren(int i3, boolean z3) {
        this.mTargetIdChildExcludes = e(this.mTargetIdChildExcludes, i3, z3);
        return this;
    }

    public l excludeTarget(int i3, boolean z3) {
        this.mTargetIdExcludes = e(this.mTargetIdExcludes, i3, z3);
        return this;
    }

    public l removeTarget(int i3) {
        if (i3 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i3));
        }
        return this;
    }

    String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i3 = 0; i3 < this.mTargetIds.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i3);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i4 = 0; i4 < this.mTargets.size(); i4++) {
                if (i4 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i4);
            }
        }
        return str3 + ")";
    }

    public l addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public l excludeChildren(Class<?> cls, boolean z3) {
        this.mTargetTypeChildExcludes = g(this.mTargetTypeChildExcludes, cls, z3);
        return this;
    }

    public l excludeTarget(String str, boolean z3) {
        this.mTargetNameExcludes = f(this.mTargetNameExcludes, str, z3);
        return this;
    }

    public l removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public l excludeTarget(Class<?> cls, boolean z3) {
        this.mTargetTypeExcludes = g(this.mTargetTypeExcludes, cls, z3);
        return this;
    }

    public l removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public l addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }
}
