package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import u.AbstractC0596a;
import x.AbstractC0626a;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4863a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal threadLocal = f4863a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        Resources resources2 = resources;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[20];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray g3 = g(resources2, theme, attributeSet, u.c.f13740b);
                int resourceId = g3.getResourceId(u.c.f13741c, -1);
                if (resourceId == -1 || e(resources2, resourceId)) {
                    color = g3.getColor(u.c.f13741c, -65281);
                } else {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = g3.getColor(u.c.f13741c, -65281);
                    }
                }
                float f3 = 1.0f;
                if (g3.hasValue(u.c.f13742d)) {
                    f3 = g3.getFloat(u.c.f13742d, 1.0f);
                } else if (g3.hasValue(u.c.f13744f)) {
                    f3 = g3.getFloat(u.c.f13744f, 1.0f);
                }
                float f4 = g3.hasValue(u.c.f13743e) ? g3.getFloat(u.c.f13743e, -1.0f) : g3.getFloat(u.c.f13745g, -1.0f);
                g3.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != AbstractC0596a.f13693a && attributeNameResource != AbstractC0596a.f13694b) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i5);
                iArr2 = e.a(iArr2, i4, f(color, f3, f4));
                iArr = (int[][]) e.b(iArr, i4, trimStateSet);
                i4++;
            }
            i3 = 1;
            resources2 = resources;
        }
        int[] iArr4 = new int[i4];
        int[][] iArr5 = new int[i4][];
        System.arraycopy(iArr2, 0, iArr4, 0, i4);
        System.arraycopy(iArr, 0, iArr5, 0, i4);
        return new ColorStateList(iArr5, iArr4);
    }

    private static boolean e(Resources resources, int i3) {
        TypedValue c3 = c();
        resources.getValue(i3, c3, true);
        int i4 = c3.type;
        return i4 >= 28 && i4 <= 31;
    }

    private static int f(int i3, float f3, float f4) {
        boolean z3 = f4 >= 0.0f && f4 <= 100.0f;
        if (f3 == 1.0f && !z3) {
            return i3;
        }
        int b3 = AbstractC0626a.b((int) ((Color.alpha(i3) * f3) + 0.5f), 0, 255);
        if (z3) {
            a c3 = a.c(i3);
            i3 = a.m(c3.j(), c3.i(), f4);
        }
        return (i3 & 16777215) | (b3 << 24);
    }

    private static TypedArray g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
