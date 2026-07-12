package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.z;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.I;

/* loaded from: classes.dex */
class r {

    /* renamed from: a, reason: collision with root package name */
    private final k f5543a;

    /* renamed from: b, reason: collision with root package name */
    private final s f5544b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f5545c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5546d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f5547e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f5548e;

        a(View view) {
            this.f5548e = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f5548e.removeOnAttachStateChangeListener(this);
            androidx.core.view.y.f0(this.f5548e);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5550a;

        static {
            int[] iArr = new int[AbstractC0272h.c.values().length];
            f5550a = iArr;
            try {
                iArr[AbstractC0272h.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5550a[AbstractC0272h.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5550a[AbstractC0272h.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5550a[AbstractC0272h.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    r(k kVar, s sVar, Fragment fragment) {
        this.f5543a = kVar;
        this.f5544b = sVar;
        this.f5545c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f5545c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f5545c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f5545c.performSaveInstanceState(bundle);
        this.f5543a.j(this.f5545c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f5545c.mView != null) {
            s();
        }
        if (this.f5545c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f5545c.mSavedViewState);
        }
        if (this.f5545c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f5545c.mSavedViewRegistryState);
        }
        if (!this.f5545c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f5545c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f5545c);
        }
        Fragment fragment = this.f5545c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        k kVar = this.f5543a;
        Fragment fragment2 = this.f5545c;
        kVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        int j3 = this.f5544b.j(this.f5545c);
        Fragment fragment = this.f5545c;
        fragment.mContainer.addView(fragment.mView, j3);
    }

    void c() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f5545c);
        }
        Fragment fragment = this.f5545c;
        Fragment fragment2 = fragment.mTarget;
        r rVar = null;
        if (fragment2 != null) {
            r m3 = this.f5544b.m(fragment2.mWho);
            if (m3 == null) {
                throw new IllegalStateException("Fragment " + this.f5545c + " declared target fragment " + this.f5545c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f5545c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            rVar = m3;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (rVar = this.f5544b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f5545c + " declared target fragment " + this.f5545c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (rVar != null && (l.f5450P || rVar.k().mState < 1)) {
            rVar.m();
        }
        Fragment fragment4 = this.f5545c;
        fragment4.mHost = fragment4.mFragmentManager.s0();
        Fragment fragment5 = this.f5545c;
        fragment5.mParentFragment = fragment5.mFragmentManager.v0();
        this.f5543a.g(this.f5545c, false);
        this.f5545c.performAttach();
        this.f5543a.b(this.f5545c, false);
    }

    int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f5545c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i3 = this.f5547e;
        int i4 = b.f5550a[fragment2.mMaxState.ordinal()];
        if (i4 != 1) {
            i3 = i4 != 2 ? i4 != 3 ? i4 != 4 ? Math.min(i3, -1) : Math.min(i3, 0) : Math.min(i3, 1) : Math.min(i3, 5);
        }
        Fragment fragment3 = this.f5545c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i3 = Math.max(this.f5547e, 2);
                View view = this.f5545c.mView;
                if (view != null && view.getParent() == null) {
                    i3 = Math.min(i3, 2);
                }
            } else {
                i3 = this.f5547e < 4 ? Math.min(i3, fragment3.mState) : Math.min(i3, 1);
            }
        }
        if (!this.f5545c.mAdded) {
            i3 = Math.min(i3, 1);
        }
        z.e.b l3 = (!l.f5450P || (viewGroup = (fragment = this.f5545c).mContainer) == null) ? null : z.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        if (l3 == z.e.b.ADDING) {
            i3 = Math.min(i3, 6);
        } else if (l3 == z.e.b.REMOVING) {
            i3 = Math.max(i3, 3);
        } else {
            Fragment fragment4 = this.f5545c;
            if (fragment4.mRemoving) {
                i3 = fragment4.isInBackStack() ? Math.min(i3, 1) : Math.min(i3, -1);
            }
        }
        Fragment fragment5 = this.f5545c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i3 = Math.min(i3, 4);
        }
        if (l.E0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i3 + " for " + this.f5545c);
        }
        return i3;
    }

