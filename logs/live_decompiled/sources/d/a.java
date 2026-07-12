package D;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f264a;

    /* renamed from: b, reason: collision with root package name */
    private int f265b = Preference.DEFAULT_ORDER;

    /* renamed from: c, reason: collision with root package name */
    private int f266c = 0;

    /* renamed from: D.a$a, reason: collision with other inner class name */
    private static class C0008a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f267a;

        /* renamed from: b, reason: collision with root package name */
        private final g f268b;

        C0008a(EditText editText, boolean z3) {
            this.f267a = editText;
            g gVar = new g(editText, z3);
            this.f268b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(D.b.getInstance());
        }

        @Override // D.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // D.a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f267a, inputConnection, editorInfo);
        }

        @Override // D.a.b
        void c(boolean z3) {
            this.f268b.c(z3);
        }
    }

    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void c(boolean z3);
    }

    public a(EditText editText, boolean z3) {
        androidx.core.util.h.e(editText, "editText cannot be null");
        this.f264a = new C0008a(editText, z3);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f264a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f264a.b(inputConnection, editorInfo);
    }

    public void c(boolean z3) {
        this.f264a.c(z3);
    }
}
