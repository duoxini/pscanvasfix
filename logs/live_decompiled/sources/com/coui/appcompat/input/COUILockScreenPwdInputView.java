package com.coui.appcompat.input;

import S1.b;
import S1.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.edittext.COUIInputView;
import com.oplus.graphics.OplusPathAdapter;
import m0.c;
import n0.AbstractC0481a;
import y0.j;

/* loaded from: classes.dex */
public class COUILockScreenPwdInputView extends COUIInputView {

    /* renamed from: H, reason: collision with root package name */
    private final int f8057H;

    /* renamed from: I, reason: collision with root package name */
    private final int f8058I;

    /* renamed from: J, reason: collision with root package name */
    private final Rect f8059J;

    /* renamed from: K, reason: collision with root package name */
    private final Path f8060K;

    /* renamed from: L, reason: collision with root package name */
    private final RectF f8061L;

    /* renamed from: M, reason: collision with root package name */
    private int f8062M;

    /* renamed from: N, reason: collision with root package name */
    private View f8063N;

    /* renamed from: O, reason: collision with root package name */
    private int f8064O;

    /* renamed from: P, reason: collision with root package name */
    private int f8065P;

    /* renamed from: Q, reason: collision with root package name */
    private a f8066Q;

    /* renamed from: R, reason: collision with root package name */
    private com.coui.appcompat.input.a f8067R;

    /* renamed from: S, reason: collision with root package name */
    private int f8068S;

    /* renamed from: T, reason: collision with root package name */
    private float f8069T;

    /* renamed from: U, reason: collision with root package name */
    private int f8070U;

    /* renamed from: V, reason: collision with root package name */
    private int f8071V;

    /* renamed from: W, reason: collision with root package name */
    private Bitmap f8072W;

    /* renamed from: a0, reason: collision with root package name */
    private Paint f8073a0;

    private final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f8074a;

        /* renamed from: b, reason: collision with root package name */
        private OplusPathAdapter f8075b;

        a() {
            this.f8075b = null;
            int a3 = AbstractC0481a.a();
            this.f8074a = a3;
            if (a3 == 1) {
                this.f8075b = new OplusPathAdapter(COUILockScreenPwdInputView.this.f8060K, a3);
            }
        }

        OplusPathAdapter a() {
            return this.f8075b;
        }

        int b() {
            return this.f8074a;
        }

        void c(RectF rectF, float f3) {
            c.a(COUILockScreenPwdInputView.this.f8060K, rectF, f3);
        }
    }

    public COUILockScreenPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void U(RectF rectF) {
        float height = rectF.height() / 2.0f;
        if (this.f8066Q == null) {
            this.f8066Q = new a();
        }
        int b3 = this.f8066Q.b();
        if (b3 == 0) {
            this.f8060K.reset();
            this.f8066Q.c(rectF, height);
        } else if (b3 != 1) {
            this.f8060K.reset();
            this.f8060K.addRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, Path.Direction.CCW);
        } else {
            OplusPathAdapter a3 = this.f8066Q.a();
            this.f8060K.reset();
            a3.addSmoothRoundRect(rectF.left, rectF.top, rectF.right, rectF.bottom, height, height, Path.Direction.CCW);
        }
    }

    private void W(Canvas canvas) {
        int save = canvas.save();
        if (this.f8073a0 == null) {
            Paint paint = new Paint();
            this.f8073a0 = paint;
            paint.setColor(this.f8068S);
            this.f8073a0.setStyle(Paint.Style.STROKE);
            this.f8073a0.setStrokeWidth(this.f8069T * 2.0f);
        }
        canvas.drawPath(this.f8060K, this.f8073a0);
        canvas.restoreToCount(save);
    }

    private void X(Canvas canvas) {
        int save = canvas.save();
        canvas.drawBitmap(this.f8072W, 0.0f, 0.0f, (Paint) null);
        canvas.restoreToCount(save);
    }

    private void Y() {
        com.coui.appcompat.input.a aVar = this.f8067R;
        if (aVar == null) {
            this.f8067R = new com.coui.appcompat.input.a(getWidth(), getHeight());
        } else {
            aVar.c();
        }
        this.f8067R.a(32.0f, 0.0f, -8.0f, this.f8070U, 0, 20.0f, this.f8060K);
        this.f8067R.a(8.0f, 0.0f, 2.0f, this.f8071V, 0, 12.0f, this.f8060K);
        this.f8072W = this.f8067R.b();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected COUIEditText H(Context context, AttributeSet attributeSet) {
        return this.f8065P == 1 ? new COUIEditText(context, attributeSet, S1.a.f2083b) : new COUIEditText(context, attributeSet, S1.a.f2082a);
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected void N(Context context, AttributeSet attributeSet) {
    }

    void V() {
        String couiEditTexttNoEllipsisText = this.f7844j.getCouiEditTexttNoEllipsisText();
        if (this.f7842h <= 0 || this.f7844j.getText() == null) {
            return;
        }
        int length = couiEditTexttNoEllipsisText.length();
        int i3 = this.f7842h;
        if (length > i3) {
            this.f7844j.setText(couiEditTexttNoEllipsisText.subSequence(0, i3));
        }
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected int getEdittextPaddingBottom() {
        return getResources().getDimensionPixelSize(b.f2091g);
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected int getEdittextPaddingEnd() {
        return this.f7839e.getWidth();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected int getEdittextPaddingTop() {
        return getResources().getDimensionPixelSize(b.f2092h);
    }

    int getInputCount() {
        String couiEditTexttNoEllipsisText = this.f7844j.getCouiEditTexttNoEllipsisText();
        if (this.f7844j.getText() == null || couiEditTexttNoEllipsisText.length() <= 0) {
            return 0;
        }
        return couiEditTexttNoEllipsisText.length();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected int getLayoutResId() {
        return d.f2105a;
    }

    int getMinInputCount() {
        return this.f8064O;
    }

    @Deprecated
    public View getmLockScreenPwdCard() {
        return this.f8063N;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8065P == 1 && j.b(j.f14497a)) {
            W(canvas);
            X(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        RectF rectF = this.f8061L;
        rectF.right = i3;
        rectF.bottom = i4;
        U(rectF);
        if (this.f8065P == 1 && j.b(j.f14497a)) {
            Y();
        }
    }

    @Deprecated
    public void setDefaultInputLockScreenPwdWidth(int i3) {
        this.f8062M = i3;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public void setEnableInputCount(boolean z3) {
        this.f7841g = z3;
        V();
        y();
    }

    void setInputType(int i3) {
        if (this.f7843i == i3) {
            return;
        }
        this.f7843i = i3;
        B();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public void setMaxCount(int i3) {
        this.f7842h = i3;
        V();
        y();
    }

    void setMinInputCount(int i3) {
        this.f8064O = i3;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    protected void z() {
    }

    public COUILockScreenPwdInputView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8057H = 360;
        this.f8058I = getResources().getDimensionPixelOffset(b.f2090f);
        this.f8059J = new Rect();
        this.f8060K = new Path();
        this.f8061L = new RectF();
        this.f8064O = 6;
        this.f8065P = 0;
        this.f8066Q = null;
        this.f8068S = 0;
    }
}
