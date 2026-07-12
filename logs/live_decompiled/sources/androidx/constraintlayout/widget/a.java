package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4366a;

    /* renamed from: b, reason: collision with root package name */
    String f4367b;

    /* renamed from: c, reason: collision with root package name */
    private b f4368c;

    /* renamed from: d, reason: collision with root package name */
    private int f4369d;

    /* renamed from: e, reason: collision with root package name */
    private float f4370e;

    /* renamed from: f, reason: collision with root package name */
    private String f4371f;

    /* renamed from: g, reason: collision with root package name */
    boolean f4372g;

    /* renamed from: h, reason: collision with root package name */
    private int f4373h;

    /* renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0058a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4374a;

        static {
            int[] iArr = new int[b.values().length];
            f4374a = iArr;
            try {
                iArr[b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4374a[b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4374a[b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4374a[b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4374a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4374a[b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4374a[b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4374a[b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(String str, b bVar, Object obj, boolean z3) {
        this.f4367b = str;
        this.f4368c = bVar;
        this.f4366a = z3;
        d(obj);
    }

    public static HashMap a(HashMap hashMap, View view) {
        HashMap hashMap2 = new HashMap();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new a(aVar, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void b(Context context, XmlPullParser xmlPullParser, HashMap hashMap) {
        b bVar;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), g.k4);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        b bVar2 = null;
        boolean z3 = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == g.l4) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == g.v4) {
                str = obtainStyledAttributes.getString(index);
                z3 = true;
            } else if (index == g.m4) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                bVar2 = b.BOOLEAN_TYPE;
            } else {
                if (index == g.o4) {
                    bVar = b.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == g.n4) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == g.s4) {
                    bVar = b.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == g.p4) {
                    bVar = b.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == g.q4) {
                    bVar = b.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == g.r4) {
                    bVar = b.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == g.u4) {
                    bVar = b.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == g.t4) {
                    bVar = b.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                bVar2 = bVar;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new a(str, bVar2, obj, z3));
        }
        obtainStyledAttributes.recycle();
    }

    public static void c(View view, HashMap hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = (a) hashMap.get(str);
            String str2 = aVar.f4366a ? str : "set" + str;
            try {
                switch (C0058a.f4374a[aVar.f4368c.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f4369d));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f4372g));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, aVar.f4371f);
                        break;
                    case 4:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f4373h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f4373h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f4369d));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f4370e));
                        break;
                    case 8:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f4370e));
                        break;
                }
            } catch (IllegalAccessException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                Log.e("TransitionLayout", e4.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e5) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e5.printStackTrace();
            }
        }
    }

    public void d(Object obj) {
        switch (C0058a.f4374a[this.f4368c.ordinal()]) {
            case 1:
            case 6:
                this.f4369d = ((Integer) obj).intValue();
                break;
            case 2:
                this.f4372g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f4371f = (String) obj;
                break;
            case 4:
            case 5:
                this.f4373h = ((Integer) obj).intValue();
                break;
            case 7:
                this.f4370e = ((Float) obj).floatValue();
                break;
            case 8:
                this.f4370e = ((Float) obj).floatValue();
                break;
        }
    }

    public a(a aVar, Object obj) {
        this.f4366a = false;
        this.f4367b = aVar.f4367b;
        this.f4368c = aVar.f4368c;
        d(obj);
    }
}
