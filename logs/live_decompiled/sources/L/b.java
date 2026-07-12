package L;

import D2.k;
import J.u;
import N.g;
import N.j;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import p2.q;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(g gVar) {
        k.e(gVar, "db");
        List c3 = AbstractC0544n.c();
        Cursor U3 = gVar.U("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (U3.moveToNext()) {
            try {
                c3.add(U3.getString(0));
            } finally {
            }
        }
        q qVar = q.f12810a;
        A2.a.a(U3, null);
        for (String str : AbstractC0544n.a(c3)) {
            k.d(str, "triggerName");
            if (K2.e.t(str, "room_fts_content_sync_", false, 2, null)) {
                gVar.w("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static final Cursor b(u uVar, j jVar, boolean z3, CancellationSignal cancellationSignal) {
        k.e(uVar, "db");
        k.e(jVar, "sqLiteQuery");
        Cursor x3 = uVar.x(jVar, cancellationSignal);
        if (!z3 || !(x3 instanceof AbstractWindowedCursor)) {
            return x3;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) x3;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? a.a(x3) : x3;
    }

    public static final int c(File file) {
        k.e(file, "databaseFile");
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i3 = allocate.getInt();
            A2.a.a(channel, null);
            return i3;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                A2.a.a(channel, th);
                throw th2;
            }
        }
    }
}
