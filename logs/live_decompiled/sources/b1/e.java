package B1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import u1.C0601d;
import y1.u;

/* loaded from: classes.dex */
public class e implements m {

    /* renamed from: n, reason: collision with root package name */
    private static final String f170n = "e";

    /* renamed from: b, reason: collision with root package name */
    private boolean f172b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f171a = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean[] f173c = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    private String[] f174d = new String[3];

    /* renamed from: e, reason: collision with root package name */
    private String[] f175e = new String[3];

    /* renamed from: f, reason: collision with root package name */
    private float[] f176f = null;

    /* renamed from: g, reason: collision with root package name */
    private int[] f177g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f178h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f179i = -1;

    /* renamed from: j, reason: collision with root package name */
    private Rect f180j = new Rect();

    /* renamed from: k, reason: collision with root package name */
    private Rect f181k = new Rect();

    /* renamed from: l, reason: collision with root package name */
    private Rect f182l = new Rect();

    /* renamed from: m, reason: collision with root package name */
    private Rect f183m = new Rect();

    private void A(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 6) {
            int i5 = (int) f3;
            this.f182l.offset(i5, 0);
            this.f183m.offset(i5, 0);
            this.f181k.right += i5;
            y(containerView, 1, true, f3);
            y(containerView, 2, true, f3);
            x(containerView, 0, true, f3);
        }
        if (i3 == 7) {
            int i6 = (int) f3;
            this.f181k.offset(i6, 0);
            this.f182l.offset(i6, 0);
            this.f183m.left += i6;
            y(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            w(containerView, 2, true, f3);
        }
    }

    private void B(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4) {
            int i5 = (int) f3;
            this.f182l.offset(0, i5);
            this.f183m.offset(0, i5);
            this.f181k.bottom += i5;
            y(containerView, 1, false, f3);
            y(containerView, 2, false, f3);
            x(containerView, 0, false, f3);
        }
        if (i3 == 5) {
            int i6 = (int) f3;
            this.f181k.offset(0, i6);
            this.f182l.offset(0, i6);
            this.f183m.top += i6;
            y(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
        }
    }

    private void C(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 6) {
            int i5 = (int) f3;
            this.f181k.offset(i5, 0);
            this.f182l.offset(i5, 0);
            this.f183m.offset(i5, 0);
            this.f181k.left = rect.left;
            x(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            y(containerView, 2, true, f3);
            z(containerView, cVar, true, f3);
        }
        if (i3 == 7) {
            int i6 = (int) f3;
            this.f181k.offset(i6, 0);
            this.f182l.offset(i6, 0);
            this.f183m.offset(i6, 0);
            this.f183m.right = rect.right;
            y(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            w(containerView, 2, true, f3);
            z(containerView, cVar, true, f3);
        }
    }

    private void D(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4) {
            int i5 = (int) f3;
            this.f181k.offset(0, i5);
            this.f182l.offset(0, i5);
            this.f183m.offset(0, i5);
            this.f181k.top = rect.top;
            x(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            y(containerView, 2, false, f3);
            z(containerView, cVar, false, f3);
        }
        if (i3 == 5) {
            int i6 = (int) f3;
            this.f181k.offset(0, i6);
            this.f182l.offset(0, i6);
            this.f183m.offset(0, i6);
            this.f183m.bottom = rect.bottom;
            y(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
            z(containerView, cVar, false, f3);
        }
    }

    private void E(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4) {
            if (i4 == 1) {
                int i5 = (int) f3;
                this.f182l.right += i5;
                this.f183m.offset(i5, 0);
                Rect rect2 = this.f183m;
                rect2.right = Math.max(rect2.right, rect.right);
            }
            if (i4 == 2) {
                int i6 = (int) f3;
                this.f182l.offset(i6, 0);
                this.f183m.left += i6;
                Rect rect3 = this.f182l;
                rect3.left = Math.min(rect3.left, rect.left);
            }
            x(containerView, 1, true, f3);
            w(containerView, 2, true, f3);
        }
        if (i3 == 5) {
            if (i4 == 0) {
                int i7 = (int) f3;
                this.f181k.right += i7;
                this.f182l.offset(i7, 0);
                Rect rect4 = this.f182l;
                rect4.right = Math.max(rect4.right, rect.right);
            }
            if (i4 == 1) {
                int i8 = (int) f3;
                this.f181k.offset(i8, 0);
                this.f182l.left += i8;
                Rect rect5 = this.f181k;
                rect5.left = Math.min(rect5.left, rect.left);
            }
            x(containerView, 0, true, f3);
            w(containerView, 1, true, f3);
        }
    }

    private void F(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 6) {
            if (i4 == 1) {
                int i5 = (int) f3;
                this.f182l.bottom += i5;
                this.f183m.offset(0, i5);
                Rect rect2 = this.f183m;
                rect2.bottom = Math.max(rect2.bottom, rect.bottom);
            }
            if (i4 == 2) {
                int i6 = (int) f3;
                this.f182l.offset(0, i6);
                this.f183m.top += i6;
                Rect rect3 = this.f182l;
                rect3.top = Math.min(rect3.top, rect.top);
            }
            x(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
        }
        if (i3 == 7) {
            if (i4 == 0) {
                int i7 = (int) f3;
                this.f181k.bottom += i7;
                this.f182l.offset(0, i7);
                Rect rect4 = this.f182l;
                rect4.bottom = Math.max(rect4.bottom, rect.bottom);
            }
            if (i4 == 1) {
                int i8 = (int) f3;
                this.f181k.offset(0, i8);
                this.f182l.top += i8;
                Rect rect5 = this.f181k;
                rect5.top = Math.min(rect5.top, rect.top);
            }
            x(containerView, 0, false, f3);
            w(containerView, 1, false, f3);
        }
    }

    private void G(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4) {
            if (f3 > 0.0f) {
                int i5 = (int) f3;
                this.f182l.right += i5;
                this.f183m.offset(i5, 0);
                x(containerView, 1, true, f3);
                y(containerView, 2, true, f3);
            } else {
                int i6 = (int) f3;
                this.f182l.offset(i6, 0);
                this.f183m.left += i6;
                y(containerView, 1, true, f3);
                w(containerView, 2, true, f3);
            }
        }
        if (i3 == 5) {
            if (f3 > 0.0f) {
                int i7 = (int) f3;
                this.f181k.right += i7;
                this.f182l.offset(i7, 0);
                x(containerView, 0, true, f3);
                y(containerView, 1, true, f3);
            } else {
                int i8 = (int) f3;
                this.f181k.offset(i8, 0);
                this.f182l.left += i8;
                y(containerView, 0, true, f3);
                w(containerView, 1, true, f3);
            }
        }
        if (i3 == 6 || i3 == 7) {
            int i9 = (int) f3;
            this.f181k.offset(i9, 0);
            this.f182l.offset(i9, 0);
            this.f183m.offset(i9, 0);
            if (i3 == 6) {
                Rect rect2 = this.f181k;
                int i10 = rect2.left;
                int i11 = rect.left;
                if (i10 > i11) {
                    rect2.left = i11;
                }
            }
            if (i3 == 7) {
                Rect rect3 = this.f183m;
                int i12 = rect3.right;
                int i13 = rect.right;
                if (i12 < i13) {
                    rect3.right = i13;
                }
            }
            y(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            y(containerView, 2, true, f3);
            z(containerView, cVar, true, f3);
        }
    }

    private void H(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4 || i3 == 5) {
            int i5 = (int) f3;
            this.f181k.offset(0, i5);
            this.f182l.offset(0, i5);
            this.f183m.offset(0, i5);
            if (i3 == 4) {
                Rect rect2 = this.f181k;
                int i6 = rect2.top;
                int i7 = rect.top;
                if (i6 > i7) {
                    rect2.top = i7;
                }
            }
            if (i3 == 5) {
                Rect rect3 = this.f183m;
                int i8 = rect3.bottom;
                int i9 = rect.bottom;
                if (i8 < i9) {
                    rect3.bottom = i9;
                }
            }
            y(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            y(containerView, 2, false, f3);
            z(containerView, cVar, false, f3);
        }
        if (i3 == 6) {
            if (f3 > 0.0f) {
                int i10 = (int) f3;
                this.f182l.bottom += i10;
                this.f183m.offset(0, i10);
                x(containerView, 1, false, f3);
                y(containerView, 2, false, f3);
            } else {
                int i11 = (int) f3;
                this.f182l.offset(0, i11);
                this.f183m.top += i11;
                y(containerView, 1, false, f3);
                w(containerView, 2, false, f3);
            }
        }
        if (i3 == 7) {
            if (f3 > 0.0f) {
                int i12 = (int) f3;
                this.f181k.bottom += i12;
                this.f182l.offset(0, i12);
                x(containerView, 0, false, f3);
                y(containerView, 1, false, f3);
                return;
            }
            int i13 = (int) f3;
            this.f181k.offset(0, i13);
            this.f182l.top += i13;
            y(containerView, 0, false, f3);
            w(containerView, 1, false, f3);
        }
    }

    private void I(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4) {
            int i5 = (int) f3;
            this.f182l.right += i5;
            this.f183m.left += i5;
            x(containerView, 1, true, f3);
            w(containerView, 2, true, f3);
        }
        if (i3 == 5) {
            int i6 = (int) f3;
            this.f181k.right += i6;
            this.f182l.left += i6;
            x(containerView, 0, true, f3);
            w(containerView, 1, true, f3);
        }
        if (i3 == 6) {
            int i7 = (int) f3;
            this.f181k.right += i7;
            this.f182l.left += i7;
            this.f183m.left += i7;
            x(containerView, 0, true, f3);
            w(containerView, 1, true, f3);
            w(containerView, 2, true, f3);
            z(containerView, cVar, true, f3 / 2.0f);
        }
        if (i3 == 7) {
            int i8 = (int) f3;
            this.f183m.left += i8;
            this.f181k.right += i8;
            this.f182l.right += i8;
            x(containerView, 0, true, f3);
            x(containerView, 1, true, f3);
            w(containerView, 2, true, f3);
            z(containerView, cVar, true, f3 / 2.0f);
        }
    }

