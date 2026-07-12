package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import c.AbstractC0294a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    private Random f3391a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private final Map f3392b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map f3393c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map f3394d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    ArrayList f3395e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    final transient Map f3396f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    final Map f3397g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final Bundle f3398h = new Bundle();

    class a extends androidx.activity.result.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3403a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0294a f3404b;

        a(String str, AbstractC0294a abstractC0294a) {
            this.f3403a = str;
            this.f3404b = abstractC0294a;
        }

        @Override // androidx.activity.result.c
        public void b(Object obj, androidx.core.app.b bVar) {
            Integer num = (Integer) ActivityResultRegistry.this.f3393c.get(this.f3403a);
            if (num != null) {
                ActivityResultRegistry.this.f3395e.add(this.f3403a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f3404b, obj, bVar);
                    return;
                } catch (Exception e3) {
                    ActivityResultRegistry.this.f3395e.remove(this.f3403a);
                    throw e3;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f3404b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void c() {
            ActivityResultRegistry.this.l(this.f3403a);
        }
    }

    class b extends androidx.activity.result.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3406a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractC0294a f3407b;

        b(String str, AbstractC0294a abstractC0294a) {
            this.f3406a = str;
            this.f3407b = abstractC0294a;
        }

        @Override // androidx.activity.result.c
        public void b(Object obj, androidx.core.app.b bVar) {
            Integer num = (Integer) ActivityResultRegistry.this.f3393c.get(this.f3406a);
            if (num != null) {
                ActivityResultRegistry.this.f3395e.add(this.f3406a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f3407b, obj, bVar);
                    return;
                } catch (Exception e3) {
                    ActivityResultRegistry.this.f3395e.remove(this.f3406a);
                    throw e3;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f3407b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void c() {
            ActivityResultRegistry.this.l(this.f3406a);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final androidx.activity.result.b f3409a;

        /* renamed from: b, reason: collision with root package name */
        final AbstractC0294a f3410b;

        c(androidx.activity.result.b bVar, AbstractC0294a abstractC0294a) {
            this.f3409a = bVar;
            this.f3410b = abstractC0294a;
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final AbstractC0272h f3411a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList f3412b = new ArrayList();

        d(AbstractC0272h abstractC0272h) {
            this.f3411a = abstractC0272h;
        }

        void a(l lVar) {
            this.f3411a.a(lVar);
            this.f3412b.add(lVar);
        }

        void b() {
            Iterator it = this.f3412b.iterator();
            while (it.hasNext()) {
                this.f3411a.c((l) it.next());
            }
            this.f3412b.clear();
        }
    }

    private void a(int i3, String str) {
        this.f3392b.put(Integer.valueOf(i3), str);
        this.f3393c.put(str, Integer.valueOf(i3));
    }

    private void d(String str, int i3, Intent intent, c cVar) {
        if (cVar == null || cVar.f3409a == null || !this.f3395e.contains(str)) {
            this.f3397g.remove(str);
            this.f3398h.putParcelable(str, new androidx.activity.result.a(i3, intent));
        } else {
            cVar.f3409a.a(cVar.f3410b.c(i3, intent));
            this.f3395e.remove(str);
        }
    }

    private int e() {
        int nextInt = this.f3391a.nextInt(2147418112);
        while (true) {
            int i3 = nextInt + 65536;
            if (!this.f3392b.containsKey(Integer.valueOf(i3))) {
                return i3;
            }
            nextInt = this.f3391a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (((Integer) this.f3393c.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i3, int i4, Intent intent) {
        String str = (String) this.f3392b.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        d(str, i4, intent, (c) this.f3396f.get(str));
        return true;
    }

    public final boolean c(int i3, Object obj) {
        androidx.activity.result.b bVar;
        String str = (String) this.f3392b.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        c cVar = (c) this.f3396f.get(str);
        if (cVar == null || (bVar = cVar.f3409a) == null) {
            this.f3398h.remove(str);
            this.f3397g.put(str, obj);
            return true;
        }
        if (!this.f3395e.remove(str)) {
            return true;
        }
        bVar.a(obj);
        return true;
    }

    public abstract void f(int i3, AbstractC0294a abstractC0294a, Object obj, androidx.core.app.b bVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f3395e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f3391a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f3398h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
            String str = stringArrayList.get(i3);
            if (this.f3393c.containsKey(str)) {
                Integer num = (Integer) this.f3393c.remove(str);
                if (!this.f3398h.containsKey(str)) {
                    this.f3392b.remove(num);
                }
            }
            a(integerArrayList.get(i3).intValue(), stringArrayList.get(i3));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f3393c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f3393c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f3395e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f3398h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f3391a);
    }

    public final androidx.activity.result.c i(final String str, o oVar, final AbstractC0294a abstractC0294a, final androidx.activity.result.b bVar) {
        AbstractC0272h lifecycle = oVar.getLifecycle();
        if (lifecycle.b().a(AbstractC0272h.c.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + oVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = (d) this.f3394d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new l() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.l
            public void a(o oVar2, AbstractC0272h.b bVar2) {
                if (!AbstractC0272h.b.ON_START.equals(bVar2)) {
                    if (AbstractC0272h.b.ON_STOP.equals(bVar2)) {
                        ActivityResultRegistry.this.f3396f.remove(str);
                        return;
                    } else {
                        if (AbstractC0272h.b.ON_DESTROY.equals(bVar2)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f3396f.put(str, new c(bVar, abstractC0294a));
                if (ActivityResultRegistry.this.f3397g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f3397g.get(str);
                    ActivityResultRegistry.this.f3397g.remove(str);
                    bVar.a(obj);
                }
                androidx.activity.result.a aVar = (androidx.activity.result.a) ActivityResultRegistry.this.f3398h.getParcelable(str);
                if (aVar != null) {
                    ActivityResultRegistry.this.f3398h.remove(str);
                    bVar.a(abstractC0294a.c(aVar.d(), aVar.c()));
                }
            }
        });
        this.f3394d.put(str, dVar);
        return new a(str, abstractC0294a);
    }

    public final androidx.activity.result.c j(String str, AbstractC0294a abstractC0294a, androidx.activity.result.b bVar) {
        k(str);
        this.f3396f.put(str, new c(bVar, abstractC0294a));
        if (this.f3397g.containsKey(str)) {
            Object obj = this.f3397g.get(str);
            this.f3397g.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar = (androidx.activity.result.a) this.f3398h.getParcelable(str);
        if (aVar != null) {
            this.f3398h.remove(str);
            bVar.a(abstractC0294a.c(aVar.d(), aVar.c()));
        }
        return new b(str, abstractC0294a);
    }

    final void l(String str) {
        Integer num;
        if (!this.f3395e.contains(str) && (num = (Integer) this.f3393c.remove(str)) != null) {
            this.f3392b.remove(num);
        }
        this.f3396f.remove(str);
        if (this.f3397g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f3397g.get(str));
            this.f3397g.remove(str);
        }
        if (this.f3398h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f3398h.getParcelable(str));
            this.f3398h.remove(str);
        }
        d dVar = (d) this.f3394d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f3394d.remove(str);
        }
    }
}
