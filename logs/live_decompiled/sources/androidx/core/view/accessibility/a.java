package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f5054a;

    /* renamed from: b, reason: collision with root package name */
    private final d f5055b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5056c;

    public a(int i3, d dVar, int i4) {
        this.f5054a = i3;
        this.f5055b = dVar;
        this.f5056c = i4;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f5054a);
        this.f5055b.I(this.f5056c, bundle);
    }
}
