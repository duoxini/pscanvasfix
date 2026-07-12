package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import e.AbstractC0339a;
import java.util.WeakHashMap;
import y.AbstractC0640a;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {

    /* renamed from: c0, reason: collision with root package name */
    static final o f4023c0 = null;

    /* renamed from: A, reason: collision with root package name */
    private View.OnClickListener f4024A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f4025B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f4026C;

    /* renamed from: D, reason: collision with root package name */
    AbstractC0640a f4027D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f4028E;

    /* renamed from: F, reason: collision with root package name */
    private CharSequence f4029F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f4030G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f4031H;

    /* renamed from: I, reason: collision with root package name */
    private int f4032I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f4033J;

    /* renamed from: K, reason: collision with root package name */
    private CharSequence f4034K;

    /* renamed from: L, reason: collision with root package name */
    private CharSequence f4035L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f4036M;

    /* renamed from: N, reason: collision with root package name */
    private int f4037N;

    /* renamed from: O, reason: collision with root package name */
    SearchableInfo f4038O;

    /* renamed from: P, reason: collision with root package name */
    private Bundle f4039P;

    /* renamed from: Q, reason: collision with root package name */
    private final Runnable f4040Q;

    /* renamed from: R, reason: collision with root package name */
    private Runnable f4041R;

    /* renamed from: S, reason: collision with root package name */
    private final WeakHashMap f4042S;

    /* renamed from: T, reason: collision with root package name */
    private final View.OnClickListener f4043T;

    /* renamed from: U, reason: collision with root package name */
    View.OnKeyListener f4044U;

    /* renamed from: V, reason: collision with root package name */
    private final TextView.OnEditorActionListener f4045V;

    /* renamed from: W, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f4046W;

    /* renamed from: a0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f4047a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextWatcher f4048b0;

    /* renamed from: e, reason: collision with root package name */
    final SearchAutoComplete f4049e;

    /* renamed from: f, reason: collision with root package name */
    private final View f4050f;

    /* renamed from: g, reason: collision with root package name */
    private final View f4051g;

    /* renamed from: h, reason: collision with root package name */
    private final View f4052h;

    /* renamed from: i, reason: collision with root package name */
    final ImageView f4053i;

    /* renamed from: j, reason: collision with root package name */
    final ImageView f4054j;

    /* renamed from: k, reason: collision with root package name */
    final ImageView f4055k;

    /* renamed from: l, reason: collision with root package name */
    final ImageView f4056l;

    /* renamed from: m, reason: collision with root package name */
    private final View f4057m;

    /* renamed from: n, reason: collision with root package name */
    private q f4058n;

    /* renamed from: o, reason: collision with root package name */
    private Rect f4059o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f4060p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f4061q;

    /* renamed from: r, reason: collision with root package name */
    private int[] f4062r;

    /* renamed from: s, reason: collision with root package name */
    private final ImageView f4063s;

    /* renamed from: t, reason: collision with root package name */
    private final Drawable f4064t;

    /* renamed from: u, reason: collision with root package name */
    private final int f4065u;

    /* renamed from: v, reason: collision with root package name */
    private final int f4066v;

    /* renamed from: w, reason: collision with root package name */
    private final Intent f4067w;

    /* renamed from: x, reason: collision with root package name */
    private final Intent f4068x;

    /* renamed from: y, reason: collision with root package name */
    private final CharSequence f4069y;

    /* renamed from: z, reason: collision with root package name */
    View.OnFocusChangeListener f4070z;

    public static class SearchAutoComplete extends C0230d {

        /* renamed from: i, reason: collision with root package name */
        private int f4071i;

        /* renamed from: j, reason: collision with root package name */
        private SearchView f4072j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f4073k;

        /* renamed from: l, reason: collision with root package name */
        final Runnable f4074l;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, AbstractC0339a.f11098m);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            if (i3 >= 960 && i4 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i3 < 600) {
                return (i3 < 640 || i4 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() {
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void d() {
            if (this.f4073k) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f4073k = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f4071i <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.C0230d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f4073k) {
                removeCallbacks(this.f4074l);
                post(this.f4074l);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z3, int i3, Rect rect) {
            super.onFocusChanged(z3, i3, rect);
            this.f4072j.B();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f4072j.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z3) {
            super.onWindowFocusChanged(z3);
            if (z3 && this.f4072j.hasFocus() && getVisibility() == 0) {
                this.f4073k = true;
                if (SearchView.o(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z3) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z3) {
                this.f4073k = false;
                removeCallbacks(this.f4074l);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f4073k = true;
                    return;
                }
                this.f4073k = false;
                removeCallbacks(this.f4074l);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f4072j = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i3) {
            super.setThreshold(i3);
            this.f4071i = i3;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f4074l = new a();
            this.f4071i = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            SearchView.this.A(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.H();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0640a abstractC0640a = SearchView.this.f4027D;
            if (abstractC0640a instanceof P) {
                abstractC0640a.changeCursor(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f4070z;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z3);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            SearchView.this.d();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f4053i) {
                searchView.x();
                return;
            }
            if (view == searchView.f4055k) {
                searchView.t();
                return;
            }
            if (view == searchView.f4054j) {
                searchView.y();
            } else if (view == searchView.f4056l) {
                searchView.C();
            } else if (view == searchView.f4049e) {
                searchView.j();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f4038O == null) {
                return false;
            }
            if (searchView.f4049e.isPopupShowing() && SearchView.this.f4049e.getListSelection() != -1) {
                return SearchView.this.z(view, i3, keyEvent);
            }
            if (SearchView.this.f4049e.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i3 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.r(0, null, searchView2.f4049e.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            SearchView.this.y();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            SearchView.this.u(i3, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            SearchView.this.v(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class k {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i3) {
            searchAutoComplete.setInputMethodMode(i3);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    private static class o {
    }

    static class p extends AbstractC0645a {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        boolean f4086e;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public p[] newArray(int i3) {
                return new p[i3];
            }
        }

        p(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f4086e + "}";
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f4086e));
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4086e = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    private static class q extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f4087a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f4088b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f4089c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f4090d;

        /* renamed from: e, reason: collision with root package name */
        private final int f4091e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f4092f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f4091e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f4088b = new Rect();
            this.f4090d = new Rect();
            this.f4089c = new Rect();
            a(rect, rect2);
            this.f4087a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f4088b.set(rect);
            this.f4090d.set(rect);
            Rect rect3 = this.f4090d;
            int i3 = this.f4091e;
            rect3.inset(-i3, -i3);
            this.f4089c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z3;
            boolean z4;
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z5 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z4 = this.f4092f;
                    if (z4 && !this.f4090d.contains(x3, y3)) {
                        z5 = z4;
                        z3 = false;
                    }
                } else {
                    if (action == 3) {
                        z4 = this.f4092f;
                        this.f4092f = false;
                    }
                    z3 = true;
                    z5 = false;
                }
                z5 = z4;
                z3 = true;
            } else {
                if (this.f4088b.contains(x3, y3)) {
                    this.f4092f = true;
                    z3 = true;
                }
                z3 = true;
                z5 = false;
            }
            if (!z5) {
                return false;
            }
            if (!z3 || this.f4089c.contains(x3, y3)) {
                Rect rect = this.f4089c;
                motionEvent.setLocation(x3 - rect.left, y3 - rect.top);
            } else {
                motionEvent.setLocation(this.f4087a.getWidth() / 2, this.f4087a.getHeight() / 2);
            }
            return this.f4087a.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private void D() {
        post(this.f4040Q);
    }

    private void E(int i3) {
        Editable text = this.f4049e.getText();
        Cursor cursor = this.f4027D.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i3)) {
            setQuery(text);
            return;
        }
        CharSequence convertToString = this.f4027D.convertToString(cursor);
        if (convertToString != null) {
            setQuery(convertToString);
        } else {
            setQuery(text);
        }
    }

    private void G() {
        boolean isEmpty = TextUtils.isEmpty(this.f4049e.getText());
        this.f4055k.setVisibility(!isEmpty || (this.f4025B && !this.f4036M) ? 0 : 8);
        Drawable drawable = this.f4055k.getDrawable();
        if (drawable != null) {
            drawable.setState(!isEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void I() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f4049e;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(l(queryHint));
    }

    private void J() {
        this.f4049e.setThreshold(this.f4038O.getSuggestThreshold());
        this.f4049e.setImeOptions(this.f4038O.getImeOptions());
        int inputType = this.f4038O.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f4038O.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f4049e.setInputType(inputType);
        AbstractC0640a abstractC0640a = this.f4027D;
        if (abstractC0640a != null) {
            abstractC0640a.changeCursor(null);
        }
        if (this.f4038O.getSuggestAuthority() != null) {
            P p3 = new P(getContext(), this, this.f4038O, this.f4042S);
            this.f4027D = p3;
            this.f4049e.setAdapter(p3);
            ((P) this.f4027D).t(this.f4030G ? 2 : 1);
        }
    }

    private void K() {
        this.f4052h.setVisibility((p() && (this.f4054j.getVisibility() == 0 || this.f4056l.getVisibility() == 0)) ? 0 : 8);
    }

    private void L(boolean z3) {
        this.f4054j.setVisibility((this.f4028E && p() && hasFocus() && (z3 || !this.f4033J)) ? 0 : 8);
    }

    private void M(boolean z3) {
        this.f4026C = z3;
        int i3 = 8;
        int i4 = z3 ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.f4049e.getText());
        this.f4053i.setVisibility(i4);
        L(!isEmpty);
        this.f4050f.setVisibility(z3 ? 8 : 0);
        if (this.f4063s.getDrawable() != null && !this.f4025B) {
            i3 = 0;
        }
        this.f4063s.setVisibility(i3);
        G();
        N(isEmpty);
        K();
    }

    private void N(boolean z3) {
        int i3 = 8;
        if (this.f4033J && !n() && z3) {
            this.f4054j.setVisibility(8);
            i3 = 0;
        }
        this.f4056l.setVisibility(i3);
    }

    private Intent e(String str, Uri uri, String str2, String str3, int i3, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f4035L);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f4039P;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i3 != 0) {
            intent.putExtra("action_key", i3);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f4038O.getSearchActivity());
        return intent;
    }

    private Intent f(Cursor cursor, int i3, String str) {
        int i4;
        String k3;
        try {
            String k4 = P.k(cursor, "suggest_intent_action");
            if (k4 == null) {
                k4 = this.f4038O.getSuggestIntentAction();
            }
            if (k4 == null) {
                k4 = "android.intent.action.SEARCH";
            }
            String str2 = k4;
            String k5 = P.k(cursor, "suggest_intent_data");
            if (k5 == null) {
                k5 = this.f4038O.getSuggestIntentData();
            }
            if (k5 != null && (k3 = P.k(cursor, "suggest_intent_data_id")) != null) {
                k5 = k5 + "/" + Uri.encode(k3);
            }
            return e(str2, k5 == null ? null : Uri.parse(k5), P.k(cursor, "suggest_intent_extra_data"), P.k(cursor, "suggest_intent_query"), i3, str);
        } catch (RuntimeException e3) {
            try {
                i4 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i4 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i4 + " returned exception.", e3);
            return null;
        }
    }

    private Intent g(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4039P;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(e.d.f11125e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(e.d.f11126f);
    }

    private Intent h(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void i() {
        this.f4049e.dismissDropDown();
    }

    private void k(View view, Rect rect) {
        view.getLocationInWindow(this.f4061q);
        getLocationInWindow(this.f4062r);
        int[] iArr = this.f4061q;
        int i3 = iArr[1];
        int[] iArr2 = this.f4062r;
        int i4 = i3 - iArr2[1];
        int i5 = iArr[0] - iArr2[0];
        rect.set(i5, i4, view.getWidth() + i5, view.getHeight() + i4);
    }

    private CharSequence l(CharSequence charSequence) {
        if (!this.f4025B || this.f4064t == null) {
            return charSequence;
        }
        int textSize = (int) (this.f4049e.getTextSize() * 1.25d);
        this.f4064t.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f4064t), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean m() {
        SearchableInfo searchableInfo = this.f4038O;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.f4038O.getVoiceSearchLaunchWebSearch() ? this.f4067w : this.f4038O.getVoiceSearchLaunchRecognizer() ? this.f4068x : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean o(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean p() {
        return (this.f4028E || this.f4033J) && !n();
    }

    private void q(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e3) {
            Log.e("SearchView", "Failed launch activity: " + intent, e3);
        }
    }

    private boolean s(int i3, int i4, String str) {
        Cursor cursor = this.f4027D.getCursor();
        if (cursor == null || !cursor.moveToPosition(i3)) {
            return false;
        }
        q(f(cursor, i4, str));
        return true;
    }

    private void setQuery(CharSequence charSequence) {
        this.f4049e.setText(charSequence);
        this.f4049e.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void A(CharSequence charSequence) {
        Editable text = this.f4049e.getText();
        this.f4035L = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        L(!isEmpty);
        N(isEmpty);
        G();
        K();
        this.f4034K = charSequence.toString();
    }

    void B() {
        M(n());
        D();
        if (this.f4049e.hasFocus()) {
            j();
        }
    }

    void C() {
        SearchableInfo searchableInfo = this.f4038O;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(h(this.f4067w, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(g(this.f4068x, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public void F(CharSequence charSequence, boolean z3) {
        this.f4049e.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f4049e;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f4035L = charSequence;
        }
        if (!z3 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        y();
    }

    void H() {
        int[] iArr = this.f4049e.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f4051g.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f4052h.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f4031H = true;
        super.clearFocus();
        this.f4049e.clearFocus();
        this.f4049e.setImeVisibility(false);
        this.f4031H = false;
    }

    void d() {
        if (this.f4057m.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f4051g.getPaddingLeft();
            Rect rect = new Rect();
            boolean b3 = b0.b(this);
            int dimensionPixelSize = this.f4025B ? resources.getDimensionPixelSize(e.d.f11123c) + resources.getDimensionPixelSize(e.d.f11124d) : 0;
            this.f4049e.getDropDownBackground().getPadding(rect);
            this.f4049e.setDropDownHorizontalOffset(b3 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f4049e.setDropDownWidth((((this.f4057m.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public int getImeOptions() {
        return this.f4049e.getImeOptions();
    }

    public int getInputType() {
        return this.f4049e.getInputType();
    }

    public int getMaxWidth() {
        return this.f4032I;
    }

    public CharSequence getQuery() {
        return this.f4049e.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f4029F;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f4038O;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f4069y : getContext().getText(this.f4038O.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f4066v;
    }

    int getSuggestionRowLayout() {
        return this.f4065u;
    }

    public AbstractC0640a getSuggestionsAdapter() {
        return this.f4027D;
    }

    void j() {
        k.a(this.f4049e);
    }

    public boolean n() {
        return this.f4026C;
    }

    @Override // androidx.appcompat.view.c
    public void onActionViewCollapsed() {
        F("", false);
        clearFocus();
        M(true);
        this.f4049e.setImeOptions(this.f4037N);
        this.f4036M = false;
    }

    @Override // androidx.appcompat.view.c
    public void onActionViewExpanded() {
        if (this.f4036M) {
            return;
        }
        this.f4036M = true;
        int imeOptions = this.f4049e.getImeOptions();
        this.f4037N = imeOptions;
        this.f4049e.setImeOptions(imeOptions | 33554432);
        this.f4049e.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f4040Q);
        post(this.f4041R);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (z3) {
            k(this.f4049e, this.f4059o);
            Rect rect = this.f4060p;
            Rect rect2 = this.f4059o;
            rect.set(rect2.left, 0, rect2.right, i6 - i4);
            q qVar = this.f4058n;
            if (qVar != null) {
                qVar.a(this.f4060p, this.f4059o);
                return;
            }
            q qVar2 = new q(this.f4060p, this.f4059o, this.f4049e);
            this.f4058n = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        if (n()) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.f4032I;
            size = i6 > 0 ? Math.min(i6, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f4032I;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i5 = this.f4032I) > 0) {
            size = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.getSuperState());
        M(pVar.f4086e);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.f4086e = n();
        return pVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        D();
    }

    void r(int i3, String str, String str2) {
        getContext().startActivity(e("android.intent.action.SEARCH", null, null, str2, i3, str));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i3, Rect rect) {
        if (this.f4031H || !isFocusable()) {
            return false;
        }
        if (n()) {
            return super.requestFocus(i3, rect);
        }
        boolean requestFocus = this.f4049e.requestFocus(i3, rect);
        if (requestFocus) {
            M(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f4039P = bundle;
    }

    public void setIconified(boolean z3) {
        if (z3) {
            t();
        } else {
            x();
        }
    }

    public void setIconifiedByDefault(boolean z3) {
        if (this.f4025B == z3) {
            return;
        }
        this.f4025B = z3;
        M(z3);
        I();
    }

    public void setImeOptions(int i3) {
        this.f4049e.setImeOptions(i3);
    }

    public void setInputType(int i3) {
        this.f4049e.setInputType(i3);
    }

    public void setMaxWidth(int i3) {
        this.f4032I = i3;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f4070z = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f4024A = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f4029F = charSequence;
        I();
    }

    public void setQueryRefinementEnabled(boolean z3) {
        this.f4030G = z3;
        AbstractC0640a abstractC0640a = this.f4027D;
        if (abstractC0640a instanceof P) {
            ((P) abstractC0640a).t(z3 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f4038O = searchableInfo;
        if (searchableInfo != null) {
            J();
            I();
        }
        boolean m3 = m();
        this.f4033J = m3;
        if (m3) {
            this.f4049e.setPrivateImeOptions("nm");
        }
        M(n());
    }

    public void setSubmitButtonEnabled(boolean z3) {
        this.f4028E = z3;
        M(n());
    }

    public void setSuggestionsAdapter(AbstractC0640a abstractC0640a) {
        this.f4027D = abstractC0640a;
        this.f4049e.setAdapter(abstractC0640a);
    }

    void t() {
        if (!TextUtils.isEmpty(this.f4049e.getText())) {
            this.f4049e.setText("");
            this.f4049e.requestFocus();
            this.f4049e.setImeVisibility(true);
        } else if (this.f4025B) {
            clearFocus();
            M(true);
        }
    }

    boolean u(int i3, int i4, String str) {
        s(i3, 0, null);
        this.f4049e.setImeVisibility(false);
        i();
        return true;
    }

    boolean v(int i3) {
        E(i3);
        return true;
    }

    protected void w(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void x() {
        M(false);
        this.f4049e.requestFocus();
        this.f4049e.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f4024A;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void y() {
        Editable text = this.f4049e.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f4038O != null) {
            r(0, null, text.toString());
        }
        this.f4049e.setImeVisibility(false);
        i();
    }

    boolean z(View view, int i3, KeyEvent keyEvent) {
        if (this.f4038O != null && this.f4027D != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i3 == 66 || i3 == 84 || i3 == 61) {
                return u(this.f4049e.getListSelection(), 0, null);
            }
            if (i3 == 21 || i3 == 22) {
                this.f4049e.setSelection(i3 == 21 ? 0 : this.f4049e.length());
                this.f4049e.setListSelection(0);
                this.f4049e.clearListSelection();
                this.f4049e.b();
                return true;
            }
            if (i3 == 19) {
                this.f4049e.getListSelection();
                return false;
            }
        }
        return false;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11079H);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4059o = new Rect();
        this.f4060p = new Rect();
        this.f4061q = new int[2];
        this.f4062r = new int[2];
        this.f4040Q = new b();
        this.f4041R = new c();
        this.f4042S = new WeakHashMap();
        f fVar = new f();
        this.f4043T = fVar;
        this.f4044U = new g();
        h hVar = new h();
        this.f4045V = hVar;
        i iVar = new i();
        this.f4046W = iVar;
        j jVar = new j();
        this.f4047a0 = jVar;
        this.f4048b0 = new a();
        V w3 = V.w(context, attributeSet, e.j.f11379f2, i3, 0);
        androidx.core.view.y.h0(this, context, e.j.f11379f2, attributeSet, w3.r(), i3, 0);
        LayoutInflater.from(context).inflate(w3.n(e.j.f11419p2, e.g.f11233r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(e.f.f11177C);
        this.f4049e = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f4050f = findViewById(e.f.f11214y);
        View findViewById = findViewById(e.f.f11176B);
        this.f4051g = findViewById;
        View findViewById2 = findViewById(e.f.f11183I);
        this.f4052h = findViewById2;
        ImageView imageView = (ImageView) findViewById(e.f.f11212w);
        this.f4053i = imageView;
        ImageView imageView2 = (ImageView) findViewById(e.f.f11215z);
        this.f4054j = imageView2;
        ImageView imageView3 = (ImageView) findViewById(e.f.f11213x);
        this.f4055k = imageView3;
        ImageView imageView4 = (ImageView) findViewById(e.f.f11178D);
        this.f4056l = imageView4;
        ImageView imageView5 = (ImageView) findViewById(e.f.f11175A);
        this.f4063s = imageView5;
        androidx.core.view.y.n0(findViewById, w3.g(e.j.f11423q2));
        androidx.core.view.y.n0(findViewById2, w3.g(e.j.f11439u2));
        imageView.setImageDrawable(w3.g(e.j.f11435t2));
        imageView2.setImageDrawable(w3.g(e.j.f11411n2));
        imageView3.setImageDrawable(w3.g(e.j.f11399k2));
        imageView4.setImageDrawable(w3.g(e.j.f11447w2));
        imageView5.setImageDrawable(w3.g(e.j.f11435t2));
        this.f4064t = w3.g(e.j.f11431s2);
        Z.a(imageView, getResources().getString(e.h.f11249o));
        this.f4065u = w3.n(e.j.f11443v2, e.g.f11232q);
        this.f4066v = w3.n(e.j.f11403l2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f4048b0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f4044U);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(w3.a(e.j.f11415o2, true));
        int f3 = w3.f(e.j.f11387h2, -1);
        if (f3 != -1) {
            setMaxWidth(f3);
        }
        this.f4069y = w3.p(e.j.f11407m2);
        this.f4029F = w3.p(e.j.f11427r2);
        int k3 = w3.k(e.j.f11395j2, -1);
        if (k3 != -1) {
            setImeOptions(k3);
        }
        int k4 = w3.k(e.j.f11391i2, -1);
        if (k4 != -1) {
            setInputType(k4);
        }
        setFocusable(w3.a(e.j.f11383g2, true));
        w3.x();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f4067w = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f4068x = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f4057m = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        M(this.f4025B);
        I();
    }
}
