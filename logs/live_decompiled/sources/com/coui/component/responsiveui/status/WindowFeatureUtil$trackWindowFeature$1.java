package com.coui.component.responsiveui.status;

import C2.p;
import L2.D;
import O2.c;
import O2.d;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.window.layout.WindowInfoTracker;
import java.util.function.Consumer;
import p2.l;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;
import v2.f;
import v2.k;

@f(c = "com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1", f = "WindowFeatureUtil.kt", l = {47}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowFeatureUtil$trackWindowFeature$1 extends k implements p {

    /* renamed from: i, reason: collision with root package name */
    int f9362i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f9363j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Consumer f9364k;

    @f(c = "com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1", f = "WindowFeatureUtil.kt", l = {55}, m = "invokeSuspend")
    /* renamed from: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends k implements p {

        /* renamed from: i, reason: collision with root package name */
        int f9365i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ComponentActivity f9366j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Consumer f9367k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ComponentActivity componentActivity, Consumer consumer, InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
            this.f9366j = componentActivity;
            this.f9367k = consumer;
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            return new AnonymousClass1(this.f9366j, this.f9367k, interfaceC0593d);
        }

        @Override // C2.p
        public final Object invoke(D d3, InterfaceC0593d interfaceC0593d) {
            return ((AnonymousClass1) create(d3, interfaceC0593d)).invokeSuspend(q.f12810a);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            Object c3 = AbstractC0603b.c();
            int i3 = this.f9365i;
            if (i3 == 0) {
                l.b(obj);
                final c a3 = WindowInfoTracker.f7170a.d(this.f9366j).a(this.f9366j);
                c cVar = new c() { // from class: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1

                    /* renamed from: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements d {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ d f9358a;

                        @f(c = "com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2", f = "WindowFeatureUtil.kt", l = {223}, m = "emit")
                        /* renamed from: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends v2.d {

                            /* renamed from: h, reason: collision with root package name */
                            /* synthetic */ Object f9359h;

                            /* renamed from: i, reason: collision with root package name */
                            int f9360i;

                            public AnonymousClass1(InterfaceC0593d interfaceC0593d) {
                                super(interfaceC0593d);
                            }

                            @Override // v2.AbstractC0610a
                            public final Object invokeSuspend(Object obj) {
                                this.f9359h = obj;
                                this.f9360i |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(d dVar) {
                            this.f9358a = dVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                        @Override // O2.d
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r7, t2.InterfaceC0593d r8) {
                            /*
                                r6 = this;
                                boolean r0 = r8 instanceof com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r8
                                com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.f9360i
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.f9360i = r1
                                goto L18
                            L13:
                                com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r8)
                            L18:
                                java.lang.Object r8 = r0.f9359h
                                java.lang.Object r1 = u2.AbstractC0603b.c()
                                int r2 = r0.f9360i
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                p2.l.b(r8)
                                goto L68
                            L29:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L31:
                                p2.l.b(r8)
                                O2.d r6 = r6.f9358a
                                androidx.window.layout.WindowLayoutInfo r7 = (androidx.window.layout.WindowLayoutInfo) r7
                                java.util.List r7 = r7.a()
                                r8 = r7
                                java.lang.Iterable r8 = (java.lang.Iterable) r8
                                java.util.ArrayList r2 = new java.util.ArrayList
                                r2.<init>()
                                java.util.Iterator r8 = r8.iterator()
                            L48:
                                boolean r4 = r8.hasNext()
                                if (r4 == 0) goto L5a
                                java.lang.Object r4 = r8.next()
                                boolean r5 = r4 instanceof androidx.window.layout.FoldingFeature
                                if (r5 == 0) goto L48
                                r2.add(r4)
                                goto L48
                            L5a:
                                com.coui.component.responsiveui.status.WindowFeature r8 = new com.coui.component.responsiveui.status.WindowFeature
                                r8.<init>(r7, r2)
                                r0.f9360i = r3
                                java.lang.Object r6 = r6.emit(r8, r0)
                                if (r6 != r1) goto L68
                                return r1
                            L68:
                                p2.q r6 = p2.q.f12810a
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, t2.d):java.lang.Object");
                        }
                    }

                    @Override // O2.c
                    public Object collect(d dVar, InterfaceC0593d interfaceC0593d) {
                        Object collect = c.this.collect(new AnonymousClass2(dVar), interfaceC0593d);
                        return collect == AbstractC0603b.c() ? collect : q.f12810a;
                    }
                };
                final Consumer consumer = this.f9367k;
                d dVar = new d() { // from class: com.coui.component.responsiveui.status.WindowFeatureUtil.trackWindowFeature.1.1.2
                    @Override // O2.d
                    public final Object emit(WindowFeature windowFeature, InterfaceC0593d interfaceC0593d) {
                        boolean z3;
                        consumer.accept(windowFeature);
                        z3 = WindowFeatureUtil.f9356a;
                        if (z3) {
                            Log.d("WindowFeatureUtil", "[trackWindowFeature] windowFeature = " + windowFeature);
                        }
                        return q.f12810a;
                    }
                };
                this.f9365i = 1;
                if (cVar.collect(dVar, this) == c3) {
                    return c3;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.b(obj);
            }
            return q.f12810a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowFeatureUtil$trackWindowFeature$1(ComponentActivity componentActivity, Consumer consumer, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f9363j = componentActivity;
        this.f9364k = consumer;
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        return new WindowFeatureUtil$trackWindowFeature$1(this.f9363j, this.f9364k, interfaceC0593d);
    }

    @Override // C2.p
    public final Object invoke(D d3, InterfaceC0593d interfaceC0593d) {
        return ((WindowFeatureUtil$trackWindowFeature$1) create(d3, interfaceC0593d)).invokeSuspend(q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        Object c3 = AbstractC0603b.c();
        int i3 = this.f9362i;
        if (i3 == 0) {
            l.b(obj);
            AbstractC0272h lifecycle = this.f9363j.getLifecycle();
            D2.k.d(lifecycle, "activity.lifecycle");
            AbstractC0272h.c cVar = AbstractC0272h.c.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f9363j, this.f9364k, null);
            this.f9362i = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, cVar, anonymousClass1, this) == c3) {
                return c3;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.b(obj);
        }
        return q.f12810a;
    }
}
