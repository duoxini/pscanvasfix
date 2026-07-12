package i;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: i.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0392a implements TransformationMethod {

    /* renamed from: a, reason: collision with root package name */
    private Locale f12006a;

    public C0392a(Context context) {
        this.f12006a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f12006a);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z3, int i3, Rect rect) {
    }
}
