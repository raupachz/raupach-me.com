package org.beanstalk4j;

import java.io.InputStream;
import java.net.URI;

import org.beanstalk4j.factory.ResourceFactory;
import org.beanstalk4j.http.HttpConnection;
import org.beanstalk4j.model.Account;

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
public class BeanstalkApi {
	
	private final HttpConnection httpConnection;
	private final ResourceFactory resourceFactory;
	
	public BeanstalkApi(String accountName, String username, String password) {
		this.httpConnection = new HttpConnection(accountName, username, password).openConnection();
		this.resourceFactory = new ResourceFactory();
	}
	
	/**
	 * Get your account details
	 * @return account details
	 */
	public Account getAccount() {
		URI uri = httpConnection.createURI("/api/account.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return resourceFactory.buildAccount(httpStream);
	}
	
	/**
	 * Releases resources.
	 */
	public void dispose() {
		httpConnection.close();
	}

}
