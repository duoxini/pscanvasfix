package com.coui.appcompat.panel;

import U1.i;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowInsets;
import com.coui.appcompat.grid.COUIPercentWidthFrameLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.oplus.graphics.OplusOutline;
import com.oplus.graphics.OplusOutlineAdapter;
import d0.AbstractC0335a;
import h0.AbstractC0371a;
import n0.AbstractC0481a;
import y0.j;

/* loaded from: classes.dex */
public class COUIPanelPercentFrameLayout extends COUIPercentWidthFrameLayout {
    public static final float MEDIUM_AND_LARGE_SCREEN = 2.0f;
    public static final float SMALL_SCREEN = 1.0f;
    private static final String TAG = "COUIPanelPercentFrameLayout";
    private static final int UNSET_WIDTH = -1;
    private Bitmap mBitmap;
    private int mBottomDiff;
    private final Paint mClipPaint;
    private boolean mHasAnchor;
    private boolean mIsHandlePanel;
    private boolean mIsSupportSmoothRoundCorner;
    private int mMaxHeight;
    private int mMaxHeightOfAttr;
    private int mMaxWidth;
    private final Rect mMeasureRect;
    private Rect mOplusOutLineRect;
    private OplusOutlineAdapter mOplusOutline;
    private ViewOutlineProvider mOutlineProvider;
    private final Path mPath;
    private int mPreferWidth;
    private float mRadius;
    private float mRatio;
    private final RectF mRectF;
    private float mWeight;

    public COUIPanelPercentFrameLayout(Context context) {
        this(context, null);
    }

    private Bitmap createClipSmoothRoundBitmap() {
        if (this.mRectF.width() <= 0.0f || this.mRectF.height() <= 0.0f) {
            AbstractC0371a.d(TAG, "createClipSmoothRoundBitmap return for width and height must be > 0");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) this.mRectF.width(), (int) this.mRectF.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawPath(this.mPath, paint);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enforceChangeScreenWidth() {
        if (this.mPreferWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = this.mPreferWidth;
            if (i3 == i4) {
                return;
            }
            configuration.screenWidthDp = i4;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : PreferWidth:" + this.mPreferWidth);
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    private void initAttr(AttributeSet attributeSet) {
        boolean z3 = false;
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f2446p);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(i.f2447q, 0);
            obtainStyledAttributes.recycle();
        }
        this.mMaxHeightOfAttr = this.mMaxHeight;
        this.mRatio = COUIPanelMultiWindowUtils.isSmallScreen(getContext(), null) ? 1.0f : 2.0f;
        if (AbstractC0481a.c() && AbstractC0481a.d()) {
            z3 = true;
        }
        this.mIsSupportSmoothRoundCorner = z3;
        if (!z3) {
            this.mRadius = AbstractC0335a.c(getContext(), M1.c.f1346D);
            this.mWeight = 0.0f;
        } else if (AbstractC0481a.a() == 0) {
            this.mRadius = AbstractC0335a.c(getContext(), M1.c.f1347E);
            this.mWeight = AbstractC0335a.e(getContext(), M1.c.f1348F);
        } else if (AbstractC0481a.a() == 1) {
            this.mRadius = AbstractC0335a.c(getContext(), M1.c.f1346D);
            updateClipToOutline(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updateBottomCornerRadius() {
        if (this.mIsHandlePanel) {
            return getContext().getResources().getDimensionPixelOffset(U1.d.f2374b);
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(U1.d.f2373a);
        Activity c3 = j.c(getContext());
        if (c3 != null) {
            int requestedOrientation = c3.getRequestedOrientation();
            if (requestedOrientation == 1 && (c3.getResources().getConfiguration().screenLayout & 48) == 32) {
                return getContext().getResources().getDimensionPixelOffset(U1.d.f2374b);
            }
            if (requestedOrientation == 0) {
                return 0;
            }
        }
        return dimensionPixelOffset;
    }

    private void updateClipToOutline(boolean z3) {
        AbstractC0371a.d(TAG, "updateClipToOutline setOutlineProvider=" + z3);
        if (z3) {
            super.setOutlineProvider(this.mOutlineProvider);
            setClipToOutline(true);
        } else {
            super.setOutlineProvider(null);
            setClipToOutline(false);
        }
    }

    private void updatePath() {
        this.mPath.reset();
        if (updateBottomCornerRadius() == 0) {
            m0.c.c(this.mPath, this.mRectF, this.mRadius, this.mWeight);
        } else {
            m0.c.d(this.mPath, this.mRectF, this.mRadius, this.mWeight, true, true, false, false);
        }
    }

    public void delPreferWidth() {
        this.mPreferWidth = -1;
        Log.d(TAG, "delPreferWidth");
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (getClipToOutline()) {
            super.draw(canvas);
            return;
        }
        if (this.mBitmap != null) {
            int saveLayer = canvas.saveLayer(null, null);
            super.draw(canvas);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mClipPaint);
            canvas.restoreToCount(saveLayer);
            return;
        }
        canvas.save();
        canvas.clipPath(this.mPath);
        super.draw(canvas);
        canvas.restore();
    }

    int getGridNumber() {
        return this.mGridNumber;
    }

    public boolean getHasAnchor() {
        return this.mHasAnchor;
    }

    int getPaddingSize() {
        return this.mPaddingSize;
    }

    int getPaddingType() {
        return this.mPaddingType;
    }

    public float getRatio() {
        if (this.mIsHandlePanel) {
            return 1.0f;
        }
        return this.mRatio;
    }

    public boolean isIsHandlePanel() {
        return this.mIsHandlePanel;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int paddingBottom = getPaddingBottom();
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (paddingBottom != 0 && getPaddingBottom() == 0) {
            setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), paddingBottom);
        }
        return onApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mRatio = COUIPanelMultiWindowUtils.isSmallScreen(getContext(), null) ? 1.0f : 2.0f;
    }

    @Override // com.coui.appcompat.grid.COUIPercentWidthFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        getWindowVisibleDisplayFrame(this.mMeasureRect);
        int height = this.mMeasureRect.height();
        int i5 = this.mMaxHeight;
        if (height > i5 && i5 > 0 && i5 < View.MeasureSpec.getSize(i4)) {
            i4 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, View.MeasureSpec.getMode(i4));
        }
        setPercentIndentEnabled((COUIPanelMultiWindowUtils.isSmallScreen(getContext(), null) || View.MeasureSpec.getSize(i3) >= this.mMeasureRect.width()) && !COUIResponsiveUtils.isSmallScreen(getContext(), this.mMeasureRect.width()) && this.mMaxWidth == 0);
        int i6 = this.mMaxWidth;
        if (i6 != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i6, View.MeasureSpec.getMode(i3));
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        enforceChangeScreenWidth();
        if (getClipToOutline()) {
            return;
        }
        this.mRectF.set(0.0f, 0.0f, i3, i4);
        updatePath();
        if (this.mIsSupportSmoothRoundCorner) {
            if (this.mBitmap != null && i3 == i5 && i4 == i6) {
                return;
            }
            this.mBitmap = createClipSmoothRoundBitmap();
        }
    }

