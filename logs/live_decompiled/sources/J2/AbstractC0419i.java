package j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: j2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0419i {
    public static String a(String str, boolean z3) {
        File file = new File(str);
        String str2 = file.getPath() + ".gz";
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
        byte[] bArr = new byte[5120];
        while (true) {
            int read = fileInputStream.read(bArr, 0, 5120);
            if (read == -1) {
                break;
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
        gZIPOutputStream.close();
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        if (z3) {
            file.delete();
        }
        return str2;
    }
}
