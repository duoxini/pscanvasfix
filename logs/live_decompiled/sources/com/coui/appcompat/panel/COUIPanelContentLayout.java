package com.coui.appcompat.panel;

import U1.f;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.poplist.t;
import f.AbstractC0348a;

/* loaded from: classes.dex */
public class COUIPanelContentLayout extends LinearLayout implements t {
    private static final Rect PANEL_OUTSETS = new Rect();
    private COUIPanelPressHelper mCOUIPanelPressHelper;
    private Rect mDisplayFrame;
    private boolean mIsLayoutAtMaxHeight;
    public boolean mIsTurnOnAnim;
    private int mPaddingBottomTemp;
    private final int mPanelHorizontalPadding;
    private boolean mPopupRuleEnable;

    public COUIPanelContentLayout(Context context) {
        this(context, null);
    }

    private int getNavigationBarHeight(WindowInsets windowInsets, Configuration configuration) {
        if (windowInsets != null) {
            return windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        }
        int identifier = getContext().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return configuration != null ? getContext().createConfigurationContext(configuration).getResources().getDimensionPixelSize(identifier) : getContext().getResources().getDimensionPixelSize(identifier);
    }

    private void initButton(Button button, String str, View.OnClickListener onClickListener) {
        if (button != null) {
            if (TextUtils.isEmpty(str)) {
                button.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            button.setText(str);
            button.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setDragViewPressAnim$0(View view, boolean z3, View view2, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view != null) {
                view.setVisibility(0);
            }
            if (z3) {
                this.mIsTurnOnAnim = true;
                this.mCOUIPanelPressHelper.startAnim(view);
            }
        }
        return true;
    }

    private void setSpecifyViewPaddingButton(boolean z3, int i3) {
        View findViewById = getRootView().findViewById(f.f2407e);
        if (findViewById != null) {
            if (!z3) {
                if (this.mPaddingBottomTemp != -1) {
                    findViewById.setPadding(findViewById.getPaddingStart(), findViewById.getPaddingTop(), findViewById.getPaddingEnd(), this.mPaddingBottomTemp);
                    this.mPaddingBottomTemp = -1;
                    return;
                }
                return;
            }
            if (i3 > 0) {
                if (this.mPaddingBottomTemp == -1) {
                    this.mPaddingBottomTemp = findViewById.getPaddingBottom();
                    findViewById.setPadding(findViewById.getPaddingStart(), findViewById.getPaddingTop(), findViewById.getPaddingEnd(), i3 + this.mPaddingBottomTemp);
                    return;
                }
                return;
            }
            if (this.mPaddingBottomTemp != -1) {
                findViewById.setPadding(findViewById.getPaddingStart(), findViewById.getPaddingTop(), findViewById.getPaddingEnd(), this.mPaddingBottomTemp);
                this.mPaddingBottomTemp = -1;
            }
        }
    }

    public void addContentView(View view) {
        if (view != null) {
            ((LinearLayout) findViewById(f.f2414l)).addView(view, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void dragBgEndAnim() {
        this.mCOUIPanelPressHelper.endAnim(findViewById(f.f2421s));
    }

    @Override // com.coui.appcompat.poplist.t
    public int getBarrierDirection() {
        return 4;
    }

    public COUIButtonBarLayout getBtnBarLayout() {
        return (COUIButtonBarLayout) findViewById(f.f2403a);
    }

    @Override // com.coui.appcompat.poplist.t
    public Rect getDisplayFrame() {
        if (this.mDisplayFrame == null) {
            this.mDisplayFrame = new Rect();
        }
        getGlobalVisibleRect(this.mDisplayFrame);
        Rect rect = this.mDisplayFrame;
        int i3 = rect.left;
        int i4 = this.mPanelHorizontalPadding;
        rect.left = i3 + i4;
        rect.right -= i4;
        return rect;
    }

    public View getDivider() {
        return findViewById(f.f2409g);
    }

    public View getDragBgView() {
        return findViewById(f.f2421s);
    }

    public ImageView getDragView() {
        return (ImageView) findViewById(f.f2410h);
    }

    public FrameLayout getDrawLayout() {
        return (FrameLayout) findViewById(f.f2411i);
    }

    public boolean getLayoutAtMaxHeight() {
        return this.mIsLayoutAtMaxHeight;
    }

    public int getMaxHeight() {
        return COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), null);
    }

    @Override // com.coui.appcompat.poplist.t
    public Rect getOutsets() {
        return PANEL_OUTSETS;
    }

    public COUIPanelBarView getPanelBarView() {
        return (COUIPanelBarView) findViewById(f.f2415m);
    }

    @Override // com.coui.appcompat.poplist.t
    public boolean getPopupMenuRuleEnabled() {
        return this.mPopupRuleEnable;
    }

    @Override // com.coui.appcompat.poplist.t
    public int getType() {
        return 2;
    }

    void refresh() {
        findViewById(f.f2421s).setBackground(AbstractC0348a.b(getContext(), U1.e.f2402d));
    }

    public void removeContentView() {
        ((LinearLayout) findViewById(f.f2414l)).removeAllViews();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void removeDragViewPressAnim() {
        View findViewById = findViewById(f.f2421s);
        if (findViewById != null) {
            findViewById.setOnTouchListener(null);
        }
    }

    public void setCenterButton(String str, View.OnClickListener onClickListener) {
        initButton((Button) findViewById(R.id.button3), str, onClickListener);
    }

    public void setDividerVisibility(boolean z3) {
        View findViewById = findViewById(f.f2409g);
        if (z3) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public void setDragViewDrawable(Drawable drawable) {
        if (drawable != null) {
            ((ImageView) findViewById(f.f2410h)).setImageDrawable(drawable);
        }
    }

    public void setDragViewDrawableTintColor(int i3) {
        ((AppCompatImageView) findViewById(f.f2410h)).getDrawable().setTint(i3);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setDragViewPressAnim(final boolean z3) {
        final View findViewById = findViewById(f.f2421s);
        if (findViewById != null) {
            findViewById.setOnTouchListener(null);
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.panel.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean lambda$setDragViewPressAnim$0;
                    lambda$setDragViewPressAnim$0 = COUIPanelContentLayout.this.lambda$setDragViewPressAnim$0(findViewById, z3, view, motionEvent);
                    return lambda$setDragViewPressAnim$0;
                }
            });
        }
    }

    public void setLayoutAtMaxHeight(boolean z3) {
        this.mIsLayoutAtMaxHeight = z3;
        if (z3) {
            getLayoutParams().height = -1;
        } else {
            getLayoutParams().height = -2;
        }
        requestLayout();
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        initButton((Button) findViewById(R.id.button2), str, onClickListener);
    }

    @Deprecated
    public void setNavigationMargin(Configuration configuration, int i3, WindowInsets windowInsets) {
        setNavigationMargin(configuration, windowInsets, true, false);
    }

    public void setPopupMenuRuleEnabled(boolean z3) {
        this.mPopupRuleEnable = z3;
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        initButton((Button) findViewById(R.id.button1), str, onClickListener);
    }

    public void setUpBottomBar(boolean z3, String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        setDividerVisibility(z3);
        COUIButtonBarLayout cOUIButtonBarLayout = (COUIButtonBarLayout) findViewById(f.f2403a);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            cOUIButtonBarLayout.setVisibility(8);
            return;
        }
        cOUIButtonBarLayout.setVisibility(0);
        cOUIButtonBarLayout.setVerButDividerVerMargin(getContext().getResources().getDimensionPixelOffset(U1.d.f2385m));
        cOUIButtonBarLayout.setVerButVerPadding(getContext().getResources().getDimensionPixelOffset(U1.d.f2386n));
        cOUIButtonBarLayout.setVerPaddingBottom(getContext().getResources().getDimensionPixelOffset(U1.d.f2384l));
        cOUIButtonBarLayout.setVerButPaddingOffset(0);
        Button button = (Button) findViewById(R.id.button2);
        Button button2 = (Button) findViewById(R.id.button3);
        Button button3 = (Button) findViewById(R.id.button1);
        initButton(button, str, onClickListener);
        initButton(button2, str2, onClickListener2);
        initButton(button3, str3, onClickListener3);
    }

    public COUIPanelContentLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setNavigationMargin(android.content.res.Configuration r8, android.view.WindowInsets r9, boolean r10, boolean r11) {
        /*
            r7 = this;
            android.content.Context r0 = r7.getContext()
            android.app.Activity r0 = com.coui.appcompat.panel.COUIPanelMultiWindowUtils.contextToActivity(r0)
            boolean r0 = com.coui.appcompat.panel.COUIPanelMultiWindowUtils.isDisplayInUpperWindow(r0)
            android.content.Context r1 = r7.getContext()
            android.app.Activity r1 = com.coui.appcompat.panel.COUIPanelMultiWindowUtils.contextToActivity(r1)
            boolean r1 = com.coui.appcompat.panel.COUIPanelMultiWindowUtils.isInMultiWindowMode(r1)
            android.content.Context r2 = r7.getContext()
            r3 = 0
            boolean r2 = com.coui.appcompat.panel.COUIPanelMultiWindowUtils.isSmallScreen(r2, r3)
            int r8 = r7.getNavigationBarHeight(r9, r8)
            android.view.View r9 = r7.getRootView()
            int r3 = U1.f.f2406d
            android.view.View r9 = r9.findViewById(r3)
            r3 = 0
            if (r9 == 0) goto L43
            int r4 = M1.h.f1483b
            android.view.View r4 = r9.findViewById(r4)
            boolean r5 = r4 instanceof com.coui.appcompat.panel.COUIPanelPercentFrameLayout
            if (r5 == 0) goto L43
            com.coui.appcompat.panel.COUIPanelPercentFrameLayout r4 = (com.coui.appcompat.panel.COUIPanelPercentFrameLayout) r4
            boolean r4 = r4.isIsHandlePanel()
            goto L44
        L43:
            r4 = r3
        L44:
            if (r0 == 0) goto L4c
            if (r1 == 0) goto L4c
        L48:
            r6 = r3
            r3 = r8
            r8 = r6
            goto L51
        L4c:
            if (r2 != 0) goto L48
            if (r4 == 0) goto L51
            goto L48
        L51:
            android.content.Context r0 = r7.getContext()
            boolean r0 = com.coui.appcompat.panel.COUINavigationBarUtil.isGestureNavigation(r0)
            if (r0 == 0) goto L63
            r11 = 3
            com.coui.appcompat.panel.COUIViewMarginUtil.setMargin(r9, r11, r8)
            r7.setSpecifyViewPaddingButton(r10, r3)
            goto L68
        L63:
            if (r11 == 0) goto L68
            r7.setSpecifyViewPaddingButton(r10, r3)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIPanelContentLayout.setNavigationMargin(android.content.res.Configuration, android.view.WindowInsets, boolean, boolean):void");
    }

    public COUIPanelContentLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPopupRuleEnable = true;
        this.mCOUIPanelPressHelper = new COUIPanelPressHelper();
        this.mPanelHorizontalPadding = context.getResources().getDimensionPixelOffset(U1.d.f2375c);
        this.mPaddingBottomTemp = -1;
    }
}
