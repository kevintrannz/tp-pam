package com.myspace.testsi;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;

public class AlertSender implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    static public int Send(String payload) {
        try {
            String url_post = "https://sis-development.ap-southeast-2.elasticbeanstalk.com/api/alerts/create-alert-post";
            URL obj = new URL(url_post);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("x-requested-with", "XMLHttpRequest");

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(payload);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            return responseCode;
        } catch (Exception e) {
            return 0;
        }
    }
    public AlertSender() {}
}
