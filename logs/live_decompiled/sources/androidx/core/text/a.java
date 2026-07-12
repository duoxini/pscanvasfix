package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final d f4977d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f4978e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f4979f;

    /* renamed from: g, reason: collision with root package name */
    static final a f4980g;

    /* renamed from: h, reason: collision with root package name */
    static final a f4981h;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4982a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4983b;

    /* renamed from: c, reason: collision with root package name */
    private final d f4984c;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    public static final class C0068a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4985a;

        /* renamed from: b, reason: collision with root package name */
        private int f4986b;

        /* renamed from: c, reason: collision with root package name */
        private d f4987c;

        public C0068a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z3) {
            return z3 ? a.f4981h : a.f4980g;
        }

        private void c(boolean z3) {
            this.f4985a = z3;
            this.f4987c = a.f4977d;
            this.f4986b = 2;
        }

        public a a() {
            return (this.f4986b == 2 && this.f4987c == a.f4977d) ? b(this.f4985a) : new a(this.f4985a, this.f4986b, this.f4987c);
        }
    }

    private static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f4988f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f4989a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f4990b;

        /* renamed from: c, reason: collision with root package name */
        private final int f4991c;

        /* renamed from: d, reason: collision with root package name */
        private int f4992d;

        /* renamed from: e, reason: collision with root package name */
        private char f4993e;

        static {
            for (int i3 = 0; i3 < 1792; i3++) {
                f4988f[i3] = Character.getDirectionality(i3);
            }
        }

        b(CharSequence charSequence, boolean z3) {
            this.f4989a = charSequence;
            this.f4990b = z3;
            this.f4991c = charSequence.length();
        }

        private static byte c(char c3) {
            return c3 < 1792 ? f4988f[c3] : Character.getDirectionality(c3);
        }

        private byte f() {
            char charAt;
            int i3 = this.f4992d;
            do {
                int i4 = this.f4992d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4989a;
                int i5 = i4 - 1;
                this.f4992d = i5;
                charAt = charSequence.charAt(i5);
                this.f4993e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f4992d = i3;
            this.f4993e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i3 = this.f4992d;
                if (i3 >= this.f4991c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f4989a;
                this.f4992d = i3 + 1;
                charAt = charSequence.charAt(i3);
                this.f4993e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i3 = this.f4992d;
            while (true) {
                int i4 = this.f4992d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f4989a;
                int i5 = i4 - 1;
                this.f4992d = i5;
                char charAt2 = charSequence.charAt(i5);
                this.f4993e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i6 = this.f4992d;
                        if (i6 > 0) {
                            CharSequence charSequence2 = this.f4989a;
                            int i7 = i6 - 1;
                            this.f4992d = i7;
                            charAt = charSequence2.charAt(i7);
                            this.f4993e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f4992d = i3;
            this.f4993e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i3 = this.f4992d;
            while (true) {
                int i4 = this.f4992d;
                if (i4 >= this.f4991c) {
                    this.f4992d = i3;
                    this.f4993e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f4989a;
                this.f4992d = i4 + 1;
                char charAt2 = charSequence.charAt(i4);
                this.f4993e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i5 = this.f4992d;
                        if (i5 < this.f4991c) {
                            CharSequence charSequence2 = this.f4989a;
                            this.f4992d = i5 + 1;
                            charAt = charSequence2.charAt(i5);
                            this.f4993e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte a() {
            char charAt = this.f4989a.charAt(this.f4992d - 1);
            this.f4993e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f4989a, this.f4992d);
                this.f4992d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f4992d--;
            byte c3 = c(this.f4993e);
            if (!this.f4990b) {
                return c3;
            }
            char c4 = this.f4993e;
            return c4 == '>' ? h() : c4 == ';' ? f() : c3;
        }

        byte b() {
            char charAt = this.f4989a.charAt(this.f4992d);
            this.f4993e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f4989a, this.f4992d);
                this.f4992d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f4992d++;
            byte c3 = c(this.f4993e);
            if (!this.f4990b) {
                return c3;
            }
            char c4 = this.f4993e;
            return c4 == '<' ? i() : c4 == '&' ? g() : c3;
        }

        int d() {
            this.f4992d = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (this.f4992d < this.f4991c && i3 == 0) {
                byte b3 = b();
                if (b3 != 0) {
                    if (b3 == 1 || b3 == 2) {
                        if (i5 == 0) {
                            return 1;
                        }
                    } else if (b3 != 9) {
                        switch (b3) {
                            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                                i5++;
                                i4 = -1;
                                continue;
                            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                            case 17:
                                i5++;
                                i4 = 1;
                                continue;
                            case 18:
                                i5--;
                                i4 = 0;
                                continue;
                        }
                    }
                } else if (i5 == 0) {
                    return -1;
                }
                i3 = i5;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i4 != 0) {
                return i4;
            }
            while (this.f4992d > 0) {
                switch (a()) {
                    case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                    case COUIViewDragHelper.EDGE_ALL /* 15 */:
                        if (i3 == i5) {
                            return -1;
                        }
                        break;
                    case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                    case 17:
                        if (i3 == i5) {
                            return 1;
                        }
                        break;
                    case 18:
                        i5++;
                        continue;
                }
                i5--;
            }
            return 0;
        }

        int e() {
            this.f4992d = this.f4991c;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                while (this.f4992d > 0) {
                    byte a3 = a();
                    if (a3 != 0) {
                        if (a3 == 1 || a3 == 2) {
                            if (i3 == 0) {
                                return 1;
                            }
                            if (i4 == 0) {
                                break;
                            }
                        } else if (a3 != 9) {
                            switch (a3) {
                                case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                                case COUIViewDragHelper.EDGE_ALL /* 15 */:
                                    if (i4 == i3) {
                                        return -1;
                                    }
                                    i3--;
                                    break;
                                case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                                case 17:
                                    if (i4 == i3) {
                                        return 1;
                                    }
                                    i3--;
                                    break;
                                case 18:
                                    i3++;
                                    break;
                                default:
                                    if (i4 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i3 == 0) {
                            return -1;
                        }
                        if (i4 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        d dVar = e.f5001c;
        f4977d = dVar;
        f4978e = Character.toString((char) 8206);
        f4979f = Character.toString((char) 8207);
        f4980g = new a(false, 2, dVar);
        f4981h = new a(true, 2, dVar);
    }

    a(boolean z3, int i3, d dVar) {
        this.f4982a = z3;
        this.f4983b = i3;
        this.f4984c = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0068a().a();
    }

    static boolean e(Locale locale) {
        return f.a(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean a3 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f4982a || !(a3 || b(charSequence) == 1)) ? this.f4982a ? (!a3 || b(charSequence) == -1) ? f4979f : "" : "" : f4978e;
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean a3 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f4982a || !(a3 || a(charSequence) == 1)) ? this.f4982a ? (!a3 || a(charSequence) == -1) ? f4979f : "" : "" : f4978e;
    }

    public boolean d() {
        return (this.f4983b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f4984c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z3) {
        if (charSequence == null) {
            return null;
        }
        boolean a3 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z3) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a3 ? e.f5000b : e.f4999a));
        }
        if (a3 != this.f4982a) {
            spannableStringBuilder.append(a3 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z3) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a3 ? e.f5000b : e.f4999a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f4984c, true);
    }

    public String k(String str, d dVar, boolean z3) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z3).toString();
    }
}
