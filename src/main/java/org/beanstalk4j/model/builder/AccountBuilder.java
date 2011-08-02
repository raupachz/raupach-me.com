package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.Account;
import org.beanstalk4j.utils.IsoDateTimeFormat;
import org.beanstalk4j.xml.DOMUtils;
import org.w3c.dom.Element;

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
public class AccountBuilder {
	
	private final Account account;
	
	public AccountBuilder() {
		account = new Account();
	}
	
	public AccountBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element, "id"));
		ownerId(DOMUtils.getChildText(element, "owner-id"));
		planId(DOMUtils.getChildText(element, "plan-id"));
		name(DOMUtils.getChildText(element, "name"));
		thirdLevelDomain(DOMUtils.getChildText(element,"third-level-domain"));
		suspended(DOMUtils.getChildText(element, "suspended"));
		createdAt(DOMUtils.getChildText(element, "created-at"));
		updatedAt(DOMUtils.getChildText(element, "updated-at"));
	}
	
	public AccountBuilder id(Integer id) {
		account.setId(id);
		return this;
	}
	
	public AccountBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public AccountBuilder ownerId(Integer ownerId) {
		account.setOwnerId(ownerId);
		return this;
	}
	
	public AccountBuilder ownerId(String ownerId) {
		return ownerId(Integer.valueOf(ownerId));
	}
	
	public AccountBuilder planId(Integer planId) {
		account.setPlanId(planId);
		return this;
	}
	
	public AccountBuilder planId(String planId) {
		return planId(Integer.valueOf(planId));
	}
	
	public AccountBuilder name(String name) {
		account.setName(name);
		return this;
	}
	
	public AccountBuilder thirdLevelDomain(String thirdLevelDomain) {
		account.setThirdLevelDomain(thirdLevelDomain);
		return this;
	}
	
	public AccountBuilder suspended(Boolean suspended) {
		account.setSuspended(suspended);
		return this;
	}
	
	public AccountBuilder suspended(String suspended) {
		return suspended(Boolean.valueOf(suspended));
	}
	
	public AccountBuilder createdAt(Date createdAt) {
		account.setCreatedAt(createdAt);
		return this;
	}
	
	public AccountBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public AccountBuilder updatedAt(Date updatedAt) {
		account.setUpdatedAt(updatedAt);
		return this;
	}
	
	public AccountBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public Account build() {
		return account;
	}

}
