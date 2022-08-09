package API;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HttpUrlCon {
    static String accessKey = "77EF45C5918C2974";
    static String secretKey = "D9E0EDD69A877EF45C5918C297475F0D";

    public static void main(String[] args) throws Exception {
        String url = "https://dh99qhj4ry.apigw.ntruss.com/vpc-test/stage/test/filedown_url/pdf";


        urlConnect(url);
    }

    public static void urlConnect(String strUrl) throws Exception{
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        URL url = null;
        BufferedReader bufferedReader = null;
        url = new URL(strUrl);

        String method = "POST";
        String hdr_timestamp = timestamp +"";

        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestProperty("content-type","application/json; charset=utf-8");
        httpCon.setRequestProperty("hdr-timestamp",timestamp+"");
        httpCon.setRequestProperty("hdr-acckey",accessKey);
        httpCon.setRequestProperty("hdr_sign",encrypt(method + "^"+ url + "^" + hdr_timestamp + "^" + accessKey));
        httpCon.setRequestMethod("POST");
        httpCon.setReadTimeout(1000);
        httpCon.connect();
        bufferedReader = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF8"));

        String input = null;
        while((input = bufferedReader.readLine()) != null){
            System.out.println(input);
        }
        bufferedReader.close();
    }

    public static String encrypt(String str) throws GeneralSecurityException, UnsupportedEncodingException {

        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        String iv = secretKey.substring(0, 16);

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));

        byte[] encrypted = c.doFinal(str.getBytes(StandardCharsets.UTF_8));

        return new String(Base64.encodeBase64(encrypted));
    }
}
