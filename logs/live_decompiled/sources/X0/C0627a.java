package x0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import d0.AbstractC0335a;
import f2.AbstractC0359a;
import f2.AbstractC0361c;
import f2.g;
import f2.h;
import u0.AbstractC0597a;

/* renamed from: x0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0627a implements InterfaceC0628b {

    /* renamed from: a, reason: collision with root package name */
    private f f13914a;

    /* renamed from: b, reason: collision with root package name */
    private Context f13915b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f13916c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f13917d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollView f13918e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f13919f;

    /* renamed from: g, reason: collision with root package name */
    private int f13920g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f13921h;

    /* renamed from: x0.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0154a implements View.OnClickListener {
        ViewOnClickListenerC0154a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0627a.this.f13914a.a();
        }
    }

    /* renamed from: x0.a$b */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f13923e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f13924f;

        b(ViewGroup viewGroup, int i3) {
            this.f13923e = viewGroup;
            this.f13924f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            androidx.coordinatorlayout.widget.b.a(this.f13923e, C0627a.this.f13919f, rect);
            int i3 = this.f13924f;
            rect.inset(-i3, -i3);
            this.f13923e.setTouchDelegate(new TouchDelegate(rect, C0627a.this.f13919f));
        }
    }

    /* renamed from: x0.a$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private CharSequence f13926a;

        public C0627a b() {
            return new C0627a(this, null);
        }
    }

    /* synthetic */ C0627a(c cVar, ViewOnClickListenerC0154a viewOnClickListenerC0154a) {
        this(cVar);
    }

    @Override // x0.InterfaceC0628b
    public void a() {
    }

    @Override // x0.InterfaceC0628b
    public void b(f fVar, Context context, int i3) {
        this.f13914a = fVar;
        this.f13915b = context;
        this.f13920g = i3;
    }

    @Override // x0.InterfaceC0628b
    public int c(int i3, ViewGroup viewGroup) {
        return Math.min(viewGroup.getMeasuredWidth(), i3);
    }

    @Override // x0.InterfaceC0628b
    public void d(ViewGroup viewGroup) {
        Context context = this.f13915b;
        int[] iArr = h.f11621a;
        int[] iArr2 = this.f13916c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, iArr2[0], iArr2[1]);
        int i3 = obtainStyledAttributes.getInt(h.f11624d, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(h.f11627g, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(h.f11628h, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(h.f11626f, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(h.f11625e, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(h.f11629i);
        obtainStyledAttributes.recycle();
        TextView textView = (TextView) viewGroup.findViewById(f2.e.f11613a);
        this.f13917d = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ScrollView scrollView = (ScrollView) viewGroup.findViewById(f2.e.f11615c);
        this.f13918e = scrollView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) scrollView.getLayoutParams();
        layoutParams.gravity = i3;
        layoutParams.setMargins(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        layoutParams.setMarginStart(dimensionPixelSize);
        layoutParams.setMarginEnd(dimensionPixelSize3);
        this.f13918e.setLayoutParams(layoutParams);
        this.f13917d.setTextSize(0, (int) AbstractC0597a.e(this.f13915b.getResources().getDimensionPixelSize(this.f13920g == 0 ? AbstractC0361c.f11607n : AbstractC0361c.f11606m), this.f13915b.getResources().getConfiguration().fontScale, 4));
        if (colorStateList != null) {
            this.f13917d.setTextColor(colorStateList);
        }
        if (!TextUtils.isEmpty(this.f13921h)) {
            this.f13917d.setText(this.f13921h);
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(f2.e.f11614b);
        this.f13919f = imageView;
        if (this.f13920g == 0) {
            imageView.setVisibility(0);
            this.f13919f.setOnClickListener(new ViewOnClickListenerC0154a());
        } else {
            imageView.setVisibility(8);
        }
        this.f13919f.post(new b(viewGroup, this.f13915b.getResources().getDimensionPixelOffset(AbstractC0361c.f11594a)));
    }

    @Override // x0.InterfaceC0628b
    public int e() {
        return f2.f.f11616a;
    }

    @Override // x0.InterfaceC0628b
    public void f(CharSequence charSequence) {
        TextView textView = this.f13917d;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.f13921h = charSequence;
        }
    }

    @Override // x0.InterfaceC0628b
    public int[] g() {
        if (this.f13920g == 0) {
            int[] iArr = this.f13916c;
            iArr[0] = AbstractC0359a.f11592b;
            iArr[1] = AbstractC0335a.j(this.f13915b) ? g.f11618b : g.f11617a;
        } else {
            int[] iArr2 = this.f13916c;
            iArr2[0] = AbstractC0359a.f11591a;
            iArr2[1] = AbstractC0335a.j(this.f13915b) ? g.f11620d : g.f11619c;
        }
        return this.f13916c;
    }

    @Override // x0.InterfaceC0628b
    public void h(ViewGroup viewGroup, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13918e.getLayoutParams();
        this.f13917d.setMaxWidth((((i3 - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
    }

    @Override // x0.InterfaceC0628b
    public int i() {
        return this.f13915b.getResources().getDimensionPixelSize(AbstractC0361c.f11608o);
    }

    private C0627a(c cVar) {
        this.f13916c = new int[2];
        this.f13921h = cVar.f13926a;
    }
}
