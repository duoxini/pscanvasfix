package D;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import androidx.preference.Preference;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class g implements TextWatcher {

    /* renamed from: e, reason: collision with root package name */
    private final EditText f285e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f286f;

    /* renamed from: g, reason: collision with root package name */
    private e.AbstractC0078e f287g;

    /* renamed from: h, reason: collision with root package name */
    private int f288h = Preference.DEFAULT_ORDER;

    /* renamed from: i, reason: collision with root package name */
    private int f289i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f290j = true;

    private static class a extends e.AbstractC0078e {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f291a;

        a(EditText editText) {
            this.f291a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.AbstractC0078e
        public void b() {
            super.b();
            g.b((EditText) this.f291a.get(), 1);
        }
    }

    g(EditText editText, boolean z3) {
        this.f285e = editText;
        this.f286f = z3;
    }

    private e.AbstractC0078e a() {
        if (this.f287g == null) {
            this.f287g = new a(this.f285e);
        }
        return this.f287g;
    }

    static void b(EditText editText, int i3) {
        if (i3 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f290j && (this.f286f || androidx.emoji2.text.e.h())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
    }

    public void c(boolean z3) {
        if (this.f290j != z3) {
            if (this.f287g != null) {
                androidx.emoji2.text.e.b().t(this.f287g);
            }
            this.f290j = z3;
            if (z3) {
                b(this.f285e, androidx.emoji2.text.e.b().d());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        if (this.f285e.isInEditMode() || d() || i4 > i5 || !(charSequence instanceof Spannable)) {
            return;
        }
        int d3 = androidx.emoji2.text.e.b().d();
        if (d3 != 0) {
            if (d3 == 1) {
                androidx.emoji2.text.e.b().r((Spannable) charSequence, i3, i3 + i5, this.f288h, this.f289i);
                return;
            } else if (d3 != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.b().s(a());
    }
}
