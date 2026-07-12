package A1;

import B1.l;
import B1.s;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.WindowManager;
import com.oplus.anim.EffectiveAnimationView;
import t1.i;
import t1.j;
import z1.C0653f;
import z1.InterfaceC0651d;
import z1.h;

/* loaded from: classes.dex */
public class a extends h {

    /* renamed from: A, reason: collision with root package name */
    private boolean f45A;

    /* renamed from: v, reason: collision with root package name */
    private Context f46v;

    /* renamed from: w, reason: collision with root package name */
    private float f47w;

    /* renamed from: x, reason: collision with root package name */
    private int f48x;

    /* renamed from: y, reason: collision with root package name */
    private int f49y;

    /* renamed from: z, reason: collision with root package name */
    private volatile boolean f50z;

    public a(Context context) {
        super(context);
        this.f46v = context;
        this.f47w = context.getResources().getDisplayMetrics().density;
        this.f48x = context.getDisplay().getMode().getPhysicalHeight();
        this.f49y = context.getDisplay().getMode().getPhysicalWidth();
        this.f14693l = false;
    }

    private int A(int i3, int i4) {
        int i5 = (int) (this.f47w * 40.0f);
        if (i3 <= 0) {
            return 0;
        }
        int i6 = i4 - i5;
        return i3 >= i6 ? i6 : i3;
    }

    private void t(int i3, int i4, EffectiveAnimationView effectiveAnimationView) {
        int G02 = l.O1(this.f46v).G0();
        int i5 = i3 - G02;
        if (i5 <= 0) {
            return;
        }
        effectiveAnimationView.getLayoutParams().width = i5;
        effectiveAnimationView.getLayoutParams().height = i5;
        effectiveAnimationView.setLayoutParams(effectiveAnimationView.getLayoutParams());
        effectiveAnimationView.setX(i4 - (i5 / 2));
        effectiveAnimationView.setY(G02);
    }

