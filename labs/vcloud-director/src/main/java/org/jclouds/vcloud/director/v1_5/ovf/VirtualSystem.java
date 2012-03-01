/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.vcloud.director.v1_5.ovf;

import static org.jclouds.vcloud.director.v1_5.VCloudDirectorConstants.VCLOUD_OVF_NS;

import javax.xml.bind.annotation.XmlRootElement;

import org.jclouds.vcloud.director.v1_5.ovf.internal.BaseVirtualSystem;

import com.google.common.collect.Multimap;

/**
 * @author Adrian Cole
 * @author Adam Lowe
 */
@XmlRootElement(name = "VirtualSystem", namespace = VCLOUD_OVF_NS)
public class VirtualSystem extends BaseVirtualSystem<VirtualSystem> {

   public static Builder builder() {
      return new Builder();
   }

   @Override
   public Builder toBuilder() {
      return new Builder().fromVirtualSystem(this);
   }

   public static class Builder extends BaseVirtualSystem.Builder<VirtualSystem> {

      /**
       * {@inheritDoc}
       */
      @Override
      public VirtualSystem build() {
         return new VirtualSystem(id, info, name, operatingSystem, virtualHardwareSections, productSections,
               additionalSections);
      }

      /**
       * {@inheritDoc}
       */
      @SuppressWarnings("unchecked")
      @Override
      public Builder additionalSection(String name, SectionType additionalSection) {
         return Builder.class.cast(super.additionalSection(name, additionalSection));
      }

      /**
       * {@inheritDoc}
       */
      @SuppressWarnings("unchecked")
      @Override
      public Builder additionalSections(Multimap<String, SectionType> additionalSections) {
         return Builder.class.cast(super.additionalSections(additionalSections));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder fromSection(SectionType<VirtualSystem> in) {
         return Builder.class.cast(super.fromSection(in));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder fromVirtualSystem(BaseVirtualSystem<VirtualSystem> in) {
         return Builder.class.cast(super.fromVirtualSystem(in));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder virtualHardwareSection(VirtualHardwareSection virtualHardwareSection) {
         return Builder.class.cast(super.virtualHardwareSection(virtualHardwareSection));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder virtualHardwareSections(Iterable<? extends VirtualHardwareSection> virtualHardwareSections) {
         return Builder.class.cast(super.virtualHardwareSections(virtualHardwareSections));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder id(String id) {
         return Builder.class.cast(super.id(id));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder info(String info) {
         return Builder.class.cast(super.info(info));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder name(String name) {
         return Builder.class.cast(super.name(name));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder operatingSystemSection(OperatingSystemSection operatingSystem) {
         return Builder.class.cast(super.operatingSystemSection(operatingSystem));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder productSection(ProductSection productSection) {
         return Builder.class.cast(super.productSection(productSection));
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public Builder productSections(Iterable<? extends ProductSection> productSections) {
         return Builder.class.cast(super.productSections(productSections));
      }

   }

   @SuppressWarnings("unchecked")
   private VirtualSystem(String id, String info, String name, OperatingSystemSection operatingSystem,
                        Iterable<? extends VirtualHardwareSection> virtualHardwareSections,
                        Iterable<? extends ProductSection> productSections, Multimap<String, SectionType> additionalSections) {
      super(id, info, name, operatingSystem, virtualHardwareSections, productSections, additionalSections);
   }
   
   private VirtualSystem() {
      // for JAXB
   }
}