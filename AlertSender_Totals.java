package com.myspace.testsi;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;
import java.util.Date;

public class AlertSender_Totals implements java.io.Serializable {
	static final long serialVersionUID = 1L;
	static public int Send(double nimwc, double simwc) {
		try {
			String url_post = "https://wwnugqd20j.execute-api.ap-southeast-2.amazonaws.com/dev/analytics";
			URL obj = new URL(url_post);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			//con.setRequestProperty("x-requested-with", "XMLHttpRequest");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes("{\"nimwc\":\"" + nimwc + "\",\"simwc\":\"" + simwc + "\"}");
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			return responseCode;
		} catch (Exception e) {
			return 0;
		}
	}
	public AlertSender_Totals() {
	}
}
