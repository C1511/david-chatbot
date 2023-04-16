package com.hehan.ai.chatbot.api.zsxq;


import javax.net.ssl.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsTest {

    private static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static String sendHttps(String url) throws Exception {
        InputStream in = null;
        OutputStream out = null;
        String returnValue = "";
        try {
//            SSLContext sc1 = SSLContext.getInstance("SSL");
//            System.out.println("-------------------------------sc1："+sc1);
//            System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
//            System.setProperty("https.protocols", "TLSv1.2");
//            SSLContext sc2 = SSLContext.getInstance("TLS", "SunJSSE");
//            System.out.println("------------------------------sc1："+sc2);
//            System.setProperty("https.proxyHost", "127.0.0.1");
//            System.setProperty("https.proxyPort", "7890");
//            SSLContext sc = SSLContext.getInstance("TLS");
            SSLContext sc = SSLContext.getInstance("TLSv1");
            TrustManager[] trustManagers = new TrustManager[]{new TrustAnyTrustManager()};
//            sc.init(null, trustManagers, new java.security.SecureRandom());
            sc.init(null, trustManagers, null);
            String[] cipherSuites = {
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
                    "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
                    "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256"
            };
            SSLSocketFactory socketFactory = sc.getSocketFactory();
            SSLParameters parameters = new SSLParameters(cipherSuites);
//            HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);
            URL console = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(socketFactory);
//            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.setRequestMethod("POST");
            conn.connect();
            InputStream is = conn.getInputStream();
            DataInputStream indata = new DataInputStream(is);
            returnValue = indata.readLine();
            conn.disconnect();
        } catch (ConnectException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
            try {
                out.close();
            } catch (Exception e) {
            }
        }
        return returnValue;
    }
}
