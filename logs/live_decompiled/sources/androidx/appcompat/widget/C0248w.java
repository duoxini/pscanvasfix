package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.ShowableListMenu;
import e.AbstractC0339a;
import f.AbstractC0348a;

/* renamed from: androidx.appcompat.widget.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0248w extends Spinner {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f4299m = {R.attr.spinnerMode};

    /* renamed from: e, reason: collision with root package name */
    private final C0231e f4300e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f4301f;

    /* renamed from: g, reason: collision with root package name */
    private H f4302g;

    /* renamed from: h, reason: collision with root package name */
    private SpinnerAdapter f4303h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4304i;

    /* renamed from: j, reason: collision with root package name */
    private j f4305j;

    /* renamed from: k, reason: collision with root package name */
    int f4306k;

    /* renamed from: l, reason: collision with root package name */
    final Rect f4307l;

    /* renamed from: androidx.appcompat.widget.w$a */
    class a extends H {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f4308e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, h hVar) {
            super(view);
            this.f4308e = hVar;
        }

        @Override // androidx.appcompat.widget.H
        public ShowableListMenu getPopup() {
            return this.f4308e;
        }

        @Override // androidx.appcompat.widget.H
        public boolean onForwardingStarted() {
            if (C0248w.this.getInternalPopup().isShowing()) {
                return true;
            }
            C0248w.this.b();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.w$b */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!C0248w.this.getInternalPopup().isShowing()) {
                C0248w.this.b();
            }
            ViewTreeObserver viewTreeObserver = C0248w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.w$c */
    private static final class c {
        static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$d */
    private static final class d {
        static int a(View view) {
            return view.getTextAlignment();
        }

        static int b(View view) {
            return view.getTextDirection();
        }

        static void c(View view, int i3) {
            view.setTextAlignment(i3);
        }

        static void d(View view, int i3) {
            view.setTextDirection(i3);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$e */
    private static final class e {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (androidx.core.util.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    /* renamed from: androidx.appcompat.widget.w$f */
    class f implements j, DialogInterface.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        androidx.appcompat.app.c f4311e;

        /* renamed from: f, reason: collision with root package name */
        private ListAdapter f4312f;

        /* renamed from: g, reason: collision with root package name */
        private CharSequence f4313g;

        f() {
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void a(int i3) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public int b() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void c(int i3, int i4) {
            if (this.f4312f == null) {
                return;
            }
            c.a aVar = new c.a(C0248w.this.getPopupContext());
            CharSequence charSequence = this.f4313g;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.c create = aVar.setSingleChoiceItems(this.f4312f, C0248w.this.getSelectedItemPosition(), this).create();
            this.f4311e = create;
            ListView f3 = create.f();
            d.d(f3, i3);
            d.c(f3, i4);
            this.f4311e.show();
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f4311e;
            if (cVar != null) {
                cVar.dismiss();
                this.f4311e = null;
            }
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public Drawable e() {
            return null;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public CharSequence f() {
            return this.f4313g;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void g(CharSequence charSequence) {
            this.f4313g = charSequence;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void h(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void i(int i3) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public boolean isShowing() {
            androidx.appcompat.app.c cVar = this.f4311e;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void j(ListAdapter listAdapter) {
            this.f4312f = listAdapter;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void k(int i3) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            C0248w.this.setSelection(i3);
            if (C0248w.this.getOnItemClickListener() != null) {
                C0248w.this.performItemClick(null, i3, this.f4312f.getItemId(i3));
            }
            dismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.w$g */
    private static class g implements ListAdapter, SpinnerAdapter {

        /* renamed from: e, reason: collision with root package name */
        private SpinnerAdapter f4315e;

        /* renamed from: f, reason: collision with root package name */
        private ListAdapter f4316f;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f4315e = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f4316f = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || !(spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                return;
            }
            e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f4316f;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i3, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i3);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i3) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            return getDropDownView(i3, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            ListAdapter listAdapter = this.f4316f;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i3);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4315e;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.w$h */
    class h extends I implements j {

        /* renamed from: K, reason: collision with root package name */
        private CharSequence f4317K;

        /* renamed from: L, reason: collision with root package name */
        ListAdapter f4318L;

        /* renamed from: M, reason: collision with root package name */
        private final Rect f4319M;

        /* renamed from: N, reason: collision with root package name */
        private int f4320N;

        /* renamed from: androidx.appcompat.widget.w$h$a */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ C0248w f4322e;

            a(C0248w c0248w) {
                this.f4322e = c0248w;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                C0248w.this.setSelection(i3);
                if (C0248w.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    C0248w.this.performItemClick(view, i3, hVar.f4318L.getItemId(i3));
                }
                h.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.w$h$b */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.P(C0248w.this)) {
                    h.this.dismiss();
                } else {
                    h.this.N();
                    h.super.show();
                }
            }
        }

        /* renamed from: androidx.appcompat.widget.w$h$c */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f4325e;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f4325e = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = C0248w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f4325e);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f4319M = new Rect();
            y(C0248w.this);
            E(true);
            J(0);
            G(new a(C0248w.this));
        }

        void N() {
            int i3;
            Drawable e3 = e();
            if (e3 != null) {
                e3.getPadding(C0248w.this.f4307l);
                i3 = b0.b(C0248w.this) ? C0248w.this.f4307l.right : -C0248w.this.f4307l.left;
            } else {
                Rect rect = C0248w.this.f4307l;
                rect.right = 0;
                rect.left = 0;
                i3 = 0;
            }
            int paddingLeft = C0248w.this.getPaddingLeft();
            int paddingRight = C0248w.this.getPaddingRight();
            int width = C0248w.this.getWidth();
            C0248w c0248w = C0248w.this;
            int i4 = c0248w.f4306k;
            if (i4 == -2) {
                int a3 = c0248w.a((SpinnerAdapter) this.f4318L, e());
                int i5 = C0248w.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = C0248w.this.f4307l;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (a3 > i6) {
                    a3 = i6;
                }
                A(Math.max(a3, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                A((width - paddingLeft) - paddingRight);
            } else {
                A(i4);
            }
            a(b0.b(C0248w.this) ? i3 + (((width - paddingRight) - u()) - O()) : i3 + paddingLeft + O());
        }

        public int O() {
            return this.f4320N;
        }

        boolean P(View view) {
            return androidx.core.view.y.N(view) && view.getGlobalVisibleRect(this.f4319M);
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void c(int i3, int i4) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            N();
            D(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            d.d(listView, i3);
            d.c(listView, i4);
            K(C0248w.this.getSelectedItemPosition());
            if (isShowing || (viewTreeObserver = C0248w.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            F(new c(bVar));
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public CharSequence f() {
            return this.f4317K;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void g(CharSequence charSequence) {
            this.f4317K = charSequence;
        }

        @Override // androidx.appcompat.widget.I, androidx.appcompat.widget.C0248w.j
        public void j(ListAdapter listAdapter) {
            super.j(listAdapter);
            this.f4318L = listAdapter;
        }

        @Override // androidx.appcompat.widget.C0248w.j
        public void k(int i3) {
            this.f4320N = i3;
        }
    }

    /* renamed from: androidx.appcompat.widget.w$i */
    static class i extends View.BaseSavedState {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        boolean f4327e;

        /* renamed from: androidx.appcompat.widget.w$i$a */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i3) {
                return new i[i3];
            }
        }

        i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.f4327e ? (byte) 1 : (byte) 0);
        }

        i(Parcel parcel) {
            super(parcel);
            this.f4327e = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.w$j */
    interface j {
        void a(int i3);

        int b();

        void c(int i3, int i4);

        int d();

        void dismiss();

        Drawable e();

        CharSequence f();

        void g(CharSequence charSequence);

        void h(Drawable drawable);

        void i(int i3);

        boolean isShowing();

        void j(ListAdapter listAdapter);

        void k(int i3);
    }

    public C0248w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11081J);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i3 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i4 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i4;
        }
        drawable.getPadding(this.f4307l);
        Rect rect = this.f4307l;
        return i4 + rect.left + rect.right;
    }

    void b() {
        this.f4305j.c(d.b(this), d.a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            c0231e.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        j jVar = this.f4305j;
        return jVar != null ? jVar.b() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        j jVar = this.f4305j;
        return jVar != null ? jVar.d() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f4305j != null ? this.f4306k : super.getDropDownWidth();
    }

    final j getInternalPopup() {
        return this.f4305j;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        j jVar = this.f4305j;
        return jVar != null ? jVar.e() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f4301f;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        j jVar = this.f4305j;
        return jVar != null ? jVar.f() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.f4305j;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f4305j.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f4305j == null || View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        if (!iVar.f4327e || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        j jVar = this.f4305j;
        iVar.f4327e = jVar != null && jVar.isShowing();
        return iVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        H h3 = this.f4302g;
        if (h3 == null || !h3.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        j jVar = this.f4305j;
        if (jVar == null) {
            return super.performClick();
        }
        if (jVar.isShowing()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i3) {
        j jVar = this.f4305j;
        if (jVar == null) {
            super.setDropDownHorizontalOffset(i3);
        } else {
            jVar.k(i3);
            this.f4305j.a(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i3) {
        j jVar = this.f4305j;
        if (jVar != null) {
            jVar.i(i3);
        } else {
            super.setDropDownVerticalOffset(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i3) {
        if (this.f4305j != null) {
            this.f4306k = i3;
        } else {
            super.setDropDownWidth(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        j jVar = this.f4305j;
        if (jVar != null) {
            jVar.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i3) {
        setPopupBackgroundDrawable(AbstractC0348a.b(getPopupContext(), i3));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        j jVar = this.f4305j;
        if (jVar != null) {
            jVar.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f4300e;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public C0248w(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f4304i) {
            this.f4303h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f4305j != null) {
            Context context = this.f4301f;
            if (context == null) {
                context = getContext();
            }
            this.f4305j.j(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public C0248w(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(context, attributeSet, i3, i4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        if (r11 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.w] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0248w(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0248w.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
