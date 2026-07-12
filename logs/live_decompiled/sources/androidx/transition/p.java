package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.l;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class p extends l {

    /* renamed from: g, reason: collision with root package name */
    int f6740g;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f6738e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private boolean f6739f = true;

    /* renamed from: h, reason: collision with root package name */
    boolean f6741h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f6742i = 0;

    class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f6743a;

        a(l lVar) {
            this.f6743a = lVar;
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            this.f6743a.runAnimators();
            lVar.removeListener(this);
        }
    }

    static class b extends m {

        /* renamed from: a, reason: collision with root package name */
        p f6745a;

        b(p pVar) {
            this.f6745a = pVar;
        }

        @Override // androidx.transition.m, androidx.transition.l.g
        public void c(l lVar) {
            p pVar = this.f6745a;
            if (pVar.f6741h) {
                return;
            }
            pVar.start();
            this.f6745a.f6741h = true;
        }

        @Override // androidx.transition.l.g
        public void e(l lVar) {
            p pVar = this.f6745a;
            int i3 = pVar.f6740g - 1;
            pVar.f6740g = i3;
            if (i3 == 0) {
                pVar.f6741h = false;
                pVar.end();
            }
            lVar.removeListener(this);
        }
    }

    private void K() {
        b bVar = new b(this);
        Iterator it = this.f6738e.iterator();
        while (it.hasNext()) {
            ((l) it.next()).addListener(bVar);
        }
        this.f6740g = this.f6738e.size();
    }

    private void x(l lVar) {
        this.f6738e.add(lVar);
        lVar.mParent = this;
    }

    @Override // androidx.transition.l
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public p removeListener(l.g gVar) {
        return (p) super.removeListener(gVar);
    }

    @Override // androidx.transition.l
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public p removeTarget(int i3) {
        for (int i4 = 0; i4 < this.f6738e.size(); i4++) {
            ((l) this.f6738e.get(i4)).removeTarget(i3);
        }
        return (p) super.removeTarget(i3);
    }

    @Override // androidx.transition.l
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public p removeTarget(View view) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).removeTarget(view);
        }
        return (p) super.removeTarget(view);
    }

    @Override // androidx.transition.l
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public p removeTarget(Class cls) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).removeTarget((Class<?>) cls);
        }
        return (p) super.removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.l
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public p removeTarget(String str) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).removeTarget(str);
        }
        return (p) super.removeTarget(str);
    }

    @Override // androidx.transition.l
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public p setDuration(long j3) {
        ArrayList arrayList;
        super.setDuration(j3);
        if (this.mDuration >= 0 && (arrayList = this.f6738e) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((l) this.f6738e.get(i3)).setDuration(j3);
            }
        }
        return this;
    }

    @Override // androidx.transition.l
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public p setInterpolator(TimeInterpolator timeInterpolator) {
        this.f6742i |= 1;
        ArrayList arrayList = this.f6738e;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((l) this.f6738e.get(i3)).setInterpolator(timeInterpolator);
            }
        }
        return (p) super.setInterpolator(timeInterpolator);
    }

    public p H(int i3) {
        if (i3 == 0) {
            this.f6739f = true;
        } else {
            if (i3 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i3);
            }
            this.f6739f = false;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.l
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public p setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.l
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public p setStartDelay(long j3) {
        return (p) super.setStartDelay(j3);
    }

    @Override // androidx.transition.l
    protected void cancel() {
        super.cancel();
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).cancel();
        }
    }

    @Override // androidx.transition.l
    public void captureEndValues(r rVar) {
        if (isValidTarget(rVar.f6750b)) {
            Iterator it = this.f6738e.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.isValidTarget(rVar.f6750b)) {
                    lVar.captureEndValues(rVar);
                    rVar.f6751c.add(lVar);
                }
            }
        }
    }

    @Override // androidx.transition.l
    void capturePropagationValues(r rVar) {
        super.capturePropagationValues(rVar);
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).capturePropagationValues(rVar);
        }
    }

    @Override // androidx.transition.l
    public void captureStartValues(r rVar) {
        if (isValidTarget(rVar.f6750b)) {
            Iterator it = this.f6738e.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.isValidTarget(rVar.f6750b)) {
                    lVar.captureStartValues(rVar);
                    rVar.f6751c.add(lVar);
                }
            }
        }
    }

    @Override // androidx.transition.l
    protected void createAnimators(ViewGroup viewGroup, s sVar, s sVar2, ArrayList arrayList, ArrayList arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            l lVar = (l) this.f6738e.get(i3);
            if (startDelay > 0 && (this.f6739f || i3 == 0)) {
                long startDelay2 = lVar.getStartDelay();
                if (startDelay2 > 0) {
                    lVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    lVar.setStartDelay(startDelay);
                }
            }
            lVar.createAnimators(viewGroup, sVar, sVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.l
    public l excludeTarget(View view, boolean z3) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).excludeTarget(view, z3);
        }
        return super.excludeTarget(view, z3);
    }

    @Override // androidx.transition.l
    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).forceToEnd(viewGroup);
        }
    }

    @Override // androidx.transition.l
    public void pause(View view) {
        super.pause(view);
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).pause(view);
        }
    }

    @Override // androidx.transition.l
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public p addListener(l.g gVar) {
        return (p) super.addListener(gVar);
    }

    @Override // androidx.transition.l
    public void resume(View view) {
        super.resume(view);
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).resume(view);
        }
    }

    @Override // androidx.transition.l
    protected void runAnimators() {
        if (this.f6738e.isEmpty()) {
            start();
            end();
            return;
        }
        K();
        if (this.f6739f) {
            Iterator it = this.f6738e.iterator();
            while (it.hasNext()) {
                ((l) it.next()).runAnimators();
            }
            return;
        }
        for (int i3 = 1; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3 - 1)).addListener(new a((l) this.f6738e.get(i3)));
        }
        l lVar = (l) this.f6738e.get(0);
        if (lVar != null) {
            lVar.runAnimators();
        }
    }

    @Override // androidx.transition.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public p addTarget(int i3) {
        for (int i4 = 0; i4 < this.f6738e.size(); i4++) {
            ((l) this.f6738e.get(i4)).addTarget(i3);
        }
        return (p) super.addTarget(i3);
    }

    @Override // androidx.transition.l
    void setCanRemoveViews(boolean z3) {
        super.setCanRemoveViews(z3);
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).setCanRemoveViews(z3);
        }
    }

    @Override // androidx.transition.l
    public void setEpicenterCallback(l.f fVar) {
        super.setEpicenterCallback(fVar);
        this.f6742i |= 8;
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).setEpicenterCallback(fVar);
        }
    }

    @Override // androidx.transition.l
    public void setPathMotion(AbstractC0287g abstractC0287g) {
        super.setPathMotion(abstractC0287g);
        this.f6742i |= 4;
        if (this.f6738e != null) {
            for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
                ((l) this.f6738e.get(i3)).setPathMotion(abstractC0287g);
            }
        }
    }

    @Override // androidx.transition.l
    public void setPropagation(o oVar) {
        super.setPropagation(oVar);
        this.f6742i |= 2;
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((l) this.f6738e.get(i3)).setPropagation(oVar);
        }
    }

    @Override // androidx.transition.l
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public p addTarget(View view) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).addTarget(view);
        }
        return (p) super.addTarget(view);
    }

    @Override // androidx.transition.l
    String toString(String str) {
        String lVar = super.toString(str);
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(lVar);
            sb.append("\n");
            sb.append(((l) this.f6738e.get(i3)).toString(str + "  "));
            lVar = sb.toString();
        }
        return lVar;
    }

    @Override // androidx.transition.l
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public p addTarget(Class cls) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).addTarget((Class<?>) cls);
        }
        return (p) super.addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.l
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public p addTarget(String str) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).addTarget(str);
        }
        return (p) super.addTarget(str);
    }

    public p w(l lVar) {
        x(lVar);
        long j3 = this.mDuration;
        if (j3 >= 0) {
            lVar.setDuration(j3);
        }
        if ((this.f6742i & 1) != 0) {
            lVar.setInterpolator(getInterpolator());
        }
        if ((this.f6742i & 2) != 0) {
            getPropagation();
            lVar.setPropagation(null);
        }
        if ((this.f6742i & 4) != 0) {
            lVar.setPathMotion(getPathMotion());
        }
        if ((this.f6742i & 8) != 0) {
            lVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public l y(int i3) {
        if (i3 < 0 || i3 >= this.f6738e.size()) {
            return null;
        }
        return (l) this.f6738e.get(i3);
    }

    public int z() {
        return this.f6738e.size();
    }

    @Override // androidx.transition.l
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public l mo0clone() {
        p pVar = (p) super.mo0clone();
        pVar.f6738e = new ArrayList();
        int size = this.f6738e.size();
        for (int i3 = 0; i3 < size; i3++) {
            pVar.x(((l) this.f6738e.get(i3)).mo0clone());
        }
        return pVar;
    }

    @Override // androidx.transition.l
    public l excludeTarget(String str, boolean z3) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).excludeTarget(str, z3);
        }
        return super.excludeTarget(str, z3);
    }

    @Override // androidx.transition.l
    public l excludeTarget(int i3, boolean z3) {
        for (int i4 = 0; i4 < this.f6738e.size(); i4++) {
            ((l) this.f6738e.get(i4)).excludeTarget(i3, z3);
        }
        return super.excludeTarget(i3, z3);
    }

    @Override // androidx.transition.l
    public l excludeTarget(Class cls, boolean z3) {
        for (int i3 = 0; i3 < this.f6738e.size(); i3++) {
            ((l) this.f6738e.get(i3)).excludeTarget((Class<?>) cls, z3);
        }
        return super.excludeTarget((Class<?>) cls, z3);
    }
}
