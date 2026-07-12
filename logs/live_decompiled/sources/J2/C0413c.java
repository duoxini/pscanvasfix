package j2;

import com.customer.feedback.sdk.util.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: j2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0413c {

    /* renamed from: a, reason: collision with root package name */
    public final long f12162a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12163b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12164c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12165d;

    public C0413c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f12162a = ((Long) jSONObject.get("t")).longValue();
            this.f12163b = ((Integer) jSONObject.get("l")).intValue();
            this.f12164c = (String) jSONObject.get("n");
            this.f12165d = (String) jSONObject.get("c");
        } catch (JSONException e3) {
            LogUtil.e("FbLogData", "exceptionInfo：" + e3);
        }
    }

    public static String b(String str) {
        str.replace("\r\n", "  ");
        str.replace("\n", "  ");
        str.replace("\r", "  ");
        return str;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.f12162a);
            jSONObject.put("l", this.f12163b);
            jSONObject.put("n", this.f12164c);
            jSONObject.put("c", this.f12165d);
        } catch (JSONException e3) {
            LogUtil.e("FbLogData", "exceptionInfo：" + e3);
        }
        return jSONObject.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("");
        long j3 = this.f12162a;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        sb.append(simpleDateFormat.format(new Date(j3)));
        sb.append(",");
        String str = "[I]";
        switch (this.f12163b) {
            case 2:
                str = "[V]";
                break;
            case 3:
                str = "[D]";
                break;
            case 5:
                str = "[W]";
                break;
            case 6:
                str = "[E]";
                break;
            case 7:
                str = "[A]";
                break;
        }
        sb.append(str);
        sb.append(",");
        sb.append(this.f12164c);
        sb.append(",");
        sb.append(this.f12165d);
        sb.append(",");
        return sb.toString();
    }

    public C0413c(long j3, int i3, String str, String str2) {
        this.f12162a = j3;
        this.f12163b = i3;
        this.f12164c = str;
        this.f12165d = b(str2);
    }
}
