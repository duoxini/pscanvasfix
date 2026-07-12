package y;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: y.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0642c extends AbstractC0640a {

    /* renamed from: m, reason: collision with root package name */
    private int f14451m;

    /* renamed from: n, reason: collision with root package name */
    private int f14452n;

    /* renamed from: o, reason: collision with root package name */
    private LayoutInflater f14453o;

    public AbstractC0642c(Context context, int i3, Cursor cursor, boolean z3) {
        super(context, cursor, z3);
        this.f14452n = i3;
        this.f14451m = i3;
        this.f14453o = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // y.AbstractC0640a
    public View c(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f14453o.inflate(this.f14452n, viewGroup, false);
    }

    @Override // y.AbstractC0640a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f14453o.inflate(this.f14451m, viewGroup, false);
    }
}
