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
package org.jclouds.domain;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public class Credentials {
   public static class Builder<T extends Credentials> {
      protected String identity;
      protected String credential;
      protected String authToken;
      protected Function<Object, Void> accessReceiver;
      protected Object access;

      public Builder<T> identity(String identity) {
         this.identity = identity;
         return this;
      }

      public Builder<T> credential(String credential) {
         this.credential = credential;
         return this;
      }

      public Builder<T> authToken(String authToken) {
         this.authToken = authToken;
         return this;
      }

      public Builder<T> accessReceiver(Function<Object, Void> accessReceiver) {
         this.accessReceiver = accessReceiver;
         return this;
      }

      public Builder<T> access(Object access){
         this.access = access;
         return this;
      }

      @SuppressWarnings("unchecked")
      public T build() {
         Credentials credentials = new Credentials(identity, credential);
         credentials.setAccessReceiver(accessReceiver);
         credentials.setAuthToken(authToken);
         credentials.setAccess(access);
         return (T) credentials;
      }
   }

   public final String identity;
   public final String credential;
   private String authToken;
   private Function<Object, Void> accessReceiver;
   private Object access;

   public String getAuthToken() {
      return authToken;
   }

   public void setAuthToken(String authToken) {
      this.authToken = authToken;
   }

   public Function<Object, Void> getAccessReceiver() {
      return accessReceiver;
   }

   public void setAccessReceiver(Function<Object, Void> accessReceiver) {
      this.accessReceiver = accessReceiver;
   }

   public Object getAccess() {
      return access;
   }

   public void setAccess(Object access) {
      this.access = access;
   }

   public Credentials(String identity, String credential) {
      this.identity = identity;
      this.credential = credential;
   }

   public Builder<? extends Credentials> toBuilder() {
      return new Builder<Credentials>().identity(identity).credential(credential).authToken(authToken).accessReceiver(accessReceiver).access(access);
   }

   @Override
   public String toString() {
      return "[identity=" + identity + ", credential=" + credential + ", authToken=" + authToken + ", access=" + access + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(identity, credential, authToken, accessReceiver, access);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof Credentials))
         return false;
      Credentials other = (Credentials) obj;
      if (!Objects.equal(identity, other.identity))
         return false;
      if (!Objects.equal(credential, other.credential))
         return false;
      if (!Objects.equal(authToken, other.authToken))
         return false;
      if (!Objects.equal(accessReceiver, other.accessReceiver))
         return false;
      if (!Objects.equal(access, other.access))
         return false;
      return true;
   }
}
