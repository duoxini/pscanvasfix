package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private G f3924e;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        G g3 = this.f3924e;
        if (g3 != null) {
            g3.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(G g3) {
    }
}
