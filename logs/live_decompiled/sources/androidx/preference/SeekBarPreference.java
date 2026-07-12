package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: e, reason: collision with root package name */
    int f5926e;

    /* renamed from: f, reason: collision with root package name */
    int f5927f;

    /* renamed from: g, reason: collision with root package name */
    private int f5928g;

    /* renamed from: h, reason: collision with root package name */
    private int f5929h;

    /* renamed from: i, reason: collision with root package name */
    boolean f5930i;

    /* renamed from: j, reason: collision with root package name */
    SeekBar f5931j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f5932k;

    /* renamed from: l, reason: collision with root package name */
    boolean f5933l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5934m;

    /* renamed from: n, reason: collision with root package name */
    boolean f5935n;

    /* renamed from: o, reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f5936o;

    /* renamed from: p, reason: collision with root package name */
    private View.OnKeyListener f5937p;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
            if (z3) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f5935n || !seekBarPreference.f5930i) {
                    seekBarPreference.m(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.n(i3 + seekBarPreference2.f5927f);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f5930i = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f5930i = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f5927f != seekBarPreference.f5926e) {
                seekBarPreference.m(seekBar);
            }
        }
    }

    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f5933l && (i3 == 21 || i3 == 22)) || i3 == 23 || i3 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f5931j;
            if (seekBar != null) {
                return seekBar.onKeyDown(i3, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5936o = new a();
        this.f5937p = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6217x1, i3, i4);
        this.f5927f = obtainStyledAttributes.getInt(s.f6061A1, 0);
        i(obtainStyledAttributes.getInt(s.f6220y1, 100));
        j(obtainStyledAttributes.getInt(s.f6064B1, 0));
        this.f5933l = obtainStyledAttributes.getBoolean(s.f6223z1, true);
        this.f5934m = obtainStyledAttributes.getBoolean(s.f6067C1, false);
        this.f5935n = obtainStyledAttributes.getBoolean(s.f6070D1, false);
        obtainStyledAttributes.recycle();
    }

    private void l(int i3, boolean z3) {
        int i4 = this.f5927f;
        if (i3 < i4) {
            i3 = i4;
        }
        int i5 = this.f5928g;
        if (i3 > i5) {
            i3 = i5;
        }
        if (i3 != this.f5926e) {
            this.f5926e = i3;
            n(i3);
            persistInt(i3);
            if (z3) {
                notifyChanged();
            }
        }
    }

    public final void i(int i3) {
        int i4 = this.f5927f;
        if (i3 < i4) {
            i3 = i4;
        }
        if (i3 != this.f5928g) {
            this.f5928g = i3;
            notifyChanged();
        }
    }

    public final void j(int i3) {
        if (i3 != this.f5929h) {
            this.f5929h = Math.min(this.f5928g - this.f5927f, Math.abs(i3));
            notifyChanged();
        }
    }

    public void k(int i3) {
        l(i3, true);
    }

    void m(SeekBar seekBar) {
        int progress = this.f5927f + seekBar.getProgress();
        if (progress != this.f5926e) {
            if (callChangeListener(Integer.valueOf(progress))) {
                l(progress, false);
            } else {
                seekBar.setProgress(this.f5926e - this.f5927f);
                n(this.f5926e);
            }
        }
    }

    void n(int i3) {
        TextView textView = this.f5932k;
        if (textView != null) {
            textView.setText(String.valueOf(i3));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        lVar.itemView.setOnKeyListener(this.f5937p);
        this.f5931j = (SeekBar) lVar.b(o.f6045c);
        TextView textView = (TextView) lVar.b(o.f6046d);
        this.f5932k = textView;
        if (this.f5934m) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f5932k = null;
        }
        SeekBar seekBar = this.f5931j;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f5936o);
        this.f5931j.setMax(this.f5928g - this.f5927f);
        int i3 = this.f5929h;
        if (i3 != 0) {
            this.f5931j.setKeyProgressIncrement(i3);
        } else {
            this.f5929h = this.f5931j.getKeyProgressIncrement();
        }
        this.f5931j.setProgress(this.f5926e - this.f5927f);
        n(this.f5926e);
        this.f5931j.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return Integer.valueOf(typedArray.getInt(i3, 0));
    }

    @Override // androidx.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f5926e = cVar.f5940e;
        this.f5927f = cVar.f5941f;
        this.f5928g = cVar.f5942g;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        c cVar = new c(onSaveInstanceState);
        cVar.f5940e = this.f5926e;
        cVar.f5941f = this.f5927f;
        cVar.f5942g = this.f5928g;
        return cVar;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        k(getPersistedInt(((Integer) obj).intValue()));
    }

    private static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        int f5940e;

        /* renamed from: f, reason: collision with root package name */
        int f5941f;

        /* renamed from: g, reason: collision with root package name */
        int f5942g;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f5940e = parcel.readInt();
            this.f5941f = parcel.readInt();
            this.f5942g = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f5940e);
            parcel.writeInt(this.f5941f);
            parcel.writeInt(this.f5942g);
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f6039k);
    }
}
