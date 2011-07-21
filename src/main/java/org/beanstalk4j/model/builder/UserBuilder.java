package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.User;
import org.beanstalk4j.utils.IsoDateTimeFormat;
import org.jdom.Element;


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
public class UserBuilder {
	
	private final User user;
	
	public UserBuilder() {
		user = new User();
	}
	
	public UserBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		accountId(element.getChildText("account-id"));
		admin(element.getChildText("admin"));
		owner(element.getChildText("owner"));
		firstName(element.getChildText("first-name"));
		lastName(element.getChildText("last-name"));
		email(element.getChildText("email"));
		login(element.getChildText("login"));
		timeZone(element.getChildText("timezone"));
		createdAt(element.getChildText("created-at"));
		updatedAt(element.getChildText("updated-at"));
	}
	
	public UserBuilder id(Integer id) {
		user.setId(id);
		return this;
	}
	
	public UserBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public UserBuilder accountId(Integer accountId) {
		user.setAccountId(accountId);
		return this;
	}
	
	public UserBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public UserBuilder owner(Boolean owner) {
		user.setOwner(owner);
		return this;
	}
	
	public UserBuilder owner(String owner) {
		return owner(Boolean.valueOf(owner));
	}
	
	public UserBuilder admin(Boolean admin) {
		user.setAdmin(admin);
		return this;
	}
	
	public UserBuilder admin(String admin) {
		return admin(Boolean.valueOf(admin));
	}
	
	public UserBuilder firstName(String firstName) {
		user.setFirstName(firstName);
		return this;
	}
	
	public UserBuilder lastName(String lastName) {
		user.setLastName(lastName);
		return this;
	}
	
	public UserBuilder email(String email) {
		user.setEmail(email);
		return this;
	}
	
	public UserBuilder login(String login) {
		user.setLogin(login);
		return this;
	}
	
	public UserBuilder timeZone(String timeZone) {
		user.setTimeZone(timeZone);
		return this;
	}
	
	public UserBuilder createdAt(Date createdAt) {
		user.setCreatedAt(createdAt);
		return this;
	}
	
	public UserBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public UserBuilder updatedAt(Date updatedAt) {
		user.setUpdatedAt(updatedAt);
		return this;
	}
	
	public UserBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public User build() {
		return user;
	}

}
