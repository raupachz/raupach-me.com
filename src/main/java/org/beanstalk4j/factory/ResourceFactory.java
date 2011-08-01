package org.beanstalk4j.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Changeset;
import org.beanstalk4j.model.Comment;
import org.beanstalk4j.model.Errors;
import org.beanstalk4j.model.Permission;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.PublicKey;
import org.beanstalk4j.model.Repository;
import org.beanstalk4j.model.ServerEnvironment;
import org.beanstalk4j.model.User;
import org.beanstalk4j.model.builder.AccountBuilder;
import org.beanstalk4j.model.builder.ChangesetBuilder;
import org.beanstalk4j.model.builder.CommentBuilder;
import org.beanstalk4j.model.builder.ErrorsBuilder;
import org.beanstalk4j.model.builder.PermissionBuilder;
import org.beanstalk4j.model.builder.PlanBuilder;
import org.beanstalk4j.model.builder.PublicKeyBuilder;
import org.beanstalk4j.model.builder.RepositoryBuilder;
import org.beanstalk4j.model.builder.ServerEnvironmentBuilder;
import org.beanstalk4j.model.builder.UserBuilder;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

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
public class ResourceFactory {
	
	private final SAXBuilder saxBuilder;
	
	public ResourceFactory() {
		this.saxBuilder = new SAXBuilder();
	}

	Document buildDocument(InputStream in) {
		Document document = null;
		try {
			document = saxBuilder.build(in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return document;
	}
	
	public Errors buildError(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element errors = document.getRootElement();
		return new ErrorsBuilder(errors).build();
	}

	public Account buildAccount(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		return new AccountBuilder(account).build();
	}

	public List<Plan> buildPlans(InputStream httpStream) {
		List<Plan> resultList = new ArrayList<Plan>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Plan plan = new PlanBuilder(e).build();
			resultList.add(plan);
		}
		return resultList;
	}

	public List<User> buildUsers(InputStream httpStream) {
		List<User> resultList = new ArrayList<User>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			User user = new UserBuilder(e).build();
			resultList.add(user);
		}
		return resultList;
	}

	public User buildUser(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		return new UserBuilder(account).build();
	}

	public List<PublicKey> buildPublicKeys(InputStream httpStream) {
		List<PublicKey> resultList = new ArrayList<PublicKey>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			PublicKey publicKey = new PublicKeyBuilder(e).build();
			resultList.add(publicKey);
		}
		return resultList;
	}

	public PublicKey buildPublicKey(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		return new PublicKeyBuilder(account).build();
	}

	public List<Repository> buildRepositories(InputStream httpStream) {
		List<Repository> resultList = new ArrayList<Repository>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext(); ) {
			Element e = (Element) it.next();
			Repository repository = new RepositoryBuilder(e).build();
			resultList.add(repository);
		}
		return resultList;
	}

	public Repository buildRepository(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new RepositoryBuilder(root).build();
	}

	public List<Permission> buildPermissions(InputStream httpStream) {
		List<Permission> resultList = new ArrayList<Permission>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext(); ) {
			Element e = (Element) it.next();
			Permission permission = new PermissionBuilder(e).build();
			resultList.add(permission);
		}
		return resultList;
	}

	public List<Changeset> buildChangesets(InputStream httpStream) {
		List<Changeset> resultList = new ArrayList<Changeset>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext(); ) {
			Element e = (Element) it.next();
			Changeset changeset = new ChangesetBuilder(e).build();
			resultList.add(changeset);
		}
		return resultList;
	}

	public Changeset buildChangeset(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new ChangesetBuilder(root).build();	
	}

	public List<Comment> buildComments(InputStream httpStream) {
		List<Comment> resultList = new ArrayList<Comment>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext(); ) {
			Element e = (Element) it.next();
			Comment comment = new CommentBuilder(e).build();
			resultList.add(comment);
		}
		return resultList;
	}

	public List<ServerEnvironment> buildServerEnvironments(InputStream httpStream) {
		List<ServerEnvironment> resultList = new ArrayList<ServerEnvironment>();
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext(); ) {
			Element e = (Element) it.next();
			ServerEnvironment serverEnvironment = new ServerEnvironmentBuilder(e).build();
			resultList.add(serverEnvironment);
		}
		return resultList;
	}

	public ServerEnvironment buildServerEnvironment(InputStream httpStream) {
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new ServerEnvironmentBuilder(root).build();	
	}

}
