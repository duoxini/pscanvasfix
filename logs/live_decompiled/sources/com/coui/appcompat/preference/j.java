package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.l;
import com.coui.appcompat.imageview.COUIRoundImageView;

/* loaded from: classes.dex */
public abstract class j {

    class a implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f8804e;

        a(TextView textView) {
            this.f8804e = textView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            int selectionStart = this.f8804e.getSelectionStart();
            int selectionEnd = this.f8804e.getSelectionEnd();
            int offsetForPosition = this.f8804e.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            boolean z3 = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.f8804e.setPressed(false);
                    this.f8804e.postInvalidateDelayed(70L);
                }
            } else {
                if (z3) {
                    return false;
                }
                this.f8804e.setPressed(true);
                this.f8804e.invalidate();
            }
            return false;
        }
    }

    public static void a(l lVar, CharSequence charSequence, int i3) {
        TextView textView = (TextView) lVar.b(W1.d.f2674b);
        if (textView != null) {
            if (TextUtils.isEmpty(charSequence)) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(charSequence);
            textView.setVisibility(0);
            if (i3 != 0) {
                textView.setTextColor(i3);
            }
        }
    }

    public static void b(l lVar, Drawable drawable, CharSequence charSequence, CharSequence charSequence2) {
        c(lVar, drawable, charSequence, charSequence2, 0);
    }

    public static void c(l lVar, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, int i3) {
        ImageView imageView = (ImageView) lVar.b(W1.d.f2687o);
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View b3 = lVar.b(R.id.icon);
        View b4 = lVar.b(W1.d.f2696x);
        if (b4 != null) {
            if (b3 != null) {
                b4.setVisibility(b3.getVisibility());
            } else {
                b4.setVisibility(8);
            }
        }
        TextView textView = (TextView) lVar.b(W1.d.f2688p);
        if (textView != null) {
            if (TextUtils.isEmpty(charSequence)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence);
                textView.setVisibility(0);
            }
        }
        a(lVar, charSequence2, i3);
    }

    public static void d(l lVar, Context context, int i3, boolean z3, int i4, boolean z4) {
        View b3 = lVar.b(R.id.icon);
        if (b3 == null || !(b3 instanceof COUIRoundImageView)) {
            return;
        }
        if (z4) {
            COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) b3;
            cOUIRoundImageView.setHasBorder(z3);
            cOUIRoundImageView.setBorderRectRadius(0);
            cOUIRoundImageView.setType(i4);
            return;
        }
        COUIRoundImageView cOUIRoundImageView2 = (COUIRoundImageView) b3;
        Drawable drawable = cOUIRoundImageView2.getDrawable();
        if (drawable != null && i3 == 14) {
            i3 = drawable.getIntrinsicHeight() / 6;
            if (i3 < context.getResources().getDimensionPixelOffset(W1.c.f2613D)) {
                i3 = context.getResources().getDimensionPixelOffset(W1.c.f2613D);
            } else if (i3 > context.getResources().getDimensionPixelOffset(W1.c.f2612C)) {
                i3 = context.getResources().getDimensionPixelOffset(W1.c.f2612C);
            }
        }
        cOUIRoundImageView2.setHasBorder(z3);
        cOUIRoundImageView2.setBorderRectRadius(i3);
        cOUIRoundImageView2.setType(i4);
    }

    public static void e(Context context, l lVar) {
        TextView textView = (TextView) lVar.b(R.id.summary);
        if (textView != null) {
            textView.setHighlightColor(context.getResources().getColor(R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new a(textView));
        }
    }

    public static void f(l lVar, ColorStateList colorStateList) {
        TextView textView = (TextView) lVar.b(R.id.summary);
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public static void g(Context context, l lVar, ColorStateList colorStateList) {
        View b3 = lVar.b(R.id.title);
        if (b3 == null || colorStateList == null) {
            return;
        }
        ((TextView) b3).setTextColor(colorStateList);
    }
}
