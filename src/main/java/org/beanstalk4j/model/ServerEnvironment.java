package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

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
public class ServerEnvironment implements Serializable {
	
	private Integer id;
	private Integer accountId;
	private Integer repositoryId;
	private Boolean automatic;
	private String branchName;
	private String currentVersion;
	private String name;
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
	
	public Integer getRepositoryId() {
		return repositoryId;
	}
	
	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	public Boolean getAutomatic() {
		return automatic;
	}
	
	public void setAutomatic(Boolean automatic) {
		this.automatic = automatic;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getCurrentVersion() {
		return currentVersion;
	}
	
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
}
