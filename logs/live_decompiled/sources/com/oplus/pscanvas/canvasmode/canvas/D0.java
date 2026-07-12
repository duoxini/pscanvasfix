package com.oplus.pscanvas.canvasmode.canvas;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import f0.C0350b;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class D0 {

    /* renamed from: a, reason: collision with root package name */
    private ContainerActivity f10300a;

    /* renamed from: b, reason: collision with root package name */
    private Dialog f10301b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10302c;

    /* renamed from: d, reason: collision with root package name */
    BroadcastReceiver f10303d = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("thermallevel", 0) >= B1.q.d(context).c()) {
                if ((D0.this.f10301b != null && D0.this.f10301b.isShowing()) || D0.this.f10302c || B1.l.F0(context)) {
                    return;
                }
                D0.this.f10300a.v0().f10732G.P();
                D0.this.f10300a.L0();
                D0 d02 = D0.this;
                d02.f10301b = d02.i();
                D0.this.f10301b.show();
                D0.this.f10302c = true;
            }
        }
    }

    public D0(ContainerActivity containerActivity) {
        this.f10300a = containerActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Dialog i() {
        C0350b c0350b = new C0350b(this.f10300a);
        c0350b.setCancelable(false);
        c0350b.Y(2008);
        c0350b.V(t1.j.f13654n0);
        c0350b.setView((LinearLayout) LayoutInflater.from(this.f10300a).inflate(t1.h.f13478k, (ViewGroup) null));
        c0350b.setPositiveButton(t1.j.f13638f0, new DialogInterface.OnClickListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.B0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                D0.this.l(dialogInterface, i3);
            }
        });
        c0350b.setNegativeButton(t1.j.f13636e0, new DialogInterface.OnClickListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.C0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        });
        return c0350b.create();
    }

    public static int k() {
        try {
            Class<?> cls = Class.forName("com.oplus.util.OplusHoraeThermalHelper");
            Object invoke = cls.getDeclaredMethod("getThermalStatus", null).invoke(cls.getDeclaredMethod("getInstance", null).invoke(null, null), null);
            if (!(invoke instanceof Integer)) {
                return -1;
            }
            Log.d("ThermalLevelStatus", "level:" + invoke);
            return ((Integer) invoke).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        this.f10300a.v0().n1(this.f10300a.v0().getAdapter().h());
    }

    public void j() {
        Dialog dialog = this.f10301b;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f10301b.dismiss();
    }

    public void n() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("oplus.intent.action.THERMAL_LEVEL_CHANGE");
        this.f10300a.registerReceiver(this.f10303d, intentFilter, 4);
    }

    public void o() {
        if (B1.l.F0(this.f10300a)) {
            return;
        }
        if (this.f10301b == null) {
            this.f10301b = i();
        }
        if (this.f10301b.isShowing()) {
            return;
        }
        this.f10301b.show();
    }

    public void p() {
        this.f10300a.unregisterReceiver(this.f10303d);
    }
}
