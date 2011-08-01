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
public class ReleaseServer implements Serializable {
	
	private Integer accountId;
	private Date createdAt;
	private Integer id;
	private String localPath;
	private String login;
	private String name;
	private String password;
	private Integer port;
	private String protocol;
	private String remoteAddr;
	private String remotePath;
	private Integer repositoryId;
	private String environmentName;
	private String serverEnvironmentId;
	private Integer revision;
	private Date updatedAt;
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLocalPath() {
		return localPath;
	}
	
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getPort() {
		return port;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	
	public String getProtocol() {
		return protocol;
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	public String getRemoteAddr() {
		return remoteAddr;
	}
	
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	
	public String getRemotePath() {
		return remotePath;
	}
	
	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath;
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
	
	public String getServerEnvironmentId() {
		return serverEnvironmentId;
	}
	
	public void setServerEnvironmentId(String serverEnvironmentId) {
		this.serverEnvironmentId = serverEnvironmentId;
	}
	
	public Integer getRevision() {
		return revision;
	}
	
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
