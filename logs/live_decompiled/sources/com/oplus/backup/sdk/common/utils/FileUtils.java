package com.oplus.backup.sdk.common.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class FileUtils {
    public static final String TAG = "FileUtils";

    public static boolean copyFile(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        if (inputStream == null || TextUtils.isEmpty(str)) {
            return false;
        }
        mkdirs(new File(str).getParentFile());
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e3) {
                throw e3;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                inputStream.close();
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                inputStream.close();
                throw th;
            }
        } catch (IOException e4) {
            throw e4;
        } catch (Exception unused2) {
        }
    }

    public static boolean copyFolder(String str, String str2) {
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i3 = 0; i3 < list.length; i3++) {
                String str3 = File.separator;
                File file = str.endsWith(str3) ? new File(str + list[i3]) : new File(str + str3 + list[i3]);
                if (file.isFile()) {
                    nioTransferCopy(file, new File(str2 + "/" + file.getName().toString()));
                }
                if (file.isDirectory()) {
                    copyFolder(str + "/" + list[i3], str2 + "/" + list[i3]);
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean deleteFileOrFolder(File file) {
        if (file == null) {
            return false;
        }
        try {
            boolean z3 = true;
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (!deleteFileOrFolder(file2)) {
                            z3 = false;
                        }
                    }
                }
                if (!file.delete()) {
                    return false;
                }
            }
            return z3;
        } catch (Exception unused) {
            BRLog.e(TAG, "deleteFileOrFolder exception");
            return false;
        }
    }

    public static boolean isEmptyFolder(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!isEmptyFolder(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean mkdirs(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        if (file.isFile()) {
            File file2 = new File(file.getAbsolutePath() + file.lastModified());
            if (file.renameTo(file2)) {
                return file.mkdirs();
            }
            BRLog.w(TAG, "file.renameTo false, " + BRLog.getModifiedFile(file2));
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean nioTransferCopy(java.io.File r9, java.io.File r10) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4e
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4e
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L46
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L46
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3e
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L33
            long r5 = r10.size()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L33
            r3 = 0
            r2 = r10
            r7 = r0
            r2.transferTo(r3, r5, r7)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L33
            r1.close()
            r10.close()
            r9.close()
            if (r0 == 0) goto L2c
            r0.close()
        L2c:
            r9 = 1
            return r9
        L2e:
            r2 = move-exception
            r8 = r1
            r1 = r0
        L31:
            r0 = r8
            goto L59
        L33:
            r2 = move-exception
            r8 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            goto L52
        L39:
            r2 = move-exception
            r10 = r0
        L3b:
            r0 = r1
        L3c:
            r1 = r10
            goto L59
        L3e:
            r2 = move-exception
            r10 = r9
            r9 = r0
            goto L52
        L42:
            r2 = move-exception
            r9 = r0
            r10 = r9
            goto L3b
        L46:
            r2 = move-exception
            r9 = r0
            r10 = r9
            goto L52
        L4a:
            r2 = move-exception
            r9 = r0
            r10 = r9
            goto L3c
        L4e:
            r2 = move-exception
            r9 = r0
            r10 = r9
            r1 = r10
        L52:
            throw r2     // Catch: java.lang.Throwable -> L53
        L53:
            r2 = move-exception
            r8 = r1
            r1 = r9
            r9 = r10
            r10 = r0
            goto L31
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            if (r10 == 0) goto L63
            r10.close()
        L63:
            if (r9 == 0) goto L68
            r9.close()
        L68:
            if (r1 == 0) goto L6d
            r1.close()
        L6d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.backup.sdk.common.utils.FileUtils.nioTransferCopy(java.io.File, java.io.File):boolean");
    }

    public static void setPermissionsReadOnly(String str) {
        android.os.FileUtils.setPermissions(str, 509, -1, -1);
    }

    public static boolean copyFile(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    fileInputStream = new FileInputStream(str);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream = fileOutputStream2;
                        } catch (IOException e3) {
                            throw e3;
                        } catch (Exception unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream == null) {
                                return false;
                            }
                            fileInputStream.close();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        throw e4;
                    } catch (Exception unused2) {
                    }
                } else {
                    fileInputStream = null;
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            throw e5;
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
