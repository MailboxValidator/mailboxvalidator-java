package com.mailboxvalidator;

import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SingleValidation {
	private String api_key = "";
	private static final String api_url = "http://api.mailboxvalidator.com/v1/validation/single";
	private static final Pattern jsonpattern = Pattern.compile("(\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\"|[0-9\\.\\-]+)", Pattern.CASE_INSENSITIVE);
	
	public SingleValidation(String apikey) {
		api_key = apikey;
	}
	
/**
* This function to validate an email address using the MailboxValidator API
* @param EmailAddress The email address to validate.
* @return MailboxValidator API results
*/
	public MBVResult ValidateEmail(String EmailAddress) throws IOException {
		MBVResult record = new MBVResult(EmailAddress);
		
		try {
			Hashtable<String, String> data = new Hashtable<String, String>();
			data.put("format", "json");
			data.put("email", EmailAddress);
			data.put("key", api_key);
			
			String datastr = "";
			for (Map.Entry<String,String> entry : data.entrySet()) {
				datastr += "&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
			}
			datastr = datastr.substring(1);
			URL url = new URL(api_url + "?" + datastr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Error connecting to API.");
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String output;
			String output2 = "";
			while ((output = br.readLine()) != null) {
				output2 = output2 + output;
			}
			conn.disconnect();
			
			List<String> allMatches = new ArrayList<String>();
			Matcher m = jsonpattern.matcher(output2);
			while (m.find()) {
				allMatches.add(m.group());
			}
			
			int x = 0;
			int max = allMatches.size();
			
			String v1 = "";
			String v2 = "";
			for (x = 0; x < max; x = x + 2) {
				v1 = allMatches.get(x).substring(1);
				v1 = v1.substring(0, v1.length() - 1);
				v2 = allMatches.get(x + 1);
				
				if (!v1.equals("credits_available")) {
					v2 = v2.substring(1);
					v2 = v2.substring(0, v2.length() - 1);
				}
				
				switch (v1) {
					case "email_address":
						record.email_address = v2;
						break;
					case "domain":
						record.domain = v2;
						break;
					case "is_free":
						record.is_free = v2;
						break;
					case "is_syntax":
						record.is_syntax = v2;
						break;
					case "is_domain":
						record.is_domain = v2;
						break;
					case "is_smtp":
						record.is_smtp = v2;
						break;
					case "is_verified":
						record.is_verified = v2;
						break;
					case "is_server_down":
						record.is_server_down = v2;
						break;
					case "is_greylisted":
						record.is_greylisted = v2;
						break;
					case "is_disposable":
						record.is_disposable = v2;
						break;
					case "is_suppressed":
						record.is_suppressed = v2;
						break;
					case "is_role":
						record.is_role = v2;
						break;
					case "is_high_risk":
						record.is_high_risk = v2;
						break;
					case "is_catchall":
						record.is_catchall = v2;
						break;
					case "mailboxvalidator_score":
						record.mailboxvalidator_score = (v2.length() > 0) ? Float.parseFloat(v2) : (float)0.0;
						break;
					case "time_taken":
						record.time_taken = Float.parseFloat(v2);
						break;
					case "status":
						record.status = v2;
						break;
					case "credits_available":
						v2 = v2.replaceAll("\"", "");
						record.credits_available = (v2.length() > 0) ? Integer.parseInt(v2) : 0;
						break;
					case "error_code":
						record.error_code = v2;
						break;
					case "error_message":
						record.error_message = v2;
						break;
					default:
						break;
				}
			}
			return record;
		}
		catch (MalformedURLException ex) {
			throw ex;
		}
		catch (IOException ex) {
			throw ex;
		}
		finally {
		}
	}
}
