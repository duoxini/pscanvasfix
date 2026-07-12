package n2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import androidx.window.embedding.ActivityEmbeddingController;
import com.customer.feedback.sdk.R;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.util.LogUtil;
import h2.AbstractC0391b;
import m2.AbstractC0468c;
import m2.p;
import o2.AbstractC0493a;

/* renamed from: n2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogC0489f extends Dialog {

    /* renamed from: e, reason: collision with root package name */
    public Bundle f12596e;

    /* renamed from: f, reason: collision with root package name */
    public c f12597f;

    /* renamed from: g, reason: collision with root package name */
    public b f12598g;

    /* renamed from: h, reason: collision with root package name */
    public a f12599h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f12600i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12601j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f12602k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f12603l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12604m;

    /* renamed from: n, reason: collision with root package name */
    public View f12605n;

    /* renamed from: o, reason: collision with root package name */
    public final Context f12606o;

    /* renamed from: p, reason: collision with root package name */
    public OnBackInvokedCallback f12607p;

    /* renamed from: n2.f$a */
    public interface a {
        void feedbacka();
    }

    /* renamed from: n2.f$b */
    public interface b {
        void feedbacka();
    }

    /* renamed from: n2.f$c */
    public interface c {
        void feedbacka();
    }

    public DialogC0489f(Context context) {
        super(context);
        this.f12606o = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(DialogInterface dialogInterface) {
        this.f12597f = null;
        this.f12599h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        b bVar = this.f12598g;
        if (bVar != null) {
            bVar.feedbacka();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean j(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (i3 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        e();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        c cVar = this.f12597f;
        if (cVar != null) {
            cVar.feedbacka();
        }
        dismiss();
    }

    public final void e() {
        LogUtil.d("FeedbackDialog", "backEvent: listener=" + this.f12599h);
        a aVar = this.f12599h;
        if (aVar != null) {
            aVar.feedbacka();
        }
    }

    public final void f(Activity activity) {
        Window window = getWindow();
        if (activity == null || window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int width = activity.getWindow().getWindowManager().getDefaultDisplay().getWidth();
        if (((int) ((width / getContext().getResources().getDisplayMetrics().density) + 0.5f)) >= 640) {
            Context context = getContext();
            attributes.width = context == null ? 0 : (int) ((context.getResources().getDisplayMetrics().density * 392.0f) + 0.5f);
        } else {
            attributes.width = width;
        }
        attributes.y = (-AbstractC0468c.l(activity)) / 2;
        window.setAttributes(attributes);
        window.setDimAmount(0.2f);
    }

    public final void i(boolean z3) {
        int i3;
        Resources resources;
        Resources resources2 = this.f12606o.getResources();
        int color = resources2.getColor(R.color.feedback_text_primary_color_dark);
        int color2 = getContext().getResources().getColor(R.color.feedback_text_primary_color_light);
        Context context = feedbacka.feedbackf;
        if (!AbstractC0468c.m() || feedbacka.feedbacky == -1) {
            LogUtil.d("FeedbackHelper", "in LightMode, use themeColor: " + feedbacka.feedbackx);
            i3 = feedbacka.feedbackx;
        } else {
            LogUtil.d("FeedbackHelper", "in NightMode, use DarkThemeColor: " + feedbacka.feedbacky);
            i3 = feedbacka.feedbacky;
        }
        if (i3 == -1) {
            resources = this.f12606o.getResources();
            String lowerCase = Build.BRAND.toLowerCase();
            LogUtil.d("FbUtils", "getBrandTextColor band");
            lowerCase.getClass();
            switch (lowerCase) {
                case "oneplus":
                    i3 = resources.getColor(R.color.theme_color_oneplus);
                    break;
                case "realme":
                    i3 = resources.getColor(R.color.theme_color_realme);
                    break;
                case "oppo":
                    i3 = resources.getColor(R.color.theme_color_oppo);
                    break;
                default:
                    i3 = -16777216;
                    break;
            }
        }
        this.f12604m.setTextColor(i3);
        this.f12603l.setTextColor(i3);
        if (z3) {
            LinearLayout linearLayout = this.f12600i;
            Drawable drawable = getContext().getDrawable(R.drawable.fb_dialog_builder_bg_night);
            Drawable background = linearLayout.getBackground();
            if (background != null && drawable != background) {
                try {
                    linearLayout.getBackground().setCallback(null);
                } catch (Exception unused) {
                    LogUtil.e("FbUtils", "FeedbackDialogFragment bg drawable Exception");
                }
            }
            linearLayout.setBackground(drawable);
            this.f12601j.setTextColor(color);
            this.f12602k.setTextColor(color);
            this.f12605n.setBackgroundColor(resources2.getColor(R.color.feedback_dialog_separator_line_night));
            return;
        }
        LinearLayout linearLayout2 = this.f12600i;
        Drawable drawable2 = getContext().getDrawable(R.drawable.fb_dialog_builder_bg_light);
        Drawable background2 = linearLayout2.getBackground();
        if (background2 != null && drawable2 != background2) {
            try {
                linearLayout2.getBackground().setCallback(null);
            } catch (Exception unused2) {
                LogUtil.e("FbUtils", "FeedbackDialogFragment bg drawable Exception");
            }
        }
        linearLayout2.setBackground(drawable2);
        this.f12601j.setTextColor(color2);
        this.f12602k.setTextColor(color2);
        this.f12605n.setBackgroundColor(resources2.getColor(R.color.feedback_dialog_separator_line_light));
    }

    public final void k() {
        if (this.f12603l.getVisibility() == 0 && this.f12598g != null) {
            this.f12603l.setOnClickListener(new View.OnClickListener() { // from class: n2.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogC0489f.this.h(view);
                }
            });
        }
        if (this.f12604m.getVisibility() == 0 && this.f12597f != null) {
            this.f12604m.setOnClickListener(new View.OnClickListener() { // from class: n2.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogC0489f.this.l(view);
                }
            });
        }
        if (this.f12599h != null) {
            if (p.a()) {
                if (this.f12607p == null) {
                    this.f12607p = AbstractC0391b.a(new Runnable() { // from class: n2.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            DialogC0489f.this.e();
                        }
                    });
                }
                AbstractC0391b.c(getOnBackInvokedDispatcher(), 0, this.f12607p);
            } else {
                setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: n2.d
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                        boolean j3;
                        j3 = DialogC0489f.this.j(dialogInterface, i3, keyEvent);
                        return j3;
                    }
                });
            }
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: n2.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogC0489f.this.g(dialogInterface);
            }
        });
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.feedback_alert_dialog);
        this.f12600i = (LinearLayout) findViewById(R.id.rl_bg);
        Window window = getWindow();
        Activity ownerActivity = getOwnerActivity();
        boolean b3 = ownerActivity != null ? ActivityEmbeddingController.a(getContext()).b(ownerActivity) : false;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (AbstractC0493a.c(this.f12606o)) {
                window.setGravity(17);
            } else {
                window.setGravity(80);
                if (b3) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12600i.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.dialog_bottom_space);
                    this.f12600i.setLayoutParams(layoutParams);
                }
            }
            if (b3) {
                window.addFlags(512);
            }
        }
        this.f12601j = (TextView) findViewById(R.id.tv_title);
        this.f12602k = (TextView) findViewById(R.id.tv_content);
        this.f12603l = (TextView) findViewById(R.id.tv_negative);
        this.f12604m = (TextView) findViewById(R.id.tv_positive);
        this.f12605n = findViewById(R.id.dialog_separator);
        Bundle bundle2 = this.f12596e;
        if (bundle2 != null) {
            String string = bundle2.getString("TITLE", "");
            if (TextUtils.isEmpty(string)) {
                this.f12601j.setVisibility(8);
            } else {
                this.f12601j.setVisibility(0);
                this.f12601j.setText(string);
            }
            String string2 = bundle2.getString("MESSAGE", "");
            if (TextUtils.isEmpty(string2)) {
                this.f12602k.setVisibility(8);
            } else {
                this.f12602k.setVisibility(0);
                this.f12602k.setText(string2);
            }
            String string3 = bundle2.getString("POSITIVE", "");
            if (TextUtils.isEmpty(string3)) {
                this.f12604m.setVisibility(8);
            } else {
                this.f12604m.setVisibility(0);
                this.f12604m.setText(string3);
            }
            String string4 = bundle2.getString("NEGATIVE", "");
            if (TextUtils.isEmpty(string4)) {
                this.f12603l.setVisibility(8);
            } else {
                this.f12603l.setVisibility(0);
                this.f12603l.setText(string4);
            }
        }
        k();
    }
}
