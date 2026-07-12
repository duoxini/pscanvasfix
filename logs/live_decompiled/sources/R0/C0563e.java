package r0;

import android.R;
import android.util.SparseIntArray;
import h0.AbstractC0371a;

/* renamed from: r0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0563e implements InterfaceC0564f {

    /* renamed from: e, reason: collision with root package name */
    private final String f13188e;

    /* renamed from: f, reason: collision with root package name */
    private final SparseIntArray f13189f;

    /* renamed from: g, reason: collision with root package name */
    private final InterfaceC0564f f13190g;

    /* renamed from: h, reason: collision with root package name */
    private int f13191h;

    /* renamed from: i, reason: collision with root package name */
    private int f13192i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13193j;

    /* renamed from: k, reason: collision with root package name */
    int f13194k;

    /* renamed from: l, reason: collision with root package name */
    int f13195l;

    public C0563e(String str, InterfaceC0564f interfaceC0564f) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.f13189f = sparseIntArray;
        this.f13191h = 0;
        this.f13192i = 0;
        this.f13193j = true;
        this.f13194k = 0;
        this.f13195l = 0;
        this.f13188e = str;
        this.f13190g = interfaceC0564f;
        sparseIntArray.put(R.attr.state_focused, 2);
        sparseIntArray.put(R.attr.state_hovered, 4);
        sparseIntArray.put(1, 1);
        sparseIntArray.put(R.attr.state_selected, 8);
        sparseIntArray.put(R.attr.state_pressed, 16);
        sparseIntArray.put(R.attr.state_enabled, 32);
    }

    private void i(int[] iArr, int i3) {
        int length = iArr.length;
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (iArr[i4] == i3) {
                z3 = true;
                break;
            }
            i4++;
        }
        if (!(z3 && (this.f13194k & this.f13189f.get(i3)) == 0) && (z3 || (this.f13194k & this.f13189f.get(i3)) == 0)) {
            return;
        }
        w(i3, z3);
    }

    private String l() {
        int i3 = this.f13191h;
        return i3 != 0 ? i3 != 1 ? "Unknown" : "selected" : "pressed";
    }

    private void w(int i3, boolean z3) {
        if (((this.f13194k & this.f13189f.get(i3)) != 0 && z3) || ((this.f13194k & this.f13189f.get(i3)) == 0 && !z3)) {
            AbstractC0371a.d(this.f13188e, "state " + j(i3) + " not changed: " + z3);
            if (i3 != 1) {
                return;
            }
        }
        boolean z4 = (this.f13194k & this.f13189f.get(i3)) != 0;
        int i4 = this.f13194k;
        int i5 = this.f13189f.get(i3);
        this.f13194k = z3 ? i4 | i5 : i4 & (~i5);
        d(i3);
        AbstractC0371a.a(this.f13188e, "state " + j(i3) + " changed from " + z4 + " to " + z3);
    }

    public void A() {
        this.f13191h = 1;
        w(1, false);
    }

    @Override // r0.InterfaceC0564f
    public void a(int i3, boolean z3, boolean z4, boolean z5) {
        if (z3) {
            this.f13195l = this.f13189f.get(i3) | this.f13195l;
        } else {
            this.f13195l = (~this.f13189f.get(i3)) & this.f13195l;
        }
    }

    @Override // r0.InterfaceC0564f
    public void b() {
        w(R.attr.state_focused, false);
    }

    @Override // r0.InterfaceC0564f
    public void c() {
        w(R.attr.state_hovered, false);
    }

    @Override // r0.InterfaceC0564f
    public void d(int i3) {
        this.f13190g.d(i3);
    }

    @Override // r0.InterfaceC0564f
    public void e() {
        this.f13191h = 0;
        w(1, false);
    }

    @Override // r0.InterfaceC0564f
    public void f() {
        this.f13191h = 0;
        w(1, true);
    }

    @Override // r0.InterfaceC0564f
    public void g() {
        w(R.attr.state_focused, true);
    }

    @Override // r0.InterfaceC0564f
    public void h() {
        w(R.attr.state_hovered, true);
    }

    public String j(int i3) {
        switch (i3) {
            case 1:
                return "touch entered #" + l();
            case R.attr.state_focused:
                return "focused";
            case R.attr.state_enabled:
                return "enabled";
            case R.attr.state_selected:
                return "selected";
            case R.attr.state_pressed:
                return "pressed";
            case R.attr.state_hovered:
                return "hovered";
            default:
                return "Unknown";
        }
    }

    public int k() {
        return this.f13191h;
    }

    public boolean m() {
        return this.f13193j;
    }

    public boolean n() {
        return (this.f13189f.get(R.attr.state_enabled) & this.f13194k) != 0;
    }

    public boolean o() {
        return (this.f13189f.get(R.attr.state_focused) & this.f13194k) != 0;
    }

    public boolean p() {
        return (this.f13189f.get(R.attr.state_hovered) & this.f13194k) != 0;
    }

    public boolean q(int i3) {
        return (this.f13192i & i3) == 0;
    }

    public boolean r() {
        return (this.f13189f.get(R.attr.state_pressed) & this.f13194k) != 0;
    }

    public boolean s() {
        return (this.f13189f.get(R.attr.state_selected) & this.f13194k) != 0;
    }

    public boolean t(int i3) {
        return (this.f13189f.get(i3) & this.f13195l) != 0;
    }

    public boolean u() {
        return true;
    }

    public boolean v() {
        return (this.f13189f.get(1) & this.f13194k) != 0;
    }

    public void x(int[] iArr) {
        if (q(32)) {
            i(iArr, R.attr.state_enabled);
        }
        if (q(2)) {
            i(iArr, R.attr.state_focused);
        }
        if (q(4)) {
            i(iArr, R.attr.state_hovered);
        }
        if (q(8)) {
            i(iArr, R.attr.state_selected);
        }
        if (q(16)) {
            i(iArr, R.attr.state_pressed);
        }
    }

    public void y(boolean z3) {
        this.f13193j = z3;
    }

    public void z() {
        this.f13191h = 1;
        w(1, true);
    }
}
