package m2;

import android.os.Bundle;
import android.os.olc.OlcManager;
import com.customer.feedback.sdk.util.LogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import p2.C0511k;
import p2.q;

/* loaded from: classes.dex */
public abstract class g {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean a() {
        /*
            java.lang.String r0 = "LogKitUtil"
            r1 = 0
            p2.k$a r2 = p2.C0511k.f12803f     // Catch: java.lang.Throwable -> L11
            int r2 = com.oplus.os.OplusBuild.VERSION.SDK_VERSION     // Catch: java.lang.Throwable -> L11
            r3 = 33
            if (r2 >= r3) goto L14
            java.lang.String r2 = "canSendToLogKit: isBelow 14.1"
            com.customer.feedback.sdk.util.LogUtil.d(r0, r2)     // Catch: java.lang.Throwable -> L11
            return r1
        L11:
            r2 = move-exception
            r3 = r1
            goto L2d
        L14:
            boolean r2 = m2.AbstractC0468c.k()     // Catch: java.lang.Throwable -> L11
            if (r2 == 0) goto L20
            java.lang.String r2 = "canSendToLogKit: isExpVersion"
            com.customer.feedback.sdk.util.LogUtil.d(r0, r2)     // Catch: java.lang.Throwable -> L11
            return r1
        L20:
            boolean r2 = com.customer.feedback.sdk.feedbacka.f9388c     // Catch: java.lang.Throwable -> L11
            p2.q r3 = p2.q.f12810a     // Catch: java.lang.Throwable -> L29
            java.lang.Object r3 = p2.C0511k.b(r3)     // Catch: java.lang.Throwable -> L29
            goto L3a
        L29:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L2d:
            p2.k$a r4 = p2.C0511k.f12803f
            java.lang.Object r2 = p2.l.a(r2)
            java.lang.Object r2 = p2.C0511k.b(r2)
            r5 = r3
            r3 = r2
            r2 = r5
        L3a:
            java.lang.Throwable r3 = p2.C0511k.d(r3)
            if (r3 == 0) goto L56
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "sendEvent error:"
            r2.<init>(r4)
            java.lang.String r3 = r3.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.customer.feedback.sdk.util.LogUtil.e(r0, r2)
            goto L57
        L56:
            r1 = r2
        L57:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "canSendToLogKit: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.customer.feedback.sdk.util.LogUtil.d(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.g.a():boolean");
    }

    private static final void b(Bundle bundle) {
        Object b3;
        try {
            C0511k.a aVar = C0511k.f12803f;
            LogUtil.d("LogKitUtil", "sendEvent result:" + OlcManager.sendEvent(bundle));
            b3 = C0511k.b(q.f12810a);
        } catch (Throwable th) {
            C0511k.a aVar2 = C0511k.f12803f;
            b3 = C0511k.b(p2.l.a(th));
        }
        Throwable d3 = C0511k.d(b3);
        if (d3 != null) {
            LogUtil.e("LogKitUtil", "sendEvent error:" + d3.getMessage());
        }
    }

    public static final void c(String str) {
        Object b3;
        boolean z3 = true;
        if (!a()) {
            LogUtil.d("LogKitUtil", "Not SupportLogKit");
            return;
        }
        if (str != null) {
            try {
                C0511k.a aVar = C0511k.f12803f;
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle = new Bundle();
                bundle.putString("eventName", "collectLitLog");
                String optString = jSONObject.optString("fid");
                StringBuilder sb = new StringBuilder("feedbackId: ");
                D2.k.d(optString, "feedbackId");
                sb.append(optString.length() > 0);
                LogUtil.d("LogKitUtil", sb.toString());
                if (optString.length() > 0) {
                    bundle.putString("feedbackId", optString);
                }
                String optString2 = jSONObject.optString("errorType");
                StringBuilder sb2 = new StringBuilder("errorType: ");
                D2.k.d(optString2, "errorType");
                sb2.append(optString2.length() > 0);
                LogUtil.d("LogKitUtil", sb2.toString());
                if (optString2.length() > 0) {
                    bundle.putString("errorTypeStr", optString2);
                }
                String optString3 = jSONObject.optString("description");
                StringBuilder sb3 = new StringBuilder("description: ");
                D2.k.d(optString3, "description");
                sb3.append(optString3.length() > 0);
                LogUtil.d("LogKitUtil", sb3.toString());
                if (optString3.length() > 0) {
                    bundle.putString("description", optString3);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("attachmentList");
                if (optJSONArray != null) {
                    D2.k.d(optJSONArray, "attachmentList");
                    ArrayList<String> arrayList = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList.add(optJSONArray.optString(i3));
                    }
                    LogUtil.d("LogKitUtil", "attachments: " + arrayList.size());
                    bundle.putStringArrayList("attachmentList", arrayList);
                }
                String optString4 = jSONObject.optString("contactInfo");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("contactInfo: ");
                D2.k.d(optString4, "contactInfo");
                if (optString4.length() <= 0) {
                    z3 = false;
                }
                sb4.append(z3);
                LogUtil.d("LogKitUtil", sb4.toString());
                if (optString4.length() > 0) {
                    bundle.putString("contactInfo", optString4);
                }
                b(bundle);
                b3 = C0511k.b(q.f12810a);
            } catch (Throwable th) {
                C0511k.a aVar2 = C0511k.f12803f;
                b3 = C0511k.b(p2.l.a(th));
            }
            Throwable d3 = C0511k.d(b3);
            if (d3 != null) {
                LogUtil.e("LogKitUtil", "sendLog error:" + d3.getMessage());
            }
            C0511k.a(b3);
        }
    }
}
