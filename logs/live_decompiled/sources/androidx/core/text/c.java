package androidx.core.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class c implements Spannable {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f4994a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f4995b;

        /* renamed from: c, reason: collision with root package name */
        private final int f4996c;

        /* renamed from: d, reason: collision with root package name */
        private final int f4997d;

        /* renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f4998e;

        public a(PrecomputedText.Params params) {
            this.f4994a = params.getTextPaint();
            this.f4995b = params.getTextDirection();
            this.f4996c = params.getBreakStrategy();
            this.f4997d = params.getHyphenationFrequency();
            this.f4998e = params;
        }

        public boolean a(a aVar) {
            if (this.f4996c == aVar.b() && this.f4997d == aVar.c() && this.f4994a.getTextSize() == aVar.e().getTextSize() && this.f4994a.getTextScaleX() == aVar.e().getTextScaleX() && this.f4994a.getTextSkewX() == aVar.e().getTextSkewX() && this.f4994a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f4994a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f4994a.getFlags() == aVar.e().getFlags() && this.f4994a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f4994a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f4994a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f4996c;
        }

        public int c() {
            return this.f4997d;
        }

        public TextDirectionHeuristic d() {
            return this.f4995b;
        }

        public TextPaint e() {
            return this.f4994a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f4995b == aVar.d();
        }

        public int hashCode() {
            return androidx.core.util.c.b(Float.valueOf(this.f4994a.getTextSize()), Float.valueOf(this.f4994a.getTextScaleX()), Float.valueOf(this.f4994a.getTextSkewX()), Float.valueOf(this.f4994a.getLetterSpacing()), Integer.valueOf(this.f4994a.getFlags()), this.f4994a.getTextLocales(), this.f4994a.getTypeface(), Boolean.valueOf(this.f4994a.isElegantTextHeight()), this.f4995b, Integer.valueOf(this.f4996c), Integer.valueOf(this.f4997d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f4994a.getTextSize());
            sb.append(", textScaleX=" + this.f4994a.getTextScaleX());
            sb.append(", textSkewX=" + this.f4994a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f4994a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f4994a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f4994a.getTextLocales());
            sb.append(", typeface=" + this.f4994a.getTypeface());
            sb.append(", variationSettings=" + this.f4994a.getFontVariationSettings());
            sb.append(", textDir=" + this.f4995b);
            sb.append(", breakStrategy=" + this.f4996c);
            sb.append(", hyphenationFrequency=" + this.f4997d);
            sb.append("}");
            return sb.toString();
        }
    }
}
