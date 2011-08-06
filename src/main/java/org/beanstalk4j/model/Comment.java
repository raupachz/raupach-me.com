package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

import org.beanstalk4j.utils.ToStringBuilder;

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
public class Comment implements Serializable {
	
	private Integer id;
	private Integer accountId;
	private Integer authorId;
	private String authorName;
	private String authorLogin;
	private String authorEmail;
	private String body;
	private Date createdAt;
	private String filePath;
	private String lineNumber;
	private String renderedBody;
	private Integer repositoryId;
	private String revision;
	private Date updatedAt;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getAuthorLogin() {
		return authorLogin;
	}
	
	public void setAuthorLogin(String authorLogin) {
		this.authorLogin = authorLogin;
	}
	
	public String getAuthorEmail() {
		return authorEmail;
	}
	
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String getRenderedBody() {
		return renderedBody;
	}
	
	public void setRenderedBody(String renderedBody) {
		this.renderedBody = renderedBody;
	}
	
	public Integer getRepositoryId() {
		return repositoryId;
	}
	
	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	public String getRevision() {
		return revision;
	}
	
	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("accountId", getAccountId())
			.append("authorId", getAuthorId())
			.append("authorName", getAuthorName())
			.append("authorLogin", getAuthorLogin())
			.append("authorEmail", getAuthorEmail())
			.append("body", getBody())
			.append("createdAt", getCreatedAt())
			.append("filePath", getFilePath())
			.append("lineNumber", getLineNumber())
			.append("renderedBody", getRenderedBody())
			.append("repositoryId", getRepositoryId())
			.append("revision", getRevision())
			.append("updatedAt", getUpdatedAt())
			.toString();
	}
}
