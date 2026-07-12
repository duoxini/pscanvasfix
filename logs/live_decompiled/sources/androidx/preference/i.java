package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class i {

    /* renamed from: e, reason: collision with root package name */
    private static final Class[] f6002e = {Context.class, AttributeSet.class};

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap f6003f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Context f6004a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f6005b = new Object[2];

    /* renamed from: c, reason: collision with root package name */
    private j f6006c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f6007d;

    public i(Context context, j jVar) {
        this.f6004a = context;
        f(jVar);
    }

    private Preference a(String str, String[] strArr, AttributeSet attributeSet) {
        Class<?> cls;
        Constructor<?> constructor = (Constructor) f6003f.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f6004a.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        cls = null;
                        ClassNotFoundException e3 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e4) {
                                e3 = e4;
                            }
                        }
                        if (cls == null) {
                            if (e3 != null) {
                                throw e3;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                        constructor = cls.getConstructor(f6002e);
                        constructor.setAccessible(true);
                        f6003f.put(str, constructor);
                    }
                    cls = Class.forName(str, false, classLoader);
                    constructor = cls.getConstructor(f6002e);
                    constructor.setAccessible(true);
                    f6003f.put(str, constructor);
                } catch (Exception e5) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e5);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e6) {
                throw e6;
            }
        }
        Object[] objArr = this.f6005b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    private Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? g(str, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e3) {
            throw e3;
        } catch (ClassNotFoundException e4) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e4);
            throw inflateException;
        } catch (Exception e5) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e5);
            throw inflateException2;
        }
    }

    private void f(j jVar) {
        this.f6006c = jVar;
        j(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    private PreferenceGroup h(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup != null) {
            return preferenceGroup;
        }
        preferenceGroup2.onAttachedToHierarchy(this.f6006c);
        return preferenceGroup2;
    }

    private void i(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (Constants.MessagerConstants.INTENT_KEY.equals(name)) {
                    try {
                        preference.setIntent(Intent.parseIntent(c().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e3);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    c().getResources().parseBundleExtra("extra", attributeSet, preference.getExtras());
                    try {
                        k(xmlPullParser);
                    } catch (IOException e4) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e4);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference b3 = b(name, attributeSet);
                    ((PreferenceGroup) preference).i(b3);
                    i(xmlPullParser, b3, attributeSet);
                }
            }
        }
    }

    private static void k(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    public Context c() {
        return this.f6004a;
    }

    public Preference d(int i3, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = c().getResources().getXml(i3);
        try {
            return e(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference e(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup h3;
        synchronized (this.f6005b) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f6005b[0] = this.f6004a;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e3) {
                    throw e3;
                } catch (IOException e4) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e4.getMessage());
                    inflateException.initCause(e4);
                    throw inflateException;
                } catch (XmlPullParserException e5) {
                    InflateException inflateException2 = new InflateException(e5.getMessage());
                    inflateException2.initCause(e5);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
            h3 = h(preferenceGroup, (PreferenceGroup) b(xmlPullParser.getName(), asAttributeSet));
            i(xmlPullParser, h3, asAttributeSet);
        }
        return h3;
    }

    protected Preference g(String str, AttributeSet attributeSet) {
        return a(str, this.f6007d, attributeSet);
    }

    public void j(String[] strArr) {
        this.f6007d = strArr;
    }
}
