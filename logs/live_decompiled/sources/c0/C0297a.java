package c0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import f.AbstractC0348a;

/* renamed from: c0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0297a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    InterfaceC0099a f7282a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f7283b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7284c;

    /* renamed from: c0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0099a {
        void a();
    }

    public C0297a(Context context) {
        this.f7284c = context;
    }

    public void a(InterfaceC0099a interfaceC0099a) {
        this.f7282a = interfaceC0099a;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        InterfaceC0099a interfaceC0099a = this.f7282a;
        if (interfaceC0099a != null) {
            interfaceC0099a.a();
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        ColorStateList a3 = AbstractC0348a.a(this.f7284c, O1.a.f1727a);
        this.f7283b = a3;
        textPaint.setColor(a3.getColorForState(textPaint.drawableState, 0));
    }
}
