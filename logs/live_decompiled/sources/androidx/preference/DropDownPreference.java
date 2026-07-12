package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: p, reason: collision with root package name */
    private final Context f5859p;

    /* renamed from: q, reason: collision with root package name */
    private final ArrayAdapter f5860q;

    /* renamed from: r, reason: collision with root package name */
    private Spinner f5861r;

    /* renamed from: s, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f5862s;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            if (i3 >= 0) {
                String charSequence = DropDownPreference.this.r()[i3].toString();
                if (charSequence.equals(DropDownPreference.this.s()) || !DropDownPreference.this.callChangeListener(charSequence)) {
                    return;
                }
                DropDownPreference.this.u(charSequence);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f6031c);
    }

    private int w(String str) {
        CharSequence[] r3 = r();
        if (str == null || r3 == null) {
            return -1;
        }
        for (int length = r3.length - 1; length >= 0; length--) {
            if (r3[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private void x() {
        this.f5860q.clear();
        if (p() != null) {
            for (CharSequence charSequence : p()) {
                this.f5860q.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.f5860q;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        Spinner spinner = (Spinner) lVar.itemView.findViewById(o.f6047e);
        this.f5861r = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f5860q);
        this.f5861r.setOnItemSelectedListener(this.f5862s);
        this.f5861r.setSelection(w(s()));
        super.onBindViewHolder(lVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void onClick() {
        this.f5861r.performClick();
    }

    protected ArrayAdapter v() {
        return new ArrayAdapter(this.f5859p, R.layout.simple_spinner_dropdown_item);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5862s = new a();
        this.f5859p = context;
        this.f5860q = v();
        x();
    }
}
