package w1;

import J.u;
import J.x;
import N.k;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements InterfaceC0624h {

    /* renamed from: a, reason: collision with root package name */
    private final u f13909a;

    /* renamed from: b, reason: collision with root package name */
    private final J.i f13910b;

    /* renamed from: c, reason: collision with root package name */
    private final J.h f13911c;

    /* renamed from: d, reason: collision with root package name */
    private final J.h f13912d;

    class a extends J.i {
        a(i iVar, u uVar) {
            super(uVar);
        }

        @Override // J.A
        public String e() {
            return "INSERT OR REPLACE INTO `embedded_canvas` (`task_id`,`canvas_user_id`,`package_name1`,`class_name1`,`app_task_id1`,`user_id1`,`use_max1`,`app_rect1`,`intent1`,`package_name2`,`class_name2`,`app_task_id2`,`user_id2`,`use_max2`,`app_rect2`,`intent2`,`package_name3`,`class_name3`,`app_task_id3`,`user_id3`,`use_max3`,`app_rect3`,`intent3`,`orientation`,`focus`,`layout_focus_side`,`panorama`,`landspace_layout`,`portrait_layout`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // J.i
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, C0623g c0623g) {
            kVar.y(1, c0623g.w());
            kVar.y(2, c0623g.g());
            if (c0623g.s() == null) {
                kVar.I(3);
            } else {
                kVar.x(3, c0623g.s());
            }
            if (c0623g.h() == null) {
                kVar.I(4);
            } else {
                kVar.x(4, c0623g.h());
            }
            kVar.y(5, c0623g.d());
            kVar.y(6, c0623g.A());
            kVar.y(7, c0623g.x() ? 1L : 0L);
            if (c0623g.a() == null) {
                kVar.I(8);
            } else {
                kVar.x(8, c0623g.a());
            }
            if (c0623g.l() == null) {
                kVar.I(9);
            } else {
                kVar.x(9, c0623g.l());
            }
            if (c0623g.t() == null) {
                kVar.I(10);
            } else {
                kVar.x(10, c0623g.t());
            }
            if (c0623g.i() == null) {
                kVar.I(11);
            } else {
                kVar.x(11, c0623g.i());
            }
            kVar.y(12, c0623g.e());
            kVar.y(13, c0623g.B());
            kVar.y(14, c0623g.y() ? 1L : 0L);
            if (c0623g.b() == null) {
                kVar.I(15);
            } else {
                kVar.x(15, c0623g.b());
            }
            if (c0623g.m() == null) {
                kVar.I(16);
            } else {
                kVar.x(16, c0623g.m());
            }
            if (c0623g.u() == null) {
                kVar.I(17);
            } else {
                kVar.x(17, c0623g.u());
            }
            if (c0623g.j() == null) {
                kVar.I(18);
            } else {
                kVar.x(18, c0623g.j());
            }
            kVar.y(19, c0623g.f());
            kVar.y(20, c0623g.C());
            kVar.y(21, c0623g.z() ? 1L : 0L);
            if (c0623g.c() == null) {
                kVar.I(22);
            } else {
                kVar.x(22, c0623g.c());
            }
            if (c0623g.n() == null) {
                kVar.I(23);
            } else {
                kVar.x(23, c0623g.n());
            }
            kVar.y(24, c0623g.r());
            kVar.y(25, c0623g.k());
            kVar.y(26, c0623g.q());
            kVar.y(27, c0623g.o() ? 1L : 0L);
            kVar.y(28, c0623g.p());
            kVar.y(29, c0623g.v());
        }
    }

    class b extends J.h {
        b(i iVar, u uVar) {
            super(uVar);
        }

        @Override // J.A
        public String e() {
            return "DELETE FROM `embedded_canvas` WHERE `task_id` = ?";
        }

        @Override // J.h
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, C0623g c0623g) {
            kVar.y(1, c0623g.w());
        }
    }

    class c extends J.h {
        c(i iVar, u uVar) {
            super(uVar);
        }

        @Override // J.A
        public String e() {
            return "UPDATE OR ABORT `embedded_canvas` SET `task_id` = ?,`canvas_user_id` = ?,`package_name1` = ?,`class_name1` = ?,`app_task_id1` = ?,`user_id1` = ?,`use_max1` = ?,`app_rect1` = ?,`intent1` = ?,`package_name2` = ?,`class_name2` = ?,`app_task_id2` = ?,`user_id2` = ?,`use_max2` = ?,`app_rect2` = ?,`intent2` = ?,`package_name3` = ?,`class_name3` = ?,`app_task_id3` = ?,`user_id3` = ?,`use_max3` = ?,`app_rect3` = ?,`intent3` = ?,`orientation` = ?,`focus` = ?,`layout_focus_side` = ?,`panorama` = ?,`landspace_layout` = ?,`portrait_layout` = ? WHERE `task_id` = ?";
        }

        @Override // J.h
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(k kVar, C0623g c0623g) {
            kVar.y(1, c0623g.w());
            kVar.y(2, c0623g.g());
            if (c0623g.s() == null) {
                kVar.I(3);
            } else {
                kVar.x(3, c0623g.s());
            }
            if (c0623g.h() == null) {
                kVar.I(4);
            } else {
                kVar.x(4, c0623g.h());
            }
            kVar.y(5, c0623g.d());
            kVar.y(6, c0623g.A());
            kVar.y(7, c0623g.x() ? 1L : 0L);
            if (c0623g.a() == null) {
                kVar.I(8);
            } else {
                kVar.x(8, c0623g.a());
            }
            if (c0623g.l() == null) {
                kVar.I(9);
            } else {
                kVar.x(9, c0623g.l());
            }
            if (c0623g.t() == null) {
                kVar.I(10);
            } else {
                kVar.x(10, c0623g.t());
            }
            if (c0623g.i() == null) {
                kVar.I(11);
            } else {
                kVar.x(11, c0623g.i());
            }
            kVar.y(12, c0623g.e());
            kVar.y(13, c0623g.B());
            kVar.y(14, c0623g.y() ? 1L : 0L);
            if (c0623g.b() == null) {
                kVar.I(15);
            } else {
                kVar.x(15, c0623g.b());
            }
            if (c0623g.m() == null) {
                kVar.I(16);
            } else {
                kVar.x(16, c0623g.m());
            }
            if (c0623g.u() == null) {
                kVar.I(17);
            } else {
                kVar.x(17, c0623g.u());
            }
            if (c0623g.j() == null) {
                kVar.I(18);
            } else {
                kVar.x(18, c0623g.j());
            }
            kVar.y(19, c0623g.f());
            kVar.y(20, c0623g.C());
            kVar.y(21, c0623g.z() ? 1L : 0L);
            if (c0623g.c() == null) {
                kVar.I(22);
            } else {
                kVar.x(22, c0623g.c());
            }
            if (c0623g.n() == null) {
                kVar.I(23);
            } else {
                kVar.x(23, c0623g.n());
            }
            kVar.y(24, c0623g.r());
            kVar.y(25, c0623g.k());
            kVar.y(26, c0623g.q());
            kVar.y(27, c0623g.o() ? 1L : 0L);
            kVar.y(28, c0623g.p());
            kVar.y(29, c0623g.v());
            kVar.y(30, c0623g.w());
        }
    }

    public i(u uVar) {
        this.f13909a = uVar;
        this.f13910b = new a(this, uVar);
        this.f13911c = new b(this, uVar);
        this.f13912d = new c(this, uVar);
    }

    public static List e() {
        return Collections.emptyList();
    }

    @Override // w1.InterfaceC0624h
    public C0623g a(int i3) {
        x xVar;
        C0623g c0623g;
        x c3 = x.c("select * from embedded_canvas where task_id=?", 1);
        c3.y(1, i3);
        this.f13909a.d();
        Cursor b3 = L.b.b(this.f13909a, c3, false, null);
        try {
            int d3 = L.a.d(b3, "task_id");
            int d4 = L.a.d(b3, "canvas_user_id");
            int d5 = L.a.d(b3, "package_name1");
            int d6 = L.a.d(b3, "class_name1");
            int d7 = L.a.d(b3, "app_task_id1");
            int d8 = L.a.d(b3, "user_id1");
            int d9 = L.a.d(b3, "use_max1");
            int d10 = L.a.d(b3, "app_rect1");
            int d11 = L.a.d(b3, "intent1");
            int d12 = L.a.d(b3, "package_name2");
            int d13 = L.a.d(b3, "class_name2");
            int d14 = L.a.d(b3, "app_task_id2");
            int d15 = L.a.d(b3, "user_id2");
            int d16 = L.a.d(b3, "use_max2");
            xVar = c3;
            try {
                int d17 = L.a.d(b3, "app_rect2");
                int d18 = L.a.d(b3, "intent2");
                int d19 = L.a.d(b3, "package_name3");
                int d20 = L.a.d(b3, "class_name3");
                int d21 = L.a.d(b3, "app_task_id3");
                int d22 = L.a.d(b3, "user_id3");
                int d23 = L.a.d(b3, "use_max3");
                int d24 = L.a.d(b3, "app_rect3");
                int d25 = L.a.d(b3, "intent3");
                int d26 = L.a.d(b3, "orientation");
                int d27 = L.a.d(b3, "focus");
                int d28 = L.a.d(b3, "layout_focus_side");
                int d29 = L.a.d(b3, "panorama");
                int d30 = L.a.d(b3, "landspace_layout");
                int d31 = L.a.d(b3, "portrait_layout");
                if (b3.moveToFirst()) {
                    C0623g c0623g2 = new C0623g();
                    c0623g2.Z(b3.getInt(d3));
                    c0623g2.J(b3.getInt(d4));
                    c0623g2.V(b3.isNull(d5) ? null : b3.getString(d5));
                    c0623g2.K(b3.isNull(d6) ? null : b3.getString(d6));
                    c0623g2.G(b3.getInt(d7));
                    c0623g2.d0(b3.getInt(d8));
                    c0623g2.a0(b3.getInt(d9) != 0);
                    c0623g2.D(b3.isNull(d10) ? null : b3.getString(d10));
                    c0623g2.O(b3.isNull(d11) ? null : b3.getString(d11));
                    c0623g2.W(b3.isNull(d12) ? null : b3.getString(d12));
                    c0623g2.L(b3.isNull(d13) ? null : b3.getString(d13));
                    c0623g2.H(b3.getInt(d14));
                    c0623g2.e0(b3.getInt(d15));
                    c0623g2.b0(b3.getInt(d16) != 0);
                    c0623g2.E(b3.isNull(d17) ? null : b3.getString(d17));
                    c0623g2.P(b3.isNull(d18) ? null : b3.getString(d18));
                    c0623g2.X(b3.isNull(d19) ? null : b3.getString(d19));
                    c0623g2.M(b3.isNull(d20) ? null : b3.getString(d20));
                    c0623g2.I(b3.getInt(d21));
                    c0623g2.f0(b3.getInt(d22));
                    c0623g2.c0(b3.getInt(d23) != 0);
                    c0623g2.F(b3.isNull(d24) ? null : b3.getString(d24));
                    c0623g2.Q(b3.isNull(d25) ? null : b3.getString(d25));
                    c0623g2.U(b3.getInt(d26));
                    c0623g2.N(b3.getInt(d27));
                    c0623g2.T(b3.getInt(d28));
                    c0623g2.R(b3.getInt(d29) != 0);
                    c0623g2.S(b3.getInt(d30));
                    c0623g2.Y(b3.getInt(d31));
                    c0623g = c0623g2;
                } else {
                    c0623g = null;
                }
                b3.close();
                xVar.j();
                return c0623g;
            } catch (Throwable th) {
                th = th;
                b3.close();
                xVar.j();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = c3;
        }
    }

    @Override // w1.InterfaceC0624h
    public long[] b(C0623g... c0623gArr) {
        this.f13909a.d();
        this.f13909a.e();
        try {
            long[] j3 = this.f13910b.j(c0623gArr);
            this.f13909a.z();
            return j3;
        } finally {
            this.f13909a.i();
        }
    }

    @Override // w1.InterfaceC0624h
    public List c() {
        x xVar;
        int d3;
        int d4;
        int d5;
        int d6;
        int d7;
        int d8;
        int d9;
        int d10;
        int d11;
        int d12;
        int d13;
        int d14;
        int d15;
        int d16;
        int i3;
        boolean z3;
        int i4;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        boolean z4;
        x c3 = x.c("select * from embedded_canvas", 0);
        this.f13909a.d();
        Cursor b3 = L.b.b(this.f13909a, c3, false, null);
        try {
            d3 = L.a.d(b3, "task_id");
            d4 = L.a.d(b3, "canvas_user_id");
            d5 = L.a.d(b3, "package_name1");
            d6 = L.a.d(b3, "class_name1");
            d7 = L.a.d(b3, "app_task_id1");
            d8 = L.a.d(b3, "user_id1");
            d9 = L.a.d(b3, "use_max1");
            d10 = L.a.d(b3, "app_rect1");
            d11 = L.a.d(b3, "intent1");
            d12 = L.a.d(b3, "package_name2");
            d13 = L.a.d(b3, "class_name2");
            d14 = L.a.d(b3, "app_task_id2");
            d15 = L.a.d(b3, "user_id2");
            d16 = L.a.d(b3, "use_max2");
            xVar = c3;
        } catch (Throwable th) {
            th = th;
            xVar = c3;
        }
        try {
            int d17 = L.a.d(b3, "app_rect2");
            int d18 = L.a.d(b3, "intent2");
            int d19 = L.a.d(b3, "package_name3");
            int d20 = L.a.d(b3, "class_name3");
            int d21 = L.a.d(b3, "app_task_id3");
            int d22 = L.a.d(b3, "user_id3");
            int d23 = L.a.d(b3, "use_max3");
            int d24 = L.a.d(b3, "app_rect3");
            int d25 = L.a.d(b3, "intent3");
            int d26 = L.a.d(b3, "orientation");
            int d27 = L.a.d(b3, "focus");
            int d28 = L.a.d(b3, "layout_focus_side");
            int d29 = L.a.d(b3, "panorama");
            int d30 = L.a.d(b3, "landspace_layout");
            int d31 = L.a.d(b3, "portrait_layout");
            int i5 = d16;
            ArrayList arrayList = new ArrayList(b3.getCount());
            while (b3.moveToNext()) {
                C0623g c0623g = new C0623g();
                ArrayList arrayList2 = arrayList;
                c0623g.Z(b3.getInt(d3));
                c0623g.J(b3.getInt(d4));
                c0623g.V(b3.isNull(d5) ? null : b3.getString(d5));
                c0623g.K(b3.isNull(d6) ? null : b3.getString(d6));
                c0623g.G(b3.getInt(d7));
                c0623g.d0(b3.getInt(d8));
                c0623g.a0(b3.getInt(d9) != 0);
                c0623g.D(b3.isNull(d10) ? null : b3.getString(d10));
                c0623g.O(b3.isNull(d11) ? null : b3.getString(d11));
                c0623g.W(b3.isNull(d12) ? null : b3.getString(d12));
                c0623g.L(b3.isNull(d13) ? null : b3.getString(d13));
                c0623g.H(b3.getInt(d14));
                c0623g.e0(b3.getInt(d15));
                int i6 = i5;
                if (b3.getInt(i6) != 0) {
                    i3 = d3;
                    z3 = true;
                } else {
                    i3 = d3;
                    z3 = false;
                }
                c0623g.b0(z3);
                int i7 = d17;
                if (b3.isNull(i7)) {
                    i4 = i7;
                    string = null;
                } else {
                    i4 = i7;
                    string = b3.getString(i7);
                }
                c0623g.E(string);
                int i8 = d18;
                if (b3.isNull(i8)) {
                    d18 = i8;
                    string2 = null;
                } else {
                    d18 = i8;
                    string2 = b3.getString(i8);
                }
                c0623g.P(string2);
                int i9 = d19;
                if (b3.isNull(i9)) {
                    d19 = i9;
                    string3 = null;
                } else {
                    d19 = i9;
                    string3 = b3.getString(i9);
                }
                c0623g.X(string3);
                int i10 = d20;
                if (b3.isNull(i10)) {
                    d20 = i10;
                    string4 = null;
                } else {
                    d20 = i10;
                    string4 = b3.getString(i10);
                }
                c0623g.M(string4);
                int i11 = d21;
                c0623g.I(b3.getInt(i11));
                d21 = i11;
                int i12 = d22;
                c0623g.f0(b3.getInt(i12));
                int i13 = d23;
                d23 = i13;
                c0623g.c0(b3.getInt(i13) != 0);
                int i14 = d24;
                if (b3.isNull(i14)) {
                    d24 = i14;
                    string5 = null;
                } else {
                    d24 = i14;
                    string5 = b3.getString(i14);
                }
                c0623g.F(string5);
                int i15 = d25;
                if (b3.isNull(i15)) {
                    d25 = i15;
                    string6 = null;
                } else {
                    d25 = i15;
                    string6 = b3.getString(i15);
                }
                c0623g.Q(string6);
                d22 = i12;
                int i16 = d26;
                c0623g.U(b3.getInt(i16));
                d26 = i16;
                int i17 = d27;
                c0623g.N(b3.getInt(i17));
                d27 = i17;
                int i18 = d28;
                c0623g.T(b3.getInt(i18));
                int i19 = d29;
                if (b3.getInt(i19) != 0) {
                    d28 = i18;
                    z4 = true;
                } else {
                    d28 = i18;
                    z4 = false;
                }
                c0623g.R(z4);
                d29 = i19;
                int i20 = d30;
                c0623g.S(b3.getInt(i20));
                d30 = i20;
                int i21 = d31;
                c0623g.Y(b3.getInt(i21));
                arrayList2.add(c0623g);
                d31 = i21;
                arrayList = arrayList2;
                d3 = i3;
                i5 = i6;
                d17 = i4;
            }
            ArrayList arrayList3 = arrayList;
            b3.close();
            xVar.j();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            b3.close();
            xVar.j();
            throw th;
        }
    }

    @Override // w1.InterfaceC0624h
    public void d(C0623g... c0623gArr) {
        this.f13909a.d();
        this.f13909a.e();
        try {
            this.f13911c.j(c0623gArr);
            this.f13909a.z();
        } finally {
            this.f13909a.i();
        }
    }
}
