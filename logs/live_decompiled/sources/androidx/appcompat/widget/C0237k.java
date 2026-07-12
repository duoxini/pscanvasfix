package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0237k {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f4273a;

    /* renamed from: b, reason: collision with root package name */
    private final D.a f4274b;

    C0237k(EditText editText) {
        this.f4273a = editText;
        this.f4274b = new D.a(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f4274b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = this.f4273a.getContext().obtainStyledAttributes(attributeSet, e.j.f11381g0, i3, 0);
        try {
            boolean z3 = obtainStyledAttributes.hasValue(e.j.f11437u0) ? obtainStyledAttributes.getBoolean(e.j.f11437u0, true) : true;
            obtainStyledAttributes.recycle();
            e(z3);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f4274b.b(inputConnection, editorInfo);
    }

    void e(boolean z3) {
        this.f4274b.c(z3);
    }
}
