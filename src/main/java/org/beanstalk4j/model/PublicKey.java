package org.beanstalk4j.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PublicKey implements Serializable {
	
	private Integer id;
	private Integer accountId;
	private Integer userId;
	private String name;
	private String content;
	private Date createdAt;
	private Date updatedAt;
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
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
			.append("id", getId())
			.append("accountId", getAccountId())
			.append("userId", getUserId())
			.append("name", getName())
			.append("content", getContent())
			.append("createdAt", getCreatedAt())
			.append("updatedAt", getUpdatedAt())
			.toString();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(19, 29)
			.append(getId())
			.append(getAccountId())
			.append(getUserId())
			.append(getName())
			.append(getContent())
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
		PublicKey aPublicKey = (PublicKey) obj;
		return new EqualsBuilder()
			.append(getId(), aPublicKey.getId())
			.append(getAccountId(), aPublicKey.getAccountId())
			.append(getName(), aPublicKey.getName())
			.append(getContent(), aPublicKey.getContent())
			.append(getCreatedAt(), aPublicKey.getCreatedAt())
			.append(getUpdatedAt(), aPublicKey.getUpdatedAt())
			.isEquals();
	}

}
