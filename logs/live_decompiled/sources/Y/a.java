package Y;

import com.oplus.wrapper.os.Debug;
import com.oplus.wrapper.os.SystemProperties;
import com.oplus.wrapper.os.Trace;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2935a;

    public a(Object obj) {
        this.f2935a = false;
        try {
            this.f2935a = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        } catch (Error | Exception unused) {
        }
    }

    public void a(long j3) {
    }

    public void b() {
    }

    public void c() {
        if (this.f2935a) {
            try {
                long j3 = Trace.TRACE_TAG_VIEW;
                Trace.traceBegin(j3, "AnimatorStart " + Debug.getCallers(10));
                Trace.traceEnd(j3);
            } catch (Error | Exception unused) {
            }
        }
    }

    public void d() {
    }

    public void e(int i3) {
        if (this.f2935a) {
            try {
                Trace.asyncTraceEnd(Trace.TRACE_TAG_VIEW, "spring_animator", i3);
            } catch (Error | Exception unused) {
            }
            b();
        }
    }

    public void f(int i3) {
        if (this.f2935a) {
            try {
                Trace.asyncTraceBegin(Trace.TRACE_TAG_VIEW, "spring_animator", i3);
            } catch (Error | Exception unused) {
            }
            c();
        }
    }
}
