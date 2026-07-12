package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.l;
import androidx.fragment.app.t;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0263a extends t implements l.m {

    /* renamed from: t, reason: collision with root package name */
    final l f5354t;

    /* renamed from: u, reason: collision with root package name */
    boolean f5355u;

    /* renamed from: v, reason: collision with root package name */
    int f5356v;

    C0263a(l lVar) {
        super(lVar.p0(), lVar.s0() != null ? lVar.s0().f().getClassLoader() : null);
        this.f5356v = -1;
        this.f5354t = lVar;
    }

    private static boolean F(t.a aVar) {
        Fragment fragment = aVar.f5574b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    void A(boolean z3) {
        for (int size = this.f5556c.size() - 1; size >= 0; size--) {
            t.a aVar = (t.a) this.f5556c.get(size);
            Fragment fragment = aVar.f5574b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(l.g1(this.f5561h));
                fragment.setSharedElementNames(this.f5570q, this.f5569p);
            }
            switch (aVar.f5573a) {
                case 1:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.j1(fragment, true);
                    this.f5354t.b1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5573a);
                case 3:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.n1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.j1(fragment, true);
                    this.f5354t.B0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.l(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.j1(fragment, true);
                    this.f5354t.x(fragment);
                    break;
                case 8:
                    this.f5354t.l1(null);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    this.f5354t.l1(fragment);
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    this.f5354t.k1(fragment, aVar.f5579g);
                    break;
            }
            if (!this.f5571r && aVar.f5573a != 3 && fragment != null && !l.f5450P) {
                this.f5354t.O0(fragment);
            }
        }
        if (this.f5571r || !z3 || l.f5450P) {
            return;
        }
        l lVar = this.f5354t;
        lVar.P0(lVar.f5481q, true);
    }

    Fragment B(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i3 = 0;
        while (i3 < this.f5556c.size()) {
            t.a aVar = (t.a) this.f5556c.get(i3);
            int i4 = aVar.f5573a;
            if (i4 != 1) {
                if (i4 == 2) {
                    Fragment fragment3 = aVar.f5574b;
                    int i5 = fragment3.mContainerId;
                    boolean z3 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = (Fragment) arrayList.get(size);
                        if (fragment4.mContainerId == i5) {
                            if (fragment4 == fragment3) {
                                z3 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f5556c.add(i3, new t.a(9, fragment4));
                                    i3++;
                                    fragment2 = null;
                                }
                                t.a aVar2 = new t.a(3, fragment4);
                                aVar2.f5575c = aVar.f5575c;
                                aVar2.f5577e = aVar.f5577e;
                                aVar2.f5576d = aVar.f5576d;
                                aVar2.f5578f = aVar.f5578f;
                                this.f5556c.add(i3, aVar2);
                                arrayList.remove(fragment4);
                                i3++;
                            }
                        }
                    }
                    if (z3) {
                        this.f5556c.remove(i3);
                        i3--;
                    } else {
                        aVar.f5573a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i4 == 3 || i4 == 6) {
                    arrayList.remove(aVar.f5574b);
                    Fragment fragment5 = aVar.f5574b;
                    if (fragment5 == fragment2) {
                        this.f5556c.add(i3, new t.a(9, fragment5));
                        i3++;
                        fragment2 = null;
                    }
                } else if (i4 != 7) {
                    if (i4 == 8) {
                        this.f5556c.add(i3, new t.a(9, fragment2));
                        i3++;
                        fragment2 = aVar.f5574b;
                    }
                }
                i3++;
            }
            arrayList.add(aVar.f5574b);
            i3++;
        }
        return fragment2;
    }

    public String C() {
        return this.f5564k;
    }

    boolean D(int i3) {
        int size = this.f5556c.size();
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = ((t.a) this.f5556c.get(i4)).f5574b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 == i3) {
                return true;
            }
        }
        return false;
    }

    boolean E(ArrayList arrayList, int i3, int i4) {
        if (i4 == i3) {
            return false;
        }
        int size = this.f5556c.size();
        int i5 = -1;
        for (int i6 = 0; i6 < size; i6++) {
            Fragment fragment = ((t.a) this.f5556c.get(i6)).f5574b;
            int i7 = fragment != null ? fragment.mContainerId : 0;
            if (i7 != 0 && i7 != i5) {
                for (int i8 = i3; i8 < i4; i8++) {
                    C0263a c0263a = (C0263a) arrayList.get(i8);
                    int size2 = c0263a.f5556c.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        Fragment fragment2 = ((t.a) c0263a.f5556c.get(i9)).f5574b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i7) {
                            return true;
                        }
                    }
                }
                i5 = i7;
            }
        }
        return false;
    }

    boolean G() {
        for (int i3 = 0; i3 < this.f5556c.size(); i3++) {
            if (F((t.a) this.f5556c.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public void H() {
        if (this.f5572s != null) {
            for (int i3 = 0; i3 < this.f5572s.size(); i3++) {
                ((Runnable) this.f5572s.get(i3)).run();
            }
            this.f5572s = null;
        }
    }

    void I(Fragment.l lVar) {
        for (int i3 = 0; i3 < this.f5556c.size(); i3++) {
            t.a aVar = (t.a) this.f5556c.get(i3);
            if (F(aVar)) {
                aVar.f5574b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }

    Fragment J(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f5556c.size() - 1; size >= 0; size--) {
            t.a aVar = (t.a) this.f5556c.get(size);
            int i3 = aVar.f5573a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 8:
                            fragment = null;
                            break;
                        case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                            fragment = aVar.f5574b;
                            break;
                        case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                            aVar.f5580h = aVar.f5579g;
                            break;
                    }
                }
                arrayList.add(aVar.f5574b);
            }
            arrayList.remove(aVar.f5574b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.l.m
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (l.E0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f5562i) {
            return true;
        }
        this.f5354t.e(this);
        return true;
    }

    @Override // androidx.fragment.app.t
    public int h() {
        return w(false);
    }

    @Override // androidx.fragment.app.t
    public int i() {
        return w(true);
    }

    @Override // androidx.fragment.app.t
    public void j() {
        l();
        this.f5354t.b0(this, false);
    }

    @Override // androidx.fragment.app.t
    public void k() {
        l();
        this.f5354t.b0(this, true);
    }

    @Override // androidx.fragment.app.t
    void m(int i3, Fragment fragment, String str, int i4) {
        super.m(i3, fragment, str, i4);
        fragment.mFragmentManager = this.f5354t;
    }

    @Override // androidx.fragment.app.t
    public t n(Fragment fragment) {
        l lVar = fragment.mFragmentManager;
        if (lVar == null || lVar == this.f5354t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.t
    public t o(Fragment fragment) {
        l lVar = fragment.mFragmentManager;
        if (lVar == null || lVar == this.f5354t) {
            return super.o(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f5356v >= 0) {
            sb.append(" #");
            sb.append(this.f5356v);
        }
        if (this.f5564k != null) {
            sb.append(" ");
            sb.append(this.f5564k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.t
    public t u(Fragment fragment) {
        l lVar = fragment.mFragmentManager;
        if (lVar == null || lVar == this.f5354t) {
            return super.u(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void v(int i3) {
        if (this.f5562i) {
            if (l.E0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            int size = this.f5556c.size();
            for (int i4 = 0; i4 < size; i4++) {
                t.a aVar = (t.a) this.f5556c.get(i4);
                Fragment fragment = aVar.f5574b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i3;
                    if (l.E0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f5574b + " to " + aVar.f5574b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int w(boolean z3) {
        if (this.f5355u) {
            throw new IllegalStateException("commit already called");
        }
        if (l.E0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new y("FragmentManager"));
            x("  ", printWriter);
            printWriter.close();
        }
        this.f5355u = true;
        if (this.f5562i) {
            this.f5356v = this.f5354t.j();
        } else {
            this.f5356v = -1;
        }
        this.f5354t.Y(this, z3);
        return this.f5356v;
    }

    public void x(String str, PrintWriter printWriter) {
        y(str, printWriter, true);
    }

    public void y(String str, PrintWriter printWriter, boolean z3) {
        String str2;
        if (z3) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f5564k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f5356v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f5355u);
            if (this.f5561h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f5561h));
            }
            if (this.f5557d != 0 || this.f5558e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5557d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5558e));
            }
            if (this.f5559f != 0 || this.f5560g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5559f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5560g));
            }
            if (this.f5565l != 0 || this.f5566m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5565l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f5566m);
            }
            if (this.f5567n != 0 || this.f5568o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5567n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f5568o);
            }
        }
        if (this.f5556c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f5556c.size();
        for (int i3 = 0; i3 < size; i3++) {
            t.a aVar = (t.a) this.f5556c.get(i3);
            switch (aVar.f5573a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f5573a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f5574b);
            if (z3) {
                if (aVar.f5575c != 0 || aVar.f5576d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f5575c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f5576d));
                }
                if (aVar.f5577e != 0 || aVar.f5578f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f5577e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f5578f));
                }
            }
        }
    }

    void z() {
        int size = this.f5556c.size();
        for (int i3 = 0; i3 < size; i3++) {
            t.a aVar = (t.a) this.f5556c.get(i3);
            Fragment fragment = aVar.f5574b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f5561h);
                fragment.setSharedElementNames(this.f5569p, this.f5570q);
            }
            switch (aVar.f5573a) {
                case 1:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.j1(fragment, false);
                    this.f5354t.g(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5573a);
                case 3:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.b1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.B0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.j1(fragment, false);
                    this.f5354t.n1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.x(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f5575c, aVar.f5576d, aVar.f5577e, aVar.f5578f);
                    this.f5354t.j1(fragment, false);
                    this.f5354t.l(fragment);
                    break;
                case 8:
                    this.f5354t.l1(fragment);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    this.f5354t.l1(null);
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    this.f5354t.k1(fragment, aVar.f5580h);
                    break;
            }
            if (!this.f5571r && aVar.f5573a != 1 && fragment != null && !l.f5450P) {
                this.f5354t.O0(fragment);
            }
        }
        if (this.f5571r || l.f5450P) {
            return;
        }
        l lVar = this.f5354t;
        lVar.P0(lVar.f5481q, true);
    }
}
