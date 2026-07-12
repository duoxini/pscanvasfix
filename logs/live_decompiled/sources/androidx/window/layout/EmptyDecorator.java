package androidx.window.layout;

import D2.k;

/* loaded from: classes.dex */
final class EmptyDecorator implements WindowInfoTrackerDecorator {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyDecorator f7142a = new EmptyDecorator();

    private EmptyDecorator() {
    }

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    public WindowInfoTracker a(WindowInfoTracker windowInfoTracker) {
        k.e(windowInfoTracker, "tracker");
        return windowInfoTracker;
    }
}
