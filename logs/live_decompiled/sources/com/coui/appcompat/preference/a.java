package com.coui.appcompat.preference;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.y;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import e0.AbstractC0342a;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public class a extends androidx.preference.c {

    /* renamed from: p, reason: collision with root package name */
    private androidx.appcompat.app.j f8755p;

    /* renamed from: q, reason: collision with root package name */
    private int f8756q;

    /* renamed from: com.coui.appcompat.preference.a$a, reason: collision with other inner class name */
    class DialogC0107a extends androidx.appcompat.app.j {
        DialogC0107a(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onMenuItemSelected(i3, menuItem);
            }
            dismiss();
            return true;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f8755p.dismiss();
        }
    }

    class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppBarLayout f8759e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ListView f8760f;

        c(AppBarLayout appBarLayout, ListView listView) {
            this.f8759e = appBarLayout;
            this.f8760f = listView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAdded()) {
                int measuredHeight = this.f8759e.getMeasuredHeight() + a.this.getResources().getDimensionPixelSize(W1.c.f2627R);
                View view = new View(this.f8759e.getContext());
                view.setVisibility(4);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, measuredHeight));
                this.f8760f.addHeaderView(view);
            }
        }
    }

    class d extends e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ListView f8762e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.j f8763f;

        /* renamed from: com.coui.appcompat.preference.a$d$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0108a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f8765e;

            ViewOnClickListenerC0108a(int i3) {
                this.f8765e = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f8756q = this.f8765e;
                a.this.onClick(null, -1);
                d.this.f8763f.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i3, int i4, CharSequence[] charSequenceArr, ListView listView, androidx.appcompat.app.j jVar) {
            super(context, i3, i4, charSequenceArr);
            this.f8762e = listView;
            this.f8763f = jVar;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i3, view, viewGroup);
            if (i3 == a.this.f8756q) {
                ListView listView = this.f8762e;
                listView.setItemChecked(listView.getHeaderViewsCount() + i3, true);
            }
            View findViewById = view2.findViewById(W1.d.f2698z);
            int count = getCount();
            if (findViewById != null) {
                if (count == 1 || i3 == count - 1) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
            view2.setOnClickListener(new ViewOnClickListenerC0108a(i3));
            com.coui.appcompat.cardlist.a.d(view2, com.coui.appcompat.cardlist.a.a(a.this.v().p().length, i3));
            return view2;
        }
    }

    private static class e extends ArrayAdapter {
        e(Context context, int i3, int i4, CharSequence[] charSequenceArr) {
            super(context, i3, i4, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public COUIActivityDialogPreference v() {
        return (COUIActivityDialogPreference) i();
    }

    public static int w(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return -1;
    }

    private View x(Context context) {
        int w3 = w(context);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, w3));
        return imageView;
    }

    public static a y(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // androidx.preference.c, androidx.preference.f
    public void m(boolean z3) {
        COUIActivityDialogPreference v3 = v();
        if (!z3 || this.f8756q < 0) {
            return;
        }
        String charSequence = v().r()[this.f8756q].toString();
        if (v3.callChangeListener(charSequence)) {
            v3.u(charSequence);
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        DialogC0107a dialogC0107a = new DialogC0107a(getActivity(), P1.f.f1837f);
        this.f8755p = dialogC0107a;
        if (dialogC0107a.getWindow() != null) {
            Window window = dialogC0107a.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(1024);
            window.setStatusBarColor(0);
            int systemUiVisibility = decorView.getSystemUiVisibility();
            int c3 = AbstractC0647b.c();
            boolean z3 = getResources().getBoolean(W1.b.f2609b);
            if (c3 >= 6 || c3 == 0) {
                window.addFlags(Integer.MIN_VALUE);
                decorView.setSystemUiVisibility(AbstractC0342a.a(dialogC0107a.getContext()) ? systemUiVisibility & (-8209) : !z3 ? systemUiVisibility | 8192 : systemUiVisibility | 256);
            }
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(W1.e.f2707i, (ViewGroup) null);
        COUIToolbar cOUIToolbar = (COUIToolbar) inflate.findViewById(W1.d.f2671M);
        cOUIToolbar.setNavigationIcon(androidx.core.content.a.e(cOUIToolbar.getContext(), M1.g.f1467a));
        cOUIToolbar.setNavigationOnClickListener(new b());
        AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(W1.d.f2673a);
        ListView listView = (ListView) inflate.findViewById(W1.d.f2686n);
        View findViewById = inflate.findViewById(W1.d.f2692t);
        if (getResources().getBoolean(W1.b.f2608a)) {
            findViewById.setVisibility(8);
        }
        y.w0(listView, true);
        View x3 = x(appBarLayout.getContext());
        appBarLayout.addView(x3, 0, x3.getLayoutParams());
        appBarLayout.post(new c(appBarLayout, listView));
        if (v() != null) {
            this.f8756q = v().o(v().s());
            cOUIToolbar.setTitle(v().l());
            listView.setAdapter((ListAdapter) new d(getActivity(), W1.e.f2708j, W1.d.f2679g, v().p(), listView, dialogC0107a));
        }
        listView.setChoiceMode(1);
        dialogC0107a.setContentView(inflate);
        return dialogC0107a;
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (i() == null) {
            dismiss();
        }
    }
}
