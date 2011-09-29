package org.beanstalk4j.http;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

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
public class URLBuilder {
	
	private final String host;
	private final String path;
	private final List<KeyValuePair> parameters;
	
	public URLBuilder(String host, String path) {
		this.host = host;
		this.path = path;
		this.parameters = new LinkedList<URLBuilder.KeyValuePair>();
	}
	
	public URLBuilder addParameter(KeyValuePair parameter) {
		parameters.add(parameter);
		return this;
	}
	
	public URLBuilder addParameter(String name, Object value) {
		return addParameter(new KeyValuePair(name, value));
	}
	
	public URI toURI() {
		StringBuilder sb = new StringBuilder();
		for (KeyValuePair pair : parameters) {
			sb.append(pair).append("&");
		}
		String query = sb.toString();
		if (!query.isEmpty()) {
			query = query.substring(0, query.length() - 1); // chop last &
		}
		
		URI uri = null;
		try {
			uri = new URI("https", null, host, -1, path, query, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		return uri;
	}
	
	public URL toURL() {
		try {
			return toURI().toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public class KeyValuePair {
		
		final String name;
		final Object value;
		
		public KeyValuePair(String name, Object value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public Object getValue() {
			return value;
		}
		
		public String toString() {
			return name + "=" + value;
		}
		
	}
	
}
