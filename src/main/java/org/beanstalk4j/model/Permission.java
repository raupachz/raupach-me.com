package org.beanstalk4j.model;

import java.io.Serializable;

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
public class Permission implements Serializable {
	
	private Integer id;
	private Integer userId;
	private Integer repositoryId;
	private Boolean read;
	private Boolean write;
	private Boolean fullDeploymentAccess;
	private Integer serverEnvironmentId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getRepositoryId() {
		return repositoryId;
	}
	
	public void setRepositoryId(Integer repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	public Boolean getRead() {
		return read;
	}
	
	public void setRead(Boolean read) {
		this.read = read;
	}
	
	public Boolean getWrite() {
		return write;
	}
	
	public void setWrite(Boolean write) {
		this.write = write;
	}
	
	public Boolean getFullDeploymentAccess() {
		return fullDeploymentAccess;
	}
	
	public void setFullDeploymentAccess(Boolean fullDeploymentAccess) {
		this.fullDeploymentAccess = fullDeploymentAccess;
	}
	
	public Integer getServerEnvironmentId() {
		return serverEnvironmentId;
	}
	
	public void setServerEnvironmentId(Integer serverEnvironmentId) {
		this.serverEnvironmentId = serverEnvironmentId;
	}
	
}
