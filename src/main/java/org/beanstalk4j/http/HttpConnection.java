package org.beanstalk4j.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

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
public class HttpConnection {
	
	private final String host;
	private final String username;
	private final String password;
	private boolean connected;
	private DefaultHttpClient httpclient;
	
	public HttpConnection(String accountName, String username, String password) {
		this.host = accountName + ".beanstalkapp.com";
		this.username = username;
		this.password = password;
	}
	
	public HttpConnection openConnection() {
		if (isConnected()) {
			throw new IllegalStateException("HttpConnection is already open.");
		} else {
			httpclient = new DefaultHttpClient();
			AuthScope authScope = new AuthScope(host, 443);
			Credentials credentials = new UsernamePasswordCredentials(username, password);
			httpclient.getCredentialsProvider().setCredentials(authScope, credentials);
			connected = true;
		}
		return this;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void close() {
		if (httpclient != null) {
			httpclient.getConnectionManager().shutdown();
			connected = false;
		}
	}
	
	public URI createURI(String path) {
		URI uri = null;
		try {
			uri = URIUtils.createURI("https", host, -1, path, null, null);
		} catch (URISyntaxException e) {
			onCaughtException(e);
		}
		return uri;
	}
	
	public InputStream doGet(URI uri) {
		HttpGet httpget = new HttpGet(uri);
		return doMethod(httpget, false);
	}
	
	public void doPost(URI uri, String request) {
		try {
			StringEntity entity = new StringEntity(request, "UTF-8");
			HttpPost httppost = new HttpPost(uri);
			httppost.setEntity(entity);
			doMethod(httppost);
		} catch (UnsupportedEncodingException e) {
			onCaughtException(e);
		} 
	}
	
	public void doPost(URI uri) {
		HttpPost httppost = new HttpPost(uri);
		doMethod(httppost);
	}
	
	public InputStream doPut(URI uri, String request) {
		InputStream in = null;
		try {
			StringEntity entity = new StringEntity(request, "UTF-8");
			HttpPut httpput = new HttpPut(uri);
			httpput.setEntity(entity);
			in =  doMethod(httpput, false);
		} catch (UnsupportedEncodingException e) {
			onCaughtException(e);
		}
		return in;
	}
	
	public InputStream doPut(URI uri) {
		HttpPut httpput = new HttpPut(uri);
		return doMethod(httpput, false);
	}
	
	public void doDelete(URI uri) {
		HttpDelete httpdelete = new HttpDelete(uri);
		doMethod(httpdelete);
	}
	
	public void doMethod(HttpUriRequest request) {
		doMethod(request,true);
	}
	
	public InputStream doMethod(HttpUriRequest request, boolean closeResponse) {
		appendHttpHeader(request);
		InputStream httpStream = null;
		try {
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				httpStream  = entity.getContent();
				if (closeResponse) {
					httpStream.close();
				}
			}
			if (hasInvalidStatusCode(response)) {
				raiseIllegalState(response);
			}
		} catch (IOException e) {
			onCaughtException(e);
		}
		return httpStream;
	}
	
	public void appendHttpHeader(HttpUriRequest request) {
		request.addHeader("Accept", "application/xml");
		request.addHeader("Content-Type", "application/xml");
	}
	
	private void onCaughtException(Exception e) {
		throw new RuntimeException(e);
	}
	
	private boolean hasInvalidStatusCode(HttpResponse response) {
		StatusLine statusLine = response.getStatusLine();
		return statusLine.getStatusCode() != HttpStatus.SC_OK;
	}
	
	private void raiseIllegalState(HttpResponse response) {
		StatusLine statusLine = response.getStatusLine();
		throw new IllegalStateException(statusLine.getStatusCode() + " - " + statusLine.getReasonPhrase());
	}

}
