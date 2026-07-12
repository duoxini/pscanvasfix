package H1;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.DeadObjectException;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private static ContentProviderClient f872a;

    private ContentValues l(G1.c cVar) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry entry : cVar.g().entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(str, (String) value);
            } else if (value instanceof Integer) {
                contentValues.put(str, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(str, (Long) value);
            } else if (value instanceof Boolean) {
                contentValues.put(str, (Boolean) value);
            }
        }
        return contentValues;
    }

    private static boolean m(Context context, final String str, ContentValues contentValues) {
        ContentProviderClient contentProviderClient;
        K1.g gVar;
        Uri parse = Uri.parse(str);
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.c
                @Override // K1.g
                public final Object get() {
                    String o3;
                    o3 = l.o();
                    return o3;
                }
            });
            return false;
        }
        boolean equals = TextUtils.equals(str, "content://com.oplus.statistics.provider/track_event");
        if (!equals || f872a == null) {
            contentProviderClient = null;
        } else {
            K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.g
                @Override // K1.g
                public final Object get() {
                    String p3;
                    p3 = l.p(str);
                    return p3;
                }
            });
            contentProviderClient = f872a;
        }
        try {
            if (contentProviderClient == null) {
                try {
                    contentProviderClient = contentResolver.acquireUnstableContentProviderClient(parse);
                    if (equals && contentProviderClient != null) {
                        f872a = contentProviderClient;
                    }
                } catch (DeadObjectException e3) {
                    if (f872a == null || !equals) {
                        K1.f.b("ContentProviderRecorder", new K1.g() { // from class: H1.d
                            @Override // K1.g
                            public final Object get() {
                                String u3;
                                u3 = l.u(e3);
                                return u3;
                            }
                        });
                        if (!equals && contentProviderClient != null) {
                            K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.e
                                @Override // K1.g
                                public final Object get() {
                                    String w3;
                                    w3 = l.w(str);
                                    return w3;
                                }
                            });
                            contentProviderClient.close();
                        }
                        return false;
                    }
                    K1.f.f("ContentProviderRecorder", new K1.g() { // from class: H1.i
                        @Override // K1.g
                        public final Object get() {
                            String r3;
                            r3 = l.r(e3);
                            return r3;
                        }
                    });
                    try {
                        contentProviderClient = contentResolver.acquireUnstableContentProviderClient(parse);
                        if (contentProviderClient != null) {
                            f872a = contentProviderClient;
                        }
                        if (contentProviderClient == null) {
                            K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.j
                                @Override // K1.g
                                public final Object get() {
                                    String s3;
                                    s3 = l.s();
                                    return s3;
                                }
                            });
                            if (!equals && contentProviderClient != null) {
                                K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.e
                                    @Override // K1.g
                                    public final Object get() {
                                        String w3;
                                        w3 = l.w(str);
                                        return w3;
                                    }
                                });
                                contentProviderClient.close();
                            }
                            return false;
                        }
                        contentProviderClient.insert(parse, contentValues);
                        if (equals) {
                            return true;
                        }
                        gVar = new K1.g() { // from class: H1.e
                            @Override // K1.g
                            public final Object get() {
                                String w3;
                                w3 = l.w(str);
                                return w3;
                            }
                        };
                    } catch (Exception unused) {
                        K1.f.b("ContentProviderRecorder", new K1.g() { // from class: H1.k
                            @Override // K1.g
                            public final Object get() {
                                String t3;
                                t3 = l.t(e3);
                                return t3;
                            }
                        });
                        f872a = null;
                        if (!equals && contentProviderClient != null) {
                            K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.e
                                @Override // K1.g
                                public final Object get() {
                                    String w3;
                                    w3 = l.w(str);
                                    return w3;
                                }
                            });
                            contentProviderClient.close();
                        }
                        return false;
                    }
                } catch (Exception e4) {
                    if (equals) {
                        f872a = null;
                    }
                    K1.f.b("ContentProviderRecorder", new K1.g() { // from class: H1.f
                        @Override // K1.g
                        public final Object get() {
                            String v3;
                            v3 = l.v(e4);
                            return v3;
                        }
                    });
                    if (!equals && contentProviderClient != null) {
                        K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.e
                            @Override // K1.g
                            public final Object get() {
                                String w3;
                                w3 = l.w(str);
                                return w3;
                            }
                        });
                        contentProviderClient.close();
                    }
                    return false;
                }
            }
            if (contentProviderClient == null) {
                K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.h
                    @Override // K1.g
                    public final Object get() {
                        String q3;
                        q3 = l.q();
                        return q3;
                    }
                });
                if (!equals && contentProviderClient != null) {
                    K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.e
                        @Override // K1.g
                        public final Object get() {
                            String w3;
                            w3 = l.w(str);
                            return w3;
                        }
                    });
                    contentProviderClient.close();
                }
                return false;
            }
            contentProviderClient.insert(parse, contentValues);
            if (equals) {
                return true;
            }
            gVar = new K1.g() { // from class: H1.e
                @Override // K1.g
                public final Object get() {
                    String w3;
                    w3 = l.w(str);
                    return w3;
                }
            };
            K1.f.a("ContentProviderRecorder", gVar);
            contentProviderClient.close();
            return true;
        } catch (Throwable th) {
            if (!equals && contentProviderClient != null) {
                K1.f.a("ContentProviderRecorder", new K1.g() { // from class: H1.e
                    @Override // K1.g
                    public final Object get() {
                        String w3;
                        w3 = l.w(str);
                        return w3;
                    }
                });
                contentProviderClient.close();
            }
            throw th;
        }
    }

    public static boolean n(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("", "");
        boolean m3 = m(context, "content://com.oplus.statistics.provider/support", contentValues);
        if (!m3) {
            K1.f.f("ContentProviderRecorder", new K1.g() { // from class: H1.b
                @Override // K1.g
                public final Object get() {
                    String x3;
                    x3 = l.x();
                    return x3;
                }
            });
        }
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String o() {
        return "get resolver failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String p(String str) {
        return str + " use ContentProviderClient from cache";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String q() {
        return "get provider client failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String r(DeadObjectException deadObjectException) {
        return "insert DeadObjectException:" + deadObjectException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String s() {
        return "get provider client failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String t(DeadObjectException deadObjectException) {
        return "insert exception:" + deadObjectException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String u(DeadObjectException deadObjectException) {
        return "insert DeadObjectException:" + deadObjectException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String v(Exception exc) {
        return "insert exception:" + exc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String w(String str) {
        return "cpc close: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String x() {
        return "not support content provider";
    }

    @Override // H1.m
    public void a(Context context, G1.c cVar) {
        m(context, "content://com.oplus.statistics.provider/track_event", l(cVar));
    }
}
