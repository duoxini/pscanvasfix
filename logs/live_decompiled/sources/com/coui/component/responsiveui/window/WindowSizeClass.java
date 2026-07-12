package com.coui.component.responsiveui.window;

import D2.g;
import D2.k;
import com.coui.component.responsiveui.unit.Dp;

/* loaded from: classes.dex */
public final class WindowSizeClass {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final WindowWidthSizeClass f9379a;

    /* renamed from: b, reason: collision with root package name */
    private final WindowHeightSizeClass f9380b;

    /* renamed from: c, reason: collision with root package name */
    private final WindowTotalSizeClass f9381c;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WindowSizeClass calculateFromSize(Dp dp, Dp dp2) {
            k.e(dp, "width");
            k.e(dp2, "height");
            return new WindowSizeClass(WindowWidthSizeClass.Companion.fromWidth(dp), WindowHeightSizeClass.Companion.fromHeight(dp2), WindowTotalSizeClass.Companion.fromWidthAndHeight(dp, dp2), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass, WindowTotalSizeClass windowTotalSizeClass, g gVar) {
        this(windowWidthSizeClass, windowHeightSizeClass, windowTotalSizeClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WindowSizeClass.class != obj.getClass()) {
            return false;
        }
        WindowSizeClass windowSizeClass = (WindowSizeClass) obj;
        return k.a(this.f9379a, windowSizeClass.f9379a) && k.a(this.f9380b, windowSizeClass.f9380b) && k.a(this.f9381c, windowSizeClass.f9381c);
    }

    public final WindowHeightSizeClass getWindowHeightSizeClass() {
        return this.f9380b;
    }

    public final WindowTotalSizeClass getWindowTotalSizeClass() {
        return this.f9381c;
    }

    public final WindowWidthSizeClass getWindowWidthSizeClass() {
        return this.f9379a;
    }

    public int hashCode() {
        return (((this.f9379a.hashCode() * 31) + this.f9380b.hashCode()) * 31) + this.f9381c.hashCode();
    }

    public String toString() {
        return "WindowSizeClass(" + this.f9379a + ", " + this.f9380b + ", " + this.f9381c + ')';
    }

    private WindowSizeClass(WindowWidthSizeClass windowWidthSizeClass, WindowHeightSizeClass windowHeightSizeClass, WindowTotalSizeClass windowTotalSizeClass) {
        this.f9379a = windowWidthSizeClass;
        this.f9380b = windowHeightSizeClass;
        this.f9381c = windowTotalSizeClass;
    }
}
