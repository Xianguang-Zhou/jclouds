/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.openstack.keystone.v2_0.domain;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import org.jclouds.openstack.keystone.v2_0.config.CredentialType;

import java.beans.ConstructorProperties;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Token Id
 *
 * @see <a href="http://docs.openstack.org/api/openstack-identity-service/2.0/content/POST_authenticate_v2.0_ids_Service_API_Api_Operations.html#d662e583"/>
 */
@CredentialType("token")
public class TokenId {

    public static Builder<?> builder() {
        return new ConcreteBuilder();
    }

    public Builder<?> toBuilder() {
        return new ConcreteBuilder().fromTokenId(this);
    }

    public static TokenId createWithId(String id) {
        return new TokenId(id);
    }

    public abstract static class Builder<T extends Builder<T>> {
        protected abstract T self();

        protected String id;

        /**
         * @see TokenId#getId()
         */
        public T id(String id) {
            this.id = id;
            return self();
        }

        public TokenId build() {
            return new TokenId(id);
        }

        public T fromTokenId(TokenId in) {
            return this
                    .id(in.getId());
        }
    }

    private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
        @Override
        protected ConcreteBuilder self() {
            return this;
        }
    }

    private final String id;

    @ConstructorProperties({
            "id"
    })
    protected TokenId(String id) {
        this.id = checkNotNull(id, "id");
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TokenId that = TokenId.class.cast(obj);
        return Objects.equal(this.id, that.id);
    }

    protected ToStringHelper string() {
        return Objects.toStringHelper(this)
                .add("id", id);
    }

    @Override
    public String toString() {
        return string().toString();
    }

}
