package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.J;
import androidx.core.view.t;
import androidx.core.view.y;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import f.AbstractC0348a;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class i<S> extends androidx.fragment.app.d {

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet f9679e = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    private final LinkedHashSet f9680f = new LinkedHashSet();

    /* renamed from: g, reason: collision with root package name */
    private final LinkedHashSet f9681g = new LinkedHashSet();

    /* renamed from: h, reason: collision with root package name */
    private final LinkedHashSet f9682h = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name */
    private int f9683i;

    /* renamed from: j, reason: collision with root package name */
    private o f9684j;

    /* renamed from: k, reason: collision with root package name */
    private com.google.android.material.datepicker.a f9685k;

    /* renamed from: l, reason: collision with root package name */
    private h f9686l;

    /* renamed from: m, reason: collision with root package name */
    private int f9687m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f9688n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9689o;

    /* renamed from: p, reason: collision with root package name */
    private int f9690p;

    /* renamed from: q, reason: collision with root package name */
    private int f9691q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f9692r;

    /* renamed from: s, reason: collision with root package name */
    private int f9693s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f9694t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f9695u;

    /* renamed from: v, reason: collision with root package name */
    private CheckableImageButton f9696v;

    /* renamed from: w, reason: collision with root package name */
    private U0.g f9697w;

    /* renamed from: x, reason: collision with root package name */
    private Button f9698x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f9699y;

    /* renamed from: z, reason: collision with root package name */
    static final Object f9678z = "CONFIRM_BUTTON_TAG";

    /* renamed from: A, reason: collision with root package name */
    static final Object f9676A = "CANCEL_BUTTON_TAG";

    /* renamed from: B, reason: collision with root package name */
    static final Object f9677B = "TOGGLE_BUTTON_TAG";

    class a implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9700a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f9701b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9702c;

        a(int i3, View view, int i4) {
            this.f9700a = i3;
            this.f9701b = view;
            this.f9702c = i4;
        }

        @Override // androidx.core.view.t
        public J onApplyWindowInsets(View view, J j3) {
            int i3 = j3.f(J.l.h()).f4901b;
            if (this.f9700a >= 0) {
                this.f9701b.getLayoutParams().height = this.f9700a + i3;
                View view2 = this.f9701b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f9701b;
            view3.setPadding(view3.getPaddingLeft(), this.f9702c + i3, this.f9701b.getPaddingRight(), this.f9701b.getPaddingBottom());
            return j3;
        }
    }

    class b extends n {
        b() {
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Button unused = i.this.f9698x;
            i.i(i.this);
            throw null;
        }
    }

    static /* synthetic */ d i(i iVar) {
        iVar.m();
        return null;
    }

    private static Drawable k(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AbstractC0348a.b(context, H0.d.f545b));
        stateListDrawable.addState(new int[0], AbstractC0348a.b(context, H0.d.f546c));
        return stateListDrawable;
    }

    private void l(Window window) {
        if (this.f9699y) {
            return;
        }
        View findViewById = requireView().findViewById(H0.e.f575h);
        EdgeToEdgeUtils.applyEdgeToEdge(window, true, ViewUtils.getBackgroundColor(findViewById), null);
        y.x0(findViewById, new a(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop()));
        this.f9699y = true;
    }

    private d m() {
        androidx.appcompat.app.p.a(getArguments().getParcelable("DATE_SELECTOR_KEY"));
        return null;
    }

    private static int o(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(H0.c.f542y);
        int i3 = k.f().f9712h;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(H0.c.f501A) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(H0.c.f504D));
    }

    private int p(Context context) {
        int i3 = this.f9683i;
        if (i3 != 0) {
            return i3;
        }
        m();
        throw null;
    }

    private void q(Context context) {
        this.f9696v.setTag(f9677B);
        this.f9696v.setImageDrawable(k(context));
        this.f9696v.setChecked(this.f9690p != 0);
        y.j0(this.f9696v, null);
        w(this.f9696v);
        this.f9696v.setOnClickListener(new c());
    }

    static boolean r(Context context) {
        return t(context, R.attr.windowFullscreen);
    }

    static boolean s(Context context) {
        return t(context, H0.a.f494z);
    }

    static boolean t(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R0.b.c(context, H0.a.f491w, h.class.getCanonicalName()), new int[]{i3});
        boolean z3 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z3;
    }

    private void u() {
        o oVar;
        int p3 = p(requireContext());
        m();
        this.f9686l = h.w(null, p3, this.f9685k);
        if (this.f9696v.isChecked()) {
            m();
            oVar = j.i(null, p3, this.f9685k);
        } else {
            oVar = this.f9686l;
        }
        this.f9684j = oVar;
        v();
        androidx.fragment.app.t m3 = getChildFragmentManager().m();
        m3.p(H0.e.f591x, this.f9684j);
        m3.j();
        this.f9684j.g(new b());
    }

    private void v() {
        String n3 = n();
        this.f9695u.setContentDescription(String.format(getString(H0.h.f628i), n3));
        this.f9695u.setText(n3);
    }

    private void w(CheckableImageButton checkableImageButton) {
        this.f9696v.setContentDescription(this.f9696v.isChecked() ? checkableImageButton.getContext().getString(H0.h.f631l) : checkableImageButton.getContext().getString(H0.h.f633n));
    }

    public String n() {
        m();
        getContext();
        throw null;
    }

    @Override // androidx.fragment.app.d, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f9681g.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9683i = bundle.getInt("OVERRIDE_THEME_RES_ID");
        androidx.appcompat.app.p.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f9685k = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f9687m = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f9688n = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f9690p = bundle.getInt("INPUT_MODE_KEY");
        this.f9691q = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f9692r = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f9693s = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f9694t = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override // androidx.fragment.app.d
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), p(requireContext()));
        Context context = dialog.getContext();
        this.f9689o = r(context);
        int c3 = R0.b.c(context, H0.a.f482n, i.class.getCanonicalName());
        U0.g gVar = new U0.g(context, null, H0.a.f491w, H0.i.f654s);
        this.f9697w = gVar;
        gVar.K(context);
        this.f9697w.U(ColorStateList.valueOf(c3));
        this.f9697w.T(y.t(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f9689o ? H0.g.f619x : H0.g.f618w, viewGroup);
        Context context = inflate.getContext();
        if (this.f9689o) {
            inflate.findViewById(H0.e.f591x).setLayoutParams(new LinearLayout.LayoutParams(o(context), -2));
        } else {
            inflate.findViewById(H0.e.f592y).setLayoutParams(new LinearLayout.LayoutParams(o(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(H0.e.f552B);
        this.f9695u = textView;
        y.l0(textView, 1);
        this.f9696v = (CheckableImageButton) inflate.findViewById(H0.e.f553C);
        TextView textView2 = (TextView) inflate.findViewById(H0.e.f554D);
        CharSequence charSequence = this.f9688n;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f9687m);
        }
        q(context);
        this.f9698x = (Button) inflate.findViewById(H0.e.f570c);
        m();
        throw null;
    }

    @Override // androidx.fragment.app.d, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f9682h.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f9683i);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        a.b bVar = new a.b(this.f9685k);
        if (this.f9686l.r() != null) {
            bVar.b(this.f9686l.r().f9714j);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f9687m);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f9688n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f9691q);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f9692r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f9693s);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f9694t);
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f9689o) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f9697w);
            l(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(H0.c.f503C);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f9697w, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new M0.a(requireDialog(), rect));
        }
        u();
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStop() {
        this.f9684j.h();
        super.onStop();
    }
}
