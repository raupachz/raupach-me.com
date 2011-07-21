package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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
public class Account implements Serializable {
	
	private Integer id;
	private Integer ownerId;
	private Integer planId;
	private String name;
	private String thirdLevelDomain;
	private String timeZone;
	private Boolean suspended;
	private Date createdAt;
	private Date updatedAt;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	
	public Integer getPlanId() {
		return planId;
	}
	
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getThirdLevelDomain() {
		return thirdLevelDomain;
	}
	
	public void setThirdLevelDomain(String thirdLevelDomain) {
		this.thirdLevelDomain = thirdLevelDomain;
	}
	
	public String getTimeZone() {
		return timeZone;
	}
	
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	public Boolean isSuspended() {
		return suspended;
	}
	
	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("ownerId",getOwnerId())
			.append("planId",getPlanId())
			.append("name",getName())
			.append("thirdLevelDomain",getThirdLevelDomain())
			.append("timeZone",getTimeZone())
			.append("suspended",isSuspended())
			.append("createdAt",getCreatedAt())
			.append("updatedAt",getUpdatedAt())
			.toString();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(31, 41)
			.append(getId())
			.append(getOwnerId())
			.append(getPlanId())
			.append(getName())
			.append(getThirdLevelDomain())
			.append(getTimeZone())
			.append(isSuspended())
			.append(getCreatedAt())
			.append(getUpdatedAt())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account == false) {
		     return false;
		   }
		   if (this == obj) {
		     return true;
		   }
		   Account aAccount = (Account) obj;
		   return new EqualsBuilder()
		                 .append(getId(), aAccount.getId())
		                 .append(getOwnerId(), aAccount.getOwnerId())
		                 .append(getPlanId(), aAccount.getPlanId())
		                 .append(getName(), aAccount.getName())
		                 .append(getThirdLevelDomain(), aAccount.getThirdLevelDomain())
		                 .append(isSuspended(), aAccount.isSuspended())
		                 .append(getCreatedAt(), aAccount.getCreatedAt())
		                 .append(getUpdatedAt(), aAccount.getUpdatedAt())
		                 .isEquals();
	}
	
}
