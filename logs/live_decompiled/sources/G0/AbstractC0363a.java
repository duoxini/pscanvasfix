package g0;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.coui.appcompat.checkbox.COUICheckBox;
import f.AbstractC0348a;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0363a extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    private Context f11640e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence[] f11641f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence[] f11642g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f11643h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable[] f11644i;

    /* renamed from: j, reason: collision with root package name */
    private int f11645j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11646k;

    /* renamed from: l, reason: collision with root package name */
    private boolean[] f11647l;

    /* renamed from: m, reason: collision with root package name */
    private boolean[] f11648m;

    /* renamed from: n, reason: collision with root package name */
    private int f11649n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11650o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11651p;

    /* renamed from: g0.a$a, reason: collision with other inner class name */
    class ViewOnTouchListenerC0132a implements View.OnTouchListener {
        ViewOnTouchListenerC0132a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: g0.a$b */
    class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f11653e;

        b(int i3) {
            this.f11653e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View findViewById = view.findViewById(P1.d.f1808e);
            if (!(findViewById instanceof COUICheckBox)) {
                if (findViewById instanceof CheckBox) {
                    ((CheckBox) findViewById).setChecked(!r5.isChecked());
                    AbstractC0363a.e(AbstractC0363a.this);
                    return;
                }
                return;
            }
            COUICheckBox cOUICheckBox = (COUICheckBox) findViewById;
            if (cOUICheckBox.getState() == 2) {
                cOUICheckBox.setState(0);
                AbstractC0363a.this.f11647l[this.f11653e] = false;
            } else if (AbstractC0363a.this.f11649n <= 0 || AbstractC0363a.this.f11649n > AbstractC0363a.this.g()) {
                cOUICheckBox.setState(2);
                AbstractC0363a.this.f11647l[this.f11653e] = true;
            } else {
                AbstractC0363a.d(AbstractC0363a.this);
            }
            AbstractC0363a.e(AbstractC0363a.this);
        }
    }

    /* renamed from: g0.a$c */
    public interface c {
    }

    /* renamed from: g0.a$d */
    public interface d {
    }

    /* renamed from: g0.a$e */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        ImageView f11655a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f11656b;

        /* renamed from: c, reason: collision with root package name */
        TextView f11657c;

        /* renamed from: d, reason: collision with root package name */
        TextView f11658d;

        /* renamed from: e, reason: collision with root package name */
        COUICheckBox f11659e;

        /* renamed from: f, reason: collision with root package name */
        FrameLayout f11660f;

        /* renamed from: g, reason: collision with root package name */
        RadioButton f11661g;

        /* renamed from: h, reason: collision with root package name */
        ImageView f11662h;

        e() {
        }
    }

    public AbstractC0363a(Context context, int i3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean z3) {
        this(context, i3, charSequenceArr, charSequenceArr2, zArr, null, z3);
    }

    static /* synthetic */ c d(AbstractC0363a abstractC0363a) {
        abstractC0363a.getClass();
        return null;
    }

    static /* synthetic */ d e(AbstractC0363a abstractC0363a) {
        abstractC0363a.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        int i3 = 0;
        for (boolean z3 : this.f11647l) {
            if (z3) {
                i3++;
            }
        }
        return i3;
    }

    private void j(boolean[] zArr) {
        for (int i3 = 0; i3 < zArr.length; i3++) {
            boolean[] zArr2 = this.f11647l;
            if (i3 >= zArr2.length) {
                return;
            }
            zArr2[i3] = zArr[i3];
        }
    }

    private void k(boolean[] zArr) {
        for (int i3 = 0; i3 < zArr.length; i3++) {
            boolean[] zArr2 = this.f11648m;
            if (i3 >= zArr2.length) {
                return;
            }
            zArr2[i3] = zArr[i3];
        }
    }

    public boolean[] f() {
        return this.f11647l;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.f11641f;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        e eVar;
        if (view == null) {
            eVar = new e();
            view2 = LayoutInflater.from(this.f11640e).inflate(this.f11645j, viewGroup, false);
            eVar.f11655a = (ImageView) view2.findViewById(P1.d.f1806c);
            eVar.f11656b = (LinearLayout) view2.findViewById(P1.d.f1826w);
            eVar.f11658d = (TextView) view2.findViewById(R.id.text1);
            eVar.f11657c = (TextView) view2.findViewById(P1.d.f1825v);
            eVar.f11662h = (ImageView) view2.findViewById(P1.d.f1817n);
            if (this.f11646k) {
                eVar.f11659e = (COUICheckBox) view2.findViewById(P1.d.f1808e);
            } else {
                eVar.f11660f = (FrameLayout) view2.findViewById(P1.d.f1822s);
                eVar.f11661g = (RadioButton) view2.findViewById(P1.d.f1821r);
            }
            if (this.f11648m[i3]) {
                eVar.f11658d.setEnabled(false);
                eVar.f11657c.setEnabled(false);
                if (this.f11646k) {
                    eVar.f11659e.setEnabled(false);
                } else {
                    eVar.f11661g.setEnabled(false);
                }
                view2.setOnTouchListener(new ViewOnTouchListenerC0132a());
            }
            view2.setTag(eVar);
        } else {
            view2 = view;
            eVar = (e) view.getTag();
        }
        if (this.f11646k) {
            eVar.f11659e.setState(this.f11647l[i3] ? 2 : 0);
            view2.setOnClickListener(new b(i3));
        } else {
            eVar.f11661g.setChecked(this.f11647l[i3]);
        }
        CharSequence item = getItem(i3);
        CharSequence i4 = i(i3);
        eVar.f11658d.setText(item);
        if (TextUtils.isEmpty(i4)) {
            eVar.f11657c.setVisibility(8);
        } else {
            eVar.f11657c.setVisibility(0);
            eVar.f11657c.setText(i4);
        }
        if (eVar.f11662h != null) {
            if (getCount() == 1 || i3 == getCount() - 1) {
                eVar.f11662h.setVisibility(8);
            } else {
                eVar.f11662h.setVisibility(0);
            }
        }
        int[] iArr = this.f11643h;
        if (iArr == null || i3 >= iArr.length) {
            Drawable[] drawableArr = this.f11644i;
            if (drawableArr == null || i3 >= drawableArr.length) {
                eVar.f11655a.setVisibility(8);
            } else {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    eVar.f11655a.setVisibility(0);
                    eVar.f11655a.setImageDrawable(drawable);
                } else {
                    eVar.f11655a.setVisibility(8);
                }
            }
        } else {
            Drawable b3 = AbstractC0348a.b(this.f11640e, iArr[i3]);
            if (b3 != null) {
                eVar.f11655a.setVisibility(0);
                eVar.f11655a.setImageDrawable(b3);
            } else {
                eVar.f11655a.setVisibility(8);
            }
        }
        return view2;
    }

    @Override // android.widget.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int i3) {
        CharSequence[] charSequenceArr = this.f11641f;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i3];
    }

    public CharSequence i(int i3) {
        CharSequence[] charSequenceArr = this.f11642g;
        if (charSequenceArr != null && i3 < charSequenceArr.length) {
            return charSequenceArr[i3];
        }
        return null;
    }

    public void l(boolean z3) {
        this.f11651p = z3;
    }

    public void m(boolean z3) {
        this.f11650o = z3;
    }

    public AbstractC0363a(Context context, int i3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean[] zArr2, boolean z3) {
        this(context, i3, charSequenceArr, charSequenceArr2, zArr, zArr2, z3, 0);
    }

    public AbstractC0363a(Context context, int i3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean[] zArr2, boolean z3, int i4) {
        this.f11650o = false;
        this.f11651p = false;
        this.f11640e = context;
        this.f11645j = i3;
        this.f11641f = charSequenceArr;
        this.f11642g = charSequenceArr2;
        this.f11646k = z3;
        this.f11647l = new boolean[charSequenceArr.length];
        if (zArr != null) {
            j(zArr);
        }
        this.f11648m = new boolean[this.f11641f.length];
        if (zArr2 != null) {
            k(zArr2);
        }
        this.f11649n = i4;
    }
}
