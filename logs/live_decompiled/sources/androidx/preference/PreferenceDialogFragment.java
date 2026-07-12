package androidx.preference;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.DialogPreference;

@Deprecated
/* loaded from: classes.dex */
public abstract class PreferenceDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private DialogPreference f5891e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f5892f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f5893g;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f5894h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f5895i;

    /* renamed from: j, reason: collision with root package name */
    private int f5896j;

    /* renamed from: k, reason: collision with root package name */
    private BitmapDrawable f5897k;

    /* renamed from: l, reason: collision with root package name */
    private int f5898l;

    @Deprecated
    public PreferenceDialogFragment() {
    }

    private void g(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public DialogPreference a() {
        if (this.f5891e == null) {
            this.f5891e = (DialogPreference) ((DialogPreference.a) getTargetFragment()).findPreference(getArguments().getString("key"));
        }
        return this.f5891e;
    }

    protected boolean b() {
        return false;
    }

    protected void c(View view) {
        int i3;
        View findViewById = view.findViewById(R.id.message);
        if (findViewById != null) {
            CharSequence charSequence = this.f5895i;
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

    protected View d(Context context) {
        int i3 = this.f5896j;
        if (i3 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
    }

    public abstract void e(boolean z3);

    protected void f(AlertDialog.Builder builder) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f5898l = i3;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentCallbacks2 targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) targetFragment;
        String string = getArguments().getString("key");
        if (bundle != null) {
            this.f5892f = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f5893g = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f5894h = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f5895i = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f5896j = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f5897k = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.findPreference(string);
        this.f5891e = dialogPreference;
        this.f5892f = dialogPreference.l();
        this.f5893g = this.f5891e.n();
        this.f5894h = this.f5891e.m();
        this.f5895i = this.f5891e.k();
        this.f5896j = this.f5891e.j();
        Drawable i3 = this.f5891e.i();
        if (i3 == null || (i3 instanceof BitmapDrawable)) {
            this.f5897k = (BitmapDrawable) i3;
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3.getIntrinsicWidth(), i3.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        i3.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        i3.draw(canvas);
        this.f5897k = new BitmapDrawable(getResources(), createBitmap);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Activity activity = getActivity();
        this.f5898l = -2;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(this.f5892f).setIcon(this.f5897k).setPositiveButton(this.f5893g, this).setNegativeButton(this.f5894h, this);
        View d3 = d(activity);
        if (d3 != null) {
            c(d3);
            negativeButton.setView(d3);
        } else {
            negativeButton.setMessage(this.f5895i);
        }
        f(negativeButton);
        AlertDialog create = negativeButton.create();
        if (b()) {
            g(create);
        }
        return create;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        e(this.f5898l == -1);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f5892f);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f5893g);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f5894h);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f5895i);
        bundle.putInt("PreferenceDialogFragment.layout", this.f5896j);
        BitmapDrawable bitmapDrawable = this.f5897k;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
