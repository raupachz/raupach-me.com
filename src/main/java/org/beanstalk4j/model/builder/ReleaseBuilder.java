package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.Release;
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
public class ReleaseBuilder {
	
	private final Release release;
	
	public ReleaseBuilder() {
		this.release = new Release();
	}
	
	public ReleaseBuilder(Element element) {
		this();
		accountId(DOMUtils.getChildText(element,"account-id"));
		author(DOMUtils.getChildText(element,"author"));
		comment(DOMUtils.getChildText(element,"comment"));
		createdAt(DOMUtils.getChildText(element,"created-at"));
		deployedAt(DOMUtils.getChildText(element,"deployed-at"));
		environmentId(DOMUtils.getChildText(element,"environment-id"));
		environmentName(DOMUtils.getChildText(element,"enviornment-name"));
		id(DOMUtils.getChildText(element,"id"));
		lastRetryAt(DOMUtils.getChildText(element,"last-retry-at"));
		repositoryId(DOMUtils.getChildText(element,"repository-id"));
		retries(DOMUtils.getChildText(element,"retries"));
		revision(DOMUtils.getChildText(element,"revision"));
		state(DOMUtils.getChildText(element,"state"));
		updatedAt(DOMUtils.getChildText(element,"updated-at"));
		userId(DOMUtils.getChildText(element,"user-id"));
	}
	
	public ReleaseBuilder accountId(Integer accountId) {
		release.setAccountId(accountId);
		return this;
	}
	
	public ReleaseBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public ReleaseBuilder author(String author) {
		release.setAuthor(author);
		return this;
	}
	
	public ReleaseBuilder comment(String comment) {
		release.setComment(comment);
		return this;
	}
	
	public ReleaseBuilder createdAt(Date createdAt) {
		release.setCreatedAt(createdAt);
		return this;
	}
	
	public ReleaseBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public ReleaseBuilder deployedAt(Date deployedAt) {
		release.setDeployedAt(deployedAt);
		return this;
	}
	
	public ReleaseBuilder deployedAt(String deployedAt) {
		return deployedAt(IsoDateTimeFormat.parse(deployedAt));
	}
	
	public ReleaseBuilder environmentId(String environmentId) {
		release.setEnvironmentId(environmentId);
		return this;
	}
	
	public ReleaseBuilder environmentName(String environmentName) {
		release.setEnvironmentName(environmentName);
		return this;
	}
	
	public ReleaseBuilder id(Integer id) {
		release.setId(id);
		return this;
	}
	
	public ReleaseBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public ReleaseBuilder lastRetryAt(Date lastRetryAt) {
		release.setLastRetryAt(lastRetryAt);
		return this;
	}
	
	public ReleaseBuilder lastRetryAt(String lastRetryAt) {
		return lastRetryAt(IsoDateTimeFormat.parse(lastRetryAt));
	}
	
	public ReleaseBuilder repositoryId(Integer repositoryId) {
		release.setRepositoryId(repositoryId);
		return this;
	}
	
	public ReleaseBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public ReleaseBuilder retries(Integer retries) {
		release.setRetries(retries);
		return this;
	}
	
	public ReleaseBuilder retries(String retries) {
		return retries(Integer.valueOf(retries));
	}
	
	public ReleaseBuilder revision(Integer revision) {
		release.setRevision(revision);
		return this;
	}
	
	public ReleaseBuilder revision(String revision) {
		return revision(Integer.valueOf(revision));
	}
	
	public ReleaseBuilder state(String state) {
		release.setState(state);
		return this;
	}
	
	public ReleaseBuilder updatedAt(Date updatedAt) {
		release.setUpdatedAt(updatedAt);
		return this;
	}
	
	public ReleaseBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public ReleaseBuilder userId(Integer userId) {
		release.setUserId(userId);
		return this;
	}
	
	public ReleaseBuilder userId(String userId) {
		return userId(Integer.valueOf(userId));
	}
	
	public Release build() {
		return release;
	}

}
