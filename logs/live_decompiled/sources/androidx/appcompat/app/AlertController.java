package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.y;
import androidx.core.widget.NestedScrollView;
import e.AbstractC0339a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {

    /* renamed from: A, reason: collision with root package name */
    NestedScrollView f3423A;

    /* renamed from: C, reason: collision with root package name */
    private Drawable f3425C;

    /* renamed from: D, reason: collision with root package name */
    private ImageView f3426D;

    /* renamed from: E, reason: collision with root package name */
    private TextView f3427E;

    /* renamed from: F, reason: collision with root package name */
    private TextView f3428F;

    /* renamed from: G, reason: collision with root package name */
    private View f3429G;

    /* renamed from: H, reason: collision with root package name */
    ListAdapter f3430H;

    /* renamed from: J, reason: collision with root package name */
    private int f3432J;

    /* renamed from: K, reason: collision with root package name */
    private int f3433K;

    /* renamed from: L, reason: collision with root package name */
    int f3434L;

    /* renamed from: M, reason: collision with root package name */
    int f3435M;

    /* renamed from: N, reason: collision with root package name */
    int f3436N;

    /* renamed from: O, reason: collision with root package name */
    int f3437O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f3438P;

    /* renamed from: R, reason: collision with root package name */
    Handler f3440R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f3442a;

    /* renamed from: b, reason: collision with root package name */
    final j f3443b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f3444c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3445d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f3446e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f3447f;

    /* renamed from: g, reason: collision with root package name */
    ListView f3448g;

    /* renamed from: h, reason: collision with root package name */
    private View f3449h;

    /* renamed from: i, reason: collision with root package name */
    private int f3450i;

    /* renamed from: j, reason: collision with root package name */
    private int f3451j;

    /* renamed from: k, reason: collision with root package name */
    private int f3452k;

    /* renamed from: l, reason: collision with root package name */
    private int f3453l;

    /* renamed from: m, reason: collision with root package name */
    private int f3454m;

    /* renamed from: o, reason: collision with root package name */
    Button f3456o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f3457p;

    /* renamed from: q, reason: collision with root package name */
    Message f3458q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f3459r;

    /* renamed from: s, reason: collision with root package name */
    Button f3460s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f3461t;

    /* renamed from: u, reason: collision with root package name */
    Message f3462u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f3463v;

    /* renamed from: w, reason: collision with root package name */
    Button f3464w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f3465x;

    /* renamed from: y, reason: collision with root package name */
    Message f3466y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f3467z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3455n = false;

    /* renamed from: B, reason: collision with root package name */
    private int f3424B = 0;

    /* renamed from: I, reason: collision with root package name */
    int f3431I = -1;

    /* renamed from: Q, reason: collision with root package name */
    private int f3439Q = 0;

    /* renamed from: S, reason: collision with root package name */
    private final View.OnClickListener f3441S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: e, reason: collision with root package name */
        private final int f3468e;

        /* renamed from: f, reason: collision with root package name */
        private final int f3469f;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f11367c2);
            this.f3469f = obtainStyledAttributes.getDimensionPixelOffset(e.j.f11371d2, -1);
            this.f3468e = obtainStyledAttributes.getDimensionPixelOffset(e.j.f11375e2, -1);
        }

        public void a(boolean z3, boolean z4) {
            if (z4 && z3) {
                return;
            }
            setPadding(getPaddingLeft(), z3 ? getPaddingTop() : this.f3468e, getPaddingRight(), z4 ? getPaddingBottom() : this.f3469f);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message obtain = (view != alertController.f3456o || (message3 = alertController.f3458q) == null) ? (view != alertController.f3460s || (message2 = alertController.f3462u) == null) ? (view != alertController.f3464w || (message = alertController.f3466y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f3440R.obtainMessage(1, alertController2.f3443b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: A, reason: collision with root package name */
        public int f3471A;

        /* renamed from: B, reason: collision with root package name */
        public int f3472B;

        /* renamed from: C, reason: collision with root package name */
        public int f3473C;

        /* renamed from: D, reason: collision with root package name */
        public int f3474D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f3476F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f3477G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f3478H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f3480J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f3481K;

        /* renamed from: L, reason: collision with root package name */
        public String f3482L;

        /* renamed from: M, reason: collision with root package name */
        public String f3483M;

        /* renamed from: N, reason: collision with root package name */
        public boolean f3484N;

        /* renamed from: O, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f3485O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f3487a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f3488b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f3490d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f3492f;

        /* renamed from: g, reason: collision with root package name */
        public View f3493g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f3494h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f3495i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f3496j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f3497k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f3498l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f3499m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f3500n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f3501o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f3502p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f3503q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f3505s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f3506t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f3507u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f3508v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f3509w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f3510x;

        /* renamed from: y, reason: collision with root package name */
        public int f3511y;

        /* renamed from: z, reason: collision with root package name */
        public View f3512z;

        /* renamed from: c, reason: collision with root package name */
        public int f3489c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f3491e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f3475E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f3479I = -1;

        /* renamed from: P, reason: collision with root package name */
        public boolean f3486P = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f3504r = true;

        class a extends ArrayAdapter {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecycleListView f3513e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i3, int i4, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i3, i4, charSequenceArr);
                this.f3513e = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i3, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i3, view, viewGroup);
                boolean[] zArr = b.this.f3476F;
                if (zArr != null && zArr[i3]) {
                    this.f3513e.setItemChecked(i3, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        class C0053b extends CursorAdapter {

            /* renamed from: e, reason: collision with root package name */
            private final int f3515e;

            /* renamed from: f, reason: collision with root package name */
            private final int f3516f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ RecycleListView f3517g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ AlertController f3518h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0053b(Context context, Cursor cursor, boolean z3, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z3);
                this.f3517g = recycleListView;
                this.f3518h = alertController;
                Cursor cursor2 = getCursor();
                this.f3515e = cursor2.getColumnIndexOrThrow(b.this.f3482L);
                this.f3516f = cursor2.getColumnIndexOrThrow(b.this.f3483M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f3515e));
                this.f3517g.setItemChecked(cursor.getPosition(), cursor.getInt(this.f3516f) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f3488b.inflate(this.f3518h.f3435M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AlertController f3520e;

            c(AlertController alertController) {
                this.f3520e = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                b.this.f3510x.onClick(this.f3520e.f3443b, i3);
                if (b.this.f3478H) {
                    return;
                }
                this.f3520e.f3443b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecycleListView f3522e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AlertController f3523f;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f3522e = recycleListView;
                this.f3523f = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                boolean[] zArr = b.this.f3476F;
                if (zArr != null) {
                    zArr[i3] = this.f3522e.isItemChecked(i3);
                }
                b.this.f3480J.onClick(this.f3523f.f3443b, i3, this.f3522e.isItemChecked(i3));
            }
        }

        public b(Context context) {
            this.f3487a = context;
            this.f3488b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f3488b.inflate(alertController.f3434L, (ViewGroup) null);
            if (this.f3477G) {
                listAdapter = this.f3481K == null ? new a(this.f3487a, alertController.f3435M, R.id.text1, this.f3508v, recycleListView) : new C0053b(this.f3487a, this.f3481K, false, recycleListView, alertController);
            } else {
                int i3 = this.f3478H ? alertController.f3436N : alertController.f3437O;
                if (this.f3481K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f3487a, i3, this.f3481K, new String[]{this.f3482L}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.f3509w;
                    if (listAdapter == null) {
                        listAdapter = new d(this.f3487a, i3, R.id.text1, this.f3508v);
                    }
                }
            }
            alertController.f3430H = listAdapter;
            alertController.f3431I = this.f3479I;
            if (this.f3510x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.f3480J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f3485O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f3478H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f3477G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f3448g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f3493g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f3492f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f3490d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i3 = this.f3489c;
                if (i3 != 0) {
                    alertController.m(i3);
                }
                int i4 = this.f3491e;
                if (i4 != 0) {
                    alertController.m(alertController.d(i4));
                }
            }
            CharSequence charSequence2 = this.f3494h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f3495i;
            if (charSequence3 != null || this.f3496j != null) {
                alertController.k(-1, charSequence3, this.f3497k, null, this.f3496j);
            }
            CharSequence charSequence4 = this.f3498l;
            if (charSequence4 != null || this.f3499m != null) {
                alertController.k(-2, charSequence4, this.f3500n, null, this.f3499m);
            }
            CharSequence charSequence5 = this.f3501o;
            if (charSequence5 != null || this.f3502p != null) {
                alertController.k(-3, charSequence5, this.f3503q, null, this.f3502p);
            }
            if (this.f3508v != null || this.f3481K != null || this.f3509w != null) {
                b(alertController);
            }
            View view2 = this.f3512z;
            if (view2 != null) {
                if (this.f3475E) {
                    alertController.t(view2, this.f3471A, this.f3472B, this.f3473C, this.f3474D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i5 = this.f3511y;
            if (i5 != 0) {
                alertController.r(i5);
            }
        }
    }

    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f3525a;

        public c(DialogInterface dialogInterface) {
            this.f3525a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -3 || i3 == -2 || i3 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f3525a.get(), message.what);
            } else {
                if (i3 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class d extends ArrayAdapter {
        public d(Context context, int i3, int i4, CharSequence[] charSequenceArr) {
            super(context, i3, i4, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, j jVar, Window window) {
        this.f3442a = context;
        this.f3443b = jVar;
        this.f3444c = window;
        this.f3440R = new c(jVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, e.j.f11274F, AbstractC0339a.f11096k, 0);
        this.f3432J = obtainStyledAttributes.getResourceId(e.j.f11278G, 0);
        this.f3433K = obtainStyledAttributes.getResourceId(e.j.f11286I, 0);
        this.f3434L = obtainStyledAttributes.getResourceId(e.j.f11294K, 0);
        this.f3435M = obtainStyledAttributes.getResourceId(e.j.f11298L, 0);
        this.f3436N = obtainStyledAttributes.getResourceId(e.j.f11306N, 0);
        this.f3437O = obtainStyledAttributes.getResourceId(e.j.f11290J, 0);
        this.f3438P = obtainStyledAttributes.getBoolean(e.j.f11302M, true);
        this.f3445d = obtainStyledAttributes.getDimensionPixelSize(e.j.f11282H, 0);
        obtainStyledAttributes.recycle();
        jVar.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i3 = this.f3433K;
        return (i3 != 0 && this.f3439Q == 1) ? i3 : this.f3432J;
    }

    private void p(ViewGroup viewGroup, View view, int i3, int i4) {
        View findViewById = this.f3444c.findViewById(e.f.f11210u);
        View findViewById2 = this.f3444c.findViewById(e.f.f11209t);
        y.z0(view, i3, i4);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        int i3;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f3456o = button;
        button.setOnClickListener(this.f3441S);
        if (TextUtils.isEmpty(this.f3457p) && this.f3459r == null) {
            this.f3456o.setVisibility(8);
            i3 = 0;
        } else {
            this.f3456o.setText(this.f3457p);
            Drawable drawable = this.f3459r;
            if (drawable != null) {
                int i4 = this.f3445d;
                drawable.setBounds(0, 0, i4, i4);
                this.f3456o.setCompoundDrawables(this.f3459r, null, null, null);
            }
            this.f3456o.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f3460s = button2;
        button2.setOnClickListener(this.f3441S);
        if (TextUtils.isEmpty(this.f3461t) && this.f3463v == null) {
            this.f3460s.setVisibility(8);
        } else {
            this.f3460s.setText(this.f3461t);
            Drawable drawable2 = this.f3463v;
            if (drawable2 != null) {
                int i5 = this.f3445d;
                drawable2.setBounds(0, 0, i5, i5);
                this.f3460s.setCompoundDrawables(this.f3463v, null, null, null);
            }
            this.f3460s.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f3464w = button3;
        button3.setOnClickListener(this.f3441S);
        if (TextUtils.isEmpty(this.f3465x) && this.f3467z == null) {
            this.f3464w.setVisibility(8);
        } else {
            this.f3464w.setText(this.f3465x);
            Drawable drawable3 = this.f3467z;
            if (drawable3 != null) {
                int i6 = this.f3445d;
                drawable3.setBounds(0, 0, i6, i6);
                this.f3464w.setCompoundDrawables(this.f3467z, null, null, null);
            }
            this.f3464w.setVisibility(0);
            i3 |= 4;
        }
        if (z(this.f3442a)) {
            if (i3 == 1) {
                b(this.f3456o);
            } else if (i3 == 2) {
                b(this.f3460s);
            } else if (i3 == 4) {
                b(this.f3464w);
            }
        }
        if (i3 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f3444c.findViewById(e.f.f11211v);
        this.f3423A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f3423A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f3428F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f3447f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f3423A.removeView(this.f3428F);
        if (this.f3448g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f3423A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.f3423A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f3448g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f3449h;
        if (view == null) {
            view = this.f3450i != 0 ? LayoutInflater.from(this.f3442a).inflate(this.f3450i, viewGroup, false) : null;
        }
        boolean z3 = view != null;
        if (!z3 || !a(view)) {
            this.f3444c.setFlags(131072, 131072);
        }
        if (!z3) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f3444c.findViewById(e.f.f11203n);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.f3455n) {
            frameLayout.setPadding(this.f3451j, this.f3452k, this.f3453l, this.f3454m);
        }
        if (this.f3448g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.f3429G != null) {
            viewGroup.addView(this.f3429G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f3444c.findViewById(e.f.f11188N).setVisibility(8);
            return;
        }
        this.f3426D = (ImageView) this.f3444c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f3446e) || !this.f3438P) {
            this.f3444c.findViewById(e.f.f11188N).setVisibility(8);
            this.f3426D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f3444c.findViewById(e.f.f11199j);
        this.f3427E = textView;
        textView.setText(this.f3446e);
        int i3 = this.f3424B;
        if (i3 != 0) {
            this.f3426D.setImageResource(i3);
            return;
        }
        Drawable drawable = this.f3425C;
        if (drawable != null) {
            this.f3426D.setImageDrawable(drawable);
        } else {
            this.f3427E.setPadding(this.f3426D.getPaddingLeft(), this.f3426D.getPaddingTop(), this.f3426D.getPaddingRight(), this.f3426D.getPaddingBottom());
            this.f3426D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f3444c.findViewById(e.f.f11208s);
        View findViewById4 = findViewById3.findViewById(e.f.f11189O);
        View findViewById5 = findViewById3.findViewById(e.f.f11202m);
        View findViewById6 = findViewById3.findViewById(e.f.f11200k);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(e.f.f11204o);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(e.f.f11189O);
        View findViewById8 = viewGroup.findViewById(e.f.f11202m);
        View findViewById9 = viewGroup.findViewById(e.f.f11200k);
        ViewGroup i3 = i(findViewById7, findViewById4);
        ViewGroup i4 = i(findViewById8, findViewById5);
        ViewGroup i5 = i(findViewById9, findViewById6);
        v(i4);
        u(i5);
        x(i3);
        boolean z3 = viewGroup.getVisibility() != 8;
        boolean z4 = (i3 == null || i3.getVisibility() == 8) ? 0 : 1;
        boolean z5 = (i5 == null || i5.getVisibility() == 8) ? false : true;
        if (!z5 && i4 != null && (findViewById2 = i4.findViewById(e.f.f11184J)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z4 != 0) {
            NestedScrollView nestedScrollView = this.f3423A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f3447f == null && this.f3448g == null) ? null : i3.findViewById(e.f.f11187M);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (i4 != null && (findViewById = i4.findViewById(e.f.f11185K)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f3448g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z4, z5);
        }
        if (!z3) {
            View view = this.f3448g;
            if (view == null) {
                view = this.f3423A;
            }
            if (view != null) {
                p(i4, view, z4 | (z5 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f3448g;
        if (listView2 == null || (listAdapter = this.f3430H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i6 = this.f3431I;
        if (i6 > -1) {
            listView2.setItemChecked(i6, true);
            listView2.setSelection(i6);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC0339a.f11095j, typedValue, true);
        return typedValue.data != 0;
    }

    public Button c(int i3) {
        if (i3 == -3) {
            return this.f3464w;
        }
        if (i3 == -2) {
            return this.f3460s;
        }
        if (i3 != -1) {
            return null;
        }
        return this.f3456o;
    }

    public int d(int i3) {
        TypedValue typedValue = new TypedValue();
        this.f3442a.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f3448g;
    }

    public void f() {
        this.f3443b.setContentView(j());
        y();
    }

    public boolean g(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3423A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public boolean h(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3423A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public void k(int i3, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f3440R.obtainMessage(i3, onClickListener);
        }
        if (i3 == -3) {
            this.f3465x = charSequence;
            this.f3466y = message;
            this.f3467z = drawable;
        } else if (i3 == -2) {
            this.f3461t = charSequence;
            this.f3462u = message;
            this.f3463v = drawable;
        } else {
            if (i3 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f3457p = charSequence;
            this.f3458q = message;
            this.f3459r = drawable;
        }
    }

    public void l(View view) {
        this.f3429G = view;
    }

    public void m(int i3) {
        this.f3425C = null;
        this.f3424B = i3;
        ImageView imageView = this.f3426D;
        if (imageView != null) {
            if (i3 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f3426D.setImageResource(this.f3424B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.f3425C = drawable;
        this.f3424B = 0;
        ImageView imageView = this.f3426D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f3426D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f3447f = charSequence;
        TextView textView = this.f3428F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f3446e = charSequence;
        TextView textView = this.f3427E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i3) {
        this.f3449h = null;
        this.f3450i = i3;
        this.f3455n = false;
    }

    public void s(View view) {
        this.f3449h = view;
        this.f3450i = 0;
        this.f3455n = false;
    }

    public void t(View view, int i3, int i4, int i5, int i6) {
        this.f3449h = view;
        this.f3450i = 0;
        this.f3455n = true;
        this.f3451j = i3;
        this.f3452k = i4;
        this.f3453l = i5;
        this.f3454m = i6;
    }
}
