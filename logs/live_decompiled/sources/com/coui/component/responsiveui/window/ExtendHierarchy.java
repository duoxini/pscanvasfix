package com.coui.component.responsiveui.window;

import D2.g;
import D2.k;
import android.content.Context;
import com.coui.component.responsiveui.unit.Dp;

/* loaded from: classes.dex */
public final class ExtendHierarchy {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static final Dp f9373a = new Dp(280);

    /* renamed from: b, reason: collision with root package name */
    private static final Dp f9374b = new Dp(360);

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final float childWindowWidth(Context context, WindowWidthSizeClass windowWidthSizeClass, int i3) {
            k.e(context, "context");
            k.e(windowWidthSizeClass, "windowWidthSizeClass");
            return i3 - parentWindowWidth(context, windowWidthSizeClass, i3);
        }

        public final float parentWindowWidth(Context context, WindowWidthSizeClass windowWidthSizeClass, int i3) {
            k.e(context, "context");
            k.e(windowWidthSizeClass, "windowWidthSizeClass");
            return k.a(windowWidthSizeClass, WindowWidthSizeClass.Medium) ? ExtendHierarchy.f9373a.toPixel(context) : k.a(windowWidthSizeClass, WindowWidthSizeClass.Expanded) ? ExtendHierarchy.f9374b.toPixel(context) : i3;
        }

        private Companion() {
        }

        public final Dp childWindowWidth(WindowWidthSizeClass windowWidthSizeClass, Dp dp) {
            k.e(windowWidthSizeClass, "windowWidthSizeClass");
            k.e(dp, "windowWidth");
            return dp.minus(parentWindowWidth(windowWidthSizeClass, dp));
        }

        public final Dp parentWindowWidth(WindowWidthSizeClass windowWidthSizeClass, Dp dp) {
            k.e(windowWidthSizeClass, "windowWidthSizeClass");
            k.e(dp, "windowWidth");
            return k.a(windowWidthSizeClass, WindowWidthSizeClass.Medium) ? ExtendHierarchy.f9373a : k.a(windowWidthSizeClass, WindowWidthSizeClass.Expanded) ? ExtendHierarchy.f9374b : dp;
        }
    }
}
