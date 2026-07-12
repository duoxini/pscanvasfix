package com.oplus.anim;

import a1.AbstractC0220B;
import a1.C0219A;
import a1.C0221a;
import a1.C0224d;
import a1.InterfaceC0222b;
import a1.InterfaceC0223c;
import a1.q;
import a1.t;
import a1.u;
import a1.w;
import a1.x;
import a1.y;
import a1.z;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.p;
import androidx.appcompat.widget.AppCompatImageView;
import com.oplus.anim.EffectiveAnimationView;
import f.AbstractC0348a;
import f1.C0358f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import m1.AbstractC0462e;
import m1.AbstractC0465h;
import n1.C0483b;

/* loaded from: classes.dex */
public class EffectiveAnimationView extends AppCompatImageView {

    /* renamed from: x, reason: collision with root package name */
    private static final String f10032x = "EffectiveAnimationView";

    /* renamed from: h, reason: collision with root package name */
    private String f10033h;

    /* renamed from: i, reason: collision with root package name */
    private final InterfaceC0222b f10034i;

    /* renamed from: j, reason: collision with root package name */
    private final InterfaceC0222b f10035j;

    /* renamed from: k, reason: collision with root package name */
    private final InterfaceC0222b f10036k;

    /* renamed from: l, reason: collision with root package name */
    private InterfaceC0222b f10037l;

    /* renamed from: m, reason: collision with root package name */
    private int f10038m;

    /* renamed from: n, reason: collision with root package name */
    private final n f10039n;

    /* renamed from: o, reason: collision with root package name */
    private String f10040o;

    /* renamed from: p, reason: collision with root package name */
    private int f10041p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f10042q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10043r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f10044s;

    /* renamed from: t, reason: collision with root package name */
    private final Set f10045t;

    /* renamed from: u, reason: collision with root package name */
    private final Set f10046u;

    /* renamed from: v, reason: collision with root package name */
    private o f10047v;

    /* renamed from: w, reason: collision with root package name */
    private C0221a f10048w;

    class a implements InterfaceC0222b {
        a() {
        }

