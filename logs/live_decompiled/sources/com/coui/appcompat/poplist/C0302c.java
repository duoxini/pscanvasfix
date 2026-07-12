package com.coui.appcompat.poplist;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import com.coui.appcompat.poplist.A;
import com.coui.appcompat.poplist.C0302c;
import java.util.ArrayList;

/* renamed from: com.coui.appcompat.poplist.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0302c {

    /* renamed from: a, reason: collision with root package name */
    private final f f8197a;

    /* renamed from: b, reason: collision with root package name */
    private A f8198b;

    /* renamed from: c, reason: collision with root package name */
    private A.c f8199c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8200d = true;

    /* renamed from: e, reason: collision with root package name */
    private InputMethodManager f8201e;

    /* renamed from: com.coui.appcompat.poplist.c$a */
    class a implements A.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view, int i3, int i4) {
            C0302c.this.l(view, i3, i4);
        }

        @Override // com.coui.appcompat.poplist.A.c
        public void a(final View view, final int i3, final int i4) {
            if (C0302c.this.f8199c != null) {
                C0302c.this.f8199c.a(view, i3, i4);
            }
            if (C0302c.this.f8201e == null || !C0302c.this.f8201e.hideSoftInputFromWindow(view.getWindowToken(), 0)) {
                C0302c.this.l(view, i3, i4);
            } else {
                view.postDelayed(new Runnable() { // from class: com.coui.appcompat.poplist.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0302c.a.this.c(view, i3, i4);
                    }
                }, view.getContext().getResources().getInteger(V1.f.f2567a));
            }
        }
    }

    public C0302c(Context context, View view) {
        f fVar = new f(context);
        this.f8197a = fVar;
        if (view != null) {
            fVar.g0(view);
        }
        this.f8201e = (InputMethodManager) context.getSystemService("input_method");
    }

    public void c() {
        this.f8197a.dismiss();
    }

    public f d() {
        return this.f8197a;
    }

    public void e(View view, ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return;
        }
        this.f8197a.k0(arrayList);
        view.setClickable(true);
        view.setLongClickable(true);
        this.f8197a.g0(view);
        A a3 = this.f8198b;
        if (a3 == null || a3.c() != view) {
            this.f8198b = new A(view, new a());
        } else {
            Log.w("COUIClickSelectMenu", "ItemView is same, no need to create PreciseClickHelper");
        }
    }

    public void f(View view, ArrayList arrayList, int i3) {
        e(view, arrayList);
        this.f8197a.q0(i3);
    }

    public void g(boolean z3) {
        f fVar;
        if (!this.f8200d || (fVar = this.f8197a) == null) {
            return;
        }
        fVar.i0(z3);
    }

    public void h(boolean z3) {
        A a3 = this.f8198b;
        if (a3 != null) {
            this.f8200d = z3;
            if (z3) {
                a3.d();
            } else {
                a3.e();
            }
        }
    }

    public void i(int i3) {
        f fVar = this.f8197a;
        if (fVar != null) {
            fVar.n0(i3);
        }
    }

    public void j(AdapterView.OnItemClickListener onItemClickListener) {
        this.f8197a.p0(onItemClickListener);
    }

    public void k(A.c cVar) {
        this.f8199c = cVar;
    }

    public void l(View view, int i3, int i4) {
        if (this.f8200d) {
            this.f8197a.u0(view, i3, i4);
        }
    }
}
