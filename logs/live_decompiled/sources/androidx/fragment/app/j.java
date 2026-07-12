package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class j implements LayoutInflater.Factory2 {

    /* renamed from: e, reason: collision with root package name */
    final l f5444e;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ r f5445e;

        a(r rVar) {
            this.f5445e = rVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k3 = this.f5445e.k();
            this.f5445e.m();
            z.n((ViewGroup) k3.mView.getParent(), j.this.f5444e).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    j(l lVar) {
        this.f5444e = lVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        r v3;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f5444e);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E.c.f352d);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(E.c.f353e);
        }
        int resourceId = obtainStyledAttributes.getResourceId(E.c.f354f, -1);
        String string = obtainStyledAttributes.getString(E.c.f355g);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !h.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment g02 = resourceId != -1 ? this.f5444e.g0(resourceId) : null;
        if (g02 == null && string != null) {
            g02 = this.f5444e.h0(string);
        }
        if (g02 == null && id != -1) {
            g02 = this.f5444e.g0(id);
        }
        if (g02 == null) {
            g02 = this.f5444e.p0().a(context.getClassLoader(), attributeValue);
            g02.mFromLayout = true;
            g02.mFragmentId = resourceId != 0 ? resourceId : id;
            g02.mContainerId = id;
            g02.mTag = string;
            g02.mInLayout = true;
            l lVar = this.f5444e;
            g02.mFragmentManager = lVar;
            g02.mHost = lVar.s0();
            g02.onInflate(this.f5444e.s0().f(), attributeSet, g02.mSavedFragmentState);
            v3 = this.f5444e.g(g02);
            if (l.E0(2)) {
                Log.v("FragmentManager", "Fragment " + g02 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (g02.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            g02.mInLayout = true;
            l lVar2 = this.f5444e;
            g02.mFragmentManager = lVar2;
            g02.mHost = lVar2.s0();
            g02.onInflate(this.f5444e.s0().f(), attributeSet, g02.mSavedFragmentState);
            v3 = this.f5444e.v(g02);
            if (l.E0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + g02 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        g02.mContainer = (ViewGroup) view;
        v3.m();
        v3.j();
        View view2 = g02.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (g02.mView.getTag() == null) {
            g02.mView.setTag(string);
        }
        g02.mView.addOnAttachStateChangeListener(new a(v3));
        return g02.mView;
    }
}
