package androidx.recyclerview.widget;

import android.view.View;
import com.customer.feedback.sdk.activity.FeedbackActivity;

/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    final b f6619a;

    /* renamed from: b, reason: collision with root package name */
    a f6620b = new a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f6621a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f6622b;

        /* renamed from: c, reason: collision with root package name */
        int f6623c;

        /* renamed from: d, reason: collision with root package name */
        int f6624d;

        /* renamed from: e, reason: collision with root package name */
        int f6625e;

        a() {
        }

        void a(int i3) {
            this.f6621a = i3 | this.f6621a;
        }

        boolean b() {
            int i3 = this.f6621a;
            if ((i3 & 7) != 0 && (i3 & c(this.f6624d, this.f6622b)) == 0) {
                return false;
            }
            int i4 = this.f6621a;
            if ((i4 & FeedbackActivity.SHOW_NO_NETWORK) != 0 && (i4 & (c(this.f6624d, this.f6623c) << 4)) == 0) {
                return false;
            }
            int i5 = this.f6621a;
            if ((i5 & 1792) != 0 && (i5 & (c(this.f6625e, this.f6622b) << 8)) == 0) {
                return false;
            }
            int i6 = this.f6621a;
            return (i6 & 28672) == 0 || ((c(this.f6625e, this.f6623c) << 12) & i6) != 0;
        }

        int c(int i3, int i4) {
            if (i3 > i4) {
                return 1;
            }
            return i3 == i4 ? 2 : 4;
        }

        void d() {
            this.f6621a = 0;
        }

        void e(int i3, int i4, int i5, int i6) {
            this.f6622b = i3;
            this.f6623c = i4;
            this.f6624d = i5;
            this.f6625e = i6;
        }
    }

    interface b {
        View a(int i3);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    q(b bVar) {
        this.f6619a = bVar;
    }

    View a(int i3, int i4, int i5, int i6) {
        int c3 = this.f6619a.c();
        int b3 = this.f6619a.b();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i4) {
            View a3 = this.f6619a.a(i3);
            this.f6620b.e(c3, b3, this.f6619a.e(a3), this.f6619a.d(a3));
            if (i5 != 0) {
                this.f6620b.d();
                this.f6620b.a(i5);
                if (this.f6620b.b()) {
                    return a3;
                }
            }
            if (i6 != 0) {
                this.f6620b.d();
                this.f6620b.a(i6);
                if (this.f6620b.b()) {
                    view = a3;
                }
            }
            i3 += i7;
        }
        return view;
    }

    boolean b(View view, int i3) {
        this.f6620b.e(this.f6619a.c(), this.f6619a.b(), this.f6619a.e(view), this.f6619a.d(view));
        if (i3 == 0) {
            return false;
        }
        this.f6620b.d();
        this.f6620b.a(i3);
        return this.f6620b.b();
    }
}
