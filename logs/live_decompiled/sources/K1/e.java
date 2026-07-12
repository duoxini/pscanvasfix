package K1;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class e {
    public static JSONObject a(Map map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
            } catch (Exception e3) {
                f.b("CastUtil", new E1.h(e3));
            }
        }
        return jSONObject;
    }
}
