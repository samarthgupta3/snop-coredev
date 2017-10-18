package com.smartNodeProtocol.auth.fb;

import javax.servlet.ServletOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Samarth on 18-08-2017.
 */
public class SimpleAccess {

    static String url = "http://google.com";
    static String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
    static String param1 = "value1";
    static String param2 = "value2";

    public static void main(String[] args){
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void connect() throws IOException {
        //CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        String query = String.format("param1=%s&param2=%s",URLEncoder.encode(param1, charset),
        URLEncoder.encode(param2, charset));
        FBConnection fbConnection = new FBConnection();

        URLConnection connection = new URL(fbConnection.getFBAuthUrl()).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
        InputStream response = connection.getInputStream();
        /*try (Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
        }*/
        connection.connect();
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        int status =  httpConnection.getResponseCode();
        String code = httpConnection.getResponseMessage();
        //code = httpConnection.getParameter("code");
        if (code == null || code.equals("")) {
            throw new RuntimeException(
                    "ERROR: Didn't get code parameter in callback.");
        }
        fbConnection = new FBConnection();
        String accessToken = fbConnection.getAccessToken(code);

        FBGraph fbGraph = new FBGraph(accessToken);
        String graph = fbGraph.getFBGraph();
        Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
        System.out.println(fbProfileData.get("first_name"));
        System.out.println(fbProfileData.get("email"));
        String contentType = connection.getHeaderField("Content-Type");
        String charset = null;

        for (String param : contentType.replace(" ", "").split(";")) {
            if (param.startsWith("charset=")) {
                charset = param.split("=", 2)[1];
                break;
            }
        }

        if (charset != null) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset));
                for (String line; (line = reader.readLine()) != null;) {
                    System.out.println(line);
                }
            }catch (Exception e){

            }
        } else {
            // It's likely binary content, use InputStream/OutputStream.
        }
        //second call
        /*for (String cookie : cookies) {
            connection.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
        }*/

    }
}
