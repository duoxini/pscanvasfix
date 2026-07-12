package m2;

import android.text.TextUtils;
import com.customer.feedback.sdk.FeedbackHelper;
import com.customer.feedback.sdk.feedbacka;
import com.customer.feedback.sdk.model.RequestData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import p2.q;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f12452a = new h();

    public static final class a extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f12453e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject) {
            super(1);
            this.f12453e = jSONObject;
        }

        @Override // C2.l
        public final Object f(Object obj) {
            D2.k.e((h) obj, "$this$ktxRunOnUi");
            FeedbackHelper.RequestMadeCallback requestMadeCallback = feedbacka.f9391f;
            if (requestMadeCallback != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = this.f12453e.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = this.f12453e.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        RequestData.Companion companion = RequestData.Companion;
                        D2.k.d(next, "key");
                        D2.k.d(optString, "value");
                        RequestData fromString = companion.fromString(next, optString);
                        if (fromString != null) {
                            arrayList.add(fromString);
                        }
                    }
                }
                requestMadeCallback.onRequestMade(arrayList);
            }
            return q.f12810a;
        }
    }

    public static final void a(JSONObject jSONObject) {
        D2.k.e(jSONObject, "jsonObject");
        k.b(new a(jSONObject), f12452a);
    }
}