    private void J(int i3, float f3, E.c cVar, ContainerView containerView, Rect rect, int i4) {
        if (i3 == 4) {
            int i5 = (int) f3;
            this.f181k.bottom += i5;
            this.f182l.top += i5;
            this.f183m.top += i5;
            x(containerView, 0, false, f3);
            w(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
            z(containerView, cVar, false, f3 / 2.0f);
        }
        if (i3 == 5) {
            int i6 = (int) f3;
            this.f181k.bottom += i6;
            this.f182l.bottom += i6;
            this.f183m.top += i6;
            x(containerView, 0, false, f3);
            x(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
            z(containerView, cVar, false, f3 / 2.0f);
        }
        if (i3 == 6) {
            int i7 = (int) f3;
            this.f182l.bottom += i7;
            this.f183m.top += i7;
            x(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
        }
        if (i3 == 7) {
            int i8 = (int) f3;
            this.f181k.bottom += i8;
            this.f182l.top += i8;
            x(containerView, 0, false, f3);
            w(containerView, 1, false, f3);
        }
    }

    private void K(int i3, List list, String str, String str2, float f3, float f4, ContainerView containerView) {
        if (i3 != containerView.getLastDragMode()) {
            containerView.getCanvasMaskListView().D(150L);
        }
        N(str, str2, i3, containerView);
        u uVar = (u) list.get(0);
        u uVar2 = (u) list.get(1);
        containerView.setLastFirstText(str);
        containerView.setLastSecondText(str2);
        uVar.o(str);
        uVar2.o(str2);
        if (i3 != 41) {
            if (i3 != 45) {
                if (i3 != 51) {
                    if (i3 != 56) {
                        if (i3 != 61) {
                            if (i3 == 62) {
                                uVar2.m(1.0f);
                                uVar.m(1.0f);
                                uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                                return;
                            } else if (i3 == 67) {
                                uVar.m(1.0f);
                                uVar2.m(1.0f);
                                uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                                return;
                            } else if (i3 != 68) {
                                uVar.m(1.0f);
                                uVar2.m(1.0f);
                                return;
                            }
                        }
                    }
                }
            }
            uVar.m(1.0f);
            uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
            containerView.X2(uVar2, uVar, i3, 1);
            return;
        }
        uVar2.m(1.0f);
        uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
        containerView.X2(uVar, uVar2, i3, 0);
    }

    private void L(float f3, ContainerView containerView, Rect rect, E.c cVar) {
        List<Rect> originalLocations = containerView.getOriginalLocations();
        if (originalLocations.get(0).left <= 0) {
            if (!this.f172b) {
                if (f3 >= 0.0f) {
                    int i3 = (int) f3;
                    this.f182l.right += i3;
                    this.f183m.offset(i3, 0);
                    x(containerView, 1, true, f3);
                    y(containerView, 2, true, f3);
                    v(cVar);
                    return;
                }
                int i4 = (int) f3;
                this.f181k.offset(i4, 0);
                this.f182l.offset(i4, 0);
                this.f183m.left += i4;
                y(containerView, 0, true, f3);
                y(containerView, 1, true, f3);
                w(containerView, 2, true, f3);
                z(containerView, cVar, true, f3);
                return;
            }
            if (f3 < 0.0f) {
                int i5 = (int) f3;
                this.f181k.offset(i5, 0);
                this.f182l.offset(i5, 0);
                this.f183m.offset(i5, 0);
                y(containerView, 0, true, f3);
                y(containerView, 1, true, f3);
                y(containerView, 2, true, f3);
            } else {
                int i6 = (int) f3;
                this.f181k.offset(i6, 0);
                this.f182l.offset(i6, 0);
                this.f183m.offset(i6, 0);
                Rect rect2 = this.f181k;
                int i7 = rect2.left;
                int i8 = rect.left;
                if (i7 > i8) {
                    rect2.left = i8;
                }
                y(containerView, 0, true, f3);
                y(containerView, 1, true, f3);
                y(containerView, 2, true, f3);
            }
            z(containerView, cVar, true, f3);
            return;
        }
        if (this.f172b) {
            if (f3 < 0.0f) {
                int i9 = (int) f3;
                this.f181k.offset(i9, 0);
                this.f182l.left += i9;
                y(containerView, 0, true, f3);
                w(containerView, 1, true, f3);
                v(cVar);
                return;
            }
            int i10 = (int) f3;
            this.f181k.right += i10;
            this.f182l.offset(i10, 0);
            this.f183m.offset(i10, 0);
            x(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            y(containerView, 2, true, f3);
            z(containerView, cVar, true, f3);
            return;
        }
        if (f3 < 0.0f) {
            int i11 = (int) f3;
            this.f181k.offset(i11, 0);
            this.f182l.offset(i11, 0);
            this.f183m.offset(i11, 0);
            Rect rect3 = this.f183m;
            int i12 = rect3.right;
            int i13 = rect.right;
            if (i12 < i13) {
                rect3.right = i13;
            }
            y(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            if (originalLocations.get(2).right <= rect.width()) {
                w(containerView, 2, true, f3);
            } else {
                y(containerView, 2, true, f3);
            }
            z(containerView, cVar, true, f3);
            return;
        }
        if (originalLocations.get(2).right <= rect.width()) {
            int i14 = (int) f3;
            this.f182l.right += i14;
            this.f183m.offset(i14, 0);
            x(containerView, 1, true, f3);
            y(containerView, 2, true, f3);
        } else {
            int i15 = (int) f3;
            this.f181k.offset(i15, 0);
            this.f182l.offset(i15, 0);
            this.f183m.offset(i15, 0);
            y(containerView, 0, true, f3);
            y(containerView, 1, true, f3);
            y(containerView, 2, true, f3);
        }
        v(cVar);
    }

    private void M(float f3, ContainerView containerView, Rect rect, E.c cVar) {
        if (containerView.getOriginalLocations().get(0).top > 0) {
            if (this.f172b) {
                if (f3 < 0.0f) {
                    int i3 = (int) f3;
                    this.f181k.offset(0, i3);
                    this.f182l.top += i3;
                    y(containerView, 0, false, f3);
                    w(containerView, 1, false, f3);
                    v(cVar);
                    return;
                }
                int i4 = (int) f3;
                this.f181k.bottom += i4;
                this.f182l.offset(0, i4);
                this.f183m.offset(0, i4);
                x(containerView, 0, false, f3);
                y(containerView, 1, false, f3);
                y(containerView, 2, false, f3);
                z(containerView, cVar, false, f3);
                return;
            }
            if (f3 < 0.0f) {
                int i5 = (int) f3;
                this.f181k.offset(0, i5);
                this.f182l.offset(0, i5);
                this.f183m.offset(0, i5);
                Rect rect2 = this.f183m;
                int i6 = rect2.bottom;
                int i7 = rect.bottom;
                if (i6 < i7) {
                    rect2.bottom = i7;
                }
                y(containerView, 0, false, f3);
                y(containerView, 1, false, f3);
                y(containerView, 2, false, f3);
            } else {
                int i8 = (int) f3;
                this.f181k.offset(0, i8);
                this.f182l.offset(0, i8);
                this.f183m.offset(0, i8);
                y(containerView, 0, false, f3);
                y(containerView, 1, false, f3);
                y(containerView, 2, false, f3);
            }
            z(containerView, cVar, false, f3);
            return;
        }
        if (!this.f172b) {
            if (f3 >= 0.0f) {
                int i9 = (int) f3;
                this.f182l.bottom += i9;
                this.f183m.offset(0, i9);
                x(containerView, 1, false, f3);
                y(containerView, 2, false, f3);
                v(cVar);
                return;
            }
            int i10 = (int) f3;
            this.f181k.offset(0, i10);
            this.f182l.offset(0, i10);
            this.f183m.top += i10;
            y(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            w(containerView, 2, false, f3);
            z(containerView, cVar, false, f3);
            return;
        }
        if (f3 < 0.0f) {
            int i11 = (int) f3;
            this.f181k.offset(0, i11);
            this.f182l.offset(0, i11);
            this.f183m.offset(0, i11);
            y(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            y(containerView, 2, false, f3);
        } else {
            int i12 = (int) f3;
            this.f181k.offset(0, i12);
            this.f182l.offset(0, i12);
            this.f183m.offset(0, i12);
            Rect rect3 = this.f181k;
            int i13 = rect3.top;
            int i14 = rect.top;
            if (i13 > i14) {
                rect3.top = i14;
            }
            y(containerView, 0, false, f3);
            y(containerView, 1, false, f3);
            y(containerView, 2, false, f3);
        }
        z(containerView, cVar, false, f3);
    }

    private void N(String str, String str2, int i3, ContainerView containerView) {
        if (i3 == containerView.getLastDragMode() || !s.r(containerView.getContext()) || i3 == 64 || i3 == 65) {
            return;
        }
        boolean z3 = i3 == 62 || i3 == 67;
        if (str != null) {
            if (str.equals(containerView.getLastFirstText())) {
                if (str.equals(containerView.getMaskPlusText()) && z3) {
                    containerView.h3(0);
                }
            } else if (str.equals(containerView.getMaskFullText())) {
                containerView.h3(69);
            } else if (str.equals(containerView.getMaskPlusText())) {
                containerView.h3(0);
            }
        }
        if (str2 != null) {
            if (str2.equals(containerView.getLastSecondText())) {
                if (str2.equals(containerView.getMaskPlusText()) && z3) {
                    containerView.h3(0);
                    return;
                }
                return;
            }
            if (str2.equals(containerView.getMaskFullText())) {
                containerView.h3(69);
            } else if (str2.equals(containerView.getMaskPlusText())) {
                containerView.h3(0);
            }
        }
    }

    private void O(ContainerView containerView, boolean z3) {
        if (containerView.getLastDragMode() == 6 && z3 && !s.H()) {
            containerView.h3(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0259, code lost:
    
        if (r3 <= 0.0f) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x025b, code lost:
    
        r10 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x025d, code lost:
    
        r10 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0273, code lost:
    
        if ((r3 - r9[r9.length - 1]) <= 0.0f) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0331  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Rect i(int r16, android.graphics.Rect r17, float r18, float r19, java.lang.String r20, java.lang.String r21, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r22) {
        /*
            Method dump skipped, instructions count: 867
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.e.i(int, android.graphics.Rect, float, float, java.lang.String, java.lang.String, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):android.graphics.Rect");
    }

    private boolean j(boolean z3, int i3, boolean[] zArr, boolean[] zArr2, int i4, boolean z4, int i5, float f3, List list) {
        boolean z5;
        if (z3) {
            return true;
        }
        if ((i3 != 4 || ((i4 != 1 || !zArr2[1]) && (i4 != 2 || !zArr2[2]))) && ((i3 != 5 || ((i4 != 0 || !zArr2[0]) && (i4 != 1 || !zArr2[1]))) && ((i3 != 6 || ((i4 != 1 || !zArr2[1]) && (i4 != 2 || !zArr2[2]))) && (i3 != 7 || ((i4 != 0 || !zArr2[0]) && (i4 != 1 || !zArr2[1])))))) {
            return z3;
        }
        this.f176f = new float[]{(float) (i5 * 0.5d)};
        if (i3 == 4 && z4) {
            if (i4 == 1) {
                this.f177g = new int[]{4, 6};
                z5 = true;
            } else {
                z5 = z3;
            }
            if (i4 == 2) {
                this.f177g = new int[]{6, 5};
                z5 = true;
            }
            this.f178h = 17;
            this.f180j.set(((Rect) list.get(1)).right, ((Rect) list.get(1)).top, ((Rect) list.get(2)).left, ((Rect) list.get(1)).bottom);
        } else {
            z5 = z3;
        }
        if (i3 == 5 && z4) {
            if (i4 == 0) {
                this.f177g = new int[]{3, 6};
                z5 = true;
            }
            if (i4 == 1) {
                this.f177g = new int[]{6, 4};
                z5 = true;
            }
            this.f178h = 17;
            this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
        }
        if (i3 == 6 && !z4) {
            if (i4 == 1) {
                this.f177g = new int[]{4, 6};
                z5 = true;
            }
            if (i4 == 2) {
                this.f177g = new int[]{6, 5};
                z5 = true;
            }
            this.f178h = 18;
            this.f180j.set(((Rect) list.get(1)).left, ((Rect) list.get(1)).bottom, ((Rect) list.get(1)).right, ((Rect) list.get(2)).top);
        }
        if (i3 != 7 || z4) {
            return z5;
        }
        if (i4 == 0) {
            this.f177g = new int[]{3, 6};
            z5 = true;
        }
        if (i4 == 1) {
            this.f177g = new int[]{6, 4};
            z5 = true;
        }
        this.f178h = 18;
        this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
        return z5;
    }

    private boolean k(boolean z3, int i3, boolean[] zArr, boolean[] zArr2, int i4, boolean z4, int i5, float f3, List list) {
        if (z3) {
            return true;
        }
        if ((i3 != 4 || i4 != 0 || !zArr2[0]) && ((i3 != 5 || i4 != 2 || !zArr2[2]) && ((i3 != 6 || i4 != 0 || !zArr2[0]) && (i3 != 7 || i4 != 2 || !zArr2[2])))) {
            return z3;
        }
        this.f176f = new float[]{(float) (i5 * 0.5d)};
        if (i3 == 4) {
            this.f177g = new int[]{3, 6};
            this.f178h = 14;
            this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
        }
        if (i3 == 5) {
            this.f177g = new int[]{6, 5};
            this.f178h = 14;
            this.f180j.set(((Rect) list.get(2)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(2)).right, ((Rect) list.get(2)).top);
        }
        if (i3 == 6) {
            this.f177g = new int[]{3, 6};
            this.f178h = 13;
            this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
        }
        if (i3 == 7) {
            this.f177g = new int[]{6, 5};
            this.f178h = 13;
            this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(2)).top, ((Rect) list.get(2)).left, ((Rect) list.get(2)).bottom);
        }
        return true;
    }

    private boolean l(boolean z3, int i3, boolean[] zArr, boolean[] zArr2, int i4, boolean z4, int i5, float f3, List list) {
        boolean z5;
        if (z3) {
            return true;
        }
        if ((i3 != 4 || ((i4 != 1 || !zArr[1] || !zArr2[2]) && (i4 != 2 || !zArr[2] || !zArr2[1]))) && ((i3 != 5 || ((i4 != 0 || !zArr[0] || !zArr2[1]) && (i4 != 1 || !zArr[1] || !zArr2[0]))) && ((i3 != 6 || ((i4 != 1 || !zArr[1] || !zArr2[2]) && (i4 != 2 || !zArr[2] || !zArr2[1]))) && (i3 != 7 || ((i4 != 0 || !zArr[0] || !zArr2[1]) && (i4 != 1 || !zArr[1] || !zArr2[0])))))) {
            return z3;
        }
        double d3 = i5;
        this.f176f = new float[]{(float) (0.5d * d3)};
        if (i3 == 4 && z4) {
            if (i4 == 1) {
                this.f176f = new float[]{(float) (d3 * 0.6d)};
                this.f177g = new int[]{6, 1};
            }
            if (i4 == 2) {
                this.f176f = new float[]{(float) (d3 * 0.4d)};
                this.f177g = new int[]{2, 6};
            }
            this.f178h = 19;
            this.f180j.set(((Rect) list.get(1)).right, ((Rect) list.get(1)).top, ((Rect) list.get(2)).left, ((Rect) list.get(1)).bottom);
            z5 = true;
        } else {
            z5 = z3;
        }
        if (i3 == 5 && z4) {
            if (i4 == 0) {
                this.f176f = new float[]{(float) (d3 * 0.6d)};
                this.f177g = new int[]{6, 0};
            }
            if (i4 == 1) {
                this.f176f = new float[]{(float) (d3 * 0.4d)};
                this.f177g = new int[]{1, 6};
            }
            this.f178h = 17;
            this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
            z5 = true;
        }
        if (i3 == 6 && !z4) {
            if (i4 == 1) {
                this.f176f = new float[]{(float) (d3 * 0.6d)};
                this.f177g = new int[]{6, 1};
            }
            if (i4 == 2) {
                this.f176f = new float[]{(float) (d3 * 0.4d)};
                this.f177g = new int[]{2, 6};
            }
            this.f178h = 20;
            this.f180j.set(((Rect) list.get(1)).left, ((Rect) list.get(1)).bottom, ((Rect) list.get(1)).right, ((Rect) list.get(2)).top);
            z5 = true;
        }
        if (i3 != 7 || z4) {
            return z5;
        }
        if (i4 == 0) {
            this.f176f = new float[]{(float) (d3 * 0.6d)};
            this.f177g = new int[]{6, 0};
        }
        if (i4 == 1) {
            this.f176f = new float[]{(float) (d3 * 0.4d)};
            this.f177g = new int[]{1, 6};
        }
        this.f178h = 20;
        this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
        return true;
    }

    private boolean m(boolean z3, int i3, boolean[] zArr, boolean[] zArr2, int i4, boolean z4, int i5, float f3, List list) {
        boolean z5;
        if (z3) {
            return true;
        }
        if ((i3 != 4 || i4 != 0 || !zArr[0] || (zArr2[1] && zArr2[2])) && ((i3 != 5 || i4 != 2 || !zArr[2] || (zArr2[0] && zArr2[1])) && ((i3 != 6 || i4 != 0 || !zArr[0] || (zArr2[1] && zArr2[2])) && (i3 != 7 || i4 != 2 || !zArr[2] || (zArr2[0] && zArr2[1]))))) {
            return z3;
        }
        if (i3 != 4 || z4) {
            z5 = z3;
        } else {
            this.f176f = new float[]{(float) (i5 * 0.6d)};
            this.f177g = new int[]{6, 0};
            this.f178h = 16;
            this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
            z5 = true;
        }
        if (i3 == 5 && !z4) {
            this.f176f = new float[]{(float) (i5 * 0.4d)};
            this.f177g = new int[]{2, 6};
            this.f178h = 16;
            this.f180j.set(((Rect) list.get(2)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(2)).right, ((Rect) list.get(2)).top);
            z5 = true;
        }
        if (i3 == 6 && z4) {
            this.f176f = new float[]{(float) (i5 * 0.6d)};
            this.f177g = new int[]{6, 0};
            this.f178h = 15;
            this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
            z5 = true;
        }
        if (i3 != 7 || !z4) {
            return z5;
        }
        this.f176f = new float[]{(float) (i5 * 0.4d)};
        this.f177g = new int[]{2, 6};
        this.f178h = 15;
        this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(2)).top, ((Rect) list.get(2)).left, ((Rect) list.get(2)).bottom);
        return true;
    }

    private boolean n(boolean z3, int i3, boolean[] zArr, boolean[] zArr2, int i4, boolean z4, int i5, float f3, List list) {
        boolean z5;
        if (z3) {
            return true;
        }
        if ((i3 == 4 && ((i4 == 1 || i4 == 2) && zArr[1] && zArr[2])) || (i3 == 5 && ((i4 == 0 || i4 == 1) && zArr[0] && zArr[1]))) {
            if (z4) {
                double d3 = i5;
                this.f176f = new float[]{(float) (d3 * 0.4d), (float) (d3 * 0.6d)};
                if (i3 == 4) {
                    this.f177g = new int[]{2, 6, 1};
                    this.f180j.set(((Rect) list.get(1)).right, ((Rect) list.get(1)).top, ((Rect) list.get(2)).left, ((Rect) list.get(1)).bottom);
                }
                if (i3 == 5) {
                    this.f177g = new int[]{1, 6, 0};
                    this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
                }
                this.f178h = 11;
            } else {
                this.f176f = new float[]{(float) (i5 * 0.5d)};
                if (i3 == 4) {
                    this.f177g = new int[]{6, 0};
                    this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
                }
                if (i3 == 5) {
                    this.f177g = new int[]{2, 6};
                    this.f180j.set(((Rect) list.get(2)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(2)).right, ((Rect) list.get(2)).top);
                }
                this.f178h = 12;
            }
            z5 = true;
        } else {
            z5 = z3;
        }
        if ((i3 != 6 || ((i4 != 1 && i4 != 2) || !zArr[1] || !zArr[2])) && (i3 != 7 || ((i4 != 0 && i4 != 1) || !zArr[0] || !zArr[1]))) {
            return z5;
        }
        if (z4) {
            this.f176f = new float[]{(float) (i5 * 0.5d)};
            if (i3 == 6) {
                this.f177g = new int[]{6, 0};
                this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
            }
            if (i3 == 7) {
                this.f177g = new int[]{2, 6};
                this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(2)).top, ((Rect) list.get(2)).left, ((Rect) list.get(2)).bottom);
            }
            this.f178h = 11;
            return true;
        }
        double d4 = i5;
        this.f176f = new float[]{(float) (0.4d * d4), (float) (d4 * 0.6d)};
        if (i3 == 6) {
            this.f177g = new int[]{2, 6, 1};
            this.f180j.set(((Rect) list.get(1)).left, ((Rect) list.get(1)).bottom, ((Rect) list.get(1)).right, ((Rect) list.get(2)).top);
        }
        if (i3 == 7) {
            this.f177g = new int[]{1, 6, 0};
            this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
        }
        this.f178h = 12;
        return true;
    }

    private boolean o(boolean z3, int i3, boolean[] zArr, boolean[] zArr2, int i4, boolean z4, int i5, List list) {
        if (z3) {
            return true;
        }
        if ((i3 != 4 || i4 != 0 || !zArr[0] || !zArr2[1] || !zArr2[2]) && ((i3 != 5 || i4 != 2 || !zArr[2] || !zArr2[0] || !zArr2[1]) && ((i3 != 6 || i4 != 0 || !zArr[0] || !zArr2[1] || !zArr2[2]) && (i3 != 7 || i4 != 2 || !zArr[2] || !zArr2[0] || !zArr2[1])))) {
            return z3;
        }
        if (i3 == 4) {
            if (z4) {
                this.f176f = new float[]{(float) (i5 * 1.0d)};
                this.f177g = new int[]{6};
                this.f178h = 21;
                this.f180j.set(((Rect) list.get(1)).right, ((Rect) list.get(1)).top, ((Rect) list.get(2)).left, ((Rect) list.get(1)).bottom);
            } else {
                this.f176f = new float[]{(float) (i5 * 0.6d)};
                this.f177g = new int[]{6, 0};
                this.f178h = 22;
                this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
            }
        }
        if (i3 == 5) {
            if (z4) {
                this.f176f = new float[]{(float) (i5 * 1.0d)};
                this.f177g = new int[]{6};
                this.f178h = 21;
                this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
            } else {
                this.f176f = new float[]{(float) (i5 * 0.4d)};
                this.f177g = new int[]{2, 6};
                this.f178h = 22;
                this.f180j.set(((Rect) list.get(2)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(2)).right, ((Rect) list.get(2)).top);
            }
        }
        if (i3 == 6) {
            if (z4) {
                this.f176f = new float[]{(float) (i5 * 0.6d)};
                this.f177g = new int[]{6, 0};
                this.f178h = 21;
                this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
            } else {
                this.f176f = new float[]{(float) (i5 * 1.0d)};
                this.f177g = new int[]{6};
                this.f178h = 22;
                this.f180j.set(((Rect) list.get(1)).left, ((Rect) list.get(1)).bottom, ((Rect) list.get(1)).right, ((Rect) list.get(2)).top);
            }
        }
        if (i3 != 7) {
            return true;
        }
        if (z4) {
            this.f176f = new float[]{(float) (i5 * 0.4d)};
            this.f177g = new int[]{2, 6};
            this.f178h = 21;
            this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(2)).top, ((Rect) list.get(2)).left, ((Rect) list.get(2)).bottom);
            return true;
        }
        this.f176f = new float[]{(float) (i5 * 1.0d)};
        this.f177g = new int[]{6};
        this.f178h = 22;
        this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
        return true;
    }

    private void p(ContainerView containerView, int i3, List list, boolean z3) {
        boolean z4;
        String str;
        String str2;
        if (containerView.getAdapter().l().size() != 3) {
            Log.e(f170n, "handleTargetDragMode, size != 3 ");
        }
        C0601d item = containerView.getAdapter().getItem(0);
        C0601d item2 = containerView.getAdapter().getItem(1);
        C0601d item3 = containerView.getAdapter().getItem(2);
        boolean a02 = containerView.f10732G.a0();
        boolean f02 = containerView.f10732G.f0();
        boolean g02 = containerView.f10732G.g0();
        if (item == null || item2 == null || item3 == null) {
            return;
        }
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        boolean[] zArr = this.f173c;
        zArr[0] = a02;
        zArr[1] = f02;
        zArr[2] = g02;
        Arrays.fill(this.f174d, "");
        int i4 = containerView.getDragTargetAction()[i3 - 101];
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) {
            boolean z5 = i4 <= 2;
            if (!z5) {
                i4 -= 3;
            }
            C0601d item4 = containerView.getAdapter().getItem(i4);
            if (item4 != null) {
                List<Rect> originalLocations = containerView.getOriginalLocations();
                if (originalLocations == null || originalLocations.size() != 3) {
                    Log.i(f170n, "handleTargetDragMode, originalLocations is null " + originalLocations);
                    return;
                }
                boolean G3 = s.G(item4, originalLocations.get(i4), windowMetricsBounds);
                if (z3) {
                    if (G3 && z5) {
                        String[] strArr = this.f174d;
                        if (this.f173c[i4]) {
                            str2 = containerView.getMaskEnlargeText();
                            strArr[i4] = str2;
                        } else {
                            str2 = this.f175e[i4];
                        }
                        strArr[i4] = str2;
                        z4 = this.f173c[i4];
                    } else {
                        z4 = false;
                    }
                    if (!G3 && !z5) {
                        String[] strArr2 = this.f174d;
                        if (this.f173c[i4]) {
                            str = containerView.getMaskNarrowText();
                            strArr2[i4] = str;
                        } else {
                            str = this.f175e[i4];
                        }
                        strArr2[i4] = str;
                        z4 = this.f173c[i4];
                    }
                    O(containerView, z4);
                } else if (this.f173c[i4] && ((G3 && z5) || (!G3 && !z5))) {
                    this.f179i = i4;
                    this.f171a = z5;
                    containerView.setIsSpringBack(false);
                }
            }
        }
        if (z3) {
            for (int i5 = 0; i5 < 3; i5++) {
                ((u) list.get(i5)).o(this.f174d[i5]);
            }
        }
        containerView.setLastDragMode(i3);
    }

    private void q(int i3, int i4, float f3, ContainerView containerView, Rect rect, int i5, E.c cVar) {
        switch (i3) {
            case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                G(i4, f3, cVar, containerView, rect, i5);
                break;
            case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                H(i4, f3, cVar, containerView, rect, i5);
                break;
            case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
                A(i4, f3, cVar, containerView, rect, i5);
                break;
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                B(i4, f3, cVar, containerView, rect, i5);
                break;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                C(i4, f3, cVar, containerView, rect, i5);
                break;
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                D(i4, f3, cVar, containerView, rect, i5);
                break;
            case 17:
            case COUICollapsableAppBarLayout.DEFAULT_SCROLL_FLAG /* 19 */:
                E(i4, f3, cVar, containerView, rect, i5);
                break;
            case 18:
            case 20:
                F(i4, f3, cVar, containerView, rect, i5);
                break;
            case 21:
                I(i4, f3, cVar, containerView, rect, i5);
                break;
            case 22:
                J(i4, f3, cVar, containerView, rect, i5);
                break;
            case 23:
                L(f3, containerView, rect, cVar);
                break;
            case 24:
                M(f3, containerView, rect, cVar);
                break;
        }
    }

    private boolean r(boolean z3, int i3, int i4, boolean z4, int i5, float f3, ContainerView containerView, E.c cVar, List list) {
        E.c C3;
        if (z3) {
            return true;
        }
        if (i3 != 3 || (C3 = containerView.f10732G.C(cVar)) == null) {
            return z3;
        }
        boolean z5 = cVar.k() && cVar.j().centerX() < C3.j().centerX();
        if (!cVar.k() && cVar.j().centerY() < C3.j().centerY()) {
            z5 = true;
        }
        if (cVar.k()) {
            if (z5) {
                this.f180j.set(((Rect) list.get(0)).right, ((Rect) list.get(0)).top, ((Rect) list.get(1)).left, ((Rect) list.get(0)).bottom);
            } else {
                this.f180j.set(((Rect) list.get(1)).right, ((Rect) list.get(1)).top, ((Rect) list.get(2)).left, ((Rect) list.get(1)).bottom);
            }
        } else if (z5) {
            this.f180j.set(((Rect) list.get(0)).left, ((Rect) list.get(0)).bottom, ((Rect) list.get(0)).right, ((Rect) list.get(1)).top);
        } else {
            this.f180j.set(((Rect) list.get(1)).left, ((Rect) list.get(1)).bottom, ((Rect) list.get(1)).right, ((Rect) list.get(2)).top);
        }
        this.f172b = z5;
        Rect rect = this.f180j;
        int centerX = z4 ? rect.centerX() : rect.centerY();
        Rect rect2 = (Rect) list.get(0);
        int i6 = z4 ? rect2.left : rect2.top;
        Rect rect3 = (Rect) list.get(2);
        int i7 = z4 ? rect3.right : rect3.bottom;
        if (s.H() && z4 && i6 >= 0 && i7 <= i5) {
            double d3 = centerX;
            double d4 = i5 * 0.1d;
            this.f176f = new float[]{(float) (d3 - d4), (float) (d3 + d4)};
            if (z5) {
                this.f177g = new int[]{1, 6, 0};
            } else {
                this.f177g = new int[]{2, 6, 1};
            }
        } else if (i6 > 0) {
            if (z5) {
                double d5 = centerX;
                double d6 = i5 * 0.1d;
                this.f176f = new float[]{(float) (d5 - d6), (float) (d5 + d6)};
                this.f177g = new int[]{1, 6, 0};
            } else {
                this.f176f = new float[]{(float) (i5 * 0.5d)};
                this.f177g = new int[]{2, 6};
            }
        } else if (z5) {
            this.f176f = new float[]{(float) (i5 * 0.5d)};
            this.f177g = new int[]{6, 0};
        } else {
            double d7 = centerX;
            double d8 = i5 * 0.1d;
            this.f176f = new float[]{(float) (d7 - d8), (float) (d7 + d8)};
            this.f177g = new int[]{2, 6, 1};
        }
        this.f178h = z4 ? 23 : 24;
        return true;
    }

    private void s(ContainerView containerView) {
        E e3 = containerView.f10732G;
        String E3 = e3.E();
        String F3 = e3.F();
        String G3 = e3.G();
        if (TextUtils.isEmpty(E3)) {
            this.f175e[0] = containerView.getContext().getResources().getString(t1.j.f13634d0);
        } else {
            this.f175e[0] = String.format(containerView.getContext().getResources().getString(t1.j.f13632c0), E3);
        }
        if (TextUtils.isEmpty(F3)) {
            this.f175e[1] = containerView.getContext().getResources().getString(t1.j.f13634d0);
        } else {
            this.f175e[1] = String.format(containerView.getContext().getResources().getString(t1.j.f13632c0), F3);
        }
        if (TextUtils.isEmpty(G3)) {
            this.f175e[2] = containerView.getContext().getResources().getString(t1.j.f13634d0);
        } else {
            this.f175e[2] = String.format(containerView.getContext().getResources().getString(t1.j.f13632c0), G3);
        }
    }

    private void t(ContainerView containerView) {
        containerView.setDuringTransform(true);
        containerView.setLastDragMode(0);
        containerView.setIndexToEnlarge(-1);
        containerView.setIndexToMax(-1);
        containerView.setIsSpringBack(true);
        this.f179i = -1;
        this.f171a = false;
    }

    private void u(ContainerView containerView, E.c cVar, float f3) {
        ImageView h3 = cVar.h();
        if (cVar.k()) {
            h3.setTranslationX(f3 / containerView.getParentScaleX());
        } else {
            h3.setTranslationY(f3 / containerView.getParentScaleY());
        }
    }

    private void v(E.c cVar) {
        if (cVar != null) {
            cVar.h().setTranslationX(0.0f);
            cVar.h().setTranslationY(0.0f);
            cVar.h().setScaleX(1.0f);
            cVar.h().setScaleY(1.0f);
        }
    }

    private void w(ContainerView containerView, int i3, boolean z3, float f3) {
        List<EmbeddedViewDecor> childEmbeddedViewList = containerView.getChildEmbeddedViewList();
        if (z3) {
            childEmbeddedViewList.get(i3).setPivotX(0.0f);
            childEmbeddedViewList.get(i3).setScaleX(1.0f - (f3 / containerView.getOriginalLocations().get(i3).width()));
            childEmbeddedViewList.get(i3).setTranslationX(f3 / containerView.getParentScaleX());
        } else {
            childEmbeddedViewList.get(i3).setPivotY(0.0f);
            childEmbeddedViewList.get(i3).setScaleY(1.0f - (f3 / containerView.getOriginalLocations().get(i3).height()));
            childEmbeddedViewList.get(i3).setTranslationY(f3 / containerView.getParentScaleY());
        }
    }

    private void x(ContainerView containerView, int i3, boolean z3, float f3) {
        List<EmbeddedViewDecor> childEmbeddedViewList = containerView.getChildEmbeddedViewList();
        if (z3) {
            childEmbeddedViewList.get(i3).setPivotX(0.0f);
            childEmbeddedViewList.get(i3).setScaleX((f3 / containerView.getOriginalLocations().get(i3).width()) + 1.0f);
        } else {
            childEmbeddedViewList.get(i3).setPivotY(0.0f);
            childEmbeddedViewList.get(i3).setScaleY((f3 / containerView.getOriginalLocations().get(i3).height()) + 1.0f);
        }
    }

    private void y(ContainerView containerView, int i3, boolean z3, float f3) {
        List<EmbeddedViewDecor> childEmbeddedViewList = containerView.getChildEmbeddedViewList();
        if (z3) {
            childEmbeddedViewList.get(i3).setTranslationX(f3 / containerView.getParentScaleX());
        } else {
            childEmbeddedViewList.get(i3).setTranslationY(f3 / containerView.getParentScaleY());
        }
    }

    private void z(ContainerView containerView, E.c cVar, boolean z3, float f3) {
        if (cVar != null) {
            if (z3) {
                cVar.h().setTranslationX(f3 / containerView.getParentScaleX());
            } else {
                cVar.h().setTranslationY(f3 / containerView.getParentScaleY());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0137, code lost:
    
        if (r12 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013b, code lost:
    
        if (r13 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0140, code lost:
    
        if (r13 != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0142, code lost:
    
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0144, code lost:
    
        if (r12 != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0151, code lost:
    
        if (r13 == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0157, code lost:
    
        if (r12 != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015c, code lost:
    
        if (r13 == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0161, code lost:
    
        if (r12 != false) goto L71;
     */
    @Override // B1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.List r17, float r18, float r19, float r20, float r21, java.lang.String r22, java.lang.String r23, boolean r24, boolean r25, boolean r26, boolean r27, android.graphics.Rect r28, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r29) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.e.a(java.util.List, float, float, float, float, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, android.graphics.Rect, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):void");
    }

    @Override // B1.m
    public Rect b(int i3, float f3, ContainerView containerView, int i4) {
        Context context = containerView.getContext();
        Rect rect = new Rect();
        int l02 = l.l0(context);
        if (containerView.getAdapter().getCount() != 2) {
            return rect;
        }
        int width = containerView.getAdapter().getItem(0).w().width();
        int height = containerView.getAdapter().getItem(0).w().height();
        if (i4 != -1 ? i4 == 1 : containerView.m1()) {
            if (i3 == 0) {
                rect.left = 0;
                rect.top = 0;
                rect.right = width;
                rect.bottom = (int) ((height * f3) - (l02 / 2));
            } else if (i3 == 1) {
                rect.left = 0;
                rect.top = (int) ((height * f3) + (l02 / 2));
                rect.right = width;
                rect.bottom = height;
            }
        } else if (i3 == 0) {
            rect.left = 0;
            rect.top = 0;
            rect.right = (int) ((width * f3) - (l02 / 2));
            rect.bottom = height;
        } else if (i3 == 1) {
            rect.left = (int) ((width * f3) + (l02 / 2));
            rect.top = 0;
            rect.right = width;
            rect.bottom = height;
        }
        return rect;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if (r3 != 5) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r3 != 6) goto L10;
     */
    @Override // B1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c(u1.C0600c r2, int r3, int r4, boolean r5) {
        /*
            r1 = this;
            int r1 = r2.getCount()
            r4 = 0
            r5 = 2
            if (r1 != r5) goto L1b
            if (r3 == r5) goto L40
            r1 = 1
            if (r3 == r1) goto L40
            u1.d r3 = r2.getItem(r4)
            boolean r3 = r3.I()
            if (r3 == 0) goto L19
            r3 = r5
            goto L40
        L19:
            r3 = r1
            goto L40
        L1b:
            int r1 = r2.getCount()
            r0 = 3
            if (r1 != r0) goto L40
            int[] r1 = r2.d()
            r1 = r1[r4]
            boolean r4 = r2.A()
            if (r4 == 0) goto L30
            r3 = r0
            goto L40
        L30:
            if (r1 < r5) goto L39
            r1 = 4
            if (r3 == r1) goto L40
            r1 = 5
            if (r3 == r1) goto L40
            goto L19
        L39:
            r1 = 7
            if (r3 == r1) goto L40
            r5 = 6
            if (r3 == r5) goto L40
            goto L19
        L40:
            r2.K(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.e.c(u1.c, int, int, boolean):int");
    }

    @Override // B1.m
    public boolean d(ContainerView containerView, E.c cVar, float f3, float f4) {
        if (!containerView.i1() || cVar == null) {
            Log.i(f170n, "calculateThreeSplitDragMode, is not threeSplitLayout: " + containerView.i1());
            return false;
        }
        C0601d item = containerView.getAdapter().getItem(0);
        C0601d item2 = containerView.getAdapter().getItem(1);
        C0601d item3 = containerView.getAdapter().getItem(2);
        if (item == null || item2 == null || item3 == null) {
            Log.i(f170n, "calculateThreeSplitDragMode, taskData is null");
            return false;
        }
        List<Rect> originalLocations = containerView.getOriginalLocations();
        if (originalLocations == null || originalLocations.size() != 3) {
            Log.i(f170n, "calculateThreeSplitDragMode, originalLocations is null " + originalLocations);
            return false;
        }
        boolean k3 = cVar.k();
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        int h3 = containerView.getAdapter().h();
        int q3 = containerView.getContainerController().q();
        int width = k3 ? windowMetricsBounds.width() : windowMetricsBounds.height();
        boolean G3 = s.G(item, originalLocations.get(0), windowMetricsBounds);
        boolean z3 = !G3;
        boolean G4 = s.G(item2, originalLocations.get(1), windowMetricsBounds);
        boolean z4 = !G4;
        boolean G5 = s.G(item3, originalLocations.get(2), windowMetricsBounds);
        boolean z5 = !G5;
        float f5 = k3 ? f3 : f4;
        boolean[] zArr = {G3, G4, G5};
        boolean[] zArr2 = {z3, z4, z5};
        float f6 = f5;
        boolean r3 = r(o(l(j(m(k(n(false, q3, zArr, zArr2, h3, k3, width, f6, originalLocations), q3, zArr, zArr2, h3, k3, width, f6, originalLocations), q3, zArr, zArr2, h3, k3, width, f6, originalLocations), q3, zArr, zArr2, h3, k3, width, f6, originalLocations), q3, zArr, zArr2, h3, k3, width, f6, originalLocations), q3, zArr, zArr2, h3, k3, width, originalLocations), q3, h3, k3, width, f5, containerView, cVar, originalLocations);
        s(containerView);
        containerView.setDragModes(this.f176f);
        containerView.setDragTargetAction(this.f177g);
        containerView.setDragModeType(this.f178h);
        containerView.f10732G.C0(this.f180j);
        Log.d(f170n, "calculateThreeSplitDragMode, handled: " + r3 + ", dragModes: " + Arrays.toString(this.f176f) + ", dragTargetAction: " + Arrays.toString(this.f177g) + ", dragModeType: " + this.f178h + ", splitBarRectStartScroll: " + this.f180j + ", windowBounds: " + windowMetricsBounds + ", isSplitBarVertical: " + k3 + ", small: " + Arrays.toString(zArr) + ", layoutOrientation: " + l.Z0(q3));
        return r3;
    }

    @Override // B1.m
    public void e(List list, float f3, float f4, ContainerView containerView, E.c cVar) {
        u uVar = (u) list.get(0);
        u uVar2 = (u) list.get(1);
        u uVar3 = (u) list.get(2);
        this.f181k = uVar.h();
        this.f182l = uVar2.h();
        this.f183m = uVar3.h();
        E.c C3 = containerView.f10732G.C(cVar);
        Rect windowMetricsBounds = containerView.getWindowMetricsBounds();
        int h3 = containerView.getAdapter().h();
        int q3 = containerView.getContainerController().q();
        int dragModeType = containerView.getDragModeType();
        int v02 = containerView.v0(f3);
        u(containerView, cVar, f4);
        p(containerView, v02, list, true);
        q(dragModeType, q3, f4, containerView, windowMetricsBounds, h3, C3);
    }

    @Override // B1.m
    public void f(ContainerView containerView, int i3, int i4, E.c cVar) {
        E e3 = containerView.f10732G;
        C0601d item = containerView.getAdapter().getItem(0);
        C0601d item2 = containerView.getAdapter().getItem(1);
        C0601d item3 = containerView.getAdapter().getItem(2);
        if (item == null || item2 == null || item3 == null) {
            Log.e(f170n, "endScrollSplitBarInThreeSplit, return firstTask: " + item + ", secondTask: " + item2 + ", thirdTask: " + item3);
            return;
        }
        containerView.getCanvasMaskManager().m0(item);
        containerView.getCanvasMaskManager().c0(item2);
        containerView.getCanvasMaskManager().l0(item3);
        t(containerView);
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List I3 = e3.I();
        ImageView h3 = cVar.h();
        C0601d c0601d = null;
        p(containerView, i3, null, false);
        containerView.setIndexToMax(this.f179i);
        for (int i5 = 0; i5 < containerView.getAdapter().getCount(); i5++) {
            C0601d item4 = containerView.getAdapter().getItem(i5);
            if (item4 != null) {
                item4.q0(false);
                if (i5 == this.f179i) {
                    item4.o0(this.f171a);
                    c0601d = item4;
                }
                arrayList2.add(item4);
            }
        }
        if (this.f179i >= 0) {
            containerView.f3(arrayList2);
            arrayList = l.d1(containerView.getContext(), arrayList2, this.f179i, containerView.getAdapter().n(), false);
            for (int i6 = 0; i6 < I3.size(); i6++) {
                ((u) I3.get(i6)).n((Rect) arrayList.get(i6));
            }
        }
        if (!containerView.f1()) {
            containerView.setSplitBarVisibility(4);
        }
        Log.d(f170n, "endScrollSplitBarInThreeSplit, targetDragMode: " + i3 + ", mIndexToMax: " + this.f179i + ", canvasTargetPosition: " + arrayList + ", taskDataList: " + arrayList2);
        containerView.getCanvasMaskManager().T(I3, h3, (long) i4, containerView.n2(i3, -1, false), containerView.j2(c0601d), containerView.m2(this.f179i, this.f171a));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0564 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x04de  */
    @Override // B1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(java.util.List r20, int r21, int r22, float r23, float r24, int r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r31) {
        /*
            Method dump skipped, instructions count: 2078
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.e.g(java.util.List, int, int, float, float, int, boolean, boolean, boolean, boolean, boolean, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):void");
    }

    @Override // B1.m
    public void h(Rect rect, ContainerView containerView) {
        float[] fArr;
        int i3;
        if (containerView.k1()) {
            C0601d item = containerView.getAdapter().getItem(0);
            C0601d item2 = containerView.getAdapter().getItem(1);
            if (item == null || item2 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(item);
            arrayList.add(item2);
            int h3 = containerView.getAdapter().h();
            float B02 = containerView.B0(containerView.getContext());
            float y02 = ContainerView.y0(containerView.getContext());
            float x02 = ContainerView.x0(containerView.getContext());
            int width = containerView.j1() ? containerView.getWindowMetricsBounds().width() : containerView.getWindowMetricsBounds().height();
            if (l.N0(containerView) || containerView.f10732G.f10323Q) {
                float f3 = width;
                double d3 = width;
                fArr = new float[]{0.050000012f * f3, 0.19999999f * f3, (float) ((1.0f - B02) * 0.5d * d3), (float) (d3 * 0.5d), (float) (d3 * (B02 + 1.0f) * 0.5d), 0.8f * f3, f3 * 0.95f};
                i3 = 7;
            } else if ((h3 == 0 && s.E(0, containerView)) || (h3 == 1 && s.E(1, containerView))) {
                float f4 = width;
                double d4 = width;
                fArr = new float[]{0.050000012f * f4, (float) ((1.0f - y02) * 0.5d * d4), (float) (d4 * (y02 + 1.0f) * 0.5d), f4 * 0.95f};
                i3 = 5;
            } else {
                float f5 = width;
                double d5 = width;
                fArr = new float[]{0.050000012f * f5, (float) ((1.0f - x02) * 0.5d * d5), (float) (d5 * 0.5d), (float) (d5 * (x02 + 1.0f) * 0.5d), f5 * 0.95f};
                i3 = 6;
            }
            containerView.setDragModes(fArr);
            containerView.setDragModeType(i3);
        }
    }
}
