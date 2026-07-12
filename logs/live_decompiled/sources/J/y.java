package J;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class y implements N.h, g {

    /* renamed from: e, reason: collision with root package name */
    private final Context f1116e;

    /* renamed from: f, reason: collision with root package name */
    private final String f1117f;

    /* renamed from: g, reason: collision with root package name */
    private final File f1118g;

    /* renamed from: h, reason: collision with root package name */
    private final Callable f1119h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1120i;

    /* renamed from: j, reason: collision with root package name */
    private final N.h f1121j;

    /* renamed from: k, reason: collision with root package name */
    private f f1122k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1123l;

    public y(Context context, String str, File file, Callable callable, int i3, N.h hVar) {
        D2.k.e(context, "context");
        D2.k.e(hVar, "delegate");
        this.f1116e = context;
        this.f1117f = str;
        this.f1118g = file;
        this.f1119h = callable;
        this.f1120i = i3;
        this.f1121j = hVar;
    }

    private final void b(File file, boolean z3) {
        ReadableByteChannel newChannel;
        if (this.f1117f != null) {
            newChannel = Channels.newChannel(this.f1116e.getAssets().open(this.f1117f));
            D2.k.d(newChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.f1118g != null) {
            newChannel = new FileInputStream(this.f1118g).getChannel();
            D2.k.d(newChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable callable = this.f1119h;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                newChannel = Channels.newChannel((InputStream) callable.call());
                D2.k.d(newChannel, "newChannel(inputStream)");
            } catch (Exception e3) {
                throw new IOException("inputStreamCallable exception on call", e3);
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f1116e.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        D2.k.d(channel, "output");
        L.c.a(newChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        D2.k.d(createTempFile, "intermediateFile");
        c(createTempFile, z3);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final void c(File file, boolean z3) {
        f fVar = this.f1122k;
        if (fVar == null) {
            D2.k.n("databaseConfiguration");
            fVar = null;
        }
        fVar.getClass();
    }

    private final void i(boolean z3) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        File databasePath = this.f1116e.getDatabasePath(databaseName);
        f fVar = this.f1122k;
        f fVar2 = null;
        if (fVar == null) {
            D2.k.n("databaseConfiguration");
            fVar = null;
        }
        boolean z4 = fVar.f995s;
        File filesDir = this.f1116e.getFilesDir();
        D2.k.d(filesDir, "context.filesDir");
        P.a aVar = new P.a(databaseName, filesDir, z4);
        try {
            P.a.c(aVar, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    D2.k.d(databasePath, "databaseFile");
                    b(databasePath, z3);
                    aVar.d();
                    return;
                } catch (IOException e3) {
                    throw new RuntimeException("Unable to copy database file.", e3);
                }
            }
            try {
                D2.k.d(databasePath, "databaseFile");
                int c3 = L.b.c(databasePath);
                if (c3 == this.f1120i) {
                    aVar.d();
                    return;
                }
                f fVar3 = this.f1122k;
                if (fVar3 == null) {
                    D2.k.n("databaseConfiguration");
                } else {
                    fVar2 = fVar3;
                }
                if (fVar2.a(c3, this.f1120i)) {
                    aVar.d();
                    return;
                }
                if (this.f1116e.deleteDatabase(databaseName)) {
                    try {
                        b(databasePath, z3);
                    } catch (IOException e4) {
                        Log.w("ROOM", "Unable to copy database file.", e4);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar.d();
                return;
            } catch (IOException e5) {
                Log.w("ROOM", "Unable to read database version.", e5);
                aVar.d();
                return;
            }
        } catch (Throwable th) {
            aVar.d();
            throw th;
        }
        aVar.d();
        throw th;
    }

    @Override // N.h
    public N.g P() {
        if (!this.f1123l) {
            i(true);
            this.f1123l = true;
        }
        return a().P();
    }

    @Override // J.g
    public N.h a() {
        return this.f1121j;
    }

    @Override // N.h, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        a().close();
        this.f1123l = false;
    }

    public final void g(f fVar) {
        D2.k.e(fVar, "databaseConfiguration");
        this.f1122k = fVar;
    }

    @Override // N.h
    public String getDatabaseName() {
        return a().getDatabaseName();
    }

    @Override // N.h
    public void setWriteAheadLoggingEnabled(boolean z3) {
        a().setWriteAheadLoggingEnabled(z3);
    }
}
