package com.oplus.pscanvas.canvasmode.canvas.database;

import J.t;
import J.u;
import N.g;
import android.content.Context;
import w1.InterfaceC0624h;

/* loaded from: classes.dex */
public abstract class CanvasTaskDatabase extends u {

    /* renamed from: p, reason: collision with root package name */
    private static CanvasTaskDatabase f10540p;

    /* renamed from: q, reason: collision with root package name */
    static final K.a f10541q = new a(3, 4);

    class a extends K.a {
        a(int i3, int i4) {
            super(i3, i4);
        }

        @Override // K.a
        public void a(g gVar) {
            gVar.w("ALTER TABLE embedded_canvas  ADD COLUMN intent1 TEXT");
            gVar.w("ALTER TABLE embedded_canvas  ADD COLUMN intent2 TEXT");
            gVar.w("ALTER TABLE embedded_canvas  ADD COLUMN intent3 TEXT");
        }
    }

    public static synchronized CanvasTaskDatabase C(Context context) {
        CanvasTaskDatabase canvasTaskDatabase;
        synchronized (CanvasTaskDatabase.class) {
            try {
                if (f10540p == null) {
                    f10540p = (CanvasTaskDatabase) t.a(context.getApplicationContext(), CanvasTaskDatabase.class, "canvas_task_database").b().a(f10541q).d().c();
                }
                canvasTaskDatabase = f10540p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return canvasTaskDatabase;
    }

    public abstract InterfaceC0624h B();
}
