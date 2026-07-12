package j2;

import android.content.Context;
import android.util.Base64;
import com.customer.feedback.sdk.util.HeaderInfoHelper;
import com.customer.feedback.sdk.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import k2.AbstractC0444a;
import l2.AbstractC0449b;
import org.json.JSONObject;

/* renamed from: j2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0418h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12175a;

    public C0418h(Context context) {
        this.f12175a = context;
    }

    public final byte[] a(String str, String str2) {
        if (str != null && str.length() > 0) {
            String str3 = AbstractC0444a.f12287a;
            String str4 = AbstractC0444a.f12288b + AbstractC0444a.f12289c;
            File file = new File(str);
            try {
                if (!file.exists()) {
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                int length = (int) file.length();
                byte[] bArr = new byte[length];
                LogUtil.d("feedbackc.feedbackh", "file buffer size is " + length);
                fileInputStream.read(bArr);
                fileInputStream.close();
                String encodeToString = Base64.encodeToString(bArr, 2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", file.getName());
                jSONObject.put("file", encodeToString);
                jSONObject.put("id", str2);
                jSONObject.put("pid", HeaderInfoHelper.getAppCode(this.f12175a));
                return AbstractC0449b.a(str4, jSONObject.toString());
            } catch (FileNotFoundException unused) {
                LogUtil.e("feedbackc.feedbackh", "FileNotFoundException");
            } catch (IOException unused2) {
                LogUtil.e("feedbackc.feedbackh", "IOException");
            } catch (Exception unused3) {
                LogUtil.e("feedbackc.feedbackh", "Exception");
            }
        }
        return null;
    }
}
