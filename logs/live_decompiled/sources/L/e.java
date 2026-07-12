package L;

import D2.k;
import L.d;
import N.g;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import q2.AbstractC0521D;
import q2.AbstractC0527J;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public abstract class e {
    private static final Map a(g gVar, String str) {
        Cursor U3 = gVar.U("PRAGMA table_info(`" + str + "`)");
        try {
            if (U3.getColumnCount() <= 0) {
                Map g3 = AbstractC0521D.g();
                A2.a.a(U3, null);
                return g3;
            }
            int columnIndex = U3.getColumnIndex("name");
            int columnIndex2 = U3.getColumnIndex("type");
            int columnIndex3 = U3.getColumnIndex("notnull");
            int columnIndex4 = U3.getColumnIndex("pk");
            int columnIndex5 = U3.getColumnIndex("dflt_value");
            Map c3 = AbstractC0521D.c();
            while (U3.moveToNext()) {
                String string = U3.getString(columnIndex);
                String string2 = U3.getString(columnIndex2);
                boolean z3 = U3.getInt(columnIndex3) != 0;
                int i3 = U3.getInt(columnIndex4);
                String string3 = U3.getString(columnIndex5);
                k.d(string, "name");
                k.d(string2, "type");
                c3.put(string, new d.a(string, string2, z3, i3, string3, 2));
            }
            Map b3 = AbstractC0521D.b(c3);
            A2.a.a(U3, null);
            return b3;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                A2.a.a(U3, th);
                throw th2;
            }
        }
    }

    private static final List b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List c3 = AbstractC0544n.c();
        while (cursor.moveToNext()) {
            int i3 = cursor.getInt(columnIndex);
            int i4 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            k.d(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            k.d(string2, "cursor.getString(toColumnIndex)");
            c3.add(new d.C0022d(i3, i4, string, string2));
        }
        return AbstractC0544n.z(AbstractC0544n.a(c3));
    }

    private static final Set c(g gVar, String str) {
        Cursor U3 = gVar.U("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = U3.getColumnIndex("id");
            int columnIndex2 = U3.getColumnIndex("seq");
            int columnIndex3 = U3.getColumnIndex("table");
            int columnIndex4 = U3.getColumnIndex("on_delete");
            int columnIndex5 = U3.getColumnIndex("on_update");
            List b3 = b(U3);
            U3.moveToPosition(-1);
            Set b4 = AbstractC0527J.b();
            while (U3.moveToNext()) {
                if (U3.getInt(columnIndex2) == 0) {
                    int i3 = U3.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<d.C0022d> arrayList3 = new ArrayList();
                    for (Object obj : b3) {
                        if (((d.C0022d) obj).c() == i3) {
                            arrayList3.add(obj);
                        }
                    }
                    for (d.C0022d c0022d : arrayList3) {
                        arrayList.add(c0022d.b());
                        arrayList2.add(c0022d.d());
                    }
                    String string = U3.getString(columnIndex3);
                    k.d(string, "cursor.getString(tableColumnIndex)");
                    String string2 = U3.getString(columnIndex4);
                    k.d(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = U3.getString(columnIndex5);
                    k.d(string3, "cursor.getString(onUpdateColumnIndex)");
                    b4.add(new d.c(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set a3 = AbstractC0527J.a(b4);
            A2.a.a(U3, null);
            return a3;
        } finally {
        }
    }

    private static final d.e d(g gVar, String str, boolean z3) {
        Cursor U3 = gVar.U("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = U3.getColumnIndex("seqno");
            int columnIndex2 = U3.getColumnIndex("cid");
            int columnIndex3 = U3.getColumnIndex("name");
            int columnIndex4 = U3.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (U3.moveToNext()) {
                    if (U3.getInt(columnIndex2) >= 0) {
                        int i3 = U3.getInt(columnIndex);
                        String string = U3.getString(columnIndex3);
                        String str2 = U3.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer valueOf = Integer.valueOf(i3);
                        k.d(string, "columnName");
                        treeMap.put(valueOf, string);
                        treeMap2.put(Integer.valueOf(i3), str2);
                    }
                }
                Collection values = treeMap.values();
                k.d(values, "columnsMap.values");
                List C3 = AbstractC0544n.C(values);
                Collection values2 = treeMap2.values();
                k.d(values2, "ordersMap.values");
                d.e eVar = new d.e(str, z3, C3, AbstractC0544n.C(values2));
                A2.a.a(U3, null);
                return eVar;
            }
            A2.a.a(U3, null);
            return null;
        } finally {
        }
    }

    private static final Set e(g gVar, String str) {
        Cursor U3 = gVar.U("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = U3.getColumnIndex("name");
            int columnIndex2 = U3.getColumnIndex("origin");
            int columnIndex3 = U3.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                Set b3 = AbstractC0527J.b();
                while (U3.moveToNext()) {
                    if (k.a("c", U3.getString(columnIndex2))) {
                        String string = U3.getString(columnIndex);
                        boolean z3 = true;
                        if (U3.getInt(columnIndex3) != 1) {
                            z3 = false;
                        }
                        k.d(string, "name");
                        d.e d3 = d(gVar, string, z3);
                        if (d3 == null) {
                            A2.a.a(U3, null);
                            return null;
                        }
                        b3.add(d3);
                    }
                }
                Set a3 = AbstractC0527J.a(b3);
                A2.a.a(U3, null);
                return a3;
            }
            A2.a.a(U3, null);
            return null;
        } finally {
        }
    }

    public static final d f(g gVar, String str) {
        k.e(gVar, "database");
        k.e(str, "tableName");
        return new d(str, a(gVar, str), c(gVar, str), e(gVar, str));
    }
}
