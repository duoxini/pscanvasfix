package j1;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import m1.AbstractC0462e;
import m1.AbstractC0465h;

/* renamed from: j1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0409g {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0406d f12155a;

    public C0409g(InterfaceC0406d interfaceC0406d) {
        this.f12155a = interfaceC0406d;
    }

    private static String b(String str, EnumC0408f enumC0408f, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("effective_anim_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z3 ? enumC0408f.a() : enumC0408f.f12154e);
        return sb.toString();
    }

    private File c(String str) {
        File file = new File(d(), b(str, EnumC0408f.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, EnumC0408f.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File a3 = this.f12155a.a();
        if (a3.isFile()) {
            a3.delete();
        }
        if (!a3.exists()) {
            a3.mkdirs();
        }
        return a3;
    }

    Pair a(String str) {
        try {
            File c3 = c(str);
            if (c3 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c3);
            EnumC0408f enumC0408f = AbstractC0465h.n(c3.getAbsolutePath(), ".zip") ? EnumC0408f.ZIP : EnumC0408f.JSON;
            AbstractC0462e.a("Cache hit for " + str + " at " + c3.getAbsolutePath());
            return new Pair(enumC0408f, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void e(String str, EnumC0408f enumC0408f) {
        File file = new File(d(), b(str, enumC0408f, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        AbstractC0462e.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        AbstractC0462e.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    File f(String str, InputStream inputStream, EnumC0408f enumC0408f) {
        File file = new File(d(), b(str, enumC0408f, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
