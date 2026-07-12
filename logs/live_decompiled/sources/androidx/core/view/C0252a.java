package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.core.view.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0252a {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0070a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final C0252a f5053a;

        C0070a(C0252a c0252a) {
            this.f5053a = c0252a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f5053a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.view.accessibility.e accessibilityNodeProvider = this.f5053a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f5053a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.view.accessibility.d r02 = androidx.core.view.accessibility.d.r0(accessibilityNodeInfo);
            r02.i0(y.R(view));
            r02.a0(y.M(view));
            r02.f0(y.m(view));
            r02.m0(y.E(view));
            this.f5053a.onInitializeAccessibilityNodeInfo(view, r02);
            r02.d(accessibilityNodeInfo.getText(), view);
            List<d.a> actionList = C0252a.getActionList(view);
            for (int i3 = 0; i3 < actionList.size(); i3++) {
                r02.b(actionList.get(i3));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f5053a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f5053a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return this.f5053a.performAccessibilityAction(view, i3, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            this.f5053a.sendAccessibilityEvent(view, i3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f5053a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    /* renamed from: androidx.core.view.a$b */
    static class b {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i3, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i3, bundle);
        }
    }

    public C0252a() {
        this(DEFAULT_DELEGATE);
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] m3 = androidx.core.view.accessibility.d.m(view.createAccessibilityNodeInfo().getText());
            for (int i3 = 0; m3 != null && i3 < m3.length; i3++) {
                if (clickableSpan.equals(m3[i3])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b(int i3, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(u.b.f13704I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    static List<d.a> getActionList(View view) {
        List<d.a> list = (List) view.getTag(u.b.f13703H);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public androidx.core.view.accessibility.e getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider a3 = b.a(this.mOriginalDelegate, view);
        if (a3 != null) {
            return new androidx.core.view.accessibility.e(a3);
        }
        return null;
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, dVar.q0());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
        List<d.a> actionList = getActionList(view);
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= actionList.size()) {
                break;
            }
            d.a aVar = actionList.get(i4);
            if (aVar.b() == i3) {
                z3 = aVar.d(view, bundle);
                break;
            }
            i4++;
        }
        if (!z3) {
            z3 = b.b(this.mOriginalDelegate, view, i3, bundle);
        }
        return (z3 || i3 != u.b.f13711a || bundle == null) ? z3 : b(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void sendAccessibilityEvent(View view, int i3) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i3);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0252a(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new C0070a(this);
    }
}
