package org.beanstalk4j;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beanstalk4j.exception.UpdateException;
import org.beanstalk4j.factory.ResourceFactory;
import org.beanstalk4j.http.HttpConnection;
import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Errors;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.User;

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
	
	public void updateAccount(String name, String timeZone) {
		URI uri = httpConnection.createURI("/api/account.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<account>");
		if (name != null) {
			sb.append("<name>").append(name).append("</name>");
		}
		if (timeZone != null) {
			sb.append("<time-zone>").append(timeZone).append("</time-zone>");
		}
		sb.append("</account>");
		
		InputStream in = httpConnection.doPut(uri, sb.toString());
		handleErrors(in);
	}
	
	/**
	 * Find all plans
	 * @return all plans
	 */
	public List<Plan> getPlans() {
		URI uri = httpConnection.createURI("/api/plans.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return resourceFactory.buildPlans(httpStream);
	}
	
	/**
	 * Find all users
	 * @return all users
	 */
	public List<User> getUsers() {
		URI uri = httpConnection.createURI("/api/users.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return resourceFactory.buildUsers(httpStream);
	}
	
	/**
	 * Find a single user
	 * @param userId
	 * @return single user
	 */
	public User getUser(Integer userId) {
		URI uri = httpConnection.createURI("/api/users/" + userId + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return resourceFactory.buildUser(httpStream);
	}
	
	/**
	 * Find user for current session
	 * @return currently logged in user
	 */
	public User getCurrentUser() {
		URI uri = httpConnection.createURI("/api/users/current.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return resourceFactory.buildUser(httpStream);
	}
	
	/**
	 * Releases resources.
	 */
	public void dispose() {
		httpConnection.close();
	}
	
	private void handleErrors(InputStream httpStream) {
		if (httpStream != null) {
			Errors errors = resourceFactory.buildError(httpStream);
			throw new UpdateException(errors);
		}
	}

}
