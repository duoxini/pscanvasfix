package com.customer.feedback.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.customer.feedback.sdk.R;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.util.LogUtil;
import com.customer.feedback.sdk.widget.ContainerView;
import m2.AbstractC0468c;

/* loaded from: classes.dex */
public class ContainerView extends RelativeLayout {
    public RelativeLayout feedbacka;
    public RelativeLayout feedbackb;
    public TextView feedbackc;
    public TextView feedbackd;
    public ProgressBar feedbacke;
    public TextView feedbackf;
    public int feedbackg;
    public WebView feedbackh;
    public ImageView feedbacki;
    public View feedbackj;
    public TextView feedbackk;
    public ImageView feedbackl;
    public View.OnClickListener feedbackm;
    public final int feedbackn;
    public final int feedbacko;
    public boolean feedbackp;
    public boolean feedbackq;
    public View feedbackr;

    public ContainerView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ boolean feedbacka(View view, MotionEvent motionEvent) {
        return true;
    }

    private void setContainerBackground(boolean z3) {
        int i3 = this.feedbackg;
        if (i3 == 0) {
            if (z3) {
                setBackgroundColor(this.feedbackn);
                return;
            } else {
                setBackgroundColor(this.feedbacko);
                return;
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                LogUtil.d("ContainerView", "set by page self");
                return;
            } else if (z3) {
                setBackgroundColor(-16777216);
                return;
            } else {
                setBackgroundColor(-1);
                return;
            }
        }
        WebView webView = this.feedbackh;
        if (webView == null) {
            return;
        }
        if (z3) {
            webView.setBackgroundColor(this.feedbackn);
        } else {
            webView.setBackgroundColor(this.feedbacko);
        }
    }

    public final void feedbackb(boolean z3) {
        if (!z3) {
            this.feedbackj.setVisibility(8);
            setPadding(getPaddingStart(), AbstractC0468c.l(getContext()), getPaddingEnd(), getPaddingBottom());
        } else {
            this.feedbackj.setVisibility(0);
            setPadding(getPaddingStart(), 0, getPaddingEnd(), getPaddingBottom());
            this.feedbackj.setPadding(0, AbstractC0468c.l(getContext()), 0, 0);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void feedbackc(boolean z3) {
        if (z3) {
            Drawable drawable = getContext().getDrawable(R.drawable.fb_anim_dark);
            Rect bounds = this.feedbacke.getIndeterminateDrawable().getBounds();
            this.feedbacke.setIndeterminateDrawable(drawable);
            this.feedbacke.getIndeterminateDrawable().setBounds(bounds);
            this.feedbackf.setTextColor(getResources().getColor(R.color.feedback_text_secondary_color_dark));
            this.feedbacka.setBackgroundColor(this.feedbackn);
            Drawable drawable2 = getContext().getDrawable(R.drawable.fb_no_network_night);
            LogUtil.d("ContainerView", "noNetworkAnim()");
            ImageView imageView = this.feedbacki;
            if (imageView != null) {
                if (drawable2 == null) {
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.fb_no_network_light));
                } else {
                    imageView.setImageDrawable(drawable2);
                    Object drawable3 = this.feedbacki.getDrawable();
                    if (drawable3 instanceof Animatable) {
                        ((Animatable) drawable3).start();
                    }
                }
            }
            this.feedbackb.setBackgroundColor(-16777216);
            this.feedbackc.setTextColor(getResources().getColor(R.color.feedback_text_primary_color_dark));
            this.feedbackd.setTextColor(getResources().getColor(R.color.feedback_text_secondary_color_dark));
            this.feedbackl.setImageResource(R.drawable.fb_night_ic_back);
            this.feedbackj.setBackgroundColor(-16777216);
            this.feedbackk.setTextColor(getResources().getColor(R.color.feedback_text_primary_color_dark));
        } else {
            Drawable drawable4 = getContext().getDrawable(R.drawable.fb_anim);
            Rect bounds2 = this.feedbacke.getIndeterminateDrawable().getBounds();
            this.feedbacke.setIndeterminateDrawable(drawable4);
            this.feedbacke.getIndeterminateDrawable().setBounds(bounds2);
            this.feedbackf.setTextColor(getResources().getColor(R.color.feedback_text_secondary_color_light));
            this.feedbacka.setBackgroundColor(this.feedbacko);
            Drawable drawable5 = getContext().getDrawable(R.drawable.fb_no_network_light);
            LogUtil.d("ContainerView", "noNetworkAnim()");
            ImageView imageView2 = this.feedbacki;
            if (imageView2 != null) {
                if (drawable5 == null) {
                    imageView2.setImageDrawable(getContext().getDrawable(R.drawable.fb_no_network_light));
                } else {
                    imageView2.setImageDrawable(drawable5);
                    Object drawable6 = this.feedbacki.getDrawable();
                    if (drawable6 instanceof Animatable) {
                        ((Animatable) drawable6).start();
                    }
                }
            }
            this.feedbackb.setBackgroundColor(-1);
            this.feedbackc.setTextColor(getResources().getColor(R.color.feedback_text_primary_color_light));
            this.feedbackd.setTextColor(getResources().getColor(R.color.feedback_text_secondary_color_light));
            this.feedbackl.setImageResource(R.drawable.fb_light_ic_back);
            this.feedbackj.setBackgroundColor(-1);
            this.feedbackk.setTextColor(getResources().getColor(R.color.feedback_text_primary_color_light));
        }
        this.feedbackp = z3;
        setContainerBackground(z3);
    }

