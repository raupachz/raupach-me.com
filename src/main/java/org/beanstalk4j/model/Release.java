package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

public class Release implements Serializable {
	
	private Integer accountId;
	private String author;
	private Integer userId;
	private String comment;
	private Date createdAt;
	private Date deployedAt;
	private Integer id;
	private Date lastRetryAt;
	private Integer repositoryId;
	private String environmentName;
	private String environmentId;
	private Integer retries;
	private Integer revision;
	private String state;
	private Date updatedAt;
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getDeployedAt() {
		return deployedAt;
	}
	
	public void setDeployedAt(Date deployedAt) {
		this.deployedAt = deployedAt;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getLastRetryAt() {
		return lastRetryAt;
	}
	
	public void setLastRetryAt(Date lastRetryAt) {
		this.lastRetryAt = lastRetryAt;
	}
	
	public Integer getRepositoryId() {
		return repositoryId;
	}
	
	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	public String getEnvironmentName() {
		return environmentName;
	}
	
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
	
	public String getEnvironmentId() {
		return environmentId;
	}
	
	public void setEnvironmentId(String environmentId) {
		this.environmentId = environmentId;
	}
	
	public Integer getRetries() {
		return retries;
	}
	
	public void setRetries(Integer retries) {
		this.retries = retries;
	}
	
	public Integer getRevision() {
		return revision;
	}
	
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
