package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.B;
import androidx.appcompat.widget.C0230d;
import androidx.appcompat.widget.C0232f;
import androidx.appcompat.widget.C0236j;
import androidx.appcompat.widget.C0240n;
import androidx.appcompat.widget.C0242p;
import androidx.appcompat.widget.C0244s;
import androidx.appcompat.widget.C0246u;
import androidx.appcompat.widget.C0248w;
import androidx.appcompat.widget.C0251z;
import androidx.appcompat.widget.S;
import androidx.core.view.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class l {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {R.attr.onClick};
    private static final int[] sAccessibilityHeading = {R.attr.accessibilityHeading};
    private static final int[] sAccessibilityPaneTitle = {R.attr.accessibilityPaneTitle};
    private static final int[] sScreenReaderFocusable = {R.attr.screenReaderFocusable};
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final m.g sConstructorMap = new m.g();

    private static class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        private final View f3643e;

        /* renamed from: f, reason: collision with root package name */
        private final String f3644f;

        /* renamed from: g, reason: collision with root package name */
        private Method f3645g;

        /* renamed from: h, reason: collision with root package name */
        private Context f3646h;

        public a(View view, String str) {
            this.f3643e = view;
            this.f3644f = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f3644f, View.class)) != null) {
                        this.f3645g = method;
                        this.f3646h = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f3643e.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f3643e.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f3644f + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f3643e.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f3645g == null) {
                a(this.f3643e.getContext());
            }
            try {
                this.f3645g.invoke(this.f3646h, view);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("Could not execute method for android:onClick", e4);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && y.J(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View c(Context context, String str, String str2) {
        String str3;
        m.g gVar = sConstructorMap;
        Constructor constructor = (Constructor) gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    private View d(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return c(context, str, null);
            }
            int i3 = 0;
            while (true) {
                String[] strArr = sClassPrefixList;
                if (i3 >= strArr.length) {
                    return null;
                }
                View c3 = c(context, str, strArr[i3]);
                if (c3 != null) {
                    return c3;
                }
                i3++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context e(Context context, AttributeSet attributeSet, boolean z3, boolean z4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.I3, 0, 0);
        int resourceId = z3 ? obtainStyledAttributes.getResourceId(e.j.J3, 0) : 0;
        if (z4 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(e.j.K3, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).getThemeResId() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId) : context;
    }

    private void f(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected C0230d createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0230d(context, attributeSet);
    }

    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected C0232f createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new C0232f(context, attributeSet);
    }

    protected C0236j createEditText(Context context, AttributeSet attributeSet) {
        return new C0236j(context, attributeSet);
    }

    protected C0240n createImageButton(Context context, AttributeSet attributeSet) {
        return new C0240n(context, attributeSet);
    }

    protected AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected C0242p createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0242p(context, attributeSet);
    }

    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected C0244s createRatingBar(Context context, AttributeSet attributeSet) {
        return new C0244s(context, attributeSet);
    }

    protected C0246u createSeekBar(Context context, AttributeSet attributeSet) {
        return new C0246u(context, attributeSet);
    }

    protected C0248w createSpinner(Context context, AttributeSet attributeSet) {
        return new C0248w(context, attributeSet);
    }

    protected C0251z createTextView(Context context, AttributeSet attributeSet) {
        return new C0251z(context, attributeSet);
    }

    protected B createToggleButton(Context context, AttributeSet attributeSet) {
        return new B(context, attributeSet);
    }

    protected View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z3, boolean z4, boolean z5, boolean z6) {
        Context context2;
        View createRatingBar;
        context2 = (!z3 || view == null) ? context : view.getContext();
        if (z4 || z5) {
            context2 = e(context2, attributeSet, z4, z5);
        }
        if (z6) {
            context2 = S.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                createRatingBar = createRatingBar(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "CheckedTextView":
                createRatingBar = createCheckedTextView(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "MultiAutoCompleteTextView":
                createRatingBar = createMultiAutoCompleteTextView(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "TextView":
                createRatingBar = createTextView(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "ImageButton":
                createRatingBar = createImageButton(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "SeekBar":
                createRatingBar = createSeekBar(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "Spinner":
                createRatingBar = createSpinner(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "RadioButton":
                createRatingBar = createRadioButton(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "ToggleButton":
                createRatingBar = createToggleButton(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "ImageView":
                createRatingBar = createImageView(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "AutoCompleteTextView":
                createRatingBar = createAutoCompleteTextView(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "CheckBox":
                createRatingBar = createCheckBox(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "EditText":
                createRatingBar = createEditText(context2, attributeSet);
                f(createRatingBar, str);
                break;
            case "Button":
                createRatingBar = createButton(context2, attributeSet);
                f(createRatingBar, str);
                break;
            default:
                createRatingBar = createView(context2, str, attributeSet);
                break;
        }
        if (createRatingBar == null && context != context2) {
            createRatingBar = d(context2, str, attributeSet);
        }
        if (createRatingBar != null) {
            b(createRatingBar, attributeSet);
            a(context2, createRatingBar, attributeSet);
        }
        return createRatingBar;
    }
}
