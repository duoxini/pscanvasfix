package j1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import m1.AbstractC0462e;

/* renamed from: j1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0403a implements InterfaceC0405c {

    /* renamed from: e, reason: collision with root package name */
    private final HttpURLConnection f12150e;

    public C0403a(HttpURLConnection httpURLConnection) {
        this.f12150e = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // j1.InterfaceC0405c
    public String M() {
        return this.f12150e.getContentType();
    }

    @Override // j1.InterfaceC0405c
    public String R() {
        try {
            if (V()) {
                return null;
            }
            return "Unable to fetch " + this.f12150e.getURL() + ". Failed with " + this.f12150e.getResponseCode() + "\n" + a(this.f12150e);
        } catch (IOException e3) {
            AbstractC0462e.d("get error failed ", e3);
            return e3.getMessage();
        }
    }

    @Override // j1.InterfaceC0405c
    public boolean V() {
        try {
            return this.f12150e.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12150e.disconnect();
    }

    @Override // j1.InterfaceC0405c
    public InputStream h() {
        return this.f12150e.getInputStream();
    }
}
