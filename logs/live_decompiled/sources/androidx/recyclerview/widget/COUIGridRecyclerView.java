package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class COUIGridRecyclerView extends COUIPercentWidthRecyclerView {

    public class COUIGridLayoutManager extends GridLayoutManager {
        private float j3() {
            if (COUIGridRecyclerView.p0(null) != 0.0f) {
                return COUIGridRecyclerView.p0(null);
            }
            if (COUIGridRecyclerView.s0(null) == 0.0f) {
                return 0.0f;
            }
            return (COUIGridRecyclerView.s0(null) / COUIGridRecyclerView.h0(null)) * COUIGridRecyclerView.l0(null);
        }

        private void k3() {
            COUIGridRecyclerView.k0(null);
            MarginType marginType = MarginType.MARGIN_SMALL;
            throw null;
        }

        private void l3() {
            COUIGridRecyclerView.f0(null, Math.max(1, (int) ((n3() + COUIGridRecyclerView.g0(null)) / (COUIGridRecyclerView.g0(null) + COUIGridRecyclerView.h0(null)))));
            COUIGridRecyclerView.m0(null, (n3() - (COUIGridRecyclerView.g0(null) * (COUIGridRecyclerView.e0(null) - 1))) / COUIGridRecyclerView.e0(null));
            COUIGridRecyclerView.q0(null, j3());
        }

        private void m3() {
            COUIGridRecyclerView.f0(null, Math.max(1, (int) ((n3() + COUIGridRecyclerView.j0(null)) / (COUIGridRecyclerView.j0(null) + COUIGridRecyclerView.l0(null)))));
            COUIGridRecyclerView.i0(null, (n3() - (COUIGridRecyclerView.l0(null) * COUIGridRecyclerView.e0(null))) / (COUIGridRecyclerView.e0(null) - 1));
        }

        private int n3() {
            return (q0() - h0()) - e0();
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public void Z0(RecyclerView.w wVar, RecyclerView.B b3) {
            int r02 = COUIGridRecyclerView.r0(null);
            if (r02 == 0) {
                k3();
            } else if (r02 == 1) {
                l3();
            } else if (r02 == 2) {
                m3();
            }
            if (COUIGridRecyclerView.e0(null) > 0 && this.f6239J != COUIGridRecyclerView.e0(null)) {
                g3(COUIGridRecyclerView.e0(null));
            }
            super.Z0(wVar, b3);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        View k2(RecyclerView.w wVar, RecyclerView.B b3, boolean z3, boolean z4) {
            return super.k2(wVar, b3, z3, z4);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        void t2(RecyclerView.w wVar, RecyclerView.B b3, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
            int f3;
            int i3;
            int i4;
            int i5;
            boolean z3;
            View d3;
            int h02 = h0() + COUIGridRecyclerView.n0(null);
            View[] viewArr = this.f6241L;
            if (viewArr == null || viewArr.length != COUIGridRecyclerView.e0(null)) {
                this.f6241L = new View[COUIGridRecyclerView.e0(null)];
            }
            int i6 = 0;
            int i7 = 0;
            while (i7 < COUIGridRecyclerView.e0(null) && cVar.c(b3) && (d3 = cVar.d(wVar)) != null) {
                this.f6241L[i7] = d3;
                i7++;
            }
            if (i7 == 0) {
                bVar.f6275b = true;
                return;
            }
            boolean z4 = cVar.f6282e == 1;
            int i8 = 0;
            int i9 = 0;
            float f4 = 0.0f;
            for (COUIGridRecyclerView cOUIGridRecyclerView = null; i8 < COUIGridRecyclerView.e0(cOUIGridRecyclerView); cOUIGridRecyclerView = null) {
                View view = this.f6241L[i8];
                if (view != null) {
                    if (cVar.f6289l == null) {
                        if (z4) {
                            d(view);
                        } else {
                            e(view, i6);
                        }
                    } else if (z4) {
                        b(view);
                    } else {
                        c(view, i6);
                    }
                    j(view, this.f6245P);
                    GridLayoutManager.b bVar2 = (GridLayoutManager.b) view.getLayoutParams();
                    Rect rect = bVar2.f6379b;
                    int i10 = rect.top + rect.bottom + (COUIGridRecyclerView.o0(cOUIGridRecyclerView) ? i6 : ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin);
                    int i11 = rect.left + rect.right + (COUIGridRecyclerView.o0(cOUIGridRecyclerView) ? 0 : ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin);
                    if (COUIGridRecyclerView.p0(cOUIGridRecyclerView) == 0.0f) {
                        COUIGridRecyclerView.q0(cOUIGridRecyclerView, ((ViewGroup.MarginLayoutParams) bVar2).height);
                    }
                    float round = Math.round(f4 + COUIGridRecyclerView.l0(cOUIGridRecyclerView));
                    float l02 = COUIGridRecyclerView.l0(cOUIGridRecyclerView) - round;
                    z3 = z4;
                    int K3 = RecyclerView.p.K((int) (round + rect.left + rect.right), this.f6263u.m(), i11, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    view.measure(K3, RecyclerView.p.K(this.f6263u.o(), X(), i10, (int) COUIGridRecyclerView.p0(null), true));
                    int e3 = this.f6263u.e(view);
                    Log.d("COUIGridRecyclerView", "childWidthSpec = " + View.MeasureSpec.getSize(K3) + " horizontalInsets = " + i11 + " lp.leftMargin = " + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + "  lp.rightMargin = " + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin + " decorInsets = " + rect.left + " - " + rect.right + " mCurrentPosition = " + cVar.f6281d + " x = " + h02);
                    if (e3 > i9) {
                        i9 = e3;
                    }
                    f4 = l02;
                } else {
                    z3 = z4;
                }
                i8++;
                z4 = z3;
                i6 = 0;
            }
            bVar.f6274a = i9;
            int i12 = h02;
            int i13 = 0;
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (COUIGridRecyclerView cOUIGridRecyclerView2 = null; i13 < COUIGridRecyclerView.e0(cOUIGridRecyclerView2); cOUIGridRecyclerView2 = null) {
                View view2 = this.f6241L[i13];
                if (view2 != null) {
                    GridLayoutManager.b bVar3 = (GridLayoutManager.b) view2.getLayoutParams();
                    if (r2()) {
                        int q02 = q0() - i12;
                        f3 = q02;
                        i3 = q02 - this.f6263u.f(view2);
                    } else {
                        f3 = this.f6263u.f(view2) + i12;
                        i3 = i12;
                    }
                    if (cVar.f6283f == -1) {
                        int i14 = cVar.f6279b;
                        i5 = i14;
                        i4 = i14 - bVar.f6274a;
                    } else {
                        int i15 = cVar.f6279b;
                        i4 = i15;
                        i5 = bVar.f6274a + i15;
                    }
                    B0(view2, i3, i4, f3, i5);
                    int round2 = Math.round(f5 + COUIGridRecyclerView.l0(null));
                    float l03 = COUIGridRecyclerView.l0(null) - round2;
                    int round3 = Math.round(f6 + COUIGridRecyclerView.g0(null));
                    float g02 = COUIGridRecyclerView.g0(null) - round3;
                    i12 = i12 + round3 + round2;
                    if (bVar3.c() || bVar3.b()) {
                        bVar.f6276c = true;
                    }
                    bVar.f6277d |= view2.hasFocusable();
                    f5 = l03;
                    f6 = g02;
                }
                i13++;
            }
            Arrays.fill(this.f6241L, (Object) null);
        }
    }

    static /* synthetic */ int e0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ int f0(COUIGridRecyclerView cOUIGridRecyclerView, int i3) {
        throw null;
    }

    static /* synthetic */ float g0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float h0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float i0(COUIGridRecyclerView cOUIGridRecyclerView, float f3) {
        throw null;
    }

    static /* synthetic */ float j0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ int k0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float l0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float m0(COUIGridRecyclerView cOUIGridRecyclerView, float f3) {
        throw null;
    }

    static /* synthetic */ int n0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ boolean o0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float p0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float q0(COUIGridRecyclerView cOUIGridRecyclerView, float f3) {
        throw null;
    }

    static /* synthetic */ int r0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }

    static /* synthetic */ float s0(COUIGridRecyclerView cOUIGridRecyclerView) {
        throw null;
    }
}
