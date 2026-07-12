package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.view.AbstractC0258g;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.C;
import androidx.lifecycle.F;
import androidx.lifecycle.H;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0271g;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.LiveData;
import c.AbstractC0294a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l.InterfaceC0445a;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.o, I, InterfaceC0271g, M.e {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    F.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    androidx.fragment.app.l mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.i mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.q mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    M.d mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    x mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    androidx.fragment.app.l mChildFragmentManager = new androidx.fragment.app.m();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new a();
    AbstractC0272h.c mMaxState = AbstractC0272h.c.RESUMED;
    androidx.lifecycle.t mViewLifecycleOwnerLiveData = new androidx.lifecycle.t();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<k> mOnPreAttachedListeners = new ArrayList<>();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ z f5306e;

        c(z zVar) {
            this.f5306e = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5306e.g();
        }
    }

    class d extends androidx.fragment.app.f {
        d() {
        }

        @Override // androidx.fragment.app.f
        public View c(int i3) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i3);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.f
        public boolean d() {
            return Fragment.this.mView != null;
        }
    }

    class e implements InterfaceC0445a {
        e() {
        }

        @Override // l.InterfaceC0445a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r22) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.mHost;
            return obj instanceof androidx.activity.result.d ? ((androidx.activity.result.d) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    class f implements InterfaceC0445a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityResultRegistry f5310a;

        f(ActivityResultRegistry activityResultRegistry) {
            this.f5310a = activityResultRegistry;
        }

        @Override // l.InterfaceC0445a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r12) {
            return this.f5310a;
        }
    }

    class g extends k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0445a f5312a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f5313b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC0294a f5314c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.b f5315d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC0445a interfaceC0445a, AtomicReference atomicReference, AbstractC0294a abstractC0294a, androidx.activity.result.b bVar) {
            super(null);
            this.f5312a = interfaceC0445a;
            this.f5313b = atomicReference;
            this.f5314c = abstractC0294a;
            this.f5315d = bVar;
        }

        @Override // androidx.fragment.app.Fragment.k
        void a() {
            String generateActivityResultKey = Fragment.this.generateActivityResultKey();
            this.f5313b.set(((ActivityResultRegistry) this.f5312a.apply(null)).i(generateActivityResultKey, Fragment.this, this.f5314c, this.f5315d));
        }
    }

    class h extends androidx.activity.result.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f5317a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0294a f5318b;

        h(AtomicReference atomicReference, AbstractC0294a abstractC0294a) {
            this.f5317a = atomicReference;
            this.f5318b = abstractC0294a;
        }

        @Override // androidx.activity.result.c
        public void b(Object obj, androidx.core.app.b bVar) {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.f5317a.get();
            if (cVar == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            cVar.b(obj, bVar);
        }

        @Override // androidx.activity.result.c
        public void c() {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.f5317a.getAndSet(null);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    static class i {

        /* renamed from: a, reason: collision with root package name */
        View f5320a;

        /* renamed from: b, reason: collision with root package name */
        Animator f5321b;

        /* renamed from: c, reason: collision with root package name */
        boolean f5322c;

        /* renamed from: d, reason: collision with root package name */
        int f5323d;

        /* renamed from: e, reason: collision with root package name */
        int f5324e;

        /* renamed from: f, reason: collision with root package name */
        int f5325f;

        /* renamed from: g, reason: collision with root package name */
        int f5326g;

        /* renamed from: h, reason: collision with root package name */
        int f5327h;

        /* renamed from: i, reason: collision with root package name */
        ArrayList f5328i;

        /* renamed from: j, reason: collision with root package name */
        ArrayList f5329j;

        /* renamed from: k, reason: collision with root package name */
        Object f5330k = null;

        /* renamed from: l, reason: collision with root package name */
        Object f5331l;

        /* renamed from: m, reason: collision with root package name */
        Object f5332m;

        /* renamed from: n, reason: collision with root package name */
        Object f5333n;

        /* renamed from: o, reason: collision with root package name */
        Object f5334o;

        /* renamed from: p, reason: collision with root package name */
        Object f5335p;

        /* renamed from: q, reason: collision with root package name */
        Boolean f5336q;

        /* renamed from: r, reason: collision with root package name */
        Boolean f5337r;

        /* renamed from: s, reason: collision with root package name */
        float f5338s;

        /* renamed from: t, reason: collision with root package name */
        View f5339t;

        /* renamed from: u, reason: collision with root package name */
        boolean f5340u;

        /* renamed from: v, reason: collision with root package name */
        l f5341v;

        /* renamed from: w, reason: collision with root package name */
        boolean f5342w;

        i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f5331l = obj;
            this.f5332m = null;
            this.f5333n = obj;
            this.f5334o = null;
            this.f5335p = obj;
            this.f5338s = 1.0f;
            this.f5339t = null;
        }
    }

    public static class j extends RuntimeException {
        public j(String str, Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class k {
        private k() {
        }

        abstract void a();

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    interface l {
        void a();

        void b();
    }

    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        final Bundle f5343e;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public m[] newArray(int i3) {
                return new m[i3];
            }
        }

        m(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f5343e = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeBundle(this.f5343e);
        }
    }

    public Fragment() {
        c();
    }

    private i a() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int b() {
        AbstractC0272h.c cVar = this.mMaxState;
        return (cVar == AbstractC0272h.c.INITIALIZED || this.mParentFragment == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.mParentFragment.b());
    }

    private void c() {
        this.mLifecycleRegistry = new androidx.lifecycle.q(this);
        this.mSavedStateRegistryController = M.d.a(this);
        this.mDefaultFactory = null;
    }

    private androidx.activity.result.c d(AbstractC0294a abstractC0294a, InterfaceC0445a interfaceC0445a, androidx.activity.result.b bVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            e(new g(interfaceC0445a, atomicReference, abstractC0294a, bVar));
            return new h(atomicReference, abstractC0294a);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void e(k kVar) {
        if (this.mState >= 0) {
            kVar.a();
        } else {
            this.mOnPreAttachedListeners.add(kVar);
        }
    }

    private void f() {
        if (androidx.fragment.app.l.E0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    void callStartTransitionListener(boolean z3) {
        ViewGroup viewGroup;
        androidx.fragment.app.l lVar;
        i iVar = this.mAnimationInfo;
        l lVar2 = null;
        if (iVar != null) {
            iVar.f5340u = false;
            l lVar3 = iVar.f5341v;
            iVar.f5341v = null;
            lVar2 = lVar3;
        }
        if (lVar2 != null) {
            lVar2.a();
            return;
        }
        if (!androidx.fragment.app.l.f5450P || this.mView == null || (viewGroup = this.mContainer) == null || (lVar = this.mFragmentManager) == null) {
            return;
        }
        z n3 = z.n(viewGroup, lVar);
        n3.p();
        if (z3) {
            this.mHost.g().post(new c(n3));
        } else {
            n3.g();
        }
    }

    androidx.fragment.app.f createFragmentContainer() {
        return new d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.i0(str);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        androidx.fragment.app.i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return (FragmentActivity) iVar.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f5337r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f5336q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f5320a;
    }

    Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f5321b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final androidx.fragment.app.l getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        androidx.fragment.app.i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.f();
    }

    public F.b getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && androidx.fragment.app.l.E0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new C(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5323d;
    }

    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f5330k;
    }

    androidx.core.app.h getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5324e;
    }

    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f5332m;
    }

    androidx.core.app.h getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        iVar.getClass();
        return null;
    }

    View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f5339t;
    }

    @Deprecated
    public final androidx.fragment.app.l getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        androidx.fragment.app.i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.h();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.o
    public AbstractC0272h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public androidx.loader.app.a getLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5327h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final androidx.fragment.app.l getParentFragmentManager() {
        androidx.fragment.app.l lVar = this.mFragmentManager;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f5322c;
    }

    int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5325f;
    }

    int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f5326g;
    }

    float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f5338s;
    }

    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f5333n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f5331l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // M.e
    public final M.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f5334o;
    }

    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f5335p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.f5328i) == null) ? new ArrayList<>() : arrayList;
    }

    ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.f5329j) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i3) {
        return getResources().getString(i3);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        androidx.fragment.app.l lVar = this.mFragmentManager;
        if (lVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return lVar.f0(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i3) {
        return getResources().getText(i3);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.o getViewLifecycleOwner() {
        x xVar = this.mViewLifecycleOwner;
        if (xVar != null) {
            return xVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.I
    public H getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (b() != AbstractC0272h.c.INITIALIZED.ordinal()) {
            return this.mFragmentManager.z0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        c();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new androidx.fragment.app.m();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f5342w;
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        androidx.fragment.app.l lVar;
        return this.mMenuVisible && ((lVar = this.mFragmentManager) == null || lVar.G0(this.mParentFragment));
    }

    boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f5340u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        androidx.fragment.app.l lVar = this.mFragmentManager;
        if (lVar == null) {
            return false;
        }
        return lVar.J0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.S0();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (androidx.fragment.app.l.E0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i3 + " resultCode: " + i4 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        androidx.fragment.app.i iVar = this.mHost;
        Activity e3 = iVar == null ? null : iVar.e();
        if (e3 != null) {
            this.mCalled = false;
            onAttach(e3);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.I0(1)) {
            return;
        }
        this.mChildFragmentManager.C();
    }

    public Animation onCreateAnimation(int i3, boolean z3, int i4) {
        return null;
    }

    public Animator onCreateAnimator(int i3, boolean z3, int i4) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            return layoutInflater.inflate(i3, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z3) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        androidx.fragment.app.i iVar = this.mHost;
        Activity e3 = iVar == null ? null : iVar.e();
        if (e3 != null) {
            this.mCalled = false;
            onInflate(e3, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z3) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z3) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z3) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.S0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            f();
            this.mChildFragmentManager.y();
        } else {
            throw new B("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    void performAttach() {
        Iterator<k> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.k(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.I(this);
            this.mChildFragmentManager.z();
        } else {
            throw new B("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.A(configuration);
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.B(menuItem);
    }

    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.S0();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.l() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.l
            public void a(androidx.lifecycle.o oVar, AbstractC0272h.b bVar) {
                View view;
                if (bVar != AbstractC0272h.b.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.d(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(AbstractC0272h.b.ON_CREATE);
            return;
        }
        throw new B("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z3 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z3 = true;
        }
        return z3 | this.mChildFragmentManager.D(menu, menuInflater);
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.S0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new x(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.b();
            J.a(this.mView, this.mViewLifecycleOwner);
            K.a(this.mView, this.mViewLifecycleOwner);
            M.f.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.j(this.mViewLifecycleOwner);
        }
    }

    void performDestroy() {
        this.mChildFragmentManager.E();
        this.mLifecycleRegistry.h(AbstractC0272h.b.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new B("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.F();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().a(AbstractC0272h.c.CREATED)) {
            this.mViewLifecycleOwner.a(AbstractC0272h.b.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            androidx.loader.app.a.b(this).c();
            this.mPerformedCreateView = false;
        } else {
            throw new B("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.D0()) {
                return;
            }
            this.mChildFragmentManager.E();
            this.mChildFragmentManager = new androidx.fragment.app.m();
            return;
        }
        throw new B("Fragment " + this + " did not call through to super.onDetach()");
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.G();
    }

    void performMultiWindowModeChanged(boolean z3) {
        onMultiWindowModeChanged(z3);
        this.mChildFragmentManager.H(z3);
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.J(menuItem);
    }

    void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.K(menu);
    }

    void performPause() {
        this.mChildFragmentManager.M();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC0272h.b.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(AbstractC0272h.b.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new B("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean z3) {
        onPictureInPictureModeChanged(z3);
        this.mChildFragmentManager.N(z3);
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z3 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z3 = true;
        }
        return z3 | this.mChildFragmentManager.O(menu);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean H02 = this.mFragmentManager.H0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != H02) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(H02);
            onPrimaryNavigationFragmentChanged(H02);
            this.mChildFragmentManager.P();
        }
    }

    void performResume() {
        this.mChildFragmentManager.S0();
        this.mChildFragmentManager.a0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new B("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.q qVar = this.mLifecycleRegistry;
        AbstractC0272h.b bVar = AbstractC0272h.b.ON_RESUME;
        qVar.h(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.Q();
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
        Parcelable h12 = this.mChildFragmentManager.h1();
        if (h12 != null) {
            bundle.putParcelable("android:support:fragments", h12);
        }
    }

    void performStart() {
        this.mChildFragmentManager.S0();
        this.mChildFragmentManager.a0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new B("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.q qVar = this.mLifecycleRegistry;
        AbstractC0272h.b bVar = AbstractC0272h.b.ON_START;
        qVar.h(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.R();
    }

    void performStop() {
        this.mChildFragmentManager.T();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC0272h.b.ON_STOP);
        }
        this.mLifecycleRegistry.h(AbstractC0272h.b.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new B("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.U();
    }

    public void postponeEnterTransition() {
        a().f5340u = true;
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0294a abstractC0294a, androidx.activity.result.b bVar) {
        return d(abstractC0294a, new e(), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i3) {
        if (this.mHost != null) {
            getParentFragmentManager().K0(this, strArr, i3);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final androidx.fragment.app.l requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.f1(parcelable);
        this.mChildFragmentManager.C();
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(AbstractC0272h.b.ON_CREATE);
            }
        } else {
            throw new B("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z3) {
        a().f5337r = Boolean.valueOf(z3);
    }

    public void setAllowReturnTransitionOverlap(boolean z3) {
        a().f5336q = Boolean.valueOf(z3);
    }

    void setAnimatingAway(View view) {
        a().f5320a = view;
    }

    void setAnimations(int i3, int i4, int i5, int i6) {
        if (this.mAnimationInfo == null && i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            return;
        }
        a().f5323d = i3;
        a().f5324e = i4;
        a().f5325f = i5;
        a().f5326g = i6;
    }

    void setAnimator(Animator animator) {
        a().f5321b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(androidx.core.app.h hVar) {
        a().getClass();
    }

    public void setEnterTransition(Object obj) {
        a().f5330k = obj;
    }

    public void setExitSharedElementCallback(androidx.core.app.h hVar) {
        a().getClass();
    }

    public void setExitTransition(Object obj) {
        a().f5332m = obj;
    }

    void setFocusedView(View view) {
        a().f5339t = view;
    }

    public void setHasOptionsMenu(boolean z3) {
        if (this.mHasMenu != z3) {
            this.mHasMenu = z3;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.o();
        }
    }

    void setHideReplaced(boolean z3) {
        a().f5342w = z3;
    }

    public void setInitialSavedState(m mVar) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (mVar == null || (bundle = mVar.f5343e) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z3) {
        if (this.mMenuVisible != z3) {
            this.mMenuVisible = z3;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.o();
            }
        }
    }

    void setNextTransition(int i3) {
        if (this.mAnimationInfo == null && i3 == 0) {
            return;
        }
        a();
        this.mAnimationInfo.f5327h = i3;
    }

    void setOnStartEnterTransitionListener(l lVar) {
        a();
        i iVar = this.mAnimationInfo;
        l lVar2 = iVar.f5341v;
        if (lVar == lVar2) {
            return;
        }
        if (lVar != null && lVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (iVar.f5340u) {
            iVar.f5341v = lVar;
        }
        if (lVar != null) {
            lVar.b();
        }
    }

    void setPopDirection(boolean z3) {
        if (this.mAnimationInfo == null) {
            return;
        }
        a().f5322c = z3;
    }

    void setPostOnViewCreatedAlpha(float f3) {
        a().f5338s = f3;
    }

    public void setReenterTransition(Object obj) {
        a().f5333n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z3) {
        this.mRetainInstance = z3;
        androidx.fragment.app.l lVar = this.mFragmentManager;
        if (lVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z3) {
            lVar.i(this);
        } else {
            lVar.d1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        a().f5331l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        a().f5334o = obj;
    }

    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        a();
        i iVar = this.mAnimationInfo;
        iVar.f5328i = arrayList;
        iVar.f5329j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        a().f5335p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i3) {
        androidx.fragment.app.l lVar = this.mFragmentManager;
        androidx.fragment.app.l lVar2 = fragment != null ? fragment.mFragmentManager : null;
        if (lVar != null && lVar2 != null && lVar != lVar2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i3;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z3) {
        if (!this.mUserVisibleHint && z3 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            androidx.fragment.app.l lVar = this.mFragmentManager;
            lVar.U0(lVar.v(this));
        }
        this.mUserVisibleHint = z3;
        this.mDeferStart = this.mState < 5 && !z3;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z3);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        androidx.fragment.app.i iVar = this.mHost;
        if (iVar != null) {
            return iVar.l(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i3) {
        startActivityForResult(intent, i3, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (androidx.fragment.app.l.E0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i3 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().M0(this, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !a().f5340u) {
            return;
        }
        if (this.mHost == null) {
            a().f5340u = false;
        } else if (Looper.myLooper() != this.mHost.g().getLooper()) {
            this.mHost.g().postAtFrontOfQueue(new b());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) androidx.fragment.app.h.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e3) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (InstantiationException e4) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    public final String getString(int i3, Object... objArr) {
        return getResources().getString(i3, objArr);
    }

    public final void postponeEnterTransition(long j3, TimeUnit timeUnit) {
        a().f5340u = true;
        androidx.fragment.app.l lVar = this.mFragmentManager;
        Handler g3 = lVar != null ? lVar.s0().g() : new Handler(Looper.getMainLooper());
        g3.removeCallbacks(this.mPostponedDurationRunnable);
        g3.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j3));
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0294a abstractC0294a, ActivityResultRegistry activityResultRegistry, androidx.activity.result.b bVar) {
        return d(abstractC0294a, new f(activityResultRegistry), bVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        androidx.fragment.app.i iVar = this.mHost;
        if (iVar != null) {
            iVar.m(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i3, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().L0(this, intent, i3, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        androidx.fragment.app.i iVar = this.mHost;
        if (iVar != null) {
            LayoutInflater i3 = iVar.i();
            AbstractC0258g.a(i3, this.mChildFragmentManager.t0());
            return i3;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
