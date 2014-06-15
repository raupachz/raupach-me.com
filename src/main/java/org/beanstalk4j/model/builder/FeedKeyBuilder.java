/*
 * Copyright 2012 Björn Raupach
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

import java.util.Date;
import org.beanstalk4j.model.FeedKey;
import org.beanstalk4j.utils.IsoDateTimeFormat;

public class FeedKeyBuilder {

    private final FeedKey feedKey;

    public FeedKeyBuilder() {
        this.feedKey = new FeedKey();
    }

    public FeedKeyBuilder id(Integer id) {
        feedKey.setId(id);
        return this;
    }

    public FeedKeyBuilder id(String id) {
        return id(Integer.valueOf(id));
    }

    public FeedKeyBuilder accountId(Integer accountId) {
        feedKey.setAccountId(accountId);
        return this;
    }

    public FeedKeyBuilder accountId(String accountId) {
        return accountId(Integer.valueOf(accountId));
    }

    public FeedKeyBuilder userId(Integer userId) {
        feedKey.setUserId(userId);
        return this;
    }

    public FeedKeyBuilder userId(String userId) {
        return userId(Integer.valueOf(userId));
    }

    public FeedKeyBuilder key(String key) {
        feedKey.setKey(key);
        return this;
    }

    public FeedKeyBuilder updatedAt(Date updatedAt) {
        feedKey.setUpdatedAt(updatedAt);
        return this;
    }

    public FeedKeyBuilder updatedAt(String updatedAt) {
        return updatedAt(IsoDateTimeFormat.parse(updatedAt));
    }

    public FeedKeyBuilder createdAt(Date createdAt) {
        feedKey.setCreatedAt(createdAt);
        return this;
    }

    public FeedKeyBuilder createdAt(String createdAt) {
        return createdAt(IsoDateTimeFormat.parse(createdAt));
    }

    public FeedKey build() {
        return feedKey;
    }

}
