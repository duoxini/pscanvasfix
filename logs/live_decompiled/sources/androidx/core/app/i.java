package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i implements Iterable {

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList f4836e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final Context f4837f;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private i(Context context) {
        this.f4837f = context;
    }

    public static i d(Context context) {
        return new i(context);
    }

    public i a(Intent intent) {
        this.f4836e.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i b(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = e.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f4837f.getPackageManager());
            }
            c(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public i c(ComponentName componentName) {
        int size = this.f4836e.size();
        try {
            Intent b3 = e.b(this.f4837f, componentName);
            while (b3 != null) {
                this.f4836e.add(size, b3);
                b3 = e.b(this.f4837f, b3.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e3);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f4836e.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f4836e.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.h(this.f4837f, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f4837f.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f4836e.iterator();
    }
}
