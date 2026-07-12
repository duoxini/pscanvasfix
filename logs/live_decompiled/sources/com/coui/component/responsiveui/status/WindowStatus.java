package com.coui.component.responsiveui.status;

import D2.g;
import D2.k;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;

/* loaded from: classes.dex */
public final class WindowStatus implements IWindowStatus {

    /* renamed from: a, reason: collision with root package name */
    private int f9369a;

    /* renamed from: b, reason: collision with root package name */
    private WindowSizeClass f9370b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutGridWindowSize f9371c;

    public WindowStatus(int i3, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize) {
        k.e(windowSizeClass, "windowSizeClass");
        k.e(layoutGridWindowSize, "layoutGridWindowSize");
        this.f9369a = i3;
        this.f9370b = windowSizeClass;
        this.f9371c = layoutGridWindowSize;
    }

    public static /* synthetic */ WindowStatus copy$default(WindowStatus windowStatus, int i3, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = windowStatus.f9369a;
        }
        if ((i4 & 2) != 0) {
            windowSizeClass = windowStatus.f9370b;
        }
        if ((i4 & 4) != 0) {
            layoutGridWindowSize = windowStatus.f9371c;
        }
        return windowStatus.copy(i3, windowSizeClass, layoutGridWindowSize);
    }

    public final int component1() {
        return this.f9369a;
    }

    public final WindowSizeClass component2() {
        return this.f9370b;
    }

    public final LayoutGridWindowSize component3() {
        return this.f9371c;
    }

    public final WindowStatus copy(int i3, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize) {
        k.e(windowSizeClass, "windowSizeClass");
        k.e(layoutGridWindowSize, "layoutGridWindowSize");
        return new WindowStatus(i3, windowSizeClass, layoutGridWindowSize);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowStatus)) {
            return false;
        }
        WindowStatus windowStatus = (WindowStatus) obj;
        return this.f9369a == windowStatus.f9369a && k.a(this.f9370b, windowStatus.f9370b) && k.a(this.f9371c, windowStatus.f9371c);
    }

    public final LayoutGridWindowSize getLayoutGridWindowSize() {
        return this.f9371c;
    }

    public final int getOrientation() {
        return this.f9369a;
    }

    public final WindowSizeClass getWindowSizeClass() {
        return this.f9370b;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f9369a) * 31) + this.f9370b.hashCode()) * 31) + this.f9371c.hashCode();
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public LayoutGridWindowSize layoutGridWindowSize() {
        return this.f9371c;
    }

    public final void setLayoutGridWindowSize(LayoutGridWindowSize layoutGridWindowSize) {
        k.e(layoutGridWindowSize, "<set-?>");
        this.f9371c = layoutGridWindowSize;
    }

    public final void setOrientation(int i3) {
        this.f9369a = i3;
    }

    public final void setWindowSizeClass(WindowSizeClass windowSizeClass) {
        k.e(windowSizeClass, "<set-?>");
        this.f9370b = windowSizeClass;
    }

    public String toString() {
        return "WindowStatus { orientation = " + this.f9369a + ", windowSizeClass = " + this.f9370b + ", windowSize = " + this.f9371c + " }";
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public int windowOrientation() {
        return this.f9369a;
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public WindowSizeClass windowSizeClass() {
        return this.f9370b;
    }

    public /* synthetic */ WindowStatus(int i3, WindowSizeClass windowSizeClass, LayoutGridWindowSize layoutGridWindowSize, int i4, g gVar) {
        this((i4 & 1) != 0 ? 0 : i3, windowSizeClass, layoutGridWindowSize);
    }
}