    void prepareForOutlineProvider() {
        super.setOutlineProvider(this.mOutlineProvider);
        setClipToOutline(true);
    }

    void restoreDefaultMaxSize() {
        if (this.mMaxWidth == 0) {
            return;
        }
        this.mMaxWidth = 0;
        this.mMaxHeight = this.mMaxHeightOfAttr;
        requestLayout();
    }

    public void setHasAnchor(boolean z3) {
        if (this.mHasAnchor != z3) {
            this.mHasAnchor = z3;
            updateClipToOutline(z3);
        }
    }

    public void setIsHandlePanel(boolean z3) {
        this.mIsHandlePanel = z3;
    }

    void setMaxHeight(int i3) {
        if (this.mMaxHeight != i3) {
            this.mMaxHeight = i3;
            requestLayout();
        }
    }

    void setMaxSize(int i3, int i4) {
        if (i4 == this.mMaxHeight && i3 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i3;
        this.mMaxHeight = i4;
        requestLayout();
    }

    void setOutlineBottomOffset(int i3) {
        this.mBottomDiff = i3;
    }

    @Override // android.view.View
    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
    }

    public void setPreferWidth(int i3) {
        this.mPreferWidth = i3;
        Log.d(TAG, "setPreferWidth =：" + this.mPreferWidth);
    }

    public void updateLayoutWhileConfigChange(Configuration configuration) {
        this.mRatio = COUIPanelMultiWindowUtils.isSmallScreen(getContext(), configuration) ? 1.0f : 2.0f;
    }

    public COUIPanelPercentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPanelPercentFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPath = new Path();
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.mClipPaint = paint;
        this.mRatio = 1.0f;
        this.mHasAnchor = false;
        this.mPreferWidth = -1;
        this.mIsSupportSmoothRoundCorner = false;
        this.mBitmap = null;
        this.mOplusOutLineRect = new Rect();
        this.mOutlineProvider = new ViewOutlineProvider() { // from class: com.coui.appcompat.panel.COUIPanelPercentFrameLayout.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                COUIPanelPercentFrameLayout.this.enforceChangeScreenWidth();
                int updateBottomCornerRadius = COUIPanelPercentFrameLayout.this.updateBottomCornerRadius();
                int height = view.getHeight() + COUIPanelPercentFrameLayout.this.mBottomDiff;
                if (!COUIPanelPercentFrameLayout.this.mIsSupportSmoothRoundCorner) {
                    outline.setRoundRect(0, 0, view.getWidth(), height + updateBottomCornerRadius, COUIPanelPercentFrameLayout.this.mRadius);
                    return;
                }
                if (AbstractC0481a.a() == 0) {
                    new OplusOutline(outline).setSmoothRoundRect(0, 0, view.getWidth(), height + updateBottomCornerRadius, COUIPanelPercentFrameLayout.this.mRadius, COUIPanelPercentFrameLayout.this.mWeight);
                    return;
                }
                if (AbstractC0481a.a() == 1) {
                    COUIPanelPercentFrameLayout.this.mOplusOutline = new OplusOutlineAdapter(outline, AbstractC0481a.a());
                    COUIPanelPercentFrameLayout.this.mOplusOutLineRect.left = 0;
                    COUIPanelPercentFrameLayout.this.mOplusOutLineRect.top = 0;
                    COUIPanelPercentFrameLayout.this.mOplusOutLineRect.right = view.getWidth();
                    COUIPanelPercentFrameLayout.this.mOplusOutLineRect.bottom = height + updateBottomCornerRadius;
                    COUIPanelPercentFrameLayout.this.mOplusOutline.setSmoothRoundRect(COUIPanelPercentFrameLayout.this.mOplusOutLineRect, COUIPanelPercentFrameLayout.this.mRadius);
                }
            }
        };
        initAttr(attributeSet);
        this.mMeasureRect = new Rect();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
}
