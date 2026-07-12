package D;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f280a;

    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f281a;

        /* renamed from: b, reason: collision with root package name */
        private final d f282b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f283c = true;

        a(TextView textView) {
            this.f281a = textView;
            this.f282b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f282b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f282b;
            return inputFilterArr2;
        }

        private SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i3 = 0; i3 < inputFilterArr.length; i3++) {
                InputFilter inputFilter = inputFilterArr[i3];
                if (inputFilter instanceof d) {
                    sparseArray.put(i3, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray g3 = g(inputFilterArr);
            if (g3.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g3.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (g3.indexOfKey(i4) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i4];
                    i3++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f281a.setFilters(a(this.f281a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // D.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f283c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // D.f.b
        public boolean b() {
            return this.f283c;
        }

        @Override // D.f.b
        void c(boolean z3) {
            if (z3) {
                l();
            }
        }

        @Override // D.f.b
        void d(boolean z3) {
            this.f283c = z3;
            l();
            k();
        }

        @Override // D.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f283c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z3) {
            this.f283c = z3;
        }

        void l() {
            this.f281a.setTransformationMethod(e(this.f281a.getTransformationMethod()));
        }
    }

    static class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        abstract void c(boolean z3);

        abstract void d(boolean z3);

        abstract TransformationMethod e(TransformationMethod transformationMethod);
    }

    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f284a;

        c(TextView textView) {
            this.f284a = new a(textView);
        }

        private boolean f() {
            return !androidx.emoji2.text.e.h();
        }

        @Override // D.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f284a.a(inputFilterArr);
        }

        @Override // D.f.b
        public boolean b() {
            return this.f284a.b();
        }

        @Override // D.f.b
        void c(boolean z3) {
            if (f()) {
                return;
            }
            this.f284a.c(z3);
        }

        @Override // D.f.b
        void d(boolean z3) {
            if (f()) {
                this.f284a.i(z3);
            } else {
                this.f284a.d(z3);
            }
        }

        @Override // D.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f284a.e(transformationMethod);
        }
    }

    public f(TextView textView, boolean z3) {
        androidx.core.util.h.e(textView, "textView cannot be null");
        if (z3) {
            this.f280a = new a(textView);
        } else {
            this.f280a = new c(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f280a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f280a.b();
    }

    public void c(boolean z3) {
        this.f280a.c(z3);
    }

    public void d(boolean z3) {
        this.f280a.d(z3);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f280a.e(transformationMethod);
    }
}
