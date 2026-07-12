package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import e.AbstractC0339a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class F extends ListView {

    /* renamed from: e, reason: collision with root package name */
    private final Rect f3903e;

    /* renamed from: f, reason: collision with root package name */
    private int f3904f;

    /* renamed from: g, reason: collision with root package name */
    private int f3905g;

    /* renamed from: h, reason: collision with root package name */
    private int f3906h;

    /* renamed from: i, reason: collision with root package name */
    private int f3907i;

    /* renamed from: j, reason: collision with root package name */
    private int f3908j;

    /* renamed from: k, reason: collision with root package name */
    private d f3909k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3910l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3911m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3912n;

    /* renamed from: o, reason: collision with root package name */
    private androidx.core.view.E f3913o;

    /* renamed from: p, reason: collision with root package name */
    private androidx.core.widget.f f3914p;

    /* renamed from: q, reason: collision with root package name */
    f f3915q;

    static class a {
        static void a(View view, float f3, float f4) {
            view.drawableHotspotChanged(f3, f4);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f3916a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f3917b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f3918c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f3919d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f3916a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f3917b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f3918c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f3919d = true;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            }
        }

        static boolean a() {
            return f3919d;
        }

        static void b(F f3, int i3, View view) {
            try {
                f3916a.invoke(f3, Integer.valueOf(i3), view, Boolean.FALSE, -1, -1);
                f3917b.invoke(f3, Integer.valueOf(i3));
                f3918c.invoke(f3, Integer.valueOf(i3));
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z3) {
            absListView.setSelectedChildViewEnabled(z3);
        }
    }

    private static class d extends g.c {

        /* renamed from: f, reason: collision with root package name */
        private boolean f3920f;

        d(Drawable drawable) {
            super(drawable);
            this.f3920f = true;
        }

        void b(boolean z3) {
            this.f3920f = z3;
        }

        @Override // g.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f3920f) {
                super.draw(canvas);
            }
        }

        @Override // g.c, android.graphics.drawable.Drawable
        public void setHotspot(float f3, float f4) {
            if (this.f3920f) {
                super.setHotspot(f3, f4);
            }
        }

        @Override // g.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i3, int i4, int i5, int i6) {
            if (this.f3920f) {
                super.setHotspotBounds(i3, i4, i5, i6);
            }
        }

        @Override // g.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f3920f) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // g.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z3, boolean z4) {
            if (this.f3920f) {
                return super.setVisible(z3, z4);
            }
            return false;
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Field f3921a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
            f3921a = field;
        }

        static boolean a(AbsListView absListView) {
            Field field = f3921a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z3) {
            Field field = f3921a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z3));
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void a() {
            F f3 = F.this;
            f3.f3915q = null;
            f3.removeCallbacks(this);
        }

        public void b() {
            F.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            F f3 = F.this;
            f3.f3915q = null;
            f3.drawableStateChanged();
        }
    }

    F(Context context, boolean z3) {
        super(context, null, AbstractC0339a.f11109x);
        this.f3903e = new Rect();
        this.f3904f = 0;
        this.f3905g = 0;
        this.f3906h = 0;
        this.f3907i = 0;
        this.f3911m = z3;
        setCacheColorHint(0);
    }

    private void a() {
        this.f3912n = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f3908j - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.E e3 = this.f3913o;
        if (e3 != null) {
            e3.c();
            this.f3913o = null;
        }
    }

    private void b(View view, int i3) {
        performItemClick(view, i3, getItemIdAtPosition(i3));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f3903e.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f3903e);
        selector.draw(canvas);
    }

    private void f(int i3, View view) {
        Rect rect = this.f3903e;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f3904f;
        rect.top -= this.f3905g;
        rect.right += this.f3906h;
        rect.bottom += this.f3907i;
        boolean k3 = k();
        if (view.isEnabled() != k3) {
            l(!k3);
            if (i3 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i3, View view) {
        Drawable selector = getSelector();
        boolean z3 = (selector == null || i3 == -1) ? false : true;
        if (z3) {
            selector.setVisible(false, false);
        }
        f(i3, view);
        if (z3) {
            Rect rect = this.f3903e;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.e(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i3, View view, float f3, float f4) {
        g(i3, view);
        Drawable selector = getSelector();
        if (selector == null || i3 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.e(selector, f3, f4);
    }

    private void i(View view, int i3, float f3, float f4) {
        View childAt;
        this.f3912n = true;
        a.a(this, f3, f4);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.f3908j;
        if (i4 != -1 && (childAt = getChildAt(i4 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f3908j = i3;
        a.a(view, f3 - view.getLeft(), f4 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i3, view, f3, f4);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z3) {
        d dVar = this.f3909k;
        if (dVar != null) {
            dVar.b(z3);
        }
    }

    private boolean k() {
        return androidx.core.os.a.b() ? c.a(this) : e.a(this);
    }

    private void l(boolean z3) {
        if (androidx.core.os.a.b()) {
            c.b(this, z3);
        } else {
            e.b(this, z3);
        }
    }

    private boolean m() {
        return this.f3912n;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i3, int i4, int i5, int i6, int i7) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i8 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        View view = null;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            view.measure(i3, i12 > 0 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i6) {
                return (i7 < 0 || i9 <= i7 || i11 <= 0 || i8 == i6) ? i6 : i11;
            }
            if (i7 >= 0 && i9 >= i7) {
                i11 = i8;
            }
            i9++;
        }
        return i8;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f3915q != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.f r9 = r7.f3914p
            if (r9 != 0) goto L5a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f3914p = r9
        L5a:
            androidx.core.widget.f r9 = r7.f3914p
            r9.m(r1)
            androidx.core.widget.f r9 = r7.f3914p
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.f r7 = r7.f3914p
            if (r7 == 0) goto L6c
            r7.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.F.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f3911m || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f3911m || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f3911m || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f3911m && this.f3910l) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f3915q = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f3915q == null) {
            f fVar = new f();
            this.f3915q = fVar;
            fVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (b.a()) {
                        b.b(this, pointToPosition, childAt);
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                n();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f3908j = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f3915q;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z3) {
        this.f3910l = z3;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f3909k = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3904f = rect.left;
        this.f3905g = rect.top;
        this.f3906h = rect.right;
        this.f3907i = rect.bottom;
    }
}
