package g0;

import P1.d;
import P1.e;
import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: g0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0364b extends BaseAdapter {

    /* renamed from: k, reason: collision with root package name */
    private static final int f11663k = e.f1829a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11664e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11665f;

    /* renamed from: g, reason: collision with root package name */
    private Context f11666g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence[] f11667h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence[] f11668i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f11669j;

    /* renamed from: g0.b$b, reason: collision with other inner class name */
    private class C0133b {

        /* renamed from: a, reason: collision with root package name */
        TextView f11670a;

        /* renamed from: b, reason: collision with root package name */
        TextView f11671b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f11672c;

        /* renamed from: d, reason: collision with root package name */
        LinearLayout f11673d;

        private C0133b() {
        }
    }

    public C0364b(Context context, boolean z3, boolean z4, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int[] iArr) {
        this.f11664e = z3;
        this.f11665f = z4;
        this.f11666g = context;
        this.f11667h = charSequenceArr;
        this.f11668i = charSequenceArr2;
        this.f11669j = iArr;
    }

    private void c(int i3, View view) {
        int dimensionPixelSize = this.f11666g.getResources().getDimensionPixelSize(P1.b.f1759H);
        int dimensionPixelSize2 = this.f11666g.getResources().getDimensionPixelSize(P1.b.f1761J);
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (i3 == getCount() - 1 && this.f11665f) {
            view.setPadding(paddingLeft, dimensionPixelSize2, paddingRight, dimensionPixelSize + dimensionPixelSize2);
        } else if (i3 == 0 && this.f11664e) {
            view.setPadding(paddingLeft, dimensionPixelSize + dimensionPixelSize2, paddingRight, dimensionPixelSize2);
        } else {
            view.setPadding(paddingLeft, dimensionPixelSize2, paddingRight, dimensionPixelSize2);
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int i3) {
        CharSequence[] charSequenceArr = this.f11667h;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i3];
    }

    public CharSequence b(int i3) {
        CharSequence[] charSequenceArr = this.f11668i;
        if (charSequenceArr != null && i3 < charSequenceArr.length) {
            return charSequenceArr[i3];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.f11667h;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        C0133b c0133b;
        if (view == null) {
            view = LayoutInflater.from(this.f11666g).inflate(f11663k, viewGroup, false);
            c0133b = new C0133b();
            c0133b.f11670a = (TextView) view.findViewById(R.id.text1);
            c0133b.f11671b = (TextView) view.findViewById(d.f1825v);
            c0133b.f11672c = (ImageView) view.findViewById(d.f1817n);
            c0133b.f11673d = (LinearLayout) view.findViewById(d.f1819p);
            view.setTag(c0133b);
        } else {
            c0133b = (C0133b) view.getTag();
        }
        CharSequence item = getItem(i3);
        CharSequence b3 = b(i3);
        c0133b.f11670a.setText(item);
        if (TextUtils.isEmpty(b3)) {
            c0133b.f11671b.setVisibility(8);
        } else {
            c0133b.f11671b.setVisibility(0);
            c0133b.f11671b.setText(b3);
        }
        c(i3, c0133b.f11673d);
        int[] iArr = this.f11669j;
        if (iArr != null && i3 >= 0 && i3 < iArr.length) {
            c0133b.f11670a.setTextColor(iArr[i3]);
        }
        if (c0133b.f11672c != null) {
            if (getCount() <= 1 || i3 == getCount() - 1) {
                c0133b.f11672c.setVisibility(8);
            } else {
                c0133b.f11672c.setVisibility(0);
            }
        }
        view.requestLayout();
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
