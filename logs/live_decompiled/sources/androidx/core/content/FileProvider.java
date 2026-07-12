package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f4838g = {"_display_name", "_size"};

    /* renamed from: h, reason: collision with root package name */
    private static final File f4839h = new File("/");

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap f4840i = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private b f4841e;

    /* renamed from: f, reason: collision with root package name */
    private int f4842f = 0;

    static class a {
        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface b {
        File a(Uri uri);
    }

    static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final String f4843a;

        /* renamed from: b, reason: collision with root package name */
        private final HashMap f4844b = new HashMap();

        c(String str) {
            this.f4843a = str;
        }

        @Override // androidx.core.content.FileProvider.b
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f4844b.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        void b(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f4844b.put(str, file.getCanonicalFile());
            } catch (IOException e3) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e3);
            }
        }
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] b(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        return objArr2;
    }

    private static String[] c(String[] strArr, int i3) {
        String[] strArr2 = new String[i3];
        System.arraycopy(strArr, 0, strArr2, 0, i3);
        return strArr2;
    }

    static XmlResourceParser d(Context context, String str, ProviderInfo providerInfo, int i3) {
        if (providerInfo == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        if (providerInfo.metaData == null && i3 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt("android.support.FILE_PROVIDER_PATHS", i3);
        }
        XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData != null) {
            return loadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    private static b e(Context context, String str, int i3) {
        b bVar;
        HashMap hashMap = f4840i;
        synchronized (hashMap) {
            try {
                bVar = (b) hashMap.get(str);
                if (bVar == null) {
                    try {
                        try {
                            bVar = g(context, str, i3);
                            hashMap.put(str, bVar);
                        } catch (IOException e3) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                        }
                    } catch (XmlPullParserException e4) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static int f(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static b g(Context context, String str, int i3) {
        c cVar = new c(str);
        XmlResourceParser d3 = d(context, str, context.getPackageManager().resolveContentProvider(str, 128), i3);
        while (true) {
            int next = d3.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = d3.getName();
                File file = null;
                String attributeValue = d3.getAttributeValue(null, "name");
                String attributeValue2 = d3.getAttributeValue(null, Constants.MessagerConstants.PATH_KEY);
                if ("root-path".equals(name)) {
                    file = f4839h;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] g3 = androidx.core.content.a.g(context, null);
                    if (g3.length > 0) {
                        file = g3[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] f3 = androidx.core.content.a.f(context);
                    if (f3.length > 0) {
                        file = f3[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] a3 = a.a(context);
                    if (a3.length > 0) {
                        file = a3[0];
                    }
                }
                if (file != null) {
                    cVar.b(attributeValue, a(file, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(Constants.DataMigration.SPLIT_TAG)[0];
        HashMap hashMap = f4840i;
        synchronized (hashMap) {
            hashMap.remove(str);
        }
        this.f4841e = e(context, str, this.f4842f);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f4841e.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a3 = this.f4841e.a(uri);
        int lastIndexOf = a3.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a3.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.f4841e.a(uri), f(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        File a3 = this.f4841e.a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f4838g;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i4 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i4] = "_display_name";
                i3 = i4 + 1;
                objArr[i4] = queryParameter == null ? a3.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i4] = "_size";
                i3 = i4 + 1;
                objArr[i4] = Long.valueOf(a3.length());
            }
            i4 = i3;
        }
        String[] c3 = c(strArr3, i4);
        Object[] b3 = b(objArr, i4);
        MatrixCursor matrixCursor = new MatrixCursor(c3, 1);
        matrixCursor.addRow(b3);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
