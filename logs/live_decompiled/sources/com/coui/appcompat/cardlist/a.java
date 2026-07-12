package com.coui.appcompat.cardlist;

import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.coui.appcompat.preference.ListSelectedItemLayout;
import com.coui.appcompat.preference.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {
    public static int a(int i3, int i4) {
        if (i3 == 1) {
            return 4;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4 == i3 - 1 ? 3 : 2;
    }

    public static int b(Preference preference) {
        PreferenceGroup parent = preference.getParent();
        int i3 = 0;
        if (parent == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < parent.o(); i4++) {
            Preference n3 = parent.n(i4);
            if (n3.isVisible()) {
                arrayList.add(n3);
            }
        }
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            if (preference == arrayList.get(i5)) {
                i3 = i5;
                break;
            }
            i5++;
        }
        Preference preference2 = i3 > 0 ? (Preference) arrayList.get(i3 - 1) : null;
        Preference preference3 = i3 < size - 1 ? (Preference) arrayList.get(i3 + 1) : null;
        int i6 = (preference2 == null || !c(parent, preference2)) ? 1 : 2;
        return (preference3 == null || !c(parent, preference3)) ? i6 == 1 ? 4 : 3 : i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(PreferenceGroup preferenceGroup, Preference preference) {
        return preferenceGroup instanceof PreferenceScreen ? (preference instanceof b) && ((b) preference).isSupportCardUse() : !(preference instanceof PreferenceCategory);
    }

    public static void d(View view, int i3) {
        if (view instanceof ListSelectedItemLayout) {
            ((ListSelectedItemLayout) view).setPositionInGroup(i3);
        }
    }
}
