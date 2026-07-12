package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.o;
import androidx.lifecycle.q;

/* loaded from: classes.dex */
public abstract class f extends Dialog implements o, k {
    private q _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, int i3) {
        super(context, i3);
        D2.k.e(context, "context");
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                f.c(f.this);
            }
        });
    }

    private final q b() {
        q qVar = this._lifecycleRegistry;
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(this);
        this._lifecycleRegistry = qVar2;
        return qVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(f fVar) {
        D2.k.e(fVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.o
    public final AbstractC0272h getLifecycle() {
        return b();
    }

    @Override // androidx.activity.k
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.f();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.onBackPressedDispatcher.g(getOnBackInvokedDispatcher());
        b().h(AbstractC0272h.b.ON_CREATE);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().h(AbstractC0272h.b.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().h(AbstractC0272h.b.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }
}
