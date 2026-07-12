package x1;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.os.LinearmotorVibrator;
import com.oplus.os.WaveformEffect;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f14182a = "s";

    /* renamed from: b, reason: collision with root package name */
    private static final long[] f14183b = {0, 50};

    public static void a(Context context, int i3, boolean z3) {
        try {
            if (Settings.System.getIntForUser(context.getContentResolver(), "haptic_feedback_enabled", 0, -2) == 0) {
                Log.d(f14182a, "vibrateEffectId failed, reason=hapticsDisabled");
                return;
            }
            if (!OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.vibrator_lmvibrator")) {
                ((Vibrator) context.getSystemService(Vibrator.class)).vibrate(VibrationEffect.createWaveform(f14183b, -1));
                Log.d(f14182a, "vibrateEffectId  SUCCESS but not lmvibrator");
                return;
            }
            LinearmotorVibrator linearmotorVibrator = (LinearmotorVibrator) context.getSystemService("linearmotor");
            WaveformEffect build = new WaveformEffect.Builder().setEffectType(i3).setAsynchronous(z3).build();
            if (linearmotorVibrator != null && build != null) {
                Log.d(f14182a, "vibrateEffectId  SUCCESS  effectId=" + i3);
                linearmotorVibrator.vibrate(build);
                return;
            }
            Log.d(f14182a, "vibrateEffectId failed,reason=Parameter vibrator=" + linearmotorVibrator + ",effect=" + build);
        } catch (Exception e3) {
            Log.e(f14182a, "vibrateEffectId " + e3);
        }
    }
}
