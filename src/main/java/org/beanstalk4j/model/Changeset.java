package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

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
public class Changeset implements Serializable {
	
	private Integer accountId;
	private Integer repositoryId;
	private Integer revision;
	private String message;
	private String author;
	private String email;
	private String changedDirs;
	private String changedFiles;
	private String changedProperties;
	private Boolean tooLarge;
	private Date time;
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Integer getRepositoryId() {
		return repositoryId;
	}
	
	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	public Integer getRevision() {
		return revision;
	}
	
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getChangedDirs() {
		return changedDirs;
	}
	
	public void setChangedDirs(String changedDirs) {
		this.changedDirs = changedDirs;
	}
	
	public String getChangedFiles() {
		return changedFiles;
	}
	
	public void setChangedFiles(String changedFiles) {
		this.changedFiles = changedFiles;
	}
	
	public String getChangedProperties() {
		return changedProperties;
	}
	
	public void setChangedProperties(String changedProperties) {
		this.changedProperties = changedProperties;
	}
	
	public Boolean getTooLarge() {
		return tooLarge;
	}
	
	public void setTooLarge(Boolean tooLarge) {
		this.tooLarge = tooLarge;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("accountId", getAccountId())
			.append("repositoryId", getRepositoryId())
			.append("revision", getRevision())
			.append("message", getMessage())
			.append("author", getAuthor())
			.append("email", getEmail())
			.append("changedDirs", getChangedDirs())
			.append("changedFiles", getChangedFiles())
			.append("changedProperties", getChangedProperties())
			.append("tooLarge", getTooLarge())
			.append("time", getTime())
			.toString();
	}
	
	

}
