package org.beanstalk4j.model.builder;

import org.beanstalk4j.model.Permission;
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
public class PermissionBuilder {
	
	private final Permission permission;
	
	public PermissionBuilder() {
		this.permission = new Permission();
	}
	
	public PermissionBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		userId(element.getChildText("userId"));
		repositoryId(element.getChildText("repository-id"));
		read(element.getChildText("read"));
		write(element.getChildText("write"));
		fullDeploymentAccess(element.getChildText("full-deployment-access"));
		serverEnvironmentId(element.getChildText("server-environment-id"));
	}
	
	public PermissionBuilder id(Integer id) {
		permission.setId(id);
		return this;
	}
	
	public PermissionBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public PermissionBuilder userId(Integer userId) {
		permission.setUserId(userId);
		return this;
	}
	
	public PermissionBuilder userId(String userId) {
		return userId(Integer.valueOf(userId));
	}
	
	public PermissionBuilder repositoryId(Integer repositoryId) {
		permission.setRepositoryId(repositoryId);
		return this;
	}
	
	public PermissionBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public PermissionBuilder read(Boolean read) {
		permission.setRead(read);
		return this;
	}
	
	public PermissionBuilder read(String read) {
		return read(Boolean.valueOf(read));
	}
	
	public PermissionBuilder write(Boolean write) {
		permission.setWrite(write);
		return this;
	}
	
	public PermissionBuilder write(String write) {
		return write(Boolean.valueOf(write));
	}
	
	public PermissionBuilder fullDeploymentAccess(Boolean fullDeploymentAccess) {
		permission.setFullDeploymentAccess(fullDeploymentAccess);
		return this;
	}
	
	public PermissionBuilder fullDeploymentAccess(String fullDeploymentAccess) {
		return fullDeploymentAccess(Boolean.valueOf(fullDeploymentAccess));
	}
	
	public PermissionBuilder serverEnvironmentId(Integer serverEnvironmentId) {
		permission.setServerEnvironmentId(serverEnvironmentId);
		return this;
	}
	
	public PermissionBuilder serverEnvironmentId(String serverEnvironmentId) {
		return serverEnvironmentId(Integer.valueOf(serverEnvironmentId));
	}

	public Permission build() {
		return permission;
	}

}
