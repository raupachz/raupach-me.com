package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;
import org.beanstalk4j.utils.ToStringBuilder;

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
	
}
