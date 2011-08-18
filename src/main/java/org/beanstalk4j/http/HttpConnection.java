package org.beanstalk4j.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.beanstalk4j.utils.Base64Coder;

public class HttpConnection  {

	private final String host;
	private final String credentials;

	public HttpConnection(String accountName, String username, String password) {
		this.host = accountName + ".beanstalkapp.com";
		this.credentials = Base64Coder.encodeString(username + ":" + password);
	}

	public URL createURL(String path) {
		try {
			return new URL("https", host, path);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public InputStream doPost(URL url, String request) {
		return doMethod(url, "POST", request);
	}

	public void doPut(URL url, String request) {
		doMethod(url, "PUT", request);
	}

	public InputStream doGet(URL url) {
		return doMethod(url, "GET", null);
	}
	
	public void doDelete(URL url) {
		doMethod(url, "DELETE", null);
	}
	
	public InputStream doMethod(URL url, String method, String messageBody) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("Authorization", "Basic " + credentials);
			con.setRequestProperty("Content-Type", "application/xml;charset=utf-8");
			if (messageBody != null) {
				con.setDoOutput(true);
				byte[] body = messageBody.getBytes("utf-8");
				con.setRequestProperty("Content-Length", String.valueOf(body.length));
				OutputStream os = con.getOutputStream();
				os.write(body);
			}
			int responseCode = con.getResponseCode();
			if (method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("DELETE")) {
				return null;
			} else {
				return con.getInputStream();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
