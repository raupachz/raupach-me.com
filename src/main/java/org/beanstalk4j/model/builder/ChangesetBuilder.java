package org.beanstalk4j.model.builder;

import java.util.Date;
import org.beanstalk4j.model.Changeset;
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
public class ChangesetBuilder {
	
	private final Changeset changeset;
	
	public ChangesetBuilder() {
		this.changeset = new Changeset();
	}
	
	public ChangesetBuilder(Element element) {
		this();
		accountId(DOMUtils.getChildText(element,"account-id"));
		repositoryId(DOMUtils.getChildText(element,"repository-id"));
		revision(DOMUtils.getChildText(element,"revision"));
		message(DOMUtils.getChildText(element,"message"));
		author(DOMUtils.getChildText(element,"author"));
		email(DOMUtils.getChildText(element,"email"));
		changedDirs(DOMUtils.getChildText(element,"changed-dirs"));
		changedFiles(DOMUtils.getChildText(element,"changed-files"));
		changedProperties(DOMUtils.getChildText(element,"changed-properties"));
		tooLarge(DOMUtils.getChildText(element,"too-large"));
		time(DOMUtils.getChildText(element,"time"));
	}
	
	public ChangesetBuilder accountId(Integer accountId) {
		changeset.setAccountId(accountId);
		return this;
	}
	
	public ChangesetBuilder accountId(String accountId) {
		return accountId(Integer.valueOf(accountId));
	}
	
	public ChangesetBuilder repositoryId(Integer repositoryId) {
		changeset.setRepositoryId(repositoryId);
		return this;
	}
	
	public ChangesetBuilder repositoryId(String repositoryId) {
		return repositoryId(Integer.valueOf(repositoryId));
	}
	
	public ChangesetBuilder revision(String revision) {
		changeset.setRevision(revision);
		return this;
	}
	
	public ChangesetBuilder message(String message) {
		changeset.setMessage(message);
		return this;
	}
	
	public ChangesetBuilder author(String author) {
		changeset.setAuthor(author);
		return this;
	}
	
	public ChangesetBuilder email(String email) {
		changeset.setEmail(email);
		return this;
	}
	
	public ChangesetBuilder changedDirs(String changedDirs) {
		changeset.setChangedDirs(changedDirs);
		return this;
	}
	
	public ChangesetBuilder changedFiles(String changedFiles) {
		changeset.setChangedFiles(changedFiles);
		return this;
	}
	
	public ChangesetBuilder changedProperties(String changedProperties) {
		changeset.setChangedProperties(changedProperties);
		return this;
	}
	
	public ChangesetBuilder tooLarge(Boolean tooLarge) {
		changeset.setTooLarge(tooLarge);
		return this;
	}
	
	public ChangesetBuilder tooLarge(String tooLarge) {
		return tooLarge(Boolean.valueOf(tooLarge));
	}
	
	public ChangesetBuilder time(Date time) {
		changeset.setTime(time);
		return this;
	}
	
	public ChangesetBuilder time(String time) {
		return time(IsoDateTimeFormat.parse(time));
	}
	
	public Changeset build() {
		return changeset;
	}

}
