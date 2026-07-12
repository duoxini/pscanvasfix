package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
final class e extends RecyclerView.u {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager2.i f6825a;

    /* renamed from: b, reason: collision with root package name */
    private final ViewPager2 f6826b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView f6827c;

    /* renamed from: d, reason: collision with root package name */
    private final LinearLayoutManager f6828d;

    /* renamed from: e, reason: collision with root package name */
    private int f6829e;

    /* renamed from: f, reason: collision with root package name */
    private int f6830f;

    /* renamed from: g, reason: collision with root package name */
    private a f6831g;

    /* renamed from: h, reason: collision with root package name */
    private int f6832h;

    /* renamed from: i, reason: collision with root package name */
    private int f6833i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6834j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6835k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6836l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6837m;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f6838a;

        /* renamed from: b, reason: collision with root package name */
        float f6839b;

        /* renamed from: c, reason: collision with root package name */
        int f6840c;

        a() {
        }

        void a() {
            this.f6838a = -1;
            this.f6839b = 0.0f;
            this.f6840c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.f6826b = viewPager2;
        RecyclerView recyclerView = viewPager2.f6785n;
        this.f6827c = recyclerView;
        this.f6828d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f6831g = new a();
        l();
    }

    private void a(int i3, float f3, int i4) {
        ViewPager2.i iVar = this.f6825a;
        if (iVar != null) {
            iVar.onPageScrolled(i3, f3, i4);
        }
    }

    private void b(int i3) {
        ViewPager2.i iVar = this.f6825a;
        if (iVar != null) {
            iVar.onPageSelected(i3);
        }
    }

    private void c(int i3) {
        if ((this.f6829e == 3 && this.f6830f == 0) || this.f6830f == i3) {
            return;
        }
        this.f6830f = i3;
        ViewPager2.i iVar = this.f6825a;
        if (iVar != null) {
            iVar.onPageScrollStateChanged(i3);
        }
    }

    private int d() {
        return this.f6828d.c2();
    }

    private boolean i() {
        int i3 = this.f6829e;
        return i3 == 1 || i3 == 4;
    }

    private void l() {
        this.f6829e = 0;
        this.f6830f = 0;
        this.f6831g.a();
        this.f6832h = -1;
        this.f6833i = -1;
        this.f6834j = false;
        this.f6835k = false;
        this.f6837m = false;
        this.f6836l = false;
    }

    private void n(boolean z3) {
        this.f6837m = z3;
        this.f6829e = z3 ? 4 : 1;
        int i3 = this.f6833i;
        if (i3 != -1) {
            this.f6832h = i3;
            this.f6833i = -1;
        } else if (this.f6832h == -1) {
            this.f6832h = d();
        }
        c(1);
    }

    private void o() {
        int top;
        a aVar = this.f6831g;
        int c22 = this.f6828d.c2();
        aVar.f6838a = c22;
        if (c22 == -1) {
            aVar.a();
            return;
        }
        View C3 = this.f6828d.C(c22);
        if (C3 == null) {
            aVar.a();
            return;
        }
        int a02 = this.f6828d.a0(C3);
        int l02 = this.f6828d.l0(C3);
        int o02 = this.f6828d.o0(C3);
        int H3 = this.f6828d.H(C3);
        ViewGroup.LayoutParams layoutParams = C3.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            a02 += marginLayoutParams.leftMargin;
            l02 += marginLayoutParams.rightMargin;
            o02 += marginLayoutParams.topMargin;
            H3 += marginLayoutParams.bottomMargin;
        }
        int height = C3.getHeight() + o02 + H3;
        int width = C3.getWidth() + a02 + l02;
        if (this.f6828d.q2() == 0) {
            top = (C3.getLeft() - a02) - this.f6827c.getPaddingLeft();
            if (this.f6826b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (C3.getTop() - o02) - this.f6827c.getPaddingTop();
        }
        int i3 = -top;
        aVar.f6840c = i3;
        if (i3 >= 0) {
            aVar.f6839b = height == 0 ? 0.0f : i3 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f6828d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f6840c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    double e() {
        o();
        a aVar = this.f6831g;
        return aVar.f6838a + aVar.f6839b;
    }

    int f() {
        return this.f6830f;
    }

    boolean g() {
        return this.f6837m;
    }

    boolean h() {
        return this.f6830f == 0;
    }

    void j() {
        this.f6836l = true;
    }

    void k(int i3, boolean z3) {
        this.f6829e = z3 ? 2 : 3;
        this.f6837m = false;
        boolean z4 = this.f6833i != i3;
        this.f6833i = i3;
        c(2);
        if (z4) {
            b(i3);
        }
    }

    void m(ViewPager2.i iVar) {
        this.f6825a = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        if (!(this.f6829e == 1 && this.f6830f == 1) && i3 == 1) {
            n(false);
            return;
        }
        if (i() && i3 == 2) {
            if (this.f6835k) {
                c(2);
                this.f6834j = true;
                return;
            }
            return;
        }
        if (i() && i3 == 0) {
            o();
            if (this.f6835k) {
                a aVar = this.f6831g;
                if (aVar.f6840c == 0) {
                    int i4 = this.f6832h;
                    int i5 = aVar.f6838a;
                    if (i4 != i5) {
                        b(i5);
                    }
                }
            } else {
                int i6 = this.f6831g.f6838a;
                if (i6 != -1) {
                    a(i6, 0.0f, 0);
                }
            }
            c(0);
            l();
        }
        if (this.f6829e == 2 && i3 == 0 && this.f6836l) {
            o();
            a aVar2 = this.f6831g;
            if (aVar2.f6840c == 0) {
                int i7 = this.f6833i;
                int i8 = aVar2.f6838a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    b(i8);
                }
                c(0);
                l();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f6826b.d()) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f6835k = r4
            r3.o()
            boolean r0 = r3.f6834j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f6834j = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f6826b
            boolean r6 = r6.d()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.e$a r5 = r3.f6831g
            int r6 = r5.f6840c
            if (r6 == 0) goto L29
            int r5 = r5.f6838a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.e$a r5 = r3.f6831g
            int r5 = r5.f6838a
        L2d:
            r3.f6833i = r5
            int r6 = r3.f6832h
            if (r6 == r5) goto L45
            r3.b(r5)
            goto L45
        L37:
            int r5 = r3.f6829e
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.e$a r5 = r3.f6831g
            int r5 = r5.f6838a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.b(r5)
        L45:
            androidx.viewpager2.widget.e$a r5 = r3.f6831g
            int r6 = r5.f6838a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.f6839b
            int r5 = r5.f6840c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f6831g
            int r6 = r5.f6838a
            int r0 = r3.f6833i
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f6840c
            if (r5 != 0) goto L6b
            int r5 = r3.f6830f
            if (r5 == r4) goto L6b
            r3.c(r2)
            r3.l()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
