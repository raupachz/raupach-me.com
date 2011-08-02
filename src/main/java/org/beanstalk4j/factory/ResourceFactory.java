package org.beanstalk4j.factory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Changeset;
import org.beanstalk4j.model.Comment;
import org.beanstalk4j.model.Permission;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.PublicKey;
import org.beanstalk4j.model.Repository;
import org.beanstalk4j.model.ServerEnvironment;
import org.beanstalk4j.model.User;
import org.beanstalk4j.model.builder.AccountBuilder;
import org.beanstalk4j.model.builder.ChangesetBuilder;
import org.beanstalk4j.model.builder.CommentBuilder;
import org.beanstalk4j.model.builder.PermissionBuilder;
import org.beanstalk4j.model.builder.PlanBuilder;
import org.beanstalk4j.model.builder.PublicKeyBuilder;
import org.beanstalk4j.model.builder.RepositoryBuilder;
import org.beanstalk4j.model.builder.ServerEnvironmentBuilder;
import org.beanstalk4j.model.builder.UserBuilder;
import org.beanstalk4j.xml.DOMUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	
	public Account buildAccount(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new AccountBuilder(root).build();
	}

	public List<Plan> buildPlans(InputStream httpStream) {
		List<Plan> resultList = new ArrayList<Plan>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				Plan plan = new PlanBuilder(e).build();
				resultList.add(plan);
			}
		}
		return resultList;
	}

	public List<User> buildUsers(InputStream httpStream) {
		List<User> resultList = new ArrayList<User>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				User user = new UserBuilder(e).build();
				resultList.add(user);
			}
		}
		return resultList;
	}

	public User buildUser(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element account = document.getDocumentElement();
		return new UserBuilder(account).build();
	}

	public List<PublicKey> buildPublicKeys(InputStream httpStream) {
		List<PublicKey> resultList = new ArrayList<PublicKey>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				PublicKey publicKey = new PublicKeyBuilder(e).build();
				resultList.add(publicKey);
			}
		}
		return resultList;
	}

	public PublicKey buildPublicKey(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element account = document.getDocumentElement();
		return new PublicKeyBuilder(account).build();
	}

	public List<Repository> buildRepositories(InputStream httpStream) {
		List<Repository> resultList = new ArrayList<Repository>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				Repository repository = new RepositoryBuilder(e).build();
				resultList.add(repository);
			}
		}
		return resultList;
	}

	public Repository buildRepository(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new RepositoryBuilder(root).build();
	}

	public List<Permission> buildPermissions(InputStream httpStream) {
		List<Permission> resultList = new ArrayList<Permission>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				Permission permission = new PermissionBuilder(e).build();
				resultList.add(permission);
			}
		}
		return resultList;
	}

	public List<Changeset> buildChangesets(InputStream httpStream) {
		List<Changeset> resultList = new ArrayList<Changeset>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				Changeset changeset = new ChangesetBuilder(e).build();
				resultList.add(changeset);
			}
		}
		return resultList;
	}

	public Changeset buildChangeset(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new ChangesetBuilder(root).build();	
	}

	public List<Comment> buildComments(InputStream httpStream) {
		List<Comment> resultList = new ArrayList<Comment>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				Comment comment = new CommentBuilder(e).build();
				resultList.add(comment);
			}
		}
		return resultList;
	}

	public List<ServerEnvironment> buildServerEnvironments(InputStream httpStream) {
		List<ServerEnvironment> resultList = new ArrayList<ServerEnvironment>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				ServerEnvironment serverEnvironment = new ServerEnvironmentBuilder(e).build();
				resultList.add(serverEnvironment);
			}
		}
		return resultList;
	}

	public ServerEnvironment buildServerEnvironment(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new ServerEnvironmentBuilder(root).build();	
	}

}
