package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5109a;

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        final e f5110a;

        a(e eVar) {
            this.f5110a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
            d b3 = this.f5110a.b(i3);
            if (b3 == null) {
                return null;
            }
            return b3.q0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i3) {
            List c3 = this.f5110a.c(str, i3);
            if (c3 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c3.size();
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.add(((d) c3.get(i4)).q0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i3, int i4, Bundle bundle) {
            return this.f5110a.f(i3, i4, bundle);
        }
    }

    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i3) {
            d d3 = this.f5110a.d(i3);
            if (d3 == null) {
                return null;
            }
            return d3.q0();
        }
    }

    static class c extends b {
        c(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f5110a.a(i3, d.r0(accessibilityNodeInfo), str, bundle);
        }
    }

    public e() {
        this.f5109a = new c(this);
    }

    public void a(int i3, d dVar, String str, Bundle bundle) {
    }

    public d b(int i3) {
        return null;
    }

    public List c(String str, int i3) {
        return null;
    }

    public d d(int i3) {
        return null;
    }

    public Object e() {
        return this.f5109a;
    }

    public boolean f(int i3, int i4, Bundle bundle) {
        return false;
    }

    public e(Object obj) {
        this.f5109a = obj;
    }
}
