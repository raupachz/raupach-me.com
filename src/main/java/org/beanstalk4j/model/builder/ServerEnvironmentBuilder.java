package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.ServerEnvironment;
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
public class ServerEnvironmentBuilder {
	
	private final ServerEnvironment serverEnvironment;
	
	public ServerEnvironmentBuilder() {
		this.serverEnvironment = new ServerEnvironment();
	}
	
	public ServerEnvironmentBuilder(Element element) {
		this();
		accountId(element.getChildText("account-id"));
		automatic(element.getChildText("automatic"));
		branchName(element.getChildText("branch-name"));
		createdAt(element.getChildText("created-at"));
		currentVersion(element.getChildText("current-version"));
		id(element.getChildText("id"));
		name(element.getChildText("name"));
		repositoryId(element.getChildText("repository-id"));
		updatedAt(element.getChildText("updated-at"));
	}
	
	public ServerEnvironmentBuilder accountId(Integer accountId) {
		serverEnvironment.setAccountId(accountId);
		return this;
	}
	
	public ServerEnvironmentBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public ServerEnvironmentBuilder automatic(Boolean automatic) {
		serverEnvironment.setAutomatic(automatic);
		return this;
	}
	
	public ServerEnvironmentBuilder automatic(String automatic) {
		return automatic(Boolean.valueOf(automatic));
	}
	
	public ServerEnvironmentBuilder branchName(String branchName) {
		serverEnvironment.setBranchName(branchName);
		return this;
	}
	
	public ServerEnvironmentBuilder createdAt(Date createdAt) {
		serverEnvironment.setCreatedAt(createdAt);
		return this;
	}
	
	public ServerEnvironmentBuilder createdAt(String createdAt) {
		return createdAt(createdAt);
	}
	
	public ServerEnvironmentBuilder currentVersion(String currentVersion) {
		serverEnvironment.setCurrentVersion(currentVersion);
		return this;
	}
	
	public ServerEnvironmentBuilder id(Integer id) {
		serverEnvironment.setId(id);
		return this;
	}
	
	public ServerEnvironmentBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public ServerEnvironmentBuilder name(String name) {
		serverEnvironment.setName(name);
		return this;
	}
	
	public ServerEnvironmentBuilder repositoryId(Integer repositoryId) {
		serverEnvironment.setRepositoryId(repositoryId);
		return this;
	}
	
	public ServerEnvironmentBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public ServerEnvironmentBuilder updatedAt(Date updatedAt) {
		serverEnvironment.setUpdatedAt(updatedAt);
		return this;
	}
	
	public ServerEnvironmentBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public ServerEnvironment build() {
		return serverEnvironment;
	}
	

}