    void e() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f5545c);
        }
        Fragment fragment = this.f5545c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f5545c.mState = 1;
            return;
        }
        this.f5543a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f5545c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        k kVar = this.f5543a;
        Fragment fragment3 = this.f5545c;
        kVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() {
        String str;
        if (this.f5545c.mFromLayout) {
            return;
        }
        if (l.E0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f5545c);
        }
        Fragment fragment = this.f5545c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f5545c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i3 = fragment2.mContainerId;
            if (i3 == 0) {
                viewGroup = null;
            } else {
                if (i3 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f5545c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.n0().c(this.f5545c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f5545c;
                    if (!fragment3.mRestored) {
                        try {
                            str = fragment3.getResources().getResourceName(this.f5545c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f5545c.mContainerId) + " (" + str + ") for fragment " + this.f5545c);
                    }
                }
            }
        }
        Fragment fragment4 = this.f5545c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f5545c.mView;
        if (view != null) {
            boolean z3 = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f5545c;
            fragment5.mView.setTag(E.b.f346a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f5545c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (androidx.core.view.y.N(this.f5545c.mView)) {
                androidx.core.view.y.f0(this.f5545c.mView);
            } else {
                View view2 = this.f5545c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f5545c.performViewCreated();
            k kVar = this.f5543a;
            Fragment fragment7 = this.f5545c;
            kVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f5545c.mView.getVisibility();
            float alpha = this.f5545c.mView.getAlpha();
            if (l.f5450P) {
                this.f5545c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f5545c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f5545c.setFocusedView(findFocus);
                        if (l.E0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f5545c);
                        }
                    }
                    this.f5545c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f5545c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z3 = true;
                }
                fragment9.mIsNewlyAdded = z3;
            }
        }
        this.f5545c.mState = 2;
    }

    void g() {
        Fragment f3;
        if (l.E0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f5545c);
        }
        Fragment fragment = this.f5545c;
        boolean z3 = true;
        boolean z4 = fragment.mRemoving && !fragment.isInBackStack();
        if (!z4 && !this.f5544b.o().p(this.f5545c)) {
            String str = this.f5545c.mTargetWho;
            if (str != null && (f3 = this.f5544b.f(str)) != null && f3.mRetainInstance) {
                this.f5545c.mTarget = f3;
            }
            this.f5545c.mState = 0;
            return;
        }
        i iVar = this.f5545c.mHost;
        if (iVar instanceof I) {
            z3 = this.f5544b.o().m();
        } else if (iVar.f() instanceof Activity) {
            z3 = true ^ ((Activity) iVar.f()).isChangingConfigurations();
        }
        if (z4 || z3) {
            this.f5544b.o().g(this.f5545c);
        }
        this.f5545c.performDestroy();
        this.f5543a.d(this.f5545c, false);
        for (r rVar : this.f5544b.k()) {
            if (rVar != null) {
                Fragment k3 = rVar.k();
                if (this.f5545c.mWho.equals(k3.mTargetWho)) {
                    k3.mTarget = this.f5545c;
                    k3.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.f5545c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.f5544b.f(str2);
        }
        this.f5544b.q(this);
    }

    void h() {
        View view;
        if (l.E0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f5545c);
        }
        Fragment fragment = this.f5545c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f5545c.performDestroyView();
        this.f5543a.n(this.f5545c, false);
        Fragment fragment2 = this.f5545c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.j(null);
        this.f5545c.mInLayout = false;
    }

    void i() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f5545c);
        }
        this.f5545c.performDetach();
        this.f5543a.e(this.f5545c, false);
        Fragment fragment = this.f5545c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.f5544b.o().p(this.f5545c)) {
            return;
        }
        if (l.E0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f5545c);
        }
        this.f5545c.initState();
    }

    void j() {
        Fragment fragment = this.f5545c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (l.E0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f5545c);
            }
            Fragment fragment2 = this.f5545c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f5545c.mSavedFragmentState);
            View view = this.f5545c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f5545c;
                fragment3.mView.setTag(E.b.f346a, fragment3);
                Fragment fragment4 = this.f5545c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f5545c.performViewCreated();
                k kVar = this.f5543a;
                Fragment fragment5 = this.f5545c;
                kVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f5545c.mState = 2;
            }
        }
    }

    Fragment k() {
        return this.f5545c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f5546d) {
            if (l.E0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f5546d = true;
            while (true) {
                int d3 = d();
                Fragment fragment = this.f5545c;
                int i3 = fragment.mState;
                if (d3 == i3) {
                    if (l.f5450P && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            z n3 = z.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.f5545c.mHidden) {
                                n3.c(this);
                            } else {
                                n3.e(this);
                            }
                        }
                        Fragment fragment2 = this.f5545c;
                        l lVar = fragment2.mFragmentManager;
                        if (lVar != null) {
                            lVar.C0(fragment2);
                        }
                        Fragment fragment3 = this.f5545c;
                        fragment3.mHiddenChanged = false;
                        fragment3.onHiddenChanged(fragment3.mHidden);
                    }
                    this.f5546d = false;
                    return;
                }
                if (d3 <= i3) {
                    switch (i3 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f5545c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (l.E0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f5545c);
                            }
                            Fragment fragment4 = this.f5545c;
                            if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                s();
                            }
                            Fragment fragment5 = this.f5545c;
                            if (fragment5.mView != null && (viewGroup3 = fragment5.mContainer) != null) {
                                z.n(viewGroup3, fragment5.getParentFragmentManager()).d(this);
                            }
                            this.f5545c.mState = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i3 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                z.n(viewGroup2, fragment.getParentFragmentManager()).b(z.e.c.b(this.f5545c.mView.getVisibility()), this);
                            }
                            this.f5545c.mState = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.f5546d = false;
            throw th;
        }
    }

    void n() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f5545c);
        }
        this.f5545c.performPause();
        this.f5543a.f(this.f5545c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f5545c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f5545c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f5545c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f5545c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f5545c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f5545c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f5545c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f5545c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f5545c);
        }
        View focusedView = this.f5545c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (l.E0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f5545c);
                sb.append(" resulting in focused view ");
                sb.append(this.f5545c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f5545c.setFocusedView(null);
        this.f5545c.performResume();
        this.f5543a.i(this.f5545c, false);
        Fragment fragment = this.f5545c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    q r() {
        q qVar = new q(this.f5545c);
        Fragment fragment = this.f5545c;
        if (fragment.mState <= -1 || qVar.f5542q != null) {
            qVar.f5542q = fragment.mSavedFragmentState;
        } else {
            Bundle q3 = q();
            qVar.f5542q = q3;
            if (this.f5545c.mTargetWho != null) {
                if (q3 == null) {
                    qVar.f5542q = new Bundle();
                }
                qVar.f5542q.putString("android:target_state", this.f5545c.mTargetWho);
                int i3 = this.f5545c.mTargetRequestCode;
                if (i3 != 0) {
                    qVar.f5542q.putInt("android:target_req_state", i3);
                }
            }
        }
        return qVar;
    }

    void s() {
        if (this.f5545c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f5545c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f5545c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f5545c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f5545c.mSavedViewRegistryState = bundle;
    }

    void t(int i3) {
        this.f5547e = i3;
    }

    void u() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f5545c);
        }
        this.f5545c.performStart();
        this.f5543a.k(this.f5545c, false);
    }

    void v() {
        if (l.E0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f5545c);
        }
        this.f5545c.performStop();
        this.f5543a.l(this.f5545c, false);
    }

    r(k kVar, s sVar, ClassLoader classLoader, h hVar, q qVar) {
        this.f5543a = kVar;
        this.f5544b = sVar;
        Fragment a3 = hVar.a(classLoader, qVar.f5530e);
        this.f5545c = a3;
        Bundle bundle = qVar.f5539n;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a3.setArguments(qVar.f5539n);
        a3.mWho = qVar.f5531f;
        a3.mFromLayout = qVar.f5532g;
        a3.mRestored = true;
        a3.mFragmentId = qVar.f5533h;
        a3.mContainerId = qVar.f5534i;
        a3.mTag = qVar.f5535j;
        a3.mRetainInstance = qVar.f5536k;
        a3.mRemoving = qVar.f5537l;
        a3.mDetached = qVar.f5538m;
        a3.mHidden = qVar.f5540o;
        a3.mMaxState = AbstractC0272h.c.values()[qVar.f5541p];
        Bundle bundle2 = qVar.f5542q;
        if (bundle2 != null) {
            a3.mSavedFragmentState = bundle2;
        } else {
            a3.mSavedFragmentState = new Bundle();
        }
        if (l.E0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a3);
        }
    }

    r(k kVar, s sVar, Fragment fragment, q qVar) {
        this.f5543a = kVar;
        this.f5544b = sVar;
        this.f5545c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = qVar.f5542q;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
