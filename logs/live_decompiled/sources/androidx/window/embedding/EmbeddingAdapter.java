package androidx.window.embedding;

import D2.g;
import D2.k;
import android.os.Binder;
import android.os.IBinder;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.PredicateAdapter;
import androidx.window.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class EmbeddingAdapter {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f6999d = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Binder f7000e = new Binder();

    /* renamed from: f, reason: collision with root package name */
    private static final Binder f7001f = new Binder();

    /* renamed from: a, reason: collision with root package name */
    private final PredicateAdapter f7002a;

    /* renamed from: b, reason: collision with root package name */
    private final VendorApiLevel1Impl f7003b;

    /* renamed from: c, reason: collision with root package name */
    private final VendorApiLevel2Impl f7004c;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Binder a() {
            return EmbeddingAdapter.f7000e;
        }

        private Companion() {
        }
    }

    private final class VendorApiLevel1Impl {

        /* renamed from: a, reason: collision with root package name */
        private final PredicateAdapter f7005a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EmbeddingAdapter f7006b;

        public VendorApiLevel1Impl(EmbeddingAdapter embeddingAdapter, PredicateAdapter predicateAdapter) {
            k.e(predicateAdapter, "predicateAdapter");
            this.f7006b = embeddingAdapter;
            this.f7005a = predicateAdapter;
        }

        public final SplitAttributes a(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            k.e(splitInfo, "splitInfo");
            return new SplitAttributes.Builder().c(SplitAttributes.SplitType.f7079c.a(splitInfo.getSplitRatio())).b(SplitAttributes.LayoutDirection.f7072d).a();
        }

        public final SplitInfo b(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            k.e(splitInfo, "splitInfo");
            List activities = splitInfo.getPrimaryActivityStack().getActivities();
            k.d(activities, "splitInfo.primaryActivityStack.activities");
            ActivityStack activityStack = new ActivityStack(activities, splitInfo.getPrimaryActivityStack().isEmpty());
            List activities2 = splitInfo.getSecondaryActivityStack().getActivities();
            k.d(activities2, "splitInfo.secondaryActivityStack.activities");
            return new SplitInfo(activityStack, new ActivityStack(activities2, splitInfo.getSecondaryActivityStack().isEmpty()), a(splitInfo), EmbeddingAdapter.f6999d.a());
        }
    }

    private final class VendorApiLevel2Impl {
        public VendorApiLevel2Impl() {
        }

        public final SplitInfo a(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            k.e(splitInfo, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            k.d(primaryActivityStack, "splitInfo.primaryActivityStack");
            List activities = primaryActivityStack.getActivities();
            k.d(activities, "primaryActivityStack.activities");
            ActivityStack activityStack = new ActivityStack(activities, primaryActivityStack.isEmpty());
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            k.d(secondaryActivityStack, "splitInfo.secondaryActivityStack");
            List activities2 = secondaryActivityStack.getActivities();
            k.d(activities2, "secondaryActivityStack.activities");
            ActivityStack activityStack2 = new ActivityStack(activities2, secondaryActivityStack.isEmpty());
            EmbeddingAdapter embeddingAdapter = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
            k.d(splitAttributes, "splitInfo.splitAttributes");
            return new SplitInfo(activityStack, activityStack2, embeddingAdapter.e(splitAttributes), EmbeddingAdapter.f6999d.a());
        }
    }

    public EmbeddingAdapter(PredicateAdapter predicateAdapter) {
        k.e(predicateAdapter, "predicateAdapter");
        this.f7002a = predicateAdapter;
        this.f7003b = new VendorApiLevel1Impl(this, predicateAdapter);
        this.f7004c = new VendorApiLevel2Impl();
    }

    private final int b() {
        return WindowSdkExtensions.f6851b.a().b();
    }

    private final SplitInfo c(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        int b3 = b();
        if (b3 == 1) {
            return this.f7003b.b(splitInfo);
        }
        if (b3 == 2) {
            return this.f7004c.a(splitInfo);
        }
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        k.d(primaryActivityStack, "splitInfo.primaryActivityStack");
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        k.d(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        List activities = primaryActivityStack.getActivities();
        k.d(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, primaryActivityStack.isEmpty());
        List activities2 = secondaryActivityStack.getActivities();
        k.d(activities2, "secondaryActivityStack.activities");
        ActivityStack activityStack2 = new ActivityStack(activities2, secondaryActivityStack.isEmpty());
        androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
        k.d(splitAttributes, "splitInfo.splitAttributes");
        SplitAttributes e3 = e(splitAttributes);
        IBinder token = splitInfo.getToken();
        k.d(token, "splitInfo.token");
        return new SplitInfo(activityStack, activityStack2, e3, token);
    }

    public final List d(List list) {
        k.e(list, "splitInfoList");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC0544n.q(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(c((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        return arrayList;
    }

    public final SplitAttributes e(androidx.window.extensions.embedding.SplitAttributes splitAttributes) {
        SplitAttributes.SplitType b3;
        SplitAttributes.LayoutDirection layoutDirection;
        k.e(splitAttributes, "splitAttributes");
        SplitAttributes.Builder builder = new SplitAttributes.Builder();
        SplitAttributes.SplitType.RatioSplitType splitType = splitAttributes.getSplitType();
        k.d(splitType, "splitAttributes.splitType");
        if (splitType instanceof SplitAttributes.SplitType.HingeSplitType) {
            b3 = SplitAttributes.SplitType.f7082f;
        } else if (splitType instanceof SplitAttributes.SplitType.ExpandContainersSplitType) {
            b3 = SplitAttributes.SplitType.f7080d;
        } else {
            if (!(splitType instanceof SplitAttributes.SplitType.RatioSplitType)) {
                throw new IllegalArgumentException("Unknown split type: " + splitType);
            }
            b3 = SplitAttributes.SplitType.f7079c.b(splitType.getRatio());
        }
        SplitAttributes.Builder c3 = builder.c(b3);
        int layoutDirection2 = splitAttributes.getLayoutDirection();
        if (layoutDirection2 == 0) {
            layoutDirection = SplitAttributes.LayoutDirection.f7073e;
        } else if (layoutDirection2 == 1) {
            layoutDirection = SplitAttributes.LayoutDirection.f7074f;
        } else if (layoutDirection2 == 3) {
            layoutDirection = SplitAttributes.LayoutDirection.f7072d;
        } else if (layoutDirection2 == 4) {
            layoutDirection = SplitAttributes.LayoutDirection.f7075g;
        } else {
            if (layoutDirection2 != 5) {
                throw new IllegalArgumentException("Unknown layout direction: " + layoutDirection2);
            }
            layoutDirection = SplitAttributes.LayoutDirection.f7076h;
        }
        return c3.b(layoutDirection).a();
    }
}
