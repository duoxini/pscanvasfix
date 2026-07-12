package r1;

import p1.C0500e;
import q1.C0516a;

/* renamed from: r1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0568c {

    /* renamed from: a, reason: collision with root package name */
    public C0516a f13235a;

    /* renamed from: b, reason: collision with root package name */
    public C0516a f13236b;

    /* renamed from: c, reason: collision with root package name */
    public final C0500e f13237c;

    /* renamed from: d, reason: collision with root package name */
    public float f13238d;

    /* renamed from: e, reason: collision with root package name */
    public float f13239e;

    /* renamed from: f, reason: collision with root package name */
    public float f13240f;

    public C0568c() {
        C0500e c0500e = new C0500e();
        this.f13237c = c0500e;
        c0500e.d(0.0f, 0.0f);
        this.f13238d = Float.MAX_VALUE;
        this.f13239e = 6.0f;
        this.f13240f = 0.8f;
    }

    public String toString() {
        return "SpringDef{target=" + this.f13237c + ", frequencyHz=" + this.f13239e + ", dampingRatio=" + this.f13240f + "}@" + hashCode();
    }
}
