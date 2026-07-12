package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f4393a;

    /* renamed from: b, reason: collision with root package name */
    d f4394b;

    /* renamed from: c, reason: collision with root package name */
    int f4395c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f4396d = -1;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray f4397e = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    private SparseArray f4398f = new SparseArray();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f4399a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f4400b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        int f4401c;

        /* renamed from: d, reason: collision with root package name */
        d f4402d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f4401c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), g.E6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == g.F6) {
                    this.f4399a = obtainStyledAttributes.getResourceId(index, this.f4399a);
                } else if (index == g.G6) {
                    this.f4401c = obtainStyledAttributes.getResourceId(index, this.f4401c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4401c);
                    context.getResources().getResourceName(this.f4401c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f4402d = dVar;
                        dVar.f(context, this.f4401c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f4400b.add(bVar);
        }

        public int b(float f3, float f4) {
            for (int i3 = 0; i3 < this.f4400b.size(); i3++) {
                if (((b) this.f4400b.get(i3)).a(f3, f4)) {
                    return i3;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        float f4403a;

        /* renamed from: b, reason: collision with root package name */
        float f4404b;

        /* renamed from: c, reason: collision with root package name */
        float f4405c;

        /* renamed from: d, reason: collision with root package name */
        float f4406d;

        /* renamed from: e, reason: collision with root package name */
        int f4407e;

        /* renamed from: f, reason: collision with root package name */
        d f4408f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f4403a = Float.NaN;
            this.f4404b = Float.NaN;
            this.f4405c = Float.NaN;
            this.f4406d = Float.NaN;
            this.f4407e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), g.c7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == g.d7) {
                    this.f4407e = obtainStyledAttributes.getResourceId(index, this.f4407e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4407e);
                    context.getResources().getResourceName(this.f4407e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f4408f = dVar;
                        dVar.f(context, this.f4407e);
                    }
                } else if (index == g.e7) {
                    this.f4406d = obtainStyledAttributes.getDimension(index, this.f4406d);
                } else if (index == g.f7) {
                    this.f4404b = obtainStyledAttributes.getDimension(index, this.f4404b);
                } else if (index == g.g7) {
                    this.f4405c = obtainStyledAttributes.getDimension(index, this.f4405c);
                } else if (index == g.h7) {
                    this.f4403a = obtainStyledAttributes.getDimension(index, this.f4403a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f3, float f4) {
            if (!Float.isNaN(this.f4403a) && f3 < this.f4403a) {
                return false;
            }
            if (!Float.isNaN(this.f4404b) && f4 < this.f4404b) {
                return false;
            }
            if (Float.isNaN(this.f4405c) || f3 <= this.f4405c) {
                return Float.isNaN(this.f4406d) || f4 <= this.f4406d;
            }
            return false;
        }
    }

    c(Context context, ConstraintLayout constraintLayout, int i3) {
        this.f4393a = constraintLayout;
        a(context, i3);
    }

    private void a(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            int eventType = xml.getEventType();
            a aVar = null;
            while (true) {
                char c3 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c3 = 4;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    if (c3 == 2) {
                        aVar = new a(context, xml);
                        this.f4397e.put(aVar.f4399a, aVar);
                    } else if (c3 == 3) {
                        b bVar = new b(context, xml);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    } else if (c3 == 4) {
                        b(context, xml);
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.m(context, xmlPullParser);
                this.f4398f.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(e eVar) {
    }

    public void d(int i3, float f3, float f4) {
        int b3;
        int i4 = this.f4395c;
        if (i4 == i3) {
            a aVar = i3 == -1 ? (a) this.f4397e.valueAt(0) : (a) this.f4397e.get(i4);
            int i5 = this.f4396d;
            if ((i5 == -1 || !((b) aVar.f4400b.get(i5)).a(f3, f4)) && this.f4396d != (b3 = aVar.b(f3, f4))) {
                d dVar = b3 == -1 ? this.f4394b : ((b) aVar.f4400b.get(b3)).f4408f;
                if (b3 != -1) {
                    int i6 = ((b) aVar.f4400b.get(b3)).f4407e;
                }
                if (dVar == null) {
                    return;
                }
                this.f4396d = b3;
                dVar.c(this.f4393a);
                return;
            }
            return;
        }
        this.f4395c = i3;
        a aVar2 = (a) this.f4397e.get(i3);
        int b4 = aVar2.b(f3, f4);
        d dVar2 = b4 == -1 ? aVar2.f4402d : ((b) aVar2.f4400b.get(b4)).f4408f;
        if (b4 != -1) {
            int i7 = ((b) aVar2.f4400b.get(b4)).f4407e;
        }
        if (dVar2 != null) {
            this.f4396d = b4;
            dVar2.c(this.f4393a);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i3 + ", dim =" + f3 + ", " + f4);
    }
}
