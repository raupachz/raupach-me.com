package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.PublicKey;
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
public class PublicKeyBuilder {
	
	private final PublicKey publicKey;
	
	public PublicKeyBuilder() {
		publicKey = new PublicKey();
	}
	
	public PublicKeyBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		accountId(element.getChildText("account-id"));
		userId(element.getChildText("user-id"));
		name(element.getChildText("name"));
		content(element.getChildText("content"));
		createdAt(element.getChildText("created-at"));
		updatedAt(element.getChildText("updated-at"));
	}
	
	public PublicKeyBuilder id(Integer id) {
		publicKey.setId(id);
		return this;
	}
	
	public PublicKeyBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public PublicKeyBuilder accountId(Integer accountId) {
		publicKey.setAccountId(accountId);
		return this;
	}
	
	public PublicKeyBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public PublicKeyBuilder userId(Integer userId) {
		publicKey.setUserId(userId);
		return this;
	}
	
	public PublicKeyBuilder userId(String userId) {
		return userId(Integer.valueOf(userId));
	}
	
	public PublicKeyBuilder name(String name) {
		publicKey.setName(name);
		return this;
	}
	
	public PublicKeyBuilder content(String content) {
		publicKey.setContent(content);
		return this;
	}
	
	public PublicKeyBuilder createdAt(Date createdAt) {
		publicKey.setCreatedAt(createdAt);
		return this;
	}
	
	public PublicKeyBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public PublicKeyBuilder updatedAt(Date updatedAt) {
		publicKey.setUpdatedAt(updatedAt);
		return this;
	}
	
	public PublicKeyBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public PublicKey build() {
		return publicKey;
	}
	
}
