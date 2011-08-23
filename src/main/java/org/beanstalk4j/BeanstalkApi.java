package org.beanstalk4j;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.beanstalk4j.factory.ResourceFactory;
import org.beanstalk4j.http.HttpConnection;
import org.beanstalk4j.logging.DefaultFormatter;
import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Changeset;
import org.beanstalk4j.model.Comment;
import org.beanstalk4j.model.Permission;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.PublicKey;
import org.beanstalk4j.model.Release;
import org.beanstalk4j.model.ReleaseServer;
import org.beanstalk4j.model.Repository;
import org.beanstalk4j.model.ServerEnvironment;
import org.beanstalk4j.model.User;
import org.omg.CORBA.INITIALIZE;

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
public class BeanstalkApi {
	
	private static Logger logger = Logger.getLogger("org.beanstalk4j");
	
	private final HttpConnection httpConnection;
	private final ResourceFactory resourceFactory;
	
	/**
	  * Constructor.
	  * @param accountName (required) your Beanstalk account name.
	  * @param username (required)
	  * @param password (required) 
	  */
	public BeanstalkApi(String accountName, String username, String password) {
		this.httpConnection = new HttpConnection(accountName, username, password);
		this.resourceFactory = new ResourceFactory();
	}
	
	/**
	  * Constructor.
	  * @param accountName (required) your Beanstalk account name.
	  * @param username (required)
	  * @param password (required) 
	  * @param debug
	  */
	public BeanstalkApi(String accountName, String username, String password, boolean debug) {
		this.httpConnection = new HttpConnection(accountName, username, password);
		this.resourceFactory = new ResourceFactory();
		if (debug) {
			initializeLogging();
		}
	}
	
	private void initializeLogging() {
		Handler[] handlers = Logger.getLogger("").getHandlers();
		for (Handler h : handlers) {
			h.setLevel(Level.FINE);
			h.setFormatter(new DefaultFormatter());
		}
		logger.setLevel(Level.FINE);
	}
	
