package API;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class OpenStram {

    public static void main(String ar[]) throws Exception {
        String url = "https://dh99qhj4ry.apigw.ntruss.com/vpc-api/stage/checkConnAwsDb";
        JSONObject json = readJsonFromUrl(url);

        System.out.println(json.toString());

    }

    private static String jsonReadAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();

        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = jsonReadAll(br);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}