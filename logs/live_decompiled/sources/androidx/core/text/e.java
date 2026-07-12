package androidx.core.text;

import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.core.text.d f4999a = new C0069e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.core.text.d f5000b = new C0069e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.core.text.d f5001c;

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.core.text.d f5002d;

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.core.text.d f5003e;

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.core.text.d f5004f;

    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f5005b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f5006a;

        private a(boolean z3) {
            this.f5006a = z3;
        }

        @Override // androidx.core.text.e.c
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            boolean z3 = false;
            while (i3 < i5) {
                int a3 = e.a(Character.getDirectionality(charSequence.charAt(i3)));
                if (a3 != 0) {
                    if (a3 != 1) {
                        continue;
                        i3++;
                        z3 = z3;
                    } else if (!this.f5006a) {
                        return 1;
                    }
                } else if (this.f5006a) {
                    return 0;
                }
                z3 = true;
                i3++;
                z3 = z3;
            }
            if (z3) {
                return this.f5006a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f5007a = new b();

        private b() {
        }

        @Override // androidx.core.text.e.c
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            int i6 = 2;
            while (i3 < i5 && i6 == 2) {
                i6 = e.b(Character.getDirectionality(charSequence.charAt(i3)));
                i3++;
            }
            return i6;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i3, int i4);
    }

    private static abstract class d implements androidx.core.text.d {

        /* renamed from: a, reason: collision with root package name */
        private final c f5008a;

        d(c cVar) {
            this.f5008a = cVar;
        }

        private boolean c(CharSequence charSequence, int i3, int i4) {
            int a3 = this.f5008a.a(charSequence, i3, i4);
            if (a3 == 0) {
                return true;
            }
            if (a3 != 1) {
                return b();
            }
            return false;
        }

        @Override // androidx.core.text.d
        public boolean a(CharSequence charSequence, int i3, int i4) {
            if (charSequence == null || i3 < 0 || i4 < 0 || charSequence.length() - i4 < i3) {
                throw new IllegalArgumentException();
            }
            return this.f5008a == null ? b() : c(charSequence, i3, i4);
        }

        protected abstract boolean b();
    }

    /* renamed from: androidx.core.text.e$e, reason: collision with other inner class name */
    private static class C0069e extends d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f5009b;

        C0069e(c cVar, boolean z3) {
            super(cVar);
            this.f5009b = z3;
        }

        @Override // androidx.core.text.e.d
        protected boolean b() {
            return this.f5009b;
        }
    }

    private static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        static final f f5010b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.text.e.d
        protected boolean b() {
            return androidx.core.text.f.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f5007a;
        f5001c = new C0069e(bVar, false);
        f5002d = new C0069e(bVar, true);
        f5003e = new C0069e(a.f5005b, false);
        f5004f = f.f5010b;
    }

    static int a(int i3) {
        if (i3 != 0) {
            return (i3 == 1 || i3 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i3) {
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                return 0;
            }
            switch (i3) {
                case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                case COUIViewDragHelper.EDGE_ALL /* 15 */:
                    break;
                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
