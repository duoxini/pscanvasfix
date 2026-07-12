package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public abstract class g {

    static class a {
        static boolean a(ListView listView, int i3) {
            return listView.canScrollList(i3);
        }

        static void b(ListView listView, int i3) {
            listView.scrollListBy(i3);
        }
    }

    public static void a(ListView listView, int i3) {
        a.b(listView, i3);
    }
}
