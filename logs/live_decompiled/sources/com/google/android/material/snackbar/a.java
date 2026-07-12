package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.p;

/* loaded from: classes.dex */
class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f9760c;

    /* renamed from: a, reason: collision with root package name */
    private final Object f9761a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f9762b = new Handler(Looper.getMainLooper(), new C0123a());

    /* renamed from: com.google.android.material.snackbar.a$a, reason: collision with other inner class name */
    class C0123a implements Handler.Callback {
        C0123a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            p.a(message.obj);
            aVar.c(null);
            return true;
        }
    }

    interface b {
    }

    private static class c {
    }

    private a() {
    }

    private boolean a(c cVar, int i3) {
        throw null;
    }

    static a b() {
        if (f9760c == null) {
            f9760c = new a();
        }
        return f9760c;
    }

    private boolean d(b bVar) {
        return false;
    }

    void c(c cVar) {
        synchronized (this.f9761a) {
            a(cVar, 2);
        }
    }

    public void e(b bVar) {
        synchronized (this.f9761a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f9761a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
