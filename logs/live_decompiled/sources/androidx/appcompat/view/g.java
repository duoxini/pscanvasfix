package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.V;
import androidx.core.view.AbstractC0253b;
import androidx.core.view.l;
import e.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
import w.InterfaceMenuC0613a;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class[] f3740e;

    /* renamed from: f, reason: collision with root package name */
    static final Class[] f3741f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f3742a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f3743b;

    /* renamed from: c, reason: collision with root package name */
    Context f3744c;

    /* renamed from: d, reason: collision with root package name */
    private Object f3745d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: g, reason: collision with root package name */
        private static final Class[] f3746g = {MenuItem.class};

        /* renamed from: e, reason: collision with root package name */
        private Object f3747e;

        /* renamed from: f, reason: collision with root package name */
        private Method f3748f;

        public a(Object obj, String str) {
            this.f3747e = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f3748f = cls.getMethod(str, f3746g);
            } catch (Exception e3) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e3);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f3748f.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f3748f.invoke(this.f3747e, menuItem)).booleanValue();
                }
                this.f3748f.invoke(this.f3747e, menuItem);
                return true;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    private class b {

        /* renamed from: A, reason: collision with root package name */
        AbstractC0253b f3749A;

        /* renamed from: B, reason: collision with root package name */
        private CharSequence f3750B;

        /* renamed from: C, reason: collision with root package name */
        private CharSequence f3751C;

        /* renamed from: D, reason: collision with root package name */
        private ColorStateList f3752D = null;

        /* renamed from: E, reason: collision with root package name */
        private PorterDuff.Mode f3753E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f3755a;

        /* renamed from: b, reason: collision with root package name */
        private int f3756b;

        /* renamed from: c, reason: collision with root package name */
        private int f3757c;

        /* renamed from: d, reason: collision with root package name */
        private int f3758d;

        /* renamed from: e, reason: collision with root package name */
        private int f3759e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f3760f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3761g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3762h;

        /* renamed from: i, reason: collision with root package name */
        private int f3763i;

        /* renamed from: j, reason: collision with root package name */
        private int f3764j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f3765k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f3766l;

        /* renamed from: m, reason: collision with root package name */
        private int f3767m;

        /* renamed from: n, reason: collision with root package name */
        private char f3768n;

        /* renamed from: o, reason: collision with root package name */
        private int f3769o;

        /* renamed from: p, reason: collision with root package name */
        private char f3770p;

        /* renamed from: q, reason: collision with root package name */
        private int f3771q;

        /* renamed from: r, reason: collision with root package name */
        private int f3772r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f3773s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f3774t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f3775u;

        /* renamed from: v, reason: collision with root package name */
        private int f3776v;

        /* renamed from: w, reason: collision with root package name */
        private int f3777w;

        /* renamed from: x, reason: collision with root package name */
        private String f3778x;

        /* renamed from: y, reason: collision with root package name */
        private String f3779y;

        /* renamed from: z, reason: collision with root package name */
        private String f3780z;

        public b(Menu menu) {
            this.f3755a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f3744c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e3) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e3);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z3 = false;
            menuItem.setChecked(this.f3773s).setVisible(this.f3774t).setEnabled(this.f3775u).setCheckable(this.f3772r >= 1).setTitleCondensed(this.f3766l).setIcon(this.f3767m);
            int i3 = this.f3776v;
            if (i3 >= 0) {
                menuItem.setShowAsAction(i3);
            }
            if (this.f3780z != null) {
                if (g.this.f3744c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f3780z));
            }
            if (this.f3772r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.f3778x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f3740e, g.this.f3742a));
                z3 = true;
            }
            int i4 = this.f3777w;
            if (i4 > 0) {
                if (z3) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i4);
                }
            }
            AbstractC0253b abstractC0253b = this.f3749A;
            if (abstractC0253b != null) {
                l.a(menuItem, abstractC0253b);
            }
            l.c(menuItem, this.f3750B);
            l.g(menuItem, this.f3751C);
            l.b(menuItem, this.f3768n, this.f3769o);
            l.f(menuItem, this.f3770p, this.f3771q);
            PorterDuff.Mode mode = this.f3753E;
            if (mode != null) {
                l.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f3752D;
            if (colorStateList != null) {
                l.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f3762h = true;
            i(this.f3755a.add(this.f3756b, this.f3763i, this.f3764j, this.f3765k));
        }

        public SubMenu b() {
            this.f3762h = true;
            SubMenu addSubMenu = this.f3755a.addSubMenu(this.f3756b, this.f3763i, this.f3764j, this.f3765k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f3762h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f3744c.obtainStyledAttributes(attributeSet, j.f11414o1);
            this.f3756b = obtainStyledAttributes.getResourceId(j.f11422q1, 0);
            this.f3757c = obtainStyledAttributes.getInt(j.f11430s1, 0);
            this.f3758d = obtainStyledAttributes.getInt(j.f11434t1, 0);
            this.f3759e = obtainStyledAttributes.getInt(j.f11438u1, 0);
            this.f3760f = obtainStyledAttributes.getBoolean(j.f11426r1, true);
            this.f3761g = obtainStyledAttributes.getBoolean(j.f11418p1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            V v3 = V.v(g.this.f3744c, attributeSet, j.f11442v1);
            this.f3763i = v3.n(j.f11454y1, 0);
            this.f3764j = (v3.k(j.f11260B1, this.f3757c) & (-65536)) | (v3.k(j.f11264C1, this.f3758d) & 65535);
            this.f3765k = v3.p(j.f11268D1);
            this.f3766l = v3.p(j.f11272E1);
            this.f3767m = v3.n(j.f11446w1, 0);
            this.f3768n = c(v3.o(j.f11276F1));
            this.f3769o = v3.k(j.f11304M1, 4096);
            this.f3770p = c(v3.o(j.f11280G1));
            this.f3771q = v3.k(j.f11320Q1, 4096);
            if (v3.s(j.f11284H1)) {
                this.f3772r = v3.a(j.f11284H1, false) ? 1 : 0;
            } else {
                this.f3772r = this.f3759e;
            }
            this.f3773s = v3.a(j.f11458z1, false);
            this.f3774t = v3.a(j.f11256A1, this.f3760f);
            this.f3775u = v3.a(j.f11450x1, this.f3761g);
            this.f3776v = v3.k(j.f11324R1, -1);
            this.f3780z = v3.o(j.f11288I1);
            this.f3777w = v3.n(j.f11292J1, 0);
            this.f3778x = v3.o(j.f11300L1);
            String o3 = v3.o(j.f11296K1);
            this.f3779y = o3;
            boolean z3 = o3 != null;
            if (z3 && this.f3777w == 0 && this.f3778x == null) {
                this.f3749A = (AbstractC0253b) e(o3, g.f3741f, g.this.f3743b);
            } else {
                if (z3) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f3749A = null;
            }
            this.f3750B = v3.p(j.f11308N1);
            this.f3751C = v3.p(j.f11328S1);
            if (v3.s(j.f11316P1)) {
                this.f3753E = E.d(v3.k(j.f11316P1, -1), this.f3753E);
            } else {
                this.f3753E = null;
            }
            if (v3.s(j.f11312O1)) {
                this.f3752D = v3.c(j.f11312O1);
            } else {
                this.f3752D = null;
            }
            v3.x();
            this.f3762h = false;
        }

        public void h() {
            this.f3756b = 0;
            this.f3757c = 0;
            this.f3758d = 0;
            this.f3759e = 0;
            this.f3760f = true;
            this.f3761g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f3740e = clsArr;
        f3741f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f3744c = context;
        Object[] objArr = {context};
        this.f3742a = objArr;
        this.f3743b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r7 = false;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.f3749A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.hasSubMenu() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r6 = false;
        r7 = false;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            androidx.appcompat.view.g$b r0 = new androidx.appcompat.view.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Expecting menu, got "
            r13.append(r14)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r6
            r8 = r5
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r7 = r4
            r8 = r5
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            androidx.core.view.b r15 = r0.f3749A
            if (r15 == 0) goto L82
            boolean r15 = r15.hasSubMenu()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = r3
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = r3
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "Unexpected end of document"
            r12.<init>(r13)
            throw r12
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.f3745d == null) {
            this.f3745d = a(this.f3744c);
        }
        return this.f3745d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i3, Menu menu) {
        if (!(menu instanceof InterfaceMenuC0613a)) {
            super.inflate(i3, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f3744c.getResources().getLayout(i3);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e3) {
                    throw new InflateException("Error inflating menu XML", e3);
                }
            } catch (XmlPullParserException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
