package j2;

import com.customer.feedback.sdk.util.LogUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: j2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0414d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12166a = true;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f12167b = new AtomicInteger(0);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File a(java.lang.String r4, boolean r5) {
        /*
            java.lang.String r0 = "\\\\"
            java.lang.String r1 = "/"
            java.lang.String r4 = r4.replaceAll(r0, r1)
            int r0 = r4.lastIndexOf(r1)
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 <= r1) goto L45
            r1 = 0
            java.lang.String r0 = r4.substring(r1, r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L25
            boolean r3 = r1.mkdirs()
        L25:
            if (r3 == 0) goto L45
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 != 0) goto L38
            boolean r4 = r0.createNewFile()     // Catch: java.io.IOException -> L46
        L36:
            r3 = r4
            goto L46
        L38:
            if (r5 == 0) goto L46
            boolean r3 = r0.delete()
            if (r3 == 0) goto L46
            boolean r4 = r0.createNewFile()     // Catch: java.io.IOException -> L46
            goto L36
        L45:
            r0 = r2
        L46:
            if (r3 == 0) goto L49
            r2 = r0
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.AbstractC0414d.a(java.lang.String, boolean):java.io.File");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(2:35|36)|(4:38|39|40|41)|(2:43|(11:45|46|(1:(3:48|(3:49|50|(2:52|(1:54)(2:59|60))(2:100|101))|57))(1:162)|(3:64|(1:66)|(1:(2:68|(3:72|(3:74|75|76)(1:78)|77)(2:80|79)))(0))(0)|81|(2:95|96)|(2:91|92)|84|85|86|87))|164|46|(0)(0)|(4:62|64|(0)|(0)(0))(0)|81|(0)|(0)|84|85|86|87) */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f9, code lost:
    
        if (r8 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fb, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01e0, code lost:
    
        if (r8 != null) goto L116;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1 A[LOOP:1: B:48:0x00f1->B:57:0x0121, LOOP_LABEL: LOOP:1: B:48:0x00f1->B:57:0x0121, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0147 A[Catch: all -> 0x0125, IOException -> 0x01cd, FileNotFoundException -> 0x01e6, TryCatch #22 {FileNotFoundException -> 0x01e6, IOException -> 0x01cd, all -> 0x0125, blocks: (B:50:0x00f2, B:52:0x00f8, B:54:0x0100, B:57:0x0121, B:62:0x0130, B:64:0x0136, B:66:0x0147, B:68:0x0153, B:70:0x0159, B:72:0x0161, B:75:0x0181, B:81:0x0186), top: B:49:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0153 A[Catch: all -> 0x0125, IOException -> 0x01cd, FileNotFoundException -> 0x01e6, LOOP:3: B:68:0x0153->B:77:0x0153, LOOP_START, PHI: r13
  0x0153: PHI (r13v2 int) = (r13v1 int), (r13v4 int) binds: [B:67:0x0151, B:77:0x0153] A[DONT_GENERATE, DONT_INLINE], TryCatch #22 {FileNotFoundException -> 0x01e6, IOException -> 0x01cd, all -> 0x0125, blocks: (B:50:0x00f2, B:52:0x00f8, B:54:0x0100, B:57:0x0121, B:62:0x0130, B:64:0x0136, B:66:0x0147, B:68:0x0153, B:70:0x0159, B:72:0x0161, B:75:0x0181, B:81:0x0186), top: B:49:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r17, long r18) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.AbstractC0414d.b(java.lang.String, long):java.lang.String");
    }

    public static void c(String str, String str2, String str3) {
        FileWriter fileWriter;
        String[] list;
        String str4 = str2 + "fblog" + str3 + ".txt";
        if (f12166a && str2 != null) {
            LogUtil.d("FbLogFile", "deleteFileMoreThan2Days");
            f12166a = false;
            File file = new File(str2);
            if (file.isDirectory() && (list = file.list()) != null) {
                Arrays.sort(list);
                ArrayList arrayList = new ArrayList();
                for (String str5 : list) {
                    if (str5 != null && str5.startsWith("fblog")) {
                        arrayList.add(str5);
                    }
                }
                int size = arrayList.size();
                for (int i3 = 0; i3 < size - 2; i3++) {
                    String str6 = str2 + ((String) arrayList.get(i3));
                    LogUtil.d("FbLogFile", "deleteFileByPath:" + str6);
                    if (str6 != null) {
                        File file2 = new File(str6);
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            }
        }
        File a3 = a(str4, false);
        if (a3 != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(a3, true);
                } catch (IOException unused) {
                    return;
                }
            } catch (IOException unused2) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException unused3) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    fileWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }
}
