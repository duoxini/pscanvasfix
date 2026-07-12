package com.oplus.settingslib.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
public abstract class OplusSearchIndexablesProvider extends ContentProvider {

    /* renamed from: e, reason: collision with root package name */
    private String f10994e;

    /* renamed from: f, reason: collision with root package name */
    private UriMatcher f10995f;

    public abstract Cursor a(String[] strArr);

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.f10994e = providerInfo.authority;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f10995f = uriMatcher;
        uriMatcher.addURI(this.f10994e, "settings/indexables_xml_res", 1);
        this.f10995f.addURI(this.f10994e, "settings/indexables_raw", 2);
        this.f10995f.addURI(this.f10994e, "settings/non_indexables_key", 3);
        this.f10995f.addURI(this.f10994e, "settings/site_map_pairs", 4);
        if (!providerInfo.exported) {
            throw new SecurityException("Provider must be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grantUriPermissions");
        }
        if (!"android.permission.READ_SEARCH_INDEXABLES".equals(providerInfo.readPermission)) {
            throw new SecurityException("Provider must be protected by READ_SEARCH_INDEXABLES");
        }
        super.attachInfo(context, providerInfo);
    }

    public abstract Cursor b(String[] strArr);

    public Cursor c() {
        return null;
    }

    public abstract Cursor d(String[] strArr);

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete not supported");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int match = this.f10995f.match(uri);
        if (match == 1) {
            return "vnd.android.cursor.dir/indexables_xml_res";
        }
        if (match == 2) {
            return "vnd.android.cursor.dir/indexables_raw";
        }
        if (match == 3) {
            return "vnd.android.cursor.dir/non_indexables_key";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert not supported");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.f10995f.match(uri);
        if (match == 1) {
            return d(null);
        }
        if (match == 2) {
            return b(null);
        }
        if (match == 3) {
            return a(null);
        }
        if (match == 4) {
            return c();
        }
        throw new UnsupportedOperationException("Unknown Uri " + uri);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Update not supported");
    }
}
