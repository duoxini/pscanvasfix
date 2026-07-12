package y;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import y.C0641b;

/* renamed from: y.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0640a extends BaseAdapter implements Filterable, C0641b.a {

    /* renamed from: e, reason: collision with root package name */
    protected boolean f14440e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f14441f;

    /* renamed from: g, reason: collision with root package name */
    protected Cursor f14442g;

    /* renamed from: h, reason: collision with root package name */
    protected Context f14443h;

    /* renamed from: i, reason: collision with root package name */
    protected int f14444i;

    /* renamed from: j, reason: collision with root package name */
    protected C0158a f14445j;

    /* renamed from: k, reason: collision with root package name */
    protected DataSetObserver f14446k;

    /* renamed from: l, reason: collision with root package name */
    protected C0641b f14447l;

    /* renamed from: y.a$a, reason: collision with other inner class name */
    private class C0158a extends ContentObserver {
        C0158a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            AbstractC0640a.this.e();
        }
    }

    /* renamed from: y.a$b */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC0640a abstractC0640a = AbstractC0640a.this;
            abstractC0640a.f14440e = true;
            abstractC0640a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC0640a abstractC0640a = AbstractC0640a.this;
            abstractC0640a.f14440e = false;
            abstractC0640a.notifyDataSetInvalidated();
        }
    }

    public AbstractC0640a(Context context, Cursor cursor, boolean z3) {
        b(context, cursor, z3 ? 1 : 2);
    }

    public abstract void a(View view, Context context, Cursor cursor);

    void b(Context context, Cursor cursor, int i3) {
        if ((i3 & 1) == 1) {
            i3 |= 2;
            this.f14441f = true;
        } else {
            this.f14441f = false;
        }
        boolean z3 = cursor != null;
        this.f14442g = cursor;
        this.f14440e = z3;
        this.f14443h = context;
        this.f14444i = z3 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i3 & 2) == 2) {
            this.f14445j = new C0158a();
            this.f14446k = new b();
        } else {
            this.f14445j = null;
            this.f14446k = null;
        }
        if (z3) {
            C0158a c0158a = this.f14445j;
            if (c0158a != null) {
                cursor.registerContentObserver(c0158a);
            }
            DataSetObserver dataSetObserver = this.f14446k;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View c(Context context, Cursor cursor, ViewGroup viewGroup);

    public void changeCursor(Cursor cursor) {
        Cursor f3 = f(cursor);
        if (f3 != null) {
            f3.close();
        }
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void e() {
        Cursor cursor;
        if (!this.f14441f || (cursor = this.f14442g) == null || cursor.isClosed()) {
            return;
        }
        this.f14440e = this.f14442g.requery();
    }

    public Cursor f(Cursor cursor) {
        Cursor cursor2 = this.f14442g;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0158a c0158a = this.f14445j;
            if (c0158a != null) {
                cursor2.unregisterContentObserver(c0158a);
            }
            DataSetObserver dataSetObserver = this.f14446k;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f14442g = cursor;
        if (cursor != null) {
            C0158a c0158a2 = this.f14445j;
            if (c0158a2 != null) {
                cursor.registerContentObserver(c0158a2);
            }
            DataSetObserver dataSetObserver2 = this.f14446k;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f14444i = cursor.getColumnIndexOrThrow("_id");
            this.f14440e = true;
            notifyDataSetChanged();
        } else {
            this.f14444i = -1;
            this.f14440e = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f14440e || (cursor = this.f14442g) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // y.C0641b.a
    public Cursor getCursor() {
        return this.f14442g;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f14440e) {
            return null;
        }
        this.f14442g.moveToPosition(i3);
        if (view == null) {
            view = c(this.f14443h, this.f14442g, viewGroup);
        }
        a(view, this.f14443h, this.f14442g);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f14447l == null) {
            this.f14447l = new C0641b(this);
        }
        return this.f14447l;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Cursor cursor;
        if (!this.f14440e || (cursor = this.f14442g) == null) {
            return null;
        }
        cursor.moveToPosition(i3);
        return this.f14442g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        Cursor cursor;
        if (this.f14440e && (cursor = this.f14442g) != null && cursor.moveToPosition(i3)) {
            return this.f14442g.getLong(this.f14444i);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f14440e) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f14442g.moveToPosition(i3)) {
            if (view == null) {
                view = d(this.f14443h, this.f14442g, viewGroup);
            }
            a(view, this.f14443h, this.f14442g);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i3);
    }
}
