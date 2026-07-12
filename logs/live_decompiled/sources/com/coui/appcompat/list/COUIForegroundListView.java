package com.coui.appcompat.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.J;
import com.coui.appcompat.poplist.n;
import com.coui.appcompat.poplist.s;

/* loaded from: classes.dex */
public class COUIForegroundListView extends ListView {

    /* renamed from: e, reason: collision with root package name */
    private int f8081e;

    /* renamed from: f, reason: collision with root package name */
    private int f8082f;

    /* renamed from: g, reason: collision with root package name */
    private J f8083g;

    /* renamed from: h, reason: collision with root package name */
    private MenuItem f8084h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f8085i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8086j;

    /* renamed from: k, reason: collision with root package name */
    private float f8087k;

    /* renamed from: l, reason: collision with root package name */
    private Path f8088l;

    /* renamed from: m, reason: collision with root package name */
    private RectF f8089m;

    public COUIForegroundListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8085i = new Paint();
        this.f8087k = 0.0f;
        this.f8089m = null;
        b(context);
    }

    private Path a() {
        Path path = this.f8088l;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f3 = this.f8087k;
        path.addRoundRect(rectF, new float[]{f3, f3, f3, f3, f3, f3, f3, f3}, Path.Direction.CW);
        return this.f8088l;
    }

    private void b(Context context) {
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.f8081e = 21;
            this.f8082f = 22;
        } else {
            this.f8081e = 22;
            this.f8082f = 21;
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return this.f8086j || super.isInTouchMode();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f8087k > 0.0f) {
            canvas.clipPath(this.f8088l);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        MenuAdapter menuAdapter;
        int i3;
        int pointToPosition;
        int i4;
        if (this.f8083g != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i3 = headerViewListAdapter.getHeadersCount();
                menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
            } else {
                menuAdapter = (MenuAdapter) adapter;
                i3 = 0;
            }
            MenuItemImpl item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i4 = pointToPosition - i3) < 0 || i4 >= menuAdapter.getCount()) ? null : menuAdapter.getItem(i4);
            MenuItem menuItem = this.f8084h;
            if (menuItem != item) {
                MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                if (menuItem != null) {
                    this.f8083g.onItemHoverExit(adapterMenu, menuItem);
                }
                this.f8084h = item;
                if (item != null) {
                    this.f8083g.onItemHoverEnter(adapterMenu, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        View selectedView = getSelectedView();
        if (!(selectedView instanceof LinearLayout)) {
            return super.onKeyDown(i3, keyEvent);
        }
        LinearLayout linearLayout = (LinearLayout) selectedView;
        ListAdapter adapter = getAdapter();
        if (linearLayout != null && i3 == this.f8081e && (adapter instanceof n)) {
            if (linearLayout.isEnabled() && ((s) ((n) adapter).getItem(getSelectedItemPosition())).w()) {
                performItemClick(linearLayout, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (linearLayout == null || i3 != this.f8082f) {
            return super.onKeyDown(i3, keyEvent);
        }
        setSelection(-1);
        return true;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        Path path = this.f8088l;
        if (path == null) {
            this.f8088l = new Path();
        } else {
            path.reset();
        }
        this.f8089m = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        a();
    }

    public void setHoverListener(J j3) {
        this.f8083g = j3;
    }

    public void setListSelectionHidden(boolean z3) {
        this.f8086j = z3;
    }

    public void setRadius(float f3) {
        this.f8087k = f3;
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8085i = new Paint();
        this.f8087k = 0.0f;
        this.f8089m = null;
        b(context);
    }
}
