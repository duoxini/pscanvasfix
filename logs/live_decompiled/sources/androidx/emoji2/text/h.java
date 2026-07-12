package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.e;
import androidx.emoji2.text.m;
import java.util.Arrays;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final e.i f5257a;

    /* renamed from: b, reason: collision with root package name */
    private final m f5258b;

    /* renamed from: c, reason: collision with root package name */
    private e.d f5259c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5260d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f5261e;

    private static final class a {
        static int a(CharSequence charSequence, int i3, int i4) {
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i4 < 0) {
                return -1;
            }
            while (true) {
                boolean z3 = false;
                while (i4 != 0) {
                    i3--;
                    if (i3 < 0) {
                        return z3 ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i3);
                    if (z3) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i4--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i4--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z3 = true;
                    }
                }
                return i3;
            }
        }

        static int b(CharSequence charSequence, int i3, int i4) {
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i4 < 0) {
                return -1;
            }
            while (true) {
                boolean z3 = false;
                while (i4 != 0) {
                    if (i3 >= length) {
                        if (z3) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i3);
                    if (z3) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i4--;
                        i3++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i4--;
                        i3++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i3++;
                        z3 = true;
                    }
                }
                return i3;
            }
        }
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f5262a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final m.a f5263b;

        /* renamed from: c, reason: collision with root package name */
        private m.a f5264c;

        /* renamed from: d, reason: collision with root package name */
        private m.a f5265d;

        /* renamed from: e, reason: collision with root package name */
        private int f5266e;

        /* renamed from: f, reason: collision with root package name */
        private int f5267f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f5268g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f5269h;

        b(m.a aVar, boolean z3, int[] iArr) {
            this.f5263b = aVar;
            this.f5264c = aVar;
            this.f5268g = z3;
            this.f5269h = iArr;
        }

        private static boolean d(int i3) {
            return i3 == 65039;
        }

        private static boolean f(int i3) {
            return i3 == 65038;
        }

        private int g() {
            this.f5262a = 1;
            this.f5264c = this.f5263b;
            this.f5267f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f5264c.b().j() || d(this.f5266e)) {
                return true;
            }
            if (this.f5268g) {
                if (this.f5269h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f5269h, this.f5264c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i3) {
            m.a a3 = this.f5264c.a(i3);
            int i4 = 2;
            if (this.f5262a != 2) {
                if (a3 == null) {
                    i4 = g();
                } else {
                    this.f5262a = 2;
                    this.f5264c = a3;
                    this.f5267f = 1;
                }
            } else if (a3 != null) {
                this.f5264c = a3;
                this.f5267f++;
            } else if (f(i3)) {
                i4 = g();
            } else if (!d(i3)) {
                if (this.f5264c.b() != null) {
                    i4 = 3;
                    if (this.f5267f != 1) {
                        this.f5265d = this.f5264c;
                        g();
                    } else if (h()) {
                        this.f5265d = this.f5264c;
                        g();
                    } else {
                        i4 = g();
                    }
                } else {
                    i4 = g();
                }
            }
            this.f5266e = i3;
            return i4;
        }

        g b() {
            return this.f5264c.b();
        }

        g c() {
            return this.f5265d.b();
        }

        boolean e() {
            return this.f5262a == 2 && this.f5264c.b() != null && (this.f5267f > 1 || h());
        }
    }

    h(m mVar, e.i iVar, e.d dVar, boolean z3, int[] iArr) {
        this.f5257a = iVar;
        this.f5258b = mVar;
        this.f5259c = dVar;
        this.f5260d = z3;
        this.f5261e = iArr;
    }

    private void a(Spannable spannable, g gVar, int i3, int i4) {
        spannable.setSpan(this.f5257a.a(gVar), i3, i4, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z3) {
        i[] iVarArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z3 && spanStart == selectionStart) || ((!z3 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean c(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z3) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i3 >= 0 && i4 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z3) {
                max = a.a(editable, selectionStart, Math.max(i3, 0));
                min = a.b(editable, selectionEnd, Math.max(i4, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i3, 0);
                min = Math.min(selectionEnd + i4, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(max, min, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean d(Editable editable, int i3, KeyEvent keyEvent) {
        if (!(i3 != 67 ? i3 != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i3, int i4, g gVar) {
        if (gVar.d() == 0) {
            gVar.k(this.f5259c.a(charSequence, i3, i4, gVar.h()));
        }
        return gVar.d() == 2;
    }

    private static boolean f(int i3, int i4) {
        return i3 == -1 || i4 == -1 || i3 != i4;
    }

    private static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:100:0x000e, B:103:0x0013, B:105:0x0017, B:107:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:23:0x0065, B:29:0x0074, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0104, B:81:0x010d, B:6:0x002f), top: B:99:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:100:0x000e, B:103:0x0013, B:105:0x0017, B:107:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:23:0x0065, B:29:0x0074, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0104, B:81:0x010d, B:6:0x002f), top: B:99:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010d A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:100:0x000e, B:103:0x0013, B:105:0x0017, B:107:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:23:0x0065, B:29:0x0074, B:30:0x0080, B:34:0x009b, B:60:0x00ab, B:64:0x00b7, B:65:0x00c1, B:47:0x00cb, B:50:0x00d2, B:37:0x00d7, B:39:0x00e2, B:71:0x00e9, B:75:0x00f3, B:78:0x00ff, B:79:0x0104, B:81:0x010d, B:6:0x002f), top: B:99:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
