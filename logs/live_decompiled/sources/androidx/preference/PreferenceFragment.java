package androidx.preference;

import android.R;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.DialogPreference;
import androidx.preference.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
/* loaded from: classes.dex */
public abstract class PreferenceFragment extends Fragment implements j.c, j.a, j.b, DialogPreference.a {

    /* renamed from: f, reason: collision with root package name */
    private j f5900f;

    /* renamed from: g, reason: collision with root package name */
    RecyclerView f5901g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5902h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5903i;

    /* renamed from: j, reason: collision with root package name */
    private Context f5904j;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f5906l;

    /* renamed from: e, reason: collision with root package name */
    private final c f5899e = new c();

    /* renamed from: k, reason: collision with root package name */
    private int f5905k = p.f6051c;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f5907m = new a();

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f5908n = new b();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragment.this.a();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PreferenceFragment.this.f5901g;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    private class c extends RecyclerView.o {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f5911a;

        /* renamed from: b, reason: collision with root package name */
        private int f5912b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5913c = true;

        c() {
        }

        private boolean m(View view, RecyclerView recyclerView) {
            RecyclerView.E childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z3 = false;
            if (!(childViewHolder instanceof l) || !((l) childViewHolder).d()) {
                return false;
            }
            boolean z4 = this.f5913c;
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
                rect.bottom = this.f5912b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.B b3) {
            if (this.f5911a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (m(childAt, recyclerView)) {
                    int y3 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f5911a.setBounds(0, y3, width, this.f5912b + y3);
                    this.f5911a.draw(canvas);
                }
            }
        }

        public void j(boolean z3) {
            this.f5913c = z3;
        }

        public void k(Drawable drawable) {
            if (drawable != null) {
                this.f5912b = drawable.getIntrinsicHeight();
            } else {
                this.f5912b = 0;
            }
            this.f5911a = drawable;
            PreferenceFragment.this.f5901g.invalidateItemDecorations();
        }

        public void l(int i3) {
            this.f5912b = i3;
            PreferenceFragment.this.f5901g.invalidateItemDecorations();
        }
    }

    private void m() {
        PreferenceScreen d3 = d();
        if (d3 != null) {
            d3.onDetached();
        }
        j();
    }

    void a() {
        PreferenceScreen d3 = d();
        if (d3 != null) {
            c().setAdapter(f(d3));
            d3.onAttached();
        }
        e();
    }

    public Fragment b() {
        return null;
    }

    public final RecyclerView c() {
        return this.f5901g;
    }

    public PreferenceScreen d() {
        return this.f5900f.k();
    }

    protected void e() {
    }

    protected RecyclerView.h f(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.a
    public Preference findPreference(CharSequence charSequence) {
        j jVar = this.f5900f;
        if (jVar == null) {
            return null;
        }
        return jVar.a(charSequence);
    }

    public RecyclerView.p g() {
        return new LinearLayoutManager(getActivity());
    }

    public abstract void h(Bundle bundle, String str);

    public RecyclerView i(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.f5904j.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(o.f6044b)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(p.f6052d, viewGroup, false);
        recyclerView2.setLayoutManager(g());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    protected void j() {
    }

    public void k(Drawable drawable) {
        this.f5899e.k(drawable);
    }

    public void l(int i3) {
        this.f5899e.l(i3);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(m.f6038j, typedValue, true);
        int i3 = typedValue.resourceId;
        if (i3 == 0) {
            i3 = r.f6058a;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i3);
        this.f5904j = contextThemeWrapper;
        j jVar = new j(contextThemeWrapper);
        this.f5900f = jVar;
        jVar.p(this);
        h(bundle, getArguments() != null ? getArguments().getString(g.ARG_PREFERENCE_ROOT) : null);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f5904j;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, s.f6151d1, androidx.core.content.res.i.a(context, m.f6035g, R.attr.preferenceFragmentStyle), 0);
        this.f5905k = obtainStyledAttributes.getResourceId(s.f6155e1, this.f5905k);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.f6159f1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(s.f6163g1, -1);
        boolean z3 = obtainStyledAttributes.getBoolean(s.f6167h1, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.f5904j);
        View inflate = cloneInContext.inflate(this.f5905k, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.list_container);
        if (!(findViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById;
        RecyclerView i3 = i(cloneInContext, viewGroup2, bundle);
        if (i3 == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f5901g = i3;
        i3.addItemDecoration(this.f5899e);
        k(drawable);
        if (dimensionPixelSize != -1) {
            l(dimensionPixelSize);
        }
        this.f5899e.j(z3);
        if (this.f5901g.getParent() == null) {
            viewGroup2.addView(this.f5901g);
        }
        this.f5907m.post(this.f5908n);
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f5907m.removeCallbacks(this.f5908n);
        this.f5907m.removeMessages(1);
        if (this.f5902h) {
            m();
        }
        this.f5901g = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.j.a
    public void onDisplayPreferenceDialog(Preference preference) {
        DialogFragment i3;
        b();
        getActivity();
        if (getFragmentManager().findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            i3 = EditTextPreferenceDialogFragment.i(preference.getKey());
        } else if (preference instanceof ListPreference) {
            i3 = ListPreferenceDialogFragment.i(preference.getKey());
        } else {
            if (!(preference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            i3 = MultiSelectListPreferenceDialogFragment.i(preference.getKey());
        }
        i3.setTargetFragment(this, 0);
        i3.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }

    @Override // androidx.preference.j.b
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        b();
        getActivity();
    }

    @Override // androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference.getFragment() != null) {
            b();
            getActivity();
        }
        return false;
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen d3 = d();
        if (d3 != null) {
            Bundle bundle2 = new Bundle();
            d3.saveHierarchyState(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5900f.q(this);
        this.f5900f.o(this);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5900f.q(null);
        this.f5900f.o(null);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen d3;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (d3 = d()) != null) {
            d3.restoreHierarchyState(bundle2);
        }
        if (this.f5902h) {
            a();
            Runnable runnable = this.f5906l;
            if (runnable != null) {
                runnable.run();
                this.f5906l = null;
            }
        }
        this.f5903i = true;
    }
}
