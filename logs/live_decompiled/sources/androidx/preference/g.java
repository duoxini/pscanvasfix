package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class g extends Fragment implements j.c, j.a, j.b, DialogPreference.a {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private j mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final d mDividerDecoration = new d();
    private int mLayoutResId = p.f6051c;
    private Handler mHandler = new a();
    private final Runnable mRequestFocus = new b();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.bindPreferences();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Preference f5979e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5980f;

        c(Preference preference, String str) {
            this.f5979e = preference;
            this.f5980f = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.h adapter = g.this.mList.getAdapter();
            if (!(adapter instanceof PreferenceGroup.c)) {
                if (adapter != 0) {
                    throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                }
                return;
            }
            Preference preference = this.f5979e;
            int e3 = preference != null ? ((PreferenceGroup.c) adapter).e(preference) : ((PreferenceGroup.c) adapter).d(this.f5980f);
            if (e3 != -1) {
                g.this.mList.scrollToPosition(e3);
            } else {
                adapter.registerAdapterDataObserver(new e(adapter, g.this.mList, this.f5979e, this.f5980f));
            }
        }
    }

    private class d extends RecyclerView.o {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f5982a;

        /* renamed from: b, reason: collision with root package name */
        private int f5983b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5984c = true;

        d() {
        }

        private boolean m(View view, RecyclerView recyclerView) {
            RecyclerView.E childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z3 = false;
            if (!(childViewHolder instanceof l) || !((l) childViewHolder).d()) {
                return false;
            }
            boolean z4 = this.f5984c;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z4;
            }
            RecyclerView.E childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            if ((childViewHolder2 instanceof l) && ((l) childViewHolder2).c()) {
                z3 = true;
            }
            return z3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.B b3) {
            if (m(view, recyclerView)) {
                rect.bottom = this.f5983b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.B b3) {
            if (this.f5982a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (m(childAt, recyclerView)) {
                    int y3 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f5982a.setBounds(0, y3, width, this.f5983b + y3);
                    this.f5982a.draw(canvas);
                }
            }
        }

        public void j(boolean z3) {
            this.f5984c = z3;
        }

        public void k(Drawable drawable) {
            if (drawable != null) {
                this.f5983b = drawable.getIntrinsicHeight();
            } else {
                this.f5983b = 0;
            }
            this.f5982a = drawable;
            g.this.mList.invalidateItemDecorations();
        }

        public void l(int i3) {
            this.f5983b = i3;
            g.this.mList.invalidateItemDecorations();
        }
    }

    private static class e extends RecyclerView.j {

        /* renamed from: a, reason: collision with root package name */
        private final RecyclerView.h f5986a;

        /* renamed from: b, reason: collision with root package name */
        private final RecyclerView f5987b;

        /* renamed from: c, reason: collision with root package name */
        private final Preference f5988c;

        /* renamed from: d, reason: collision with root package name */
        private final String f5989d;

        public e(RecyclerView.h hVar, RecyclerView recyclerView, Preference preference, String str) {
            this.f5986a = hVar;
            this.f5987b = recyclerView;
            this.f5988c = preference;
            this.f5989d = str;
        }

        private void g() {
            this.f5986a.unregisterAdapterDataObserver(this);
            Preference preference = this.f5988c;
            int e3 = preference != null ? ((PreferenceGroup.c) this.f5986a).e(preference) : ((PreferenceGroup.c) this.f5986a).d(this.f5989d);
            if (e3 != -1) {
                this.f5987b.scrollToPosition(e3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void b(int i3, int i4, Object obj) {
            g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i3, int i4) {
            g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i3, int i4, int i5) {
            g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i3, int i4) {
            g();
        }
    }

    private void g() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void h() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void i(Preference preference, String str) {
        c cVar = new c(preference, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = cVar;
        } else {
            cVar.run();
        }
    }

    private void j() {
        getListView().setAdapter(null);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        onUnbindPreferences();
    }

    public void addPreferencesFromResource(int i3) {
        h();
        setPreferenceScreen(this.mPreferenceManager.m(getContext(), i3, getPreferenceScreen()));
    }

    void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.onAttached();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.DialogPreference.a
    public <T extends Preference> T findPreference(CharSequence charSequence) {
        j jVar = this.mPreferenceManager;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public j getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.k();
    }

    protected void onBindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(m.f6038j, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 == 0) {
            i3 = r.f6058a;
        }
        getActivity().getTheme().applyStyle(i3, false);
        j jVar = new j(getContext());
        this.mPreferenceManager = jVar;
        jVar.p(this);
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString(ARG_PREFERENCE_ROOT) : null);
    }

    protected RecyclerView.h onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    public RecyclerView.p onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(o.f6044b)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(p.f6052d, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, s.f6171i1, m.f6034f, 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(s.f6175j1, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.f6178k1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(s.f6181l1, -1);
        boolean z3 = obtainStyledAttributes.getBoolean(s.f6184m1, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(getContext());
        View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.list_container);
        if (!(findViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
        if (onCreateRecyclerView == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.mList = onCreateRecyclerView;
        onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
        setDivider(drawable);
        if (dimensionPixelSize != -1) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mDividerDecoration.j(z3);
        if (this.mList.getParent() == null) {
            viewGroup2.addView(this.mList);
        }
        this.mHandler.post(this.mRequestFocus);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            j();
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.j.a
    public void onDisplayPreferenceDialog(Preference preference) {
        androidx.fragment.app.d q3;
        getCallbackFragment();
        getActivity();
        if (getParentFragmentManager().h0(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            q3 = androidx.preference.a.q(preference.getKey());
        } else if (preference instanceof ListPreference) {
            q3 = androidx.preference.c.q(preference.getKey());
        } else {
            if (!(preference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            q3 = androidx.preference.d.q(preference.getKey());
        }
        q3.setTargetFragment(this, 0);
        q3.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
    }

    @Override // androidx.preference.j.b
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        getCallbackFragment();
        getActivity();
    }

    @Override // androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference.getFragment() == null) {
            return false;
        }
        getCallbackFragment();
        getActivity();
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        androidx.fragment.app.l supportFragmentManager = requireActivity().getSupportFragmentManager();
        Bundle extras = preference.getExtras();
        Fragment a3 = supportFragmentManager.p0().a(requireActivity().getClassLoader(), preference.getFragment());
        a3.setArguments(extras);
        a3.setTargetFragment(this, 0);
        supportFragmentManager.m().p(((View) getView().getParent()).getId(), a3).g(null).h();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPreferenceManager.q(this);
        this.mPreferenceManager.o(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPreferenceManager.q(null);
        this.mPreferenceManager.o(null);
    }

    protected void onUnbindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(String str) {
        i(null, str);
    }

    public void setDivider(Drawable drawable) {
        this.mDividerDecoration.k(drawable);
    }

    public void setDividerHeight(int i3) {
        this.mDividerDecoration.l(i3);
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (!this.mPreferenceManager.r(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        onUnbindPreferences();
        this.mHavePrefs = true;
        if (this.mInitDone) {
            g();
        }
    }

    public void setPreferencesFromResource(int i3, String str) {
        h();
        PreferenceScreen m3 = this.mPreferenceManager.m(getContext(), i3, null);
        PreferenceScreen preferenceScreen = m3;
        if (str != null) {
            Preference k3 = m3.k(str);
            boolean z3 = k3 instanceof PreferenceScreen;
            preferenceScreen = k3;
            if (!z3) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        setPreferenceScreen(preferenceScreen);
    }

    public void scrollToPreference(Preference preference) {
        i(preference, null);
    }
}
