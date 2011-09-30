package org.beanstalk4j.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.beanstalk4j.utils.Base64Coder;
import org.beanstalk4j.xml.XMLFormatter;

/*
 * Copyright 2011 Björn Raupach

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
public class HttpConnection  {
	
	private static Logger logger = Logger.getLogger("org.beanstalk4j");
	
	private final String credentials;

	public HttpConnection(String username, String password) {
		this.credentials = Base64Coder.encodeString(username + ":" + password);
	}

	public InputStream doGet(URL url) {
		return doMethod(url, "GET", null);
	}

	public InputStream doPost(URL url, String request) {
		return doMethod(url, "POST", request);
	}

	public void doPut(URL url, String request) {
		doMethod(url, "PUT", request);
	}
	
	public void doDelete(URL url) {
		doMethod(url, "DELETE", null);
	}
	
	public InputStream doMethod(URL url, String method, String messageBody) {
		if (logger.isLoggable(Level.FINE)) {
			logger.fine(">> HTTP " + method + " " + url);
			if (messageBody != null) {
				String prettyMessageBody = XMLFormatter.prettyFormat(messageBody);
				for (String line : prettyMessageBody.split("\\n")) {
					logger.fine(">> HTTP " + line);
				}
			}
		}
		
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
			if (logger.isLoggable(Level.FINE)) {
				logger.fine("<< HTTP Status-Code " + responseCode);
			}
			if (!(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED)) {
				ByteBuffer buffer = new ByteBuffer(con.getErrorStream());
				if (logger.isLoggable(Level.FINE)) {
					String response = new String(buffer.getByteArray(), "utf-8");
					String prettyMessageBody = XMLFormatter.prettyFormat(response);
					for (String line : prettyMessageBody.split("\\n")) {
						logger.fine("<< HTTP " + line);
					}
				}
				return null;
			}
			if (method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("DELETE")) {
				return null;
			} else {
				ByteBuffer buffer = new ByteBuffer(con.getInputStream());
				if (logger.isLoggable(Level.FINE)) {
					String response = new String(buffer.getByteArray(), "utf-8");
					String prettyMessageBody = XMLFormatter.prettyFormat(response);
					for (String line : prettyMessageBody.split("\\n")) {
						logger.fine("<< HTTP " + line);
					}
				}
				return buffer.getInputStream();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
