package D;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f274a;

    /* renamed from: b, reason: collision with root package name */
    private e.AbstractC0078e f275b;

    private static class a extends e.AbstractC0078e {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f276a;

        /* renamed from: b, reason: collision with root package name */
        private final Reference f277b;

        a(TextView textView, d dVar) {
            this.f276a = new WeakReference(textView);
            this.f277b = new WeakReference(dVar);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.e.AbstractC0078e
        public void b() {
            CharSequence text;
            CharSequence o3;
            super.b();
            TextView textView = (TextView) this.f276a.get();
            if (c(textView, (InputFilter) this.f277b.get()) && textView.isAttachedToWindow() && text != (o3 = androidx.emoji2.text.e.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(o3);
                int selectionEnd = Selection.getSelectionEnd(o3);
                textView.setText(o3);
                if (o3 instanceof Spannable) {
                    d.b((Spannable) o3, selectionStart, selectionEnd);
                }
            }
        }
    }

    d(TextView textView) {
        this.f274a = textView;
    }

    private e.AbstractC0078e a() {
        if (this.f275b == null) {
            this.f275b = new a(this.f274a, this);
        }
        return this.f275b;
    }

    static void b(Spannable spannable, int i3, int i4) {
        if (i3 >= 0 && i4 >= 0) {
            Selection.setSelection(spannable, i3, i4);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        } else if (i4 >= 0) {
            Selection.setSelection(spannable, i4);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        if (this.f274a.isInEditMode()) {
            return charSequence;
        }
        int d3 = androidx.emoji2.text.e.b().d();
        if (d3 != 0) {
            if (d3 == 1) {
                if ((i6 == 0 && i5 == 0 && spanned.length() == 0 && charSequence == this.f274a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i3 != 0 || i4 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i3, i4);
                }
                return androidx.emoji2.text.e.b().p(charSequence, 0, charSequence.length());
            }
            if (d3 != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.e.b().s(a());
        return charSequence;
    }
}
