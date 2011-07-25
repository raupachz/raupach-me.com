package org.beanstalk4j.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Errors;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.PublicKey;
import org.beanstalk4j.model.User;
import org.beanstalk4j.model.builder.AccountBuilder;
import org.beanstalk4j.model.builder.ErrorsBuilder;
import org.beanstalk4j.model.builder.PlanBuilder;
import org.beanstalk4j.model.builder.PublicKeyBuilder;
import org.beanstalk4j.model.builder.UserBuilder;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

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
public class ResourceFactory {
	
	private final SAXBuilder saxBuilder;
	
	public ResourceFactory() {
		this.saxBuilder = new SAXBuilder();
	}

	Document buildDocument(InputStream in) {
		Document document = null;
		try {
			document = saxBuilder.build(in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return document;
	}
	
	public Errors buildError(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element errors = document.getRootElement();
		return new ErrorsBuilder(errors).build();
	}

	public Account buildAccount(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		return new AccountBuilder(account).build();
	}

	public List<Plan> buildPlans(InputStream httpStream) {
		List<Plan> resultList = new ArrayList<Plan>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Plan plan = new PlanBuilder(e).build();
			resultList.add(plan);
		}
		return resultList;
	}

	public List<User> buildUsers(InputStream httpStream) {
		List<User> resultList = new ArrayList<User>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			User user = new UserBuilder(e).build();
			resultList.add(user);
		}
		return resultList;
	}

	public User buildUser(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		return new UserBuilder(account).build();
	}

	public List<PublicKey> buildPublicKeys(InputStream httpStream) {
		List<PublicKey> resultList = new ArrayList<PublicKey>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			PublicKey publicKey = new PublicKeyBuilder(e).build();
			resultList.add(publicKey);
		}
		return resultList;
	}

	public PublicKey buildPublicKey(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		return new PublicKeyBuilder(account).build();
	}
	

}