    @SuppressLint({"ScreencaptureDetector"})
    public WebView getContentView() {
        return this.feedbackh;
    }

    public int getCurrentShowViewType() {
        return this.feedbackg;
    }

    public void setBackClick(View.OnClickListener onClickListener) {
        this.feedbackm = onClickListener;
    }

    public void setNavigationBarBackground(int i3) {
        if (this.feedbackr != null) {
            LogUtil.i("ContainerView", "setNavigationBarBackground = " + i3);
            this.feedbackr.setBackgroundColor(i3);
        }
    }

    public void setNavigationBarViewHeight(int i3) {
        if (this.feedbackr != null) {
            LogUtil.i("ContainerView", "setNavigationBarViewHeight = " + i3);
            ViewGroup.LayoutParams layoutParams = this.feedbackr.getLayoutParams();
            layoutParams.height = i3;
            this.feedbackr.setLayoutParams(layoutParams);
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.feedbackb.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.feedbackk.setText(str);
    }

    public ContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void feedbacka() {
        Context context = getContext();
        Context context2 = feedbacka.feedbacks;
        if (context2 != null) {
            this.feedbackh = new WebView(context2);
        } else {
            this.feedbackh = new WebView(context);
        }
        setBackgroundColor(0);
        this.feedbackh.setBackgroundColor(0);
        feedbacka(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams.addRule(12);
        View view = new View(context);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        view.setLayoutParams(layoutParams);
        this.feedbackr = view;
        addView(view);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, R.id.feedback_main_title);
        layoutParams2.addRule(2, this.feedbackr.getId());
        addView(this.feedbackh, 0, layoutParams2);
        addView(View.inflate(context, R.layout.feedback_error_view, null), 0, layoutParams2);
        View inflate = View.inflate(context, R.layout.feedback_loading_view, null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(2, this.feedbackr.getId());
        addView(inflate, 0, layoutParams3);
        this.feedbackb = (RelativeLayout) findViewById(R.id.error_rl);
        this.feedbackc = (TextView) findViewById(R.id.tv_hint);
        this.feedbackd = (TextView) findViewById(R.id.tv_hint1);
        this.feedbacka = (RelativeLayout) findViewById(R.id.rl_loading);
        this.feedbacke = (ProgressBar) findViewById(R.id.pb_loading);
        this.feedbackf = (TextView) findViewById(R.id.tv_loading);
        this.feedbacki = (ImageView) findViewById(R.id.iv_no_network);
    }

    public ContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.feedbackg = 0;
        this.feedbackn = feedbacka.feedbackb();
        this.feedbacko = getContext().getResources().getColor(R.color.feedback_background_color);
        this.feedbackp = false;
        this.feedbackq = true;
        feedbacka();
    }

    public final void feedbacka(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.feedback_main_title, (ViewGroup) this, false);
        this.feedbackj = inflate;
        inflate.findViewById(R.id.iv_main_back_container).setOnClickListener(new View.OnClickListener() { // from class: E0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContainerView.this.feedbacka(view);
            }
        });
        this.feedbackl = (ImageView) this.feedbackj.findViewById(R.id.iv_main_back);
        this.feedbackk = (TextView) this.feedbackj.findViewById(R.id.tv_main_title);
        feedbackb(false);
        this.feedbackj.setOnTouchListener(new View.OnTouchListener() { // from class: E0.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ContainerView.feedbacka(view, motionEvent);
            }
        });
        addView(this.feedbackj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void feedbacka(View view) {
        View.OnClickListener onClickListener = this.feedbackm;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void feedbacka(boolean z3) {
        if (z3) {
            this.feedbacka.setVisibility(0);
            setPadding(getPaddingStart(), 0, getPaddingEnd(), getPaddingBottom());
            this.feedbacka.setPadding(0, AbstractC0468c.l(getContext()), 0, AbstractC0468c.j(getContext()));
        } else {
            this.feedbacka.setVisibility(8);
            setPadding(getPaddingStart(), AbstractC0468c.l(getContext()), getPaddingEnd(), getPaddingBottom());
        }
    }

    public final void feedbacka(int i3) {
        LogUtil.d("ContainerView", "switchView:" + i3);
        this.feedbackg = i3;
        setContainerBackground(this.feedbackp);
        if (i3 == 0) {
            feedbackb(false);
            this.feedbackh.setVisibility(8);
            this.feedbackb.setVisibility(8);
            feedbacka(true);
            this.feedbackf.setText(getResources().getString(R.string.fb_start_loading));
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            this.feedbackb.setVisibility(0);
            this.feedbackh.setVisibility(8);
            feedbacka(false);
            feedbackb(true);
            setTitle(getResources().getString(R.string.feedback_app_name));
            this.feedbackc.setText(getResources().getString(R.string.no_network_connect_str));
            this.feedbackd.setText(getResources().getString(R.string.check_network_settings));
            return;
        }
        this.feedbackb.setVisibility(8);
        feedbacka(false);
        if (this.feedbackj.getVisibility() == 0) {
            setPadding(getPaddingStart(), 0, getPaddingEnd(), getPaddingBottom());
            this.feedbackj.setBackground(getBackground());
        } else {
            setPadding(getPaddingStart(), this.feedbackq ? AbstractC0468c.l(getContext()) : 0, getPaddingEnd(), getPaddingBottom());
        }
        if (this.feedbackh.getVisibility() != 0) {
            this.feedbackh.setVisibility(0);
        }
    }
}
