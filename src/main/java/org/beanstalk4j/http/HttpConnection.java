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

	public InputStream doGet(URL url) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestProperty("Authorization", "Basic "+ credentials);
			return con.getInputStream();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public InputStream doPost(URL url, String request) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestProperty("Authorization", "Basic "+ credentials);
			OutputStream os = con.getOutputStream();
			os.write(request.getBytes());
			return con.getInputStream();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void doPost(URL url) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(false);
			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestProperty("Authorization", "Basic "+ credentials);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public InputStream doPut(URL url, String request) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestProperty("Authorization", "Basic "+ credentials);
			OutputStream os = con.getOutputStream();
			os.write(request.getBytes());
			return con.getInputStream();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public InputStream doPut(URL url) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setDoOutput(false);
			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestProperty("Authorization", "Basic "+ credentials);
			return con.getInputStream();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void doDelete(URL url) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");
			con.setDoOutput(false);
			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestProperty("Authorization", "Basic "+ credentials);
			int responseCode = con.getResponseCode();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
