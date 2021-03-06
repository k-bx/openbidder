/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openbidder.ui.resource;

import com.google.common.collect.Multimap;
import com.google.openbidder.ui.resource.support.ExternalResource;
import com.google.openbidder.ui.resource.support.ResourceMethod;

import java.util.List;

/**
 * Service for performing REST operations on root-level {@link ExternalResource}s.
 */
public interface RootResourceService<T extends ExternalResource> {

  /**
   * @return {@code true} if this service supports the {@code resourceMethod},
   * otherwise {@code false}.
   */
  boolean supports(ResourceMethod resourceMethod);

  /**
   * @return A resource identified by unique name.
   */
  T get(String resourceName, Multimap<String, String> params);

  /**
   * @return {@link java.util.Collection} of all resources belonging to this
   * {@link com.google.openbidder.ui.resource.support.ResourceCollectionId}
   */
  List<? extends T> list(Multimap<String, String> params);

  /**
   * @return A newly created resource based on the {@code newResource} passed in. Note: the
   * service is free to modify the resource as desired.
   */
  T create(T newResource);

  /**
   * @return The updated resource based on the requested update.
   */
  T update(String resourceName, T updatedResource);

  /**
   * Delete a specific resource identified by unique name.
   */
  void delete(String resourceName);
}
