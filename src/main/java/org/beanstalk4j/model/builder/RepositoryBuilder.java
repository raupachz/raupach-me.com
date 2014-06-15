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

import java.util.Date;
import org.beanstalk4j.model.ColorLabel;
import org.beanstalk4j.model.Repository;
import org.beanstalk4j.utils.IsoDateTimeFormat;

public class RepositoryBuilder {

    private final Repository repository;

    public RepositoryBuilder() {
        this.repository = new Repository();
    }

    public RepositoryBuilder id(Integer id) {
        repository.setId(id);
        return this;
    }

    public RepositoryBuilder id(String id) {
        return id(Integer.valueOf(id));
    }

    public RepositoryBuilder accountId(Integer accountId) {
        repository.setAccountId(accountId);
        return this;
    }

    public RepositoryBuilder accountId(String accountId) {
        return accountId(Integer.valueOf(accountId));
    }

    public RepositoryBuilder anonymous(Boolean anonymous) {
        repository.setAnonymous(anonymous);
        return this;
    }

    public RepositoryBuilder anonymous(String anonymous) {
        return anonymous(Boolean.valueOf(anonymous));
    }

    public RepositoryBuilder type(String type) {
        repository.setType(type);
        return this;
    }

    public RepositoryBuilder name(String name) {
        repository.setName(name);
        return this;
    }

    public RepositoryBuilder title(String title) {
        repository.setTitle(title);
        return this;
    }

    public RepositoryBuilder revision(Integer revision) {
        repository.setRevision(revision);
        return this;
    }

    public RepositoryBuilder revision(String revision) {
        if (revision == null) {
            return null;
        } else {
            return revision(Integer.valueOf(revision));
        }
    }

    public RepositoryBuilder storageUsedBytes(Integer storageBytesUsed) {
        repository.setStorageUsedBytes(storageBytesUsed);
        return this;
    }

    public RepositoryBuilder storageUsedBytes(String storageUsedBytes) {
        return storageUsedBytes(Integer.valueOf(storageUsedBytes));
    }

    public RepositoryBuilder colorLabel(String colorLabel) {
        repository.setColorLabel(ColorLabel.parse(colorLabel));
        return this;
    }

    public RepositoryBuilder lastCommitAt(Date lastCommitAt) {
        repository.setLastCommitAt(lastCommitAt);
        return this;
    }

    public RepositoryBuilder lastCommitAt(String lastCommitAt) {
        return lastCommitAt(IsoDateTimeFormat.parse(lastCommitAt));
    }

    public RepositoryBuilder updatedAt(Date updatedAt) {
        repository.setUpdatedAt(updatedAt);
        return this;
    }

    public RepositoryBuilder updatedAt(String updatedAt) {
        return updatedAt(IsoDateTimeFormat.parse(updatedAt));
    }

    public RepositoryBuilder createdAt(Date createdAt) {
        repository.setCreatedAt(createdAt);
        return this;
    }

    public RepositoryBuilder createdAt(String createdAt) {
        return createdAt(IsoDateTimeFormat.parse(createdAt));
    }

    public Repository build() {
        return repository;
    }

}
