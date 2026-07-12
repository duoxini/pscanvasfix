package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0252a;
import androidx.core.view.y;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class m extends C0252a {
    private final a mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class a extends C0252a {

        /* renamed from: e, reason: collision with root package name */
        final m f6611e;

        /* renamed from: f, reason: collision with root package name */
        private Map f6612f = new WeakHashMap();

        public a(m mVar) {
            this.f6611e = mVar;
        }

        C0252a c(View view) {
            return (C0252a) this.f6612f.remove(view);
        }

        void d(View view) {
            C0252a j3 = y.j(view);
            if (j3 == null || j3 == this) {
                return;
            }
            this.f6612f.put(view, j3);
        }

        @Override // androidx.core.view.C0252a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            return c0252a != null ? c0252a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0252a
        public androidx.core.view.accessibility.e getAccessibilityNodeProvider(View view) {
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            return c0252a != null ? c0252a.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            if (c0252a != null) {
                c0252a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
            if (this.f6611e.shouldIgnore() || this.f6611e.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                return;
            }
            this.f6611e.mRecyclerView.getLayoutManager().Q0(view, dVar);
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            if (c0252a != null) {
                c0252a.onInitializeAccessibilityNodeInfo(view, dVar);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
            }
        }

        @Override // androidx.core.view.C0252a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            if (c0252a != null) {
                c0252a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0252a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0252a c0252a = (C0252a) this.f6612f.get(viewGroup);
            return c0252a != null ? c0252a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0252a
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (this.f6611e.shouldIgnore() || this.f6611e.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i3, bundle);
            }
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            if (c0252a != null) {
                if (c0252a.performAccessibilityAction(view, i3, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i3, bundle)) {
                return true;
            }
            return this.f6611e.mRecyclerView.getLayoutManager().k1(view, i3, bundle);
        }

        @Override // androidx.core.view.C0252a
        public void sendAccessibilityEvent(View view, int i3) {
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            if (c0252a != null) {
                c0252a.sendAccessibilityEvent(view, i3);
            } else {
                super.sendAccessibilityEvent(view, i3);
            }
        }

        @Override // androidx.core.view.C0252a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            C0252a c0252a = (C0252a) this.f6612f.get(view);
            if (c0252a != null) {
                c0252a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public m(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        C0252a itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof a)) {
            this.mItemDelegate = new a(this);
        } else {
            this.mItemDelegate = (a) itemDelegate;
        }
    }

    public C0252a getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.C0252a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().M0(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.C0252a
    public void onInitializeAccessibilityNodeInfo(View view, androidx.core.view.accessibility.d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().O0(dVar);
    }

    @Override // androidx.core.view.C0252a
    public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
        if (super.performAccessibilityAction(view, i3, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().i1(i3, bundle);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
