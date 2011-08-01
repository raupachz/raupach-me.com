package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.Release;
import org.beanstalk4j.utils.IsoDateTimeFormat;
import org.jdom.Element;

public class ReleaseBuilder {
	
	private final Release release;
	
	public ReleaseBuilder() {
		this.release = new Release();
	}
	
	public ReleaseBuilder(Element element) {
		this();
		accountId(element.getChildText("account-id"));
		author(element.getChildText("author"));
		comment(element.getChildText("comment"));
		createdAt(element.getChildText("created-at"));
		deployedAt(element.getChildText("deployed-at"));
		environmentId(element.getChildText("environment-id"));
		environmentName(element.getChildText("enviornment-name"));
		id(element.getChildText("id"));
		lastRetryAt(element.getChildText("last-retry-at"));
		repositoryId(element.getChildText("repository-id"));
		retries(element.getChildText("retries"));
		revision(element.getChildText("revision"));
		state(element.getChildText("state"));
		updatedAt(element.getChildText("updated-at"));
		userId(element.getChildText("user-id"));
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

}
