package q0;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseIntArray;
import h0.AbstractC0371a;
import y0.d;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f12997d;

    /* renamed from: e, reason: collision with root package name */
    private static b f12998e;

    /* renamed from: b, reason: collision with root package name */
    private final Context f13000b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SoundPool f13001c = null;

    /* renamed from: a, reason: collision with root package name */
    private final SparseIntArray f12999a = new SparseIntArray();

    static {
        f12997d = AbstractC0371a.f11873b || AbstractC0371a.e("COUIAsyncSoundUtil", 3);
    }

    private b(Context context) {
        this.f13000b = context.getApplicationContext();
    }

    private static void b() {
        if (f12998e.f13001c == null) {
            if (f12997d) {
                Log.d("COUIAsyncSoundUtil", "init sound pool");
            }
            f12998e.c();
        }
    }

    private void c() {
        boolean z3 = f12997d;
        if (z3) {
            Log.d("COUIAsyncSoundUtil", "init sound pool begin");
        }
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes build = new AudioAttributes.Builder().setFlags(128).setLegacyStreamType(1).build();
        builder.setMaxStreams(10);
        builder.setAudioAttributes(build);
        this.f13001c = builder.build();
        if (z3) {
            Log.d("COUIAsyncSoundUtil", "init sound pool end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(int[] iArr) {
        b();
        if (f12997d) {
            Log.d("COUIAsyncSoundUtil", "sound pool initialized, load sound file");
        }
        for (int i3 : iArr) {
            b bVar = f12998e;
            bVar.e(bVar.f13000b, i3);
        }
    }

    private void e(Context context, int i3) {
        boolean z3 = f12997d;
        if (z3) {
            Log.d("COUIAsyncSoundUtil", "load sound file id = " + i3);
        }
        if (this.f12999a.indexOfKey(i3) < 0 || this.f12999a.get(i3) == 0) {
            this.f12999a.put(i3, this.f13001c.load(context, i3, 0));
        } else if (z3) {
            Log.d("COUIAsyncSoundUtil", i3 + " already loaded");
        }
    }

    public static void f(Context context, int i3, float f3, float f4, int i4, int i5, float f5) {
        if (f12998e.f13001c == null || !h(context)) {
            return;
        }
        f12998e.g(i3, f3, f4, i4, i5, f5);
    }

    private void g(int i3, float f3, float f4, int i4, int i5, float f5) {
        int i6 = this.f12999a.get(i3);
        if (f12997d) {
            Log.d("COUIAsyncSoundUtil", "soundId = " + i6);
        }
        if (i6 != 0) {
            this.f13001c.play(i6, f3, f4, i4, i5, f5);
        }
    }

    private static boolean h(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "sound_effects_enabled", 0) != 0;
    }

    public static void i(Context context, final int... iArr) {
        boolean z3 = f12997d;
        if (z3) {
            Log.d("COUIAsyncSoundUtil", "register, sound file num: " + iArr.length);
        }
        if (f12998e == null) {
            if (z3) {
                Log.d("COUIAsyncSoundUtil", "init util");
            }
            f12998e = new b(context);
        }
        d.f(1).i(new Runnable() { // from class: q0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(iArr);
            }
        });
    }
}
