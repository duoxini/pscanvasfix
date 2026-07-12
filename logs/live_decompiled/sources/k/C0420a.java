package k;

import java.util.HashMap;
import java.util.Map;
import k.b;

/* renamed from: k.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0420a extends b {

    /* renamed from: i, reason: collision with root package name */
    private HashMap f12189i = new HashMap();

    @Override // k.b
    protected b.c c(Object obj) {
        return (b.c) this.f12189i.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f12189i.containsKey(obj);
    }

    @Override // k.b
    public Object g(Object obj, Object obj2) {
        b.c c3 = c(obj);
        if (c3 != null) {
            return c3.f12195b;
        }
        this.f12189i.put(obj, f(obj, obj2));
        return null;
    }

    @Override // k.b
    public Object h(Object obj) {
        Object h3 = super.h(obj);
        this.f12189i.remove(obj);
        return h3;
    }

    public Map.Entry i(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f12189i.get(obj)).f12197d;
        }
        return null;
    }
}
