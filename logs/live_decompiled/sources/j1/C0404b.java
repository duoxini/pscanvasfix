package j1;

import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: j1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0404b implements InterfaceC0407e {
    @Override // j1.InterfaceC0407e
    public InterfaceC0405c a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new C0403a(httpURLConnection);
    }
}
