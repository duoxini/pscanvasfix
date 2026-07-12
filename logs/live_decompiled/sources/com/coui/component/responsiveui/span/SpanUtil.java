package com.coui.component.responsiveui.span;

import D2.g;
import D2.k;
import H2.d;
import com.coui.component.responsiveui.unit.Dp;

/* loaded from: classes.dex */
public final class SpanUtil {
    public static final int DEFAULT_COLUMNS_PER_SPAN = 4;
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static final Dp f9351a = new Dp(360);

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ float calculateGapBetweenSpans$default(Companion companion, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 16) != 0) {
                i7 = 1;
            }
            return companion.calculateGapBetweenSpans(i3, i4, i5, i6, i7);
        }

        public static /* synthetic */ int calculateSpanCount$default(Companion companion, Dp dp, int i3, Dp dp2, int i4, int i5, Object obj) {
            if ((i5 & 8) != 0) {
                i4 = i3;
            }
            return companion.calculateSpanCount(dp, i3, dp2, i4);
        }

        public final float calculateGapBetweenSpans(int i3, int i4, int i5, int i6, int i7) {
            if (i4 <= 1) {
                throw new IllegalArgumentException("spanCounts must be greater than 1");
            }
            if (i7 >= 0) {
                return d.a(((i3 - (i6 * 2)) - (i5 * i4)) / (i4 - 1.0f), i7);
            }
            throw new IllegalArgumentException("minGap must be equal or greater than 0");
        }

        public final int calculateSpanCount(int i3, int i4) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("totalColumns must be positive");
            }
            if (i4 <= 0) {
                throw new IllegalArgumentException("columnsPerSpan must be positive");
            }
            if (i4 <= i3) {
                return i3 / i4;
            }
            throw new IllegalArgumentException("totalColumns must be equal or greater than columnsPerSpan");
        }

        public final Dp getDEFAULT_BASE_WIDTH() {
            return SpanUtil.f9351a;
        }

        private Companion() {
        }

        public final int calculateSpanCount(Dp dp, int i3, Dp dp2, int i4) {
            k.e(dp, "baseWidth");
            k.e(dp2, "layoutGridWindowWidth");
            if (i3 >= 1) {
                return d.b((int) (dp2.div(dp).getValue() * i3), i4);
            }
            throw new IllegalArgumentException("spanCountPerBaseWidth must be equal or greater than 1");
        }
    }
}
