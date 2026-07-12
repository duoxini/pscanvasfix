package A1;

import B1.l;
import B1.s;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.SystemProperties;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.preference.j;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import f0.C0350b;
import t1.f;
import t1.h;
import t1.i;

/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f81f = SystemProperties.getBoolean("ro.oplus.allow_change_guide_shown", false);

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f82g = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: a, reason: collision with root package name */
    private final Context f83a;

    /* renamed from: b, reason: collision with root package name */
    private final ContainerView f84b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.appcompat.app.c f85c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f86d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f87e = false;

    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (e.f82g.booleanValue()) {
                Log.d("MultiGestureGuideManager", "onDismiss mMultiFingerGestureGuideDialog");
            }
            e.this.f85c = null;
            if (e.this.f84b != null && e.this.f84b.getFlexibleUiManager() != null && e.this.f84b.Q2(e.this.f83a) != null && e.this.f86d && !e.this.f87e && e.this.f84b.Q2(e.this.f83a).t0() == 3) {
                e.this.f84b.getFlexibleUiManager().Q();
            }
            e.this.f86d = false;
            e.this.f87e = false;
        }
    }

    public e(Context context, ContainerView containerView) {
        this.f83a = context;
        this.f84b = containerView;
    }

    private boolean k() {
        return j.b(this.f83a).getBoolean("multi_gesture_guide_show", false);
    }

    private void l(EffectiveAnimationView effectiveAnimationView, boolean z3) {
        effectiveAnimationView.setAnimation(s.H() ? z3 ? i.f13555f1 : i.f13552e1 : s.r(this.f83a) ? z3 ? i.f13549d1 : i.f13546c1 : -1);
        effectiveAnimationView.setRepeatCount(-1);
        effectiveAnimationView.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        androidx.appcompat.app.c cVar = this.f85c;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    private void p(Context context) {
        View inflate;
        if (k()) {
            return;
        }
        androidx.appcompat.app.c cVar = this.f85c;
        if ((cVar == null || !cVar.isShowing()) && (inflate = LayoutInflater.from(context).inflate(h.f13480m, (ViewGroup) null)) != null) {
            Log.d("MultiGestureGuideManager", "showGuideDialog start");
            o(true);
            Button button = (Button) inflate.findViewById(f.f13425E);
            EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) inflate.findViewById(f.f13424D);
            boolean z3 = (context.getResources().getConfiguration().uiMode & 32) != 0;
            if (effectiveAnimationView != null) {
                l(effectiveAnimationView, z3);
            }
            C0350b c0350b = new C0350b(context);
            c0350b.setView(inflate);
            c0350b.setCancelable(true);
            c0350b.Y(2008);
            androidx.appcompat.app.c show = c0350b.show();
            this.f85c = show;
            show.setCanceledOnTouchOutside(false);
            this.f85c.setOnDismissListener(new a());
            button.setOnClickListener(new View.OnClickListener() { // from class: A1.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.n(view);
                }
            });
        }
    }

    public void j(boolean z3) {
        androidx.appcompat.app.c cVar = this.f85c;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        if (f82g.booleanValue()) {
            Log.d("MultiGestureGuideManager", "dismissDialog mMultiFingerGestureGuideDialog");
        }
        this.f87e = z3;
        this.f85c.dismiss();
    }

    public boolean m() {
        androidx.appcompat.app.c cVar = this.f85c;
        return cVar != null && cVar.isShowing();
    }

    public void o(boolean z3) {
        if (f82g.booleanValue()) {
            Log.d("MultiGestureGuideManager", "saveGuidePrefs isShow=" + z3);
        }
        SharedPreferences.Editor edit = j.b(this.f83a).edit();
        edit.putBoolean("multi_gesture_guide_show", z3);
        edit.apply();
    }

    public void q(Context context) {
        boolean k3 = k();
        if (k3) {
            if (!f81f) {
                return;
            } else {
                o(false);
            }
        }
        if (l.B0()) {
            this.f86d = true;
            Log.d("MultiGestureGuideManager", "showMultiFingerGestureGuideDialog isInFourFingerToCanvasAnimation");
            return;
        }
        Log.d("MultiGestureGuideManager", "showMultiFingerGestureGuideDialog isGuideShown=" + k3);
        p(context);
    }
}
