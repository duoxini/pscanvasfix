package y1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.util.Objects;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private Rect f14646a;

    /* renamed from: b, reason: collision with root package name */
    private Intent f14647b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f14648c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f14649d;

    /* renamed from: e, reason: collision with root package name */
    private String f14650e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f14651f;

    /* renamed from: g, reason: collision with root package name */
    private int f14652g;

    /* renamed from: h, reason: collision with root package name */
    private int f14653h;

    /* renamed from: i, reason: collision with root package name */
    private float f14654i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14655j;

    public u(Rect rect, Intent intent) {
        new Rect();
        this.f14653h = Integer.MIN_VALUE;
        this.f14654i = -2.14748365E9f;
        this.f14655j = true;
        this.f14646a = rect;
        this.f14647b = intent;
    }

    public int a() {
        return this.f14653h;
    }

    public Bitmap b() {
        return this.f14648c;
    }

    public Drawable c() {
        return this.f14649d;
    }

    public Drawable d() {
        return this.f14651f;
    }

    public Intent e() {
        return this.f14647b;
    }

    public int f() {
        return this.f14652g;
    }

    public float g() {
        return this.f14654i;
    }

    public Rect h() {
        return this.f14646a;
    }

    public int hashCode() {
        return Objects.hash(this.f14646a, this.f14647b, this.f14648c, Boolean.valueOf(this.f14655j));
    }

    public String i() {
        return this.f14650e;
    }

    public boolean j() {
        return this.f14655j;
    }

    public void k(int i3) {
        this.f14653h = i3;
    }

    public void l(Drawable drawable) {
        this.f14649d = drawable;
    }

    public void m(float f3) {
        this.f14654i = f3;
    }

    public void n(Rect rect) {
        this.f14646a.set(rect);
    }

    public void o(String str) {
        this.f14650e = str;
    }

    public void p(u uVar) {
        this.f14646a.set(uVar.f14646a);
        this.f14647b = uVar.f14647b;
        this.f14648c = uVar.f14648c;
        this.f14655j = uVar.f14655j;
        this.f14650e = uVar.f14650e;
        this.f14653h = uVar.f14653h;
        this.f14651f = uVar.f14651f;
        this.f14654i = uVar.f14654i;
        this.f14652g = uVar.f14652g;
        this.f14649d = uVar.f14649d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskData{");
        Intent intent = this.f14647b;
        if (intent != null) {
            sb.append(intent.getComponent());
        }
        if (this.f14648c != null) {
            sb.append(" bitmap: " + this.f14648c);
        }
        sb.append(" rect:" + this.f14646a);
        sb.append(" useBlurAlpha:" + this.f14655j);
        sb.append(" lightMode:" + this.f14652g);
        sb.append(" closeDrawable: " + this.f14649d);
        sb.append("}");
        return sb.toString();
    }

    public u(Rect rect, Intent intent, Drawable drawable) {
        new Rect();
        this.f14653h = Integer.MIN_VALUE;
        this.f14654i = -2.14748365E9f;
        this.f14655j = true;
        this.f14646a = rect;
        this.f14647b = intent;
        this.f14651f = drawable;
    }

    public u(Rect rect, Intent intent, Drawable drawable, Bitmap bitmap) {
        new Rect();
        this.f14653h = Integer.MIN_VALUE;
        this.f14654i = -2.14748365E9f;
        this.f14655j = true;
        this.f14646a = rect;
        this.f14647b = intent;
        this.f14651f = drawable;
        this.f14648c = bitmap;
    }

    public u(Rect rect, Intent intent, Drawable drawable, Bitmap bitmap, int i3) {
        new Rect();
        this.f14653h = Integer.MIN_VALUE;
        this.f14654i = -2.14748365E9f;
        this.f14655j = true;
        this.f14646a = rect;
        this.f14647b = intent;
        this.f14651f = drawable;
        this.f14648c = bitmap;
        this.f14652g = i3;
    }

    public u(Rect rect, Intent intent, Bitmap bitmap) {
        Rect rect2 = new Rect();
        this.f14646a = rect2;
        this.f14653h = Integer.MIN_VALUE;
        this.f14654i = -2.14748365E9f;
        this.f14655j = true;
        rect2.set(rect);
        this.f14647b = intent;
        this.f14648c = bitmap;
    }

    public u(u uVar) {
        Rect rect = new Rect();
        this.f14646a = rect;
        this.f14653h = Integer.MIN_VALUE;
        this.f14654i = -2.14748365E9f;
        this.f14655j = true;
        rect.set(uVar.f14646a);
        this.f14647b = uVar.f14647b;
        this.f14648c = uVar.f14648c;
        this.f14651f = uVar.f14651f;
        this.f14655j = uVar.f14655j;
        this.f14653h = uVar.f14653h;
        this.f14654i = uVar.f14654i;
        this.f14652g = uVar.f14652g;
    }
}
