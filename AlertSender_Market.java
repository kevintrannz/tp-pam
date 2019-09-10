package com.myspace.testsi;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;

public class AlertSender_Market implements java.io.Serializable {
	static final long serialVersionUID = 1L;
	static public int Send(String market_alert) {
		try {
			String url_post = "https://webhook.site/5c2ba7f9-8776-42b7-8997-8679a54ebc63";
			URL obj = new URL(url_post);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-requested-with", "XMLHttpRequest");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(market_alert);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			return responseCode;
		} catch (Exception e) {
			return 0;
		}
	}
	public AlertSender_Market() {
	}
}
