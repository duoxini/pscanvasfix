package com.coui.appcompat.poplist;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.coui.appcompat.reddot.COUIHintRedDot;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import r0.C0559a;
import u0.AbstractC0597a;

/* loaded from: classes.dex */
public class n extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    private final Context f8288f;

    /* renamed from: g, reason: collision with root package name */
    private int f8289g;

    /* renamed from: h, reason: collision with root package name */
    private int f8290h;

    /* renamed from: i, reason: collision with root package name */
    private int f8291i;

    /* renamed from: j, reason: collision with root package name */
    private int f8292j;

    /* renamed from: k, reason: collision with root package name */
    private int f8293k;

    /* renamed from: l, reason: collision with root package name */
    private int f8294l;

    /* renamed from: m, reason: collision with root package name */
    private int f8295m;

    /* renamed from: n, reason: collision with root package name */
    private int f8296n;

    /* renamed from: o, reason: collision with root package name */
    private int f8297o;

    /* renamed from: p, reason: collision with root package name */
    private int f8298p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8302t;

    /* renamed from: u, reason: collision with root package name */
    private List f8303u;

    /* renamed from: w, reason: collision with root package name */
    private ColorStateList f8305w;

    /* renamed from: x, reason: collision with root package name */
    private ColorStateList f8306x;

    /* renamed from: y, reason: collision with root package name */
    private r f8307y;

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f8286z = {R.attr.state_enabled, R.attr.state_selected};

    /* renamed from: A, reason: collision with root package name */
    private static final int[] f8283A = {-16842910};

    /* renamed from: B, reason: collision with root package name */
    private static final Drawable f8284B = new ColorDrawable(0);

    /* renamed from: C, reason: collision with root package name */
    private static final Typeface f8285C = Typeface.create("sans-serif-medium", 0);

    /* renamed from: e, reason: collision with root package name */
    private final View.AccessibilityDelegate f8287e = new a();

    /* renamed from: q, reason: collision with root package name */
    private int f8299q = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8300r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8301s = false;

    /* renamed from: v, reason: collision with root package name */
    private Set f8304v = null;

    class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("");
        }
    }

    class b extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8309a;

        b(int i3) {
            this.f8309a = i3;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            super.performAccessibilityAction(view, i3, bundle);
            if (i3 != 16) {
                return true;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof COUITouchListView)) {
                return true;
            }
            COUITouchListView cOUITouchListView = (COUITouchListView) parent;
            int firstVisiblePosition = this.f8309a - cOUITouchListView.getFirstVisiblePosition();
            cOUITouchListView.performItemClick(cOUITouchListView.getChildAt(firstVisiblePosition), firstVisiblePosition, cOUITouchListView.getItemIdAtPosition(firstVisiblePosition));
            return true;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        TextView f8310a;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(View view) {
            this.f8310a = (TextView) view.findViewById(V1.e.f2559b);
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f8311a;

        /* renamed from: b, reason: collision with root package name */
        TextView f8312b;

        /* renamed from: c, reason: collision with root package name */
        TextView f8313c;

        /* renamed from: d, reason: collision with root package name */
        Space f8314d;

        /* renamed from: e, reason: collision with root package name */
        LinearLayout f8315e;

        /* renamed from: f, reason: collision with root package name */
        Space f8316f;

        /* renamed from: g, reason: collision with root package name */
        CheckBox f8317g;

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(View view) {
            this.f8311a = (ImageView) view.findViewById(V1.e.f2563f);
            this.f8312b = (TextView) view.findViewById(V1.e.f2565h);
            this.f8313c = (TextView) view.findViewById(V1.e.f2560c);
            this.f8314d = (Space) view.findViewById(V1.e.f2566i);
            this.f8315e = (LinearLayout) view.findViewById(V1.e.f2562e);
            this.f8316f = (Space) view.findViewById(V1.e.f2561d);
            this.f8317g = (CheckBox) view.findViewById(V1.e.f2564g);
        }
    }

    public n(Context context, List list) {
        this.f8288f = context;
        J(list);
        Resources resources = context.getResources();
        this.f8289g = resources.getDimensionPixelSize(V1.c.f2536c);
        this.f8290h = resources.getDimensionPixelSize(V1.c.f2537d);
        this.f8291i = resources.getDimensionPixelSize(V1.c.f2538e);
        this.f8292j = resources.getDimensionPixelSize(V1.c.f2545l);
        this.f8293k = resources.getDimensionPixelSize(V1.c.f2542i);
        this.f8294l = resources.getDimensionPixelSize(V1.c.f2544k);
        this.f8295m = resources.getDimensionPixelSize(V1.c.f2535b);
        this.f8296n = resources.getDimensionPixelSize(V1.c.f2534a);
        this.f8305w = y0.j.h(context, V1.b.f2532c);
        this.f8306x = y0.j.h(context, V1.b.f2531b);
        this.f8298p = AbstractC0335a.b(context, M1.c.f1364i, M1.e.f1389e);
        this.f8297o = AbstractC0335a.b(context, M1.c.f1370o, M1.e.f1391g);
    }

    private void B(TextView textView, s sVar) {
        if (TextUtils.isEmpty(sVar.e())) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setTextAppearance(M1.l.f1508h);
        textView.setText(sVar.e());
        if (this.f8301s) {
            textView.setTextSize(1, 12.0f);
        } else if (this.f8300r) {
            AbstractC0597a.b(textView, 4);
        }
        textView.setTextColor(this.f8297o);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (TextUtils.isEmpty(sVar.f())) {
            return;
        }
        textView.setContentDescription(sVar.f());
    }

    private void C(d dVar, s sVar) {
        boolean z3 = sVar.j() != -1;
        boolean z4 = sVar.q() != null || sVar.r() != 0 || sVar.x() || (sVar.q() == null && sVar.r() == 0 && sVar.y());
        if (!z3 && !z4) {
            dVar.f8314d.setVisibility(8);
            return;
        }
        dVar.f8314d.setVisibility(4);
        if (z3 && z4) {
            dVar.f8316f.setVisibility(4);
        } else {
            dVar.f8316f.setVisibility(8);
        }
    }

    private void E(ViewGroup viewGroup, s sVar) {
        if (sVar.z()) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        viewGroup.removeAllViews();
        if (sVar.j() == 0) {
            viewGroup.addView(o(sVar), new ViewGroup.LayoutParams(-2, -2));
            return;
        }
        if (sVar.j() != 1 || sVar.c() == null) {
            return;
        }
        ViewParent parent = sVar.c().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(sVar.c());
        }
        viewGroup.addView(sVar.c());
    }

    private void F(ImageView imageView, s sVar) {
        if ((this.f8299q & 1) != 0) {
            imageView.setVisibility(0);
            Drawable k3 = sVar.k() != null ? sVar.k() : sVar.l() != 0 ? androidx.core.content.res.f.f(this.f8288f.getResources(), sVar.l(), this.f8288f.getTheme()) : null;
            if ((sVar.g() & 1) != 0) {
                G(k3, this.f8305w, sVar);
            }
            imageView.setSelected(sVar.y());
            imageView.setImageDrawable(k3);
        } else {
            imageView.setVisibility(8);
        }
        imageView.setEnabled(sVar.z());
    }

    private void G(Drawable drawable, ColorStateList colorStateList, s sVar) {
        H(drawable, colorStateList, sVar, false);
    }

    private void H(Drawable drawable, ColorStateList colorStateList, s sVar, boolean z3) {
        if (drawable == null) {
            return;
        }
        drawable.setTint(q(colorStateList, sVar, z3));
    }

    private void L(CheckBox checkBox, s sVar) {
        if (sVar.q() != null || sVar.r() != 0 || sVar.x() || sVar.y()) {
            checkBox.setVisibility(0);
            Drawable drawable = f8284B;
            if (sVar.x()) {
                drawable = androidx.core.content.res.f.f(this.f8288f.getResources(), T1.b.f2195a, this.f8288f.getTheme());
                H(drawable, this.f8306x, sVar, true);
            } else {
                if (sVar.q() != null) {
                    drawable = sVar.q();
                } else if (sVar.r() != 0) {
                    drawable = androidx.core.content.res.f.f(this.f8288f.getResources(), sVar.r(), this.f8288f.getTheme());
                } else if (sVar.y()) {
                    drawable = androidx.core.content.res.f.f(this.f8288f.getResources(), V1.d.f2556b, this.f8288f.getTheme());
                }
                if ((sVar.g() & 4) != 0) {
                    H(drawable, this.f8306x, sVar, true);
                }
            }
            checkBox.setButtonDrawable(drawable);
            checkBox.setChecked(sVar.y());
        } else {
            checkBox.setVisibility(8);
        }
        checkBox.setEnabled(sVar.z());
    }

    private void M(TextView textView, ColorStateList colorStateList, s sVar) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(p(colorStateList, sVar));
    }

    private void N(TextView textView, s sVar, int i3) {
        boolean isEmpty = TextUtils.isEmpty(sVar.e());
        textView.setTextAppearance(M1.l.f1507g);
        if (sVar.i() == 2 && i3 == 0) {
            textView.setTypeface(f8285C);
        } else {
            textView.setTypeface(null);
        }
        textView.setText(sVar.t());
        if (!TextUtils.isEmpty(sVar.v())) {
            textView.setContentDescription(sVar.v());
        }
        if (this.f8301s) {
            textView.setTextSize(1, 16.0f);
        } else if (this.f8300r) {
            AbstractC0597a.b(textView, 4);
        } else {
            AbstractC0597a.b(textView, 5);
        }
        if (isEmpty) {
            textView.setMaxLines(3);
        } else {
            textView.setMaxLines(2);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if ((sVar.g() & 2) != 0) {
            M(textView, this.f8305w, sVar);
        } else if (sVar.u() != null) {
            textView.setTextColor(sVar.u());
        }
        textView.setSelected(sVar.y());
        textView.setEnabled(sVar.z());
    }

    private void b(View view, int i3) {
        if (this.f8303u.size() == 1) {
            view.setMinimumHeight(this.f8294l + (this.f8291i * 2));
            view.setPadding(view.getPaddingStart(), this.f8292j + this.f8291i, view.getPaddingEnd(), this.f8292j + this.f8291i);
        } else if (i3 == 0) {
            view.setMinimumHeight(this.f8294l + this.f8291i);
            view.setPadding(view.getPaddingStart(), this.f8292j + this.f8291i, view.getPaddingEnd(), this.f8292j);
        } else if (i3 == this.f8303u.size() - 1) {
            view.setMinimumHeight(this.f8294l + this.f8291i);
            view.setPadding(view.getPaddingStart(), this.f8292j, view.getPaddingEnd(), this.f8292j + this.f8291i);
        } else {
            view.setMinimumHeight(this.f8294l);
            view.setPadding(view.getPaddingStart(), this.f8292j, view.getPaddingEnd(), this.f8292j);
        }
    }

    private void c(View view, s sVar) {
        r rVar;
        if (sVar != null && sVar.x() && sVar.i() != 2 && !(view.getBackground() instanceof r)) {
            view.setBackground(new r(this.f8288f, 1, null));
        } else if (sVar != null && sVar.x() && sVar.i() == 2 && (rVar = this.f8307y) != null) {
            view.setBackground(rVar.F());
        } else if (!(view.getBackground() instanceof C0559a)) {
            C0559a c0559a = new C0559a(this.f8288f, 1);
            c0559a.y(false);
            c0559a.B(false);
            c0559a.e();
            view.setBackground(c0559a);
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.poplist.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean x3;
                x3 = n.x(view2, motionEvent);
                return x3;
            }
        });
    }

    public static int d(int i3) {
        return i3 * 2;
    }

    private static View.AccessibilityDelegate e(int i3) {
        return new b(i3);
    }

    private View f(int i3, View view, ViewGroup viewGroup) {
        s sVar = (s) this.f8303u.get(z(i3));
        View d3 = sVar.d();
        if (d3 == null) {
            Log.e("DefaultAdapter", "Popup list item custom view is null! Return an empty view.");
            d3 = new View(viewGroup.getContext());
        }
        if (view == null) {
            d3.setClickable(true);
            view = d3;
        }
        view.setAccessibilityDelegate(e(i3));
        c(view, sVar);
        view.setEnabled(sVar.z());
        return d3;
    }

    private InsetDrawable g(boolean z3) {
        boolean w3 = w();
        return new InsetDrawable((Drawable) new ColorDrawable(AbstractC0335a.a(this.f8288f, M1.c.f1363h)), w3 ? this.f8296n : (z3 || !r()) ? this.f8296n : this.f8295m, 0, w3 ? (z3 || !r()) ? this.f8296n : this.f8295m : this.f8296n, 0);
    }

    private View h(View view, boolean z3) {
        if (view != null) {
            return view;
        }
        View view2 = new View(this.f8288f);
        androidx.core.view.y.u0(view2, 2);
        AbstractC0342a.b(view2, false);
        view2.setBackground(g(z3));
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f8289g));
        view2.setFocusable(false);
        return view2;
    }

    private View i(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        int z3 = z(i3);
        if (view == null || !(view.getTag() instanceof d)) {
            d dVar2 = new d();
            View inflate = LayoutInflater.from(this.f8288f).inflate(V1.g.f2569b, viewGroup, false);
            dVar2.b(inflate);
            inflate.setClickable(true);
            CheckBox checkBox = dVar2.f8317g;
            if (checkBox != null) {
                checkBox.setAccessibilityDelegate(this.f8287e);
                dVar2.f8317g.setBackground(null);
            }
            inflate.setTag(dVar2);
            dVar = dVar2;
            view = inflate;
        } else {
            dVar = (d) view.getTag();
        }
        view.setAccessibilityDelegate(e(i3));
        b(view, z3);
        s sVar = (s) this.f8303u.get(z3);
        F(dVar.f8311a, sVar);
        N(dVar.f8312b, sVar, i3);
        B(dVar.f8313c, sVar);
        C(dVar, sVar);
        E(dVar.f8315e, sVar);
        L(dVar.f8317g, sVar);
        view.setEnabled(sVar.z());
        c(view, sVar);
        return view;
    }

    private View k(int i3, View view, int i4) {
        View h3 = i4 != 2 ? i4 != 5 ? h(view, false) : h(view, true) : (this.f8302t && i3 == 1) ? h(view, false) : l(view);
        h3.setFocusable(false);
        return h3;
    }

    private View l(View view) {
        if (view != null) {
            return view;
        }
        View view2 = new View(this.f8288f);
        androidx.core.view.y.u0(view2, 2);
        AbstractC0342a.b(view2, false);
        view2.setBackgroundColor(androidx.core.content.res.f.d(this.f8288f.getResources(), V1.b.f2530a, this.f8288f.getTheme()));
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f8290h));
        return view2;
    }

    private View m(int i3, View view, ViewGroup viewGroup) {
        c cVar;
        int z3 = z(i3);
        if (view == null || !(view.getTag() instanceof c)) {
            c cVar2 = new c();
            View inflate = LayoutInflater.from(this.f8288f).inflate(V1.g.f2568a, viewGroup, false);
            cVar2.b(inflate);
            inflate.setClickable(false);
            inflate.setTag(cVar2);
            cVar = cVar2;
            view = inflate;
        } else {
            cVar = (c) view.getTag();
        }
        view.setAccessibilityDelegate(e(i3));
        b(view, z3);
        view.setMinimumHeight(this.f8293k);
        s sVar = (s) this.f8303u.get(z3);
        cVar.f8310a.setText(sVar.t());
        if (!TextUtils.isEmpty(sVar.v())) {
            cVar.f8310a.setContentDescription(sVar.v());
        }
        if (this.f8301s) {
            cVar.f8310a.setTextSize(1, 12.0f);
        } else if (this.f8300r) {
            AbstractC0597a.b(cVar.f8310a, 4);
        } else {
            AbstractC0597a.b(cVar.f8310a, 5);
        }
        return view;
    }

    private View n(int i3, View view, ViewGroup viewGroup, int i4) {
        return i4 != 3 ? i4 != 4 ? i(i3, view, viewGroup) : m(i3, view, viewGroup) : f(i3, view, viewGroup);
    }

    private View o(s sVar) {
        COUIHintRedDot cOUIHintRedDot = new COUIHintRedDot(new ContextThemeWrapper(this.f8288f, Z1.f.f3119b));
        if (TextUtils.isEmpty(sVar.p())) {
            cOUIHintRedDot.setPointNumber(sVar.o());
            int o3 = sVar.o();
            if (o3 == -1) {
                cOUIHintRedDot.setPointMode(0);
            } else if (o3 != 0) {
                cOUIHintRedDot.setPointMode(2);
            } else {
                cOUIHintRedDot.setPointMode(1);
            }
        } else {
            cOUIHintRedDot.setPointMode(2);
            cOUIHintRedDot.setPointText(sVar.p());
        }
        return cOUIHintRedDot;
    }

    private int p(ColorStateList colorStateList, s sVar) {
        return q(colorStateList, sVar, false);
    }

    private int q(ColorStateList colorStateList, s sVar, boolean z3) {
        if (!sVar.z()) {
            return colorStateList.getColorForState(f8283A, M1.e.f1389e);
        }
        if (sVar.n() != 0) {
            return sVar.n() == 1 ? this.f8298p : colorStateList.getDefaultColor();
        }
        if ((!z3 || sVar.i() == 0) && !sVar.y()) {
            return colorStateList.getDefaultColor();
        }
        return colorStateList.getColorForState(f8286z, M1.e.f1389e);
    }

    public static boolean t(int i3) {
        return i3 % 2 == 0;
    }

    private boolean w() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean x(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        Drawable background = view.getBackground();
        if (motionEvent.getActionMasked() == 0 && (background instanceof C0559a)) {
            ((C0559a) background).f();
        }
        if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && (background instanceof C0559a)) {
            ((C0559a) background).e();
        }
        return false;
    }

    private boolean y(List list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static int z(int i3) {
        return i3 / 2;
    }

    public void A(boolean z3) {
        this.f8300r = z3;
    }

    void D(Set set) {
        this.f8304v = set;
    }

    public void I(boolean z3) {
        this.f8301s = z3;
    }

    public void J(List list) {
        this.f8303u = list;
        if (list == null) {
            return;
        }
        s sVar = (s) list.get(0);
        this.f8302t = (sVar == null || sVar.i() == 0) ? false : true;
        this.f8299q = 0;
        for (s sVar2 : this.f8303u) {
            if (sVar2 != null) {
                if (sVar2.l() != 0 || sVar2.k() != null) {
                    this.f8299q |= 1;
                }
                if (!TextUtils.isEmpty(sVar2.e())) {
                    this.f8299q |= 2;
                }
                if (sVar2.j() != -1) {
                    this.f8299q |= 4;
                }
                if (sVar2.r() != 0 || sVar2.q() != null) {
                    this.f8299q |= 8;
                }
                if (sVar2.x()) {
                    this.f8299q |= 16;
                }
            }
        }
    }

    public void K(r rVar) {
        this.f8307y = rVar;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y(this.f8303u)) {
            return d(this.f8303u.size()) - 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        if (z(i3) >= this.f8303u.size()) {
            return null;
        }
        return this.f8303u.get(z(i3));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (!t(i3)) {
            if (v(i3)) {
                return 5;
            }
            return u(i3) ? 2 : 1;
        }
        int z3 = z(i3);
        if (!y(this.f8303u) || z3 >= this.f8303u.size()) {
            return 0;
        }
        int n3 = ((s) this.f8303u.get(z3)).n();
        if (n3 != 2) {
            return n3 != 3 ? 0 : 4;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 0) {
            if (itemViewType != 1 && itemViewType != 2) {
                if (itemViewType != 3 && itemViewType != 4) {
                    if (itemViewType != 5) {
                        Log.e("DefaultAdapter", "View type error!");
                        return null;
                    }
                }
            }
            return k(i3, view, itemViewType);
        }
        return n(i3, view, viewGroup, itemViewType);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        return t(i3);
    }

    public int j(int i3) {
        if (i3 == 1) {
            return this.f8289g;
        }
        if (i3 == 2) {
            return this.f8290h;
        }
        return 0;
    }

    public boolean r() {
        return (this.f8299q & 1) != 0;
    }

    public boolean s() {
        return (this.f8299q & 16) != 0;
    }

    boolean u(int i3) {
        Set set = this.f8304v;
        return (set == null || !set.contains(Integer.valueOf((i3 + 1) / 2)) || v(i3)) ? false : true;
    }

    boolean v(int i3) {
        if (i3 <= 0) {
            return false;
        }
        return y(this.f8303u) && ((s) this.f8303u.get(z(i3 - 1))).n() == 3;
    }
}
