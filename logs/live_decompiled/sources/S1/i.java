package s1;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Iterator;
import m.C0452b;
import p1.AbstractC0496a;
import p1.AbstractC0497b;
import p1.C0500e;
import q1.C0516a;
import q1.C0517b;
import r1.C0567b;
import r1.C0568c;
import s1.C0578e;

/* loaded from: classes.dex */
public class i implements C0578e.a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13312a;

    /* renamed from: g, reason: collision with root package name */
    private HashMap f13318g;

    /* renamed from: h, reason: collision with root package name */
    private HashMap f13319h;

    /* renamed from: j, reason: collision with root package name */
    private C0517b f13321j;

    /* renamed from: k, reason: collision with root package name */
    private C0516a f13322k;

    /* renamed from: b, reason: collision with root package name */
    private final C0452b f13313b = new C0452b(1);

    /* renamed from: c, reason: collision with root package name */
    private final C0452b f13314c = new C0452b(1);

    /* renamed from: d, reason: collision with root package name */
    private boolean f13315d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f13316e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13317f = false;

    /* renamed from: i, reason: collision with root package name */
    private C0578e f13320i = null;

    private i(Context context) {
        this.f13312a = context;
        o();
    }

    private C0516a d(k kVar, int i3) {
        C0516a f3 = f(this.f13321j.f().d(AbstractC0496a.c(kVar.f13331e.f12799a), AbstractC0496a.c(kVar.f13331e.f12800b)), 1, i3, AbstractC0496a.c(kVar.f13327a), AbstractC0496a.c(kVar.f13328b), i(i3));
        f3.f13006e.f();
        f3.k(true);
        return f3;
    }

    public static i e(Context context) {
        return new i(context);
    }

    private void h() {
        this.f13321j = new C0517b();
        this.f13322k = f(new C0500e(), 0, 5, 0.0f, 0.0f, "Ground");
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("createWorld : " + this);
        }
    }

    private static String i(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "custom" : "alpha" : "rotation" : "scale" : "position";
    }

    private void o() {
        C0578e c0578e = new C0578e();
        this.f13320i = c0578e;
        c0578e.e(this);
        p();
        h();
    }

    private void p() {
        AbstractC0496a.d(this.f13312a.getResources().getDisplayMetrics().density);
        Display defaultDisplay = ((WindowManager) this.f13312a.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            AbstractC0496a.e(1.0f / defaultDisplay.getRefreshRate());
        }
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("initConfig : sPhysicalSizeToPixelsRatio =:" + AbstractC0496a.f12794c + ",sSteadyAccuracy =:" + AbstractC0496a.f12793b + ",sRefreshRate =:" + AbstractC0496a.f12792a);
        }
    }

    private void q(AbstractC0576c abstractC0576c) {
        InterfaceC0574a interfaceC0574a;
        HashMap hashMap = this.f13318g;
        if (hashMap == null || (interfaceC0574a = (InterfaceC0574a) hashMap.get(abstractC0576c)) == null) {
            return;
        }
        interfaceC0574a.onAnimationEnd(abstractC0576c);
    }

    private void r(AbstractC0576c abstractC0576c) {
        InterfaceC0574a interfaceC0574a;
        HashMap hashMap = this.f13318g;
        if (hashMap == null || (interfaceC0574a = (InterfaceC0574a) hashMap.get(abstractC0576c)) == null) {
            return;
        }
        interfaceC0574a.onAnimationStart(abstractC0576c);
    }

    private void s(AbstractC0576c abstractC0576c) {
        InterfaceC0575b interfaceC0575b;
        HashMap hashMap = this.f13319h;
        if (hashMap == null || (interfaceC0575b = (InterfaceC0575b) hashMap.get(abstractC0576c)) == null) {
            return;
        }
        interfaceC0575b.onAnimationUpdate(abstractC0576c);
    }

    private void t() {
        if (this.f13316e) {
            this.f13320i.f();
            this.f13316e = false;
        }
    }

    private void v() {
        if (this.f13316e) {
            return;
        }
        this.f13320i.d();
        this.f13316e = true;
    }

    private void x() {
        this.f13321j.i(AbstractC0496a.f12792a);
        z();
    }

    private void z() {
        if (AbstractC0497b.a()) {
            AbstractC0497b.d("PhysicsWorld-Frame", "syncMoverChanging start ===========> mCurrentRunningBehaviors =:" + this.f13313b.size());
        }
        Iterator it = this.f13313b.iterator();
        while (it.hasNext()) {
            AbstractC0576c abstractC0576c = (AbstractC0576c) it.next();
            if (abstractC0576c != null) {
                abstractC0576c.m();
                A(abstractC0576c);
                s(abstractC0576c);
                if (AbstractC0497b.a()) {
                    AbstractC0497b.d("PhysicsWorld-Frame", "updateBehavior : " + abstractC0576c);
                }
                if (abstractC0576c.r()) {
                    if (AbstractC0497b.b()) {
                        AbstractC0497b.c("syncMoverChanging : behavior is steady");
                    }
                    abstractC0576c.z();
                }
            }
        }
        this.f13315d = this.f13313b.isEmpty();
        if (AbstractC0497b.a()) {
            AbstractC0497b.d("PhysicsWorld-Frame", "syncMoverChanging end ===========> mCurrentRunningBehaviors =:" + this.f13313b.size());
        }
        if (this.f13315d) {
            t();
        } else {
            this.f13320i.d();
        }
    }

    void A(AbstractC0576c abstractC0576c) {
        abstractC0576c.B();
    }

    public void a(AbstractC0576c abstractC0576c, InterfaceC0574a interfaceC0574a) {
        if (this.f13318g == null) {
            this.f13318g = new HashMap(1);
        }
        this.f13318g.put(abstractC0576c, interfaceC0574a);
    }

    public void b(AbstractC0576c abstractC0576c, InterfaceC0575b interfaceC0575b) {
        if (this.f13319h == null) {
            this.f13319h = new HashMap(1);
        }
        this.f13319h.put(abstractC0576c, interfaceC0575b);
    }

    public AbstractC0576c c(AbstractC0576c abstractC0576c) {
        Object obj;
        Object obj2;
        abstractC0576c.c(this);
        int i3 = 0;
        while (i3 < this.f13314c.size()) {
            AbstractC0576c abstractC0576c2 = (AbstractC0576c) this.f13314c.h(i3);
            if (abstractC0576c2 != null && (obj = abstractC0576c2.f13295n) != null && (obj2 = abstractC0576c.f13295n) != null && obj == obj2 && abstractC0576c2.q() == abstractC0576c.q() && u(abstractC0576c2)) {
                i3--;
            }
            i3++;
        }
        this.f13314c.add(abstractC0576c);
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("addBehavior behavior =:" + abstractC0576c + ",mAllBehaviors.size =:" + this.f13314c.size());
        }
        return abstractC0576c;
    }

    @Override // s1.C0578e.a
    public void doFrame(long j3) {
        if (this.f13317f) {
            return;
        }
        x();
    }

    C0516a f(C0500e c0500e, int i3, int i4, float f3, float f4, String str) {
        return this.f13321j.a(c0500e, i3, i4, f3, f4, str);
    }

    C0567b g(C0568c c0568c) {
        return this.f13321j.b(c0568c);
    }

    boolean j(C0516a c0516a) {
        if (c0516a == null) {
            return false;
        }
        this.f13321j.c(c0516a);
        return true;
    }

    boolean k(C0567b c0567b) {
        this.f13321j.d(c0567b);
        return true;
    }

    C0516a l() {
        return this.f13322k;
    }

    C0516a m(k kVar, int i3) {
        C0516a c0516a;
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("getOrCreatePropertyBody : uiItem =:" + kVar + ",propertyType =:" + i3);
        }
        Iterator it = this.f13314c.iterator();
        while (it.hasNext()) {
            AbstractC0576c abstractC0576c = (AbstractC0576c) it.next();
            k kVar2 = abstractC0576c.f13291j;
            if (kVar2 != null && kVar2 == kVar && (c0516a = abstractC0576c.f13292k) != null && c0516a.f() == i3) {
                return abstractC0576c.f13292k;
            }
        }
        return d(kVar, i3);
    }

    k n(Object obj) {
        Object obj2;
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("getOrCreateUIItem : target =:" + obj);
        }
        Iterator it = this.f13314c.iterator();
        while (it.hasNext()) {
            k kVar = ((AbstractC0576c) it.next()).f13291j;
            if (kVar != null && (obj2 = kVar.f13329c) != null && obj != null && obj2 == obj) {
                return kVar;
            }
        }
        if (!(obj instanceof View)) {
            return obj instanceof k ? (k) obj : new k().b(0.0f, 0.0f);
        }
        View view = (View) obj;
        k b3 = new k(obj).b(view.getMeasuredWidth(), view.getMeasuredHeight());
        b3.c(view.getX(), view.getY());
        b3.d(view.getScaleX(), view.getScaleY());
        return b3;
    }

    public boolean u(AbstractC0576c abstractC0576c) {
        if (abstractC0576c == null) {
            return false;
        }
        boolean remove = this.f13314c.remove(abstractC0576c);
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("removeBehavior behavior =:" + abstractC0576c + ",removed =:" + remove);
        }
        if (remove) {
            abstractC0576c.w();
        }
        return remove;
    }

    void w(AbstractC0576c abstractC0576c) {
        Object obj;
        Object obj2;
        C0516a c0516a;
        C0516a c0516a2;
        if (this.f13317f) {
            return;
        }
        if (this.f13313b.contains(abstractC0576c) && this.f13316e) {
            return;
        }
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("startBehavior behavior =:" + abstractC0576c);
        }
        int i3 = 0;
        while (i3 < this.f13313b.size()) {
            AbstractC0576c abstractC0576c2 = (AbstractC0576c) this.f13313b.h(i3);
            if (abstractC0576c2 != null && (obj = abstractC0576c2.f13295n) != null && (obj2 = abstractC0576c.f13295n) != null && obj == obj2 && (c0516a = abstractC0576c2.f13292k) != null && (c0516a2 = abstractC0576c.f13292k) != null && c0516a == c0516a2 && abstractC0576c2.z()) {
                i3--;
            }
            i3++;
        }
        this.f13313b.add(abstractC0576c);
        this.f13315d = false;
        v();
        r(abstractC0576c);
    }

    void y(AbstractC0576c abstractC0576c) {
        this.f13313b.remove(abstractC0576c);
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("stopBehavior behavior =:" + abstractC0576c + ",mCurrentRunningBehaviors.size() =:" + this.f13313b.size());
        }
        q(abstractC0576c);
    }
}
