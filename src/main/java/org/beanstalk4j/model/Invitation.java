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
public class Invitation implements Serializable {
	
	private Integer id;
	private Integer accountId;
	private Integer userId;
	private Date createdAt;
	private Date updatedAt;
	private Integer creatorId;
	private String creatorName;
	private String creatorEmail;
	private String secureToken;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Integer getCreatorId() {
		return creatorId;
	}
	
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
	public String getCreatorEmail() {
		return creatorEmail;
	}
	
	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
	
	public String getSecureToken() {
		return secureToken;
	}
	
	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("accountId", getAccountId())
			.append("userId", getUserId())
			.append("creatorId", getCreatorId())
			.append("creatorName", getCreatorName())
			.append("creatorEmail", getCreatorEmail())
			.append("secureToken", getSecureToken())
			.append("updatedAt", getUpdatedAt())
			.append("createdAt", getCreatedAt())
			.toString();
	}

}
