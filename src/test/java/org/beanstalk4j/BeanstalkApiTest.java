/*
 * Copyright 2011 Björn Raupach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beanstalk4j;

import java.io.IOException;
import java.util.List;
import org.beanstalk4j.model.Account;
import org.beanstalk4j.model.Changeset;
import org.beanstalk4j.model.ColorLabel;
import org.beanstalk4j.model.Comment;
import org.beanstalk4j.model.FeedKey;
import org.beanstalk4j.model.Plan;
import org.beanstalk4j.model.PublicKey;
import org.beanstalk4j.model.Release;
import org.beanstalk4j.model.Repository;
import org.beanstalk4j.model.ServerEnvironment;
import org.beanstalk4j.model.User;
import org.beanstalk4j.model.builder.UserBuilder;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BeanstalkApiTest {

    public static final String accountName = "<your account>";
    public static final String username = "<your username>";
    public static final String accessToken = "<your accessToken>";

    private BeanstalkApi api;

    @Before
    public void setUp() throws IOException {
        api = new BeanstalkApi(accountName, username, accessToken, true, false);
    }

    @Test
    public void testGetAccount() {
        Account account = api.getAccount();
        assertNotNull(account);
    }

    @Test
    @Ignore
    public void testUpdateAccountTimeZone() {
        Account account = api.getAccount();
        String timeZone = "Berlin";
        account.setName("e2n");
        account.setTimeZone(timeZone);
        api.updateAccount(account);
        account = api.getAccount();
        //assertEquals(timeZone, account.getTimeZone());
    }

    @Test
    @Ignore
    public void testGetPlans() {
        List<Plan> plans = api.getPlans();
        for (Plan p : plans) {
            System.out.println(p);
        }
    }

    @Test
    @Ignore
    public void testGetUsers() {
        List<User> users = api.getUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    @Ignore
    public void testGetUsersWithPagination() {
        List<User> users = api.getUsers(3, 1);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    @Ignore
    public void testGetUser() {
        List<User> users = api.getUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    @Ignore
    public void testCreateDuplicateUser() {
        User user = new UserBuilder()
                .login("ilya")
                .email("foo@example.com")
                .firstName("Björn")
                .lastName("Raupach").build();
        user = api.createUser(user, "12345");
    }

    @Test
    @Ignore
    public void testCreateAndDeleteUser() {
        User user = new UserBuilder()
                .login("ilya")
                .email("raupach@me.com")
                .firstName("Björn")
                .lastName("Raupach").build();
        user = api.createUser(user, "12345");
        api.deleteUser(user);
    }

    @Test
    @Ignore
    public void testUpdateUser() {
        User user = api.getCurrentUser();
        user.setEmail("raupach@e2n.de");
        api.updateUser(user);
    }

    @Test
    @Ignore
    public void testGetPublicKeys() {
        for (PublicKey p : api.getPublicKeys()) {
            System.out.println(p);
        }
    }

    @Test
    @Ignore
    public void testGetPublicKey() {
        PublicKey publicKey = api.getPublicKey(35210);
        publicKey.setName("Björn's Public Key");
        api.updatePublicKey(publicKey);
    }

    @Test
    @Ignore
    public void testGetRepository() {
        Integer repositoryId = 244086;
        api.getRepository(repositoryId);
    }

    @Test
    @Ignore
    public void testGetRepositories() {
        for (Repository r : api.getRepositories()) {
            System.out.println(r);
            Repository tmp = api.getRepository(r.getId());
            tmp = api.getRepository(r.getName());
        }
    }

    @Test
    @Ignore
    public void testGetRepositoriesWithPagination() {
        for (Repository r : api.getRepositories(null, null)) {
            System.out.println(r);
        }
    }

    @Test
    @Ignore
    public void testGetChangesets() {
        for (Changeset c : api.getChangesets()) {
            System.out.println(c);
        }
    }

    @Test
    @Ignore
    public void testGetComments() {
        Integer repositoryId = 180178;
        for (Comment c : api.getComments(repositoryId, null, null)) {
            System.out.println(c);
        }
    }

    @Test
    @Ignore
    public void testCreateRepository() {
        api.createRepository("myrepo", "My Repository", ColorLabel.BLUE);
    }

    @Test
    @Ignore
    public void testUpdateRepository() {
        for (Repository r : api.getRepositories()) {
            r.setColorLabel(ColorLabel.GREEN);
            api.updateRepository(r);
        }
    }

    @Test
    @Ignore
    public void testGetAllServerEnvironments() {
        for (Repository r : api.getRepositories()) {
            List<ServerEnvironment> env = api.getServerEnvironments(r.getId());
            for (ServerEnvironment e : env) {
                System.out.println(e);
            }
        }
    }

    @Test
    @Ignore
    public void testGetReleases() {
        for (Release r : api.getReleases()) {
            System.out.println(r);
        }
    }

    @Test
    @Ignore
    public void testGetFeedKey() {
        FeedKey key = api.getFeedKey();
    }

}
