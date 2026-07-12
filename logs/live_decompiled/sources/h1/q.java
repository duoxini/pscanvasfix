package H1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes.dex */
public class q implements m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f877a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f878b;

    static {
        byte[] decode = Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0);
        Charset charset = StandardCharsets.UTF_8;
        f877a = new String(decode, charset);
        f878b = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbS5zZXJ2aWNlLlJlY2VpdmVyU2VydmljZQ==", 0), charset);
    }

    private Intent d(G1.c cVar) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f877a, f878b));
        for (Map.Entry entry : cVar.g().entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(str, (String) value);
            } else if (value instanceof Integer) {
                intent.putExtra(str, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(str, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(str, (Boolean) value);
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        return "add Task failed: bean or context is null. context=" + context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Exception exc) {
        return "startService exception=" + exc;
    }

    @Override // H1.m
    public void a(final Context context, G1.c cVar) {
        if (cVar == null || context == null) {
            K1.f.a("ServiceRecorder", new K1.g() { // from class: H1.o
                @Override // K1.g
                public final Object get() {
                    String e3;
                    e3 = q.e(context);
                    return e3;
                }
            });
            return;
        }
        try {
            context.startService(d(cVar));
        } catch (Exception e3) {
            K1.f.f("ServiceRecorder", new K1.g() { // from class: H1.p
                @Override // K1.g
                public final Object get() {
                    String f3;
                    f3 = q.f(e3);
                    return f3;
                }
            });
        }
    }
}
