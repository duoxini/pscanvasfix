package L;

import D2.k;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
public abstract class a {
    public static final Cursor a(Cursor cursor) {
        k.e(cursor, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i3 = 0; i3 < columnCount; i3++) {
                    int type = cursor.getType(i3);
                    if (type == 0) {
                        objArr[i3] = null;
                    } else if (type == 1) {
                        objArr[i3] = Long.valueOf(cursor.getLong(i3));
                    } else if (type == 2) {
                        objArr[i3] = Double.valueOf(cursor.getDouble(i3));
                    } else if (type == 3) {
                        objArr[i3] = cursor.getString(i3);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i3] = cursor.getBlob(i3);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            A2.a.a(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int b(Cursor cursor, String str) {
        return -1;
    }

    public static final int c(Cursor cursor, String str) {
        k.e(cursor, "c");
        k.e(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : b(cursor, str);
    }

    public static final int d(Cursor cursor, String str) {
        String str2;
        k.e(cursor, "c");
        k.e(str, "name");
        int c3 = c(cursor, str);
        if (c3 >= 0) {
            return c3;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            k.d(columnNames, "c.columnNames");
            str2 = AbstractC0538h.B(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception e3) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e3);
            str2 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
