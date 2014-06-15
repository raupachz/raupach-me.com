/*
 * Copyright 2011 Björn Raupach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beanstalk4j.model.builder;

import org.beanstalk4j.model.Plan;

public class PlanBuilder {

    private final Plan plan;

    public PlanBuilder() {
        plan = new Plan();
    }

    public PlanBuilder id(Integer id) {
        plan.setId(id);
        return this;
    }

    public PlanBuilder id(String id) {
        return id(Integer.valueOf(id));
    }

    public PlanBuilder name(String name) {
        plan.setName(name);
        return this;
    }

    public PlanBuilder price(Integer price) {
        plan.setPrice(price);
        return this;
    }

    public PlanBuilder price(String price) {
        return price(Integer.valueOf(price));
    }

    public PlanBuilder repositories(Integer repositories) {
        plan.setRepositories(repositories);
        return this;
    }

    public PlanBuilder repositories(String repositories) {
        return repositories(Integer.valueOf(repositories));
    }

    public PlanBuilder storage(Integer storage) {
        plan.setStorage(storage);
        return this;
    }

    public PlanBuilder storage(String storage) {
        return storage(Integer.valueOf(storage));
    }

    public PlanBuilder users(Integer users) {
        plan.setUsers(users);
        return this;
    }

    public PlanBuilder users(String users) {
        return users(Integer.valueOf(users));
    }

    public PlanBuilder servers(Integer servers) {
        plan.setServers(servers);
        return this;
    }

    public PlanBuilder servers(String servers) {
        return servers(Integer.valueOf(servers));
    }

    public Plan build() {
        return plan;
    }

}