	/**
	 * Get your account details
	 * @return account details
	 */
	public Account getAccount() {
		URL url = httpConnection.createURL("/api/account.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildAccount(httpStream);
	}
	
	/**
	 * Update account
	 * @param account
	 */
	public void updateAccount(Account account) {
		URL url = httpConnection.createURL("/api/account.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<account>");
		sb.append("<name>").append(account.getName()).append("</name>");
		sb.append("<time-zone>").append(account.getTimeZone()).append("</time-zone>");
		sb.append("</account>");
		
		httpConnection.doPut(url, sb.toString());
	}
	
	/**
	 * Find all plans
	 * @return all plans
	 */
	public List<Plan> getPlans() {
		URL url = httpConnection.createURL("/api/plans.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildPlans(httpStream);
	}
	
	/**
	 * Find all users
	 * @return all users
	 */
	public List<User> getUsers() {
		URL url = httpConnection.createURL("/api/users.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildUsers(httpStream);
	}
	
	/**
	 * Find a single user
	 * @param userId
	 * @return single user
	 */
	public User getUser(Integer userId) {
		URL url = httpConnection.createURL("/api/users/" + userId + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildUser(httpStream);
	}
	
	/**
	 * Find user for current session
	 * @return currently logged in user
	 */
	public User getCurrentUser() {
		URL url = httpConnection.createURL("/api/users/current.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildUser(httpStream);
	}
	
	/**
	 * Create new User
	 * @param user
	 */
	public User createUser(User user, String password) {
		URL url = httpConnection.createURL("/api/users.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<user>");
		sb.append("<login>").append(user.getLogin()).append("</login>");
		sb.append("<email>").append(user.getEmail()).append("</email>");
		sb.append("<first-name>").append(user.getFirstName()).append("</first-name>");
		sb.append("<last-name>").append(user.getLastName()).append("</last-name>");
		sb.append("<password>").append(password).append("</password>");
		sb.append("</user>");

		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildUser(httpStream);
	}
	 
	public void updateUser(User user) {
		URL url = httpConnection.createURL("/api/users/" + user.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<user>");
		sb.append("<login>").append(user.getLogin()).append("</login>");
		sb.append("<email>").append(user.getEmail()).append("</email>");
		sb.append("<first-name>").append(user.getFirstName()).append("<first-name>");
		sb.append("<last-name>").append(user.getLastName()).append("<last-name>");
		sb.append("</user>");
		
		httpConnection.doPut(url, sb.toString());
	}
	
	/**
	 * Delete user. You can not delete account owner.
	 * @param user
	 */
	public void deleteUser(User user) {
		URL url = httpConnection.createURL("/api/users/" + user.getId() + ".xml");
		httpConnection.doDelete(url);
	}
	
	/**
	 * Finds current user's public keys
	 * @return current user's public keys
	 */
	public List<PublicKey> getPublicKeys() {
		URL url = httpConnection.createURL("/api/public_keys.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildPublicKeys(httpStream);
	}
	
	/**
	 * Find a single public key
	 * @return public key
	 */
	public PublicKey getPublicKey(Integer id) {
		URL url = httpConnection.createURL("/api/public_keys/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildPublicKey(httpStream);
	}
	
	/**
	 * Create a new public key for the current user
	 * @param content 
	 * @return created public key
	 */
	public PublicKey createPublicKey(String content) {
		URL url = httpConnection.createURL("/api/public_keys.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<public-key>");
		sb.append("<content>").append(content).append("</content>");
		sb.append("</public-key>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildPublicKey(httpStream);
	}
	
	/**
	 * Create a new public key
	 * @param userId 
	 * @param content
	 * @return created public key
	 */
	public PublicKey createPublicKey(Integer userId, String content) {
		URL url = httpConnection.createURL("/api/public_keys.xml?user_id=" + userId);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<public-key>");
		sb.append("<content>").append(content).append("</content>");
		sb.append("</public-key>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildPublicKey(httpStream);
	}
	
	/**
	 * Update an existing public key
	 * @param publicKey
	 */
	public void updatePublicKey(PublicKey publicKey) {
		URL url = httpConnection.createURL("/api/public_keys/" + publicKey.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<public-key>");
		if (publicKey.getName() != null) {
			sb.append("<name>").append(publicKey.getName()).append("</name>");
		}
		sb.append("<content>").append(publicKey.getContent()).append("</content>");
		sb.append("</public-key>");
		
		httpConnection.doPut(url, sb.toString());
	}
	
	/**
	 * Delete public Key
	 */
	public void deletePublicKey(PublicKey publicKey) {
		URL url = httpConnection.createURL("/api/public_keys/" + publicKey.getId() + ".xml");
		httpConnection.doDelete(url);
	}
	
	/**
	 * Find all repositories
	 * @return all repositories
	 */
	public List<Repository> getRepositories() {
		URL url = httpConnection.createURL("/api/repositories.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildRepositories(httpStream);
	}
	
	/**
	 * Find a single repository by Id
	 * @param repositoryId
	 * @return repository
	 */
	public Repository getRepository(Integer repositoryId) {
		URL url = httpConnection.createURL("/api/repositories/" + repositoryId + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildRepository(httpStream);
	}
	
	/**
	 * Find a single repository by Name, don't confuse with title
	 * @param name
	 * @return repository
	 */
	public Repository getRepository(String name) {
		URL url = httpConnection.createURL("/api/repositories/" + name + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildRepository(httpStream);
	}
	
	/**
	 * Create a rew repository
	 * @param name must be unique
	 * @param title must be unique
	 * @return
	 */
	public Repository createRepository(String name, String title, ColorLabel colorLabel) {
		URL url = httpConnection.createURL("/api/repositories.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<repository>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("<title>").append(title).append("</title>");
		sb.append("<color-label>").append(colorLabel).append("</color-label>");
		sb.append("</repository>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildRepository(httpStream);
	}
	
	/**
	 * Update existing repository
	 * @param repository
	 */
	public void updateRepository(Repository repository) {
		URL url = httpConnection.createURL("/api/repositories/" + repository.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<repository>");
		sb.append("<name>").append(repository.getName()).append("</name>");
		sb.append("<title>").append(repository.getTitle()).append("</title>");
		sb.append("<color-label>").append(repository.getColorLabel()).append("</color-label>");
		sb.append("</repository>");
		
		httpConnection.doPut(url, sb.toString());
	}
	/**
	 * Find permissions for user
	 */
	public List<Permission> getPermissions(Integer userId) {
		URL url = httpConnection.createURL("/api/permissions/" + userId + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildPermissions(httpStream);
	}
	
	/**
	 * Create permissions for user. Admin privileges required for this API method.
	 * @param permission
	 * @return
	 */
	public Permission createPermission(Permission permission) {
		URL url = httpConnection.createURL("/api/permissions.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<permission>");
		sb.append("<user-id>").append(permission.getUserId()).append("</user-id>");
		sb.append("<repository-id>").append(permission.getRepositoryId()).append("</repository-id>");
		sb.append("<write>").append(permission.getWrite()).append("</write>");
		sb.append("<server-environment-id>").append(permission.getServerEnvironmentId()).append("</server-environment-id>");
		sb.append("</permission>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildPermission(httpStream);
	}
	
	/**
	 * Strip user of permission
	 * @param permission
	 */
	public void deletePermission(Permission permission) {
		URL url = httpConnection.createURL("/api/permissions/" + permission.getId() + ".xml");
		httpConnection.doDelete(url);
	}
	
	/**
	 * Find alle changesets
	 * @return last 15 changesets from all repositories
	 */
	public List<Changeset> getChangesets() {
		URL url = httpConnection.createURL("/api/changesets.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildChangesets(httpStream);
	}
	
	/**
	 * Find all changesets for a specific repository
	 * @param repositoryId
	 * @return
	 */
	public List<Changeset> getChangesets(Integer repositoryId) {
		URL url = httpConnection.createURL("/api/changesets/repository.xml?repository_id=" + repositoryId);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildChangesets(httpStream);
	}
	
	/**
	 * Finds all changesets for a specific repository
	 * @param name of the repository
	 * @return
	 */
	public List<Changeset> getChangesets(String name) {
		URL url = httpConnection.createURL("/api/changesets/repository.xml?repository_id=" + name);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildChangesets(httpStream);
	}
	
	/**
	 * Find a single changeset
	 * @param repositoryId
	 * @param revision
	 * @return
	 */
	public Changeset getChangeset(Integer repositoryId, Integer revision) {
		URL url = httpConnection.createURL("/api/changesets/" + revision + ".xml?repository_id=" + repositoryId);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildChangeset(httpStream);
	}
	
	/**
	 * Find a single changeset
	 * @param repositoryId
	 * @param name
	 * @return
	 */
	public Changeset getChangeset(String name, Integer revision) {
		URL url = httpConnection.createURL("/api/changesets/" + revision + ".xml?repository_id=" + revision);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildChangeset(httpStream);
	}
	
	/**
	 * Find all comments for a repository
	 * @param repositoryId Id of the repository
	 * @return all comments
	 */
	public List<Comment> getComments(Integer repositoryId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/comments.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildComments(httpStream);
	}
	
	/**
	 * Find all comments for a repository
	 * @param reposioryName of the repository
	 * @return all comments
	 */
	public List<Comment> getComments(String repositoryName) {
		URL url = httpConnection.createURL("/api/" + repositoryName + "/comments.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildComments(httpStream);
	}
	
	/**
	 * Find all comments for specific changeset
	 * @param repositoryId
	 * @param revision
	 * @return
	 */
	public List<Comment> getComments(Integer repositoryId, String revision) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/comments.xml?revision=" + revision);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildComments(httpStream);
	}
	
	/**
	 * Find all comments for specific changeset
	 * @param repositoryName
	 * @param revision
	 * @return
	 */
	public List<Comment> getComments(String repositoryName, String revision) {
		URL url = httpConnection.createURL("/api/" + repositoryName + "/comments.xml?revision=" + revision);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildComments(httpStream);
	}
	
	/**
	 * Find a single comment by id
	 * @param id
	 * @return single comment
	 */
	public Comment getComment(Integer repositoryId, Integer id) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/comments/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildComment(httpStream);
	}
	
	/**
	 * Find a single comment by id
	 * @param repositoryName
	 * @param id
	 * @return
	 */
	public Comment getComment(String repositoryName, Integer id) {
		URL url = httpConnection.createURL("/api/" + repositoryName + "/comments/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildComment(httpStream);
	}
	
	/**
	 * Create a new comment
	 * @param repositoryId
	 * @param comment
	 * @return
	 */
	public Comment createComment(Integer repositoryId, Comment comment) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/comments.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<comment>");
		sb.append("<revision>").append(comment.getRevision()).append("</revision>");
		sb.append("<body>").append(comment.getBody()).append("</body>");
		sb.append("<file-path>").append(comment.getFilePath()).append("</file-path>");
		sb.append("<line-number>").append(comment.getLineNumber()).append("</line-number>");
		sb.append("</comment>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildComment(httpStream);
	}
	
	/**
	 * Create a Server Environment
	 * @param repositoryId
	 * @param name
	 * @return
	 */
	public ServerEnvironment createServerEnvironment(Integer repositoryId, String name) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/server_environments.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<server-environment>");
		sb.append("</name>").append(name).append("</name>");
		sb.append("</server-environment>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildServerEnvironment(httpStream);
	}
	
	/**
	 * Create a Server Environment (git)
	 * @param repositoryId
	 * @param name
	 * @param branchName
	 * @return
	 */
	public ServerEnvironment createServerEnvironment(Integer repositoryId, String name, String branchName) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/server_environments.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<server-environment>");
		sb.append("</name>").append(name).append("</name>");
		sb.append("</branch-name>").append(name).append("</branch-name>");
		sb.append("</server-environment>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildServerEnvironment(httpStream);
	}
	
	/**
	 * Update existing Server Environment
	 * @param serverEnvironment
	 */
	public void updateServerEnvironment(ServerEnvironment serverEnvironment) {
		URL url = httpConnection.createURL("/api/" + serverEnvironment.getRepositoryId() + "/server_environments/" + serverEnvironment.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<server-environment>");
		sb.append("<name>").append(serverEnvironment.getName()).append("</name>");
		sb.append("<automatic>").append(serverEnvironment.getAutomatic()).append("</automatic>");
		sb.append("<branch-name>").append(serverEnvironment.getBranchName()).append("</branch-name>");
		sb.append("</server-environment>");
		
		httpConnection.doPut(url, sb.toString());
	}
	
	/**
	 * Find all Server Environments
	 * @param repositoryId
	 * @return
	 */
	public List<ServerEnvironment> getServerEnvironments(Integer repositoryId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/server_environments.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildServerEnvironments(httpStream);
	}
	
	/**
	 * Find a single Server Environment
	 * @param repositoryId Id of the repository
	 * @param id Id of the Server Environemnt
	 * @return single Server Environment
	 */
	public ServerEnvironment getServerEnvironment(Integer repositoryId, Integer id) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/server_environments/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildServerEnvironment(httpStream);
	}
	
	/**
	 * Find a single Server Environment
	 * @param repositoryId Id of the Repository
	 * @param name Name of the Server Environment
	 * @return
	 */
	public ServerEnvironment getServerEnvironment(Integer repositoryId, String name) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/server_environments/" + name + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildServerEnvironment(httpStream);
	}
	
	/**
	 * Find all Release Servers
	 * @param repositoryId
	 * @param environmentId
	 * @return all release servers
	 */
	public List<ReleaseServer> getReleaseServers(Integer repositoryId, Integer environmentId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/release_servers.xml?environment_id=" + environmentId);
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildReleaseServers(httpStream);
	}
	
	/**
	 * Find a single Release Server
	 * @param repositoryId
	 * @param releaseServerId
	 * @return
	 */
	public ReleaseServer getReleaseServer(Integer repositoryId, Integer releaseServerId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/release_servers/" + repositoryId + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildReleaseServer(httpStream);
	}
	
	/**
	 * Create a Release Server
	 * @param repositoryId
	 * @param environmentId
	 * @param name
	 * @param localPath
	 * @param remotePath
	 * @param remoteAddr
	 * @param protocol
	 * @param port
	 * @param login
	 * @param password
	 * @return
	 */
	public ReleaseServer createReleaseServer(Integer repositoryId, Integer environmentId, String name, String localPath, String remotePath, String remoteAddr, String protocol, Integer port, String login, String password) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/release_servers.xml?environment_id=" + environmentId);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<release-server>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("<local-path>").append(localPath).append("</local-path>");
		sb.append("<remote-path>").append(remotePath).append("</remote-path>");
		sb.append("<remote-addr>").append(remoteAddr).append("</remote-addr>");
		sb.append("<protocol>").append(protocol).append("</protocol>");
		sb.append("<port>").append(port).append("</port>");
		sb.append("<login>").append(login).append("</login>");
		sb.append("<password>").append(password).append("</password>");
		sb.append("</release-server>");
		
		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildReleaseServer(httpStream);
	}
	
	/**
	 * Update existing Release Server
	 * @param releaseServer
	 */
	public void updateReleaseServer(ReleaseServer releaseServer) {
		URL url = httpConnection.createURL("/api/" + releaseServer.getRepositoryId() + "/release_servers/" + releaseServer.getId());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<release-server>");
		sb.append("<name>").append(releaseServer.getName()).append("</name>");
		sb.append("<local-path>").append(releaseServer.getLocalPath()).append("</local-path>");
		sb.append("<remote-path>").append(releaseServer.getRemotePath()).append("</remote-path>");
		sb.append("<remote-addr>").append(releaseServer.getRemoteAddr()).append("</remote-addr>");
		sb.append("<protocol>").append(releaseServer.getProtocol()).append("</protocol>");
		sb.append("<port>").append(releaseServer.getPort()).append("</port>");
		sb.append("<login>").append(releaseServer.getLogin()).append("</login>");
		sb.append("<password>").append(releaseServer.getPassword()).append("</password>");
		sb.append("</release-server>");
		
		httpConnection.doPut(url, sb.toString());
	}
	
	/**
	 * Delete an existing Release Server
	 * @param releaseServer
	 */
	public void deleteReleaseServer(ReleaseServer releaseServer) {
		URL url = httpConnection.createURL("/api/" + releaseServer.getRepositoryId() + "/release_servers/" + releaseServer.getId() + ".xml");
		httpConnection.doDelete(url);
	}
	
	/**
	 * Find all releases for account
	 * @return
	 */
	public List<Release> getReleases() {
		URL url = httpConnection.createURL("/api/releases.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildReleases(httpStream);
	}
	
	/**
	 * Find all releases for repository
	 * @param repositoryId
	 * @return
	 */
	public List<Release> getReleases(Integer repositoryId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/releases.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildReleases(httpStream);
	}
	
	/**
	 * Find all releases for repository
	 * @param repositoryId
	 * @return
	 */
	public List<Release> getReleases(String repositoryName) {
		URL url = httpConnection.createURL("/api/" + repositoryName + "/releases.xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildReleases(httpStream);
	}
	
	/**
	 * Find a single release
	 * @param repositoryId
	 * @param releaseId
	 * @return
	 */
	public Release getRelease(Integer repositoryId, Integer releaseId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/releases/" + releaseId + ".xml");
		InputStream httpStream = httpConnection.doGet(url);
		return resourceFactory.buildRelease(httpStream);
	}
	
	/**
	 * Create a new release
	 */
	public Release createRelease(Integer repositoryId, Integer environmentId, String revision, String comment) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/releases.xml?environment_id=" + environmentId);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<release>");
		sb.append("<revision>").append(revision).append("</revision>");
		if (comment != null) {
			sb.append("<comment>").append(comment).append("</comment>");
		}
		sb.append("</revision>");

		InputStream httpStream = httpConnection.doPost(url, sb.toString());
		return resourceFactory.buildRelease(httpStream);
	}
	
	/**
	 * Retry failed deployment
	 * @param repositoryId
	 * @param releaseId
	 */
	public void retryFailedRelease(Integer repositoryId, Integer releaseId) {
		URL url = httpConnection.createURL("/api/" + repositoryId + "/releases/" + releaseId + "/retry.xml");
		httpConnection.doPut(url, null);
	}
	
	/**
	 * Retry failed deployment
	 * @param repositoryName
	 * @param releaseId
	 */
	public void retryFailedRelease(String repositoryName, Integer releaseId) {
		URL url = httpConnection.createURL("/api/" + repositoryName + "/releases/" + releaseId + "/retry.xml");
		httpConnection.doPut(url, null);
	}
	
}
