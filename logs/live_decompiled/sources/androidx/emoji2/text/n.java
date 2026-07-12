package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class n extends SpannableStringBuilder {

    /* renamed from: e, reason: collision with root package name */
    private final Class f5296e;

    /* renamed from: f, reason: collision with root package name */
    private final List f5297f;

    private static class a implements TextWatcher, SpanWatcher {

        /* renamed from: e, reason: collision with root package name */
        final Object f5298e;

        /* renamed from: f, reason: collision with root package name */
        private final AtomicInteger f5299f = new AtomicInteger(0);

        a(Object obj) {
            this.f5298e = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof i;
        }

        final void a() {
            this.f5299f.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f5298e).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            ((TextWatcher) this.f5298e).beforeTextChanged(charSequence, i3, i4, i5);
        }

        final void c() {
            this.f5299f.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i3, int i4) {
            if (this.f5299f.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f5298e).onSpanAdded(spannable, obj, i3, i4);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i3, int i4, int i5, int i6) {
            if (this.f5299f.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f5298e).onSpanChanged(spannable, obj, i3, i4, i5, i6);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i3, int i4) {
            if (this.f5299f.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f5298e).onSpanRemoved(spannable, obj, i3, i4);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            ((TextWatcher) this.f5298e).onTextChanged(charSequence, i3, i4, i5);
        }
    }

    n(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f5297f = new ArrayList();
        androidx.core.util.h.e(cls, "watcherClass cannot be null");
        this.f5296e = cls;
    }

    private void b() {
        for (int i3 = 0; i3 < this.f5297f.size(); i3++) {
            ((a) this.f5297f.get(i3)).a();
        }
    }

    public static n c(Class cls, CharSequence charSequence) {
        return new n(cls, charSequence);
    }

    private void e() {
        for (int i3 = 0; i3 < this.f5297f.size(); i3++) {
            ((a) this.f5297f.get(i3)).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i3 = 0; i3 < this.f5297f.size(); i3++) {
            a aVar = (a) this.f5297f.get(i3);
            if (aVar.f5298e == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(Class cls) {
        return this.f5296e == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i3 = 0; i3 < this.f5297f.size(); i3++) {
            ((a) this.f5297f.get(i3)).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a f3;
        if (h(obj) && (f3 = f(obj)) != null) {
            obj = f3;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a f3;
        if (h(obj) && (f3 = f(obj)) != null) {
            obj = f3;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a f3;
        if (h(obj) && (f3 = f(obj)) != null) {
            obj = f3;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i3, i4, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i3, i4, a.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, aVarArr.length);
        for (int i5 = 0; i5 < aVarArr.length; i5++) {
            objArr[i5] = aVarArr[i5].f5298e;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVar;
        if (h(obj)) {
            aVar = f(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.f5297f.remove(aVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f5297f.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i3, i4, i5);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return new n(this.f5296e, this, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i3, int i4) {
        super.delete(i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence) {
        b();
        super.replace(i3, i4, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i3, CharSequence charSequence, int i4, int i5) {
        super.insert(i3, charSequence, i4, i5);
        return this;
    }

    n(Class cls, CharSequence charSequence, int i3, int i4) {
        super(charSequence, i3, i4);
        this.f5297f = new ArrayList();
        androidx.core.util.h.e(cls, "watcherClass cannot be null");
        this.f5296e = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        b();
        super.replace(i3, i4, charSequence, i5, i6);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i3, int i4) {
        super.append(charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i3) {
        super.append(charSequence, obj, i3);
        return this;
    }
}
