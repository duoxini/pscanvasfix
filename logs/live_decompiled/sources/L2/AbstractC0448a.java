package l2;

import com.customer.feedback.sdk.util.LogUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0448a {
    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                } catch (Exception e4) {
                    LogUtil.e("BaseHelper", "exceptionInfo：" + e4);
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                        LogUtil.e("BaseHelper", "exceptionInfo：" + e5);
                    }
                }
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e32) {
                    LogUtil.e("BaseHelper", "exceptionInfo：" + e32);
                }
            }
        }
        return sb.toString();
    }
}
