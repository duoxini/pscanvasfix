package D;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* loaded from: classes.dex */
final class c extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f272a;

    /* renamed from: b, reason: collision with root package name */
    private final a f273b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z3) {
            return androidx.emoji2.text.e.e(inputConnection, editable, i3, i4, z3);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.e.h()) {
                androidx.emoji2.text.e.b().u(editorInfo);
            }
        }
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f272a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        return this.f273b.a(this, a(), i3, i4, false) || super.deleteSurroundingText(i3, i4);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        return this.f273b.a(this, a(), i3, i4, true) || super.deleteSurroundingTextInCodePoints(i3, i4);
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f272a = textView;
        this.f273b = aVar;
        aVar.b(editorInfo);
    }
}
