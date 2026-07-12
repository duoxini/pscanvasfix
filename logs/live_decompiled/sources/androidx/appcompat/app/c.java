package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class c extends j implements DialogInterface {

    /* renamed from: e, reason: collision with root package name */
    final AlertController f3528e;

    public static class a {

        /* renamed from: P, reason: collision with root package name */
        private final AlertController.b f3529P;
        private final int mTheme;

        public a(Context context) {
            this(context, c.resolveDialogTheme(context, 0));
        }

        public c create() {
            c cVar = new c(this.f3529P.f3487a, this.mTheme);
            this.f3529P.a(cVar.f3528e);
            cVar.setCancelable(this.f3529P.f3504r);
            if (this.f3529P.f3504r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f3529P.f3505s);
            cVar.setOnDismissListener(this.f3529P.f3506t);
            DialogInterface.OnKeyListener onKeyListener = this.f3529P.f3507u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context getContext() {
            return this.f3529P.f3487a;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3509w = listAdapter;
            bVar.f3510x = onClickListener;
            return this;
        }

        public a setCancelable(boolean z3) {
            this.f3529P.f3504r = z3;
            return this;
        }

        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.b bVar = this.f3529P;
            bVar.f3481K = cursor;
            bVar.f3482L = str;
            bVar.f3510x = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.f3529P.f3493g = view;
            return this;
        }

        public a setIcon(int i3) {
            this.f3529P.f3489c = i3;
            return this;
        }

        public a setIconAttribute(int i3) {
            TypedValue typedValue = new TypedValue();
            this.f3529P.f3487a.getTheme().resolveAttribute(i3, typedValue, true);
            this.f3529P.f3489c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z3) {
            this.f3529P.f3484N = z3;
            return this;
        }

        public a setItems(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3508v = bVar.f3487a.getResources().getTextArray(i3);
            this.f3529P.f3510x = onClickListener;
            return this;
        }

        public a setMessage(int i3) {
            AlertController.b bVar = this.f3529P;
            bVar.f3494h = bVar.f3487a.getText(i3);
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3508v = charSequenceArr;
            bVar.f3480J = onMultiChoiceClickListener;
            bVar.f3476F = zArr;
            bVar.f3477G = true;
            return this;
        }

        public a setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3498l = bVar.f3487a.getText(i3);
            this.f3529P.f3500n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.f3529P.f3499m = drawable;
            return this;
        }

        public a setNeutralButton(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3501o = bVar.f3487a.getText(i3);
            this.f3529P.f3503q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.f3529P.f3502p = drawable;
            return this;
        }

        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f3529P.f3505s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f3529P.f3506t = onDismissListener;
            return this;
        }

        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f3529P.f3485O = onItemSelectedListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f3529P.f3507u = onKeyListener;
            return this;
        }

        public a setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3495i = bVar.f3487a.getText(i3);
            this.f3529P.f3497k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.f3529P.f3496j = drawable;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z3) {
            this.f3529P.f3486P = z3;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i3, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3481K = cursor;
            bVar.f3510x = onClickListener;
            bVar.f3479I = i3;
            bVar.f3482L = str;
            bVar.f3478H = true;
            return this;
        }

        public a setTitle(int i3) {
            AlertController.b bVar = this.f3529P;
            bVar.f3492f = bVar.f3487a.getText(i3);
            return this;
        }

        public a setView(int i3) {
            AlertController.b bVar = this.f3529P;
            bVar.f3512z = null;
            bVar.f3511y = i3;
            bVar.f3475E = false;
            return this;
        }

        public c show() {
            c create = create();
            create.show();
            return create;
        }

        public a(Context context, int i3) {
            this.f3529P = new AlertController.b(new ContextThemeWrapper(context, c.resolveDialogTheme(context, i3)));
            this.mTheme = i3;
        }

        public a setIcon(Drawable drawable) {
            this.f3529P.f3490d = drawable;
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.f3529P.f3494h = charSequence;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.f3529P.f3492f = charSequence;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3508v = charSequenceArr;
            bVar.f3510x = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3498l = charSequence;
            bVar.f3500n = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3501o = charSequence;
            bVar.f3503q = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3495i = charSequence;
            bVar.f3497k = onClickListener;
            return this;
        }

        public a setView(View view) {
            AlertController.b bVar = this.f3529P;
            bVar.f3512z = view;
            bVar.f3511y = 0;
            bVar.f3475E = false;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3481K = cursor;
            bVar.f3480J = onMultiChoiceClickListener;
            bVar.f3483M = str;
            bVar.f3482L = str2;
            bVar.f3477G = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3508v = charSequenceArr;
            bVar.f3510x = onClickListener;
            bVar.f3479I = i3;
            bVar.f3478H = true;
            return this;
        }

        @Deprecated
        public a setView(View view, int i3, int i4, int i5, int i6) {
            AlertController.b bVar = this.f3529P;
            bVar.f3512z = view;
            bVar.f3511y = 0;
            bVar.f3475E = true;
            bVar.f3471A = i3;
            bVar.f3472B = i4;
            bVar.f3473C = i5;
            bVar.f3474D = i6;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f3529P;
            bVar.f3509w = listAdapter;
            bVar.f3510x = onClickListener;
            bVar.f3479I = i3;
            bVar.f3478H = true;
            return this;
        }
    }

    protected c(Context context, int i3) {
        super(context, resolveDialogTheme(context, i3));
        this.f3528e = new AlertController(getContext(), this, getWindow());
    }

    static int resolveDialogTheme(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC0339a.f11097l, typedValue, true);
        return typedValue.resourceId;
    }

    public Button e(int i3) {
        return this.f3528e.c(i3);
    }

    public ListView f() {
        return this.f3528e.e();
    }

    @Override // androidx.appcompat.app.j, androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3528e.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (this.f3528e.g(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (this.f3528e.h(i3, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f3528e.q(charSequence);
    }
}
