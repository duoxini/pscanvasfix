package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.p;
import androidx.core.view.accessibility.g;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f5057a;

    /* renamed from: b, reason: collision with root package name */
    public int f5058b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f5059c = -1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Object f5103a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5104b;

        /* renamed from: c, reason: collision with root package name */
        private final Class f5105c;

        /* renamed from: d, reason: collision with root package name */
        protected final g f5106d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f5081e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f5082f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f5083g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f5084h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f5085i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f5086j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f5087k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f5088l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f5089m = new a(256, (CharSequence) null, g.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f5090n = new a(512, (CharSequence) null, g.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f5091o = new a(1024, (CharSequence) null, g.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f5092p = new a(2048, (CharSequence) null, g.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f5093q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f5094r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f5095s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f5096t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f5097u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f5098v = new a(131072, (CharSequence) null, g.C0071g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f5099w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f5100x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f5101y = new a(1048576, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f5102z = new a(2097152, (CharSequence) null, g.h.class);

        /* renamed from: A, reason: collision with root package name */
        public static final a f5060A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);

        /* renamed from: B, reason: collision with root package name */
        public static final a f5061B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);

        /* renamed from: C, reason: collision with root package name */
        public static final a f5062C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);

        /* renamed from: D, reason: collision with root package name */
        public static final a f5063D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);

        /* renamed from: E, reason: collision with root package name */
        public static final a f5064E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);

        /* renamed from: F, reason: collision with root package name */
        public static final a f5065F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);

        /* renamed from: G, reason: collision with root package name */
        public static final a f5066G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);

        /* renamed from: H, reason: collision with root package name */
        public static final a f5067H = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);

        /* renamed from: I, reason: collision with root package name */
        public static final a f5068I = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);

        /* renamed from: J, reason: collision with root package name */
        public static final a f5069J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);

        /* renamed from: K, reason: collision with root package name */
        public static final a f5070K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);

        /* renamed from: L, reason: collision with root package name */
        public static final a f5071L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, g.f.class);

        /* renamed from: M, reason: collision with root package name */
        public static final a f5072M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, g.d.class);

        /* renamed from: N, reason: collision with root package name */
        public static final a f5073N = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);

        /* renamed from: O, reason: collision with root package name */
        public static final a f5074O = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);

        /* renamed from: P, reason: collision with root package name */
        public static final a f5075P = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);

        /* renamed from: Q, reason: collision with root package name */
        public static final a f5076Q = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);

        /* renamed from: R, reason: collision with root package name */
        public static final a f5077R = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START, R.id.accessibilityActionDragStart, null, null, null);

        /* renamed from: S, reason: collision with root package name */
        public static final a f5078S = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP, R.id.accessibilityActionDragDrop, null, null, null);

        /* renamed from: T, reason: collision with root package name */
        public static final a f5079T = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL, R.id.accessibilityActionDragCancel, null, null, null);

        /* renamed from: U, reason: collision with root package name */
        public static final a f5080U = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS, R.id.accessibilityActionShowTextSuggestions, null, null, null);

        public a(int i3, CharSequence charSequence) {
            this(null, i3, charSequence, null, null);
        }

        public a a(CharSequence charSequence, g gVar) {
            return new a(null, this.f5104b, charSequence, gVar, this.f5105c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f5103a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f5103a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f5106d == null) {
                return false;
            }
            Class cls = this.f5105c;
            if (cls != null) {
                try {
                    p.a(cls.getDeclaredConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e3) {
                    Class cls2 = this.f5105c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e3);
                }
            }
            return this.f5106d.perform(view, null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f5103a;
            return obj2 == null ? aVar.f5103a == null : obj2.equals(aVar.f5103a);
        }

        public int hashCode() {
            Object obj = this.f5103a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i3, CharSequence charSequence, g gVar) {
            this(null, i3, charSequence, gVar, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i3, CharSequence charSequence, Class cls) {
            this(null, i3, charSequence, null, cls);
        }

        a(Object obj, int i3, CharSequence charSequence, g gVar, Class cls) {
            this.f5104b = i3;
            this.f5106d = gVar;
            if (obj == null) {
                this.f5103a = new AccessibilityNodeInfo.AccessibilityAction(i3, charSequence);
            } else {
                this.f5103a = obj;
            }
            this.f5105c = cls;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f5107a;

        b(Object obj) {
            this.f5107a = obj;
        }

        public static b a(int i3, int i4, boolean z3) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z3));
        }

        public static b b(int i3, int i4, boolean z3, int i5) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i3, i4, z3, i5));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final Object f5108a;

        c(Object obj) {
            this.f5108a = obj;
        }

        public static c a(int i3, int i4, int i5, int i6, boolean z3, boolean z4) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, z3, z4));
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5057a = accessibilityNodeInfo;
    }

    public static d F() {
        return r0(AccessibilityNodeInfo.obtain());
    }

    public static d G(View view) {
        return r0(AccessibilityNodeInfo.obtain(view));
    }

    public static d H(d dVar) {
        return r0(AccessibilityNodeInfo.obtain(dVar.f5057a));
    }

    private List e(String str) {
        ArrayList<Integer> integerArrayList = this.f5057a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f5057a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String g(int i3) {
        if (i3 == 1) {
            return "ACTION_FOCUS";
        }
        if (i3 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i3) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                return "ACTION_CLICK";
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP_MARGINS /* 32 */:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i3) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i3) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i3) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] m(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static d r0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    private boolean t() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public boolean A() {
        return this.f5057a.isLongClickable();
    }

    public boolean B() {
        return this.f5057a.isPassword();
    }

    public boolean C() {
        return this.f5057a.isScrollable();
    }

    public boolean D() {
        return this.f5057a.isSelected();
    }

    public boolean E() {
        return this.f5057a.isShowingHintText();
    }

    public boolean I(int i3, Bundle bundle) {
        return this.f5057a.performAction(i3, bundle);
    }

    public void J() {
        this.f5057a.recycle();
    }

    public boolean K(a aVar) {
        return this.f5057a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f5103a);
    }

    public void L(boolean z3) {
        this.f5057a.setAccessibilityFocused(z3);
    }

    public void M(Rect rect) {
        this.f5057a.setBoundsInParent(rect);
    }

    public void N(Rect rect) {
        this.f5057a.setBoundsInScreen(rect);
    }

    public void O(boolean z3) {
        this.f5057a.setCheckable(z3);
    }

    public void P(boolean z3) {
        this.f5057a.setChecked(z3);
    }

    public void Q(CharSequence charSequence) {
        this.f5057a.setClassName(charSequence);
    }

    public void R(boolean z3) {
        this.f5057a.setClickable(z3);
    }

    public void S(Object obj) {
        this.f5057a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f5107a);
    }

    public void T(Object obj) {
        this.f5057a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f5108a);
    }

    public void U(CharSequence charSequence) {
        this.f5057a.setContentDescription(charSequence);
    }

    public void V(boolean z3) {
        this.f5057a.setDismissable(z3);
    }

    public void W(boolean z3) {
        this.f5057a.setEnabled(z3);
    }

    public void X(CharSequence charSequence) {
        this.f5057a.setError(charSequence);
    }

    public void Y(boolean z3) {
        this.f5057a.setFocusable(z3);
    }

    public void Z(boolean z3) {
        this.f5057a.setFocused(z3);
    }

    public void a(int i3) {
        this.f5057a.addAction(i3);
    }

    public void a0(boolean z3) {
        this.f5057a.setHeading(z3);
    }

    public void b(a aVar) {
        this.f5057a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f5103a);
    }

    public void b0(CharSequence charSequence) {
        this.f5057a.setHintText(charSequence);
    }

    public void c(View view, int i3) {
        this.f5057a.addChild(view, i3);
    }

    public void c0(View view) {
        this.f5057a.setLabelFor(view);
    }

    public void d(CharSequence charSequence, View view) {
    }

    public void d0(int i3) {
        this.f5057a.setMaxTextLength(i3);
    }

    public void e0(CharSequence charSequence) {
        this.f5057a.setPackageName(charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5057a;
        if (accessibilityNodeInfo == null) {
            if (dVar.f5057a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f5057a)) {
            return false;
        }
        return this.f5059c == dVar.f5059c && this.f5058b == dVar.f5058b;
    }

    public List f() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f5057a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new a(actionList.get(i3)));
        }
        return arrayList;
    }

    public void f0(CharSequence charSequence) {
        this.f5057a.setPaneTitle(charSequence);
    }

    public void g0(View view) {
        this.f5058b = -1;
        this.f5057a.setParent(view);
    }

    public int h() {
        return this.f5057a.getActions();
    }

    public void h0(View view, int i3) {
        this.f5058b = i3;
        this.f5057a.setParent(view, i3);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5057a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i(Rect rect) {
        this.f5057a.getBoundsInParent(rect);
    }

    public void i0(boolean z3) {
        this.f5057a.setScreenReaderFocusable(z3);
    }

    public void j(Rect rect) {
        this.f5057a.getBoundsInScreen(rect);
    }

    public void j0(boolean z3) {
        this.f5057a.setScrollable(z3);
    }

    public int k() {
        return this.f5057a.getChildCount();
    }

    public void k0(boolean z3) {
        this.f5057a.setShowingHintText(z3);
    }

    public CharSequence l() {
        return this.f5057a.getClassName();
    }

    public void l0(View view, int i3) {
        this.f5059c = i3;
        this.f5057a.setSource(view, i3);
    }

    public void m0(CharSequence charSequence) {
        if (androidx.core.os.a.a()) {
            this.f5057a.setStateDescription(charSequence);
        } else {
            this.f5057a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public CharSequence n() {
        return this.f5057a.getContentDescription();
    }

    public void n0(CharSequence charSequence) {
        this.f5057a.setText(charSequence);
    }

    public Bundle o() {
        return this.f5057a.getExtras();
    }

    public void o0(View view) {
        this.f5057a.setTraversalAfter(view);
    }

    public CharSequence p() {
        return this.f5057a.getPackageName();
    }

    public void p0(boolean z3) {
        this.f5057a.setVisibleToUser(z3);
    }

    public CharSequence q() {
        if (!t()) {
            return this.f5057a.getText();
        }
        List e3 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List e4 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List e5 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List e6 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f5057a.getText(), 0, this.f5057a.getText().length()));
        for (int i3 = 0; i3 < e3.size(); i3++) {
            spannableString.setSpan(new androidx.core.view.accessibility.a(((Integer) e6.get(i3)).intValue(), this, o().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) e3.get(i3)).intValue(), ((Integer) e4.get(i3)).intValue(), ((Integer) e5.get(i3)).intValue());
        }
        return spannableString;
    }

    public AccessibilityNodeInfo q0() {
        return this.f5057a;
    }

    public String r() {
        return androidx.core.os.a.b() ? this.f5057a.getUniqueId() : this.f5057a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String s() {
        return this.f5057a.getViewIdResourceName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        i(rect);
        sb.append("; boundsInParent: " + rect);
        j(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(p());
        sb.append("; className: ");
        sb.append(l());
        sb.append("; text: ");
        sb.append(q());
        sb.append("; contentDescription: ");
        sb.append(n());
        sb.append("; viewId: ");
        sb.append(s());
        sb.append("; uniqueId: ");
        sb.append(r());
        sb.append("; checkable: ");
        sb.append(u());
        sb.append("; checked: ");
        sb.append(v());
        sb.append("; focusable: ");
        sb.append(y());
        sb.append("; focused: ");
        sb.append(z());
        sb.append("; selected: ");
        sb.append(D());
        sb.append("; clickable: ");
        sb.append(w());
        sb.append("; longClickable: ");
        sb.append(A());
        sb.append("; enabled: ");
        sb.append(x());
        sb.append("; password: ");
        sb.append(B());
        sb.append("; scrollable: " + C());
        sb.append("; [");
        List f3 = f();
        for (int i3 = 0; i3 < f3.size(); i3++) {
            a aVar = (a) f3.get(i3);
            String g3 = g(aVar.b());
            if (g3.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                g3 = aVar.c().toString();
            }
            sb.append(g3);
            if (i3 != f3.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean u() {
        return this.f5057a.isCheckable();
    }

    public boolean v() {
        return this.f5057a.isChecked();
    }

    public boolean w() {
        return this.f5057a.isClickable();
    }

    public boolean x() {
        return this.f5057a.isEnabled();
    }

    public boolean y() {
        return this.f5057a.isFocusable();
    }

    public boolean z() {
        return this.f5057a.isFocused();
    }
}
