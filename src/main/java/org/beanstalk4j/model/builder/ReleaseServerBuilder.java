package org.beanstalk4j.model.builder;

import java.util.Date;
import org.beanstalk4j.model.ReleaseServer;
import org.beanstalk4j.utils.IsoDateTimeFormat;
import org.beanstalk4j.xml.DOMUtils;
import org.w3c.dom.Element;

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
public class ReleaseServerBuilder {
	
	private ReleaseServer releaseServer;
	
	public ReleaseServerBuilder() {
		this.releaseServer = new ReleaseServer();
	}
	
	public ReleaseServerBuilder(Element element) {
		this();
		accountId(DOMUtils.getChildText(element,"account-id"));
		createdAt(DOMUtils.getChildText(element,"created-at"));
		environmentName(DOMUtils.getChildText(element,"environment-name"));
		id(DOMUtils.getChildText(element,"id"));
		localPath(DOMUtils.getChildText(element,"local-path"));
		login(DOMUtils.getChildText(element,"login"));
		name(DOMUtils.getChildText(element,"name"));
		password(DOMUtils.getChildText(element,"password"));
		port(DOMUtils.getChildText(element,"port"));
		protocol(DOMUtils.getChildText(element,"protocol"));
		remoteAddr(DOMUtils.getChildText(element,"remote-addr"));
		remotePath(DOMUtils.getChildText(element,"remote-path"));
		repositoryId(DOMUtils.getChildText(element,"repository-id"));
		revision(DOMUtils.getChildText(element,"revision"));
		serverEnvironmentId(DOMUtils.getChildText(element,"server-environment-id"));
		updatedAt(DOMUtils.getChildText(element,"updated-at"));
	}
	
	public ReleaseServerBuilder accountId(Integer accountId) {
		releaseServer.setAccountId(accountId);
		return this;
	}
	
	public ReleaseServerBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public ReleaseServerBuilder createdAt(Date createdAt) {
		releaseServer.setCreatedAt(createdAt);
		return this;
	}
	
	public ReleaseServerBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public ReleaseServerBuilder environmentName(String environmentName) {
		releaseServer.setEnvironmentName(environmentName);
		return this;
	}
	
	public ReleaseServerBuilder id(Integer id) {
		releaseServer.setId(id);
		return this;
	}
	
	public ReleaseServerBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public ReleaseServerBuilder localPath(String localPath) {
		releaseServer.setLocalPath(localPath);
		return this;
	}
	
	public ReleaseServerBuilder login(String login) {
		releaseServer.setLogin(login);
		return this;
	}
	
	public ReleaseServerBuilder name(String name) {
		releaseServer.setName(name);
		return this;
	}
	
	public ReleaseServerBuilder password(String password) {
		releaseServer.setPassword(password);
		return this;
	}
	
	public ReleaseServerBuilder port(Integer port) {
		releaseServer.setPort(port);
		return this;
	}
	
	public ReleaseServerBuilder port(String port) {
		return port(Integer.valueOf(port));
	}
	
	public ReleaseServerBuilder protocol(String protocol) {
		releaseServer.setProtocol(protocol);
		return this;
	}
	
	public ReleaseServerBuilder remoteAddr(String remoteAddr) {
		releaseServer.setRemoteAddr(remoteAddr);
		return this;
	}
	
	public ReleaseServerBuilder remotePath(String remotePath) {
		releaseServer.setRemotePath(remotePath);
		return this;
	}
	
	public ReleaseServerBuilder repositoryId(Integer repositoryId) {
		releaseServer.setRepositoryId(repositoryId);
		return this;
	}
	
	public ReleaseServerBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public ReleaseServerBuilder revision(Integer revision) {
		releaseServer.setRevision(revision);
		return this;
	}
	
	public ReleaseServerBuilder revision(String revision) {
		return revision(Integer.valueOf(revision));
	}
	
	public ReleaseServerBuilder serverEnvironmentId(String serverEnvironmentId) {
		releaseServer.setServerEnvironmentId(serverEnvironmentId);
		return this;
	}
	
	public ReleaseServerBuilder updatedAt(Date updatedAt) {
		releaseServer.setUpdatedAt(updatedAt);
		return this;
	}
	
	public ReleaseServerBuilder updatedAt(String updatedAt) {
		return updatedAt(updatedAt);
	}
	
	public ReleaseServer build() {
		return releaseServer;
	}
	
	

}
