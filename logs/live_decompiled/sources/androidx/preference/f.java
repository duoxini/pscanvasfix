package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.InterfaceC0271g;
import androidx.preference.DialogPreference;

/* loaded from: classes.dex */
public abstract class f extends androidx.fragment.app.d implements DialogInterface.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private DialogPreference f5969e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f5970f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f5971g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f5972h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f5973i;

    /* renamed from: j, reason: collision with root package name */
    private int f5974j;

    /* renamed from: k, reason: collision with root package name */
    private BitmapDrawable f5975k;

    /* renamed from: l, reason: collision with root package name */
    private int f5976l;

    private void o(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public DialogPreference i() {
        if (this.f5969e == null) {
            this.f5969e = (DialogPreference) ((DialogPreference.a) getTargetFragment()).findPreference(getArguments().getString("key"));
        }
        return this.f5969e;
    }

    protected boolean j() {
        return false;
    }

    protected void k(View view) {
        int i3;
        View findViewById = view.findViewById(R.id.message);
        if (findViewById != null) {
            CharSequence charSequence = this.f5973i;
            if (TextUtils.isEmpty(charSequence)) {
                i3 = 8;
            } else {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i3 = 0;
            }
            if (findViewById.getVisibility() != i3) {
                findViewById.setVisibility(i3);
            }
        }
    }

    protected View l(Context context) {
        int i3 = this.f5974j;
        if (i3 == 0) {
            return null;
        }
        return getLayoutInflater().inflate(i3, (ViewGroup) null);
    }

    public abstract void m(boolean z3);

    protected void n(c.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f5976l = i3;
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InterfaceC0271g targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) targetFragment;
        String string = getArguments().getString("key");
        if (bundle != null) {
            this.f5970f = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f5971g = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f5972h = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f5973i = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f5974j = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f5975k = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.findPreference(string);
        this.f5969e = dialogPreference;
        this.f5970f = dialogPreference.l();
        this.f5971g = this.f5969e.n();
        this.f5972h = this.f5969e.m();
        this.f5973i = this.f5969e.k();
        this.f5974j = this.f5969e.j();
        Drawable i3 = this.f5969e.i();
        if (i3 == null || (i3 instanceof BitmapDrawable)) {
            this.f5975k = (BitmapDrawable) i3;
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3.getIntrinsicWidth(), i3.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        i3.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        i3.draw(canvas);
        this.f5975k = new BitmapDrawable(getResources(), createBitmap);
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f5976l = -2;
        c.a negativeButton = new c.a(activity).setTitle(this.f5970f).setIcon(this.f5975k).setPositiveButton(this.f5971g, this).setNegativeButton(this.f5972h, this);
        View l3 = l(activity);
        if (l3 != null) {
            k(l3);
            negativeButton.setView(l3);
        } else {
            negativeButton.setMessage(this.f5973i);
        }
        n(negativeButton);
        androidx.appcompat.app.c create = negativeButton.create();
        if (j()) {
            o(create);
        }
        return create;
    }

    @Override // androidx.fragment.app.d, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m(this.f5976l == -1);
    }

    @Override // androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f5970f);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f5971g);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f5972h);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f5973i);
        bundle.putInt("PreferenceDialogFragment.layout", this.f5974j);
        BitmapDrawable bitmapDrawable = this.f5975k;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
