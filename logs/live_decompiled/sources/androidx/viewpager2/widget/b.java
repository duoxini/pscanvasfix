package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    private final List f6820a;

    b(int i3) {
        this.f6820a = new ArrayList(i3);
    }

    private void b(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    void a(ViewPager2.i iVar) {
        this.f6820a.add(iVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i3) {
        try {
            Iterator it = this.f6820a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).onPageScrollStateChanged(i3);
            }
        } catch (ConcurrentModificationException e3) {
            b(e3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrolled(int i3, float f3, int i4) {
        try {
            Iterator it = this.f6820a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).onPageScrolled(i3, f3, i4);
            }
        } catch (ConcurrentModificationException e3) {
            b(e3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageSelected(int i3) {
        try {
            Iterator it = this.f6820a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).onPageSelected(i3);
            }
        } catch (ConcurrentModificationException e3) {
            b(e3);
        }
    }
}
