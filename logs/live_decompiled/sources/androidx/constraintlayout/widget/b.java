package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: e, reason: collision with root package name */
    protected int[] f4384e;

    /* renamed from: f, reason: collision with root package name */
    protected int f4385f;

    /* renamed from: g, reason: collision with root package name */
    protected Context f4386g;

    /* renamed from: h, reason: collision with root package name */
    protected q.h f4387h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f4388i;

    /* renamed from: j, reason: collision with root package name */
    protected String f4389j;

    /* renamed from: k, reason: collision with root package name */
    protected String f4390k;

    /* renamed from: l, reason: collision with root package name */
    private View[] f4391l;

    /* renamed from: m, reason: collision with root package name */
    protected HashMap f4392m;

    public b(Context context) {
        super(context);
        this.f4384e = new int[32];
        this.f4388i = false;
        this.f4391l = null;
        this.f4392m = new HashMap();
        this.f4386g = context;
        g(null);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f4386g == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int f3 = f(trim);
        if (f3 != 0) {
            this.f4392m.put(Integer.valueOf(f3), trim);
            b(f3);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void b(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i4 = this.f4385f + 1;
        int[] iArr = this.f4384e;
        if (i4 > iArr.length) {
            this.f4384e = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4384e;
        int i5 = this.f4385f;
        iArr2[i5] = i3;
        this.f4385f = i5 + 1;
    }

    private void c(String str) {
        if (str == null || str.length() == 0 || this.f4386g == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    private int e(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f4386g.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int f(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i3 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i3 = ((Integer) designInformation).intValue();
            }
        }
        if (i3 == 0 && constraintLayout != null) {
            i3 = e(constraintLayout, str);
        }
        if (i3 == 0) {
            try {
                i3 = f.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i3 == 0 ? this.f4386g.getResources().getIdentifier(str, "id", this.f4386g.getPackageName()) : i3;
    }

    protected void d(ConstraintLayout constraintLayout) {
    }

    protected void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.f4698n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == g.f4738x1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f4389j = string;
                    setIds(string);
                } else if (index == g.f4742y1) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f4390k = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4384e, this.f4385f);
    }

    public abstract void h(q.e eVar, boolean z3);

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    public void l(ConstraintLayout constraintLayout) {
        String str;
        int e3;
        if (isInEditMode()) {
            setIds(this.f4389j);
        }
        q.h hVar = this.f4387h;
        if (hVar == null) {
            return;
        }
        hVar.c();
        for (int i3 = 0; i3 < this.f4385f; i3++) {
            int i4 = this.f4384e[i3];
            View viewById = constraintLayout.getViewById(i4);
            if (viewById == null && (e3 = e(constraintLayout, (str = (String) this.f4392m.get(Integer.valueOf(i4))))) != 0) {
                this.f4384e[i3] = e3;
                this.f4392m.put(Integer.valueOf(e3), str);
                viewById = constraintLayout.getViewById(e3);
            }
            if (viewById != null) {
                this.f4387h.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f4387h.b(constraintLayout.mLayoutWidget);
    }

    public void m() {
        if (this.f4387h == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).widget = (q.e) this.f4387h;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f4389j;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f4390k;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f4388i) {
            super.onMeasure(i3, i4);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void setIds(String str) {
        this.f4389j = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f4385f = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                a(str.substring(i3));
                return;
            } else {
                a(str.substring(i3, indexOf));
                i3 = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f4390k = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f4385f = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                c(str.substring(i3));
                return;
            } else {
                c(str.substring(i3, indexOf));
                i3 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f4389j = null;
        this.f4385f = 0;
        for (int i3 : iArr) {
            b(i3);
        }
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        super.setTag(i3, obj);
        if (obj == null && this.f4389j == null) {
            b(i3);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4384e = new int[32];
        this.f4388i = false;
        this.f4391l = null;
        this.f4392m = new HashMap();
        this.f4386g = context;
        g(attributeSet);
    }
}
