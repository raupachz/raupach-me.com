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
import org.beanstalk4j.model.Invitation;
import org.beanstalk4j.utils.IsoDateTimeFormat;

public class InvitationBuilder {

    private final Invitation invitation;

    public InvitationBuilder() {
        this.invitation = new Invitation();
    }

    public InvitationBuilder id(Integer id) {
        invitation.setId(id);
        return this;
    }

    public InvitationBuilder id(String id) {
        return id(Integer.valueOf(id));
    }

    public InvitationBuilder accountId(Integer accountId) {
        invitation.setAccountId(accountId);
        return this;
    }

    public InvitationBuilder accountId(String accountId) {
        return accountId(Integer.valueOf(accountId));
    }

    public InvitationBuilder userId(Integer userId) {
        invitation.setUserId(userId);
        return this;
    }

    public InvitationBuilder userId(String userId) {
        return userId(Integer.valueOf(userId));
    }

    public InvitationBuilder creatorEmail(String creatorEmail) {
        invitation.setCreatorEmail(creatorEmail);
        return this;
    }

    public InvitationBuilder creatorId(Integer creatorId) {
        invitation.setCreatorId(creatorId);
        return this;
    }

    public InvitationBuilder creatorId(String creatorId) {
        return creatorId(Integer.valueOf(creatorId));
    }

    public InvitationBuilder creatorName(String creatorName) {
        invitation.setCreatorName(creatorName);
        return this;
    }

    public InvitationBuilder secureToken(String secureToken) {
        invitation.setSecureToken(secureToken);
        return this;
    }

    public InvitationBuilder createdAt(Date createdAt) {
        invitation.setCreatedAt(createdAt);
        return this;
    }

    public InvitationBuilder createdAt(String createdAt) {
        return createdAt(IsoDateTimeFormat.parse(createdAt));
    }

    public InvitationBuilder updatedAt(Date updatedAt) {
        invitation.setUpdatedAt(updatedAt);
        return this;
    }

    public InvitationBuilder updatedAt(String updatedAt) {
        return updatedAt(IsoDateTimeFormat.parse(updatedAt));
    }

    public Invitation build() {
        return invitation;
    }

}
