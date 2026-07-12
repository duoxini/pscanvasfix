package D;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    private final KeyListener f278a;

    /* renamed from: b, reason: collision with root package name */
    private final a f279b;

    public static class a {
        public boolean a(Editable editable, int i3, KeyEvent keyEvent) {
            return androidx.emoji2.text.e.f(editable, i3, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i3) {
        this.f278a.clearMetaKeyState(view, editable, i3);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f278a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f279b.a(editable, i3, keyEvent) || this.f278a.onKeyDown(view, editable, i3, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f278a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f278a.onKeyUp(view, editable, i3, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f278a = keyListener;
        this.f279b = aVar;
    }
}
