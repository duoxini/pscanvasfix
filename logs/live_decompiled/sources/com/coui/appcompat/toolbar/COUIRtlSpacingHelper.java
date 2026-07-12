package com.coui.appcompat.toolbar;

/* loaded from: classes.dex */
public class COUIRtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i3, int i4) {
        this.mIsRelative = false;
        if (i3 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i3;
            this.mLeft = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.mExplicitRight = i4;
            this.mRight = i4;
        }
    }

    public void setDirection(boolean z3) {
        if (z3 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z3;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
            return;
        }
        if (z3) {
            int i3 = this.mEnd;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.mExplicitLeft;
            }
            this.mLeft = i3;
            int i4 = this.mStart;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.mExplicitRight;
            }
            this.mRight = i4;
            return;
        }
        int i5 = this.mStart;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.mExplicitLeft;
        }
        this.mLeft = i5;
        int i6 = this.mEnd;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.mExplicitRight;
        }
        this.mRight = i6;
    }

    public void setRelative(int i3, int i4) {
        this.mStart = i3;
        this.mEnd = i4;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i4 != Integer.MIN_VALUE) {
                this.mLeft = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.mRight = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.mLeft = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.mRight = i4;
        }
    }
}