        @Override // a1.InterfaceC0222b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            if (EffectiveAnimationView.this.f10038m != 0) {
                EffectiveAnimationView effectiveAnimationView = EffectiveAnimationView.this;
                effectiveAnimationView.setImageResource(effectiveAnimationView.f10038m);
            }
            InterfaceC0222b interfaceC0222b = EffectiveAnimationView.this.f10037l;
            EffectiveAnimationView effectiveAnimationView2 = EffectiveAnimationView.this;
            (interfaceC0222b == null ? effectiveAnimationView2.f10034i : effectiveAnimationView2.f10037l).a(th);
        }
    }

    private static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f10050e;

        /* renamed from: f, reason: collision with root package name */
        int f10051f;

        /* renamed from: g, reason: collision with root package name */
        float f10052g;

        /* renamed from: h, reason: collision with root package name */
        boolean f10053h;

        /* renamed from: i, reason: collision with root package name */
        String f10054i;

        /* renamed from: j, reason: collision with root package name */
        int f10055j;

        /* renamed from: k, reason: collision with root package name */
        int f10056k;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        /* synthetic */ b(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f10050e);
            parcel.writeFloat(this.f10052g);
            parcel.writeInt(this.f10053h ? 1 : 0);
            parcel.writeString(this.f10054i);
            parcel.writeInt(this.f10055j);
            parcel.writeInt(this.f10056k);
        }

        b(Parcelable parcelable) {
            super(parcelable);
        }

        private b(Parcel parcel) {
            super(parcel);
            this.f10050e = parcel.readString();
            this.f10052g = parcel.readFloat();
            this.f10053h = parcel.readInt() == 1;
            this.f10054i = parcel.readString();
            this.f10055j = parcel.readInt();
            this.f10056k = parcel.readInt();
        }
    }

    private enum c {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public EffectiveAnimationView(Context context) {
        super(context);
        this.f10033h = "";
        this.f10034i = new InterfaceC0222b() { // from class: a1.f
            @Override // a1.InterfaceC0222b
            public final void a(Object obj) {
                EffectiveAnimationView.this.s((Throwable) obj);
            }
        };
        this.f10035j = new InterfaceC0222b() { // from class: a1.g
            @Override // a1.InterfaceC0222b
            public final void a(Object obj) {
                EffectiveAnimationView.this.setComposition((C0221a) obj);
            }
        };
        this.f10036k = new a();
        this.f10038m = 0;
        this.f10039n = new n();
        this.f10042q = false;
        this.f10043r = false;
        this.f10044s = true;
        this.f10045t = new HashSet();
        this.f10046u = new HashSet();
        o(null, x.f3270a);
    }

    private void A() {
        boolean p3 = p();
        setImageDrawable(null);
        setImageDrawable(this.f10039n);
        if (p3) {
            this.f10039n.u0();
        }
    }

    private void B(float f3, boolean z3) {
        if (z3) {
            this.f10045t.add(c.SET_PROGRESS);
        }
        this.f10039n.R0(f3);
    }

    private void j() {
        o oVar = this.f10047v;
        if (oVar != null) {
            oVar.j(this.f10035j);
            this.f10047v.i(this.f10036k);
        }
    }

    private void k() {
        this.f10048w = null;
        this.f10039n.u();
    }

    private o m(final String str) {
        return isInEditMode() ? new o(new Callable() { // from class: a1.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0224d q3;
                q3 = EffectiveAnimationView.this.q(str);
                return q3;
            }
        }, true) : this.f10044s ? q.j(getContext(), str) : q.k(getContext(), str, null);
    }

    private o n(final int i3) {
        return isInEditMode() ? new o(new Callable() { // from class: a1.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0224d r3;
                r3 = EffectiveAnimationView.this.r(i3);
                return r3;
            }
        }, true) : this.f10044s ? q.s(getContext(), i3) : q.t(getContext(), i3, null);
    }

    private void o(AttributeSet attributeSet, int i3) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, y.f3328t, i3, 0);
        this.f10044s = obtainStyledAttributes.getBoolean(y.f3330v, true);
        boolean hasValue = obtainStyledAttributes.hasValue(y.f3277G);
        boolean hasValue2 = obtainStyledAttributes.hasValue(y.f3272B);
        boolean hasValue3 = obtainStyledAttributes.hasValue(y.f3282L);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("anim_rawRes and anim_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(y.f3277G, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(y.f3272B);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(y.f3282L)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(y.f3271A, 0));
        if (obtainStyledAttributes.getBoolean(y.f3329u, false)) {
            this.f10043r = true;
        }
        if (obtainStyledAttributes.getBoolean(y.f3275E, false)) {
            this.f10039n.T0(-1);
        }
        if (obtainStyledAttributes.hasValue(y.f3280J)) {
            setRepeatMode(obtainStyledAttributes.getInt(y.f3280J, 1));
        }
        if (obtainStyledAttributes.hasValue(y.f3279I)) {
            setRepeatCount(obtainStyledAttributes.getInt(y.f3279I, -1));
        }
        if (obtainStyledAttributes.hasValue(y.f3281K)) {
            setSpeed(obtainStyledAttributes.getFloat(y.f3281K, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(y.f3331w)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(y.f3331w, true));
        }
        if (obtainStyledAttributes.hasValue(y.f3333y)) {
            setDefaultFontFileExtension(obtainStyledAttributes.getString(y.f3333y));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(y.f3274D));
        B(obtainStyledAttributes.getFloat(y.f3276F, 0.0f), obtainStyledAttributes.hasValue(y.f3276F));
        l(obtainStyledAttributes.getBoolean(y.f3334z, false));
        if (obtainStyledAttributes.hasValue(y.f3332x)) {
            h(new C0358f("**"), InterfaceC0223c.f3188K, new C0483b(new C0219A(AbstractC0348a.a(getContext(), obtainStyledAttributes.getResourceId(y.f3332x, -1)).getDefaultColor())));
        }
        if (obtainStyledAttributes.hasValue(y.f3278H)) {
            int i4 = y.f3278H;
            z zVar = z.AUTOMATIC;
            int i5 = obtainStyledAttributes.getInt(i4, zVar.ordinal());
            if (i5 >= z.values().length) {
                i5 = zVar.ordinal();
            }
            setRenderMode(z.values()[i5]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(y.f3273C, false));
        if (obtainStyledAttributes.hasValue(y.f3283M)) {
            setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(y.f3283M, false));
        }
        obtainStyledAttributes.recycle();
        this.f10039n.X0(Boolean.valueOf(AbstractC0465h.f(getContext()) != 0.0f));
        this.f10033h = AbstractC0465h.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C0224d q(String str) {
        return this.f10044s ? q.l(getContext(), str) : q.m(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C0224d r(int i3) {
        return this.f10044s ? q.u(getContext(), i3) : q.v(getContext(), i3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Throwable th) {
        if (AbstractC0465h.l(th)) {
            AbstractC0462e.d("Unable to load composition.", th);
            return;
        }
        Log.d(f10032x, "Unable to parse composition callers:" + this.f10033h);
        throw new IllegalStateException("Unable to parse composition", th);
    }

    private void setCompositionTask(o oVar) {
        this.f10045t.add(c.SET_ANIMATION);
        k();
        j();
        this.f10047v = oVar.d(this.f10035j).c(this.f10036k);
    }

    public void g(Animator.AnimatorListener animatorListener) {
        this.f10039n.p(animatorListener);
    }

    public boolean getClipToCompositionBounds() {
        return this.f10039n.F();
    }

    public C0221a getComposition() {
        return this.f10048w;
    }

    public long getDuration() {
        C0221a c0221a = this.f10048w;
        if (c0221a != null) {
            return (long) c0221a.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f10039n.J();
    }

    public String getImageAssetsFolder() {
        return this.f10039n.L();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f10039n.N();
    }

    public float getMaxFrame() {
        return this.f10039n.O();
    }

    public float getMinFrame() {
        return this.f10039n.P();
    }

    public w getPerformanceTracker() {
        return this.f10039n.Q();
    }

    public float getProgress() {
        return this.f10039n.R();
    }

    public z getRenderMode() {
        return this.f10039n.S();
    }

    public int getRepeatCount() {
        return this.f10039n.T();
    }

    public int getRepeatMode() {
        return this.f10039n.U();
    }

    public float getSpeed() {
        return this.f10039n.V();
    }

    public void h(C0358f c0358f, Object obj, C0483b c0483b) {
        this.f10039n.q(c0358f, obj, c0483b);
    }

    public void i() {
        this.f10045t.add(c.PLAY_OPTION);
        this.f10039n.t();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof n) && ((n) drawable).S() == z.SOFTWARE) {
            this.f10039n.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        n nVar = this.f10039n;
        if (drawable2 == nVar) {
            super.invalidateDrawable(nVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void l(boolean z3) {
        this.f10039n.z(z3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f10043r) {
            return;
        }
        this.f10039n.q0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i3;
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f10040o = bVar.f10050e;
        Set set = this.f10045t;
        c cVar = c.SET_ANIMATION;
        if (!set.contains(cVar) && !TextUtils.isEmpty(this.f10040o)) {
            setAnimation(this.f10040o);
        }
        this.f10041p = bVar.f10051f;
        if (!this.f10045t.contains(cVar) && (i3 = this.f10041p) != 0) {
            setAnimation(i3);
        }
        if (!this.f10045t.contains(c.SET_PROGRESS)) {
            B(bVar.f10052g, false);
        }
        if (!this.f10045t.contains(c.PLAY_OPTION) && bVar.f10053h) {
            v();
        }
        if (!this.f10045t.contains(c.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(bVar.f10054i);
        }
        if (!this.f10045t.contains(c.SET_REPEAT_MODE)) {
            setRepeatMode(bVar.f10055j);
        }
        if (this.f10045t.contains(c.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(bVar.f10056k);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f10050e = this.f10040o;
        bVar.f10051f = this.f10041p;
        bVar.f10052g = this.f10039n.R();
        bVar.f10053h = this.f10039n.a0();
        bVar.f10054i = this.f10039n.L();
        bVar.f10055j = this.f10039n.U();
        bVar.f10056k = this.f10039n.T();
        return bVar;
    }

    public boolean p() {
        return this.f10039n.Z();
    }

    public void setAnimation(int i3) {
        this.f10041p = i3;
        this.f10040o = null;
        setCompositionTask(n(i3));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        z(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f10044s ? q.w(getContext(), str) : q.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z3) {
        this.f10039n.w0(z3);
    }

    public void setCacheComposition(boolean z3) {
        this.f10044s = z3;
    }

    public void setClipToCompositionBounds(boolean z3) {
        this.f10039n.x0(z3);
    }

    public void setComposition(C0221a c0221a) {
        this.f10039n.setCallback(this);
        this.f10048w = c0221a;
        this.f10042q = true;
        boolean y02 = this.f10039n.y0(c0221a);
        this.f10042q = false;
        if (getDrawable() != this.f10039n || y02) {
            if (!y02) {
                A();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.f10046u.iterator();
            if (it.hasNext()) {
                p.a(it.next());
                throw null;
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f10039n.z0(str);
    }

    public void setFailureListener(InterfaceC0222b interfaceC0222b) {
        this.f10037l = interfaceC0222b;
    }

    public void setFallbackResource(int i3) {
        this.f10038m = i3;
    }

    public void setFontAssetDelegate(t tVar) {
        this.f10039n.A0(tVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.f10039n.B0(map);
    }

    public void setFrame(int i3) {
        this.f10039n.C0(i3);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z3) {
        this.f10039n.D0(z3);
    }

    public void setImageAssetDelegate(u uVar) {
        this.f10039n.E0(uVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f10039n.F0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        j();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        j();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        j();
        super.setImageResource(i3);
    }

    public void setMaintainOriginalImageBounds(boolean z3) {
        this.f10039n.G0(z3);
    }

    public void setMaxFrame(int i3) {
        this.f10039n.H0(i3);
    }

    public void setMaxProgress(float f3) {
        this.f10039n.J0(f3);
    }

    public void setMinAndMaxFrame(String str) {
        this.f10039n.L0(str);
    }

    public void setMinFrame(int i3) {
        this.f10039n.M0(i3);
    }

    public void setMinProgress(float f3) {
        this.f10039n.O0(f3);
    }

    public void setOutlineMasksAndMattes(boolean z3) {
        this.f10039n.P0(z3);
    }

    public void setPerformanceTrackingEnabled(boolean z3) {
        this.f10039n.Q0(z3);
    }

    public void setProgress(float f3) {
        B(f3, true);
    }

    public void setRenderMode(z zVar) {
        this.f10039n.S0(zVar);
    }

    public void setRepeatCount(int i3) {
        this.f10045t.add(c.SET_REPEAT_COUNT);
        this.f10039n.T0(i3);
    }

    public void setRepeatMode(int i3) {
        this.f10045t.add(c.SET_REPEAT_MODE);
        this.f10039n.U0(i3);
    }

    public void setSafeMode(boolean z3) {
        this.f10039n.V0(z3);
    }

    public void setSpeed(float f3) {
        this.f10039n.W0(f3);
    }

    public void setTextDelegate(AbstractC0220B abstractC0220B) {
        this.f10039n.Y0(abstractC0220B);
    }

    public void setUseCompositionFrameRate(boolean z3) {
        this.f10039n.Z0(z3);
    }

    public void t(boolean z3) {
        this.f10039n.T0(z3 ? -1 : 0);
    }

    public void u() {
        this.f10043r = false;
        this.f10039n.p0();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        n nVar;
        if (!this.f10042q && drawable == (nVar = this.f10039n) && nVar.Z()) {
            u();
        } else if (!this.f10042q && (drawable instanceof n)) {
            n nVar2 = (n) drawable;
            if (nVar2.Z()) {
                nVar2.p0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void v() {
        this.f10045t.add(c.PLAY_OPTION);
        this.f10039n.q0();
    }

    public void w() {
        this.f10039n.r0();
    }

    public void x() {
        this.f10045t.add(c.PLAY_OPTION);
        this.f10039n.u0();
    }

    public void y(InputStream inputStream, String str) {
        setCompositionTask(q.n(inputStream, str));
    }

    public void z(String str, String str2) {
        y(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f10039n.I0(str);
    }

    public void setMinFrame(String str) {
        this.f10039n.N0(str);
    }

    public void setAnimation(String str) {
        this.f10040o = str;
        this.f10041p = 0;
        setCompositionTask(m(str));
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10033h = "";
        this.f10034i = new InterfaceC0222b() { // from class: a1.f
            @Override // a1.InterfaceC0222b
            public final void a(Object obj) {
                EffectiveAnimationView.this.s((Throwable) obj);
            }
        };
        this.f10035j = new InterfaceC0222b() { // from class: a1.g
            @Override // a1.InterfaceC0222b
            public final void a(Object obj) {
                EffectiveAnimationView.this.setComposition((C0221a) obj);
            }
        };
        this.f10036k = new a();
        this.f10038m = 0;
        this.f10039n = new n();
        this.f10042q = false;
        this.f10043r = false;
        this.f10044s = true;
        this.f10045t = new HashSet();
        this.f10046u = new HashSet();
        o(attributeSet, x.f3270a);
    }
}
