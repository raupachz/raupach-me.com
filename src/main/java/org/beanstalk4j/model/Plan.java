package org.beanstalk4j.model;

import java.io.Serializable;

import org.beanstalk4j.ToStringBuilder;

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
public class Plan implements Serializable {
	
	private Integer id;
	private String name;
	private Integer price;
	private Integer repositories;
	private Integer storage;
	private Integer users;
	private Integer servers;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getRepositories() {
		return repositories;
	}
	
	public void setRepositories(Integer repositories) {
		this.repositories = repositories;
	}
	
	public Integer getStorage() {
		return storage;
	}
	
	public void setStorage(Integer storage) {
		this.storage = storage;
	}
	
	public Integer getUsers() {
		return users;
	}
	
	public void setUsers(Integer users) {
		this.users = users;
	}
	
	public Integer getServers() {
		return servers;
	}
	
	public void setServers(Integer servers) {
		this.servers = servers;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", getId())
			.append("name", getName())
			.append("price", getPrice())
			.append("repositories", getRepositories())
			.append("storage", getStorage())
			.append("users", getUsers())
			.append("servers", getServers())
			.toString();
	}
	
}
