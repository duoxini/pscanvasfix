package com.coui.component.responsiveui.status;

import D2.g;
import D2.k;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import java.util.List;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class WindowFeature {

    /* renamed from: a, reason: collision with root package name */
    private final List f9354a;

    /* renamed from: b, reason: collision with root package name */
    private final List f9355b;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowFeature() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowFeature copy$default(WindowFeature windowFeature, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = windowFeature.f9354a;
        }
        if ((i3 & 2) != 0) {
            list2 = windowFeature.f9355b;
        }
        return windowFeature.copy(list, list2);
    }

    public final List<DisplayFeature> component1() {
        return this.f9354a;
    }

    public final List<FoldingFeature> component2() {
        return this.f9355b;
    }

    public final WindowFeature copy(List<? extends DisplayFeature> list, List<? extends FoldingFeature> list2) {
        k.e(list, "displayFeatureList");
        k.e(list2, "foldingFeatureList");
        return new WindowFeature(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowFeature)) {
            return false;
        }
        WindowFeature windowFeature = (WindowFeature) obj;
        return k.a(this.f9354a, windowFeature.f9354a) && k.a(this.f9355b, windowFeature.f9355b);
    }

    public final List<DisplayFeature> getDisplayFeatureList() {
        return this.f9354a;
    }

    public final List<FoldingFeature> getFoldingFeatureList() {
        return this.f9355b;
    }

    public int hashCode() {
        return (this.f9354a.hashCode() * 31) + this.f9355b.hashCode();
    }

    public String toString() {
        return "WindowFeature { displayFeature = " + this.f9354a + ", foldingFeature = " + this.f9355b + " }";
    }

    public WindowFeature(List<? extends DisplayFeature> list, List<? extends FoldingFeature> list2) {
        k.e(list, "displayFeatureList");
        k.e(list2, "foldingFeatureList");
        this.f9354a = list;
        this.f9355b = list2;
    }

    public /* synthetic */ WindowFeature(List list, List list2, int i3, g gVar) {
        this((i3 & 1) != 0 ? AbstractC0544n.j() : list, (i3 & 2) != 0 ? AbstractC0544n.j() : list2);
    }
}