    private void u(Rect rect, int i3, int i4, boolean z3) {
        int i5;
        int min;
        int min2;
        int i6;
        int min3;
        int min4;
        int i7;
        int min5;
        int min6;
        int i8;
        int min7;
        int min8;
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d == null) {
            Log.i("FlexibleTipsManager", "setAnimationPos mTarget null ");
            return;
        }
        EffectiveAnimationView dragAnimationViewRight = ((C0653f) interfaceC0651d).getDragAnimationViewRight();
        if (dragAnimationViewRight == null) {
            Log.i("FlexibleTipsManager", "setAnimationPos dragRightAnimate null ," + i3);
            return;
        }
        this.f14691j = 10;
        this.f14692k = this.f46v.getString(j.f13649l);
        dragAnimationViewRight.setCacheComposition(false);
        dragAnimationViewRight.setAnimation(i.f13541b);
        dragAnimationViewRight.setRotation(0.0f);
        int i9 = (int) (this.f47w * 40.0f);
        Log.d("FlexibleTipsManager", "setAnimationPos type=" + i3 + ",isPort=" + z3 + ",dr_width=" + i9);
        dragAnimationViewRight.getLayoutParams().width = i9;
        dragAnimationViewRight.getLayoutParams().height = i9;
        dragAnimationViewRight.setLayoutParams(dragAnimationViewRight.getLayoutParams());
        if (i3 == 1) {
            this.f14690i = 128;
            int i10 = (int) (rect.right - (this.f47w * 8.0f));
            if (z3) {
                i5 = rect.top;
                if (i5 < 0) {
                    min2 = Math.min(rect.bottom, this.f48x) / 2;
                } else {
                    min = (Math.min(rect.bottom, this.f48x) - rect.top) / 2;
                    min2 = i5 + min;
                }
            } else {
                i5 = rect.top;
                if (i5 < 0) {
                    min2 = Math.min(rect.bottom, this.f49y) / 2;
                } else {
                    min = (Math.min(rect.bottom, this.f49y) - rect.top) / 2;
                    min2 = i5 + min;
                }
            }
            int z4 = z(i10 - i9, i4);
            dragAnimationViewRight.setX(z4);
            dragAnimationViewRight.setY(min2 - (i9 / 2));
            p(z4 + r2, (r8 - r2) - ((int) (this.f47w * 80.0f)));
            return;
        }
        if (i3 == 2) {
            this.f14690i = 128;
            int i11 = (int) (rect.left + (this.f47w * 8.0f));
            if (z3) {
                i6 = rect.top;
                if (i6 < 0) {
                    min4 = Math.min(rect.bottom, this.f48x) / 2;
                } else {
                    min3 = (Math.min(rect.bottom, this.f48x) - rect.top) / 2;
                    min4 = i6 + min3;
                }
            } else {
                i6 = rect.top;
                if (i6 < 0) {
                    min4 = Math.min(rect.bottom, this.f49y) / 2;
                } else {
                    min3 = (Math.min(rect.bottom, this.f49y) - rect.top) / 2;
                    min4 = i6 + min3;
                }
            }
            dragAnimationViewRight.setX(z(i11, i4));
            dragAnimationViewRight.setY(min4 - (i9 / 2));
            p(r9 + r2, (r8 - r2) - ((int) (this.f47w * 80.0f)));
            return;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                return;
            }
            this.f14690i = 4;
            int i12 = (int) (rect.top + (this.f47w * 8.0f));
            if (z3) {
                i8 = rect.left;
                if (i8 < 0) {
                    min8 = Math.min(rect.right, this.f49y) / 2;
                } else {
                    min7 = (Math.min(rect.right, this.f49y) - rect.left) / 2;
                    min8 = i8 + min7;
                }
            } else {
                i8 = rect.left;
                if (i8 < 0) {
                    min8 = Math.min(rect.right, this.f48x) / 2;
                } else {
                    min7 = (Math.min(rect.right, this.f48x) - rect.left) / 2;
                    min8 = i8 + min7;
                }
            }
            int A3 = A(i12, i4);
            dragAnimationViewRight.setX(min8 - (i9 / 2));
            dragAnimationViewRight.setY(A3);
            p(r8 + r2, A3 - ((int) (this.f47w * 10.0f)));
            return;
        }
        this.f14690i = 128;
        int i13 = (int) (rect.bottom - (this.f47w * 8.0f));
        if (z3) {
            i7 = rect.left;
            if (i7 < 0) {
                min6 = Math.min(rect.right, this.f49y) / 2;
            } else {
                min5 = (Math.min(rect.right, this.f49y) - rect.left) / 2;
                min6 = i7 + min5;
            }
        } else {
            i7 = rect.left;
            if (i7 < 0) {
                min6 = Math.min(rect.right, this.f48x) / 2;
            } else {
                min5 = (Math.min(rect.right, this.f48x) - rect.left) / 2;
                min6 = i7 + min5;
            }
        }
        int A4 = A(i13 - i9, i4);
        dragAnimationViewRight.setX(min6 - (i9 / 2));
        dragAnimationViewRight.setY(A4);
        p(r3 + r1, (int) (r9 + (this.f47w * 50.0f)));
        if (s.J(this.f46v) && l.u0()) {
            t(rect.bottom, min6, dragAnimationViewRight);
        }
    }

    private int z(int i3, int i4) {
        int i5 = (int) (this.f47w * 40.0f);
        if (i3 <= 0) {
            return 0;
        }
        int i6 = i4 - i5;
        return i3 >= i6 ? i6 : i3;
    }

    @Override // z1.h
    /* renamed from: m */
    public void o() {
        super.o();
        Log.d("FlexibleTipsManager", "hideTips");
        if (this.f45A) {
            b.H(0);
        }
        this.f50z = false;
    }

    public void r(Context context) {
        this.f46v = context;
    }

    public boolean s() {
        return this.f50z;
    }

    public void v(boolean z3) {
        this.f45A = z3;
    }

    public void w(boolean z3) {
        this.f50z = z3;
    }

    public void x(Rect rect, boolean z3) {
        if (rect == null) {
            Log.i("FlexibleTipsManager", "showFocusTips null " + z3);
            return;
        }
        Log.d("FlexibleTipsManager", "showFocusTips " + rect + ",isSplitVertical:" + z3 + "--" + this.f49y + "--" + this.f48x + "--" + this.f14676e);
        if (this.f14676e != null) {
            Log.d("FlexibleTipsManager", "showFocusTips, mTarget != null, removeView");
            g();
            return;
        }
        int rotation = ((WindowManager) this.f46v.getSystemService("window")).getDefaultDisplay().getRotation();
        Log.i("FlexibleTipsManager", "showTips,  rotation:" + rotation);
        j();
        if (rotation == 0 || rotation == 2) {
            if (z3) {
                u(rect, rect.left < 0 ? 1 : 2, this.f49y, true);
                return;
            } else {
                u(rect, rect.top < 0 ? 3 : 4, this.f48x, true);
                return;
            }
        }
        if (z3) {
            u(rect, rect.left < 0 ? 1 : 2, this.f48x, false);
        } else {
            u(rect, rect.top < 0 ? 3 : 4, this.f49y, false);
        }
    }

    public void y(boolean z3) {
        if (this.f14676e != null) {
            Log.d("FlexibleTipsManager", "showFullTips, mTarget != null, removeView " + this);
            g();
            return;
        }
        j();
        InterfaceC0651d interfaceC0651d = this.f14676e;
        if (interfaceC0651d == null) {
            Log.i("FlexibleTipsManager", "showFullTips mTarget null ");
            return;
        }
        EffectiveAnimationView dragAnimationViewRight = ((C0653f) interfaceC0651d).getDragAnimationViewRight();
        if (dragAnimationViewRight == null) {
            Log.i("FlexibleTipsManager", "showFullTips dragRightAnimate null ");
            return;
        }
        this.f14690i = 128;
        this.f14691j = 10;
        float f3 = this.f47w;
        int i3 = (int) (424.0f * f3);
        dragAnimationViewRight.getLayoutParams().width = i3;
        dragAnimationViewRight.getLayoutParams().height = (int) (f3 * 338.0f);
        dragAnimationViewRight.setLayoutParams(dragAnimationViewRight.getLayoutParams());
        dragAnimationViewRight.setCacheComposition(false);
        if (z3) {
            dragAnimationViewRight.setAnimation(i.f13544c);
            this.f14692k = this.f46v.getString(j.f13640g0);
        } else {
            dragAnimationViewRight.setAnimation(i.f13547d);
            this.f14692k = this.f46v.getString(j.f13644i0);
        }
        dragAnimationViewRight.setRotation(0.0f);
        int rotation = ((WindowManager) this.f46v.getSystemService("window")).getDefaultDisplay().getRotation();
        Log.d("FlexibleTipsManager", "showFullTips,  rotation:" + rotation + ",isEnter:" + z3);
        dragAnimationViewRight.setY(this.f47w * 250.0f);
        if (rotation == 0 || rotation == 2) {
            dragAnimationViewRight.setX((this.f49y / 2.0f) - (i3 / 2.0f));
            p(this.f49y / 2.0f, this.f47w * 86.0f);
        } else {
            dragAnimationViewRight.setX((this.f48x / 2.0f) - (i3 / 2.0f));
            p(this.f48x / 2.0f, this.f47w * 86.0f);
        }
    }
}
