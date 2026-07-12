package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
class p implements Spannable {

    /* renamed from: e, reason: collision with root package name */
    private boolean f5301e = false;

    /* renamed from: f, reason: collision with root package name */
    private Spannable f5302f;

    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        abstract boolean a(CharSequence charSequence);
    }

    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.p.b
        boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedText;
        }
    }

    p(Spannable spannable) {
        this.f5302f = spannable;
    }

    private void a() {
        Spannable spannable = this.f5302f;
        if (!this.f5301e && c().a(spannable)) {
            this.f5302f = new SpannableString(spannable);
        }
        this.f5301e = true;
    }

    static b c() {
        return new c();
    }

    Spannable b() {
        return this.f5302f;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.f5302f.charAt(i3);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f5302f);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f5302f);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f5302f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f5302f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f5302f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        return this.f5302f.getSpans(i3, i4, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f5302f.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        return this.f5302f.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f5302f.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        a();
        this.f5302f.setSpan(obj, i3, i4, i5);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return this.f5302f.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f5302f.toString();
    }

    p(CharSequence charSequence) {
        this.f5302f = new SpannableString(charSequence);
    }
}
