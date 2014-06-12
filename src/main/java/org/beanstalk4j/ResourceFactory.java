/*
 * Copyright 2014 raupach.
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

package org.beanstalk4j;

import java.io.InputStream;
import java.util.List;
import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Changeset;
import org.beanstalk4j.model.Comment;
import org.beanstalk4j.model.FeedKey;
import org.beanstalk4j.model.Invitation;
import org.beanstalk4j.model.Permission;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.PublicKey;
import org.beanstalk4j.model.Release;
import org.beanstalk4j.model.ReleaseServer;
import org.beanstalk4j.model.Repository;
import org.beanstalk4j.model.RepositoryImport;
import org.beanstalk4j.model.ServerEnvironment;
import org.beanstalk4j.model.User;

/**
 *
 * @author raupach
 */
public interface ResourceFactory {

    Account buildAccount(InputStream httpStream);

    Changeset buildChangeset(InputStream httpStream);

    List<Changeset> buildChangesets(InputStream httpStream);

    Comment buildComment(InputStream httpStream);

    List<Comment> buildComments(InputStream httpStream);

    FeedKey buildFeedKey(InputStream httpStream);

    Invitation buildInvitation(InputStream httpStream);

    Permission buildPermission(InputStream httpStream);

    List<Permission> buildPermissions(InputStream httpStream);

    List<Plan> buildPlans(InputStream httpStream);

    PublicKey buildPublicKey(InputStream httpStream);

    List<PublicKey> buildPublicKeys(InputStream httpStream);

    Release buildRelease(InputStream httpStream);

    ReleaseServer buildReleaseServer(InputStream httpStream);

    List<ReleaseServer> buildReleaseServers(InputStream httpStream);

    List<Release> buildReleases(InputStream httpStream);

    List<Repository> buildRepositories(InputStream httpStream);

    Repository buildRepository(InputStream httpStream);

    RepositoryImport buildRepositoryImport(InputStream httpStream);

    ServerEnvironment buildServerEnvironment(InputStream httpStream);

    List<ServerEnvironment> buildServerEnvironments(InputStream httpStream);

    User buildUser(InputStream httpStream);

    List<User> buildUsers(InputStream httpStream);
    
}
