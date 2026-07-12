package K1;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f1169a = false;

    public static void a(String str, g gVar) {
        if (f1169a) {
            Log.d("OplusTrack-" + str, (String) gVar.get());
        }
    }

    public static void b(String str, g gVar) {
        Log.e("OplusTrack-" + str, (String) gVar.get());
    }

    public static void c(String str, g gVar) {
        if (f1169a) {
            Log.i("OplusTrack-" + str, (String) gVar.get());
        }
    }

    public static void d(boolean z3) {
        f1169a = z3;
    }

    public static void e(String str, g gVar) {
        if (f1169a) {
            Log.v("OplusTrack-" + str, (String) gVar.get());
        }
    }

    public static void f(String str, g gVar) {
        Log.w("OplusTrack-" + str, (String) gVar.get());
    }
}
