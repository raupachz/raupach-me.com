package org.beanstalk4j.model.builder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import org.beanstalk4j.model.RepositoryImport;
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
public class RepositoryImportBuilder {
	
	private final RepositoryImport repositoryImport;
	
	public RepositoryImportBuilder() {
		this.repositoryImport = new RepositoryImport();
	}
	
	public RepositoryImportBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element, "id"));
		accountId(DOMUtils.getChildText(element, "account-id"));
		repositoryId(DOMUtils.getChildText(element, "repository-id"));
		state(DOMUtils.getChildText(element, "state"));
		uri(DOMUtils.getChildText(element, "uri"));
		createdAt(DOMUtils.getChildText(element, "created-at"));
		updatedAt(DOMUtils.getChildText(element, "updated-at"));
	}
	
	public RepositoryImportBuilder id(Integer id) {
		repositoryImport.setId(id);
		return this;
	}
	
	public RepositoryImportBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public RepositoryImportBuilder accountId(Integer accountId) {
		repositoryImport.setAccountId(accountId);
		return this;
	}
	
	public RepositoryImportBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public RepositoryImportBuilder repositoryId(Integer repositoryId) {
		repositoryImport.setRepositoryId(repositoryId);
		return this;
	}
	
	public RepositoryImportBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public RepositoryImportBuilder state(String state) {
		repositoryImport.setState(state);
		return this;
	}
	
	public RepositoryImportBuilder uri(URI uri) {
		repositoryImport.setUri(uri);
		return this;
	}
	
	public RepositoryImportBuilder uri(String uri) {
		try {
			return uri(new URI(uri));
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	public RepositoryImportBuilder createdAt(Date createdAt) {
		repositoryImport.setCreatedAt(createdAt);
		return this;
	}
	
	public RepositoryImportBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public RepositoryImportBuilder updatedAt(Date updatedAt) {
		repositoryImport.setUpdatedAt(updatedAt);
		return this;
	}
	
	public RepositoryImportBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public RepositoryImport build() {
		return repositoryImport;
	}

}
