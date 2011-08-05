package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

import org.beanstalk4j.ColorLabel;
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
public class Repository implements Serializable {
	
	private Integer id;
	private Integer accountId;
	private Boolean anonymous;
	private ColorLabel colorLabel;
	private String type;
	private String name;
	private Integer revision;
	private Integer storageUsedBytes;
	private String title;
	private Date lastCommitAt;
	private Date updatedAt;
	private Date createdAt;
	
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
	
	public Boolean isAnonymous() {
		return anonymous;
	}
	
	public void setAnonymous(Boolean anonymous) {
		this.anonymous = anonymous;
	}
	
	public ColorLabel getColorLabel() {
		return colorLabel;
	}
	
	public void setColorLabel(ColorLabel colorLabel) {
		this.colorLabel = colorLabel;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getRevision() {
		return revision;
	}
	
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	
	public Integer getStorageUsedBytes() {
		return storageUsedBytes;
	}
	
	public void setStorageUsedBytes(Integer storageUsedBytes) {
		this.storageUsedBytes = storageUsedBytes;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getLastCommitAt() {
		return lastCommitAt;
	}
	
	public void setLastCommitAt(Date lastCommitAt) {
		this.lastCommitAt = lastCommitAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("accountId", getAccountId())
			.append("anonymous", isAnonymous())
			.append("colorLabel", getColorLabel())
			.append("type", getType())
			.append("name", getName())
			.append("revision", getRevision())
			.append("storageBytes", getStorageUsedBytes())
			.append("title", getTitle())
			.append("lastCommitAt", getLastCommitAt())
			.append("updatedAt", getUpdatedAt())
			.append("createdAt", getCreatedAt())
			.toString();
	}
	
}
