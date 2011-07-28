package org.beanstalk4j.model.builder;

import java.util.Date;

import org.beanstalk4j.model.Comment;
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
public class CommentBuilder {
	
	private final Comment comment;

	public CommentBuilder() {
		this.comment = new Comment();
	}
	
	public CommentBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		accountId(element.getChildText("account-id"));
		authorId(element.getChildText("author-id"));
		authorName(element.getChildText("author-name"));
		authorLogin(element.getChildText("author-login"));
		authorEmail(element.getChildText("author-email"));
		body(element.getChildText("body"));
		createdAt(element.getChildText("created-at"));
		filePath(element.getChildText("file-path"));
		lineNumber(element.getChildText("line-number"));
		renderedBody(element.getChildText("rendered-body"));
		repositoryId(element.getChildText("repository-id"));
		revision(element.getChildText("revision"));
		updatedAt(element.getChildText("updated-at"));
	}
	
	public CommentBuilder id(Integer id) {
		comment.setId(id);
		return this;
	}
	
	public CommentBuilder id(String id) {
		return id(Integer.valueOf(id));
	}
	
	public CommentBuilder accountId(Integer accountId) {
		comment.setAccountId(accountId);
		return this;
	}
	
	public CommentBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public CommentBuilder authorId(Integer authorId) {
		comment.setAuthorId(authorId);
		return this;
	}
	
	public CommentBuilder authorId(String authorId) {
		return authorId(Integer.valueOf(authorId));
	}
	
	public CommentBuilder authorName(String authorName) {
		comment.setAuthorName(authorName);
		return this;
	}
	
	public CommentBuilder authorLogin(String authorLogin) {
		comment.setAuthorLogin(authorLogin);
		return this;
	}
	
	public CommentBuilder authorEmail(String authorEmail) {
		comment.setAuthorEmail(authorEmail);
		return this;
	}
	
	public CommentBuilder body(String body) {
		comment.setBody(body);
		return this;
	}
	
	public CommentBuilder createdAt(Date createdAt) {
		comment.setCreatedAt(createdAt);
		return this;
	}
	
	public CommentBuilder createdAt(String createdAt) {
		return createdAt(IsoDateTimeFormat.parse(createdAt));
	}
	
	public CommentBuilder filePath(String filePath) {
		comment.setFilePath(filePath);
		return this;
	}
	
	public CommentBuilder lineNumber(Integer lineNumber) {
		comment.setLineNumber(lineNumber);
		return this;
	}
	
	public CommentBuilder lineNumber(String lineNumber) {
		return lineNumber(Integer.valueOf(lineNumber));
	}
	
	public CommentBuilder renderedBody(String renderedBody) {
		comment.setRenderedBody(renderedBody);
		return this;
	}
	
	public CommentBuilder repositoryId(Integer repositoryId) {
		comment.setRepositoryId(repositoryId);
		return this;
	}
	
	public CommentBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public CommentBuilder revision(Integer revision) {
		comment.setRevision(revision);
		return this;
	}
	
	public CommentBuilder revision(String revision) {
		return revision(Integer.valueOf(revision));
	}
	
	public CommentBuilder updatedAt(Date updatedAt) {
		comment.setUpdatedAt(updatedAt);
		return this;
	}
	
	public CommentBuilder updatedAt(String updatedAt) {
		return updatedAt(IsoDateTimeFormat.parse(updatedAt));
	}
	
	public Comment build() {
		return comment;
	}
	
}
