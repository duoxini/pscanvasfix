package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import e.AbstractC0339a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import y.AbstractC0642c;

/* loaded from: classes.dex */
class P extends AbstractC0642c implements View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    private int f3990A;

    /* renamed from: B, reason: collision with root package name */
    private int f3991B;

    /* renamed from: C, reason: collision with root package name */
    private int f3992C;

    /* renamed from: p, reason: collision with root package name */
    private final SearchView f3993p;

    /* renamed from: q, reason: collision with root package name */
    private final SearchableInfo f3994q;

    /* renamed from: r, reason: collision with root package name */
    private final Context f3995r;

    /* renamed from: s, reason: collision with root package name */
    private final WeakHashMap f3996s;

    /* renamed from: t, reason: collision with root package name */
    private final int f3997t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3998u;

    /* renamed from: v, reason: collision with root package name */
    private int f3999v;

    /* renamed from: w, reason: collision with root package name */
    private ColorStateList f4000w;

    /* renamed from: x, reason: collision with root package name */
    private int f4001x;

    /* renamed from: y, reason: collision with root package name */
    private int f4002y;

    /* renamed from: z, reason: collision with root package name */
    private int f4003z;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f4004a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f4005b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f4006c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f4007d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f4008e;

        public a(View view) {
            this.f4004a = (TextView) view.findViewById(R.id.text1);
            this.f4005b = (TextView) view.findViewById(R.id.text2);
            this.f4006c = (ImageView) view.findViewById(R.id.icon1);
            this.f4007d = (ImageView) view.findViewById(R.id.icon2);
            this.f4008e = (ImageView) view.findViewById(e.f.f11206q);
        }
    }

    public P(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f3998u = false;
        this.f3999v = 1;
        this.f4001x = -1;
        this.f4002y = -1;
        this.f4003z = -1;
        this.f3990A = -1;
        this.f3991B = -1;
        this.f3992C = -1;
        this.f3993p = searchView;
        this.f3994q = searchableInfo;
        this.f3997t = searchView.getSuggestionCommitIconResId();
        this.f3995r = context;
        this.f3996s = weakHashMap;
    }

    private Drawable g(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f3996s.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence h(CharSequence charSequence) {
        if (this.f4000w == null) {
            TypedValue typedValue = new TypedValue();
            this.f3995r.getTheme().resolveAttribute(AbstractC0339a.f11083L, typedValue, true);
            this.f4000w = this.f3995r.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f4000w, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable i(ComponentName componentName) {
        PackageManager packageManager = this.f3995r.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("SuggestionsAdapter", e3.toString());
            return null;
        }
    }

    private Drawable j(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.f3996s.containsKey(flattenToShortString)) {
            Drawable i3 = i(componentName);
            this.f3996s.put(flattenToShortString, i3 != null ? i3.getConstantState() : null);
            return i3;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f3996s.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f3995r.getResources());
    }

    public static String k(Cursor cursor, String str) {
        return s(cursor, cursor.getColumnIndex(str));
    }

    private Drawable l() {
        Drawable j3 = j(this.f3994q.getSearchActivity());
        return j3 != null ? j3 : this.f3995r.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return n(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f3995r.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException e3) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e3);
                }
            }
        } catch (FileNotFoundException e4) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
        return null;
    }

    private Drawable o(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f3995r.getPackageName() + "/" + parseInt;
            Drawable g3 = g(str2);
            if (g3 != null) {
                return g3;
            }
            Drawable e3 = androidx.core.content.a.e(this.f3995r, parseInt);
            w(str2, e3);
            return e3;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable g4 = g(str);
            if (g4 != null) {
                return g4;
            }
            Drawable m3 = m(Uri.parse(str));
            w(str, m3);
            return m3;
        }
    }

    private Drawable p(Cursor cursor) {
        int i3 = this.f3990A;
        if (i3 == -1) {
            return null;
        }
        Drawable o3 = o(cursor.getString(i3));
        return o3 != null ? o3 : l();
    }

    private Drawable q(Cursor cursor) {
        int i3 = this.f3991B;
        if (i3 == -1) {
            return null;
        }
        return o(cursor.getString(i3));
    }

    private static String s(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e3);
            return null;
        }
    }

    private void u(ImageView imageView, Drawable drawable, int i3) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i3);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void v(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void w(String str, Drawable drawable) {
        if (drawable != null) {
            this.f3996s.put(str, drawable.getConstantState());
        }
    }

    private void x(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // y.AbstractC0640a
    public void a(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i3 = this.f3992C;
        int i4 = i3 != -1 ? cursor.getInt(i3) : 0;
        if (aVar.f4004a != null) {
            v(aVar.f4004a, s(cursor, this.f4001x));
        }
        if (aVar.f4005b != null) {
            String s3 = s(cursor, this.f4003z);
            CharSequence h3 = s3 != null ? h(s3) : s(cursor, this.f4002y);
            if (TextUtils.isEmpty(h3)) {
                TextView textView = aVar.f4004a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f4004a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f4004a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f4004a.setMaxLines(1);
                }
            }
            v(aVar.f4005b, h3);
        }
        ImageView imageView = aVar.f4006c;
        if (imageView != null) {
            u(imageView, p(cursor), 4);
        }
        ImageView imageView2 = aVar.f4007d;
        if (imageView2 != null) {
            u(imageView2, q(cursor), 8);
        }
        int i5 = this.f3999v;
        if (i5 != 2 && (i5 != 1 || (i4 & 1) == 0)) {
            aVar.f4008e.setVisibility(8);
            return;
        }
        aVar.f4008e.setVisibility(0);
        aVar.f4008e.setTag(aVar.f4004a.getText());
        aVar.f4008e.setOnClickListener(this);
    }

    @Override // y.AbstractC0640a, y.C0641b.a
    public void changeCursor(Cursor cursor) {
        if (this.f3998u) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f4001x = cursor.getColumnIndex("suggest_text_1");
                this.f4002y = cursor.getColumnIndex("suggest_text_2");
                this.f4003z = cursor.getColumnIndex("suggest_text_2_url");
                this.f3990A = cursor.getColumnIndex("suggest_icon_1");
                this.f3991B = cursor.getColumnIndex("suggest_icon_2");
                this.f3992C = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e3);
        }
    }

    @Override // y.AbstractC0640a, y.C0641b.a
    public CharSequence convertToString(Cursor cursor) {
        String k3;
        String k4;
        if (cursor == null) {
            return null;
        }
        String k5 = k(cursor, "suggest_intent_query");
        if (k5 != null) {
            return k5;
        }
        if (this.f3994q.shouldRewriteQueryFromData() && (k4 = k(cursor, "suggest_intent_data")) != null) {
            return k4;
        }
        if (!this.f3994q.shouldRewriteQueryFromText() || (k3 = k(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return k3;
    }

    @Override // y.AbstractC0642c, y.AbstractC0640a
    public View d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View d3 = super.d(context, cursor, viewGroup);
        d3.setTag(new a(d3));
        ((ImageView) d3.findViewById(e.f.f11206q)).setImageResource(this.f3997t);
        return d3;
    }

    @Override // y.AbstractC0640a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View c3 = this.c(this.f3995r, this.getCursor(), viewGroup);
            if (c3 != null) {
                ((a) c3.getTag()).f4004a.setText(e3.toString());
            }
            return c3;
        }
    }

    @Override // y.AbstractC0640a, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View d3 = this.d(this.f3995r, this.getCursor(), viewGroup);
            if (d3 != null) {
                ((a) d3.getTag()).f4004a.setText(e3.toString());
            }
            return d3;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    Drawable n(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f3995r.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        x(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        x(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f3993p.w((CharSequence) tag);
        }
    }

    Cursor r(SearchableInfo searchableInfo, String str, int i3) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i3 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i3));
        }
        return this.f3995r.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // y.C0641b.a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f3993p.getVisibility() == 0 && this.f3993p.getWindowVisibility() == 0) {
            try {
                Cursor r3 = r(this.f3994q, charSequence2, 50);
                if (r3 != null) {
                    r3.getCount();
                    return r3;
                }
            } catch (RuntimeException e3) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e3);
            }
        }
        return null;
    }

    public void t(int i3) {
        this.f3999v = i3;
    }
}
