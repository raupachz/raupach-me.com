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

package org.beanstalk4j.json;

import java.io.InputStream;
import java.util.List;
import org.beanstalk4j.ResourceFactory;
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
public class JSONResourceFactory implements ResourceFactory {

    @Override
    public Account buildAccount(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Changeset buildChangeset(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Changeset> buildChangesets(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment buildComment(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> buildComments(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FeedKey buildFeedKey(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Invitation buildInvitation(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permission buildPermission(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Permission> buildPermissions(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Plan> buildPlans(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PublicKey buildPublicKey(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PublicKey> buildPublicKeys(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Release buildRelease(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReleaseServer buildReleaseServer(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReleaseServer> buildReleaseServers(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Release> buildReleases(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Repository> buildRepositories(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Repository buildRepository(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RepositoryImport buildRepositoryImport(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServerEnvironment buildServerEnvironment(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ServerEnvironment> buildServerEnvironments(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User buildUser(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> buildUsers(InputStream httpStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
