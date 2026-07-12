package androidx.preference;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.preference.j;
import f.AbstractC0348a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private static final String CLIPBOARD_ID = "Preference";
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private Context mContext;
    private boolean mCopyingEnabled;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private c mListener;
    private d mOnChangeListener;
    private e mOnClickListener;
    private f mOnCopyListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;
    private androidx.preference.e mPreferenceDataStore;
    private j mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private g mSummaryProvider;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.performClick(view);
        }
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface c {
        void a(Preference preference);

        void b(Preference preference);

        void c(Preference preference);
    }

    public interface d {
        boolean a(Preference preference, Object obj);
    }

    public interface e {
        boolean a(Preference preference);
    }

    private static class f implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: e, reason: collision with root package name */
        private final Preference f5890e;

        f(Preference preference) {
            this.f5890e = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence summary = this.f5890e.getSummary();
            if (!this.f5890e.isCopyingEnabled() || TextUtils.isEmpty(summary)) {
                return;
            }
            contextMenu.setHeaderTitle(summary);
            contextMenu.add(0, 0, 0, q.f6053a).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f5890e.getContext().getSystemService("clipboard");
            CharSequence summary = this.f5890e.getSummary();
            clipboardManager.setPrimaryClip(ClipData.newPlainText(Preference.CLIPBOARD_ID, summary));
            Toast.makeText(this.f5890e.getContext(), this.f5890e.getContext().getString(q.f6056d, summary), 0).show();
            return true;
        }
    }

    public interface g {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.mOrder = DEFAULT_ORDER;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = p.f6050b;
        this.mClickListener = new a();
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6201s0, i3, i4);
        this.mIconResId = androidx.core.content.res.i.e(obtainStyledAttributes, s.f6108Q0, s.f6204t0, 0);
        this.mKey = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6117T0, s.f6222z0);
        this.mTitle = androidx.core.content.res.i.g(obtainStyledAttributes, s.f6143b1, s.f6216x0);
        this.mSummary = androidx.core.content.res.i.g(obtainStyledAttributes, s.f6139a1, s.f6060A0);
        this.mOrder = androidx.core.content.res.i.d(obtainStyledAttributes, s.f6123V0, s.f6063B0, DEFAULT_ORDER);
        this.mFragment = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6105P0, s.f6078G0);
        this.mLayoutResId = androidx.core.content.res.i.e(obtainStyledAttributes, s.f6120U0, s.f6213w0, p.f6050b);
        this.mWidgetLayoutResId = androidx.core.content.res.i.e(obtainStyledAttributes, s.f6147c1, s.f6066C0, 0);
        this.mEnabled = androidx.core.content.res.i.b(obtainStyledAttributes, s.f6102O0, s.f6210v0, true);
        this.mSelectable = androidx.core.content.res.i.b(obtainStyledAttributes, s.f6129X0, s.f6219y0, true);
        this.mPersistent = androidx.core.content.res.i.b(obtainStyledAttributes, s.f6126W0, s.f6207u0, true);
        this.mDependencyKey = androidx.core.content.res.i.f(obtainStyledAttributes, s.f6096M0, s.f6069D0);
        int i5 = s.f6087J0;
        this.mAllowDividerAbove = androidx.core.content.res.i.b(obtainStyledAttributes, i5, i5, this.mSelectable);
        int i6 = s.f6090K0;
        this.mAllowDividerBelow = androidx.core.content.res.i.b(obtainStyledAttributes, i6, i6, this.mSelectable);
        if (obtainStyledAttributes.hasValue(s.f6093L0)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, s.f6093L0);
        } else if (obtainStyledAttributes.hasValue(s.f6072E0)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, s.f6072E0);
        }
        this.mShouldDisableView = androidx.core.content.res.i.b(obtainStyledAttributes, s.f6132Y0, s.f6075F0, true);
        boolean hasValue = obtainStyledAttributes.hasValue(s.f6135Z0);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            this.mSingleLineTitle = androidx.core.content.res.i.b(obtainStyledAttributes, s.f6135Z0, s.f6081H0, true);
        }
        this.mIconSpaceReserved = androidx.core.content.res.i.b(obtainStyledAttributes, s.f6111R0, s.f6084I0, false);
        int i7 = s.f6114S0;
        this.mVisible = androidx.core.content.res.i.b(obtainStyledAttributes, i7, i7, true);
        int i8 = s.f6099N0;
        this.mCopyingEnabled = androidx.core.content.res.i.b(obtainStyledAttributes, i8, i8, false);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        getPreferenceDataStore();
        if (shouldPersist() && getSharedPreferences().contains(this.mKey)) {
            onSetInitialValue(true, null);
            return;
        }
        Object obj = this.mDefaultValue;
        if (obj != null) {
            onSetInitialValue(false, obj);
        }
    }

    private void c() {
        if (TextUtils.isEmpty(this.mDependencyKey)) {
            return;
        }
        Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.mDependencyKey);
        if (findPreferenceInHierarchy != null) {
            findPreferenceInHierarchy.d(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + ((Object) this.mTitle) + "\"");
    }

    private void d(Preference preference) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void e(View view, boolean z3) {
        view.setEnabled(z3);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                e(viewGroup.getChildAt(childCount), z3);
            }
        }
    }

    private void f(SharedPreferences.Editor editor) {
        if (this.mPreferenceManager.t()) {
            editor.apply();
        }
    }

    private void g() {
        Preference findPreferenceInHierarchy;
        String str = this.mDependencyKey;
        if (str == null || (findPreferenceInHierarchy = findPreferenceInHierarchy(str)) == null) {
            return;
        }
        findPreferenceInHierarchy.h(this);
    }

    private void h(Preference preference) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            list.remove(preference);
        }
    }

    void assignParent(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.mParentGroup != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.mParentGroup = preferenceGroup;
    }

    public boolean callChangeListener(Object obj) {
        d dVar = this.mOnChangeListener;
        return dVar == null || dVar.a(this, obj);
    }

    final void clearWasDetached() {
        this.mWasDetached = false;
    }

    void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        if (!hasKey() || (parcelable = bundle.getParcelable(this.mKey)) == null) {
            return;
        }
        this.mBaseMethodCalled = false;
        onRestoreInstanceState(parcelable);
        if (!this.mBaseMethodCalled) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    void dispatchSaveInstanceState(Bundle bundle) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (onSaveInstanceState != null) {
                bundle.putParcelable(this.mKey, onSaveInstanceState);
            }
        }
    }

    protected <T extends Preference> T findPreferenceInHierarchy(String str) {
        j jVar = this.mPreferenceManager;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(str);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Drawable getIcon() {
        int i3;
        if (this.mIcon == null && (i3 = this.mIconResId) != 0) {
            this.mIcon = AbstractC0348a.b(this.mContext, i3);
        }
        return this.mIcon;
    }

    long getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getKey() {
        return this.mKey;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public d getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public e getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    protected boolean getPersistedBoolean(boolean z3) {
        if (!shouldPersist()) {
            return z3;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getBoolean(this.mKey, z3);
    }

    protected float getPersistedFloat(float f3) {
        if (!shouldPersist()) {
            return f3;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getFloat(this.mKey, f3);
    }

    protected int getPersistedInt(int i3) {
        if (!shouldPersist()) {
            return i3;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getInt(this.mKey, i3);
    }

    protected long getPersistedLong(long j3) {
        if (!shouldPersist()) {
            return j3;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getLong(this.mKey, j3);
    }

    protected String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getString(this.mKey, str);
    }

    public Set<String> getPersistedStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return set;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getStringSet(this.mKey, set);
    }

    public androidx.preference.e getPreferenceDataStore() {
        j jVar = this.mPreferenceManager;
        if (jVar != null) {
            jVar.j();
        }
        return null;
    }

    public j getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager == null) {
            return null;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l();
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public CharSequence getSummary() {
        return getSummaryProvider() != null ? getSummaryProvider().a(this) : this.mSummary;
    }

    public final g getSummaryProvider() {
        return this.mSummaryProvider;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public boolean isCopyingEnabled() {
        return this.mCopyingEnabled;
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet && this.mParentDependencyMet;
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public final boolean isShown() {
        if (!isVisible() || getPreferenceManager() == null) {
            return false;
        }
        if (this == getPreferenceManager().k()) {
            return true;
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            return false;
        }
        return parent.isShown();
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    protected void notifyChanged() {
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void notifyDependencyChange(boolean z3) {
        List<Preference> list = this.mDependents;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            list.get(i3).onDependencyChanged(this, z3);
        }
    }

    protected void notifyHierarchyChanged() {
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public void onAttached() {
        c();
    }

    protected void onAttachedToHierarchy(j jVar) {
        this.mPreferenceManager = jVar;
        if (!this.mHasId) {
            this.mId = jVar.f();
        }
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.preference.l r9) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.onBindViewHolder(androidx.preference.l):void");
    }

    protected void onClick() {
    }

    public void onDependencyChanged(Preference preference, boolean z3) {
        if (this.mDependencyMet == z3) {
            this.mDependencyMet = !z3;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onDetached() {
        g();
        this.mWasDetached = true;
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return null;
    }

    @Deprecated
    public void onInitializeAccessibilityNodeInfo(androidx.core.view.accessibility.d dVar) {
    }

    public void onParentChanged(Preference preference, boolean z3) {
        if (this.mParentDependencyMet == z3) {
            this.mParentDependencyMet = !z3;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    protected void onPrepareForRemoval() {
        g();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return AbsSavedState.EMPTY_STATE;
    }

    protected void onSetInitialValue(Object obj) {
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    protected void performClick(View view) {
        performClick();
    }

    protected boolean persistBoolean(boolean z3) {
        if (!shouldPersist()) {
            return false;
        }
        if (z3 == getPersistedBoolean(!z3)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e3 = this.mPreferenceManager.e();
        e3.putBoolean(this.mKey, z3);
        f(e3);
        return true;
    }

    protected boolean persistFloat(float f3) {
        if (!shouldPersist()) {
            return false;
        }
        if (f3 == getPersistedFloat(Float.NaN)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e3 = this.mPreferenceManager.e();
        e3.putFloat(this.mKey, f3);
        f(e3);
        return true;
    }

    protected boolean persistInt(int i3) {
        if (!shouldPersist()) {
            return false;
        }
        if (i3 == getPersistedInt(~i3)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e3 = this.mPreferenceManager.e();
        e3.putInt(this.mKey, i3);
        f(e3);
        return true;
    }

    protected boolean persistLong(long j3) {
        if (!shouldPersist()) {
            return false;
        }
        if (j3 == getPersistedLong(~j3)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e3 = this.mPreferenceManager.e();
        e3.putLong(this.mKey, j3);
        f(e3);
        return true;
    }

    protected boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        if (TextUtils.equals(str, getPersistedString(null))) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e3 = this.mPreferenceManager.e();
        e3.putString(this.mKey, str);
        f(e3);
        return true;
    }

    public boolean persistStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return false;
        }
        if (set.equals(getPersistedStringSet(null))) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e3 = this.mPreferenceManager.e();
        e3.putStringSet(this.mKey, set);
        f(e3);
        return true;
    }

    void requireKey() {
        if (TextUtils.isEmpty(this.mKey)) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        this.mRequiresKey = true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCopyingEnabled(boolean z3) {
        if (this.mCopyingEnabled != z3) {
            this.mCopyingEnabled = z3;
            notifyChanged();
        }
    }

    public void setDefaultValue(Object obj) {
        this.mDefaultValue = obj;
    }

    public void setDependency(String str) {
        g();
        this.mDependencyKey = str;
        c();
    }

    public void setEnabled(boolean z3) {
        if (this.mEnabled != z3) {
            this.mEnabled = z3;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String str) {
        this.mFragment = str;
    }

    public void setIcon(Drawable drawable) {
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            this.mIconResId = 0;
            notifyChanged();
        }
    }

    public void setIconSpaceReserved(boolean z3) {
        if (this.mIconSpaceReserved != z3) {
            this.mIconSpaceReserved = z3;
            notifyChanged();
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setKey(String str) {
        this.mKey = str;
        if (!this.mRequiresKey || hasKey()) {
            return;
        }
        requireKey();
    }

    public void setLayoutResource(int i3) {
        this.mLayoutResId = i3;
    }

    final void setOnPreferenceChangeInternalListener(c cVar) {
        this.mListener = cVar;
    }

    public void setOnPreferenceChangeListener(d dVar) {
        this.mOnChangeListener = dVar;
    }

    public void setOnPreferenceClickListener(e eVar) {
        this.mOnClickListener = eVar;
    }

    public void setOrder(int i3) {
        if (i3 != this.mOrder) {
            this.mOrder = i3;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean z3) {
        this.mPersistent = z3;
    }

    public void setPreferenceDataStore(androidx.preference.e eVar) {
    }

    public void setSelectable(boolean z3) {
        if (this.mSelectable != z3) {
            this.mSelectable = z3;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean z3) {
        if (this.mShouldDisableView != z3) {
            this.mShouldDisableView = z3;
            notifyChanged();
        }
    }

    public void setSingleLineTitle(boolean z3) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = z3;
    }

    public void setSummary(CharSequence charSequence) {
        if (getSummaryProvider() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.mSummary, charSequence)) {
            return;
        }
        this.mSummary = charSequence;
        notifyChanged();
    }

    public final void setSummaryProvider(g gVar) {
        this.mSummaryProvider = gVar;
        notifyChanged();
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence != null || this.mTitle == null) && (charSequence == null || charSequence.equals(this.mTitle))) {
            return;
        }
        this.mTitle = charSequence;
        notifyChanged();
    }

    public void setViewId(int i3) {
        this.mViewId = i3;
    }

    public final void setVisible(boolean z3) {
        if (this.mVisible != z3) {
            this.mVisible = z3;
            c cVar = this.mListener;
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    public void setWidgetLayoutResource(int i3) {
        this.mWidgetLayoutResId = i3;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    protected boolean shouldPersist() {
        return this.mPreferenceManager != null && isPersistent() && hasKey();
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    final boolean wasDetached() {
        return this.mWasDetached;
    }

    @Override // java.lang.Comparable
    public int compareTo(Preference preference) {
        int i3 = this.mOrder;
        int i4 = preference.mOrder;
        if (i3 != i4) {
            return i3 - i4;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    @Deprecated
    protected void onSetInitialValue(boolean z3, Object obj) {
        onSetInitialValue(obj);
    }

    public void performClick() {
        j.c h3;
        if (isEnabled() && isSelectable()) {
            onClick();
            e eVar = this.mOnClickListener;
            if (eVar == null || !eVar.a(this)) {
                j preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (h3 = preferenceManager.h()) == null || !h3.onPreferenceTreeClick(this)) && this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    public void setTitle(int i3) {
        setTitle(this.mContext.getString(i3));
    }

    protected void onAttachedToHierarchy(j jVar, long j3) {
        this.mId = j3;
        this.mHasId = true;
        try {
            onAttachedToHierarchy(jVar);
        } finally {
            this.mHasId = false;
        }
    }

    public void setIcon(int i3) {
        setIcon(AbstractC0348a.b(this.mContext, i3));
        this.mIconResId = i3;
    }

    public void setSummary(int i3) {
        setSummary(this.mContext.getString(i3));
    }

    public Preference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6037i, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
