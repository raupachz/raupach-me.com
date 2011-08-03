package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

import org.beanstalk4j.utils.ToStringBuilder;

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
public class User implements Serializable {

	private Integer id;
	private Integer accountId;
	private Boolean admin;
	private Boolean owner;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String timeZone;
	private Date createdAt;
	private Date updatedAt;
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public Boolean isOwner() {
		return owner;
	}
	
	public void setOwner(Boolean owner) {
		this.owner = owner;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getTimeZone() {
		return timeZone;
	}
	
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("accountId",getAccountId())
			.append("admin", isAdmin())
			.append("owner", isOwner())
			.append("firstName", getFirstName())
			.append("lastName", getLastName())
			.append("email", getEmail())
			.append("login", getLogin())
			.append("timeZone", getTimeZone())
			.append("createdAt", getCreatedAt())
			.append("updatedAt", getUpdatedAt())
			.toString();
	}
	
}
