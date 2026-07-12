package m2;

import android.content.Context;
import android.util.Base64;
import com.customer.feedback.sdk.util.LogUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static RSAPublicKey f12454a;

    public static String a(Context context, String str) {
        try {
            if (f12454a == null) {
                InputStream open = context.getApplicationContext().getResources().getAssets().open("feedback_public_key.pem");
                try {
                    f12454a = d(b(open));
                    open.close();
                } catch (IOException unused) {
                    throw new IOException("公钥数据流读取错误");
                } catch (NullPointerException unused2) {
                    throw new IOException("公钥输入流为空");
                }
            }
            return c(str, f12454a);
        } catch (Exception e3) {
            LogUtil.e("RsaUtil", "exceptionInfo：" + e3);
            return "";
        }
    }

    public static String b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            if (readLine.charAt(0) != '-') {
                sb.append(readLine);
                sb.append('\r');
            }
        }
    }

    public static String c(String str, PublicKey publicKey) {
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(1, publicKey);
        int length = str.getBytes().length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = length - i3;
            if (i5 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
            byte[] doFinal = i5 > 117 ? cipher.doFinal(str.getBytes(), i3, 117) : cipher.doFinal(str.getBytes(), i3, i5);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i4++;
            i3 = i4 * 117;
        }
    }

    public static RSAPublicKey d(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new IOException("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new IOException("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new IOException("公钥非法");
        }
    }
}
