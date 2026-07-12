package B1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u1.C0600c;
import u1.C0601d;
import y1.u;

/* loaded from: classes.dex */
public class o implements m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f231a = "o";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x027b, code lost:
    
        if ((r1 - r9) <= 0.0f) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x026b, code lost:
    
        if (r1 <= 0.0f) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x026d, code lost:
    
        r14 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0270, code lost:
    
        r14 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Rect i(int r20, android.graphics.Rect r21, float r22, float r23, java.lang.String r24, java.lang.String r25, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView r26) {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.o.i(int, android.graphics.Rect, float, float, java.lang.String, java.lang.String, com.oplus.pscanvas.canvasmode.canvas.view.ContainerView):android.graphics.Rect");
    }

    private void j(int i3, List list, String str, String str2, float f3, float f4, ContainerView containerView) {
        k(i3, list, str, str2, f3, f4, true, containerView);
    }

    private void k(int i3, List list, String str, String str2, float f3, float f4, boolean z3, ContainerView containerView) {
        if (i3 != containerView.getLastDragMode()) {
            containerView.getCanvasMaskListView().D(150L);
        }
        u uVar = (u) list.get(0);
        u uVar2 = (u) list.get(1);
        if (z3) {
            l(str, str2, Boolean.valueOf(i3 != containerView.getLastDragMode() && (i3 == 2 || i3 == 5)), containerView);
        }
        containerView.setLastFirstText(str);
        containerView.setLastSecondText(str2);
        uVar.o(str);
        uVar2.o(str2);
        switch (i3) {
            case 1:
            case 7:
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                uVar2.m(1.0f);
                uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                containerView.X2(uVar, uVar2, i3, 0);
                break;
            case 2:
                uVar2.m(1.0f);
                uVar.m(1.0f);
                uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                break;
            case 3:
            case 4:
            case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
            default:
                uVar.m(1.0f);
                uVar2.m(1.0f);
                break;
            case 5:
                uVar.m(1.0f);
                uVar2.m(1.0f);
                uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                break;
            case 6:
            case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
            case 18:
                uVar.m(1.0f);
                uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                containerView.X2(uVar2, uVar, i3, 1);
                break;
            case 8:
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                uVar2.m(1.0f);
                uVar.m(1.0f);
                uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                break;
            case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
            case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                uVar.m(1.0f);
                uVar2.m(1.0f);
                uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                break;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                uVar2.m(1.0f);
                uVar.m(1.0f);
                uVar.n(i(i3, uVar.h(), f3, f4, str, str2, containerView));
                break;
            case 17:
                uVar.m(1.0f);
                uVar2.m(1.0f);
                uVar2.n(i(i3, uVar2.h(), f3, f4, str, str2, containerView));
                break;
        }
    }

    private void l(String str, String str2, Boolean bool, ContainerView containerView) {
        if (str != null) {
            if (str.equals(containerView.getLastFirstText())) {
                boolean a3 = containerView.getAdapter().getItem(0).a(containerView.getAdapter().t(), containerView.getAdapter().w());
                if (str.equals(containerView.getMaskPlusText()) && bool.booleanValue() && a3) {
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
                boolean a4 = containerView.getAdapter().getItem(1).a(containerView.getAdapter().t(), containerView.getAdapter().w());
                if (str2.equals(containerView.getMaskPlusText()) && bool.booleanValue() && a4) {
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

    @Override // B1.m
    public void a(List list, float f3, float f4, float f5, float f6, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Rect rect, ContainerView containerView) {
        if (containerView.getDragModes() == null || containerView.getDragModes().length == 0 || list.size() != 2 || rect.isEmpty()) {
            return;
        }
        int h3 = containerView.getAdapter().h();
        C0601d item = containerView.getAdapter().getItem(0);
        C0601d item2 = containerView.getAdapter().getItem(1);
        if (item == null || item2 == null) {
            return;
        }
        containerView.getAdapter().w();
        String string = TextUtils.isEmpty(str) ? containerView.getContext().getResources().getString(t1.j.f13634d0) : String.format(containerView.getContext().getResources().getString(t1.j.f13632c0), str);
        String string2 = TextUtils.isEmpty(str2) ? containerView.getContext().getResources().getString(t1.j.f13634d0) : String.format(containerView.getContext().getResources().getString(t1.j.f13632c0), str2);
        int u02 = containerView.u0(containerView.j1(), f3, f4);
        List P3 = containerView.P(list, u02, f3, f4, f5, f6);
        switch (u02) {
            case 1:
            case 7:
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                j(u02, P3, "", containerView.getMaskFullText(), f3, f4, containerView);
                break;
            case 2:
                if (!containerView.m1()) {
                    if (z4) {
                        string2 = containerView.getMaskPlusText();
                    }
                    j(u02, P3, "", string2, f3, f4, containerView);
                    break;
                } else {
                    if (z4) {
                        string2 = containerView.getMaskPlusText();
                    }
                    j(u02, P3, "", string2, f3, f4, containerView);
                    break;
                }
            case 3:
            case 4:
                if (!containerView.j1() ? f4 >= rect.centerY() : f3 >= rect.centerX()) {
                    if (!z3 || z4) {
                        string2 = "";
                    }
                    k(u02, P3, "", string2, f3, f4, false, containerView);
                    break;
                } else {
                    if (!z4 || z3) {
                        string = "";
                    }
                    k(u02, P3, string, "", f3, f4, false, containerView);
                    break;
                }
            case 5:
                if (!containerView.m1()) {
                    if (z3) {
                        string = containerView.getMaskPlusText();
                    }
                    j(u02, P3, string, "", f3, f4, containerView);
                    break;
                } else {
                    if (z3) {
                        string = containerView.getMaskPlusText();
                    }
                    j(u02, P3, string, "", f3, f4, containerView);
                    break;
                }
            case 6:
            case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
            case 18:
                j(u02, P3, containerView.getMaskFullText(), "", f3, f4, containerView);
                break;
            case 8:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1) {
                            if (!z6) {
                                j(u02, P3, "", "", f3, f4, containerView);
                                break;
                            } else {
                                j(u02, P3, "", item2.u() ? "" : containerView.getMaskPlusText(), f3, f4, containerView);
                                break;
                            }
                        }
                    } else if (!z5) {
                        j(u02, P3, string, "", f3, f4, containerView);
                        break;
                    } else {
                        j(u02, P3, "", "", f3, f4, containerView);
                        break;
                    }
                } else {
                    if (z6) {
                        string2 = containerView.getMaskPlusText();
                    }
                    j(u02, P3, "", string2, f3, f4, containerView);
                    break;
                }
                break;
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1) {
                            if (!z6) {
                                j(u02, P3, "", string2, f3, f4, containerView);
                                break;
                            } else {
                                j(u02, P3, "", item2.u() ? "" : containerView.getMaskPlusText(), f3, f4, containerView);
                                break;
                            }
                        }
                    } else if (!z5) {
                        j(u02, P3, string, "", f3, f4, containerView);
                        break;
                    } else {
                        j(u02, P3, "", "", f3, f4, containerView);
                        break;
                    }
                } else {
                    if (z6) {
                        string2 = containerView.getMaskPlusText();
                    }
                    j(u02, P3, "", string2, f3, f4, containerView);
                    break;
                }
                break;
            case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1) {
                            if (!z6) {
                                j(u02, P3, "", string2, f3, f4, containerView);
                                break;
                            } else {
                                j(u02, P3, "", "", f3, f4, containerView);
                                break;
                            }
                        }
                    } else if (!z5) {
                        j(u02, P3, string, "", f3, f4, containerView);
                        break;
                    } else {
                        j(u02, P3, "", "", f3, f4, containerView);
                        break;
                    }
                } else {
                    j(u02, P3, "", "", f3, f4, containerView);
                    break;
                }
                break;
            case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1) {
                            if (!z6) {
                                j(u02, P3, "", string2, f3, f4, containerView);
                                break;
                            } else {
                                j(u02, P3, "", "", f3, f4, containerView);
                                break;
                            }
                        }
                    } else if (!z5) {
                        j(u02, P3, string, "", f3, f4, containerView);
                        break;
                    } else {
                        j(u02, P3, item.u() ? "" : containerView.getMaskPlusText(), "", f3, f4, containerView);
                        break;
                    }
                } else {
                    if (z5) {
                        string = containerView.getMaskPlusText();
                    }
                    j(u02, P3, string, "", f3, f4, containerView);
                    break;
                }
                break;
            case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1) {
                            if (!z6) {
                                j(u02, P3, "", string2, f3, f4, containerView);
                                break;
                            } else {
                                j(u02, P3, "", "", f3, f4, containerView);
                                break;
                            }
                        }
                    } else if (!z5) {
                        j(u02, P3, "", "", f3, f4, containerView);
                        break;
                    } else {
                        j(u02, P3, item.u() ? "" : containerView.getMaskPlusText(), "", f3, f4, containerView);
                        break;
                    }
                } else {
                    if (z5) {
                        string = containerView.getMaskPlusText();
                    }
                    j(u02, P3, string, "", f3, f4, containerView);
                    break;
                }
                break;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                if (l.N0(containerView) || h3 == 1) {
                    if (z6) {
                        string2 = containerView.getMaskPlusText();
                    }
                    j(u02, P3, "", string2, f3, f4, containerView);
                    break;
                }
                break;
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                j(u02, P3, "", "", f3, f4, containerView);
                break;
            case 17:
                if (l.N0(containerView) || h3 == 0) {
                    if (z5) {
                        string = containerView.getMaskPlusText();
                    }
                    j(u02, P3, string, "", f3, f4, containerView);
                    break;
                }
        }
        containerView.setLastDragMode(u02);
    }

    @Override // B1.m
    public Rect b(int i3, float f3, ContainerView containerView, int i4) {
        Context context = containerView.getContext();
        Rect rect = new Rect();
        int j3 = s.j(context);
        int h3 = s.h(context);
        int G02 = l.O1(context).G0();
        int f4 = l.z0(context) ? 0 : s.f(context);
        int l02 = l.l0(context);
        containerView.B0(context);
        if (j3 >= h3) {
            float f5 = ContainerView.f10715T0;
            if (f3 > f5) {
                containerView.a3(f5);
            } else {
                f5 = f3;
            }
            float f6 = ContainerView.f10716U0;
            if (f3 < f6) {
                containerView.a3(f6);
                f5 = f6;
            }
            if (i3 == 0) {
                rect.left = 0;
                rect.top = 0;
                rect.right = (int) (((j3 - f4) * f5) - (l02 / 2));
                rect.bottom = h3;
            } else if (i3 == 1) {
                int i5 = j3 - f4;
                rect.left = (int) ((i5 * f5) + (l02 / 2));
                rect.top = 0;
                rect.right = i5;
                rect.bottom = h3;
            }
        } else if (i3 == 0) {
            rect.left = 0;
            rect.top = G02;
            rect.right = j3;
            rect.bottom = (int) (((((h3 - f4) - G02) * f3) - (l02 / 2)) + G02);
        } else if (i3 == 1) {
            rect.left = 0;
            rect.top = (int) (((r1 - G02) * f3) + (l02 / 2) + G02);
            rect.right = j3;
            rect.bottom = h3 - f4;
        }
        return rect;
    }

    @Override // B1.m
    public int c(C0600c c0600c, int i3, int i4, boolean z3) {
        if (c0600c.getCount() == 2) {
            return i4 == 2 ? 2 : 1;
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // B1.m
    public void g(List list, int i3, int i4, float f3, float f4, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, ContainerView containerView) {
        Rect rect;
        Rect rect2;
        boolean z8;
        boolean z9;
        int i6;
        int i7;
        int i8;
        int i9;
        ContainerActivity containerActivity;
        containerView.setDuringTransform(true);
        containerView.setLastDragMode(0);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Rect(((u) it.next()).h()));
        }
        int h3 = containerView.getAdapter().h();
        C0601d item = containerView.getAdapter().getItem(0);
        C0601d item2 = containerView.getAdapter().getItem(1);
        containerView.getCanvasMaskManager().m0(item);
        containerView.getCanvasMaskManager().c0(item2);
        containerView.setIndexToEnlarge(-1);
        containerView.setIndexToMax(-1);
        containerView.setIsSpringBack(false);
        boolean x3 = s.x(containerView.getContext());
        if (((Rect) arrayList.get(1)).top > ((Rect) arrayList.get(0)).top || ((Rect) arrayList.get(1)).left > ((Rect) arrayList.get(0)).left) {
            rect = (Rect) arrayList.get(0);
            rect2 = (Rect) arrayList.get(1);
        } else {
            rect = (Rect) arrayList.get(1);
            rect2 = (Rect) arrayList.get(0);
        }
        ContainerActivity O12 = l.O1(containerView.getContext());
        int j3 = s.j(containerView.getContext());
        int h4 = s.h(containerView.getContext());
        int J02 = O12.J0();
        int navigationBarHeight = l.z0(containerView.getContext()) ? 0 : containerView.getNavigationBarHeight();
        int l02 = l.l0(containerView.getContext());
        switch (i3) {
            case 1:
            case 7:
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                ((u) list.get(1)).h().set(0, 0, j3, h4);
                if (x3) {
                    ((u) list.get(0)).h().top = 0;
                    ((u) list.get(0)).h().bottom = 0;
                } else {
                    ((u) list.get(0)).h().left = 0;
                    ((u) list.get(0)).h().right = 0;
                }
                z8 = true;
                break;
            case 2:
                z8 = true;
                if (z4) {
                    containerView.setIndexToMax(1);
                    break;
                }
                z8 = true;
                break;
            case 3:
            case 4:
                if (l.N0(containerView) && z3 && z4) {
                    if (h3 == 0) {
                        containerView.setIndexToEnlarge(0);
                    } else if (h3 == 1) {
                        containerView.setIndexToEnlarge(1);
                    }
                }
                z8 = true;
                break;
            case 5:
                if (z3) {
                    containerView.setIndexToMax(0);
                }
                z8 = true;
                break;
            case 6:
            case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
            case 18:
                ((u) list.get(0)).h().set(0, 0, j3, h4);
                if (x3) {
                    ((u) list.get(1)).h().top = h4;
                    ((u) list.get(1)).h().bottom = h4;
                } else {
                    ((u) list.get(1)).h().left = j3;
                    ((u) list.get(1)).h().right = j3;
                }
                z8 = true;
                break;
            case 8:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        z8 = true;
                        if (h3 == 1 && z6 && !item2.u()) {
                            containerView.setIndexToMax(1);
                            break;
                        }
                    } else if (z5 && item.u()) {
                        containerView.setIndexToMax(0);
                        z8 = false;
                        break;
                    } else if (!containerView.getAdapter().w() && item.y() && !item.u() && (!item2.y() || item2.u())) {
                        containerView.T(1, 0, 4, true);
                    }
                } else if (z6) {
                    containerView.setIndexToMax(1);
                }
                z8 = true;
                break;
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1 && z6) {
                            containerView.setIndexToMax(1);
                            z9 = !item2.u();
                            z8 = z9;
                            break;
                        }
                    } else if (z5 && item.u()) {
                        containerView.setIndexToMax(0);
                        z8 = false;
                        break;
                    } else if (!containerView.getAdapter().w() && item.y() && !item.u() && (!item2.y() || item2.u())) {
                        containerView.T(1, 0, 4, true);
                    }
                } else if (z6) {
                    containerView.setIndexToMax(1);
                }
                z8 = true;
                break;
            case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                if (h3 == 0) {
                    if (z5 && item.u()) {
                        containerView.setIndexToMax(0);
                        z8 = false;
                        break;
                    }
                    z8 = true;
                    break;
                } else {
                    if (h3 == 1 && z6 && item2.u()) {
                        containerView.setIndexToMax(1);
                        z8 = false;
                    }
                    z8 = true;
                }
                break;
            case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                if (!l.N0(containerView)) {
                    if (h3 == 0) {
                        if (z5) {
                            containerView.setIndexToMax(0);
                            z9 = !item.u();
                            z8 = z9;
                            break;
                        }
                    } else if (h3 == 1) {
                        if (z6 && item2.u()) {
                            containerView.setIndexToMax(1);
                            z8 = false;
                            break;
                        } else if (!containerView.getAdapter().w() && item2.y() && !item2.u() && (!item.y() || item.u())) {
                            containerView.T(0, 0, 4, true);
                        }
                    }
                } else if (z5) {
                    containerView.setIndexToMax(0);
                }
                z8 = true;
                break;
            case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                if (!l.N0(containerView)) {
                    if (h3 != 0) {
                        if (h3 == 1) {
                            if (z6 && item2.u()) {
                                containerView.setIndexToMax(1);
                                z8 = false;
                                break;
                            } else if (!containerView.getAdapter().w() && item2.y() && !item2.u() && (!item.y() || item.u())) {
                                containerView.T(0, 0, 4, true);
                            }
                        }
                    } else if (z5 && !item.u()) {
                        containerView.setIndexToMax(0);
                    }
                } else if (z5) {
                    containerView.setIndexToMax(0);
                }
                z8 = true;
                break;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                if (l.N0(containerView)) {
                    if (z6) {
                        z8 = true;
                        containerView.setIndexToMax(1);
                        break;
                    }
                } else if (h3 == 1 && z6) {
                    containerView.setIndexToMax(1);
                }
                z8 = true;
                break;
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
            default:
                z8 = true;
                break;
            case 17:
                if (l.N0(containerView)) {
                    if (z5) {
                        containerView.setIndexToMax(0);
                    }
                } else if (h3 == 0 && z5) {
                    containerView.setIndexToMax(0);
                }
                z8 = true;
                break;
        }
        if (i5 != 0 || z7) {
            containerView.setIndexToEnlarge(-1);
            containerView.setIndexToMax(-1);
        }
        List arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (i5 != 0) {
            i6 = navigationBarHeight;
            i7 = h4;
        } else if (x3) {
            float f5 = f4 - f3;
            Rect rect3 = new Rect(rect.left, rect.top, rect.right, (int) (rect.bottom + f5));
            Rect rect4 = new Rect(rect2.left, (int) (rect2.top + f5), rect2.right, rect2.bottom);
            i6 = navigationBarHeight;
            float f6 = (h4 - i6) - J02;
            containerView.a3((((rect3.bottom + rect4.top) / 2) - J02) / f6);
            float splitRatio = containerView.getSplitRatio();
            float f7 = ContainerView.f10715T0;
            if (splitRatio > f7) {
                containerView.a3(f7);
                float f8 = ContainerView.f10715T0;
                i7 = h4;
                float f9 = l02 / 2;
                float f10 = J02;
                rect3.bottom = (int) (((f6 * f8) - f9) + f10);
                rect4.top = (int) ((f6 * f8) + f9 + f10);
            } else {
                i7 = h4;
                float splitRatio2 = containerView.getSplitRatio();
                float f11 = ContainerView.f10716U0;
                if (splitRatio2 < f11) {
                    containerView.a3(f11);
                    float f12 = ContainerView.f10716U0;
                    float f13 = l02 / 2;
                    float f14 = J02;
                    rect3.bottom = (int) (((f6 * f12) - f13) + f14);
                    rect4.top = (int) ((f6 * f12) + f13 + f14);
                }
            }
            rect2 = rect4;
            rect = rect3;
        } else {
            i6 = navigationBarHeight;
            i7 = h4;
            float f15 = f4 - f3;
            Rect rect5 = new Rect(rect.left, rect.top, (int) (rect.right + f15), rect.bottom);
            Rect rect6 = new Rect((int) (rect2.left + f15), rect2.top, rect2.right, rect2.bottom);
            int max = Math.max(O12.D0().left, 0);
            float f16 = j3 - i6;
            containerView.a3((((rect5.right + rect6.left) / 2) - max) / f16);
            float splitRatio3 = containerView.getSplitRatio();
            float f17 = ContainerView.f10715T0;
            if (splitRatio3 > f17) {
                containerView.a3(f17);
                float f18 = max;
                float f19 = ContainerView.f10715T0;
                float f20 = l02 / 2;
                rect5.right = (int) (((f16 * f19) + f18) - f20);
                rect6.left = (int) (f18 + (f16 * f19) + f20);
            } else {
                float splitRatio4 = containerView.getSplitRatio();
                float f21 = ContainerView.f10716U0;
                if (splitRatio4 < f21) {
                    containerView.a3(f21);
                    float f22 = max;
                    float f23 = ContainerView.f10716U0;
                    float f24 = l02 / 2;
                    rect5.right = (int) (((f16 * f23) + f22) - f24);
                    rect6.left = (int) (f22 + (f16 * f23) + f24);
                }
            }
            rect = rect5;
            rect2 = rect6;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < containerView.getAdapter().getCount()) {
            C0601d item3 = containerView.getAdapter().getItem(i10);
            if (item3 != null) {
                Rect n3 = item3.n();
                if (containerView.getIndexToEnlarge() >= 0 && i5 == 0) {
                    item3.q0(true);
                    if (i10 == 0) {
                        item3.j0(rect);
                    } else if (i10 == 1) {
                        item3.j0(rect2);
                    }
                }
                if (containerView.getIndexToMax() >= 0) {
                    item3.q0(false);
                    if (i10 == containerView.getIndexToMax()) {
                        item3.o0(z8);
                    }
                }
                Rect n4 = item3.n();
                containerActivity = O12;
                i9 = l02;
                if (n3.width() == n4.width() && n3.height() == n4.height()) {
                    i11++;
                }
                arrayList3.add(item3);
            } else {
                i9 = l02;
                containerActivity = O12;
            }
            i10++;
            O12 = containerActivity;
            l02 = i9;
        }
        int i12 = l02;
        ContainerActivity containerActivity2 = O12;
        if (i11 == 2) {
            containerView.setIsSpringBack(true);
        }
        if (containerView.getIndexToEnlarge() >= 0) {
            arrayList2.add(rect);
            arrayList2.add(rect2);
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((u) list.get(i13)).n((Rect) arrayList2.get(i13));
            }
        }
        if (containerView.getIndexToMax() >= 0) {
            if (z8) {
                h.a(containerView.getContext()).d("drag_enlarge", containerView);
            } else {
                h.a(containerView.getContext()).d("drag_narrow", containerView);
            }
            containerView.a3(0.0f);
            arrayList2 = l.d1(containerView.getContext(), arrayList3, containerView.getIndexToMax(), containerView.getAdapter().n(), false);
            Log.d(f231a, "canvasTargetPosition=" + arrayList2);
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((u) list.get(i14)).n((Rect) arrayList2.get(i14));
            }
        }
        if (containerView.getAdapter().getItem(0).H()) {
            h.a(containerView.getContext()).d("drag_stepless", containerView);
        }
        if (l.f201a.booleanValue()) {
            String str = f231a;
            StringBuilder sb = new StringBuilder();
            sb.append("endScrollSplitBarOnPhonePsPlus , targetDragMode: ");
            i8 = i3;
            sb.append(i8);
            sb.append(", indexToMax: ");
            sb.append(containerView.getIndexToMax());
            sb.append(", indexToEnlarge: ");
            sb.append(containerView.getIndexToEnlarge());
            sb.append(", screenWidth: ");
            sb.append(j3);
            sb.append(", screenHeight: ");
            sb.append(i7);
            sb.append(", statusBarHeight : ");
            sb.append(J02);
            sb.append(", adjustedNavHeight: ");
            sb.append(i6);
            sb.append(", isGestureNavMode: ");
            sb.append(l.z0(containerView.getContext()));
            sb.append(", margin: ");
            sb.append(i12);
            sb.append(", maskDatas: ");
            sb.append(list);
            Log.d(str, sb.toString());
        } else {
            i8 = i3;
        }
        ImageView h5 = ((E.c) containerView.f10732G.H().get(0)).h();
        int indexToEnlarge = containerView.getIndexToEnlarge() >= 0 ? containerView.getIndexToEnlarge() : containerView.getIndexToMax();
        if (containerView.getIndexToEnlarge() >= 0) {
            z8 = true;
        }
        if (i8 == 1 || i8 == 6 || i8 == 7 || i8 == 13 || i8 == 14 || i8 == 18) {
            containerActivity2.J1(0);
            containerActivity2.getWindow().setNavigationBarColor(0);
            containerView.getCanvasMaskListView().D(0L);
            containerView.G2(i8);
            h.a(containerView.getContext()).e("drag_close");
            containerView.getCanvasMaskManager().S(list, null, i4, -1L, containerView.n2(i8, containerView.getIndexToEnlarge(), true), containerView.k2(i8, indexToEnlarge, z8), containerView.l2());
            return;
        }
        if (containerView.getIndexToEnlarge() >= 0 || containerView.getIndexToMax() >= 0) {
            containerView.C1(i4, containerView.b0(containerView.getOriginalLocations(), containerView.getScaleProgress(), 1.0f), arrayList2);
            containerView.getCanvasMaskManager().T(list, h5, i4, containerView.n2(i8, containerView.getIndexToEnlarge(), true), containerView.k2(i8, indexToEnlarge, z8), containerView.l2());
            return;
        }
        containerView.C1(i4, containerView.getOriginalLocations(), containerView.getOriginalLocations());
        List d12 = l.d1(containerView.getContext(), arrayList3, containerView.getAdapter().h(), containerView.getAdapter().n(), false);
        if (d12.size() == list.size()) {
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((u) list.get(i15)).n((Rect) d12.get(i15));
            }
        }
        containerView.getCanvasMaskManager().T(list, h5, i4, containerView.n2(i8, containerView.getIndexToEnlarge(), true), containerView.k2(i8, indexToEnlarge, z8), containerView.l2());
    }

    @Override // B1.m
    public void h(Rect rect, ContainerView containerView) {
        int i3;
        int i4;
        float[] fArr;
        int i5;
        if (containerView.k1()) {
            float B02 = containerView.B0(containerView.getContext());
            float x02 = ContainerView.x0(containerView.getContext());
            float y02 = ContainerView.y0(containerView.getContext());
            ContainerActivity O12 = l.O1(containerView.getContext());
            if (containerView.m1()) {
                i3 = O12.G0();
                i4 = 0;
            } else if (O12.D0().left > 0) {
                i4 = O12.D0().left;
                i3 = 0;
            } else {
                i3 = 0;
                i4 = 0;
            }
            int max = Math.max(containerView.getWindowMetricsBounds().height(), containerView.getWindowMetricsBounds().width()) - i3;
            if ((l.N0(containerView) && !containerView.getAdapter().w()) || containerView.f10732G.f10323Q) {
                float f3 = i4;
                float f4 = max;
                float f5 = i3;
                double d3 = i4;
                double d4 = max;
                double d5 = i3;
                fArr = new float[]{(0.050000012f * f4) + f3 + f5, (float) (((1.0f - B02) * 0.5d * d4) + d3 + d5), (float) ((d4 * 0.5d) + d3 + d5), (float) (d3 + ((B02 + 1.0f) * 0.5d * d4) + d5), f3 + (f4 * 0.95f) + f5};
                i5 = 1;
            } else if (!containerView.y2() || rect.isEmpty()) {
                float f6 = i4;
                float f7 = max;
                float f8 = i3;
                double d6 = i4;
                double d7 = max;
                double d8 = i3;
                fArr = new float[]{(0.050000012f * f7) + f6 + f8, (float) (((1.0f - x02) * 0.5d * d7) + d6 + d8), (float) (((1.0f - y02) * 0.5d * d7) + d6 + d8), (float) (((y02 + 1.0f) * 0.5d * d7) + d6 + d8), (float) (d6 + (d7 * (x02 + 1.0f) * 0.5d) + d8), f6 + (f7 * 0.95f) + f8};
                i5 = 2;
            } else {
                float f9 = i4;
                float f10 = max;
                float f11 = i3;
                double d9 = max * 0.05d;
                fArr = new float[]{(0.050000012f * f10) + f9 + f11, (float) (r8 - d9), (float) (r8 + d9), f9 + (f10 * 0.95f) + f11};
                i5 = 3;
            }
            containerView.setDragModes(fArr);
            containerView.setDragModeType(i5);
        }
    }
}
