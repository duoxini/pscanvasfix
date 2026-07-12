package R0;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f2025a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0037a f2026b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2027c;

    /* renamed from: R0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0037a {
        void apply(Typeface typeface);
    }

    public a(InterfaceC0037a interfaceC0037a, Typeface typeface) {
        this.f2025a = typeface;
        this.f2026b = interfaceC0037a;
    }

    private void b(Typeface typeface) {
        if (this.f2027c) {
            return;
        }
        this.f2026b.apply(typeface);
    }

    public void a() {
        this.f2027c = true;
    }

    @Override // R0.f
    public void onFontRetrievalFailed(int i3) {
        b(this.f2025a);
    }

    @Override // R0.f
    public void onFontRetrieved(Typeface typeface, boolean z3) {
        b(typeface);
    }
}
