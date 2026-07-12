package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f3892e;

    /* renamed from: f, reason: collision with root package name */
    private TypedValue f3893f;

    /* renamed from: g, reason: collision with root package name */
    private TypedValue f3894g;

    /* renamed from: h, reason: collision with root package name */
    private TypedValue f3895h;

    /* renamed from: i, reason: collision with root package name */
    private TypedValue f3896i;

    /* renamed from: j, reason: collision with root package name */
    private TypedValue f3897j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f3898k;

    /* renamed from: l, reason: collision with root package name */
    private a f3899l;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i3, int i4, int i5, int i6) {
        this.f3898k.set(i3, i4, i5, i6);
        if (androidx.core.view.y.O(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f3896i == null) {
            this.f3896i = new TypedValue();
        }
        return this.f3896i;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f3897j == null) {
            this.f3897j = new TypedValue();
        }
        return this.f3897j;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f3894g == null) {
            this.f3894g = new TypedValue();
        }
        return this.f3894g;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f3895h == null) {
            this.f3895h = new TypedValue();
        }
        return this.f3895h;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f3892e == null) {
            this.f3892e = new TypedValue();
        }
        return this.f3892e;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f3893f == null) {
            this.f3893f = new TypedValue();
        }
        return this.f3893f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f3899l;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f3899l;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f3899l = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3898k = new Rect();
    }
}
